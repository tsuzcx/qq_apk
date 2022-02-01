package com.tencent.mobileqq.data.entitymanager;

import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public class CorruptionInterceptorChain
  implements Interceptor.Chain<Void>
{
  public final SQLiteDatabase database;
  public final DefaultDatabaseErrorHandler defaultErrorHandler;
  private final int index;
  private final List<Interceptor<Void>> interceptors;
  
  public CorruptionInterceptorChain(int paramInt, List<Interceptor<Void>> paramList, SQLiteDatabase paramSQLiteDatabase, DefaultDatabaseErrorHandler paramDefaultDatabaseErrorHandler)
  {
    this.index = paramInt;
    this.interceptors = paramList;
    this.database = paramSQLiteDatabase;
    this.defaultErrorHandler = paramDefaultDatabaseErrorHandler;
  }
  
  public Void proceed()
  {
    if ((this.interceptors != null) && (this.index < this.interceptors.size())) {
      return (Void)((Interceptor)this.interceptors.get(this.index)).intercept(new CorruptionInterceptorChain(this.index + 1, this.interceptors, this.database, this.defaultErrorHandler));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.CorruptionInterceptorChain
 * JD-Core Version:    0.7.0.1
 */