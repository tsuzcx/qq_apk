package com.yolo.esports.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.timi.game.utils.Logger;

abstract class BaseSQLHelper
  extends SQLiteOpenHelper
{
  public BaseSQLHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  protected abstract void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getReadableDatabase: ");
      localStringBuilder.append(localException.getMessage());
      Logger.c("BaseSQLHelper_", localStringBuilder.toString());
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWritableDatabase: ");
      localStringBuilder.append(localException.getMessage());
      Logger.c("BaseSQLHelper_", localStringBuilder.toString());
    }
    return null;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">onUpgrade ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt2);
      Logger.b("BaseSQLHelper_", localStringBuilder.toString());
      while (paramInt1 < paramInt2)
      {
        int i = paramInt1 + 1;
        a(paramSQLiteDatabase, paramInt1, i);
        paramInt1 = i;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.db.BaseSQLHelper
 * JD-Core Version:    0.7.0.1
 */