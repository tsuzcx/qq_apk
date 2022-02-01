package com.tencent.mobileqq.troop.blocktroop;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class TroopBlockConfigProcessor
  extends IQConfigProcessor<TroopBlockConfig>
{
  @NonNull
  public TroopBlockConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopBlockConfigProcessor", 2, localStringBuilder.toString());
    return new TroopBlockConfig();
  }
  
  @Nullable
  public TroopBlockConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopBlockConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TroopBlockConfig paramTroopBlockConfig) {}
  
  public Class<TroopBlockConfig> clazz()
  {
    return TroopBlockConfig.class;
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
    QLog.d("TroopBlockConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockConfigProcessor
 * JD-Core Version:    0.7.0.1
 */