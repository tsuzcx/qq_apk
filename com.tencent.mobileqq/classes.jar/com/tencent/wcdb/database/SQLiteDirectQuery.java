package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectQuery
  extends SQLiteProgram
{
  private static final int[] c = { 3, 1, 2, 3, 4, 0 };
  private final CancellationSignal b;
  
  public SQLiteDirectQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.b = paramCancellationSignal;
  }
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native int nativeStep(long paramLong, int paramInt);
  
  public long a(int paramInt)
  {
    return nativeGetLong(this.a.a(), paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.a != null)
      {
        this.a.a(false);
        if (paramBoolean)
        {
          this.a.b(this.b);
          this.a.a(null);
          o();
        }
      }
      return;
    }
    finally {}
  }
  
  public double b(int paramInt)
  {
    return nativeGetDouble(this.a.a(), paramInt);
  }
  
  public String c(int paramInt)
  {
    return nativeGetString(this.a.a(), paramInt);
  }
  
  public byte[] d(int paramInt)
  {
    return nativeGetBlob(this.a.a(), paramInt);
  }
  
  public int e(int paramInt)
  {
    return c[nativeGetType(this.a.a(), paramInt)];
  }
  
  public int f(int paramInt)
  {
    try
    {
      if (b(false))
      {
        this.a.a("directQuery", j());
        this.a.a(this.b);
      }
      paramInt = nativeStep(this.a.a(), paramInt);
      return paramInt;
    }
    catch (RuntimeException localRuntimeException)
    {
      if ((localRuntimeException instanceof SQLiteException))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got exception on stepping: ");
        localStringBuilder.append(localRuntimeException.getMessage());
        localStringBuilder.append(", SQL: ");
        localStringBuilder.append(f());
        Log.a("WCDB.SQLiteDirectQuery", localStringBuilder.toString());
        a((SQLiteException)localRuntimeException);
      }
      if (this.a != null)
      {
        this.a.b(this.b);
        this.a.a(localRuntimeException);
      }
      o();
      throw localRuntimeException;
    }
  }
  
  protected void g()
  {
    try
    {
      if (this.a != null)
      {
        this.a.b(this.b);
        this.a.a(null);
      }
      super.g();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectQuery
 * JD-Core Version:    0.7.0.1
 */