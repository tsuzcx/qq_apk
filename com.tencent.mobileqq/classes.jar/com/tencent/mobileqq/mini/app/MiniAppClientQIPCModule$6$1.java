package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;

class MiniAppClientQIPCModule$6$1
  implements Runnable
{
  MiniAppClientQIPCModule$6$1(MiniAppClientQIPCModule.6 param6) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(MiniAppClientQIPCModule.access$100(this.this$1.this$0).appBrandRuntime.getApkgInfo().appConfig, "share_success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.6.1
 * JD-Core Version:    0.7.0.1
 */