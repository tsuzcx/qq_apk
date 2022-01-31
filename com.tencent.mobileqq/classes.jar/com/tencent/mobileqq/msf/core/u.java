package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;

public class u
{
  public static final String a = "MsfCoreMsgSender";
  public static final String b = "MsfCoreSocketReaderNew";
  public static final String c = "LightSender";
  public static final String d = "LightTcpSenderThread";
  private static HandlerThread e;
  private static Handler f;
  private static HandlerThread g;
  private static Handler h;
  
  public static HandlerThread a()
  {
    if (e == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("MSF_StatReportThread");
      localHandlerThread.start();
      e = localHandlerThread;
      return e;
    }
    finally {}
  }
  
  public static Handler b()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new Handler(a().getLooper());
      }
      return f;
    }
    finally {}
  }
  
  public static HandlerThread c()
  {
    if (g == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("MSFNetHandlerThread");
      localHandlerThread.start();
      g = localHandlerThread;
      return g;
    }
    finally {}
  }
  
  public static Handler d()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new Handler(c().getLooper());
      }
      return h;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.u
 * JD-Core Version:    0.7.0.1
 */