package com.tencent.mobileqq.imcore.proxy.db;

public class ThreadRegulatorProxy
{
  private static ThreadRegulatorProxy.Proxy proxy;
  
  public static void checkInNextBusiness()
  {
    ThreadRegulatorProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.checkInNextBusiness();
    }
  }
  
  public static void registerProxy(ThreadRegulatorProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy
 * JD-Core Version:    0.7.0.1
 */