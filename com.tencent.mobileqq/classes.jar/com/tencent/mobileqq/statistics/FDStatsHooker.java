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
  private static final String TAG = "FDStats";
  static long lastLogTime = 0L;
  private static final ConcurrentHashMap<Integer, String> mStackMap = new ConcurrentHashMap(1024);
  private static ConcurrentHashMap<String, Integer> sErrorFDMap = new ConcurrentHashMap(100);
  
  public static void dumpStackForFD(String paramString, int paramInt)
  {
    Thread localThread = Thread.currentThread();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 1;
    while (i < arrayOfStackTraceElement.length)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(arrayOfStackTraceElement[i]);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    if ((QLog.isColorLevel()) && (FDNative.a().b())) {
      QLog.d("FDStats", 2, new Object[] { "fdPath: ", paramString, " fd:", Integer.valueOf(paramInt), " thread:", localThread.getName(), " threadId:", Long.valueOf(localThread.getId()) });
    }
    localStringBuilder1.append("thread:");
    localStringBuilder1.append(localThread.getName());
    localStringBuilder1.append(" id:");
    localStringBuilder1.append(localThread.getId());
    localStringBuilder1.append("\n");
    localStringBuilder1.append("fd:");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" id:");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append("\n");
    mStackMap.put(Integer.valueOf(paramInt), localStringBuilder1.toString());
  }
  
  public static String getAllStackTrace()
  {
    localStringBuilder = new StringBuilder(2048);
    try
    {
      Object localObject1 = new ConcurrentHashMap(1024);
      Object localObject2 = FDNative.a().f();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject2).next();
          ((ConcurrentHashMap)localObject1).put(localInteger, mStackMap.get(localInteger));
        }
      }
      ((ConcurrentHashMap)localObject1).putAll(mStackMap);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, new Object[] { "curMap size:", Integer.valueOf(((ConcurrentHashMap)localObject1).size()) });
      }
      localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject1).next());
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FDStats", 1, "getAllStackTrace ", localThrowable);
    }
  }
  
  public static void handleFDError(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
    ThreadManagerV2.executeOnSubThread(new FDStatsHooker.1(paramStringBuilder, paramHashMap));
  }
  
  public static void notifyErrorForFD(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append("notifyErrorForFD fd:");
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append(" errCode:");
    localStringBuilder1.append(paramInt2);
    localStringBuilder1.append(" filePath:");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(" method:");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(" backTrace:\n");
    localStringBuilder1.append(paramString3);
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder2 = new StringBuilder();
    paramInt1 = 1;
    while (paramInt1 < localObject.length)
    {
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append(localObject[paramInt1]);
      localStringBuilder3.append("\n");
      localStringBuilder2.append(localStringBuilder3.toString());
      paramInt1 += 1;
    }
    localStringBuilder1.append("javaStack:\n");
    localStringBuilder1.append(localStringBuilder2);
    localObject = new HashMap();
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append("");
    localStringBuilder3.append(paramInt2);
    ((HashMap)localObject).put("errCode", localStringBuilder3.toString());
    ((HashMap)localObject).put("filePath", paramString1);
    ((HashMap)localObject).put("method:", paramString2);
    ((HashMap)localObject).put("backTrace", paramString3);
    ((HashMap)localObject).put("javaStack", localStringBuilder2.toString());
    handleFDError(localStringBuilder1, (HashMap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsHooker
 * JD-Core Version:    0.7.0.1
 */