package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;

public class q
{
  public static final String a = "MsfCoreMsgSender";
  public static final String b = "MsfCoreSocketReaderNew";
  public static final String c = "LightSender";
  public static final String d = "LightTcpSenderThread";
  public static final String e = "MSFSubHandlerThread";
  private static HandlerThread f;
  private static Handler g;
  private static HandlerThread h;
  private static Handler i;
  private static HandlerThread j;
  private static Handler k;
  
  public static HandlerThread a()
  {
    if (f == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSF_StatReportThread");
        localHandlerThread.start();
        f = localHandlerThread;
      }
      finally {}
    }
    return f;
  }
  
  public static Handler b()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new Handler(a().getLooper());
        }
      }
      finally {}
    }
    return g;
  }
  
  public static HandlerThread c()
  {
    if (j == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSFNetHandlerThread");
        localHandlerThread.start();
        j = localHandlerThread;
      }
      finally {}
    }
    return j;
  }
  
  public static Handler d()
  {
    if (k == null) {
      try
      {
        if (k == null) {
          k = new Handler(c().getLooper());
        }
      }
      finally {}
    }
    return k;
  }
  
  public static HandlerThread e()
  {
    if (h == null) {
      try
      {
        HandlerThread localHandlerThread = new HandlerThread("MSFSubHandlerThread");
        localHandlerThread.start();
        h = localHandlerThread;
      }
      finally {}
    }
    return h;
  }
  
  public static Handler f()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new Handler(e().getLooper());
        }
      }
      finally {}
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.q
 * JD-Core Version:    0.7.0.1
 */