package io.flutter.embedding.engine.plugins;

import androidx.annotation.NonNull;

public abstract interface FlutterPlugin
{
  public abstract void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding);
  
  public abstract void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.FlutterPlugin
 * JD-Core Version:    0.7.0.1
 */