package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.persistence.Entity;

public class TableBuilderProxy
{
  private static TableBuilderProxy.Proxy proxy;
  
  public static String createIndexSQLStatement(Entity paramEntity)
  {
    TableBuilderProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      return localProxy.createIndexSQLStatement(paramEntity);
    }
    return null;
  }
  
  public static Class[] getNeedPrivateFieldsClass()
  {
    TableBuilderProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      return localProxy.getNeedPrivateFieldsClass();
    }
    return new Class[0];
  }
  
  public static void registerProxy(TableBuilderProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy
 * JD-Core Version:    0.7.0.1
 */