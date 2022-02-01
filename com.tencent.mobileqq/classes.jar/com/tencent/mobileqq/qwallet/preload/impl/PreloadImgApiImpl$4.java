package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class PreloadImgApiImpl$4
  implements ThreadExcutor.IThreadListener
{
  PreloadImgApiImpl$4(PreloadImgApiImpl paramPreloadImgApiImpl, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.a.isEmpty())
    {
      DownloadTask localDownloadTask = new DownloadTask(this.a, this.b, UUID.randomUUID().toString());
      localDownloadTask.a(this.c);
      if (this.d.mDownloaderInterface != null) {
        this.d.mDownloaderInterface.startDownload(localDownloadTask, PreloadImgApiImpl.access$400(this.d), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.4
 * JD-Core Version:    0.7.0.1
 */