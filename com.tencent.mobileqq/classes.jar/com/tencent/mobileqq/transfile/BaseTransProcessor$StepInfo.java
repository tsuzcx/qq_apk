package com.tencent.mobileqq.transfile;

public class BaseTransProcessor$StepInfo
{
  public int failTryCount;
  public long finishTime;
  public int result = -1;
  public long startTime;
  public int successTryCount;
  
  public void fixAtPttPreSend(long paramLong)
  {
    if (paramLong >= this.finishTime) {
      this.startTime = 0L;
    }
    while (paramLong <= this.startTime) {
      return;
    }
    this.startTime = paramLong;
  }
  
  public String getReportInfo(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.result != -1)
    {
      l1 = l2;
      if (this.startTime != 0L)
      {
        l1 = l2;
        if (this.finishTime != 0L) {
          l1 = (this.finishTime - this.startTime) / 1000000L;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append("_").append(this.result).append("_").append(this.successTryCount).append("_").append(this.failTryCount).append("_").append(l1);
    return localStringBuilder.toString();
  }
  
  public long getTimeConsume()
  {
    if ((this.startTime != 0L) && (this.finishTime != 0L)) {}
    for (long l = (this.finishTime - this.startTime) / 1000000L;; l = 0L)
    {
      if (l < 0L) {
        return 0L;
      }
      return l;
    }
  }
  
  void logFinishTime()
  {
    long l = System.nanoTime();
    if (l > this.finishTime) {
      this.finishTime = l;
    }
  }
  
  void logStartTime()
  {
    if (this.startTime == 0L) {
      this.startTime = System.nanoTime();
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("startTime: ").append(this.startTime).append(" finishTime: ").append(this.finishTime);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo
 * JD-Core Version:    0.7.0.1
 */