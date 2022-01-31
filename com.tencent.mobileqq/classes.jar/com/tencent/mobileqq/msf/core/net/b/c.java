package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final String a = "NetworkToolsHelper";
  private static AtomicBoolean b = new AtomicBoolean(false);
  
  public static h.a a(String paramString)
  {
    if (b.compareAndSet(false, true))
    {
      paramString = new h(paramString, true).a();
      b.set(false);
      return paramString;
    }
    QLog.d("NetworkToolsHelper", 1, "Stop traceroute host: " + paramString + " by another task running");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.c
 * JD-Core Version:    0.7.0.1
 */