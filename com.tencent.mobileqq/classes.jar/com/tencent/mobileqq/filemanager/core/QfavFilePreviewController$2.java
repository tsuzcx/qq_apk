package com.tencent.mobileqq.filemanager.core;

import aqlx;
import arab;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(arab paramarab) {}
  
  public void run()
  {
    if (3 != arab.b(this.this$0))
    {
      this.this$0.a.a(false, arab.a(this.this$0), String.valueOf(arab.a(this.this$0)), arab.a(this.this$0), null, arab.b(this.this$0), null, arab.c(this.this$0), null);
      arab.b(this.this$0, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2
 * JD-Core Version:    0.7.0.1
 */