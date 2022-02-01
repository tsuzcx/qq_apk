package com.tencent.mobileqq.voicechange.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class VoiceChangeManagerImpl$1
  extends DownloadListener
{
  VoiceChangeManagerImpl$1(VoiceChangeManagerImpl paramVoiceChangeManagerImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject;
    if (paramDownloadTask == null)
    {
      if (this.a.mUrlList.size() > 0)
      {
        paramDownloadTask = (String)this.a.mUrlList.remove(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("picDownloadListener mUrlList.size()=");
          ((StringBuilder)localObject).append(this.a.mUrlList.size());
          ((StringBuilder)localObject).append(", url=");
          ((StringBuilder)localObject).append(paramDownloadTask);
          QLog.d("VoiceChangeManager", 2, ((StringBuilder)localObject).toString());
        }
        if (TextUtils.isEmpty(paramDownloadTask))
        {
          QLog.e("VoiceChangeManager", 1, "picDownloadListener url = null");
          onDone(null);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.VOICECHANGE_ROOT_DIR);
        ((StringBuilder)localObject).append(paramDownloadTask.substring(paramDownloadTask.lastIndexOf("/") + 1));
        File localFile = new File(((StringBuilder)localObject).toString());
        if ((localFile.isFile()) && (localFile.exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
          }
          onDone(null);
          return;
        }
        localObject = new Bundle();
        paramDownloadTask = new DownloadTask(paramDownloadTask, localFile);
        paramDownloadTask.J = true;
        ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(paramDownloadTask, this.a.picDownloadListener, (Bundle)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size() = 0");
      }
      return;
    }
    super.onDone(paramDownloadTask);
    paramDownloadTask.b();
    if ((paramDownloadTask.e() == 3) && (paramDownloadTask.c == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("picDownloadListener downloadOk task.key = ");
        ((StringBuilder)localObject).append(paramDownloadTask.b);
        QLog.d("VoiceChangeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("picDownloadListener download Error task.key = ");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      QLog.e("VoiceChangeManager", 1, ((StringBuilder)localObject).toString());
    }
    onDone(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.impl.VoiceChangeManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */