package com.tencent.qqmini.proxyimpl;

import bjei;
import bjeo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public class MiniSDKClientQIPCModule$4
  implements Runnable
{
  public MiniSDKClientQIPCModule$4(bjei parambjei, BaseRuntime paramBaseRuntime, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void run()
  {
    MiniAppConfig localMiniAppConfig = bjeo.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime.getMiniAppInfo());
    String str2 = MiniProgramLpReportDC04239.getAppType(localMiniAppConfig);
    if ("0".equals(str2)) {}
    for (String str1 = ActionBridge.PageActionBridge.getPageUrl(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime);; str1 = null)
    {
      MiniProgramLpReportDC04239.report(localMiniAppConfig, str2, str1, "user_click", "custom_button", this.jdField_a_of_type_JavaLangString, this.b, String.valueOf(this.jdField_a_of_type_Int), str1, this.c, null);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */