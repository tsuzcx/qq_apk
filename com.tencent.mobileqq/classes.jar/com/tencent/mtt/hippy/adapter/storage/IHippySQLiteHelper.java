package com.tencent.mtt.hippy.adapter.storage;

import android.database.sqlite.SQLiteDatabase;

public abstract interface IHippySQLiteHelper
{
  public static final String COLUMN_KEY = "key";
  public static final String COLUMN_VALUE = "value";
  
  public abstract SQLiteDatabase getDatabase();
  
  public abstract String getTableName();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.IHippySQLiteHelper
 * JD-Core Version:    0.7.0.1
 */