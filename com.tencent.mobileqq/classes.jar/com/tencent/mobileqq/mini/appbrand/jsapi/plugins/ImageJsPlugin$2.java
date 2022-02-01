package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import bfur;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.this$0.jsPluginEngine.getActivityContext(), 230, amtj.a(2131704861), amtj.a(2131704860), amtj.a(2131704862), amtj.a(2131704859), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */