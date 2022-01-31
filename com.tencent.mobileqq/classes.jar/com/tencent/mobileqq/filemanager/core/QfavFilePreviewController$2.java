package com.tencent.mobileqq.filemanager.core;

import anxs;
import aolw;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(aolw paramaolw) {}
  
  public void run()
  {
    if (3 != aolw.b(this.this$0))
    {
      this.this$0.a.a(false, aolw.a(this.this$0), String.valueOf(aolw.a(this.this$0)), aolw.a(this.this$0), null, aolw.b(this.this$0), null, aolw.c(this.this$0), null);
      aolw.b(this.this$0, 3);
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