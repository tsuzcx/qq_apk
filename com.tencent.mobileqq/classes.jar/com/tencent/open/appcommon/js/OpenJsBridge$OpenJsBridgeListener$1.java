package com.tencent.open.appcommon.js;

import bfjo;
import bflp;
import com.tencent.smtt.sdk.WebView;

public class OpenJsBridge$OpenJsBridgeListener$1
  implements Runnable
{
  public OpenJsBridge$OpenJsBridgeListener$1(bfjo parambfjo, String paramString1, String paramString2, WebView paramWebView) {}
  
  public void run()
  {
    bflp.b("OpenJsBridge", "[onOpenComplete]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.this$0.b + ",'r':0,'data':" + this.b + "});");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.this$0.b + ",'r':0,'data':" + this.b + "});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.1
 * JD-Core Version:    0.7.0.1
 */