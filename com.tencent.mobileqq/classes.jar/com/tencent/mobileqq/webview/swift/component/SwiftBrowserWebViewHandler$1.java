package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

class SwiftBrowserWebViewHandler$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    WebAccelerator.initTbsEnvironment(this.a, 2);
    this.this$0.a.compareAndSet(2, 3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebAccelerator.asyncInitWebView, cost=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("SwiftBrowserWebViewHandler", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new SwiftBrowserWebViewHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler.1
 * JD-Core Version:    0.7.0.1
 */