package com.tencent.upload.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.upload.e.c;
import com.tencent.upload.network.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b
  implements a
{
  private static final AtomicInteger b = new AtomicInteger(0);
  protected final int a = b.incrementAndGet();
  private int c;
  private a.a d;
  private Object e;
  
  public b() {}
  
  public b(int paramInt)
  {
    this();
    this.c = paramInt;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(a.a parama)
  {
    this.d = parama;
  }
  
  public void a(Object paramObject)
  {
    this.e = paramObject;
  }
  
  public byte[] a()
    throws IOException
  {
    try
    {
      Object localObject = h();
      if (localObject == null)
      {
        com.tencent.upload.common.b.e("UploadRequest", "createJceRequest return null");
        return null;
      }
      try
      {
        byte[] arrayOfByte = com.tencent.upload.e.b.a((JceStruct)localObject);
        arrayOfByte = c.a(d(), this.a, arrayOfByte);
        return arrayOfByte;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.tencent.upload.common.b.e("UploadRequest", "encode request OOM. gc, then retry");
        System.gc();
        localObject = com.tencent.upload.e.b.a((JceStruct)localObject);
        localObject = c.a(d(), this.a, (byte[])localObject);
        return localObject;
      }
      return null;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      com.tencent.upload.common.b.c("UploadRequest", "encode exception. reqId=" + c(), localFileNotFoundException);
      return null;
    }
    catch (IOException localIOException)
    {
      com.tencent.upload.common.b.c("UploadRequest", "encode exception. reqId=" + c(), localIOException);
      throw localIOException;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.upload.common.b.c("UploadRequest", "encode exception. reqId=" + c(), localThrowable);
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return 1;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public a.a f()
  {
    return this.d;
  }
  
  public Object g()
  {
    return this.e;
  }
  
  protected abstract JceStruct h()
    throws IOException;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=").append(b()).append(" reqId=").append(c()).append(" cmd=").append(d());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.b
 * JD-Core Version:    0.7.0.1
 */