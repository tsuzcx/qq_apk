package com.tencent.superplayer.utils;

import android.annotation.TargetApi;
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
    long l = -1L;
    if (paramContext == null) {
      return -1L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (paramContext != null)
    {
      paramContext.getMemoryInfo(localMemoryInfo);
      l = localMemoryInfo.availMem;
    }
    return l;
  }
  
  public static String getBrand()
  {
    return Build.BRAND;
  }
  
  /* Error */
  public static int getCPUMaxFreqKHz()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_m1
    //   3: istore_0
    //   4: iload_2
    //   5: invokestatic 112	com/tencent/superplayer/utils/HardwareUtil:getNumberOfCPUCores	()I
    //   8: if_icmpge +162 -> 170
    //   11: new 114	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 117
    //   22: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: iload_2
    //   28: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc 126
    //   35: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: new 128	java/io/File
    //   42: dup
    //   43: aload_3
    //   44: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: iload_0
    //   52: istore_1
    //   53: aload_3
    //   54: invokevirtual 138	java/io/File:exists	()Z
    //   57: ifeq +178 -> 235
    //   60: iload_0
    //   61: istore_1
    //   62: aload_3
    //   63: invokevirtual 141	java/io/File:canRead	()Z
    //   66: ifeq +169 -> 235
    //   69: sipush 128
    //   72: newarray byte
    //   74: astore 4
    //   76: new 143	java/io/FileInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: astore_3
    //   85: aload_3
    //   86: aload 4
    //   88: invokevirtual 150	java/io/FileInputStream:read	([B)I
    //   91: pop
    //   92: iconst_0
    //   93: istore_1
    //   94: aload 4
    //   96: iload_1
    //   97: baload
    //   98: invokestatic 60	java/lang/Character:isDigit	(I)Z
    //   101: ifeq +17 -> 118
    //   104: iload_1
    //   105: aload 4
    //   107: arraylength
    //   108: if_icmpge +10 -> 118
    //   111: iload_1
    //   112: iconst_1
    //   113: iadd
    //   114: istore_1
    //   115: goto -21 -> 94
    //   118: new 62	java/lang/String
    //   121: dup
    //   122: aload 4
    //   124: iconst_0
    //   125: iload_1
    //   126: invokespecial 153	java/lang/String:<init>	([BII)V
    //   129: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   132: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: astore 4
    //   137: iload_0
    //   138: istore_1
    //   139: aload 4
    //   141: invokevirtual 160	java/lang/Integer:intValue	()I
    //   144: iload_0
    //   145: if_icmple +9 -> 154
    //   148: aload 4
    //   150: invokevirtual 160	java/lang/Integer:intValue	()I
    //   153: istore_1
    //   154: aload_3
    //   155: invokevirtual 163	java/io/FileInputStream:close	()V
    //   158: goto +77 -> 235
    //   161: astore 4
    //   163: aload_3
    //   164: invokevirtual 163	java/io/FileInputStream:close	()V
    //   167: aload 4
    //   169: athrow
    //   170: iload_0
    //   171: iconst_m1
    //   172: if_icmpne +51 -> 223
    //   175: new 143	java/io/FileInputStream
    //   178: dup
    //   179: ldc 165
    //   181: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   184: astore_3
    //   185: ldc 168
    //   187: aload_3
    //   188: invokestatic 172	com/tencent/superplayer/utils/HardwareUtil:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   191: istore_1
    //   192: iload_1
    //   193: sipush 1000
    //   196: imul
    //   197: istore_1
    //   198: iload_1
    //   199: iload_0
    //   200: if_icmple +8 -> 208
    //   203: iload_1
    //   204: istore_0
    //   205: goto +3 -> 208
    //   208: aload_3
    //   209: invokevirtual 163	java/io/FileInputStream:close	()V
    //   212: iload_0
    //   213: ireturn
    //   214: astore 4
    //   216: aload_3
    //   217: invokevirtual 163	java/io/FileInputStream:close	()V
    //   220: aload 4
    //   222: athrow
    //   223: iload_0
    //   224: ireturn
    //   225: astore_3
    //   226: iconst_m1
    //   227: ireturn
    //   228: astore 4
    //   230: iload_0
    //   231: istore_1
    //   232: goto -78 -> 154
    //   235: iload_2
    //   236: iconst_1
    //   237: iadd
    //   238: istore_2
    //   239: iload_1
    //   240: istore_0
    //   241: goto -237 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	238	0	i	int
    //   52	188	1	j	int
    //   1	238	2	k	int
    //   18	199	3	localObject1	Object
    //   225	1	3	localIOException	IOException
    //   74	75	4	localObject2	Object
    //   161	7	4	localObject3	Object
    //   214	7	4	localObject4	Object
    //   228	1	4	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   85	92	161	finally
    //   94	111	161	finally
    //   118	137	161	finally
    //   139	154	161	finally
    //   185	192	214	finally
    //   4	51	225	java/io/IOException
    //   53	60	225	java/io/IOException
    //   62	85	225	java/io/IOException
    //   154	158	225	java/io/IOException
    //   163	170	225	java/io/IOException
    //   175	185	225	java/io/IOException
    //   208	212	225	java/io/IOException
    //   216	223	225	java/io/IOException
    //   85	92	228	java/lang/NumberFormatException
    //   94	111	228	java/lang/NumberFormatException
    //   118	137	228	java/lang/NumberFormatException
    //   139	154	228	java/lang/NumberFormatException
  }
  
  /* Error */
  private static int getCoresFromFileInfo(String paramString)
  {
    // Byte code:
    //   0: new 143	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 175	java/io/BufferedReader
    //   12: dup
    //   13: new 177	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 180	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_2
    //   31: invokevirtual 187	java/io/BufferedReader:close	()V
    //   34: aload_3
    //   35: invokestatic 190	com/tencent/superplayer/utils/HardwareUtil:getCoresFromFileString	(Ljava/lang/String;)I
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual 193	java/io/InputStream:close	()V
    //   43: iload_1
    //   44: ireturn
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_3
    //   49: astore_0
    //   50: goto +9 -> 59
    //   53: goto +18 -> 71
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 193	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 193	java/io/InputStream:close	()V
    //   79: iconst_m1
    //   80: ireturn
    //   81: astore_0
    //   82: goto -13 -> 69
    //   85: astore_2
    //   86: goto -33 -> 53
    //   89: astore_0
    //   90: iload_1
    //   91: ireturn
    //   92: astore_2
    //   93: goto -26 -> 67
    //   96: astore_0
    //   97: iconst_m1
    //   98: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   38	53	1	i	int
    //   24	40	2	localObject1	Object
    //   85	1	2	localIOException1	IOException
    //   92	1	2	localIOException2	IOException
    //   29	6	3	str	String
    //   45	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	39	45	finally
    //   0	9	56	finally
    //   0	9	81	java/io/IOException
    //   9	39	85	java/io/IOException
    //   39	43	89	java/io/IOException
    //   63	67	92	java/io/IOException
    //   75	79	96	java/io/IOException
  }
  
  private static int getCoresFromFileString(String paramString)
  {
    if ((paramString != null) && (paramString.matches("0-[\\d]+$"))) {
      return Integer.valueOf(paramString.substring(2)).intValue() + 1;
    }
    return -1;
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
    //   0: new 266	java/io/FileReader
    //   3: dup
    //   4: ldc 165
    //   6: invokespecial 267	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: astore_0
    //   12: new 175	java/io/BufferedReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 4
    //   22: ldc_w 269
    //   25: astore_2
    //   26: aload_1
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +8 -> 43
    //   38: aload_3
    //   39: astore_2
    //   40: goto -14 -> 26
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 271
    //   49: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +29 -> 81
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 277
    //   61: iconst_2
    //   62: invokevirtual 281	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   65: iconst_1
    //   66: aaload
    //   67: astore_2
    //   68: aload_1
    //   69: invokevirtual 282	java/io/FileReader:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: areturn
    //   81: aload_1
    //   82: invokevirtual 282	java/io/FileReader:close	()V
    //   85: goto +38 -> 123
    //   88: astore_2
    //   89: goto +12 -> 101
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: goto +37 -> 132
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: aload_2
    //   104: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +15 -> 123
    //   111: aload_1
    //   112: invokevirtual 282	java/io/FileReader:close	()V
    //   115: goto +8 -> 123
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   123: getstatic 288	android/os/Build:HARDWARE	Ljava/lang/String;
    //   126: areturn
    //   127: astore_2
    //   128: aload_0
    //   129: astore_1
    //   130: aload_2
    //   131: astore_0
    //   132: aload_1
    //   133: ifnull +15 -> 148
    //   136: aload_1
    //   137: invokevirtual 282	java/io/FileReader:close	()V
    //   140: goto +8 -> 148
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   148: goto +5 -> 153
    //   151: aload_0
    //   152: athrow
    //   153: goto -2 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	46	0	localObject1	Object
    //   74	2	0	localException1	java.lang.Exception
    //   92	1	0	localObject2	Object
    //   102	1	0	localObject3	Object
    //   118	11	0	localException2	java.lang.Exception
    //   131	21	0	localObject4	Object
    //   9	128	1	localObject5	Object
    //   143	2	1	localException3	java.lang.Exception
    //   25	55	2	localObject6	Object
    //   88	1	2	localException4	java.lang.Exception
    //   98	6	2	localException5	java.lang.Exception
    //   127	4	2	localObject7	Object
    //   33	6	3	str	String
    //   20	9	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   12	22	88	java/lang/Exception
    //   28	34	88	java/lang/Exception
    //   45	55	88	java/lang/Exception
    //   57	68	88	java/lang/Exception
    //   0	10	92	finally
    //   0	10	98	java/lang/Exception
    //   81	85	118	java/lang/Exception
    //   111	115	118	java/lang/Exception
    //   12	22	127	finally
    //   28	34	127	finally
    //   45	55	127	finally
    //   57	68	127	finally
    //   103	107	127	finally
    //   136	140	143	java/lang/Exception
  }
  
  public static String getModel()
  {
    return Build.MODEL;
  }
  
  public static int getNumberOfCPUCores()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int j = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
      int i = j;
      if (j == -1) {
        i = getCoresFromFileInfo("/sys/devices/system/cpu/present");
      }
      if (i == -1)
      {
        Object localObject = new File("/sys/devices/system/cpu/");
        if (((File)localObject).exists())
        {
          localObject = ((File)localObject).listFiles(CPU_FILTER);
          if (localObject != null)
          {
            i = localObject.length;
            return i;
          }
        }
      }
      return i;
    }
    catch (SecurityException|NullPointerException localSecurityException) {}
    return -1;
  }
  
  @TargetApi(16)
  public static long getTotalMemory(Context paramContext)
  {
    long l2 = -1L;
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
      return localMemoryInfo.totalMem;
    }
    l1 = l2;
    try
    {
      paramContext = new FileInputStream("/proc/meminfo");
      try
      {
        int i = parseFileForValue("MemTotal", paramContext);
        l2 = i * 1024L;
        l1 = l2;
        paramContext.close();
        return l2;
      }
      finally
      {
        l1 = l2;
        paramContext.close();
        l1 = l2;
      }
      return l1;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
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
    int i = -1;
    if (paramContext == null) {
      return -1;
    }
    int j = sCacheDeviceLevel;
    if (j != -1) {
      return j;
    }
    j = judgeMemory(paramContext);
    int k = judgeCPU();
    if ((j < 1) && (k == 0))
    {
      i = -2;
    }
    else if ((j >= 2) && (k != 0))
    {
      if ((j == 2) && (k >= 1)) {}
      do
      {
        i = 2;
        break;
        if (j <= 2) {
          break;
        }
      } while (k <= 1);
      i = 3;
    }
    else
    {
      i = 1;
    }
    sCacheDeviceLevel = i;
    return i;
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
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        LogUtil.e("HardwareUtil", "parseFileForValue failed.", paramString);
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      int k = i;
      if (j < m)
      {
        k = j - i;
        if (arrayOfByte[j] != paramString.charAt(k))
        {
          k = i;
        }
        else
        {
          if (k == paramString.length() - 1)
          {
            i = extractValue(arrayOfByte, j);
            return i;
          }
          j += 1;
          continue;
        }
      }
      int j = k + 1;
      if (j < m) {
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.HardwareUtil
 * JD-Core Version:    0.7.0.1
 */