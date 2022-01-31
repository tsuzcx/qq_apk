package com.tencent.mobileqq.filemanager.activity;

import actj;
import anbp;
import anbq;
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
import aood;
import aooe;
import aoof;
import aooi;
import aooj;
import aook;
import aool;
import aoom;
import aoon;
import aooo;
import aoop;
import aooq;
import aoze;
import aozw;
import apei;
import apej;
import apet;
import apue;
import apuf;
import apug;
import apvb;
import apvd;
import apvx;
import apxe;
import axqy;
import ayfd;
import bcqf;
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
  aooq jdField_a_of_type_Aooq = null;
  aozw jdField_a_of_type_Aozw = null;
  public apet a;
  apvb jdField_a_of_type_Apvb = null;
  public apxe a;
  private ayfd jdField_a_of_type_Ayfd = new aood(this);
  private bcqf jdField_a_of_type_Bcqf;
  public FileWebView a;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  final String jdField_a_of_type_JavaLangString = "<FileAssistant>FilePreviewActivity";
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  public LinearLayout b;
  public TextView b;
  apvb jdField_b_of_type_Apvb = null;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  public TextView c;
  apvb jdField_c_of_type_Apvb;
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
    this.jdField_a_of_type_Apet = null;
    this.jdField_a_of_type_Apxe = null;
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
    View localView2 = ((ViewStub)findViewById(2131364762)).inflate();
    localView2.setPadding(0, 0, 70, 120);
    View localView1 = localView2.findViewById(2131378376);
    localView2 = localView2.findViewById(2131378377);
    this.app.addObserver(this.jdField_a_of_type_Ayfd);
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
        localView1.setOnClickListener(new aook(this));
      }
      if ((localView2 == null) || (!paramBoolean2)) {
        break;
      }
      localView2.setOnClickListener(new aool(this));
      return;
      axqy.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      break label75;
      label164:
      axqy.b(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
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
    Object localObject = apei.a(this, this.jdField_c_of_type_JavaLangString, "FileType");
    this.j = apei.a(this, this.jdField_c_of_type_JavaLangString, "InterfacePage");
    String str = apei.a(this, this.jdField_c_of_type_JavaLangString, "PreviewMode");
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
      setContentViewForImage(2131560485);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131375494);
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
      this.jdField_a_of_type_Aozw = this.app.a().a();
      if (this.jdField_a_of_type_Aozw != null) {
        break label361;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.jdField_a_of_type_Boolean = apug.a(this.jdField_c_of_type_Int);
      break;
      label351:
      setContentView(2131560485);
    }
    label361:
    this.l = String.valueOf(this.jdField_a_of_type_Aozw.a());
    if (this.jdField_a_of_type_Aooq == null) {
      h();
    }
    this.jdField_a_of_type_Aozw.a(this.jdField_a_of_type_Aooq);
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
      paramIntent = apei.a(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
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
    this.jdField_a_of_type_Apet = new apet(this.app.getCurrentAccountUin());
    apet localapet1 = this.jdField_a_of_type_Apet;
    apet localapet2 = this.jdField_a_of_type_Apet;
    long l1 = System.currentTimeMillis();
    localapet2.jdField_a_of_type_Long = l1;
    localapet1.jdField_e_of_type_Long = l1;
    this.jdField_a_of_type_Apet.k = String.valueOf(this.l);
    this.jdField_a_of_type_Apet.l = "1";
    this.jdField_a_of_type_Apet.h = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Apet.j = apvd.a(this.jdField_c_of_type_JavaLangString).replace(".", "").toLowerCase();
    this.jdField_a_of_type_Apet.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    return this.jdField_a_of_type_Aozw.a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aoom(this);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_Aooq = new aoon(this);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379387));
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(new aooo(this));
    localObject = new Handler();
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new aoop(this, (Handler)localObject));
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new aooe(this));
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.15(this, paramInt));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Apet != null) {
      this.jdField_a_of_type_Apet.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Apet != null)
      {
        this.jdField_a_of_type_Apet.jdField_c_of_type_Long = (this.jdField_a_of_type_Apet.f - this.jdField_a_of_type_Apet.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apet.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Apet.i = "";
        this.jdField_a_of_type_Apet.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apet.a();
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
        paramString = new apuf();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_first";
        paramString.jdField_b_of_type_Long = (paramLong - l1);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = apvd.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        apue.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Apet != null)
      {
        this.jdField_a_of_type_Apet.jdField_c_of_type_Long = (this.jdField_a_of_type_Apet.f - this.jdField_a_of_type_Apet.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apet.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Apet.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_Apet.i = paramString;
        this.jdField_a_of_type_Apet.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apet.a();
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
        str = getString(2131692570);
      }
      paramString = str + getString(2131692568);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  boolean a()
  {
    return (this.jdField_c_of_type_Int != apej.jdField_b_of_type_Int) && (!apug.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Apet != null) {
      this.jdField_a_of_type_Apet.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Apet != null)
      {
        this.jdField_a_of_type_Apet.jdField_c_of_type_Long = (this.jdField_a_of_type_Apet.f - this.jdField_a_of_type_Apet.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apet.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Apet.i = "";
        this.jdField_a_of_type_Apet.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apet.a();
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
        setTitle(BaseApplicationImpl.getContext().getString(2131692858));
        paramLong = System.currentTimeMillis();
        long l1 = this.jdField_b_of_type_Long;
        paramString = new apuf();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_more";
        paramString.jdField_b_of_type_Long = (paramLong - l1);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = apvd.a(this.jdField_c_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        apue.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Apet != null)
      {
        this.jdField_a_of_type_Apet.jdField_c_of_type_Long = (this.jdField_a_of_type_Apet.f - this.jdField_a_of_type_Apet.jdField_e_of_type_Long);
        this.jdField_a_of_type_Apet.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Apet.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_Apet.i = paramString;
        this.jdField_a_of_type_Apet.d = (System.currentTimeMillis() - this.jdField_a_of_type_Apet.jdField_a_of_type_Long);
        this.jdField_a_of_type_Apet.a();
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131693974);
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
          Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
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
    setRightButton(2131690832, new aooi(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375329));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367049));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371228));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    Object localObject = anbq.a();
    boolean bool1 = ((anbp)localObject).a();
    boolean bool2 = ((anbp)localObject).b();
    if ((bool2) || (!apvx.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
    {
      a(bool1, bool2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365724));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375201));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131367050));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367048));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375212));
      setTitle(BaseApplicationImpl.getContext().getString(2131692858));
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
      localObject = (ViewStub)findViewById(2131376587);
      if ((!this.jdField_b_of_type_Boolean) || (!bool1)) {
        break;
      }
      localObject = ((ViewStub)localObject).inflate();
      this.app.addObserver(this.jdField_a_of_type_Ayfd);
      axqy.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      apvx.a(this.app, this, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, new aooj(this));
      break;
      label346:
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(BaseApplicationImpl.getContext().getString(2131692858));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.app.removeObserver(this.jdField_a_of_type_Ayfd);
    if (this.jdField_a_of_type_Aozw != null) {
      this.jdField_a_of_type_Aozw.b();
    }
    if (this.jdField_c_of_type_Apvb != null) {
      this.jdField_c_of_type_Apvb.b();
    }
    if (this.jdField_a_of_type_Apvb != null) {
      this.jdField_a_of_type_Apvb.b();
    }
    if (this.jdField_b_of_type_Apvb != null) {
      this.jdField_b_of_type_Apvb.b();
    }
    apuf localapuf = new apuf();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    localapuf.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localapuf.jdField_b_of_type_Long = l2;
    localapuf.jdField_a_of_type_Boolean = true;
    localapuf.jdField_c_of_type_JavaLangString = apvd.a(this.jdField_c_of_type_JavaLangString);
    localapuf.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    apue.a(this.app.getCurrentAccountUin(), localapuf);
    if ((this.jdField_a_of_type_Apet != null) && ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Apet.f < this.jdField_a_of_type_Apet.jdField_e_of_type_Long)))
    {
      this.jdField_a_of_type_Apet.d = l2;
      this.jdField_a_of_type_Apet.f = l1;
      this.jdField_a_of_type_Apet.jdField_c_of_type_Long = (this.jdField_a_of_type_Apet.f - this.jdField_a_of_type_Apet.jdField_e_of_type_Long);
      this.jdField_a_of_type_Apet.jdField_e_of_type_JavaLangString = String.valueOf(9037);
      this.jdField_a_of_type_Apet.i = ("LoadInterface[" + this.jdField_e_of_type_Boolean + "]");
      this.jdField_a_of_type_Apet.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Apet.a();
    }
    this.jdField_a_of_type_Apet = null;
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
    if (this.jdField_a_of_type_Apxe != null) {
      return;
    }
    this.jdField_a_of_type_Apxe = new aoof(this);
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
    paramString1 = "javascript:qpreview.onClientResponse('init'," + apug.a(localHashMap) + ")";
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