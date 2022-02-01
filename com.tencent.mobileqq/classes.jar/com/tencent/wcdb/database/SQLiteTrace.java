package com.tencent.wcdb.database;

import java.util.List;

public abstract interface SQLiteTrace
{
  public abstract void a(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong);
  
  public abstract void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean, List<SQLiteTrace.TraceInfo<String>> paramList, List<SQLiteTrace.TraceInfo<StackTraceElement[]>> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteTrace
 * JD-Core Version:    0.7.0.1
 */