package com.tencent.open.filedownload;

import ajya;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import axqy;
import bbfj;
import bbfk;
import bdhk;
import bdhz;
import bdia;
import bdib;
import bdic;
import bdii;
import bdis;
import bdnb;
import bdnc;
import bdnd;
import bdne;
import bdnf;
import bdng;
import bdni;
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
  private bdnf jdField_a_of_type_Bdnf;
  private bdni jdField_a_of_type_Bdni;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bdni jdField_b_of_type_Bdni;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bdii.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bdni.f + "|" + bbfj.g(getActivity()) + "|" + bbfj.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bdni.f, "com.tencent.weishi")) && (bbfj.g(getActivity())) && (bbfj.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bdni parambdni)
  {
    bdng.a(this.jdField_a_of_type_AndroidWidgetImageView, parambdni.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambdni.h);
    if (parambdni.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bdhk.a().b(parambdni.e);
      if (localDownloadInfo != null) {
        parambdni.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambdni.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bbfk.a((float)parambdni.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bdni.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bdni.h)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bdhz.a(bdia.a().k(this.jdField_a_of_type_Bdnf.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bdnf.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdni.h).b(this.jdField_a_of_type_Bdni.f).g(this.jdField_a_of_type_Bdni.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bdni.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bdni.h)
      {
        axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bdni.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bdni.h)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bdis.a().a(ajya.a(2131700281));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bdnf = bdnf.jdField_a_of_type_Bdnf;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bdni = new bdni();
      this.jdField_a_of_type_Bdni.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdnf.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bdni.d = this.jdField_a_of_type_Bdnf.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bdni.e = localBundle.getString("param_url");
      bdii.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bdni.e);
      this.jdField_a_of_type_Bdni.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bdii.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bdni.e)) {
            this.jdField_a_of_type_Bdni.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bdni.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bdni.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bdni.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bdni.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bdni.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdni.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bdni.h = bdng.a(this.jdField_a_of_type_Bdni.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bdii.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bdnf + "\nTaskInfo:" + this.jdField_a_of_type_Bdni + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdni.e)) {
        break;
      }
      bdis.a().a(ajya.a(2131700278));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bdng.a()) {
        this.jdField_a_of_type_Bdnf = bdnf.jdField_b_of_type_Bdnf;
      } else {
        this.jdField_a_of_type_Bdnf = bdnf.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(ajya.a(2131700279));
    this.leftView.setOnClickListener(new bdnb(this));
    setTitle(ajya.a(2131700283));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367771));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378514));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378513));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363598));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363641));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363699));
    this.c = ((TextView)a(2131378530));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bdni);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bdni);
      return;
      this.jdField_b_of_type_Bdni = bdni.a(this.jdField_a_of_type_Bdni);
      this.jdField_b_of_type_Bdni.e = "http://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bdni.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bdni.h = ajya.a(2131700275);
      this.jdField_b_of_type_Bdni.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bdni);
      this.jdField_b_of_type_Bdni.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bdni);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bdnc(this));
      this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bdni);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bdnd(this));
      this.c.setText(ajya.a(2131700284));
      this.c.setOnClickListener(new bdne(this));
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
      bdhz.b(bdib.a().a("301").k(this.jdField_a_of_type_Bdnf.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bdnf.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdni.h).b(this.jdField_a_of_type_Bdni.f).g(this.jdField_a_of_type_Bdni.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bdhz.b(bdib.a().a("200").k(this.jdField_a_of_type_Bdnf.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bdnf.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bdni.h).b(this.jdField_a_of_type_Bdni.f).g(this.jdField_a_of_type_Bdni.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bdii.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bdii.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */