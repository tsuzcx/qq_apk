package com.tencent.mobileqq.filemanager.activity;

import actz;
import acua;
import acub;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.ImplDataReportHandle_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  protected long a;
  public RelativeLayout a;
  public TextView a;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acub(this);
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  private IReport_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  final String jdField_a_of_type_JavaLangString = "BaseFileAssistantActivity<FileAssistant>";
  protected ArrayList a;
  protected boolean a;
  protected int b;
  public String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  private int d;
  protected String d;
  protected boolean d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_f_of_type_Boolean = true;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void l()
  {
    i();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131368814));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131368756));
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
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368825));
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
    return this.jdField_d_of_type_Int;
  }
  
  public IReport_Ver51 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2130970042);
    ((RelativeLayout)findViewById(2131368823)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131368786));
    f();
    j();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramIClickListener_Ver51);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramIClickListener_Ver51);
  }
  
  public void a(ArrayList paramArrayList) {}
  
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
    return this.jdField_f_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void b()
  {
    f();
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void c()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void c(ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void d()
  {
    this.rightViewText.setVisibility(8);
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if (paramInt2 == 4)
    {
      if ((this.k) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
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
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    paramBundle = getIntent();
    d(paramBundle.getBooleanExtra("selectMode", c()));
    boolean bool;
    if (!c())
    {
      bool = true;
      c(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.k = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_e_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_g_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.jdField_f_of_type_Int = paramBundle.getIntExtra("sendprepare", -100);
      this.j = paramBundle.getBooleanExtra("apautocreate", false);
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("qlinkselect", false);
      this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("only_show_local_tab", false);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("max_select_count", -1);
      this.jdField_a_of_type_Long = paramBundle.getLongExtra("max_select_size", 0L);
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("send_btn_custom_text");
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("custom_title");
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("approval_attachment_customid", 0);
      if (-1 == this.jdField_b_of_type_Int) {
        if (!this.jdField_c_of_type_Boolean) {
          break label341;
        }
      }
    }
    label341:
    for (int m = 50;; m = 20)
    {
      this.jdField_b_of_type_Int = m;
      FMDataCache.a(this.jdField_b_of_type_Int);
      FMDataCache.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label347;
      }
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext()) {
        FMDataCache.a((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
    }
    label347:
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
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
    this.jdField_f_of_type_Boolean = true;
    k();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e()
  {
    this.jdField_f_of_type_Boolean = false;
    new Handler().postDelayed(new actz(this), 1500L);
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368824));
      g();
    }
    l();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      d();
    }
    m();
    n();
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setCheckAll(paramBoolean);
  }
  
  public boolean f()
  {
    return (c()) || (e());
  }
  
  public void finish()
  {
    super.finish();
    if (this.k)
    {
      if (b() == 1) {
        this.app.a().f();
      }
      if (f()) {
        FMDataCache.b();
      }
    }
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
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void i()
  {
    if (f())
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(getString(2131428127));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new acua(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131428089);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 = new ImplDataReportHandle_Ver51();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    long l = FMDataCache.a();
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (f()))
    {
      if (FMDataCache.a() == 0L) {
        h();
      }
    }
    else {
      return;
    }
    setTitle("已选" + l + "个");
  }
  
  public void onClick(View paramView) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130970042);
    ((RelativeLayout)findViewById(2131368823)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    f();
    j();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", c());
    paramIntent.putExtra("enableDelete", b());
    paramIntent.putExtra("targetUin", this.jdField_e_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_d_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_e_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_g_of_type_Int);
    paramIntent.putExtra("sendprepare", this.jdField_f_of_type_Int);
    paramIntent.putExtra("apautocreate", this.j);
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