package com.tencent.mobileqq.troop.honor.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopHonorConfigProcessor
  extends IQConfigProcessor<TroopHonorConfig>
{
  public TroopHonorConfig a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new TroopHonorConfig();
  }
  
  public TroopHonorConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopHonorConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(TroopHonorConfig paramTroopHonorConfig)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + paramTroopHonorConfig);
    ((ITroopHonorService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopHonorService.class, "")).updateConfig(paramTroopHonorConfig, false);
  }
  
  public Class<TroopHonorConfig> clazz()
  {
    return TroopHonorConfig.class;
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
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 544;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.config.TroopHonorConfigProcessor
 * JD-Core Version:    0.7.0.1
 */