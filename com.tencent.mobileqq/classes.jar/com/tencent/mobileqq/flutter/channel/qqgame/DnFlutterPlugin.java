package com.tencent.mobileqq.flutter.channel.qqgame;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class DnFlutterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel a;
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.a = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "dn_flutter_plugin", JSONMethodCodec.INSTANCE);
    this.a.setMethodCallHandler(this);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall.toString());
      return;
    }
    if (paramMethodCall.method.equals("getBasicInfo"))
    {
      paramMethodCall = new HashMap();
      paramMethodCall.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramMethodCall.put("clientVersion", "8.8.17");
      paramMethodCall.put("phoneType", Build.MODEL);
      paramMethodCall.put("systemType", Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqgame.DnFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */