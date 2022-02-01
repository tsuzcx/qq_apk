package com.tencent.qqmini.sdk.cache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class StrictLineReader
  implements Closeable
{
  private static final byte CR = 13;
  private static final byte LF = 10;
  private byte[] buf;
  private final Charset charset;
  private int end;
  private final InputStream in;
  private int pos;
  
  public StrictLineReader(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramInt >= 0)
      {
        if (paramCharset.equals(DiskLruCacheUtil.US_ASCII))
        {
          this.in = paramInputStream;
          this.charset = paramCharset;
          this.buf = new byte[paramInt];
          return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
      }
      throw new IllegalArgumentException("capacity <= 0");
    }
    throw new NullPointerException();
  }
  
  public StrictLineReader(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void fillBuf()
  {
    InputStream localInputStream = this.in;
    byte[] arrayOfByte = this.buf;
    int i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1)
    {
      this.pos = 0;
      this.end = i;
      return;
    }
    throw new EOFException();
  }
  
  public void close()
  {
    synchronized (this.in)
    {
      if (this.buf != null)
      {
        this.buf = null;
        this.in.close();
      }
      return;
    }
  }
  
  public boolean hasUnterminatedLine()
  {
    return this.end == -1;
  }
  
  public String readLine()
  {
    int i;
    int j;
    label276:
    label283:
    synchronized (this.in)
    {
      if (this.buf != null)
      {
        if (this.pos >= this.end) {
          fillBuf();
        }
        i = this.pos;
        Object localObject1;
        if (i != this.end)
        {
          if (this.buf[i] != 10) {
            break label276;
          }
          if (i != this.pos)
          {
            localObject1 = this.buf;
            j = i - 1;
            if (localObject1[j] == 13)
            {
              localObject1 = new String(this.buf, this.pos, j - this.pos, this.charset.name());
              this.pos = (i + 1);
              return localObject1;
            }
          }
        }
        else
        {
          localObject1 = new StrictLineReader.1(this, this.end - this.pos + 80);
          do
          {
            ((ByteArrayOutputStream)localObject1).write(this.buf, this.pos, this.end - this.pos);
            this.end = -1;
            fillBuf();
            i = this.pos;
          } while (i == this.end);
          if (this.buf[i] != 10) {
            break label283;
          }
          if (i != this.pos) {
            ((ByteArrayOutputStream)localObject1).write(this.buf, this.pos, i - this.pos);
          }
          this.pos = (i + 1);
          localObject1 = ((ByteArrayOutputStream)localObject1).toString();
          return localObject1;
        }
      }
      else
      {
        throw new IOException("LineReader is closed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.StrictLineReader
 * JD-Core Version:    0.7.0.1
 */