package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery
  extends SQLiteProgram
{
  private final int b = k().length;
  
  public SQLiteAsyncQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
  }
  
  private static native int nativeCount(long paramLong);
  
  private static native int nativeFillRows(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  int a(ChunkedCursorWindow paramChunkedCursorWindow, int paramInt1, int paramInt2)
  {
    a();
    int i = paramChunkedCursorWindow.c();
    int j = this.b;
    if (i != j) {
      paramChunkedCursorWindow.b(j);
    }
    try
    {
      paramInt1 = nativeFillRows(this.a.a(), paramChunkedCursorWindow.a, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (SQLiteException paramChunkedCursorWindow)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Got exception on fillRows: ");
      localStringBuilder.append(paramChunkedCursorWindow.getMessage());
      localStringBuilder.append(", SQL: ");
      localStringBuilder.append(f());
      Log.a("WCDB.SQLiteAsyncQuery", localStringBuilder.toString());
      a(paramChunkedCursorWindow);
      throw paramChunkedCursorWindow;
    }
  }
  
  void a()
  {
    if (this.a == null)
    {
      b(true);
      this.a.a(j());
    }
  }
  
  void b()
  {
    o();
  }
  
  int c()
  {
    a();
    try
    {
      int i = nativeCount(this.a.a());
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Got exception on getCount: ");
      localStringBuilder.append(localSQLiteException.getMessage());
      localStringBuilder.append(", SQL: ");
      localStringBuilder.append(f());
      Log.a("WCDB.SQLiteAsyncQuery", localStringBuilder.toString());
      a(localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  void d()
  {
    if (this.a != null) {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncQuery
 * JD-Core Version:    0.7.0.1
 */