package io.flutter.plugins;

import io.flutter.plugin.common.PluginRegistry;
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
    PathProviderPlugin.registerWith(paramPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */