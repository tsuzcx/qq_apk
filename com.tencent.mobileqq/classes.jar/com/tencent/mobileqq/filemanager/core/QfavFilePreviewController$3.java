package com.tencent.mobileqq.filemanager.core;

import asrx;
import atgq;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(atgq paramatgq) {}
  
  public void run()
  {
    asrx localasrx = this.this$0.a;
    if (0L == atgq.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localasrx.a(bool, atgq.a(this.this$0), String.valueOf(atgq.a(this.this$0)), atgq.a(this.this$0), null, atgq.b(this.this$0), null, atgq.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + atgq.a(this.this$0) + ", port=" + atgq.a(this.this$0) + ", key=" + atgq.b(this.this$0) + ", retCode =" + atgq.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */