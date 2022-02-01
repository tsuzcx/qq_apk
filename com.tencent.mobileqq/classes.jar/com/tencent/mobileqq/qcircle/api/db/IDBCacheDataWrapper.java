package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;

public abstract interface IDBCacheDataWrapper
{
  public abstract void readFrom(ContentValues paramContentValues);
  
  public abstract void writeTo(ContentValues paramContentValues);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper
 * JD-Core Version:    0.7.0.1
 */