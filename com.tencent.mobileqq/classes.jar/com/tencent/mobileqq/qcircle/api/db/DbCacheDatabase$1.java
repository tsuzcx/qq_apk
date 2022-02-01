package com.tencent.mobileqq.qcircle.api.db;

import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import com.tencent.biz.richframework.delegate.impl.RFLog;

final class DbCacheDatabase$1
  implements DatabaseErrorHandler
{
  DatabaseErrorHandler a = new DefaultDatabaseErrorHandler();
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a.onCorruption(paramSQLiteDatabase);
      int i = RFLog.USR;
      int j = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCorruption:");
      localStringBuilder.append(paramSQLiteDatabase);
      RFLog.e("QCircleDbCacheDatabase", i, new Object[] { Integer.valueOf(j), localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheDatabase.1
 * JD-Core Version:    0.7.0.1
 */