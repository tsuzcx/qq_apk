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
  public static int a;
  public static final ArrayList<String> a;
  public static boolean a;
  private static String[] a;
  public static int b;
  public static boolean b;
  private static String[] b;
  public static int c;
  public static boolean c;
  public static int d;
  public static boolean d;
  public static int e;
  public static boolean e;
  public static final int f;
  public static boolean f;
  public static int g;
  private static boolean g;
  private static boolean h;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add("SHARP_FS8010".toLowerCase());
    jdField_g_of_type_Boolean = false;
    h = false;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750", "N5207", "V1932A", "V1986A" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Int = 0;
    jdField_f_of_type_Int = ViewUtils.a(66.0F);
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = false;
    jdField_g_of_type_Int = 0;
  }
  
  public static int a()
  {
    return jdField_g_of_type_Int;
  }
  
  public static int a(Activity paramActivity)
  {
    int i = a(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      return i;
    }
    try
    {
      paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
      if (paramActivity == null)
      {
        if (!QLog.isColorLevel()) {
          return i;
        }
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
        return i;
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
        break label219;
      }
      int j = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getNotchInScreenHeight_AndroidP top:");
        paramActivity.append(j);
        QLog.i("LiuHaiUtils", 1, paramActivity.toString());
      }
      return j;
    }
    catch (Exception paramActivity)
    {
      label205:
      label219:
      break label205;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP Exception");
    }
    return i;
    return i;
  }
  
  public static int a(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
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
            int i = ((Integer)paramString).intValue();
            return i;
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
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "resetAllLiuHaiStatus!");
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiProperty manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" hasInitHasNotch:");
      localStringBuilder1.append(jdField_c_of_type_Boolean);
      localStringBuilder1.append(" sHasNotch:");
      localStringBuilder1.append(jdField_a_of_type_Boolean);
      localStringBuilder1.append(" sEnableNotchOK:");
      localStringBuilder1.append(jdField_b_of_type_Boolean);
      localStringBuilder1.append(" sNotchHeight:");
      localStringBuilder1.append(jdField_a_of_type_Int);
      QLog.e("LiuHaiUtils", 1, localStringBuilder1.toString());
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_b_of_type_Int = ViewUtils.b();
      jdField_c_of_type_Int = ViewUtils.a();
      jdField_a_of_type_Boolean = false;
      try
      {
        jdField_a_of_type_Boolean = d(paramActivity);
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
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_Int = b(paramActivity);
      }
      jdField_c_of_type_Boolean = true;
    }
    jdField_b_of_type_Boolean = false;
    if (jdField_a_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = k(paramActivity);
      if (jdField_a_of_type_Int <= 0) {
        jdField_b_of_type_Boolean = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiProperty[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" hasInitHasNotch:");
      paramActivity.append(jdField_c_of_type_Boolean);
      paramActivity.append(" sHasNotch:");
      paramActivity.append(jdField_a_of_type_Boolean);
      paramActivity.append(" sEnableNotchOK:");
      paramActivity.append(jdField_b_of_type_Boolean);
      paramActivity.append(" sNotchHeight:");
      paramActivity.append(jdField_a_of_type_Int);
      QLog.e("LiuHaiUtils", 1, paramActivity.toString());
    }
  }
  
  public static boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString().toLowerCase();
    return jdField_a_of_type_JavaUtilArrayList.contains(localObject);
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
            break label162;
          }
          QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
          return false;
        }
        if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) == null) {
          break label164;
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
      label162:
      return false;
      label164:
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
          ((ViewGroup.LayoutParams)localObject).height = jdField_a_of_type_Int;
          paramView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramView1.getVisibility() != 0) {
            paramView1.setVisibility(0);
          }
        }
        int i = ViewUtils.a();
        int j = ViewUtils.b();
        int k = (int)(i / 9.0F * 16.0F);
        i = j - k - jdField_a_of_type_Int;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initLiuHaiScreenUI_Common manufacturer:");
          ((StringBuilder)localObject).append(Build.MANUFACTURER);
          ((StringBuilder)localObject).append(" version:");
          ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
          ((StringBuilder)localObject).append(" remainedPixel:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" srcHeight:");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" sNotchHeight:");
          ((StringBuilder)localObject).append(jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" BOTTOM_HEIGHT_LH: ");
          ((StringBuilder)localObject).append(jdField_f_of_type_Int);
          ((StringBuilder)localObject).append(" surfaceMaxHeight:");
          ((StringBuilder)localObject).append(k);
          QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
        }
        j = jdField_f_of_type_Int;
        if (i > j)
        {
          i -= paramInt;
          j = (int)(j * 1.2F);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("initLiuHaiScreenUI_Common manufacturer:");
            ((StringBuilder)localObject).append(Build.MANUFACTURER);
            ((StringBuilder)localObject).append(" limitMaxBottom:");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" remainedPixel:");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" sForceCenter_16_9:");
            ((StringBuilder)localObject).append(true);
            QLog.e("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
          }
          paramInt = i;
          if (i > j)
          {
            paramInt = (i - jdField_f_of_type_Int) / 2;
            jdField_d_of_type_Int = paramInt;
            if (paramView1 != null)
            {
              localObject = paramView1.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject).height = (jdField_a_of_type_Int + paramInt);
              paramView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            paramInt += jdField_f_of_type_Int;
          }
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = paramInt;
          paramView2.setLayoutParams(paramView1);
          jdField_e_of_type_Int = paramInt;
          if (paramView2.getVisibility() == 0) {
            break label636;
          }
          paramView2.setVisibility(0);
          return true;
        }
        paramInt = Math.abs(i - j);
        if (QLog.isColorLevel())
        {
          paramView1 = new StringBuilder();
          paramView1.append("initLiuHaiScreenUI_Common manufacturer:");
          paramView1.append(Build.MANUFACTURER);
          paramView1.append(" sIsIrregularScreen:");
          paramView1.append(jdField_d_of_type_Boolean);
          paramView1.append(" remainedPixel:");
          paramView1.append(i);
          paramView1.append(" diffPixels: ");
          paramView1.append(paramInt);
          QLog.e("LiuHaiUtils", 1, paramView1.toString());
        }
        if (paramInt < 5)
        {
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = i;
          paramView2.setLayoutParams(paramView1);
          jdField_e_of_type_Int = i;
          if (paramView2.getVisibility() == 0) {
            break label636;
          }
          paramView2.setVisibility(0);
          return true;
        }
        if (jdField_d_of_type_Boolean)
        {
          paramView2.setVisibility(8);
        }
        else
        {
          paramView1 = paramView2.getLayoutParams();
          paramView1.height = jdField_f_of_type_Int;
          paramView2.setLayoutParams(paramView1);
          jdField_e_of_type_Int = jdField_f_of_type_Int;
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
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 27) {
      return c(paramLayoutParams);
    }
    return b(paramLayoutParams);
  }
  
  public static int[] a(Context paramContext)
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
    int i;
    if (bool) {
      i = SystemBarTintManager.getNavigationBarHeight(paramContext);
    } else {
      i = 0;
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
      paramContext.append(i);
      paramContext.append(" hasNavBar:");
      paramContext.append(bool);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels + i };
  }
  
  public static int b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotchInScreenHeight apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    int j = a(paramActivity);
    if (j <= 0)
    {
      if (i > 27) {
        return a(paramActivity);
      }
      return b(paramActivity);
    }
    return j;
  }
  
  public static int b(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    String str = ((StringBuilder)localObject).toString();
    boolean bool = str.equalsIgnoreCase("HUAWEI");
    localObject = null;
    if (bool) {
      localObject = b(paramContext);
    } else if (str.equalsIgnoreCase("OPPO")) {
      localObject = c(paramContext);
    } else if ((!str.equalsIgnoreCase("VIVO")) && (str.equalsIgnoreCase("XIAOMI"))) {
      localObject = d(paramContext);
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
    int k = a(paramContext);
    if (QLog.isColorLevel())
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
      QLog.e("LiuHaiUtils", 1, paramContext.toString());
    }
    return Math.max(j, k);
  }
  
  public static void b(Activity paramActivity)
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
  
  public static boolean b()
  {
    return (jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean) && (jdField_a_of_type_Int > 0);
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (!jdField_g_of_type_Boolean)
    {
      h = c(paramActivity);
      jdField_g_of_type_Boolean = true;
    }
    return h;
  }
  
  public static boolean b(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return c(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO")) {
      return d(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("VIVO")) {
      return a(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return e(paramContext);
    }
    return false;
  }
  
  private static boolean b(WindowManager.LayoutParams paramLayoutParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiUtils", 2, "color note androidO notch screen compat");
    }
    return true;
  }
  
  private static int[] b(Context paramContext)
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
  
  public static void c(Activity paramActivity)
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
  
  public static boolean c()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean c(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreenByVersion version: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    boolean bool = false;
    if (i > 27) {
      return a(paramActivity);
    }
    if (i >= 26) {
      bool = b(paramActivity);
    }
    return bool;
  }
  
  private static boolean c(Context paramContext)
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
  
  private static int[] c(Context paramContext)
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
        int i = Integer.valueOf(localObject[0]).intValue();
        int j = Integer.valueOf(localObject[1]).intValue();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("oppoGetNotchSize mProperty values[0] left=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" top=");
          ((StringBuilder)localObject).append(j);
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
          int k = Integer.valueOf(localObject[0]).intValue();
          int m = Integer.valueOf(localObject[1]).intValue();
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("oppoGetNotchSize mProperty values[1] right=");
            paramContext.append(k);
            paramContext.append(" bottom=");
            paramContext.append(m);
            QLog.i("LiuHaiUtils", 1, paramContext.toString());
          }
          return new int[] { k - i, m - j };
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
  
  public static void d(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiBarHeight manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" mHasInitHasNotch:");
      localStringBuilder1.append(jdField_e_of_type_Boolean);
      localStringBuilder1.append(" mHasNotch:");
      localStringBuilder1.append(jdField_f_of_type_Boolean);
      localStringBuilder1.append(" mNotchHeight:");
      localStringBuilder1.append(jdField_g_of_type_Int);
      QLog.e("LiuHaiUtils", 1, localStringBuilder1.toString());
    }
    if (!jdField_e_of_type_Boolean)
    {
      jdField_f_of_type_Boolean = false;
      try
      {
        jdField_f_of_type_Boolean = d(paramActivity);
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
      if (jdField_f_of_type_Boolean) {
        jdField_g_of_type_Int = b(paramActivity);
      }
      jdField_e_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiBarHeight[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" mHasInitHasNotch:");
      paramActivity.append(jdField_e_of_type_Boolean);
      paramActivity.append(" mHasNotch:");
      paramActivity.append(jdField_f_of_type_Boolean);
      paramActivity.append(" mNotchHeight:");
      paramActivity.append(jdField_g_of_type_Int);
      QLog.e("LiuHaiUtils", 1, paramActivity.toString());
    }
  }
  
  public static boolean d()
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
  
  private static boolean d(Activity paramActivity)
  {
    boolean bool1 = false;
    jdField_d_of_type_Boolean = false;
    int i = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreen version: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i < 26) {
      return false;
    }
    if (i > 27) {
      bool1 = a(paramActivity);
    }
    if ((!bool1) && (i >= 26)) {
      bool1 = b(paramActivity);
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
      } while (g());
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
  
  private static boolean d(Context paramContext)
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
  
  private static int[] d(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int i = paramContext.getResources().getIdentifier("notch_width", "dimen", "android");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_width]resourceId: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_height]resourceId: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
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
  
  public static boolean e()
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
  
  private static boolean e(Activity paramActivity)
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
  
  @TargetApi(17)
  private static boolean e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17) {
          break label140;
        }
        i = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i == 1)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen closed: ");
          paramContext.append(i);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
          return false;
        }
        i = a("ro.miui.notch", 0);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen isNotch: ");
          paramContext.append(i);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
        }
        if (i == 1) {
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
      int i = 0;
    }
    return false;
  }
  
  public static boolean enableNotch(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 27) {
      return j(paramActivity);
    }
    return i(paramActivity);
  }
  
  public static boolean f()
  {
    return (jdField_f_of_type_Boolean) && (jdField_g_of_type_Int > 0);
  }
  
  private static boolean f(Activity paramActivity)
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
  
  private static boolean g()
  {
    String str = Build.MODEL;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
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
  
  private static boolean g(Activity paramActivity)
  {
    return j(paramActivity);
  }
  
  private static boolean h(Activity paramActivity)
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
  
  private static boolean i(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return h(paramActivity);
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
      return e(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("SAMSUNG")) {
      return g(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("Meizu")) {
      return f(paramActivity);
    }
    return false;
  }
  
  private static boolean j(Activity paramActivity)
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
  
  private static boolean k(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("enableNotchInScreen apiVersion: ");
      paramActivity.append(i);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.LiuHaiUtils
 * JD-Core Version:    0.7.0.1
 */