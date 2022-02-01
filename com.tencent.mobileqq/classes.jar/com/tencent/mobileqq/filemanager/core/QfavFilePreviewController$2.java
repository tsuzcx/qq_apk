package com.tencent.mobileqq.filemanager.core;

import asrx;
import atgq;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(atgq paramatgq) {}
  
  public void run()
  {
    if (3 != atgq.b(this.this$0))
    {
      this.this$0.a.a(false, atgq.a(this.this$0), String.valueOf(atgq.a(this.this$0)), atgq.a(this.this$0), null, atgq.b(this.this$0), null, atgq.c(this.this$0), null);
      atgq.b(this.this$0, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2
 * JD-Core Version:    0.7.0.1
 */