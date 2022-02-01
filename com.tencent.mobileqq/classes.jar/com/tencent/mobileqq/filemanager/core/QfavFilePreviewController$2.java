package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$2
  implements Runnable
{
  QfavFilePreviewController$2(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    if (3 != QfavFilePreviewController.e(this.this$0))
    {
      this.this$0.a.a(false, QfavFilePreviewController.a(this.this$0), String.valueOf(QfavFilePreviewController.b(this.this$0)), QfavFilePreviewController.d(this.this$0), null, QfavFilePreviewController.c(this.this$0), null, QfavFilePreviewController.f(this.this$0), null);
      QfavFilePreviewController.b(this.this$0, 3);
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