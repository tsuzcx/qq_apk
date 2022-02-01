package com.tencent.superplayer.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
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
    //   24	8	3	localBufferedReader	java.io.BufferedReader
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
  
  /* Error */
  public static String getHardWare()
  {
    // Byte code:
    //   0: new 270	java/io/FileReader
    //   3: dup
    //   4: ldc 167
    //   6: invokespecial 271	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: astore_0
    //   12: new 177	java/io/BufferedReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 185	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 4
    //   22: ldc_w 273
    //   25: astore_2
    //   26: aload_1
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 188	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +8 -> 43
    //   38: aload_3
    //   39: astore_2
    //   40: goto -14 -> 26
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 275
    //   49: invokevirtual 279	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +29 -> 81
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 281
    //   61: iconst_2
    //   62: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   65: iconst_1
    //   66: aaload
    //   67: astore_2
    //   68: aload_1
    //   69: invokevirtual 286	java/io/FileReader:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: areturn
    //   81: aload_1
    //   82: invokevirtual 286	java/io/FileReader:close	()V
    //   85: getstatic 292	android/os/Build:HARDWARE	Ljava/lang/String;
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   94: goto -9 -> 85
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 293	java/io/FileNotFoundException:printStackTrace	()V
    //   106: aload_1
    //   107: invokevirtual 286	java/io/FileReader:close	()V
    //   110: goto -25 -> 85
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   118: goto -33 -> 85
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   130: aload_1
    //   131: invokevirtual 286	java/io/FileReader:close	()V
    //   134: goto -49 -> 85
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   142: goto -57 -> 85
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 286	java/io/FileReader:close	()V
    //   152: aload_1
    //   153: athrow
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   159: goto -7 -> 152
    //   162: astore_1
    //   163: goto -15 -> 148
    //   166: astore_2
    //   167: goto -43 -> 124
    //   170: astore_2
    //   171: goto -71 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	46	0	localFileReader1	java.io.FileReader
    //   74	2	0	localException1	java.lang.Exception
    //   89	2	0	localException2	java.lang.Exception
    //   101	1	0	localFileReader2	java.io.FileReader
    //   113	2	0	localException3	java.lang.Exception
    //   125	1	0	localFileReader3	java.io.FileReader
    //   137	2	0	localException4	java.lang.Exception
    //   147	2	0	localObject1	Object
    //   154	2	0	localException5	java.lang.Exception
    //   9	122	1	localFileReader4	java.io.FileReader
    //   145	8	1	localObject2	Object
    //   162	1	1	localObject3	Object
    //   25	55	2	localObject4	Object
    //   97	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   121	6	2	localIOException1	IOException
    //   166	1	2	localIOException2	IOException
    //   170	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   33	6	3	str	String
    //   20	9	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   81	85	89	java/lang/Exception
    //   0	10	97	java/io/FileNotFoundException
    //   106	110	113	java/lang/Exception
    //   0	10	121	java/io/IOException
    //   130	134	137	java/lang/Exception
    //   0	10	145	finally
    //   148	152	154	java/lang/Exception
    //   12	22	162	finally
    //   28	34	162	finally
    //   45	55	162	finally
    //   57	68	162	finally
    //   102	106	162	finally
    //   126	130	162	finally
    //   12	22	166	java/io/IOException
    //   28	34	166	java/io/IOException
    //   45	55	166	java/io/IOException
    //   57	68	166	java/io/IOException
    //   12	22	170	java/io/FileNotFoundException
    //   28	34	170	java/io/FileNotFoundException
    //   45	55	170	java/io/FileNotFoundException
    //   57	68	170	java/io/FileNotFoundException
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
          Object localObject = new File("/sys/devices/system/cpu/");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((File)localObject).exists())
            {
              localObject = ((File)localObject).listFiles(CPU_FILTER);
              j = i;
              if (localObject != null)
              {
                i = localObject.length;
                return i;
              }
            }
          }
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
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long getTotalMemory(Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 76
    //   3: lstore 4
    //   5: aload_0
    //   6: ifnonnull +7 -> 13
    //   9: ldc2_w 76
    //   12: lreturn
    //   13: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 16
    //   18: if_icmplt +38 -> 56
    //   21: new 89	android/app/ActivityManager$MemoryInfo
    //   24: dup
    //   25: invokespecial 90	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   28: astore 6
    //   30: aload_0
    //   31: ldc 79
    //   33: invokevirtual 85	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 87	android/app/ActivityManager
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +9 -> 50
    //   44: aload_0
    //   45: aload 6
    //   47: invokevirtual 94	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   50: aload 6
    //   52: getfield 324	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   55: lreturn
    //   56: lload 4
    //   58: lstore_2
    //   59: new 145	java/io/FileInputStream
    //   62: dup
    //   63: ldc_w 326
    //   66: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   69: astore_0
    //   70: ldc_w 328
    //   73: aload_0
    //   74: invokestatic 174	com/tencent/superplayer/utils/HardwareUtil:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   77: istore_1
    //   78: iload_1
    //   79: i2l
    //   80: ldc2_w 329
    //   83: lmul
    //   84: lstore 4
    //   86: lload 4
    //   88: lstore_2
    //   89: aload_0
    //   90: invokevirtual 165	java/io/FileInputStream:close	()V
    //   93: lload 4
    //   95: lreturn
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   101: lload_2
    //   102: lreturn
    //   103: astore 6
    //   105: lload 4
    //   107: lstore_2
    //   108: aload_0
    //   109: invokevirtual 165	java/io/FileInputStream:close	()V
    //   112: lload 4
    //   114: lstore_2
    //   115: aload 6
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   77	2	1	i	int
    //   58	57	2	l1	long
    //   3	110	4	l2	long
    //   28	23	6	localMemoryInfo	ActivityManager.MemoryInfo
    //   103	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	70	96	java/io/IOException
    //   89	93	96	java/io/IOException
    //   108	112	96	java/io/IOException
    //   115	118	96	java/io/IOException
    //   70	78	103	finally
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