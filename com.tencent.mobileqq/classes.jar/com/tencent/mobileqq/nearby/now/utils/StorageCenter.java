package com.tencent.mobileqq.nearby.now.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class StorageCenter
{
  static boolean a;
  private static StorageCenter b = new StorageCenter();
  private SharedPreferences c;
  
  public static void a(Context paramContext, String paramString)
  {
    b.c = SharedPreferencesProxyManager.getInstance().getProxy(paramString, 0);
    a = true;
  }
  
  public static void a(String paramString)
  {
    synchronized (b)
    {
      SharedPreferences.Editor localEditor = b.c.edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
  }
  
  public static void a(String paramString, float paramFloat)
  {
    SharedPreferences.Editor localEditor = b.c.edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.commit();
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = b.c.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = b.c.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = b.c.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = b.c.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static float b(String paramString, float paramFloat)
  {
    try
    {
      float f = b.c.getFloat(paramString, paramFloat);
      return f;
    }
    catch (ClassCastException paramString) {}
    return paramFloat;
  }
  
  public static int b(String paramString, int paramInt)
  {
    try
    {
      int i = b.c.getInt(paramString, paramInt);
      return i;
    }
    catch (ClassCastException paramString) {}
    return paramInt;
  }
  
  public static long b(String paramString, long paramLong)
  {
    try
    {
      long l = b.c.getLong(paramString, paramLong);
      return l;
    }
    catch (ClassCastException paramString) {}
    return paramLong;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b.c.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (ClassCastException paramString1) {}
    return paramString2;
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = b.c.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (ClassCastException paramString) {}
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StorageCenter
 * JD-Core Version:    0.7.0.1
 */