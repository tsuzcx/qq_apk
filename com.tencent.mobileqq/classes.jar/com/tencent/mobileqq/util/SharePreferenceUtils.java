package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils
{
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("c_profile_sharepreference", 0).getString(paramString, "");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 0).edit();
      paramContext.remove(paramString);
      paramContext.commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.SharePreferenceUtils
 * JD-Core Version:    0.7.0.1
 */