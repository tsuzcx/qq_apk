package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class QQGamePreDownloadServiceImpl$7$1
  extends DownloadListener
{
  QQGamePreDownloadServiceImpl$7$1(QQGamePreDownloadServiceImpl.7 param7, String paramString1, String paramString2) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoneFile...task:");
      localStringBuilder.append(paramDownloadTask);
      localStringBuilder.append(",Thread:");
      localStringBuilder.append(Thread.currentThread());
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, localStringBuilder.toString());
    }
    if ((paramDownloadTask.g != null) && (paramDownloadTask.g.containsKey(this.a)))
    {
      paramDownloadTask = (File)paramDownloadTask.g.get(this.a);
      if ((paramDownloadTask != null) && (paramDownloadTask.exists()))
      {
        paramDownloadTask = ((IArkHelper)QRoute.api(IArkHelper.class)).CopyFileToCache(this.b, paramDownloadTask.getAbsolutePath());
        ((IQQGameResService)QRoute.api(IQQGameResService.class)).saveArkResPreloadName(this.b, this.a, paramDownloadTask);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("CopyFileToCache...fileName:");
          localStringBuilder.append(paramDownloadTask);
          localStringBuilder.append(",url:");
          localStringBuilder.append(this.a);
          localStringBuilder.append(",appName:");
          localStringBuilder.append(this.b);
          QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 1, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.7.1
 * JD-Core Version:    0.7.0.1
 */