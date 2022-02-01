package com.tencent.mobileqq.microapp.webview;

import com.tencent.qphone.base.util.QLog;

final class a
  implements Runnable
{
  a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.a + "\"," + this.b + "," + this.c + "," + 0 + ")";
    if (QLog.isColorLevel()) {
      QLog.d(BaseAppBrandWebview.access$000(), 2, "evaluateSubcribeJS: " + str);
    }
    this.d.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.webview.a
 * JD-Core Version:    0.7.0.1
 */