package com.tencent.open.filedownload;

import amtj;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bcef;
import bfmy;
import bhyo;
import bhzd;
import bhze;
import bhzf;
import bhzg;
import bhzm;
import bhzt;
import bidv;
import bidw;
import bidx;
import bidy;
import bidz;
import biea;
import biec;
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
  private bidz jdField_a_of_type_Bidz;
  private biec jdField_a_of_type_Biec;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private biec jdField_b_of_type_Biec;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bhzm.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Biec.f + "|" + NetworkUtil.isNetworkAvailable(getActivity()) + "|" + NetworkUtil.isWifiConnected(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Biec.f, "com.tencent.weishi")) && (NetworkUtil.isNetworkAvailable(getActivity())) && (NetworkUtil.isWifiConnected(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(biec parambiec)
  {
    biea.a(this.jdField_a_of_type_AndroidWidgetImageView, parambiec.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambiec.h);
    if (parambiec.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bhyo.a().b(parambiec.e);
      if (localDownloadInfo != null) {
        parambiec.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambiec.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bfmy.a((float)parambiec.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Biec.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Biec.h)
    {
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bhzd.a(bhze.a().k(this.jdField_a_of_type_Bidz.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bidz.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Biec.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Biec.h)
      {
        bcef.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Biec.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Biec.h)
    {
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bhzt.a().a(amtj.a(2131699430));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bidz = bidz.jdField_a_of_type_Bidz;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Biec = new biec();
      this.jdField_a_of_type_Biec.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bidz.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Biec.d = this.jdField_a_of_type_Bidz.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Biec.e = localBundle.getString("param_url");
      bhzm.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Biec.e);
      this.jdField_a_of_type_Biec.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bhzm.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Biec.e)) {
            this.jdField_a_of_type_Biec.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Biec.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Biec.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Biec.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Biec.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Biec.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Biec.h)) {
          break label393;
        }
        this.jdField_a_of_type_Biec.h = biea.a(this.jdField_a_of_type_Biec.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bhzm.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bidz + "\nTaskInfo:" + this.jdField_a_of_type_Biec + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Biec.e)) {
        break;
      }
      bhzt.a().a(amtj.a(2131699427));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (biea.a()) {
        this.jdField_a_of_type_Bidz = bidz.jdField_b_of_type_Bidz;
      } else {
        this.jdField_a_of_type_Bidz = bidz.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(amtj.a(2131699428));
    this.leftView.setOnClickListener(new bidv(this));
    setTitle(amtj.a(2131699432));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368337));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380020));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380019));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363899));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363949));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131364011));
    this.c = ((TextView)a(2131380036));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Biec);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Biec);
      return;
      this.jdField_b_of_type_Biec = biec.a(this.jdField_a_of_type_Biec);
      this.jdField_b_of_type_Biec.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Biec.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Biec.h = amtj.a(2131699424);
      this.jdField_b_of_type_Biec.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Biec);
      this.jdField_b_of_type_Biec.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Biec);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bidw(this));
      this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Biec);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bidx(this));
      this.c.setText(amtj.a(2131699433));
      this.c.setOnClickListener(new bidy(this));
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
    return 2131559658;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bhzd.b(bhzf.a().a("301").k(this.jdField_a_of_type_Bidz.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bidz.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bhzd.b(bhzf.a().a("200").k(this.jdField_a_of_type_Bidz.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bidz.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bhzm.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bhzm.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */