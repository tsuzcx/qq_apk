package com.tencent.mobileqq.persistence.qslowtable;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.util.DBBuildUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QSlowTableEntityManagerFactory
  extends QQEntityManagerFactory
{
  public QSlowTableEntityManagerFactory(String paramString)
  {
    super(paramString, 1);
    initBuilder(DBBuildUtil.getDefaultEntityManagerFactoryBuilder(paramString));
    this.tag = "QSlowTableEntityManagerFactory";
  }
  
  private void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
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
          if (str.startsWith("mr_slow_"))
          {
            localObject = MessageRecord.class;
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
          label139:
          break label139;
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
  
  public EntityManager a()
  {
    return QQEntityManagerFactoryProxy.a(this);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("slowtable_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, localStringBuilder.toString(), 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(getPackageName(), paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.qslowtable.QSlowTableEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */