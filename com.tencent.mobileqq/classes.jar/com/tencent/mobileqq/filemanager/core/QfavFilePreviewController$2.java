package com.tencent.mobileqq.filemanager.core;

import asyq;
import atpa;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(atpa paramatpa) {}
  
  public void run()
  {
    if (3 != atpa.b(this.this$0))
    {
      this.this$0.a.a(false, atpa.a(this.this$0), String.valueOf(atpa.a(this.this$0)), atpa.a(this.this$0), null, atpa.b(this.this$0), null, atpa.c(this.this$0), null);
      atpa.b(this.this$0, 3);
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