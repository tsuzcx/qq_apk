package com.tencent.wcdb.database;

import com.tencent.wcdb.support.LruCache;

final class SQLiteConnection$PreparedStatementCache
  extends LruCache<String, SQLiteConnection.PreparedStatement>
{
  public SQLiteConnection$PreparedStatementCache(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
  {
    SQLiteConnection.PreparedStatement.b(paramPreparedStatement1, false);
    if (!SQLiteConnection.PreparedStatement.d(paramPreparedStatement1)) {
      SQLiteConnection.a(this.a, paramPreparedStatement1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.PreparedStatementCache
 * JD-Core Version:    0.7.0.1
 */