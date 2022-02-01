package io.flutter.embedding.android;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;

public abstract interface FlutterEngineConfigurator
{
  public abstract void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine);
  
  public abstract void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterEngineConfigurator
 * JD-Core Version:    0.7.0.1
 */