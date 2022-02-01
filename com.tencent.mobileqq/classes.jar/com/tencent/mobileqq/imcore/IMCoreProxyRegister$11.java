package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy.Proxy;
import com.tencent.qqperf.tools.ThreadTraceHelper;

final class IMCoreProxyRegister$11
  implements ThreadTraceHelperProxy.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    ThreadTraceHelper.b(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    ThreadTraceHelper.a(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    ThreadTraceHelper.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.11
 * JD-Core Version:    0.7.0.1
 */