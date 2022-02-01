package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianFastWebMutualShowTypeAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(196);
  
  public static int a()
  {
    return a.getIntegerFromString("artical_interact_type", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFastWebMutualShowTypeAladdinConfig
 * JD-Core Version:    0.7.0.1
 */