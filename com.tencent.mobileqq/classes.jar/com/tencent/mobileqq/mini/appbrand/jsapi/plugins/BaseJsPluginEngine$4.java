package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amcx;
import amcy;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.List;

class BaseJsPluginEngine$4
  implements Runnable
{
  BaseJsPluginEngine$4(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString) {}
  
  public void run()
  {
    amcx localamcx = amcy.a();
    if ((localamcx != null) && (localamcx.a() != null) && (localamcx.a().contains(this.val$eventName))) {
      MiniProgramLpReportDC04239.reportApiInvoke(this.this$0.appBrandRuntime.getApkgInfo().appConfig, this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.4
 * JD-Core Version:    0.7.0.1
 */