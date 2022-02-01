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
  
  /* Error */
  public void mark(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	org/apache/commons/io/input/ProxyReader:in	Ljava/io/Reader;
    //   6: iload_1
    //   7: invokevirtual 31	java/io/Reader:mark	(I)V
    //   10: goto +13 -> 23
    //   13: astore_2
    //   14: goto +12 -> 26
    //   17: astore_2
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual 28	org/apache/commons/io/input/ProxyReader:handleIOException	(Ljava/io/IOException;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ProxyReader
    //   0	30	1	paramInt	int
    //   13	1	2	localObject	java.lang.Object
    //   17	12	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
    //   18	23	13	finally
    //   2	10	17	java/io/IOException
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
  {
    for (int i = 1;; i = -1) {
      try
      {
        beforeRead(1);
        int j = this.in.read();
        if (j != -1)
        {
          afterRead(i);
          return j;
        }
      }
      catch (IOException localIOException)
      {
        handleIOException(localIOException);
        return -1;
      }
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
        continue;
      }
      handleIOException(paramCharBuffer);
      return -1;
      int i = 0;
    }
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
        continue;
      }
      handleIOException(paramArrayOfChar);
      return -1;
      int i = 0;
    }
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
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	org/apache/commons/io/input/ProxyReader:in	Ljava/io/Reader;
    //   6: invokevirtual 63	java/io/Reader:reset	()V
    //   9: goto +13 -> 22
    //   12: astore_1
    //   13: goto +12 -> 25
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 28	org/apache/commons/io/input/ProxyReader:handleIOException	(Ljava/io/IOException;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	ProxyReader
    //   12	1	1	localObject	java.lang.Object
    //   16	12	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   17	22	12	finally
    //   2	9	16	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ProxyReader
 * JD-Core Version:    0.7.0.1
 */