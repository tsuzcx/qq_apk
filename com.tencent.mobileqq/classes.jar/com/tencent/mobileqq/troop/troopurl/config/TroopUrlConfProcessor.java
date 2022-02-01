package com.tencent.mobileqq.troop.troopurl.config;

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
    TroopUrlConfBean localTroopUrlConfBean2 = (TroopUrlConfBean)QConfigManager.b().b(435);
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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopUrlConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TroopUrlConfBean paramTroopUrlConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramTroopUrlConfBean.toString());
      QLog.d("TroopUrlConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("TroopUrlConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor
 * JD-Core Version:    0.7.0.1
 */