package com.tencent.open.filedownload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import bdla;
import bgvp;
import bjjq;
import bjkf;
import bjkg;
import bjkh;
import bjki;
import bjko;
import bjkv;
import bjox;
import bjoy;
import bjoz;
import bjpa;
import bjpb;
import bjpc;
import bjpe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjpb jdField_a_of_type_Bjpb;
  private bjpe jdField_a_of_type_Bjpe;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bjpe jdField_b_of_type_Bjpe;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bjko.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bjpe.f + "|" + NetworkUtil.isNetworkAvailable(getActivity()) + "|" + NetworkUtil.isWifiConnected(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bjpe.f, "com.tencent.weishi")) && (NetworkUtil.isNetworkAvailable(getActivity())) && (NetworkUtil.isWifiConnected(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bjpe parambjpe)
  {
    bjpc.a(this.jdField_a_of_type_AndroidWidgetImageView, parambjpe.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambjpe.h);
    if (parambjpe.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bjjq.a().b(parambjpe.e);
      if (localDownloadInfo != null) {
        parambjpe.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambjpe.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bgvp.a((float)parambjpe.jdField_a_of_type_Long, true, 2));
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
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bjpe.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bjpe.h)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    bjkf.a(bjkg.a().k(this.jdField_a_of_type_Bjpb.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bjpb.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjpe.h).b(this.jdField_a_of_type_Bjpe.f).g(this.jdField_a_of_type_Bjpe.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bjpe.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bjpe.h)
      {
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bjpe.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bjpe.h)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bjkv.a().a(anvx.a(2131699781));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bjpb = bjpb.jdField_a_of_type_Bjpb;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bjpe = new bjpe();
      this.jdField_a_of_type_Bjpe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjpb.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bjpe.d = this.jdField_a_of_type_Bjpb.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bjpe.e = localBundle.getString("param_url");
      bjko.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bjpe.e);
      this.jdField_a_of_type_Bjpe.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bjko.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bjpe.e)) {
            this.jdField_a_of_type_Bjpe.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bjpe.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bjpe.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bjpe.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bjpe.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bjpe.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bjpe.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bjpe.h = bjpc.a(this.jdField_a_of_type_Bjpe.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bjko.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bjpb + "\nTaskInfo:" + this.jdField_a_of_type_Bjpe + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bjpe.e)) {
        break;
      }
      bjkv.a().a(anvx.a(2131699778));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bjpc.a()) {
        this.jdField_a_of_type_Bjpb = bjpb.jdField_b_of_type_Bjpb;
      } else {
        this.jdField_a_of_type_Bjpb = bjpb.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(anvx.a(2131699779));
    this.leftView.setOnClickListener(new bjox(this));
    setTitle(anvx.a(2131699783));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368494));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380355));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380354));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363971));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131364023));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131364086));
    this.c = ((TextView)a(2131380371));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bjpe.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bjpe);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bjpe);
      return;
      this.jdField_b_of_type_Bjpe = bjpe.a(this.jdField_a_of_type_Bjpe);
      this.jdField_b_of_type_Bjpe.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bjpe.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bjpe.h = anvx.a(2131699775);
      this.jdField_b_of_type_Bjpe.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bjpe.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bjpe);
      this.jdField_b_of_type_Bjpe.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bjpe);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bjoy(this));
      this.jdField_a_of_type_Bjpe.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bjpe);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bjoz(this));
      this.c.setText(anvx.a(2131699784));
      this.c.setOnClickListener(new bjpa(this));
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    QAppCenterPluginProxyActivityTools.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    c();
    d();
    e();
    b();
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559693;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bjkf.b(bjkh.a().a("301").k(this.jdField_a_of_type_Bjpb.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bjpb.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjpe.h).b(this.jdField_a_of_type_Bjpe.f).g(this.jdField_a_of_type_Bjpe.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bjkf.b(bjkh.a().a("200").k(this.jdField_a_of_type_Bjpb.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bjpb.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjpe.h).b(this.jdField_a_of_type_Bjpe.f).g(this.jdField_a_of_type_Bjpe.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bjko.b("ApkFileDownloadFragment_", "[onDestroy]");
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.c();
    }
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.c();
    }
    if (this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton != null) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.c();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    bjko.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */