package com.tencent.mobileqq.filemanager.activity;

import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$16$2
  implements Runnable
{
  FilePreviewActivity$16$2(FilePreviewActivity.16 param16, int paramInt1, boolean paramBoolean, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = this.a;
    if (i == 0) {
      this.e.a.a(this.b, this.c, this.d);
    } else if (i == 1) {
      this.e.a.b(this.b, this.c, this.d);
    }
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish  process Over");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2
 * JD-Core Version:    0.7.0.1
 */