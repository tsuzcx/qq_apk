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
  
  public SQLiteDatabase a()
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
  
  public void a()
  {
    this.a.a();
  }
  
  public SQLiteDatabase b()
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
  
  public void close()
  {
    this.a.b();
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.b();
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
      SQLiteDatabase localSQLiteDatabase = this.a.a();
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
    this.a.a(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.b(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    this.a.b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.localizeddb.LocalizedSQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */