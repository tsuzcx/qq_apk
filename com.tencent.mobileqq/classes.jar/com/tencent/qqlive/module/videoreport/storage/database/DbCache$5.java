package com.tencent.qqlive.module.videoreport.storage.database;

import java.util.List;

class DbCache$5
  implements Runnable
{
  DbCache$5(DbCache paramDbCache, Class paramClass, List paramList) {}
  
  public void run()
  {
    DbCache.access$000(this.this$0).deleteObjects(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbCache.5
 * JD-Core Version:    0.7.0.1
 */