package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class q
{
  public static final String a = "MsfCoreMsgSender";
  public static final String b = "MsfCoreSocketReaderNew";
  public static final String c = "LightSender";
  public static final String d = "LightTcpSenderThread";
  public static final String e = "MSFSubHandlerThread";
  public static final int f = 2;
  private static final String g = "MsfThreadManager";
  private static HandlerThread h;
  private static Handler i;
  private static HandlerThread j;
  private static Handler k;
  private static Executor l;
  private static HandlerThread m;
  private static Handler n;
  
  public static HandlerThread a()
  {
    if (h == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSF_StatReportThread");
        localHandlerThread.start();
        h = localHandlerThread;
      }
      finally {}
    }
    return h;
  }
  
  public static void a(Runnable paramRunnable, q.a parama)
  {
    if (l == null) {
      l = Executors.newFixedThreadPool(2);
    }
    l.execute(new r(parama, paramRunnable));
    QLog.d("MsfThreadManager", 1, new Object[] { "[postFileTask] task: ", paramRunnable });
  }
  
  public static Handler b()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new Handler(a().getLooper());
        }
      }
      finally {}
    }
    return i;
  }
  
  public static HandlerThread c()
  {
    if (m == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSFNetHandlerThread");
        localHandlerThread.start();
        m = localHandlerThread;
      }
      finally {}
    }
    return m;
  }
  
  public static Handler d()
  {
    if (n == null) {
      try
      {
        if (n == null) {
          n = new Handler(c().getLooper());
        }
      }
      finally {}
    }
    return n;
  }
  
  public static HandlerThread e()
  {
    if (j == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSFSubHandlerThread");
        localHandlerThread.start();
        j = localHandlerThread;
      }
      finally {}
    }
    return j;
  }
  
  public static Handler f()
  {
    if (k == null) {
      try
      {
        if (k == null) {
          k = new Handler(e().getLooper());
        }
      }
      finally {}
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.q
 * JD-Core Version:    0.7.0.1
 */