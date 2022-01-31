package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;

class AppBrandRuntime$7
  implements Runnable
{
  AppBrandRuntime$7(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    AppLoaderFactory.getAppLoaderManager().notifyMessage(AppBrandRuntime.access$100(317));
    MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 121, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.this$0), null, null, 0);
    StringBuilder localStringBuilder = new StringBuilder().append("页面加载完成 url=");
    if (this.this$0.pageContainer.getCurrentPage() != null) {}
    for (String str = this.this$0.pageContainer.getCurrentPage().getUrl();; str = "null")
    {
      QLog.i("miniapp-start", 1, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.7
 * JD-Core Version:    0.7.0.1
 */