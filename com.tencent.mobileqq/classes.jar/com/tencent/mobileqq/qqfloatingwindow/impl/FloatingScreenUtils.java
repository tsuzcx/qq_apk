package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.reflect.Method;

public class FloatingScreenUtils
{
  public static int a = 480;
  private static int b = 0;
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: new 26	android/util/DisplayMetrics
    //   3: dup
    //   4: invokespecial 41	android/util/DisplayMetrics:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ldc 43
    //   11: invokevirtual 49	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 51	android/view/WindowManager
    //   17: invokeinterface 55 1 0
    //   22: astore_0
    //   23: getstatic 60	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 17
    //   28: if_icmplt +13 -> 41
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 66	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   36: aload_2
    //   37: getfield 69	android/util/DisplayMetrics:heightPixels	I
    //   40: ireturn
    //   41: ldc 62
    //   43: ldc 71
    //   45: iconst_0
    //   46: anewarray 73	java/lang/Class
    //   49: invokevirtual 77	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   52: astore_2
    //   53: aload_2
    //   54: aload_0
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokevirtual 83	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 85	java/lang/Integer
    //   65: invokevirtual 89	java/lang/Integer:intValue	()I
    //   68: istore_1
    //   69: iload_1
    //   70: ireturn
    //   71: astore_0
    //   72: ldc 91
    //   74: iconst_2
    //   75: aload_0
    //   76: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iconst_m1
    //   83: ireturn
    //   84: astore_0
    //   85: ldc 91
    //   87: iconst_2
    //   88: aload_0
    //   89: invokevirtual 104	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   92: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -13 -> 82
    //   98: astore_0
    //   99: goto -27 -> 72
    //   102: astore_0
    //   103: goto -31 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramContext	Context
    //   68	2	1	i	int
    //   7	47	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	69	71	java/lang/IllegalAccessException
    //   23	41	84	java/lang/NoSuchMethodException
    //   41	53	84	java/lang/NoSuchMethodException
    //   53	69	84	java/lang/NoSuchMethodException
    //   72	82	84	java/lang/NoSuchMethodException
    //   53	69	98	java/lang/IllegalArgumentException
    //   53	69	102	java/lang/reflect/InvocationTargetException
  }
  
  public static boolean a(Context paramContext)
  {
    if (b == 0)
    {
      if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT >= 28) || (!LiuHaiUtils.b(paramContext))) {
        break label56;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
      }
    }
    label56:
    for (b = 1; b == 1; b = 2) {
      return true;
    }
    return false;
  }
  
  @TargetApi(13)
  public static int b(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (a = localPoint.y;; a = paramContext.getDefaultDisplay().getHeight()) {
      return a;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2;
    for (;;)
    {
      try
      {
        Resources localResources = paramContext.getResources();
        i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (i <= 0) {
          continue;
        }
        bool1 = localResources.getBoolean(i);
      }
      catch (Exception paramContext)
      {
        int i;
        boolean bool1 = false;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          return bool2;
        }
        QLog.e("FloatingScreenUtils", 2, "checkNavigationBarShow error: " + paramContext.toString());
        return bool1;
        return bool1;
        bool1 = false;
        continue;
        if (i != 1) {
          continue;
        }
        bool2 = false;
      }
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
        } else {
          i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
        }
      }
      catch (Exception paramContext) {}
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
    {
      paramContext = Class.forName("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
      if ("1".equals(paramContext)) {
        return false;
      }
      bool2 = "0".equals(paramContext);
      if (bool2) {
        return true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenUtils
 * JD-Core Version:    0.7.0.1
 */