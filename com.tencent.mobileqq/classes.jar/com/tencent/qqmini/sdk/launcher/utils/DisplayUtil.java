package com.tencent.qqmini.sdk.launcher.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MiniKeep
public class DisplayUtil
{
  private static final String NAVIGATION = "navigationBarBackground";
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  public static final String STATUS_BAR_HEIGHT = "status_bar_height";
  public static final String TAG = "DisplayUtil";
  private static float density = 0.0F;
  public static final boolean isImmersiveSupported = false;
  private static boolean mInPortrait = true;
  private static int mhasNavBar = -1;
  private static String sNavBarOverride;
  public static int statusHeight = -1;
  
  static
  {
    if (VersionUtil.isKITKAT()) {}
    try
    {
      localObject1 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      sNavBarOverride = (String)((Method)localObject1).invoke(null, new Object[] { "qemu.hw.mainkeys" });
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      label54:
      Object localObject2;
      break label54;
    }
    sNavBarOverride = null;
    if (Build.VERSION.SDK_INT < 19)
    {
      isImmersiveSupported = false;
      return;
    }
    localObject1 = Build.MANUFACTURER.toUpperCase();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(Build.MODEL);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((!((String)localObject1).endsWith("BBK")) && ((!((String)localObject1).endsWith("VIVO")) || (Build.VERSION.SDK_INT >= 20)) && (!((String)localObject2).equals("OPPO-3007")))
    {
      isImmersiveSupported = true;
      return;
    }
  }
  
