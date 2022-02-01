package com.tencent.mobileqq.upgrade.activity;

import Override;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import anvx;
import bdla;
import bgvp;
import bgvw;
import bgvx;
import bgwc;
import bgwh;
import bgwi;
import bgwj;
import bgwk;
import bgwl;
import bgwm;
import bgwn;
import bgwo;
import bgwp;
import bgwq;
import bgwr;
import bgws;
import bgwt;
import bgwu;
import bgwv;
import bgww;
import bgwx;
import bgwy;
import bhdj;
import bhhj;
import bhhr;
import bjhn;
import bjhp;
import bjko;
import bjkv;
import bjnn;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
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
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  
  private void a(boolean paramBoolean)
  {
    if (bgvx.a().a() == 4)
    {
      Object localObject = this.app.getHandler(Conversation.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1134018);
        ((Message)localObject).obj = this;
        ((Message)localObject).sendToTarget();
      }
      return;
    }
    UpgradeDetailActivity.a(this, bgvx.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = anvx.a(2131715277);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = anvx.a(2131715280);
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
    if (bgvx.a().a() == 4) {}
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
  
  public void a()
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
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bgvx.a().a();
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
    getWindow().setBackgroundDrawableResource(2131167296);
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
    if ((this.jdField_b_of_type_Boolean) && (bjnn.a().b()))
    {
      if (!bjnn.a().f()) {
        bgvp.a(this);
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
      ((QQCustomDialog)localObject1).setOnDismissListener(new bgwq(this));
      return localObject1;
      bdla.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bgvw.b(), String.valueOf(0), bgvx.a(), "");
      localObject1 = bhdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((QQCustomDialog)localObject1).setPositiveButton(2131719831, new bgws(this)).setNegativeButton(2131716592, new bgwr(this)).setOnKeyListener(new bgwh(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        bdla.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bgvw.b(), String.valueOf(0), bgvx.a(), "");
        localObject1 = bhdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (bgvx.a().a() == 4) {}
        for (paramInt = 2131693291;; paramInt = 2131719831)
        {
          ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new bgwv(this)).setNegativeButton(2131719830, new bgwu(this)).setOnKeyListener(new bgwt(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        bdla.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bgvw.b(), String.valueOf(2), bgvx.a(), "");
        bdla.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          bgww localbgww = new bgww(this);
          bgwx localbgwx = new bgwx(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = anvx.a(2131715281);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label678;
              }
              str = anvx.a(2131715274);
              paramInt = bhhr.aP(this, this.app.getCurrentUin());
              bhhr.af(this, this.app.getCurrentUin(), paramInt + 1);
              bhhr.j(this, this.app.getCurrentUin(), System.currentTimeMillis());
              QLog.d("qqBaseActivity", 4, "UpgradeActivity:strTitle: " + this.jdField_b_of_type_JavaLangString);
              QLog.d("qqBaseActivity", 4, "UpgradeActivity:strUpgradeDesc: " + this.jdField_c_of_type_JavaLangString);
              localObject1 = bhdj.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localbgwx, localbgww);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new bgwy(this));
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
            localObject2 = anvx.a(2131715272);
            label715:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label795;
            }
          }
          label795:
          for (String str = anvx.a(2131715279);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = bhhr.aO(this, this.app.getCurrentUin());
            bhhr.ae(this, this.app.getCurrentUin(), paramInt + 1);
            bhhr.i(this, this.app.getCurrentUin(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label715;
          }
        }
        Object localObject2 = bhdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(anvx.a(2131715278), new bgwj(this)).setNegativeButton(anvx.a(2131715283), new bgwi(this));
        continue;
        localObject2 = bhdj.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(anvx.a(2131715275), new bgwl(this)).setNegativeButton(anvx.a(2131715276), new bgwk(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_b_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_b_of_type_Long = l;
        localObject2 = bgvx.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bgwc == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bjkv.a().a(anvx.a(2131715282));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bgwc.jdField_a_of_type_Long;
          bhhj.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bgwc.jdField_a_of_type_Int;
          bhhj.b(paramInt);
          if (bjnn.a().b())
          {
            localObject2 = bhdj.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new bgwm(this), new bgwn(this));
            ((QQCustomDialog)localObject2).setOnDismissListener(new bgwo(this));
            bjko.b("qqBaseActivity", bjhp.a(10010, 1, 1, 100));
            bjko.b("qqBaseActivity", bjhp.a(10010, 1, 2, 100));
            bjko.b("qqBaseActivity", bjhp.a(10010, 1, 3, 100));
            bjhn.a().a(16, bjhp.a(10010, 1, 1, 100));
            bjhn.a().a(16, bjhp.a(10010, 1, 2, 100));
            bjhn.a().a(16, bjhp.a(10010, 1, 3, 100));
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
          bjnn.a().a(false);
          localObject2 = bhdj.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((bgvp)localObject2).a(new bgwp(this, (bgvp)localObject2, paramInt), true);
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