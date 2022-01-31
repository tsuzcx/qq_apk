package com.tencent.open.filedownload;

import alud;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import azqs;
import bdin;
import bdio;
import bfkr;
import bflg;
import bflh;
import bfli;
import bflj;
import bflp;
import bflz;
import bfqh;
import bfqi;
import bfqj;
import bfqk;
import bfql;
import bfqm;
import bfqo;
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
  private bfql jdField_a_of_type_Bfql;
  private bfqo jdField_a_of_type_Bfqo;
  private NormalDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton;
  private SafeDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton;
  private WhiteListDownloadButton jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bfqo jdField_b_of_type_Bfqo;
  private TextView c;
  
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private void a()
  {
    bflp.b("ApkFileDownloadFragment_", ">specialCode " + this.jdField_a_of_type_Boolean + "|" + this.jdField_a_of_type_Bfqo.f + "|" + bdin.g(getActivity()) + "|" + bdin.h(getActivity()));
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.equals(this.jdField_a_of_type_Bfqo.f, "com.tencent.weishi")) && (bdin.g(getActivity())) && (bdin.h(getActivity()))) {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.a(true, true);
    }
  }
  
  private void a(bfqo parambfqo)
  {
    bfqm.a(this.jdField_a_of_type_AndroidWidgetImageView, parambfqo.g);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfqo.h);
    if (parambfqo.jdField_a_of_type_Long <= 0L)
    {
      DownloadInfo localDownloadInfo = bfkr.a().b(parambfqo.e);
      if (localDownloadInfo != null) {
        parambfqo.jdField_a_of_type_Long = localDownloadInfo.c;
      }
    }
    if (parambfqo.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bdio.a((float)parambfqo.jdField_a_of_type_Long, true, 2));
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
    if (this.jdField_a_of_type_Bfqo.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bfqo.h)
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
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
    bflg.a(bflh.a().k(this.jdField_a_of_type_Bfql.jdField_b_of_type_JavaLangString).j("0").l("0").m(this.jdField_a_of_type_Bfql.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfqo.h).b(this.jdField_a_of_type_Bfqo.f).g(this.jdField_a_of_type_Bfqo.e));
    if (this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = getActivity().app;
      if (this.jdField_a_of_type_Bfqo.h == null) {}
      for (str = "";; str = this.jdField_a_of_type_Bfqo.h)
      {
        azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str, "");
        return;
      }
    }
    QQAppInterface localQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_Bfqo.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bfqo.h)
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      bflz.a().a(alud.a(2131700662));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("param_in_white_list", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bfql = bfql.jdField_a_of_type_Bfql;
    }
    for (;;)
    {
      Object localObject = localBundle.getString("param_ext_info");
      this.jdField_a_of_type_Bfqo = new bfqo();
      this.jdField_a_of_type_Bfqo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bfql.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bfqo.d = this.jdField_a_of_type_Bfql.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bfqo.e = localBundle.getString("param_url");
      bflp.b("ApkFileDownloadFragment_", "RealUrl:" + this.jdField_a_of_type_Bfqo.e);
      this.jdField_a_of_type_Bfqo.jdField_a_of_type_Long = localBundle.getLong("_filesize");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bflp.b("ApkFileDownloadFragment_", "appInfoJson:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bfqo.e)) {
            this.jdField_a_of_type_Bfqo.e = ((JSONObject)localObject).optString("url");
          }
          this.jdField_a_of_type_Bfqo.g = ((JSONObject)localObject).optString("app_icon");
          this.jdField_a_of_type_Bfqo.h = ((JSONObject)localObject).optString("app_name");
          if (this.jdField_a_of_type_Bfqo.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Bfqo.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("app_filesize");
          }
          this.jdField_a_of_type_Bfqo.f = ((JSONObject)localObject).optString("packagename");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfqo.h)) {
          break label393;
        }
        this.jdField_a_of_type_Bfqo.h = bfqm.a(this.jdField_a_of_type_Bfqo.e);
        this.jdField_a_of_type_JavaLangString = localBundle.getString("big_brother_source_key");
        bflp.b("ApkFileDownloadFragment_", "mPageType:" + this.jdField_a_of_type_Bfql + "\nTaskInfo:" + this.jdField_a_of_type_Bfqo + "\nmSource:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfqo.e)) {
        break;
      }
      bflz.a().a(alud.a(2131700659));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      if (bfqm.a()) {
        this.jdField_a_of_type_Bfql = bfql.jdField_b_of_type_Bfql;
      } else {
        this.jdField_a_of_type_Bfql = bfql.c;
      }
    }
    label393:
  }
  
  private void d()
  {
    this.leftView.setText(alud.a(2131700660));
    this.leftView.setOnClickListener(new bfqh(this));
    setTitle(alud.a(2131700664));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367916));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379184));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379183));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton = ((NormalDownloadButton)a(2131363645));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton = ((SafeDownloadButton)a(2131363696));
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton = ((WhiteListDownloadButton)a(2131363757));
    this.c = ((TextView)a(2131379200));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setSource(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bfqo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiWhiteListDownloadButton.setApkInfo(this.jdField_a_of_type_Bfqo);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bfqo);
      return;
      this.jdField_b_of_type_Bfqo = bfqo.a(this.jdField_a_of_type_Bfqo);
      this.jdField_b_of_type_Bfqo.e = "http://a.app.qq.com/o/myapp-down?g_f=1005234";
      this.jdField_b_of_type_Bfqo.f = "com.tencent.android.qqdownloader";
      this.jdField_b_of_type_Bfqo.h = alud.a(2131700656);
      this.jdField_b_of_type_Bfqo.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setVisibility(0);
      this.jdField_a_of_type_Bfqo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setOriApkInfo(this.jdField_a_of_type_Bfqo);
      this.jdField_b_of_type_Bfqo.jdField_b_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setApkInfo(this.jdField_b_of_type_Bfqo);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.setEventCallback(new bfqi(this));
      this.jdField_a_of_type_Bfqo.jdField_b_of_type_JavaLangString = "4";
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setApkInfo(this.jdField_a_of_type_Bfqo);
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.setEventCallback(new bfqj(this));
      this.c.setText(alud.a(2131700665));
      this.c.setOnClickListener(new bfqk(this));
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
    return 2131559514;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bflg.b(bfli.a().a("301").k(this.jdField_a_of_type_Bfql.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bfql.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfqo.h).b(this.jdField_a_of_type_Bfqo.f).g(this.jdField_a_of_type_Bfqo.e));
      this.jdField_a_of_type_ComTencentOpenFiledownloadUiNormalDownloadButton.b(false, true);
      return true;
    }
    bflg.b(bfli.a().a("200").k(this.jdField_a_of_type_Bfql.jdField_b_of_type_JavaLangString).j("2").l("0").m(this.jdField_a_of_type_Bfql.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_Bfqo.h).b(this.jdField_a_of_type_Bfqo.f).g(this.jdField_a_of_type_Bfqo.e));
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    bflp.b("ApkFileDownloadFragment_", "[onDestroy]");
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
    bflp.b("ApkFileDownloadFragment_", "[onResume]");
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiSafeDownloadButton.j();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment
 * JD-Core Version:    0.7.0.1
 */