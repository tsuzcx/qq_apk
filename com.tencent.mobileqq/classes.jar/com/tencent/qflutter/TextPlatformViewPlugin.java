package com.tencent.qflutter;

import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformViewRegistry;

public class TextPlatformViewPlugin
{
  public static void register(PluginRegistry.Registrar paramRegistrar)
  {
    paramRegistrar.platformViewRegistry().registerViewFactory("plugins.test/view", new TextPlatformViewFactory(StandardMessageCodec.INSTANCE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qflutter.TextPlatformViewPlugin
 * JD-Core Version:    0.7.0.1
 */