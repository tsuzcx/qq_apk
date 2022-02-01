package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TroopNotificationEntryConfigProcessor
  extends IQConfigProcessor<TroopNotificationEntryConfig>
{
  @NonNull
  public TroopNotificationEntryConfig a(int paramInt)
  {
    QLog.d("TroopNotificationEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
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
    QLog.d("TroopNotificationEntryConfigProcessor", 1, "onUpdate, newConf = " + paramTroopNotificationEntryConfig);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (TroopNotificationManager)((AppRuntime)localObject).getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (localObject != null)
      {
        QLog.d("TroopNotificationEntryConfigProcessor", 1, "call troopNotificationManager.onTroopNotificationConfigUpdate(newConf)");
        ((TroopNotificationManager)localObject).a(paramTroopNotificationEntryConfig);
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
    QLog.d("TroopNotificationEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 691;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.TroopNotificationEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */