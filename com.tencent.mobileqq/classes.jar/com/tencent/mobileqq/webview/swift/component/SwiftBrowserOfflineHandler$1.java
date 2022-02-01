package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicInteger;

class SwiftBrowserOfflineHandler$1
  implements Runnable
{
  SwiftBrowserOfflineHandler$1(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler, String paramString) {}
  
  public void run()
  {
    this.this$0.b();
    long l = System.currentTimeMillis();
    boolean bool;
    if (SwiftBrowserOfflineHandler.g.get() == 3) {
      bool = HtmlOffline.a(BaseApplication.getContext().getApplicationContext(), this.a, new SwiftBrowserOfflineHandler.1.1(this, l));
    } else {
      bool = false;
    }
    if (!bool) {
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1
 * JD-Core Version:    0.7.0.1
 */