package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianFeedsCardStyleAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(245);
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = a;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("kandian_feeds_card_style", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsCardStyleAladdinConfig
 * JD-Core Version:    0.7.0.1
 */