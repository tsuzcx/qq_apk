package com.tencent.ttpic.filament;

import android.opengl.GLES20;
import android.text.TextUtils;
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
  private static final String TAG = FilaBenchUtil.class.getSimpleName();
  private static Map<String, Long> lastTimeMap;
  private static Map<String, Long> startTimeMap = new HashMap();
  private static Map<String, CopyOnWriteArrayList<Long>> totalTimeMap = new HashMap();
  
  static
  {
    lastTimeMap = new HashMap();
  }
  
  public static long benchEnd(String paramString)
  {
    if ((!ENABLE_LOG) || (TextUtils.isEmpty(paramString)) || (startTimeMap == null)) {
      return 0L;
    }
    Long localLong = (Long)startTimeMap.get(paramString);
    if (localLong == null) {
      return 0L;
    }
    if ((ENABLE_PERFORMANCE_RECORD) && (paramString.startsWith(SHOWPREVIEW_BENCH_TAG))) {
      GLES20.glFinish();
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)totalTimeMap.get(paramString);
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
    if (localCopyOnWriteArrayList2 == null)
    {
      localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
      totalTimeMap.put(paramString, localCopyOnWriteArrayList1);
    }
    long l1 = System.currentTimeMillis() - localLong.longValue();
    localCopyOnWriteArrayList1.add(Long.valueOf(l1));
    int i = localCopyOnWriteArrayList1.size();
    if (i >= 1)
    {
      long l2 = getTotalTime(localCopyOnWriteArrayList1) / i;
      LogUtils.d(TAG, "[time]" + paramString + ": " + l2 + " ms");
      lastTimeMap.put(paramString, Long.valueOf(l2));
      localCopyOnWriteArrayList1.clear();
    }
    return l1;
  }
  
  public static void benchStart(String paramString)
  {
    if (!ENABLE_LOG) {}
    while (TextUtils.isEmpty(paramString)) {
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
      LogUtils.d(TAG, "[time]" + (String)localEntry.getKey() + ": " + getTotalTime((CopyOnWriteArrayList)localEntry.getValue()) + "ms");
    }
    totalTimeMap.clear();
  }
  
  /* Error */
  private static long getTotalTime(CopyOnWriteArrayList<Long> paramCopyOnWriteArrayList)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 46	com/tencent/ttpic/filament/FilaBenchUtil:ENABLE_LOG	Z
    //   8: istore 5
    //   10: iload 5
    //   12: ifne +8 -> 20
    //   15: ldc 2
    //   17: monitorexit
    //   18: lload_1
    //   19: lreturn
    //   20: aload_0
    //   21: invokestatic 182	com/tencent/ttpic/baseutils/collection/CollectionUtils:isEmpty	(Ljava/util/Collection;)Z
    //   24: ifne -9 -> 15
    //   27: aload_0
    //   28: invokevirtual 183	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   31: astore_0
    //   32: lconst_0
    //   33: lstore_1
    //   34: aload_0
    //   35: invokeinterface 162 1 0
    //   40: ifeq +23 -> 63
    //   43: aload_0
    //   44: invokeinterface 166 1 0
    //   49: checkcast 70	java/lang/Long
    //   52: invokevirtual 97	java/lang/Long:longValue	()J
    //   55: lstore_3
    //   56: lload_1
    //   57: lload_3
    //   58: ladd
    //   59: lstore_1
    //   60: goto -26 -> 34
    //   63: goto -48 -> 15
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramCopyOnWriteArrayList	CopyOnWriteArrayList<Long>
    //   1	59	1	l1	long
    //   55	3	3	l2	long
    //   8	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	66	finally
    //   20	32	66	finally
    //   34	56	66	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilaBenchUtil
 * JD-Core Version:    0.7.0.1
 */