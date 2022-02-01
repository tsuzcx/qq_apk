package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteDatabase;

public abstract interface ISQLiteOpenHelper
{
  public abstract SQLiteDatabase a();
  
  public abstract void a();
  
  public abstract SQLiteDatabase b();
  
  public abstract void close();
  
  public abstract String getDatabaseName();
  
  public abstract SQLiteDatabase getReadableDatabase();
  
  public abstract SQLiteDatabase getWritableDatabase();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ISQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */