package com.tencent.mobileqq.filemanager.core;

import aooq;
import apcu;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(apcu paramapcu) {}
  
  public void run()
  {
    aooq localaooq = this.this$0.a;
    if (0L == apcu.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localaooq.a(bool, apcu.a(this.this$0), String.valueOf(apcu.a(this.this$0)), apcu.a(this.this$0), null, apcu.b(this.this$0), null, apcu.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + apcu.a(this.this$0) + ", port=" + apcu.a(this.this$0) + ", key=" + apcu.b(this.this$0) + ", retCode =" + apcu.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */