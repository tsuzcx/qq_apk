package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aobw;
import bdjz;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class OtherJsPlugin$6
  implements Runnable
{
  OtherJsPlugin$6(OtherJsPlugin paramOtherJsPlugin, aobw paramaobw) {}
  
  public void run()
  {
    bdjz localbdjz = new bdjz(this.this$0.jsPluginEngine.getActivityContext(), 2131755801);
    localbdjz.setContentView(2131559294);
    localbdjz.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localbdjz.setPositiveButton("确定", new OtherJsPlugin.6.1(this));
    localbdjz.setNegativeButton("取消", new OtherJsPlugin.6.2(this));
    localbdjz.setCanceledOnTouchOutside(false);
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */