package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

class MiniSDKClientQIPCModule$4
  implements Runnable
{
  MiniSDKClientQIPCModule$4(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, BaseRuntime paramBaseRuntime, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void run()
  {
    MiniAppConfig localMiniAppConfig = MiniSdkUtil.b(this.a.getMiniAppInfo());
    String str2 = MiniProgramLpReportDC04239.getAppType(localMiniAppConfig);
    String str1;
    if ("0".equals(str2)) {
      str1 = ActionBridge.PageActionBridge.getPageUrl(this.a);
    } else {
      str1 = null;
    }
    MiniProgramLpReportDC04239.report(localMiniAppConfig, str2, str1, "user_click", "custom_button", this.b, this.c, String.valueOf(this.d), str1, this.e, null);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */