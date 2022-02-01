package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class WVWhiteListConfProcessor
  extends IQConfigProcessor<WVWhiteListConfBean>
{
  @NonNull
  public WVWhiteListConfBean a(int paramInt)
  {
    return new WVWhiteListConfBean();
  }
  
  @Nullable
  public WVWhiteListConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      WVWhiteListConfBean localWVWhiteListConfBean = WVWhiteListConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfQConfItem[0].a);
      }
      return localWVWhiteListConfBean;
    }
    return null;
  }
  
  public void a(WVWhiteListConfBean paramWVWhiteListConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramWVWhiteListConfBean.toString());
    }
  }
  
  public Class<WVWhiteListConfBean> clazz()
  {
    return WVWhiteListConfBean.class;
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
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVWhiteListConfProcessor
 * JD-Core Version:    0.7.0.1
 */