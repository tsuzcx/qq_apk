package com.tencent.mobileqq.qqlive.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QQLiveConfigProcessor
  extends IQConfigProcessor<QQLiveConfigBean>
{
  public static QQLiveConfigBean a()
  {
    Object localObject;
    try
    {
      QQLiveConfigBean localQQLiveConfigBean = (QQLiveConfigBean)QConfigManager.b().b(767);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGiftConfigProcessor", 1, localThrowable, new Object[0]);
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig bean:");
      localStringBuilder.append(localObject);
      QLog.i("QQGiftConfigProcessor", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
      return localObject;
    }
    return new QQLiveConfigBean();
  }
  
  public QQLiveConfigBean a(int paramInt)
  {
    return new QQLiveConfigBean();
  }
  
  public QQLiveConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGiftConfigProcessor", 2, "onParsed");
    }
    return QQLiveConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(QQLiveConfigBean paramQQLiveConfigBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQLiveConfigBean);
      QLog.d("QQGiftConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QQLiveConfigBean> clazz()
  {
    return QQLiveConfigBean.class;
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
      localStringBuilder.append("onReqFailed failCode: ");
      localStringBuilder.append(paramInt);
      QLog.d("QQGiftConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 767;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor
 * JD-Core Version:    0.7.0.1
 */