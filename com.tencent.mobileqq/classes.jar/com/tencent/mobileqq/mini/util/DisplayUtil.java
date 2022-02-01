package com.tencent.mobileqq.mini.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayUtil
{
  private static final String NAVIGATION = "navigationBarBackground";
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  public static final String TAG = "DisplayUtil";
  private static float density;
  private static boolean mInPortrait;
  private static int mhasNavBar;
  private static String sNavBarOverride;
  
  static
  {
    if (VersionUtils.isKITKAT()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      mInPortrait = true;
      mhasNavBar = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        sNavBarOverride = null;
      }
    }
  }
  
  @TargetApi(17)
  public static boolean checkHasNavigationBar(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    paramActivity.getSize(localPoint1);
    paramActivity.getRealSize(localPoint2);
    return localPoint1.y != localPoint2.y;
  }
  
  public static boolean checkNavigationBarShow(@NonNull Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {}
    for (boolean bool1 = ((Resources)localObject).getBoolean(i);; bool1 = false)
    {
      try
      {
        localObject = Class.forName("android.os.SystemProperties");
        localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
        if (Build.VERSION.SDK_INT < 21) {}
        for (i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);; i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0))
        {
          if ("1".equals(localObject)) {
            break label146;
          }
          if (1 != i) {
            break;
          }
          break label146;
        }
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return bool1;
      }
      return bool1;
    }
    label146:
    return false;
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static boolean enableXiaoMiNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(1792) });
      if (QLog.isColorLevel()) {
        QLog.i("DisplayUtil", 1, "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DisplayUtil", 1, "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  public static float getDensity(Context paramContext)
  {
    if (density != 0.0F) {
      return density;
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("");
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    density = paramContext.density;
    return paramContext.density;
  }
  
  public static JSONObject getDisplayCutoutSafeArea(Activity paramActivity)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    int i1;
    int n;
    int m;
    int k;
    int j;
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = SystemUtil.getDisplayCutoutSafeInsets(paramActivity.getWindow().getDecorView());
      localRect.top = SystemUtil.getNotchHeight(paramActivity, paramActivity);
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        paramActivity = localDisplayMetrics;
        i1 = localRect.left;
        n = localRect.top;
        m = localRect.right;
        k = localRect.bottom;
        j = paramActivity.widthPixels - localRect.left - localRect.right;
        i = paramActivity.heightPixels - localRect.top - localRect.bottom;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("left", i1);
        localJSONObject.put("top", n);
        localJSONObject.put("right", m);
        localJSONObject.put("bottom", k);
        localJSONObject.put("width", j);
        localJSONObject.put("height", i);
        return localJSONObject;
      }
      catch (JSONException paramActivity)
      {
        QLog.e("DisplayUtil", 1, "getDisplayCutoutSafeArea", paramActivity);
      }
      paramActivity = paramActivity.getWindow().getDecorView().getResources().getDisplayMetrics();
      break;
      QLog.w("DisplayUtil", 1, "getDisplayCutoutSafeArea use all zero values");
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
    }
    return localJSONObject;
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
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!mInPortrait) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = getInternalDimensionSize(localResources, paramContext);
      return i;
    }
  }
  
  public static int getRealHeight(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        QLog.e("DisplayUtil", 2, paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        QLog.e("DisplayUtil", 2, paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        QLog.e("DisplayUtil", 2, paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        QLog.e("DisplayUtil", 2, paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static int getScreenHeight(Activity paramActivity)
  {
    int m = 1;
    DisplayMetrics localDisplayMetrics;
    int i;
    label64:
    int n;
    int j;
    int k;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 17) {
        break label209;
      }
      if ((!checkHasNavigationBar(paramActivity)) || (!isNavigationBarExist(paramActivity))) {
        break label204;
      }
      i = 1;
      n = localDisplayMetrics.heightPixels;
      j = n;
      k = i;
      if (Build.MANUFACTURER.contains("Xiaomi")) {
        if ((!Build.MODEL.contains("MIX 2S")) && (!Build.MODEL.contains("MI 8")))
        {
          j = n;
          k = i;
          if (!Build.MODEL.contains("MIX 2")) {}
        }
        else
        {
          j = n;
          k = i;
          if (Build.VERSION.SDK_INT >= 21) {
            if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
              break label239;
            }
          }
        }
      }
    }
    for (;;)
    {
      j = n;
      k = i;
      if (m != 0)
      {
        j = ScreenUtil.getRealHeight(BaseApplication.getContext());
        k = 0;
      }
      i = j;
      if (k != 0) {
        i = j - getNavigationBarHeight(paramActivity);
      }
      return i;
      localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      break;
      label204:
      i = 0;
      break label64;
      label209:
      if (((hasNavBar(paramActivity)) && (isNavigationBarExist(paramActivity))) || (isFlymeOS7NavBarShow()))
      {
        i = 1;
        break label64;
      }
      i = 0;
      break label64;
      label239:
      m = 0;
    }
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
  
  public static int getStatusBarHeight(Context paramContext)
  {
    return (int)(ImmersiveUtils.getStatusBarHeight(paramContext) / getDensity(paramContext) + 0.5F);
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
    if (mhasNavBar != -1) {
      return mhasNavBar == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(sNavBarOverride)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "hasNavbar=" + bool);
      }
      if (bool) {}
      for (mhasNavBar = 1;; mhasNavBar = 0)
      {
        return bool;
        if (!"0".equals(sNavBarOverride)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label151;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label151:
      bool = false;
    }
  }
  
  public static boolean isFlymeOS7NavBarShow()
  {
    String str = getSystemProperty("ro.build.display.id", "");
    if (("Flyme 7.1.1.4A".equals(str)) || ("Flyme 7.3.0.0A".equals(str)))
    {
      if (("1".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mainkeys", "0")))) {}
      while (("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNavigationBarExist(@NonNull Activity paramActivity)
  {
    boolean bool2 = false;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    boolean bool1 = bool2;
    int i;
    if (localViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId())))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
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
      if (localPoint2.y == localPoint1.y) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean isSimpleThemeAndStatusBarOfWhite(String paramString)
  {
    return ("3063".equals(paramString)) || ("3066".equals(paramString)) || ("3065".equals(paramString)) || ("3067".equals(paramString)) || ("3491".equals(paramString));
  }
  
  public static boolean isWhiteModeTheme()
  {
    return "2105".equals(ThemeUtil.getCurrentThemeId());
  }
  
  public static float mpx2px(double paramDouble)
  {
    return (float)(density * paramDouble);
  }
  
  public static int mpx2pxInt(double paramDouble)
  {
    return (int)(density * paramDouble + 0.5D);
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
          str1 = "#" + str1 + str1 + str2 + str2 + paramString + paramString;
        }
      }
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static float px2mpx(double paramDouble)
  {
    return (float)(paramDouble / density);
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
  
  public static void setStatusBarTextColor(Activity paramActivity)
  {
    if (ThemeUtil.isDefaultTheme())
    {
      ImmersiveUtils.a(false, paramActivity.getWindow());
      return;
    }
    if (ThemeUtil.isGoldenTheme())
    {
      ImmersiveUtils.a(false, paramActivity.getWindow());
      return;
    }
    if (isWhiteModeTheme())
    {
      ImmersiveUtils.a(false, paramActivity.getWindow());
      return;
    }
    if (isSimpleThemeAndStatusBarOfWhite(ThemeUtil.getCurrentThemeId()))
    {
      ImmersiveUtils.a(false, paramActivity.getWindow());
      return;
    }
    ImmersiveUtils.a(ThemeUtil.isDartStatusBar(paramActivity), paramActivity.getWindow());
  }
  
  public static void setSystemUIVisible(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WindowManager.LayoutParams localLayoutParams = paramBaseActivity.getWindow().getAttributes();
      localLayoutParams.flags &= 0xFFFFFBFF;
      paramBaseActivity.getWindow().setAttributes(localLayoutParams);
      paramBaseActivity.getWindow().clearFlags(512);
      return;
    }
    LiuHaiUtils.a(paramBaseActivity);
    if (LiuHaiUtils.b())
    {
      if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))) {
        break label100;
      }
      enableXiaoMiNotch(paramBaseActivity);
    }
    for (;;)
    {
      paramBaseActivity.getWindow().setFlags(1024, 1024);
      return;
      label100:
      LiuHaiUtils.enableNotch(paramBaseActivity);
    }
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static void updatePortrait(Activity paramActivity)
  {
    boolean bool = true;
    if (paramActivity != null) {
      if (paramActivity.getWindow().getContext().getResources().getConfiguration().orientation != 1) {
        break label31;
      }
    }
    for (;;)
    {
      mInPortrait = bool;
      return;
      label31:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */