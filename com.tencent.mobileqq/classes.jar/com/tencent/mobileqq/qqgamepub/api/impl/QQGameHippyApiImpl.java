package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.hippy.module.QQGameApIProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;

public class QQGameHippyApiImpl
  implements IQQGameHippyApi
{
  private static final String TAG = "QQGamePub_QQGameHippyApiImpl";
  public static volatile boolean isGetHippysManagerConfig = false;
  public static volatile boolean isPreloadHippy = false;
  public static volatile boolean isReadyToPreloadHippy = false;
  
  public HippyAPIProvider getQQGameHippyAPIProvider()
  {
    return new QQGameApIProvider();
  }
  
  public void preloadNewQQGamePaHippy()
  {
    QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "<<<<<<<<<<<<<<preloadNewQQGamePaHippy<<<<<<<<<<<<<<<<");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGetHippysManagerConfig=");
      localStringBuilder.append(isGetHippysManagerConfig);
      localStringBuilder.append(" isReadyToPreloadHippy=");
      localStringBuilder.append(isReadyToPreloadHippy);
      localStringBuilder.append(" isPreloadHippy=");
      localStringBuilder.append(isPreloadHippy);
      QLog.d("QQGamePub_QQGameHippyApiImpl", 1, localStringBuilder.toString());
    }
    if (isGetHippysManagerConfig)
    {
      if (!isReadyToPreloadHippy) {
        return;
      }
      if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch())
      {
        QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "can not preload hippy engine because hippy switch is close");
        return;
      }
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPreloadSwitch())
      {
        QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "can not preload hippy engine because preload switch is close");
        return;
      }
      if (isPreloadHippy) {
        return;
      }
      isPreloadHippy = true;
      ThreadManagerV2.excute(new QQGameHippyApiImpl.1(this), 64, null, true);
    }
  }
  
  public void setGetHippysManagerConfig(boolean paramBoolean)
  {
    isGetHippysManagerConfig = paramBoolean;
  }
  
  public void setReadyToPreloadHippy(boolean paramBoolean)
  {
    isReadyToPreloadHippy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */