package com.tencent.mobileqq.transfile;

public class FileMsg$StepBaseInfo
{
  public long detailErrCode = 9223372036854775807L;
  public int errCode = 9001;
  public String errDesc = "";
  public int failTryCount = 0;
  public long finishTime = 0L;
  public boolean isReported = false;
  public boolean result = true;
  public int retryCount = 1;
  public long startTime = 0L;
  public int successTryCount = 0;
  
  public String getStepReportInfo(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    if (this.result) {
      if (this.startTime > 0L)
      {
        localStringBuilder.append("1");
        localStringBuilder.append("_");
      }
    }
    for (;;)
    {
      if ((!(this instanceof FileMsg.StepTransInfo)) && (!this.result) && (this.successTryCount > 0))
      {
        this.failTryCount += this.successTryCount;
        this.successTryCount = 0;
      }
      localStringBuilder.append(this.successTryCount).append("_");
      localStringBuilder.append(this.failTryCount).append("_");
      localStringBuilder.append(this.finishTime - this.startTime);
      return localStringBuilder.toString();
      localStringBuilder.append("-1");
      break;
      localStringBuilder.append("0").append("_");
    }
  }
  
  public long getTimeElapsed()
  {
    long l = 0L;
    if ((this.startTime != 0L) && (this.finishTime != 0L)) {
      l = this.finishTime - this.startTime;
    }
    while ((this.startTime == 0L) && (this.finishTime == 0L)) {
      return l;
    }
    return 612345L;
  }
  
  public void reset()
  {
    this.result = true;
    this.startTime = 0L;
    this.finishTime = 0L;
    this.errCode = 9001;
    this.errDesc = "";
    this.isReported = false;
    this.retryCount = 1;
    this.successTryCount = 0;
    this.failTryCount = 0;
    this.detailErrCode = 9223372036854775807L;
  }
  
  public boolean shouldReport()
  {
    return (this.startTime != 0L) || (this.finishTime != 0L);
  }
  
  public String toJson()
  {
    if (shouldReport())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("result:" + this.result);
      localStringBuilder.append(",elapsed:" + getTimeElapsed());
      localStringBuilder.append(",errCode:" + this.errCode);
      localStringBuilder.append(",retryCount:" + this.retryCount);
      if (this.detailErrCode != 9223372036854775807L) {
        localStringBuilder.append(",detailError:" + this.detailErrCode);
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String toReportJson()
  {
    if (shouldReport())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + getTimeElapsed());
      localStringBuilder.append(",tryCount:" + this.retryCount);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String toString()
  {
    return "result:" + this.result + " startTime:" + this.startTime + " finishTime:" + this.finishTime + " errCode:" + this.errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepBaseInfo
 * JD-Core Version:    0.7.0.1
 */