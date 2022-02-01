package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;

public abstract interface SQLiteCursorDriver
{
  public abstract Cursor a(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject);
  
  public abstract void a();
  
  public abstract void a(Cursor paramCursor);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCursorDriver
 * JD-Core Version:    0.7.0.1
 */