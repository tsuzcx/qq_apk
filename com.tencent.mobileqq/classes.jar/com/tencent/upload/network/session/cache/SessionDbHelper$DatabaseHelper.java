package com.tencent.upload.network.session.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SessionDbHelper$DatabaseHelper
  extends SQLiteOpenHelper
{
  SessionDbHelper$DatabaseHelper(Context paramContext)
  {
    super(paramContext, "upload_session", null, 2);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE session (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin INTEGER,path TEXT,session TEXT,modified INTEGER,  UNIQUE (uin,path) ON CONFLICT REPLACE );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.cache.SessionDbHelper.DatabaseHelper
 * JD-Core Version:    0.7.0.1
 */