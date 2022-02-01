package com.tencent.qa.apphook.util.emulator;

import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class DetectAndroidEmulator
{
  private static String[] known_files = { "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props" };
  private static String[] known_geny_files = { "/dev/socket/genyd", "/dev/socket/baseband_genyd" };
  private static String[] known_pipes = { "/dev/socket/qemud", "/dev/qemu_pipe" };
  private static String[] known_qemu_drivers = { "goldfish" };
  
  public static boolean hasEmulatorBuild()
  {
    String str1 = Build.BOARD;
    String str2 = Build.BRAND;
    String str3 = Build.DEVICE;
    String str4 = Build.HARDWARE;
    String str5 = Build.MODEL;
    String str6 = Build.PRODUCT;
    return (str1.compareTo("unknown") == 0) || (str2.compareTo("generic") == 0) || (str3.compareTo("generic") == 0) || (str5.compareTo("sdk") == 0) || (str6.compareTo("sdk") == 0) || (str4.compareTo("goldfish") == 0);
  }
  
  public static boolean hasGenyFiles()
  {
    boolean bool2 = false;
    String[] arrayOfString = known_geny_files;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (new File(arrayOfString[i]).exists()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean hasPipes()
  {
    boolean bool2 = false;
    String[] arrayOfString = known_pipes;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (new File(arrayOfString[i]).exists()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean hasQEmuDrivers()
  {
    File[] arrayOfFile = new File[2];
    arrayOfFile[0] = new File("/proc/tty/drivers");
    arrayOfFile[1] = new File("/proc/cpuinfo");
    int k = arrayOfFile.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = arrayOfFile[i];
      if ((((File)localObject2).exists()) && (((File)localObject2).canRead()))
      {
        Object localObject1 = new byte[1024];
        try
        {
          localObject2 = new FileInputStream((File)localObject2);
          ((InputStream)localObject2).read((byte[])localObject1);
          ((InputStream)localObject2).close();
          localObject1 = new String((byte[])localObject1);
          localObject2 = known_qemu_drivers;
          int m = localObject2.length;
          j = 0;
          if (j < m) {
            if (((String)localObject1).indexOf(localObject2[j]) != -1) {
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            localException.printStackTrace();
            continue;
            j += 1;
          }
        }
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean hasQEmuFiles()
  {
    boolean bool2 = false;
    String[] arrayOfString = known_files;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (new File(arrayOfString[i]).exists()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isAndroidEmulator()
  {
    return (hasEmulatorBuild()) || (hasQEmuDrivers()) || (hasGenyFiles()) || (hasPipes()) || (hasQEmuFiles());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.emulator.DetectAndroidEmulator
 * JD-Core Version:    0.7.0.1
 */