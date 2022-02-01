package com.tencent.mobileqq.filemanager.core;

import atib;
import atyk;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(atyk paramatyk) {}
  
  public void run()
  {
    if (3 != atyk.b(this.this$0))
    {
      this.this$0.a.a(false, atyk.a(this.this$0), String.valueOf(atyk.a(this.this$0)), atyk.a(this.this$0), null, atyk.b(this.this$0), null, atyk.c(this.this$0), null);
      atyk.b(this.this$0, 3);
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