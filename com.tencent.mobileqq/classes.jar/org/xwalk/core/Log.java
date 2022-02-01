package org.xwalk.core;

import com.tencent.xweb.util.IXWebLogClient;

public class Log
{
  private static IXWebLogClient m_log_callback;
  
  public static void SetLogCallBack(IXWebLogClient paramIXWebLogClient)
  {
    m_log_callback = paramIXWebLogClient;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.d(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.b(paramString1, paramString2);
      return;
    }
    android.util.Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.b(paramString1, paramString2);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.b(paramString1, paramString2);
      return;
    }
    android.util.Log.e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.a(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.e(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.c(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IXWebLogClient localIXWebLogClient = m_log_callback;
    if (localIXWebLogClient != null)
    {
      localIXWebLogClient.c(paramString1, paramString2);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.Log
 * JD-Core Version:    0.7.0.1
 */