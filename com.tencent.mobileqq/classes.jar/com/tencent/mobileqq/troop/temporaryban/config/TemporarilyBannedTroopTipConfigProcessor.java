package com.tencent.mobileqq.troop.temporaryban.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TemporarilyBannedTroopTipConfigProcessor
  extends IQConfigProcessor<TemporarilyBannedTroopTipsConfig>
{
  @NonNull
  public TemporarilyBannedTroopTipsConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("TemporarilyBannedTroopTipConfigPrecoess", 2, localStringBuilder.toString());
    return new TemporarilyBannedTroopTipsConfig();
  }
  
  @Nullable
  public TemporarilyBannedTroopTipsConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TemporarilyBannedTroopTipConfigPrecoess", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TemporarilyBannedTroopTipsConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TemporarilyBannedTroopTipsConfig paramTemporarilyBannedTroopTipsConfig) {}
  
  public Class<TemporarilyBannedTroopTipsConfig> clazz()
  {
    return TemporarilyBannedTroopTipsConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
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
    QLog.d("TemporarilyBannedTroopTipConfigPrecoess", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 755;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.config.TemporarilyBannedTroopTipConfigProcessor
 * JD-Core Version:    0.7.0.1
 */