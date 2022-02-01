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
  private static final String TAG = "QCircleDbCacheDatabase.DbCacheExceptionHandler";
  private volatile Context mContext;
  
  public static DbCacheExceptionHandler getInstance()
  {
    return DbCacheExceptionHandler.InstanceHolder.INSTANCE;
  }
  
  private void notifyDbError() {}
  
  public void attachContext(Context paramContext)
  {
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.mContext = paramContext;
      return;
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public void handleException(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    if (((paramThrowable instanceof SQLiteDiskIOException)) || ((paramThrowable instanceof SQLiteDatabaseCorruptException)) || ((paramThrowable instanceof SQLiteFullException)) || ((Build.VERSION.SDK_INT >= 11) && ((paramThrowable instanceof SQLiteCantOpenDatabaseException))) || ((Build.VERSION.SDK_INT >= 11) && ((paramThrowable instanceof SQLiteAccessPermException))) || ((paramThrowable instanceof DbCacheSQLiteException)) || (((paramThrowable instanceof SQLiteException)) && (paramThrowable.getMessage().contains("no such table"))))
    {
      DbCacheService.getInstance().close(paramString);
      this.mContext.deleteDatabase(paramString);
      RFLog.e("QCircleDbCacheDatabase.DbCacheExceptionHandler", RFLog.USR, "deleteDatabase:" + paramString);
      notifyDbError();
      return;
    }
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    throw new DbCacheExceptionHandler.DbCacheError(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheExceptionHandler
 * JD-Core Version:    0.7.0.1
 */