package com.tencent.qqmini.sdk.runtime.plugin;

import bgho;
import bgid;
import bgkd;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

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
  
  public void doInterceptJsEvent(bgkd parambgkd)
  {
    this.mMiniAppContext.a(bgid.a(parambgkd, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.TabBarJsPlugin
 * JD-Core Version:    0.7.0.1
 */