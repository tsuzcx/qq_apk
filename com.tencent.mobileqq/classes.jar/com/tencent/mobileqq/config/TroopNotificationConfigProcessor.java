package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationConfigProcessor
  extends IQConfigProcessor<TroopNotificationConfig>
{
  @NonNull
  public TroopNotificationConfig a(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new TroopNotificationConfig();
  }
  
  @Nullable
  public TroopNotificationConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopNotificationConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(TroopNotificationConfig paramTroopNotificationConfig)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onUpdate, newConf = " + paramTroopNotificationConfig);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
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
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 634;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.TroopNotificationConfigProcessor
 * JD-Core Version:    0.7.0.1
 */