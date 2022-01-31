package com.tencent.mobileqq.mini.appbrand;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

class JsErrorGuard$1
  implements Runnable
{
  JsErrorGuard$1(JsErrorGuard paramJsErrorGuard) {}
  
  public void run()
  {
    int i = QbSdk.getTbsVersion(JsErrorGuard.access$000(this.this$0).activity);
    int j = QbSdk.getTmpDirTbsVersion(JsErrorGuard.access$000(this.this$0).activity);
    QLog.d("miniapp-start_JsConsoleGuard", 1, "timeout, getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    if ((i > 0) || (j > 0))
    {
      JsErrorGuard.access$100(this.this$0);
      return;
    }
    JsErrorGuard.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.1
 * JD-Core Version:    0.7.0.1
 */