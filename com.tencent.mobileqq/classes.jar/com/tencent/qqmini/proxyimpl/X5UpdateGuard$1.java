package com.tencent.qqmini.proxyimpl;

import bksl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;

public class X5UpdateGuard$1
  implements Runnable
{
  public X5UpdateGuard$1(bksl parambksl) {}
  
  public void run()
  {
    int i = QbSdk.getTbsVersion(bksl.a(this.this$0).getContext());
    int j = QbSdk.getTmpDirTbsVersion(bksl.a(this.this$0).getContext());
    QLog.d("minisdk_X5UpdateGuard", 1, "timeout, getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    if ((i > 0) || (j > 0))
    {
      bksl.a(this.this$0);
      return;
    }
    bksl.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.1
 * JD-Core Version:    0.7.0.1
 */