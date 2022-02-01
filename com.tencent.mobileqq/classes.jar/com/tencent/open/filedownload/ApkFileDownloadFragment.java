package com.tencent.open.filedownload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.AppExposureDataBuilder;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.ui.NormalDownloadButton;
import com.tencent.open.filedownload.ui.SafeDownloadButton;
import com.tencent.open.filedownload.ui.WhiteListDownloadButton;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import org.json.JSONException;
import org.json.JSONObject;

public class ApkFileDownloadFragment
  extends IphoneTitleBarFragment
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private NormalDownloadButton d;
  private SafeDownloadButton e;
  private WhiteListDownloadButton f;
  private TextView g;
  private boolean h;
  private TaskInfo i;
  private TaskInfo j;
  private ApkFileDownloadFragment.PageType k;
  private BaseActivity l;
  private String m;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">specialCode ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append(this.i.f);
    localStringBuilder.append("|");
    localStringBuilder.append(NetworkUtil.isNetworkAvailable(getBaseActivity()));
    localStringBuilder.append("|");
    localStringBuilder.append(NetworkUtil.isWifiConnected(getBaseActivity()));
    LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
    if ((this.h) && (TextUtils.equals(this.i.f, "com.tencent.weishi")) && (NetworkUtil.isNetworkAvailable(getBaseActivity())) && (NetworkUtil.isWifiConnected(getBaseActivity()))) {
      this.f.a(true, true);
    }
  }
  
  private void a(TaskInfo paramTaskInfo)
  {
    CommonUtils.a(this.a, paramTaskInfo.g);
    this.b.setText(paramTaskInfo.i);
    if (paramTaskInfo.h <= 0L)
    {
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(paramTaskInfo.e);
      if (localDownloadInfo != null) {
        paramTaskInfo.h = localDownloadInfo.E;
      }
    }
    if (paramTaskInfo.h > 0L)
    {
      this.c.setVisibility(0);
      this.c.setText(NewUpgradeDialog.a((float)paramTaskInfo.h, true, 2));
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    this.d.setVisibility(0);
    this.d.a(paramBoolean, true);
    this.e.d();
    this.e.setVisibility(8);
    this.g.setVisibility(4);
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    String str;
    if (this.i.i == null) {
      str = "";
    } else {
      str = this.i.i;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
  }
  
  private void b()
  {
    AppCenterReporter.a(AppExposureDataBuilder.a().l(this.k.e).k("0").m("0").n(this.k.d).b(this.i.i).c(this.i.f).h(this.i.e));
    boolean bool = this.h;
    String str = "";
    if (bool)
    {
      localQQAppInterface = getBaseActivity().app;
      if (this.i.i != null) {
        str = this.i.i;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
      return;
    }
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if (this.i.i != null) {
      str = this.i.i;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
  }
  
  private void c()
  {
    Object localObject1 = getArguments();
    if (localObject1 == null)
    {
      ToastUtil.a().a(HardCodeUtil.a(2131898532));
      this.l.finish();
      return;
    }
    this.h = ((Bundle)localObject1).getBoolean("param_in_white_list", false);
    if (this.h) {
      this.k = ApkFileDownloadFragment.PageType.a;
    } else if (CommonUtils.a()) {
      this.k = ApkFileDownloadFragment.PageType.b;
    } else {
      this.k = ApkFileDownloadFragment.PageType.c;
    }
    Object localObject2 = ((Bundle)localObject1).getString("param_ext_info");
    this.i = new TaskInfo();
    this.i.a = this.k.e;
    this.i.d = this.k.d;
    this.i.e = ((Bundle)localObject1).getString("param_url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RealUrl:");
    localStringBuilder.append(this.i.e);
    LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
    this.i.h = ((Bundle)localObject1).getLong("_filesize");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("appInfoJson:");
        localStringBuilder.append((String)localObject2);
        LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
        localObject2 = new JSONObject((String)localObject2);
        if (TextUtils.isEmpty(this.i.e)) {
          this.i.e = ((JSONObject)localObject2).optString("url");
        }
        this.i.g = ((JSONObject)localObject2).optString("app_icon");
        this.i.i = ((JSONObject)localObject2).optString("app_name");
        if (this.i.h <= 0L) {
          this.i.h = ((JSONObject)localObject2).optLong("app_filesize");
        }
        this.i.f = ((JSONObject)localObject2).optString("packagename");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (TextUtils.isEmpty(this.i.e))
    {
      ToastUtil.a().a(HardCodeUtil.a(2131898530));
      this.l.finish();
      return;
    }
    if (TextUtils.isEmpty(this.i.i))
    {
      TaskInfo localTaskInfo = this.i;
      localTaskInfo.i = CommonUtils.a(localTaskInfo.e);
    }
    this.m = ((Bundle)localObject1).getString("big_brother_source_key");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mPageType:");
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).append("\nTaskInfo:");
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append("\nmSource:");
    ((StringBuilder)localObject1).append(this.m);
    LogUtility.b("ApkFileDownloadFragment_", ((StringBuilder)localObject1).toString());
  }
  
  private void d()
  {
    this.leftView.setText(HardCodeUtil.a(2131901576));
    this.leftView.setOnClickListener(new ApkFileDownloadFragment.1(this));
    setTitle(HardCodeUtil.a(2131898534));
    this.a = ((ImageView)a(2131435346));
    this.b = ((TextView)a(2131448974));
    this.c = ((TextView)a(2131448973));
    this.d = ((NormalDownloadButton)a(2131429946));
    this.e = ((SafeDownloadButton)a(2131430003));
    this.f = ((WhiteListDownloadButton)a(2131430073));
    this.g = ((TextView)a(2131448990));
  }
  
  private void e()
  {
    this.e.setSource(this.m);
    this.f.setSource(this.m);
    this.d.setSource(this.m);
    TaskInfo localTaskInfo;
    if (this.h)
    {
      this.f.setVisibility(0);
      localTaskInfo = this.i;
      localTaskInfo.b = "3";
      this.f.setApkInfo(localTaskInfo);
      this.g.setVisibility(8);
    }
    else
    {
      this.j = TaskInfo.a(this.i);
      localTaskInfo = this.j;
      localTaskInfo.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      localTaskInfo.f = "com.tencent.android.qqdownloader";
      localTaskInfo.i = HardCodeUtil.a(2131898527);
      this.j.h = 0L;
      this.e.setVisibility(8);
      localTaskInfo = this.i;
      localTaskInfo.b = "3";
      this.e.setOriApkInfo(localTaskInfo);
      localTaskInfo = this.j;
      localTaskInfo.b = "3";
      this.e.setApkInfo(localTaskInfo);
      this.e.setEventCallback(new ApkFileDownloadFragment.2(this));
      localTaskInfo = this.i;
      localTaskInfo.b = "4";
      this.d.setApkInfo(localTaskInfo);
      this.d.setEventCallback(new ApkFileDownloadFragment.3(this));
      this.g.setText(HardCodeUtil.a(2131898535));
      this.g.setOnClickListener(new ApkFileDownloadFragment.4(this));
    }
    a(this.i);
  }
  
  private boolean f()
  {
    boolean bool2 = this.h;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (this.d.getVisibility() == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.l = getBaseActivity();
    QAppCenterPluginProxyActivityTools.a(this.l);
    c();
    d();
    e();
    b();
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625675;
  }
  
  public boolean onBackEvent()
  {
    if (f())
    {
      AppCenterReporter.b(ClickDataBuilder.a().a("301").l(this.k.e).k("2").m("0").n(this.k.d).b(this.i.i).c(this.i.f).h(this.i.e));
      this.d.b(false, true);
      return true;
    }
    AppCenterReporter.b(ClickDataBuilder.a().a("200").l(this.k.e).k("2").m("0").n(this.k.d).b(this.i.i).c(this.i.f).h(this.i.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    LogUtility.b("ApkFileDownloadFragment_", "[onDestroy]");
    Object localObject = this.d;
    if (localObject != null) {
      ((NormalDownloadButton)localObject).c();
    }
    localObject = this.f;
    if (localObject != null) {
      ((WhiteListDownloadButton)localObject).c();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SafeDownloadButton)localObject).c();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    LogUtility.b("ApkFileDownloadFragment_", "[onResume]");
    this.e.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */