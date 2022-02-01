package com.tencent.tmdownloader.internal.downloadservice;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.tmassistant.st.b;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;

class d
  implements DownloaderTaskListener
{
  private int b = 2;
  
  d(c paramc) {}
  
  public void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    ab.c("_DownloadInfo", "halleyTest onTaskCompletedMainloop");
  }
  
  public void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask)
  {
    this.a.j = paramDownloaderTask.getRealSaveName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("halleyTest onTaskCompletedSubloop saveFileName = ");
    ((StringBuilder)localObject).append(paramDownloaderTask.getRealSaveName());
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    this.a.b(paramDownloaderTask.getReceivedLength());
    localObject = this.a;
    ((c)localObject).l = 0;
    ((c)localObject).a(4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("halleyTest onTaskCompletedSubloop mReceivedBytes=");
    ((StringBuilder)localObject).append(this.a.h);
    ((StringBuilder)localObject).append(",totalSize=");
    ((StringBuilder)localObject).append(this.a.i);
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    this.a.a(103, paramDownloaderTask);
    b.a().a(this.a, paramDownloaderTask);
    DownloadTaskNotifier.get().notify(c.a(this.a, paramDownloaderTask), 4);
  }
  
  public void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask)
  {
    this.a.j = paramDownloaderTask.getRealSaveName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskDetectedSubloop saveFileName = ");
    localStringBuilder.append(paramDownloaderTask.getRealSaveName());
    ab.c("_DownloadInfo", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskDetectedSubloop percent=");
    localStringBuilder.append(paramDownloaderTask.getPercentage());
    localStringBuilder.append(",receivedBytes=");
    localStringBuilder.append(paramDownloaderTask.getReceivedLength());
    ab.c("_DownloadInfo", localStringBuilder.toString());
    this.a.a(paramDownloaderTask.getTotalLength());
    if ((paramDownloaderTask.getPercentage() == 0) && (paramDownloaderTask.getReceivedLength() == 0L)) {
      this.a.a(2);
    }
  }
  
  public void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    ab.c("_DownloadInfo", "halleyTest onTaskFailedMainloop");
  }
  
  public void onTaskFailedSubloop(DownloaderTask paramDownloaderTask)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("halleyTest onTaskFailedSubloop failCode=");
    ((StringBuilder)localObject).append(paramDownloaderTask.getFailCode());
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    this.a.j = paramDownloaderTask.getRealSaveName();
    this.a.b(paramDownloaderTask.getFailCode());
    localObject = this.a;
    ((c)localObject).i = 0L;
    ((c)localObject).h = 0L;
    ((c)localObject).a(5);
    this.a.a(102, paramDownloaderTask);
    if ((paramDownloaderTask.getFailCode() == -72) && (this.b > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed code = -72,redownload mRetryCounter = ");
      ((StringBuilder)localObject).append(this.b);
      ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
      this.b -= 1;
      this.a.f();
      this.a.c();
    }
    DownloadTaskNotifier.get().notify(c.a(this.a, paramDownloaderTask), 3);
  }
  
  public void onTaskPausedMainloop(DownloaderTask paramDownloaderTask)
  {
    ab.c("_DownloadInfo", "halleyTest onTaskPausedMainloop");
  }
  
  public void onTaskPausedSubloop(DownloaderTask paramDownloaderTask)
  {
    boolean bool = paramDownloaderTask.isPausedOnMobile();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskPausedSubloop pauseType=");
    localStringBuilder.append(bool);
    localStringBuilder.append(",mIsPausedByMoble=");
    localStringBuilder.append(this.a.G);
    ab.b("_DownloadInfo", localStringBuilder.toString());
    this.a.a(3);
    if (this.a.G) {
      paramDownloaderTask.setApkId("BY_MOBILE");
    } else {
      paramDownloaderTask.setApkId("BY_MAUAL");
    }
    this.a.a(101, paramDownloaderTask);
    DownloadTaskNotifier.get().notify(c.a(this.a, paramDownloaderTask), 2);
  }
  
  public void onTaskPendingMainloop(DownloaderTask paramDownloaderTask)
  {
    ab.c("_DownloadInfo", "halleyTest onTaskPendingMainloop");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskReceivedSubloop failCode=");
    localStringBuilder.append(paramDownloaderTask.getFailCode());
    ab.c("_DownloadInfo", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskReceivedSubloop mReceivedBytes =");
    localStringBuilder.append(this.a.h);
    ab.c("_DownloadInfo", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskReceivedSubloop receivedLength=");
    localStringBuilder.append(paramDownloaderTask.getReceivedLength());
    ab.c("_DownloadInfo", localStringBuilder.toString());
  }
  
  public void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    ab.c("_DownloadInfo", "halleyTest onTaskStartedMainloop");
  }
  
  public void onTaskStartedSubloop(DownloaderTask paramDownloaderTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskStartedSubloop saveFileName = ");
    localStringBuilder.append(paramDownloaderTask.getRealSaveName());
    ab.c("_DownloadInfo", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleyTest onTaskStartedSubloop percent=");
    localStringBuilder.append(paramDownloaderTask.getPercentage());
    localStringBuilder.append(",receivedBytes=");
    localStringBuilder.append(paramDownloaderTask.getReceivedLength());
    ab.c("_DownloadInfo", localStringBuilder.toString());
    if (paramDownloaderTask.getPercentage() == 0) {
      this.a.a(2);
    }
    DownloadTaskNotifier.get().notify(c.a(this.a, paramDownloaderTask), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.d
 * JD-Core Version:    0.7.0.1
 */