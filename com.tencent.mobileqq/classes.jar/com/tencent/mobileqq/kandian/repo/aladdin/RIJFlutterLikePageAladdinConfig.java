package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJFlutterLikePageAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(459);
  
  public static boolean a()
  {
    return a.getIntegerFromString("flutter_pre_download", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJFlutterLikePageAladdinConfig
 * JD-Core Version:    0.7.0.1
 */