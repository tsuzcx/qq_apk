package com.tencent.mobileqq.mini.appbrand.page.embedded;

import java.util.concurrent.ConcurrentHashMap;

public class EmbeddedVideoLogger
  implements com.tencent.oskplayer.util.QLog
{
  private static final String TAG_PREFIX = "VIDEO_LOG/";
  private static ConcurrentHashMap<String, String> sLogTagCache;
  
  private static String getLogTag(String paramString)
  {
    if (sLogTagCache == null) {
      sLogTagCache = new ConcurrentHashMap();
    }
    if (!sLogTagCache.containsKey(paramString)) {
      sLogTagCache.put(paramString, "VIDEO_LOG/" + paramString);
    }
    return (String)sLogTagCache.get(paramString);
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
      com.tencent.qphone.base.util.QLog.d(getLogTag(paramString1), 4, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
      com.tencent.qphone.base.util.QLog.d(getLogTag(paramString1), 4, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.e(getLogTag(paramString1), 1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.e(getLogTag(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.i(getLogTag(paramString1), 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.i(getLogTag(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i(getLogTag(paramString1), 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i(getLogTag(paramString1), 2, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.w(getLogTag(paramString1), 1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.w(getLogTag(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.w(getLogTag(paramString), 1, paramThrowable.getMessage());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedVideoLogger
 * JD-Core Version:    0.7.0.1
 */