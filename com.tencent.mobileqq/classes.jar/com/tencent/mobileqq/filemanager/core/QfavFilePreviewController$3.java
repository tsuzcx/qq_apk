package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$3
  implements Runnable
{
  QfavFilePreviewController$3(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    FilePreviewActivity.ControlerCallback localControlerCallback = this.this$0.a;
    if (0L == QfavFilePreviewController.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.this$0), String.valueOf(QfavFilePreviewController.a(this.this$0)), QfavFilePreviewController.a(this.this$0), null, QfavFilePreviewController.b(this.this$0), null, QfavFilePreviewController.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + QfavFilePreviewController.a(this.this$0) + ", port=" + QfavFilePreviewController.a(this.this$0) + ", key=" + QfavFilePreviewController.b(this.this$0) + ", retCode =" + QfavFilePreviewController.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */