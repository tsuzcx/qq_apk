package com.tencent.mobileqq.filemanager.core;

import aoiz;
import aojb;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(aoiz paramaoiz) {}
  
  public void run()
  {
    if (aoiz.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + aoiz.b(this.this$0) + "] resend");
    if (aoiz.a(this.this$0) != null) {
      aoiz.a(this.this$0).i();
    }
    aoiz.a(this.this$0, 0L);
    aoiz.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */