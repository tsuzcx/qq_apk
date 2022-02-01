package com.tencent.qqlive.module.videoreport.trace;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Map;

public class SimpleTracer
{
  private static volatile Map<String, Long> BEGIN_MAP;
  private static final String TAG = "SimpleTracer";
  
  public static void begin(String paramString)
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return;
    }
    getBeginMap().put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void end(String paramString)
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {}
    Long localLong;
    do
    {
      return;
      localLong = (Long)getBeginMap().remove(paramString);
    } while (localLong == null);
    long l1 = System.currentTimeMillis();
    long l2 = localLong.longValue();
    Log.i("SimpleTracer", paramString + " cost " + (l1 - l2) + " ms.");
  }
  
  private static Map<String, Long> getBeginMap()
  {
    if (BEGIN_MAP != null) {
      return BEGIN_MAP;
    }
    try
    {
      if (BEGIN_MAP == null) {
        BEGIN_MAP = new ArrayMap();
      }
      return BEGIN_MAP;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.trace.SimpleTracer
 * JD-Core Version:    0.7.0.1
 */