package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgok;
import bgsi;

class TelephonyJsPlugin$2
  implements Runnable
{
  TelephonyJsPlugin$2(TelephonyJsPlugin paramTelephonyJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    bgsi localbgsi = bgsi.a(this.this$0.mMiniAppContext.a());
    localbgsi.a("创建新联系人", 7);
    localbgsi.a("添加到现有联系人", 7);
    localbgsi.a(new TelephonyJsPlugin.2.1(this, localbgsi));
    localbgsi.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */