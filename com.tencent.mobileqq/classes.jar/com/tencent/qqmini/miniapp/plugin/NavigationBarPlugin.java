package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
public class NavigationBarPlugin
  extends BaseJsPlugin
{
  public static final String HIDE_NAVBAR_LOADING = "hideNavigationBarLoading";
  public static final String SET_NAV_BAR_BG_COLOR = "setNavigationBarColor";
  public static final String SET_NAV_BAR_TITLE = "setNavigationBarTitle";
  public static final String SHOW_NAVBAR_LOADING = "showNavigationBarLoading";
  
  @JsEvent({"setNavigationBarTitle", "showNavigationBarLoading", "hideNavigationBarLoading", "setNavigationBarColor"})
  public void doInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.NavigationBarPlugin
 * JD-Core Version:    0.7.0.1
 */