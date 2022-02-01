package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
public class TabBarJsPlugin
  extends BaseJsPlugin
{
  public static final String API_HIDE_TABBAR = "hideTabBar";
  public static final String API_HITD_RED_DOT = "hideTabBarRedDot";
  public static final String API_REMOVE_TABBAR_BADGE = "removeTabBarBadge";
  public static final String API_SET_TABBAR_BADGE = "setTabBarBadge";
  public static final String API_SET_TABBAR_ITEM = "setTabBarItem";
  public static final String API_SET_TABBAR_STYLE = "setTabBarStyle";
  public static final String API_SHOW_RED_DOT = "showTabBarRedDot";
  public static final String API_SHOW_TABBAR = "showTabBar";
  public static final String TAG = "TabBarJsPlugin";
  
  @JsEvent({"showTabBar", "hideTabBar", "setTabBarItem", "setTabBarStyle", "setTabBarBadge", "removeTabBarBadge", "showTabBarRedDot", "hideTabBarRedDot"})
  public void doInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TabBarJsPlugin
 * JD-Core Version:    0.7.0.1
 */