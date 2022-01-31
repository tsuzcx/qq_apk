package com.tencent.open.adapter;

import android.app.Activity;
import android.text.TextUtils;
import bfbm;
import bfir;
import bflk;
import bflp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class OpenAppClient$GetVkeyRunnable
  implements Runnable
{
  protected int a;
  protected Activity a;
  protected String a;
  protected AppRuntime a;
  
  public OpenAppClient$GetVkeyRunnable(Activity paramActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public OpenAppClient$GetVkeyRunnable(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (!bflk.d(bfbm.a().a())) {}
    while (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    String str2 = ((TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2)).getSkey(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    String str1;
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      str1 = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin();
    }
    for (;;)
    {
      if ((str1 != null) && (!str1.equals(String.valueOf(bfbm.a().a())))) {
        bfbm.a().a(Long.valueOf(str1).longValue());
      }
      if (!TextUtils.isEmpty(str2))
      {
        bflp.b(OpenAppClient.jdField_a_of_type_JavaLangString, "Get skey success");
        bfbm.a().a(str2);
      }
      OpenAppClient.jdField_a_of_type_Boolean = false;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        bfir.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str1, str2);
        return;
        if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof BrowserAppInterface)) {
          str1 = ((BrowserAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount();
        }
        break;
      case 2: 
        bfir.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str1, str2);
        return;
        str1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.GetVkeyRunnable
 * JD-Core Version:    0.7.0.1
 */