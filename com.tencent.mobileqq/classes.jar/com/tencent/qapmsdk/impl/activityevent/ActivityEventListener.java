package com.tencent.qapmsdk.impl.activityevent;

import com.tencent.qapmsdk.impl.instrumentation.MetricEventListener;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;

public class ActivityEventListener
  implements MetricEventListener
{
  public void asyncEnterMethod(QAPMTraceUnit paramQAPMTraceUnit) {}
  
  public void enterMethod(QAPMTraceUnit paramQAPMTraceUnit) {}
  
  public void exitMethod() {}
  
  public void exitMethodCustom(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.activityevent.ActivityEventListener
 * JD-Core Version:    0.7.0.1
 */