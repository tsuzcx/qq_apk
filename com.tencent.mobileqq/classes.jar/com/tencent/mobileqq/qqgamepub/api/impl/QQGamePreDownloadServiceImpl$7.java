package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qqgamepub.adapter.FlowControlListenerAdapter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQGamePreDownloadServiceImpl$7
  extends FlowControlListenerAdapter
{
  QQGamePreDownloadServiceImpl$7(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl) {}
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resState:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",internalTime:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).filePath = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getFilePath(paramString1, 0);
      this.a.startPreDownload((DownloadParam)localObject, new QQGamePreDownloadServiceImpl.7.1(this, paramString1, paramString2), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */