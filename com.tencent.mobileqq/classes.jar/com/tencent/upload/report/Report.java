package com.tencent.upload.report;

import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.Map;

public class Report
{
  public static final int REPORT_TYPE_RESLUT = 0;
  public static final int REPORT_TYPE_START = 1;
  public long batchCtrlCostAvg;
  public int concurrent;
  public String content_type;
  public long ctrlEnd;
  public long ctrlStart;
  public long dataEnd;
  public long dataStart;
  public long endTime;
  public String entry;
  public String errMsg;
  public String filePath;
  public long fileSize;
  public int flowId;
  public int ipsrctype;
  public boolean isIPV6 = false;
  public int networkType;
  public int num;
  public String refer;
  public int reportType;
  public int retCode;
  public int retry;
  public String serverIp;
  public int source;
  public long startTime;
  public Map<String, String> transfer;
  public TaskTypeConfig uploadType;
  public String uppAppId;
  
  public Report() {}
  
  public Report(int paramInt1, String paramString1, int paramInt2, String paramString2, TaskTypeConfig paramTaskTypeConfig, String paramString3, long paramLong1, long paramLong2, long paramLong3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.retCode = paramInt1;
    this.errMsg = paramString1;
    this.flowId = paramInt2;
    this.filePath = paramString2;
    this.uploadType = paramTaskTypeConfig;
    this.uppAppId = paramString3;
    this.fileSize = paramLong1;
    this.startTime = paramLong2;
    this.endTime = paramLong3;
    this.serverIp = paramString4;
    this.ipsrctype = paramInt3;
    this.networkType = paramInt4;
    this.retry = paramInt5;
    this.source = paramInt6;
    this.reportType = paramInt7;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadReportObj [retCode=");
    localStringBuilder.append(this.retCode);
    localStringBuilder.append(",errMsg=");
    localStringBuilder.append(this.errMsg);
    localStringBuilder.append(",flowId=");
    localStringBuilder.append(this.flowId);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append(",uploadType=");
    localStringBuilder.append(this.uploadType);
    localStringBuilder.append(",uppAppId=");
    localStringBuilder.append(this.uppAppId);
    localStringBuilder.append(",fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(",startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(",endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(",serverIp=");
    localStringBuilder.append(this.serverIp);
    localStringBuilder.append(",ipsrctype=");
    localStringBuilder.append(this.ipsrctype);
    localStringBuilder.append(",networkType=");
    localStringBuilder.append(this.networkType);
    localStringBuilder.append(",retry=");
    localStringBuilder.append(this.retry);
    localStringBuilder.append(",source=");
    localStringBuilder.append(this.source);
    localStringBuilder.append(",reportType=");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.report.Report
 * JD-Core Version:    0.7.0.1
 */