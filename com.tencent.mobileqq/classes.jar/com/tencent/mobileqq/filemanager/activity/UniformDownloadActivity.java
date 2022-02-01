package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkMsgAIDisableConfBean;
import com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class UniformDownloadActivity
  extends BaseActivity
{
  public static String a = "UniformDownloadActivity<FileAssistant>";
  public static String b = "URL";
  public static String c = "buttonType";
  public static String d = "filename";
  public static String e = "filesize";
  public static String f = "filetype";
  public static String g = "iconpath";
  public static String h = "filememo";
  public static String i = "isqbdownload";
  public static String j = "fileMimeType";
  public static String k = "refer_url";
  private static final String m;
  private long jdField_a_of_type_Long = 0L;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new UniformDownloadActivity.6(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  private IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = new UniformDownloadActivity.11(this);
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new UniformDownloadActivity.10(this);
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new UniformDownloadActivity.7(this);
  protected ActionSheet a;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public final String l = "application/vnd.android.package-archive";
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = "";
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private View a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839406));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(241);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(242);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131691847);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166952));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("&downl_url=");
    localStringBuilder.append(URLEncoder.encode(this.n));
    localStringBuilder.append("&via=");
    localStringBuilder.append("ANDROIDQQ.POPUP.YYBDOWNAPP");
    localStringBuilder.append("&hostpname=com.tencent.mobileqq&outerCallTime=");
    localStringBuilder.append(paramOuterCallReportModel.mOuterCallTime);
    localStringBuilder.append("&outerCallType=");
    localStringBuilder.append(paramOuterCallReportModel.mOuterCallType);
    localStringBuilder.append("&outerCallMode=");
    localStringBuilder.append(paramOuterCallReportModel.mOuterCallMode);
    localStringBuilder.append("&hostversion=");
    localStringBuilder.append(GlobalUtil.getAppVersionCode(this));
    return localStringBuilder.toString();
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
    return ((!((ArkMsgAIDisableConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkMsgAIDisableConfBean.class)).a().b) || (!this.jdField_a_of_type_Boolean)) && (localPortalManager.a(paramString));
  }
  
  private void b()
  {
    super.setContentView(2131560832);
    Object localObject1 = (TextView)findViewById(2131380173);
    Object localObject2 = (TextView)findViewById(2131380174);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380172));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject2).setText(2131690635);
      }
      ((TextView)localObject2).setOnClickListener(new UniformDownloadActivity.1(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new UniformDownloadActivity.2(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131380178);
    TextView localTextView2 = (TextView)findViewById(2131380179);
    ImageView localImageView = (ImageView)findViewById(2131380177);
    localObject2 = localIntent.getStringExtra(h);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.o;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(FileUtil.a(this.jdField_a_of_type_Long));
    int i1 = FileManagerUtil.b(this.o);
    localObject1 = localIntent.getStringExtra(g);
    if (i1 != 0) {
      localImageView.setImageResource(i1);
    } else {
      localImageView.setImageResource(2130844434);
    }
    if (localObject1 != null)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1);
      ((URLDrawable)localObject1).setURLDrawableListener(new UniformDownloadActivity.3(this, localImageView));
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private boolean b()
  {
    return AppUtil.a("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void c()
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_filename_from_dlg", this.o);
    ((Bundle)localObject).putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_WEBVIEW");
    ((Bundle)localObject).putString("FILE_MIME_TYPE", this.q);
    ((Bundle)localObject).putString("param_refer_url", this.r);
    a().startDownload(this.n, (Bundle)localObject, this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener);
    d();
    OpenSdkStatic.a().a(this.p, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    ReportController.b(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL]. >>> downloadFile. url:");
      localStringBuilder.append(this.n);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
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
      OpenSdkStatic.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    } else {
      OpenSdkStatic.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
    }
    if (NetworkUtil.isNetSupport(getActivity()))
    {
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(getActivity(), 2131692561, 2131720077, new UniformDownloadActivity.8(this));
        return;
      }
      c();
      return;
    }
    FMToastUtil.a(2131692554);
    finish();
    overridePendingTransition(0, 0);
  }
  
  protected IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getActivity(), null));
    Object localObject = SharedPreUtils.i(this, "noSafeDown");
    Log.d(jdField_a_of_type_JavaLangString, this.n);
    if (((String)localObject).equals("true"))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690088);
    }
    else
    {
      int i1 = 0;
      boolean bool1;
      if (a())
      {
        boolean bool2 = a(this.n);
        bool1 = bool2;
        if (bool2)
        {
          DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.n);
          Log.d(jdField_a_of_type_JavaLangString, "url is blocked!! show only normal download");
          i1 = 1;
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
      if (bool1)
      {
        if (i1 != 0) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690088);
        } else {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691829);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690089);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new UniformDownloadActivity.4(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(new UniformDownloadActivity.5(this));
    localObject = LayoutInflater.from(this).inflate(2131558467, null);
    Button localButton = (Button)((View)localObject).findViewById(2131361988);
    localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localButton.setText(2131691828);
    localButton.setTextColor(getResources().getColor(2131165229));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addView((View)localObject);
    OpenSdkStatic.a().a(this.p, "", "ANDROIDQQ.POPUP", "100", false);
    ReportController.b(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    if (paramBundle.getBooleanExtra(i, false))
    {
      b();
    }
    else
    {
      setContentView(a(), new FrameLayout.LayoutParams(-1, -1));
      a();
    }
    if (this.r == null) {
      this.r = "";
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.9(this));
    a().removeOuterListenner(this.n);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */