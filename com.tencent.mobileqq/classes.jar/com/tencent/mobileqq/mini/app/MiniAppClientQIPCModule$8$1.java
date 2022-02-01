package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class MiniAppClientQIPCModule$8$1
  implements Runnable
{
  MiniAppClientQIPCModule$8$1(MiniAppClientQIPCModule.8 param8, BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(this.val$finalJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, "share_success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.8.1
 * JD-Core Version:    0.7.0.1
 */