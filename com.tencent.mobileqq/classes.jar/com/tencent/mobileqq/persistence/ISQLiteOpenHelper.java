package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteDatabase;

public abstract interface ISQLiteOpenHelper
{
  public abstract void close();
  
  public abstract void dropAllTable();
  
  public abstract String getDatabaseName();
  
  public abstract SQLiteDatabase getReadableDatabase();
  
  public abstract SQLiteDatabase getReadableDatabaseInner();
  
  public abstract SQLiteDatabase getWritableDatabase();
  
  public abstract SQLiteDatabase getWritableDatabaseInner();
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public abstract void onOpen(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ISQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */