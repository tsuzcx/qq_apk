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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ApkFileDownloadFragment.PageType jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType;
  private TaskInfo jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TaskInfo jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">specialCode ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f);
    localStringBuilder.append("|");
    localStringBuilder.append(NetworkUtil.isNetworkAvailable(getBaseActivity()));
    localStringBuilder.append("|");
    localStringBuilder.append(NetworkUtil.isWifiConnected(getBaseActivity()));
    LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f, "com.tencent.weishi")) && (NetworkUtil.isNetworkAvailable(getBaseActivity())) && (NetworkUtil.isWifiConnected(getBaseActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(TaskInfo paramTaskInfo)
  {
    CommonUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramTaskInfo.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTaskInfo.h);
    if (paramTaskInfo.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(paramTaskInfo.e);
      if (localDownloadInfo != null) {
        paramTaskInfo.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (paramTaskInfo.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(NewUpgradeDialog.a((float)paramTaskInfo.jdField_a_of_type_Long, true, 2));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.a(paramBoolean, true);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.d();
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(8);
    this.c.setVisibility(4);
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    String str;
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h == null) {
      str = "";
    } else {
      str = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
  }
  
  private boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.getVisibility() == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b()
  {
    AppCenterReporter.a(AppExposureDataBuilder.a().k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
    boolean bool = this.jdField_a_of_type_Boolean;
    String str = "";
    if (bool)
    {
      localQQAppInterface = getBaseActivity().app;
      if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h != null) {
        str = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
      return;
    }
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h != null) {
      str = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
  }
  
  private void c()
  {
    Object localObject1 = getArguments();
    if (localObject1 == null)
    {
      ToastUtil.a().a(HardCodeUtil.a(2131700501));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = ((Bundle)localObject1).getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType = ApkFileDownloadFragment.PageType.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType;
    } else if (CommonUtils.a()) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType = ApkFileDownloadFragment.PageType.jdField_b_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType;
    } else {
      this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType = ApkFileDownloadFragment.PageType.c;
    }
    Object localObject2 = ((Bundle)localObject1).getString("param_ext_info");
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo = new TaskInfo();
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.d = this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e = ((Bundle)localObject1).getString("param_url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RealUrl:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e);
    LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long = ((Bundle)localObject1).getLong("_filesize");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("appInfoJson:");
        localStringBuilder.append((String)localObject2);
        LogUtility.b("ApkFileDownloadFragment_", localStringBuilder.toString());
        localObject2 = new JSONObject((String)localObject2);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e)) {
          this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e = ((JSONObject)localObject2).optString("url");
        }
        this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.g = ((JSONObject)localObject2).optString("app_icon");
        this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h = ((JSONObject)localObject2).optString("app_name");
        if (this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("app_filesize");
        }
        this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f = ((JSONObject)localObject2).optString("packagename");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e))
    {
      ToastUtil.a().a(HardCodeUtil.a(2131700498));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h))
    {
      TaskInfo localTaskInfo = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.h = CommonUtils.a(localTaskInfo.e);
    }
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("big_brother_source_key");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mPageType:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType);
    ((StringBuilder)localObject1).append("\nTaskInfo:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo);
    ((StringBuilder)localObject1).append("\nmSource:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    LogUtility.b("ApkFileDownloadFragment_", ((StringBuilder)localObject1).toString());
  }
  
  private void d()
  {
    this.leftView.setText(HardCodeUtil.a(2131700499));
    this.leftView.setOnClickListener(new ApkFileDownloadFragment.1(this));
    setTitle(HardCodeUtil.a(2131700503));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368450));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380061));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380060));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363989));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131364045));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131364107));
    this.c = ((TextView)a(2131380077));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    TaskInfo localTaskInfo;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      localTaskInfo = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(localTaskInfo);
      this.c.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo = TaskInfo.a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo);
      localTaskInfo = this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      localTaskInfo.f = "com.tencent.android.qqdownloader";
      localTaskInfo.h = HardCodeUtil.a(2131700495);
      this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(8);
      localTaskInfo = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(localTaskInfo);
      localTaskInfo = this.jdField_b_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(localTaskInfo);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new ApkFileDownloadFragment.2(this));
      localTaskInfo = this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo;
      localTaskInfo.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(localTaskInfo);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new ApkFileDownloadFragment.3(this));
      this.c.setText(HardCodeUtil.a(2131700504));
      this.c.setOnClickListener(new ApkFileDownloadFragment.4(this));
    }
    a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    QAppCenterPluginProxyActivityTools.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    c();
    d();
    e();
    b();
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131559646;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      AppCenterReporter.b(ClickDataBuilder.a().a("301").k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    AppCenterReporter.b(ClickDataBuilder.a().a("200").k(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_ComTencentOpenFiledownloadApkFileDownloadFragment$PageType.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadTaskInfo.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    LogUtility.b("ApkFileDownloadFragment_", "[onDestroy]");
    Object localObject = this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
    if (localObject != null) {
      ((NormalDownloadButton)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
    if (localObject != null) {
      ((WhiteListDownloadButton)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
    if (localObject != null) {
      ((SafeDownloadButton)localObject).c();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    LogUtility.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */