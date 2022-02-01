package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long jdField_c_of_type_Long;
  private float jdField_a_of_type_Float;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  View jdField_a_of_type_AndroidViewView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = null;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  FMActivity.FMTroopBusinessObserver jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver = null;
  FMActivity.FMTroopObserver jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopObserver = null;
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
  String e;
  int jdField_f_of_type_Int = -1;
  String jdField_f_of_type_JavaLangString = null;
  int g;
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
        this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void C()
  {
    Object localObject = FMDataCache.a();
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Set)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(((FileInfo)localIterator.next()).c());
      }
    }
    localObject = null;
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).requestSendQlinkFile(this, (ArrayList)localObject, this.jdField_f_of_type_JavaLangString);
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(111, getString(2131692589));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(119, getString(2131692587));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(110, getString(2131692579));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(118, getString(2131692578));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(114, getString(2131692586));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private int a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).jdField_a_of_type_Int;
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
      this.jdField_a_of_type_JavaUtilHashMap.put("media", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 11, a(2131692581)));
      this.jdField_a_of_type_JavaUtilHashMap.put("image", new FMActivity.FileChooseTypeMessage(".jpg|.bmp|.jpeg|.gif|.png|.ico|", 9, a(2131692587)));
      this.jdField_a_of_type_JavaUtilHashMap.put("file", new FMActivity.FileChooseTypeMessage(".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", 10, a(2131692579)));
      this.jdField_a_of_type_JavaUtilHashMap.put("video", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", 13, a(2131692589)));
      this.jdField_a_of_type_JavaUtilHashMap.put("audio", new FMActivity.FileChooseTypeMessage(".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 12, a(2131692584)));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      paramBundle.putInt("file_choose_extension_handle_type", 1);
      Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject1 != null) && (!((ArrayList)localObject1).contains("all")))
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        StringBuilder localStringBuilder;
        for (localObject1 = "";; localObject1 = localStringBuilder.toString())
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (String)localIterator.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(a((String)localObject2));
        }
      }
      Object localObject2 = "";
      paramBundle.putString("file_choose_extension_in_filter", (String)localObject2);
      paramBundle.putString("file_choose_extension_out_filter", "");
    }
  }
  
  private boolean a(Intent paramIntent, boolean paramBoolean)
  {
    return (paramBoolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Int == 5) || (this.jdField_d_of_type_Boolean) || ((paramIntent != null) && (paramIntent.getIntExtra("approval_attachment_customid", -1) != -1));
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  private void b(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("needRemember", false);
    } else {
      bool = false;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if (a(localSharedPreferences))
    {
      this.jdField_m_of_type_Boolean = true;
    }
    else if (a(paramIntent, bool))
    {
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = localSharedPreferences.getInt("last_select_tab_type", -1);
      }
      this.jdField_f_of_type_Int = localSharedPreferences.getInt("last_select_tab_view", -1);
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_f_of_type_Int != -1)) {
        this.jdField_l_of_type_Boolean = true;
      }
    }
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
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            str = "";
          }
          else
          {
            str = getString(2131692329);
            this.jdField_m_of_type_Int = 4;
          }
        }
        else
        {
          str = getString(2131692330);
          this.jdField_m_of_type_Int = 3;
        }
      }
      else
      {
        str = getString(2131692326);
        this.jdField_m_of_type_Int = 2;
      }
    }
    else
    {
      str = getString(2131692327);
      this.jdField_m_of_type_Int = 1;
    }
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_m_of_type_Int = 0;
  }
  
  private void f(int paramInt)
  {
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 8) && (this.jdField_a_of_type_Int != 6) && (!this.jdField_g_of_type_Boolean))
    {
      a(2131560782);
      ((LinearLayout)findViewById(2131366801)).setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        f();
      }
    }
    else
    {
      setContentView(2131560782);
      ((RelativeLayout)findViewById(2131376752)).setVisibility(8);
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366801);
    }
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366797));
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    int i1 = 2;
    localQfileTabBarView.setAttribution(2);
    localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (this.jdField_f_of_type_Boolean) {
      i1 = 1;
    }
    localQfileTabBarView.setWYSubAppId(i1);
    if (c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setMemory(true);
    }
    o();
    if ((c()) && (paramInt != 5) && (paramInt != 8) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131376175));
      r();
      if (!m()) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.jdField_d_of_type_AndroidWidgetRadioButton);
      }
      p();
      if (o()) {
        return;
      }
      if (n()) {
        return;
      }
    }
    if (this.n)
    {
      findViewById(2131376175).setVisibility(8);
      findViewById(2131370400).setVisibility(0);
    }
    g();
    this.jdField_a_of_type_JavaLangString = getString(2131698215);
    i(paramInt);
  }
  
  private void i(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt != 5)
          {
            if ((paramInt == 6) || (paramInt == 7)) {
              break label246;
            }
            if (paramInt != 8)
            {
              if (paramInt != 1408041718) {
                return;
              }
              this.jdField_a_of_type_JavaLangString = getString(2131692282);
              setTitle(this.jdField_a_of_type_JavaLangString);
              localRadioGroup = this.jdField_a_of_type_AndroidWidgetRadioGroup;
              if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
                this.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(true);
              }
              z();
              return;
            }
            this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131698174);
            setTitle(this.jdField_a_of_type_JavaLangString);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
            setLeftViewName(2131690529);
            getRightTextView().setVisibility(8);
            D();
          }
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = getString(2131692375);
          setTitle(this.jdField_a_of_type_JavaLangString);
          localRadioGroup = this.jdField_a_of_type_AndroidWidgetRadioGroup;
          if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
            this.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(true);
          }
          j(paramInt);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        if ((this.jdField_i_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      q();
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = getString(2131690790);
    }
    label246:
    setTitle(this.jdField_a_of_type_JavaLangString);
    RadioGroup localRadioGroup = this.jdField_a_of_type_AndroidWidgetRadioGroup;
    if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    t();
  }
  
  private void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    e(0);
    this.jdField_m_of_type_Int = 3;
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    VerifyPwdView localVerifyPwdView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView;
    if (localVerifyPwdView != null) {
      localVerifyPwdView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, new FMActivity.4(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private boolean l()
  {
    int i1 = this.jdField_l_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i1 != 11)
    {
      bool1 = bool2;
      if (i1 != 1)
      {
        bool1 = bool2;
        if (i1 != 3)
        {
          bool1 = bool2;
          if (i1 != 5)
          {
            bool1 = bool2;
            if (i1 != 4) {
              if (i1 == 20) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
          }
        }
      }
    }
    if (!f()) {
      bool1 = false;
    }
    return bool1;
  }
  
  private void m()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131697671);
    localQQCustomDialog.setTitle(2131697674);
    localQQCustomDialog.setNegativeButton(getString(2131697673), new FMActivity.1(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private boolean m()
  {
    int i1 = this.jdField_l_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i1 != 1)
    {
      bool1 = bool2;
      if (i1 != 3)
      {
        bool1 = bool2;
        if (i1 != 11)
        {
          if (i1 == 4) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131370404));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376173));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131364749));
    this.jdField_d_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131366485));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_ROOT);
    ((StringBuilder)localObject1).append("/Tencent/MicroMsg/Download/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_ROOT);
    ((StringBuilder)localObject2).append("/Tencent/MicroMsg/WeiXin/");
    localObject2 = ((StringBuilder)localObject2).toString();
    new File((String)localObject1);
    new File((String)localObject2);
  }
  
  private boolean n()
  {
    if ((!this.jdField_l_of_type_Boolean) && (!this.jdField_m_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      u();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
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
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      setLeftViewName(2131692363);
      return;
    }
    String str = this.jdField_e_of_type_JavaLangString;
    if ((str != null) && (str.trim().length() != 0) && (this.jdField_g_of_type_Int != -1))
    {
      setLeftViewName(2131690817);
      return;
    }
    setLeftViewName(2131690529);
  }
  
  private boolean o()
  {
    if (this.jdField_m_of_type_Boolean)
    {
      t();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 0);
      localEditor.commit();
      if ((this.jdField_i_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return true;
    }
    return false;
  }
  
  private void p()
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
  
  private void q()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getString(2131692292);
    }
    setTitle(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidWidgetRadioGroup;
    if ((localObject != null) && (((RadioGroup)localObject).getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
    }
    u();
    if ((c()) && ((this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int == 5)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
      setLeftViewName(2131692577);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_e_of_type_Int != 1))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
      localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (b() == 8) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
      s();
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new FMActivity.3(this);
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    String str = this.jdField_e_of_type_JavaLangString;
    if ((str != null) && (str.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_e_of_type_JavaLangString);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131692579));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692577));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692579));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(21, getString(2131698185));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692587));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692581));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692578));
    }
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(4);
    }
    else
    {
      if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
      {
        int i1 = this.jdField_f_of_type_Int;
        if ((i1 >= 3) && (i1 <= 7))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(i1);
          break label241;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
    }
    label241:
    e(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    e(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    w();
    x();
    int i1 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
    if ((this.jdField_l_of_type_Boolean) && ((this.jdField_a_of_type_Int == 1) || (i1 == 1)))
    {
      i1 = this.jdField_f_of_type_Int;
      if ((i1 >= 8) && (i1 <= 14))
      {
        if (this.jdField_j_of_type_Int <= 0)
        {
          if ((i1 != 11) && (i1 != 9) && (i1 != 10) && (i1 != 8) && (i1 != 14) && (i1 != 5) && (i1 != 13) && (i1 != 12))
          {
            v();
            break label256;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_f_of_type_Int);
          break label256;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.k);
        break label256;
      }
    }
    if (7 != this.h)
    {
      if (this.jdField_j_of_type_Int <= 0) {
        v();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.k);
      }
    }
    else
    {
      i1 = this.k;
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(i1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
    label256:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private void v()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (!localArrayList.contains("all")))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(a((String)this.jdField_b_of_type_JavaUtilArrayList.get(0)));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(10);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
  }
  
  private void w()
  {
    if (f())
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370402));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_e_of_type_Int == -1))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
      g();
      return;
    }
    a(this);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_j_of_type_Int <= 0)
    {
      if (this.jdField_e_of_type_Int == 1)
      {
        y();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131692581));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692587));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692579));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131692578));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, getString(2131692586));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (a(8))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131692579));
      localArrayList.add(Integer.valueOf(10));
    }
    if (a(4))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131692587));
      localArrayList.add(Integer.valueOf(9));
    }
    if (a(2))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(13, getString(2131692589));
      localArrayList.add(Integer.valueOf(13));
    }
    if (a(1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131692584));
      localArrayList.add(Integer.valueOf(12));
    }
    if (localArrayList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
    }
  }
  
  private void y()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).contains("all")))
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(a(str), b(str));
      }
      this.jdField_f_of_type_Int = a((String)this.jdField_b_of_type_JavaUtilArrayList.get(0));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, a(2131692579));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, a(2131692581));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, a(2131692587));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(14, a(2131692586));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1)
    {
      localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.findViewById(2131370079);
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundColor(16777215);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.findViewById(2131380838);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
    }
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initFavTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    String str = this.jdField_e_of_type_JavaLangString;
    if ((str != null) && (str.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1200, getString(2131692581));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1201, getString(2131692587));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1202, getString(2131692579));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1203, getString(2131692578));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(1204, getString(2131692586));
    if (this.jdField_l_of_type_Boolean)
    {
      int i1 = this.jdField_f_of_type_Int;
      if ((i1 >= 1200) && (i1 <= 1204))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(i1);
        break label188;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(1200);
    label188:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800AFA7", "0X800AFA7", 0, 0, "", "", "", "");
  }
  
  public ListView a()
  {
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView != null) {
      return localQfileTabBarView.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    return getString(paramInt);
  }
  
  public String a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).jdField_a_of_type_JavaLangString;
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
    return (paramInt & this.jdField_j_of_type_Int) > 0;
  }
  
  public int[] a()
  {
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView == null) {
      return null;
    }
    return localQfileTabBarView.a();
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
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView == null)
    {
      super.d(paramInt);
      return;
    }
    localQfileTabBarView.setSortType(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.f();
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ev.getY(");
        ((StringBuilder)localObject).append(paramMotionEvent.getY());
        ((StringBuilder)localObject).append("),");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("y: ");
        localStringBuilder.append(this.jdField_b_of_type_Float);
        localStringBuilder.append(" ,ev.getX(");
        localStringBuilder.append(paramMotionEvent.getX());
        localStringBuilder.append("),x: ");
        localStringBuilder.append(this.jdField_a_of_type_Float);
        localStringBuilder.append("  ");
        localStringBuilder.append(paramMotionEvent.getY() - this.jdField_b_of_type_Float);
        localStringBuilder.append(",");
        localStringBuilder.append(Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float));
        QLog.e("@@@@@", 1, new Object[] { localObject, localStringBuilder.toString() });
        if ((paramMotionEvent.getY() - this.jdField_b_of_type_Float < -200.0F) && (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) < 200.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a(false);
        }
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9999)
    {
      if (paramIntent == null) {
        return;
      }
      if (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1)
      {
        setResult(paramInt2, new Intent(paramIntent));
        finish();
      }
    }
    if (paramInt2 == -1)
    {
      String str = this.jdField_e_of_type_JavaLangString;
      if ((str != null) && (str.trim().length() != 0))
      {
        if (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4)) {
          return;
        }
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openAIO(this, paramIntent);
        finish();
        return;
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    jdField_c_of_type_Long += 1L;
    this.jdField_d_of_type_Long = jdField_c_of_type_Long;
    FMDataCache.b();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tab_tab_type", -1);
    this.h = paramBundle.getIntExtra("busiType", -1);
    this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("uintype", -1);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("from_aio", false);
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("peerType", -1);
    this.n = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("mini_file_paths_support", -1);
    a(paramBundle);
    this.jdField_l_of_type_Int = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate type[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("],select[");
      localStringBuilder.append(c());
      localStringBuilder.append("]");
      QLog.d("FMActivity<FileAssistant>", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.jdField_f_of_type_JavaLangString);
    this.jdField_j_of_type_Int = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.jdField_j_of_type_Int & 0xF) == 0) {
      this.jdField_j_of_type_Int = 0;
    }
    b(paramBundle);
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == -1)) {
      f(true);
    }
    f(getResources().getDisplayMetrics().heightPixels);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370627));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374015));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FMActivity.2(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378305);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378304));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377064));
    e(0);
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == -1))
    {
      setLeftViewName(2131690529);
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
    }
    n();
    h(this.jdField_a_of_type_Int);
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).clearNewDownload();
    A();
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).initAppStoreSDK();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView;
    if (localObject != null) {
      ((VerifyPwdView)localObject).a();
    }
    if (this.jdField_d_of_type_Long == jdField_c_of_type_Long) {
      FMDataCache.b();
    }
    B();
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = new Intent("com.tencent.qlink.selectfileover");
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  protected void doOnPause()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent;
    if (localObject != null) {
      ((IBaseTabViewEvent)localObject).t();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.jdField_f_of_type_JavaLangString != null))
    {
      Object localObject = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopPhotoHandlerName();
      localObject = (ITroopPhotoHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver = new FMActivity.FMTroopBusinessObserver(this);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopObserver = new FMActivity.FMTroopObserver(this);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$FMTroopObserver);
      ((ITroopPhotoHandler)localObject).a(this.jdField_f_of_type_JavaLangString);
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if (c())
    {
      if (this.jdField_a_of_type_Int == 8) {
        return;
      }
      overridePendingTransition(2130771991, 2130771992);
    }
  }
  
  public int g()
  {
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView == null) {
      return super.g();
    }
    return localQfileTabBarView.b();
  }
  
  public int h()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public int i()
  {
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView == null) {
      return -1;
    }
    return localQfileTabBarView.a();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (a())
    {
      e();
      Object localObject;
      if ((paramView.getId() != 2131370402) && (paramView.getId() != 2131369202))
      {
        if (paramView.getId() == 2131377013)
        {
          localObject = new Intent(this, FMLocalFileActivity.class);
          ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
          ((Intent)localObject).putExtra(TeamWorkConstants.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_Boolean);
          ((Intent)localObject).putExtra(TeamWorkConstants.g, this.jdField_d_of_type_JavaLangString);
          ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
          ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
          ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
          a().ak();
          startActivityForResult((Intent)localObject, 20002);
        }
        else if (paramView.getId() == 2131378304)
        {
          int i1 = this.jdField_m_of_type_Int;
          if (i1 != 0)
          {
            int i2;
            if (i1 != 1)
            {
              if (i1 != 2) {
                break label597;
              }
              i1 = 17;
              i2 = 2;
            }
            else
            {
              i1 = 16;
              i2 = 1;
            }
            ReportController.b(null, "dc00898", "", "", "0X800AA90", "0X800AA90", i2, 0, "0", "0", "", "");
            localObject = new Bundle();
            ((Bundle)localObject).putString("qfile_search_param_ex_params_target_uin", a());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_peer_type", a());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_busi_type", b());
            ((Bundle)localObject).putString("qfile_search_param_exparams_send_uin", b());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_qlink_state", d());
            ((Bundle)localObject).putBoolean("qfile_search_param_exparams_qlink_ap_created", d());
            a((Bundle)localObject);
            ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startSeach(this, i1, (Bundle)localObject);
          }
        }
      }
      else
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(TeamWorkConstants.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_Boolean);
        ((Intent)localObject).putExtra(TeamWorkConstants.g, this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.jdField_i_of_type_Boolean);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
        a().ad();
        startActivityForResult((Intent)localObject, 20001);
        overridePendingTransition(2130772265, 2130772268);
      }
    }
    label597:
    EventCollector.getInstance().onViewClicked(paramView);
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
    IBaseTabViewEvent localIBaseTabViewEvent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent;
    if (localIBaseTabViewEvent != null)
    {
      localIBaseTabViewEvent.s();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
    }
  }
  
  protected void onResume()
  {
    if (FMDataCache.b() > 0L) {
      l();
    }
    IBaseTabViewEvent localIBaseTabViewEvent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent;
    if (localIBaseTabViewEvent != null) {
      localIBaseTabViewEvent.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */