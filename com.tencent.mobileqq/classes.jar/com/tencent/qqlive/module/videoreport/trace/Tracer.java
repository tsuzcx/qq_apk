package com.tencent.qqlive.module.videoreport.trace;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Tracer
{
  private static final String TAG = "VRTracer";
  private static Map<String, Tracer.TraceData> sDataMap = new ArrayMap();
  
  public static void begin(String paramString)
  {
    long l = System.nanoTime();
    fetchData(paramString).lastBeginNano = l;
  }
  
  public static void clear()
  {
    sDataMap.clear();
  }
  
  public static long end(String paramString)
  {
    long l = System.nanoTime();
    paramString = fetchData(paramString);
    if (paramString.lastBeginNano == -1L) {
      return -1L;
    }
    paramString.count += 1;
    l -= paramString.lastBeginNano;
    paramString.totalNano += l;
    paramString.lastBeginNano = -1L;
    return l;
  }
  
  private static Tracer.TraceData fetchData(String paramString)
  {
    Tracer.TraceData localTraceData2 = (Tracer.TraceData)sDataMap.get(paramString);
    Tracer.TraceData localTraceData1 = localTraceData2;
    if (localTraceData2 == null)
    {
      localTraceData1 = new Tracer.TraceData(null);
      sDataMap.put(paramString, localTraceData1);
    }
    return localTraceData1;
  }
  
  public static void trace()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.d("VRTracer", "begin trace output:");
      Iterator localIterator = sDataMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Tracer.TraceData localTraceData = (Tracer.TraceData)localEntry.getValue();
        if (localTraceData.count != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("    ");
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append(": average = ");
          localStringBuilder.append(localTraceData.totalNano / localTraceData.count / 1000L);
          localStringBuilder.append(" us, total = ");
          localStringBuilder.append(localTraceData.totalNano / 1000L);
          localStringBuilder.append(" us, count = ");
          localStringBuilder.append(localTraceData.count);
          Log.d("VRTracer", localStringBuilder.toString());
        }
        else
        {
          Log.d("VRTracer", "    no data found");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.trace.Tracer
 * JD-Core Version:    0.7.0.1
 */