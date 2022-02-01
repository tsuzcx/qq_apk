package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJWebPreloadAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(276);
  
  public static boolean a()
  {
    return a.getIntegerFromString("supportPreloadWebProcess", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJWebPreloadAladdinConfig
 * JD-Core Version:    0.7.0.1
 */