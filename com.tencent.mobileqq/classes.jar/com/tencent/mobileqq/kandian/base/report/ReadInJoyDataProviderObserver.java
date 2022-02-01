package com.tencent.mobileqq.kandian.base.report;

public class ReadInJoyDataProviderObserver
{
  private static ReadInJoyDataProviderObserver observer = new ReadInJoyDataProviderObserver();
  private ReadInJoyDataProviderObserver.FluencyObserver mFluencyObserver;
  ReadInJoyDataProviderObserver.Reporter report;
  
  public static ReadInJoyDataProviderObserver getInstance()
  {
    return observer;
  }
  
  public void caculateFeedsFlunency(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    ReadInJoyDataProviderObserver.FluencyObserver localFluencyObserver = this.mFluencyObserver;
    if (localFluencyObserver == null) {
      return;
    }
    localFluencyObserver.caculateFeedsFlunency(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void doReport(String paramString1, String paramString2)
  {
    ReadInJoyDataProviderObserver.Reporter localReporter = this.report;
    if ((localReporter != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localReporter.report(paramString2);
    }
  }
  
  public void removeFluencyObserver()
  {
    this.mFluencyObserver = null;
  }
  
  public void setFluencyObserver(ReadInJoyDataProviderObserver.FluencyObserver paramFluencyObserver)
  {
    this.mFluencyObserver = paramFluencyObserver;
  }
  
  public void setReport(ReadInJoyDataProviderObserver.Reporter paramReporter)
  {
    this.report = paramReporter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver
 * JD-Core Version:    0.7.0.1
 */