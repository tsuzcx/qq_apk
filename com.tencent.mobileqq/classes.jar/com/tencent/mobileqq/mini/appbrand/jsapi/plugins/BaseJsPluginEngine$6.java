package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import apyq;
import apyr;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.List;

class BaseJsPluginEngine$6
  implements Runnable
{
  BaseJsPluginEngine$6(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString) {}
  
  public void run()
  {
    apyq localapyq = apyr.a();
    if ((localapyq != null) && (localapyq.a() != null) && (localapyq.a().contains(this.val$eventName))) {
      MiniProgramLpReportDC04239.reportApiInvoke(this.this$0.appBrandRuntime.getApkgInfo().appConfig, this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.6
 * JD-Core Version:    0.7.0.1
 */