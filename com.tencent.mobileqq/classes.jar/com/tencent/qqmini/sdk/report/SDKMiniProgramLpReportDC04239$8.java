package com.tencent.qqmini.sdk.report;

import bhcn;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public final class SDKMiniProgramLpReportDC04239$8
  implements Runnable
{
  public SDKMiniProgramLpReportDC04239$8(String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.d("MiniProgramLpReportDC04239", "reportApiInvoke() called with args: " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
      bhcn.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bhcn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), null, "inner-app", "from_api", this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.8
 * JD-Core Version:    0.7.0.1
 */