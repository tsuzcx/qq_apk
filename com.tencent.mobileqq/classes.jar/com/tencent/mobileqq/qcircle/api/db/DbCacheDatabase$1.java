package com.tencent.mobileqq.qcircle.api.db;

import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

final class DbCacheDatabase$1
  implements DatabaseErrorHandler
{
  DatabaseErrorHandler a = new DefaultDatabaseErrorHandler();
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a.onCorruption(paramSQLiteDatabase);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCorruption:");
      localStringBuilder.append(paramSQLiteDatabase);
      QLog.e("QCircleDbCacheDatabase", 1, new Object[] { Integer.valueOf(1), localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheDatabase.1
 * JD-Core Version:    0.7.0.1
 */