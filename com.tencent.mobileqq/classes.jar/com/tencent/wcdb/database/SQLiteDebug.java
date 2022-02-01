package com.tencent.wcdb.database;

import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

public final class SQLiteDebug
{
  private static volatile int a;
  private static volatile ArrayList<SQLiteDebug.IOTraceStats> b;
  
  static {}
  
  static void a(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      a = nativeGetLastErrorLine();
      localObject = new ArrayList();
      long l = paramSQLiteConnection.a(null);
      if (l != 0L)
      {
        nativeGetIOTraceStats(l, (ArrayList)localObject);
        paramSQLiteConnection.a(null);
      }
      b = (ArrayList)localObject;
      return;
    }
    catch (RuntimeException paramSQLiteConnection)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot collect I/O trace statistics: ");
      ((StringBuilder)localObject).append(paramSQLiteConnection.getMessage());
      Log.a("WCDB.SQLiteDebug", ((StringBuilder)localObject).toString());
    }
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      a = nativeGetLastErrorLine();
      localObject = new ArrayList();
      long l = paramSQLiteDatabase.a("collectIoStat", false, false);
      if (l != 0L) {
        nativeGetIOTraceStats(l, (ArrayList)localObject);
      }
      paramSQLiteDatabase.a(l, null);
      b = (ArrayList)localObject;
      return;
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot collect I/O trace statistics: ");
      ((StringBuilder)localObject).append(paramSQLiteDatabase.getMessage());
      Log.a("WCDB.SQLiteDebug", ((StringBuilder)localObject).toString());
    }
  }
  
  public static final boolean a(long paramLong)
  {
    return paramLong > 300L;
  }
  
  private static native void nativeGetIOTraceStats(long paramLong, ArrayList<SQLiteDebug.IOTraceStats> paramArrayList);
  
  private static native int nativeGetLastErrorLine();
  
  private static native void nativeGetPagerStats(SQLiteDebug.PagerStats paramPagerStats);
  
  private static native void nativeSetIOTraceFlags(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */