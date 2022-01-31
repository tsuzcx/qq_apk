package com.tencent.mobileqq.theme;

import ahzu;
import ahzv;
import ahzw;
import ahzx;
import ahzy;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NightModeLogic
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Dialog a;
  public Handler a;
  ThemeDownloader.ThemeDownloadListener jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = new ahzx(this);
  ThemeDownloader jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader;
  ThemeSwitchManager jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager;
  private ThemeUtil.ThemeInfo jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AppRuntime a;
  public boolean a;
  boolean b;
  
  public NightModeLogic(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidOsHandler = new ahzy(this, Looper.getMainLooper());
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (ThemeSwitchManager)((QQAppInterface)paramAppRuntime).getManager(184);; paramAppRuntime = new ThemeSwitchManager(paramAppRuntime))
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager = paramAppRuntime;
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = ThemeUtil.getThemeInfo(this.jdField_a_of_type_AndroidAppActivity, "1103");
      if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = new ThemeUtil.ThemeInfo();
        this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId = "1103";
      }
      return;
    }
  }
  
  private Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt1);
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt2);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt3);
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject1, new Object[] { paramString });; paramString = (String)localObject1)
    {
      localObject1 = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131624515);
      ((Dialog)localObject1).setContentView(2130968842);
      TextView localTextView = (TextView)((Dialog)localObject1).findViewById(2131364010);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = (TextView)((Dialog)localObject1).findViewById(2131362758);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(paramString);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131364013);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131364014);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return localObject1;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "showDownloadDialog");
    }
    this.jdField_a_of_type_AndroidAppDialog = a(2131434104, 2131434105, 2131432998, 2131434592, (float)Math.round(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.size / 1024.0D / 1024.0D * 100.0D) / 100.0F + "", new ahzu(this), new ahzv(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ahzw(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public int a()
  {
    int i = 2;
    ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), "1103");
    if ((a()) || ((localThemeInfo != null) && (localThemeInfo.status.equals("2"))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NightModeLogic", 2, "switchRightViewImage status: juhua");
      }
      i = 0;
    }
    do
    {
      return i;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NightModeLogic", 2, "switchRightViewImage status: sun");
        }
        return 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "switchRightViewImage status: moon");
    return 2;
  }
  
  public ThemeUtil.ThemeInfo a()
  {
    Object localObject;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
    }
    ThemeUtil.ThemeInfo localThemeInfo;
    do
    {
      return localObject;
      localThemeInfo = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), "1103");
      localObject = localThemeInfo;
    } while (localThemeInfo != null);
    try
    {
      ThemeUtil.setThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo);
      return this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NightModeLogic", 2, "getNightThemeInfo err:" + localException.getMessage());
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      QLog.e("NightModeLogic", 1, "checkThemeStatus Err mRuntime == null");
    }
    boolean bool;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (!a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NightModeLogic", 2, "checkThemeStatus is download or switching theme");
      return;
      Object localObject = a();
      if ((!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) && (!a((ThemeUtil.ThemeInfo)localObject)))
      {
        int i = NetworkUtil.a(this.jdField_a_of_type_AndroidAppActivity);
        if ((1 == i) || (4 == i))
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putInt("start_status", 1);
            a(0, (Bundle)localObject);
          }
          b();
        }
        for (;;)
        {
          ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "2", "", "", "");
          return;
          d();
        }
      }
      bool = c();
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "startNightMode result=" + bool);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NightModeLogic.NightModeCallback localNightModeCallback = (NightModeLogic.NightModeCallback)localIterator.next();
      if (paramInt == 0) {
        localNightModeCallback.c(paramBundle);
      } else if (1 == paramInt) {
        localNightModeCallback.b(paramBundle);
      } else if (-1 == paramInt) {
        localNightModeCallback.d(paramBundle);
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
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "startNightMode, isNightMode=" + ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime) + ", nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_MqqAppAppRuntime) + ", mRuntime=" + this.jdField_a_of_type_MqqAppAppRuntime);
    }
    a();
  }
  
  public void a(NightModeLogic.NightModeCallback paramNightModeCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramNightModeCallback != null)
    {
      if ((paramBoolean1) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramNightModeCallback))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramNightModeCallback);
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramNightModeCallback))) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramNightModeCallback);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("NightModeLogic", 2, "isDownloadOrSwtich isDownloadingInProgress=" + this.jdField_a_of_type_Boolean + ", switching=" + this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public boolean a(ThemeUtil.ThemeInfo paramThemeInfo)
  {
    boolean bool4 = true;
    boolean bool1;
    if ((paramThemeInfo == null) || (this.jdField_a_of_type_MqqAppAppRuntime == null))
    {
      QLog.e("NightModeLogic", 2, "isThemeExist err: info=" + paramThemeInfo + ", mRuntime=" + this.jdField_a_of_type_MqqAppAppRuntime);
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool4;
    } while ("1000".equals(paramThemeInfo.themeId));
    if ((TextUtils.isEmpty(paramThemeInfo.themeId)) || (TextUtils.isEmpty(paramThemeInfo.version)))
    {
      QLog.e("NightModeLogic", 2, "isThemeExist err: info id=" + paramThemeInfo.themeId + ", version:" + paramThemeInfo.version);
      return false;
    }
    boolean bool5 = ThemeDownloader.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version, paramThemeInfo.fileNum, "202");
    boolean bool2;
    if (bool5)
    {
      if ("5".equals(paramThemeInfo.status)) {
        break label409;
      }
      paramThemeInfo.status = "5";
      bool2 = false;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool3 = bool1;
      if (bool2)
      {
        bool3 = bool1;
        if (!"3".equals(paramThemeInfo.status))
        {
          paramThemeInfo.status = "3";
          bool3 = true;
        }
      }
      bool1 = bool3;
      if (!bool2)
      {
        bool1 = bool3;
        if (!bool5) {
          if (!"5".equals(paramThemeInfo.status))
          {
            bool1 = bool3;
            if (!"3".equals(paramThemeInfo.status)) {}
          }
          else
          {
            paramThemeInfo.status = "1";
            bool1 = true;
          }
        }
      }
      if ((!bool1) || (QLog.isColorLevel())) {
        QLog.d("NightModeLogic", 2, "isThemeExist info id=" + paramThemeInfo.themeId + ", ver=" + paramThemeInfo.version + ", needSave=" + bool1 + ", isZipExist=" + bool2 + ", isFileExist=" + bool5);
      }
      bool1 = bool4;
      if (bool2) {
        break;
      }
      bool1 = bool4;
      if (bool5) {
        break;
      }
      return false;
      bool2 = ThemeDownloader.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), paramThemeInfo.themeId, "20000000", paramThemeInfo.size, "202");
      bool1 = false;
      continue;
      label409:
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.onDestroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager = null;
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader = null;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "downLoadNightTheme nightthemeInfo");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NightModeLogic", 2, "downLoadNightTheme is downloading theme");
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId);
    localBundle.putString("version", this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version);
    localBundle.putBoolean("isVoiceTheme", false);
    localBundle.putInt("net_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId, true, false);
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader = new ThemeDownloader(this.jdField_a_of_type_MqqAppAppRuntime, "202");
    int i = this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), localBundle, this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener);
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "downLoadNightTheme opCode:" + i + ", id:" + this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId + ", size:" + this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.size);
    }
    return true;
  }
  
  public void c()
  {
    if (this.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4100);
      this.b = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.b();
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "setupNightTheme");
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.e("NightModeLogic", 1, "setupNightTheme Err mRuntime == null");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.d("NightModeLogic", 2, "setupNightTheme Err themeSwitchManager.mIsSwitching=true, return;");
      return false;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("start_status", 1);
    a(0, (Bundle)localObject1);
    boolean bool = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
    ThemeUtil.ThemeInfo localThemeInfo = new ThemeUtil.ThemeInfo();
    Object localObject2;
    if (!bool)
    {
      localObject1 = a();
      ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
      VasWebviewUtil.reportVasStatus("Setting_tab", "Night_mode", "0", 0, 0);
      if ((TextUtils.isEmpty(((ThemeUtil.ThemeInfo)localObject1).themeId)) || (TextUtils.isEmpty(((ThemeUtil.ThemeInfo)localObject1).version)))
      {
        QLog.e("NightModeLogic", 2, "setupNightTheme data Err, themeID=" + ((ThemeUtil.ThemeInfo)localObject1).themeId + ", version=" + ((ThemeUtil.ThemeInfo)localObject1).version);
        return false;
      }
    }
    else
    {
      localObject1 = ThemeSwitchUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      String str = ((Bundle)localObject1).getString("themeID");
      if ((QLog.isColorLevel()) || (TextUtils.isEmpty(str))) {
        QLog.d("NightModeLogic", 2, "setupNightTheme, pre themeID=" + str + ",version=" + ((Bundle)localObject1).getString("version"));
      }
      int i = 0;
      if (("1000".equals(str)) || (TextUtils.isEmpty(str)))
      {
        i = 1;
        localObject1 = localThemeInfo;
      }
      for (;;)
      {
        if ((i != 0) || (!a((ThemeUtil.ThemeInfo)localObject1)))
        {
          if (i == 0)
          {
            QLog.e("NightModeLogic", 2, "setupNightTheme theme is not exists, so setup default theme:preThemeId=" + str);
            this.b = true;
          }
          ((ThemeUtil.ThemeInfo)localObject1).themeId = "1000";
          ((ThemeUtil.ThemeInfo)localObject1).version = "0";
        }
        ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
        break;
        localObject1 = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), str);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if ("1000".equals(str))
          {
            localObject2 = new ThemeUtil.ThemeInfo();
            ((ThemeUtil.ThemeInfo)localObject2).themeId = str;
            ((ThemeUtil.ThemeInfo)localObject2).version = "0";
            ((ThemeUtil.ThemeInfo)localObject2).status = "5";
            ThemeUtil.setThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), (ThemeUtil.ThemeInfo)localObject2);
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          i = 1;
          this.b = true;
          QLog.e("NightModeLogic", 2, "setupNightTheme normal Theme Err, themeID=" + str);
          localObject1 = localThemeInfo;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "setupNightTheme themeID=" + ((ThemeUtil.ThemeInfo)localObject1).themeId);
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, (ThemeUtil.ThemeInfo)localObject1, false, true, "202");
    if ((!"999".equals(((ThemeUtil.ThemeInfo)localObject1).themeId)) && (!"1000".equals(((ThemeUtil.ThemeInfo)localObject1).themeId)) && (((ThemeUtil.ThemeInfo)localObject1).zipVer < 20000000))
    {
      localObject2 = ThemeUtil.getThemeConfigID(((ThemeUtil.ThemeInfo)localObject1).themeId);
      localObject1 = ThemeUtil.getThemeDownloadFilePath(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), ((ThemeUtil.ThemeInfo)localObject1).themeId, "20000000") + "_no";
      VasQuickUpdateManager.a(this.jdField_a_of_type_MqqAppAppRuntime, 3L, (String)localObject2, (String)localObject1, true, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic
 * JD-Core Version:    0.7.0.1
 */