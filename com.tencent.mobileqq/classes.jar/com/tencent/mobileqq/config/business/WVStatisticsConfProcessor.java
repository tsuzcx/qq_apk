package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class WVStatisticsConfProcessor
  extends IQConfigProcessor<WVStatisticsConfBean>
{
  @NonNull
  public WVStatisticsConfBean a(int paramInt)
  {
    return new WVStatisticsConfBean();
  }
  
  @Nullable
  public WVStatisticsConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      WVStatisticsConfBean localWVStatisticsConfBean = WVStatisticsConfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("WVStatisticsConfProcessor", 2, localStringBuilder.toString());
      }
      return localWVStatisticsConfBean;
    }
    return null;
  }
  
  public void a(WVStatisticsConfBean paramWVStatisticsConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramWVStatisticsConfBean.toString());
      QLog.d("WVStatisticsConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<WVStatisticsConfBean> clazz()
  {
    return WVStatisticsConfBean.class;
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
    return 361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVStatisticsConfProcessor
 * JD-Core Version:    0.7.0.1
 */