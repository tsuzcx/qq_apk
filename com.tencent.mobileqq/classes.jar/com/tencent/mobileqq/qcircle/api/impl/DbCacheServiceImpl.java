package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.DbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;

public class DbCacheServiceImpl
  implements IDbCacheService
{
  public void close()
  {
    DbCacheService.getInstance().close();
  }
  
  public IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString)
  {
    return DbCacheService.getInstance().getCacheManager(paramClass, paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.DbCacheServiceImpl
 * JD-Core Version:    0.7.0.1
 */