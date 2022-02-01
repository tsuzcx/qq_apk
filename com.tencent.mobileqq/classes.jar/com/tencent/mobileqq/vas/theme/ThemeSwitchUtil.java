package com.tencent.mobileqq.vas.theme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeSwitchUtil
{
  public static Bundle a(AppRuntime paramAppRuntime)
  {
    Bundle localBundle = new Bundle();
    Object localObject = ThemeUtil.getWeekLoopTheme(paramAppRuntime);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = paramAppRuntime.getPreferences();
      paramAppRuntime = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
      localObject = ((SharedPreferences)localObject).getString("previousThemeVersion", "0");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ThemeSwitchUtil getPreviousThemeIdVersion,themeID=");
        localStringBuilder.append(paramAppRuntime);
        localStringBuilder.append(",version=");
        localStringBuilder.append((String)localObject);
        QLog.d("ThemeSwitchUtil", 2, localStringBuilder.toString());
      }
      localBundle.putString("themeID", paramAppRuntime);
      localBundle.putString("version", (String)localObject);
      return localBundle;
    }
    localBundle.putString("themeID", (String)localObject);
    localBundle.putString("version", ThemeUtil.getUserCurrentThemeVersion(paramAppRuntime));
    return localBundle;
  }
  
  public static Boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    Object localObject2 = paramAppRuntime.getAccount();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "noLogin";
    }
    localObject2 = paramAppRuntime.getApplication().getSharedPreferences((String)localObject1, 4);
    paramAppRuntime = paramAppRuntime.getAccount();
    localObject1 = ((SharedPreferences)localObject2).getString("previousThemeId", "1000");
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("previousThemeId", paramString1);
    ((SharedPreferences.Editor)localObject2).putString("previousThemeVersion", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("ThemeSwitchUtil setPreviousThemeIdVersion,uin=");
    paramString2.append(paramAppRuntime);
    paramString2.append(",oldPreviousThemeId=");
    paramString2.append((String)localObject1);
    paramString2.append(",set new themeId=");
    paramString2.append(paramString1);
    QLog.d("ThemeSwitchUtil", 1, paramString2.toString());
    return Boolean.valueOf(((SharedPreferences.Editor)localObject2).commit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeSwitchUtil
 * JD-Core Version:    0.7.0.1
 */