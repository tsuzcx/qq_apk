package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class NullReader
  extends Reader
{
  private boolean eof;
  private long mark = -1L;
  private final boolean markSupported;
  private long position;
  private long readlimit;
  private final long size;
  private final boolean throwEofException;
  
  public NullReader(long paramLong)
  {
    this(paramLong, true, false);
  }
  
  public NullReader(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.size = paramLong;
    this.markSupported = paramBoolean1;
    this.throwEofException = paramBoolean2;
  }
  
  private int doEndOfFile()
  {
    this.eof = true;
    if (!this.throwEofException) {
      return -1;
    }
    throw new EOFException();
  }
  
  public void close()
  {
    this.eof = false;
    this.position = 0L;
    this.mark = -1L;
  }
  
  public long getPosition()
  {
    return this.position;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      if (this.markSupported)
      {
        this.mark = this.position;
        this.readlimit = paramInt;
        return;
      }
      throw new UnsupportedOperationException("Mark not supported");
    }
    finally {}
  }
  
  public boolean markSupported()
  {
    return this.markSupported;
  }
  
  protected int processChar()
  {
    return 0;
  }
  
  protected void processChars(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public int read()
  {
    if (!this.eof)
    {
      long l = this.position;
      if (l == this.size) {
        return doEndOfFile();
      }
      this.position = (l + 1L);
      return processChar();
    }
    throw new IOException("Read after end of file");
  }
  
  public int read(char[] paramArrayOfChar)
  {
    return read(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.eof)
    {
      long l2 = this.position;
      long l1 = this.size;
      if (l2 == l1) {
        return doEndOfFile();
      }
      this.position = (l2 + paramInt2);
      l2 = this.position;
      int i = paramInt2;
      if (l2 > l1)
      {
        i = paramInt2 - (int)(l2 - l1);
        this.position = l1;
      }
      processChars(paramArrayOfChar, paramInt1, i);
      return i;
    }
    throw new IOException("Read after end of file");
  }
  
  public void reset()
  {
    try
    {
      if (this.markSupported)
      {
        if (this.mark >= 0L)
        {
          if (this.position <= this.mark + this.readlimit)
          {
            this.position = this.mark;
            this.eof = false;
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Marked position [");
          localStringBuilder.append(this.mark);
          localStringBuilder.append("] is no longer valid - passed the read limit [");
          localStringBuilder.append(this.readlimit);
          localStringBuilder.append("]");
          throw new IOException(localStringBuilder.toString());
        }
        throw new IOException("No position has been marked");
      }
      throw new UnsupportedOperationException("Mark not supported");
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    if (!this.eof)
    {
      long l1 = this.position;
      long l2 = this.size;
      if (l1 == l2) {
        return doEndOfFile();
      }
      this.position = (l1 + paramLong);
      long l3 = this.position;
      l1 = paramLong;
      if (l3 > l2)
      {
        l1 = paramLong - (l3 - l2);
        this.position = l2;
      }
      return l1;
    }
    throw new IOException("Skip after end of file");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.NullReader
 * JD-Core Version:    0.7.0.1
 */