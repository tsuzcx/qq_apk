package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;

class AppBrandRuntime$4
  implements Runnable
{
  AppBrandRuntime$4(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 2, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.this$0), null, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */