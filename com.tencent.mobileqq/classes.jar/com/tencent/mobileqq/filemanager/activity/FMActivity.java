package com.tencent.mobileqq.filemanager.activity;

import actj;
import ajsd;
import ajwc;
import ajya;
import akhp;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import aonv;
import aonw;
import aonx;
import aony;
import aonz;
import aooa;
import aosc;
import aouu;
import apel;
import apvj;
import axqy;
import ayed;
import bbdj;
import bbgu;
import bgnk;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
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
  aooa jdField_a_of_type_Aooa = null;
  aosc jdField_a_of_type_Aosc = null;
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
  public boolean j;
  private int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean;
  
  public FMActivity()
  {
    this.jdField_g_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetRadioButton = null;
    this.jdField_c_of_type_AndroidWidgetRadioButton = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView = null;
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
      str = getString(2131692462);
      this.jdField_l_of_type_Int = 1;
      continue;
      str = getString(2131692465);
      this.jdField_l_of_type_Int = 3;
      continue;
      str = getString(2131692461);
      this.jdField_l_of_type_Int = 2;
      continue;
      str = getString(2131692464);
      this.jdField_l_of_type_Int = 4;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_l_of_type_Int = 0;
  }
  
  private void d(int paramInt)
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
  
  private void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366228));
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
        break label337;
      }
      setLeftViewName(2131692428);
      label80:
      if ((!c()) || (paramInt == 5) || (paramInt == 8) || (this.jdField_e_of_type_Boolean)) {
        break label493;
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131374876));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        p();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      if (ajwc.a() > 17.0F)
      {
        float f1 = getResources().getDisplayMetrics().density;
        localObject = new LinearLayout.LayoutParams((int)(55.0F * f1), (int)(f1 * 30.0F));
        this.jdField_c_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_c_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
        this.jdField_a_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
        this.jdField_b_of_type_AndroidWidgetRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label385;
      }
      q();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 0);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    label337:
    do
    {
      return;
      m = 2;
      break;
      if ((this.jdField_h_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString.trim().length() != 0) && (this.f != -1))
      {
        setLeftViewName(2131690740);
        break label80;
      }
      setLeftViewName(2131690331);
      break label80;
      if ((this.jdField_j_of_type_Boolean) || (this.jdField_k_of_type_Boolean)) {
        break label493;
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      r();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (!this.jdField_h_of_type_Boolean);
    label385:
    this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_c_of_type_AndroidWidgetRadioButton);
    return;
    label493:
    if (this.jdField_l_of_type_Boolean)
    {
      findViewById(2131374876).setVisibility(8);
      findViewById(2131369516).setVisibility(0);
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
      for (this.jdField_b_of_type_JavaLangString = getString(2131690711);; this.jdField_b_of_type_JavaLangString = getString(2131692441))
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
      this.jdField_b_of_type_JavaLangString = getString(2131692400);
      setTitle(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      f(paramInt);
      return;
    case 1: 
      if ((this.jdField_h_of_type_Int == 0) && (this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    case 5: 
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_b_of_type_JavaLangString = getString(2131692425);
        label734:
        setTitle(this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
        }
        r();
        if ((c()) && ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
        {
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
          setLeftViewName(2131692493);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
          if (this.jdField_i_of_type_Int <= 0) {
            break label915;
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
        break label734;
        label915:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    this.jdField_b_of_type_JavaLangString = ajya.a(2131704663);
    setTitle(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    setLeftViewName(2131690331);
    getRightTextView().setVisibility(8);
    v();
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    axqy.b(this.app, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, new aony(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private boolean l()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_k_of_type_Int != 11)
    {
      bool1 = bool2;
      if (this.jdField_k_of_type_Int != 1)
      {
        bool1 = bool2;
        if (this.jdField_k_of_type_Int != 3)
        {
          bool1 = bool2;
          if (this.jdField_k_of_type_Int != 5)
          {
            bool1 = bool2;
            if (this.jdField_k_of_type_Int != 4) {
              if (this.jdField_k_of_type_Int != 20) {
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
    akhp localakhp = (akhp)this.app.a(20);
    if (localakhp != null) {}
    try
    {
      localakhp.a(Long.parseLong(this.jdField_i_of_type_JavaLangString), 0L, 2, 0, 0);
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
    bbgu localbbgu = bbdj.a(this, 230);
    localbbgu.setMessage(2131697917);
    localbbgu.setTitle(2131697920);
    localbbgu.setNegativeButton(getString(2131697919), new aonv(this));
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.setCancelable(false);
    if (!isFinishing()) {
      localbbgu.show();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131369520));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131374874));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131364304));
    String str1 = ajsd.aV + "/Tencent/MicroMsg/Download/";
    String str2 = ajsd.aV + "/Tencent/MicroMsg/WeiXin/";
    new File(str1);
    new File(str2);
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new aonx(this);
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131692691));
      if (!this.jdField_h_of_type_Boolean) {
        break label228;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692689));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692691));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(21, getString(2131692696));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692695));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692692));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692690));
      break;
      label228:
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_e_of_type_Int >= 3) && (this.jdField_e_of_type_Int <= 7)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_e_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
      }
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    c(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369518));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_i_of_type_Int <= 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        g();
        label91:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
        if (this.jdField_i_of_type_Int > 0) {
          break label360;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131692692));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692695));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692691));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131692690));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131692694));
        label185:
        if ((!this.jdField_j_of_type_Boolean) || ((this.jdField_a_of_type_Int != 1) && (this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1) != 1)) || (this.jdField_e_of_type_Int < 8) || (this.jdField_e_of_type_Int > 14)) {
          break label551;
        }
        if (this.jdField_i_of_type_Int > 0) {
          break label537;
        }
        if ((this.jdField_e_of_type_Int != 11) && (this.jdField_e_of_type_Int != 9) && (this.jdField_e_of_type_Int != 10) && (this.jdField_e_of_type_Int != 8) && (this.jdField_e_of_type_Int != 14)) {
          break label525;
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
        break label91;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label91;
      label360:
      ArrayList localArrayList = new ArrayList();
      if (a(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692691));
        localArrayList.add(Integer.valueOf(10));
      }
      if (a(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692695));
        localArrayList.add(Integer.valueOf(9));
      }
      if (a(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131692697));
        localArrayList.add(Integer.valueOf(13));
      }
      if (a(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131692693));
        localArrayList.add(Integer.valueOf(12));
      }
      if (localArrayList.size() != 1) {
        break label185;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      break label185;
      label525:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      label537:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_j_of_type_Int);
      continue;
      label551:
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
  
  private void s()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aonz(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void u()
  {
    ArrayList localArrayList2 = null;
    Object localObject = apel.a();
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
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(111, getString(2131692697));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(119, getString(2131692695));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(110, getString(2131692691));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(118, getString(2131692690));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(114, getString(2131692694));
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
  
  public void a(aosc paramaosc)
  {
    this.jdField_a_of_type_Aosc = paramaosc;
    if (this.jdField_a_of_type_Int == 8) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_Aosc);
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
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
    apel.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("busiType", -1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.f = paramBundle.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.jdField_l_of_type_Boolean = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.jdField_k_of_type_Int = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
    }
    this.jdField_b_of_type_Boolean = false;
    if (ajsd.z.equalsIgnoreCase(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_i_of_type_Int & 0xF) == 0) {
      this.jdField_i_of_type_Int = 0;
    }
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (localSharedPreferences.getBoolean("last_select_All", false)) && (localSharedPreferences.getBoolean("last_select_send", false)))
    {
      this.jdField_k_of_type_Boolean = true;
      d(paramBundle.getIntExtra("smart_device_switch_tab_flag", 0));
      paramBundle = localSharedPreferences.edit();
      paramBundle.putBoolean("last_select_All", false);
      paramBundle.putBoolean("last_select_send", false);
      paramBundle.commit();
      if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.f == -1)) {
        f(true);
      }
      int m = getResources().getDisplayMetrics().heightPixels;
      if ((!c()) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 8) || (this.jdField_a_of_type_Int == 6) || (this.jdField_e_of_type_Boolean)) {
        break label738;
      }
      a(2131560453);
      ((LinearLayout)findViewById(2131366233)).setLayoutParams(new RelativeLayout.LayoutParams(-1, m));
      if ((ImmersiveUtils.isSupporImmersive() != 1) || (!f())) {}
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369735));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372854));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aonw(this));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376876);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376875));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375718));
      c(0);
      if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.f == -1))
      {
        setLeftViewName(2131720600);
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
      }
      o();
      e(this.jdField_a_of_type_Int);
      this.app.a().e();
      s();
      return true;
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int != 5) && (!this.jdField_b_of_type_Boolean) && (paramBundle.getIntExtra("approval_attachment_customid", -1) == -1)) {
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
      label738:
      setContentView(2131560453);
      ((RelativeLayout)findViewById(2131375447)).setVisibility(8);
      paramBundle = (LinearLayout)findViewById(2131366233);
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
      apel.b();
    }
    t();
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Aooa != null) {
      removeObserver(this.jdField_a_of_type_Aooa);
    }
    if (this.jdField_a_of_type_Aosc != null) {
      this.jdField_a_of_type_Aosc.q();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_i_of_type_JavaLangString != null))
    {
      akhp localakhp = (akhp)this.app.a(20);
      this.jdField_a_of_type_Aooa = new aooa(this);
      addObserver(this.jdField_a_of_type_Aooa);
      localakhp.p(this.jdField_i_of_type_JavaLangString);
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
    int m = 1;
    super.onClick(paramView);
    if (!a()) {}
    Object localObject;
    do
    {
      return;
      e();
      if ((paramView.getId() == 2131369518) || (paramView.getId() == 2131368429))
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(ayed.f, this.jdField_h_of_type_Boolean);
        ((Intent)localObject).putExtra(ayed.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.jdField_g_of_type_Boolean);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
        a().af();
        startActivityForResult((Intent)localObject, paramView.getId());
        overridePendingTransition(2130772199, 2130772202);
        return;
      }
      if (paramView.getId() == 2131375670)
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(ayed.f, this.jdField_h_of_type_Boolean);
        ((Intent)localObject).putExtra(ayed.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        a().am();
        startActivityForResult((Intent)localObject, paramView.getId());
        return;
      }
    } while ((paramView.getId() != 2131376875) || (this.jdField_l_of_type_Int == 0));
    paramView = new ArrayList();
    switch (this.jdField_l_of_type_Int)
    {
    default: 
      return;
    }
    for (int n = 16;; n = 17)
    {
      axqy.b(null, "dc00898", "", "", "0X800AA90", "0X800AA90", m, 0, "0", "0", "", "");
      localObject = new Bundle();
      ((Bundle)localObject).putString("qfile_search_param_ex_params_target_uin", a());
      ((Bundle)localObject).putInt("qfile_search_param_exparams_peer_type", a());
      ((Bundle)localObject).putInt("qfile_search_param_exparams_busi_type", b());
      ((Bundle)localObject).putString("qfile_search_param_exparams_send_uin", b());
      ((Bundle)localObject).putInt("qfile_search_param_exparams_qlink_state", d());
      ((Bundle)localObject).putBoolean("qfile_search_param_exparams_qlink_ap_created", d());
      FileSearchActivity.a(this, "", paramView, false, n, "", (Bundle)localObject);
      return;
      m = 2;
    }
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Aosc != null) {
      this.jdField_a_of_type_Aosc.p();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (apel.b() > 0L) {
      l();
    }
    if (this.jdField_a_of_type_Aosc != null) {
      this.jdField_a_of_type_Aosc.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */