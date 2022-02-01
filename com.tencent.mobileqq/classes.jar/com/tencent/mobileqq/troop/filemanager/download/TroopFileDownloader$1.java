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
    if (this.this$0.h)
    {
      int i = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.this$0.b);
      localStringBuilder.append("] download. had stoped");
      TroopFileTransferUtil.Log.b("TroopFileDownloader", i, localStringBuilder.toString());
      return;
    }
    if (this.this$0.c()) {
      return;
    }
    if (!this.this$0.f())
    {
      this.this$0.a(true, -5001, "file open exception", "");
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.this$0.a(true, 9004, "no network", "");
      return;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */