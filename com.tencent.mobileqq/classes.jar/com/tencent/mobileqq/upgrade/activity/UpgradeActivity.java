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
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
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
      BannerManager.a().b(InstallUpgradeBannerProcessor.jdField_a_of_type_Int, localMessage);
      return;
    }
    UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131715683);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131715686);
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
    boolean bool;
    if (UpgradeController.a().a() == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Long = getIntent().getLongExtra("showTime", 0L);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("iUpgradeSdkId", 0);
    this.jdField_e_of_type_Int = getIntent().getIntExtra("rate", 1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=wrapper手动赋值:strTitle: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wrapper手动赋值:strUpgradeDesc: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
        QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
    }
    getIntent().getIntExtra("mode", 0);
    int i = this.jdField_c_of_type_Int;
    if (i == 2)
    {
      showDialog(2);
      return;
    }
    if (i == 1)
    {
      showDialog(1);
      return;
    }
    if (i == 3)
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
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      int i = localSharedPreferences.getInt("upgrade_tip_count", 0);
      if (i < 1)
      {
        localSharedPreferences.edit().putInt("upgrade_tip_count", i + 1).commit();
        return;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UpgradeActivty", 2, "UpgradeTipCounter --- app is null");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    if ((paramBundle != null) && (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType > 0))
    {
      getWindow().setBackgroundDrawableResource(2131167333);
      this.jdField_a_of_type_Int = getIntent().getIntExtra("activity_type", 4096);
      int i = this.jdField_a_of_type_Int;
      if (i != 4096)
      {
        if (i != 8192)
        {
          if (i != 16384)
          {
            finish();
            return true;
          }
          d();
          return true;
        }
        c();
        return true;
      }
      e();
      return true;
    }
    paramBundle = new Intent();
    UpgradeDetailWrapper localUpgradeDetailWrapper = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    boolean bool = false;
    if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)) {
      bool = true;
    }
    paramBundle.putExtra("getUpgradeInfo", bool);
    setResult(-1, paramBundle);
    finish();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_b_of_type_Boolean)
    {
      MyAppApi.a();
      if (MyAppApi.b())
      {
        if (!MyAppApi.a().f()) {
          NewUpgradeDialog.a(this);
        }
        finish();
      }
    }
  }
  
  protected void onAccountChanged()
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
    int i = 2131720140;
    Object localObject1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 8192)
          {
            if (paramInt == 16384)
            {
              localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
              ((QQCustomDialog)localObject1).setPositiveButton(HardCodeUtil.a(2131715681), new UpgradeActivity.13(this)).setNegativeButton(HardCodeUtil.a(2131715682), new UpgradeActivity.12(this));
              break label1287;
            }
          }
          else
          {
            localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
            ((QQCustomDialog)localObject1).setPositiveButton(HardCodeUtil.a(2131715684), new UpgradeActivity.11(this)).setNegativeButton(HardCodeUtil.a(2131715689), new UpgradeActivity.10(this));
            break label1287;
          }
        }
        else
        {
          long l = System.currentTimeMillis();
          if (l - jdField_b_of_type_Long <= 1000L)
          {
            finish();
            return null;
          }
          jdField_b_of_type_Long = l;
          localObject1 = UpgradeController.a().a();
          if ((localObject1 != null) && (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
          {
            this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
            this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
            try
            {
              this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
            }
            catch (Exception localException2)
            {
              QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
              localException2.printStackTrace();
            }
            l = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Long;
            SPSettings.b(true);
            paramInt = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
            SPSettings.b(paramInt);
            MyAppApi.a();
            if (MyAppApi.b())
            {
              localObject1 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new UpgradeActivity.14(this), new UpgradeActivity.15(this));
              ((QQCustomDialog)localObject1).setOnDismissListener(new UpgradeActivity.16(this));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 1, 100));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 2, 100));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 1, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 2, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 3, 100));
              return localObject1;
            }
            this.jdField_b_of_type_Boolean = true;
            MyAppApi.a().a(false);
            localObject1 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
            ((NewUpgradeDialog)localObject1).a(new UpgradeActivity.17(this, (NewUpgradeDialog)localObject1, paramInt), true);
            return localObject1;
          }
          ToastUtil.a().a(HardCodeUtil.a(2131715688));
          finish();
          return null;
        }
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject1).setPositiveButton(2131720140, new UpgradeActivity.3(this)).setNegativeButton(2131716746, new UpgradeActivity.2(this)).setOnKeyListener(new UpgradeActivity.1(this));
        break label1287;
      }
    }
    else
    {
      paramInt = this.jdField_d_of_type_Int;
      if (paramInt == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        paramInt = i;
        if (UpgradeController.a().a() == 4) {
          paramInt = 2131693397;
        }
        ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new UpgradeActivity.6(this)).setNegativeButton(2131720139, new UpgradeActivity.5(this)).setOnKeyListener(new UpgradeActivity.4(this));
        break label1287;
      }
      if (paramInt == 2)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "");
        ReportController.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
        }
        catch (Exception localException1)
        {
          QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
          localException1.printStackTrace();
        }
        UpgradeActivity.7 local7 = new UpgradeActivity.7(this);
        UpgradeActivity.8 local8 = new UpgradeActivity.8(this);
        String str;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = this.g;
          if ((localObject2 != null) && (!"".equals(localObject2))) {
            localObject2 = this.g;
          } else {
            localObject2 = HardCodeUtil.a(2131715687);
          }
          str = this.h;
          if ((str != null) && (!"".equals(str))) {
            str = this.h;
          } else {
            str = HardCodeUtil.a(2131715680);
          }
          paramInt = SharedPreUtils.aI(this, this.app.getCurrentUin());
          SharedPreUtils.W(this, this.app.getCurrentUin(), paramInt + 1);
          SharedPreUtils.h(this, this.app.getCurrentUin(), System.currentTimeMillis());
        }
        else
        {
          localObject2 = this.jdField_e_of_type_JavaLangString;
          if ((localObject2 != null) && (!"".equals(localObject2))) {
            localObject2 = this.jdField_e_of_type_JavaLangString;
          } else {
            localObject2 = HardCodeUtil.a(2131715678);
          }
          str = this.jdField_d_of_type_JavaLangString;
          if ((str != null) && (!"".equals(str))) {
            str = this.jdField_d_of_type_JavaLangString;
          } else {
            str = HardCodeUtil.a(2131715685);
          }
          paramInt = SharedPreUtils.aH(this, this.app.getCurrentUin());
          SharedPreUtils.V(this, this.app.getCurrentUin(), paramInt + 1);
          SharedPreUtils.g(this, this.app.getCurrentUin(), System.currentTimeMillis());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UpgradeActivity:strTitle: ");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("UpgradeActivity:strUpgradeDesc: ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
        localObject2 = DialogUtils.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject2, str, this.f, local8, local7);
        b();
        ((Dialog)localObject2).setCanceledOnTouchOutside(false);
        ((Dialog)localObject2).setOnDismissListener(new UpgradeActivity.9(this));
        return localObject2;
      }
    }
    Object localObject2 = null;
    label1287:
    if (localObject2 != null)
    {
      ((QQCustomDialog)localObject2).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject2).setOnDismissListener(new UpgradeActivity.18(this));
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */