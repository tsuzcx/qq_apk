package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import bdcd;
import bdfq;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.this$0.jsPluginEngine.getActivityContext(), 230, alpo.a(2131706111), alpo.a(2131706110), alpo.a(2131706112), alpo.a(2131706109), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */