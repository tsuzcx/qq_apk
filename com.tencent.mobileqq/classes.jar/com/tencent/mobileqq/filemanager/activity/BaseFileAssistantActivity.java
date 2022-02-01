package com.tencent.mobileqq.filemanager.activity;

import Override;
import agej;
import ajby;
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
import anzj;
import arqm;
import arqn;
import athe;
import athf;
import atmo;
import atpa;
import atur;
import atyw;
import aunj;
import auoi;
import auom;
import auon;
import beai;
import bmim;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  protected long a;
  private ajby jdField_a_of_type_Ajby;
  public RelativeLayout a;
  public TextView a;
  atpa jdField_a_of_type_Atpa = new athf(this);
  private auoi jdField_a_of_type_Auoi;
  private auom jdField_a_of_type_Auom;
  public QfileEditBottomBar a;
  public SendBottomBar a;
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
  public boolean j;
  boolean k = true;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "doc|.docx|.xls|.xlsx";
    this.jdField_d_of_type_Int = 20971520;
    this.jdField_b_of_type_Long = -1L;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = agej.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131377315));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131365819));
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372737));
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
  
  public ajby a()
  {
    return this.jdField_a_of_type_Ajby;
  }
  
  public auom a()
  {
    return this.jdField_a_of_type_Auom;
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
    super.setContentViewNoTitle(2131560898);
    ((RelativeLayout)findViewById(2131363326)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131377269));
    f();
    k();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(atmo paramatmo) {}
  
  public void a(auoi paramauoi)
  {
    k();
    this.jdField_a_of_type_Auoi = paramauoi;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramauoi);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramauoi);
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
  
  public boolean a()
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if ((paramInt2 == -1) && (paramInt1 == 109)) {
      this.jdField_a_of_type_Ajby.a(paramIntent);
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
    this.app.a().addObserver(this.jdField_a_of_type_Atpa);
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
      this.j = paramBundle.getBooleanExtra(beai.jdField_f_of_type_JavaLangString, false);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra(beai.jdField_g_of_type_JavaLangString);
      this.jdField_b_of_type_Long = paramBundle.getLongExtra("qrlogin_appid", -1L);
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isTroopFile", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("isOverSpace", false);
      paramBundle.putExtra("uintype", 0);
      this.jdField_a_of_type_Ajby = new ajby(this, 109);
      this.jdField_a_of_type_Ajby.a();
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
      atyw.a(1);
      paramBundle = arqn.a().c();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_e_of_type_JavaLangString = paramBundle;
      }
      long l2 = arqn.a().a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 20971520L;
      }
      this.jdField_a_of_type_Long = l1;
    }
    for (;;)
    {
      atyw.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label538;
      }
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext()) {
        atyw.a((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
      label522:
      i1 = 20;
      break label406;
      label528:
      atyw.a(this.jdField_b_of_type_Int);
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
    this.jdField_a_of_type_Ajby.b();
    if (this.jdField_a_of_type_Atpa != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.g();
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.h();
    }
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
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
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377126));
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
        this.app.a().f();
      }
      if (f()) {
        atyw.b();
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
  
  public void i()
  {
    if (f())
    {
      atyw.b();
      f(false);
      if (c())
      {
        setResult(5);
        finish();
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692081);
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
    if (this.jdField_a_of_type_Auoi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      this.jdField_a_of_type_Auoi.f();
    }
    atyw.b();
    f(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692065);
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
      this.rightViewText.setText(getString(2131692065));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new athe(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692081);
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
    if (this.jdField_a_of_type_Auom == null) {
      this.jdField_a_of_type_Auom = new auon();
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
    long l1 = atyw.b();
    if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (!aunj.a(this)) && (f()))
    {
      if (atyw.b() == 0L) {
        h();
      }
    }
    else {
      return;
    }
    setTitle(anzj.a(2131699915) + l1 + anzj.a(2131699914));
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
    super.setContentView(2131560898);
    ((RelativeLayout)findViewById(2131363326)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */