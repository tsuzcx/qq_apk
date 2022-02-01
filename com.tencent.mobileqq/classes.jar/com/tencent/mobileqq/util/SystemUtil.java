package com.tencent.mobileqq.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;

public class SystemUtil
{
  public static String a = "SystemUtil";
  static boolean b;
  static boolean c;
  
  public static String a(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString, null });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static long b()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return 0L;
  }
  
  public static long c()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data/data/com.tencent.mobileqq/files/");
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    return 0L;
  }
  
  public static boolean d()
  {
    if (b) {
      return c;
    }
    e();
    return c;
  }
  
  public static void e()
  {
    boolean bool2 = true;
    b = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(a("ro.miui.ui.version.code")))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
        if (!TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    c = bool1;
  }
  
  public static boolean f()
  {
    return b;
  }
  
  public static boolean g()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean h()
  {
    return (!TextUtils.isEmpty(a("ro.meizu.product.model"))) || ("meizu".equalsIgnoreCase(Build.BRAND)) || ("22c4185e".equalsIgnoreCase(Build.BRAND));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */