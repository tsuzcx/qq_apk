package com.tencent.mobileqq.mini.webview;

import com.tencent.qphone.base.util.QLog;

class BaseAppBrandWebview$2
  implements Runnable
{
  BaseAppBrandWebview$2(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.val$eventName + "\"," + this.val$data + "," + 0 + ",\"" + this.val$webviweId + "\")";
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-JS", 2, "evaluateSubcribeJSInService: eventName:" + this.val$eventName + "   webviewId:" + this.val$webviweId);
    }
    this.this$0.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.webview.BaseAppBrandWebview.2
 * JD-Core Version:    0.7.0.1
 */