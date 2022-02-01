package com.tencent.mobileqq.statistics.natmem;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import mqq.app.MobileQQ;

public class NativeMemoryUtils
{
  private static String a;
  public static List<String> a;
  public static String[] a;
  private static String b;
  public static List<String> b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { ".*\\.so$" };
    jdField_a_of_type_JavaUtilList = new NativeMemoryUtils.1();
    jdField_b_of_type_JavaUtilList = new NativeMemoryUtils.2();
  }
  
  public static int a()
  {
    return PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getInt("RateNum", 90);
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/MobileQQ/nativemem/");
      jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
    jdField_b_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("NatMem", 2, new Object[] { "FilePath:", jdField_a_of_type_JavaLangString });
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("NatMemSp", 0).edit();
    localEditor.putInt("EnableBackground", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).edit().putLong("NatMemUploadTime", paramLong);
  }
  
  public static void a(String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).edit().putString("ignoreList", paramString).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).edit().putBoolean("AutoStartHook", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getLong("LastScanTime", 0L);
    return System.currentTimeMillis() - l > 300000L;
  }
  
  public static int b()
  {
    return PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getInt("RateDen", 100);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_JavaLangString == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/MobileQQ/nativemem/scanner/");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("NatMem", 2, new Object[] { "ScannerFilePath:", jdField_a_of_type_JavaLangString });
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean b()
  {
    return PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getBoolean("NeedHookSys", false);
  }
  
  public static int c()
  {
    return PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getInt("MinSize", 1024);
  }
  
  public static boolean c()
  {
    return PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getBoolean("AutoStartHook", false);
  }
  
  public static boolean d()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext().getApplicationContext()).getLong("NatMemUploadTime", 0L);
    return Math.abs(System.currentTimeMillis() - l) > 43200000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryUtils
 * JD-Core Version:    0.7.0.1
 */