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
    if (!this.used) {
      throw new IOException("BufferedOutputStream is closed");
    }
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new IndexOutOfBoundsException("length=" + paramInt1 + "; regionStart=" + paramInt2 + "; regionLength=" + paramInt3);
    }
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
    RecycleableBufferedOutputStream localRecycleableBufferedOutputStream = null;
    synchronized (POOL_LOCK)
    {
      if (sPool != null)
      {
        localRecycleableBufferedOutputStream = sPool;
        sPool = localRecycleableBufferedOutputStream.next;
        localRecycleableBufferedOutputStream.next = null;
        poolSize -= 1;
      }
      if (localRecycleableBufferedOutputStream != null)
      {
        localRecycleableBufferedOutputStream.out = paramOutputStream;
        localRecycleableBufferedOutputStream.used = true;
        return localRecycleableBufferedOutputStream;
      }
    }
    return new RecycleableBufferedOutputStream(paramOutputStream);
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
  
  public void close()
  {
    try
    {
      boolean bool = this.used;
      if (bool) {
        break label14;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          label14:
          super.close();
          recycle();
        }
      }
      finally
      {
        recycle();
      }
      localObject1 = finally;
    }
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
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer == null");
      }
    }
    finally {}
    byte[] arrayOfByte = this.buf;
    if (paramInt2 >= arrayOfByte.length)
    {
      flushInternal();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      if (paramInt2 > arrayOfByte.length - this.count) {
        flushInternal();
      }
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.count, paramInt2);
      this.count += paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.RecycleableBufferedOutputStream
 * JD-Core Version:    0.7.0.1
 */