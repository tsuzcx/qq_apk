package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class AbsApolloResDownloader$5
  extends DownloadListener
{
  AbsApolloResDownloader$5(AbsApolloResDownloader paramAbsApolloResDownloader, int paramInt, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (3 != paramDownloadTask.e())
    {
      localObject = this.c.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadApolloAudio error id->");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" task.getStatus()->");
      localStringBuilder.append(paramDownloadTask.e());
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, this.a);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramDownloadTask = this.c.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadApolloAudio ok id");
      ((StringBuilder)localObject).append(this.a);
      QLog.d(paramDownloadTask, 2, ((StringBuilder)localObject).toString());
    }
    paramDownloadTask = this.b;
    if (paramDownloadTask != null) {
      paramDownloadTask.a(true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.5
 * JD-Core Version:    0.7.0.1
 */