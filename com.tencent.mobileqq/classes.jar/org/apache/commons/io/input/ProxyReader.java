package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public abstract class ProxyReader
  extends FilterReader
{
  public ProxyReader(Reader paramReader)
  {
    super(paramReader);
  }
  
  protected void afterRead(int paramInt) {}
  
  protected void beforeRead(int paramInt) {}
  
  public void close()
  {
    try
    {
      this.in.close();
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  protected void handleIOException(IOException paramIOException)
  {
    throw paramIOException;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        handleIOException(localIOException);
      }
    }
    finally {}
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
  {
    int i = 1;
    try
    {
      beforeRead(1);
      int j = this.in.read();
      if (j != -1) {}
      for (;;)
      {
        afterRead(i);
        return j;
        i = -1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public int read(CharBuffer paramCharBuffer)
  {
    if (paramCharBuffer != null) {}
    for (;;)
    {
      try
      {
        i = paramCharBuffer.length();
        beforeRead(i);
        i = this.in.read(paramCharBuffer);
        afterRead(i);
        return i;
      }
      catch (IOException paramCharBuffer)
      {
        int i;
        handleIOException(paramCharBuffer);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfChar.length;
        beforeRead(i);
        i = this.in.read(paramArrayOfChar);
        afterRead(i);
        return i;
      }
      catch (IOException paramArrayOfChar)
      {
        int i;
        handleIOException(paramArrayOfChar);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    try
    {
      beforeRead(paramInt2);
      paramInt1 = this.in.read(paramArrayOfChar, paramInt1, paramInt2);
      afterRead(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfChar)
    {
      handleIOException(paramArrayOfChar);
    }
    return -1;
  }
  
  public boolean ready()
  {
    try
    {
      boolean bool = this.in.ready();
      return bool;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return false;
  }
  
  public void reset()
  {
    try
    {
      this.in.reset();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        handleIOException(localIOException);
      }
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    try
    {
      paramLong = this.in.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.ProxyReader
 * JD-Core Version:    0.7.0.1
 */