package com.tencent.mobileqq.vas.theme;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class NightModeLogic
{
  Handler jdField_a_of_type_AndroidOsHandler = new NightModeLogic.2(this, Looper.getMainLooper());
  IThemeSwitchManager jdField_a_of_type_ComTencentMobileqqVasManagerApiIThemeSwitchManager;
  ThemeSwitchCallback jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitchCallback = new NightModeLogic.1(this);
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<NightModeLogic.NightModeCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public NightModeLogic(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqVasManagerApiIThemeSwitchManager = VasUtil.a().getThemeSwitchManager();
  }
  
  public int a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NightModeLogic", 2, "switchRightViewImage status: juhua");
      }
      return 0;
    }
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NightModeLogic", 2, "switchRightViewImage status: sun");
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "switchRightViewImage status: moon");
    }
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = null;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NightModeLogic.NightModeCallback localNightModeCallback = (NightModeLogic.NightModeCallback)localIterator.next();
      if (1 == paramInt) {
        localNightModeCallback.b(paramBundle);
      } else if (-2 == paramInt) {
        localNightModeCallback.a(paramBundle);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.e("NightModeLogic", 1, "startNightMode Err mRuntime == null");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startNightMode, isNightMode=");
      localStringBuilder.append(ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime));
      localStringBuilder.append(", nowThemeId=");
      localStringBuilder.append(ThemeUtil.getCurrentThemeId());
      localStringBuilder.append(", userThemeId=");
      localStringBuilder.append(ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_MqqAppAppRuntime));
      localStringBuilder.append(", mRuntime=");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime);
      QLog.d("NightModeLogic", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    boolean bool = b();
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("startNightMode result=");
      paramActivity.append(bool);
      QLog.i("NightModeLogic", 2, paramActivity.toString());
    }
  }
  
  public void a(NightModeLogic.NightModeCallback paramNightModeCallback, boolean paramBoolean)
  {
    if (paramNightModeCallback != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramNightModeCallback);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramNightModeCallback);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public boolean a()
  {
    boolean bool = ThemeSwitcher.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDownloadOrSwtich: ");
    localStringBuilder.append(bool);
    QLog.e("NightModeLogic", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasManagerApiIThemeSwitchManager.onPostThemeChanged();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof AppRuntime)) {
      ((ISimpleUIHandler)QRoute.api(ISimpleUIHandler.class)).onPostThemeChanged();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "setupNightTheme");
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.e("NightModeLogic", 1, "setupNightTheme Err mRuntime == null");
      return false;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("start_status", 1);
    a(1, (Bundle)localObject1);
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
    boolean bool2 = SimpleUIUtil.a();
    if (!bool1)
    {
      if (bool2) {
        localObject1 = "2920";
      } else {
        localObject1 = "1103";
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
    }
    else if (bool2)
    {
      localObject1 = SimpleUIUtil.a(SimpleUIUtil.g());
    }
    else
    {
      localObject2 = ThemeSwitchUtil.a(this.jdField_a_of_type_MqqAppAppRuntime);
      localObject1 = ((Bundle)localObject2).getString("themeID");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupNightTheme, pre themeID=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",version=");
      localStringBuilder.append(((Bundle)localObject2).getString("version"));
      QLog.d("NightModeLogic", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = "1000";
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setupNightTheme themeID=");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("NightModeLogic", 1, ((StringBuilder)localObject2).toString());
    ThemeSwitcher.a((String)localObject1, "202", this.jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitchCallback);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.NightModeLogic
 * JD-Core Version:    0.7.0.1
 */