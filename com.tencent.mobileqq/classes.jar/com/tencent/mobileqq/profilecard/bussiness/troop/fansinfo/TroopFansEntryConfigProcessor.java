package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class TroopFansEntryConfigProcessor
  extends IQConfigProcessor<TroopFansEntryConfig>
{
  public static final int CONFIG_ID = 701;
  private static final String TAG = "TroopFansEntryConfigProcessor";
  
  public Class<TroopFansEntryConfig> clazz()
  {
    return TroopFansEntryConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  @NonNull
  public TroopFansEntryConfig migrateOldOrDefaultContent(int paramInt)
  {
    QLog.d("TroopFansEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new TroopFansEntryConfig();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public TroopFansEntryConfig onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopFansEntryConfig.parse(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopFansEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void onUpdate(TroopFansEntryConfig paramTroopFansEntryConfig) {}
  
  public int type()
  {
    return 701;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */