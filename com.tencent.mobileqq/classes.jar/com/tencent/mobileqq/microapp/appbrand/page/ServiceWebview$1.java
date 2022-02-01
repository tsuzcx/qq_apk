package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$1
  implements ValueCallback
{
  ServiceWebview$1(ServiceWebview paramServiceWebview, a.a parama, c paramc) {}
  
  public void onReceiveValue(Object paramObject)
  {
    paramObject = this.val$listener;
    if (paramObject != null) {
      paramObject.a();
    }
    c.a(this.this$0, this.val$apkgInfo$5475ea27.a());
    if (QLog.isColorLevel()) {
      QLog.i("PageWebview111", 2, "---end getWAServiceJSStr----");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview.1
 * JD-Core Version:    0.7.0.1
 */