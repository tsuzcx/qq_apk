package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class OpenDataCommonJsPlugin$19
  implements Runnable
{
  OpenDataCommonJsPlugin$19(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void run()
  {
    MiniAppInfo localMiniAppInfo = this.a.getMiniAppInfo();
    String str2 = SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo);
    String str1;
    if ("0".equals(str2)) {
      str1 = PageAction.obtain(this.a).getPageUrl();
    } else {
      str1 = null;
    }
    SDKMiniProgramLpReportDC04239.report(localMiniAppInfo, str2, str1, "user_click", "custom_button", this.b, this.c, String.valueOf(this.d), str1, this.e, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */