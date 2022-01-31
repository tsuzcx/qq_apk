package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class BatchReportConfig
  extends JceStruct
  implements Cloneable
{
  public long batchReportInterval = 0L;
  public int batchReportMaxCount = 0;
  public int reportRetryCount = 0;
  
  static
  {
    if (!BatchReportConfig.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public BatchReportConfig() {}
  
  public BatchReportConfig(int paramInt1, long paramLong, int paramInt2)
  {
    this.batchReportMaxCount = paramInt1;
    this.batchReportInterval = paramLong;
    this.reportRetryCount = paramInt2;
  }
  
  public String className()
  {
    return "jce.BatchReportConfig";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (a) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.batchReportMaxCount, "batchReportMaxCount");
    paramStringBuilder.display(this.batchReportInterval, "batchReportInterval");
    paramStringBuilder.display(this.reportRetryCount, "reportRetryCount");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.batchReportMaxCount, true);
    paramStringBuilder.displaySimple(this.batchReportInterval, true);
    paramStringBuilder.displaySimple(this.reportRetryCount, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (BatchReportConfig)paramObject;
    } while ((!JceUtil.equals(this.batchReportMaxCount, paramObject.batchReportMaxCount)) || (!JceUtil.equals(this.batchReportInterval, paramObject.batchReportInterval)) || (!JceUtil.equals(this.reportRetryCount, paramObject.reportRetryCount)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.BatchReportConfig";
  }
  
  public long getBatchReportInterval()
  {
    return this.batchReportInterval;
  }
  
  public int getBatchReportMaxCount()
  {
    return this.batchReportMaxCount;
  }
  
  public int getReportRetryCount()
  {
    return this.reportRetryCount;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchReportMaxCount = paramJceInputStream.read(this.batchReportMaxCount, 0, true);
    this.batchReportInterval = paramJceInputStream.read(this.batchReportInterval, 1, true);
    this.reportRetryCount = paramJceInputStream.read(this.reportRetryCount, 2, true);
  }
  
  public void setBatchReportInterval(long paramLong)
  {
    this.batchReportInterval = paramLong;
  }
  
  public void setBatchReportMaxCount(int paramInt)
  {
    this.batchReportMaxCount = paramInt;
  }
  
  public void setReportRetryCount(int paramInt)
  {
    this.reportRetryCount = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchReportMaxCount, 0);
    paramJceOutputStream.write(this.batchReportInterval, 1);
    paramJceOutputStream.write(this.reportRetryCount, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.BatchReportConfig
 * JD-Core Version:    0.7.0.1
 */