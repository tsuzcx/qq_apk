package com.tencent.mobileqq.nearby.now.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class StorageCenter
{
  private static StorageCenter jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter = new StorageCenter();
  static boolean jdField_a_of_type_Boolean;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  public static float a(String paramString, float paramFloat)
  {
    try
    {
      float f = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.getFloat(paramString, paramFloat);
      return f;
    }
    catch (ClassCastException paramString) {}
    return paramFloat;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, paramInt);
      return i;
    }
    catch (ClassCastException paramString) {}
    return paramInt;
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, paramLong);
      return l;
    }
    catch (ClassCastException paramString) {}
    return paramLong;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (ClassCastException paramString1) {}
    return paramString2;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy(paramString, 0);
    jdField_a_of_type_Boolean = true;
  }
  
  public static void a(String paramString)
  {
    synchronized (jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter)
    {
      SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
  }
  
  public static void a(String paramString, float paramFloat)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.commit();
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (ClassCastException paramString) {}
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StorageCenter
 * JD-Core Version:    0.7.0.1
 */