package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$4$1
  implements ValueCallback
{
  ServiceWebview$4$1(ServiceWebview.4 param4) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!this.this$1.this$0.AppServiceJsLoaded) && (this.this$1.this$0.apkgInfo != null) && (ServiceWebview.access$300(this.this$1.this$0) != null))
    {
      this.this$1.this$0.AppServiceJsLoaded = true;
      ServiceWebview.access$400(this.this$1.this$0, this.this$1.this$0.apkgInfo, null, ServiceWebview.access$300(this.this$1.this$0));
      MiniReportManager.reportEventType(this.this$1.this$0.apkgInfo.appConfig, 15, this.this$1.this$0.getUrl(), null, null, 0);
    }
    if (this.this$1.this$0.appServiceJsCallback != null) {
      this.this$1.this$0.appServiceJsCallback.onReceiveValue(paramObject);
    }
    this.this$1.this$0.waServiceJSLoaded = true;
    QLog.i("miniapp-start", 1, "---end initWAServiceJS----");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.4.1
 * JD-Core Version:    0.7.0.1
 */