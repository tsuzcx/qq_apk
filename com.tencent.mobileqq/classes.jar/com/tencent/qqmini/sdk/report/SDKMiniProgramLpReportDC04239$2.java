package com.tencent.qqmini.sdk.report;

import besl;
import beyu;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public final class SDKMiniProgramLpReportDC04239$2
  implements Runnable
{
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      besl.a("MiniProgramLpReportDC04239", "reportMiniAppEvent() called with: actionType = [" + this.jdField_a_of_type_JavaLangString + "],subActionType = [" + this.b + "], reserves = [" + this.c + "], appType = [" + this.d + "]");
    }
    beyu.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.d, this.e, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.f, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.2
 * JD-Core Version:    0.7.0.1
 */