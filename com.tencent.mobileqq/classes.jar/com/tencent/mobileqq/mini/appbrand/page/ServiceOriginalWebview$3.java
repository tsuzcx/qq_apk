package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceOriginalWebview$3
  implements ValueCallback
{
  ServiceOriginalWebview$3(ServiceOriginalWebview paramServiceOriginalWebview) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!this.this$0.AppServiceJsLoaded) && (this.this$0.apkgInfo != null) && (ServiceOriginalWebview.access$100(this.this$0) != null))
    {
      this.this$0.AppServiceJsLoaded = true;
      ServiceOriginalWebview.access$200(this.this$0, this.this$0.apkgInfo, ServiceOriginalWebview.access$100(this.this$0));
    }
    if (this.this$0.apkgInfo != null) {
      MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 15, this.this$0.getUrl(), null, null, 0);
    }
    for (;;)
    {
      if (this.this$0.appServiceJsCallback != null) {
        this.this$0.appServiceJsCallback.onReceiveValue(paramObject);
      }
      this.this$0.waServiceJSLoaded = true;
      QLog.i("ServiceOriginalWebview", 1, "---end initWAServiceJS----");
      return;
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 15, this.this$0.getUrl(), null, null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.3
 * JD-Core Version:    0.7.0.1
 */