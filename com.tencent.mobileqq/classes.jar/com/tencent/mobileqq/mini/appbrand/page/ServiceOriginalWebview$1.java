package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsConsoleMessageListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsErrorListener;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class ServiceOriginalWebview$1
  extends WebChromeClient
{
  ServiceOriginalWebview$1(ServiceOriginalWebview paramServiceOriginalWebview) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (this.this$0.mJsConsoleMessageListener != null) {
      this.this$0.mJsConsoleMessageListener.onConsoleMessage(paramConsoleMessage);
    }
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label194;
      }
      if (this.this$0.mJsErrorListener != null) {
        this.this$0.mJsErrorListener.onJsError();
      }
      QLog.e("miniapp-chromium", 1, "ServiceOriginalWebview: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      if ((this.this$0.getApkgInfo() != null) && (paramConsoleMessage != null) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) {
        MiniReportManager.reportEventType(this.this$0.getApkgInfo().appConfig, 23, this.this$0.getUrl(), paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), null, 0);
      }
      return super.onConsoleMessage(paramConsoleMessage);
      label194:
      QLog.i("miniapp-chromium", 2, "ServiceOriginalWebview: " + paramConsoleMessage.message());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.1
 * JD-Core Version:    0.7.0.1
 */