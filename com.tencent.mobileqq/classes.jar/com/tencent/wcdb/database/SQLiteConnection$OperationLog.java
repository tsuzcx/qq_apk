package com.tencent.wcdb.database;

import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

final class SQLiteConnection$OperationLog
{
  private final SQLiteConnection.Operation[] b = new SQLiteConnection.Operation[20];
  private int c;
  private int d;
  
  private SQLiteConnection$OperationLog(SQLiteConnection paramSQLiteConnection) {}
  
  private void a(SQLiteConnection.Operation paramOperation, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramOperation.a(localStringBuilder, false);
    if (paramString != null)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
    }
    Log.c("WCDB.SQLiteConnection", localStringBuilder.toString());
  }
  
  private boolean a(SQLiteConnection.Operation paramOperation)
  {
    if (paramOperation != null)
    {
      paramOperation.b = System.currentTimeMillis();
      paramOperation.f = true;
      if ((paramOperation.g != null) && (paramOperation.g.getMessage() != null)) {
        return true;
      }
      return SQLiteDebug.a(paramOperation.b - paramOperation.a);
    }
    return false;
  }
  
  private int c(int paramInt)
  {
    int i = this.d;
    this.d = (i + 1);
    return paramInt | i << 8;
  }
  
  private SQLiteConnection.Operation d(int paramInt)
  {
    SQLiteConnection.Operation localOperation = this.b[(paramInt & 0xFF)];
    if (localOperation.h == paramInt) {
      return localOperation;
    }
    return null;
  }
  
  SQLiteConnection.Operation a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    int i;
    label248:
    synchronized (this.b)
    {
      int j = (this.c + 1) % 20;
      SQLiteConnection.Operation localOperation2 = this.b[j];
      i = 0;
      SQLiteConnection.Operation localOperation1;
      if (localOperation2 == null)
      {
        localOperation1 = new SQLiteConnection.Operation(null);
        this.b[j] = localOperation1;
      }
      else
      {
        localOperation2.f = false;
        localOperation2.g = null;
        localOperation1 = localOperation2;
        if (localOperation2.e != null)
        {
          localOperation2.e.clear();
          localOperation1 = localOperation2;
        }
      }
      localOperation1.a = System.currentTimeMillis();
      localOperation1.c = paramString1;
      localOperation1.d = paramString2;
      if (paramArrayOfObject != null)
      {
        if (localOperation1.e == null) {
          localOperation1.e = new ArrayList();
        } else {
          localOperation1.e.clear();
        }
        if (i < paramArrayOfObject.length)
        {
          paramString1 = paramArrayOfObject[i];
          if ((paramString1 != null) && ((paramString1 instanceof byte[])))
          {
            localOperation1.e.add(SQLiteConnection.g());
            break label248;
          }
          localOperation1.e.add(paramString1);
          break label248;
        }
      }
      localOperation1.h = c(j);
      localOperation1.j = SQLiteConnection.b(this.a);
      this.c = j;
      return localOperation1;
    }
  }
  
  String a()
  {
    synchronized (this.b)
    {
      Object localObject1 = this.b[this.c];
      if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).f))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        ((SQLiteConnection.Operation)localObject1).a(localStringBuilder, false);
        localObject1 = localStringBuilder.toString();
        return localObject1;
      }
      return null;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.b)
    {
      SQLiteConnection.Operation localOperation = d(paramInt);
      if (a(localOperation)) {
        a(localOperation, null);
      }
      String str1 = localOperation.d;
      String str2 = localOperation.c;
      paramInt = localOperation.i;
      long l1 = localOperation.b;
      long l2 = localOperation.a;
      if (!"prepare".equals(str2)) {
        SQLiteConnection.c(this.a).a(str1, paramInt, l1 - l2);
      }
      return;
    }
  }
  
  void a(int paramInt, Exception paramException)
  {
    synchronized (this.b)
    {
      SQLiteConnection.Operation localOperation = d(paramInt);
      if (localOperation != null) {
        localOperation.g = paramException;
      }
      return;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    synchronized (this.b)
    {
      SQLiteConnection.Operation localOperation = d(paramInt);
      if (localOperation != null) {
        a(localOperation, paramString);
      }
      return;
    }
  }
  
  SQLiteTrace.TraceInfo<String> b()
  {
    synchronized (this.b)
    {
      Object localObject1 = this.b[this.c];
      if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).f))
      {
        localObject1 = new SQLiteTrace.TraceInfo(((SQLiteConnection.Operation)localObject1).d, ((SQLiteConnection.Operation)localObject1).a, ((SQLiteConnection.Operation)localObject1).j);
        return localObject1;
      }
      return null;
    }
  }
  
  boolean b(int paramInt)
  {
    synchronized (this.b)
    {
      SQLiteConnection.Operation localOperation = d(paramInt);
      if (localOperation == null) {
        return false;
      }
      boolean bool = a(localOperation);
      String str1 = localOperation.d;
      String str2 = localOperation.c;
      paramInt = localOperation.i;
      long l1 = localOperation.b;
      long l2 = localOperation.a;
      if (!"prepare".equals(str2)) {
        SQLiteConnection.c(this.a).a(str1, paramInt, l1 - l2);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.OperationLog
 * JD-Core Version:    0.7.0.1
 */