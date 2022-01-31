package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppJsPluginScope
{
  public static final Map EVENT_HANDLERS_ColorNotePlugin;
  public static final Map EVENT_HANDLERS_NavigationJsPlugin;
  public static final Map PLUGIN_EVENTS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  
  static
  {
    PLUGIN_EVENTS = new HashMap();
    EVENT_HANDLERS_NavigationJsPlugin = new HashMap();
    EVENT_HANDLERS_ColorNotePlugin = new HashMap();
    EVENT_HANDLERS_NavigationJsPlugin.put("navigateToMiniProgram", "navigateToMiniProgram");
    EVENT_HANDLERS_NavigationJsPlugin.put("exitMiniProgram", "exitMiniProgram");
    EVENT_HANDLERS_NavigationJsPlugin.put("navigateBackMiniProgram", "navigateBackMiniProgram");
    PLUGIN_EVENTS.put("com.tencent.qqmini.proxyimpl.NavigationJsPlugin", EVENT_HANDLERS_NavigationJsPlugin);
    EVENT_HANDLERS_ColorNotePlugin.put("addColorSign", "addColorSign");
    EVENT_HANDLERS_ColorNotePlugin.put("addColorSignDirectly", "addColorSignDirectly");
    PLUGIN_EVENTS.put("com.tencent.qqmini.proxyimpl.ColorNotePlugin", EVENT_HANDLERS_ColorNotePlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.AppJsPluginScope
 * JD-Core Version:    0.7.0.1
 */