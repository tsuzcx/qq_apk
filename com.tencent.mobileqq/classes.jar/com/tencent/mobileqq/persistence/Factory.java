package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

public class Factory
  implements SQLiteDatabase.CursorFactory
{
  private final EntityManagerFactory mEmf;
  
  public Factory(EntityManagerFactory paramEntityManagerFactory)
  {
    this.mEmf = paramEntityManagerFactory;
  }
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new Factory.1(this, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Factory
 * JD-Core Version:    0.7.0.1
 */