package com.tencent.mobileqq.persistence;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class SQLiteOpenHelperImpl
  extends SQLiteOpenHelper
  implements ISQLiteOpenHelper
{
  private final SQLiteOpenHelperFacade mFacade;
  
  public SQLiteOpenHelperImpl(EntityManagerFactory paramEntityManagerFactory, String paramString1, String paramString2, int paramInt)
  {
    this(paramEntityManagerFactory, paramString1, paramString2, paramInt, null);
  }
  
  @TargetApi(11)
  public SQLiteOpenHelperImpl(EntityManagerFactory paramEntityManagerFactory, String paramString1, String paramString2, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(BaseApplication.getContext(), paramString1, new Factory(paramEntityManagerFactory), paramInt, paramDatabaseErrorHandler);
    this.mFacade = new SQLiteOpenHelperFacade(this, paramString1, paramEntityManagerFactory, paramString2);
  }
  
  public void close()
  {
    this.mFacade.close();
  }
  
  public void dropAllTable()
  {
    this.mFacade.dropAllTable();
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.mFacade.getReadableDatabase();
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
      SQLiteDatabase localSQLiteDatabase = this.mFacade.getWritableDatabase();
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
    this.mFacade.onCreate(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.mFacade.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    this.mFacade.onOpen(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.mFacade.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.SQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */