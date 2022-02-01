package com.tencent.qqlive.module.videoreport.storage.database;

import java.util.List;

class DbCache$2
  implements Runnable
{
  DbCache$2(DbCache paramDbCache, List paramList1, List paramList2) {}
  
  public void run()
  {
    DbCache.access$000(this.this$0).insertObjects(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbCache.2
 * JD-Core Version:    0.7.0.1
 */