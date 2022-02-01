package com.tencent.mobileqq.qcircle.api.db;

import android.util.Pair;

public abstract interface IDBCacheDataWrapper$PrePareDbCreator<T extends IDBCacheDataWrapper>
  extends IDBCacheDataWrapper.DbCreator<T>
{
  public abstract Pair<String, String[]> rawSql(String paramString1, String paramString2, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.PrePareDbCreator
 * JD-Core Version:    0.7.0.1
 */