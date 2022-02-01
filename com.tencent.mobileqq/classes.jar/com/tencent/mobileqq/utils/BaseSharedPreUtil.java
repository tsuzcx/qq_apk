package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;

public class BaseSharedPreUtil
{
  public static Object a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences") {
      return a(paramContext, str, paramString1, paramString2, paramObject);
    }
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramObject, 0);
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, String paramString3, Object paramObject, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, paramInt);
    try
    {
      paramString1 = paramString3 + paramString2;
      if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class)) {
        return Integer.valueOf(paramContext.getInt(paramString1, ((Integer)paramObject).intValue()));
      }
      if (paramObject.getClass() == String.class) {
        return paramContext.getString(paramString1, (String)paramObject);
      }
      if ((paramObject.getClass() == Boolean.TYPE) || (paramObject.getClass() == Boolean.class)) {
        return Boolean.valueOf(paramContext.getBoolean(paramString1, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject.getClass() == Float.TYPE) || (paramObject.getClass() == Float.class)) {
        return Float.valueOf(paramContext.getFloat(paramString1, ((Float)paramObject).floatValue()));
      }
      if ((paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class))
      {
        long l = paramContext.getLong(paramString1, ((Long)paramObject).longValue());
        return Long.valueOf(l);
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("SharedPreUtil", 1, paramContext, new Object[0]);
    }
    return paramObject;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Object paramObject)
  {
    a(paramContext, paramString1, paramString2, paramBoolean, paramString3, paramObject, 0);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Object paramObject, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, paramInt).edit();
    for (;;)
    {
      try
      {
        paramString1 = paramString3 + paramString2;
        if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class))
        {
          paramContext.putInt(paramString1, ((Integer)paramObject).intValue());
          if (!paramBoolean) {
            break;
          }
          paramContext.apply();
          return;
        }
        if (paramObject.getClass() == String.class)
        {
          paramContext.putString(paramString1, (String)paramObject);
          continue;
        }
        if (paramObject.getClass() == Boolean.TYPE) {
          break label141;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("SharedPreUtil", 1, paramContext, new Object[0]);
        return;
      }
      if (paramObject.getClass() == Boolean.class) {
        label141:
        paramContext.putBoolean(paramString1, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject.getClass() == Float.TYPE) || (paramObject.getClass() == Float.class)) {
        paramContext.putFloat(paramString1, ((Float)paramObject).floatValue());
      } else if ((paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class)) {
        paramContext.putLong(paramString1, ((Long)paramObject).longValue());
      }
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences")
    {
      a(paramContext, str, paramString1, paramBoolean, paramString2, paramObject);
      return;
    }
  }
  
  public static <T> T b(Context paramContext, String paramString1, String paramString2, T paramT)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(paramContext);; str = paramContext.getPackageName() + "_preferences") {
      return a(paramContext, str, paramString1, paramString2, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */