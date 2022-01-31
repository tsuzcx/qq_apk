package com.tencent.open.downloadnew;

import android.os.Build.VERSION;
import bcav;
import bcds;
import bchw;
import bchx;
import com.tencent.smtt.sdk.WebView;

public class WebViewDownloadListener$1
  implements Runnable
{
  public WebViewDownloadListener$1(bchw parambchw, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (bcav.a().a())) {
      try
      {
        bcds.a("WebViewDownloadListener", "wb.loadUrl(loadJs):" + this.jdField_a_of_type_JavaLangString);
        if (Build.VERSION.SDK_INT < 19)
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(this.jdField_a_of_type_JavaLangString, new bchx(this));
        return;
      }
      catch (Exception localException)
      {
        bcds.a("WebViewDownloadListener", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */