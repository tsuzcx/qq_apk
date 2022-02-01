package com.tencent.open.downloadnew;

import android.os.Build.VERSION;
import bjhr;
import bjko;
import bjoi;
import bjoj;
import com.tencent.smtt.sdk.WebView;

public class WebViewDownloadListener$1
  implements Runnable
{
  public WebViewDownloadListener$1(bjoi parambjoi, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (bjhr.a().a())) {
      try
      {
        bjko.a("WebViewDownloadListener", "wb.loadUrl(loadJs):" + this.jdField_a_of_type_JavaLangString);
        if (Build.VERSION.SDK_INT < 19)
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(this.jdField_a_of_type_JavaLangString, new bjoj(this));
        return;
      }
      catch (Exception localException)
      {
        bjko.a("WebViewDownloadListener", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */