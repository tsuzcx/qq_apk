package com.tencent.ttpic.filament;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FilaBenchUtil
{
  private static final int COUNT = 1;
  public static boolean ENABLE_LOG = true;
  public static boolean ENABLE_PERFORMANCE_RECORD = false;
  private static final String PREFIX = "[time]";
  public static String SHOWPREVIEW_BENCH_TAG = "[filament]";
  private static final String TAG = "FilaBenchUtil";
  private static Map<String, Long> lastTimeMap;
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, CopyOnWriteArrayList<Long>> totalTimeMap = new HashMap();
  
  static
  {
    lastTimeMap = new HashMap();
  }
  
  public static long benchEnd(String paramString)
  {
    if ((ENABLE_LOG) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = startTimeMap;
      if (localObject1 == null) {
        return 0L;
      }
      Object localObject3 = (Long)((Map)localObject1).get(paramString);
      if (localObject3 == null) {
        return 0L;
      }
      if ((ENABLE_PERFORMANCE_RECORD) && (paramString.startsWith(SHOWPREVIEW_BENCH_TAG))) {
        GLES20.glFinish();
      }
      Object localObject2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        totalTimeMap.put(paramString, localObject1);
      }
      long l1 = System.currentTimeMillis() - ((Long)localObject3).longValue();
      ((CopyOnWriteArrayList)localObject1).add(Long.valueOf(l1));
      int i = ((CopyOnWriteArrayList)localObject1).size();
      if (i >= 1)
      {
        long l2 = getTotalTime((CopyOnWriteArrayList)localObject1) / i;
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[time]");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append(" ms");
        LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
        lastTimeMap.put(paramString, Long.valueOf(l2));
        ((CopyOnWriteArrayList)localObject1).clear();
      }
      return l1;
    }
    return 0L;
  }
  
  public static void benchStart(String paramString)
  {
    if (!ENABLE_LOG) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((ENABLE_PERFORMANCE_RECORD) && (paramString.startsWith(SHOWPREVIEW_BENCH_TAG))) {
      GLES20.glFinish();
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static long elapsed(String paramString)
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[time]");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(": ");
      localStringBuilder.append(getTotalTime((CopyOnWriteArrayList)localEntry.getValue()));
      localStringBuilder.append("ms");
      LogUtils.d(str, localStringBuilder.toString());
    }
    totalTimeMap.clear();
  }
  
  private static long getTotalTime(CopyOnWriteArrayList<Long> paramCopyOnWriteArrayList)
  {
    try
    {
      boolean bool = ENABLE_LOG;
      long l1 = 0L;
      if (!bool) {
        return 0L;
      }
      bool = CollectionUtils.isEmpty(paramCopyOnWriteArrayList);
      if (bool) {
        return 0L;
      }
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
      while (paramCopyOnWriteArrayList.hasNext())
      {
        long l2 = ((Long)paramCopyOnWriteArrayList.next()).longValue();
        l1 += l2;
      }
      return l1;
    }
    finally {}
    for (;;)
    {
      throw paramCopyOnWriteArrayList;
    }
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
    lastTimeMap.clear();
  }
  
  public static void reset()
  {
    startTimeMap.clear();
  }
  
  public static void setEnableLog(boolean paramBoolean)
  {
    ENABLE_LOG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilaBenchUtil
 * JD-Core Version:    0.7.0.1
 */