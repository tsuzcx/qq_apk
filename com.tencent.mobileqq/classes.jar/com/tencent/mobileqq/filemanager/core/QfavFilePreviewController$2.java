package com.tencent.mobileqq.filemanager.core;

import aool;
import apcq;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(apcq paramapcq) {}
  
  public void run()
  {
    if (3 != apcq.b(this.this$0))
    {
      this.this$0.a.a(false, apcq.a(this.this$0), String.valueOf(apcq.a(this.this$0)), apcq.a(this.this$0), null, apcq.b(this.this$0), null, apcq.c(this.this$0), null);
      apcq.b(this.this$0, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2
 * JD-Core Version:    0.7.0.1
 */