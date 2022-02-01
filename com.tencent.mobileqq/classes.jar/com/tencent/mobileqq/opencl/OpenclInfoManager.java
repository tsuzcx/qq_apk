package com.tencent.mobileqq.opencl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class OpenclInfoManager
{
  private static Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString = "OpenclInfoManager";
  private static boolean jdField_a_of_type_Boolean;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    a();
  }
  
  public static void a()
  {
    try
    {
      System.loadLibrary("oclInfo");
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      System.out.println(localUnsatisfiedLinkError);
    }
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("err"))) {}
    do
    {
      return;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).edit();
      localEditor.putString("param_ocl_gpuinfo", paramString);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "saveOclGpuInfo:" + paramString);
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("param_ocl_gpuinfo", "");
  }
  
  private native String nativeGetOclVersion();
  
  private native String nativeGetPlatformName();
  
  private native int nativeGetSupportedType();
  
  public String a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!TextUtils.isEmpty(b))
      {
        String str = b;
        return str;
      }
      b = b();
      boolean bool = TextUtils.isEmpty(b);
      if (!bool) {}
    }
    try
    {
      b = nativeGetGPUInfo();
      a(b);
      return b;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getGPUInfo exception!", localException);
        }
      }
      localObject2 = finally;
      throw localObject2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getGPUInfo UnsatisfiedLinkError!");
        }
      }
    }
  }
  
  public native String nativeGetGPUInfo();
  
  public native int nativeGetGPUUnit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.opencl.OpenclInfoManager
 * JD-Core Version:    0.7.0.1
 */