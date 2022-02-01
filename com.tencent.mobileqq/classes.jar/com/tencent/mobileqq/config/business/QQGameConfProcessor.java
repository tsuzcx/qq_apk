package com.tencent.mobileqq.config.business;

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
    return (QQGameConfBean)QConfigManager.a().a(441);
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
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
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
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramQQGameConfBean.toString());
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
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGameConfProcessor
 * JD-Core Version:    0.7.0.1
 */