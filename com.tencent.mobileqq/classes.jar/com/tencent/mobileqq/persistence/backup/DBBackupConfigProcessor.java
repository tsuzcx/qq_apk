package com.tencent.mobileqq.persistence.backup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class DBBackupConfigProcessor
  extends IQConfigProcessor<DBBackupConfigProcessor.Config>
{
  public static DBBackupConfigProcessor.Config a()
  {
    DBBackupConfigProcessor.Config localConfig = (DBBackupConfigProcessor.Config)QConfigManager.b().b(769);
    if (localConfig != null) {
      return localConfig;
    }
    return new DBBackupConfigProcessor.Config();
  }
  
  @NonNull
  public DBBackupConfigProcessor.Config a(int paramInt)
  {
    return new DBBackupConfigProcessor.Config();
  }
  
  @Nullable
  public DBBackupConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    DBBackupConfigProcessor.Config localConfig = new DBBackupConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      DBBackupConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].b);
    }
    return localConfig;
  }
  
  public void a(DBBackupConfigProcessor.Config paramConfig) {}
  
  public Class<DBBackupConfigProcessor.Config> clazz()
  {
    return DBBackupConfigProcessor.Config.class;
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
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 769;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor
 * JD-Core Version:    0.7.0.1
 */