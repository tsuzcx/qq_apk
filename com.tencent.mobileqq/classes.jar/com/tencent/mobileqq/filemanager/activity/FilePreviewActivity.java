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
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
  LinearLayout A = null;
  View.OnClickListener B = null;
  FilePreviewDataReporter C = null;
  FileWebView.JSInterface D = null;
  String E = null;
  String F = null;
  boolean G = false;
  boolean H = false;
  boolean I = false;
  boolean J = false;
  long K = 0L;
  long L = 0L;
  boolean M = false;
  FilePreviewAnimQueue N = null;
  FilePreviewAnimQueue O = null;
  FilePreviewAnimQueue P;
  private TeamWorkFileImportInfo Q;
  private QQProgressDialog R;
  private TeamWorkFileImportObserver S = new FilePreviewActivity.1(this);
  FilePreViewControllerBase a = null;
  ControlerCallback b = null;
  RelativeLayout c;
  FileWebView d;
  String e;
  String f;
  String g = null;
  String h = null;
  int i = -1;
  int j = -1;
  int k = -1;
  boolean l = false;
  String m;
  String n;
  ViewGroup o = null;
  String p;
  String q;
  boolean r = false;
  long s = -1L;
  String t;
  LinearLayout u = null;
  TextView v = null;
  ImageView w = null;
  TextView x = null;
  ProgressBar y = null;
  TextView z = null;
  
  private String a(String paramString)
  {
    int i3 = paramString.lastIndexOf("/") + 1;
    int i2 = paramString.lastIndexOf("&");
    int i1 = i2;
    if (i2 < i3) {
      i1 = paramString.length();
    }
    return paramString.substring(i3, i1);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.G) {
      return;
    }
    View localView2 = ((ViewStub)findViewById(2131431405)).inflate();
    localView2.setPadding(0, 0, 70, 120);
    View localView1 = localView2.findViewById(2131448803);
    localView2 = localView2.findViewById(2131448804);
    this.app.addObserver(this.S);
    if (!paramBoolean1)
    {
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
    }
    else {
      ReportController.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
    }
    if (!paramBoolean2)
    {
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
    else {
      ReportController.b(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
    if ((localView1 != null) && (paramBoolean1)) {
      localView1.setOnClickListener(new FilePreviewActivity.4(this));
    }
    if ((localView2 != null) && (paramBoolean2)) {
      localView2.setOnClickListener(new FilePreviewActivity.5(this));
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    this.i = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.i == -1) {
      return false;
    }
    this.f = paramIntent.getStringExtra("offline_file_name");
    if (this.i == 1) {
      this.g = paramIntent.getStringExtra("OfflinePreZipPath");
    }
    this.f = paramIntent.getStringExtra("offline_file_name");
    Object localObject = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f, "FileType");
    this.t = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f, "InterfacePage");
    String str = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(this, this.f, "PreviewMode");
    this.p = paramIntent.getStringExtra("offline_file_domain");
    this.q = paramIntent.getStringExtra("offline_file_port");
    this.m = paramIntent.getStringExtra("offline_file_domain_key");
    this.j = paramIntent.getIntExtra("offline_file_type_key", -1);
    this.n = paramIntent.getStringExtra("COOKIE");
    this.G = paramIntent.getBooleanExtra("offline_file_show_team_work_menu", false);
    this.Q = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.Q;
    if (localTeamWorkFileImportInfo != null) {
      localTeamWorkFileImportInfo.n = 3;
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.j = Integer.parseInt((String)localObject);
    }
    if ((str != null) && (str.length() > 0)) {
      this.k = Integer.parseInt(str);
    }
    if (this.i != 0) {
      this.l = paramIntent.getBooleanExtra("offline_file_bZip", false);
    } else {
      this.l = FileManagerUtil.e(this.k);
    }
    if (a())
    {
      setContentViewForImage(2131627079);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131445139);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
    else
    {
      setContentView(2131627079);
    }
    b();
    if (this.i == 0)
    {
      this.a = this.app.getFileManagerDataCenter().e();
      localObject = this.a;
      if (localObject == null)
      {
        QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
        finish();
        return false;
      }
      this.F = String.valueOf(((FilePreViewControllerBase)localObject).c());
      if (this.b == null) {
        i();
      }
      this.a.a(this.b);
      this.leftView.setVisibility(8);
      this.s = paramIntent.getLongExtra("offline_file_size", 0L);
      startTitleProgress();
    }
    else
    {
      this.e = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      this.leftView.setText(2131887440);
      localObject = this.e;
      if (localObject != null) {
        this.d.loadUrl((String)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mWebView.loadUrl(");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(")");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject).toString());
      this.E = paramIntent.getStringExtra("OfflinePreZipUUID");
    }
    if (this.l)
    {
      this.M = true;
      return true;
    }
    paramIntent = ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramIntent == null) {
      return true;
    }
    if (Integer.parseInt(paramIntent) == 0) {
      return true;
    }
    setRequestedOrientation(-1);
    return true;
  }
  
  private void h()
  {
    if (this.B != null) {
      return;
    }
    this.B = new FilePreviewActivity.6(this);
  }
  
  private void i()
  {
    try
    {
      this.b = new FilePreviewActivity.7(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
    }
    this.K = System.currentTimeMillis();
    this.C = new FilePreviewDataReporter(this.app.getCurrentAccountUin());
    FilePreviewDataReporter localFilePreviewDataReporter = this.C;
    long l1 = System.currentTimeMillis();
    localFilePreviewDataReporter.b = l1;
    localFilePreviewDataReporter.s = l1;
    this.C.m = String.valueOf(this.F);
    localFilePreviewDataReporter = this.C;
    localFilePreviewDataReporter.n = "1";
    String str = this.f;
    localFilePreviewDataReporter.j = str;
    localFilePreviewDataReporter.l = FileUtil.a(str).replace(".", "").toLowerCase();
    this.C.f = this.s;
    return this.a.a();
  }
  
  private WebViewClient k()
  {
    return new FilePreviewActivity.8(this);
  }
  
  private FileWebView.TitilebarEventInterface l()
  {
    return new FilePreviewActivity.9(this, new Handler());
  }
  
  private FileWebView.TitilebarEventInterface m()
  {
    return new FilePreviewActivity.10(this);
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.15(this, paramInt));
  }
  
  void a(boolean paramBoolean, long paramLong, String paramString)
  {
    Object localObject = this.C;
    if (localObject != null) {
      ((FilePreviewDataReporter)localObject).t = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      paramString = this.C;
      if (paramString != null)
      {
        paramString.o = (paramString.t - this.C.s);
        paramString = this.C;
        paramString.q = true;
        paramString.k = "";
        paramString.p = (System.currentTimeMillis() - this.C.b);
        this.C.a();
      }
      this.w.setVisibility(8);
      this.x.setVisibility(4);
      this.A.setVisibility(4);
      this.A.setOnClickListener(null);
    }
    try
    {
      this.d.setVisibility(0);
    }
    catch (NullPointerException paramString)
    {
      label143:
      long l1;
      break label143;
    }
    this.d.setOverrideOnCheckIsTextEditor(false);
    this.d.setVisibility(0);
    break label363;
    localObject = this.C;
    if (localObject != null)
    {
      ((FilePreviewDataReporter)localObject).o = (((FilePreviewDataReporter)localObject).t - this.C.s);
      localObject = this.C;
      ((FilePreviewDataReporter)localObject).q = false;
      ((FilePreviewDataReporter)localObject).e = String.valueOf(paramLong);
      localObject = this.C;
      ((FilePreviewDataReporter)localObject).k = paramString;
      ((FilePreviewDataReporter)localObject).p = (System.currentTimeMillis() - this.C.b);
      this.C.a();
    }
    this.w.setVisibility(0);
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131889433);
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append(getString(2131889431));
    paramString = paramString.toString();
    this.x.setText(paramString);
    this.x.setVisibility(0);
    this.A.setOnClickListener(this.B);
    this.A.setVisibility(0);
    this.d.setVisibility(4);
    label363:
    paramString = new StringBuilder();
    paramString.append("js call loadFnish suc[");
    paramString.append(paramBoolean);
    paramString.append("] retCode[");
    paramString.append(paramLong);
    paramString.append("]");
    QLog.i("<FileAssistant>FilePreviewActivity", 1, paramString.toString());
    paramLong = System.currentTimeMillis();
    l1 = this.K;
    paramString = new FileManagerReporter.FileAssistantReportData();
    paramString.b = "file_preview_time_first";
    paramString.h = (paramLong - l1);
    paramString.i = paramBoolean;
    paramString.d = FileUtil.a(this.f);
    paramString.e = this.s;
    FileManagerReporter.a(this.app.getCurrentAccountUin(), paramString);
  }
  
  boolean a()
  {
    return (this.k != FMConstants.c) && (!FileManagerUtil.e(this.k)) && (!this.l);
  }
  
  void b()
  {
    this.c = ((RelativeLayout)findViewById(2131450068));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", "qfile");
    QbSdk.initTbsSettings((Map)localObject);
    this.d = new FileWebView(getApplicationContext());
    this.c.addView(this.d);
    localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = i2;
    ((RelativeLayout.LayoutParams)localObject).width = i1;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    g();
    this.d.setWebViewClient(k());
    if (a()) {
      this.d.setOnCustomScroolChangeListener(l());
    } else {
      this.d.setOnCustomScroolChangeListener(m());
    }
    this.d.setWebChromeClient(new ReportX5CoreWebChromeClient());
    this.d.setScrollBarStyle(0);
    this.d.requestFocus();
    this.d.setFocusableInTouchMode(false);
    localObject = this.d.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setCacheMode(-1);
    if (this.l) {
      ((WebSettings)localObject).setCacheMode(2);
    }
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setSupportZoom(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    if (Build.VERSION.SDK_INT < 16)
    {
      localObject = this.d;
      FileWebView.enablePlatformNotifications();
    }
  }
  
  void b(boolean paramBoolean, long paramLong, String paramString)
  {
    FilePreviewDataReporter localFilePreviewDataReporter = this.C;
    if (localFilePreviewDataReporter != null) {
      localFilePreviewDataReporter.t = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      paramString = this.C;
      if (paramString != null)
      {
        paramString.o = (paramString.t - this.C.s);
        paramString = this.C;
        paramString.q = true;
        paramString.k = "";
        paramString.p = (System.currentTimeMillis() - this.C.b);
        this.C.a();
      }
      this.w.setVisibility(8);
      this.x.setVisibility(4);
      this.A.setVisibility(4);
      this.A.setOnClickListener(null);
      a(1000);
    }
    try
    {
      this.d.setVisibility(0);
    }
    catch (NullPointerException paramString)
    {
      label150:
      long l1;
      break label150;
    }
    this.d.setOverrideOnCheckIsTextEditor(false);
    this.d.setVisibility(0);
    break label289;
    localFilePreviewDataReporter = this.C;
    if (localFilePreviewDataReporter != null)
    {
      localFilePreviewDataReporter.o = (localFilePreviewDataReporter.t - this.C.s);
      localFilePreviewDataReporter = this.C;
      localFilePreviewDataReporter.q = false;
      localFilePreviewDataReporter.e = String.valueOf(paramLong);
      localFilePreviewDataReporter = this.C;
      localFilePreviewDataReporter.k = paramString;
      localFilePreviewDataReporter.p = (System.currentTimeMillis() - this.C.b);
      this.C.a();
    }
    this.y.setVisibility(8);
    this.z.setText(2131891374);
    this.z.setVisibility(0);
    a(5000);
    label289:
    paramString = new StringBuilder();
    paramString.append("js call reportGetmoreTimeV2[");
    paramString.append(paramBoolean);
    paramString.append("],retCode[");
    paramString.append(paramLong);
    paramString.append("]");
    QLog.i("<FileAssistant>FilePreviewActivity", 1, paramString.toString());
    stopTitleProgress();
    setTitle(BaseApplicationImpl.getContext().getString(2131889789));
    paramLong = System.currentTimeMillis();
    l1 = this.K;
    paramString = new FileManagerReporter.FileAssistantReportData();
    paramString.b = "file_preview_time_more";
    paramString.h = (paramLong - l1);
    paramString.i = paramBoolean;
    paramString.d = FileUtil.a(this.f);
    paramString.e = this.s;
    FileManagerReporter.a(this.app.getCurrentAccountUin(), paramString);
  }
  
  void c()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  void d()
  {
    runOnUiThread(new FilePreviewActivity.12(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        return;
      }
      setResult(0, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (!a(paramBundle))
    {
      finish();
      return false;
    }
    setRightButton(2131887812, new FilePreviewActivity.2(this));
    this.o = ((ViewGroup)findViewById(2131444897));
    this.u = ((LinearLayout)findViewById(2131434218));
    this.u.setVisibility(4);
    this.v = ((TextView)findViewById(2131439798));
    this.v.setVisibility(4);
    Object localObject = TencentDocConvertConfigProcessor.a();
    boolean bool1 = ((TencentDocConvertConfigBean)localObject).a();
    boolean bool2 = ((TencentDocConvertConfigBean)localObject).b();
    if ((!bool2) && (((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).hasConfig(this.Q)))
    {
      localObject = (ViewStub)findViewById(2131446479);
      if ((this.G) && (bool1))
      {
        localObject = ((ViewStub)localObject).inflate();
        this.app.addObserver(this.S);
        ReportController.b(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
        ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).configureABTest(this.app, this, (View)localObject, this.Q, new FilePreviewActivity.3(this));
      }
    }
    else
    {
      a(bool1, bool2);
    }
    this.w = ((ImageView)findViewById(2131432587));
    this.x = ((TextView)findViewById(2131444733));
    this.w.setVisibility(8);
    this.y = ((ProgressBar)findViewById(2131434219));
    this.z = ((TextView)findViewById(2131434217));
    this.A = ((LinearLayout)findViewById(2131444742));
    setTitle(BaseApplicationImpl.getContext().getString(2131889789));
    if (this.i == 0)
    {
      j();
    }
    else
    {
      this.h = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(BaseApplicationImpl.getContext().getString(2131889789));
    }
    this.d.setVisibility(4);
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.R;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.R.dismiss();
    }
    this.app.removeObserver(this.S);
    localObject = this.a;
    if (localObject != null) {
      ((FilePreViewControllerBase)localObject).b();
    }
    localObject = this.P;
    if (localObject != null) {
      ((FilePreviewAnimQueue)localObject).b();
    }
    localObject = this.N;
    if (localObject != null) {
      ((FilePreviewAnimQueue)localObject).b();
    }
    localObject = this.O;
    if (localObject != null) {
      ((FilePreviewAnimQueue)localObject).b();
    }
    localObject = new FileManagerReporter.FileAssistantReportData();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.K;
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_preview_time_stay";
    ((FileManagerReporter.FileAssistantReportData)localObject).h = l2;
    ((FileManagerReporter.FileAssistantReportData)localObject).i = true;
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileUtil.a(this.f);
    ((FileManagerReporter.FileAssistantReportData)localObject).e = this.s;
    FileManagerReporter.a(this.app.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    localObject = this.C;
    if ((localObject != null) && ((!this.H) || (((FilePreviewDataReporter)localObject).t < this.C.s)))
    {
      localObject = this.C;
      ((FilePreviewDataReporter)localObject).p = l2;
      ((FilePreviewDataReporter)localObject).t = l1;
      ((FilePreviewDataReporter)localObject).o = (((FilePreviewDataReporter)localObject).t - this.C.s);
      this.C.e = String.valueOf(9037);
      localObject = this.C;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LoadInterface[");
      localStringBuilder.append(this.J);
      localStringBuilder.append("]");
      ((FilePreviewDataReporter)localObject).k = localStringBuilder.toString();
      localObject = this.C;
      ((FilePreviewDataReporter)localObject).q = false;
      ((FilePreviewDataReporter)localObject).a();
    }
    this.C = null;
    try
    {
      if (this.d != null)
      {
        this.d.setOnCustomScroolChangeListener(null);
        this.d.clearCache(false);
        this.d.setVisibility(4);
        this.c.removeView(this.d);
        this.d.destroy();
        this.c.removeAllViews();
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  protected void doOnPause()
  {
    if (this.d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnPause");
      }
      this.d.onPause();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnResume");
      }
      this.d.onResume();
    }
    super.doOnResume();
  }
  
  void e()
  {
    runOnUiThread(new FilePreviewActivity.13(this));
  }
  
  void f()
  {
    runOnUiThread(new FilePreviewActivity.14(this));
  }
  
  void g()
  {
    if (this.D != null) {
      return;
    }
    this.D = new FilePreviewActivity.16(this);
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
    paramString1 = new StringBuilder();
    paramString1.append("javascript:qpreview.onClientResponse('init',");
    paramString1.append(FileManagerUtil.a(localHashMap));
    paramString1.append(")");
    paramString1 = paramString1.toString();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getInitString:");
      paramString2.append(paramString1);
      QLog.i("<FileAssistant>FilePreviewActivity", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.d.canGoBack())
    {
      this.d.goBack();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */