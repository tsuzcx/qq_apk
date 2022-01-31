package com.tencent.mobileqq.filemanager.activity;

import actn;
import afck;
import ajyc;
import anca;
import ancb;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aono;
import aonp;
import aory;
import aouj;
import aozc;
import apeh;
import apue;
import apvd;
import apvh;
import apvi;
import ayeb;
import bgmt;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
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
  private afck jdField_a_of_type_Afck;
  public RelativeLayout a;
  public TextView a;
  aouj jdField_a_of_type_Aouj = new aonp(this);
  private apvd jdField_a_of_type_Apvd;
  private apvh jdField_a_of_type_Apvh;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  final String jdField_a_of_type_JavaLangString = "BaseFileAssistantActivity<FileAssistant>";
  protected ArrayList<FileInfo> a;
  protected boolean a;
  protected int b;
  public long b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  public int d;
  protected String d;
  public boolean d;
  private int e;
  public String e;
  protected boolean e;
  private int f;
  public String f;
  public boolean f;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  protected boolean g;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  public boolean h;
  private int jdField_i_of_type_Int;
  boolean jdField_i_of_type_Boolean = true;
  private boolean j = true;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "doc|.docx|.xls|.xlsx";
    this.jdField_d_of_type_Int = 20971520;
    this.jdField_b_of_type_Long = -1L;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = actn.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131375831));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131365456));
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371718));
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
  
  public afck a()
  {
    return this.jdField_a_of_type_Afck;
  }
  
  public apvh a()
  {
    return this.jdField_a_of_type_Apvh;
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
    return this.jdField_g_of_type_JavaLangString;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2131560474);
    ((RelativeLayout)findViewById(2131363079)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131375791));
    f();
    k();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(aory paramaory) {}
  
  public void a(apvd paramapvd)
  {
    k();
    this.jdField_a_of_type_Apvd = paramapvd;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramapvd);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramapvd);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a()
  {
    return this.jdField_i_of_type_Boolean;
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
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void b()
  {
    f();
  }
  
  public void b(int paramInt) {}
  
  public void b(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.j;
  }
  
  public int c()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void c()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public int d()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void d()
  {
    this.rightViewText.setVisibility(8);
  }
  
  protected void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if ((paramInt2 == -1) && (paramInt1 == 109)) {
      this.jdField_a_of_type_Afck.a(paramIntent);
    }
    if (paramInt2 == 4)
    {
      if ((this.n) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
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
    this.app.a().addObserver(this.jdField_a_of_type_Aouj);
    paramBundle = getIntent();
    d(paramBundle.getBooleanExtra("selectMode", c()));
    boolean bool;
    int i1;
    if (!c())
    {
      bool = true;
      c(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_g_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_e_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.n = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_f_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_h_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.jdField_g_of_type_Int = paramBundle.getIntExtra("sendprepare", -100);
      this.m = paramBundle.getBooleanExtra("apautocreate", false);
      this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("qlinkselect", false);
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("only_show_local_tab", false);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("max_select_count", -1);
      this.jdField_a_of_type_Long = paramBundle.getLongExtra("max_select_size", 0L);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("send_btn_custom_text");
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("custom_title");
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("approval_attachment_customid", 0);
      this.jdField_g_of_type_Boolean = paramBundle.getBooleanExtra("select_file_support_send_docs_file", false);
      this.jdField_h_of_type_Boolean = paramBundle.getBooleanExtra(ayeb.jdField_f_of_type_JavaLangString, false);
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra(ayeb.jdField_g_of_type_JavaLangString);
      this.jdField_b_of_type_Long = paramBundle.getLongExtra("qrlogin_appid", -1L);
      paramBundle.putExtra("uintype", 0);
      this.jdField_a_of_type_Afck = new afck(this, 109);
      this.jdField_a_of_type_Afck.a();
      if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
        j(true);
      }
      if (-1 == this.jdField_b_of_type_Int)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label498;
        }
        i1 = 100;
        label382:
        this.jdField_b_of_type_Int = i1;
      }
      if (!this.jdField_h_of_type_Boolean) {
        break label504;
      }
      apeh.a(1);
      paramBundle = ancb.a().c();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_f_of_type_JavaLangString = paramBundle;
      }
      long l2 = ancb.a().a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 20971520L;
      }
      this.jdField_a_of_type_Long = l1;
    }
    for (;;)
    {
      apeh.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label514;
      }
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext()) {
        apeh.a((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
      label498:
      i1 = 20;
      break label382;
      label504:
      apeh.a(this.jdField_b_of_type_Int);
    }
    label514:
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
    this.jdField_a_of_type_Afck.b();
    if (this.jdField_a_of_type_Aouj != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aouj);
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
    this.jdField_i_of_type_Boolean = true;
    l();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
  {
    this.jdField_i_of_type_Boolean = false;
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
    return this.l;
  }
  
  public int f()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375668));
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
    this.l = paramBoolean;
  }
  
  public boolean f()
  {
    return (c()) || (e());
  }
  
  public void finish()
  {
    super.finish();
    if (this.n)
    {
      if (b() == 1) {
        this.app.a().f();
      }
      if (f()) {
        apeh.b();
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
    return (this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean);
  }
  
  public void h()
  {
    setTitle(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Int == 1) && (!f())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      QLog.i("BaseFileAssistantActivity<FileAssistant>", 1, "biz not support docs send!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(paramBoolean);
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void i()
  {
    if (f())
    {
      apeh.b();
      f(false);
      if (c())
      {
        setResult(5);
        finish();
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692414);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      setTitle(this.jdField_b_of_type_JavaLangString);
      b();
      a();
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      b(false);
      return;
    }
    if (this.jdField_a_of_type_Apvd != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      this.jdField_a_of_type_Apvd.g();
    }
    apeh.b();
    f(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692399);
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
      this.rightViewText.setText(getString(2131692399));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new aono(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131692414);
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
    if (this.jdField_a_of_type_Apvh == null) {
      this.jdField_a_of_type_Apvh = new apvi();
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
    long l1 = apeh.b();
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (!apue.a(this)) && (f()))
    {
      if (apeh.b() == 0L) {
        h();
      }
    }
    else {
      return;
    }
    setTitle(ajyc.a(2131700992) + l1 + ajyc.a(2131700991));
  }
  
  public void onClick(View paramView) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131560474);
    ((RelativeLayout)findViewById(2131363079)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    f();
    k();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", c());
    paramIntent.putExtra("enableDelete", b());
    paramIntent.putExtra("targetUin", this.jdField_g_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_h_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_e_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_f_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_h_of_type_Int);
    paramIntent.putExtra("sendprepare", this.jdField_g_of_type_Int);
    paramIntent.putExtra("apautocreate", this.m);
    paramIntent.putExtra("qlinkselect", this.jdField_c_of_type_Boolean);
    paramIntent.putExtra("max_select_size", this.jdField_a_of_type_Long);
    paramIntent.putExtra("max_select_count", this.jdField_b_of_type_Int);
    paramIntent.putExtra("send_btn_custom_text", this.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("custom_title", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */