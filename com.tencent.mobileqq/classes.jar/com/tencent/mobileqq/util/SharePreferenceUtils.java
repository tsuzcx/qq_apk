package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils
{
  public static String a(Context paramContext, String paramString)
  {
    return b(paramContext, "c_profile_sharepreference", paramString);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    c(paramContext, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    b(paramContext, paramString1, paramString2, paramString3);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString1, 4).getString(paramString2, "");
    }
    return "";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 4).edit();
      paramContext.remove(paramString);
      paramContext.commit();
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      paramContext.getSharedPreferences(paramString, 4).edit().clear().commit();
    }
  }
  
  private static void c(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, "c_profile_sharepreference", paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SharePreferenceUtils
 * JD-Core Version:    0.7.0.1
 */