package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.qphone.base.util.QLog;

class ServiceRemoteRuntime$2
  implements Runnable
{
  ServiceRemoteRuntime$2(ServiceRemoteRuntime paramServiceRemoteRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.val$eventName + "\"," + this.val$data + "," + this.val$webviweId + "," + 0 + ")";
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-JS", 2, "[evaluateCallbackJs] callbackStr=" + str);
    }
    ServiceRemoteRuntime.access$000(this.this$0).evaluateJs(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceRemoteRuntime.2
 * JD-Core Version:    0.7.0.1
 */