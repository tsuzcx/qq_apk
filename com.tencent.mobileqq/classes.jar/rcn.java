import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class rcn
{
  private static final String a = anzj.a(2131719074);
  private static final String b = anzj.a(2131719077);
  private static final String c = anzj.a(2131719075);
  private static final String d = anzj.a(2131719073);
  private static final String e = anzj.a(2131719076);
  
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
 * Qualified Name:     rcn
 * JD-Core Version:    0.7.0.1
 */