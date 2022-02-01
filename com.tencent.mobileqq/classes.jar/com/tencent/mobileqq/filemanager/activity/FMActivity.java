package com.tencent.mobileqq.filemanager.activity;

import Override;
import afur;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import anhk;
import anll;
import anni;
import anwd;
import asrc;
import asrd;
import asre;
import asrf;
import asrg;
import asrh;
import aswk;
import aszd;
import atae;
import athc;
import atwr;
import bcst;
import bdhn;
import bglp;
import bgpa;
import blhj;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long jdField_c_of_type_Long;
  private float jdField_a_of_type_Float;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  View jdField_a_of_type_AndroidViewView = null;
  public LinearLayout a;
  public RadioButton a;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  asrh jdField_a_of_type_Asrh = null;
  aswk jdField_a_of_type_Aswk = null;
  public VerifyPwdView a;
  public QfileTabBarView a;
  private float jdField_b_of_type_Float;
  public View b;
  public RadioButton b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public TextView b;
  public RadioButton c;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  long jdField_d_of_type_Long;
  public RadioButton d;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  public int e;
  int f;
  int g;
  public final String g;
  public int h;
  String h;
  int i;
  public String i;
  int j;
  private int k;
  private int l;
  public boolean l;
  boolean m = false;
  boolean n;
  
  public FMActivity()
  {
    this.jdField_g_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetRadioButton = null;
    this.jdField_c_of_type_AndroidWidgetRadioButton = null;
    this.jdField_d_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void B()
  {
    ArrayList localArrayList2 = null;
    Object localObject = athc.a();
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
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(111, getString(2131692345));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(119, getString(2131692343));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(110, getString(2131692339));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(118, getString(2131692338));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(114, getString(2131692342));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private void a(Intent paramIntent)
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if (a(localSharedPreferences)) {
      this.m = true;
    }
    for (;;)
    {
      if ((!m()) && (this.jdField_a_of_type_Int == 1408041718)) {
        this.jdField_a_of_type_Int = 7;
      }
      e(paramIntent.getIntExtra("smart_device_switch_tab_flag", 0));
      paramIntent = localSharedPreferences.edit();
      paramIntent.putBoolean("last_select_All", false);
      paramIntent.putBoolean("last_select_send", false);
      paramIntent.commit();
      return;
      if ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Int == 5) || (this.jdField_d_of_type_Boolean) || (paramIntent.getIntExtra("approval_attachment_customid", -1) != -1))
      {
        if (this.jdField_a_of_type_Int == -1) {
          this.jdField_a_of_type_Int = localSharedPreferences.getInt("last_select_tab_type", -1);
        }
        this.jdField_e_of_type_Int = localSharedPreferences.getInt("last_select_tab_view", -1);
        if ((this.jdField_a_of_type_Int != -1) && (this.jdField_e_of_type_Int != -1)) {
          this.jdField_l_of_type_Boolean = true;
        }
      }
    }
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 5)
      {
        bool1 = bool2;
        if (paramSharedPreferences.getBoolean("last_select_All", false))
        {
          bool1 = bool2;
          if (paramSharedPreferences.getBoolean("last_select_send", false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void c(int paramInt)
  {
    if (!l())
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_l_of_type_Int = 0;
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_l_of_type_Int = 0;
      return;
    }
    String str = "";
    switch (paramInt)
    {
    }
    while (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      return;
      str = getString(2131692125);
      this.jdField_l_of_type_Int = 1;
      continue;
      str = getString(2131692128);
      this.jdField_l_of_type_Int = 3;
      continue;
      str = getString(2131692124);
      this.jdField_l_of_type_Int = 2;
      continue;
      str = getString(2131692127);
      this.jdField_l_of_type_Int = 4;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_l_of_type_Int = 0;
  }
  
  private void d(int paramInt)
  {
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 8) && (this.jdField_a_of_type_Int != 6) && (!this.jdField_g_of_type_Boolean))
    {
      a(2131560846);
      ((LinearLayout)findViewById(2131366575)).setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (f())) {}
      return;
    }
    setContentView(2131560846);
    ((RelativeLayout)findViewById(2131376734)).setVisibility(8);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366575);
  }
  
  private void e(int paramInt)
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
  
  private void f(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366571));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(2);
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    int i1;
    if (this.jdField_f_of_type_Boolean)
    {
      i1 = 1;
      localQfileTabBarView.setWYSubAppId(i1);
      if (c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setMemory(true);
      }
      p();
      if ((!c()) || (paramInt == 5) || (paramInt == 8) || (this.jdField_g_of_type_Boolean)) {
        break label145;
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131376123));
      s();
      if (!m()) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_d_of_type_AndroidWidgetRadioButton);
      }
      q();
      if (!o()) {
        break label138;
      }
    }
    label138:
    while (n())
    {
      return;
      i1 = 2;
      break;
    }
    label145:
    if (this.n)
    {
      findViewById(2131376123).setVisibility(8);
      findViewById(2131370234).setVisibility(0);
    }
    g();
    this.jdField_b_of_type_JavaLangString = getString(2131692103);
    g(paramInt);
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_JavaLangString = getString(2131690643);
    case 6: 
    case 7: 
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      u();
      return;
    case 2: 
    case 3: 
      this.jdField_b_of_type_JavaLangString = getString(2131692061);
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      h(paramInt);
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    case 5: 
      r();
      return;
    case 8: 
      this.jdField_b_of_type_JavaLangString = anni.a(2131703443);
      setTitle(this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368947));
      setLeftViewName(2131690389);
      getRightTextView().setVisibility(8);
      C();
      return;
    }
    this.jdField_b_of_type_JavaLangString = getString(2131692078);
    setTitle(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    y();
  }
  
  private void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    bcst.b(this.app, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    c(0);
    this.jdField_l_of_type_Int = 3;
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, new asrf(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private boolean l()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.k != 11)
    {
      bool1 = bool2;
      if (this.k != 1)
      {
        bool1 = bool2;
        if (this.k != 3)
        {
          bool1 = bool2;
          if (this.k != 5)
          {
            bool1 = bool2;
            if (this.k != 4) {
              if (this.k != 20) {
                break label75;
              }
            }
          }
        }
      }
    }
    label75:
    for (bool1 = bool2;; bool1 = false)
    {
      if (!f()) {
        return false;
      }
      return bool1;
    }
  }
  
  private void m()
  {
    anwd localanwd = (anwd)this.app.a(20);
    if (localanwd != null) {}
    try
    {
      localanwd.a(Long.parseLong(this.jdField_i_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private boolean m()
  {
    return (this.k == 1) || (this.k == 3) || (this.k == 11) || (this.k == 4);
  }
  
  private void n()
  {
    bgpa localbgpa = bglp.a(this, 230);
    localbgpa.setMessage(2131696943);
    localbgpa.setTitle(2131696946);
    localbgpa.setNegativeButton(getString(2131696945), new asrc(this));
    localbgpa.setCanceledOnTouchOutside(false);
    localbgpa.setCancelable(false);
    if (!isFinishing()) {
      localbgpa.show();
    }
  }
  
  private boolean n()
  {
    if ((!this.jdField_l_of_type_Boolean) && (!this.m))
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      v();
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 1);
      localEditor.commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_c_of_type_AndroidWidgetRadioButton);
        if (m()) {
          this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_d_of_type_AndroidWidgetRadioButton);
        }
      }
      return true;
    }
    return false;
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131370238));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376121));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131364585));
    this.jdField_d_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131366262));
    String str1 = anhk.aZ + "/Tencent/MicroMsg/Download/";
    String str2 = anhk.aZ + "/Tencent/MicroMsg/WeiXin/";
    new File(str1);
    new File(str2);
  }
  
  private boolean o()
  {
    boolean bool = false;
    if (this.m)
    {
      u();
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 0);
      localEditor.commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      bool = true;
    }
    return bool;
  }
  
  private void p()
  {
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      setLeftViewName(2131692090);
      return;
    }
    if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0) && (this.jdField_f_of_type_Int != -1))
    {
      setLeftViewName(2131690668);
      return;
    }
    setLeftViewName(2131690389);
  }
  
  private void q()
  {
    if (anll.a() > 17.0F)
    {
      float f1 = getResources().getDisplayMetrics().density;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(55.0F * f1), (int)(f1 * 30.0F));
      this.jdField_c_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      if (m())
      {
        this.jdField_d_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
        this.jdField_d_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
    }
  }
  
  private void r()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = getString(2131692087);
    }
    setTitle(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    v();
    if ((c()) && ((this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368947));
      setLeftViewName(2131692156);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_i_of_type_Int <= 0) {
        break label184;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 1);
      localEditor.commit();
      if (b() == 8) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      return;
      label184:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
      t();
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new asre(this);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_h_of_type_JavaLangString);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131692339));
      if (!this.jdField_j_of_type_Boolean) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(4);
    }
    for (;;)
    {
      c(1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692337));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692339));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(21, getString(2131692344));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692343));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692340));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692338));
      break;
      label224:
      if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_e_of_type_Int >= 3) && (this.jdField_e_of_type_Int <= 7)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
      }
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    c(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    w();
    x();
    int i1 = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
    if ((this.jdField_l_of_type_Boolean) && ((this.jdField_a_of_type_Int == 1) || (i1 == 1)) && (this.jdField_e_of_type_Int >= 8) && (this.jdField_e_of_type_Int <= 14)) {
      if (this.jdField_i_of_type_Int <= 0) {
        if ((this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 9) || (this.jdField_e_of_type_Int == 10) || (this.jdField_e_of_type_Int == 8) || (this.jdField_e_of_type_Int == 14)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      continue;
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
  
  private void w()
  {
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370236));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_i_of_type_Int <= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        g();
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      break;
      a(this);
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_i_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131692340));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692343));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692339));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131692338));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131692342));
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      if (a(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692339));
        localArrayList.add(Integer.valueOf(10));
      }
      if (a(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692343));
        localArrayList.add(Integer.valueOf(9));
      }
      if (a(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131692345));
        localArrayList.add(Integer.valueOf(13));
      }
      if (a(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131692341));
        localArrayList.add(Integer.valueOf(12));
      }
    } while (localArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initFavTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_h_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1200, getString(2131692340));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1201, getString(2131692343));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1202, getString(2131692339));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1203, getString(2131692338));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1204, getString(2131692342));
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_e_of_type_Int >= 1200) && (this.jdField_e_of_type_Int <= 1204)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      bcst.b(this.app, "dc00898", "", "", "0X800AFA7", "0X800AFA7", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1200);
    }
  }
  
  private void z()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new asrg(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
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
  
  public void a(aswk paramaswk)
  {
    this.jdField_a_of_type_Aswk = paramaswk;
    if (this.jdField_a_of_type_Int == 8) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_Aswk);
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
    int i1 = 0;
    if (paramBoolean) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int i2 = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(i2 - i1);
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
        break label54;
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
      return bool;
      label54:
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
    if (paramInt1 == 9999) {
      if (paramIntent != null) {}
    }
    do
    {
      return;
      if (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1)
      {
        setResult(paramInt2, new Intent(paramIntent));
        finish();
      }
      if ((paramInt2 != -1) || (this.jdField_h_of_type_JavaLangString == null) || (this.jdField_h_of_type_JavaLangString.trim().length() == 0)) {
        break;
      }
    } while (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4));
    Intent localIntent = afur.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
    return;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_c_of_type_Long += 1L;
    this.jdField_d_of_type_Long = jdField_c_of_type_Long;
    athc.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("busiType", -1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.n = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.k = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
    }
    this.jdField_d_of_type_Boolean = false;
    if (anhk.z.equalsIgnoreCase(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_i_of_type_Int & 0xF) == 0) {
      this.jdField_i_of_type_Int = 0;
    }
    a(paramBundle);
    if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.jdField_f_of_type_Int == -1)) {
      f(true);
    }
    d(getResources().getDisplayMetrics().heightPixels);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370459));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374044));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new asrd(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378274);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378273));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377044));
    c(0);
    if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.jdField_f_of_type_Int == -1))
    {
      setLeftViewName(2131718890);
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
    }
    o();
    f(this.jdField_a_of_type_Int);
    this.app.a().e();
    z();
    this.app.a().a().a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    this.app.a().b();
    this.app.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    if (this.jdField_d_of_type_Long == jdField_c_of_type_Long) {
      athc.b();
    }
    A();
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Asrh != null) {
      removeObserver(this.jdField_a_of_type_Asrh);
    }
    if (this.jdField_a_of_type_Aswk != null) {
      this.jdField_a_of_type_Aswk.t();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_i_of_type_JavaLangString != null))
    {
      anwd localanwd = (anwd)this.app.a(20);
      this.jdField_a_of_type_Asrh = new asrh(this);
      addObserver(this.jdField_a_of_type_Asrh);
      localanwd.p(this.jdField_i_of_type_JavaLangString);
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
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    super.onClick(paramView);
    if (!a()) {}
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      if ((paramView.getId() == 2131370236) || (paramView.getId() == 2131368947))
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(bdhn.f, this.jdField_j_of_type_Boolean);
        ((Intent)localObject).putExtra(bdhn.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.jdField_i_of_type_Boolean);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
        a().ad();
        startActivityForResult((Intent)localObject, paramView.getId());
        overridePendingTransition(2130772224, 2130772227);
      }
      else if (paramView.getId() == 2131376987)
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(bdhn.f, this.jdField_j_of_type_Boolean);
        ((Intent)localObject).putExtra(bdhn.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        a().ak();
        startActivityForResult((Intent)localObject, paramView.getId());
      }
      else if ((paramView.getId() == 2131378273) && (this.jdField_l_of_type_Int != 0))
      {
        localObject = new ArrayList();
        switch (this.jdField_l_of_type_Int)
        {
        }
      }
    }
    for (int i2 = 16;; i2 = 17)
    {
      bcst.b(null, "dc00898", "", "", "0X800AA90", "0X800AA90", i1, 0, "0", "0", "", "");
      Bundle localBundle = new Bundle();
      localBundle.putString("qfile_search_param_ex_params_target_uin", a());
      localBundle.putInt("qfile_search_param_exparams_peer_type", a());
      localBundle.putInt("qfile_search_param_exparams_busi_type", b());
      localBundle.putString("qfile_search_param_exparams_send_uin", b());
      localBundle.putInt("qfile_search_param_exparams_qlink_state", d());
      localBundle.putBoolean("qfile_search_param_exparams_qlink_ap_created", d());
      FileSearchActivity.a(this, "", (List)localObject, false, i2, "", localBundle);
      break;
      i1 = 2;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Aswk != null) {
      this.jdField_a_of_type_Aswk.s();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (athc.b() > 0L) {
      l();
    }
    if (this.jdField_a_of_type_Aswk != null) {
      this.jdField_a_of_type_Aswk.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */