package com.tencent.qqlive.module.videoreport.inner;

import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class LogReporter
  implements IReporter
{
  private static final String TAG = "LogReporter";
  
  public static LogReporter getInstance()
  {
    return LogReporter.InstanceHolder.INSTANCE;
  }
  
  public void report(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramObject = paramMap;
      if (paramMap == null) {
        paramObject = Collections.emptyMap();
      }
      paramObject = new TreeMap(paramObject);
      if ("pgin".equals(paramString)) {
        Log.d("LogReporter", "report: [" + paramString + "], " + new JSONObject(paramObject));
      }
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        paramMap = (Map.Entry)paramObject.next();
        Log.d("LogReporter", "    [" + paramString + "]  " + (String)paramMap.getKey() + ": " + paramMap.getValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.LogReporter
 * JD-Core Version:    0.7.0.1
 */