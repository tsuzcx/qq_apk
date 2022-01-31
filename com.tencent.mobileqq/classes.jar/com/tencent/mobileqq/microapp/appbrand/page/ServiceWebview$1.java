package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.a.a;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$1
  implements ValueCallback
{
  ServiceWebview$1(ServiceWebview paramServiceWebview, a.a parama, f paramf) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if (this.val$listener != null) {
      this.val$listener.a();
    }
    a.a(this.this$0, this.val$apkgInfo.b());
    if (QLog.isColorLevel()) {
      QLog.i("PageWebview111", 2, "---end getWAServiceJSStr----");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview.1
 * JD-Core Version:    0.7.0.1
 */