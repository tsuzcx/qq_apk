package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qroute.QRoute;

class QQGameHelperImpl$2
  implements Runnable
{
  QQGameHelperImpl$2(QQGameHelperImpl paramQQGameHelperImpl) {}
  
  public void run()
  {
    ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).preloadFlutter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */