package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class ImaxAdVideoPreloadManager$4
  implements Runnable
{
  ImaxAdVideoPreloadManager$4(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */