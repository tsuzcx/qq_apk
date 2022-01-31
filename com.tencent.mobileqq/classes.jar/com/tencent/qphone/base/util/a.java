package com.tencent.qphone.base.util;

import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.text.TextUtils;

public class a
{
  public static boolean a()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 0);
  }
  
  public static boolean b()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public static boolean c()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public static boolean d()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a
 * JD-Core Version:    0.7.0.1
 */