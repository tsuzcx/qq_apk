package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.a.a;

public class CacheTable
  implements com.tencent.tmassistant.common.a.c
{
  protected static final String[] COLS_SIZE = { "key" };
  protected static final String COL_BLOB = "blob";
  protected static final String COL_KEY = "key";
  public static final String COL_KEY_CACHE = "cache";
  public static final String COL_KEY_REPORT = "report";
  protected static final String COL_TYPE = "type";
  public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
  protected static final int REPORT_MAX_DB_SIZE = 20;
  public static final String TABLE_NAME = "reportInfo";
  protected static final String TAG = "ReportTable";
  
  public String createTableSQL()
  {
    return "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
  }
  
  public void dataMovement(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    localObject = null;
    localSQLiteDatabase = null;
    if ((paramSQLiteDatabase2 != null) && (paramSQLiteDatabase1 != null)) {
      paramSQLiteDatabase2.beginTransaction();
    }
    try
    {
      paramSQLiteDatabase1 = paramSQLiteDatabase1.rawQuery("select * from reportInfo", null);
      if (paramSQLiteDatabase1 != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase1;
        localObject = paramSQLiteDatabase1;
        if (paramSQLiteDatabase1.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase1;
          localObject = paramSQLiteDatabase1;
          ab.c("reportInfo", "start move data!");
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            ContentValues localContentValues = new ContentValues();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, com.tencent.tmdownloader.internal.downloadservice.c.b(paramSQLiteDatabase1));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            paramSQLiteDatabase2.insert("reportInfo", null, localContentValues);
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            bool = paramSQLiteDatabase1.moveToNext();
          } while (bool);
        }
      }
      if (paramSQLiteDatabase1 != null) {
        paramSQLiteDatabase1.close();
      }
    }
    catch (Exception paramSQLiteDatabase1)
    {
      for (;;)
      {
        localObject = localSQLiteDatabase;
        ab.c("ReportTable", "exception: ", paramSQLiteDatabase1);
        localObject = localSQLiteDatabase;
        paramSQLiteDatabase1.printStackTrace();
        localObject = localSQLiteDatabase;
        ab.c("reportInfo", "move data exception!");
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label200;
      }
      ((Cursor)localObject).close();
    }
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public d getHelper()
  {
    return a.c();
  }
  
  public String tableName()
  {
    return "reportInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.CacheTable
 * JD-Core Version:    0.7.0.1
 */