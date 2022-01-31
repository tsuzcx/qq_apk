package com.tencent.mobileqq.statistics;

import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FDStatsHooker
{
  private static final ConcurrentHashMap<Integer, String> mStackMap = new ConcurrentHashMap(1024);
  
  public static void closeForFD(int paramInt)
  {
    if (mStackMap.containsKey(Integer.valueOf(paramInt)))
    {
      mStackMap.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, new Object[] { "closeForFD ", Integer.valueOf(paramInt) });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FDStats", 2, new Object[] { "closeForFD not exist", Integer.valueOf(paramInt) });
  }
  
  public static void dumpStackForFD(String paramString, int paramInt)
  {
    Thread localThread = Thread.currentThread();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i] + "\n");
      i += 1;
    }
    localStringBuilder.append("thread:").append(localThread.getName()).append(" id:").append(localThread.getId()).append("\n");
    localStringBuilder.append("fd:").append(paramString).append(" id:").append(paramInt).append("\n");
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "fdPath: ", paramString, " fd:", Integer.valueOf(paramInt), " thread:", localThread.getName(), " threadId:", Long.valueOf(localThread.getId()) });
    }
    mStackMap.put(Integer.valueOf(paramInt), localStringBuilder.toString());
  }
  
  public static String getAllStackTrace()
  {
    localStringBuilder = new StringBuilder(2048);
    try
    {
      Iterator localIterator = mStackMap.values().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FDStats", 1, "getAllStackTrace ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsHooker
 * JD-Core Version:    0.7.0.1
 */