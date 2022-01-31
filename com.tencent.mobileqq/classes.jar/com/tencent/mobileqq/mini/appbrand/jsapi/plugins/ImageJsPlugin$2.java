package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import bdgm;
import bdjz;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.this$0.jsPluginEngine.getActivityContext(), 230, alud.a(2131706123), alud.a(2131706122), alud.a(2131706124), alud.a(2131706121), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localbdjz.setCanceledOnTouchOutside(false);
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */