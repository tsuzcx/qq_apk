package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

@Deprecated
public class RIJBiuAndCommentAladdinUtils
{
  private static AladdinConfig a()
  {
    return Aladdin.getConfig(278);
  }
  
  public static String a()
  {
    return a().getString("comment_guide_wording", "");
  }
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = a();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("comment_and_biu_combine_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String b()
  {
    return a().getString("biu_editor_guide_wording", "");
  }
  
  public static boolean b()
  {
    AladdinConfig localAladdinConfig = a();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_default_status", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String c()
  {
    return a().getString("biu_editor_confirm_btn_wording", "");
  }
  
  public static boolean c()
  {
    AladdinConfig localAladdinConfig = a();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_enable_remember", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String d()
  {
    return a().getString("biu_editor_checkbox_wording", "");
  }
  
  public static boolean d()
  {
    AladdinConfig localAladdinConfig = a();
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("biu_editor_checkbox_hidden", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String e()
  {
    boolean bool = a();
    String str = "";
    if (bool) {
      str = a().getString("operate_cell_aladding_keys", "");
    }
    return str;
  }
  
  public static boolean e()
  {
    return a().getIntegerFromString("biu_feed_card_white_jump", 1) == 1;
  }
  
  public static boolean f()
  {
    return a().getIntegerFromString("biu_feed_card_gray_jump", 1) == 1;
  }
  
  public static boolean g()
  {
    return a().getIntegerFromString("biu_feed_card_btn_jump", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils
 * JD-Core Version:    0.7.0.1
 */