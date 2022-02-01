package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy.Proxy;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;

final class IMCoreProxyRegister$16
  implements ThreadRegulatorProxy.Proxy
{
  public void checkInNextBusiness()
  {
    ThreadRegulator.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.16
 * JD-Core Version:    0.7.0.1
 */