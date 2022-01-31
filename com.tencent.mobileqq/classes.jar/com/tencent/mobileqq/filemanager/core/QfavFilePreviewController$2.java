package com.tencent.mobileqq.filemanager.core;

import aqho;
import aqvs;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$2
  implements Runnable
{
  public QfavFilePreviewController$2(aqvs paramaqvs) {}
  
  public void run()
  {
    if (3 != aqvs.b(this.this$0))
    {
      this.this$0.a.a(false, aqvs.a(this.this$0), String.valueOf(aqvs.a(this.this$0)), aqvs.a(this.this$0), null, aqvs.b(this.this$0), null, aqvs.c(this.this$0), null);
      aqvs.b(this.this$0, 3);
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