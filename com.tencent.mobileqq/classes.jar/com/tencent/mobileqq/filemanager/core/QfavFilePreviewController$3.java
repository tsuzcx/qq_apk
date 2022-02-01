package com.tencent.mobileqq.filemanager.core;

import aruk;
import asku;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(asku paramasku) {}
  
  public void run()
  {
    aruk localaruk = this.this$0.a;
    if (0L == asku.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localaruk.a(bool, asku.a(this.this$0), String.valueOf(asku.a(this.this$0)), asku.a(this.this$0), null, asku.b(this.this$0), null, asku.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + asku.a(this.this$0) + ", port=" + asku.a(this.this$0) + ", key=" + asku.b(this.this$0) + ", retCode =" + asku.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */