package com.tencent.open.filedownload;

import alpo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import azmj;
import bdee;
import bdef;
import bfgi;
import bfgx;
import bfgy;
import bfgz;
import bfha;
import bfhg;
import bfhq;
import bfly;
import bflz;
import bfma;
import bfmb;
import bfmc;
import bfmd;
import bfmf;
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
  private bfmc jdField_a_of_type_Bfmc;
  private bfmf jdField_a_of_type_Bfmf;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bfmf jdField_b_of_type_Bfmf;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bfhg.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bfmf.f + "|" + bdee.g(getActivity()) + "|" + bdee.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bfmf.f, "com.tencent.weishi")) && (bdee.g(getActivity())) && (bdee.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bfmf parambfmf)
  {
    bfmd.a(this.jdField_a_of_type_AndroidWidgetImageView, parambfmf.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfmf.h);
    if (parambfmf.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bfgi.a().b(parambfmf.e);
      if (localDownloadInfo != null) {
        parambfmf.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambfmf.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bdef.a((float)parambfmf.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bfmf.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bfmf.h)
    {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bfgx.a(bfgy.a().k(this.jdField_a_of_type_Bfmc.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bfmf.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bfmf.h)
      {
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bfmf.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bfmf.h)
    {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bfhq.a().a(alpo.a(2131700650));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bfmc = bfmc.jdField_a_of_type_Bfmc;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bfmf = new bfmf();
      this.jdField_a_of_type_Bfmf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bfmc.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bfmf.d = this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bfmf.e = localBundle.getString("param_url");
      bfhg.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bfmf.e);
      this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bfhg.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bfmf.e)) {
            this.jdField_a_of_type_Bfmf.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bfmf.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bfmf.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bfmf.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfmf.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bfmf.h = bfmd.a(this.jdField_a_of_type_Bfmf.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bfhg.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bfmc + "\nTaskInfo:" + this.jdField_a_of_type_Bfmf + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfmf.e)) {
        break;
      }
      bfhq.a().a(alpo.a(2131700647));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bfmd.a()) {
        this.jdField_a_of_type_Bfmc = bfmc.jdField_b_of_type_Bfmc;
      } else {
        this.jdField_a_of_type_Bfmc = bfmc.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(alpo.a(2131700648));
    this.leftView.setOnClickListener(new bfly(this));
    setTitle(alpo.a(2131700652));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367905));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379126));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379125));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363643));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363694));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363755));
    this.c = ((TextView)a(2131379142));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bfmf);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bfmf);
      return;
      this.jdField_b_of_type_Bfmf = bfmf.a(this.jdField_a_of_type_Bfmf);
      this.jdField_b_of_type_Bfmf.e = "http://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bfmf.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bfmf.h = alpo.a(2131700644);
      this.jdField_b_of_type_Bfmf.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bfmf);
      this.jdField_b_of_type_Bfmf.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bfmf);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bflz(this));
      this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bfmf);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bfma(this));
      this.c.setText(alpo.a(2131700653));
      this.c.setOnClickListener(new bfmb(this));
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
    return 2131559515;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bfgx.b(bfgz.a().a("301").k(this.jdField_a_of_type_Bfmc.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bfgx.b(bfgz.a().a("200").k(this.jdField_a_of_type_Bfmc.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bfhg.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bfhg.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */