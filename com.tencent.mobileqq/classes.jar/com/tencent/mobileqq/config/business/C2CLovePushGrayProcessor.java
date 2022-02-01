package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class C2CLovePushGrayProcessor
  extends IQConfigProcessor<C2CLovePushGrayConfBean>
{
  @NonNull
  public C2CLovePushGrayConfBean a(int paramInt)
  {
    return new C2CLovePushGrayConfBean().b("0");
  }
  
  @Nullable
  public C2CLovePushGrayConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      C2CLovePushGrayConfBean localC2CLovePushGrayConfBean = C2CLovePushGrayConfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("C2CLovePushGrayProcessor", 2, localStringBuilder.toString());
      }
      return localC2CLovePushGrayConfBean;
    }
    return null;
  }
  
  public void a(C2CLovePushGrayConfBean paramC2CLovePushGrayConfBean) {}
  
  public Class<C2CLovePushGrayConfBean> clazz()
  {
    return C2CLovePushGrayConfBean.class;
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
      QLog.d("C2CLovePushGrayProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.C2CLovePushGrayProcessor
 * JD-Core Version:    0.7.0.1
 */