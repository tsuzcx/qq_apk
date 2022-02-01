package com.tencent.qqperf.monitor.backgroundcpu;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.BufferedWriter;
import java.io.File;

public class BatteryLog
{
  private static long jdField_a_of_type_Long;
  private static Handler jdField_a_of_type_AndroidOsHandler = new BatteryLog.LogHandler(ThreadManager.getFileThreadLooper());
  private static BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  private static String jdField_a_of_type_JavaLangString;
  static ThreadLocal<StringBuilder> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static BufferedWriter jdField_b_of_type_JavaIoBufferedWriter;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  private static String d;
  
  static StringBuilder a()
  {
    StringBuilder localStringBuilder = (StringBuilder)jdField_a_of_type_JavaLangThreadLocal.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder(1024);
      jdField_a_of_type_JavaLangThreadLocal.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.delete(0, localStringBuilder.length());
    return localStringBuilder;
  }
  
  static void a(Object... paramVarArgs)
  {
    if (jdField_a_of_type_JavaIoBufferedWriter != null) {
      jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, 0, paramVarArgs).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryLog
 * JD-Core Version:    0.7.0.1
 */