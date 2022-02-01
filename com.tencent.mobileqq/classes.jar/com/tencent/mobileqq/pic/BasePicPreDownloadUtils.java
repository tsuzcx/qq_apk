package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class BasePicPreDownloadUtils
{
  static SharedPreferences a = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
  static SharedPreferences.Editor b = a.edit();
  
  public static int a()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i == 1) {
      return 0;
    }
    if (i == 2) {}
    do
    {
      return 3;
      if (i == 3) {
        return 2;
      }
    } while (i != 4);
    return 1;
  }
  
  public static Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(a.getBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a.getString(paramString1, paramString2);
  }
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong)
  {
    a(paramString, paramLong, true);
  }
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong, boolean paramBoolean)
  {
    b.putLong(paramString, paramLong);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        b.apply();
        return;
      }
      b.commit();
    }
  }
  
  @TargetApi(9)
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    b.putString(paramString1, paramString2);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        b.apply();
        return;
      }
      b.commit();
    }
  }
  
  @TargetApi(9)
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    b.putBoolean(paramString, paramBoolean1);
    if (paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        b.apply();
        return;
      }
      b.commit();
    }
  }
  
  public static long b(String paramString, long paramLong)
  {
    return a.getLong(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicPreDownloadUtils
 * JD-Core Version:    0.7.0.1
 */