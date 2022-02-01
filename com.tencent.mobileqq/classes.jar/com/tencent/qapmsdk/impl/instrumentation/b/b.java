package com.tencent.qapmsdk.impl.instrumentation.b;

import java.io.IOException;
import java.io.OutputStream;

public class b
  extends OutputStream
  implements f
{
  private final OutputStream a;
  private long b = 0L;
  private final e c = new e();
  
  public b(OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  private void a(Exception paramException)
  {
    if (!this.c.a()) {
      this.c.b(new c(this, this.b, paramException));
    }
  }
  
  private void b()
  {
    if (!this.c.a()) {
      this.c.a(new c(this, this.b));
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(d paramd)
  {
    this.c.a(paramd);
  }
  
  public void b(d paramd)
  {
    this.c.b(paramd);
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      b();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void flush()
  {
    try
    {
      this.a.flush();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      this.a.write(paramInt);
      this.b += 1L;
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    try
    {
      this.a.write(paramArrayOfByte);
      this.b += paramArrayOfByte.length;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.a.write(paramArrayOfByte, paramInt1, paramInt2);
      this.b += paramInt2;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.b.b
 * JD-Core Version:    0.7.0.1
 */