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
  
  public static long end(String paramString)
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return -1L;
    }
    Object localObject = (Long)getBeginMap().remove(paramString);
    if (localObject == null) {
      return -1L;
    }
    long l = System.currentTimeMillis() - ((Long)localObject).longValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" cost ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" ms.");
    Log.i("SimpleTracer", ((StringBuilder)localObject).toString());
    return l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.trace.SimpleTracer
 * JD-Core Version:    0.7.0.1
 */