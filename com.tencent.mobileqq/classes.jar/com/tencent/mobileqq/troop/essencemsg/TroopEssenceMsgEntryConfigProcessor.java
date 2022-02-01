package com.tencent.mobileqq.troop.essencemsg;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class TroopEssenceMsgEntryConfigProcessor
  extends IQConfigProcessor<TroopEssenceMsgEntryConfig>
{
  @NonNull
  public TroopEssenceMsgEntryConfig a(int paramInt)
  {
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new TroopEssenceMsgEntryConfig();
  }
  
  @Nullable
  public TroopEssenceMsgEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopEssenceMsgEntryConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TroopEssenceMsgEntryConfig paramTroopEssenceMsgEntryConfig) {}
  
  public Class<TroopEssenceMsgEntryConfig> clazz()
  {
    return TroopEssenceMsgEntryConfig.class;
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
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 668;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */