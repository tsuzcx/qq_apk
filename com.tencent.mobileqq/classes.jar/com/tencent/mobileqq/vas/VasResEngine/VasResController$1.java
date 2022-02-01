package com.tencent.mobileqq.vas.VasResEngine;

import android.annotation.TargetApi;
import android.os.Handler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class VasResController$1
  extends DownloadListener
{
  VasResController$1(VasResController paramVasResController) {}
  
  @TargetApi(9)
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    VasResController.a(this.a).sendMessage(VasResController.a(this.a).obtainMessage(10002, paramDownloadTask.e(), 0, paramDownloadTask.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController.1
 * JD-Core Version:    0.7.0.1
 */