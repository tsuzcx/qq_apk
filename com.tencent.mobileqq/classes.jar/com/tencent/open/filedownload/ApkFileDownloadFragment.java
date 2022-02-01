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
import anni;
import bcst;
import bgdl;
import bgnt;
import bisa;
import bisp;
import bisq;
import bisr;
import biss;
import bisy;
import biti;
import bixo;
import bixp;
import bixq;
import bixr;
import bixs;
import bixt;
import bixv;
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
  private bixs jdField_a_of_type_Bixs;
  private bixv jdField_a_of_type_Bixv;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bixv jdField_b_of_type_Bixv;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bisy.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bixv.f + "|" + bgnt.g(getActivity()) + "|" + bgnt.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bixv.f, "com.tencent.weishi")) && (bgnt.g(getActivity())) && (bgnt.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bixv parambixv)
  {
    bixt.a(this.jdField_a_of_type_AndroidWidgetImageView, parambixv.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambixv.h);
    if (parambixv.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bisa.a().b(parambixv.e);
      if (localDownloadInfo != null) {
        parambixv.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambixv.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bgdl.a((float)parambixv.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bixv.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bixv.h)
    {
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bisp.a(bisq.a().k(this.jdField_a_of_type_Bixs.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bixs.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bixv.h).b(this.jdField_a_of_type_Bixv.f).g(this.jdField_a_of_type_Bixv.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bixv.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bixv.h)
      {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bixv.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bixv.h)
    {
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      biti.a().a(anni.a(2131699088));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bixs = bixs.jdField_a_of_type_Bixs;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bixv = new bixv();
      this.jdField_a_of_type_Bixv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bixs.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bixv.d = this.jdField_a_of_type_Bixs.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bixv.e = localBundle.getString("param_url");
      bisy.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bixv.e);
      this.jdField_a_of_type_Bixv.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bisy.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bixv.e)) {
            this.jdField_a_of_type_Bixv.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bixv.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bixv.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bixv.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bixv.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bixv.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bixv.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bixv.h = bixt.a(this.jdField_a_of_type_Bixv.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bisy.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bixs + "\nTaskInfo:" + this.jdField_a_of_type_Bixv + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bixv.e)) {
        break;
      }
      biti.a().a(anni.a(2131699085));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bixt.a()) {
        this.jdField_a_of_type_Bixs = bixs.jdField_b_of_type_Bixs;
      } else {
        this.jdField_a_of_type_Bixs = bixs.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(anni.a(2131699086));
    this.leftView.setOnClickListener(new bixo(this));
    setTitle(anni.a(2131699090));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368239));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380109));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380108));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363849));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363899));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363963));
    this.c = ((TextView)a(2131380125));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bixv.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bixv);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bixv);
      return;
      this.jdField_b_of_type_Bixv = bixv.a(this.jdField_a_of_type_Bixv);
      this.jdField_b_of_type_Bixv.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bixv.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bixv.h = anni.a(2131699082);
      this.jdField_b_of_type_Bixv.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bixv.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bixv);
      this.jdField_b_of_type_Bixv.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bixv);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bixp(this));
      this.jdField_a_of_type_Bixv.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bixv);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bixq(this));
      this.c.setText(anni.a(2131699091));
      this.c.setOnClickListener(new bixr(this));
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
    return 2131559650;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bisp.b(bisr.a().a("301").k(this.jdField_a_of_type_Bixs.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bixs.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bixv.h).b(this.jdField_a_of_type_Bixv.f).g(this.jdField_a_of_type_Bixv.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bisp.b(bisr.a().a("200").k(this.jdField_a_of_type_Bixs.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bixs.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bixv.h).b(this.jdField_a_of_type_Bixv.f).g(this.jdField_a_of_type_Bixv.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bisy.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bisy.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */