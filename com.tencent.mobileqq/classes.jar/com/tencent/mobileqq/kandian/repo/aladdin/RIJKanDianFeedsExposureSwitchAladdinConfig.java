package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianFeedsExposureSwitchAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(253);
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = a;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("enable_use_exposure_data", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsExposureSwitchAladdinConfig
 * JD-Core Version:    0.7.0.1
 */