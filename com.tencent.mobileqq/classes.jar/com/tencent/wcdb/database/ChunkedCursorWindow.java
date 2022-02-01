package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow
  extends SQLiteClosable
{
  long a;
  private int b = 0;
  
  public ChunkedCursorWindow(int paramInt)
  {
    this.a = nativeCreate(paramInt);
    if (this.a != 0L) {
      return;
    }
    throw new CursorWindowAllocationException("Cursor window allocation failed.");
  }
  
  private void d()
  {
    long l = this.a;
    if (l != 0L)
    {
      nativeDispose(l);
      this.a = 0L;
    }
  }
  
  private static native void nativeClear(long paramLong);
  
  private static native long nativeCreate(int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeEndRow(long paramLong1, long paramLong2);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native int nativeGetNumChunks(long paramLong);
  
  private static native long nativeGetRow(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native long nativeRemoveChunk(long paramLong, int paramInt);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  int a(long paramLong, int paramInt)
  {
    return nativeGetType(paramLong, paramInt);
  }
  
  public long a(int paramInt)
  {
    h();
    try
    {
      long l = nativeRemoveChunk(this.a, paramInt);
      return l;
    }
    finally
    {
      i();
    }
  }
  
  public void a()
  {
    h();
    try
    {
      nativeClear(this.a);
      return;
    }
    finally
    {
      i();
    }
  }
  
  void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    nativeEndRow(this.a, paramLong);
    i();
  }
  
  public int b()
  {
    h();
    try
    {
      int i = nativeGetNumChunks(this.a);
      return i;
    }
    finally
    {
      i();
    }
  }
  
  public boolean b(int paramInt)
  {
    h();
    try
    {
      boolean bool = nativeSetNumColumns(this.a, paramInt);
      if (bool) {
        this.b = paramInt;
      }
      return bool;
    }
    finally
    {
      i();
    }
  }
  
  byte[] b(long paramLong, int paramInt)
  {
    return nativeGetBlob(paramLong, paramInt);
  }
  
  public int c()
  {
    return this.b;
  }
  
  long c(int paramInt)
  {
    h();
    long l = nativeGetRow(this.a, paramInt);
    if (l == 0L) {
      i();
    }
    return l;
  }
  
  String c(long paramLong, int paramInt)
  {
    return nativeGetString(paramLong, paramInt);
  }
  
  long d(long paramLong, int paramInt)
  {
    return nativeGetLong(paramLong, paramInt);
  }
  
  double e(long paramLong, int paramInt)
  {
    return nativeGetDouble(paramLong, paramInt);
  }
  
  protected void finalize()
  {
    try
    {
      d();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.ChunkedCursorWindow
 * JD-Core Version:    0.7.0.1
 */