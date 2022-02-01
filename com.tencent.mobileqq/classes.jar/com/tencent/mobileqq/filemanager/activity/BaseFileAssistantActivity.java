package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.ImplDataReportHandleVer51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected long a;
  public RelativeLayout a;
  public TextView a;
  private SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new BaseFileAssistantActivity.3(this);
  private IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51;
  private IReportVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReportVer51;
  protected QfileEditBottomBar a;
  protected SendBottomBar a;
  protected String a;
  protected ArrayList<FileInfo> a;
  public boolean a;
  protected int b;
  public long b;
  protected String b;
  public boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  public int d;
  public String d;
  protected boolean d;
  private int e;
  public String e;
  protected boolean e;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  protected boolean g;
  private int h;
  public boolean h;
  private int i;
  protected boolean i;
  public boolean j = false;
  boolean k = true;
  private boolean l = true;
  private boolean m = false;
  private boolean n = false;
  private boolean o;
  private boolean p;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "doc|.docx|.xls|.xlsx";
    this.jdField_d_of_type_Int = 20971520;
    this.jdField_i_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void m()
  {
    j();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131377760));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131366114));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (c())
    {
      g();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    while (!e()) {
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373225));
    }
    if ((c()) || (e())) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      b(f());
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public SeparateForward a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  }
  
  public IReportVer51 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReportVer51;
  }
  
  public SendBottomBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar;
  }
  
  public ListView a()
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2131560929);
    ((RelativeLayout)findViewById(2131363510)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131377713));
    f();
    k();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent) {}
  
  public void a(IClickListenerVer51 paramIClickListenerVer51)
  {
    k();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = paramIClickListenerVer51;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramIClickListenerVer51);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramIClickListenerVer51);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void a(Set<FileInfo> paramSet) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      startTitleProgress();
      return;
    }
    stopTitleProgress();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  protected boolean a()
  {
    return this.k;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public void b()
  {
    f();
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.l;
  }
  
  public int c()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void c(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean c()
  {
    return this.m;
  }
  
  public int d()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void d()
  {
    this.rightViewText.setVisibility(8);
  }
  
  public void d(int paramInt) {}
  
  protected void d(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean d()
  {
    return this.o;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if ((paramInt2 == -1) && (paramInt1 == 109)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramIntent);
    }
    if (paramInt2 == 4)
    {
      if ((this.p) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        a(paramIntent.getExtras());
      }
      setResult(4, paramIntent);
      finish();
    }
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 != 103) && (paramInt1 != 12289))
      {
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramInt2 == 5)
      {
        setResult(5, null);
        finish();
        return;
      }
    } while (paramInt2 != 10);
    setResult(10, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    paramBundle = getIntent();
    d(paramBundle.getBooleanExtra("selectMode", c()));
    boolean bool;
    int i1;
    if (!c())
    {
      bool = true;
      c(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_g_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_e_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.p = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_f_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_h_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.jdField_g_of_type_Int = paramBundle.getIntExtra("sendprepare", -100);
      this.o = paramBundle.getBooleanExtra("apautocreate", false);
      this.jdField_h_of_type_Boolean = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("qlinkselect", false);
      this.jdField_g_of_type_Boolean = paramBundle.getBooleanExtra("only_show_local_tab", false);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("max_select_count", -1);
      this.jdField_a_of_type_Long = paramBundle.getLongExtra("max_select_size", 0L);
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("send_btn_custom_text");
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("custom_title");
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("approval_attachment_customid", 0);
      this.jdField_i_of_type_Boolean = paramBundle.getBooleanExtra("select_file_support_send_docs_file", false);
      this.j = paramBundle.getBooleanExtra(TeamWorkConstants.jdField_f_of_type_JavaLangString, false);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra(TeamWorkConstants.jdField_g_of_type_JavaLangString);
      this.jdField_b_of_type_Long = paramBundle.getLongExtra("qrlogin_appid", -1L);
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isTroopFile", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("isOverSpace", false);
      paramBundle.putExtra("uintype", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(this, 109);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
      if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
        j(true);
      }
      if (-1 == this.jdField_b_of_type_Int)
      {
        if (!this.jdField_e_of_type_Boolean) {
          break label522;
        }
        i1 = 100;
        label406:
        this.jdField_b_of_type_Int = i1;
      }
      if (!this.j) {
        break label528;
      }
      FMDataCache.a(1);
      paramBundle = TencentDocImportFileInfoProcessor.a().c();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_e_of_type_JavaLangString = paramBundle;
      }
      long l2 = TencentDocImportFileInfoProcessor.a().a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 20971520L;
      }
      this.jdField_a_of_type_Long = l1;
    }
    for (;;)
    {
      FMDataCache.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label538;
      }
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext()) {
        FMDataCache.a((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
      label522:
      i1 = 20;
      break label406;
      label528:
      FMDataCache.a(this.jdField_b_of_type_Int);
    }
    label538:
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnCreate ");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnDestroy ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.c();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    this.k = true;
    l();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.i();
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void e()
  {
    this.k = false;
    new Handler().postDelayed(new BaseFileAssistantActivity.1(this), 1500L);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectAllOrCancelAll(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return this.n;
  }
  
  public int f()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377570));
      g();
    }
    m();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      d();
    }
    n();
    o();
  }
  
  public void f(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean f()
  {
    return (c()) || (e());
  }
  
  public void finish()
  {
    super.finish();
    if (this.p)
    {
      if (b() == 1) {
        this.app.getQQProxyForQlink().f();
      }
      if (f()) {
        FMDataCache.b();
      }
    }
  }
  
  public int g()
  {
    return -1;
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setCheckAllEnable(paramBoolean);
  }
  
  public boolean g()
  {
    return (this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean);
  }
  
  public void h()
  {
    setTitle(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Int == 1) && (!f())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      QLog.i("BaseFileAssistantActivity<FileAssistant>", 1, "biz not support docs send!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(paramBoolean);
  }
  
  public boolean h()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected void i()
  {
    if (f())
    {
      FMDataCache.b();
      f(false);
      if (c())
      {
        setResult(5);
        finish();
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692351);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      setTitle(this.jdField_a_of_type_JavaLangString);
      b();
      a();
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      b(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51.f();
    }
    FMDataCache.b();
    f(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692335);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    b();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    b(true);
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_Int |= 0x1;
      return;
    }
    this.jdField_i_of_type_Int &= 0xFFFFFFFE;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
  }
  
  public void j()
  {
    if (f())
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(getString(2131692335));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new BaseFileAssistantActivity.2(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692351);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_Int |= 0x2;
      return;
    }
    this.jdField_i_of_type_Int &= 0xFFFFFFFD;
  }
  
  public boolean j()
  {
    return (this.jdField_i_of_type_Int & 0x2) == 2;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReportVer51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReportVer51 = new ImplDataReportHandleVer51();
    }
  }
  
  public boolean k()
  {
    return (this.jdField_i_of_type_Int & 0x1) == 1;
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    long l1 = FMDataCache.b();
    if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (!FileManagerUtil.a(this)) && (f()))
    {
      if (FMDataCache.b() == 0L) {
        h();
      }
    }
    else {
      return;
    }
    setTitle(HardCodeUtil.a(2131701079) + l1 + HardCodeUtil.a(2131701078));
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131560929);
    ((RelativeLayout)findViewById(2131363510)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    f();
    k();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", c());
    paramIntent.putExtra("enableDelete", b());
    paramIntent.putExtra("targetUin", this.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_g_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_e_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_f_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_h_of_type_Int);
    paramIntent.putExtra("sendprepare", this.jdField_g_of_type_Int);
    paramIntent.putExtra("apautocreate", this.o);
    paramIntent.putExtra("qlinkselect", this.jdField_e_of_type_Boolean);
    paramIntent.putExtra("max_select_size", this.jdField_a_of_type_Long);
    paramIntent.putExtra("max_select_count", this.jdField_b_of_type_Int);
    paramIntent.putExtra("send_btn_custom_text", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("custom_title", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */