package com.tencent.mobileqq.filemanager.core;

import aruk;
import asku;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(asku paramasku) {}
  
  public void run()
  {
    if (3 != asku.b(this.this$0))
    {
      this.this$0.a.a(false, asku.a(this.this$0), String.valueOf(asku.a(this.this$0)), asku.a(this.this$0), null, asku.b(this.this$0), null, asku.c(this.this$0), null);
      asku.b(this.this$0, 3);
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