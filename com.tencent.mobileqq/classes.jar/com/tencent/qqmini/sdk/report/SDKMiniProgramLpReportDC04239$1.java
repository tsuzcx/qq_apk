package com.tencent.qqmini.sdk.report;

import betc;
import bezl;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class SDKMiniProgramLpReportDC04239$1
  implements Runnable
{
  public SDKMiniProgramLpReportDC04239$1(String paramString1, String paramString2, String paramString3, String paramString4, MiniAppInfo paramMiniAppInfo, String paramString5) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      betc.a("MiniProgramLpReportDC04239", "reportUserClick() called with: actionType = [" + this.jdField_a_of_type_JavaLangString + "],subActionType = [" + this.b + "], reserves = [" + this.c + "], appType = [" + this.d + "]");
    }
    bezl.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.d, this.e, this.jdField_a_of_type_JavaLangString, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1
 * JD-Core Version:    0.7.0.1
 */