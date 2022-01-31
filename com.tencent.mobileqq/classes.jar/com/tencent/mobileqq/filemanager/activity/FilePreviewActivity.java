package com.tencent.mobileqq.filemanager.activity;

import actn;
import anbk;
import anbl;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aony;
import aonz;
import aooa;
import aood;
import aooe;
import aoof;
import aoog;
import aooh;
import aooi;
import aooj;
import aook;
import aool;
import aoza;
import aozs;
import apee;
import apef;
import apep;
import apuc;
import apud;
import apue;
import apuz;
import apvb;
import apvv;
import apxc;
import axqw;
import ayfb;
import bcpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  public int a;
  long jdField_a_of_type_Long = -1L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  aool jdField_a_of_type_Aool = null;
  aozs jdField_a_of_type_Aozs = null;
  public apep a;
  apuz jdField_a_of_type_Apuz = null;
  public apxc a;
  private ayfb jdField_a_of_type_Ayfb = new aony(this);
  private bcpq jdField_a_of_type_Bcpq;
  public FileWebView a;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  final String jdField_a_of_type_JavaLangString = "<FileAssistant>FilePreviewActivity";
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  public LinearLayout b;
  public TextView b;
  apuz jdField_b_of_type_Apuz = null;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  public TextView c;
  apuz jdField_c_of_type_Apuz;
  public String c;
  public boolean c;
  public String d;
  boolean d;
  String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k = null;
  String l = null;
  
  public FilePreviewActivity()
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Apep = null;
    this.jdField_a_of_type_Apxc = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    View localView2 = ((ViewStub)findViewById(2131364763)).inflate();
    localView2.setPadding(0, 0, 70, 120);
    View localView1 = localView2.findViewById(2131378373);
    localView2 = localView2.findViewById(2131378374);
    this.app.addObserver(this.jdField_a_of_type_Ayfb);
    if (!paramBoolean1)
    {
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
      label75:
      if (paramBoolean2) {
        break label164;
      }
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((localView1 != null) && (paramBoolean1)) {
        localView1.setOnClickListener(new aoof(this));
      }
      if ((localView2 == null) || (!paramBoolean2)) {
        break;
      }
      localView2.setOnClickListener(new aoog(this));
      return;
      axqw.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      break label75;
      label164:
      axqw.b(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.jdField_a_of_type_Int == -1) {
      return false;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("OfflinePreZipPath");
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    Object localObject = apee.a(this, this.jdField_c_of_type_JavaLangString, "FileType");
    this.j = apee.a(this, this.jdField_c_of_type_JavaLangString, "InterfacePage");
    String str = apee.a(this, this.jdField_c_of_type_JavaLangString, "PreviewMode");
    this.h = paramIntent.getStringExtra("offline_file_domain");
    this.i = paramIntent.getStringExtra("offline_file_port");
    this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_domain_key");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("offline_file_type_key", -1);
    this.g = paramIntent.getStringExtra("COOKIE");
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("offline_file_show_team_work_menu", false);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d = 3;
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.jdField_b_of_type_Int = Integer.parseInt((String)localObject);
    }
    if ((str != null) && (str.length() > 0)) {
      this.jdField_c_of_type_Int = Integer.parseInt(str);
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("offline_file_bZip", false);
      if (!a()) {
        break label351;
      }
      setContentViewForImage(2131560486);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131375492);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
    for (;;)
    {
      a();
      if (this.jdField_a_of_type_Int != 0) {
        break label437;
      }
      this.jdField_a_of_type_Aozs = this.app.a().a();
      if (this.jdField_a_of_type_Aozs != null) {
        break label361;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.jdField_a_of_type_Boolean = apue.a(this.jdField_c_of_type_Int);
      break;
      label351:
      setContentView(2131560486);
    }
    label361:
    this.l = String.valueOf(this.jdField_a_of_type_Aozs.a());
    if (this.jdField_a_of_type_Aool == null) {
      h();
    }
    this.jdField_a_of_type_Aozs.a(this.jdField_a_of_type_Aool);
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("offline_file_size", 0L);
    startTitleProgress();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = true;
    }
    for (;;)
    {
      return true;
      label437:
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      this.leftView.setText(2131690331);
      if (this.jdField_b_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.jdField_b_of_type_JavaLangString);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.jdField_b_of_type_JavaLangString + ")");
      this.k = paramIntent.getStringExtra("OfflinePreZipUUID");
      break;
      paramIntent = apee.a(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
      if (paramIntent == null) {
        return true;
      }
      if (Integer.parseInt(paramIntent) == 0) {
        return true;
      }
      setRequestedOrientation(-1);
    }
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Apep = new apep(this.app.getCurrentAccountUin());
    apep localapep1 = this.jdField_a_of_type_Apep;
    apep localapep2 = this.jdField_a_of_type_Apep;
    long l1 = System.currentTimeMillis();
    localapep2.jdField_a_of_type_Long = l1;
    localapep1.jdField_e_of_type_Long = l1;
    this.jdField_a_of_type_Apep.k = String.valueOf(this.l);
    this.jdField_a_of_type_Apep.l = "1";
    this.jdField_a_of_type_Apep.h = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Apep.j = apvb.a(this.jdField_c_of_type_JavaLangString).replace(".", "").toLowerCase();
    this.jdField_a_of_type_Apep.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    return this.jdField_a_of_type_Aozs.a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aooh(this);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_Aool = new aooi(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379382));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", "qfile");
    QbSdk.initTbsSettings((Map)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = new FileWebView(getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
    localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int m = ((DisplayMetrics)localObject).widthPixels;
    int n = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = n;
    ((RelativeLayout.LayoutParams)localObject).width = m;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(new aooj(this));
    localObject = new Handler();
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new aook(this, (Handler)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new WebChromeClient());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      if (this.jdField_a_of_type_Boolean) {
        ((WebSettings)localObject).setCacheMode(2);
      }
      ((WebSettings)localObject).setBuiltInZoomControls(true);
      ((WebSettings)localObject).setSupportZoom(true);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      if (Build.VERSION.SDK_INT < 16)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
        FileWebView.enablePlatformNotifications();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new aonz(this));
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.15(this, paramInt));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Apep != null) {
      this.jdField_a_of_type_Apep.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Apep != null)
      {
        this.jdField_a_of_type_Apep.jdField_c_of_type_Long = (this.jdField_a_of_type_Apep.f - this.jdField_a_of_type_Apep.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apep.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Apep.i = "";
        this.jdField_a_of_type_Apep.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apep.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apep.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFnish suc[" + paramBoolean + "] retCode[" + paramLong + "]");
        paramLong = System.currentTimeMillis();
        long l1 = this.jdField_b_of_type_Long;
        paramString = new apud();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_first";
        paramString.jdField_b_of_type_Long = (paramLong - l1);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = apvb.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        apuc.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Apep != null)
      {
        this.jdField_a_of_type_Apep.jdField_c_of_type_Long = (this.jdField_a_of_type_Apep.f - this.jdField_a_of_type_Apep.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apep.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Apep.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_Apep.i = paramString;
        this.jdField_a_of_type_Apep.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apep.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apep.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        str = getString(2131692569);
      }
      paramString = str + getString(2131692567);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  boolean a()
  {
    return (this.jdField_c_of_type_Int != apef.jdField_b_of_type_Int) && (!apue.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Apep != null) {
      this.jdField_a_of_type_Apep.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Apep != null)
      {
        this.jdField_a_of_type_Apep.jdField_c_of_type_Long = (this.jdField_a_of_type_Apep.f - this.jdField_a_of_type_Apep.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apep.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Apep.i = "";
        this.jdField_a_of_type_Apep.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apep.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apep.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      a(1000);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call reportGetmoreTimeV2[" + paramBoolean + "],retCode[" + paramLong + "]");
        stopTitleProgress();
        setTitle(BaseApplicationImpl.getContext().getString(2131692857));
        paramLong = System.currentTimeMillis();
        long l1 = this.jdField_b_of_type_Long;
        paramString = new apud();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_more";
        paramString.jdField_b_of_type_Long = (paramLong - l1);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = apvb.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        apuc.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Apep != null)
      {
        this.jdField_a_of_type_Apep.jdField_c_of_type_Long = (this.jdField_a_of_type_Apep.f - this.jdField_a_of_type_Apep.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apep.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Apep.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_Apep.i = paramString;
        this.jdField_a_of_type_Apep.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apep.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apep.a();
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131693973);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      a(5000);
    }
  }
  
  public void c()
  {
    runOnUiThread(new FilePreviewActivity.12(this));
  }
  
  public void d()
  {
    runOnUiThread(new FilePreviewActivity.13(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          Bundle localBundle = paramIntent.getExtras();
          Intent localIntent = actn.a(new Intent(this, SplashActivity.class), null);
          localIntent.putExtras(new Bundle(localBundle));
          startActivity(localIntent);
        }
        setResult(4, paramIntent);
      }
    }
    else {
      return;
    }
    setResult(0, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (!a(paramBundle))
    {
      finish();
      return false;
    }
    setRightButton(2131690832, new aood(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375327));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367049));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371228));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    Object localObject = anbl.a();
    boolean bool1 = ((anbk)localObject).a();
    boolean bool2 = ((anbk)localObject).b();
    if ((bool2) || (!apvv.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
    {
      a(bool1, bool2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365725));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375199));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131367050));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367048));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375210));
      setTitle(BaseApplicationImpl.getContext().getString(2131692857));
      if (this.jdField_a_of_type_Int != 0) {
        break label346;
      }
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
      g();
      return true;
      localObject = (ViewStub)findViewById(2131376585);
      if ((!this.jdField_b_of_type_Boolean) || (!bool1)) {
        break;
      }
      localObject = ((ViewStub)localObject).inflate();
      this.app.addObserver(this.jdField_a_of_type_Ayfb);
      axqw.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      apvv.a(this.app, this, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, new aooe(this));
      break;
      label346:
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(BaseApplicationImpl.getContext().getString(2131692857));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.app.removeObserver(this.jdField_a_of_type_Ayfb);
    if (this.jdField_a_of_type_Aozs != null) {
      this.jdField_a_of_type_Aozs.b();
    }
    if (this.jdField_c_of_type_Apuz != null) {
      this.jdField_c_of_type_Apuz.b();
    }
    if (this.jdField_a_of_type_Apuz != null) {
      this.jdField_a_of_type_Apuz.b();
    }
    if (this.jdField_b_of_type_Apuz != null) {
      this.jdField_b_of_type_Apuz.b();
    }
    apud localapud = new apud();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    localapud.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localapud.jdField_b_of_type_Long = l2;
    localapud.jdField_a_of_type_Boolean = true;
    localapud.jdField_c_of_type_JavaLangString = apvb.a(this.jdField_c_of_type_JavaLangString);
    localapud.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    apuc.a(this.app.getCurrentAccountUin(), localapud);
    if ((this.jdField_a_of_type_Apep != null) && ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Apep.f < this.jdField_a_of_type_Apep.jdField_e_of_type_Long)))
    {
      this.jdField_a_of_type_Apep.d = l2;
      this.jdField_a_of_type_Apep.f = l1;
      this.jdField_a_of_type_Apep.jdField_c_of_type_Long = (this.jdField_a_of_type_Apep.f - this.jdField_a_of_type_Apep.jdField_e_of_type_Long);
      this.jdField_a_of_type_Apep.jdField_e_of_type_JavaLangString = String.valueOf(9037);
      this.jdField_a_of_type_Apep.i = ("LoadInterface[" + this.jdField_e_of_type_Boolean + "]");
      this.jdField_a_of_type_Apep.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Apep.a();
    }
    this.jdField_a_of_type_Apep = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.clearCache(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.destroy();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnPause");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnResume");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onResume();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    runOnUiThread(new FilePreviewActivity.14(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Apxc != null) {
      return;
    }
    this.jdField_a_of_type_Apxc = new aooa(this);
  }
  
  public String getInitString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("domain", paramString1);
    localHashMap.put("fileType", Integer.valueOf(paramInt1));
    localHashMap.put("port", Integer.valueOf(paramInt2));
    localHashMap.put("downloadkey", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("cookie", paramString3);
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "";
    }
    localHashMap.put("path", paramString1);
    paramString1 = "javascript:qpreview.onClientResponse('init'," + apue.a(localHashMap) + ")";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "getInitString:" + paramString1);
    }
    return paramString1;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.goBack();
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */