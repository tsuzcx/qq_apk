package com.tencent.mobileqq.filemanager.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apwl;
import aszn;
import aszp;
import aszq;
import aszr;
import aszs;
import aszt;
import aszu;
import aszv;
import aszw;
import aszx;
import audn;
import audr;
import auea;
import auht;
import aulc;
import bdla;
import bhhr;
import bjlo;
import bjme;
import bkzh;
import bkzi;
import bkzq;
import bkzz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class UniformDownloadActivity
  extends BaseActivity
{
  public static String a;
  public static String b;
  public static String c = "buttonType";
  public static String d = "filename";
  public static String e = "filesize";
  public static String f = "filetype";
  public static String g = "iconpath";
  public static String h = "filememo";
  public static String i = "isqbdownload";
  public static String j = "fileMimeType";
  public static String k = "refer_url";
  private static final String m = null;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aszv(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aulc jdField_a_of_type_Aulc = new aszq(this);
  public bkzi a;
  private bkzq jdField_a_of_type_Bkzq = new aszw(this);
  public QQAppInterface a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new aszp(this);
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public final String l = "application/vnd.android.package-archive";
  private String n;
  private String o;
  private String p;
  private String q;
  private String r = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadActivity<FileAssistant>";
    jdField_b_of_type_JavaLangString = "URL";
  }
  
  private int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private View a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839470));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(241);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(242);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131691802);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166928));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, a(30.0F));
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 241);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = a(5.0F);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 242);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = a(5.0F);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  @NonNull
  private OuterCallReportModel a()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 1;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mVia = "ANDROIDQQ.POPUP.YYBDOWNAPP";
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  @NonNull
  private String a(OuterCallReportModel paramOuterCallReportModel)
  {
    return "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(this.n) + "&via=" + "ANDROIDQQ.POPUP.YYBDOWNAPP" + "&hostpname=com.tencent.mobileqq&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostversion=" + GlobalUtil.getAppVersionCode(this);
  }
  
  private void a(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(getApplicationContext());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  private void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.setFlags(268435456);
    try
    {
      startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean a()
  {
    return ("application/vnd.android.package-archive".equals(this.q)) || (this.o.toLowerCase().endsWith(".apk"));
  }
  
  private boolean a(String paramString)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_PORTAL);
    if (localPortalManager == null) {
      return true;
    }
    if (((!apwl.f) || (!this.jdField_a_of_type_Boolean)) && (localPortalManager.a(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    super.setContentView(2131560865);
    Object localObject1 = (TextView)findViewById(2131380464);
    Object localObject2 = (TextView)findViewById(2131380465);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380463));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject2).setText(2131690605);
      }
      ((TextView)localObject2).setOnClickListener(new aszn(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new aszr(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131380469);
    TextView localTextView2 = (TextView)findViewById(2131380470);
    ImageView localImageView = (ImageView)findViewById(2131380468);
    localObject2 = localIntent.getStringExtra(h);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.o;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(FileUtil.filesizeToString(this.jdField_a_of_type_Long));
    int i1 = auea.b(this.o);
    localObject1 = localIntent.getStringExtra(g);
    if (i1 != 0) {
      localImageView.setImageResource(i1);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new aszs(this, localImageView));
        localImageView.setImageDrawable((Drawable)localObject1);
      }
      return;
      localImageView.setImageResource(2130844338);
    }
  }
  
  private boolean b()
  {
    return bjlo.a("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void c()
  {
    bdla.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.o);
    localBundle.putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_WEBVIEW");
    localBundle.putString("FILE_MIME_TYPE", this.q);
    localBundle.putString("param_refer_url", this.r);
    auht.a().a(this.n, localBundle, this.jdField_a_of_type_Aulc);
    d();
    bjme.a().a(this.p, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    bdla.b(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[UniformDL]. >>> downloadFile. url:" + this.n);
    }
  }
  
  private void d()
  {
    if ((!TextUtils.isEmpty(this.o)) && (this.o.startsWith("qzone"))) {
      LocalMultiProcConfig.putLong("qzonedownloadtime", System.currentTimeMillis());
    }
  }
  
  private void e()
  {
    if (b()) {
      bjme.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    }
    while (NetworkUtil.isNetSupport(getActivity())) {
      if (auea.a())
      {
        audn.a(getActivity(), 2131692476, 2131719760, new aszx(this));
        return;
        bjme.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
      }
      else
      {
        c();
        return;
      }
    }
    audr.a(2131692469);
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(getActivity(), null));
    int i1 = 1;
    View localView = null;
    Object localObject = bhhr.k(this, "noSafeDown");
    Log.d(jdField_a_of_type_JavaLangString, this.n);
    if (((String)localObject).equals("true"))
    {
      this.jdField_a_of_type_Bkzi.b(2131690115);
      localObject = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_Bkzq);
      this.jdField_a_of_type_Bkzi.a(new aszt(this));
      this.jdField_a_of_type_Bkzi.show();
      this.jdField_a_of_type_Bkzi.setOnKeyListener(new aszu(this));
      localView = LayoutInflater.from(this).inflate(2131558439, null);
      Button localButton = (Button)localView.findViewById(2131361970);
      localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localButton.setText(2131691781);
      localButton.setTextColor(getResources().getColor(2131165203));
      this.jdField_a_of_type_Bkzi.a(localView);
      if (localObject != null)
      {
        localObject = (TextView)this.jdField_a_of_type_Bkzi.findViewById(((bkzh)localObject).b);
        ((TextView)localObject).setTextColor(getResources().getColor(2131165201));
        ((TextView)localObject).getPaint().setFakeBoldText(true);
      }
      bjme.a().a(this.p, "", "ANDROIDQQ.POPUP", "100", false);
      bdla.b(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
      return;
      boolean bool2 = false;
      localObject = localView;
      boolean bool1 = bool2;
      boolean bool3;
      if (a())
      {
        bool3 = a(this.n);
        localObject = localView;
        bool1 = bool2;
        i1 = bool3;
        if (bool3)
        {
          bool1 = DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.n);
          if (bool1) {
            break label389;
          }
          Log.d(jdField_a_of_type_JavaLangString, "url is ok show safe download");
          localObject = new bkzh(2131365840, getString(2131691783), 0, 0);
          this.jdField_a_of_type_Bkzi.a((bkzh)localObject, 0);
          i1 = bool3;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (bool1)
          {
            this.jdField_a_of_type_Bkzi.b(2131690115);
            break;
            label389:
            Log.d(jdField_a_of_type_JavaLangString, "url is blocked!! show only normal download");
            localObject = localView;
            i1 = bool3;
            continue;
          }
          this.jdField_a_of_type_Bkzi.b(2131691782);
          break;
        }
      }
      if (localObject == null) {
        this.jdField_a_of_type_Bkzi.b(2131690116);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.n = paramBundle.getStringExtra(jdField_b_of_type_JavaLangString);
    this.o = paramBundle.getStringExtra(d);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra(e, 0L);
    this.q = paramBundle.getStringExtra(j);
    this.r = paramBundle.getStringExtra(k);
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.p = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramBundle.getBooleanExtra(i, false)) {
      b();
    }
    for (;;)
    {
      if (this.r == null) {
        this.r = "";
      }
      return true;
      setContentView(a(), new FrameLayout.LayoutParams(-1, -1));
      a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.9(this));
    auht.a().a(this.n);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */