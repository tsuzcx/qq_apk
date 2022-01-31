package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class PageWebview$2$1
  implements ValueCallback
{
  PageWebview$2$1(PageWebview.2 param2) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("miniapp-start", 1, "---PageWebView begin load wawebview --- webviewid:" + this.this$1.this$0.pageWebviewId);
    PageWebview.access$800(this.this$1.this$0, PageWebview.access$200(this.this$1.this$0) + PageWebview.access$300(this.this$1.this$0), new PageWebview.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.2.1
 * JD-Core Version:    0.7.0.1
 */