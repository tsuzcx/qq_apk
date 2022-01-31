package com.tencent.mobileqq.webview.swift;

import bcdl;
import bcgc;
import com.tencent.qphone.base.util.QLog;

public class WebViewWrapper$WebViewClientImpl$2
  implements Runnable
{
  public WebViewWrapper$WebViewClientImpl$2(bcdl parambcdl, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "post intercept:", Boolean.valueOf(bool), " ", bcgc.a(this.jdField_a_of_type_JavaLangString) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2
 * JD-Core Version:    0.7.0.1
 */