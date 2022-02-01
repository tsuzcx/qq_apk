package com.tencent.mobileqq.transfile;

public class StepInfo
{
  public static final int STEP_MSG_URL_DOWN = 4;
  public static final int STEP_NOTIFY = 3;
  public static final int STEP_SIG = 0;
  public static final int STEP_TRANS = 2;
  public static final int STEP_URL = 1;
  public int failTryCount = 0;
  public long finishTime = 0L;
  public int result = -1;
  public long startTime = 0L;
  public int successTryCount = 0;
  
  public void fixAtPttPreSend(long paramLong)
  {
    if (paramLong >= this.finishTime)
    {
      this.startTime = 0L;
      return;
    }
    if (paramLong > this.startTime) {
      this.startTime = paramLong;
    }
  }
  
  public String getReportInfo(int paramInt)
  {
    int i = this.result;
    long l2 = 0L;
    long l1 = l2;
    if (i != -1)
    {
      long l3 = this.startTime;
      l1 = l2;
      if (l3 != 0L)
      {
        long l4 = this.finishTime;
        l1 = l2;
        if (l4 != 0L) {
          l1 = (l4 - l3) / 1000000L;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(this.result);
    localStringBuilder.append("_");
    localStringBuilder.append(this.successTryCount);
    localStringBuilder.append("_");
    localStringBuilder.append(this.failTryCount);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    return localStringBuilder.toString();
  }
  
  public long getTimeConsume()
  {
    long l1 = this.startTime;
    if (l1 != 0L)
    {
      l2 = this.finishTime;
      if (l2 != 0L)
      {
        l1 = (l2 - l1) / 1000000L;
        break label35;
      }
    }
    l1 = 0L;
    label35:
    long l2 = l1;
    if (l1 < 0L) {
      l2 = 0L;
    }
    return l2;
  }
  
  public void logFinishTime()
  {
    long l = System.nanoTime();
    if (l > this.finishTime) {
      this.finishTime = l;
    }
  }
  
  public void logStartTime()
  {
    if (this.startTime == 0L) {
      this.startTime = System.nanoTime();
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("startTime: ");
    localStringBuffer.append(this.startTime);
    localStringBuffer.append(" finishTime: ");
    localStringBuffer.append(this.finishTime);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StepInfo
 * JD-Core Version:    0.7.0.1
 */