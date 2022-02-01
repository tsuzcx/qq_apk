package com.tencent.mobileqq.studyroom.download;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class DownloadTaskListenerBridge
  implements DownloaderTaskListener
{
  private IHellyEventListener a;
  
  public DownloadTaskListenerBridge(IHellyEventListener paramIHellyEventListener)
  {
    this.a = paramIHellyEventListener;
  }
  
  public void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    IHellyEventListener localIHellyEventListener = this.a;
    if (localIHellyEventListener != null) {
      localIHellyEventListener.a(paramDownloaderTask);
    }
  }
  
  public void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask)
  {
    IHellyEventListener localIHellyEventListener = this.a;
    if (localIHellyEventListener != null) {
      localIHellyEventListener.b(paramDownloaderTask);
    }
  }
  
  public void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadTaskListenerBridge.1(this, paramDownloaderTask));
  }
  
  public void onTaskFailedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPausedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPausedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPendingMainloop(DownloaderTask paramDownloaderTask)
  {
    IHellyEventListener localIHellyEventListener = this.a;
    if (localIHellyEventListener != null) {
      localIHellyEventListener.d(paramDownloaderTask);
    }
  }
  
  public void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask)
  {
    IHellyEventListener localIHellyEventListener = this.a;
    if (localIHellyEventListener != null) {
      localIHellyEventListener.f(paramDownloaderTask);
    }
  }
  
  public void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    IHellyEventListener localIHellyEventListener = this.a;
    if (localIHellyEventListener != null) {
      localIHellyEventListener.e(paramDownloaderTask);
    }
  }
  
  public void onTaskStartedSubloop(DownloaderTask paramDownloaderTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.download.DownloadTaskListenerBridge
 * JD-Core Version:    0.7.0.1
 */