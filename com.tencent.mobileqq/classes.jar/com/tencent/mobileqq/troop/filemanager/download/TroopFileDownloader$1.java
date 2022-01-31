package com.tencent.mobileqq.troop.filemanager.download;

import bbrc;
import bbsd;
import bdee;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileDownloader$1
  implements Runnable
{
  public TroopFileDownloader$1(bbsd parambbsd) {}
  
  public void run()
  {
    if (this.this$0.a) {
      bbrc.b("TroopFileDownloader", bbrc.a, "[" + this.this$0.b + "] download. had stoped");
    }
    while (this.this$0.a()) {
      return;
    }
    if (!this.this$0.c())
    {
      this.this$0.a(true, -5001, "file open exception", "");
      return;
    }
    if (!bdee.d(BaseApplication.getContext()))
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