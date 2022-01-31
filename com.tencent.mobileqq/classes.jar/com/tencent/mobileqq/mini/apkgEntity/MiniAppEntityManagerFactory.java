package com.tencent.mobileqq.mini.apkgEntity;

import akfv;
import android.database.sqlite.SQLiteDatabase;
import auln;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;

public class MiniAppEntityManagerFactory
  extends QQEntityManagerFactory
{
  private static final int DB_VERSION = 11;
  
  public MiniAppEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public akfv build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "miniapp_" + paramString + ".db", null, 11);
      this.dbHelper = new akfv(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    QLog.d("miniapp-db", 1, "createDatabase");
    paramSQLiteDatabase.execSQL(auln.a(new MiniAppInfoEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new MiniAppByLinkEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new MiniAppByIdEntity()));
    paramSQLiteDatabase.execSQL(auln.a(new MiniAppShowInfoEntity()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QLog.d("miniapp-db", 1, "upgradeDatabase --  oldVersion: " + paramInt1 + "; newVersion : " + paramInt2);
    if (paramInt1 < 8)
    {
      paramSQLiteDatabase.execSQL(auln.a(MiniAppInfoEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(MiniAppByLinkEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(MiniAppByIdEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(auln.a(MiniAppShowInfoEntity.class.getSimpleName()));
    }
    if (paramInt1 < 11) {
      paramSQLiteDatabase.execSQL(auln.a(MiniAppShowInfoEntity.class.getSimpleName()));
    }
    checkColumnChange(getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */