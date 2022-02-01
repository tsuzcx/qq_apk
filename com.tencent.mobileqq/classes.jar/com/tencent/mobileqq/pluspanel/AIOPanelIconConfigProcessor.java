package com.tencent.mobileqq.pluspanel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public abstract class AIOPanelIconConfigProcessor
  extends IQConfigProcessor<AIOPanelIconConfigProcessor.Config>
{
  abstract int a();
  
  @NonNull
  public AIOPanelIconConfigProcessor.Config a(int paramInt)
  {
    return new AIOPanelIconConfigProcessor.Config();
  }
  
  @Nullable
  public AIOPanelIconConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    AIOPanelIconConfigProcessor.Config localConfig = new AIOPanelIconConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      AIOPanelIconConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].b);
    }
    return localConfig;
  }
  
  public void a(AIOPanelIconConfigProcessor.Config paramConfig) {}
  
  public Class<AIOPanelIconConfigProcessor.Config> clazz()
  {
    return AIOPanelIconConfigProcessor.Config.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor
 * JD-Core Version:    0.7.0.1
 */