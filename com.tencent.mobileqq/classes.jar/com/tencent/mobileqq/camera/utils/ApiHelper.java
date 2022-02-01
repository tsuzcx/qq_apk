package com.tencent.mobileqq.camera.utils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Build.VERSION;

public class ApiHelper
{
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static final boolean n;
  
  static
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1;
    if (i1 >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    b = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    c = bool1;
    if (Build.VERSION.SDK_INT >= 15) {
      bool1 = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
    } else {
      bool1 = false;
    }
    d = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = a("android.graphics.SurfaceTexture", "release", new Class[0]);
    } else {
      bool1 = false;
    }
    e = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    f = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    g = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
    } else {
      bool1 = false;
    }
    h = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    i = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    j = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    k = bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    l = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    m = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    n = bool1;
  }
  
  private static boolean a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1)
    {
      label12:
      break label12;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.utils.ApiHelper
 * JD-Core Version:    0.7.0.1
 */