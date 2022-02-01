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
  private static HandlerThread f = null;
  private static Handler g = null;
  private static HandlerThread h = null;
  private static Handler i = null;
  private static HandlerThread j = null;
  private static Handler k = null;
  
  public static HandlerThread a()
  {
    if (f == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("MSF_StatReportThread");
      localHandlerThread.start();
      f = localHandlerThread;
      return f;
    }
    finally {}
  }
  
  public static Handler b()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new Handler(a().getLooper());
      }
      return g;
    }
    finally {}
  }
  
  public static HandlerThread c()
  {
    if (j == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("MSFNetHandlerThread");
      localHandlerThread.start();
      j = localHandlerThread;
      return j;
    }
    finally {}
  }
  
  public static Handler d()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new Handler(c().getLooper());
      }
      return k;
    }
    finally {}
  }
  
  public static HandlerThread e()
  {
    if (h == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("MSFSubHandlerThread");
      localHandlerThread.start();
      h = localHandlerThread;
      return h;
    }
    finally {}
  }
  
  public static Handler f()
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new Handler(e().getLooper());
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.q
 * JD-Core Version:    0.7.0.1
 */