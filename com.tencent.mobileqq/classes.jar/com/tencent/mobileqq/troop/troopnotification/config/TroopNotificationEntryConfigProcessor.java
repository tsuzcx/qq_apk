package com.tencent.mobileqq.troop.troopnotification.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopNotificationEntryConfigProcessor
  extends IQConfigProcessor<TroopNotificationEntryConfig>
{
  @NonNull
  public TroopNotificationEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopNotificationEntryConfigProcessor", 2, localStringBuilder.toString());
    return new TroopNotificationEntryConfig();
  }
  
  @Nullable
  public TroopNotificationEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopNotificationEntryConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdate, newConf = ");
    ((StringBuilder)localObject).append(paramTroopNotificationEntryConfig);
    QLog.d("TroopNotificationEntryConfigProcessor", 1, ((StringBuilder)localObject).toString());
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
      if (localObject != null) {
        ((ITroopNotificationService)localObject).notifyNotificationShowNewEntryConfigUpdate(paramTroopNotificationEntryConfig);
      }
    }
  }
  
  public Class<TroopNotificationEntryConfig> clazz()
  {
    return TroopNotificationEntryConfig.class;
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
    QLog.d("TroopNotificationEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 691;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */