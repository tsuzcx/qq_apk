package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

public abstract interface SQLiteDatabase$CursorFactory
{
  public abstract Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram);
  
  public abstract SQLiteProgram a(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
 * JD-Core Version:    0.7.0.1
 */