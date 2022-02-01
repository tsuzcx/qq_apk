package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;

public class SQLiteAsyncCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory g = new SQLiteAsyncCursor.1();
  private final SQLiteAsyncQuery h;
  private final SQLiteCursorDriver i;
  private final String[] j;
  private ChunkedCursorWindow k;
  private long l;
  private volatile int m;
  private final Object n;
  private SQLiteAsyncCursor.QueryThread o;
  
  public SQLiteAsyncCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteAsyncQuery paramSQLiteAsyncQuery)
  {
    if (paramSQLiteAsyncQuery != null)
    {
      this.h = paramSQLiteAsyncQuery;
      this.i = paramSQLiteCursorDriver;
      this.j = paramSQLiteAsyncQuery.k();
      this.m = -1;
      this.n = new Object();
      this.k = new ChunkedCursorWindow(16777216);
      this.o = new SQLiteAsyncCursor.QueryThread(this);
      this.o.start();
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getCount());
  }
  
  private long b(int paramInt)
  {
    try
    {
      synchronized (this.n)
      {
        long l1;
        for (;;)
        {
          l1 = this.k.c(paramInt);
          if (l1 != 0L) {
            break label58;
          }
          if (!a(paramInt)) {
            break;
          }
          this.n.wait();
        }
        throw new CursorIndexOutOfBoundsException(this.b, this.m);
        label58:
        return l1;
      }
      return 0L;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  private boolean d()
  {
    ChunkedCursorWindow localChunkedCursorWindow = this.k;
    boolean bool = false;
    if (localChunkedCursorWindow == null) {
      return false;
    }
    if (!a(this.b)) {
      return false;
    }
    this.o.a(this.b);
    this.l = this.k.c(this.b);
    if (this.l == 0L) {
      this.l = b(this.b);
    }
    if (this.l != 0L) {
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    if (this.l != 0L) {
      return;
    }
    if (!a(this.b)) {
      throw new CursorIndexOutOfBoundsException(this.b, this.m);
    }
    throw new StaleDataException("Cannot get valid Row object");
  }
  
  protected void b()
  {
    long l1 = this.l;
    if (l1 != 0L)
    {
      this.k.a(l1);
      this.l = 0L;
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((SQLiteAsyncCursor.QueryThread)localObject).a();
    }
    try
    {
      this.o.join();
      label44:
      this.o = null;
      localObject = this.k;
      if (localObject != null)
      {
        ((ChunkedCursorWindow)localObject).close();
        this.k = null;
      }
      this.m = -1;
      this.b = -1;
      super.b();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label44;
    }
  }
  
  public void close()
  {
    super.close();
    this.h.close();
    this.i.b();
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.i.a();
  }
  
  public byte[] getBlob(int paramInt)
  {
    e();
    return this.k.b(this.l, paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.j;
  }
  
  public int getCount()
  {
    if (this.m >= 0) {
      return this.m;
    }
    if (this.k == null) {
      return -1;
    }
    try
    {
      synchronized (this.n)
      {
        while (this.m < 0) {
          this.n.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label55:
      break label55;
    }
    return this.m;
  }
  
  public double getDouble(int paramInt)
  {
    e();
    return this.k.e(this.l, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)getDouble(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)getLong(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    e();
    return this.k.d(this.l, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    e();
    return this.k.c(this.l, paramInt);
  }
  
  public int getType(int paramInt)
  {
    e();
    return this.k.a(this.l, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < -1) {
      i1 = -1;
    }
    if (i1 != this.b)
    {
      this.k.a(this.l);
      this.l = 0L;
    }
    paramInt = getCount();
    boolean bool2 = false;
    if (i1 >= paramInt)
    {
      this.b = paramInt;
      return false;
    }
    this.b = i1;
    boolean bool1 = bool2;
    if (i1 >= 0)
    {
      bool1 = bool2;
      if (d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor
 * JD-Core Version:    0.7.0.1
 */