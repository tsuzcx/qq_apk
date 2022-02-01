package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import anzj;
import bhlq;
import bhpc;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.this$0.jsPluginEngine.getActivityContext(), 230, anzj.a(2131704631), anzj.a(2131704630), anzj.a(2131704632), anzj.a(2131704629), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localbhpc.setCanceledOnTouchOutside(false);
    localbhpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */