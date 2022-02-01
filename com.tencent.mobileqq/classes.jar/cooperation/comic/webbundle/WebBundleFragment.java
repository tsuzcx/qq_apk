package cooperation.comic.webbundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.WebBundleClient;
import cooperation.comic.ui.QQComicFragment;

public class WebBundleFragment
  extends QQComicFragment
{
  private WebBundleClient jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient = null;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public TouchWebView createCustomWebView()
  {
    if (this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient != null)
    {
      IWebBundleWebView localIWebBundleWebView = this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.getValidWebView(super.getActivity(), this.b);
      if ((localIWebBundleWebView instanceof TouchWebView))
      {
        WebBundleReportUtils.a(this.jdField_a_of_type_JavaLangString, true, WebBundleReportUtils.jdField_a_of_type_JavaLangString);
        return (TouchWebView)localIWebBundleWebView;
      }
      WebBundleReportUtils.a(this.jdField_a_of_type_JavaLangString, false, WebBundleReportUtils.d);
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
    Util.a("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    initFinish();
    if ((this.mStatistics.i) && (this.mStatistics.k > 0L))
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.c);
      this.mStatistics.k = 0L;
    }
    this.mStatistics.r = System.currentTimeMillis();
    long l = this.mStatistics.r;
    l = this.mStatistics.b;
    if (((this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient == null) || (!this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.interceptLoadUrl(this.intent))) && (!TextUtils.isEmpty(this.mUrl))) {
      this.webView.loadUrl(this.mUrl);
    }
    Util.b("Web_readyToLoadUrl");
    this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */