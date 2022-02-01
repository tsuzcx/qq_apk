package io.flutter.plugins.packageinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.Map;

public class PackageInfoPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private Context applicationContext;
  private MethodChannel methodChannel;
  
  private static long getLongVersionCode(PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
  
  private void onAttachedToEngine(Context paramContext, BinaryMessenger paramBinaryMessenger)
  {
    this.applicationContext = paramContext;
    this.methodChannel = new MethodChannel(paramBinaryMessenger, "plugins.flutter.io/package_info");
    this.methodChannel.setMethodCallHandler(this);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new PackageInfoPlugin().onAttachedToEngine(paramRegistrar.context(), paramRegistrar.messenger());
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    onAttachedToEngine(paramFlutterPluginBinding.getApplicationContext(), paramFlutterPluginBinding.getBinaryMessenger());
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.applicationContext = null;
    this.methodChannel.setMethodCallHandler(null);
    this.methodChannel = null;
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    try
    {
      if (paramMethodCall.method.equals("getAll"))
      {
        paramMethodCall = this.applicationContext.getPackageManager();
        PackageInfo localPackageInfo = paramMethodCall.getPackageInfo(this.applicationContext.getPackageName(), 0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("appName", localPackageInfo.applicationInfo.loadLabel(paramMethodCall).toString());
        localHashMap.put("packageName", this.applicationContext.getPackageName());
        localHashMap.put("version", localPackageInfo.versionName);
        localHashMap.put("buildNumber", String.valueOf(getLongVersionCode(localPackageInfo)));
        paramResult.success(localHashMap);
        return;
      }
      paramResult.notImplemented();
      return;
    }
    catch (PackageManager.NameNotFoundException paramMethodCall)
    {
      paramResult.error("Name not found", paramMethodCall.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugins.packageinfo.PackageInfoPlugin
 * JD-Core Version:    0.7.0.1
 */