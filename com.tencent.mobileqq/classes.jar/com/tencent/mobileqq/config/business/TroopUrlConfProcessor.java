package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TroopUrlConfProcessor
  extends IQConfigProcessor<TroopUrlConfBean>
{
  @NonNull
  public static TroopUrlConfBean a()
  {
    TroopUrlConfBean localTroopUrlConfBean2 = (TroopUrlConfBean)QConfigManager.a().a(435);
    TroopUrlConfBean localTroopUrlConfBean1 = localTroopUrlConfBean2;
    if (localTroopUrlConfBean2 == null) {
      localTroopUrlConfBean1 = new TroopUrlConfBean();
    }
    return localTroopUrlConfBean1;
  }
  
  @NonNull
  public TroopUrlConfBean a(int paramInt)
  {
    return new TroopUrlConfBean();
  }
  
  @Nullable
  public TroopUrlConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = TroopUrlConfBean.a(paramArrayOfQConfItem);
      }
    }
    return localObject1;
  }
  
  public void a(TroopUrlConfBean paramTroopUrlConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramTroopUrlConfBean.toString());
    }
  }
  
  public Class<TroopUrlConfBean> clazz()
  {
    return TroopUrlConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopUrlConfProcessor
 * JD-Core Version:    0.7.0.1
 */