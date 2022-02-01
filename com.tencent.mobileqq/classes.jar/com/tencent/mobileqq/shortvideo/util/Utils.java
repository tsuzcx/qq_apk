package com.tencent.mobileqq.shortvideo.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class Utils
{
  private static long[] CRCTable = new long[256];
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  public static final String TAG = "URLDrawable.Utils";
  private static boolean init = false;
  
  public static final long Crc64Long(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      l2 = 0L;
      return l2;
    }
    if (!init)
    {
      i = 0;
      while (i < 256)
      {
        l1 = i;
        j = 0;
        if (j < 8)
        {
          if (((int)l1 & 0x1) != 0) {}
          for (l1 = l1 >> 1 ^ 0xAC4BC9B5;; l1 >>= 1)
          {
            j += 1;
            break;
          }
        }
        CRCTable[i] = l1;
        i += 1;
      }
      init = true;
    }
    int j = paramString.length();
    long l1 = -1L;
    int i = k;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      k = paramString.charAt(i);
      l2 = CRCTable[((k ^ (int)l1) & 0xFF)];
      i += 1;
      l1 = l2 ^ l1 >> 8;
    }
  }
  
  public static final String Crc64String(String paramString)
  {
    return Long.toString(Crc64Long(paramString), 16);
  }
  
  public static void disableConnectionReuseIfNecessary()
  {
    if (hasHttpConnectionBug()) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public static File getExternalCacheDir(Context paramContext)
  {
    if (hasExternalCacheDir()) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/imagecache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static int getMemoryClass(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  @SuppressLint({"NewApi"})
  public static long getUsableSpace(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return paramFile.getUsableSpace();
    }
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockSize();
    return paramFile.getAvailableBlocks() * l;
  }
  
  public static boolean hasExternalCacheDir()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean hasHttpConnectionBug()
  {
    return Build.VERSION.SDK_INT < 8;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.Utils
 * JD-Core Version:    0.7.0.1
 */