package com.tencent.qphone.base.util;

import java.io.IOException;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbsSessionInputBuffer
  implements SessionInputBuffer
{
  protected boolean ascii = true;
  protected byte[] buffer;
  protected int bufferlen;
  protected int bufferpos;
  protected String charset = "US-ASCII";
  protected ByteArrayBuffer linebuffer = null;
  protected int maxLineLen = -1;
  protected HttpTransportMetricsImpl metrics;
  
  private int lineFromLineBuffer(CharArrayBuffer paramCharArrayBuffer)
  {
    int j = this.linebuffer.length();
    if (j > 0)
    {
      i = j;
      if (this.linebuffer.byteAt(j - 1) == 10)
      {
        i = j - 1;
        this.linebuffer.setLength(i);
      }
      if ((i > 0) && (this.linebuffer.byteAt(i - 1) == 13)) {
        this.linebuffer.setLength(i - 1);
      }
    }
    int i = this.linebuffer.length();
    if (this.ascii)
    {
      paramCharArrayBuffer.append(this.linebuffer, 0, i);
      return i;
    }
    paramCharArrayBuffer.append(new String(this.linebuffer.buffer(), 0, i, this.charset));
    return i;
  }
  
  private int lineFromReadBuffer(CharArrayBuffer paramCharArrayBuffer, int paramInt)
  {
    int j = this.bufferpos;
    this.bufferpos = (paramInt + 1);
    int i = paramInt;
    if (paramInt > j)
    {
      i = paramInt;
      if (this.buffer[(paramInt - 1)] == 13) {
        i = paramInt - 1;
      }
    }
    paramInt = i - j;
    if (this.ascii)
    {
      paramCharArrayBuffer.append(this.buffer, j, paramInt);
      return paramInt;
    }
    paramCharArrayBuffer.append(new String(this.buffer, j, paramInt, this.charset));
    return paramInt;
  }
  
  private int locateLF()
  {
    int i = this.bufferpos;
    while (i < this.bufferlen)
    {
      if (this.buffer[i] == 10) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected abstract int fillBuffer();
  
  public byte[] getBuffer()
  {
    return this.buffer;
  }
  
  public int getBufferlen()
  {
    return this.bufferlen;
  }
  
  public int getBufferpos()
  {
    return this.bufferpos;
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return this.metrics;
  }
  
  public boolean hasBufferedData()
  {
    return this.bufferpos < this.bufferlen;
  }
  
  public int read()
  {
    while (!hasBufferedData()) {
      if (fillBuffer() == -1) {
        return -1;
      }
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferpos;
    this.bufferpos = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    while (!hasBufferedData()) {
      if (fillBuffer() == -1) {
        return -1;
      }
    }
    int i = this.bufferlen - this.bufferpos;
    if (i <= paramInt2) {
      paramInt2 = i;
    }
    System.arraycopy(this.buffer, this.bufferpos, paramArrayOfByte, paramInt1, paramInt2);
    this.bufferpos += paramInt2;
    return paramInt2;
  }
  
  public int readLine(CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer != null)
    {
      this.linebuffer.clear();
      int k = 1;
      int i = 0;
      while (k != 0)
      {
        int j = locateLF();
        if (j != -1)
        {
          if (this.linebuffer.isEmpty()) {
            return lineFromReadBuffer(paramCharArrayBuffer, j);
          }
          j += 1;
          k = this.bufferpos;
          this.linebuffer.append(this.buffer, k, j - k);
          this.bufferpos = j;
        }
        int m;
        do
        {
          m = 0;
          j = i;
          break;
          if (hasBufferedData())
          {
            i = this.bufferlen;
            j = this.bufferpos;
            this.linebuffer.append(this.buffer, j, i - j);
            this.bufferpos = this.bufferlen;
          }
          i = fillBuffer();
          m = k;
          j = i;
        } while (i == -1);
        k = m;
        i = j;
        if (this.maxLineLen > 0) {
          if (this.linebuffer.length() < this.maxLineLen)
          {
            k = m;
            i = j;
          }
          else
          {
            throw new IOException("Maximum line length limit exceeded");
          }
        }
      }
      if ((i == -1) && (this.linebuffer.isEmpty())) {
        return -1;
      }
      return lineFromLineBuffer(paramCharArrayBuffer);
    }
    paramCharArrayBuffer = new IllegalArgumentException("Char array buffer may not be null");
    for (;;)
    {
      throw paramCharArrayBuffer;
    }
  }
  
  public String readLine()
  {
    CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(64);
    if (readLine(localCharArrayBuffer) != -1) {
      return localCharArrayBuffer.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.AbsSessionInputBuffer
 * JD-Core Version:    0.7.0.1
 */