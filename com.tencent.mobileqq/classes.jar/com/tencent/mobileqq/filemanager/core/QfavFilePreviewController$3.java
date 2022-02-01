package com.tencent.mobileqq.filemanager.core;

import atib;
import atyk;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(atyk paramatyk) {}
  
  public void run()
  {
    atib localatib = this.this$0.a;
    if (0L == atyk.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localatib.a(bool, atyk.a(this.this$0), String.valueOf(atyk.a(this.this$0)), atyk.a(this.this$0), null, atyk.b(this.this$0), null, atyk.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + atyk.a(this.this$0) + ", port=" + atyk.a(this.this$0) + ", key=" + atyk.b(this.this$0) + ", retCode =" + atyk.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */