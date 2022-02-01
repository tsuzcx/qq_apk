package com.tencent.mobileqq.filemanager.activity;

import android.os.Handler;

class FilePreviewActivity$10$1
  implements Runnable
{
  FilePreviewActivity$10$1(FilePreviewActivity.10 param10) {}
  
  public void run()
  {
    if (this.a.a.M)
    {
      this.a.a.e();
      return;
    }
    this.a.a.f();
    this.a.a.e();
    new Handler().postDelayed(new FilePreviewActivity.10.1.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1
 * JD-Core Version:    0.7.0.1
 */