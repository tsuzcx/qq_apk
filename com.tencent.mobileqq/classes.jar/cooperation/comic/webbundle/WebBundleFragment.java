package cooperation.comic.webbundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import azmj;
import beep;
import bikk;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.WebBundleClient;
import cooperation.comic.ui.QQComicFragment;
import ndq;

public class WebBundleFragment
  extends QQComicFragment
{
  private WebBundleClient jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public TouchWebView a()
  {
    if (this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient != null)
    {
      IWebBundleWebView localIWebBundleWebView = this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.getValidWebView(super.getActivity(), this.b);
      if ((localIWebBundleWebView instanceof TouchWebView))
      {
        bikk.a(this.jdField_a_of_type_JavaLangString, true, bikk.jdField_a_of_type_JavaLangString);
        return (TouchWebView)localIWebBundleWebView;
      }
      bikk.a(this.jdField_a_of_type_JavaLangString, false, bikk.d);
    }
    return super.a();
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("real_url");
    this.b = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("preload_url");
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("bundle_data");
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str))) {
      this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient = new WebBundleClient("comic");
    }
    return super.c(paramBundle);
  }
  
  public void g()
  {
    ndq.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    a();
    if ((this.jdField_a_of_type_Beep.i) && (this.jdField_a_of_type_Beep.k > 0L))
    {
      azmj.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Beep.k) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Beep.c);
      this.jdField_a_of_type_Beep.k = 0L;
    }
    this.jdField_a_of_type_Beep.q = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Beep.q;
    l = this.jdField_a_of_type_Beep.b;
    if (((this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient == null) || (!this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.interceptLoadUrl(this.jdField_a_of_type_AndroidContentIntent))) && (!TextUtils.isEmpty(this.g))) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.g);
    }
    ndq.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_Beep.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.g, 0, 0, 0, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */