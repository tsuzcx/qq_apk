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
import anzj;
import bdll;
import bhdm;
import bhnv;
import bjsz;
import bjto;
import bjtp;
import bjtq;
import bjtr;
import bjtx;
import bjuh;
import bjyn;
import bjyo;
import bjyp;
import bjyq;
import bjyr;
import bjys;
import bjyu;
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
  private bjyr jdField_a_of_type_Bjyr;
  private bjyu jdField_a_of_type_Bjyu;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bjyu jdField_b_of_type_Bjyu;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bjtx.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bjyu.f + "|" + bhnv.g(getActivity()) + "|" + bhnv.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bjyu.f, "com.tencent.weishi")) && (bhnv.g(getActivity())) && (bhnv.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bjyu parambjyu)
  {
    bjys.a(this.jdField_a_of_type_AndroidWidgetImageView, parambjyu.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambjyu.h);
    if (parambjyu.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bjsz.a().b(parambjyu.e);
      if (localDownloadInfo != null) {
        parambjyu.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambjyu.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bhdm.a((float)parambjyu.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bjyu.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bjyu.h)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bjto.a(bjtp.a().k(this.jdField_a_of_type_Bjyr.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bjyr.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bjyu.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bjyu.h)
      {
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bjyu.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bjyu.h)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bjuh.a().a(anzj.a(2131699195));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bjyr = bjyr.jdField_a_of_type_Bjyr;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bjyu = new bjyu();
      this.jdField_a_of_type_Bjyu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjyr.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bjyu.d = this.jdField_a_of_type_Bjyr.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bjyu.e = localBundle.getString("param_url");
      bjtx.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bjyu.e);
      this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bjtx.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bjyu.e)) {
            this.jdField_a_of_type_Bjyu.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bjyu.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bjyu.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bjyu.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bjyu.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bjyu.h = bjys.a(this.jdField_a_of_type_Bjyu.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bjtx.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bjyr + "\nTaskInfo:" + this.jdField_a_of_type_Bjyu + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bjyu.e)) {
        break;
      }
      bjuh.a().a(anzj.a(2131699192));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bjys.a()) {
        this.jdField_a_of_type_Bjyr = bjyr.jdField_b_of_type_Bjyr;
      } else {
        this.jdField_a_of_type_Bjyr = bjyr.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(anzj.a(2131699193));
    this.leftView.setOnClickListener(new bjyn(this));
    setTitle(anzj.a(2131699197));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368313));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380294));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380293));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363873));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363923));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363987));
    this.c = ((TextView)a(2131380310));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bjyu);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bjyu);
      return;
      this.jdField_b_of_type_Bjyu = bjyu.a(this.jdField_a_of_type_Bjyu);
      this.jdField_b_of_type_Bjyu.e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bjyu.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bjyu.h = anzj.a(2131699189);
      this.jdField_b_of_type_Bjyu.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bjyu);
      this.jdField_b_of_type_Bjyu.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bjyu);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bjyo(this));
      this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bjyu);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bjyp(this));
      this.c.setText(anzj.a(2131699198));
      this.c.setOnClickListener(new bjyq(this));
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
    return 2131559656;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bjto.b(bjtq.a().a("301").k(this.jdField_a_of_type_Bjyr.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bjyr.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bjto.b(bjtq.a().a("200").k(this.jdField_a_of_type_Bjyr.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bjyr.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bjtx.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bjtx.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */