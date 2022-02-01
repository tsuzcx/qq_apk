package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QQGameTeamConfProcessor
  extends IQConfigProcessor<QQGameTeamConfBean>
{
  public static QQGameTeamConfBean a()
  {
    try
    {
      QQGameTeamConfBean localQQGameTeamConfBean = (QQGameTeamConfBean)QConfigManager.a().a(720);
      if (localQQGameTeamConfBean != null) {
        return localQQGameTeamConfBean;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QQGameTeamConfProcessor", 1, localThrowable, new Object[0]);
        Object localObject = null;
      }
    }
    return new QQGameTeamConfBean();
  }
  
  @NonNull
  public QQGameTeamConfBean a(int paramInt)
  {
    return new QQGameTeamConfBean();
  }
  
  @Nullable
  public QQGameTeamConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = QQGameTeamConfBean.a(paramArrayOfQConfItem);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTeamConfProcessor", 2, "onParsed:" + localObject1);
    }
    return localObject1;
  }
  
  public void a(QQGameTeamConfBean paramQQGameTeamConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTeamConfProcessor", 2, "onUpdate " + paramQQGameTeamConfBean);
    }
  }
  
  public Class<QQGameTeamConfBean> clazz()
  {
    return QQGameTeamConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTeamConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 720;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGameTeamConfProcessor
 * JD-Core Version:    0.7.0.1
 */