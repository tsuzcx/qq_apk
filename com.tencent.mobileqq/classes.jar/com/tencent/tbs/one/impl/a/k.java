package com.tencent.tbs.one.impl.a;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public final class k
  extends InputStream
{
  public long a = 0L;
  public k.a b;
  private InputStream c;
  private long d;
  private int e = 0;
  
  public k(InputStream paramInputStream, long paramLong)
  {
    this.c = paramInputStream;
    this.d = paramLong;
  }
  
  private void a()
  {
    k.a locala = this.b;
    if (locala != null)
    {
      if (locala.a()) {
        return;
      }
      throw new IOException("Aborted");
    }
  }
  
  private void b()
  {
    long l = this.d;
    if (l > 0L)
    {
      k.a locala = this.b;
      if (locala != null)
      {
        double d1 = this.a;
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        int i = (int)(d1 / d2 * 100.0D);
        if (i - this.e >= 2)
        {
          this.e = i;
          locala.a(i);
        }
      }
    }
  }
  
  public final int available()
  {
    return this.c.available();
  }
  
  public final void close()
  {
    this.c.close();
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.c.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return this.c.markSupported();
  }
  
  public final int read()
  {
    a();
    int i = this.c.read();
    if (i != -1)
    {
      this.a += 1L;
      b();
    }
    return i;
  }
  
  public final int read(@NonNull byte[] paramArrayOfByte)
  {
    a();
    int i = this.c.read(paramArrayOfByte);
    if (i != -1)
    {
      this.a += i;
      b();
    }
    return i;
  }
  
  public final int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1)
    {
      this.a += paramInt1;
      b();
    }
    return paramInt1;
  }
  
  public final void reset()
  {
    try
    {
      this.c.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    return this.c.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.k
 * JD-Core Version:    0.7.0.1
 */