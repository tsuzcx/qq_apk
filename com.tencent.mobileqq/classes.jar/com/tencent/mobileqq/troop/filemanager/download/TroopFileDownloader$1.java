package com.tencent.mobileqq.troop.filemanager.download;

import bfvr;
import bfwr;
import bhnv;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileDownloader$1
  implements Runnable
{
  public TroopFileDownloader$1(bfwr parambfwr) {}
  
  public void run()
  {
    if (this.this$0.a) {
      bfvr.b("TroopFileDownloader", bfvr.a, "[" + this.this$0.b + "] download. had stoped");
    }
    while (this.this$0.a()) {
      return;
    }
    if (!this.this$0.c())
    {
      this.this$0.a(true, -5001, "file open exception", "");
      return;
    }
    if (!bhnv.d(BaseApplication.getContext()))
    {
      this.this$0.a(true, 9004, "no network", "");
      return;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */