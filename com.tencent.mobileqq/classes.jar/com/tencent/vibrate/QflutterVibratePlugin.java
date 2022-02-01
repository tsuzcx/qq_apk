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
    Vibrator localVibrator = this.vibrator;
    boolean bool;
    if ((localVibrator != null) && (localVibrator.hasVibrator())) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramMethodCall.method.equals("canVibrate"))
    {
      paramResult.success(Boolean.valueOf(bool));
      return;
    }
    if (!bool) {
      return;
    }
    long l;
    if (paramMethodCall.method.equals("heavy"))
    {
      paramMethodCall = this.vibrator;
      l = 100L;
    }
    for (;;)
    {
      paramMethodCall.vibrate(l);
      paramResult.success(null);
      return;
      if (paramMethodCall.method.equals("medium"))
      {
        paramMethodCall = this.vibrator;
        l = 40L;
      }
      else if (paramMethodCall.method.equals("light"))
      {
        paramMethodCall = this.vibrator;
        l = 10L;
      }
      else if (paramMethodCall.method.equals("success"))
      {
        paramMethodCall = this.vibrator;
        l = 50L;
      }
      else if (paramMethodCall.method.equals("error"))
      {
        paramMethodCall = this.vibrator;
        l = 500L;
      }
      else if (paramMethodCall.method.equals("warning"))
      {
        paramMethodCall = this.vibrator;
        l = 250L;
      }
      else
      {
        if (!paramMethodCall.method.equals("selection")) {
          break;
        }
        paramMethodCall = this.vibrator;
        l = 3L;
      }
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vibrate.QflutterVibratePlugin
 * JD-Core Version:    0.7.0.1
 */