package com.tencent.mobileqq.localizeddb;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.Factory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.qphone.base.util.BaseApplication;

public class LocalizedSQLiteOpenHelperImpl
  extends LocalizedSQLiteOpenHelper
  implements ISQLiteOpenHelper
{
  private final SQLiteOpenHelperFacade a;
  
  @TargetApi(11)
  public LocalizedSQLiteOpenHelperImpl(EntityManagerFactory paramEntityManagerFactory, String paramString1, String paramString2, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(BaseApplication.getContext(), paramString1, new Factory(paramEntityManagerFactory), paramInt, paramDatabaseErrorHandler);
    this.a = new SQLiteOpenHelperFacade(this, paramString1, paramEntityManagerFactory, paramString2);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void dropAllTable()
  {
    this.a.dropAllTable();
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getReadableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SQLiteDatabase getReadableDatabaseInner()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SQLiteDatabase getWritableDatabaseInner()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.onCreate(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    this.a.onOpen(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.localizeddb.LocalizedSQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */