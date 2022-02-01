package com.tencent.mobileqq.qqsec.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

public class FrozenKickUtils
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqsec.api.FrozenKickUtils
 * JD-Core Version:    0.7.0.1
 */