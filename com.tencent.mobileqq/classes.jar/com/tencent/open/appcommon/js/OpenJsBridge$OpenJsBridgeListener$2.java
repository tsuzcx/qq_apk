package com.tencent.open.appcommon.js;

import bfff;
import bfhg;
import com.tencent.smtt.sdk.WebView;

public class OpenJsBridge$OpenJsBridgeListener$2
  implements Runnable
{
  public OpenJsBridge$OpenJsBridgeListener$2(bfff parambfff, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    bfhg.b("OpenJsBridge", "[onNoMatchMethod]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.this$0.b + ",'r':-2,'data':'no such method'});");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.this$0.b + ",'r':-2,'data':'no such method'});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.2
 * JD-Core Version:    0.7.0.1
 */