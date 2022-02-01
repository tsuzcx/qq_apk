package com.tencent.mobileqq.filemanager.core;

import atdm;
import atdo;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(atdm paramatdm) {}
  
  public void run()
  {
    if (atdm.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + atdm.b(this.this$0) + "] resend");
    if (atdm.a(this.this$0) != null) {
      atdm.a(this.this$0).i();
    }
    atdm.a(this.this$0, 0L);
    atdm.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */