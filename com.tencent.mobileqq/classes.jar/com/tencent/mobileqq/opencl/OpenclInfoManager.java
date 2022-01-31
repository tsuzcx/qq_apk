package com.tencent.mobileqq.opencl;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class OpenclInfoManager
{
  private static String jdField_a_of_type_JavaLangString = "OpenclInfoManager";
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    a();
  }
  
  public static void a()
  {
    try
    {
      i = Build.VERSION.SDK_INT;
      if (i < 24) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      for (;;)
      {
        try
        {
          label15:
          System.load("/system/lib/egl/libGLES_mali.so");
          i = 2;
          bool1 = true;
          bool2 = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
        {
          try
          {
            System.loadLibrary("OpenCL");
            i = 0;
            bool1 = false;
            bool2 = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError4)
          {
            try
            {
              System.load("/system/vendor/lib/egl/libGLES_mali.so");
              i = 3;
              bool1 = true;
              bool2 = false;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError5)
            {
              try
              {
                System.loadLibrary("GLES_mali");
                i = 0;
                bool1 = true;
                bool2 = false;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError6)
              {
                int i = 0;
                boolean bool1 = false;
                boolean bool2 = false;
              }
            }
          }
        }
      }
    }
    try
    {
      System.loadLibrary("hardware");
      System.load("/system/vendor/lib/egl/libGLES_mali_v2.so");
      i = 1;
      bool1 = true;
      bool2 = false;
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("loadOclSo[%s], loadMaliSo[%s], maliType[%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(i) }));
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        System.loadLibrary("oclInfo");
        jdField_a_of_type_Boolean = true;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError7)
      {
        System.out.println(localUnsatisfiedLinkError7);
      }
      localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
      localUnsatisfiedLinkError1.printStackTrace();
      break label15;
    }
  }
  
  private native String nativeGetOclVersion();
  
  private native String nativeGetPlatformName();
  
  private native int nativeGetSupportedType();
  
  public String a()
  {
    Object localObject = "";
    try
    {
      String str = nativeGetGPUInfo();
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGPUInfo exception!", localException);
      return "";
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGPUInfo UnsatisfiedLinkError!");
    }
    return localObject;
    return "";
  }
  
  public native String nativeGetGPUInfo();
  
  public native int nativeGetGPUUnit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.opencl.OpenclInfoManager
 * JD-Core Version:    0.7.0.1
 */