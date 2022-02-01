package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class TroopFileDownloader$1
  implements Runnable
{
  TroopFileDownloader$1(TroopFileDownloader paramTroopFileDownloader) {}
  
  public void run()
  {
    if (this.this$0.a) {
      TroopFileTransferUtil.Log.b("TroopFileDownloader", TroopFileTransferUtil.Log.a, "[" + this.this$0.b + "] download. had stoped");
    }
    while (this.this$0.a()) {
      return;
    }
    if (!this.this$0.c())
    {
      this.this$0.a(true, -5001, "file open exception", "");
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
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