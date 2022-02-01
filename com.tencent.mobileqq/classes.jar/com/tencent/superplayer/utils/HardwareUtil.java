package com.tencent.superplayer.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class HardwareUtil
{
  private static final FileFilter CPU_FILTER = new HardwareUtil.1();
  public static final int CPU_LEVEL_HIGH = 3;
  public static final int CPU_LEVEL_LOW = 0;
  public static final int CPU_LEVEL_MIDDLE = 2;
  public static final int CPU_LEVEL_MIDDLE_LOW = 1;
  public static final int DEVICE_LEVEL_BOTTOM_LOW = -2;
  public static final int DEVICE_LEVEL_HIGH = 3;
  public static final int DEVICE_LEVEL_LOW = 1;
  public static final int DEVICE_LEVEL_MID = 2;
  public static final int RAM_LEVEL_BOTTOM_LOW = 0;
  public static final int RAM_LEVEL_HIGH = 3;
  public static final int RAM_LEVEL_LOW = 1;
  public static final int RAM_LEVEL_MIDDLE = 2;
  public static final int RAM_LEVEL_TOP_HIGH = 4;
  public static final String TAG = "HardwareUtil";
  public static final int UNKNOWN = -1;
  private static int sCacheDeviceLevel = -1;
  private static final Map<String, String> sDeviceInfoJsonMap = new HashMap();
  
  private static int extractValue(byte[] paramArrayOfByte, int paramInt)
  {
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if (Character.isDigit(paramArrayOfByte[paramInt]))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (Character.isDigit(paramArrayOfByte[i]))) {
          i += 1;
        }
        return Integer.parseInt(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public static long getAvailMemory(Context paramContext)
  {
    if (paramContext == null) {
      return -1L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (paramContext != null)
    {
      paramContext.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public static String getBrand()
  {
    return Build.BRAND;
  }
  
  public static int getCPUMaxFreqKHz()
  {
    int k = 0;
    int i = -1;
    try
    {
      int j;
      for (;;)
      {
        Object localObject1;
        if (k < getNumberOfCPUCores())
        {
          localObject1 = new File("/sys/devices/system/cpu/cpu" + k + "/cpufreq/cpuinfo_max_freq");
          j = i;
          if (((File)localObject1).exists())
          {
            j = i;
            if (((File)localObject1).canRead())
            {
              Object localObject2 = new byte[''];
              localObject1 = new FileInputStream((File)localObject1);
              try
              {
                ((FileInputStream)localObject1).read((byte[])localObject2);
                j = 0;
                while ((Character.isDigit(localObject2[j])) && (j < localObject2.length)) {
                  j += 1;
                }
                localObject2 = Integer.valueOf(Integer.parseInt(new String((byte[])localObject2, 0, j)));
                j = i;
                if (((Integer)localObject2).intValue() > i) {
                  j = ((Integer)localObject2).intValue();
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                ((FileInputStream)localObject1).close();
                j = i;
              }
              finally
              {
                ((FileInputStream)localObject1).close();
              }
            }
          }
        }
        else
        {
          j = i;
          if (i != -1) {
            break;
          }
          localObject1 = new FileInputStream("/proc/cpuinfo");
          try
          {
            j = parseFileForValue("cpu MHz", (FileInputStream)localObject1);
            k = j * 1000;
            j = i;
            if (k > i) {
              j = k;
            }
            return j;
          }
          finally
          {
            ((FileInputStream)localObject1).close();
          }
        }
        k += 1;
        i = j;
      }
      return j;
    }
    catch (IOException localIOException)
    {
      j = -1;
    }
  }
  
  /* Error */
  private static int getCoresFromFileInfo(String paramString)
  {
    // Byte code:
    //   0: new 145	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 177	java/io/BufferedReader
    //   12: dup
    //   13: new 179	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 182	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 185	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 188	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: invokevirtual 189	java/io/BufferedReader:close	()V
    //   35: aload 4
    //   37: invokestatic 192	com/tencent/superplayer/utils/HardwareUtil:getCoresFromFileString	(Ljava/lang/String;)I
    //   40: istore_1
    //   41: iload_1
    //   42: istore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 195	java/io/InputStream:close	()V
    //   51: iload_1
    //   52: istore_2
    //   53: iload_2
    //   54: ireturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: iconst_m1
    //   59: istore_2
    //   60: aload_0
    //   61: ifnull -8 -> 53
    //   64: aload_0
    //   65: invokevirtual 195	java/io/InputStream:close	()V
    //   68: iconst_m1
    //   69: ireturn
    //   70: astore_0
    //   71: iconst_m1
    //   72: ireturn
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 195	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: athrow
    //   86: astore_0
    //   87: iload_1
    //   88: ireturn
    //   89: astore_0
    //   90: goto -6 -> 84
    //   93: astore_3
    //   94: goto -18 -> 76
    //   97: astore_3
    //   98: goto -40 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   40	48	1	i	int
    //   42	18	2	j	int
    //   24	8	3	localBufferedReader	BufferedReader
    //   73	12	3	localObject1	Object
    //   93	1	3	localObject2	Object
    //   97	1	3	localIOException	IOException
    //   29	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	9	55	java/io/IOException
    //   64	68	70	java/io/IOException
    //   0	9	73	finally
    //   47	51	86	java/io/IOException
    //   80	84	89	java/io/IOException
    //   9	41	93	finally
    //   9	41	97	java/io/IOException
  }
  
  private static int getCoresFromFileString(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$"))) {
      return -1;
    }
    return Integer.valueOf(paramString.substring(2)).intValue() + 1;
  }
  
  public static String getDeviceInfoJson()
  {
    synchronized (sDeviceInfoJsonMap)
    {
      if (sDeviceInfoJsonMap.isEmpty())
      {
        sDeviceInfoJsonMap.put("model", getModel());
        sDeviceInfoJsonMap.put("brand", getBrand());
        sDeviceInfoJsonMap.put("cpuMaxFreqMHz", String.valueOf(getCPUMaxFreqKHz() / 1000));
        sDeviceInfoJsonMap.put("cpuCoreNumber", String.valueOf(getNumberOfCPUCores()));
        sDeviceInfoJsonMap.put("cpuName", getHardWare());
        sDeviceInfoJsonMap.put("ram", String.valueOf(getTotalMemory(SuperPlayerSDKMgr.getContext())));
      }
      sDeviceInfoJsonMap.put("availRam", String.valueOf(getAvailMemory(SuperPlayerSDKMgr.getContext())));
      String str = new JSONObject(sDeviceInfoJsonMap).toString();
      return str;
    }
  }
  
  public static String getHardWare()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
      String str;
      for (Object localObject = "";; localObject = str)
      {
        str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
      }
      if (((String)localObject).contains("Hardware"))
      {
        localObject = localObject.split(":\\s+", 2)[1];
        return localObject;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return Build.HARDWARE;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static String getModel()
  {
    return Build.MODEL;
  }
  
  public static int getNumberOfCPUCores()
  {
    int j;
    if (Build.VERSION.SDK_INT <= 10) {
      j = 1;
    }
    for (;;)
    {
      return j;
      try
      {
        j = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
        int i = j;
        if (j == -1) {
          i = getCoresFromFileInfo("/sys/devices/system/cpu/present");
        }
        j = i;
        if (i == -1)
        {
          i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
          return i;
        }
      }
      catch (SecurityException localSecurityException)
      {
        return -1;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    return -1;
  }
  
  @TargetApi(16)
  public static long getTotalMemory(Context paramContext)
  {
    if (paramContext == null) {
      return -1L;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null) {
        paramContext.getMemoryInfo(localMemoryInfo);
      }
      if (localMemoryInfo != null) {
        return localMemoryInfo.totalMem;
      }
      return -1L;
    }
    for (;;)
    {
      try
      {
        paramContext = new FileInputStream("/proc/meminfo");
      }
      catch (IOException paramContext)
      {
        int i;
        long l = -1L;
        continue;
      }
      try
      {
        i = parseFileForValue("MemTotal", paramContext);
        l = i * 1024L;
        try
        {
          return l;
        }
        catch (IOException paramContext) {}
        return l;
      }
      finally
      {
        paramContext.close();
      }
    }
  }
  
  private static int judgeCPU()
  {
    int i = getCPUMaxFreqKHz() / 1000;
    if (i <= 1600) {
      return 0;
    }
    if (i <= 2000) {
      return 1;
    }
    if (i <= 2500) {
      return 2;
    }
    return 3;
  }
  
  public static int judgeDeviceLevel(Context paramContext)
  {
    int j = 2;
    if (paramContext == null) {
      return -1;
    }
    if (sCacheDeviceLevel != -1) {
      return sCacheDeviceLevel;
    }
    int k = judgeMemory(paramContext);
    int m = judgeCPU();
    int i;
    if ((k < 1) && (m == 0)) {
      i = -2;
    }
    for (;;)
    {
      sCacheDeviceLevel = i;
      return i;
      if ((k < 2) || (m == 0))
      {
        i = 1;
      }
      else if (k == 2)
      {
        i = j;
        if (m >= 1) {}
      }
      else if (k > 2)
      {
        i = j;
        if (m > 1) {
          i = 3;
        }
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private static int judgeMemory(Context paramContext)
  {
    long l = getTotalMemory(paramContext) / 1048576L;
    if (l <= 2000L) {
      return 0;
    }
    if (l <= 3000L) {
      return 1;
    }
    if (l <= 4000L) {
      return 2;
    }
    if (l <= 6000L) {
      return 3;
    }
    return 4;
  }
  
  private static int parseFileForValue(String paramString, FileInputStream paramFileInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    int m;
    int j;
    int i;
    int k;
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      k = i;
      if (j >= m) {
        break label129;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        break label129;
      }
      if (k == paramString.length() - 1)
      {
        i = extractValue(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    for (;;)
    {
      if (j < m)
      {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
          break;
        }
        label129:
        j = k + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.HardwareUtil
 * JD-Core Version:    0.7.0.1
 */