package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

final class SQLiteAsyncCursor$1
  implements SQLiteDatabase.CursorFactory
{
  public Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram)
  {
    return new SQLiteAsyncCursor(paramSQLiteCursorDriver, paramString, (SQLiteAsyncQuery)paramSQLiteProgram);
  }
  
  public SQLiteProgram a(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    return new SQLiteAsyncQuery(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor.1
 * JD-Core Version:    0.7.0.1
 */