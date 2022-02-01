package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$3
  implements Runnable
{
  QfavFilePreviewController$3(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    Object localObject = this.this$0.a;
    boolean bool;
    if (0L == QfavFilePreviewController.a(this.this$0)) {
      bool = true;
    } else {
      bool = false;
    }
    ((ControlerCallback)localObject).a(bool, QfavFilePreviewController.a(this.this$0), String.valueOf(QfavFilePreviewController.a(this.this$0)), QfavFilePreviewController.a(this.this$0), null, QfavFilePreviewController.b(this.this$0), null, QfavFilePreviewController.c(this.this$0), null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCS: mHost=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.a(this.this$0));
      ((StringBuilder)localObject).append(", port=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.a(this.this$0));
      ((StringBuilder)localObject).append(", key=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.b(this.this$0));
      ((StringBuilder)localObject).append(", retCode =");
      ((StringBuilder)localObject).append(QfavFilePreviewController.a(this.this$0));
      QLog.i("QfavFilePreviewController", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */