package com.tencent.mobileqq.troop.troopnotification.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationConfigProcessor
  extends IQConfigProcessor<TroopNotificationConfig>
{
  @NonNull
  public TroopNotificationConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopNotificationConfigProcessor.config", 2, localStringBuilder.toString());
    return new TroopNotificationConfig();
  }
  
  @Nullable
  public TroopNotificationConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopNotificationConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TroopNotificationConfig paramTroopNotificationConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdate, newConf = ");
    localStringBuilder.append(paramTroopNotificationConfig);
    QLog.d("TroopNotificationConfigProcessor.config", 1, localStringBuilder.toString());
  }
  
  public Class<TroopNotificationConfig> clazz()
  {
    return TroopNotificationConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopNotificationConfigProcessor.config", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 634;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfigProcessor
 * JD-Core Version:    0.7.0.1
 */