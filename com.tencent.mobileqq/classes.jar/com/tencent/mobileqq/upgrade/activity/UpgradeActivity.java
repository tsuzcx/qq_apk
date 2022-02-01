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
  private static long q;
  String a = null;
  private int b;
  private String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private int j;
  private int k = 0;
  private int l = 0;
  private boolean m;
  private long n;
  private int o;
  private UpgradeDetailWrapper p;
  private boolean r = false;
  
  private void a(boolean paramBoolean)
  {
    if (UpgradeController.a().b() == 4)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = this;
      BannerManager.a().b(InstallUpgradeBannerProcessor.a, localMessage);
      return;
    }
    UpgradeDetailActivity.a(this, UpgradeController.a().d(), false, true, true);
  }
  
  private void c()
  {
    this.c = HardCodeUtil.a(2131913150);
    this.d = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.c = "下载QQ失败";
    this.d = HardCodeUtil.a(2131913153);
    showDialog(16384);
  }
  
  private void e()
  {
    this.c = getIntent().getStringExtra("StrTitle");
    this.d = getIntent().getStringExtra("StrUpgradeDesc");
    this.a = getIntent().getStringExtra("StrUrl");
    this.g = getIntent().getStringExtra("strDesc");
    this.h = getIntent().getStringExtra("lBtnText");
    this.i = getIntent().getStringExtra("rBtnText");
    this.k = getIntent().getIntExtra("iUpgradeType", 0);
    this.l = getIntent().getIntExtra("iTipsType", 0);
    if (getIntent().hasExtra("strConfirmBtnText")) {
      this.e = getIntent().getStringExtra("strConfirmBtnText");
    }
    if (getIntent().hasExtra("strCancelButtonDesc")) {
      this.f = getIntent().getStringExtra("strCancelButtonDesc");
    }
    boolean bool;
    if (UpgradeController.a().b() == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    this.n = getIntent().getLongExtra("showTime", 0L);
    this.j = getIntent().getIntExtra("iUpgradeSdkId", 0);
    this.o = getIntent().getIntExtra("rate", 1);
    Object localObject = this.p;
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).b != null))
    {
      if (this.c == null)
      {
        this.c = this.p.b.strTitle;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=wrapper手动赋值:strTitle: ");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
      }
      if (this.d == null)
      {
        this.d = this.p.b.strUpgradeDesc;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wrapper手动赋值:strUpgradeDesc: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
      }
      this.k = this.p.b.iUpgradeType;
      this.l = this.p.b.iTipsType;
      this.j = this.p.b.iUpgradeSdkId;
    }
    getIntent().getIntExtra("mode", 0);
    int i1 = this.k;
    if (i1 == 2)
    {
      showDialog(2);
      return;
    }
    if (i1 == 1)
    {
      showDialog(1);
      return;
    }
    if (i1 == 3)
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
      int i1 = localSharedPreferences.getInt("upgrade_tip_count", 0);
      if (i1 < 1)
      {
        localSharedPreferences.edit().putInt("upgrade_tip_count", i1 + 1).commit();
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
    this.p = UpgradeController.a().d();
    paramBundle = this.p;
    if ((paramBundle != null) && (paramBundle.b != null) && (this.p.b.iUpgradeType > 0))
    {
      getWindow().setBackgroundDrawableResource(2131168376);
      this.b = getIntent().getIntExtra("activity_type", 4096);
      int i1 = this.b;
      if (i1 != 4096)
      {
        if (i1 != 8192)
        {
          if (i1 != 16384)
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
    UpgradeDetailWrapper localUpgradeDetailWrapper = this.p;
    boolean bool = false;
    if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.b != null)) {
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
    if (this.r)
    {
      MyAppApi.l();
      if (MyAppApi.m())
      {
        if (!MyAppApi.l().v()) {
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
    int i1 = 2131917770;
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
              localObject1 = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.d);
              ((QQCustomDialog)localObject1).setPositiveButton(HardCodeUtil.a(2131913149), new UpgradeActivity.13(this)).setNegativeButton(HardCodeUtil.a(2131898212), new UpgradeActivity.12(this));
              break label1289;
            }
          }
          else
          {
            localObject1 = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.d);
            ((QQCustomDialog)localObject1).setPositiveButton(HardCodeUtil.a(2131913151), new UpgradeActivity.11(this)).setNegativeButton(HardCodeUtil.a(2131898212), new UpgradeActivity.10(this));
            break label1289;
          }
        }
        else
        {
          long l1 = System.currentTimeMillis();
          if (l1 - q <= 1000L)
          {
            finish();
            return null;
          }
          q = l1;
          localObject1 = UpgradeController.a().d();
          if ((localObject1 != null) && (((UpgradeDetailWrapper)localObject1).e != null) && (((UpgradeDetailWrapper)localObject1).b != null))
          {
            this.c = ((UpgradeDetailWrapper)localObject1).b.strTitle;
            this.d = ((UpgradeDetailWrapper)localObject1).b.strUpgradeDesc;
            try
            {
              this.d = String.format(this.d, new Object[0]);
            }
            catch (Exception localException2)
            {
              QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
              localException2.printStackTrace();
            }
            l1 = ((UpgradeDetailWrapper)localObject1).e.b;
            SPSettings.b(true);
            paramInt = ((UpgradeDetailWrapper)localObject1).e.d;
            SPSettings.b(paramInt);
            MyAppApi.l();
            if (MyAppApi.m())
            {
              localObject1 = DialogUtils.a(this, this.c, l1, this.d, new UpgradeActivity.14(this), new UpgradeActivity.15(this));
              ((QQCustomDialog)localObject1).setOnDismissListener(new UpgradeActivity.16(this));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 1, 100));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 2, 100));
              LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 1, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 2, 100));
              AppCircleReportManager.a().a(16, STUtils.a(10010, 1, 3, 100));
              return localObject1;
            }
            this.r = true;
            MyAppApi.l().a(false);
            localObject1 = DialogUtils.a(this, this.c, l1, this.d, "");
            ((NewUpgradeDialog)localObject1).a(new UpgradeActivity.17(this, (NewUpgradeDialog)localObject1, paramInt), true);
            return localObject1;
          }
          ToastUtil.a().a(HardCodeUtil.a(2131913155));
          finish();
          return null;
        }
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.k(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.d);
        ((QQCustomDialog)localObject1).setPositiveButton(2131917770, new UpgradeActivity.3(this)).setNegativeButton(2131914218, new UpgradeActivity.2(this)).setOnKeyListener(new UpgradeActivity.1(this));
        break label1289;
      }
    }
    else
    {
      paramInt = this.l;
      if (paramInt == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.k(), "");
        localObject1 = DialogUtil.a(this, 230).setTitle(this.c).setMessage(this.d);
        b();
        paramInt = i1;
        if (UpgradeController.a().b() == 4) {
          paramInt = 2131890946;
        }
        ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new UpgradeActivity.6(this)).setNegativeButton(2131917769, new UpgradeActivity.5(this)).setOnKeyListener(new UpgradeActivity.4(this));
        break label1289;
      }
      if (paramInt == 2)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.k(), "");
        ReportController.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.d = String.format(this.d, new Object[0]);
        }
        catch (Exception localException1)
        {
          QLog.d("UpgradeActivty", 2, "parse dialog wording error!");
          localException1.printStackTrace();
        }
        UpgradeActivity.7 local7 = new UpgradeActivity.7(this);
        UpgradeActivity.8 local8 = new UpgradeActivity.8(this);
        String str;
        if (this.m)
        {
          localObject2 = this.h;
          if ((localObject2 != null) && (!"".equals(localObject2))) {
            localObject2 = this.h;
          } else {
            localObject2 = HardCodeUtil.a(2131913154);
          }
          str = this.i;
          if ((str != null) && (!"".equals(str))) {
            str = this.i;
          } else {
            str = HardCodeUtil.a(2131913148);
          }
          paramInt = SharedPreUtils.bV(this, this.app.getCurrentUin());
          SharedPreUtils.aa(this, this.app.getCurrentUin(), paramInt + 1);
          SharedPreUtils.h(this, this.app.getCurrentUin(), System.currentTimeMillis());
        }
        else
        {
          localObject2 = this.f;
          if ((localObject2 != null) && (!"".equals(localObject2))) {
            localObject2 = this.f;
          } else {
            localObject2 = HardCodeUtil.a(2131913146);
          }
          str = this.e;
          if ((str != null) && (!"".equals(str))) {
            str = this.e;
          } else {
            str = HardCodeUtil.a(2131913152);
          }
          paramInt = SharedPreUtils.bT(this, this.app.getCurrentUin());
          SharedPreUtils.Z(this, this.app.getCurrentUin(), paramInt + 1);
          SharedPreUtils.g(this, this.app.getCurrentUin(), System.currentTimeMillis());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UpgradeActivity:strTitle: ");
        localStringBuilder.append(this.c);
        QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("UpgradeActivity:strUpgradeDesc: ");
        localStringBuilder.append(this.d);
        QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
        localObject2 = DialogUtils.a(this, this.c, this.d, (String)localObject2, str, this.g, local8, local7);
        b();
        ((Dialog)localObject2).setCanceledOnTouchOutside(false);
        ((Dialog)localObject2).setOnDismissListener(new UpgradeActivity.9(this));
        return localObject2;
      }
    }
    Object localObject2 = null;
    label1289:
    if (localObject2 != null)
    {
      ((QQCustomDialog)localObject2).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject2).setOnDismissListener(new UpgradeActivity.18(this));
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity
 * JD-Core Version:    0.7.0.1
 */