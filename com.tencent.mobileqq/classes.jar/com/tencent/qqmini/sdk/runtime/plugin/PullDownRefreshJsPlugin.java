package com.tencent.qqmini.sdk.runtime.plugin;

import bglv;
import bgmk;
import bgok;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class PullDownRefreshJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_DISABLE_SROLL_BOUNCE = "disableScrollBounce";
  public static final String EVENT_START_PULLDOWN_REFRESH = "startPullDownRefresh";
  public static final String EVENT_STOP_PULLDOWN_REFRESH = "stopPullDownRefresh";
  
  public void doInterceptJsEvent(bgok parambgok)
  {
    this.mMiniAppContext.a(bgmk.a(parambgok, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PullDownRefreshJsPlugin
 * JD-Core Version:    0.7.0.1
 */