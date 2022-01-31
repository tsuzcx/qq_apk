package com.tencent.mobileqq.mini.appbrand.page;

import ajjy;
import bbmy;
import com.tencent.qphone.base.util.QLog;

class ProgressWebView$6$1
  implements Runnable
{
  ProgressWebView$6$1(ProgressWebView.6 param6) {}
  
  public void run()
  {
    QLog.e("ProgressWebView", 1, "sharePicToQQ failed, because of picture downloadFailed");
    bbmy.a(ProgressWebView.access$300(this.this$1.this$0), 1, ajjy.a(2131642719), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.6.1
 * JD-Core Version:    0.7.0.1
 */