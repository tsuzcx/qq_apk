package com.tencent.mobileqq.mini.apkgEntity;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.TableBuilder;

public class MiniAppEntityManagerFactory
  extends EntityManagerFactory
{
  private static final int DB_VERSION = 12;
  
  public MiniAppEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, "miniapp_" + paramString + ".db", null, 12);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    QLog.d("miniapp-db", 1, "createDatabase");
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByLinkEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByIdEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppShowInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByIdEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByIdEntity()));
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
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppInfoEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppByLinkEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppByIdEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppShowInfoEntity.class.getSimpleName()));
    }
    if (paramInt1 < 11) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppShowInfoEntity.class.getSimpleName()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */