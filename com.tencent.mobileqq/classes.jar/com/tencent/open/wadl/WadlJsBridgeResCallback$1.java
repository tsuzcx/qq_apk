package com.tencent.open.wadl;

import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class WadlJsBridgeResCallback$1
  implements Runnable
{
  WadlJsBridgeResCallback$1(WadlJsBridgeResCallback paramWadlJsBridgeResCallback, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        WLog.c("WadlJsBridgeResCallback", "doJsCallback call:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      WLog.a("WadlJsBridgeResCallback", "doJsCallback exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeResCallback.1
 * JD-Core Version:    0.7.0.1
 */