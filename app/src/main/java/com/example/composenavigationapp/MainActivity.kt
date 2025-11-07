package com.example.composenavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigationapp.ui.theme.ComposeNavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {

        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("settings") { SettingsScreen(navController) }

    }
}

@Composable
fun HomeScreen(navController: NavController) {
    ScreenTemplate(title = "Home Screen") {
        Button(onClick = { navController.navigate("profile") }) {
            Text("Go to Profile")
        }
    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    ScreenTemplate(title = "Profile Screen") {
        Button(onClick = { navController.navigate("settings") }) {
            Text("Go to Settings")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    ScreenTemplate(title = "Settings Screen") {
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
}

@Composable
fun ScreenTemplate(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        content()
    }
}
