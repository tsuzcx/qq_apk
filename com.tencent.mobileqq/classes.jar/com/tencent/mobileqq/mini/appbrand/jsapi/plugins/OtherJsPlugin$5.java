package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alrv;
import bafb;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class OtherJsPlugin$5
  implements Runnable
{
  OtherJsPlugin$5(OtherJsPlugin paramOtherJsPlugin, alrv paramalrv) {}
  
  public void run()
  {
    bafb localbafb = new bafb(this.this$0.jsPluginEngine.getActivityContext(), 2131690181);
    localbafb.setContentView(2131493682);
    localbafb.setMessage("是否将" + this.this$0.jsPluginEngine.getAppInfo().name + "添加到彩签？");
    localbafb.setPositiveButton("确定", new OtherJsPlugin.5.1(this));
    localbafb.setNegativeButton("取消", new OtherJsPlugin.5.2(this));
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */