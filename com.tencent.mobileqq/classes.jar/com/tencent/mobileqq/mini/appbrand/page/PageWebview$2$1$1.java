package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class PageWebview$2$1$1
  implements ValueCallback
{
  PageWebview$2$1$1(PageWebview.2.1 param1) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("miniapp-start", 1, "---PageWebView end load WAWebviewJs --- webviewid:" + this.this$2.this$1.this$0.pageWebviewId);
    PageWebview.access$502(this.this$2.this$1.this$0, true);
    PageWebview.access$400(this.this$2.this$1.this$0, 19);
    if ((!PageWebview.access$600(this.this$2.this$1.this$0)) && (this.this$2.this$1.this$0.apkgInfo != null))
    {
      PageWebview.access$602(this.this$2.this$1.this$0, true);
      this.this$2.this$1.this$0.doInitApkgJs();
    }
    PageWebview.access$702(this.this$2.this$1.this$0, true);
    this.this$2.this$1.this$0.runDelayedEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.2.1.1
 * JD-Core Version:    0.7.0.1
 */