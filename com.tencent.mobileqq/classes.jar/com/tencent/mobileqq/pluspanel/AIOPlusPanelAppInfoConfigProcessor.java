package com.tencent.mobileqq.pluspanel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class AIOPlusPanelAppInfoConfigProcessor
  extends IQConfigProcessor<AIOPlusPanelAppInfoConfigProcessor.Config>
{
  private int a;
  
  public AIOPlusPanelAppInfoConfigProcessor() {}
  
  public AIOPlusPanelAppInfoConfigProcessor(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected int a()
  {
    return this.a;
  }
  
  @NonNull
  public AIOPlusPanelAppInfoConfigProcessor.Config a(int paramInt)
  {
    return new AIOPlusPanelAppInfoConfigProcessor.Config();
  }
  
  @Nullable
  public AIOPlusPanelAppInfoConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    AIOPlusPanelAppInfoConfigProcessor.Config localConfig = new AIOPlusPanelAppInfoConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      AIOPlusPanelAppInfoConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].a);
    }
    return localConfig;
  }
  
  public void a(AIOPlusPanelAppInfoConfigProcessor.Config paramConfig) {}
  
  public Class<AIOPlusPanelAppInfoConfigProcessor.Config> clazz()
  {
    return AIOPlusPanelAppInfoConfigProcessor.Config.class;
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
  
  public void onProcessorConstructed(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoConfigProcessor
 * JD-Core Version:    0.7.0.1
 */