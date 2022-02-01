package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils
{
  private static final String m_str_key_x = "c_profile_sharepreference";
  
  public static String get(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("c_profile_sharepreference", 4).getString(paramString, "");
    }
    return "";
  }
  
  public static void remove(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 4).edit();
      paramContext.remove(paramString);
      paramContext.commit();
    }
  }
  
  private static void save(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 4).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void set(Context paramContext, String paramString1, String paramString2)
  {
    save(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SharePreferenceUtils
 * JD-Core Version:    0.7.0.1
 */