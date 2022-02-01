package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import anni;
import bglp;
import bgpa;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.this$0.jsPluginEngine.getActivityContext(), 230, anni.a(2131704524), anni.a(2131704523), anni.a(2131704525), anni.a(2131704522), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localbgpa.setCanceledOnTouchOutside(false);
    localbgpa.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */