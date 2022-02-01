package com.tencent.qapmsdk.impl.instrumentation.b;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public class a
  extends InputStream
  implements f
{
  private final InputStream a;
  private long b = 0L;
  private final e c = new e();
  private final ByteBuffer d;
  private boolean e = false;
  
  public a(InputStream paramInputStream)
  {
    this.a = paramInputStream;
    if (this.e)
    {
      this.d = ByteBuffer.allocate(1024);
      a();
      return;
    }
    this.d = null;
  }
  
  public a(InputStream paramInputStream, boolean paramBoolean)
  {
    this.a = paramInputStream;
    this.e = paramBoolean;
    if (paramBoolean)
    {
      this.d = ByteBuffer.allocate(1024);
      a();
      return;
    }
    this.d = null;
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (d()) {
      return -1;
    }
    int i = this.d.remaining();
    this.d.get(paramArrayOfByte, paramInt1, paramInt2);
    return i - this.d.remaining();
  }
  
  private void a(Exception paramException)
  {
    if (!this.c.a()) {
      this.c.b(new c(this, this.b, paramException));
    }
  }
  
  private boolean a(long paramLong)
  {
    return this.d.remaining() >= paramLong;
  }
  
  private int c()
  {
    if (d()) {
      return -1;
    }
    return this.d.get();
  }
  
  private boolean d()
  {
    return !this.d.hasRemaining();
  }
  
  private void e()
  {
    if (!this.c.a()) {
      this.c.a(new c(this, this.b));
    }
  }
  
  public void a()
  {
    if ((this.d == null) || (!this.d.hasArray())) {
      return;
    }
    try
    {
      synchronized (this.d)
      {
        i = this.a.read(this.d.array(), 0, this.d.capacity());
        if (i <= 0)
        {
          this.d.limit(0);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCountingInputStream", localIOException.toString() });
        int i = 0;
        continue;
        if (i < this.d.capacity()) {
          this.d.limit(i);
        }
      }
    }
  }
  
  public void a(d paramd)
  {
    this.c.a(paramd);
  }
  
  public int available()
  {
    int i = 0;
    if (this.e) {
      i = this.d.remaining();
    }
    try
    {
      int j = this.a.available();
      return i + j;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public String b()
  {
    if (this.d != null) {
      synchronized (this.d)
      {
        Object localObject1 = new byte[this.d.limit()];
        int i = 0;
        while (i < this.d.limit())
        {
          localObject1[i] = this.d.get(i);
          i += 1;
        }
        localObject1 = new String((byte[])localObject1);
        return localObject1;
      }
    }
    return "";
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
      e();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void mark(int paramInt)
  {
    if (!markSupported()) {
      return;
    }
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    if (this.e) {}
    int i;
    synchronized (this.d)
    {
      if (a(1L))
      {
        i = c();
        if (i >= 0) {
          this.b += 1L;
        }
        return i;
      }
      try
      {
        i = this.a.read();
        if (i >= 0)
        {
          this.b += 1L;
          return i;
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException);
        throw localIOException;
      }
    }
    e();
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    ByteBuffer localByteBuffer;
    int j;
    if (this.e)
    {
      localByteBuffer = this.d;
      long l = i;
      try
      {
        if (a(l))
        {
          i = a(paramArrayOfByte);
          if (i >= 0)
          {
            this.b += i;
            return i;
          }
          throw new IOException("readBufferBytes failed");
        }
      }
      finally {}
      j = this.d.remaining();
      if (j > 0)
      {
        j = a(paramArrayOfByte, 0, j);
        if (j < 0) {
          throw new IOException("partial read from buffer failed");
        }
        i -= j;
        this.b += j;
      }
    }
    for (;;)
    {
      try
      {
        i = this.a.read(paramArrayOfByte, j, i);
        if (i >= 0)
        {
          this.b += i;
          return i + j;
        }
        if (j <= 0)
        {
          e();
          return i;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCountingInputStream", paramArrayOfByte.toString() });
        System.out.println("NOTIFY STREAM ERROR: " + paramArrayOfByte);
        paramArrayOfByte.printStackTrace();
        a(paramArrayOfByte);
        throw paramArrayOfByte;
      }
      return j;
      j = 0;
      break;
      j = 0;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = 0;
    int j = paramInt2;
    ByteBuffer localByteBuffer;
    if (this.e)
    {
      localByteBuffer = this.d;
      long l = paramInt2;
      try
      {
        if (a(l))
        {
          paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2);
          if (paramInt1 >= 0)
          {
            this.b += paramInt1;
            return paramInt1;
          }
          throw new IOException("readBufferBytes failed");
        }
      }
      finally {}
      int m = this.d.remaining();
      i = k;
      j = paramInt2;
      if (m > 0)
      {
        i = a(paramArrayOfByte, paramInt1, m);
        if (i < 0) {
          throw new IOException("partial read from buffer failed");
        }
        j = paramInt2 - i;
        this.b += i;
      }
    }
    try
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1 + i, j);
      if (paramInt1 >= 0)
      {
        this.b += paramInt1;
        return paramInt1 + i;
      }
      if (i <= 0)
      {
        e();
        return paramInt1;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
    return i;
  }
  
  public void reset()
  {
    if (!markSupported()) {
      return;
    }
    try
    {
      this.a.reset();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public long skip(long paramLong)
  {
    long l = paramLong;
    if (this.e) {}
    synchronized (this.d)
    {
      if (a(paramLong))
      {
        this.d.position((int)paramLong);
        this.b += paramLong;
        return paramLong;
      }
      l = paramLong - this.d.remaining();
      if (l > 0L)
      {
        this.d.position(this.d.remaining());
        try
        {
          paramLong = this.a.skip(l);
          this.b += paramLong;
          return paramLong;
        }
        catch (IOException localIOException)
        {
          a(localIOException);
          throw localIOException;
        }
      }
      throw new IOException("partial read from buffer (skip) failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.b.a
 * JD-Core Version:    0.7.0.1
 */