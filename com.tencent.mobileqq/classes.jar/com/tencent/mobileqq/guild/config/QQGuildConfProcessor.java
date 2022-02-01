package com.tencent.mobileqq.guild.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QQGuildConfProcessor
  extends IQConfigProcessor<QQGuildConfigBean>
{
  @NonNull
  public QQGuildConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("QQGuildConfProcessor", 2, localStringBuilder.toString());
    return new QQGuildConfigBean();
  }
  
  public QQGuildConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QQGuildConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQGuildConfigBean paramQQGuildConfigBean) {}
  
  public Class<QQGuildConfigBean> clazz()
  {
    return QQGuildConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("QQGuildConfProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 733;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildConfProcessor
 * JD-Core Version:    0.7.0.1
 */