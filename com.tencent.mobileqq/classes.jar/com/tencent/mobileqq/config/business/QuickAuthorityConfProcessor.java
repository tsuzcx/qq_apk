package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QuickAuthorityConfProcessor
  extends IQConfigProcessor<QuickAuthorityConfBean>
{
  @NonNull
  public QuickAuthorityConfBean a(int paramInt)
  {
    return new QuickAuthorityConfBean();
  }
  
  @Nullable
  public QuickAuthorityConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      QuickAuthorityConfBean localQuickAuthorityConfBean = QuickAuthorityConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("QuickAuthorityConfProcessor", 2, localStringBuilder.toString());
      }
      return localQuickAuthorityConfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(QuickAuthorityConfBean paramQuickAuthorityConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQuickAuthorityConfBean.toString());
      QLog.d("QuickAuthorityConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QuickAuthorityConfBean> clazz()
  {
    return QuickAuthorityConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 546;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QuickAuthorityConfProcessor
 * JD-Core Version:    0.7.0.1
 */