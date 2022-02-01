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
  public static final ArrayList<String> NOTCH_WHITE_LIST = new ArrayList();
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
    NOTCH_WHITE_LIST.add("SHARP_FS8010".toLowerCase());
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
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      Object localObject = paramActivity.getWindow().getAttributes();
      try
      {
        paramActivity = Class.forName("com.huawei.android.view.LayoutParamsEx");
        localObject = paramActivity.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
        paramActivity.getMethod("addHwFlags", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(65536) });
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "enableHuaWeiNotch true");
        }
        return true;
      }
      catch (Exception paramActivity)
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("LiuHaiUtils", "enableHuaWeiNotch Exception", paramActivity);
        }
        return false;
      }
    }
    if (QMLog.isColorLevel()) {
      QMLog.i("LiuHaiUtils", "enableHuaWeiNotch invalid param");
    }
    return false;
  }
  
  private static boolean enableMeizuNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x80);
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
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    if (i > 27) {
      return enableNotchInScreen_AndroidP(paramActivity);
    }
    return enableNotchInScreen_AndroidO(paramActivity);
  }
  
  private static boolean enableNotchInScreen(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QMLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("enableNotchInScreen apiVersion: ");
      paramActivity.append(i);
      QMLog.i("LiuHaiUtils", paramActivity.toString());
    }
    return true;
  }
  
  private static boolean enableNotchInScreen_AndroidO(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return enableHuaWeiNotch(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO"))
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableNotchInScreen_AndroidO OPPO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("VIVO"))
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "enableNotchInScreen_AndroidO VIVO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return enableXiaoMiNotch(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("SAMSUNG")) {
      return enableSamsungNotch(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("Meizu")) {
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
      label54:
      break label54;
    }
    if (QMLog.isColorLevel()) {
      QMLog.e("LiuHaiUtils", "enableNotchInScreen_AndroidP Exception");
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
    int i = Build.VERSION.SDK_INT;
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotchInScreenHeight apiVersion: ");
      localStringBuilder.append(i);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    int j = getStatusBarHeight(paramActivity);
    if (j <= 0)
    {
      if (i > 27) {
        return getNotchInScreenHeight_AndroidP(paramActivity);
      }
      return getNotchInScreenHeight_AndroidO(paramActivity);
    }
    return j;
  }
  
  public static int getNotchInScreenHeight_AndroidO(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    String str = ((StringBuilder)localObject).toString();
    boolean bool = str.equalsIgnoreCase("HUAWEI");
    localObject = null;
    if (bool) {
      localObject = hwGetNotchSize(paramContext);
    } else if (str.equalsIgnoreCase("OPPO")) {
      localObject = oppoGetNotchSize(paramContext);
    } else if ((!str.equalsIgnoreCase("VIVO")) && (str.equalsIgnoreCase("XIAOMI"))) {
      localObject = xiaomiGetNotchSize(paramContext);
    }
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject[0];
    } else {
      i = 0;
    }
    if (localObject != null) {
      j = localObject[1];
    }
    int k = getStatusBarHeight(paramContext);
    if (QMLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getNotchInScreenHeight manufacturer:");
      paramContext.append(Build.MANUFACTURER);
      paramContext.append(" height:");
      paramContext.append(j);
      paramContext.append(" width:");
      paramContext.append(i);
      paramContext.append(" status:");
      paramContext.append(k);
      QMLog.e("LiuHaiUtils", paramContext.toString());
    }
    return Math.max(j, k);
  }
  
  public static int getNotchInScreenHeight_AndroidP(Activity paramActivity)
  {
    int i = getStatusBarHeight(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      return i;
    }
    try
    {
      paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
      if (paramActivity == null)
      {
        if (!QMLog.isColorLevel()) {
          return i;
        }
        QMLog.i("LiuHaiUtils", "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
        return i;
      }
      paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
      if (QMLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=");
        localStringBuilder.append(paramActivity);
        QMLog.i("LiuHaiUtils", localStringBuilder.toString());
      }
      if (paramActivity == null) {
        break label222;
      }
      int j = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
      if (QMLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getNotchInScreenHeight_AndroidP top:");
        paramActivity.append(j);
        QMLog.i("LiuHaiUtils", paramActivity.toString());
      }
      return j;
    }
    catch (Exception paramActivity)
    {
      label208:
      label222:
      break label208;
    }
    if (QMLog.isColorLevel()) {
      QMLog.e("LiuHaiUtils", "getNotchInScreenHeight_AndroidP Exception");
    }
    return i;
    return i;
  }
  
  public static int[] getRealDisplay(Context paramContext)
  {
    Object localObject = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = new DisplayMetrics();
      ((Display)localObject).getRealMetrics(paramContext);
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRealDisplay manufacturer:");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append(" version:");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject).append(" width:");
        ((StringBuilder)localObject).append(paramContext.widthPixels);
        ((StringBuilder)localObject).append(" height:");
        ((StringBuilder)localObject).append(paramContext.heightPixels);
        QMLog.i("LiuHaiUtils", ((StringBuilder)localObject).toString());
      }
      return new int[] { paramContext.widthPixels, paramContext.heightPixels };
    }
    boolean bool = DisplayUtil.hasNavBar(paramContext);
    int i;
    if (bool) {
      i = DisplayUtil.getNavigationBarHeight(paramContext);
    } else {
      i = 0;
    }
    if (QMLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getRealDisplay[none] manufacturer:");
      paramContext.append(Build.MANUFACTURER);
      paramContext.append(" width:");
      paramContext.append(localDisplayMetrics.widthPixels);
      paramContext.append(" height:");
      paramContext.append(localDisplayMetrics.heightPixels);
      paramContext.append(" mNavigationBarHeight:");
      paramContext.append(i);
      paramContext.append(" hasNavBar:");
      paramContext.append(bool);
      QMLog.i("LiuHaiUtils", paramContext.toString());
    }
    return new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels + i };
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private static int getSystemPropertyForXiaomi(String paramString, int paramInt)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          if ((paramString instanceof Integer))
          {
            int i = ((Integer)paramString).intValue();
            return i;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSystemPropertyForXiaomi() Exception=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QMLog.d("LiuHaiUtils", ((StringBuilder)localObject).toString());
      }
    }
    return paramInt;
  }
  
  private static boolean hasNotchInScreen(Activity paramActivity)
  {
    boolean bool1 = false;
    sIsIrregularScreen = false;
    int i = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreen version: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    if (i < 26) {
      return false;
    }
    if (i > 27) {
      bool1 = hasNotchInScreen_AndroidP(paramActivity);
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (i >= 26) {
        bool2 = hasNotchInScreen_AndroidO(paramActivity);
      }
    }
    if (isLiuHaiModel())
    {
      if (QMLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("hasNotchInScreen manufacturer = ");
        paramActivity.append(Build.MANUFACTURER);
        paramActivity.append(" ,brand = ");
        paramActivity.append(Build.BRAND);
        paramActivity.append(" ,model = ");
        paramActivity.append(Build.MODEL);
        QMLog.i("LiuHaiUtils", paramActivity.toString());
      }
      return true;
    }
    if (QMLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("hasNotchInScreen haveNotch: ");
      paramActivity.append(bool2);
      QMLog.i("LiuHaiUtils", paramActivity.toString());
    }
    return bool2;
  }
  
  public static boolean hasNotchInScreenByVersion(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreenByVersion version: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    boolean bool = false;
    if (i > 27) {
      return hasNotchInScreen_AndroidP(paramActivity);
    }
    if (i >= 26) {
      bool = hasNotchInScreen_AndroidO(paramActivity);
    }
    return bool;
  }
  
  public static boolean hasNotchInScreen_AndroidO(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return hwHasNotchInScreen(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO")) {
      return oppoHasNotchInScreen(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("VIVO")) {
      return vivoHasNotchInScreen(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return xiaomiHasNotchInScreen(paramContext);
    }
    return false;
  }
  
  public static boolean hasNotchInScreen_AndroidP(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "hasNotchInScreen_AndroidP decorView=null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
        if (paramActivity == null)
        {
          if (!QMLog.isColorLevel()) {
            break label160;
          }
          QMLog.i("LiuHaiUtils", "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
          return false;
        }
        if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) == null) {
          break label162;
        }
        bool = true;
        if (QMLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("hasNotchInScreen_AndroidP getDisplayCutout  exists:");
          paramActivity.append(bool);
          QMLog.i("LiuHaiUtils", paramActivity.toString());
        }
        return bool;
      }
      catch (Exception paramActivity)
      {
        continue;
      }
      if (QMLog.isColorLevel()) {
        QMLog.e("LiuHaiUtils", "hasNotchInScreen_AndroidP Exception");
      }
      return false;
      label160:
      return false;
      label162:
      boolean bool = false;
    }
  }
  
  private static int[] hwGetNotchSize(Context paramContext)
  {
    Object localObject = new int[2];
    Object tmp5_4 = localObject;
    tmp5_4[0] = 0;
    Object tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      localObject = paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label141;
    }
    catch (NoSuchMethodException paramContext)
    {
      label141:
      label143:
      label161:
      break label121;
    }
    catch (Exception paramContext)
    {
      label92:
      label95:
      label98:
      label101:
      label103:
      label121:
      label123:
      break label101;
    }
    try
    {
      if (!QMLog.isColorLevel()) {
        break label161;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hwGetNotchSize ret=");
      ((StringBuilder)localObject).append(paramContext);
      QMLog.i("LiuHaiUtils", ((StringBuilder)localObject).toString());
      return paramContext;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label98;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label95;
    }
    catch (Exception localException)
    {
      break label92;
    }
    break label103;
    break label123;
    break label143;
    paramContext = (Context)localObject;
    localObject = paramContext;
    if (QMLog.isColorLevel())
    {
      QMLog.e("LiuHaiUtils", "hasNotchInScreen Exception");
      return paramContext;
      paramContext = (Context)localObject;
      localObject = paramContext;
      if (QMLog.isColorLevel())
      {
        QMLog.e("LiuHaiUtils", "hwGetNotchSize NoSuchMethodException");
        return paramContext;
        paramContext = (Context)localObject;
        localObject = paramContext;
        if (QMLog.isColorLevel())
        {
          QMLog.e("LiuHaiUtils", "hwGetNotchSize ClassNotFoundException");
          localObject = paramContext;
        }
      }
    }
    return localObject;
  }
  
  private static boolean hwHasNotchInScreen(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool3 = bool1;
    boolean bool4 = bool2;
    boolean bool5 = bool6;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      bool3 = bool1;
      bool4 = bool2;
      bool5 = bool6;
      bool1 = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      if (!QMLog.isColorLevel()) {
        break label201;
      }
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext = new StringBuilder();
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext.append("hwHasNotchInScreen ret=");
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext.append(bool1);
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      QMLog.i("LiuHaiUtils", paramContext.toString());
      return bool1;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label183;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label163;
    }
    catch (Exception paramContext)
    {
      label143:
      break label143;
    }
    bool2 = bool5;
    if (QMLog.isColorLevel())
    {
      QMLog.e("LiuHaiUtils", "hwHasNotchInScreen Exception");
      return bool5;
      label163:
      bool2 = bool4;
      if (QMLog.isColorLevel())
      {
        QMLog.e("LiuHaiUtils", "hwHasNotchInScreen NoSuchMethodException");
        return bool4;
        label183:
        bool2 = bool3;
        if (QMLog.isColorLevel())
        {
          QMLog.e("LiuHaiUtils", "hwHasNotchInScreen ClassNotFoundException");
          bool2 = bool3;
        }
      }
    }
    label201:
    return bool2;
  }
  
  public static void initLiuHaiProperty(Activity paramActivity)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiProperty manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" hasInitHasNotch:");
      localStringBuilder1.append(hasInitHasNotch);
      localStringBuilder1.append(" sHasNotch:");
      localStringBuilder1.append(sHasNotch);
      localStringBuilder1.append(" sEnableNotchOK:");
      localStringBuilder1.append(sEnableNotchOK);
      localStringBuilder1.append(" sNotchHeight:");
      localStringBuilder1.append(sNotchHeight);
      QMLog.i("LiuHaiUtils", localStringBuilder1.toString());
    }
    if (!hasInitHasNotch)
    {
      sScreenHeight = DisplayUtil.getScreenHeight(paramActivity);
      sScreenWidth = DisplayUtil.getScreenWidth(paramActivity);
      sHasNotch = false;
      try
      {
        sHasNotch = hasNotchInScreen(paramActivity);
      }
      catch (Throwable localThrowable)
      {
        if (QMLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("initLiuHaiProperty manufacturer:");
          localStringBuilder2.append(Build.MANUFACTURER);
          QMLog.e("LiuHaiUtils", localStringBuilder2.toString(), localThrowable);
        }
      }
      if (sHasNotch) {
        sNotchHeight = getNotchInScreenHeight(paramActivity);
      }
      hasInitHasNotch = true;
    }
    sEnableNotchOK = false;
    if (sHasNotch)
    {
      sEnableNotchOK = enableNotchInScreen(paramActivity);
      if (sNotchHeight <= 0) {
        sEnableNotchOK = false;
      }
    }
    if (QMLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiProperty[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" hasInitHasNotch:");
      paramActivity.append(hasInitHasNotch);
      paramActivity.append(" sHasNotch:");
      paramActivity.append(sHasNotch);
      paramActivity.append(" sEnableNotchOK:");
      paramActivity.append(sEnableNotchOK);
      paramActivity.append(" sNotchHeight:");
      paramActivity.append(sNotchHeight);
      QMLog.i("LiuHaiUtils", paramActivity.toString());
    }
  }
  
  public static boolean isInNotchWhiteList()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString().toLowerCase();
    return NOTCH_WHITE_LIST.contains(localObject);
  }
  
  private static boolean isLiuHaiModel()
  {
    String str = Build.MODEL;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = LIUHAI_LIST;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isLiuHaiUseValid()
  {
    return (sHasNotch) && (sEnableNotchOK) && (sNotchHeight > 0);
  }
  
  private static boolean isNoneSupportedPhone()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (Build.VERSION.SDK_INT > 27) {
      return true;
    }
    String[] arrayOfString = MANUFACTURER;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (((String)localObject).equalsIgnoreCase(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isSamsungFolderMobile()
  {
    String str = Build.MODEL.toUpperCase();
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      bool1 = bool2;
      if (str.contains("SM-F9000")) {
        bool1 = true;
      }
    }
    return bool1;
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
    }
    catch (Throwable paramContext)
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty exp ", paramContext);
      }
      paramContext = null;
    }
    if (TextUtils.isEmpty(paramContext))
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("LiuHaiUtils", "oppoGetNotchSize mProperty empty");
      }
      return null;
    }
    paramContext = paramContext.split(":");
    Object localObject;
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("oppoGetNotchSize mProperty values=");
      ((StringBuilder)localObject).append(paramContext);
      QMLog.i("LiuHaiUtils", ((StringBuilder)localObject).toString());
    }
    if (paramContext.length >= 2)
    {
      localObject = paramContext[0].split(",");
      StringBuilder localStringBuilder;
      if (QMLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("oppoGetNotchSize mProperty values[0] size=");
        localStringBuilder.append(localObject);
        QMLog.i("LiuHaiUtils", localStringBuilder.toString());
      }
      if (localObject.length < 2) {
        return null;
      }
      try
      {
        int i = Integer.valueOf(localObject[0]).intValue();
        int j = Integer.valueOf(localObject[1]).intValue();
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("oppoGetNotchSize mProperty values[0] left=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" top=");
          ((StringBuilder)localObject).append(j);
          QMLog.i("LiuHaiUtils", ((StringBuilder)localObject).toString());
        }
        localObject = paramContext[1].split(",");
        if (QMLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("oppoGetNotchSize mProperty values[1] size=");
          localStringBuilder.append(localObject);
          QMLog.i("LiuHaiUtils", localStringBuilder.toString());
        }
        if (localObject.length < 2) {
          return null;
        }
        try
        {
          int k = Integer.valueOf(localObject[0]).intValue();
          int m = Integer.valueOf(localObject[1]).intValue();
          if (QMLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("oppoGetNotchSize mProperty values[1] right=");
            paramContext.append(k);
            paramContext.append(" bottom=");
            paramContext.append(m);
            QMLog.i("LiuHaiUtils", paramContext.toString());
          }
          return new int[] { k - i, m - j };
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          if (QMLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("oppoGetNotchSize values[1]=");
            localStringBuilder.append(paramContext[1]);
            QMLog.i("LiuHaiUtils", localStringBuilder.toString(), localNumberFormatException1);
          }
          return null;
        }
        return null;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        if (QMLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("oppoGetNotchSize values[0]=");
          localStringBuilder.append(paramContext[0]);
          QMLog.i("LiuHaiUtils", localStringBuilder.toString(), localNumberFormatException2);
        }
      }
    }
  }
  
  private static boolean oppoHasNotchInScreen(Context paramContext)
  {
    if (Build.MODEL.equals("PAAM00")) {
      return true;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    if (QMLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("oppoHasNotchInScreen exits:");
      paramContext.append(bool);
      QMLog.i("LiuHaiUtils", paramContext.toString());
    }
    return bool;
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool3;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      bool1 = bool2;
      bool2 = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      bool1 = bool2;
      bool3 = bool2;
      if (QMLog.isColorLevel())
      {
        bool1 = bool2;
        paramContext = new StringBuilder();
        bool1 = bool2;
        paramContext.append("vivoHasNotchInScreen ret=");
        bool1 = bool2;
        paramContext.append(bool2);
        bool1 = bool2;
        QMLog.i("LiuHaiUtils", paramContext.toString());
        return bool2;
      }
    }
    catch (Exception paramContext)
    {
      bool3 = bool1;
      if (QMLog.isColorLevel())
      {
        QMLog.e("LiuHaiUtils", "vivoHasNotchInScreen Exception", paramContext);
        bool3 = bool1;
      }
    }
    return bool3;
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
    StringBuilder localStringBuilder;
    if (QMLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_width]resourceId: ");
      localStringBuilder.append(i);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QMLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_height]resourceId: ");
      localStringBuilder.append(i);
      QMLog.i("LiuHaiUtils", localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
    }
    if (QMLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("xiaomiGetNotchSize width: ");
      paramContext.append(arrayOfInt[0]);
      paramContext.append(" height:");
      paramContext.append(arrayOfInt[1]);
      QMLog.i("LiuHaiUtils", paramContext.toString());
    }
    return arrayOfInt;
  }
  
  @TargetApi(17)
  private static boolean xiaomiHasNotchInScreen(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17) {
          break label137;
        }
        i = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i == 1)
        {
          if (!QMLog.isColorLevel()) {
            break;
          }
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen closed: ");
          paramContext.append(i);
          QMLog.i("LiuHaiUtils", paramContext.toString());
          return false;
        }
        i = getSystemPropertyForXiaomi("ro.miui.notch", 0);
        if (QMLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen isNotch: ");
          paramContext.append(i);
          QMLog.i("LiuHaiUtils", paramContext.toString());
        }
        if (i == 1) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        if (QMLog.isColorLevel()) {
          QMLog.i("LiuHaiUtils", "xiaomiHasNotchInScreen crash: ", paramContext);
        }
      }
      return false;
      label137:
      int i = 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils
 * JD-Core Version:    0.7.0.1
 */