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
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = PreferenceManager.getDefaultSharedPreferencesName(paramContext);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = ((StringBuilder)localObject).toString();
    }
    return a(paramContext, (String)localObject, paramString1, paramString2, paramObject);
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
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
      if ((paramObject.getClass() != Integer.TYPE) && (paramObject.getClass() != Integer.class))
      {
        if (paramObject.getClass() == String.class) {
          paramContext = paramContext.getString(paramString1, (String)paramObject);
        } else if ((paramObject.getClass() != Boolean.TYPE) && (paramObject.getClass() != Boolean.class))
        {
          if ((paramObject.getClass() != Float.TYPE) && (paramObject.getClass() != Float.class))
          {
            if ((paramObject.getClass() != Long.TYPE) && (paramObject.getClass() != Long.class)) {
              break label251;
            }
            paramContext = Long.valueOf(paramContext.getLong(paramString1, ((Long)paramObject).longValue()));
          }
          else
          {
            paramContext = Float.valueOf(paramContext.getFloat(paramString1, ((Float)paramObject).floatValue()));
          }
        }
        else {
          paramContext = Boolean.valueOf(paramContext.getBoolean(paramString1, ((Boolean)paramObject).booleanValue()));
        }
      }
      else {
        paramContext = Integer.valueOf(paramContext.getInt(paramString1, ((Integer)paramObject).intValue()));
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("SharedPreUtil", 1, paramContext, new Object[0]);
    }
    label251:
    return paramObject;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Object paramObject)
  {
    a(paramContext, paramString1, paramString2, paramBoolean, paramString3, paramObject, 0);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, Object paramObject, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, paramInt).edit();
    try
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
      if ((paramObject.getClass() != Integer.TYPE) && (paramObject.getClass() != Integer.class))
      {
        if (paramObject.getClass() == String.class) {
          paramContext.putString(paramString1, (String)paramObject);
        } else if ((paramObject.getClass() != Boolean.TYPE) && (paramObject.getClass() != Boolean.class))
        {
          if ((paramObject.getClass() != Float.TYPE) && (paramObject.getClass() != Float.class))
          {
            if ((paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class)) {
              paramContext.putLong(paramString1, ((Long)paramObject).longValue());
            }
          }
          else {
            paramContext.putFloat(paramString1, ((Float)paramObject).floatValue());
          }
        }
        else {
          paramContext.putBoolean(paramString1, ((Boolean)paramObject).booleanValue());
        }
      }
      else {
        paramContext.putInt(paramString1, ((Integer)paramObject).intValue());
      }
      if (paramBoolean)
      {
        paramContext.apply();
        return;
      }
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("SharedPreUtil", 1, paramContext, new Object[0]);
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, Object paramObject)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = PreferenceManager.getDefaultSharedPreferencesName(paramContext);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = ((StringBuilder)localObject).toString();
    }
    a(paramContext, (String)localObject, paramString1, paramBoolean, paramString2, paramObject);
  }
  
  public static <T> T b(Context paramContext, String paramString1, String paramString2, T paramT)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = PreferenceManager.getDefaultSharedPreferencesName(paramContext);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = ((StringBuilder)localObject).toString();
    }
    return a(paramContext, (String)localObject, paramString1, paramString2, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */