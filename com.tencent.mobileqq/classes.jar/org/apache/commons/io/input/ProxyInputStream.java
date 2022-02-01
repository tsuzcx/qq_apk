package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ProxyInputStream
  extends FilterInputStream
{
  public ProxyInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void afterRead(int paramInt) {}
  
  public int available()
  {
    try
    {
      int i = super.available();
      return i;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return 0;
  }
  
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
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
  
  public int read(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfByte.length;
        beforeRead(i);
        i = this.in.read(paramArrayOfByte);
        afterRead(i);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        continue;
      }
      handleIOException(paramArrayOfByte);
      return -1;
      int i = 0;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      beforeRead(paramInt2);
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      afterRead(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      handleIOException(paramArrayOfByte);
    }
    return -1;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	org/apache/commons/io/input/ProxyInputStream:in	Ljava/io/InputStream;
    //   6: invokevirtual 55	java/io/InputStream:reset	()V
    //   9: goto +13 -> 22
    //   12: astore_1
    //   13: goto +12 -> 25
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 21	org/apache/commons/io/input/ProxyInputStream:handleIOException	(Ljava/io/IOException;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	ProxyInputStream
    //   12	1	1	localObject	Object
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
 * Qualified Name:     org.apache.commons.io.input.ProxyInputStream
 * JD-Core Version:    0.7.0.1
 */