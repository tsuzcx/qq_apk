package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.smtt.sdk.JsContext;

class ServiceWebview$7
  implements Runnable
{
  ServiceWebview$7(ServiceWebview paramServiceWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.val$eventName + "\"," + this.val$data + "," + this.val$webviweId + "," + 0 + ")";
    if (this.this$0.mJsContext != null) {
      this.this$0.mJsContext.evaluateJavascript(str, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.7
 * JD-Core Version:    0.7.0.1
 */