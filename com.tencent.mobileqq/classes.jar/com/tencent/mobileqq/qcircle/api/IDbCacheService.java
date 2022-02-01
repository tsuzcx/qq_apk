package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDbCacheService
  extends QRouteApi
{
  public abstract void close();
  
  public abstract IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IDbCacheService
 * JD-Core Version:    0.7.0.1
 */