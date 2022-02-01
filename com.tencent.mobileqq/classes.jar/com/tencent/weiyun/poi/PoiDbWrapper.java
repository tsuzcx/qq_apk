package com.tencent.weiyun.poi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

final class PoiDbWrapper
{
  private SQLiteDatabase db;
  
  private PoiDbWrapper() {}
  
  PoiDbWrapper(SQLiteDatabase paramSQLiteDatabase)
  {
    this.db = paramSQLiteDatabase;
  }
  
  public void beginTransaction()
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase != null) {
      localSQLiteDatabase.beginTransaction();
    }
  }
  
  SQLiteDatabase database()
  {
    return this.db;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase == null) {
      return 0;
    }
    return localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
  }
  
  public void endTransaction()
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase != null) {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase == null) {
      return -1L;
    }
    return localSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase == null) {
      return null;
    }
    return localSQLiteDatabase.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public void setTransactionSuccessful()
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase != null) {
      localSQLiteDatabase.setTransactionSuccessful();
    }
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    if (localSQLiteDatabase == null) {
      return 0;
    }
    return localSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiDbWrapper
 * JD-Core Version:    0.7.0.1
 */