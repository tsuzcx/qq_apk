package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Looper;

public class QAPMTraceUnit
  extends QAPMUnit
{
  public int callType;
  private long invokeTimeFromAppStart;
  public boolean isPageLoadEnd = false;
  public int nodeType;
  public int segmentType;
  
  public QAPMTraceUnit()
  {
    this.nodeType = 0;
    this.callType = 1;
    this.segmentType = 0;
  }
  
  public QAPMTraceUnit(String paramString, int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (int i = TraceType.THREAD_TYPE.MAIN.getValue();; i = TraceType.THREAD_TYPE.OTHER.getValue())
    {
      this.callType = i;
      this.metricName = paramString;
      this.segmentType = paramInt;
      this.entryTimestamp = System.currentTimeMillis();
      return;
    }
  }
  
  public QAPMTraceUnit(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (int i = TraceType.THREAD_TYPE.MAIN.getValue();; i = TraceType.THREAD_TYPE.OTHER.getValue())
    {
      this.callType = i;
      this.metricName = paramString1;
      this.subMetricName = paramString2;
      this.segmentType = paramInt;
      this.entryTimestamp = paramLong1;
      this.exitTimestamp = paramLong2;
      return;
    }
  }
  
  public void complete()
  {
    super.complete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit
 * JD-Core Version:    0.7.0.1
 */