package com.tencent.weiyun.transmission.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class JobDbWrapper
{
  private SQLiteDatabase db;
  
  private JobDbWrapper() {}
  
  JobDbWrapper(SQLiteDatabase paramSQLiteDatabase)
  {
    this.db = paramSQLiteDatabase;
  }
  
  public void beginTransaction()
  {
    if (this.db != null) {
      this.db.beginTransaction();
    }
  }
  
  SQLiteDatabase database()
  {
    return this.db;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (this.db == null) {
      return 0;
    }
    return this.db.delete(paramString1, paramString2, paramArrayOfString);
  }
  
  public void endTransaction()
  {
    if (this.db != null) {
      this.db.endTransaction();
    }
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if (this.db == null) {
      return -1L;
    }
    return this.db.insert(paramString1, paramString2, paramContentValues);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.db == null) {
      return null;
    }
    return this.db.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public void setTransactionSuccessful()
  {
    if (this.db != null) {
      this.db.setTransactionSuccessful();
    }
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    if (this.db == null) {
      return 0;
    }
    return this.db.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.JobDbWrapper
 * JD-Core Version:    0.7.0.1
 */