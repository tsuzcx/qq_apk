package com.tencent.qqlive.module.videoreport.storage.database;

import android.util.Pair;
import java.util.List;
import java.util.concurrent.Callable;

class DbCache$8
  implements Callable<List<Pair<String, T>>>
{
  DbCache$8(DbCache paramDbCache, Class paramClass) {}
  
  public List<Pair<String, T>> a()
  {
    return DbCache.access$000(this.b).getAllObjects(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbCache.8
 * JD-Core Version:    0.7.0.1
 */