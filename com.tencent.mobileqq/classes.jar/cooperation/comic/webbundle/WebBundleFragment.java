package cooperation.comic.webbundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bdll;
import biqx;
import bmdj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.WebBundleClient;
import cooperation.comic.ui.QQComicFragment;
import noe;

public class WebBundleFragment
  extends QQComicFragment
{
  private WebBundleClient jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public TouchWebView createCustomWebView()
  {
    if (this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient != null)
    {
      IWebBundleWebView localIWebBundleWebView = this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.getValidWebView(super.getActivity(), this.b);
      if ((localIWebBundleWebView instanceof TouchWebView))
      {
        bmdj.a(this.jdField_a_of_type_JavaLangString, true, bmdj.jdField_a_of_type_JavaLangString);
        return (TouchWebView)localIWebBundleWebView;
      }
      bmdj.a(this.jdField_a_of_type_JavaLangString, false, bmdj.d);
    }
    return super.createCustomWebView();
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = this.intent.getStringExtra("real_url");
    this.b = this.intent.getStringExtra("preload_url");
    String str = this.intent.getStringExtra("bundle_data");
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str))) {
      this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient = new WebBundleClient("comic");
    }
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  public void startLoadUrl()
  {
    noe.a("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    initFinish();
    if ((this.mStatistics.i) && (this.mStatistics.k > 0L))
    {
      bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.c);
      this.mStatistics.k = 0L;
    }
    this.mStatistics.q = System.currentTimeMillis();
    long l = this.mStatistics.q;
    l = this.mStatistics.b;
    if (((this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient == null) || (!this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.interceptLoadUrl(this.intent))) && (!TextUtils.isEmpty(this.mUrl))) {
      this.webView.loadUrl(this.mUrl);
    }
    noe.b("Web_readyToLoadUrl");
    this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */