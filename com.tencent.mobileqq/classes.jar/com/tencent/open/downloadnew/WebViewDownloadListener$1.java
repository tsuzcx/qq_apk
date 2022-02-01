package com.tencent.open.downloadnew;

import android.os.Build.VERSION;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class WebViewDownloadListener$1
  implements Runnable
{
  WebViewDownloadListener$1(WebViewDownloadListener paramWebViewDownloadListener, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (CallBackEvent.a().a())) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wb.loadUrl(loadJs):");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        LogUtility.a("WebViewDownloadListener", localStringBuilder.toString());
        if (Build.VERSION.SDK_INT < 19)
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(this.jdField_a_of_type_JavaLangString, new WebViewDownloadListener.1.1(this));
        return;
      }
      catch (Exception localException)
      {
        LogUtility.a("WebViewDownloadListener", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */