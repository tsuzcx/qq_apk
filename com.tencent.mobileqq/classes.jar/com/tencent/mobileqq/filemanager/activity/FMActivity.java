package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
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
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qlink.QQProxyForQlink;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long jdField_c_of_type_Long = 0L;
  private float jdField_a_of_type_Float;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = null;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  FMActivity.FMTroopBusinessObserver jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver = null;
  VerifyPwdView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
  IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = null;
  public QfileTabBarView a;
  private HashMap<String, FMActivity.FileChooseTypeMessage> jdField_a_of_type_JavaUtilHashMap;
  private float jdField_b_of_type_Float;
  View jdField_b_of_type_AndroidViewView = null;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  protected ArrayList<String> b;
  RadioButton jdField_c_of_type_AndroidWidgetRadioButton = null;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  long jdField_d_of_type_Long;
  RadioButton jdField_d_of_type_AndroidWidgetRadioButton = null;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  protected int e;
  int jdField_f_of_type_Int = -1;
  String jdField_f_of_type_JavaLangString;
  int jdField_g_of_type_Int;
  String jdField_g_of_type_JavaLangString = null;
  int h = -1;
  int i;
  int j;
  int k = -1;
  private int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  boolean jdField_m_of_type_Boolean = false;
  boolean n;
  
  public FMActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilArrayList = null;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initFavTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_f_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1200, getString(2131692628));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1201, getString(2131692631));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1202, getString(2131692627));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1203, getString(2131692626));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1204, getString(2131692630));
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_f_of_type_Int >= 1200) && (this.jdField_f_of_type_Int <= 1204)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_f_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800AFA7", "0X800AFA7", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1200);
    }
  }
  
  private void B()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new FMActivity.5(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void D()
  {
    ArrayList localArrayList2 = null;
    Object localObject = FMDataCache.a();
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
    this.app.getQQProxyForQlink().a(this, localArrayList1, 15, 0, true, this.jdField_g_of_type_JavaLangString);
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(111, getString(2131692633));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(119, getString(2131692631));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(110, getString(2131692627));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(118, getString(2131692626));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(114, getString(2131692630));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private int a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("mini_file_paths_support", 1);
    localIntent.putExtra("file_number_limit", paramInt2);
    localIntent.putExtra("file_type", paramArrayList);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 1);
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt1);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      d(true);
      b(10006);
      c(7);
      this.jdField_b_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("file_type");
      FMDataCache.a(paramIntent.getIntExtra("file_number_limit", 20));
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put("media", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 11, a(2131692628)));
      this.jdField_a_of_type_JavaUtilHashMap.put("image", new FMActivity.FileChooseTypeMessage(".jpg|.bmp|.jpeg|.gif|.png|.ico|", 9, a(2131692631)));
      this.jdField_a_of_type_JavaUtilHashMap.put("file", new FMActivity.FileChooseTypeMessage(".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", 10, a(2131692627)));
      this.jdField_a_of_type_JavaUtilHashMap.put("video", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", 13, a(2131692633)));
      this.jdField_a_of_type_JavaUtilHashMap.put("audio", new FMActivity.FileChooseTypeMessage(".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 12, a(2131692629)));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      paramBundle.putInt("file_choose_extension_handle_type", 1);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (!this.jdField_b_of_type_JavaUtilArrayList.contains("all"))
        {
          localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          String str;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + a(str)) {
            str = (String)((Iterator)localObject2).next();
          }
        }
      }
      paramBundle.putString("file_choose_extension_in_filter", (String)localObject1);
      paramBundle.putString("file_choose_extension_out_filter", "");
    }
  }
  
  private boolean a(Intent paramIntent, boolean paramBoolean)
  {
    return (paramBoolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Int == 5) || (this.jdField_d_of_type_Boolean) || ((paramIntent != null) && (paramIntent.getIntExtra("approval_attachment_customid", -1) != -1));
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
  
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("needRemember", false);; bool = false)
    {
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
      if (a(localSharedPreferences)) {
        this.jdField_m_of_type_Boolean = true;
      }
      for (;;)
      {
        if ((!m()) && (this.jdField_a_of_type_Int == 1408041718)) {
          this.jdField_a_of_type_Int = 7;
        }
        if (paramIntent != null) {
          g(paramIntent.getIntExtra("smart_device_switch_tab_flag", 0));
        }
        paramIntent = localSharedPreferences.edit();
        paramIntent.putBoolean("last_select_All", false);
        paramIntent.putBoolean("last_select_send", false);
        paramIntent.commit();
        return;
        if (a(paramIntent, bool))
        {
          if (this.jdField_a_of_type_Int == -1) {
            this.jdField_a_of_type_Int = localSharedPreferences.getInt("last_select_tab_type", -1);
          }
          this.jdField_f_of_type_Int = localSharedPreferences.getInt("last_select_tab_view", -1);
          if ((this.jdField_a_of_type_Int != -1) && (this.jdField_f_of_type_Int != -1)) {
            this.jdField_l_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (!l())
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_m_of_type_Int = 0;
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_m_of_type_Int = 0;
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
      str = getString(2131692400);
      this.jdField_m_of_type_Int = 1;
      continue;
      str = getString(2131692403);
      this.jdField_m_of_type_Int = 3;
      continue;
      str = getString(2131692399);
      this.jdField_m_of_type_Int = 2;
      continue;
      str = getString(2131692402);
      this.jdField_m_of_type_Int = 4;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_m_of_type_Int = 0;
  }
  
  private void f(int paramInt)
  {
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 8) && (this.jdField_a_of_type_Int != 6) && (!this.jdField_g_of_type_Boolean))
    {
      a(2131560908);
      ((LinearLayout)findViewById(2131366939)).setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (f())) {}
      return;
    }
    setContentView(2131560908);
    ((RelativeLayout)findViewById(2131377297)).setVisibility(8);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366939);
  }
  
  private void g(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 1) && (paramInt != 2) && (paramInt != 4))
    {
      this.k = 10;
      return;
    }
    if ((paramInt == 8) && (a(8)))
    {
      this.k = 10;
      return;
    }
    if ((paramInt == 1) && (a(1)))
    {
      this.k = 12;
      return;
    }
    if ((paramInt == 2) && (a(2)))
    {
      this.k = 13;
      return;
    }
    if ((paramInt == 4) && (a(4)))
    {
      this.k = 9;
      return;
    }
    this.k = 10;
  }
  
  private void h(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366935));
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
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131376671));
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
      findViewById(2131376671).setVisibility(8);
      findViewById(2131370766).setVisibility(0);
    }
    g();
    this.jdField_a_of_type_JavaLangString = getString(2131692378);
    i(paramInt);
  }
  
  private void i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_JavaLangString = getString(2131690862);
    case 6: 
    case 7: 
      setTitle(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      u();
      return;
    case 2: 
    case 3: 
      this.jdField_a_of_type_JavaLangString = getString(2131692336);
      setTitle(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(true);
      }
      j(paramInt);
      return;
    case 1: 
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      if ((this.jdField_i_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    case 5: 
      r();
      return;
    case 8: 
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704679);
      setTitle(this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
      setLeftViewName(2131690601);
      getRightTextView().setVisibility(8);
      E();
      return;
    }
    this.jdField_a_of_type_JavaLangString = getString(2131692353);
    setTitle(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    A();
  }
  
  private void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    e(0);
    this.jdField_m_of_type_Int = 3;
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, new FMActivity.4(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private boolean l()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_l_of_type_Int != 11)
    {
      bool1 = bool2;
      if (this.jdField_l_of_type_Int != 1)
      {
        bool1 = bool2;
        if (this.jdField_l_of_type_Int != 3)
        {
          bool1 = bool2;
          if (this.jdField_l_of_type_Int != 5)
          {
            bool1 = bool2;
            if (this.jdField_l_of_type_Int != 4) {
              if (this.jdField_l_of_type_Int != 20) {
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
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_g_of_type_JavaLangString), 0L, 2, 0, 0);
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
    return (this.jdField_l_of_type_Int == 1) || (this.jdField_l_of_type_Int == 3) || (this.jdField_l_of_type_Int == 11) || (this.jdField_l_of_type_Int == 4);
  }
  
  private void n()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131697665);
    localQQCustomDialog.setTitle(2131697668);
    localQQCustomDialog.setNegativeButton(getString(2131697667), new FMActivity.1(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private boolean n()
  {
    if ((!this.jdField_l_of_type_Boolean) && (!this.jdField_m_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      v();
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 1);
      localEditor.commit();
      if ((this.jdField_i_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
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
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131370770));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376669));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131364863));
    this.jdField_d_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131366616));
    String str1 = AppConstants.SDCARD_ROOT + "/Tencent/MicroMsg/Download/";
    String str2 = AppConstants.SDCARD_ROOT + "/Tencent/MicroMsg/WeiXin/";
    new File(str1);
    new File(str2);
  }
  
  private boolean o()
  {
    boolean bool = false;
    if (this.jdField_m_of_type_Boolean)
    {
      u();
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 0);
      localEditor.commit();
      if ((this.jdField_i_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
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
      setLeftViewName(2131692365);
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0) && (this.jdField_g_of_type_Int != -1))
    {
      setLeftViewName(2131690888);
      return;
    }
    setLeftViewName(2131690601);
  }
  
  private void q()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
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
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getString(2131692362);
    }
    setTitle(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    v();
    if ((c()) && ((this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
      setLeftViewName(2131692431);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_e_of_type_Int != 1)) {
        break label193;
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
      label193:
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
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new FMActivity.3(this);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_f_of_type_JavaLangString);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131692627));
      if (!this.jdField_j_of_type_Boolean) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(4);
    }
    for (;;)
    {
      e(1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692625));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692627));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(21, getString(2131692632));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692631));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692628));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692626));
      break;
      label223:
      if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_f_of_type_Int >= 3) && (this.jdField_f_of_type_Int <= 7)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_f_of_type_Int);
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
    e(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    x();
    y();
    int i1 = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
    if ((this.jdField_l_of_type_Boolean) && ((this.jdField_a_of_type_Int == 1) || (i1 == 1)) && (this.jdField_f_of_type_Int >= 8) && (this.jdField_f_of_type_Int <= 14)) {
      if (this.jdField_j_of_type_Int <= 0) {
        if ((this.jdField_f_of_type_Int == 11) || (this.jdField_f_of_type_Int == 9) || (this.jdField_f_of_type_Int == 10) || (this.jdField_f_of_type_Int == 8) || (this.jdField_f_of_type_Int == 14) || (this.jdField_f_of_type_Int == 5) || (this.jdField_f_of_type_Int == 13) || (this.jdField_f_of_type_Int == 12)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_f_of_type_Int);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      w();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.k);
      continue;
      if (7 != this.h)
      {
        if (this.jdField_j_of_type_Int <= 0) {
          w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.k);
        }
      }
      else if (this.k != -1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.k);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.contains("all")))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(10);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(a((String)this.jdField_b_of_type_JavaUtilArrayList.get(0)));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
  }
  
  private void x()
  {
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370768));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_e_of_type_Int == -1))
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
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_j_of_type_Int <= 0) {
      if (this.jdField_e_of_type_Int == 1) {
        z();
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131692628));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692631));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692627));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131692626));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131692630));
      return;
      localArrayList = new ArrayList();
      if (a(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692627));
        localArrayList.add(Integer.valueOf(10));
      }
      if (a(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692631));
        localArrayList.add(Integer.valueOf(9));
      }
      if (a(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131692633));
        localArrayList.add(Integer.valueOf(13));
      }
      if (a(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131692629));
        localArrayList.add(Integer.valueOf(12));
      }
    } while (localArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
  }
  
  private void z()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.contains("all")))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, a(2131692627));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, a(2131692628));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, a(2131692631));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, a(2131692630));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1)
      {
        localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.findViewById(2131370420);
        if (localObject != null) {
          ((LinearLayout)localObject).setBackgroundColor(16777215);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.findViewById(2131381605);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
      }
      return;
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(a(str), b(str));
      }
      this.jdField_f_of_type_Int = a((String)this.jdField_b_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    return getString(paramInt);
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
    if (this.jdField_a_of_type_Int == 8) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent);
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
    return (this.jdField_j_of_type_Int & paramInt) > 0;
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
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null)
    {
      super.d(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSortType(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.f();
      if (paramMotionEvent.getAction() != 0) {
        break label65;
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      label65:
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
      if ((paramInt2 != -1) || (this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.trim().length() == 0)) {
        break;
      }
    } while (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4));
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
    FMDataCache.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.h = paramBundle.getIntExtra("busiType", -1);
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.n = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("mini_file_paths_support", -1);
    a(paramBundle);
    this.jdField_l_of_type_Int = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
    }
    this.jdField_d_of_type_Boolean = AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.jdField_g_of_type_JavaLangString);
    this.jdField_j_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_j_of_type_Int & 0xF) == 0) {
      this.jdField_j_of_type_Int = 0;
    }
    b(paramBundle);
    if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == -1)) {
      f(true);
    }
    f(getResources().getDisplayMetrics().heightPixels);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370993));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374477));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FMActivity.2(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378917);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378916));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377623));
    e(0);
    if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == -1))
    {
      setLeftViewName(2131720326);
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
    }
    o();
    h(this.jdField_a_of_type_Int);
    this.app.getFileManagerEngine().e();
    B();
    this.app.getFileManagerEngine().a().a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    this.app.getFileManagerEngine().b();
    this.app.getFileManagerEngine().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    if (this.jdField_d_of_type_Long == jdField_c_of_type_Long) {
      FMDataCache.b();
    }
    C();
    if (this.jdField_e_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.t();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_g_of_type_JavaLangString != null))
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver = new FMActivity.FMTroopBusinessObserver(this);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver);
      localTroopHandler.n(this.jdField_g_of_type_JavaLangString);
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if ((!c()) || (this.jdField_a_of_type_Int == 8)) {
      return;
    }
    overridePendingTransition(2130771979, 2130771980);
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
    return this.jdField_e_of_type_Int;
  }
  
  public int i()
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
      if ((paramView.getId() == 2131370768) || (paramView.getId() == 2131369487))
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(TeamWorkConstants.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_Boolean);
        ((Intent)localObject).putExtra(TeamWorkConstants.jdField_g_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.jdField_i_of_type_Boolean);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
        a().ad();
        startActivityForResult((Intent)localObject, paramView.getId());
        overridePendingTransition(2130772236, 2130772239);
      }
      else if (paramView.getId() == 2131377570)
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(TeamWorkConstants.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_Boolean);
        ((Intent)localObject).putExtra(TeamWorkConstants.jdField_g_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        a().ak();
        startActivityForResult((Intent)localObject, paramView.getId());
      }
      else if ((paramView.getId() == 2131378916) && (this.jdField_m_of_type_Int != 0))
      {
        localObject = new ArrayList();
        switch (this.jdField_m_of_type_Int)
        {
        }
      }
    }
    for (int i2 = 16;; i2 = 17)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AA90", "0X800AA90", i1, 0, "0", "0", "", "");
      Bundle localBundle = new Bundle();
      localBundle.putString("qfile_search_param_ex_params_target_uin", a());
      localBundle.putInt("qfile_search_param_exparams_peer_type", a());
      localBundle.putInt("qfile_search_param_exparams_busi_type", b());
      localBundle.putString("qfile_search_param_exparams_send_uin", b());
      localBundle.putInt("qfile_search_param_exparams_qlink_state", d());
      localBundle.putBoolean("qfile_search_param_exparams_qlink_ap_created", d());
      a(localBundle);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.s();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (FMDataCache.b() > 0L) {
      l();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */