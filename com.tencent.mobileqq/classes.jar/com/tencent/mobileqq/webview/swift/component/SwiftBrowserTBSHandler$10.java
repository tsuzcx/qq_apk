package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

final class SwiftBrowserTBSHandler$10
  implements Runnable
{
  SwiftBrowserTBSHandler$10(String paramString1, String paramString2, WebView paramWebView, int paramInt1, int paramInt2, String paramString3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("TYPE", "4");
      localHashMap.put("mimeType", "text/html");
      localHashMap.put("encoding", "utf-8");
      localHashMap.put("baseUrl", this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.getX5WebViewExtension().preLoad(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad offline data:" + this.jdField_b_of_type_JavaLangString + ", sha1: " + this.c);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentSmttSdkWebView.getX5WebViewExtension().preLoad(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad: " + this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */