package com.tencent.mobileqq.qcircle.api.db;

import android.database.Cursor;

public abstract interface IDBCacheDataWrapper$DbCreator<T extends IDBCacheDataWrapper>
{
  public abstract T createFromCursor(Cursor paramCursor);
  
  public abstract String sortOrder();
  
  public abstract IDBCacheDataWrapper.Structure[] structure();
  
  public abstract int version();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
 * JD-Core Version:    0.7.0.1
 */