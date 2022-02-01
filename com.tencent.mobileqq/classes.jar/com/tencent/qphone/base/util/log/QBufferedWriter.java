package com.tencent.qphone.base.util.log;

import java.io.IOException;

public class QBufferedWriter
  extends QWriter
{
  private static int defaultCharBufferSize = 8192;
  private char[] cb;
  private int nChars;
  private int nextChar;
  private QWriter out;
  
  public QBufferedWriter(QWriter paramQWriter)
  {
    this(paramQWriter, defaultCharBufferSize);
  }
  
  public QBufferedWriter(QWriter paramQWriter, int paramInt)
  {
    super(paramQWriter);
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Buffer size <= 0");
    }
    this.out = paramQWriter;
    this.cb = new char[paramInt];
    this.nChars = paramInt;
    this.nextChar = 0;
  }
  
  private void ensureOpen()
  {
    if (this.out == null) {
      throw new IOException("Stream closed");
    }
  }
  
  private int min(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      if (this.out == null) {
        return;
      }
    }
  }
  
  public void flush()
  {
    synchronized (this.lock)
    {
      flushBuffer();
      this.out.flush();
      return;
    }
  }
  
  void flushBuffer()
  {
    synchronized (this.lock)
    {
      ensureOpen();
      if (this.nextChar == 0) {
        return;
      }
      this.out.write(this.cb, 0, this.nextChar);
      this.nextChar = 0;
      return;
    }
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      ensureOpen();
      if (this.nextChar >= this.nChars) {
        flushBuffer();
      }
      char[] arrayOfChar = this.cb;
      int i = this.nextChar;
      this.nextChar = (i + 1);
      arrayOfChar[i] = ((char)paramInt);
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      ensureOpen();
      int i = paramInt1 + paramInt2;
      while (paramInt1 < i)
      {
        int j = min(this.nChars - this.nextChar, i - paramInt1);
        paramString.getChars(paramInt1, paramInt1 + j, this.cb, this.nextChar);
        paramInt2 = paramInt1 + j;
        this.nextChar = (j + this.nextChar);
        paramInt1 = paramInt2;
        if (this.nextChar >= this.nChars)
        {
          flushBuffer();
          paramInt1 = paramInt2;
        }
      }
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      flushBuffer();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      ensureOpen();
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
        throw new IndexOutOfBoundsException();
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 >= this.nChars)
    {
      flushBuffer();
      this.out.write(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    for (;;)
    {
      int i;
      if (paramInt1 < i)
      {
        int j = min(this.nChars - this.nextChar, i - paramInt1);
        System.arraycopy(paramArrayOfChar, paramInt1, this.cb, this.nextChar, j);
        paramInt2 = paramInt1 + j;
        this.nextChar = (j + this.nextChar);
        paramInt1 = paramInt2;
        if (this.nextChar >= this.nChars)
        {
          flushBuffer();
          paramInt1 = paramInt2;
        }
      }
      else
      {
        return;
        i = paramInt1 + paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.QBufferedWriter
 * JD-Core Version:    0.7.0.1
 */