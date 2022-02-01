package com.tencent.mobileqq.qqgamepub.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QQGameConfProcessor
  extends IQConfigProcessor<QQGameConfBean>
{
  public static QQGameConfBean a()
  {
    return (QQGameConfBean)QConfigManager.b().b(441);
  }
  
  @NonNull
  public QQGameConfBean a(int paramInt)
  {
    return new QQGameConfBean();
  }
  
  @Nullable
  public QQGameConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new QQGameConfBean();
      return QQGameConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQGameConfBean paramQQGameConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQGameConfBean.toString());
      QLog.d("QQGamePub_QQGameConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QQGameConfBean> clazz()
  {
    return QQGameConfBean.class;
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
      QLog.d("QQGamePub_QQGameConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGameConfProcessor
 * JD-Core Version:    0.7.0.1
 */