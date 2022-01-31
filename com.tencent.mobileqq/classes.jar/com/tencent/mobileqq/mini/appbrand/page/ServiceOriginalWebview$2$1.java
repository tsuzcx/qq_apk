package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceOriginalWebview$2$1
  implements ValueCallback
{
  ServiceOriginalWebview$2$1(ServiceOriginalWebview.2 param2) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("ServiceOriginalWebview", 2, "---end initAppServiceJs----");
    MiniReportManager.reportEventType(this.this$1.val$apkgInfo.appConfig, 105, this.this$1.this$0.getUrl(), null, null, 0);
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onLoadFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.2.1
 * JD-Core Version:    0.7.0.1
 */