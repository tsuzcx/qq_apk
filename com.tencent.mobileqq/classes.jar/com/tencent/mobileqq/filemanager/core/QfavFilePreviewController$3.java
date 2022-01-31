package com.tencent.mobileqq.filemanager.core;

import aqlx;
import arab;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(arab paramarab) {}
  
  public void run()
  {
    aqlx localaqlx = this.this$0.a;
    if (0L == arab.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localaqlx.a(bool, arab.a(this.this$0), String.valueOf(arab.a(this.this$0)), arab.a(this.this$0), null, arab.b(this.this$0), null, arab.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + arab.a(this.this$0) + ", port=" + arab.a(this.this$0) + ", key=" + arab.b(this.this$0) + ", retCode =" + arab.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */