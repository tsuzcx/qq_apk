package com.tencent.mobileqq.kandian.repo.biu;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

public class BiuBehaviour
{
  public static int a()
  {
    return ((Integer)RIJSPUtils.b("sp_key_biu_button_click_behaviour", Integer.valueOf(0))).intValue();
  }
  
  public static int b()
  {
    return ((Integer)RIJSPUtils.b("sp_key_biu_button_long_click_behaviour", Integer.valueOf(1))).intValue();
  }
  
  public static void c()
  {
    RIJSPUtils.a("sp_key_biu_long_click_tips_count", Integer.valueOf(((Integer)RIJSPUtils.b("sp_key_biu_long_click_tips_count", Integer.valueOf(0))).intValue() + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour
 * JD-Core Version:    0.7.0.1
 */