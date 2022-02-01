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
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getMiniAppInfo();
    String str2 = SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo);
    String str1;
    if ("0".equals(str2)) {
      str1 = PageAction.obtain(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext).getPageUrl();
    } else {
      str1 = null;
    }
    SDKMiniProgramLpReportDC04239.report(localMiniAppInfo, str2, str1, "user_click", "custom_button", this.jdField_a_of_type_JavaLangString, this.b, String.valueOf(this.jdField_a_of_type_Int), str1, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */