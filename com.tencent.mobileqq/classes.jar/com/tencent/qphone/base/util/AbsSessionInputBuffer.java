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
  protected ByteArrayBuffer linebuffer;
  protected int maxLineLen = -1;
  protected HttpTransportMetricsImpl metrics;
  
  private int lineFromLineBuffer(CharArrayBuffer paramCharArrayBuffer)
    throws IOException
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
    throws IOException
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
  
  protected abstract int fillBuffer()
    throws IOException;
  
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
    throws IOException
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
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
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
    if (i > paramInt2) {}
    for (;;)
    {
      System.arraycopy(this.buffer, this.bufferpos, paramArrayOfByte, paramInt1, paramInt2);
      this.bufferpos += paramInt2;
      return paramInt2;
      paramInt2 = i;
    }
  }
  
  public int readLine(CharArrayBuffer paramCharArrayBuffer)
    throws IOException
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    this.linebuffer.clear();
    int j = 1;
    int k = 0;
    if (j != 0)
    {
      int i = locateLF();
      int m;
      if (i != -1)
      {
        if (this.linebuffer.isEmpty()) {
          return lineFromReadBuffer(paramCharArrayBuffer, i);
        }
        j = this.bufferpos;
        this.linebuffer.append(this.buffer, this.bufferpos, i + 1 - j);
        this.bufferpos = (i + 1);
        i = 0;
        m = k;
      }
      for (;;)
      {
        j = i;
        k = m;
        if (this.maxLineLen <= 0) {
          break;
        }
        j = i;
        k = m;
        if (this.linebuffer.length() < this.maxLineLen) {
          break;
        }
        throw new IOException("Maximum line length limit exceeded");
        if (hasBufferedData())
        {
          i = this.bufferlen;
          k = this.bufferpos;
          this.linebuffer.append(this.buffer, this.bufferpos, i - k);
          this.bufferpos = this.bufferlen;
        }
        k = fillBuffer();
        i = j;
        m = k;
        if (k == -1)
        {
          i = 0;
          m = k;
        }
      }
    }
    if ((k == -1) && (this.linebuffer.isEmpty())) {
      return -1;
    }
    return lineFromLineBuffer(paramCharArrayBuffer);
  }
  
  public String readLine()
    throws IOException
  {
    CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(64);
    if (readLine(localCharArrayBuffer) != -1) {
      return localCharArrayBuffer.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.AbsSessionInputBuffer
 * JD-Core Version:    0.7.0.1
 */