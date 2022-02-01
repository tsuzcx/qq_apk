import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class onn
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
    return a().getIntegerFromString("comment_and_biu_combine_switch", 0) == 1;
  }
  
  public static String b()
  {
    return a().getString("biu_editor_guide_wording", "");
  }
  
  public static boolean b()
  {
    return a().getIntegerFromString("biu_editor_checkbox_default_status", 0) == 1;
  }
  
  public static String c()
  {
    return a().getString("biu_editor_confirm_btn_wording", "");
  }
  
  public static boolean c()
  {
    return a().getIntegerFromString("biu_editor_checkbox_enable_remember", 0) == 1;
  }
  
  public static String d()
  {
    return a().getString("biu_editor_checkbox_wording", "");
  }
  
  public static boolean d()
  {
    return a().getIntegerFromString("biu_editor_checkbox_hidden", 0) == 1;
  }
  
  public static String e()
  {
    if (a()) {
      return a().getString("operate_cell_aladding_keys", "");
    }
    return "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onn
 * JD-Core Version:    0.7.0.1
 */