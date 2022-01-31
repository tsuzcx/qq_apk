package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FDNative
{
  private static FDNative a;
  
  private FDNative()
  {
    System.loadLibrary("qq_fd");
  }
  
  public static FDNative a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new FDNative();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext()).edit().putBoolean("FDHook", paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "setEnableHook ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public static boolean a()
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext()).getBoolean("FDHook", true);
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "getEnableHook ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static native int nativeIgnore(String paramString);
  
  public static native int nativeRegister(String paramString);
  
  public static native int nativeSave(String paramString);
  
  public static native int nativeSetColor(boolean paramBoolean);
  
  public static native int nativeSetTarget(String paramString);
  
  public static native int nativeStart();
  
  public static native int nativeStop();
  
  public void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDNative
 * JD-Core Version:    0.7.0.1
 */