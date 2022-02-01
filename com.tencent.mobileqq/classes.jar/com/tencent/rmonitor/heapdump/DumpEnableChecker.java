package com.tencent.rmonitor.heapdump;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.rmonitor.common.util.AndroidVersion;
import java.io.File;

public class DumpEnableChecker
{
  public static boolean a()
  {
    return d() * 1024L > Runtime.getRuntime().totalMemory();
  }
  
  public static boolean b()
  {
    return (AndroidVersion.c()) && (!AndroidVersion.f());
  }
  
  public static boolean c()
  {
    return (AndroidVersion.d()) && (Build.VERSION.SDK_INT <= 30);
  }
  
  private static long d()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.DumpEnableChecker
 * JD-Core Version:    0.7.0.1
 */