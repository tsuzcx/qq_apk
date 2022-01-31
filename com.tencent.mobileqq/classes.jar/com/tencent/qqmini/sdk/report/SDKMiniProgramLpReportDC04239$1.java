package com.tencent.qqmini.sdk.report;

import bdnw;
import bdsx;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public final class SDKMiniProgramLpReportDC04239$1
  implements Runnable
{
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      bdnw.a("MiniProgramLpReportDC04239", "reportUserClick() called with: actionType = [" + this.jdField_a_of_type_JavaLangString + "],subActionType = [" + this.b + "], reserves = [" + this.c + "], appType = [" + this.d + "]");
    }
    bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.d, this.e, this.jdField_a_of_type_JavaLangString, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1
 * JD-Core Version:    0.7.0.1
 */