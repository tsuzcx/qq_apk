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
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 14)
    {
      bool1 = true;
      a = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label251;
      }
      bool1 = true;
      label26:
      b = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label256;
      }
      bool1 = true;
      label40:
      c = bool1;
      if (Build.VERSION.SDK_INT < 15) {
        break label261;
      }
      bool1 = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      label76:
      d = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label266;
      }
      bool1 = a("android.graphics.SurfaceTexture", "release", new Class[0]);
      label100:
      e = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label271;
      }
      bool1 = true;
      label114:
      f = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label276;
      }
      bool1 = true;
      label128:
      g = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label281;
      }
      bool1 = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      label157:
      h = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label286;
      }
      bool1 = true;
      label171:
      i = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label291;
      }
      bool1 = true;
      label185:
      j = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label296;
      }
      bool1 = true;
      label199:
      k = bool1;
      if (Build.VERSION.SDK_INT < 19) {
        break label301;
      }
      bool1 = true;
      label213:
      l = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label306;
      }
      bool1 = true;
      label227:
      m = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label311;
      }
    }
    label256:
    label261:
    label266:
    label271:
    label276:
    label281:
    label286:
    label291:
    label296:
    label301:
    label306:
    label311:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      n = bool1;
      return;
      bool1 = false;
      break;
      label251:
      bool1 = false;
      break label26;
      bool1 = false;
      break label40;
      bool1 = false;
      break label76;
      bool1 = false;
      break label100;
      bool1 = false;
      break label114;
      bool1 = false;
      break label128;
      bool1 = false;
      break label157;
      bool1 = false;
      break label171;
      bool1 = false;
      break label185;
      bool1 = false;
      break label199;
      bool1 = false;
      break label213;
      bool1 = false;
      break label227;
    }
  }
  
  private static boolean a(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, Class... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.camera.utils.ApiHelper
 * JD-Core Version:    0.7.0.1
 */