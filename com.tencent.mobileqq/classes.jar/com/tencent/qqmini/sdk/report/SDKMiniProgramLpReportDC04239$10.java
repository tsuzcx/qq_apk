package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$10
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$10(String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.d("MiniProgramLpReportDC04239", "reportApiInvoke() called with args: " + this.val$eventName);
    }
    if (this.val$miniAppConfig != null) {
      SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "inner-app", "from_api", this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10
 * JD-Core Version:    0.7.0.1
 */