package com.tencent.open.wadl;

import bfrz;
import bfsf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class WadlJsBridgeCallBack$1
  implements Runnable
{
  public WadlJsBridgeCallBack$1(bfsf parambfsf, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        bfrz.c(bfsf.jdField_a_of_type_JavaLangString, "doJsCallback call:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      bfrz.a(bfsf.jdField_a_of_type_JavaLangString, "doJsCallback exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.1
 * JD-Core Version:    0.7.0.1
 */