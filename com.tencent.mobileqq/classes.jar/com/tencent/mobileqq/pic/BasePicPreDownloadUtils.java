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
  static SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor = jdField_a_of_type_AndroidContentSharedPreferences.edit();
  static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
  
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
  
  public static long a(String paramString, long paramLong)
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, paramLong);
  }
  
  public static Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
  }
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong)
  {
    a(paramString, paramLong, true);
  }
  
  @TargetApi(9)
  public static void a(String paramString, long paramLong, boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramString, paramLong);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  @TargetApi(9)
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(paramString1, paramString2);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  @TargetApi(9)
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(paramString, paramBoolean1);
    if (paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicPreDownloadUtils
 * JD-Core Version:    0.7.0.1
 */