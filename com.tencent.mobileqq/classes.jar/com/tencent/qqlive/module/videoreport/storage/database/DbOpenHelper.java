package com.tencent.qqlive.module.videoreport.storage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DbOpenHelper
  extends SQLiteOpenHelper
{
  public DbOpenHelper(Context paramContext)
  {
    super(paramContext.getApplicationContext(), "datong_storage", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS datong_storage (`id` INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, `class_id` varchar(100) NOT NULL, `object_id` varchar(100) NOT NULL, `object_dat` text NOT NULL, UNIQUE (`class_id`, `object_id`) ON CONFLICT REPLACE);");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS datong_storage");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS datong_storage");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbOpenHelper
 * JD-Core Version:    0.7.0.1
 */