  private static void checkImmersiveStatusBar(Window paramWindow)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) || (isVivoAndLOLLIPOP()))
      {
        paramWindow.clearFlags(67108864);
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramWindow.setStatusBarColor(0);
          return;
        }
      }
    }
    catch (Exception paramWindow)
    {
      QMLog.e("DisplayUtil", "", paramWindow);
    }
  }
  
  public static boolean checkNavigationBarShow(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1;
    if (i > 0) {
      bool1 = ((Resources)localObject).getBoolean(i);
    } else {
      bool1 = false;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
      i = Build.VERSION.SDK_INT;
      if (i < 21) {
        i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      } else {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      }
      if ((!"1".equals(localObject)) && (1 != i))
      {
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
  
  public static void clearCoverForStatus(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(", MODEL = ");
      localStringBuilder.append(Build.MODEL);
      QMLog.i("DisplayUtil", localStringBuilder.toString());
      if ((localObject != null) && ((((String)localObject).equals("MeizuPRO 7-S")) || (((String)localObject).equalsIgnoreCase("MeizuM711C"))))
      {
        setTranslucentStatus(paramWindow);
        return;
      }
      checkImmersiveStatusBar(paramWindow);
    }
  }
  
  @TargetApi(23)
  private static void compatHighMIUI(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
  }
  
  private static boolean compatLowMIUI(Window paramWindow, boolean paramBoolean)
  {
    Object localObject = paramWindow.getClass();
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          i = j;
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return true;
        }
      }
      catch (Exception paramWindow)
      {
        paramWindow.printStackTrace();
        return false;
      }
      int i = 0;
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private static boolean enableXiaoMiNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(1792) });
      if (QMLog.isColorLevel()) {
        QMLog.i("Window", "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("Window", "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  public static float getDensity(Context paramContext)
  {
    float f = density;
    if (f != 0.0F) {
      return f;
    }
    if (paramContext != null)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      density = paramContext.density;
      return paramContext.density;
    }
    throw new IllegalArgumentException("");
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    return paramContext.getResources().getDisplayMetrics();
  }
  
  private static int getInternalDimensionSize(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier(paramString, "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (mInPortrait) {
        paramContext = "navigation_bar_height";
      } else {
        paramContext = "navigation_bar_height_landscape";
      }
      return getInternalDimensionSize(localResources, paramContext);
    }
    return 0;
  }
  
  public static int getRealHeight(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      int i;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
      }
      else
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        try
        {
          i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        }
        catch (InvocationTargetException paramContext)
        {
          QMLog.e("DisplayUtil", paramContext.getMessage());
          return -1;
        }
        catch (IllegalAccessException paramContext)
        {
          QMLog.e("DisplayUtil", paramContext.getMessage());
          return -1;
        }
        catch (IllegalArgumentException paramContext)
        {
          QMLog.e("DisplayUtil", paramContext.getMessage());
          return -1;
        }
      }
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      QMLog.e("DisplayUtil", paramContext.getMessage());
      return -1;
    }
  }
  
  public static int getScreenHeight(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    else
    {
      localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    }
    int i;
    if (((hasNavBar(paramActivity)) && (isNavigationBarExist(paramActivity))) || (isFlymeOS7NavBarShow())) {
      i = 1;
    } else {
      i = 0;
    }
    int k = localDisplayMetrics.heightPixels;
    int j = k;
    if (i != 0) {
      j = k - getNavigationBarHeight(paramActivity);
    }
    return j;
  }
  
  public static int getScreenRefreshRate(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = ((DisplayManager)paramContext.getSystemService("display")).getDisplays();
      if ((paramContext != null) && (paramContext.length > 0)) {
        return (int)paramContext[0].getRefreshRate();
      }
    }
    return 60;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      return paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    if (statusHeight == -1)
    {
      int i = 0;
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      float f3 = paramContext.getDisplayMetrics().density;
      float f2 = f3 / paramContext.getDisplayMetrics().density;
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 1.0F;
      }
      if (i <= 0) {
        i = Math.round(f1 * 25.0F * f3);
      } else {
        i = (int)Math.ceil(i * f1 + 0.5F);
      }
      statusHeight = i;
    }
    return statusHeight;
  }
  
  public static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean hasNavBar(Context paramContext)
  {
    int i = mhasNavBar;
    if (i != -1) {
      return i == 1;
    }
    Resources localResources = paramContext.getResources();
    i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if (!"1".equals(sNavBarOverride))
      {
        if (!"0".equals(sNavBarOverride)) {
          break label97;
        }
        bool = true;
        break label97;
      }
    }
    else if (Build.VERSION.SDK_INT >= 14)
    {
      bool = ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
      break label97;
    }
    boolean bool = false;
    label97:
    paramContext = new StringBuilder();
    paramContext.append("hasNavbar=");
    paramContext.append(bool);
    QMLog.d("XPanelContainer", paramContext.toString());
    if (bool)
    {
      mhasNavBar = 1;
      return bool;
    }
    mhasNavBar = 0;
    return bool;
  }
  
  public static boolean isFlymeOS7NavBarShow()
  {
    String str = getSystemProperty("ro.build.display.id", "");
    if (("Flyme 7.1.1.4A".equals(str)) || ("Flyme 7.3.0.0A".equals(str)))
    {
      if (("1".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mainkeys", "0")))) {
        return true;
      }
      if (("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNavigationBarExist(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId())))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      return localPoint2.y != localPoint1.y;
    }
    boolean bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    if (!bool1) {
      return !bool2;
    }
    return false;
  }
  
  public static boolean isVivoAndLOLLIPOP()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  public static float mpx2px(double paramDouble)
  {
    double d = density;
    Double.isNaN(d);
    return (float)(paramDouble * d);
  }
  
  public static int mpx2pxInt(double paramDouble)
  {
    double d = density;
    Double.isNaN(d);
    return (int)(paramDouble * d + 0.5D);
  }
  
  public static int parseColor(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.length() == 4)
      {
        str1 = paramString;
        if (paramString.substring(0, 1).equals("#"))
        {
          str1 = paramString.substring(1, 2);
          String str2 = paramString.substring(2, 3);
          paramString = paramString.substring(3, 4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("#");
          localStringBuilder.append(str1);
          localStringBuilder.append(str1);
          localStringBuilder.append(str2);
          localStringBuilder.append(str2);
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramString);
          str1 = localStringBuilder.toString();
        }
      }
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static boolean processMIUI(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      compatHighMIUI(paramWindow, paramBoolean);
      return true;
    }
    return compatLowMIUI(paramWindow, paramBoolean);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static float px2mpx(double paramDouble)
  {
    double d = density;
    Double.isNaN(d);
    return (float)(paramDouble / d);
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  public static void setActivityTransparent(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFormat(-2);
    LiuHaiUtils.initLiuHaiProperty(paramActivity);
    if (LiuHaiUtils.isLiuHaiUseValid())
    {
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)))
      {
        enableXiaoMiNotch(paramActivity);
        return;
      }
      LiuHaiUtils.enableNotch(paramActivity);
    }
  }
  
  private static boolean setStatusBarDarkModeForFlyme(Window paramWindow, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWindow != null) {}
    try
    {
      localLayoutParams = paramWindow.getAttributes();
      Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
      localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
      localField1.setAccessible(true);
      localField2.setAccessible(true);
      i = localField1.getInt(null);
      j = localField2.getInt(localLayoutParams);
      if (!paramBoolean) {
        break label179;
      }
      i |= j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams;
        Field localField2;
        int j;
        continue;
        int i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    localField2.setInt(localLayoutParams, i);
    paramWindow.setAttributes(localLayoutParams);
    bool1 = true;
    break label104;
    QMLog.e("DisplayUtil", "setStatusBarDarkModeForFlyme: failed");
    label104:
    bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow = paramWindow.getDecorView();
      bool2 = bool1;
      if (paramWindow != null)
      {
        j = paramWindow.getSystemUiVisibility();
        if (paramBoolean) {
          i = j | 0x2000;
        } else {
          i = j & 0xFFFFDFFF;
        }
        bool2 = bool1;
        if (i != j)
        {
          paramWindow.setSystemUiVisibility(i);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public static boolean setStatusTextColor(boolean paramBoolean, Window paramWindow)
  {
    if (OSUtils.isFlymeOS()) {
      return setStatusBarDarkModeForFlyme(paramWindow, paramBoolean);
    }
    if (OSUtils.isMIUI()) {
      return processMIUI(paramWindow, paramBoolean);
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWindow.getDecorView().setSystemUiVisibility(9216);
        return true;
      }
    }
    else if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      return true;
    }
    return false;
  }
  
  public static void setSystemUIVisible(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
        localLayoutParams.flags &= 0xFFFFFBFF;
        paramActivity.getWindow().setAttributes(localLayoutParams);
        paramActivity.getWindow().clearFlags(512);
        return;
      }
      catch (Exception paramActivity)
      {
        QMLog.e("DisplayUtil", "void setSystemUIVisible", paramActivity);
        return;
      }
    }
    LiuHaiUtils.initLiuHaiProperty(paramActivity);
    if (LiuHaiUtils.isLiuHaiUseValid()) {
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27))) {
        enableXiaoMiNotch(paramActivity);
      } else {
        LiuHaiUtils.enableNotch(paramActivity);
      }
    }
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public static void setTranslucentStatus(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Field localField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
      localField.setAccessible(true);
      localField.setInt(paramWindow.getDecorView(), 0);
      return;
    }
    catch (Exception paramWindow)
    {
      label36:
      break label36;
    }
    QMLog.i("DisplayUtil", "反射修改状态栏颜色失败");
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void updatePortrait(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      int i = paramActivity.getWindow().getContext().getResources().getConfiguration().orientation;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      mInPortrait = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */