package com.tencent.mobileqq.qqgift.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QQGiftConfigProcessor
  extends IQConfigProcessor<QQGiftConfig>
{
  public QQGiftConfig a(int paramInt)
  {
    return new QQGiftConfig();
  }
  
  public QQGiftConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGiftConfigProcessor", 2, "onParsed");
    }
    return QQGiftConfig.a(paramArrayOfQConfItem);
  }
  
  public void a(QQGiftConfig paramQQGiftConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQGiftConfig.toString());
      QLog.d("QQGiftConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QQGiftConfig> clazz()
  {
    return QQGiftConfig.class;
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
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.config.QQGiftConfigProcessor
 * JD-Core Version:    0.7.0.1
 */