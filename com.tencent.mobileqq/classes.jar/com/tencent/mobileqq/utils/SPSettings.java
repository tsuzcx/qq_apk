package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

public class SPSettings
{
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_predownload_success_key", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean a()
  {
    return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_predownload_success_key", false);
  }
  
  public static int b()
  {
    return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_versioncode", 0);
  }
  
  public static void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_dialog_versioncode", paramInt);
    localEditor.apply();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_has_show_upgrade_dialog", paramBoolean);
    localEditor.apply();
  }
  
  public static void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putInt("key_normal_upgrade_version", paramInt);
    localEditor.apply();
  }
  
  public static void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
    localEditor.putBoolean("key_normal_upgrade", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean c()
  {
    return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_has_show_upgrade_dialog", false);
  }
  
  public static int d()
  {
    return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_dialog_versioncode", 0);
  }
  
  public static boolean d(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0);
    if (localSharedPreferences.getInt("key_normal_upgrade_version", 0) != paramInt) {
      return true;
    }
    return localSharedPreferences.getBoolean("key_normal_upgrade", false) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SPSettings
 * JD-Core Version:    0.7.0.1
 */