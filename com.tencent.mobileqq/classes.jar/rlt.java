import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class rlt
{
  private static final String a = anni.a(2131718924);
  private static final String b = anni.a(2131718927);
  private static final String c = anni.a(2131718925);
  private static final String d = anni.a(2131718923);
  private static final String e = anni.a(2131718926);
  
  public static int a()
  {
    return a().getIntegerFromString("ugc_add_account_tips_show_time", 2);
  }
  
  private static AladdinConfig a()
  {
    return Aladdin.getConfig(303);
  }
  
  public static String a()
  {
    return a().getString("ugc_add_account_description", a);
  }
  
  public static String b()
  {
    return a().getString("ugc_add_account_use_original_account_button_description", b);
  }
  
  public static String c()
  {
    return a().getString("ugc_add_account_edit_account_button_description", c);
  }
  
  public static String d()
  {
    return a().getString("ugc_add_account_complete_toast_wording", d);
  }
  
  public static String e()
  {
    return a().getString("ugc_add_account_tips_wording", e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlt
 * JD-Core Version:    0.7.0.1
 */