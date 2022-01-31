package com.tencent.mobileqq.filemanager.activity;

import alck;
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
import anyp;
import anyr;
import anys;
import anyt;
import anyu;
import anyv;
import anyw;
import anyx;
import anyy;
import anyz;
import aome;
import apbx;
import apcb;
import apck;
import apdh;
import apeq;
import awqx;
import badq;
import baig;
import bcev;
import bcfn;
import bcgn;
import begq;
import begr;
import begw;
import behe;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new anyx(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apeq jdField_a_of_type_Apeq = new anys(this);
  private bcgn jdField_a_of_type_Bcgn = new anyr(this);
  public begr a;
  private begw jdField_a_of_type_Begw = new anyy(this);
  public QQAppInterface a;
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
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839117));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(241);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(242);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131626357);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101167));
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
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
    if (localPortalManager == null) {
      return true;
    }
    if (((!alck.f) || (!this.jdField_a_of_type_Boolean)) && (localPortalManager.a(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    super.setContentView(2131494923);
    Object localObject1 = (TextView)findViewById(2131312788);
    Object localObject2 = (TextView)findViewById(2131312789);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131312787));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject2).setText(2131624901);
      }
      ((TextView)localObject2).setOnClickListener(new anyp(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new anyt(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131312793);
    TextView localTextView2 = (TextView)findViewById(2131312794);
    ImageView localImageView = (ImageView)findViewById(2131312792);
    localObject2 = localIntent.getStringExtra(h);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.o;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(apdh.a(this.jdField_a_of_type_Long));
    int i1 = apck.b(this.o);
    localObject1 = localIntent.getStringExtra(g);
    if (i1 != 0) {
      localImageView.setImageResource(i1);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new anyu(this, localImageView));
        localImageView.setImageDrawable((Drawable)localObject1);
      }
      return;
      localImageView.setImageResource(2130843462);
    }
  }
  
  private boolean b()
  {
    return bcev.a("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void c()
  {
    awqx.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.o);
    localBundle.putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_WEBVIEW");
    localBundle.putString("FILE_MIME_TYPE", this.q);
    localBundle.putString("param_refer_url", this.r);
    aome.a().a(this.n, localBundle, this.jdField_a_of_type_Apeq);
    d();
    bcfn.a().a(this.p, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    awqx.b(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
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
      bcfn.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    }
    while (badq.d(getActivity())) {
      if (apck.a())
      {
        apbx.a(getActivity(), 2131627035, 2131654705, new anyz(this));
        return;
        bcfn.a().a(this.p, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
      }
      else
      {
        c();
        return;
      }
    }
    apcb.a(2131627028);
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Begr = ((begr)behe.a(getActivity(), null));
    int i1 = 1;
    View localView = null;
    Object localObject = baig.j(this, "noSafeDown");
    Log.d(jdField_a_of_type_JavaLangString, this.n);
    if (((String)localObject).equals("true"))
    {
      this.jdField_a_of_type_Begr.b(2131624586);
      localObject = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_Begw);
      this.jdField_a_of_type_Begr.a(new anyv(this));
      this.jdField_a_of_type_Begr.show();
      this.jdField_a_of_type_Begr.setOnKeyListener(new anyw(this));
      localView = LayoutInflater.from(this).inflate(2131492896, null);
      Button localButton = (Button)localView.findViewById(2131296377);
      localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localButton.setText(2131626338);
      localButton.setTextColor(getResources().getColor(2131099667));
      this.jdField_a_of_type_Begr.a(localView);
      if (localObject != null)
      {
        localObject = (TextView)this.jdField_a_of_type_Begr.findViewById(((begq)localObject).b);
        ((TextView)localObject).setTextColor(getResources().getColor(2131099665));
        ((TextView)localObject).getPaint().setFakeBoldText(true);
      }
      bcfn.a().a(this.p, "", "ANDROIDQQ.POPUP", "100", false);
      awqx.b(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
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
          localObject = new begq(2131299780, getString(2131626340), 0, 0);
          this.jdField_a_of_type_Begr.a((begq)localObject, 0);
          i1 = bool3;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (bool1)
          {
            this.jdField_a_of_type_Begr.b(2131624586);
            break;
            label389:
            Log.d(jdField_a_of_type_JavaLangString, "url is blocked!! show only normal download");
            localObject = localView;
            i1 = bool3;
            continue;
          }
          this.jdField_a_of_type_Begr.b(2131626339);
          break;
        }
      }
      if (localObject == null) {
        this.jdField_a_of_type_Begr.b(2131624587);
      }
    }
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
    aome.a().a(this.n);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */