package com.tencent.weiyun.transmission.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Printer;
import java.util.WeakHashMap;

public final class ThreadUtils
{
  private static final WeakHashMap<Looper, ThreadUtils.PrinterWrapper> sLooperPrinters = new WeakHashMap();
  private static Handler sMainHandler;
  private static Thread sMainThread = Looper.getMainLooper().getThread();
  
  static
  {
    sMainHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void addLooperPrinter(Looper paramLooper, Printer paramPrinter)
  {
    if (paramLooper == null) {
      throw new RuntimeException("null looper");
    }
    synchronized (sLooperPrinters)
    {
      ThreadUtils.PrinterWrapper localPrinterWrapper2 = (ThreadUtils.PrinterWrapper)sLooperPrinters.get(paramLooper);
      ThreadUtils.PrinterWrapper localPrinterWrapper1 = localPrinterWrapper2;
      if (localPrinterWrapper2 == null)
      {
        localPrinterWrapper1 = new ThreadUtils.PrinterWrapper();
        sLooperPrinters.put(paramLooper, localPrinterWrapper1);
        paramLooper.setMessageLogging(localPrinterWrapper1);
      }
      localPrinterWrapper1.add(paramPrinter);
      return;
    }
  }
  
  public static void addLooperPrinter(Printer paramPrinter)
  {
    addLooperPrinter(Looper.myLooper(), paramPrinter);
  }
  
  public static Handler getMainHandler()
  {
    return sMainHandler;
  }
  
  public static boolean isMainThread()
  {
    return sMainThread == Thread.currentThread();
  }
  
  public static void post(Runnable paramRunnable)
  {
    sMainHandler.post(paramRunnable);
  }
  
  public static void postDelayed(Runnable paramRunnable, long paramLong)
  {
    sMainHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void removeCallbacks(Runnable paramRunnable)
  {
    sMainHandler.removeCallbacks(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (isMainThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */