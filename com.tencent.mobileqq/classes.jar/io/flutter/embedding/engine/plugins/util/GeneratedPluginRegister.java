package io.flutter.embedding.engine.plugins.util;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Method;

public class GeneratedPluginRegister
{
  private static final String TAG = "GeneratedPluginsRegister";
  
  public static void registerGeneratedPlugins(@NonNull FlutterEngine paramFlutterEngine)
  {
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      return;
    }
    catch (Exception localException)
    {
      label33:
      StringBuilder localStringBuilder;
      break label33;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to automatically register plugins with FlutterEngine (");
    localStringBuilder.append(paramFlutterEngine);
    localStringBuilder.append(") but could not find and invoke the GeneratedPluginRegistrant.");
    Log.w("GeneratedPluginsRegister", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister
 * JD-Core Version:    0.7.0.1
 */