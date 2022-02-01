package com.tencent.mobileqq.filemanager.core;

import ashq;
import ashs;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(ashq paramashq) {}
  
  public void run()
  {
    if (ashq.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + ashq.b(this.this$0) + "] resend");
    if (ashq.a(this.this$0) != null) {
      ashq.a(this.this$0).i();
    }
    ashq.a(this.this$0, 0L);
    ashq.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */