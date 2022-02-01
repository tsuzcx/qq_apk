package com.tencent.mobileqq.pluspanel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class AIOPlusPanelAppInfoOrderConfigProcessor
  extends IQConfigProcessor<AIOPlusPanelAppInfoOrderConfigProcessor.Config>
{
  @NonNull
  public AIOPlusPanelAppInfoOrderConfigProcessor.Config a(int paramInt)
  {
    return new AIOPlusPanelAppInfoOrderConfigProcessor.Config();
  }
  
  @Nullable
  public AIOPlusPanelAppInfoOrderConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    AIOPlusPanelAppInfoOrderConfigProcessor.Config localConfig = new AIOPlusPanelAppInfoOrderConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      AIOPlusPanelAppInfoOrderConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].a);
    }
    return localConfig;
  }
  
  public void a(AIOPlusPanelAppInfoOrderConfigProcessor.Config paramConfig) {}
  
  public Class<AIOPlusPanelAppInfoOrderConfigProcessor.Config> clazz()
  {
    return AIOPlusPanelAppInfoOrderConfigProcessor.Config.class;
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
    return 495;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoOrderConfigProcessor
 * JD-Core Version:    0.7.0.1
 */