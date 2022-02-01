package com.tencent.mobileqq.troop.troopMemberLevel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberLevelMapConfigProcessor
  extends IQConfigProcessor<TroopMemberLevelMapConfig>
{
  @NonNull
  public TroopMemberLevelMapConfig a(int paramInt)
  {
    QLog.d("TroopMemberLevelMapCofigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new TroopMemberLevelMapConfig();
  }
  
  @Nullable
  public TroopMemberLevelMapConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapCofigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopMemberLevelMapConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(TroopMemberLevelMapConfig paramTroopMemberLevelMapConfig) {}
  
  public Class<TroopMemberLevelMapConfig> clazz()
  {
    return TroopMemberLevelMapConfig.class;
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
    QLog.d("TroopMemberLevelMapCofigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelMapConfigProcessor
 * JD-Core Version:    0.7.0.1
 */