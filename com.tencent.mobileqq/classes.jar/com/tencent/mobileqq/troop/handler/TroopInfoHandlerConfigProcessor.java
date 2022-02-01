package com.tencent.mobileqq.troop.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TroopInfoHandlerConfigProcessor
  extends IQConfigProcessor<TroopInfoHandlerConfig>
{
  @NonNull
  public TroopInfoHandlerConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopInfoHandlerConfigProcessor", 2, localStringBuilder.toString());
    return new TroopInfoHandlerConfig();
  }
  
  @Nullable
  public TroopInfoHandlerConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoHandlerConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopInfoHandlerConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TroopInfoHandlerConfig paramTroopInfoHandlerConfig) {}
  
  public Class<TroopInfoHandlerConfig> clazz()
  {
    return TroopInfoHandlerConfig.class;
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
    QLog.d("TroopInfoHandlerConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfigProcessor
 * JD-Core Version:    0.7.0.1
 */