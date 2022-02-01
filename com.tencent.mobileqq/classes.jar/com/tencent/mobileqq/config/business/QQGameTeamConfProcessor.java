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
    QQGameTeamConfBean localQQGameTeamConfBean2;
    try
    {
      QQGameTeamConfBean localQQGameTeamConfBean1 = (QQGameTeamConfBean)QConfigManager.b().b(720);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameTeamConfProcessor", 1, localThrowable, new Object[0]);
      localQQGameTeamConfBean2 = null;
    }
    if (localQQGameTeamConfBean2 != null) {
      return localQQGameTeamConfBean2;
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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = QQGameTeamConfBean.a(paramArrayOfQConfItem);
    } else {
      paramArrayOfQConfItem = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed:");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.d("QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
    return paramArrayOfQConfItem;
  }
  
  public void a(QQGameTeamConfBean paramQQGameTeamConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQGameTeamConfBean);
      QLog.d("QQGameTeamConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 720;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGameTeamConfProcessor
 * JD-Core Version:    0.7.0.1
 */