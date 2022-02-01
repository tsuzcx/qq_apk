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
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ImmersiveUtils
{
  public static int FLAG_TRANSLUCENT_STATUS = 0;
  private static final String KEY_STATUS_BAR_HEIGHT = "status_bar_height";
  public static String TAG;
  private static float density;
  public static boolean enableStatusBarDarkModeForMIUI = true;
  public static int i_support_immersive;
  public static boolean isStatusNotChange;
  public static boolean m_needImmersive;
  private static int screenHeight;
  private static int screenWidth;
  public static int statusHeight;
  public static volatile boolean statusHeightCorrect;
  
  static
  {
    if ("Success".equals(MobileQQ.sInjectResult))
    {
      MobileQQ.sImmersiveUtilsEscapedMsg = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sInjectResult:");
      ((StringBuilder)localObject).append(MobileQQ.sInjectResult);
      localObject = ((StringBuilder)localObject).toString();
      try
      {
        throw new IllegalAccessError("ImmersiveUtils escapes!");
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("\n");
        localStringBuilder.append(QLog.getStackTraceString(localThrowable));
        MobileQQ.sImmersiveUtilsEscapedMsg = localStringBuilder.toString();
        QLog.e("DexLoad", 1, "ImmersiveUtils escapes!");
      }
    }
    TAG = "ImmersiveUtils";
    density = -1.0F;
    screenWidth = -1;
    screenHeight = -1;
    i_support_immersive = -1;
    m_needImmersive = true;
    FLAG_TRANSLUCENT_STATUS = 67108864;
    isStatusNotChange = false;
    statusHeight = -1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("smartisan-sm705")) {
      isStatusNotChange = true;
    }
    if (((String)localObject).equalsIgnoreCase("vivo-vivo Y35A")) {
      isStatusNotChange = true;
    }
  }
  
  public static int PxToDp(float paramFloat)
  {
    return Math.round(paramFloat / getDensity());
  }
  
  public static void addStatusAsView(Activity paramActivity, int paramInt)
  {
    View localView = new View(paramActivity);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(paramActivity)));
    localView.setBackgroundDrawable(paramActivity.getResources().getDrawable(paramInt));
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(localView);
  }
  
  public static void adjustThemeStatusBar(Window paramWindow)
  {
    if ((QQTheme.a(getCurrentUin(), true)) && (isSupporImmersive() != 0) && (couldSetStatusTextColor())) {
      setStatusTextColor(QQTheme.a(paramWindow.getDecorView().getResources().getColor(2131167114)) ^ true, paramWindow);
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
        paramWindow.setStatusBarColor(0);
        return;
      }
    }
    catch (Exception paramWindow)
    {
      QLog.e(TAG, 1, paramWindow, new Object[0]);
    }
  }
  
  public static void clearCoverForStatus(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MANUFACTURER = ");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append(", MODEL = ");
        localStringBuilder.append(Build.MODEL);
        QLog.i(str, 2, localStringBuilder.toString());
      }
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
  
  public static boolean correctStatusBarHeight(Window paramWindow)
  {
    Rect localRect = new Rect();
    paramWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    if ((localRect.top > 0) && (localRect.top <= 200))
    {
      if (Math.abs(localRect.top - statusHeight) > 1)
      {
        if (QLog.isColorLevel())
        {
          paramWindow = new StringBuilder();
          paramWindow.append("correct status bar height: ");
          paramWindow.append(statusHeight);
          paramWindow.append(", top = ");
          paramWindow.append(localRect.top);
          QLog.d("systembar", 2, paramWindow.toString());
        }
        statusHeight = localRect.top;
        MobileQQ.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("status_bar_height", statusHeight).apply();
        statusHeightCorrect = true;
        return true;
      }
      return false;
    }
    paramWindow = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid status height: ");
    localStringBuilder.append(localRect.top);
    QLog.w(paramWindow, 2, localStringBuilder.toString());
    return false;
  }
  
  public static boolean couldSetStatusTextColor()
  {
    boolean bool3 = OSUtils.isMIUI();
    boolean bool4 = OSUtils.isFlymeOS();
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (i >= 23) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4)
      {
        if (i != 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(paramFloat * getDensity());
  }
  
  private static String getCurrentUin()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  public static float getDensity()
  {
    init();
    return density;
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
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("mobileQQ", 4);
      statusHeight = localSharedPreferences.getInt("status_bar_height", -1);
      if (statusHeight == -1)
      {
        Object localObject = paramContext.getResources();
        int i = ((Resources)localObject).getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0) {
          i = ((Resources)localObject).getDimensionPixelSize(i);
        } else {
          i = 0;
        }
        float f1 = FontSettingManager.systemMetrics.density;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getStatusBarHeight org=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", sys density=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(", cur density=");
          ((StringBuilder)localObject).append(paramContext.getResources().getDisplayMetrics().density);
          QLog.d("systembar", 2, ((StringBuilder)localObject).toString());
        }
        f1 /= paramContext.getResources().getDisplayMetrics().density;
        float f2 = 1.0F;
        if (i <= 0)
        {
          if (f1 <= 0.0F) {
            f1 = f2;
          }
          i = dpToPx(f1 * 25.0F);
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
        localSharedPreferences.edit().putInt("status_bar_height", statusHeight).apply();
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("height=");
        paramContext.append(statusHeight);
        QLog.i("systembar", 2, paramContext.toString());
      }
    }
    return statusHeight;
  }
  
  private static void init()
  {
    if (density == -1.0F)
    {
      DisplayMetrics localDisplayMetrics = MobileQQ.getContext().getResources().getDisplayMetrics();
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
  
  public static int isSupporImmersive()
  {
    int i = i_support_immersive;
    if (i != -1) {
      return i;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      i_support_immersive = 0;
      return i_support_immersive;
    }
    String str = Build.MANUFACTURER.toUpperCase();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (((!str.endsWith("BBK")) && (!str.endsWith("VIVO"))) || ((Build.VERSION.SDK_INT >= 20) && (!((String)localObject).equals("OPPO-3007")))) {
      i_support_immersive = 1;
    } else {
      i_support_immersive = 0;
    }
    return i_support_immersive;
  }
  
  public static boolean isVivoAndLOLLIPOP()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
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
  
  @TargetApi(11)
  public static void setAlpha(View paramView, float paramFloat)
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
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView.setFitsSystemWindows(paramBoolean);
      paramView.setPadding(0, getStatusBarHeight(paramView.getContext()), 0, 0);
    }
  }
  
  public static void setRootView(Activity paramActivity)
  {
    paramActivity = ((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0);
    if ((paramActivity instanceof ViewGroup))
    {
      paramActivity.setFitsSystemWindows(true);
      ((ViewGroup)paramActivity).setClipToPadding(true);
    }
  }
  
  public static boolean setStatusBarDarkMode(Window paramWindow, boolean paramBoolean)
  {
    boolean bool2 = VersionUtils.i();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if ((enableStatusBarDarkModeForMIUI) && (SystemUtil.b())) {
      return setStatusBarDarkModeForMIUI(paramWindow, paramBoolean);
    }
    if (SystemUtil.d()) {
      bool1 = setStatusBarDarkModeForFlyme(paramWindow, paramBoolean);
    }
    return bool1;
  }
  
  private static boolean setStatusBarDarkModeForFlyme(Window paramWindow, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
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
        break label195;
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
        boolean bool1;
        continue;
        int i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    localField2.setInt(localLayoutParams, i);
    paramWindow.setAttributes(localLayoutParams);
    bool1 = true;
    break label120;
    bool1 = bool3;
    if (QLog.isColorLevel())
    {
      QLog.e(TAG, 2, "setStatusBarDarkModeForFlyme: failed");
      bool1 = bool3;
    }
    label120:
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
  
  private static boolean setStatusBarDarkModeForMIUI(Window paramWindow, boolean paramBoolean)
  {
    Object localObject;
    if ((paramWindow != null) && (enableStatusBarDarkModeForMIUI)) {
      localObject = paramWindow.getClass();
    }
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (!paramBoolean) {
        break label126;
      }
      i = j;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        int j;
        continue;
        int i = 0;
      }
    }
    ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    return true;
    enableStatusBarDarkModeForMIUI = false;
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "setStatusBarDarkModeForMIUI: failed");
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
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "反射修改状态栏颜色失败");
    }
  }
  
  public static boolean supportStatusBarDarkMode()
  {
    return (VersionUtils.i()) && (((enableStatusBarDarkModeForMIUI) && (SystemUtil.b())) || (SystemUtil.d()));
  }
  
  public static void trySetImmersiveStatusBar(Window paramWindow)
  {
    if (VersionUtils.j())
    {
      paramWindow.clearFlags(67108864);
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
      return;
    }
    if (VersionUtils.i()) {
      paramWindow.addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */