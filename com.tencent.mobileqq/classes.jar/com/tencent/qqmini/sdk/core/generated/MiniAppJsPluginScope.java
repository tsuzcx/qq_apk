package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MiniAppJsPluginScope
{
  public static final Map EVENT_HANDLERS_NavigationBarPlugin;
  public static final Map EVENT_HANDLERS_PickerJsPlugin;
  public static final Map EVENT_HANDLERS_PullDownRefreshJsPlugin;
  public static final Map EVENT_HANDLERS_TabBarJsPlugin;
  public static final Map PLUGIN_EVENTS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  
  static
  {
    PLUGIN_EVENTS = new HashMap();
    EVENT_HANDLERS_NavigationBarPlugin = new HashMap();
    EVENT_HANDLERS_PullDownRefreshJsPlugin = new HashMap();
    EVENT_HANDLERS_PickerJsPlugin = new HashMap();
    EVENT_HANDLERS_TabBarJsPlugin = new HashMap();
    EVENT_HANDLERS_NavigationBarPlugin.put("setNavigationBarTitle", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("showNavigationBarLoading", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("hideNavigationBarLoading", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("setNavigationBarColor", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.NavigationBarPlugin", EVENT_HANDLERS_NavigationBarPlugin);
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("startPullDownRefresh", "doInterceptJsEvent");
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("stopPullDownRefresh", "doInterceptJsEvent");
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("disableScrollBounce", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.PullDownRefreshJsPlugin", EVENT_HANDLERS_PullDownRefreshJsPlugin);
    EVENT_HANDLERS_PickerJsPlugin.put("showPickerView", "handleShowPickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("showMultiPickerView", "handleShowMultiPickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("showDatePickerView", "handleShowDatePickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("updateMultiPickerView", "handleUpdateMultiPickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("getRegionData", "handleGetRegionData");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin", EVENT_HANDLERS_PickerJsPlugin);
    EVENT_HANDLERS_TabBarJsPlugin.put("showTabBar", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("hideTabBar", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarItem", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarStyle", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarBadge", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("removeTabBarBadge", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("showTabBarRedDot", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("hideTabBarRedDot", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.TabBarJsPlugin", EVENT_HANDLERS_TabBarJsPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.MiniAppJsPluginScope
 * JD-Core Version:    0.7.0.1
 */