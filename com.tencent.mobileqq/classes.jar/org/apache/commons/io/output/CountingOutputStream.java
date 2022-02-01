package org.apache.commons.io.output;

import java.io.OutputStream;

public class CountingOutputStream
  extends ProxyOutputStream
{
  private long count = 0L;
  
  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  protected void beforeWrite(int paramInt)
  {
    try
    {
      this.count += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getByteCount()
  {
    try
    {
      long l = this.count;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCount()
  {
    long l = getByteCount();
    if (l <= 2147483647L) {
      return (int)l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The byte count ");
    localStringBuilder.append(l);
    localStringBuilder.append(" is too large to be converted to an int");
    throw new ArithmeticException(localStringBuilder.toString());
  }
  
  public long resetByteCount()
  {
    try
    {
      long l = this.count;
      this.count = 0L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int resetCount()
  {
    long l = resetByteCount();
    if (l <= 2147483647L) {
      return (int)l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The byte count ");
    localStringBuilder.append(l);
    localStringBuilder.append(" is too large to be converted to an int");
    throw new ArithmeticException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.CountingOutputStream
 * JD-Core Version:    0.7.0.1
 */