package com.tencent.qqmini.sdk.runtime.plugin;

import begz;
import bejs;
import beka;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class PullDownRefreshJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_DISABLE_SROLL_BOUNCE = "disableScrollBounce";
  public static final String EVENT_START_PULLDOWN_REFRESH = "startPullDownRefresh";
  public static final String EVENT_STOP_PULLDOWN_REFRESH = "stopPullDownRefresh";
  
  public void doInterceptJsEvent(beka parambeka)
  {
    this.mMiniAppContext.a(bejs.a(parambeka, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PullDownRefreshJsPlugin
 * JD-Core Version:    0.7.0.1
 */