package cooperation.qzone.report;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

class QzoneReportManager$DataBuilder
{
  private static final int MAX_POOL_SIZE = 10;
  private static DataBuilder sPool;
  private static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private DataBuilder next;
  private StringBuilder stringBuilder = new StringBuilder(128);
  
  private void clearForRecycle()
  {
    this.stringBuilder.delete(0, this.stringBuilder.length());
  }
  
  public static DataBuilder obtain()
  {
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DataBuilder localDataBuilder = sPool;
        sPool = localDataBuilder.next;
        localDataBuilder.next = null;
        sPoolSize -= 1;
        return localDataBuilder;
      }
      return new DataBuilder();
    }
  }
  
  public DataBuilder append(String paramString, char paramChar)
  {
    this.stringBuilder.append(paramChar);
    return this;
  }
  
  public DataBuilder append(String paramString, double paramDouble)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramDouble);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramDouble);
    return this;
  }
  
  public DataBuilder append(String paramString, float paramFloat)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramFloat);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramFloat);
    return this;
  }
  
  public DataBuilder append(String paramString, int paramInt)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramInt);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramInt);
    return this;
  }
  
  public DataBuilder append(String paramString, long paramLong)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramLong);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramLong);
    return this;
  }
  
  public DataBuilder append(String paramString, Object paramObject)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramObject);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramObject);
    return this;
  }
  
  public DataBuilder append(String paramString1, String paramString2)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString1).append("=").append(paramString2);
      return this;
    }
    this.stringBuilder.append("&").append(paramString1).append("=").append(paramString2);
    return this;
  }
  
  public DataBuilder append(String paramString, StringBuffer paramStringBuffer)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramStringBuffer);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramStringBuffer);
    return this;
  }
  
  public DataBuilder append(String paramString, Properties paramProperties)
  {
    if (this.stringBuilder.length() != 0) {
      this.stringBuilder.append("&");
    }
    this.stringBuilder.append(paramString).append("=").append("[");
    paramString = paramProperties.entrySet().iterator();
    while (paramString.hasNext())
    {
      Object localObject = (Map.Entry)paramString.next();
      paramProperties = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      this.stringBuilder.append(paramProperties).append("=").append(localObject);
    }
    this.stringBuilder.append("]");
    return this;
  }
  
  public DataBuilder append(String paramString, boolean paramBoolean)
  {
    if (this.stringBuilder.length() == 0)
    {
      this.stringBuilder.append(paramString).append("=").append(paramBoolean);
      return this;
    }
    this.stringBuilder.append("&").append(paramString).append("=").append(paramBoolean);
    return this;
  }
  
  public void recycle()
  {
    clearForRecycle();
    synchronized (sPoolSync)
    {
      if (sPoolSize < 10)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager.DataBuilder
 * JD-Core Version:    0.7.0.1
 */