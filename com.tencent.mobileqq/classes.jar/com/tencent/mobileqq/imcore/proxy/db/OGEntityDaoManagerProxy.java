package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.persistence.OGAbstractDao;

public class OGEntityDaoManagerProxy
{
  private static OGEntityDaoManagerProxy.Proxy proxy;
  
  public static OGAbstractDao getEntityDao(Class paramClass)
  {
    if (proxy != null) {
      return proxy.getEntityDao(paramClass);
    }
    return null;
  }
  
  public static void registerProxy(OGEntityDaoManagerProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy
 * JD-Core Version:    0.7.0.1
 */