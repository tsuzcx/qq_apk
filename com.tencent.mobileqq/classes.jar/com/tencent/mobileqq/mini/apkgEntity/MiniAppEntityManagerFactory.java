package com.tencent.mobileqq.mini.apkgEntity;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;

public class MiniAppEntityManagerFactory
  extends EntityManagerFactory
{
  private static final int DB_VERSION = 14;
  
  public MiniAppEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("miniapp_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, localStringBuilder.toString(), 14);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    QLog.d("miniapp-db", 1, "createDatabase");
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByLinkEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByIdEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppShowInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByIdEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByLinkEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppDetainRecordEntity()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgradeDatabase --  oldVersion: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; newVersion : ");
    localStringBuilder.append(paramInt2);
    QLog.d("miniapp-db", 1, localStringBuilder.toString());
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
    if (paramInt1 < 14) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppLocalSearchEntity.class.getSimpleName()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */