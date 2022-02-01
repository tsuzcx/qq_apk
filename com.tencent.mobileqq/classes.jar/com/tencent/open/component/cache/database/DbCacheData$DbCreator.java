package com.tencent.open.component.cache.database;

import android.database.Cursor;

public abstract interface DbCacheData$DbCreator<T extends DbCacheData>
{
  public abstract T createFromCursor(Cursor paramCursor);
  
  public abstract String sortOrder();
  
  public abstract DbCacheData.Structure[] structure();
  
  public abstract int version();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheData.DbCreator
 * JD-Core Version:    0.7.0.1
 */