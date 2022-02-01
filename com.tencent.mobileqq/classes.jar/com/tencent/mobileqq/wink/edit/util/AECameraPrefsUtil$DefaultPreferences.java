package com.tencent.mobileqq.wink.edit.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.wink.QQWinkEnvironment;

class AECameraPrefsUtil$DefaultPreferences
{
  private static final SharedPreferences a = QQWinkEnvironment.a().getSharedPreferences("wink_short_video_ptu_template_sdk_sp", 0);
  
  static void a(@NonNull String paramString)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  @Nullable
  static String b(@NonNull String paramString1, String paramString2)
  {
    return a.getString(paramString1, paramString2);
  }
  
  static boolean b(@NonNull String paramString, boolean paramBoolean)
  {
    return a.getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil.DefaultPreferences
 * JD-Core Version:    0.7.0.1
 */