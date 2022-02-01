package com.tencent.richframework.sender.util;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class EventControlUtils
{
  private static final Map<String, Long> a = new ConcurrentHashMap();
  private static final Map<String, Timer> b = new ConcurrentHashMap();
  
  public static Timer a(String paramString)
  {
    return (Timer)b.get(paramString);
  }
  
  public static void a(String paramString, long paramLong, EventControlUtils.OnDebounceListener paramOnDebounceListener)
  {
    Timer localTimer = (Timer)b.get(paramString);
    if (localTimer != null) {
      localTimer.cancel();
    }
    localTimer = new Timer();
    localTimer.schedule(new EventControlUtils.2(paramOnDebounceListener), paramLong);
    b.put(paramString, localTimer);
  }
  
  public static void a(String paramString, Timer paramTimer)
  {
    b.put(paramString, paramTimer);
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    Long localLong = (Long)a.get(paramString);
    long l = SystemClock.elapsedRealtime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime");
    localStringBuilder.append(l);
    QLog.d("EventControlUtils", 4, localStringBuilder.toString());
    if ((localLong != null) && (l - localLong.longValue() < paramLong))
    {
      paramString = new StringBuilder();
      paramString.append("throttling in timeInterval");
      paramString.append(paramLong);
      QLog.d("EventControlUtils", 4, paramString.toString());
      return false;
    }
    a.put(paramString, Long.valueOf(l));
    return true;
  }
  
  public static Long b(String paramString)
  {
    return (Long)a.get(paramString);
  }
  
  public static void b(String paramString, long paramLong)
  {
    a.put(paramString, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.util.EventControlUtils
 * JD-Core Version:    0.7.0.1
 */