package com.tencent.mobileqq.qqgamepub.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class QQGamePreloadConfProcessor
  extends IQConfigProcessor<QQGamePreloadConfBean>
{
  public static QQGamePreloadConfBean a()
  {
    return (QQGamePreloadConfBean)QConfigManager.a().a(631);
  }
  
  @NonNull
  public QQGamePreloadConfBean a(int paramInt)
  {
    return new QQGamePreloadConfBean();
  }
  
  @Nullable
  public QQGamePreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new QQGamePreloadConfBean();
      return QQGamePreloadConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQGamePreloadConfBean paramQQGamePreloadConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQGamePreloadConfBean.toString());
      QLog.d("QQGamePub_QQGamePreloadConfProcessor", 2, localStringBuilder.toString());
    }
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).setGetHippysManagerConfig(true);
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).preloadNewQQGamePaHippy();
  }
  
  public Class<QQGamePreloadConfBean> clazz()
  {
    return QQGamePreloadConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("QQGamePub_QQGamePreloadConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGamePreloadConfProcessor", 2, "onReqNoReceive");
    }
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).setGetHippysManagerConfig(true);
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).preloadNewQQGamePaHippy();
  }
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */