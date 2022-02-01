package com.tencent.mobileqq.data.entitymanager;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQDBErrorHandler
  implements DatabaseErrorHandler
{
  private final List<Interceptor<Void>> mCorruptionInterceptors;
  private final DefaultDatabaseErrorHandler mDefaultErrorHandler = new DefaultDatabaseErrorHandler();
  
  @TargetApi(11)
  public QQDBErrorHandler(List<Interceptor<Void>> paramList)
  {
    this.mCorruptionInterceptors = paramList;
  }
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQDatabaseErrorHandler", 2, "[SQLiteDatabaseCorruptException]Corruption reported by sqlite on database: " + paramSQLiteDatabase.getPath());
      }
      new CorruptionInterceptorChain(0, this.mCorruptionInterceptors, paramSQLiteDatabase, this.mDefaultErrorHandler).proceed();
      return;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      this.mDefaultErrorHandler.onCorruption(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.QQDBErrorHandler
 * JD-Core Version:    0.7.0.1
 */