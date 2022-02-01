package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

class SQLiteConnectionPool$1
  implements CancellationSignal.OnCancelListener
{
  SQLiteConnectionPool$1(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter, int paramInt) {}
  
  public void c()
  {
    synchronized (SQLiteConnectionPool.a(this.c))
    {
      if (this.a.j == this.b) {
        SQLiteConnectionPool.a(this.c, this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool.1
 * JD-Core Version:    0.7.0.1
 */