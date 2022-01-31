package com.tencent.qqmini.sdk.core.plugins;

import behq;
import bekr;
import beny;

class TelephonyJsPlugin$2
  implements Runnable
{
  TelephonyJsPlugin$2(TelephonyJsPlugin paramTelephonyJsPlugin, bekr parambekr) {}
  
  public void run()
  {
    beny localbeny = beny.a(this.this$0.mMiniAppContext.a());
    localbeny.a("创建新联系人", 7);
    localbeny.a("添加到现有联系人", 7);
    localbeny.a(new TelephonyJsPlugin.2.1(this, localbeny));
    localbeny.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */