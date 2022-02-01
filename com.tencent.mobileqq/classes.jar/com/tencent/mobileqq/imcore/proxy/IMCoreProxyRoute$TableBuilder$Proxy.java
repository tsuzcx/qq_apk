package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.persistence.Entity;

public abstract interface IMCoreProxyRoute$TableBuilder$Proxy
{
  public abstract String createIndexSQLStatement(Entity paramEntity);
  
  public abstract Class[] getNeedPrivateFieldsClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TableBuilder.Proxy
 * JD-Core Version:    0.7.0.1
 */