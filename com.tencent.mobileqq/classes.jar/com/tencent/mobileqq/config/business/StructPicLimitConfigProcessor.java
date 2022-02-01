package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class StructPicLimitConfigProcessor
  extends IQConfigProcessor<StructPicLimitDataBean>
{
  public static StructPicLimitDataBean a()
  {
    return (StructPicLimitDataBean)QConfigManager.a().a(724);
  }
  
  @NonNull
  public StructPicLimitDataBean a(int paramInt)
  {
    return new StructPicLimitDataBean();
  }
  
  @Nullable
  public StructPicLimitDataBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("StructPicLimitConfigProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      localStructPicLimitDataBean = StructPicLimitDataBean.a(paramArrayOfQConfItem[0].a);
      localObject = localStructPicLimitDataBean;
      if (QLog.isColorLevel())
      {
        QLog.d("StructPicLimitConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
        localObject = localStructPicLimitDataBean;
      }
    }
    while (!QLog.isColorLevel())
    {
      StructPicLimitDataBean localStructPicLimitDataBean;
      return localObject;
    }
    QLog.d("StructPicLimitConfigProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(StructPicLimitDataBean paramStructPicLimitDataBean)
  {
    QLog.i("StructPicLimitConfigProcessor", 1, "[onUpdate]");
  }
  
  public Class<StructPicLimitDataBean> clazz()
  {
    return StructPicLimitDataBean.class;
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
    QLog.i("StructPicLimitConfigProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 724;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor
 * JD-Core Version:    0.7.0.1
 */