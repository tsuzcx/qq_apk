package com.tencent.mobileqq.mini.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;
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
  private static boolean mInPortrait = true;
  private static int mhasNavBar = -1;
  private static String sNavBarOverride;
  
  static
  {
    if (VersionUtils.i()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
    }
    catch (Throwable localThrowable)
    {
      label54:
      break label54;
    }
    sNavBarOverride = null;
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
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
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
  
  public static JSONObject getDisplayCutoutSafeArea(Activity paramActivity)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    int i1;
    int k;
    int m;
    int n;
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
      }
      else
      {
        paramActivity = paramActivity.getWindow().getDecorView().getResources().getDisplayMetrics();
      }
      i1 = localRect.left;
      i = localRect.top;
      k = localRect.right;
      m = localRect.bottom;
      n = paramActivity.widthPixels - localRect.left - localRect.right;
      j = paramActivity.heightPixels - localRect.top - localRect.bottom;
    }
    else
    {
      QLog.w("DisplayUtil", 1, "getDisplayCutoutSafeArea use all zero values");
      i1 = 0;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
    }
    try
    {
      localJSONObject.put("left", i1);
      localJSONObject.put("top", i);
      localJSONObject.put("right", k);
      localJSONObject.put("bottom", m);
      localJSONObject.put("width", n);
      localJSONObject.put("height", j);
      return localJSONObject;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("DisplayUtil", 1, "getDisplayCutoutSafeArea", paramActivity);
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
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalAccessException paramContext)
        {
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
        catch (IllegalArgumentException paramContext)
        {
          QLog.e("DisplayUtil", 2, paramContext.getMessage());
          return -1;
        }
      }
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      QLog.e("DisplayUtil", 2, paramContext.getMessage());
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
    int i = Build.VERSION.SDK_INT;
    int m = 1;
    if (i >= 17) {
      if ((!checkHasNavigationBar(paramActivity)) || (!isNavigationBarExist(paramActivity))) {}
    }
    for (;;)
    {
      i = 1;
      break;
      do
      {
        i = 0;
        break label109;
        if ((hasNavBar(paramActivity)) && (isNavigationBarExist(paramActivity))) {
          break;
        }
      } while (!isFlymeOS7NavBarShow());
    }
    label109:
    int n = localDisplayMetrics.heightPixels;
    int j = n;
    int k = i;
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
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            m = 0;
          }
          j = n;
          k = i;
          if (m != 0)
          {
            j = ScreenUtil.getRealHeight(BaseApplication.getContext());
            k = 0;
          }
        }
      }
    }
    i = j;
    if (k != 0) {
      i = j - getNavigationBarHeight(paramActivity);
    }
    return i;
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
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasNavbar=");
      paramContext.append(bool);
      QLog.d("XPanelContainer", 2, paramContext.toString());
    }
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
  
  public static boolean isNavigationBarExist(@NonNull Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        boolean bool;
        try
        {
          bool = "navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()));
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          QLog.w("DisplayUtil", 1, "isNavigationBarExist error", localNotFoundException);
          bool = false;
        }
        if ((localViewGroup.getChildAt(i).getId() != -1) && (bool)) {
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
  
  public static void setStatusBarTextColor(Activity paramActivity)
  {
    if (ThemeUtil.isDefaultTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
      return;
    }
    if (ThemeUtil.isGoldenTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
      return;
    }
    if (isWhiteModeTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
      return;
    }
    if (isSimpleThemeAndStatusBarOfWhite(ThemeUtil.getCurrentThemeId()))
    {
      ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(ThemeUtil.isDartStatusBar(paramActivity, 2131167331), paramActivity.getWindow());
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
    LiuHaiUtils.f(paramBaseActivity);
    if (LiuHaiUtils.b()) {
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27))) {
        enableXiaoMiNotch(paramBaseActivity);
      } else {
        LiuHaiUtils.enableNotch(paramBaseActivity);
      }
    }
    paramBaseActivity.getWindow().setFlags(1024, 1024);
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
 * Qualified Name:     com.tencent.mobileqq.mini.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */