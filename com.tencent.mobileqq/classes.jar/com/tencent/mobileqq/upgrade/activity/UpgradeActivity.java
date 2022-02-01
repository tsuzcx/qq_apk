package com.tencent.mobileqq.upgrade.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeActivity
  extends BaseActivity
{
  private static long jdField_b_of_type_Long;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = null;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = null;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = null;
  private String f = null;
  private String g = null;
  private String h = null;
  
  private void a(boolean paramBoolean)
  {
    if (UpgradeController.a().a() == 4)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = this;
      BannerManager.a().b(17, localMessage);
      return;
    }
    UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131715759);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131715762);
    showDialog(16384);
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("StrTitle");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("StrUpgradeDesc");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("StrUrl");
    this.f = getIntent().getStringExtra("strDesc");
    this.g = getIntent().getStringExtra("lBtnText");
    this.h = getIntent().getStringExtra("rBtnText");
    this.jdField_c_of_type_Int = getIntent().getIntExtra("iUpgradeType", 0);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("iTipsType", 0);
    if (getIntent().hasExtra("strConfirmBtnText")) {
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("strConfirmBtnText");
    }
    if (getIntent().hasExtra("strCancelButtonDesc")) {
      this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("strCancelButtonDesc");
    }
    if (UpgradeController.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = getIntent().getLongExtra("showTime", 0L);
      this.jdField_b_of_type_Int = getIntent().getIntExtra("iUpgradeSdkId", 0);
      this.jdField_e_of_type_Int = getIntent().getIntExtra("rate", 1);
      if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
      {
        if (this.jdField_b_of_type_JavaLangString == null)
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
          QLog.d("qqBaseActivity", 4, "=wrapper手动赋值:strTitle: " + this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_JavaLangString == null)
        {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
          QLog.d("qqBaseActivity", 4, "wrapper手动赋值:strUpgradeDesc: " + this.jdField_c_of_type_JavaLangString);
        }
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType;
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
      }
      getIntent().getIntExtra("mode", 0);
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      showDialog(2);
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      showDialog(1);
      return;
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      showDialog(3);
      return;
    }
    finish();
  }
  
  private void f() {}
  
  private void g() {}
  
  void a()
  {
    finish();
    this.app.exit(false);
  }
  
  void b()
  {
    if (this.app != null)
    {
      localSharedPreferences = this.app.getPreferences();
      i = localSharedPreferences.getInt("upgrade_tip_count", 0);
      if (i < 1) {
        localSharedPreferences.edit().putInt("upgrade_tip_count", i + 1).commit();
      }
    }
    while (!QLog.isColorLevel())
    {
      SharedPreferences localSharedPreferences;
      int i;
      return;
    }
    QLog.i("UpgradeActivty", 2, "UpgradeTipCounter --- app is null");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      paramBundle = new Intent();
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) {}
      for (;;)
      {
        paramBundle.putExtra("getUpgradeInfo", bool);
        setResult(-1, paramBundle);
        finish();
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          bool = true;
        }
      }
    }
    getWindow().setBackgroundDrawableResource(2131167305);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("activity_type", 4096);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      finish();
      return true;
    case 4096: 
      e();
      return true;
    case 8192: 
      c();
      return true;
    }
    d();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_b_of_type_Boolean) && (MyAppApi.a().b()))
    {
      if (!MyAppApi.a().f()) {
        NewUpgradeDialog.a(this);
      }
      finish();
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject1 = null;
    switch (paramInt)
    {
    }
    while (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject1).setOnDismissListener(new UpgradeActivity.18(this));
      return localObject1;
      ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
      localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((QQCustomDialog)localObject1).setPositiveButton(2131720401, new UpgradeActivity.3(this)).setNegativeButton(2131717087, new UpgradeActivity.2(this)).setOnKeyListener(new UpgradeActivity.1(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (UpgradeController.a().a() == 4) {}
        for (paramInt = 2131693442;; paramInt = 2131720401)
        {
          ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new UpgradeActivity.6(this)).setNegativeButton(2131720400, new UpgradeActivity.5(this)).setOnKeyListener(new UpgradeActivity.4(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "");
        ReportController.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          UpgradeActivity.7 local7 = new UpgradeActivity.7(this);
          UpgradeActivity.8 local8 = new UpgradeActivity.8(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = HardCodeUtil.a(2131715763);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label678;
              }
              str = HardCodeUtil.a(2131715756);
              paramInt = SharedPreUtils.aQ(this, this.app.getCurrentUin());
              SharedPreUtils.ag(this, this.app.getCurrentUin(), paramInt + 1);
              SharedPreUtils.k(this, this.app.getCurrentUin(), System.currentTimeMillis());
              QLog.d("qqBaseActivity", 4, "UpgradeActivity:strTitle: " + this.jdField_b_of_type_JavaLangString);
              QLog.d("qqBaseActivity", 4, "UpgradeActivity:strUpgradeDesc: " + this.jdField_c_of_type_JavaLangString);
              localObject1 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, local8, local7);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new UpgradeActivity.9(this));
              return localObject1;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException1.printStackTrace();
            continue;
            localObject2 = this.g;
            continue;
            label678:
            str = this.h;
          }
          if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString)))
          {
            localObject2 = HardCodeUtil.a(2131715754);
            label715:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label795;
            }
          }
          label795:
          for (String str = HardCodeUtil.a(2131715761);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = SharedPreUtils.aP(this, this.app.getCurrentUin());
            SharedPreUtils.af(this, this.app.getCurrentUin(), paramInt + 1);
            SharedPreUtils.j(this, this.app.getCurrentUin(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label715;
          }
        }
        Object localObject2 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(HardCodeUtil.a(2131715760), new UpgradeActivity.11(this)).setNegativeButton(HardCodeUtil.a(2131715765), new UpgradeActivity.10(this));
        continue;
        localObject2 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(HardCodeUtil.a(2131715757), new UpgradeActivity.13(this)).setNegativeButton(HardCodeUtil.a(2131715758), new UpgradeActivity.12(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_b_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_b_of_type_Long = l;
        localObject2 = UpgradeController.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          ToastUtil.a().a(HardCodeUtil.a(2131715764));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Long;
          SPSettings.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
          SPSettings.b(paramInt);
          if (MyAppApi.a().b())
          {
            localObject2 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new UpgradeActivity.14(this), new UpgradeActivity.15(this));
            ((QQCustomDialog)localObject2).setOnDismissListener(new UpgradeActivity.16(this));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 1, 100));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 2, 100));
            LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 1, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 2, 100));
            AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 3, 100));
            return localObject2;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
            localException2.printStackTrace();
          }
          this.jdField_b_of_type_Boolean = true;
          MyAppApi.a().a(false);
          localObject2 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((NewUpgradeDialog)localObject2).a(new UpgradeActivity.17(this, (NewUpgradeDialog)localObject2, paramInt), true);
          return localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */