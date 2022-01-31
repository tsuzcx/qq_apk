package com.tencent.mobileqq.mini.appbrand.page;

import alpo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ProgressWebView$6$1
  implements Runnable
{
  ProgressWebView$6$1(ProgressWebView.6 param6) {}
  
  public void run()
  {
    QLog.e("ProgressWebView", 1, "sharePicToQQ failed, because of picture downloadFailed");
    QQToast.a(ProgressWebView.access$300(this.this$1.this$0), 1, alpo.a(2131708887), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.6.1
 * JD-Core Version:    0.7.0.1
 */