package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class SharedPreferencesPlugin
  implements FlutterPlugin
{
  private static final String CHANNEL_NAME = "plugins.flutter.io/shared_preferences";
  private MethodChannel channel;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new SharedPreferencesPlugin().setupChannel(paramRegistrar.messenger(), paramRegistrar.context());
  }
  
  private void setupChannel(BinaryMessenger paramBinaryMessenger, Context paramContext)
  {
    this.channel = new MethodChannel(paramBinaryMessenger, "plugins.flutter.io/shared_preferences");
    paramBinaryMessenger = new MethodCallHandlerImpl(paramContext);
    this.channel.setMethodCallHandler(paramBinaryMessenger);
  }
  
  private void teardownChannel()
  {
    this.channel.setMethodCallHandler(null);
    this.channel = null;
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    setupChannel(paramFlutterPluginBinding.getBinaryMessenger(), paramFlutterPluginBinding.getApplicationContext());
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    teardownChannel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin
 * JD-Core Version:    0.7.0.1
 */