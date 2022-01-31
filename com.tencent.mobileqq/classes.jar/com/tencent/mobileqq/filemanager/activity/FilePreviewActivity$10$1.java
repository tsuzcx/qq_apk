package com.tencent.mobileqq.filemanager.activity;

import android.os.Handler;
import aooe;

public class FilePreviewActivity$10$1
  implements Runnable
{
  public FilePreviewActivity$10$1(aooe paramaooe) {}
  
  public void run()
  {
    if (this.a.a.f)
    {
      this.a.a.d();
      return;
    }
    this.a.a.e();
    this.a.a.d();
    new Handler().postDelayed(new FilePreviewActivity.10.1.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.10.1
 * JD-Core Version:    0.7.0.1
 */