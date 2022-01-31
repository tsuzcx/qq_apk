package com.tencent.qqmini.sdk.core.plugins;

import bdcz;
import bdfz;
import bdje;

class TelephonyJsPlugin$2
  implements Runnable
{
  TelephonyJsPlugin$2(TelephonyJsPlugin paramTelephonyJsPlugin, bdfz parambdfz) {}
  
  public void run()
  {
    bdje localbdje = bdje.a(this.this$0.mMiniAppContext.a());
    localbdje.a("创建新联系人", 7);
    localbdje.a("添加到现有联系人", 7);
    localbdje.a(new TelephonyJsPlugin.2.1(this, localbdje));
    localbdje.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */