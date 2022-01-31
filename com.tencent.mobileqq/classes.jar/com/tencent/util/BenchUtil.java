package com.tencent.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.filter.BaseFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BenchUtil
{
  private static int COUNT = 10;
  private static final String PREFIX = "[time]";
  private static final String TAG = BenchUtil.class.getSimpleName();
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, List<Long>> totalTimeMap = new HashMap();
  
  public static void benchEnd(String paramString)
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
    } while (((List)localObject).size() < COUNT);
    Log.d(TAG, "[time]" + paramString + ": " + getTotalTime((List)localObject) / ((List)localObject).size() + "ms");
    ((List)localObject).clear();
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
    } while (((List)localObject).size() < COUNT);
    Log.d(TAG, "[time]" + paramString + ": " + getTotalTime((List)localObject) * paramInt / ((List)localObject).size() + "ms");
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
    } while (((List)localObject).size() < COUNT);
    Log.d(TAG, "[time]" + paramString + ": " + ((List)localObject).size() * paramInt / getTotalTime((List)localObject) + "fps");
    ((List)localObject).clear();
  }
  
  public static void benchStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static int getLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    return i;
  }
  
  private static long getTotalTime(List<Long> paramList)
  {
    long l2;
    if (paramList == null)
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
    COUNT = 10;
  }
  
  public static void setCount(int paramInt)
  {
    COUNT = Math.min(10, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.BenchUtil
 * JD-Core Version:    0.7.0.1
 */