package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FDStatsHooker
{
  static long lastLogTime;
  private static final ConcurrentHashMap<Integer, String> mStackMap = new ConcurrentHashMap(1024);
  private static ConcurrentHashMap<String, Integer> sErrorFDMap = new ConcurrentHashMap(100);
  
  public static void dumpStackForFD(String paramString, int paramInt)
  {
    Thread localThread = Thread.currentThread();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < arrayOfStackTraceElement.length)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i] + "\n");
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "fdPath: ", paramString, " fd:", Integer.valueOf(paramInt), " thread:", localThread.getName(), " threadId:", Long.valueOf(localThread.getId()) });
    }
    localStringBuilder.append("thread:").append(localThread.getName()).append(" id:").append(localThread.getId()).append("\n");
    localStringBuilder.append("fd:").append(paramString).append(" id:").append(paramInt).append("\n");
    mStackMap.put(Integer.valueOf(paramInt), localStringBuilder.toString());
  }
  
  public static String getAllStackTrace()
  {
    StringBuilder localStringBuilder = new StringBuilder(2048);
    try
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(1024);
      Object localObject = FDNative.a().a();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          localConcurrentHashMap.put(localInteger, mStackMap.get(localInteger));
          continue;
          return localStringBuilder.toString();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FDStats", 1, "getAllStackTrace ", localThrowable);
    }
    for (;;)
    {
      localThrowable.putAll(mStackMap);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, new Object[] { "curMap size:", Integer.valueOf(localThrowable.size()) });
      }
      Iterator localIterator = localThrowable.values().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("\n");
      }
    }
  }
  
  public static void handleFDError(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
    ThreadManagerV2.executeOnSubThread(new FDStatsHooker.1(paramStringBuilder, paramHashMap));
  }
  
  public static void notifyErrorForFD(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append("notifyErrorForFD fd:").append(paramInt1);
    localStringBuilder1.append(" errCode:").append(paramInt2);
    localStringBuilder1.append(" filePath:").append(paramString1);
    localStringBuilder1.append(" method:").append(paramString2);
    localStringBuilder1.append(" backTrace:\n").append(paramString3);
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder2 = new StringBuilder();
    paramInt1 = 1;
    while (paramInt1 < localObject.length)
    {
      localStringBuilder2.append(localObject[paramInt1] + "\n");
      paramInt1 += 1;
    }
    localStringBuilder1.append("javaStack:\n").append(localStringBuilder2);
    localObject = new HashMap();
    ((HashMap)localObject).put("errCode", "" + paramInt2);
    ((HashMap)localObject).put("filePath", paramString1);
    ((HashMap)localObject).put("method:", paramString2);
    ((HashMap)localObject).put("backTrace", paramString3);
    ((HashMap)localObject).put("javaStack", localStringBuilder2.toString());
    handleFDError(localStringBuilder1, (HashMap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsHooker
 * JD-Core Version:    0.7.0.1
 */