package com.tencent.mobileqq.qqgamepub.api.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class QQGamePreDownloadServiceImpl$2
  extends AbsPreDownloadTask
{
  QQGamePreDownloadServiceImpl$2(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl, BaseQQAppInterface paramBaseQQAppInterface, String paramString, DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle)
  {
    super(paramBaseQQAppInterface, paramString);
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realCancel...url:");
      localStringBuilder.append(this.a.url);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, localStringBuilder.toString());
    }
  }
  
  protected void realStart()
  {
    this.d.startDownload(this.a, this.b, this.c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realStart...url:");
      localStringBuilder.append(this.a.url);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */