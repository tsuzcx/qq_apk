package org.apache.commons.io.input;

import java.io.InputStream;

public class CountingInputStream
  extends ProxyInputStream
{
  private long count;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void afterRead(int paramInt)
  {
    if (paramInt != -1) {}
    try
    {
      this.count += paramInt;
    }
    finally {}
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
  
  public long skip(long paramLong)
  {
    try
    {
      paramLong = super.skip(paramLong);
      this.count += paramLong;
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.CountingInputStream
 * JD-Core Version:    0.7.0.1
 */