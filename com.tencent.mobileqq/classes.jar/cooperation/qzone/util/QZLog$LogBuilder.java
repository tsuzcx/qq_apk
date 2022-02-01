package cooperation.qzone.util;

class QZLog$LogBuilder
{
  private static final int MAX_POOL_SIZE = 50;
  private static LogBuilder sPool;
  private static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private LogBuilder next;
  private StringBuilder stringBuilder = new StringBuilder(128);
  
  private void clearForRecycle()
  {
    StringBuilder localStringBuilder = this.stringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  public static LogBuilder obtain()
  {
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        LogBuilder localLogBuilder = sPool;
        sPool = localLogBuilder.next;
        localLogBuilder.next = null;
        sPoolSize -= 1;
        return localLogBuilder;
      }
      return new LogBuilder();
    }
  }
  
  public LogBuilder append(char paramChar)
  {
    this.stringBuilder.append(paramChar);
    return this;
  }
  
  public LogBuilder append(double paramDouble)
  {
    this.stringBuilder.append(paramDouble);
    return this;
  }
  
  public LogBuilder append(float paramFloat)
  {
    this.stringBuilder.append(paramFloat);
    return this;
  }
  
  public LogBuilder append(int paramInt)
  {
    this.stringBuilder.append(paramInt);
    return this;
  }
  
  public LogBuilder append(long paramLong)
  {
    this.stringBuilder.append(paramLong);
    return this;
  }
  
  public LogBuilder append(CharSequence paramCharSequence)
  {
    this.stringBuilder.append(paramCharSequence);
    return this;
  }
  
  public LogBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.stringBuilder.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public LogBuilder append(Object paramObject)
  {
    this.stringBuilder.append(paramObject);
    return this;
  }
  
  public LogBuilder append(String paramString)
  {
    this.stringBuilder.append(paramString);
    return this;
  }
  
  public LogBuilder append(StringBuffer paramStringBuffer)
  {
    this.stringBuilder.append(paramStringBuffer);
    return this;
  }
  
  public LogBuilder append(boolean paramBoolean)
  {
    this.stringBuilder.append(paramBoolean);
    return this;
  }
  
  public LogBuilder append(char[] paramArrayOfChar)
  {
    this.stringBuilder.append(paramArrayOfChar);
    return this;
  }
  
  public LogBuilder append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.stringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    return this;
  }
  
  public void recycle()
  {
    clearForRecycle();
    synchronized (sPoolSync)
    {
      if (sPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        sPoolSize += 1;
      }
      return;
    }
  }
  
  public String toString()
  {
    return this.stringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.QZLog.LogBuilder
 * JD-Core Version:    0.7.0.1
 */