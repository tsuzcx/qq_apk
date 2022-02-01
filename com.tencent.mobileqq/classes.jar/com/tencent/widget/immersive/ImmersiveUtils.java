package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import bhii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersiveUtils
{
  private static float a;
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c;
  public static volatile boolean c;
  private static int d;
  public static boolean d;
  private static int jdField_e_of_type_Int;
  private static boolean jdField_e_of_type_Boolean;
  private static int jdField_f_of_type_Int;
  private static boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_d_of_type_Int = 2147483647;
    String str;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("ImmersiveUtils escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sImmersiveUtilsEscapedMsg = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "ImmersiveUtils escapes!");
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = "ImmersiveUtils";
      jdField_a_of_type_Float = -1.0F;
      jdField_e_of_type_Int = -1;
      jdField_f_of_type_Int = -1;
      jdField_a_of_type_Int = -1;
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Int = 67108864;
      jdField_c_of_type_Int = -1;
      str = Build.MANUFACTURER + "-" + Build.MODEL;
      if (str.equalsIgnoreCase("smartisan-sm705")) {
        jdField_b_of_type_Boolean = true;
      }
      if (str.equalsIgnoreCase("vivo-vivo Y35A")) {
        jdField_b_of_type_Boolean = true;
      }
      jdField_d_of_type_Boolean = true;
      return;
      BaseApplicationImpl.sImmersiveUtilsEscapedMsg = "";
    }
  }
  
  public static float a()
  {
    a();
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    a();
    return jdField_e_of_type_Int;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  private static void a()
  {
    DisplayMetrics localDisplayMetrics;
    if (jdField_a_of_type_Float == -1.0F)
    {
      localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      jdField_a_of_type_Float = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        jdField_e_of_type_Int = localDisplayMetrics.widthPixels;
        jdField_f_of_type_Int = localDisplayMetrics.heightPixels;
      }
    }
    else
    {
      return;
    }
    jdField_f_of_type_Int = localDisplayMetrics.widthPixels;
    jdField_e_of_type_Int = localDisplayMetrics.heightPixels;
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  @TargetApi(14)
  public static void a(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView.setFitsSystemWindows(paramBoolean);
      paramView.setPadding(0, getStatusBarHeight(paramView.getContext()), 0, 0);
    }
  }
  
  public static void a(Window paramWindow)
  {
    if (VersionUtils.isLOLLIPOP())
    {
      paramWindow.clearFlags(67108864);
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
    while (!VersionUtils.isKITKAT()) {
      return;
    }
    paramWindow.addFlags(67108864);
  }
  
  public static void a(@NonNull Window paramWindow, @ColorInt int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "[NavigationBar] setImmersiveNavigationBarColor activity=", paramWindow, " color=", Integer.valueOf(paramInt) });
    }
    try
    {
      paramWindow.addFlags(-2147483648);
      paramWindow.setNavigationBarColor(paramInt);
      return;
    }
    catch (Throwable paramWindow)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[NavigationBar] setNavigationBarColor =", paramWindow);
    }
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = Build.MANUFACTURER + Build.MODEL;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
      }
      if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
        b(paramWindow);
      }
    }
    else
    {
      return;
    }
    d(paramWindow);
  }
  
  public static boolean a()
  {
    return (VersionUtils.isKITKAT()) && (((jdField_d_of_type_Boolean) && (SystemUtil.isMIUI())) || (SystemUtil.isFlyme()));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!jdField_e_of_type_Boolean)
    {
      jdField_f_of_type_Boolean = LiuHaiUtils.b(paramActivity);
      jdField_e_of_type_Boolean = true;
    }
    return jdField_f_of_type_Boolean;
  }
  
  public static boolean a(Window paramWindow)
  {
    Rect localRect = new Rect();
    paramWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    if ((localRect.top <= 0) || (localRect.top > 200))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "invalid status height: " + localRect.top);
      return false;
    }
    if (Math.abs(localRect.top - jdField_c_of_type_Int) > 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "correct status bar height: " + jdField_c_of_type_Int + ", top = " + localRect.top);
      }
      jdField_c_of_type_Int = localRect.top;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0).edit().putInt("status_bar_height", jdField_c_of_type_Int).apply();
      jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if (!VersionUtils.isKITKAT()) {}
    do
    {
      return false;
      if ((jdField_d_of_type_Boolean) && (SystemUtil.isMIUI())) {
        return b(paramWindow, paramBoolean);
      }
    } while (!SystemUtil.isFlyme());
    return c(paramWindow, paramBoolean);
  }
  
  public static boolean a(boolean paramBoolean, Window paramWindow)
  {
    if (OSUtils.isFlymeOS()) {
      return c(paramWindow, paramBoolean);
    }
    if (OSUtils.isMIUI()) {
      return d(paramWindow, paramBoolean);
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
  
  public static int b()
  {
    a();
    return jdField_f_of_type_Int;
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(paramFloat / a());
  }
  
  public static void b(Window paramWindow)
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
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_a_of_type_JavaLangString, 2, "反射修改状态栏颜色失败");
    }
  }
  
  @TargetApi(23)
  private static void b(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
  }
  
  public static boolean b()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if ((paramWindow != null) && (jdField_d_of_type_Boolean))
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
        jdField_d_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForMIUI: failed");
        }
      }
    }
  }
  
  public static void c(@NonNull Window paramWindow)
  {
    for (;;)
    {
      try
      {
        boolean bool = bhii.b(BaseApplicationImpl.sApplication, "KEY_DISABLE_NAVIGATION_BAR", true);
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[NavigationBar] enableNavigationBarColor =", Boolean.valueOf(bool) });
        if (bool) {
          return;
        }
        if ((jdField_d_of_type_Int == 2147483647) && (Build.VERSION.SDK_INT >= 21)) {
          jdField_d_of_type_Int = paramWindow.getNavigationBarColor();
        }
        bool = ThemeUtil.isNowThemeIsNight(null, false, "");
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[NavigationBar] setNavigationBarColor sLightThemeNavigationBarColor=", Integer.valueOf(jdField_d_of_type_Int), " isNightMode=", Boolean.valueOf(bool) });
        if (bool)
        {
          i = -16777216;
          a(paramWindow, i);
          return;
        }
      }
      catch (Throwable paramWindow)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[NavigationBar] setNavigationBarColor throwable=", paramWindow);
        return;
      }
      int i = jdField_d_of_type_Int;
    }
  }
  
  public static boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = OSUtils.isMIUI();
    boolean bool3 = OSUtils.isFlymeOS();
    if (Build.VERSION.SDK_INT >= 23) {}
    for (int i = 1;; i = 0)
    {
      if ((bool2) || (bool3) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean)
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
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForFlyme: failed");
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
  
  private static void d(Window paramWindow)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) || (b()))
      {
        paramWindow.clearFlags(67108864);
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        paramWindow.setStatusBarColor(0);
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramWindow, new Object[0]);
    }
  }
  
  private static boolean d(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      b(paramWindow, paramBoolean);
      return true;
    }
    return e(paramWindow, paramBoolean);
  }
  
  private static boolean e(Window paramWindow, boolean paramBoolean)
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
  
  public static int getStatusBarHeight(Context paramContext)
  {
    float f2 = 1.0F;
    int i = 0;
    SharedPreferences localSharedPreferences;
    float f1;
    if (jdField_c_of_type_Int == -1)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      jdField_c_of_type_Int = localSharedPreferences.getInt("status_bar_height", -1);
      if (jdField_c_of_type_Int == -1)
      {
        Resources localResources = paramContext.getResources();
        int j = localResources.getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0) {
          i = localResources.getDimensionPixelSize(j);
        }
        f1 = FontSettingManager.systemMetrics.density;
        if (QLog.isColorLevel()) {
          QLog.d("systembar", 2, "getStatusBarHeight org=" + i + ", sys density=" + f1 + ", cur density=" + paramContext.getResources().getDisplayMetrics().density);
        }
        f1 /= paramContext.getResources().getDisplayMetrics().density;
        if (i > 0) {
          break label257;
        }
        if (f1 > 0.0F) {
          break label254;
        }
        f1 = 1.0F;
      }
    }
    label254:
    for (;;)
    {
      i = a(f1 * 25.0F);
      jdField_c_of_type_Int = i;
      localSharedPreferences.edit().putInt("status_bar_height", jdField_c_of_type_Int).apply();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "height=" + jdField_c_of_type_Int);
      }
      return jdField_c_of_type_Int;
    }
    label257:
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
  
  public static int isSupporImmersive()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      jdField_a_of_type_Int = 0;
      return jdField_a_of_type_Int;
    }
    String str1 = Build.MANUFACTURER.toUpperCase();
    String str2 = str1 + "-" + Build.MODEL;
    if (((!str1.endsWith("BBK")) && (!str1.endsWith("VIVO"))) || ((Build.VERSION.SDK_INT < 20) || (str2.equals("OPPO-3007")))) {}
    for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 1) {
      return jdField_a_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */