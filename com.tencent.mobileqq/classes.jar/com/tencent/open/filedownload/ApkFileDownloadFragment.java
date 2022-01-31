package com.tencent.open.filedownload;

import ajjy;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import awqx;
import badq;
import badr;
import bccu;
import bcdj;
import bcdk;
import bcdl;
import bcdm;
import bcds;
import bcec;
import bcil;
import bcim;
import bcin;
import bcio;
import bcip;
import bciq;
import bcis;
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
  private bcip jdField_a_of_type_Bcip;
  private bcis jdField_a_of_type_Bcis;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bcis jdField_b_of_type_Bcis;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bcds.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bcis.f + "|" + badq.g(getActivity()) + "|" + badq.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bcis.f, "com.tencent.weishi")) && (badq.g(getActivity())) && (badq.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bcis parambcis)
  {
    bciq.a(this.jdField_a_of_type_AndroidWidgetImageView, parambcis.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambcis.h);
    if (parambcis.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bccu.a().b(parambcis.e);
      if (localDownloadInfo != null) {
        parambcis.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambcis.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(badr.a((float)parambcis.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bcis.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bcis.h)
    {
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bcdj.a(bcdk.a().k(this.jdField_a_of_type_Bcip.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bcip.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bcis.h).b(this.jdField_a_of_type_Bcis.f).g(this.jdField_a_of_type_Bcis.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bcis.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bcis.h)
      {
        awqx.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bcis.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bcis.h)
    {
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bcec.a().a(ajjy.a(2131634482));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bcip = bcip.jdField_a_of_type_Bcip;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bcis = new bcis();
      this.jdField_a_of_type_Bcis.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bcip.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bcis.d = this.jdField_a_of_type_Bcip.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bcis.e = localBundle.getString("param_url");
      bcds.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bcis.e);
      this.jdField_a_of_type_Bcis.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bcds.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bcis.e)) {
            this.jdField_a_of_type_Bcis.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bcis.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bcis.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bcis.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bcis.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bcis.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcis.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bcis.h = bciq.a(this.jdField_a_of_type_Bcis.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bcds.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bcip + "\nTaskInfo:" + this.jdField_a_of_type_Bcis + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcis.e)) {
        break;
      }
      bcec.a().a(ajjy.a(2131634479));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bciq.a()) {
        this.jdField_a_of_type_Bcip = bcip.jdField_b_of_type_Bcip;
      } else {
        this.jdField_a_of_type_Bcip = bcip.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(ajjy.a(2131634480));
    this.leftView.setOnClickListener(new bcil(this));
    setTitle(ajjy.a(2131634484));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131302153));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131312685));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131312684));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131298049));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131298090));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131298147));
    this.c = ((TextView)a(2131312701));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bcis.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bcis);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bcis);
      return;
      this.jdField_b_of_type_Bcis = bcis.a(this.jdField_a_of_type_Bcis);
      this.jdField_b_of_type_Bcis.e = "http://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bcis.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bcis.h = ajjy.a(2131634476);
      this.jdField_b_of_type_Bcis.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bcis.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bcis);
      this.jdField_b_of_type_Bcis.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bcis);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bcim(this));
      this.jdField_a_of_type_Bcis.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bcis);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bcin(this));
      this.c.setText(ajjy.a(2131634485));
      this.c.setOnClickListener(new bcio(this));
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
    return 2131493895;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bcdj.b(bcdl.a().a("301").k(this.jdField_a_of_type_Bcip.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bcip.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bcis.h).b(this.jdField_a_of_type_Bcis.f).g(this.jdField_a_of_type_Bcis.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bcdj.b(bcdl.a().a("200").k(this.jdField_a_of_type_Bcip.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bcip.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bcis.h).b(this.jdField_a_of_type_Bcis.f).g(this.jdField_a_of_type_Bcis.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bcds.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bcds.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */