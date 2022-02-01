package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;

class MiniAppClientQIPCModule$3
  implements Runnable
{
  MiniAppClientQIPCModule$3(MiniAppClientQIPCModule paramMiniAppClientQIPCModule) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(MiniAppClientQIPCModule.access$100(this.this$0).appBrandRuntime.getApkgInfo().appConfig, "share_fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */