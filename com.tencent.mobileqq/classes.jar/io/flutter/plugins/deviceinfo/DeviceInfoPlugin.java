package io.flutter.plugins.deviceinfo;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class DeviceInfoPlugin
  implements FlutterPlugin
{
  MethodChannel channel;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new DeviceInfoPlugin().setupMethodChannel(paramRegistrar.messenger(), paramRegistrar.context());
  }
  
  private void setupMethodChannel(BinaryMessenger paramBinaryMessenger, Context paramContext)
  {
    this.channel = new MethodChannel(paramBinaryMessenger, "plugins.flutter.io/device_info");
    paramBinaryMessenger = new MethodCallHandlerImpl(paramContext.getContentResolver(), paramContext.getPackageManager());
    this.channel.setMethodCallHandler(paramBinaryMessenger);
  }
  
  private void tearDownChannel()
  {
    this.channel.setMethodCallHandler(null);
    this.channel = null;
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    setupMethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), paramFlutterPluginBinding.getApplicationContext());
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    tearDownChannel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.deviceinfo.DeviceInfoPlugin
 * JD-Core Version:    0.7.0.1
 */