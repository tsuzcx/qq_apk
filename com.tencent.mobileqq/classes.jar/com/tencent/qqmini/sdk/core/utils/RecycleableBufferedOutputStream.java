package com.tencent.qqmini.sdk.core.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RecycleableBufferedOutputStream
  extends FilterOutputStream
{
  private static final int MAX_POOL_SIZE = 4;
  private static final Object POOL_LOCK = new Object();
  private static int poolSize = 0;
  private static RecycleableBufferedOutputStream sPool;
  protected byte[] buf;
  protected int count;
  private RecycleableBufferedOutputStream next;
  private boolean used;
  
  private RecycleableBufferedOutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  private RecycleableBufferedOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.buf = new byte[paramInt];
    this.used = true;
  }
  
  private void checkNotClosed()
  {
    if (this.used) {
      return;
    }
    throw new IOException("BufferedOutputStream is closed");
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void clearForRecycle()
  {
    this.count = 0;
    this.out = null;
    this.used = false;
  }
  
  private void flushInternal()
  {
    if (this.count > 0)
    {
      this.out.write(this.buf, 0, this.count);
      this.count = 0;
    }
  }
  
  public static RecycleableBufferedOutputStream obtain(OutputStream paramOutputStream)
  {
    for (;;)
    {
      synchronized (POOL_LOCK)
      {
        if (sPool != null)
        {
          localRecycleableBufferedOutputStream = sPool;
          sPool = localRecycleableBufferedOutputStream.next;
          localRecycleableBufferedOutputStream.next = null;
          poolSize -= 1;
          if (localRecycleableBufferedOutputStream != null)
          {
            localRecycleableBufferedOutputStream.out = paramOutputStream;
            localRecycleableBufferedOutputStream.used = true;
            return localRecycleableBufferedOutputStream;
          }
          return new RecycleableBufferedOutputStream(paramOutputStream);
        }
      }
      RecycleableBufferedOutputStream localRecycleableBufferedOutputStream = null;
    }
  }
  
  private void recycle()
  {
    clearForRecycle();
    synchronized (POOL_LOCK)
    {
      if (poolSize < 4)
      {
        this.next = sPool;
        sPool = this;
        poolSize += 1;
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
    //   3: getfield 40	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:used	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 100	java/io/FilterOutputStream:close	()V
    //   18: aload_0
    //   19: invokespecial 102	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:recycle	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_0
    //   27: invokespecial 102	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:recycle	()V
    //   30: aload_2
    //   31: athrow
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	RecycleableBufferedOutputStream
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
      checkNotClosed();
      flushInternal();
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
      checkNotClosed();
      if (this.count == this.buf.length)
      {
        this.out.write(this.buf, 0, this.count);
        this.count = 0;
      }
      byte[] arrayOfByte = this.buf;
      int i = this.count;
      this.count = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      checkNotClosed();
      if (paramArrayOfByte != null)
      {
        byte[] arrayOfByte = this.buf;
        if (paramInt2 >= arrayOfByte.length)
        {
          flushInternal();
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
        if (paramInt2 > arrayOfByte.length - this.count) {
          flushInternal();
        }
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.count, paramInt2);
        this.count += paramInt2;
        return;
      }
      throw new NullPointerException("buffer == null");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.RecycleableBufferedOutputStream
 * JD-Core Version:    0.7.0.1
 */