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
  private static float density = -1.0F;
  public static int notchHeight = -1;
  private static int screenHeight = -1;
  private static int screenWidth = -1;
  public static int statusHeight = -1;
  
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
  
  public static float getDensity()
  {
    init();
    return density;
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
      Rect localRect = getDisplayCutoutSafeInsets(paramActivity.getWindow().getDecorView());
      localRect.top = getNotchHeight(paramActivity, paramActivity);
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
      QMLog.w("ImmersiveUtils", "getDisplayCutoutSafeArea use all zero values");
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
      QMLog.e("ImmersiveUtils", "getDisplayCutoutSafeArea", paramActivity);
    }
    return localJSONObject;
  }
  
  @NonNull
  public static Rect getDisplayCutoutSafeInsets(View paramView)
  {
    Rect localRect = new Rect();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Build.VERSION.SDK_INT:");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    QMLog.d("ImmersiveUtils", ((StringBuilder)localObject1).toString());
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramView = JarReflectUtil.callSpecifiedMethod(paramView, "getRootWindowInsets", false, null, new Object[0]);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("insets:");
        ((StringBuilder)localObject1).append(paramView);
        QMLog.d("ImmersiveUtils", ((StringBuilder)localObject1).toString());
        Object localObject3 = JarReflectUtil.callSpecifiedMethod(paramView, "getDisplayCutout", false, null, new Object[0]);
        if (localObject3 == null)
        {
          QMLog.d("ImmersiveUtils", "displayCutout == null");
          return localRect;
        }
        paramView = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetTop", false, null, new Object[0]);
        localObject1 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetBottom", false, null, new Object[0]);
        Object localObject2 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetLeft", false, null, new Object[0]);
        localObject3 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetRight", false, null, new Object[0]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("safeInsetTop:");
        localStringBuilder.append(paramView);
        localStringBuilder.append(" safeInsetBottom:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(" safeInsetLeft:");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" safeInsetRight:");
        localStringBuilder.append(localObject3);
        QMLog.d("ImmersiveUtils", localStringBuilder.toString());
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
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramView);
        QMLog.e("ImmersiveUtils", ((StringBuilder)localObject1).toString());
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
      paramContext = new StringBuilder();
      paramContext.append("has notchHeight:");
      paramContext.append(notchHeight);
      QMLog.d("ImmersiveUtils", paramContext.toString());
      return notchHeight;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Build.MODEL:");
    localStringBuilder.append(Build.MODEL);
    QMLog.d("ImmersiveUtils", localStringBuilder.toString());
    if (hasNotchInVivo(paramContext))
    {
      notchHeight = DisplayUtil.dip2px(paramContext, 27.0F);
    }
    else if (hasNotchInOppo(paramContext))
    {
      if (Build.VERSION.SDK_INT >= 28) {
        getGoogleApi(paramActivity);
      }
      int i = notchHeight;
      if ((i == 0) || (i == -1)) {
        notchHeight = 80;
      }
    }
    else if (hasNotchInHuaWei(paramContext))
    {
      notchHeight = getNotchSizeInHuaWei(paramContext)[1];
    }
    else if ((!hasNotchInXiaoMi(paramContext)) && (!hasNotchInSmartisan(paramContext)) && (!isSpecialDevices()))
    {
      if (isSharpS2()) {
        notchHeight = 121;
      } else {
        getGoogleApi(paramActivity);
      }
    }
    else
    {
      notchHeight = getNotchSizeInStatusBar(paramContext);
    }
    return notchHeight;
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
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    finally {}
    QMLog.e("ImmersiveUtils", "getNotchSize Exception");
    return arrayOfInt;
    QMLog.e("ImmersiveUtils", "getNotchSize NoSuchMethodException");
    return arrayOfInt;
    QMLog.e("ImmersiveUtils", "getNotchSize ClassNotFoundException");
    return arrayOfInt;
    return arrayOfInt;
  }
  
  private static int getNotchSizeInStatusBar(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
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
    catch (IllegalArgumentException|Exception paramContext)
    {
      label70:
      break label70;
    }
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
    if (statusHeight == -1)
    {
      Object localObject = paramContext.getResources();
      int i = ((Resources)localObject).getIdentifier("status_bar_height", "dimen", "android");
      if (i > 0) {
        i = ((Resources)localObject).getDimensionPixelSize(i);
      } else {
        i = 0;
      }
      float f1 = ViewUtils.getDensity();
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStatusBarHeight org=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", sys density=");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", cur density=");
        ((StringBuilder)localObject).append(paramContext.getResources().getDisplayMetrics().density);
        QMLog.d("systembar", ((StringBuilder)localObject).toString());
      }
      f1 /= paramContext.getResources().getDisplayMetrics().density;
      float f2 = 1.0F;
      if (i <= 0)
      {
        if (f1 <= 0.0F) {
          f1 = f2;
        }
        i = ViewUtils.dpToPx(f1 * 25.0F);
      }
      else
      {
        float f3 = i;
        if (f1 <= 0.0F) {
          f1 = f2;
        }
        i = (int)Math.ceil(f3 * f1 + 0.5F);
      }
      statusHeight = i;
    }
    return statusHeight;
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
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    finally {}
    QMLog.e("ImmersiveUtils", "hasNotchInScreen Exception");
    return false;
    QMLog.e("ImmersiveUtils", "hasNotchInScreen NoSuchMethodException");
    return false;
    QMLog.e("ImmersiveUtils", "hasNotchInScreen ClassNotFoundException");
    return false;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext);
      QMLog.e("ImmersiveUtils", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext);
      QMLog.e("ImmersiveUtils", localStringBuilder.toString());
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
    if (density == -1.0F)
    {
      DisplayMetrics localDisplayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      density = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        screenWidth = localDisplayMetrics.widthPixels;
        screenHeight = localDisplayMetrics.heightPixels;
        return;
      }
      screenHeight = localDisplayMetrics.widthPixels;
      screenWidth = localDisplayMetrics.heightPixels;
    }
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
    QMLog.e("ImmersiveUtils", "setStatusBarDarkModeForFlyme: failed");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */