package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.MetricEventListener;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CONTEXT;
import com.tencent.qapmsdk.impl.util.TraceUtil;

public class MethodEventListener
  implements MetricEventListener
{
  public MonitorAdapter monitorAdapter;
  
  public void asyncEnterMethod(QAPMTraceUnit paramQAPMTraceUnit)
  {
    if (this.monitorAdapter != null) {}
  }
  
  public void enterMethod(QAPMTraceUnit paramQAPMTraceUnit)
  {
    if ((TraceUtil.canInstrumentMonitor) && (this.monitorAdapter != null)) {
      this.monitorAdapter.addMonitorUnit(paramQAPMTraceUnit);
    }
  }
  
  public void exitMethod()
  {
    if ((TraceUtil.canInstrumentMonitor) && (this.monitorAdapter != null)) {
      this.monitorAdapter.deleteMonitorUnit(true);
    }
  }
  
  public void exitMethodCustom(String paramString)
  {
    if ((TraceUtil.canInstrumentMonitor) && (this.monitorAdapter != null)) {}
  }
  
  public SectionHarve finishMonitor()
  {
    if (this.monitorAdapter == null) {
      return null;
    }
    return this.monitorAdapter.finishMonitor();
  }
  
  public QAPMMonitorThreadLocal getQapmMonitorThreadLocal()
  {
    return this.monitorAdapter.getQapmMonitorThreadLocal();
  }
  
  public MonitorAdapter registerEvent(String paramString, long paramLong, TraceType.CONTEXT paramCONTEXT)
  {
    this.monitorAdapter = MonitorAdapter.newOne(paramString, paramLong, paramCONTEXT);
    return this.monitorAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.MethodEventListener
 * JD-Core Version:    0.7.0.1
 */