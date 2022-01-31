package com.tencent.qqmini.sdk.runtime.plugin;

import bglv;
import bgmk;
import bgok;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class NavigationBarPlugin
  extends BaseJsPlugin
{
  public static final String HIDE_NAVBAR_LOADING = "hideNavigationBarLoading";
  public static final String SET_NAV_BAR_BG_COLOR = "setNavigationBarColor";
  public static final String SET_NAV_BAR_TITLE = "setNavigationBarTitle";
  public static final String SHOW_NAVBAR_LOADING = "showNavigationBarLoading";
  
  public void doInterceptJsEvent(bgok parambgok)
  {
    this.mMiniAppContext.a(bgmk.a(parambgok, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.NavigationBarPlugin
 * JD-Core Version:    0.7.0.1
 */