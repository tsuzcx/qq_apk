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
  
  public TimePrinter(String paramString) {}
  
  public TimePrinter(String paramString, long paramLong)
  {
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
  
  /* Error */
  public static void printCons(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 56 2 0
    //   12: checkcast 2	com/tencent/tav/report/TimePrinter
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +32 -> 49
    //   20: getstatic 25	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   23: aload_0
    //   24: new 2	com/tencent/tav/report/TimePrinter
    //   27: dup
    //   28: aload_0
    //   29: invokestatic 72	java/lang/System:nanoTime	()J
    //   32: ldc2_w 73
    //   35: ldiv
    //   36: invokespecial 76	com/tencent/tav/report/TimePrinter:<init>	(Ljava/lang/String;J)V
    //   39: invokeinterface 62 3 0
    //   44: pop
    //   45: ldc 2
    //   47: monitorexit
    //   48: return
    //   49: aload_1
    //   50: invokevirtual 78	com/tencent/tav/report/TimePrinter:printCons	()V
    //   53: getstatic 25	com/tencent/tav/report/TimePrinter:constMap	Ljava/util/Map;
    //   56: aload_0
    //   57: invokeinterface 81 2 0
    //   62: pop
    //   63: goto -18 -> 45
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString	String
    //   15	35	1	localTimePrinter	TimePrinter
    // Exception table:
    //   from	to	target	type
    //   3	16	66	finally
    //   20	45	66	finally
    //   49	63	66	finally
  }
  
  public void print(CMTime paramCMTime)
  {
    if (this.currentSyncTime == null)
    {
      this.currentSyncTime = paramCMTime;
      return;
    }
    Log.d(this.TAG, "print: timeSub = " + paramCMTime.sub(this.currentSyncTime).getTimeUs());
    this.currentSyncTime = paramCMTime;
  }
  
  public void printCons()
  {
    long l = System.nanoTime() / 1000L;
    Log.d(this.TAG, "printConst: const = " + (l - this.currentTimeUs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.TimePrinter
 * JD-Core Version:    0.7.0.1
 */