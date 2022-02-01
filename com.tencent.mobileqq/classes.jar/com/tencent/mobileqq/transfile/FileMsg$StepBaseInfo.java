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
    if (this.result)
    {
      if (this.startTime > 0L) {
        localStringBuilder.append("1");
      } else {
        localStringBuilder.append("-1");
      }
      localStringBuilder.append("_");
    }
    else
    {
      localStringBuilder.append("0");
      localStringBuilder.append("_");
    }
    if ((!(this instanceof FileMsg.StepTransInfo)) && (!this.result))
    {
      paramInt = this.successTryCount;
      if (paramInt > 0)
      {
        this.failTryCount += paramInt;
        this.successTryCount = 0;
      }
    }
    localStringBuilder.append(this.successTryCount);
    localStringBuilder.append("_");
    localStringBuilder.append(this.failTryCount);
    localStringBuilder.append("_");
    localStringBuilder.append(this.finishTime - this.startTime);
    return localStringBuilder.toString();
  }
  
  public long getTimeElapsed()
  {
    long l2 = this.startTime;
    long l1 = 0L;
    if (l2 != 0L)
    {
      long l3 = this.finishTime;
      if (l3 != 0L) {
        return l3 - l2;
      }
    }
    if ((this.startTime != 0L) || (this.finishTime != 0L)) {
      l1 = 612345L;
    }
    return l1;
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
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("result:");
      localStringBuilder2.append(this.result);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",elapsed:");
      localStringBuilder2.append(getTimeElapsed());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",errCode:");
      localStringBuilder2.append(this.errCode);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",retryCount:");
      localStringBuilder2.append(this.retryCount);
      localStringBuilder1.append(localStringBuilder2.toString());
      if (this.detailErrCode != 9223372036854775807L)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(",detailError:");
        localStringBuilder2.append(this.detailErrCode);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
    return "{}";
  }
  
  public String toReportJson()
  {
    if (shouldReport())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("elapsed:");
      localStringBuilder2.append(getTimeElapsed());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",tryCount:");
      localStringBuilder2.append(this.retryCount);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
    return "{}";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.result);
    localStringBuilder.append(" startTime:");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(" finishTime:");
    localStringBuilder.append(this.finishTime);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.errCode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepBaseInfo
 * JD-Core Version:    0.7.0.1
 */