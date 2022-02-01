package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.persistence.Entity;

public abstract interface TableBuilderProxy$Proxy
{
  public abstract String createIndexSQLStatement(Entity paramEntity);
  
  public abstract Class[] getNeedPrivateFieldsClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy.Proxy
 * JD-Core Version:    0.7.0.1
 */