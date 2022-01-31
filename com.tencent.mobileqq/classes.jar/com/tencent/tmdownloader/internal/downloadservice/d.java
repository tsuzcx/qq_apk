package com.tencent.tmdownloader.internal.downloadservice;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.tmassistantbase.util.r;

class d
  implements DownloaderTaskListener
{
  private int b = 2;
  
  d(c paramc) {}
  
  public void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskCompletedMainloop");
  }
  
  public void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask)
  {
    this.a.j = paramDownloaderTask.getRealSaveName();
    r.c("_DownloadInfo", "halleyTest onTaskCompletedSubloop saveFileName = " + paramDownloaderTask.getRealSaveName());
    this.a.b(paramDownloaderTask.getReceivedLength());
    this.a.m = 0;
    this.a.a(4);
    r.c("_DownloadInfo", "halleyTest onTaskCompletedSubloop mReceivedBytes=" + this.a.h + ",totalSize=" + this.a.i);
    this.a.a(103, paramDownloaderTask);
  }
  
  public void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask)
  {
    this.a.j = paramDownloaderTask.getRealSaveName();
    r.c("_DownloadInfo", "halleyTest onTaskDetectedSubloop saveFileName = " + paramDownloaderTask.getRealSaveName());
    r.c("_DownloadInfo", "halleyTest onTaskDetectedSubloop percent=" + paramDownloaderTask.getPercentage() + ",receivedBytes=" + paramDownloaderTask.getReceivedLength());
    this.a.a(paramDownloaderTask.getTotalLength());
    if ((paramDownloaderTask.getPercentage() == 0) && (paramDownloaderTask.getReceivedLength() == 0L)) {
      this.a.a(2);
    }
  }
  
  public void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskFailedMainloop");
  }
  
  public void onTaskFailedSubloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskFailedSubloop failCode=" + paramDownloaderTask.getFailCode());
    this.a.j = paramDownloaderTask.getRealSaveName();
    this.a.b(paramDownloaderTask.getFailCode());
    this.a.i = 0L;
    this.a.h = 0L;
    this.a.a(5);
    this.a.a(102, paramDownloaderTask);
    if ((paramDownloaderTask.getFailCode() == -72) && (this.b > 0))
    {
      r.c("_DownloadInfo", "failed code = -72,redownload mRetryCounter = " + this.b);
      this.b -= 1;
      this.a.f();
      this.a.c();
    }
  }
  
  public void onTaskPausedMainloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskPausedMainloop");
  }
  
  public void onTaskPausedSubloop(DownloaderTask paramDownloaderTask)
  {
    boolean bool = paramDownloaderTask.isPausedOnMobile();
    r.b("_DownloadInfo", "halleyTest onTaskPausedSubloop pauseType=" + bool + ",mIsPausedByMoble=" + this.a.H);
    this.a.a(3);
    if (this.a.H) {
      paramDownloaderTask.setApkId("BY_MOBILE");
    }
    for (;;)
    {
      this.a.a(101, paramDownloaderTask);
      return;
      paramDownloaderTask.setApkId("BY_MAUAL");
    }
  }
  
  public void onTaskPendingMainloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskPendingMainloop");
  }
  
  public void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (paramDownloaderTask != null)
    {
      long l = paramDownloaderTask.getReceivedLength();
      if (l != this.a.h) {
        this.a.b(l);
      }
    }
  }
  
  public void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskReceivedSubloop failCode=" + paramDownloaderTask.getFailCode());
    r.c("_DownloadInfo", "halleyTest onTaskReceivedSubloop mReceivedBytes =" + this.a.h);
    r.c("_DownloadInfo", "halleyTest onTaskReceivedSubloop receivedLength=" + paramDownloaderTask.getReceivedLength());
  }
  
  public void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskStartedMainloop");
  }
  
  public void onTaskStartedSubloop(DownloaderTask paramDownloaderTask)
  {
    r.c("_DownloadInfo", "halleyTest onTaskStartedSubloop saveFileName = " + paramDownloaderTask.getRealSaveName());
    r.c("_DownloadInfo", "halleyTest onTaskStartedSubloop percent=" + paramDownloaderTask.getPercentage() + ",receivedBytes=" + paramDownloaderTask.getReceivedLength());
    if (paramDownloaderTask.getPercentage() == 0) {
      this.a.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.d
 * JD-Core Version:    0.7.0.1
 */