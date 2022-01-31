package com.tencent.mobileqq.filemanager.core;

import aozx;
import aozz;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(aozx paramaozx) {}
  
  public void run()
  {
    if (aozx.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + aozx.b(this.this$0) + "] resend");
    if (aozx.a(this.this$0) != null) {
      aozx.a(this.this$0).i();
    }
    aozx.a(this.this$0, 0L);
    aozx.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */