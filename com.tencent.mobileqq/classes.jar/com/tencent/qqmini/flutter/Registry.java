package com.tencent.qqmini.flutter;

import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoaderPlugin;
import com.qflutter.video.QflutterVideoViewSource;
import com.qflutter.video.QflutterVideoviewPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;

public final class Registry
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
    if (!alreadyRegisteredWith(paramPluginRegistry))
    {
      PackageInfoPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.packageinfo.PackageInfoPlugin"));
      PathProviderPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
      QflutterLogPlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
      WebViewFlutterPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.webviewflutter.WebViewFlutterPlugin"));
      QFlutterSkinEnginePlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.native_resources.QFlutterSkinEnginePlugin"));
      QFlutterResourceLoaderPlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.resource_loader.QFlutterResourceLoaderPlugin"));
      QflutterVideoviewPlugin.registerWith(paramPluginRegistry.registrarFor("com.qflutter.video.QflutterVideoviewPlugin"));
      QflutterVideoViewSource.setProvider(new VideoViewProvider());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.Registry
 * JD-Core Version:    0.7.0.1
 */