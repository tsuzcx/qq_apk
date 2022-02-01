package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

final class SQLiteDirectCursor$1
  implements SQLiteDatabase.CursorFactory
{
  public Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram)
  {
    return new SQLiteDirectCursor(paramSQLiteCursorDriver, paramString, (SQLiteDirectQuery)paramSQLiteProgram);
  }
  
  public SQLiteProgram a(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    return new SQLiteDirectQuery(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursor.1
 * JD-Core Version:    0.7.0.1
 */