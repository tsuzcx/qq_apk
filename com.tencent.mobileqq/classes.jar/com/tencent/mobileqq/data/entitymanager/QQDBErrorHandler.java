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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[SQLiteDatabaseCorruptException]Corruption reported by sqlite on database: ");
        localStringBuilder.append(paramSQLiteDatabase.getPath());
        QLog.i("QQDatabaseErrorHandler", 2, localStringBuilder.toString());
      }
      new CorruptionInterceptorChain(0, this.mCorruptionInterceptors, paramSQLiteDatabase, this.mDefaultErrorHandler).proceed();
      return;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      label62:
      break label62;
    }
    this.mDefaultErrorHandler.onCorruption(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.QQDBErrorHandler
 * JD-Core Version:    0.7.0.1
 */