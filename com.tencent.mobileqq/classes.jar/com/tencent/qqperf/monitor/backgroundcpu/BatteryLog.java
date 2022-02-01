package com.tencent.qqperf.monitor.backgroundcpu;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.BufferedWriter;
import java.io.File;

public class BatteryLog
{
  static ThreadLocal<StringBuilder> a = new ThreadLocal();
  private static Handler b = new BatteryLog.LogHandler(ThreadManager.getFileThreadLooper());
  private static String c;
  private static String d;
  private static String e;
  private static long f;
  private static BufferedWriter g;
  private static BufferedWriter h;
  private static String i;
  
  static StringBuilder a()
  {
    StringBuilder localStringBuilder = (StringBuilder)a.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder(1024);
      a.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.delete(0, localStringBuilder.length());
    return localStringBuilder;
  }
  
  static void a(Object... paramVarArgs)
  {
    if (g != null) {
      b.obtainMessage(2, 0, 0, paramVarArgs).sendToTarget();
    }
  }
  
  private static long b(File paramFile)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.indexOf("_") + 1);
      if ((paramFile.endsWith(".log")) || (paramFile.endsWith(".zip")) || (paramFile.endsWith("rpt")))
      {
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
        return l;
      }
    }
    catch (Exception paramFile)
    {
      label65:
      break label65;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryLog
 * JD-Core Version:    0.7.0.1
 */