package com.tencent.mobileqq.data.entitymanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public class FindTableNameInterceptorChain
  implements Interceptor.Chain<Class>
{
  public final SQLiteDatabase db;
  private final int index;
  private final List<Interceptor<Class>> interceptors;
  public final int newVersion;
  public final int oldVersion;
  public final String tableName;
  
  public FindTableNameInterceptorChain(int paramInt1, String paramString, List<Interceptor<Class>> paramList, int paramInt2, int paramInt3, SQLiteDatabase paramSQLiteDatabase)
  {
    this.index = paramInt1;
    this.oldVersion = paramInt2;
    this.newVersion = paramInt3;
    this.tableName = paramString;
    this.interceptors = paramList;
    this.db = paramSQLiteDatabase;
  }
  
  public Class proceed()
  {
    return proceed(this.tableName);
  }
  
  public Class proceed(String paramString)
  {
    List localList = this.interceptors;
    if ((localList != null) && (this.index < localList.size())) {
      return (Class)((Interceptor)this.interceptors.get(this.index)).intercept(new FindTableNameInterceptorChain(this.index + 1, paramString, this.interceptors, this.oldVersion, this.newVersion, this.db));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain
 * JD-Core Version:    0.7.0.1
 */