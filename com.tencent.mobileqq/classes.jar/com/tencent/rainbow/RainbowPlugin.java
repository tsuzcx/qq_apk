package com.tencent.rainbow;

import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class RainbowPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static Context sContext;
  private static boolean sIsPublishVersion = true;
  private MethodChannel channel;
  
  public static void setIsPublisVersion(boolean paramBoolean)
  {
    sIsPublishVersion = paramBoolean;
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "rainbow_channel");
    sContext = paramFlutterPluginBinding.getApplicationContext();
    this.channel.setMethodCallHandler(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.channel.setMethodCallHandler(null);
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("isPublishVersion"))
    {
      paramResult.success(Boolean.valueOf(sIsPublishVersion));
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.rainbow.RainbowPlugin
 * JD-Core Version:    0.7.0.1
 */