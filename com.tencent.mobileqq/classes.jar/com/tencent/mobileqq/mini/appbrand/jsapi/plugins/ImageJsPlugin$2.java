package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajya;
import bbdj;
import bbgu;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.this$0.jsPluginEngine.getActivityContext(), 230, ajya.a(2131705739), ajya.a(2131705738), ajya.a(2131705740), ajya.a(2131705737), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */