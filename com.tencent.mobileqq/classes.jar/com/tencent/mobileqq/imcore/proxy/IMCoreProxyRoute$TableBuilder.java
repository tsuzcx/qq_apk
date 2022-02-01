package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.persistence.Entity;

public class IMCoreProxyRoute$TableBuilder
{
  private static IMCoreProxyRoute.TableBuilder.Proxy TableBuilderProxy;
  
  public static String createIndexSQLStatement(Entity paramEntity)
  {
    if (TableBuilderProxy != null) {
      return TableBuilderProxy.createIndexSQLStatement(paramEntity);
    }
    return null;
  }
  
  public static Class[] getNeedPrivateFieldsClass()
  {
    if (TableBuilderProxy != null) {
      return TableBuilderProxy.getNeedPrivateFieldsClass();
    }
    return new Class[0];
  }
  
  public static void registerProxy(IMCoreProxyRoute.TableBuilder.Proxy paramProxy)
  {
    TableBuilderProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder
 * JD-Core Version:    0.7.0.1
 */