package com.tencent.mobileqq.filemanager.activity;

import aciy;
import ajed;
import ajia;
import ajjy;
import ajtg;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anww;
import anwx;
import anwy;
import anxa;
import anxb;
import anxc;
import aobe;
import aodw;
import aonm;
import apdn;
import awqx;
import axdz;
import babr;
import bafb;
import bffc;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long jdField_c_of_type_Long;
  private float jdField_a_of_type_Float;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  public LinearLayout a;
  public RadioButton a;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  anxc jdField_a_of_type_Anxc = null;
  aobe jdField_a_of_type_Aobe = null;
  public VerifyPwdView a;
  public QfileTabBarView a;
  private float b;
  public RadioButton b;
  public RelativeLayout b;
  public TextView b;
  public RadioButton c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  long d;
  public RadioButton d;
  public int e;
  int f;
  int g;
  public final String g;
  public int h;
  String h;
  int i;
  public String i;
  int j;
  public boolean j;
  boolean k = false;
  boolean l;
  
  public FMActivity()
  {
    this.jdField_g_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetRadioButton = null;
    this.jdField_c_of_type_AndroidWidgetRadioButton = null;
    this.jdField_d_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 1) && (paramInt != 2) && (paramInt != 4))
    {
      this.jdField_j_of_type_Int = 10;
      return;
    }
    if ((paramInt == 8) && (a(8)))
    {
      this.jdField_j_of_type_Int = 10;
      return;
    }
    if ((paramInt == 1) && (a(1)))
    {
      this.jdField_j_of_type_Int = 12;
      return;
    }
    if ((paramInt == 2) && (a(2)))
    {
      this.jdField_j_of_type_Int = 13;
      return;
    }
    if ((paramInt == 4) && (a(4)))
    {
      this.jdField_j_of_type_Int = 9;
      return;
    }
    this.jdField_j_of_type_Int = 10;
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131300626));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    int m;
    if (this.jdField_d_of_type_Boolean)
    {
      m = 1;
      ((QfileTabBarView)localObject).setWYSubAppId(m);
      if (c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setMemory(true);
      }
      if (!"FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
        break label390;
      }
      setLeftViewName(2131626826);
      label80:
      if ((!c()) || (paramInt == 5) || (paramInt == 8) || (this.jdField_e_of_type_Boolean)) {
        break label544;
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131309130));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.jdField_d_of_type_AndroidWidgetRadioButton.getVisibility() == 0) {
        awqx.b(this.app, "dc00898", "", "", "0x8009DAD", "0x8009DAD", 0, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        p();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      if (ajia.a() > 17.0F)
      {
        float f1 = getResources().getDisplayMetrics().density;
        localObject = new LinearLayout.LayoutParams((int)(55.0F * f1), (int)(f1 * 30.0F));
        this.jdField_c_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_c_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
        this.jdField_a_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
        this.jdField_b_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
        this.jdField_d_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_d_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      }
      if (!this.k) {
        break label438;
      }
      q();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 0);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    label390:
    label438:
    do
    {
      return;
      m = 2;
      break;
      if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0) && (this.f != -1))
      {
        setLeftViewName(2131625179);
        break label80;
      }
      setLeftViewName(2131624770);
      break label80;
      if ((this.jdField_j_of_type_Boolean) || (this.k)) {
        break label544;
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      s();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (!this.jdField_h_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_c_of_type_AndroidWidgetRadioButton);
    return;
    label544:
    if (this.l)
    {
      findViewById(2131309130).setVisibility(8);
      findViewById(2131303842).setVisibility(0);
    }
    g();
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 6: 
    case 7: 
      if (paramInt == 0) {}
      for (this.jdField_b_of_type_JavaLangString = getString(2131625150);; this.jdField_b_of_type_JavaLangString = getString(2131626839))
      {
        setTitle(this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
          this.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(true);
        }
        q();
        return;
      }
    case 2: 
    case 3: 
      this.jdField_b_of_type_JavaLangString = getString(2131626798);
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      e(paramInt);
      return;
    case 1: 
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    case 5: 
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_b_of_type_JavaLangString = getString(2131626823);
        setTitle(this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
        }
        s();
        if ((c()) && ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
        {
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
          setLeftViewName(2131626879);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
          if (this.jdField_i_of_type_Int <= 0) {
            break label969;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
        }
      }
      for (;;)
      {
        localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
        ((SharedPreferences.Editor)localObject).commit();
        if (b() != 8) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
        this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        break label790;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    case 8: 
      label790:
      label969:
      this.jdField_b_of_type_JavaLangString = ajjy.a(2131638867);
      setTitle(this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
      setLeftViewName(2131624770);
      getRightTextView().setVisibility(8);
      w();
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    if (this.jdField_c_of_type_JavaLangString == null) {}
    for (this.jdField_b_of_type_JavaLangString = ajjy.a(2131638870);; this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString)
    {
      setTitle(this.jdField_b_of_type_JavaLangString);
      r();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 9);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    awqx.b(this.app, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new anxa(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void m()
  {
    ajtg localajtg = (ajtg)this.app.a(20);
    if (localajtg != null) {}
    try
    {
      localajtg.a(Long.parseLong(this.jdField_i_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private void n()
  {
    bafb localbafb = babr.a(this, 230);
    localbafb.setMessage(2131632182);
    localbafb.setTitle(2131632185);
    localbafb.setNegativeButton(getString(2131632184), new anww(this));
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.setCancelable(false);
    if (!isFinishing()) {
      localbafb.show();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131303846));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131309128));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131298748));
    this.jdField_d_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131313587));
    Object localObject2 = ajed.aT + "/Tencent/MicroMsg/Download/";
    Object localObject1 = ajed.aT + "/Tencent/MicroMsg/WeiXin/";
    localObject2 = new File((String)localObject2);
    localObject1 = new File((String)localObject1);
    if (((((File)localObject2).exists()) && (((File)localObject2).isDirectory())) || ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())))
    {
      localObject1 = this.jdField_d_of_type_AndroidWidgetRadioButton.getBackground();
      this.jdField_c_of_type_AndroidWidgetRadioButton.setBackgroundDrawable((Drawable)localObject1);
      this.jdField_d_of_type_AndroidWidgetRadioButton.setVisibility(8);
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new anwy(this);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_h_of_type_JavaLangString);
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131627052));
      if (!this.jdField_h_of_type_Boolean) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131627050));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131627052));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(21, getString(2131627057));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131627056));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131627053));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131627051));
      break;
      label223:
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_e_of_type_Int >= 3) && (this.jdField_e_of_type_Int <= 7)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
      }
    }
  }
  
  private void r()
  {
    ThreadManager.getFileThreadHandler().post(new FMActivity.4(this));
    awqx.b(this.app, "dc00898", "", "", "0x8009D9B", "0x8009D9B", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1111, getString(2131627053));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1119, getString(2131627056));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1110, getString(2131627052));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1118, getString(2131627051));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1114, getString(2131627055));
    if ((this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_Int == 9) && (this.jdField_e_of_type_Int >= 1110) && (this.jdField_e_of_type_Int <= 1118))
    {
      if (this.jdField_i_of_type_Int <= 0)
      {
        if ((this.jdField_e_of_type_Int == 1111) || (this.jdField_e_of_type_Int == 1119) || (this.jdField_e_of_type_Int == 1110) || (this.jdField_e_of_type_Int == 1118) || (this.jdField_e_of_type_Int == 1114))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1111);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      return;
    }
    if (7 != this.jdField_g_of_type_Int)
    {
      if (this.jdField_i_of_type_Int <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1111);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      return;
    }
    if (this.jdField_j_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1111);
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303844));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_i_of_type_Int <= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        g();
        label86:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
        if (this.jdField_i_of_type_Int > 0) {
          break label353;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131627053));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131627056));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131627052));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131627051));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131627055));
        label180:
        if ((!this.jdField_j_of_type_Boolean) || ((this.jdField_a_of_type_Int != 1) && (this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1) != 1)) || (this.jdField_e_of_type_Int < 8) || (this.jdField_e_of_type_Int > 14)) {
          break label544;
        }
        if (this.jdField_i_of_type_Int > 0) {
          break label530;
        }
        if ((this.jdField_e_of_type_Int != 11) && (this.jdField_e_of_type_Int != 9) && (this.jdField_e_of_type_Int != 10) && (this.jdField_e_of_type_Int != 8) && (this.jdField_e_of_type_Int != 14)) {
          break label518;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      break;
      a(this);
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label86;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label86;
      label353:
      ArrayList localArrayList = new ArrayList();
      if (a(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131627052));
        localArrayList.add(Integer.valueOf(10));
      }
      if (a(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131627056));
        localArrayList.add(Integer.valueOf(9));
      }
      if (a(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131627058));
        localArrayList.add(Integer.valueOf(13));
      }
      if (a(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131627054));
        localArrayList.add(Integer.valueOf(12));
      }
      if (localArrayList.size() != 1) {
        break label180;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      break label180;
      label518:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      label530:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      continue;
      label544:
      if (7 != this.jdField_g_of_type_Int)
      {
        if (this.jdField_i_of_type_Int <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
        }
      }
      else if (this.jdField_j_of_type_Int != -1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new anxb(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void v()
  {
    ArrayList localArrayList2 = null;
    Object localObject = aonm.a();
    ArrayList localArrayList1 = localArrayList2;
    if (localObject != null)
    {
      localArrayList1 = localArrayList2;
      if (((Set)localObject).size() > 0)
      {
        localArrayList2 = new ArrayList();
        localObject = ((Set)localObject).iterator();
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArrayList2.add(((FileInfo)((Iterator)localObject).next()).c());
        }
      }
    }
    this.app.a().a(this, localArrayList1, 15, 0, true, this.jdField_i_of_type_JavaLangString);
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(111, getString(2131627058));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(119, getString(2131627056));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(110, getString(2131627052));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(118, getString(2131627051));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(114, getString(2131627055));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    }
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void a(aobe paramaobe)
  {
    this.jdField_a_of_type_Aobe = paramaobe;
    if (this.jdField_a_of_type_Int == 8) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_Aobe);
    }
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramArrayList);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramSet);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_i_of_type_Int & paramInt) > 0;
  }
  
  public int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null)
    {
      super.b(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSortType(paramInt);
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int m = 0;
    if (paramBoolean) {
      m = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int n = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(n - m);
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.e();
      if (paramMotionEvent.getAction() != 0) {
        break label43;
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label43:
      if (paramMotionEvent.getAction() == 2)
      {
        QLog.e("@@@@@", 1, new Object[] { "ev.getY(" + paramMotionEvent.getY() + "),", "y: " + this.jdField_b_of_type_Float + " ,ev.getX(" + paramMotionEvent.getX() + "),x: " + this.jdField_a_of_type_Float + "  " + (paramMotionEvent.getY() - this.jdField_b_of_type_Float) + "," + Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) });
        if ((paramMotionEvent.getY() - this.jdField_b_of_type_Float < -200.0F) && (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) < 200.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a(false);
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0))
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_c_of_type_Long += 1L;
    this.jdField_d_of_type_Long = jdField_c_of_type_Long;
    aonm.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("busiType", -1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.f = paramBundle.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.l = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_i_of_type_Int & 0xF) == 0) {
      this.jdField_i_of_type_Int = 0;
    }
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (localSharedPreferences.getBoolean("last_select_All", false)) && (localSharedPreferences.getBoolean("last_select_send", false)))
    {
      this.k = true;
      c(paramBundle.getIntExtra("smart_device_switch_tab_flag", 0));
      paramBundle = localSharedPreferences.edit();
      paramBundle.putBoolean("last_select_All", false);
      paramBundle.putBoolean("last_select_send", false);
      paramBundle.commit();
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
      if (QLog.isColorLevel()) {
        QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
      }
      if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.f == -1)) {
        f(true);
      }
      this.jdField_b_of_type_Boolean = false;
      if (ajed.z.equalsIgnoreCase(this.jdField_i_of_type_JavaLangString)) {
        this.jdField_b_of_type_Boolean = true;
      }
      int m = getResources().getDisplayMetrics().heightPixels;
      if ((!c()) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 8) || (this.jdField_a_of_type_Int == 6) || (this.jdField_e_of_type_Boolean)) {
        break label665;
      }
      a(2131494882);
      ((LinearLayout)findViewById(2131300631)).setLayoutParams(new RelativeLayout.LayoutParams(-1, m));
      if ((ImmersiveUtils.isSupporImmersive() != 1) || (!f())) {}
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304063));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131307140));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new anwx(this));
      if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.f == -1))
      {
        setLeftViewName(2131654691);
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
      }
      o();
      d(this.jdField_a_of_type_Int);
      this.app.a().e();
      t();
      return true;
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int != 5) && (paramBundle.getIntExtra("approval_attachment_customid", -1) == -1)) {
        break;
      }
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = localSharedPreferences.getInt("last_select_tab_type", -1);
      }
      this.jdField_e_of_type_Int = localSharedPreferences.getInt("last_select_tab_view", -1);
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_e_of_type_Int == -1)) {
        break;
      }
      this.jdField_j_of_type_Boolean = true;
      break;
      label665:
      setContentView(2131494882);
      ((RelativeLayout)findViewById(2131309690)).setVisibility(8);
      paramBundle = (LinearLayout)findViewById(2131300631);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.app.a().b();
    this.app.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    if (this.jdField_d_of_type_Long == jdField_c_of_type_Long) {
      aonm.b();
    }
    u();
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Anxc != null) {
      removeObserver(this.jdField_a_of_type_Anxc);
    }
    if (this.jdField_a_of_type_Aobe != null) {
      this.jdField_a_of_type_Aobe.q();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_i_of_type_JavaLangString != null))
    {
      ajtg localajtg = (ajtg)this.app.a(20);
      this.jdField_a_of_type_Anxc = new anxc(this);
      addObserver(this.jdField_a_of_type_Anxc);
      localajtg.p(this.jdField_i_of_type_JavaLangString);
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if (c()) {
      overridePendingTransition(2130771977, 2130771978);
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return super.g();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (!a()) {}
    Intent localIntent;
    do
    {
      return;
      e();
      localIntent = new Intent(this, FMLocalFileActivity.class);
      localIntent.putExtra("STRING_Show_Music_Category", false);
      localIntent.putExtra("STRING_Show_Video_Category", false);
      localIntent.putExtra("STRING_Show_Apk_Category", false);
      localIntent.putExtra("STRING_Show_Pic_Category", false);
      localIntent.putExtra("STRING_Show_Driver_Category", false);
      localIntent.putExtra("STRING_Show_First_Space", false);
      localIntent.putExtra(axdz.f, this.jdField_h_of_type_Boolean);
      localIntent.putExtra(axdz.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
      if ((paramView.getId() == 2131303844) || (paramView.getId() == 2131302804))
      {
        localIntent.putExtra("localSdCardfile", 1408041717);
        localIntent.putExtra("STRING_Show_Download_Category", false);
        localIntent.putExtra("STRING_Show_MyFile_Category", true);
        localIntent.putExtra("select_file_support_send_docs_file", this.jdField_g_of_type_Boolean);
        localIntent.putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
        a().af();
        startActivityForResult(localIntent, paramView.getId());
        overridePendingTransition(2130772199, 2130772202);
        return;
      }
    } while (paramView.getId() != 2131309907);
    localIntent.putExtra("localSdCardfile", 1408041716);
    localIntent.putExtra("STRING_Show_Download_Category", false);
    a().am();
    startActivityForResult(localIntent, paramView.getId());
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Aobe != null) {
      this.jdField_a_of_type_Aobe.p();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (aonm.b() > 0L) {
      l();
    }
    if (this.jdField_a_of_type_Aobe != null) {
      this.jdField_a_of_type_Aobe.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */