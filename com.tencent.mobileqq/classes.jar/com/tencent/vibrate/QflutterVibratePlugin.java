package com.tencent.vibrate;

import android.content.Context;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class QflutterVibratePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private static final String TAG = "QflutterVibratePlugin";
  private Context context;
  private Vibrator vibrator;
  
  public QflutterVibratePlugin() {}
  
  public QflutterVibratePlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.context = paramRegistrar.context();
    this.vibrator = ((Vibrator)this.context.getSystemService("vibrator"));
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter_vibrate").setMethodCallHandler(this);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new QflutterVibratePlugin(paramRegistrar);
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.context = paramFlutterPluginBinding.getApplicationContext();
    this.vibrator = ((Vibrator)this.context.getSystemService("vibrator"));
    new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.qflutter_vibrate").setMethodCallHandler(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    boolean bool;
    if ((this.vibrator != null) && (this.vibrator.hasVibrator()))
    {
      bool = true;
      if (!paramMethodCall.method.equals("canVibrate")) {
        break label47;
      }
      paramResult.success(Boolean.valueOf(bool));
    }
    label47:
    while (!bool)
    {
      return;
      bool = false;
      break;
    }
    if (paramMethodCall.method.equals("heavy"))
    {
      this.vibrator.vibrate(100L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("medium"))
    {
      this.vibrator.vibrate(40L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("light"))
    {
      this.vibrator.vibrate(10L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("success"))
    {
      this.vibrator.vibrate(50L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("error"))
    {
      this.vibrator.vibrate(500L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("warning"))
    {
      this.vibrator.vibrate(250L);
      paramResult.success(null);
      return;
    }
    if (paramMethodCall.method.equals("selection"))
    {
      this.vibrator.vibrate(3L);
      paramResult.success(null);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.vibrate.QflutterVibratePlugin
 * JD-Core Version:    0.7.0.1
 */