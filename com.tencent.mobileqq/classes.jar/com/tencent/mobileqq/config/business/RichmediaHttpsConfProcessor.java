package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class RichmediaHttpsConfProcessor
  extends IQConfigProcessor<RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean>
{
  public static RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean a()
  {
    return (RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean)QConfigManager.a().a(647);
  }
  
  @NonNull
  public RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean a(int paramInt)
  {
    return new RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean();
  }
  
  @Nullable
  public RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean paramRichmediaHttpsConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaHttpsConfProcessor", 2, "RichmediaHttpsConfProcessor onUpdate");
    }
  }
  
  public Class<RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean> clazz()
  {
    return RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean.class;
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
    return 647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor
 * JD-Core Version:    0.7.0.1
 */