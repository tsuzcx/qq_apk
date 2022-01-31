package com.tencent.open.filedownload;

import ajyc;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import axqw;
import bbev;
import bbew;
import bdgv;
import bdhk;
import bdhl;
import bdhm;
import bdhn;
import bdht;
import bdid;
import bdmm;
import bdmn;
import bdmo;
import bdmp;
import bdmq;
import bdmr;
import bdmt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
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
  private bdmq jdField_a_of_type_Bdmq;
  private bdmt jdField_a_of_type_Bdmt;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bdmt jdField_b_of_type_Bdmt;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bdht.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bdmt.f + "|" + bbev.g(getActivity()) + "|" + bbev.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bdmt.f, "com.tencent.weishi")) && (bbev.g(getActivity())) && (bbev.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bdmt parambdmt)
  {
    bdmr.a(this.jdField_a_of_type_AndroidWidgetImageView, parambdmt.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambdmt.h);
    if (parambdmt.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bdgv.a().b(parambdmt.e);
      if (localDownloadInfo != null) {
        parambdmt.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambdmt.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bbew.a((float)parambdmt.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bdmt.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bdmt.h)
    {
      axqw.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bdhk.a(bdhl.a().k(this.jdField_a_of_type_Bdmq.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bdmq.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bdmt.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bdmt.h)
      {
        axqw.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bdmt.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bdmt.h)
    {
      axqw.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bdid.a().a(ajyc.a(2131700270));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bdmq = bdmq.jdField_a_of_type_Bdmq;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bdmt = new bdmt();
      this.jdField_a_of_type_Bdmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdmq.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bdmt.d = this.jdField_a_of_type_Bdmq.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bdmt.e = localBundle.getString("param_url");
      bdht.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bdmt.e);
      this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bdht.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bdmt.e)) {
            this.jdField_a_of_type_Bdmt.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bdmt.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bdmt.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bdmt.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdmt.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bdmt.h = bdmr.a(this.jdField_a_of_type_Bdmt.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bdht.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bdmq + "\nTaskInfo:" + this.jdField_a_of_type_Bdmt + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdmt.e)) {
        break;
      }
      bdid.a().a(ajyc.a(2131700267));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bdmr.a()) {
        this.jdField_a_of_type_Bdmq = bdmq.jdField_b_of_type_Bdmq;
      } else {
        this.jdField_a_of_type_Bdmq = bdmq.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(ajyc.a(2131700268));
    this.leftView.setOnClickListener(new bdmm(this));
    setTitle(ajyc.a(2131700272));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367771));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378509));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378508));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363599));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363642));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363700));
    this.c = ((TextView)a(2131378525));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bdmt);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bdmt);
      return;
      this.jdField_b_of_type_Bdmt = bdmt.a(this.jdField_a_of_type_Bdmt);
      this.jdField_b_of_type_Bdmt.e = "http://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bdmt.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bdmt.h = ajyc.a(2131700264);
      this.jdField_b_of_type_Bdmt.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bdmt);
      this.jdField_b_of_type_Bdmt.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bdmt);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bdmn(this));
      this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bdmt);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bdmo(this));
      this.c.setText(ajyc.a(2131700273));
      this.c.setOnClickListener(new bdmp(this));
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
    return 2131559463;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bdhk.b(bdhm.a().a("301").k(this.jdField_a_of_type_Bdmq.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bdmq.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bdhk.b(bdhm.a().a("200").k(this.jdField_a_of_type_Bdmq.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bdmq.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bdht.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bdht.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */