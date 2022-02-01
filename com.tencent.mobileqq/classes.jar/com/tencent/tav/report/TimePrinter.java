package com.tencent.tav.report;

import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import java.util.Map;

public class TimePrinter
{
  private static Map<String, TimePrinter> constMap = new HashMap();
  private static Map<String, TimePrinter> printerMap = new HashMap();
  private String TAG = "TimeDebug";
  private CMTime currentSyncTime;
  private long currentTimeUs;
  
  public TimePrinter(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.TAG);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    this.TAG = localStringBuilder.toString();
  }
  
  public TimePrinter(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.TAG);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    this.TAG = localStringBuilder.toString();
    this.currentTimeUs = paramLong;
  }
  
  public static void print(String paramString, CMTime paramCMTime)
  {
    try
    {
      TimePrinter localTimePrinter2 = (TimePrinter)printerMap.get(paramString);
      TimePrinter localTimePrinter1 = localTimePrinter2;
      if (localTimePrinter2 == null)
      {
        localTimePrinter1 = new TimePrinter(paramString);
        printerMap.put(paramString, localTimePrinter1);
      }
      localTimePrinter1.print(paramCMTime);
      return;
    }
    finally {}
  }
  
  public static void printCons(String paramString)
  {
    try
    {
      TimePrinter localTimePrinter = (TimePrinter)constMap.get(paramString);
      if (localTimePrinter == null)
      {
        constMap.put(paramString, new TimePrinter(paramString, System.nanoTime() / 1000L));
      }
      else
      {
        localTimePrinter.printCons();
        constMap.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void print(CMTime paramCMTime)
  {
    if (this.currentSyncTime == null)
    {
      this.currentSyncTime = paramCMTime;
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("print: timeSub = ");
    localStringBuilder.append(paramCMTime.sub(this.currentSyncTime).getTimeUs());
    Log.d(str, localStringBuilder.toString());
    this.currentSyncTime = paramCMTime;
  }
  
  public void printCons()
  {
    long l = System.nanoTime() / 1000L;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("printConst: const = ");
    localStringBuilder.append(l - this.currentTimeUs);
    Log.d(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.TimePrinter
 * JD-Core Version:    0.7.0.1
 */