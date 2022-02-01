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
      if ("pgin".equals(paramString))
      {
        paramMap = new StringBuilder();
        paramMap.append("report: [");
        paramMap.append(paramString);
        paramMap.append("], ");
        paramMap.append(new JSONObject(paramObject));
        Log.d("LogReporter", paramMap.toString());
      }
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        paramMap = (Map.Entry)paramObject.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    [");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]  ");
        localStringBuilder.append((String)paramMap.getKey());
        localStringBuilder.append(": ");
        localStringBuilder.append(paramMap.getValue());
        Log.d("LogReporter", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.LogReporter
 * JD-Core Version:    0.7.0.1
 */