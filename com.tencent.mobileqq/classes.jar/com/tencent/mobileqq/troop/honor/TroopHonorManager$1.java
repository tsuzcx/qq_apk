package com.tencent.mobileqq.troop.honor;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;

class TroopHonorManager$1
  implements Runnable
{
  TroopHonorManager$1(TroopHonorManager paramTroopHonorManager) {}
  
  public void run()
  {
    TroopHonorConfig localTroopHonorConfig = (TroopHonorConfig)QConfigManager.b().b(544);
    this.this$0.a(localTroopHonorConfig, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorManager.1
 * JD-Core Version:    0.7.0.1
 */