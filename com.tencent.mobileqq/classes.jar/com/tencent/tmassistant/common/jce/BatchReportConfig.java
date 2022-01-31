package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BatchReportConfig
  extends JceStruct
{
  public long batchReportInterval = 0L;
  public int batchReportMaxCount = 0;
  public int reportRetryCount = 0;
  
  public BatchReportConfig() {}
  
  public BatchReportConfig(int paramInt1, long paramLong, int paramInt2)
  {
    this.batchReportMaxCount = paramInt1;
    this.batchReportInterval = paramLong;
    this.reportRetryCount = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchReportMaxCount = paramJceInputStream.read(this.batchReportMaxCount, 0, true);
    this.batchReportInterval = paramJceInputStream.read(this.batchReportInterval, 1, true);
    this.reportRetryCount = paramJceInputStream.read(this.reportRetryCount, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchReportMaxCount, 0);
    paramJceOutputStream.write(this.batchReportInterval, 1);
    paramJceOutputStream.write(this.reportRetryCount, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.BatchReportConfig
 * JD-Core Version:    0.7.0.1
 */