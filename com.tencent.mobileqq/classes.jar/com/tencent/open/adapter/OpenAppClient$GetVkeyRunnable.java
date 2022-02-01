package com.tencent.open.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
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
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramActivity instanceof BaseActivity)) {
      this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)paramActivity).getAppRuntime();
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
    if (!APNUtil.d(CommonDataAdapter.a().a())) {
      return;
    }
    String str = null;
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject == null) {
      return;
    }
    localObject = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    } else if ((localAppRuntime instanceof BrowserAppInterface)) {
      str = ((BrowserAppInterface)localAppRuntime).getAccount();
    }
    if ((str != null) && (!str.equals(String.valueOf(CommonDataAdapter.a().a())))) {
      CommonDataAdapter.a().a(Long.valueOf(str).longValue());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      LogUtility.b(OpenAppClient.jdField_a_of_type_JavaLangString, "Get skey success");
      CommonDataAdapter.a().a((String)localObject);
    }
    OpenAppClient.jdField_a_of_type_Boolean = false;
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      AppClient.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str, (String)localObject);
      return;
    }
    AppClient.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.GetVkeyRunnable
 * JD-Core Version:    0.7.0.1
 */