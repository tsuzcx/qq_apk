package com.tencent.mobileqq.upgrade.activity;

import Override;
import amtj;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import bcef;
import bfmy;
import bfnf;
import bfng;
import bfnl;
import bfnq;
import bfnr;
import bfns;
import bfnt;
import bfnu;
import bfnv;
import bfnw;
import bfnx;
import bfny;
import bfnz;
import bfoa;
import bfob;
import bfoc;
import bfod;
import bfoe;
import bfof;
import bfog;
import bfoh;
import bfur;
import bfyr;
import bfyz;
import bhwl;
import bhwn;
import bhzm;
import bhzt;
import bicl;
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
    if (bfng.a().a() == 4)
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
    UpgradeDetailActivity.a(this, bfng.a().a(), false, true, true);
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaLangString = amtj.a(2131714929);
    this.jdField_c_of_type_JavaLangString = "检测到你的网络环境处于2G/3G下，继续下载QQ将会产生流量。";
    showDialog(8192);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = "下载QQ失败";
    this.jdField_c_of_type_JavaLangString = amtj.a(2131714932);
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
    if (bfng.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = getIntent().getLongExtra("showTime", 0L);
      this.jdField_b_of_type_Int = getIntent().getIntExtra("iUpgradeSdkId", 0);
      this.jdField_e_of_type_Int = getIntent().getIntExtra("rate", 1);
      if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
      {
        if (this.jdField_b_of_type_JavaLangString == null) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        }
        if (this.jdField_c_of_type_JavaLangString == null) {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
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
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bfng.a().a();
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
    getWindow().setBackgroundDrawableResource(2131167276);
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
    if ((this.jdField_b_of_type_Boolean) && (bicl.a().b()))
    {
      if (!bicl.a().f()) {
        bfmy.a(this);
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
      ((QQCustomDialog)localObject1).setOnDismissListener(new bfnz(this));
      return localObject1;
      bcef.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bfnf.b(), String.valueOf(0), bfng.a(), "");
      localObject1 = bfur.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
      ((QQCustomDialog)localObject1).setPositiveButton(2131719403, new bfob(this)).setNegativeButton(2131716231, new bfoa(this)).setOnKeyListener(new bfnq(this));
      continue;
      if (this.jdField_d_of_type_Int == 0)
      {
        bcef.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bfnf.b(), String.valueOf(0), bfng.a(), "");
        localObject1 = bfur.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        b();
        if (bfng.a().a() == 4) {}
        for (paramInt = 2131693123;; paramInt = 2131719403)
        {
          ((QQCustomDialog)localObject1).setPositiveButton(paramInt, new bfoe(this)).setNegativeButton(2131719402, new bfod(this)).setOnKeyListener(new bfoc(this));
          break;
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        bcef.b(this.app, "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bfnf.b(), String.valueOf(2), bfng.a(), "");
        bcef.b(this.app, "CliOper", "", "", "0X800417D", "0X800417D", 0, 0, "", "", "", "");
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          bfof localbfof = new bfof(this);
          bfog localbfog = new bfog(this);
          if (this.jdField_a_of_type_Boolean) {
            if ((this.g == null) || ("".equals(this.g)))
            {
              localObject1 = amtj.a(2131714933);
              if ((this.h != null) && (!"".equals(this.h))) {
                break label620;
              }
              str = amtj.a(2131714926);
              paramInt = bfyz.aP(this, this.app.getCurrentUin());
              bfyz.af(this, this.app.getCurrentUin(), paramInt + 1);
              bfyz.j(this, this.app.getCurrentUin(), System.currentTimeMillis());
              localObject1 = bfur.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, (String)localObject1, str, this.f, localbfog, localbfof);
              b();
              ((Dialog)localObject1).setCanceledOnTouchOutside(false);
              ((Dialog)localObject1).setOnDismissListener(new bfoh(this));
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
            localObject2 = amtj.a(2131714924);
            label657:
            if ((this.jdField_d_of_type_JavaLangString != null) && (!"".equals(this.jdField_d_of_type_JavaLangString))) {
              break label737;
            }
          }
          label737:
          for (String str = amtj.a(2131714931);; str = this.jdField_d_of_type_JavaLangString)
          {
            paramInt = bfyz.aO(this, this.app.getCurrentUin());
            bfyz.ae(this, this.app.getCurrentUin(), paramInt + 1);
            bfyz.i(this, this.app.getCurrentUin(), System.currentTimeMillis());
            break;
            localObject2 = this.jdField_e_of_type_JavaLangString;
            break label657;
          }
        }
        Object localObject2 = bfur.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(amtj.a(2131714930), new bfns(this)).setNegativeButton(amtj.a(2131714935), new bfnr(this));
        continue;
        localObject2 = bfur.a(this, 230).setTitle(this.jdField_b_of_type_JavaLangString).setMessage(this.jdField_c_of_type_JavaLangString);
        ((QQCustomDialog)localObject2).setPositiveButton(amtj.a(2131714927), new bfnu(this)).setNegativeButton(amtj.a(2131714928), new bfnt(this));
        continue;
        long l = System.currentTimeMillis();
        if (l - jdField_b_of_type_Long <= 1000L)
        {
          finish();
          return null;
        }
        jdField_b_of_type_Long = l;
        localObject2 = bfng.a().a();
        if ((localObject2 == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bfnl == null) || (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null))
        {
          bhzt.a().a(amtj.a(2131714934));
          finish();
          return null;
        }
        this.jdField_b_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle;
        this.jdField_c_of_type_JavaLangString = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc;
        try
        {
          this.jdField_c_of_type_JavaLangString = String.format(this.jdField_c_of_type_JavaLangString, new Object[0]);
          l = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bfnl.jdField_a_of_type_Long;
          bfyr.b(true);
          paramInt = ((UpgradeDetailWrapper)localObject2).jdField_a_of_type_Bfnl.jdField_a_of_type_Int;
          bfyr.b(paramInt);
          if (bicl.a().b())
          {
            localObject2 = bfur.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, new bfnv(this), new bfnw(this));
            ((QQCustomDialog)localObject2).setOnDismissListener(new bfnx(this));
            bhzm.b("qqBaseActivity", bhwn.a(10010, 1, 1, 100));
            bhzm.b("qqBaseActivity", bhwn.a(10010, 1, 2, 100));
            bhzm.b("qqBaseActivity", bhwn.a(10010, 1, 3, 100));
            bhwl.a().a(16, bhwn.a(10010, 1, 1, 100));
            bhwl.a().a(16, bhwn.a(10010, 1, 2, 100));
            bhwl.a().a(16, bhwn.a(10010, 1, 3, 100));
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
          bicl.a().a(false);
          localObject2 = bfur.a(this, this.jdField_b_of_type_JavaLangString, l, this.jdField_c_of_type_JavaLangString, "");
          ((bfmy)localObject2).a(new bfny(this, (bfmy)localObject2, paramInt), true);
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