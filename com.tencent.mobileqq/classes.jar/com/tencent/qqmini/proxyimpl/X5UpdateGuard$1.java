package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;

class X5UpdateGuard$1
  implements Runnable
{
  X5UpdateGuard$1(X5UpdateGuard paramX5UpdateGuard) {}
  
  public void run()
  {
    int i = QbSdk.getTbsVersion(X5UpdateGuard.a(this.this$0).getContext());
    int j = QbSdk.getTmpDirTbsVersion(X5UpdateGuard.a(this.this$0).getContext());
    QLog.d("minisdk_X5UpdateGuard", 1, "timeout, getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    if ((i > 0) || (j > 0))
    {
      X5UpdateGuard.a(this.this$0);
      return;
    }
    X5UpdateGuard.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.1
 * JD-Core Version:    0.7.0.1
 */