package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import apkn;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.utils.QQCustomDialog;

class OtherJsPlugin$6
  implements Runnable
{
  OtherJsPlugin$6(OtherJsPlugin paramOtherJsPlugin, apkn paramapkn, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.this$0.jsPluginEngine.getActivityContext(), 2131755826);
    localQQCustomDialog.setContentView(2131559385);
    localQQCustomDialog.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localQQCustomDialog.setPositiveButton("确定", new OtherJsPlugin.6.1(this));
    localQQCustomDialog.setNegativeButton("取消", new OtherJsPlugin.6.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */