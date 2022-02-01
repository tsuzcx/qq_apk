package com.yolo.esports.download.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class SpaceUtils
{
  public static int a(String paramString)
  {
    if ((paramString != null) && (paramString.contains("/data/data"))) {
      return 2;
    }
    if (FileUtil.a()) {
      return 3;
    }
    return 1;
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return Math.max(localStatFs.getBlockSize() * (localStatFs.getAvailableBlocks() - 4L), 0L);
  }
  
  public static long b()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      StatFs localStatFs = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
      return Math.max(localStatFs.getBlockSize() * (localStatFs.getAvailableBlocks() - 4L), 0L);
    }
    return 0L;
  }
  
  public static long b(String paramString)
  {
    int i = a(paramString);
    if (i == 2) {
      return a();
    }
    if (i == 3) {
      return b();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.util.SpaceUtils
 * JD-Core Version:    0.7.0.1
 */