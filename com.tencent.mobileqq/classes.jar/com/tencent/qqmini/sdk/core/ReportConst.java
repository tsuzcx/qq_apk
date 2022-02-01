package com.tencent.qqmini.sdk.core;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ReportConst
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  private static MiniAppInfo MINI_APP_CONFIG_FOR_PRELOAD;
  public static final String PRELOAD_MINI_APP_ID = "0000000000";
  public static List<String> apiReportList = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static MiniAppInfo miniAppConfigForPreload()
  {
    if (MINI_APP_CONFIG_FOR_PRELOAD == null) {}
    try
    {
      if (MINI_APP_CONFIG_FOR_PRELOAD == null)
      {
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = "0000000000";
        localMiniAppInfo.launchParam.miniAppId = "0000000000";
        MINI_APP_CONFIG_FOR_PRELOAD = localMiniAppInfo;
      }
      return MINI_APP_CONFIG_FOR_PRELOAD;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.ReportConst
 * JD-Core Version:    0.7.0.1
 */