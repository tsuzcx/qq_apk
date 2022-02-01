package com.tencent.mobileqq.mini.appbrand.page;

import anzj;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ProgressWebView$5$1
  implements Runnable
{
  ProgressWebView$5$1(ProgressWebView.5 param5) {}
  
  public void run()
  {
    QLog.e("ProgressWebView", 1, "savaPicToAlbum failed, because of picture downloadFailed");
    QQToast.a(ProgressWebView.access$300(this.this$1.this$0), 1, anzj.a(2131707383), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.5.1
 * JD-Core Version:    0.7.0.1
 */