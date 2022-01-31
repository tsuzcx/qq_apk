package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgkd;
import bgob;

class TelephonyJsPlugin$2
  implements Runnable
{
  TelephonyJsPlugin$2(TelephonyJsPlugin paramTelephonyJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    bgob localbgob = bgob.a(this.this$0.mMiniAppContext.a());
    localbgob.a("创建新联系人", 7);
    localbgob.a("添加到现有联系人", 7);
    localbgob.a(new TelephonyJsPlugin.2.1(this, localbgob));
    localbgob.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */