package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amgo;
import bbgg;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class OtherJsPlugin$5
  implements Runnable
{
  OtherJsPlugin$5(OtherJsPlugin paramOtherJsPlugin, amgo paramamgo) {}
  
  public void run()
  {
    bbgg localbbgg = new bbgg(this.this$0.jsPluginEngine.getActivityContext(), 2131755791);
    localbbgg.setContentView(2131559251);
    localbbgg.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localbbgg.setPositiveButton("确定", new OtherJsPlugin.5.1(this));
    localbbgg.setNegativeButton("取消", new OtherJsPlugin.5.2(this));
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */