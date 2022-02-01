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
import anzj;
import bdll;
import bhdm;
import bhdt;
import bhdu;
import bhdz;
import bhee;
import bhef;
import bheg;
import bheh;
import bhei;
import bhej;
import bhek;
import bhel;
import bhem;
import bhen;
import bheo;
import bhep;
import bheq;
import bher;
import bhes;
import bhet;
import bheu;
import bhev;
import bhlq;
import bhpc;
import bhrv;
import bhsi;
import bjqw;
import bjqy;
import bjtx;
import bjuh;
import bjxd;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
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
    if (bhdu.a().a() == 4)
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
    UpgradeDetailActivity.a(this, bhdu.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = anzj.a(2131714695);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = anzj.a(2131714698);
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
    if (bhdu.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = getIntent().getLongExtra("showTime", 0L);
      this.jdField_b_of_type_Int = getIntent().getIntExtra("iUpgradeSdkId", 0);
      this.jdField_e_of_type_Int = getIntent().getIntExtra("rate", 1);
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
    this.app.b(false);
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = bhdu.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return true;
    }
    getWindow().setBackgroundDrawableResource(2131167247);
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
    if ((this.jdField_b_of_type_Boolean) && (bjxd.a().b()))
    {
      if (!bjxd.a().f()) {
        bhdm.a(this);
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
      ((bhpc)localObject1).setCanceledOnTouchOutside(false);
      ((bhpc)localObject1).setOnDismissListener(new bhen(this));
      return localObject1;
      bdll.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bhdt.b(), String.valueOf(0), bhdu.a(), "");
      localObject1 = bhlq.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((bhpc)localObject1).setPositiveButton(2131719118, new bhep(this)).setNegativeButton(2131715997, new bheo(this)).setOnKeyListener(new bhee(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        bdll.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bhdt.b(), String.valueOf(0), bhdu.a(), "");
        localObject1 = bhlq.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (bhdu.a().a() == 4) {}
        for (paramInt = 2131693065;; paramInt = 2131719118)
        {
          ((bhpc)localObject1).setPositiveButton(paramInt, new bhes(this)).setNegativeButton(2131719117, new bher(this)).setOnKeyListener(new bheq(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        bdll.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bhdt.b(), String.valueOf(2), bhdu.a(), "");
        bdll.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          bhet localbhet = new bhet(this);
          bheu localbheu = new bheu(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = anzj.a(2131714699);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label620;
              }
              str = anzj.a(2131714692);
              paramInt = bhsi.aP(this, this.app.c());
              bhsi.af(this, this.app.c(), paramInt + 1);
              bhsi.j(this, this.app.c(), System.currentTimeMillis());
              localObject1 = bhlq.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localbheu, localbhet);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new bhev(this));
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
            label620:
            str = this.h;
          }
          if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString)))
          {
            localObject2 = anzj.a(2131714690);
            label657:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label737;
            }
          }
          label737:
          for (String str = anzj.a(2131714697);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = bhsi.aO(this, this.app.c());
            bhsi.ae(this, this.app.c(), paramInt + 1);
            bhsi.i(this, this.app.c(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label657;
          }
        }
        Object localObject2 = bhlq.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bhpc)localObject2).setPositiveButton(anzj.a(2131714696), new bheg(this)).setNegativeButton(anzj.a(2131714701), new bhef(this));
        continue;
        localObject2 = bhlq.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((bhpc)localObject2).setPositiveButton(anzj.a(2131714693), new bhei(this)).setNegativeButton(anzj.a(2131714694), new bheh(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_b_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_b_of_type_Long = l;
        localObject2 = bhdu.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bhdz == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bjuh.a().a(anzj.a(2131714700));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bhdz.jdField_a_of_type_Long;
          bhrv.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bhdz.jdField_a_of_type_Int;
          bhrv.b(paramInt);
          if (bjxd.a().b())
          {
            localObject2 = bhlq.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new bhej(this), new bhek(this));
            ((bhpc)localObject2).setOnDismissListener(new bhel(this));
            bjtx.b("qqBaseActivity", bjqy.a(10010, 1, 1, 100));
            bjtx.b("qqBaseActivity", bjqy.a(10010, 1, 2, 100));
            bjtx.b("qqBaseActivity", bjqy.a(10010, 1, 3, 100));
            bjqw.a().a(16, bjqy.a(10010, 1, 1, 100));
            bjqw.a().a(16, bjqy.a(10010, 1, 2, 100));
            bjqw.a().a(16, bjqy.a(10010, 1, 3, 100));
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
          bjxd.a().a(false);
          localObject2 = bhlq.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((bhdm)localObject2).a(new bhem(this, (bhdm)localObject2, paramInt), true);
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