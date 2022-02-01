package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJArticleInteractBarAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(176);
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = a;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("artical_interact_area", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    AladdinConfig localAladdinConfig = a;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("ad_relative_pos", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJArticleInteractBarAladdinConfig
 * JD-Core Version:    0.7.0.1
 */