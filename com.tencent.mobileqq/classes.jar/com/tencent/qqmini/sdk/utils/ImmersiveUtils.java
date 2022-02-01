package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.OSUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class ImmersiveUtils
{
  private static final String ISMIUI = "1";
  public static final int OPPO_NOTCH_HEIGHT = 80;
  public static final int SHARP_NOTCH_HEIGHT = 121;
  public static final String TAG = "ImmersiveUtils";
  private static float density;
  public static int notchHeight = -1;
  private static int screenHeight;
  private static int screenWidth;
  public static int statusHeight = -1;
  
  static
  {
    density = -1.0F;
    screenWidth = -1;
    screenHeight = -1;
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
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (paramBoolean) {}
      for (int i = j;; i = 0)
      {
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        return true;
      }
      return false;
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static float getDensity()
  {
    init();
    return density;
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
      Rect localRect = getDisplayCutoutSafeInsets(paramActivity.getWindow().getDecorView());
      localRect.top = getNotchHeight(paramActivity, paramActivity);
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
        QMLog.e("ImmersiveUtils", "getDisplayCutoutSafeArea", paramActivity);
      }
      paramActivity = paramActivity.getWindow().getDecorView().getResources().getDisplayMetrics();
      break;
      QMLog.w("ImmersiveUtils", "getDisplayCutoutSafeArea use all zero values");
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
    }
    return localJSONObject;
  }
  
  @NonNull
  public static Rect getDisplayCutoutSafeInsets(View paramView)
  {
    Rect localRect = new Rect();
    QMLog.d("ImmersiveUtils", "Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramView = JarReflectUtil.callSpecifiedMethod(paramView, "getRootWindowInsets", false, null, new Object[0]);
        QMLog.d("ImmersiveUtils", "insets:" + paramView);
        Object localObject3 = JarReflectUtil.callSpecifiedMethod(paramView, "getDisplayCutout", false, null, new Object[0]);
        if (localObject3 == null)
        {
          QMLog.d("ImmersiveUtils", "displayCutout == null");
          return localRect;
        }
        paramView = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetTop", false, null, new Object[0]);
        Object localObject1 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetBottom", false, null, new Object[0]);
        Object localObject2 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetLeft", false, null, new Object[0]);
        localObject3 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetRight", false, null, new Object[0]);
        QMLog.d("ImmersiveUtils", "safeInsetTop:" + paramView + " safeInsetBottom:" + localObject1 + " safeInsetLeft:" + localObject2 + " safeInsetRight:" + localObject3);
        if ((localObject2 instanceof Integer)) {
          localRect.left = ((Integer)localObject2).intValue();
        }
        if ((localObject1 instanceof Integer)) {
          localRect.bottom = ((Integer)localObject1).intValue();
        }
        if ((localObject3 instanceof Integer)) {
          localRect.right = ((Integer)localObject3).intValue();
        }
        if ((paramView instanceof Integer))
        {
          localRect.top = ((Integer)paramView).intValue();
          return localRect;
        }
      }
      catch (Exception paramView)
      {
        QMLog.e("ImmersiveUtils", "" + paramView);
      }
    }
    return localRect;
  }
  
  private static void getGoogleApi(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null)) {
      notchHeight = getDisplayCutoutSafeInsets(paramActivity.getWindow().getDecorView()).top;
    }
  }
  
  public static int getNotchHeight(Context paramContext, Activity paramActivity)
  {
    if (notchHeight != -1)
    {
      QMLog.d("ImmersiveUtils", "has notchHeight:" + notchHeight);
      return notchHeight;
    }
    QMLog.d("ImmersiveUtils", "Build.MODEL:" + Build.MODEL);
    if (hasNotchInVivo(paramContext)) {
      notchHeight = DisplayUtil.dip2px(paramContext, 27.0F);
    }
    for (;;)
    {
      return notchHeight;
      if (hasNotchInOppo(paramContext))
      {
        if (Build.VERSION.SDK_INT >= 28) {
          getGoogleApi(paramActivity);
        }
        if ((notchHeight == 0) || (notchHeight == -1)) {
          notchHeight = 80;
        }
      }
      else if (hasNotchInHuaWei(paramContext))
      {
        notchHeight = getNotchSizeInHuaWei(paramContext)[1];
      }
      else if ((hasNotchInXiaoMi(paramContext)) || (hasNotchInSmartisan(paramContext)) || (isSpecialDevices()))
      {
        notchHeight = getNotchSizeInStatusBar(paramContext);
      }
      else if (isSharpS2())
      {
        notchHeight = 121;
      }
      else
      {
        getGoogleApi(paramActivity);
      }
    }
  }
  
  public static int[] getNotchSizeInHuaWei(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "getNotchSize ClassNotFoundException");
      return arrayOfInt;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "getNotchSize NoSuchMethodException");
      return arrayOfInt;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "getNotchSize Exception");
      return arrayOfInt;
    }
    finally {}
    return arrayOfInt;
  }
  
  private static int getNotchSizeInStatusBar(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public static String getReflectString(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { new String(paramString1), new String(paramString2) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return paramString2;
    }
    catch (IllegalArgumentException paramContext) {}
    return paramString2;
  }
  
  public static int getScreenHeight()
  {
    init();
    return screenHeight;
  }
  
  public static int getScreenWidth()
  {
    init();
    return screenWidth;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    float f2 = 1.0F;
    int i = 0;
    float f1;
    if (statusHeight == -1)
    {
      Resources localResources = paramContext.getResources();
      int j = localResources.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = localResources.getDimensionPixelSize(j);
      }
      f1 = ViewUtils.getDensity();
      if (QMLog.isColorLevel()) {
        QMLog.d("systembar", "getStatusBarHeight org=" + i + ", sys density=" + f1 + ", cur density=" + paramContext.getResources().getDisplayMetrics().density);
      }
      f1 /= paramContext.getResources().getDisplayMetrics().density;
      if (i > 0) {
        break label162;
      }
      if (f1 > 0.0F) {
        break label159;
      }
      f1 = 1.0F;
    }
    label159:
    for (;;)
    {
      i = ViewUtils.dpToPx(f1 * 25.0F);
      statusHeight = i;
      return statusHeight;
    }
    label162:
    float f3 = i;
    if (f1 <= 0.0F) {
      f1 = f2;
    }
    for (;;)
    {
      i = (int)Math.ceil(f3 * f1 + 0.5F);
      break;
    }
  }
  
  public static boolean hasNotchInHuaWei(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "hasNotchInScreen ClassNotFoundException");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "hasNotchInScreen NoSuchMethodException");
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QMLog.e("ImmersiveUtils", "hasNotchInScreen Exception");
      return false;
    }
    finally {}
    return false;
  }
  
  public static boolean hasNotchInOppo(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static boolean hasNotchInSmartisan(Context paramContext)
  {
    try
    {
      paramContext = JarReflectUtil.callSpecifiedStaticMethod("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(1) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QMLog.e("ImmersiveUtils", "" + paramContext);
    }
    return false;
  }
  
  public static boolean hasNotchInVivo(Context paramContext)
  {
    try
    {
      paramContext = JarReflectUtil.callSpecifiedStaticMethod("android.util.FtFeature", "isFeatureSupport", false, getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(32) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QMLog.e("ImmersiveUtils", "" + paramContext);
    }
    return false;
  }
  
  public static boolean hasNotchInXiaoMi(Context paramContext)
  {
    paramContext = getReflectString(paramContext, "ro.miui.notch", "0");
    if (paramContext != null) {
      return paramContext.equals("1");
    }
    return false;
  }
  
  private static void init()
  {
    DisplayMetrics localDisplayMetrics;
    if (density == -1.0F)
    {
      localDisplayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      density = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        screenWidth = localDisplayMetrics.widthPixels;
        screenHeight = localDisplayMetrics.heightPixels;
      }
    }
    else
    {
      return;
    }
    screenHeight = localDisplayMetrics.widthPixels;
    screenWidth = localDisplayMetrics.heightPixels;
  }
  
  private static boolean isLenovo()
  {
    return Build.MODEL.endsWith("L78011");
  }
  
  private static boolean isOnePlus()
  {
    return "GM1910".equals(Build.MODEL);
  }
  
  private static boolean isSMF9000()
  {
    return "SM-F9000".equals(Build.MODEL);
  }
  
  private static boolean isSharpS2()
  {
    return "FS8010".equals(Build.MODEL);
  }
  
  private static boolean isSpecialDevices()
  {
    return (isLenovo()) || (isOnePlus()) || (isSMF9000()) || ("Pixel 3 XL".equals(Build.MODEL)) || ("NX606J".equals(Build.MODEL));
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
  
  private static boolean setStatusBarDarkModeForFlyme(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramWindow != null) {
      for (;;)
      {
        try
        {
          WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
          Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
          Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
          localField1.setAccessible(true);
          localField2.setAccessible(true);
          i = localField1.getInt(null);
          j = localField2.getInt(localLayoutParams);
          if (!paramBoolean) {
            continue;
          }
          i |= j;
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
        }
        catch (Exception localException)
        {
          int j;
          QMLog.e("ImmersiveUtils", "setStatusBarDarkModeForFlyme: failed");
          bool = false;
          continue;
          int i = j & 0xFFFFDFFF;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramWindow = paramWindow.getDecorView();
          if (paramWindow != null)
          {
            j = paramWindow.getSystemUiVisibility();
            if (!paramBoolean) {
              continue;
            }
            i = j | 0x2000;
            if (i != j) {
              paramWindow.setSystemUiVisibility(i);
            }
          }
        }
        return bool;
        i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */