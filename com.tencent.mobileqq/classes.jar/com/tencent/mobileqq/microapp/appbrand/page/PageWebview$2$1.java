package com.tencent.mobileqq.microapp.appbrand.page;

import android.text.TextUtils;
import bdnn;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class PageWebview$2$1
  implements ValueCallback
{
  PageWebview$2$1(PageWebview.2 param2) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(PageWebview.access$100(), 2, "---load wawebview ---");
    }
    PageWebview.access$402(this.this$1.this$0, true);
    if (this.this$1.this$0.apkgInfo != null)
    {
      this.this$1.this$0.initJSGlobalConfig();
      PageWebview.access$500(this.this$1.this$0);
      if (bdnn.a(PageWebview.access$600(this.this$1.this$0))) {
        PageWebview.access$602(this.this$1.this$0, this.this$1.this$0.apkgInfo.e());
      }
      if (!TextUtils.isEmpty(PageWebview.access$600(this.this$1.this$0))) {
        this.this$1.this$0.evaluteJs(PageWebview.access$600(this.this$1.this$0));
      }
      if (!bdnn.a(PageWebview.access$200(this.this$1.this$0))) {
        this.this$1.this$0.evaluteJs(PageWebview.access$200(this.this$1.this$0));
      }
      this.this$1.this$0.loadPageWebviewJs(this.this$1.this$0.apkgInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview.2.1
 * JD-Core Version:    0.7.0.1
 */