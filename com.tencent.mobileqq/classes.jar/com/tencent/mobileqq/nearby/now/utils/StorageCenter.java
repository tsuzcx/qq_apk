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
  
  public static void a(Context paramContext, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqNearbyNowUtilsStorageCenter.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy(paramString, 0);
    jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StorageCenter
 * JD-Core Version:    0.7.0.1
 */