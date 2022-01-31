package com.tencent.mobileqq.troop.filemanager.download;

import azsr;
import azts;
import bbev;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileDownloader$1
  implements Runnable
{
  public TroopFileDownloader$1(azts paramazts) {}
  
  public void run()
  {
    if (this.this$0.a) {
      azsr.b("TroopFileDownloader", azsr.a, "[" + this.this$0.b + "] download. had stoped");
    }
    while (this.this$0.a()) {
      return;
    }
    if (!this.this$0.c())
    {
      this.this$0.a(true, -5001, "file open exception", "");
      return;
    }
    if (!bbev.d(BaseApplication.getContext()))
    {
      this.this$0.a(true, 9004, "no network", "");
      return;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */