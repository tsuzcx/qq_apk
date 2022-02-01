package com.tencent.mobileqq.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import java.io.ByteArrayOutputStream;

public class PoolingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  private final ByteArrayPool a;
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    this.a = paramByteArrayPool;
    this.buf = this.a.getBuf(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.a.getBuf((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.returnBuf(this.buf);
    this.buf = arrayOfByte;
  }
  
  public byte[] a()
  {
    return this.buf;
  }
  
  public void close()
  {
    this.a.returnBuf(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PoolingByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */