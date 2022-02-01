package com.tencent.wcdb.database;

public class SQLiteDebug$DbStats
{
  public String cache;
  public String dbName;
  public long dbSize;
  public int lookaside;
  public long pageSize;
  
  public SQLiteDebug$DbStats(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dbName = paramString;
    this.pageSize = (paramLong2 / 1024L);
    this.dbSize = (paramLong1 * paramLong2 / 1024L);
    this.lookaside = paramInt1;
    paramString = new StringBuilder();
    paramString.append(paramInt2);
    paramString.append("/");
    paramString.append(paramInt3);
    paramString.append("/");
    paramString.append(paramInt4);
    this.cache = paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug.DbStats
 * JD-Core Version:    0.7.0.1
 */