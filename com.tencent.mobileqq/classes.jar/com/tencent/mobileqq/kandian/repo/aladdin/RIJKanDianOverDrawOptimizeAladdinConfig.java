package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJKanDianOverDrawOptimizeAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(190);
  
  public static boolean a()
  {
    return a.getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianOverDrawOptimizeAladdinConfig
 * JD-Core Version:    0.7.0.1
 */