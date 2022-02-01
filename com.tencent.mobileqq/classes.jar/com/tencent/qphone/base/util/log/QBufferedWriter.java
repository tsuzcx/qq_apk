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
    if (paramInt > 0)
    {
      this.out = paramQWriter;
      this.cb = new char[paramInt];
      this.nChars = paramInt;
      this.nextChar = 0;
      return;
    }
    throw new IllegalArgumentException("Buffer size <= 0");
  }
  
  private void ensureOpen()
  {
    if (this.out != null) {
      return;
    }
    throw new IOException("Stream closed");
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
      try
      {
        flushBuffer();
        this.out.close();
        this.out = null;
        this.cb = null;
        return;
      }
      finally
      {
        localObject2 = finally;
        this.out.close();
        this.out = null;
        this.cb = null;
        throw localObject2;
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
      int i = paramInt2 + paramInt1;
      if (paramInt1 < i)
      {
        int j = min(this.nChars - this.nextChar, i - paramInt1);
        paramInt2 = paramInt1 + j;
        paramString.getChars(paramInt1, paramInt2, this.cb, this.nextChar);
        this.nextChar += j;
        if (this.nextChar >= this.nChars) {
          flushBuffer();
        }
      }
      else
      {
        return;
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
      if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfChar.length) && (paramInt2 >= 0))
      {
        int j = paramInt1 + paramInt2;
        if ((j <= paramArrayOfChar.length) && (j >= 0))
        {
          if (paramInt2 == 0) {
            return;
          }
          int i = paramInt1;
          if (paramInt2 >= this.nChars)
          {
            flushBuffer();
            this.out.write(paramArrayOfChar, paramInt1, paramInt2);
            return;
          }
          while (i < j)
          {
            paramInt2 = min(this.nChars - this.nextChar, j - i);
            System.arraycopy(paramArrayOfChar, i, this.cb, this.nextChar, paramInt2);
            paramInt1 = i + paramInt2;
            this.nextChar += paramInt2;
            i = paramInt1;
            if (this.nextChar >= this.nChars)
            {
              flushBuffer();
              i = paramInt1;
            }
          }
          return;
        }
      }
      throw new IndexOutOfBoundsException();
    }
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.QBufferedWriter
 * JD-Core Version:    0.7.0.1
 */