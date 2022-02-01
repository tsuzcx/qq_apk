package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class FDNative
{
  private static FDNative jdField_a_of_type_ComTencentMobileqqStatisticsFDNative;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private FDNative()
  {
    System.loadLibrary("qq_fd");
  }
  
  public static int a()
  {
    int i = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext()).getInt("FDHookFailTime", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "getFailTime ", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static FDNative a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsFDNative == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStatisticsFDNative == null) {
          jdField_a_of_type_ComTencentMobileqqStatisticsFDNative = new FDNative();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsFDNative;
  }
  
  public static void a()
  {
    if (a() >= 30)
    {
      long l = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext()).getLong("FDHookLastInterval", 0L);
      if ((System.currentTimeMillis() - l > 86400000L) && (l != 0L))
      {
        a(0);
        a(true, true);
      }
    }
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext());
    localSharedPreferences.edit().putInt("FDHookFailTime", paramInt).apply();
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "setFailTime ", Integer.valueOf(paramInt) });
    }
    if (paramInt >= 30)
    {
      localSharedPreferences.edit().putLong("FDHookLastInterval", System.currentTimeMillis()).apply();
      a(false, true);
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext());
    localSharedPreferences.edit().putBoolean("FDHook", paramBoolean1).commit();
    if (!paramBoolean2) {
      localSharedPreferences.edit().putBoolean("FDHookChanged", true).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "setEnableHook ", Boolean.valueOf(paramBoolean1) });
    }
  }
  
  public static boolean b()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext());
    localSharedPreferences.getBoolean("FDHookChanged", false);
    boolean bool = localSharedPreferences.getBoolean("FDHook", true);
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "getEnableHook ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static native Object nativeCollectFDList();
  
  public static native int nativeIgnore(String paramString);
  
  public static native int nativeInit(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public static native int nativeRegister(String paramString);
  
  public static native int nativeSave(String paramString);
  
  public static native int nativeStart();
  
  public static native int nativeStop();
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = (ArrayList)nativeCollectFDList();
    if (QLog.isColorLevel())
    {
      int i = 0;
      if (localArrayList != null) {
        i = localArrayList.size();
      }
      QLog.d("FDStats", 2, new Object[] { "getCollectFDList size ", Integer.valueOf(i) });
    }
    return localArrayList;
  }
  
  public void a(String paramString) {}
  
  public boolean a()
  {
    if (!this.b)
    {
      this.jdField_a_of_type_Boolean = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ.getApplicationContext()).getBoolean("FDLog", false);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, new Object[] { "getEnableLog ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      this.b = true;
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDNative
 * JD-Core Version:    0.7.0.1
 */