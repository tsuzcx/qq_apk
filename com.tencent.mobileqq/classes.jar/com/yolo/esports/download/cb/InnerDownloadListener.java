package com.yolo.esports.download.cb;

import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.download.common.DownloadInfo;
import com.yolo.esports.download.common.HalleyDownloaderProxy;

public class InnerDownloadListener
  implements DownloaderTaskListener
{
  private static volatile InnerDownloadListener a;
  
  public static InnerDownloadListener a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new InnerDownloadListener();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static DownloadInfo a(DownloaderTask paramDownloaderTask)
  {
    try
    {
      localObject1 = (String)paramDownloaderTask.getTag();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("<getDownloadInfoFromHalleyTask>从Tag获取到ticket:");
        localStringBuilder1.append((String)localObject1);
        Logger.a("InnerDownloadListener", localStringBuilder1.toString());
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder2 = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = "";
    }
    StringBuilder localStringBuilder2;
    localStringBuilder2.append("<getDownloadInfoFromHalleyTask>从Tag获取ticket失败：");
    localStringBuilder2.append(localThrowable2.getMessage());
    Logger.c("InnerDownloadListener", localStringBuilder2.toString());
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = DownloadInfo.b(paramDownloaderTask.getUrl());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<getDownloadInfoFromHalleyTask>从URL获取到ticket:");
      ((StringBuilder)localObject1).append((String)localObject2);
      Logger.a("InnerDownloadListener", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("<getDownloadInfoFromHalleyTask>TaskSpeedLimit: un support,receivedLength:");
    ((StringBuilder)localObject1).append(paramDownloaderTask.getReceivedLength());
    ((StringBuilder)localObject1).append(",totalLength");
    ((StringBuilder)localObject1).append(paramDownloaderTask.getTotalLength());
    ((StringBuilder)localObject1).append(", url:");
    ((StringBuilder)localObject1).append(paramDownloaderTask.getUrl());
    Logger.a("InnerDownloadListener", ((StringBuilder)localObject1).toString());
    return HalleyDownloaderProxy.a().b((String)localObject2);
  }
  
  private void a(DownloadInfo paramDownloadInfo, DownloaderTask paramDownloaderTask)
  {
    paramDownloadInfo.j = paramDownloaderTask.getReceivedLength();
    paramDownloadInfo.k = paramDownloaderTask.getTotalLength();
    paramDownloadInfo.e = paramDownloaderTask.getSavePath();
    paramDownloadInfo.l = paramDownloaderTask.getFailCode();
    paramDownloadInfo.m = paramDownloaderTask.getFailInfo();
    paramDownloadInfo.v = paramDownloaderTask.getAverageSpeed();
    paramDownloadInfo.w = paramDownloaderTask.getRealTimeSpeed();
    if (paramDownloadInfo.q == 2)
    {
      if (System.currentTimeMillis() - paramDownloadInfo.t > 1000L)
      {
        HalleyDownloaderProxy.a().b(paramDownloadInfo);
        return;
      }
      HalleyDownloaderProxy.a().c(paramDownloadInfo);
      return;
    }
    HalleyDownloaderProxy.a().b(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    TaskCallbackCenter.a().a(paramDownloadInfo.a(), paramDownloadInfo);
  }
  
  public void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onTaskCompletedSubloop>info:");
    localStringBuilder.append(localDownloadInfo);
    Logger.a("InnerDownloadListener", localStringBuilder.toString());
    if (localDownloadInfo == null)
    {
      Logger.c("InnerDownloadListener", "<onTaskCompletedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 4;
    a(localDownloadInfo, paramDownloaderTask);
    a(localDownloadInfo);
  }
  
  public void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    if (localDownloadInfo == null)
    {
      QLog.e("InnerDownloadListener", 1, "<onTaskDetectedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 1;
    a(localDownloadInfo, paramDownloaderTask);
    TaskCallbackCenter.a().a(localDownloadInfo.a(), localDownloadInfo);
  }
  
  public void onTaskFailedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskFailedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onTaskFailedSubloop>info:");
    localStringBuilder.append(localDownloadInfo);
    Logger.a("InnerDownloadListener", localStringBuilder.toString());
    if (localDownloadInfo == null)
    {
      Logger.c("InnerDownloadListener", "<onTaskFailedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 5;
    a(localDownloadInfo, paramDownloaderTask);
    TaskCallbackCenter.a().a(localDownloadInfo.a(), localDownloadInfo);
  }
  
  public void onTaskPausedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPausedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onTaskPausedSubloop>info:");
    localStringBuilder.append(localDownloadInfo);
    Logger.a("InnerDownloadListener", localStringBuilder.toString());
    if (localDownloadInfo == null)
    {
      Logger.a("InnerDownloadListener", "<onTaskPausedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 3;
    a(localDownloadInfo, paramDownloaderTask);
    TaskCallbackCenter.a().a(localDownloadInfo.a(), localDownloadInfo);
  }
  
  public void onTaskPendingMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    if (localDownloadInfo == null)
    {
      QLog.e("InnerDownloadListener", 1, "<onTaskReceivedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 2;
    a(localDownloadInfo, paramDownloaderTask);
    TaskCallbackCenter.a().c(localDownloadInfo.a(), localDownloadInfo);
  }
  
  public void onTaskStartedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskStartedSubloop(DownloaderTask paramDownloaderTask)
  {
    DownloadInfo localDownloadInfo = a(paramDownloaderTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onTaskStartedSubloop>info:");
    localStringBuilder.append(localDownloadInfo);
    QLog.i("InnerDownloadListener", 4, localStringBuilder.toString());
    if ((localDownloadInfo != null) && ((localDownloadInfo.q == 0) || (localDownloadInfo.q == 6))) {
      TaskCallbackCenter.a().b(localDownloadInfo.a(), localDownloadInfo);
    }
    if (localDownloadInfo == null)
    {
      QLog.e("InnerDownloadListener", 1, "<onTaskStartedSubloop>task is null");
      return;
    }
    localDownloadInfo.q = 2;
    a(localDownloadInfo, paramDownloaderTask);
    TaskCallbackCenter.a().a(localDownloadInfo.a(), localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.cb.InnerDownloadListener
 * JD-Core Version:    0.7.0.1
 */