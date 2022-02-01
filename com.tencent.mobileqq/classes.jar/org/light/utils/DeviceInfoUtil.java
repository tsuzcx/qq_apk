package org.light.utils;

import android.os.Build.VERSION;
import android.os.Process;
import java.io.RandomAccessFile;
import org.light.LibraryLoadUtils;

public class DeviceInfoUtil
{
  private static RandomAccessFile appStatFile;
  private static Long lastAppCpuTime;
  private static Long lastCpuTime;
  private static RandomAccessFile procStatFile;
  
  static
  {
    LibraryLoadUtils.loadLibrary("YTCommon");
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  public static float getCpuUsage()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return -1.0F;
    }
    float f2 = 0.0F;
    float f1 = f2;
    long l1;
    long l2;
    for (;;)
    {
      try
      {
        if (procStatFile != null)
        {
          f1 = f2;
          if (appStatFile != null) {}
        }
        else
        {
          f1 = f2;
          procStatFile = new RandomAccessFile("/proc/stat", "r");
          f1 = f2;
          appStatFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
          f1 = f2;
          Object localObject2 = procStatFile.readLine();
          f1 = f2;
          Object localObject1 = appStatFile.readLine();
          f1 = f2;
          localObject2 = ((String)localObject2).split(" ");
          f1 = f2;
          localObject1 = ((String)localObject1).split(" ");
          f1 = f2;
          l1 = Long.parseLong(localObject2[2]) + Long.parseLong(localObject2[3]) + Long.parseLong(localObject2[4]) + Long.parseLong(localObject2[5]) + Long.parseLong(localObject2[6]) + Long.parseLong(localObject2[7]) + Long.parseLong(localObject2[8]);
          f1 = f2;
          l2 = Long.parseLong(localObject1[13]);
          f1 = f2;
          l2 = Long.parseLong(localObject1[14]) + l2;
          f1 = f2;
          if (lastCpuTime != null) {
            break;
          }
          f1 = f2;
          if (lastAppCpuTime != null) {
            break;
          }
          f1 = f2;
          lastCpuTime = Long.valueOf(l1);
          f1 = f2;
          lastAppCpuTime = Long.valueOf(l2);
          return 0.0F;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return f1;
      }
      f1 = f2;
      procStatFile.seek(0L);
      f1 = f2;
      appStatFile.seek(0L);
    }
    f1 = f2;
    float f3 = (float)(l2 - lastAppCpuTime.longValue());
    f1 = f2;
    f2 = (float)(l1 - lastCpuTime.longValue());
    f1 = f2;
    f2 = f3 / f2 * 100.0F;
    f1 = f2;
    lastCpuTime = Long.valueOf(l1);
    f1 = f2;
    lastAppCpuTime = Long.valueOf(l2);
    return f2;
  }
  
  public static float getMemoryUsage()
  {
    return 100.0F;
  }
  
  private static native void nativeInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.utils.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */