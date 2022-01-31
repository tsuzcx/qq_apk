package com.tencent.mobileqq.microapp.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class g
  implements Closeable
{
  private final InputStream a;
  private final Charset b;
  private byte[] c;
  private int d;
  private int e;
  
  public g(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream == null) || (paramCharset == null)) {
      throw new NullPointerException();
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("capacity <= 0");
    }
    if (!paramCharset.equals(i.a)) {
      throw new IllegalArgumentException("Unsupported encoding");
    }
    this.a = paramInputStream;
    this.b = paramCharset;
    this.c = new byte[paramInt];
  }
  
  public g(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void c()
  {
    int i = this.a.read(this.c, 0, this.c.length);
    if (i == -1) {
      throw new EOFException();
    }
    this.d = 0;
    this.e = i;
  }
  
  public String a()
  {
    synchronized (this.a)
    {
      if (this.c == null) {
        throw new IOException("LineReader is closed");
      }
    }
    if (this.d >= this.e) {
      c();
    }
    int i = this.d;
    for (;;)
    {
      if (i != this.e)
      {
        if (this.c[i] != 10) {
          break label272;
        }
        if ((i == this.d) || (this.c[(i - 1)] != 13)) {
          break label267;
        }
      }
      label267:
      for (int j = i - 1;; j = i)
      {
        Object localObject2 = new String(this.c, this.d, j - this.d, this.b.name());
        this.d = (i + 1);
        return localObject2;
        localObject2 = new h(this, this.e - this.d + 80);
        for (;;)
        {
          ((ByteArrayOutputStream)localObject2).write(this.c, this.d, this.e - this.d);
          this.e = -1;
          c();
          i = this.d;
          while (i != this.e)
          {
            if (this.c[i] == 10)
            {
              if (i != this.d) {
                ((ByteArrayOutputStream)localObject2).write(this.c, this.d, i - this.d);
              }
              this.d = (i + 1);
              localObject2 = ((ByteArrayOutputStream)localObject2).toString();
              return localObject2;
            }
            i += 1;
          }
        }
      }
      label272:
      i += 1;
    }
  }
  
  public boolean b()
  {
    return this.e == -1;
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        this.c = null;
        this.a.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.g
 * JD-Core Version:    0.7.0.1
 */