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
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CNR setAutoLoginSharePre auto =");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SharedPreUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_auto");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
      if (!paramBoolean) {
        i = 1;
      }
      paramContext.putInt(paramString, i).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString)
  {
    if (!paramString.equalsIgnoreCase(paramAppRuntime.getAccount())) {
      a(BaseApplication.getContext(), paramString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.AccountLoginResult
 * JD-Core Version:    0.7.0.1
 */