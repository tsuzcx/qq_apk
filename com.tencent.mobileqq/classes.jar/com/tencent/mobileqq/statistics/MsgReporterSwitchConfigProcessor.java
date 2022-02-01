package com.tencent.mobileqq.statistics;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class MsgReporterSwitchConfigProcessor
  extends IQConfigProcessor<MsgReporterSwitchConfigProcessor.Config>
{
  @NonNull
  public MsgReporterSwitchConfigProcessor.Config a(int paramInt)
  {
    return new MsgReporterSwitchConfigProcessor.Config();
  }
  
  @Nullable
  public MsgReporterSwitchConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    MsgReporterSwitchConfigProcessor.Config localConfig = new MsgReporterSwitchConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      MsgReporterSwitchConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].b);
    }
    return localConfig;
  }
  
  public void a(MsgReporterSwitchConfigProcessor.Config paramConfig) {}
  
  public Class<MsgReporterSwitchConfigProcessor.Config> clazz()
  {
    return MsgReporterSwitchConfigProcessor.Config.class;
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
    return 577;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.MsgReporterSwitchConfigProcessor
 * JD-Core Version:    0.7.0.1
 */