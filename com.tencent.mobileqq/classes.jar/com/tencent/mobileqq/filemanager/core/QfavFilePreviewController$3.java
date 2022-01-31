package com.tencent.mobileqq.filemanager.core;

import aool;
import apcq;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(apcq paramapcq) {}
  
  public void run()
  {
    aool localaool = this.this$0.a;
    if (0L == apcq.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localaool.a(bool, apcq.a(this.this$0), String.valueOf(apcq.a(this.this$0)), apcq.a(this.this$0), null, apcq.b(this.this$0), null, apcq.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + apcq.a(this.this$0) + ", port=" + apcq.a(this.this$0) + ", key=" + apcq.b(this.this$0) + ", retCode =" + apcq.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */