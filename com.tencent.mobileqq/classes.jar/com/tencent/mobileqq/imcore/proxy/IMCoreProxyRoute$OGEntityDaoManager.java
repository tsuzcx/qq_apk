package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.persistence.OGAbstractDao;

public class IMCoreProxyRoute$OGEntityDaoManager
{
  private static IMCoreProxyRoute.OGEntityDaoManager.Proxy OGEntityDaoManagerProxy;
  
  public static OGAbstractDao getEntityDao(Class paramClass)
  {
    if (OGEntityDaoManagerProxy != null) {
      return OGEntityDaoManagerProxy.getEntityDao(paramClass);
    }
    return null;
  }
  
  public static void registerProxy(IMCoreProxyRoute.OGEntityDaoManager.Proxy paramProxy)
  {
    OGEntityDaoManagerProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager
 * JD-Core Version:    0.7.0.1
 */