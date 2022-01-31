package com.tencent.ttpic.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BenchUtil
{
  private static final int COUNT = 5;
  private static final boolean ENABLE_LOG = false;
  private static final String PREFIX = "[time]";
  private static final String TAG = BenchUtil.class.getSimpleName();
  private static Map<String, Long> lastTimeMap = new HashMap();
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, List<Long>> totalTimeMap = new HashMap();
  
  public static long benchEnd(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap == null) || (startTimeMap.get(paramString) == null)) {
      l1 = 0L;
    }
    Object localObject;
    long l2;
    do
    {
      return l1;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      l2 = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      ((List)localObject).add(Long.valueOf(l2));
      l1 = l2;
    } while (((List)localObject).size() < 5);
    long l1 = getTotalTime((List)localObject) / ((List)localObject).size();
    Log.d(TAG, "[time]" + paramString + ": " + l1 + "ms");
    lastTimeMap.put(paramString, Long.valueOf(l1));
    ((List)localObject).clear();
    return l2;
  }
  
  public static void benchEnd(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {}
    Object localObject;
    do
    {
      return;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
    } while (((List)localObject).size() < 5);
    ((List)localObject).clear();
  }
  
  public static void benchEndReverse(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {}
    Object localObject;
    do
    {
      return;
      List localList = (List)totalTimeMap.get(paramString);
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        totalTimeMap.put(paramString, localObject);
      }
      ((List)localObject).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
    } while (((List)localObject).size() < 5);
    Log.d(TAG, "[time]" + paramString + ": " + ((List)localObject).size() * paramInt / getTotalTime((List)localObject) + "fps");
    ((List)localObject).clear();
  }
  
  public static long benchEndTotal(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (startTimeMap.get(paramString) == null)) {
      return 0L;
    }
    List localList = (List)totalTimeMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      totalTimeMap.put(paramString, localObject);
    }
    long l = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
    ((List)localObject).add(Long.valueOf(l));
    return l;
  }
  
  public static void benchStart(String paramString) {}
  
  public static void calcFps()
  {
    benchEnd("bench_fps");
    benchStart("bench_fps");
  }
  
  private static long elapsed(String paramString)
  {
    if (!lastTimeMap.containsKey(paramString)) {
      return 0L;
    }
    return ((Long)lastTimeMap.get(paramString)).longValue();
  }
  
  public static void flush()
  {
    Iterator localIterator = totalTimeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.d(TAG, "[time]" + (String)localEntry.getKey() + ": " + getTotalTime((List)localEntry.getValue()) + "ms");
    }
    totalTimeMap.clear();
  }
  
  public static String getLastBenchAverage()
  {
    return null;
  }
  
  private static long getTotalTime(List<Long> paramList)
  {
    long l2;
    if (VideoUtil.isEmpty(paramList))
    {
      l2 = 0L;
      return l2;
    }
    long l1 = 0L;
    paramList = paramList.iterator();
    for (;;)
    {
      l2 = l1;
      if (!paramList.hasNext()) {
        break;
      }
      l1 += ((Long)paramList.next()).longValue();
    }
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
    lastTimeMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.BenchUtil
 * JD-Core Version:    0.7.0.1
 */