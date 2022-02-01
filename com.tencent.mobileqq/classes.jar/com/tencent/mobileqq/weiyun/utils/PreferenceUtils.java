package com.tencent.mobileqq.weiyun.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PreferenceUtils
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_gray_enable");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).getString(a(paramString1, paramString2), null);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(Iterator<String> paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (paramIterator.hasNext())
    {
      String str = (String)paramIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        if (i == 0)
        {
          localStringBuffer.append(str);
        }
        else
        {
          localStringBuffer.append(":");
          localStringBuffer.append(str);
        }
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static List<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString != null) && (paramString.length > 0))
    {
      ArrayList localArrayList = new ArrayList(paramString.length);
      Collections.addAll(localArrayList, paramString);
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_gray_enable");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("mini_app_weiyun_entry_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).edit().putString(a(paramString1, paramString2), paramString3).commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).getString(a(paramString1, paramString2), null);
    if (paramContext == null) {
      return paramBoolean;
    }
    return Boolean.valueOf(paramContext).booleanValue();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_apkg_url");
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).edit().remove(a(paramString1, paramString2)).commit();
  }
  
  public static int c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_version");
    return paramContext.getInt(localStringBuilder.toString(), 23);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("weiyun_mini_app_apkg_url");
    paramContext.putString(localStringBuilder.toString(), paramString1);
    paramContext.apply();
  }
  
  public static int d(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("mini_app_weiyun_entry_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.PreferenceUtils
 * JD-Core Version:    0.7.0.1
 */