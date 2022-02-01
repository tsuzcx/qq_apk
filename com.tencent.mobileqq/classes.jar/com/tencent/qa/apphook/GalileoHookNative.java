package com.tencent.qa.apphook;

import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class GalileoHookNative
{
  int test;
  
  static
  {
    System.loadLibrary("galileohook");
    galileoInit(Build.VERSION.SDK_INT);
    try
    {
      if (isArt())
      {
        computeAccess(MethodSizeCalc.class.getDeclaredMethod("m1", new Class[0]));
        Field localField1 = Object.class.getDeclaredFields()[0];
        GalileoHookLog.d("objectFirstField name is " + localField1.getName());
        Field localField2 = GalileoHookNative.class.getDeclaredField("test");
        GalileoHookLog.d("testField name is " + localField2.getName());
        computeSupperCls(localField1, localField2);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static native void computeAccess(Method paramMethod);
  
  public static native void computeSupperCls(Field paramField1, Field paramField2);
  
  public static native void galileoInit(int paramInt);
  
  public static native void initMethod(Class paramClass, String paramString1, String paramString2, boolean paramBoolean);
  
  public static boolean isArt()
  {
    String str = System.getProperty("java.vm.version");
    return (str != null) && (str.startsWith("2"));
  }
  
  public static native void makePrivate(Method paramMethod);
  
  public static Member repairMethod(Member paramMember, Method paramMethod, long paramLong)
  {
    if (isArt()) {
      return paramMethod;
    }
    return paramMember;
  }
  
  public static void replaceMethodArt(GalileoBackupMethod paramGalileoBackupMethod)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder().append("replaceMethodArt old method name is ");
        if (paramGalileoBackupMethod.getOriginMethod() != null)
        {
          str = paramGalileoBackupMethod.getOriginMethod().getName();
          GalileoHookLog.d(str);
          localStringBuilder = new StringBuilder().append("replaceMethodArt old new method name is ");
          if (paramGalileoBackupMethod.getNewMethod() == null) {
            break label166;
          }
          str = paramGalileoBackupMethod.getNewMethod().getName();
          GalileoHookLog.d(str);
          localStringBuilder = new StringBuilder().append("replaceMethodArt invoke method name is ");
          if (paramGalileoBackupMethod.getInvoker() != null)
          {
            str = paramGalileoBackupMethod.getInvoker().getName();
            GalileoHookLog.d(str);
            paramGalileoBackupMethod.setBackAddr(replaceNativeArt(paramGalileoBackupMethod.getOriginMethod(), paramGalileoBackupMethod.getNewMethod(), paramGalileoBackupMethod.getInvoker()) & 0xFFFFFFFF);
            return;
          }
          str = "";
          continue;
        }
        str = "";
      }
      catch (Exception paramGalileoBackupMethod)
      {
        paramGalileoBackupMethod.printStackTrace();
        return;
      }
      continue;
      label166:
      String str = "";
    }
  }
  
  public static native long replaceNativeArt(Member paramMember1, Member paramMember2, Method paramMethod);
  
  public static boolean setMadeClassSuper(Class paramClass)
  {
    try
    {
      setSupperCls(paramClass.getField("flag"));
      return true;
    }
    catch (Exception paramClass)
    {
      GalileoHookLog.e("field not found!", paramClass);
    }
    return false;
  }
  
  public static native boolean setSupperCls(Field paramField);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.GalileoHookNative
 * JD-Core Version:    0.7.0.1
 */