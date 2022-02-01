package com.tencent.mobileqq.monitor;

import com.tencent.qphone.base.util.QLog;

public class CaptureFreqMonitor
{
  public static String a = "AutoMonitor_Camera";
  public static boolean b = false;
  public static CaptureFreqMonitorItem c = new CaptureFreqMonitorItem();
  public static boolean d = true;
  public static CaptureFreqMonitorItem e = new CaptureFreqMonitorItem(3);
  public static CaptureFreqMonitorItem f = new CaptureFreqMonitorItem(5);
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramArrayOfInt != null))
    {
      if (paramInt2 > paramArrayOfInt.length) {
        return 0;
      }
      long l = 0L;
      int i = paramInt1;
      while (i < paramInt2)
      {
        l += paramArrayOfInt[i];
        i += 1;
      }
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 == 0) {
        return 0;
      }
      return (int)(l / paramInt1);
    }
    return 0;
  }
  
  public static String a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramInt != 0) && (paramArrayOfInt != null) && (paramInt <= paramArrayOfInt.length))
    {
      int i = paramInt - 1;
      if (i == -1) {
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      paramInt = 0;
      for (;;)
      {
        localStringBuilder.append(paramArrayOfInt[paramInt]);
        if (paramInt == i)
        {
          localStringBuilder.append(']');
          return localStringBuilder.toString();
        }
        localStringBuilder.append(", ");
        paramInt += 1;
      }
    }
    return "";
  }
  
  public static void a()
  {
    if (c.b())
    {
      c.e = System.currentTimeMillis();
      long l = c.e - c.d;
      QLog.d(a, 1, String.format("CameraEditStatistic, avgRenderCost=%d, cost=%d, frameCount=%d, frameFreq=%d", new Object[] { Integer.valueOf(a(c.h, 0, c.f)), Long.valueOf(l), Integer.valueOf(c.f), Long.valueOf(c.f * 1000 / l) }));
      QLog.d(a, 1, String.format("CameraEditStatistic, render cost: %s", new Object[] { a(c.h, c.f) }));
      c.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.monitor.CaptureFreqMonitor
 * JD-Core Version:    0.7.0.1
 */