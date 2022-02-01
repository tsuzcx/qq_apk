package com.tencent.qqmusic.mediaplayer.util;

public class CpuInfoUtil
{
  private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
  private static final String TAG = "CpuInfoUtil";
  private static CpuInfoUtil.OutputCpuThread mCurrThread;
  
  public static void outputCpuHZToLog() {}
  
  public static void outputThreadInfoToLog() {}
  
  public static void startProcessInfoOutput() {}
  
  public static void stopProcessInfoOutput()
  {
    try
    {
      mCurrThread = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil
 * JD-Core Version:    0.7.0.1
 */