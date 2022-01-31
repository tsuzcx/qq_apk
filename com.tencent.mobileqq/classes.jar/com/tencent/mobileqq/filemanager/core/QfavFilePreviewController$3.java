package com.tencent.mobileqq.filemanager.core;

import anxs;
import aolw;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(aolw paramaolw) {}
  
  public void run()
  {
    anxs localanxs = this.this$0.a;
    if (0L == aolw.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localanxs.a(bool, aolw.a(this.this$0), String.valueOf(aolw.a(this.this$0)), aolw.a(this.this$0), null, aolw.b(this.this$0), null, aolw.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + aolw.a(this.this$0) + ", port=" + aolw.a(this.this$0) + ", key=" + aolw.b(this.this$0) + ", retCode =" + aolw.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */