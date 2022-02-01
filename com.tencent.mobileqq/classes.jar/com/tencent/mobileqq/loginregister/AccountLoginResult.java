package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AccountLoginResult
  extends BaseLoginResult
{
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
    }
    paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4).edit().putBoolean("login_auto" + paramString, paramBoolean).commit();
    paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.putInt(paramString, i).commit();
      return;
      i = 1;
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString)
  {
    if (!paramString.equalsIgnoreCase(paramAppRuntime.getAccount())) {
      a(BaseApplication.getContext(), paramString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.AccountLoginResult
 * JD-Core Version:    0.7.0.1
 */