package com.tencent.qqlive.module.videoreport.trace;

import android.support.v4.util.ArrayMap;
import java.util.Map;

public class Tracer
{
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.trace.Tracer
 * JD-Core Version:    0.7.0.1
 */