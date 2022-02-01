package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aqcb;
import bgpa;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class OtherJsPlugin$6
  implements Runnable
{
  OtherJsPlugin$6(OtherJsPlugin paramOtherJsPlugin, aqcb paramaqcb, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    bgpa localbgpa = new bgpa(this.this$0.jsPluginEngine.getActivityContext(), 2131755823);
    localbgpa.setContentView(2131559383);
    localbgpa.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localbgpa.setPositiveButton("确定", new OtherJsPlugin.6.1(this));
    localbgpa.setNegativeButton("取消", new OtherJsPlugin.6.2(this));
    localbgpa.setCanceledOnTouchOutside(false);
    localbgpa.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */