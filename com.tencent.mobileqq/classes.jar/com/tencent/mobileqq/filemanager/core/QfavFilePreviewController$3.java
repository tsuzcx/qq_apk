package com.tencent.mobileqq.filemanager.core;

import aqho;
import aqvs;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$3
  implements Runnable
{
  public QfavFilePreviewController$3(aqvs paramaqvs) {}
  
  public void run()
  {
    aqho localaqho = this.this$0.a;
    if (0L == aqvs.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localaqho.a(bool, aqvs.a(this.this$0), String.valueOf(aqvs.a(this.this$0)), aqvs.a(this.this$0), null, aqvs.b(this.this$0), null, aqvs.c(this.this$0), null);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + aqvs.a(this.this$0) + ", port=" + aqvs.a(this.this$0) + ", key=" + aqvs.b(this.this$0) + ", retCode =" + aqvs.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
 * JD-Core Version:    0.7.0.1
 */