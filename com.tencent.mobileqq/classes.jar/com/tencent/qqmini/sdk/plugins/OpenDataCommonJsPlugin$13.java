package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class OpenDataCommonJsPlugin$13
  implements Runnable
{
  OpenDataCommonJsPlugin$13(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void run()
  {
    MiniAppInfo localMiniAppInfo = this.val$miniAppContext.getMiniAppInfo();
    String str2 = SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo);
    if ("0".equals(str2)) {}
    for (String str1 = PageAction.obtain(this.val$miniAppContext).getPageUrl();; str1 = null)
    {
      SDKMiniProgramLpReportDC04239.report(localMiniAppInfo, str2, str1, "user_click", "custom_button", this.val$reservesAction, this.val$reserves2, String.valueOf(this.val$reserves3), str1, this.val$reserves5, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */