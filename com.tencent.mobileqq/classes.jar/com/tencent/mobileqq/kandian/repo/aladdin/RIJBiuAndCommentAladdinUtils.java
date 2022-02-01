package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

@Deprecated
public class RIJBiuAndCommentAladdinUtils
{
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = m();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("comment_and_biu_combine_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String b()
  {
    return m().getString("comment_guide_wording", "");
  }
  
  public static String c()
  {
    return m().getString("biu_editor_guide_wording", "");
  }
  
  public static String d()
  {
    return m().getString("biu_editor_confirm_btn_wording", "");
  }
  
  public static String e()
  {
    return m().getString("biu_editor_checkbox_wording", "");
  }
  
  public static boolean f()
  {
    AladdinConfig localAladdinConfig = m();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_default_status", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g()
  {
    AladdinConfig localAladdinConfig = m();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_enable_remember", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h()
  {
    AladdinConfig localAladdinConfig = m();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_hidden", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String i()
  {
    boolean bool = a();
    String str = "";
    if (bool) {
      str = m().getString("operate_cell_aladding_keys", "");
    }
    return str;
  }
  
  public static boolean j()
  {
    return m().getIntegerFromString("biu_feed_card_white_jump", 1) == 1;
  }
  
  public static boolean k()
  {
    return m().getIntegerFromString("biu_feed_card_gray_jump", 1) == 1;
  }
  
  public static boolean l()
  {
    return m().getIntegerFromString("biu_feed_card_btn_jump", 1) == 1;
  }
  
  private static AladdinConfig m()
  {
    return Aladdin.getConfig(278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils
 * JD-Core Version:    0.7.0.1
 */