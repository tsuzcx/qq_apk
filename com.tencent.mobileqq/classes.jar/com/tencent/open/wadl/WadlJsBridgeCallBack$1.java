package com.tencent.open.wadl;

import bckd;
import bckj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class WadlJsBridgeCallBack$1
  implements Runnable
{
  public WadlJsBridgeCallBack$1(bckj parambckj, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        bckd.b(bckj.jdField_a_of_type_JavaLangString, "doJsCallback call:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      bckd.a(bckj.jdField_a_of_type_JavaLangString, "doJsCallback exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.1
 * JD-Core Version:    0.7.0.1
 */