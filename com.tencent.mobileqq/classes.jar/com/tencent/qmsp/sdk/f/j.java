package com.tencent.qmsp.sdk.f;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class j
  extends FilterOutputStream
{
  private static j e;
  private static int f;
  private static final Object g = new Object();
  private boolean a;
  private j b;
  protected byte[] c;
  protected int d;
  
  private j(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  private j(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.c = a.a().a(paramInt);
    this.a = true;
  }
  
  public static j a(OutputStream paramOutputStream)
  {
    for (;;)
    {
      synchronized (g)
      {
        if (e != null)
        {
          localj = e;
          e = localj.b;
          localj.b = null;
          f -= 1;
          if (localj != null)
          {
            localj.out = paramOutputStream;
            localj.a = true;
            return localj;
          }
          return new j(paramOutputStream);
        }
      }
      j localj = null;
    }
  }
  
  private void a()
  {
    if (this.a) {
      return;
    }
    throw new IOException("BufferedOutputStream is closed");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) >= 0) && (paramInt2 <= paramInt1) && (paramInt1 - paramInt2 >= paramInt3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt3);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private void b()
  {
    this.d = 0;
    this.out = null;
    this.a = false;
  }
  
  private void c()
  {
    int i = this.d;
    if (i > 0)
    {
      this.out.write(this.c, 0, i);
      this.d = 0;
    }
  }
  
  private void d()
  {
    b();
    synchronized (g)
    {
      if (f < 4)
      {
        this.b = e;
        e = this;
        f += 1;
      }
      return;
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/qmsp/sdk/f/j:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 100	java/io/FilterOutputStream:close	()V
    //   18: aload_0
    //   19: invokespecial 102	com/tencent/qmsp/sdk/f/j:d	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_0
    //   27: invokespecial 102	com/tencent/qmsp/sdk/f/j:d	()V
    //   30: aload_2
    //   31: athrow
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	j
    //   6	2	1	bool	boolean
    //   25	6	2	localObject1	Object
    //   32	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	18	25	finally
    //   2	7	32	finally
    //   18	22	32	finally
    //   26	32	32	finally
  }
  
  public void flush()
  {
    try
    {
      a();
      c();
      this.out.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      a();
      int i = this.d;
      byte[] arrayOfByte = this.c;
      if (i == arrayOfByte.length)
      {
        this.out.write(arrayOfByte, 0, i);
        this.d = 0;
      }
      arrayOfByte = this.c;
      i = this.d;
      this.d = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a();
      if (paramArrayOfByte != null)
      {
        byte[] arrayOfByte = this.c;
        if (paramInt2 >= arrayOfByte.length)
        {
          c();
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        a(paramArrayOfByte.length, paramInt1, paramInt2);
        if (paramInt2 > arrayOfByte.length - this.d) {
          c();
        }
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.d, paramInt2);
        this.d += paramInt2;
        return;
      }
      throw new NullPointerException("buffer == null");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.j
 * JD-Core Version:    0.7.0.1
 */