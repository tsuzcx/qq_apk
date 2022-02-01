package com.tencent.qqmini.sdk.launcher.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LiuHaiUtils
{
  private static final int ANDROID_O_API_LIMIT = 26;
  private static final int ANDROID_P_API_LIMIT = 27;
  private static final int FLAG_NOTCH_SUPPORT = 65536;
  public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS = 1;
  public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0;
  public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2;
  public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1;
  private static String[] LIUHAI_LIST;
  private static String[] MANUFACTURER;
  public static final int NOTCH_IN_SCREEN_VOIO = 32;
  public static final ArrayList<String> NotchWhiteList = new ArrayList();
  public static final int ROUNDED_IN_SCREEN_VOIO = 8;
  private static final String TAG = "LiuHaiUtils";
  public static boolean hasInitHasNotch = false;
  public static int sCenterOffset = 0;
  public static boolean sEnableNotchOK = false;
  private static final boolean sForceCenter_16_9 = true;
  public static boolean sHasNotch = false;
  public static boolean sIsIrregularScreen;
  public static int sNotchHeight;
  public static int sScreenHeight;
  public static int sScreenWidth;
  
  static
  {
    sEnableNotchOK = false;
    sNotchHeight = 0;
    hasInitHasNotch = false;
    sScreenHeight = 0;
    sScreenWidth = 0;
    sCenterOffset = 0;
    sIsIrregularScreen = false;
    LIUHAI_LIST = new String[] { "PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750" };
    MANUFACTURER = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
    NotchWhiteList.add("SHARP_FS8010".toLowerCase());
  }
  
  public static void closeFullScreen(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(1024);
    paramActivity.getWindow().addFlags(2048);
    paramActivity.getWindow().addFlags(256);
    paramActivity.getWindow().clearFlags(512);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  private static boolean enableHuaWeiNotch(Activity paramActivity)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramActivity.getWindow() == null))
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableHuaWeiNotch invalid param");
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject = paramActivity.getWindow().getAttributes();
      try
      {
        paramActivity = Class.forName("com.huawei.android.view.LayoutParamsEx");
        localObject = paramActivity.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
        paramActivity.getMethod("addHwFlags", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(65536) });
        if (QMLog.isColorLevel())
        {
          QMLog.i("LiuHaiUtils", "enableHuaWeiNotch true");
          return true;
        }
      }
      catch (Exception paramActivity)
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("LiuHaiUtils", "enableHuaWeiNotch Exception", paramActivity);
        }
      }
    }
    return false;
  }
  
  private static boolean enableMeizuNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(0x80 | paramActivity.getSystemUiVisibility());
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableMeizuNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("LiuHaiUtils", "enableMeizuNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  public static boolean enableNotch(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "enableNotch apiVersion: " + i);
    }
    if (i > 27) {
      return enableNotchInScreen_AndroidP(paramActivity);
    }
    return enableNotchInScreen_AndroidO(paramActivity);
  }
  
  private static boolean enableNotchInScreen(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "enableNotchInScreen apiVersion: " + i);
    }
    return true;
  }
  
  private static boolean enableNotchInScreen_AndroidO(Activity paramActivity)
  {
    boolean bool = true;
    String str = "" + Build.MANUFACTURER;
    if (str.equalsIgnoreCase("HUAWEI")) {
      bool = enableHuaWeiNotch(paramActivity);
    }
    do
    {
      do
      {
        return bool;
        if (!str.equalsIgnoreCase("OPPO")) {
          break;
        }
      } while (!QMLog.isColorLevel());
      QMLog.i("LiuHaiUtils", "enableNotchInScreen_AndroidO OPPO=true");
      return true;
      if (!str.equalsIgnoreCase("VIVO")) {
        break;
      }
    } while (!QMLog.isColorLevel());
    QMLog.i("LiuHaiUtils", "enableNotchInScreen_AndroidO VIVO=true");
    return true;
    if (str.equalsIgnoreCase("XIAOMI")) {
      return enableXiaoMiNotch(paramActivity);
    }
    if (str.equalsIgnoreCase("SAMSUNG")) {
      return enableSamsungNotch(paramActivity);
    }
    if (str.equalsIgnoreCase("Meizu")) {
      return enableMeizuNotch(paramActivity);
    }
    return false;
  }
  
  private static boolean enableNotchInScreen_AndroidP(Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    try
    {
      Field localField = localLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(localLayoutParams, 1);
      paramActivity.getWindow().setAttributes(localLayoutParams);
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("LiuHaiUtils", "enableNotchInScreen_AndroidP Exception");
      }
    }
    return false;
  }
  
  private static boolean enableSamsungNotch(Activity paramActivity)
  {
    return enableNotchInScreen_AndroidP(paramActivity);
  }
  
  private static boolean enableXiaoMiNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(768) });
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("LiuHaiUtils", "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  public static int getNotchInScreenHeight(Activity paramActivity)
  {
    int k = Build.VERSION.SDK_INT;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "getNotchInScreenHeight apiVersion: " + k);
    }
    int j = getStatusBarHeight(paramActivity);
    int i = j;
    if (j <= 0)
    {
      if (k > 27) {
        i = getNotchInScreenHeight_AndroidP(paramActivity);
      }
    }
    else {
      return i;
    }
    return getNotchInScreenHeight_AndroidO(paramActivity);
  }
  
  public static int getNotchInScreenHeight_AndroidO(Context paramContext)
  {
    int j = 0;
    Object localObject = "" + Build.MANUFACTURER;
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      localObject = hwGetNotchSize(paramContext);
    }
    for (;;)
    {
      if (localObject != null) {}
      for (int i = localObject[0];; i = 0)
      {
        if (localObject != null) {
          j = localObject[1];
        }
        int k = getStatusBarHeight(paramContext);
        if (QMLog.isColorLevel()) {
          QMLog.e("LiuHaiUtils", "getNotchInScreenHeight manufacturer:" + Build.MANUFACTURER + " height:" + j + " width:" + i + " status:" + k);
        }
        return Math.max(j, k);
        if (((String)localObject).equalsIgnoreCase("OPPO"))
        {
          localObject = oppoGetNotchSize(paramContext);
          break;
        }
        if (((String)localObject).equalsIgnoreCase("VIVO"))
        {
          localObject = null;
          break;
        }
        if (!((String)localObject).equalsIgnoreCase("XIAOMI")) {
          break label194;
        }
        localObject = xiaomiGetNotchSize(paramContext);
        break;
      }
      label194:
      localObject = null;
    }
  }
  
  public static int getNotchInScreenHeight_AndroidP(Activity paramActivity)
  {
    int j = getStatusBarHeight(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    int i;
    if (paramActivity == null)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      i = j;
    }
    for (;;)
    {
      return i;
      try
      {
        paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
        if (paramActivity == null)
        {
          if (!QMLog.isColorLevel()) {
            return j;
          }
          QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
          return j;
        }
        paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + paramActivity);
        }
        if (paramActivity != null)
        {
          int k = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
          i = k;
          if (!QMLog.isColorLevel()) {
            continue;
          }
          QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP top:" + k);
          return k;
        }
      }
      catch (Exception paramActivity)
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("LiuHaiUtils", "getNotchInScreenHeight_AndroidP Exception");
        }
      }
    }
    return j;
    return j;
  }
  
  public static int[] getRealDisplay(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = new DisplayMetrics();
      localDisplay.getRealMetrics(paramContext);
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "getRealDisplay manufacturer:" + Build.MANUFACTURER + " version:" + Build.VERSION.SDK_INT + " width:" + paramContext.widthPixels + " height:" + paramContext.heightPixels);
      }
      return new int[] { paramContext.widthPixels, paramContext.heightPixels };
    }
    boolean bool = DisplayUtil.hasNavBar(paramContext);
    if (bool) {}
    for (int i = DisplayUtil.getNavigationBarHeight(paramContext);; i = 0)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "getRealDisplay[none] manufacturer:" + Build.MANUFACTURER + " width:" + localDisplayMetrics.widthPixels + " height:" + localDisplayMetrics.heightPixels + " mNavigationBarHeight:" + i + " hasNavBar:" + bool);
      }
      return new int[] { localDisplayMetrics.widthPixels, i + localDisplayMetrics.heightPixels };
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  private static int getSystemPropertyForXiaomi(String paramString, int paramInt)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      i = paramInt;
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        i = paramInt;
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          i = paramInt;
          if ((paramString instanceof Integer)) {
            i = ((Integer)paramString).intValue();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      do
      {
        int i = paramInt;
      } while (!QMLog.isColorLevel());
      QMLog.d("LiuHaiUtils", "getSystemPropertyForXiaomi() Exception=" + paramString.getMessage());
    }
    return i;
    return paramInt;
  }
  
  private static boolean hasNotchInScreen(Activity paramActivity)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    sIsIrregularScreen = false;
    int i = Build.VERSION.SDK_INT;
    String str = "" + Build.MANUFACTURER;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "hasNotchInScreen version: " + i + " " + str);
    }
    if (i < 26) {}
    do
    {
      return bool2;
      bool2 = bool1;
      if (i > 27) {
        bool2 = hasNotchInScreen_AndroidP(paramActivity);
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (i >= 26) {
          bool1 = hasNotchInScreen_AndroidO(paramActivity);
        }
      }
      if (isLiuHaiModel())
      {
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "hasNotchInScreen manufacturer = " + Build.MANUFACTURER + " ,brand = " + Build.BRAND + " ,model = " + Build.MODEL);
        }
        return true;
      }
      bool2 = bool1;
    } while (!QMLog.isColorLevel());
    QMLog.i("LiuHaiUtils", "hasNotchInScreen haveNotch: " + bool1);
    return bool1;
  }
  
  public static boolean hasNotchInScreenByVersion(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    String str = "" + Build.MANUFACTURER;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "hasNotchInScreenByVersion version: " + i + " " + str);
    }
    boolean bool = false;
    if (i > 27) {
      bool = hasNotchInScreen_AndroidP(paramActivity);
    }
    while (i < 26) {
      return bool;
    }
    return hasNotchInScreen_AndroidO(paramActivity);
  }
  
  public static boolean hasNotchInScreen_AndroidO(Context paramContext)
  {
    String str = "" + Build.MANUFACTURER;
    if (str.equalsIgnoreCase("HUAWEI")) {
      return hwHasNotchInScreen(paramContext);
    }
    if (str.equalsIgnoreCase("OPPO")) {
      return oppoHasNotchInScreen(paramContext);
    }
    if (str.equalsIgnoreCase("VIVO")) {
      return vivoHasNotchInScreen(paramContext);
    }
    if (str.equalsIgnoreCase("XIAOMI")) {
      return xiaomiHasNotchInScreen(paramContext);
    }
    return false;
  }
  
  public static boolean hasNotchInScreen_AndroidP(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null) {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "hasNotchInScreen_AndroidP decorView=null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        try
        {
          paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
          if (paramActivity != null) {
            break label88;
          }
          if (QMLog.isColorLevel())
          {
            QMLog.i("LiuHaiUtils", "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
            return false;
          }
        }
        catch (Exception paramActivity) {}
      }
    } while (!QMLog.isColorLevel());
    QMLog.e("LiuHaiUtils", "hasNotchInScreen_AndroidP Exception");
    return false;
    label88:
    if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  private static int[] hwGetNotchSize(Context paramContext)
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore_1
    //   4: aload_1
    //   5: dup
    //   6: iconst_0
    //   7: iconst_0
    //   8: iastore
    //   9: dup
    //   10: iconst_1
    //   11: iconst_0
    //   12: iastore
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 508	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: ldc_w 510
    //   21: invokevirtual 515	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 517
    //   29: iconst_0
    //   30: anewarray 160	java/lang/Class
    //   33: invokevirtual 188	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: aload_0
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 198	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 519	[I
    //   47: checkcast 519	[I
    //   50: astore_0
    //   51: aload_0
    //   52: astore_1
    //   53: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   56: ifeq +30 -> 86
    //   59: ldc 32
    //   61: new 214	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 521
    //   71: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 152	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: astore_1
    //   86: aload_1
    //   87: areturn
    //   88: astore_0
    //   89: aload_1
    //   90: astore_0
    //   91: aload_0
    //   92: astore_1
    //   93: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   96: ifeq -10 -> 86
    //   99: ldc 32
    //   101: ldc_w 523
    //   104: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: astore_0
    //   112: aload_0
    //   113: astore_1
    //   114: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   117: ifeq -31 -> 86
    //   120: ldc 32
    //   122: ldc_w 525
    //   125: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: aload_1
    //   132: astore_0
    //   133: aload_0
    //   134: astore_1
    //   135: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   138: ifeq -52 -> 86
    //   141: ldc 32
    //   143: ldc_w 527
    //   146: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: areturn
    //   151: astore_1
    //   152: goto -19 -> 133
    //   155: astore_1
    //   156: goto -44 -> 112
    //   159: astore_1
    //   160: goto -69 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramContext	Context
    //   3	132	1	localObject	Object
    //   151	1	1	localException	Exception
    //   155	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   159	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	51	88	java/lang/ClassNotFoundException
    //   14	51	109	java/lang/NoSuchMethodException
    //   14	51	130	java/lang/Exception
    //   53	84	151	java/lang/Exception
    //   53	84	155	java/lang/NoSuchMethodException
    //   53	84	159	java/lang/ClassNotFoundException
  }
  
  /* Error */
  private static boolean hwHasNotchInScreen(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 508	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   4: ldc_w 510
    //   7: invokevirtual 515	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 528
    //   15: iconst_0
    //   16: anewarray 160	java/lang/Class
    //   19: invokevirtual 188	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: aload_0
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokevirtual 198	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 530	java/lang/Boolean
    //   33: invokevirtual 533	java/lang/Boolean:booleanValue	()Z
    //   36: istore_1
    //   37: iload_1
    //   38: istore_2
    //   39: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   42: ifeq +30 -> 72
    //   45: ldc 32
    //   47: new 214	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 535
    //   57: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 415	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 152	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iload_1
    //   71: istore_2
    //   72: iload_2
    //   73: ireturn
    //   74: astore_0
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: istore_2
    //   79: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   82: ifeq -10 -> 72
    //   85: ldc 32
    //   87: ldc_w 537
    //   90: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_0
    //   96: iconst_0
    //   97: istore_1
    //   98: iload_1
    //   99: istore_2
    //   100: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   103: ifeq -31 -> 72
    //   106: ldc 32
    //   108: ldc_w 539
    //   111: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: iload_1
    //   115: ireturn
    //   116: astore_0
    //   117: iconst_0
    //   118: istore_1
    //   119: iload_1
    //   120: istore_2
    //   121: invokestatic 146	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   124: ifeq -52 -> 72
    //   127: ldc 32
    //   129: ldc_w 541
    //   132: invokestatic 294	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: iload_1
    //   136: ireturn
    //   137: astore_0
    //   138: goto -19 -> 119
    //   141: astore_0
    //   142: goto -44 -> 98
    //   145: astore_0
    //   146: goto -69 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramContext	Context
    //   36	100	1	bool1	boolean
    //   38	83	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	37	74	java/lang/ClassNotFoundException
    //   0	37	95	java/lang/NoSuchMethodException
    //   0	37	116	java/lang/Exception
    //   39	70	137	java/lang/Exception
    //   39	70	141	java/lang/NoSuchMethodException
    //   39	70	145	java/lang/ClassNotFoundException
  }
  
  public static void initLiuHaiProperty(Activity paramActivity)
  {
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
    }
    if (!hasInitHasNotch)
    {
      sScreenHeight = DisplayUtil.getScreenHeight(paramActivity);
      sScreenWidth = DisplayUtil.getScreenWidth(paramActivity);
      sHasNotch = false;
    }
    try
    {
      sHasNotch = hasNotchInScreen(paramActivity);
      if (sHasNotch) {
        sNotchHeight = getNotchInScreenHeight(paramActivity);
      }
      hasInitHasNotch = true;
      sEnableNotchOK = false;
      if (sHasNotch)
      {
        sEnableNotchOK = enableNotchInScreen(paramActivity);
        if (sNotchHeight <= 0) {
          sEnableNotchOK = false;
        }
      }
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "initLiuHaiProperty[after] manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("LiuHaiUtils", "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, localThrowable);
        }
      }
    }
  }
  
  public static boolean isInNotchWhiteList()
  {
    String str = (Build.MANUFACTURER + "_" + Build.MODEL).toLowerCase();
    return NotchWhiteList.contains(str);
  }
  
  private static boolean isLiuHaiModel()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = LIUHAI_LIST;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isLiuHaiUseValid()
  {
    return (sHasNotch) && (sEnableNotchOK) && (sNotchHeight > 0);
  }
  
  private static boolean isNoneSupportedPhone()
  {
    String str = "" + Build.MANUFACTURER;
    if (Build.VERSION.SDK_INT > 27) {}
    for (;;)
    {
      return true;
      String[] arrayOfString = MANUFACTURER;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isSamsungFolderMobile()
  {
    String str = Build.MODEL.toUpperCase();
    if (TextUtils.isEmpty(str)) {}
    while ((!Build.MANUFACTURER.equalsIgnoreCase("samsung")) || (!str.contains("SM-F9000"))) {
      return false;
    }
    return true;
  }
  
  public static boolean needCloseFullScreen()
  {
    return sHasNotch;
  }
  
  private static int[] oppoGetNotchSize(Context paramContext)
  {
    try
    {
      paramContext = DisplayUtil.getSystemProperty("ro.oppo.screen.heteromorphism", null);
      if (TextUtils.isEmpty(paramContext))
      {
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty empty");
        }
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          if (QMLog.isColorLevel()) {
            QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty exp ", paramContext);
          }
          paramContext = null;
          continue;
          paramContext = paramContext.split(":");
          if (QMLog.isColorLevel()) {
            QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty values=" + paramContext);
          }
          if (paramContext.length >= 2)
          {
            String[] arrayOfString = paramContext[0].split(",");
            if (QMLog.isColorLevel()) {
              QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty values[0] size=" + arrayOfString);
            }
            if (arrayOfString.length >= 2) {
              try
              {
                int i = Integer.valueOf(arrayOfString[0]).intValue();
                int j = Integer.valueOf(arrayOfString[1]).intValue();
                if (QMLog.isColorLevel()) {
                  QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty values[0] left=" + i + " top=" + j);
                }
                arrayOfString = paramContext[1].split(",");
                if (QMLog.isColorLevel()) {
                  QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty values[1] size=" + arrayOfString);
                }
                int k;
                int m;
                if ((arrayOfString.length >= 2) && (QMLog.isColorLevel())) {
                  QMLog.i("LiuHaiUtils", "oppoGetNotchSize values[0]=" + paramContext[0], localNumberFormatException1);
                }
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                try
                {
                  k = Integer.valueOf(arrayOfString[0]).intValue();
                  m = Integer.valueOf(arrayOfString[1]).intValue();
                  if (QMLog.isColorLevel()) {
                    QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty values[1] right=" + k + " bottom=" + m);
                  }
                  return new int[] { k - i, m - j };
                }
                catch (NumberFormatException localNumberFormatException2) {}
                localNumberFormatException1 = localNumberFormatException1;
              }
            }
          }
        }
        return null;
      } while (!QMLog.isColorLevel());
      QMLog.i("LiuHaiUtils", "oppoGetNotchSize values[1]=" + paramContext[1], localNumberFormatException2);
    }
    return null;
  }
  
  private static boolean oppoHasNotchInScreen(Context paramContext)
  {
    boolean bool1;
    if (Build.MODEL.equals("PAAM00")) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
      bool1 = bool2;
    } while (!QMLog.isColorLevel());
    QMLog.i("LiuHaiUtils", "oppoHasNotchInScreen exits:" + bool2);
    return bool2;
  }
  
  public static void resetAllLiuHaiStatus()
  {
    sHasNotch = false;
    sEnableNotchOK = false;
    sNotchHeight = 0;
    hasInitHasNotch = false;
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "resetAllLiuHaiStatus!");
    }
  }
  
  public static void resetFullScreen(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(2048);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().addFlags(256);
    paramActivity.getWindow().addFlags(512);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x4);
    }
  }
  
  public static boolean vivoHasNotchInScreen(Context paramContext)
  {
    do
    {
      try
      {
        paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
        bool1 = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
        boolean bool2 = bool1;
        bool2 = bool1;
      }
      catch (Exception paramContext)
      {
        try
        {
          if (QMLog.isColorLevel())
          {
            QMLog.i("LiuHaiUtils", "vivoHasNotchInScreen ret=" + bool1);
            bool2 = bool1;
          }
          return bool2;
        }
        catch (Exception paramContext)
        {
          boolean bool1;
          continue;
        }
        paramContext = paramContext;
        bool1 = false;
      }
    } while (!QMLog.isColorLevel());
    QMLog.e("LiuHaiUtils", "vivoHasNotchInScreen Exception", paramContext);
    return bool1;
  }
  
  private static int[] xiaomiGetNotchSize(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int i = paramContext.getResources().getIdentifier("notch_width", "dimen", "android");
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "xiaomiGetNotchSize [notch_width]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "xiaomiGetNotchSize [notch_height]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
    }
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "xiaomiGetNotchSize width: " + arrayOfInt[0] + " height:" + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  @TargetApi(17)
  private static boolean xiaomiHasNotchInScreen(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i == 1)
        {
          if (!QMLog.isColorLevel()) {
            break label127;
          }
          QMLog.i("LiuHaiUtils", "xiaomiHasNotchInScreen closed: " + i);
          return false;
        }
        i = getSystemPropertyForXiaomi("ro.miui.notch", 0);
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "xiaomiHasNotchInScreen isNotch: " + i);
        }
        if (i != 1) {
          break label127;
        }
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      while (QMLog.isColorLevel())
      {
        QMLog.i("LiuHaiUtils", "xiaomiHasNotchInScreen crash: ", paramContext);
        return false;
        i = 0;
      }
    }
    label127:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils
 * JD-Core Version:    0.7.0.1
 */