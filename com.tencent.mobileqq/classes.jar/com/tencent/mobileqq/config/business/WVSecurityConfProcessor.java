package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class WVSecurityConfProcessor
  extends IQConfigProcessor<WVSecurityConfBean>
{
  @NonNull
  public WVSecurityConfBean a(int paramInt)
  {
    return new WVSecurityConfBean();
  }
  
  @Nullable
  public WVSecurityConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      WVSecurityConfBean localWVSecurityConfBean = WVSecurityConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("WVSecurityConfProcessor", 2, localStringBuilder.toString());
      }
      return localWVSecurityConfBean;
    }
    return null;
  }
  
  public void a(WVSecurityConfBean paramWVSecurityConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramWVSecurityConfBean.toString());
      QLog.d("WVSecurityConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<WVSecurityConfBean> clazz()
  {
    return WVSecurityConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVSecurityConfProcessor
 * JD-Core Version:    0.7.0.1
 */