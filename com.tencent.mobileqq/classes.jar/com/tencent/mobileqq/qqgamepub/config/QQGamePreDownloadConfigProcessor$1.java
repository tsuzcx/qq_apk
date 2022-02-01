package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qroute.QRoute;

class QQGamePreDownloadConfigProcessor$1
  implements Runnable
{
  QQGamePreDownloadConfigProcessor$1(QQGamePreDownloadConfigProcessor paramQQGamePreDownloadConfigProcessor) {}
  
  public void run()
  {
    ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).checkAndCleanExpireCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */