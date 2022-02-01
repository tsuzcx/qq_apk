package com.tencent.mobileqq.qcircle.api.db;

import android.database.sqlite.SQLiteDatabase;

public abstract interface IDBCacheDataWrapper$RawDbCreator<T extends IDBCacheDataWrapper>
  extends IDBCacheDataWrapper.DbCreator<T>
{
  public abstract int delRawSql(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2);
  
  public abstract String indexRawSql(String paramString);
  
  public abstract String queryRawSql(String paramString1, String paramString2, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.RawDbCreator
 * JD-Core Version:    0.7.0.1
 */