package com.tencent.mobileqq.troop.essence;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopEssenceMsgEntryInCardConfigProcessor
  extends IQConfigProcessor<TroopEssenceMsgEntryInCardConfig>
{
  @NonNull
  public TroopEssenceMsgEntryInCardConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopEssenceMsgEntryInCardConfigProcessor", 2, localStringBuilder.toString());
    return new TroopEssenceMsgEntryInCardConfig();
  }
  
  @Nullable
  public TroopEssenceMsgEntryInCardConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopEssenceMsgEntryInCardConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TroopEssenceMsgEntryInCardConfig paramTroopEssenceMsgEntryInCardConfig) {}
  
  public Class<TroopEssenceMsgEntryInCardConfig> clazz()
  {
    return TroopEssenceMsgEntryInCardConfig.class;
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
    QLog.d("TroopEssenceMsgEntryInCardConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 715;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.TroopEssenceMsgEntryInCardConfigProcessor
 * JD-Core Version:    0.7.0.1
 */