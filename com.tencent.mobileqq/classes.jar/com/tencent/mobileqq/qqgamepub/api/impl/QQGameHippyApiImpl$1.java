package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQGameHippyApiImpl$1
  implements Runnable
{
  QQGameHippyApiImpl$1(QQGameHippyApiImpl paramQQGameHippyApiImpl) {}
  
  public void run()
  {
    QLog.d("QQGamePub_QQGameHippyApiImpl", 1, " now start preload NewQQGamePa Hippy");
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "SGameOfficial";
    localOpenHippyInfo.isPreload = true;
    localOpenHippyInfo.processName = "main";
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(localOpenHippyInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHippyApiImpl.1
 * JD-Core Version:    0.7.0.1
 */