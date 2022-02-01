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
  private static final String o;
  private boolean A;
  private View.OnClickListener B = new UniformDownloadActivity.6(this);
  private ActionSheet.OnButtonClickListener C = new UniformDownloadActivity.7(this);
  private DownloadListener D = new UniformDownloadActivity.10(this);
  private IUniformDownloaderListener E = new UniformDownloadActivity.11(this);
  public final String l = "application/vnd.android.package-archive";
  public QQAppInterface m;
  protected ActionSheet n;
  private String p = null;
  private String q = null;
  private long r = 0L;
  private RelativeLayout s = null;
  private String t = null;
  private String u = null;
  private String v = "";
  private RelativeLayout w;
  private ProgressBar x;
  private TextView y;
  private TextView z;
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(getApplicationContext());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  private boolean a(String paramString)
  {
    PortalManager localPortalManager = (PortalManager)this.m.getManager(QQManagerFactory.MGR_PORTAL);
    if (localPortalManager == null) {
      return true;
    }
    return ((!((ArkMsgAIDisableConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkMsgAIDisableConfBean.class)).b().b) || (!this.A)) && (localPortalManager.c(paramString));
  }
  
  @NonNull
  private String b(OuterCallReportModel paramOuterCallReportModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("&downl_url=");
    localStringBuilder.append(URLEncoder.encode(this.p));
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
  
  private void b(String paramString)
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
  
  private void c()
  {
    super.setContentView(2131627090);
    Object localObject1 = (TextView)findViewById(2131449088);
    Object localObject2 = (TextView)findViewById(2131449089);
    this.s = ((RelativeLayout)findViewById(2131449087));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject2).setText(2131887546);
      }
      ((TextView)localObject2).setOnClickListener(new UniformDownloadActivity.1(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new UniformDownloadActivity.2(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131449093);
    TextView localTextView2 = (TextView)findViewById(2131449094);
    ImageView localImageView = (ImageView)findViewById(2131449092);
    localObject2 = localIntent.getStringExtra(h);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.q;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(FileUtil.a(this.r));
    int i1 = FileManagerUtil.i(this.q);
    localObject1 = localIntent.getStringExtra(g);
    if (i1 != 0) {
      localImageView.setImageResource(i1);
    } else {
      localImageView.setImageResource(2130845752);
    }
    if (localObject1 != null)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1);
      ((URLDrawable)localObject1).setURLDrawableListener(new UniformDownloadActivity.3(this, localImageView));
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void d()
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_filename_from_dlg", this.q);
    ((Bundle)localObject).putLong("_filesize_from_dlg", this.r);
    ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_WEBVIEW");
    ((Bundle)localObject).putString("FILE_MIME_TYPE", this.u);
    ((Bundle)localObject).putString("param_refer_url", this.v);
    b().startDownload(this.p, (Bundle)localObject, this.E);
    e();
    OpenSdkStatic.a().a(this.t, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    ReportController.b(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL]. >>> downloadFile. url:");
      localStringBuilder.append(this.p);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.q)) && (this.q.startsWith("qzone"))) {
      LocalMultiProcConfig.putLong("qzonedownloadtime", System.currentTimeMillis());
    }
  }
  
  private View f()
  {
    this.w = new RelativeLayout(this);
    this.x = new ProgressBar(this);
    this.x.setIndeterminateDrawable(getResources().getDrawable(2130839590));
    this.x.setId(241);
    this.y = new TextView(this);
    this.y.setId(242);
    this.y.setTextColor(-1);
    this.y.setTextSize(14.0F);
    this.z = new TextView(this);
    this.z.setText(2131888812);
    this.z.setVisibility(4);
    this.z.setTextColor(getResources().getColor(2131167885));
    this.z.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, a(30.0F));
    localLayoutParams.addRule(13);
    this.w.addView(this.x, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 241);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = a(5.0F);
    this.w.addView(this.y, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 242);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = a(5.0F);
    this.w.addView(this.z, localLayoutParams);
    this.w.setVisibility(4);
    return this.w;
  }
  
  private boolean g()
  {
    return ("application/vnd.android.package-archive".equals(this.u)) || (this.q.toLowerCase().endsWith(".apk"));
  }
  
  private boolean h()
  {
    return AppUtil.d("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void i()
  {
    if (h()) {
      OpenSdkStatic.a().a(this.t, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    } else {
      OpenSdkStatic.a().a(this.t, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
    }
    if (NetworkUtil.isNetSupport(getActivity()))
    {
      if (FileManagerUtil.b())
      {
        FMDialogUtil.a(getActivity(), 2131889584, 2131917699, new UniformDownloadActivity.8(this));
        return;
      }
      d();
      return;
    }
    FMToastUtil.a(2131889577);
    finish();
    overridePendingTransition(0, 0);
  }
  
  @NonNull
  private OuterCallReportModel j()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 1;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mVia = "ANDROIDQQ.POPUP.YYBDOWNAPP";
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  public void a()
  {
    this.n = ((ActionSheet)ActionSheetHelper.b(getActivity(), null));
    Object localObject = SharedPreUtils.az(this, "noSafeDown");
    Log.d(a, this.p);
    if (((String)localObject).equals("true"))
    {
      this.n.addButton(2131886907);
    }
    else
    {
      int i1 = 0;
      boolean bool1;
      if (g())
      {
        boolean bool2 = a(this.p);
        bool1 = bool2;
        if (bool2)
        {
          DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.p);
          Log.d(a, "url is blocked!! show only normal download");
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
          this.n.addButton(2131886907);
        } else {
          this.n.addButton(2131888792);
        }
      }
      else {
        this.n.addButton(2131886908);
      }
    }
    this.n.setOnButtonClickListener(this.C);
    this.n.setOnDismissListener(new UniformDownloadActivity.4(this));
    this.n.show();
    this.n.setOnKeyListener(new UniformDownloadActivity.5(this));
    localObject = LayoutInflater.from(this).inflate(2131624005, null);
    Button localButton = (Button)((View)localObject).findViewById(2131427548);
    localButton.setOnClickListener(this.B);
    localButton.setText(2131888791);
    localButton.setTextColor(getResources().getColor(2131165408));
    this.n.addView((View)localObject);
    OpenSdkStatic.a().a(this.t, "", "ANDROIDQQ.POPUP", "100", false);
    ReportController.b(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
  }
  
  protected IUniformDownloadMgr b()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
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
    this.p = paramBundle.getStringExtra(b);
    this.q = paramBundle.getStringExtra(d);
    this.r = paramBundle.getLongExtra(e, 0L);
    this.u = paramBundle.getStringExtra(j);
    this.v = paramBundle.getStringExtra(k);
    this.A = paramBundle.getBooleanExtra("fromArkAppDownload", false);
    this.m = ((QQAppInterface)getAppRuntime());
    this.t = this.m.getCurrentAccountUin();
    if (paramBundle.getBooleanExtra(i, false))
    {
      c();
    }
    else
    {
      setContentView(f(), new FrameLayout.LayoutParams(-1, -1));
      a();
    }
    if (this.v == null) {
      this.v = "";
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.9(this));
    b().removeOuterListenner(this.p);
    this.m = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */