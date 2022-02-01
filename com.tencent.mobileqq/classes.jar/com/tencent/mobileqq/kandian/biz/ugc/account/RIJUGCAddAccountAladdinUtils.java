package com.tencent.mobileqq.kandian.biz.ugc.account;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.HardCodeUtil;

public class RIJUGCAddAccountAladdinUtils
{
  private static final String a = HardCodeUtil.a(2131917714);
  private static final String b = HardCodeUtil.a(2131917717);
  private static final String c = HardCodeUtil.a(2131917715);
  private static final String d = HardCodeUtil.a(2131917713);
  private static final String e = HardCodeUtil.a(2131917716);
  
  public static String a()
  {
    return g().getString("ugc_add_account_description", a);
  }
  
  public static String b()
  {
    return g().getString("ugc_add_account_use_original_account_button_description", b);
  }
  
  public static String c()
  {
    return g().getString("ugc_add_account_edit_account_button_description", c);
  }
  
  public static String d()
  {
    return g().getString("ugc_add_account_complete_toast_wording", d);
  }
  
  public static String e()
  {
    return g().getString("ugc_add_account_tips_wording", e);
  }
  
  public static int f()
  {
    return g().getIntegerFromString("ugc_add_account_tips_show_time", 2);
  }
  
  private static AladdinConfig g()
  {
    return Aladdin.getConfig(303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountAladdinUtils
 * JD-Core Version:    0.7.0.1
 */