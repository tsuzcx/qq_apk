package com.tencent.plato.core.utils;

import android.os.Debug;
import java.util.Hashtable;
import java.util.Map;

public class Tracker
{
  public static boolean enable = true;
  private static Map<String, Record> maps = new Hashtable();
  
  private static String getDebug(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1.substring(paramString1.lastIndexOf('.') + 1);
    paramString1 = str;
    if (str.indexOf('$') > 0) {
      paramString1 = str.substring(0, str.indexOf('$'));
    }
    return "(Trace)[" + paramString1 + "." + paramString2 + ":" + paramInt + "]";
  }
  
  private static String getTag(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf('.') + 1);
    paramString = str;
    if (str.indexOf('$') > 0) {
      paramString = str.substring(0, str.indexOf('$'));
    }
    return paramString;
  }
  
  public static void trace(String paramString)
  {
    if (!enable) {
      return;
    }
    StackTraceElement localStackTraceElement = new java.lang.Throwable().fillInStackTrace().getStackTrace()[1];
    trace(getTag(localStackTraceElement.getClassName()), getDebug(localStackTraceElement.getClassName(), localStackTraceElement.getMethodName(), localStackTraceElement.getLineNumber()), paramString);
  }
  
  public static void trace(String paramString1, String paramString2)
  {
    if (!enable) {
      return;
    }
    StackTraceElement localStackTraceElement = new java.lang.Throwable().fillInStackTrace().getStackTrace()[1];
    trace(paramString1, getDebug(localStackTraceElement.getClassName(), localStackTraceElement.getMethodName(), localStackTraceElement.getLineNumber()), paramString2);
  }
  
  private static void trace(String paramString1, String paramString2, String paramString3)
  {
    Record localRecord = (Record)maps.get(paramString1);
    paramString2 = new Record(paramString2, paramString3, localRecord);
    if (localRecord != null) {
      PLog.d(paramString1, paramString2.debug + paramString2.index + ":(" + (paramString2.t - localRecord.t) + "/" + (paramString2.t - paramString2.o) + ")" + paramString2.des);
    }
    for (;;)
    {
      maps.put(paramString1, paramString2);
      return;
      PLog.d(paramString1, paramString2.debug + paramString2.index + ":(" + 0 + "/" + 0 + ")" + paramString2.des);
    }
  }
  
  static class Record
  {
    long cput;
    String debug;
    String des;
    int index;
    long o;
    long t;
    
    Record(String paramString1, String paramString2, Record paramRecord)
    {
      this.debug = paramString1;
      this.des = paramString2;
      if (paramRecord == null) {
        this.o = System.currentTimeMillis();
      }
      for (this.index = 0;; paramRecord.index += 1)
      {
        this.t = System.currentTimeMillis();
        this.cput = Debug.threadCpuTimeNanos();
        return;
        this.o = paramRecord.o;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.Tracker
 * JD-Core Version:    0.7.0.1
 */