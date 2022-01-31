package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CATEGORY;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CONTEXT;
import com.tencent.qapmsdk.impl.util.TraceUtil;

public class CommonActivityTrace
{
  protected MethodEventListener eventListener = new MethodEventListener();
  
  protected boolean canMonitor()
  {
    return (TraceUtil.canInstrumentMonitor) && (AppStateTimeInfo.hasStartEnd) && (!QAPMAppInstrumentation.isAppInBackground);
  }
  
  public void onCreateOrOnRestartEnterMethod(String paramString1, String paramString2)
  {
    if (canMonitor())
    {
      this.eventListener.registerEvent(paramString1, 500L, TraceType.CONTEXT.ACTIVITY);
      this.eventListener.enterMethod(new QAPMTraceUnit(paramString1 + paramString2, TraceType.CATEGORY.OTHER.getValue()));
    }
  }
  
  public void onCreateOrOnRestartExitMethod()
  {
    if (canMonitor()) {
      this.eventListener.exitMethod();
    }
  }
  
  public void onResumeEnterMethod(String paramString)
  {
    if (canMonitor()) {
      this.eventListener.enterMethod(new QAPMTraceUnit(paramString + "#onResume", TraceType.CATEGORY.OTHER.getValue()));
    }
  }
  
  public SectionHarve onResumeExitMethod()
  {
    if (!canMonitor()) {
      return null;
    }
    this.eventListener.exitMethod();
    return this.eventListener.finishMonitor();
  }
  
  public void onStartEnterMethod(String paramString)
  {
    if (canMonitor()) {
      this.eventListener.enterMethod(new QAPMTraceUnit(paramString + "#onStart", TraceType.CATEGORY.OTHER.getValue()));
    }
  }
  
  public void onStartExitMethod()
  {
    if (canMonitor()) {
      this.eventListener.exitMethod();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.CommonActivityTrace
 * JD-Core Version:    0.7.0.1
 */