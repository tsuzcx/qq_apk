package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MigrateSubscribeDB$ReadInJoyDBHelper
  extends SQLiteOpenHelper
{
  public MigrateSubscribeDB$ReadInJoyDBHelper(MigrateSubscribeDB paramMigrateSubscribeDB, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB.ReadInJoyDBHelper
 * JD-Core Version:    0.7.0.1
 */