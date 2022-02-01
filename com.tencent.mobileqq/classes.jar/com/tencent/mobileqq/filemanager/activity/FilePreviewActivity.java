package com.tencent.mobileqq.filemanager.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = -1L;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  FilePreviewActivity.ControlerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = null;
  FilePreViewControllerBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
  FilePreviewDataReporter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
  FilePreviewAnimQueue jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
  FileWebView.JSInterface jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = null;
  FileWebView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private TeamWorkFileImportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new FilePreviewActivity.1(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  FilePreviewAnimQueue jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  FilePreviewAnimQueue jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  String jdField_g_of_type_JavaLangString;
  boolean jdField_g_of_type_Boolean = false;
  String h;
  String i;
  String j = null;
  String k = null;
  
  private FileWebView.TitilebarEventInterface a()
  {
    return new FilePreviewActivity.9(this, new Handler());
  }
  
  private WebViewClient a()
  {
    return new FilePreviewActivity.8(this);
  }
  
  private String a(String paramString)
  {
    int i1 = paramString.lastIndexOf("/") + 1;
    int n = paramString.lastIndexOf("&");
    int m = n;
    if (n < i1) {
      m = paramString.length();
    }
    return paramString.substring(i1, m);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    View localView2 = ((ViewStub)findViewById(2131365375)).inflate();
    localView2.setPadding(0, 0, 70, 120);
    View localView1 = localView2.findViewById(2131380642);
    localView2 = localView2.findViewById(2131380643);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
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
        localView1.setOnClickListener(new FilePreviewActivity.4(this));
      }
      if ((localView2 == null) || (!paramBoolean2)) {
        break;
      }
      localView2.setOnClickListener(new FilePreviewActivity.5(this));
      return;
      ReportController.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      break label75;
      label164:
      ReportController.b(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.jdField_a_of_type_Int == -1) {
      return false;
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("OfflinePreZipPath");
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    Object localObject = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.jdField_b_of_type_JavaLangString, "FileType");
    this.i = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.jdField_b_of_type_JavaLangString, "InterfacePage");
    String str = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.jdField_b_of_type_JavaLangString, "PreviewMode");
    this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_domain");
    this.h = paramIntent.getStringExtra("offline_file_port");
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_domain_key");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("offline_file_type_key", -1);
    this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("COOKIE");
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("offline_file_show_team_work_menu", false);
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
        break label389;
      }
      setContentViewForImage(2131560946);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131377357);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
    for (;;)
    {
      a();
      if (this.jdField_a_of_type_Int != 0) {
        break label475;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = this.app.getFileManagerDataCenter().a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null) {
        break label399;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.jdField_a_of_type_Boolean = FileManagerUtil.a(this.jdField_c_of_type_Int);
      break;
      label389:
      setContentView(2131560946);
    }
    label399:
    this.k = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback == null) {
      h();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback);
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("offline_file_size", 0L);
    startTitleProgress();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = true;
    }
    for (;;)
    {
      return true;
      label475:
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      this.leftView.setText(2131690601);
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.jdField_a_of_type_JavaLangString + ")");
      this.j = paramIntent.getStringExtra("OfflinePreZipUUID");
      break;
      paramIntent = ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
      if (paramIntent == null) {
        return true;
      }
      if (Integer.parseInt(paramIntent) == 0) {
        return true;
      }
      setRequestedOrientation(-1);
    }
  }
  
  private FileWebView.TitilebarEventInterface b()
  {
    return new FilePreviewActivity.10(this);
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = new FilePreviewDataReporter(this.app.getCurrentAccountUin());
    FilePreviewDataReporter localFilePreviewDataReporter1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    FilePreviewDataReporter localFilePreviewDataReporter2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    long l = System.currentTimeMillis();
    localFilePreviewDataReporter2.jdField_a_of_type_Long = l;
    localFilePreviewDataReporter1.e = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.j = String.valueOf(this.k);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.k = "1";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_g_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = FileUtil.a(this.jdField_b_of_type_JavaLangString).replace(".", "").toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new FilePreviewActivity.6(this);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = new FilePreviewActivity.7(this);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131381841));
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(a());
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new ReportX5CoreWebChromeClient());
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(b());
    }
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.15(this, paramInt));
  }
  
  void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
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
        long l = this.jdField_b_of_type_Long;
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_first";
        paramString.jdField_b_of_type_Long = (paramLong - l);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_b_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        FileManagerReporter.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = paramString;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
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
        str = getString(2131692509);
      }
      paramString = str + getString(2131692507);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  boolean a()
  {
    return (this.jdField_c_of_type_Int != FMConstants.jdField_c_of_type_Int) && (!FileManagerUtil.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  void b(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
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
        setTitle(BaseApplicationImpl.getContext().getString(2131692761));
        paramLong = System.currentTimeMillis();
        long l = this.jdField_b_of_type_Long;
        paramString = new FileManagerReporter.FileAssistantReportData();
        paramString.jdField_b_of_type_JavaLangString = "file_preview_time_more";
        paramString.jdField_b_of_type_Long = (paramLong - l);
        paramString.jdField_a_of_type_Boolean = paramBoolean;
        paramString.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_b_of_type_JavaLangString);
        paramString.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        FileManagerReporter.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = paramString;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131693846);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      a(5000);
    }
  }
  
  void c()
  {
    runOnUiThread(new FilePreviewActivity.12(this));
  }
  
  void d()
  {
    runOnUiThread(new FilePreviewActivity.13(this));
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
    if (paramIntent != null)
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          Bundle localBundle = paramIntent.getExtras();
          Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
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
    setRightButton(2131690946, new FilePreviewActivity.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377159));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367908));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372710));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    Object localObject = TencentDocConvertConfigProcessor.a();
    boolean bool1 = ((TencentDocConvertConfigBean)localObject).a();
    boolean bool2 = ((TencentDocConvertConfigBean)localObject).b();
    if ((bool2) || (!TencentDocConvertABTestUtil.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
    {
      a(bool1, bool2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366404));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377010));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131367909));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367907));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377021));
      setTitle(BaseApplicationImpl.getContext().getString(2131692761));
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
      localObject = (ViewStub)findViewById(2131378581);
      if ((!this.jdField_c_of_type_Boolean) || (!bool1)) {
        break;
      }
      localObject = ((ViewStub)localObject).inflate();
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
      ReportController.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      TencentDocConvertABTestUtil.a(this.app, this, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, new FilePreviewActivity.3(this));
      break;
      label346:
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(BaseApplicationImpl.getContext().getString(2131692761));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    localFileAssistantReportData.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localFileAssistantReportData.jdField_b_of_type_Long = l2;
    localFileAssistantReportData.jdField_a_of_type_Boolean = true;
    localFileAssistantReportData.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_b_of_type_JavaLangString);
    localFileAssistantReportData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.app.getCurrentAccountUin(), localFileAssistantReportData);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) && ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f < this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = l2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = String.valueOf(9037);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = ("LoadInterface[" + this.jdField_f_of_type_Boolean + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
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
  
  void e()
  {
    runOnUiThread(new FilePreviewActivity.14(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface = new FilePreviewActivity.16(this);
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
    paramString1 = "javascript:qpreview.onClientResponse('init'," + FileManagerUtil.a(localHashMap) + ")";
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */