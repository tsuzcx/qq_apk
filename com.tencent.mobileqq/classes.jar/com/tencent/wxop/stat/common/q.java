package com.tencent.wxop.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class q
{
  private static SharedPreferences a = null;
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    paramString = l.a(paramContext, "wxop_" + paramString);
    return a(paramContext).getInt(paramString, paramInt);
  }
  
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    paramString = l.a(paramContext, "wxop_" + paramString);
    return a(paramContext).getLong(paramString, paramLong);
  }
  
  static SharedPreferences a(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(".mta-wxop", 0);
      a = localSharedPreferences;
      if (localSharedPreferences == null) {
        a = PreferenceManager.getDefaultSharedPreferences(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = l.a(paramContext, "wxop_" + paramString1);
    return a(paramContext).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramString = l.a(paramContext, "wxop_" + paramString);
    paramContext = a(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramString = l.a(paramContext, "wxop_" + paramString);
    paramContext = a(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = l.a(paramContext, "wxop_" + paramString1);
    paramContext = a(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.q
 * JD-Core Version:    0.7.0.1
 */