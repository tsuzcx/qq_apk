package com.tencent.mobileqq.mini.appbrand.page;

import anzj;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ProgressWebView$5$2
  implements Runnable
{
  ProgressWebView$5$2(ProgressWebView.5 param5) {}
  
  public void run()
  {
    File localFile = new File(this.this$1.val$tmpFilePath);
    if (localFile.exists())
    {
      ProgressWebView.access$1000(this.this$1.this$0, localFile.getAbsolutePath());
      return;
    }
    QLog.e("ProgressWebView", 1, "savaPicToAlbum failed, because of picture downloadFailed");
    QQToast.a(ProgressWebView.access$300(this.this$1.this$0), 1, anzj.a(2131707385), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.5.2
 * JD-Core Version:    0.7.0.1
 */