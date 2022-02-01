package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class UinSearchConfProcessor
  extends IQConfigProcessor<UinSearchConfProcessor.UinSearchConfigBean>
{
  @NonNull
  public UinSearchConfProcessor.UinSearchConfigBean a(int paramInt)
  {
    return new UinSearchConfProcessor.UinSearchConfigBean();
  }
  
  @Nullable
  public UinSearchConfProcessor.UinSearchConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      UinSearchConfProcessor.UinSearchConfigBean localUinSearchConfigBean = UinSearchConfProcessor.UinSearchConfigBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed: ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.i("UinSearchConfProcessor", 2, localStringBuilder.toString());
      }
      return localUinSearchConfigBean;
    }
    return new UinSearchConfProcessor.UinSearchConfigBean();
  }
  
  public void a(UinSearchConfProcessor.UinSearchConfigBean paramUinSearchConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<UinSearchConfProcessor.UinSearchConfigBean> clazz()
  {
    return UinSearchConfProcessor.UinSearchConfigBean.class;
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
      localStringBuilder.append("onReqFailed: ");
      localStringBuilder.append(paramInt);
      QLog.i("UinSearchConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 589;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.UinSearchConfProcessor
 * JD-Core Version:    0.7.0.1
 */