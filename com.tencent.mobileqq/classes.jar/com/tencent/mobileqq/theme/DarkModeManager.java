package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.config.business.DarkModeConfigProcessor;
import com.tencent.mobileqq.settings.message.ReportClickEventHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class DarkModeManager
{
  private static boolean a = false;
  private static boolean b = false;
  
  protected static void a(Activity paramActivity, String paramString, DarkModeManager.ActionResult paramActionResult)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = DialogUtil.a(paramActivity, 0, null, paramActivity.getString(2131916335), paramActivity.getString(2131887648), paramActivity.getString(2131888010), new DarkModeManager.4(paramActionResult), new DarkModeManager.5(paramActionResult));
      paramActivity.show();
      paramActivity.setCancelable(false);
      b("0X800A5C9");
      return;
    }
    QLog.e("DarkModeManager", 2, "showThemeDarkModeTips error!: ");
  }
  
  public static void a(IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    if (b())
    {
      boolean bool1;
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) == 32) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateDarkModeStatus isNightMode  = ");
        localStringBuilder.append(bool2);
        localStringBuilder.append(", isDarkMode = ");
        localStringBuilder.append(bool1);
        QLog.d("DarkModeManager", 2, localStringBuilder.toString());
      }
      b(bool1, bool2, paramIThemeSwitchCallback);
      return;
    }
    if ((b) && (!AutomatorHelper.b)) {
      k();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    ReportClickEventHelper.a(j(), "0X800B86E", paramBoolean);
    a = paramBoolean;
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateModeStatus isOpened  = ");
      localStringBuilder.append(a);
      QLog.d("DarkModeManager", 2, localStringBuilder.toString());
    }
    localSharedPreferences.edit().putBoolean("dark_switch_key", a).apply();
  }
  
  protected static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      String str = localBaseActivity.getString(2131916338);
      if (!paramBoolean1) {
        str = localBaseActivity.getString(2131916334);
      }
      paramString1 = DialogUtil.a(localBaseActivity, 0, null, str, localBaseActivity.getString(2131887648), localBaseActivity.getString(2131888010), new DarkModeManager.1(paramBoolean1, paramBoolean2), new DarkModeManager.2(paramString1, paramString2));
      paramString1.show();
      paramString1.setCancelable(false);
      h();
      b("0X800A5B4");
      return;
    }
    QLog.e("DarkModeManager", 2, "showDarkModeTips error!: ");
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 29;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = b();
    boolean bool1 = true;
    if (bool2)
    {
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) == 32) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("updateDarkModeStatus isNightMode  = ");
        paramString.append(bool2);
        paramString.append(", isDarkMode = ");
        paramString.append(bool1);
        QLog.d("DarkModeManager", 2, paramString.toString());
      }
      if (bool1 == bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (a())
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject != null)
      {
        if (((Activity)localObject).isFinishing()) {
          return false;
        }
        boolean bool1;
        if ((((Activity)localObject).getResources().getConfiguration().uiMode & 0x30) == 32) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("afterDownloadRoamTheme isNightMode  = ");
          ((StringBuilder)localObject).append(bool2);
          ((StringBuilder)localObject).append(", isDarkMode = ");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(", isCurrentVersionFirstLaunch = ");
          ((StringBuilder)localObject).append(AutomatorHelper.b);
          QLog.d("DarkModeManager", 2, ((StringBuilder)localObject).toString());
        }
        if (bool1 == bool2) {
          return false;
        }
        if ((!g()) && (DarkModeConfigProcessor.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme dialog will show!");
          }
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            a(bool1, bool2, paramString1, paramString2);
            return true;
          }
          ThreadManager.getUIHandler().post(new DarkModeManager.3(bool1, bool2, paramString1, paramString2));
          return true;
        }
        if (b())
        {
          b(bool1, bool2, null);
          if (QLog.isColorLevel()) {
            QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! switch is opened, so switch theme!");
          }
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("DarkModeManager", 2, "afterDownloadRoamTheme iscalled! the system version is lower 29! so do not dialog!");
    }
    return false;
  }
  
  private static void b(IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    int i;
    if (SimpleUIUtil.e())
    {
      i = SimpleUIUtil.j();
      str = SimpleUIUtil.a(i);
    }
    try
    {
      ((ModeSwitchManager)j().getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).a(i, 1);
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      break label122;
    }
    localObject = ThemeSwitchUtil.a(j());
    String str = ((Bundle)localObject).getString("themeID");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("closedNightMode, pre themeID=");
    localStringBuilder.append(str);
    localStringBuilder.append(",version=");
    localStringBuilder.append(((Bundle)localObject).getString("version"));
    QLog.d("DarkModeManager", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      str = "1000";
    }
    label122:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closedNightMode is called, will set themeID=");
    ((StringBuilder)localObject).append(str);
    QLog.d("DarkModeManager", 1, ((StringBuilder)localObject).toString());
    ThemeSwitcher.a(str, "202", paramIThemeSwitchCallback);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("DarkModeManager", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2, IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      e();
      return;
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      b(paramIThemeSwitchCallback);
    }
  }
  
  public static boolean b()
  {
    return (a()) && (c());
  }
  
  public static boolean b(Activity paramActivity, String paramString, DarkModeManager.ActionResult paramActionResult)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return false;
      }
      if (b())
      {
        boolean bool1;
        if ((paramActivity.getResources().getConfiguration().uiMode & 0x30) == 32) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
        if (TextUtils.isEmpty(paramString)) {
          bool2 = ThemeUtil.isNowThemeIsNight(null, false, null) ^ true;
        }
        if (bool1 == bool2) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("userSetThemeAction isNightMode  = ");
          localStringBuilder.append(bool2);
          localStringBuilder.append(", isDarkMode = ");
          localStringBuilder.append(bool1);
          QLog.d("DarkModeManager", 2, localStringBuilder.toString());
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          a(paramActivity, paramString, paramActionResult);
          return true;
        }
        ThreadManager.getUIHandler().post(new DarkModeManager.6(paramActivity, paramString, paramActionResult));
        return true;
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDarkModeSwitch isOpened  = ");
      localStringBuilder.append(a);
      QLog.d("DarkModeManager", 2, localStringBuilder.toString());
    }
    return a;
  }
  
  private static void e()
  {
    String str;
    if (SimpleUIUtil.e()) {
      str = "2920";
    } else {
      str = "1103";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToNightMode themeID=");
    localStringBuilder.append(str);
    QLog.d("DarkModeManager", 1, localStringBuilder.toString());
    ThemeSwitcher.a(str, "202", null);
  }
  
  private static void f()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences != null)
    {
      a = localSharedPreferences.getBoolean("dark_switch_key", false);
      return;
    }
    a = true;
  }
  
  private static boolean g()
  {
    SharedPreferences localSharedPreferences = i();
    boolean bool = false;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("dialog_has_shown_key", false);
    }
    return bool;
  }
  
  private static void h()
  {
    SharedPreferences localSharedPreferences = i();
    if (localSharedPreferences == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "setShownPromtFlag is called!");
    }
    localSharedPreferences.edit().putBoolean("dialog_has_shown_key", true).apply();
  }
  
  private static SharedPreferences i()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if (localObject != null)
        {
          localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences("DarkModeManagerdark_mode_ui", 4);
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DarkModeManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  @Nullable
  private static QQAppInterface j()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  private static void k()
  {
    a("1000", "204");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.DarkModeManager
 * JD-Core Version:    0.7.0.1
 */