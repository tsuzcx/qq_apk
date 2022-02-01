package com.tencent.qapmsdk.memory.memorydump;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import java.io.File;

public class DumpEnableCheck
{
  public static boolean checkDisk()
  {
    return getSdCardAvailableSize() * 1024L > Runtime.getRuntime().totalMemory();
  }
  
  public static boolean checkVersion()
  {
    return (AndroidVersion.isL()) && (!AndroidVersion.isQ());
  }
  
  private static long getSdCardAvailableSize()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.memorydump.DumpEnableCheck
 * JD-Core Version:    0.7.0.1
 */