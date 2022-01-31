package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import anxn;
import bdfq;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class OtherJsPlugin$6
  implements Runnable
{
  OtherJsPlugin$6(OtherJsPlugin paramOtherJsPlugin, anxn paramanxn) {}
  
  public void run()
  {
    bdfq localbdfq = new bdfq(this.this$0.jsPluginEngine.getActivityContext(), 2131755801);
    localbdfq.setContentView(2131559295);
    localbdfq.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localbdfq.setPositiveButton("确定", new OtherJsPlugin.6.1(this));
    localbdfq.setNegativeButton("取消", new OtherJsPlugin.6.2(this));
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */