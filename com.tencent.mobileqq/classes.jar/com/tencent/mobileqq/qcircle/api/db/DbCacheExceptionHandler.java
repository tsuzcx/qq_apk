package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class DbCacheExceptionHandler
{
  private volatile Context a;
  
  public static DbCacheExceptionHandler a()
  {
    return DbCacheExceptionHandler.InstanceHolder.a;
  }
  
  private void a() {}
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      paramContext = paramContext.getApplicationContext();
    } else {
      paramContext = null;
    }
    this.a = paramContext;
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    if ((!(paramThrowable instanceof SQLiteDiskIOException)) && (!(paramThrowable instanceof SQLiteDatabaseCorruptException)) && (!(paramThrowable instanceof SQLiteFullException)) && ((Build.VERSION.SDK_INT < 11) || (!(paramThrowable instanceof SQLiteCantOpenDatabaseException))) && ((Build.VERSION.SDK_INT < 11) || (!(paramThrowable instanceof SQLiteAccessPermException))) && (!(paramThrowable instanceof DbCacheSQLiteException)) && ((!(paramThrowable instanceof SQLiteException)) || (!paramThrowable.getMessage().contains("no such table"))))
    {
      if ((paramThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)paramThrowable);
      }
      throw new DbCacheExceptionHandler.DbCacheError(paramThrowable);
    }
    DbCacheService.a().a(paramString);
    this.a.deleteDatabase(paramString);
    int i = RFLog.USR;
    paramThrowable = new StringBuilder();
    paramThrowable.append("deleteDatabase:");
    paramThrowable.append(paramString);
    RFLog.e("QCircleDbCacheDatabase.DbCacheExceptionHandler", i, paramThrowable.toString());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheExceptionHandler
 * JD-Core Version:    0.7.0.1
 */