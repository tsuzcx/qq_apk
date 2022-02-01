package com.tencent.mobileqq.qcircle.api.db;

import java.util.HashMap;

class DbCacheService$1
  implements IDBManagerWrapper.OnCloseListener
{
  DbCacheService$1(DbCacheService paramDbCacheService) {}
  
  public void onClosed(IDBManagerWrapper paramIDBManagerWrapper)
  {
    synchronized (DbCacheService.a(this.a))
    {
      if ((paramIDBManagerWrapper instanceof DbCacheManager))
      {
        paramIDBManagerWrapper = (DbCacheManager)paramIDBManagerWrapper;
        DbCacheService.a(this.a).remove(paramIDBManagerWrapper.c());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheService.1
 * JD-Core Version:    0.7.0.1
 */