package com.tencent.mobileqq.filemanager.activity;

import acob;
import acod;
import acoi;
import acop;
import acoq;
import acor;
import acos;
import acot;
import acou;
import acow;
import acox;
import android.content.Intent;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
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
  private static final String l = null;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acot(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  private UniformDownloader.IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener = new acoi(this);
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new acod(this);
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new acou(this);
  public ActionSheet a;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public final String k = "application/vnd.android.package-archive";
  private String m;
  private String n;
  private String o;
  private String p;
  
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
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838600));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(241);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(242);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131428581);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493506));
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
    return "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(this.m) + "&via=" + "ANDROIDQQ.POPUP.YYBDOWNAPP" + "&hostpname=com.tencent.mobileqq&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostversion=" + GlobalUtil.getAppVersionCode(this);
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
    return ("application/vnd.android.package-archive".equals(this.p)) || (this.n.toLowerCase().endsWith(".apk"));
  }
  
  private boolean a(String paramString)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
    if (localPortalManager == null) {
      return true;
    }
    if (((!ArkAiAppCenter.n) || (!this.jdField_a_of_type_Boolean)) && (localPortalManager.a(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    super.setContentView(2130970038);
    Object localObject1 = (TextView)findViewById(2131364100);
    Object localObject2 = (TextView)findViewById(2131364101);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364093));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject2).setText(2131434996);
      }
      ((TextView)localObject2).setOnClickListener(new acob(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new acop(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131364096);
    TextView localTextView2 = (TextView)findViewById(2131364097);
    ImageView localImageView = (ImageView)findViewById(2131364094);
    localObject2 = localIntent.getStringExtra(h);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.n;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(FileUtil.a(this.jdField_a_of_type_Long));
    int i1 = FileManagerUtil.b(this.n);
    localObject1 = localIntent.getStringExtra(g);
    if (i1 != 0) {
      localImageView.setImageResource(i1);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new acoq(this, localImageView));
        localImageView.setImageDrawable((Drawable)localObject1);
      }
      return;
      localImageView.setImageResource(2130841667);
    }
  }
  
  private boolean b()
  {
    return AppUtil.a("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void c()
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.n);
    localBundle.putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    UniformDownloadMgr.a().a(this.m, localBundle, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener);
    d();
    OpenSdkStatic.a().a(this.o, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    ReportController.b(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[UniformDL]. >>> downloadFile. url:" + this.m);
    }
  }
  
  private void d()
  {
    if ((!TextUtils.isEmpty(this.n)) && (this.n.startsWith("qzone"))) {
      LocalMultiProcConfig.putLong("qzonedownloadtime", System.currentTimeMillis());
    }
  }
  
  private void e()
  {
    if (b()) {
      OpenSdkStatic.a().a(this.o, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    }
    while (NetworkUtil.d(getActivity())) {
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(getActivity(), 2131428241, 2131428268, new acow(this));
        return;
        OpenSdkStatic.a().a(this.o, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
      }
      else
      {
        c();
        return;
      }
    }
    FMToastUtil.a(2131428327);
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getActivity(), null));
    int i1 = 1;
    View localView = null;
    Object localObject = SharedPreUtils.k(this, "noSafeDown");
    Log.d(jdField_a_of_type_JavaLangString, this.m);
    if (((String)localObject).equals("true"))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131428572);
      localObject = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new acor(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(new acos(this));
      localView = LayoutInflater.from(this).inflate(2130968599, null);
      Button localButton = (Button)localView.findViewById(2131362809);
      localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localButton.setText(2131428579);
      localButton.setTextColor(getResources().getColor(2131493058));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView);
      if (localObject != null)
      {
        localObject = (TextView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(((ActionMenuItem)localObject).b);
        ((TextView)localObject).setTextColor(getResources().getColor(2131493056));
        ((TextView)localObject).getPaint().setFakeBoldText(true);
      }
      OpenSdkStatic.a().a(this.o, "", "ANDROIDQQ.POPUP", "100", false);
      ReportController.b(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
      return;
      boolean bool2 = false;
      localObject = localView;
      boolean bool1 = bool2;
      boolean bool3;
      if (a())
      {
        bool3 = a(this.m);
        localObject = localView;
        bool1 = bool2;
        i1 = bool3;
        if (bool3)
        {
          bool1 = DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.m);
          if (bool1) {
            break label396;
          }
          Log.d(jdField_a_of_type_JavaLangString, "url is ok show safe download");
          localObject = new ActionMenuItem(2131362394, getString(2131428576), 0, 0);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a((ActionMenuItem)localObject, 0);
          i1 = bool3;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (bool1)
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131428572);
            break;
            label396:
            Log.d(jdField_a_of_type_JavaLangString, "url is blocked!! show only normal download");
            localObject = localView;
            i1 = bool3;
            continue;
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131428578);
          break;
        }
      }
      if (localObject == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131428573);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.m = paramBundle.getStringExtra(jdField_b_of_type_JavaLangString);
    this.n = paramBundle.getStringExtra(d);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra(e, 0L);
    this.p = paramBundle.getStringExtra(j);
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.o = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramBundle.getBooleanExtra(i, false)) {
      b();
    }
    for (;;)
    {
      return true;
      setContentView(a(), new FrameLayout.LayoutParams(-1, -1));
      a();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new acox(this));
    UniformDownloadMgr.a().a(this.m);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */