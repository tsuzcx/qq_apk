package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.QAPMUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CONTEXT;
import com.tencent.qapmsdk.impl.report.MonitorReport;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SectionHarve
{
  protected final ConcurrentHashMap<UUID, QAPMUnit> c = new ConcurrentHashMap();
  public final Set<UUID> d = Collections.synchronizedSet(new HashSet());
  protected long entryTimestamp = System.currentTimeMillis();
  private long exitTimestamp;
  private long threshold = 0L;
  private boolean traceFinished = false;
  private TraceType.CONTEXT traceType;
  public QAPMTraceUnit unit;
  
  public SectionHarve(QAPMTraceUnit paramQAPMTraceUnit, long paramLong, TraceType.CONTEXT paramCONTEXT)
  {
    this.unit = paramQAPMTraceUnit;
    this.unit.entryTimestamp = System.currentTimeMillis();
    this.unit.nodeType = 0;
    this.traceType = paramCONTEXT;
    this.threshold = paramLong;
  }
  
  private JSONObject serializeEvent(long paramLong, QAPMUnit paramQAPMUnit, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    double d1;
    if (paramBoolean)
    {
      d1 = paramQAPMUnit.entryTimestamp / 1000.0D;
      localJSONObject.put("event_time", d1);
      localJSONObject.put("tag_id", paramLong);
      if (!paramBoolean) {
        break label148;
      }
      paramLong = 0L;
      label51:
      localJSONObject.put("during_time", paramLong);
      if (!paramBoolean) {
        break label161;
      }
    }
    label148:
    label161:
    for (int i = 0;; i = 1)
    {
      localJSONObject.put("type", i);
      localJSONObject.put("stage", paramQAPMUnit.metricName);
      localJSONObject.put("sub_stage", paramQAPMUnit.subMetricName);
      localJSONObject.put("extra_info", "");
      localJSONObject.put("process_name", "");
      localJSONObject.put("is_slow", 0);
      return localJSONObject;
      d1 = paramQAPMUnit.exitTimestamp / 1000.0D;
      break;
      paramLong = paramQAPMUnit.exitTimestamp - paramQAPMUnit.entryTimestamp;
      break label51;
    }
  }
  
  public SectionHarve exitTrace()
  {
    if (this.traceFinished) {
      return null;
    }
    this.traceFinished = true;
    this.unit.exitTimestamp = System.currentTimeMillis();
    this.exitTimestamp = this.unit.exitTimestamp;
    return this;
  }
  
  public void readyToReport(QAPMMonitorThreadLocal paramQAPMMonitorThreadLocal)
  {
    MonitorReport localMonitorReport = MonitorReport.getInstance();
    long l1 = this.unit.exitTimestamp - this.unit.entryTimestamp;
    if (l1 > 30000L)
    {
      paramQAPMMonitorThreadLocal.clear();
      return;
    }
    long l2 = this.unit.entryTimestamp;
    long l3 = this.unit.entryTimestamp;
    long l4 = this.unit.exitTimestamp;
    Object localObject1 = this.unit.metricName;
    Object localObject2 = this.unit.subMetricName;
    if (l1 > this.threshold) {}
    QAPMUnit localQAPMUnit;
    for (boolean bool = true;; bool = false)
    {
      localMonitorReport.addMonitorMetric(l2, l3, l4, (String)localObject1, (String)localObject2, bool);
      localObject2 = (Vector)paramQAPMMonitorThreadLocal.getFinishedMethodThreadLocal().get();
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localQAPMUnit = (QAPMUnit)((Iterator)localObject1).next();
        localMonitorReport.addMonitorMetric(this.unit.entryTimestamp, localQAPMUnit.entryTimestamp, localQAPMUnit.exitTimestamp, localQAPMUnit.metricName, localQAPMUnit.subMetricName, false);
      }
    }
    if (l1 > this.threshold) {
      try
      {
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(serializeEvent(this.unit.entryTimestamp, this.unit, true));
        ((JSONArray)localObject1).put(serializeEvent(this.unit.entryTimestamp, this.unit, false));
        if (localObject2 != null)
        {
          localObject2 = ((Vector)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localQAPMUnit = (QAPMUnit)((Iterator)localObject2).next();
            ((JSONArray)localObject1).put(serializeEvent(this.unit.entryTimestamp, localQAPMUnit, true));
            ((JSONArray)localObject1).put(serializeEvent(this.unit.entryTimestamp, localQAPMUnit, false));
            continue;
            localMonitorReport.doReport();
          }
        }
      }
      catch (JSONException localJSONException) {}
    }
    for (;;)
    {
      paramQAPMMonitorThreadLocal.clear();
      return;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("manu_tags", localJSONException);
      if (TraceUtil.LAUNCH_KATEGRORY.contains(this.unit.subMetricName)) {
        localMonitorReport.addMonitorSingle(l1, this.unit.entryTimestamp, this.unit.subMetricName, ((JSONObject)localObject2).toString());
      } else {
        localMonitorReport.addMonitorSingle(l1, this.unit.entryTimestamp, this.unit.metricName, ((JSONObject)localObject2).toString());
      }
    }
  }
  
  public void setEntryTimestamp(long paramLong)
  {
    this.unit.entryTimestamp = paramLong;
    this.entryTimestamp = paramLong;
  }
  
  public void setExitTimestamp(long paramLong)
  {
    this.unit.exitTimestamp = paramLong;
    this.exitTimestamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.SectionHarve
 * JD-Core Version:    0.7.0.1
 */