package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class RIJSocialBottomViewAladdinConfig
{
  private static final AladdinConfig a = Aladdin.getConfig(154);
  
  public static boolean a()
  {
    return a.getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean b()
  {
    return a.getIntegerFromString("need_show_biu_button", 1) == 1;
  }
  
  public static boolean c()
  {
    AladdinConfig localAladdinConfig = a;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("need_show_share_button", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    return a.getIntegerFromString("is_share_sheet_show_third_lines", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig
 * JD-Core Version:    0.7.0.1
 */