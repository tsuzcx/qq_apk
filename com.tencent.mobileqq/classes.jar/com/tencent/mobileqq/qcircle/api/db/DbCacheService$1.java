package com.tencent.mobileqq.qcircle.api.db;

import java.util.HashMap;

class DbCacheService$1
  implements IDBManagerWrapper.OnCloseListener
{
  DbCacheService$1(DbCacheService paramDbCacheService) {}
  
  public void onClosed(IDBManagerWrapper paramIDBManagerWrapper)
  {
    synchronized (DbCacheService.access$000(this.this$0))
    {
      if ((paramIDBManagerWrapper instanceof DbCacheManager))
      {
        paramIDBManagerWrapper = (DbCacheManager)paramIDBManagerWrapper;
        DbCacheService.access$000(this.this$0).remove(paramIDBManagerWrapper.uniqueKey());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheService.1
 * JD-Core Version:    0.7.0.1
 */