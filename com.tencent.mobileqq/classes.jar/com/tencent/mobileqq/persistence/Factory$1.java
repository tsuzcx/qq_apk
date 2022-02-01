package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.utils.SecurityUtile;

class Factory$1
  extends SQLiteCursor
{
  Factory$1(Factory paramFactory, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  public byte[] getBlob(int paramInt)
  {
    byte[] arrayOfByte2 = super.getBlob(paramInt);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (Factory.a(this.a).isNeedEncrypt()) {
      arrayOfByte1 = SecurityUtile.encode(arrayOfByte2);
    }
    return arrayOfByte1;
  }
  
  public String getString(int paramInt)
  {
    String str2 = super.getString(paramInt);
    String str1 = str2;
    if (Factory.a(this.a).isNeedEncrypt()) {}
    try
    {
      str1 = SecurityUtile.decode(str2);
      return str1;
    }
    catch (Exception localException) {}
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Factory.1
 * JD-Core Version:    0.7.0.1
 */