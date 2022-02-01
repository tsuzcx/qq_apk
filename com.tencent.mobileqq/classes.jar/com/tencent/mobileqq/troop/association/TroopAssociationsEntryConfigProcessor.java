package com.tencent.mobileqq.troop.association;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopAssociationsEntryConfigProcessor
  extends IQConfigProcessor<TroopAssociationsEntryConfig>
{
  @NonNull
  public TroopAssociationsEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopAssociationsEntryConfigProcessor", 2, localStringBuilder.toString());
    return new TroopAssociationsEntryConfig();
  }
  
  @Nullable
  public TroopAssociationsEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopAssociationsEntryConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TroopAssociationsEntryConfig paramTroopAssociationsEntryConfig) {}
  
  public Class<TroopAssociationsEntryConfig> clazz()
  {
    return TroopAssociationsEntryConfig.class;
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
    QLog.d("TroopAssociationsEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 686;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */