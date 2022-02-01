package com.tencent.mobileqq.filemanager.core;

import asyq;
import atpa;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(atpa paramatpa) {}
  
  public void run()
  {
    asyq localasyq = this.this$0.a;
    if (0L == atpa.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localasyq.a(bool, atpa.a(this.this$0), String.valueOf(atpa.a(this.this$0)), atpa.a(this.this$0), null, atpa.b(this.this$0), null, atpa.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + atpa.a(this.this$0) + ", port=" + atpa.a(this.this$0) + ", key=" + atpa.b(this.this$0) + ", retCode =" + atpa.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */