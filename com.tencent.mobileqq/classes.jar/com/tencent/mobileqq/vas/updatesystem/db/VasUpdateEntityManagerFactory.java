package com.tencent.mobileqq.vas.updatesystem.db;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VasUpdateEntityManagerFactory
  extends EntityManagerFactory
{
  public VasUpdateEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.decode(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {}
        try
        {
          Object localObject;
          if (str.equals(LocalUpdateEntity.TABLE_NAME))
          {
            localObject = LocalUpdateEntity.class;
          }
          else if (str.equals(ShouldUpdateEntity.TABLE_NAME))
          {
            localObject = ShouldUpdateEntity.class;
          }
          else if (str.equals(LocalFileMd5Entity.TABLE_NAME))
          {
            localObject = LocalFileMd5Entity.class;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(".");
            ((StringBuilder)localObject).append(str);
            localObject = Class.forName(((StringBuilder)localObject).toString());
          }
          OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          label166:
          break label166;
        }
        localCursor2.close();
      }
      localCursor1.close();
    }
    else
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          paramSQLiteDatabase.execSQL((String)paramString.next());
        }
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        for (;;)
        {
          throw paramString;
        }
      }
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, "vas_update_system_database.db", 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShouldUpdateEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LocalUpdateEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LocalFileMd5Entity()));
  }
  
  protected String getPackageName()
  {
    return "com.tencent.mobileqq.vas.updatesystem.db";
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DB]|upgrade. oldVer=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", newVer=");
    localStringBuilder.append(paramInt2);
    QLog.i("VasUpdateEntityManagerF", 1, localStringBuilder.toString());
    a(getPackageName(), paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.db.VasUpdateEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */