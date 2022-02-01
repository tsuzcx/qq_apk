package com.tencent.mobileqq.filemanager.activity.fileassistant;

import Override;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import arie;
import arif;
import arnf;
import arng;
import aroc;
import arod;
import arzq;
import atcv;
import atcw;
import atcx;
import atcy;
import atcz;
import atda;
import atdb;
import atdc;
import atfq;
import athn;
import atix;
import atlh;
import audr;
import audy;
import audz;
import auea;
import ayqy;
import bbbq;
import bdla;
import becr;
import bhhr;
import bivu;
import bleh;
import blek;
import blyb;
import blzq;
import bmni;
import bmrn;
import bmrp;
import bmsd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements bivu
{
  public Handler a;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  arie jdField_a_of_type_Arie;
  private ayqy jdField_a_of_type_Ayqy = new atdc(this);
  public bleh a;
  private bmni jdField_a_of_type_Bmni;
  private bmrp jdField_a_of_type_Bmrp;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  public QfileTabBarView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131692454, 2131698061, 2131720078, 2131719313 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private atfq jdField_b_of_type_Atfq = new atda(this);
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130844275, 2130844276, 2130844281, 2130844325 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  public BusinessInfoCheckUpdate.AppInfo c;
  TextView d;
  TextView e;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = anvx.a(2131703962);
  public boolean l = false;
  boolean m = false;
  private volatile boolean n;
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidOsHandler = new atdb(this, Looper.getMainLooper());
  }
  
  private void A()
  {
    this.n = false;
    if (this.app.getFileManagerEngine().a() == true)
    {
      this.app.getFileManagerEngine().c();
      return;
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    audr.a(BaseApplication.getContext().getString(2131694253));
  }
  
  private void B()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    C();
    E();
    D();
  }
  
  private void C()
  {
    bbbq localbbbq;
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localbbbq != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localbbbq.b(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void D()
  {
    bbbq localbbbq;
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localbbbq != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localbbbq.b(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void E()
  {
    bbbq localbbbq;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localbbbq != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localbbbq.b(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (paramAppInfo == null)
    {
      localbbbq.b(paramString);
      return;
    }
    localbbbq.a(paramAppInfo, null);
  }
  
  private void n()
  {
    this.e = ((TextView)findViewById(2131369057));
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.e).b(53).d(10).a();
    this.e.setOnClickListener(this);
    bdla.b(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    aroc localaroc = arod.a();
    if (localaroc != null)
    {
      this.e.setText(localaroc.jdField_a_of_type_JavaLangString);
      this.d.setText(localaroc.b);
      this.jdField_f_of_type_JavaLangString = localaroc.c;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Bmni = new bmni(this, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView, 1);
    this.jdField_a_of_type_Bmni.a();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_Arie == null) || (!this.jdField_a_of_type_Arie.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Arie.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131366342));
    this.jdField_b_of_type_AndroidViewViewStub.inflate();
    TextView localTextView1 = (TextView)findViewById(2131380207);
    TextView localTextView2 = (TextView)findViewById(2131380208);
    ImageView localImageView = (ImageView)findViewById(2131369570);
    localTextView1.setText(this.jdField_a_of_type_Arie.a());
    localTextView2.setText(this.jdField_a_of_type_Arie.b());
    localTextView2.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_Arie.a();
  }
  
  private void r()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_b_of_type_AndroidViewViewStub.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new atcv(this));
    localValueAnimator.addListener(new atcw(this));
    localValueAnimator.start();
  }
  
  private void s()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2131720078) {}
      blek localblek = new blek();
      localblek.jdField_a_of_type_Int = i;
      localblek.jdField_a_of_type_JavaLangString = getString(this.jdField_a_of_type_ArrayOfInt[i]);
      localblek.c = localblek.jdField_a_of_type_JavaLangString;
      if (i == 3)
      {
        aroc localaroc = arod.a();
        if ((localaroc != null) && (!TextUtils.isEmpty(localaroc.d)))
        {
          localblek.jdField_a_of_type_JavaLangString = localaroc.d;
          localblek.c = localaroc.d;
        }
      }
      localblek.b = this.jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localblek);
      i += 1;
    }
    this.jdField_a_of_type_Bleh = bleh.a(this, localArrayList, new atcx(this), null, AIOUtils.dp2px(210.0F, getResources()));
    this.jdField_a_of_type_Bleh.setTouchInterceptor(new atcy(this));
  }
  
  private void t()
  {
    this.app.getQQProxyForQlink().a("0X800474E", 1);
    blyb.a(this, 2, null);
  }
  
  private void u()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 1);
    localIntent.putExtra("qfile_entrance_type_key", 8);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 15);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("from", "FileAssistant");
      localIntent.putExtra("custom_title", getString(2131692230));
      startActivityForResult(localIntent, 101);
      if (this.l)
      {
        audy.a("0X8005538");
        return;
      }
      audy.a("0X800681E");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void v()
  {
    FileSearchActivity.a(this, "", new ArrayList(), false, 8);
  }
  
  private void w()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(arng.a().h())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = arng.a().h())
      {
        String str2 = becr.b(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.m)
        {
          str2 = becr.b(str1, "s_qq_myfile_banner");
          localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
          this.m = false;
        }
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        if (TeamWorkDocEditBrowserActivity.a(this, str2, localIntent.getStringExtra("tdsourcetag"))) {
          break;
        }
        startActivity(localIntent.putExtra("url", str2));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("FileAssistantActivity", 1, localException.toString());
    }
  }
  
  private void x()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_Bmrp = new bmrp();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Bmrp);
    bmrn.a(this.app.getApplication());
  }
  
  private void z()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    }
    return null;
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramSet);
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
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      bmsd.a(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    setContentView(2131560808);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)findViewById(2131368164));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369121));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369129));
    this.d = ((TextView)findViewById(2131369198));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.d).b(53).d(10).a();
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369058));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131378485).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131376760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692298));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130844221);; paramBundle = getResources().getDrawable(2130844221))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(anvx.a(2131703964));
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).b(53).d(5).e(10).a();
      o();
      p();
      m();
      this.app.getFileManagerNotifyCenter().addObserver(this.jdField_b_of_type_Atfq);
      y();
      B();
      this.app.registObserver(this.jdField_a_of_type_Ayqy);
      if (bhhr.aS(this, this.app.getCurrentAccountUin()) == 1)
      {
        MiniAppController.preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.l = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new audz();
      paramBundle.b = "file_asst_in";
      paramBundle.jdField_a_of_type_Int = 11;
      audy.a(this.app.getCurrentAccountUin(), paramBundle);
      if (auea.a(this, getString(2131692233))) {
        break label551;
      }
      paramBundle = new int[this.jdField_a_of_type_ArrayOfInt.length + 1];
      arrayOfInt = new int[this.jdField_b_of_type_ArrayOfInt.length + 1];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramBundle[i] = this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
      }
    }
    paramBundle[(paramBundle.length - 1)] = 2131692276;
    this.jdField_a_of_type_ArrayOfInt = paramBundle;
    int i = j;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      arrayOfInt[i] = this.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130844277;
    this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
    label551:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    if (this.jdField_b_of_type_Atfq != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_b_of_type_Atfq);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Ayqy);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.n = true;
    this.jdField_a_of_type_Bmrp.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692298));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691061);
    B();
    b();
  }
  
  public void j()
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if (f()) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690697);
      }
    }
    else {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691061);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366758));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692492));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692494));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692498));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692495));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692493));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131369058)
    {
      i();
      if (f())
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690697);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692298));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      audy.a("0X8009C32");
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691061);
      break;
      if (i == 2131369121)
      {
        if (!CheckPermission.isHasStoragePermission(this)) {
          CheckPermission.requestSDCardPermission(this, new atcz(this));
        } else {
          u();
        }
      }
      else
      {
        Object localObject1;
        if (i == 2131369129)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("string_from", false);
          ((Bundle)localObject1).putBoolean("string_uin", false);
          ((Bundle)localObject1).putLong("device_din", 0L);
          ((Bundle)localObject1).putInt("sTitleID", 0);
          blzq.a(this, (Bundle)localObject1, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.l) {
            audy.a("0X8005539");
          } else {
            audy.a("0X800681F");
          }
        }
        else
        {
          if (i == 2131369198)
          {
            i = bhhr.aS(this, this.app.getCurrentAccountUin());
            if (i == 1)
            {
              localObject1 = bhhr.t(this, this.app.getCurrentAccountUin());
              i = bhhr.aT(this, this.app.getCurrentAccountUin());
              if (TextUtils.isEmpty((CharSequence)localObject1)) {}
            }
            for (;;)
            {
              try
              {
                a(this, (String)localObject1, i);
                if (!this.l) {
                  break label398;
                }
                audy.a("0X800553A");
                a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100164");
              }
              catch (MiniAppException localMiniAppException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("FileAssistantActivity", 2, "fail to open weiyun mini app!");
                }
                A();
                continue;
              }
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + localMiniAppException + ", version = " + i);
              A();
              continue;
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
              A();
              continue;
              label398:
              audy.a("0X8006820");
            }
          }
          if (i == 2131369057)
          {
            audy.a("0X8009070");
            w();
            arzq.a(getAppInterface());
            a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100163");
          }
          else if (i == 2131369570)
          {
            this.jdField_a_of_type_Arie.b();
            r();
          }
          else if (i == 2131380208)
          {
            this.jdField_a_of_type_Arie.c();
            Object localObject2 = (atix)this.app.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
            if (localObject2 != null)
            {
              localObject2 = ((atix)localObject2).a().a();
              if (localObject2 != null) {
                ((arif)localObject2).a(this);
              }
              r();
            }
          }
          else if (i == 2131378485)
          {
            audy.a("0X8009C33");
            v();
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      if (this.jdField_a_of_type_Bleh == null) {
        s();
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_Bleh.getWidth();
      int j = getResources().getDimensionPixelSize(2131298807);
      this.jdField_a_of_type_Bleh.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - j, 0);
      bdla.b(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        i();
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692298));
        return;
      }
    } while (paramInt != 1);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */