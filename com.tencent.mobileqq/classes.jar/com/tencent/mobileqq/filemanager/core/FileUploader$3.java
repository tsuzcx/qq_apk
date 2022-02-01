package com.tencent.mobileqq.filemanager.core;

import atlw;
import atly;
import com.tencent.qphone.base.util.QLog;

public class FileUploader$3
  implements Runnable
{
  public FileUploader$3(atlw paramatlw) {}
  
  public void run()
  {
    if (atlw.a(this.this$0)) {
      return;
    }
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + atlw.b(this.this$0) + "] resend");
    if (atlw.a(this.this$0) != null) {
      atlw.a(this.this$0).i();
    }
    atlw.a(this.this$0, 0L);
    atlw.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader.3
 * JD-Core Version:    0.7.0.1
 */