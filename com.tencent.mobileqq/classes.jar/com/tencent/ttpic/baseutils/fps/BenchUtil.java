package com.tencent.ttpic.baseutils.fps;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BenchUtil
{
  private static final int COUNT = 10;
  public static boolean ENABLE_DEBUG = false;
  public static boolean ENABLE_LOG = false;
  public static boolean ENABLE_MEMINFO = false;
  public static boolean ENABLE_PERFORMANCE_RECORD = false;
  private static final String PREFIX = "[time]";
  public static String SHOWPREVIEW_BENCH_TAG;
  private static final String TAG = "BenchUtil";
  private static Map<String, Float> lastTimeMap;
  private static BenchUtil.LoggerAgent sLogger;
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, CopyOnWriteArrayList<Long>> totalTimeMap = new HashMap();
  
  static
  {
    lastTimeMap = new HashMap();
    sLogger = new BenchUtil.LoggerAgent();
    ENABLE_DEBUG = true;
    ENABLE_LOG = false;
    ENABLE_PERFORMANCE_RECORD = false;
    SHOWPREVIEW_BENCH_TAG = "[showPreview]";
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
      long l = System.currentTimeMillis() - ((Long)localObject3).longValue();
      ((CopyOnWriteArrayList)localObject1).add(Long.valueOf(l));
      int i = ((CopyOnWriteArrayList)localObject1).size();
      if (i >= 10)
      {
        float f = (float)getTotalTime((CopyOnWriteArrayList)localObject1) / i;
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[time]");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(f);
        ((StringBuilder)localObject3).append(" ms");
        Log.d((String)localObject2, ((StringBuilder)localObject3).toString());
        lastTimeMap.put(paramString, Float.valueOf(f));
        ((CopyOnWriteArrayList)localObject1).clear();
      }
      return l;
    }
    return 0L;
  }
  
  public static void benchEnd(String paramString, int paramInt)
  {
    if (!ENABLE_LOG) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (startTimeMap.get(paramString) == null) {
        return;
      }
      Object localObject2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        totalTimeMap.put(paramString, localObject1);
      }
      ((CopyOnWriteArrayList)localObject1).add(Long.valueOf(System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue()));
      if (((CopyOnWriteArrayList)localObject1).size() >= 10)
      {
        localObject2 = sLogger;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[time]");
        localStringBuilder.append(paramString);
        localStringBuilder.append(": ");
        localStringBuilder.append(getTotalTime((CopyOnWriteArrayList)localObject1) / (((CopyOnWriteArrayList)localObject1).size() / paramInt));
        localStringBuilder.append("ms");
        ((BenchUtil.LoggerAgent)localObject2).d(str, localStringBuilder.toString());
        ((CopyOnWriteArrayList)localObject1).clear();
      }
    }
  }
  
  public static long benchEndFPS(String paramString)
  {
    if ((ENABLE_DEBUG) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = startTimeMap;
      if (localObject1 == null) {
        return 0L;
      }
      Object localObject3 = (Long)((Map)localObject1).get(paramString);
      if (localObject3 == null) {
        return 0L;
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
      long l2 = getTotalTimeFPS((List)localObject1);
      int i = ((CopyOnWriteArrayList)localObject1).size();
      if (i >= 10)
      {
        float f = (float)(l2 / i);
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[time]");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(f);
        ((StringBuilder)localObject3).append("ms");
        LogUtils.d((String)localObject2, ((StringBuilder)localObject3).toString());
        lastTimeMap.put(paramString, Float.valueOf(f));
        ((CopyOnWriteArrayList)localObject1).clear();
      }
      return l1;
    }
    return 0L;
  }
  
  public static long benchEndTotal(String paramString)
  {
    boolean bool = ENABLE_LOG;
    long l = 0L;
    if (!bool) {
      return 0L;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (startTimeMap.get(paramString) == null) {
        return 0L;
      }
      CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
      CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
      if (localCopyOnWriteArrayList2 == null)
      {
        localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
        totalTimeMap.put(paramString, localCopyOnWriteArrayList1);
      }
      l = System.currentTimeMillis() - ((Long)startTimeMap.get(paramString)).longValue();
      localCopyOnWriteArrayList1.add(Long.valueOf(l));
    }
    return l;
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
  
  public static void benchStartFPS(String paramString)
  {
    if (!ENABLE_DEBUG) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void calcFps()
  {
    benchEndFPS("bench_fps");
    benchStartFPS("bench_fps");
  }
  
  public static float elapsed(String paramString)
  {
    if (!lastTimeMap.containsKey(paramString)) {
      return 0.0F;
    }
    return ((Float)lastTimeMap.get(paramString)).floatValue();
  }
  
  public static void flush()
  {
    Iterator localIterator = totalTimeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      BenchUtil.LoggerAgent localLoggerAgent = sLogger;
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[time]");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(": ");
      localStringBuilder.append(getTotalTime((CopyOnWriteArrayList)localEntry.getValue()));
      localStringBuilder.append("ms");
      localLoggerAgent.d(str, localStringBuilder.toString());
    }
    totalTimeMap.clear();
  }
  
  public static String getBenchFps()
  {
    float f = elapsed("bench_fps");
    if (f != 0.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(Math.round(1000.0F / f));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String getLastBenchAverage()
  {
    if (!ENABLE_LOG) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    float f = elapsed("bench_fps");
    if (f != 0.0F)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("fps : ");
      localStringBuilder2.append(Math.round(1000.0F / f));
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("frame elapsed : ");
    localStringBuilder2.append(f);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("yuv2rgba : ");
    localStringBuilder2.append(elapsed("mPreviewFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("beauty-filter : ");
    localStringBuilder2.append(elapsed("mBeautyFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("filter : ");
    localStringBuilder2.append(elapsed("mFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("arFilter : ");
    localStringBuilder2.append(elapsed("arFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("gpu2cpu : ");
    localStringBuilder2.append(elapsed("gpu2cpu"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("doTrack : ");
    localStringBuilder2.append(elapsed("doTrack"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("faceDetect : ");
    localStringBuilder2.append(elapsed("faceDetect"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("beautyTransform : ");
    localStringBuilder2.append(elapsed("mBeautyTransformList"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("sticker : ");
    localStringBuilder2.append(elapsed("updateAndRender"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("flip : ");
    localStringBuilder2.append(elapsed("mFlipFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("viewFilter : ");
    localStringBuilder2.append(elapsed("mViewFilter"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("onDrawFrame : ");
    localStringBuilder2.append(elapsed("onDrawFrame"));
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
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
  
  private static long getTotalTimeFPS(List<Long> paramList)
  {
    boolean bool = ENABLE_DEBUG;
    long l = 0L;
    if (!bool) {
      return 0L;
    }
    if (CollectionUtils.isEmpty(paramList)) {
      return 0L;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      l += ((Long)paramList.next()).longValue();
    }
    return l;
  }
  
  public static void init()
  {
    startTimeMap.clear();
    totalTimeMap.clear();
    lastTimeMap.clear();
  }
  
  public static void setEnableDebugLog(boolean paramBoolean1, boolean paramBoolean2)
  {
    ENABLE_DEBUG = paramBoolean1;
    ENABLE_LOG = paramBoolean2;
  }
  
  public static void setLoggerAgent(BenchUtil.LoggerAgent paramLoggerAgent)
  {
    sLogger = paramLoggerAgent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.fps.BenchUtil
 * JD-Core Version:    0.7.0.1
 */