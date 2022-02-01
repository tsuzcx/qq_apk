package com.tencent.open.component.cache.database;

import android.database.Cursor;

public abstract interface DbCacheData$DbCreator<T extends DbCacheData>
{
  public abstract DbCacheData.Structure[] a();
  
  public abstract T b(Cursor paramCursor);
  
  public abstract String b();
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheData.DbCreator
 * JD-Core Version:    0.7.0.1
 */