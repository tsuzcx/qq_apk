package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qroute.QRoute;

class QQGameHelperImpl$3
  implements Runnable
{
  QQGameHelperImpl$3(QQGameHelperImpl paramQQGameHelperImpl) {}
  
  public void run()
  {
    ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).preloadFlutter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */