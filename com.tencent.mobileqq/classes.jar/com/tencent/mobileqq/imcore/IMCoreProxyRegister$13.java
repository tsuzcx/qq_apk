package com.tencent.mobileqq.imcore;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy.Proxy;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;

final class IMCoreProxyRegister$13
  implements CaughtExceptionReportProxy.Proxy
{
  public void e(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    CaughtExceptionReport.a(paramThrowable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.13
 * JD-Core Version:    0.7.0.1
 */