package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$ThreadRegulator
{
  private static IMCoreProxyRoute.ThreadRegulator.Proxy ThreadRegulatorProxy;
  
  public static void checkInNextBusiness()
  {
    if (ThreadRegulatorProxy != null) {
      ThreadRegulatorProxy.checkInNextBusiness();
    }
  }
  
  public static void registerProxy(IMCoreProxyRoute.ThreadRegulator.Proxy paramProxy)
  {
    ThreadRegulatorProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator
 * JD-Core Version:    0.7.0.1
 */