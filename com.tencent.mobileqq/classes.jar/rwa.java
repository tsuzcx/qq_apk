import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class rwa
{
  private static final String a = anvx.a(2131719782);
  private static final String b = anvx.a(2131719785);
  private static final String c = anvx.a(2131719783);
  private static final String d = anvx.a(2131719781);
  private static final String e = anvx.a(2131719784);
  
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
 * Qualified Name:     rwa
 * JD-Core Version:    0.7.0.1
 */