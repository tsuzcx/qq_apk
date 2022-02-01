package com.tencent.util;

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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LiuHaiUtils
{
  public static final ArrayList<String> a = new ArrayList();
  public static boolean b = false;
  public static boolean c = false;
  public static int d = 0;
  public static boolean e = false;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  public static boolean i = false;
  public static int j = 0;
  public static final int k = ViewUtils.dip2px(66.0F);
  public static boolean l = false;
  public static boolean m = false;
  public static int n = 0;
  private static boolean o;
  private static boolean p;
  private static String[] q;
  private static String[] r;
  
  static
  {
    a.add("SHARP_FS8010".toLowerCase());
    o = false;
    p = false;
    q = new String[] { "PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750", "N5207", "V1932A", "V1986A" };
    r = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
  }
  
  private static int a(String paramString, int paramInt)
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
            int i1 = ((Integer)paramString).intValue();
            return i1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSystemPropertyForXiaomi() Exception=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("LiuHaiUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramInt;
  }
  
  public static boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString().toLowerCase();
    return a.contains(localObject);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP decorView=null");
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
          if (!QLog.isColorLevel()) {
            break label158;
          }
          QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
          return false;
        }
        if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) == null) {
          break label160;
        }
        bool = true;
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("hasNotchInScreen_AndroidP getDisplayCutout  exists:");
          paramActivity.append(bool);
          QLog.i("LiuHaiUtils", 1, paramActivity.toString());
        }
        return bool;
      }
      catch (Exception paramActivity)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP Exception");
      }
      return false;
      label158:
      return false;
      label160:
      boolean bool = false;
    }
  }
  
  public static boolean a(Context paramContext)
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
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        paramContext = new StringBuilder();
        bool1 = bool2;
        paramContext.append("vivoHasNotchInScreen ret=");
        bool1 = bool2;
        paramContext.append(bool2);
        bool1 = bool2;
        QLog.i("LiuHaiUtils", 1, paramContext.toString());
        return bool2;
      }
    }
    catch (Exception paramContext)
    {
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "vivoHasNotchInScreen Exception", paramContext);
        bool3 = bool1;
      }
    }
    return bool3;
  }
  
  public static boolean a(View paramView1, View paramView2, int paramInt)
  {
    boolean bool = true;
    if (paramView2 != null) {
      if (!b())
      {
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
        paramView2.setVisibility(8);
      }
      else
      {
        Object localObject;
        if (paramView1 != null)
        {
          localObject = paramView1.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = d;
          paramView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramView1.getVisibility() != 0) {
            paramView1.setVisibility(0);
          }
        }
        int i1 = ViewUtils.getScreenWidth();
        int i2 = ViewUtils.getScreenHeight();
        int i3 = (int)(i1 / 9.0F * 16.0F);
        i1 = i2 - i3 - d;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initLiuHaiScreenUI_Common manufacturer:");
          ((StringBuilder)localObject).append(Build.MANUFACTURER);
          ((StringBuilder)localObject).append(" version:");
          ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
          ((StringBuilder)localObject).append(" remainedPixel:");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" srcHeight:");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(" sNotchHeight:");
          ((StringBuilder)localObject).append(d);
          ((StringBuilder)localObject).append(" BOTTOM_HEIGHT_LH: ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(" surfaceMaxHeight:");
          ((StringBuilder)localObject).append(i3);
          QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
        }
        i2 = k;
        if (i1 > i2)
        {
          i1 -= paramInt;
          i2 = (int)(i2 * 1.2F);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("initLiuHaiScreenUI_Common manufacturer:");
            ((StringBuilder)localObject).append(Build.MANUFACTURER);
            ((StringBuilder)localObject).append(" limitMaxBottom:");
            ((StringBuilder)localObject).append(i2);
            ((StringBuilder)localObject).append(" remainedPixel:");
            ((StringBuilder)localObject).append(i1);
            ((StringBuilder)localObject).append(" sForceCenter_16_9:");
            ((StringBuilder)localObject).append(true);
            QLog.e("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
          }
          paramInt = i1;
          if (i1 > i2)
          {
            paramInt = (i1 - k) / 2;
            h = paramInt;
            if (paramView1 != null)
            {
              localObject = paramView1.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject).height = (d + paramInt);
              paramView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            paramInt += k;
          }
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = paramInt;
          paramView2.setLayoutParams(paramView1);
          j = paramInt;
          if (paramView2.getVisibility() == 0) {
            break label636;
          }
          paramView2.setVisibility(0);
          return true;
        }
        paramInt = Math.abs(i1 - i2);
        if (QLog.isColorLevel())
        {
          paramView1 = new StringBuilder();
          paramView1.append("initLiuHaiScreenUI_Common manufacturer:");
          paramView1.append(Build.MANUFACTURER);
          paramView1.append(" sIsIrregularScreen:");
          paramView1.append(i);
          paramView1.append(" remainedPixel:");
          paramView1.append(i1);
          paramView1.append(" diffPixels: ");
          paramView1.append(paramInt);
          QLog.e("LiuHaiUtils", 1, paramView1.toString());
        }
        if (paramInt < 5)
        {
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = i1;
          paramView2.setLayoutParams(paramView1);
          j = i1;
          if (paramView2.getVisibility() == 0) {
            break label636;
          }
          paramView2.setVisibility(0);
          return true;
        }
        if (i)
        {
          paramView2.setVisibility(8);
        }
        else
        {
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = k;
          paramView2.setLayoutParams(paramView1);
          j = k;
          if (paramView2.getVisibility() == 0) {
            break label636;
          }
          paramView2.setVisibility(0);
          return true;
        }
      }
    }
    bool = false;
    label636:
    return bool;
  }
  
  public static boolean a(WindowManager.LayoutParams paramLayoutParams)
  {
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i1);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i1 > 27) {
      return c(paramLayoutParams);
    }
    return b(paramLayoutParams);
  }
  
  public static int b(Context paramContext)
  {
    int i1 = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i1 > 0) {
      return paramContext.getResources().getDimensionPixelSize(i1);
    }
    return 0;
  }
  
  public static boolean b()
  {
    return (b) && (c) && (d > 0);
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (!o)
    {
      p = c(paramActivity);
      o = true;
    }
    return p;
  }
  
  private static boolean b(WindowManager.LayoutParams paramLayoutParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiUtils", 2, "color note androidO notch screen compat");
    }
    return true;
  }
  
  public static boolean c()
  {
    return b;
  }
  
  public static boolean c(Activity paramActivity)
  {
    int i1 = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreenByVersion version: ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    boolean bool = false;
    if (i1 > 27) {
      return a(paramActivity);
    }
    if (i1 >= 26) {
      bool = c(paramActivity);
    }
    return bool;
  }
  
  public static boolean c(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return f(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO")) {
      return h(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("VIVO")) {
      return a(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return j(paramContext);
    }
    return false;
  }
  
  private static boolean c(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      Field localField = paramLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(paramLayoutParams, 1);
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramLayoutParams)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP Exception");
    }
    return false;
  }
  
  public static int d(Activity paramActivity)
  {
    int i1 = b(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      return i1;
    }
    try
    {
      paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
      if (paramActivity == null)
      {
        if (!QLog.isColorLevel()) {
          return i1;
        }
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
        return i1;
      }
      paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=");
        localStringBuilder.append(paramActivity);
        QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
      }
      if (paramActivity == null) {
        break label225;
      }
      int i2 = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getNotchInScreenHeight_AndroidP top:");
        paramActivity.append(i2);
        QLog.i("LiuHaiUtils", 1, paramActivity.toString());
      }
      return i2;
    }
    catch (Exception paramActivity)
    {
      label210:
      label225:
      break label210;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP Exception");
    }
    return i1;
    return i1;
  }
  
  public static int d(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    String str = ((StringBuilder)localObject).toString();
    boolean bool = str.equalsIgnoreCase("HUAWEI");
    localObject = null;
    if (bool) {
      localObject = g(paramContext);
    } else if (str.equalsIgnoreCase("OPPO")) {
      localObject = i(paramContext);
    } else if ((!str.equalsIgnoreCase("VIVO")) && (str.equalsIgnoreCase("XIAOMI"))) {
      localObject = k(paramContext);
    }
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = localObject[0];
    } else {
      i1 = 0;
    }
    if (localObject != null) {
      i2 = localObject[1];
    }
    int i3 = b(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getNotchInScreenHeight manufacturer:");
      paramContext.append(Build.MANUFACTURER);
      paramContext.append(" height:");
      paramContext.append(i2);
      paramContext.append(" width:");
      paramContext.append(i1);
      paramContext.append(" status:");
      paramContext.append(i3);
      QLog.e("LiuHaiUtils", 1, paramContext.toString());
    }
    return Math.max(i2, i3);
  }
  
  public static void d()
  {
    b = false;
    c = false;
    d = 0;
    e = false;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "resetAllLiuHaiStatus!");
    }
  }
  
  public static int e(Activity paramActivity)
  {
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotchInScreenHeight apiVersion: ");
      localStringBuilder.append(i1);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    int i2 = b(paramActivity);
    if (i2 <= 0)
    {
      if (i1 > 27) {
        return d(paramActivity);
      }
      return d(paramActivity);
    }
    return i2;
  }
  
  public static boolean e()
  {
    String str = Build.MODEL.toUpperCase();
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
      if ((!str.contains("RLI-AN00")) && (!str.contains("RLI-N29")) && (!str.contains("TAH-AN00")) && (!str.contains("TAH-N29")) && (!str.contains("unknownRLl")))
      {
        bool1 = bool2;
        if (!str.contains("HWTAH")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int[] e(Context paramContext)
  {
    Object localObject = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = new DisplayMetrics();
      ((Display)localObject).getRealMetrics(paramContext);
      if (QLog.isColorLevel())
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
        QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
      }
      return new int[] { paramContext.widthPixels, paramContext.heightPixels };
    }
    boolean bool = SystemBarTintManager.hasNavBar(paramContext);
    int i1;
    if (bool) {
      i1 = SystemBarTintManager.getNavigationBarHeight(paramContext);
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getRealDisplay[none] manufacturer:");
      paramContext.append(Build.MANUFACTURER);
      paramContext.append(" width:");
      paramContext.append(localDisplayMetrics.widthPixels);
      paramContext.append(" height:");
      paramContext.append(localDisplayMetrics.heightPixels);
      paramContext.append(" mNavigationBarHeight:");
      paramContext.append(i1);
      paramContext.append(" hasNavBar:");
      paramContext.append(bool);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels + i1 };
  }
  
  public static boolean enableNotch(Activity paramActivity)
  {
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i1);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i1 > 27) {
      return p(paramActivity);
    }
    return o(paramActivity);
  }
  
  public static void f(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiProperty manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" hasInitHasNotch:");
      localStringBuilder1.append(e);
      localStringBuilder1.append(" sHasNotch:");
      localStringBuilder1.append(b);
      localStringBuilder1.append(" sEnableNotchOK:");
      localStringBuilder1.append(c);
      localStringBuilder1.append(" sNotchHeight:");
      localStringBuilder1.append(d);
      QLog.e("LiuHaiUtils", 1, localStringBuilder1.toString());
    }
    if (!e)
    {
      f = ViewUtils.getScreenHeight();
      g = ViewUtils.getScreenWidth();
      b = false;
      try
      {
        b = j(paramActivity);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("initLiuHaiProperty manufacturer:");
          localStringBuilder2.append(Build.MANUFACTURER);
          QLog.e("LiuHaiUtils", 1, localStringBuilder2.toString(), localThrowable);
        }
      }
      if (b) {
        d = e(paramActivity);
      }
      e = true;
    }
    c = false;
    if (b)
    {
      c = q(paramActivity);
      if (d <= 0) {
        c = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiProperty[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" hasInitHasNotch:");
      paramActivity.append(e);
      paramActivity.append(" sHasNotch:");
      paramActivity.append(b);
      paramActivity.append(" sEnableNotchOK:");
      paramActivity.append(c);
      paramActivity.append(" sNotchHeight:");
      paramActivity.append(d);
      QLog.e("LiuHaiUtils", 1, paramActivity.toString());
    }
  }
  
  public static boolean f()
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
  
  private static boolean f(Context paramContext)
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
      if (!QLog.isColorLevel()) {
        break label205;
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
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
      return bool1;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label186;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label165;
    }
    catch (Exception paramContext)
    {
      label144:
      break label144;
    }
    bool2 = bool5;
    if (QLog.isColorLevel())
    {
      QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen Exception");
      return bool5;
      label165:
      bool2 = bool4;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen NoSuchMethodException");
        return bool4;
        label186:
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen ClassNotFoundException");
          bool2 = bool3;
        }
      }
    }
    label205:
    return bool2;
  }
  
  public static void g(Activity paramActivity)
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
  
  public static boolean g()
  {
    return (m) && (n > 0);
  }
  
  private static int[] g(Context paramContext)
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
      break label144;
    }
    catch (NoSuchMethodException paramContext)
    {
      label144:
      label146:
      label165:
      break label123;
    }
    catch (Exception paramContext)
    {
      label93:
      label96:
      label99:
      label102:
      label104:
      label123:
      label125:
      break label102;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label165;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hwGetNotchSize ret=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
      return paramContext;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label99;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label96;
    }
    catch (Exception localException)
    {
      break label93;
    }
    break label104;
    break label125;
    break label146;
    paramContext = (Context)localObject;
    localObject = paramContext;
    if (QLog.isColorLevel())
    {
      QLog.e("LiuHaiUtils", 1, "hasNotchInScreen Exception");
      return paramContext;
      paramContext = (Context)localObject;
      localObject = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "hwGetNotchSize NoSuchMethodException");
        return paramContext;
        paramContext = (Context)localObject;
        localObject = paramContext;
        if (QLog.isColorLevel())
        {
          QLog.e("LiuHaiUtils", 1, "hwGetNotchSize ClassNotFoundException");
          localObject = paramContext;
        }
      }
    }
    return localObject;
  }
  
  public static int h()
  {
    return n;
  }
  
  public static void h(Activity paramActivity)
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
  
  private static boolean h(Context paramContext)
  {
    if (Build.MODEL.equals("PAAM00")) {
      return true;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("oppoHasNotchInScreen exits:");
      paramContext.append(bool);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return bool;
  }
  
  public static void i(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiBarHeight manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" mHasInitHasNotch:");
      localStringBuilder1.append(l);
      localStringBuilder1.append(" mHasNotch:");
      localStringBuilder1.append(m);
      localStringBuilder1.append(" mNotchHeight:");
      localStringBuilder1.append(n);
      QLog.e("LiuHaiUtils", 1, localStringBuilder1.toString());
    }
    if (!l)
    {
      m = false;
      try
      {
        m = j(paramActivity);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("initLiuHaiProperty manufacturer:");
          localStringBuilder2.append(Build.MANUFACTURER);
          QLog.e("LiuHaiUtils", 1, localStringBuilder2.toString(), localThrowable);
        }
      }
      if (m) {
        n = e(paramActivity);
      }
      l = true;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiBarHeight[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" mHasInitHasNotch:");
      paramActivity.append(l);
      paramActivity.append(" mHasNotch:");
      paramActivity.append(m);
      paramActivity.append(" mNotchHeight:");
      paramActivity.append(n);
      QLog.e("LiuHaiUtils", 1, paramActivity.toString());
    }
  }
  
  private static boolean i()
  {
    String str = Build.MODEL;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = q;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (str.equalsIgnoreCase(arrayOfString[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private static int[] i(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("android.os.SystemProperties");
      if (paramContext != null)
      {
        paramContext = paramContext.getMethod("get", new Class[] { String.class });
        if (paramContext != null)
        {
          paramContext.setAccessible(true);
          paramContext = paramContext.invoke(null, new Object[] { "ro.oppo.screen.heteromorphism" });
          if ((paramContext instanceof String)) {
            paramContext = (String)paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty exp ", paramContext);
      }
      paramContext = null;
    }
    if (TextUtils.isEmpty(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty empty");
      }
      return null;
    }
    paramContext = paramContext.split(":");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("oppoGetNotchSize mProperty values=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
    }
    if (paramContext.length >= 2)
    {
      localObject = paramContext[0].split(",");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("oppoGetNotchSize mProperty values[0] size=");
        localStringBuilder.append(localObject);
        QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
      }
      if (localObject.length < 2) {
        return null;
      }
      try
      {
        int i1 = Integer.valueOf(localObject[0]).intValue();
        int i2 = Integer.valueOf(localObject[1]).intValue();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("oppoGetNotchSize mProperty values[0] left=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" top=");
          ((StringBuilder)localObject).append(i2);
          QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
        }
        localObject = paramContext[1].split(",");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("oppoGetNotchSize mProperty values[1] size=");
          localStringBuilder.append(localObject);
          QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
        }
        if (localObject.length < 2) {
          return null;
        }
        try
        {
          int i3 = Integer.valueOf(localObject[0]).intValue();
          int i4 = Integer.valueOf(localObject[1]).intValue();
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("oppoGetNotchSize mProperty values[1] right=");
            paramContext.append(i3);
            paramContext.append(" bottom=");
            paramContext.append(i4);
            QLog.i("LiuHaiUtils", 1, paramContext.toString());
          }
          return new int[] { i3 - i1, i4 - i2 };
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("oppoGetNotchSize values[1]=");
            localStringBuilder.append(paramContext[1]);
            QLog.i("LiuHaiUtils", 1, localStringBuilder.toString(), localNumberFormatException1);
          }
          return null;
        }
        return null;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("oppoGetNotchSize values[0]=");
          localStringBuilder.append(paramContext[0]);
          QLog.i("LiuHaiUtils", 1, localStringBuilder.toString(), localNumberFormatException2);
        }
      }
    }
  }
  
  private static boolean j(Activity paramActivity)
  {
    boolean bool1 = false;
    i = false;
    int i1 = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreen version: ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i1 < 26) {
      return false;
    }
    if (i1 > 27) {
      bool1 = a(paramActivity);
    }
    if ((!bool1) && (i1 >= 26)) {
      bool1 = c(paramActivity);
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("hasNotchInScreen manufacturer = ");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" ,brand = ");
      paramActivity.append(Build.BRAND);
      paramActivity.append(" ,model = ");
      paramActivity.append(Build.MODEL);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      if (LiuHaiWhiteListConfProcessor.a().a(Build.MANUFACTURER, Build.BRAND, Build.MODEL)) {}
      do
      {
        bool2 = true;
        break;
        bool2 = bool1;
      } while (i());
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("hasNotchInScreen haveNotch: ");
      paramActivity.append(bool2);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    return bool2;
  }
  
  @TargetApi(17)
  private static boolean j(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17) {
          break label140;
        }
        i1 = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i1 == 1)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen closed: ");
          paramContext.append(i1);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
          return false;
        }
        i1 = a("ro.miui.notch", 0);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen isNotch: ");
          paramContext.append(i1);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
        }
        if (i1 == 1) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "xiaomiHasNotchInScreen crash: ", paramContext);
        }
      }
      return false;
      label140:
      int i1 = 0;
    }
    return false;
  }
  
  private static boolean k(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(768) });
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private static int[] k(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int i1 = paramContext.getResources().getIdentifier("notch_width", "dimen", "android");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_width]resourceId: ");
      localStringBuilder.append(i1);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i1 > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i1);
    }
    i1 = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_height]resourceId: ");
      localStringBuilder.append(i1);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i1 > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i1);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("xiaomiGetNotchSize width: ");
      paramContext.append(arrayOfInt[0]);
      paramContext.append(" height:");
      paramContext.append(arrayOfInt[1]);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return arrayOfInt;
  }
  
  private static boolean l(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x80);
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableMeizuNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableMeizuNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private static boolean m(Activity paramActivity)
  {
    return p(paramActivity);
  }
  
  private static boolean n(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      Object localObject = paramActivity.getWindow().getAttributes();
      try
      {
        paramActivity = Class.forName("com.huawei.android.view.LayoutParamsEx");
        localObject = paramActivity.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
        paramActivity.getMethod("addHwFlags", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(65536) });
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch true");
        }
        return true;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "enableHuaWeiNotch Exception", paramActivity);
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch invalid param");
    }
    return false;
  }
  
  private static boolean o(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return n(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO OPPO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("VIVO"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO VIVO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return k(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("SAMSUNG")) {
      return m(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("Meizu")) {
      return l(paramActivity);
    }
    return false;
  }
  
  private static boolean p(Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    try
    {
      Field localField = localLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(localLayoutParams, 1);
      paramActivity.getWindow().setAttributes(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      label55:
      break label55;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP Exception");
    }
    return false;
  }
  
  private static boolean q(Activity paramActivity)
  {
    int i1 = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("enableNotchInScreen apiVersion: ");
      paramActivity.append(i1);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.LiuHaiUtils
 * JD-Core Version:    0.7.0.1
 */