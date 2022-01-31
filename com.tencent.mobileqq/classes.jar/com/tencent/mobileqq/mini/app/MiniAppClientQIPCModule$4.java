package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class MiniAppClientQIPCModule$4
  implements Runnable
{
  MiniAppClientQIPCModule$4(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(this.val$appBrandRuntime.getApkgInfo().appConfig, "share_fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */