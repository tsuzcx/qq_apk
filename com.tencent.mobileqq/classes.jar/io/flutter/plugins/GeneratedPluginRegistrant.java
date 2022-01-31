package io.flutter.plugins;

import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.qflutter_skin_engine.QFlutterSkinEnginePlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;

public final class GeneratedPluginRegistrant
{
  private static boolean alreadyRegisteredWith(PluginRegistry paramPluginRegistry)
  {
    String str = GeneratedPluginRegistrant.class.getCanonicalName();
    if (paramPluginRegistry.hasPlugin(str)) {
      return true;
    }
    paramPluginRegistry.registrarFor(str);
    return false;
  }
  
  public static void registerWith(PluginRegistry paramPluginRegistry)
  {
    if (alreadyRegisteredWith(paramPluginRegistry)) {
      return;
    }
    FlutterBoostPlugin.registerWith(paramPluginRegistry.registrarFor("com.idlefish.flutterboost.FlutterBoostPlugin"));
    PackageInfoPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.packageinfo.PackageInfoPlugin"));
    PathProviderPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
    QflutterLogPlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
    QFlutterSkinEnginePlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.qflutter_skin_engine.QFlutterSkinEnginePlugin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */