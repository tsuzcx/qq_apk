package com.tencent.qqmini.v8rt.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SpeedUtil
{
  public static final SpeedUtil DEFAULT = new SpeedUtil("default");
  public static final String TAG = "SpdUtl";
  private final Map<String, SpeedUtil.ReportPoint> mPoints = new LinkedHashMap();
  private final String name;
  
  public SpeedUtil(String paramString)
  {
    this.name = paramString;
  }
  
  public void clear()
  {
    try
    {
      this.mPoints.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void event(String paramString)
  {
    try
    {
      SpeedUtil.ReportPoint localReportPoint = (SpeedUtil.ReportPoint)this.mPoints.get(paramString);
      if (localReportPoint == null)
      {
        localReportPoint = new SpeedUtil.ReportPoint();
        this.mPoints.put(paramString, localReportPoint);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("operation ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" already exists");
        Logger.w("SpdUtl", localStringBuilder.toString());
      }
      localReportPoint.event = paramString;
      localReportPoint.startTs = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void report(String... paramVarArgs)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramVarArgs != null)
      {
        localObject1 = localObject2;
        if (paramVarArgs.length > 0) {
          localObject1 = Arrays.asList(paramVarArgs);
        }
      }
      paramVarArgs = this.mPoints.entrySet().iterator();
      while (paramVarArgs.hasNext())
      {
        localObject2 = (SpeedUtil.ReportPoint)((Map.Entry)paramVarArgs.next()).getValue();
        if (localObject1 != null)
        {
          if (((List)localObject1).contains(((SpeedUtil.ReportPoint)localObject2).event)) {
            localArrayList.add(localObject2);
          }
        }
        else {
          localArrayList.add(localObject2);
        }
      }
      Collections.sort(localArrayList);
      paramVarArgs = localArrayList.iterator();
      long l1 = -1L;
      long l4;
      for (long l2 = l1; paramVarArgs.hasNext(); l2 = l4)
      {
        localObject1 = (SpeedUtil.ReportPoint)paramVarArgs.next();
        long l3 = l1;
        if (l1 == -1L) {
          l3 = ((SpeedUtil.ReportPoint)localObject1).startTs;
        }
        l4 = l2;
        if (l2 == -1L) {
          l4 = ((SpeedUtil.ReportPoint)localObject1).startTs;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((SpeedUtil.ReportPoint)localObject1).event);
        ((StringBuilder)localObject2).append("->");
        ((StringBuilder)localObject2).append(((SpeedUtil.ReportPoint)localObject1).startTs);
        ((StringBuilder)localObject2).append(",diff=");
        ((StringBuilder)localObject2).append(((SpeedUtil.ReportPoint)localObject1).startTs - l3);
        Logger.d("SpdUtl", ((StringBuilder)localObject2).toString());
        l1 = ((SpeedUtil.ReportPoint)localObject1).startTs;
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.name);
      paramVarArgs.append(" total:");
      paramVarArgs.append(l1 - l2);
      Logger.d("SpdUtl", paramVarArgs.toString());
      return;
    }
    finally {}
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.SpeedUtil
 * JD-Core Version:    0.7.0.1
 */