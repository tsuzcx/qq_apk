package com.tencent.qqmini.sdk.report;

import betc;
import bezl;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class SDKMiniProgramLpReportDC04239$3
  implements Runnable
{
  public SDKMiniProgramLpReportDC04239$3(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo, String paramString4) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      betc.a("MiniProgramLpReportDC04239", "reportUserClick() called with: subActionType = [" + this.jdField_a_of_type_JavaLangString + "], reserves = [" + this.b + "], appType = [" + this.c + "]");
    }
    bezl.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.c, this.d, "page_view", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3
 * JD-Core Version:    0.7.0.1
 */