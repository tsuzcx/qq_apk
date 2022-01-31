package com.tencent.mobileqq.mini.appbrand.page;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

class ServiceWebview$1
  implements QbSdk.PreInitCallback
{
  ServiceWebview$1(ServiceWebview paramServiceWebview) {}
  
  public void onCoreInitFinished()
  {
    QLog.e("miniapp-start", 1, "onCoreInitFinished in thread --> " + this.this$0.threadName);
    ServiceWebview.access$002(true);
    this.this$0.mThreadHandler.post(new ServiceWebview.1.1(this));
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    QLog.e("miniapp-start", 1, "onViewInitFinished isX5Core:" + paramBoolean + " in thread -->" + this.this$0.threadName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.1
 * JD-Core Version:    0.7.0.1
 */