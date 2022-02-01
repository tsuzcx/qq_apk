package com.tencent.open.component.cache.database;

import android.database.Cursor;

public abstract interface DbCacheData$DbCreator<T extends DbCacheData>
{
  public abstract int a();
  
  public abstract T a(Cursor paramCursor);
  
  public abstract String a();
  
  public abstract DbCacheData.Structure[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheData.DbCreator
 * JD-Core Version:    0.7.0.1
 */