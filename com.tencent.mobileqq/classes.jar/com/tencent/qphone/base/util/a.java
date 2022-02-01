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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool5 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if ((!bool5) && (((String)localObject).toLowerCase().contains("xiaomi")))
    {
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_in_normal", -1) == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      bool1 = bool2;
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_on", -1) > 4) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      bool1 = bool3;
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_on", -1) == 5) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool4;
    if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_when_ringing", -1) == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean d()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.a
 * JD-Core Version:    0.7.0.1
 */