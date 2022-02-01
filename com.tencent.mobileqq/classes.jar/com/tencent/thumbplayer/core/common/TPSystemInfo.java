package com.tencent.thumbplayer.core.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;

public class TPSystemInfo
{
  public static final int CHIP_ARM_AARCH64 = 7;
  public static final int CHIP_ARM_LATER = 50;
  public static final int CHIP_ARM_V5 = 3;
  public static final int CHIP_ARM_V6 = 4;
  public static final int CHIP_ARM_V7_NENO = 6;
  public static final int CHIP_ARM_V7_NO_NENO = 5;
  public static final int CHIP_MIPS = 2;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 1;
  public static final int CPU_HW_HISI = 2;
  public static final int CPU_HW_MTK = 1;
  public static final int CPU_HW_OTHER = -1;
  public static final int CPU_HW_QUALCOMM = 0;
  public static final int CPU_HW_SUMSUNG = 3;
  private static int cpuArch = -1;
  private static final String[][] cpuPerfList;
  private static long currentCpuFreq;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI = "";
  private static String deviceMacAddr;
  private static Method getWlanMethod;
  private static long mAppInstallTime;
  private static int mAudioBestFramesPerBust;
  private static int mAudioBestSampleRate;
  private static int mCpuArchitecture;
  private static int mCpuHWProductIdx;
  private static int mCpuHWProducter;
  private static String mCpuHardware;
  private static String mFeature;
  private static int mOpenGLVersion = 0;
  private static String mProcessorName = "N/A";
  public static int mScreenHeight;
  public static int mScreenWidth;
  private static long maxCpuFreq;
  private static int numOfCores;
  
  static
  {
    mFeature = "";
    mCpuHardware = "";
    mCpuArchitecture = 0;
    mCpuHWProducter = -1;
    mCpuHWProductIdx = -1;
    mAudioBestSampleRate = 0;
    mAudioBestFramesPerBust = 0;
    String[] arrayOfString1 = { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro", "MSM8998", "SDM845", "SM8150", "SM8250", "SM8350" };
    String[] arrayOfString2 = { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" };
    cpuPerfList = new String[][] { arrayOfString1, { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" }, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960", "Kirin970", "Kirin980", "Kirin990" }, arrayOfString2 };
    maxCpuFreq = -1L;
    currentCpuFreq = -1L;
    numOfCores = -1;
  }
  
  private static String _getDeviceMacAddr(Context paramContext)
  {
    String str = "";
    if (hasMarshmallow()) {
      paramContext = getWlanName();
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = NetworkInterface.getByName(paramContext);
        paramContext = str;
        if (localObject != null)
        {
          localObject = ((NetworkInterface)localObject).getHardwareAddress();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            str = Integer.toHexString(localObject[i] & 0xFF);
            paramContext = str;
            if (str.length() == 1) {
              paramContext = 0 + str;
            }
            localStringBuilder.append(paramContext);
            if (i == j - 1) {
              break label148;
            }
            localStringBuilder.append(":");
            break label148;
          }
          paramContext = localStringBuilder.toString().toUpperCase();
        }
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TPNativeLog.printLog(4, paramContext.getMessage());
        return "";
      }
      return getLowerMarshmallowDeviceMacAddr(paramContext);
      label148:
      i += 1;
    }
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    if (!hasMarshmallow()) {}
    for (;;)
    {
      return true;
      if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
        return false;
      }
      if ("android.permission.WRITE_SETTINGS".equals(paramString)) {
        return Settings.System.canWrite(paramContext);
      }
      try
      {
        int i = ContextCompat.checkSelfPermission(paramContext, paramString);
        if (i != 0) {
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static int getBestAudioFramesPerBust()
  {
    return mAudioBestFramesPerBust;
  }
  
  public static int getBestAudioSampleRate()
  {
    return mAudioBestSampleRate;
  }
  
  public static int getCpuArchFromId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 5: 
      return 3;
    case 6: 
      return 4;
    case 7: 
      return 6;
    case 8: 
    case 9: 
    case 10: 
      return 50;
    }
    return 7;
  }
  
  public static int getCpuArchitecture()
  {
    if (-1 != cpuArch) {
      return cpuArch;
    }
    if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI.contains("X86")))) {
      cpuArch = 1;
    }
    for (;;)
    {
      return cpuArch;
      if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("mips")) || (Build.CPU_ABI.contains("Mips"))))
      {
        cpuArch = 2;
      }
      else
      {
        if (mCpuArchitecture == 0) {
          getCpuInfo();
        }
        TPNativeLog.printLog(2, "getCpuArchitecture mCpuArchitecture:" + mCpuArchitecture);
        if ((!TextUtils.isEmpty(mCpuHardware)) && (mCpuHardware.contains("MSM8994")))
        {
          cpuArch = 7;
          return cpuArch;
        }
        if (isARMV5Whitelist())
        {
          cpuArch = 3;
          return cpuArch;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("ARMv6")))
        {
          cpuArch = 4;
          return cpuArch;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("AArch64")))
        {
          cpuArch = 7;
          return cpuArch;
        }
        if ((mCpuArchitecture == 7) && (!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon")))
        {
          cpuArch = 4;
          return cpuArch;
        }
        cpuArch = getCpuArchFromId(mCpuArchitecture);
      }
    }
  }
  
  private static int getCpuHWProducer(String paramString)
  {
    if (paramString.isEmpty()) {}
    do
    {
      return -1;
      if ((paramString.contains("Exynos")) || (paramString.contains("SMDK")) || (paramString.contains("S5L8900")) || (paramString.contains("S5PC100"))) {
        return 3;
      }
      if ((paramString.contains("Kirin")) || (paramString.contains("K3V"))) {
        return 2;
      }
      if ((paramString.contains("MSM")) || (paramString.contains("APQ")) || (paramString.contains("QSD")) || (paramString.contains("SDM")) || (paramString.contains("SM"))) {
        return 0;
      }
    } while (!paramString.contains("MT6"));
    return 1;
  }
  
  public static int getCpuHWProductIndex(String paramString)
  {
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    if ((mCpuHWProducter >= 0) && (mCpuHWProductIdx < 0))
    {
      String[] arrayOfString = cpuPerfList[mCpuHWProducter];
      int i = 0;
      int k = -1;
      if (i < arrayOfString.length)
      {
        int j = k;
        if (paramString.contains(arrayOfString[i]))
        {
          if (-1 != k) {
            break label74;
          }
          j = i;
        }
        for (;;)
        {
          i += 1;
          k = j;
          break;
          label74:
          j = k;
          if (arrayOfString[i].length() > arrayOfString[k].length()) {
            j = i;
          }
        }
      }
      mCpuHWProductIdx = k;
    }
    return mCpuHWProductIdx;
  }
  
  public static int getCpuHWProducter(String paramString)
  {
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    return mCpuHWProducter;
  }
  
  public static String getCpuHarewareName()
  {
    if (TextUtils.isEmpty(mCpuHardware)) {
      getCpuInfo();
    }
    return mCpuHardware;
  }
  
  /* Error */
  public static void getCpuInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 513	java/io/InputStreamReader
    //   7: dup
    //   8: new 515	java/io/FileInputStream
    //   11: dup
    //   12: ldc_w 517
    //   15: invokespecial 520	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: ldc_w 522
    //   21: invokespecial 525	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: astore_1
    //   25: new 527	java/io/BufferedReader
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +20 -> 60
    //   43: aload_1
    //   44: ifnull +7 -> 51
    //   47: aload_1
    //   48: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 537	java/io/BufferedReader:close	()V
    //   59: return
    //   60: aload_2
    //   61: invokestatic 540	com/tencent/thumbplayer/core/common/TPSystemInfo:parseCpuInfoLine	(Ljava/lang/String;)V
    //   64: goto -30 -> 34
    //   67: astore_2
    //   68: ldc_w 542
    //   71: putstatic 67	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuHardware	Ljava/lang/String;
    //   74: iconst_0
    //   75: putstatic 69	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuArchitecture	I
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   86: aload_0
    //   87: ifnull -28 -> 59
    //   90: aload_0
    //   91: invokevirtual 537	java/io/BufferedReader:close	()V
    //   94: return
    //   95: astore_0
    //   96: iconst_4
    //   97: aload_0
    //   98: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   101: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   104: return
    //   105: astore_0
    //   106: iconst_4
    //   107: aload_0
    //   108: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   111: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   114: return
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 537	java/io/BufferedReader:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: iconst_4
    //   138: aload_1
    //   139: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   142: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   145: goto -11 -> 134
    //   148: astore_0
    //   149: goto -31 -> 118
    //   152: astore_3
    //   153: aload_0
    //   154: astore_2
    //   155: aload_3
    //   156: astore_0
    //   157: goto -39 -> 118
    //   160: astore_3
    //   161: aload_0
    //   162: astore_2
    //   163: aload_3
    //   164: astore_0
    //   165: goto -47 -> 118
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_3
    //   172: astore_1
    //   173: goto -105 -> 68
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_0
    //   179: goto -111 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	58	0	localBufferedReader	java.io.BufferedReader
    //   95	3	0	localIOException1	IOException
    //   105	3	0	localIOException2	IOException
    //   115	20	0	localObject1	Object
    //   148	6	0	localObject2	Object
    //   156	9	0	localObject3	Object
    //   168	1	0	localThrowable1	Throwable
    //   170	1	0	localObject4	Object
    //   176	1	0	localThrowable2	Throwable
    //   178	1	0	localObject5	Object
    //   24	99	1	localInputStreamReader	java.io.InputStreamReader
    //   136	3	1	localIOException3	IOException
    //   172	1	1	localObject6	Object
    //   1	60	2	str	String
    //   67	64	2	localThrowable3	Throwable
    //   154	9	2	localObject7	Object
    //   3	1	3	localObject8	Object
    //   152	4	3	localObject9	Object
    //   160	12	3	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	67	java/lang/Throwable
    //   60	64	67	java/lang/Throwable
    //   82	86	95	java/io/IOException
    //   90	94	95	java/io/IOException
    //   47	51	105	java/io/IOException
    //   55	59	105	java/io/IOException
    //   4	25	115	finally
    //   122	126	136	java/io/IOException
    //   130	134	136	java/io/IOException
    //   25	34	148	finally
    //   34	39	152	finally
    //   60	64	152	finally
    //   68	78	160	finally
    //   4	25	168	java/lang/Throwable
    //   25	34	176	java/lang/Throwable
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: getstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +9 -> 14
    //   8: getstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   11: lstore_2
    //   12: lload_2
    //   13: lreturn
    //   14: new 513	java/io/InputStreamReader
    //   17: dup
    //   18: new 515	java/io/FileInputStream
    //   21: dup
    //   22: ldc_w 549
    //   25: invokespecial 520	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   28: ldc_w 522
    //   31: invokespecial 525	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: astore 4
    //   36: new 527	java/io/BufferedReader
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore 7
    //   47: aload 7
    //   49: astore 6
    //   51: aload 4
    //   53: astore 5
    //   55: aload 7
    //   57: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload 8
    //   64: ifnonnull +64 -> 128
    //   67: aload 7
    //   69: astore 6
    //   71: aload 4
    //   73: astore 5
    //   75: aload 4
    //   77: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   80: aload 7
    //   82: astore 6
    //   84: aload 4
    //   86: astore 5
    //   88: aload 7
    //   90: invokevirtual 537	java/io/BufferedReader:close	()V
    //   93: aload 4
    //   95: ifnull +8 -> 103
    //   98: aload 4
    //   100: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   103: aload 7
    //   105: ifnull +8 -> 113
    //   108: aload 7
    //   110: invokevirtual 537	java/io/BufferedReader:close	()V
    //   113: lconst_0
    //   114: lreturn
    //   115: astore 4
    //   117: iconst_4
    //   118: aload 4
    //   120: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   123: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   126: lconst_0
    //   127: lreturn
    //   128: aload 7
    //   130: astore 6
    //   132: aload 4
    //   134: astore 5
    //   136: aload 8
    //   138: invokevirtual 552	java/lang/String:trim	()Ljava/lang/String;
    //   141: astore 8
    //   143: aload 7
    //   145: astore 6
    //   147: aload 4
    //   149: astore 5
    //   151: aload 8
    //   153: invokevirtual 382	java/lang/String:length	()I
    //   156: ifle +495 -> 651
    //   159: aload 7
    //   161: astore 6
    //   163: aload 4
    //   165: astore 5
    //   167: aload 8
    //   169: invokestatic 558	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   172: lstore_0
    //   173: aload 7
    //   175: astore 6
    //   177: aload 4
    //   179: astore 5
    //   181: lload_0
    //   182: putstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   195: lload_0
    //   196: lstore_2
    //   197: aload 7
    //   199: ifnull -187 -> 12
    //   202: aload 7
    //   204: invokevirtual 537	java/io/BufferedReader:close	()V
    //   207: lload_0
    //   208: lreturn
    //   209: astore 4
    //   211: iconst_4
    //   212: aload 4
    //   214: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   217: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   220: lconst_0
    //   221: lreturn
    //   222: astore 8
    //   224: aconst_null
    //   225: astore 7
    //   227: aconst_null
    //   228: astore 4
    //   230: ldc2_w 559
    //   233: lstore_0
    //   234: aload 7
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: iconst_4
    //   243: aload 8
    //   245: invokevirtual 561	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   248: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   251: aload 4
    //   253: ifnull +8 -> 261
    //   256: aload 4
    //   258: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   261: lload_0
    //   262: lstore_2
    //   263: aload 7
    //   265: ifnull -253 -> 12
    //   268: aload 7
    //   270: invokevirtual 537	java/io/BufferedReader:close	()V
    //   273: lload_0
    //   274: lreturn
    //   275: astore 4
    //   277: iconst_4
    //   278: aload 4
    //   280: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   283: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   286: lconst_0
    //   287: lreturn
    //   288: astore 8
    //   290: aconst_null
    //   291: astore 7
    //   293: aconst_null
    //   294: astore 4
    //   296: ldc2_w 559
    //   299: lstore_0
    //   300: aload 7
    //   302: astore 6
    //   304: aload 4
    //   306: astore 5
    //   308: iconst_4
    //   309: aload 8
    //   311: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   314: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   327: lload_0
    //   328: lstore_2
    //   329: aload 7
    //   331: ifnull -319 -> 12
    //   334: aload 7
    //   336: invokevirtual 537	java/io/BufferedReader:close	()V
    //   339: lload_0
    //   340: lreturn
    //   341: astore 4
    //   343: iconst_4
    //   344: aload 4
    //   346: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   349: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   352: lconst_0
    //   353: lreturn
    //   354: astore 8
    //   356: aconst_null
    //   357: astore 7
    //   359: aconst_null
    //   360: astore 4
    //   362: ldc2_w 559
    //   365: lstore_0
    //   366: aload 7
    //   368: astore 6
    //   370: aload 4
    //   372: astore 5
    //   374: iconst_4
    //   375: aload 8
    //   377: invokevirtual 562	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   380: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   393: lload_0
    //   394: lstore_2
    //   395: aload 7
    //   397: ifnull -385 -> 12
    //   400: aload 7
    //   402: invokevirtual 537	java/io/BufferedReader:close	()V
    //   405: lload_0
    //   406: lreturn
    //   407: astore 4
    //   409: iconst_4
    //   410: aload 4
    //   412: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   415: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   418: lconst_0
    //   419: lreturn
    //   420: astore 8
    //   422: aconst_null
    //   423: astore 7
    //   425: aconst_null
    //   426: astore 4
    //   428: ldc2_w 559
    //   431: lstore_0
    //   432: aload 7
    //   434: astore 6
    //   436: aload 4
    //   438: astore 5
    //   440: iconst_4
    //   441: aload 8
    //   443: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   446: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   449: aload 4
    //   451: ifnull +8 -> 459
    //   454: aload 4
    //   456: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   459: lload_0
    //   460: lstore_2
    //   461: aload 7
    //   463: ifnull -451 -> 12
    //   466: aload 7
    //   468: invokevirtual 537	java/io/BufferedReader:close	()V
    //   471: lload_0
    //   472: lreturn
    //   473: astore 4
    //   475: iconst_4
    //   476: aload 4
    //   478: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   481: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   484: lconst_0
    //   485: lreturn
    //   486: astore 7
    //   488: aconst_null
    //   489: astore 6
    //   491: aconst_null
    //   492: astore 4
    //   494: aload 4
    //   496: ifnull +8 -> 504
    //   499: aload 4
    //   501: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   504: aload 6
    //   506: ifnull +8 -> 514
    //   509: aload 6
    //   511: invokevirtual 537	java/io/BufferedReader:close	()V
    //   514: aload 7
    //   516: athrow
    //   517: astore 4
    //   519: iconst_4
    //   520: aload 4
    //   522: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   525: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   528: lconst_0
    //   529: lreturn
    //   530: astore 7
    //   532: aconst_null
    //   533: astore 6
    //   535: goto -41 -> 494
    //   538: astore 7
    //   540: aload 5
    //   542: astore 4
    //   544: goto -50 -> 494
    //   547: astore 8
    //   549: aconst_null
    //   550: astore 7
    //   552: ldc2_w 559
    //   555: lstore_0
    //   556: goto -124 -> 432
    //   559: astore 8
    //   561: ldc2_w 559
    //   564: lstore_0
    //   565: goto -133 -> 432
    //   568: astore 8
    //   570: goto -138 -> 432
    //   573: astore 8
    //   575: aconst_null
    //   576: astore 7
    //   578: ldc2_w 559
    //   581: lstore_0
    //   582: goto -216 -> 366
    //   585: astore 8
    //   587: ldc2_w 559
    //   590: lstore_0
    //   591: goto -225 -> 366
    //   594: astore 8
    //   596: goto -230 -> 366
    //   599: astore 8
    //   601: aconst_null
    //   602: astore 7
    //   604: ldc2_w 559
    //   607: lstore_0
    //   608: goto -308 -> 300
    //   611: astore 8
    //   613: ldc2_w 559
    //   616: lstore_0
    //   617: goto -317 -> 300
    //   620: astore 8
    //   622: goto -322 -> 300
    //   625: astore 8
    //   627: aconst_null
    //   628: astore 7
    //   630: ldc2_w 559
    //   633: lstore_0
    //   634: goto -400 -> 234
    //   637: astore 8
    //   639: ldc2_w 559
    //   642: lstore_0
    //   643: goto -409 -> 234
    //   646: astore 8
    //   648: goto -414 -> 234
    //   651: ldc2_w 559
    //   654: lstore_0
    //   655: goto -482 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   172	483	0	l1	long
    //   11	450	2	l2	long
    //   34	65	4	localInputStreamReader	java.io.InputStreamReader
    //   115	76	4	localThrowable1	Throwable
    //   209	4	4	localThrowable2	Throwable
    //   228	29	4	localObject1	Object
    //   275	4	4	localThrowable3	Throwable
    //   294	29	4	localObject2	Object
    //   341	4	4	localThrowable4	Throwable
    //   360	29	4	localObject3	Object
    //   407	4	4	localThrowable5	Throwable
    //   426	29	4	localObject4	Object
    //   473	4	4	localThrowable6	Throwable
    //   492	8	4	localObject5	Object
    //   517	4	4	localThrowable7	Throwable
    //   542	1	4	localObject6	Object
    //   53	488	5	localObject7	Object
    //   49	485	6	localBufferedReader1	java.io.BufferedReader
    //   45	422	7	localBufferedReader2	java.io.BufferedReader
    //   486	29	7	localObject8	Object
    //   530	1	7	localObject9	Object
    //   538	1	7	localObject10	Object
    //   550	79	7	localObject11	Object
    //   60	108	8	str	String
    //   222	22	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   288	22	8	localIOException1	IOException
    //   354	22	8	localException1	Exception
    //   420	22	8	localThrowable8	Throwable
    //   547	1	8	localThrowable9	Throwable
    //   559	1	8	localThrowable10	Throwable
    //   568	1	8	localThrowable11	Throwable
    //   573	1	8	localException2	Exception
    //   585	1	8	localException3	Exception
    //   594	1	8	localException4	Exception
    //   599	1	8	localIOException2	IOException
    //   611	1	8	localIOException3	IOException
    //   620	1	8	localIOException4	IOException
    //   625	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   637	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   646	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   98	103	115	java/lang/Throwable
    //   108	113	115	java/lang/Throwable
    //   190	195	209	java/lang/Throwable
    //   202	207	209	java/lang/Throwable
    //   14	36	222	java/io/FileNotFoundException
    //   256	261	275	java/lang/Throwable
    //   268	273	275	java/lang/Throwable
    //   14	36	288	java/io/IOException
    //   322	327	341	java/lang/Throwable
    //   334	339	341	java/lang/Throwable
    //   14	36	354	java/lang/Exception
    //   388	393	407	java/lang/Throwable
    //   400	405	407	java/lang/Throwable
    //   14	36	420	java/lang/Throwable
    //   454	459	473	java/lang/Throwable
    //   466	471	473	java/lang/Throwable
    //   14	36	486	finally
    //   499	504	517	java/lang/Throwable
    //   509	514	517	java/lang/Throwable
    //   36	47	530	finally
    //   55	62	538	finally
    //   75	80	538	finally
    //   88	93	538	finally
    //   136	143	538	finally
    //   151	159	538	finally
    //   167	173	538	finally
    //   181	185	538	finally
    //   242	251	538	finally
    //   308	317	538	finally
    //   374	383	538	finally
    //   440	449	538	finally
    //   36	47	547	java/lang/Throwable
    //   55	62	559	java/lang/Throwable
    //   75	80	559	java/lang/Throwable
    //   88	93	559	java/lang/Throwable
    //   136	143	559	java/lang/Throwable
    //   151	159	559	java/lang/Throwable
    //   167	173	559	java/lang/Throwable
    //   181	185	568	java/lang/Throwable
    //   36	47	573	java/lang/Exception
    //   55	62	585	java/lang/Exception
    //   75	80	585	java/lang/Exception
    //   88	93	585	java/lang/Exception
    //   136	143	585	java/lang/Exception
    //   151	159	585	java/lang/Exception
    //   167	173	585	java/lang/Exception
    //   181	185	594	java/lang/Exception
    //   36	47	599	java/io/IOException
    //   55	62	611	java/io/IOException
    //   75	80	611	java/io/IOException
    //   88	93	611	java/io/IOException
    //   136	143	611	java/io/IOException
    //   151	159	611	java/io/IOException
    //   167	173	611	java/io/IOException
    //   181	185	620	java/io/IOException
    //   36	47	625	java/io/FileNotFoundException
    //   55	62	637	java/io/FileNotFoundException
    //   75	80	637	java/io/FileNotFoundException
    //   88	93	637	java/io/FileNotFoundException
    //   136	143	637	java/io/FileNotFoundException
    //   151	159	637	java/io/FileNotFoundException
    //   167	173	637	java/io/FileNotFoundException
    //   181	185	646	java/io/FileNotFoundException
  }
  
  public static String getDeviceID(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceID)) {
      return deviceID;
    }
    if (paramContext == null) {
      return "";
    }
    try
    {
      deviceID = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      if (TextUtils.isEmpty(deviceID)) {
        deviceID = "NONE";
      }
      return deviceID;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        deviceID = "NONE";
      }
    }
  }
  
  public static String getDeviceIMEI(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceIMEI)) {
      return deviceIMEI;
    }
    if (paramContext == null) {
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMEI = "NONE";
      return deviceIMEI;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        deviceIMEI = paramContext.getDeviceId();
        if (TextUtils.isEmpty(deviceIMEI)) {
          deviceIMEI = "NONE";
        }
        paramContext = deviceIMEI;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      deviceIMEI = "NONE";
    }
    return "NONE";
  }
  
  public static String getDeviceIMSI(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceIMSI)) {
      return deviceIMSI;
    }
    if (paramContext == null) {
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMSI = "NONE";
      return deviceIMSI;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        deviceIMSI = paramContext.getSubscriberId();
        if (deviceIMSI == null) {
          deviceIMSI = "";
        }
        paramContext = deviceIMSI;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      return "";
    }
    return "";
  }
  
  public static String getDeviceMacAddr(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceMacAddr)) {
      return deviceMacAddr;
    }
    if (paramContext == null) {
      return "";
    }
    deviceMacAddr = _getDeviceMacAddr(paramContext);
    if (TextUtils.isEmpty(deviceMacAddr)) {
      deviceMacAddr = "NONE";
    }
    return deviceMacAddr;
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  private static String getLowerMarshmallowDeviceMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, paramContext.getMessage());
    }
    return "";
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: lconst_0
    //   10: lstore_0
    //   11: ldc2_w 330
    //   14: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   17: lcmp
    //   18: ifeq +9 -> 27
    //   21: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   24: lstore_0
    //   25: lload_0
    //   26: lreturn
    //   27: new 513	java/io/InputStreamReader
    //   30: dup
    //   31: new 515	java/io/FileInputStream
    //   34: dup
    //   35: ldc_w 630
    //   38: invokespecial 520	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   41: ldc_w 522
    //   44: invokespecial 525	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: astore 6
    //   49: new 527	java/io/BufferedReader
    //   52: dup
    //   53: aload 6
    //   55: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 533	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 8
    //   67: aload 8
    //   69: ifnonnull +48 -> 117
    //   72: aload 6
    //   74: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   77: aload 7
    //   79: invokevirtual 537	java/io/BufferedReader:close	()V
    //   82: aload 6
    //   84: ifnull +8 -> 92
    //   87: aload 6
    //   89: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   92: aload 7
    //   94: ifnull -69 -> 25
    //   97: aload 7
    //   99: invokevirtual 537	java/io/BufferedReader:close	()V
    //   102: lconst_0
    //   103: lreturn
    //   104: astore 6
    //   106: iconst_4
    //   107: aload 6
    //   109: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   112: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   115: lconst_0
    //   116: lreturn
    //   117: aload 8
    //   119: invokevirtual 552	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore 8
    //   124: lload_0
    //   125: lstore_2
    //   126: aload 8
    //   128: invokevirtual 382	java/lang/String:length	()I
    //   131: ifle +9 -> 140
    //   134: aload 8
    //   136: invokestatic 558	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore_2
    //   140: aload 6
    //   142: ifnull +8 -> 150
    //   145: aload 6
    //   147: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   150: lload_2
    //   151: lstore 4
    //   153: aload 7
    //   155: ifnull +11 -> 166
    //   158: aload 7
    //   160: invokevirtual 537	java/io/BufferedReader:close	()V
    //   163: lload_2
    //   164: lstore 4
    //   166: lload 4
    //   168: putstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   171: iconst_2
    //   172: new 371	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 632
    //   182: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   188: invokevirtual 635	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   197: lload 4
    //   199: lreturn
    //   200: astore 6
    //   202: iconst_4
    //   203: aload 6
    //   205: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   208: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   211: lload_2
    //   212: lstore 4
    //   214: goto -48 -> 166
    //   217: astore 6
    //   219: aconst_null
    //   220: astore 8
    //   222: aload 7
    //   224: astore 6
    //   226: aload 8
    //   228: astore 7
    //   230: aload 6
    //   232: ifnull +8 -> 240
    //   235: aload 6
    //   237: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   240: lload_0
    //   241: lstore 4
    //   243: aload 7
    //   245: ifnull -79 -> 166
    //   248: aload 7
    //   250: invokevirtual 537	java/io/BufferedReader:close	()V
    //   253: lload_0
    //   254: lstore 4
    //   256: goto -90 -> 166
    //   259: astore 6
    //   261: iconst_4
    //   262: aload 6
    //   264: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   267: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   270: lload_0
    //   271: lstore 4
    //   273: goto -107 -> 166
    //   276: astore 6
    //   278: aconst_null
    //   279: astore 6
    //   281: aload 9
    //   283: astore 7
    //   285: aload 6
    //   287: ifnull +8 -> 295
    //   290: aload 6
    //   292: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   295: lload_0
    //   296: lstore 4
    //   298: aload 7
    //   300: ifnull -134 -> 166
    //   303: aload 7
    //   305: invokevirtual 537	java/io/BufferedReader:close	()V
    //   308: lload_0
    //   309: lstore 4
    //   311: goto -145 -> 166
    //   314: astore 6
    //   316: iconst_4
    //   317: aload 6
    //   319: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   322: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   325: lload_0
    //   326: lstore 4
    //   328: goto -162 -> 166
    //   331: astore 7
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 6
    //   338: ifnull +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 536	java/io/InputStreamReader:close	()V
    //   346: aload 8
    //   348: ifnull +8 -> 356
    //   351: aload 8
    //   353: invokevirtual 537	java/io/BufferedReader:close	()V
    //   356: aload 7
    //   358: athrow
    //   359: astore 6
    //   361: iconst_4
    //   362: aload 6
    //   364: invokevirtual 543	java/io/IOException:getMessage	()Ljava/lang/String;
    //   367: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   370: goto -14 -> 356
    //   373: astore 7
    //   375: goto -39 -> 336
    //   378: astore 9
    //   380: aload 7
    //   382: astore 8
    //   384: aload 9
    //   386: astore 7
    //   388: goto -52 -> 336
    //   391: astore 7
    //   393: aload 9
    //   395: astore 7
    //   397: goto -112 -> 285
    //   400: astore 8
    //   402: goto -117 -> 285
    //   405: astore 7
    //   407: aconst_null
    //   408: astore 7
    //   410: goto -180 -> 230
    //   413: astore 8
    //   415: goto -185 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	316	0	l1	long
    //   125	87	2	l2	long
    //   151	176	4	l3	long
    //   47	41	6	localInputStreamReader	java.io.InputStreamReader
    //   104	42	6	localIOException1	IOException
    //   200	4	6	localIOException2	IOException
    //   217	1	6	localIOException3	IOException
    //   224	12	6	localObject1	Object
    //   259	4	6	localIOException4	IOException
    //   276	1	6	localThrowable1	Throwable
    //   279	12	6	localObject2	Object
    //   314	4	6	localIOException5	IOException
    //   334	8	6	localObject3	Object
    //   359	4	6	localIOException6	IOException
    //   7	297	7	localObject4	Object
    //   331	26	7	localObject5	Object
    //   373	8	7	localObject6	Object
    //   386	1	7	localObject7	Object
    //   391	1	7	localThrowable2	Throwable
    //   395	1	7	localObject8	Object
    //   405	1	7	localIOException7	IOException
    //   408	1	7	localObject9	Object
    //   4	379	8	localObject10	Object
    //   400	1	8	localThrowable3	Throwable
    //   413	1	8	localIOException8	IOException
    //   1	281	9	localObject11	Object
    //   378	16	9	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	104	java/io/IOException
    //   97	102	104	java/io/IOException
    //   145	150	200	java/io/IOException
    //   158	163	200	java/io/IOException
    //   27	49	217	java/io/IOException
    //   235	240	259	java/io/IOException
    //   248	253	259	java/io/IOException
    //   27	49	276	java/lang/Throwable
    //   290	295	314	java/io/IOException
    //   303	308	314	java/io/IOException
    //   27	49	331	finally
    //   341	346	359	java/io/IOException
    //   351	356	359	java/io/IOException
    //   49	60	373	finally
    //   60	67	378	finally
    //   72	82	378	finally
    //   117	124	378	finally
    //   126	140	378	finally
    //   49	60	391	java/lang/Throwable
    //   60	67	400	java/lang/Throwable
    //   72	82	400	java/lang/Throwable
    //   117	124	400	java/lang/Throwable
    //   126	140	400	java/lang/Throwable
    //   49	60	405	java/io/IOException
    //   60	67	413	java/io/IOException
    //   72	82	413	java/io/IOException
    //   117	124	413	java/io/IOException
    //   126	140	413	java/io/IOException
  }
  
  public static int getNumCores()
  {
    if (-1 != numOfCores) {
      return numOfCores;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new TPSystemInfo.1CpuFilter());
      if (arrayOfFile == null)
      {
        numOfCores = 1;
        return numOfCores;
      }
      numOfCores = arrayOfFile.length;
      TPNativeLog.printLog(2, "core num " + numOfCores);
      int i = numOfCores;
      return i;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, localException.getMessage());
      numOfCores = 1;
    }
    return 1;
  }
  
  public static int getOpenGLSupportVersion(Context paramContext)
  {
    if (mOpenGLVersion == 0) {}
    try
    {
      paramContext = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      if (paramContext == null) {
        return mOpenGLVersion;
      }
      mOpenGLVersion = paramContext.getDeviceConfigurationInfo().reqGlEsVersion;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, paramContext.getMessage());
      }
    }
    return mOpenGLVersion;
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    if (mScreenHeight != 0) {
      return mScreenHeight;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      return mScreenHeight;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        mScreenHeight = 0;
      }
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    if (mScreenWidth != 0) {
      return mScreenWidth;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      return mScreenWidth;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        mScreenWidth = 0;
      }
    }
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    f2 = -1.0F;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    try
    {
      paramString1 = paramString1.trim().split("\\s+");
      long l1 = getSystemIdleTime(paramString1);
      long l2 = getSystemUptime(paramString1);
      paramString1 = paramString2.trim().split("\\s+");
      long l3 = getSystemIdleTime(paramString1);
      long l4 = getSystemUptime(paramString1);
      f1 = f2;
      if (l1 >= 0L)
      {
        f1 = f2;
        if (l2 >= 0L)
        {
          f1 = f2;
          if (l3 >= 0L)
          {
            f1 = f2;
            if (l4 >= 0L)
            {
              f1 = f2;
              if (l4 + l3 > l2 + l1)
              {
                f1 = f2;
                if (l4 >= l2) {
                  f1 = (float)(l4 - l2) / (float)(l3 + l4 - (l1 + l2)) * 100.0F;
                }
              }
            }
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, paramString1.getMessage());
        float f1 = f2;
      }
    }
    return (int)f1;
  }
  
  public static long getSystemIdleTime(String[] paramArrayOfString)
  {
    try
    {
      long l = Long.parseLong(paramArrayOfString[4]);
      return l;
    }
    catch (Throwable paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return -1L;
  }
  
  public static long getSystemUptime(String[] paramArrayOfString)
  {
    long l1 = 0L;
    int i = 1;
    long l2;
    for (;;)
    {
      l2 = l1;
      if (i < paramArrayOfString.length)
      {
        l2 = l1;
        if (4 != i) {}
        try
        {
          l2 = Long.parseLong(paramArrayOfString[i]);
          l2 = l1 + l2;
          i += 1;
          l1 = l2;
        }
        catch (Throwable paramArrayOfString)
        {
          l2 = -1L;
        }
      }
    }
    return l2;
  }
  
  private static String getWlanName()
  {
    try
    {
      if (getWlanMethod == null) {
        getWlanMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class });
      }
      String str = (String)getWlanMethod.invoke(null, new Object[] { "wifi.interface", "wlan0" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return "wlan0";
  }
  
  private static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  /* Error */
  public static void initAudioBestSettings(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +11 -> 15
    //   7: getstatic 75	com/tencent/thumbplayer/core/common/TPSystemInfo:mAudioBestSampleRate	I
    //   10: istore_1
    //   11: iload_1
    //   12: ifle +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: getstatic 443	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 17
    //   24: if_icmplt -9 -> 15
    //   27: aload_0
    //   28: ldc_w 745
    //   31: invokevirtual 592	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 747	android/media/AudioManager
    //   37: astore_2
    //   38: aload_2
    //   39: ldc_w 749
    //   42: invokevirtual 753	android/media/AudioManager:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_0
    //   46: aload_2
    //   47: ldc_w 755
    //   50: invokevirtual 753	android/media/AudioManager:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore_2
    //   54: aload_0
    //   55: invokestatic 758	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: putstatic 75	com/tencent/thumbplayer/core/common/TPSystemInfo:mAudioBestSampleRate	I
    //   61: aload_2
    //   62: invokestatic 758	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: putstatic 77	com/tencent/thumbplayer/core/common/TPSystemInfo:mAudioBestFramesPerBust	I
    //   68: goto -53 -> 15
    //   71: astore_0
    //   72: iconst_4
    //   73: aload_0
    //   74: invokevirtual 759	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   77: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   80: goto -65 -> 15
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	Context
    //   10	2	1	i	int
    //   37	25	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	68	71	java/lang/NumberFormatException
    //   7	11	83	finally
    //   19	54	83	finally
    //   54	68	83	finally
    //   72	80	83	finally
  }
  
  public static boolean isARMV5Whitelist()
  {
    return (getDeviceName().equals("XT882")) || (getDeviceName().equals("ME860")) || (getDeviceName().equals("MB860")) || (getDeviceName().equals("Lenovo P70")) || (getDeviceName().equals("Lenovo A60")) || (getDeviceName().equals("Lenovo A366t"));
  }
  
  private static void parseCpuInfoLine(String paramString)
  {
    if ((paramString.contains("aarch64")) || (paramString.contains("AArch64"))) {
      mCpuArchitecture = 64;
    }
    int i;
    if (paramString.startsWith("Processor"))
    {
      i = paramString.indexOf(':');
      if (i > 1)
      {
        mProcessorName = paramString.substring(i + 1, paramString.length());
        mProcessorName = mProcessorName.trim();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramString.startsWith("CPU architecture")) {
                  break;
                }
              } while (mCpuArchitecture != 0);
              i = paramString.indexOf(':');
            } while (i <= 1);
            paramString = paramString.substring(i + 1, paramString.length()).trim();
            if ((paramString.length() > 0) && (paramString.length() < 2))
            {
              mCpuArchitecture = (int)Long.parseLong(paramString);
              return;
            }
          } while (paramString.length() <= 1);
          mCpuArchitecture = (int)Long.parseLong(paramString.substring(0, 1));
          return;
          if (!paramString.startsWith("Features")) {
            break;
          }
          i = paramString.indexOf(':');
        } while (i <= 1);
        mFeature = paramString.substring(i + 1, paramString.length()).trim();
        return;
      } while (!paramString.startsWith("Hardware"));
      i = paramString.indexOf(':');
    } while (i <= 1);
    mCpuHardware = paramString.substring(i + 1, paramString.length()).trim().replace(" ", "");
    TPNativeLog.printLog(2, "hardware " + mCpuHardware);
    getCpuHWProductIndex(mCpuHardware);
  }
  
  /* Error */
  private static String readStringFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 527	java/io/BufferedReader
    //   9: dup
    //   10: new 808	java/io/FileReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 811	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   18: invokespecial 530	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_0
    //   26: invokevirtual 813	java/io/File:length	()J
    //   29: lstore_1
    //   30: lload_1
    //   31: ldc2_w 814
    //   34: lcmp
    //   35: ifle +22 -> 57
    //   38: aload 5
    //   40: astore 4
    //   42: aload_3
    //   43: ifnull +11 -> 54
    //   46: aload_3
    //   47: invokevirtual 537	java/io/BufferedReader:close	()V
    //   50: aload 5
    //   52: astore 4
    //   54: aload 4
    //   56: areturn
    //   57: aload_3
    //   58: astore 4
    //   60: aload_0
    //   61: invokevirtual 813	java/io/File:length	()J
    //   64: l2i
    //   65: newarray char
    //   67: astore 7
    //   69: aload_3
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual 813	java/io/File:length	()J
    //   80: l2i
    //   81: invokevirtual 819	java/io/BufferedReader:read	([CII)I
    //   84: ifle -46 -> 38
    //   87: aload_3
    //   88: astore 4
    //   90: new 79	java/lang/String
    //   93: dup
    //   94: aload 7
    //   96: invokespecial 822	java/lang/String:<init>	([C)V
    //   99: astore 5
    //   101: goto -63 -> 38
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   109: aload 5
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore 4
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: aload 4
    //   123: ifnull +8 -> 131
    //   126: aload 4
    //   128: invokevirtual 537	java/io/BufferedReader:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_3
    //   137: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   140: aload 6
    //   142: astore 4
    //   144: aload_0
    //   145: ifnull -91 -> 54
    //   148: aload_0
    //   149: invokevirtual 537	java/io/BufferedReader:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_3
    //   162: aload_3
    //   163: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   166: goto -35 -> 131
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 4
    //   173: goto -52 -> 121
    //   176: astore_3
    //   177: aload_0
    //   178: astore 4
    //   180: aload_3
    //   181: astore_0
    //   182: goto -61 -> 121
    //   185: astore 4
    //   187: aload_3
    //   188: astore_0
    //   189: aload 4
    //   191: astore_3
    //   192: goto -56 -> 136
    //   195: astore_0
    //   196: goto -81 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramFile	File
    //   29	2	1	l	long
    //   21	95	3	localBufferedReader	java.io.BufferedReader
    //   133	4	3	localThrowable1	Throwable
    //   161	2	3	localThrowable2	Throwable
    //   176	12	3	localObject1	Object
    //   191	1	3	localObject2	Object
    //   23	156	4	localObject3	Object
    //   185	5	4	localThrowable3	Throwable
    //   4	106	5	str	String
    //   1	140	6	localObject4	Object
    //   67	28	7	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   46	50	104	java/lang/Throwable
    //   6	22	112	java/io/FileNotFoundException
    //   25	30	120	finally
    //   60	69	120	finally
    //   72	87	120	finally
    //   90	101	120	finally
    //   118	120	120	finally
    //   6	22	133	java/lang/Throwable
    //   148	152	154	java/lang/Throwable
    //   126	131	161	java/lang/Throwable
    //   6	22	169	finally
    //   136	140	176	finally
    //   25	30	185	java/lang/Throwable
    //   60	69	185	java/lang/Throwable
    //   72	87	185	java/lang/Throwable
    //   90	101	185	java/lang/Throwable
    //   25	30	195	java/io/FileNotFoundException
    //   60	69	195	java/io/FileNotFoundException
    //   72	87	195	java/io/FileNotFoundException
    //   90	101	195	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 825	java/io/RandomAccessFile
    //   5: dup
    //   6: ldc_w 827
    //   9: ldc_w 829
    //   12: invokespecial 832	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 833	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   35: aload_0
    //   36: astore_2
    //   37: aload_2
    //   38: areturn
    //   39: astore_1
    //   40: iconst_4
    //   41: aload_1
    //   42: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   48: aload_0
    //   49: areturn
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   59: aload_3
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull -25 -> 37
    //   65: aload_1
    //   66: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: iconst_4
    //   73: aload_0
    //   74: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   77: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: astore_0
    //   96: iconst_4
    //   97: aload_0
    //   98: invokevirtual 400	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   101: invokestatic 406	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   104: goto -11 -> 93
    //   107: astore_1
    //   108: goto -23 -> 85
    //   111: astore_2
    //   112: goto -59 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	38	0	localObject1	Object
    //   71	3	0	localThrowable1	Throwable
    //   84	6	0	localObject2	Object
    //   95	3	0	localThrowable2	Throwable
    //   15	17	1	localRandomAccessFile	java.io.RandomAccessFile
    //   39	3	1	localThrowable3	Throwable
    //   52	14	1	localObject3	Object
    //   82	12	1	localObject4	Object
    //   107	1	1	localObject5	Object
    //   22	16	2	localObject6	Object
    //   50	6	2	localThrowable4	Throwable
    //   60	1	2	localObject7	Object
    //   111	1	2	localThrowable5	Throwable
    //   1	59	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	39	java/lang/Throwable
    //   2	16	50	java/lang/Throwable
    //   65	69	71	java/lang/Throwable
    //   2	16	82	finally
    //   89	93	95	java/lang/Throwable
    //   18	23	107	finally
    //   55	59	107	finally
    //   18	23	111	java/lang/Throwable
  }
  
  public static boolean supportInDeviceDolbyAudioEffect()
  {
    int i = 0;
    try
    {
      arrayOfDescriptor = AudioEffect.queryEffects();
      j = arrayOfDescriptor.length;
      bool1 = false;
    }
    catch (Exception localException1)
    {
      try
      {
        AudioEffect.Descriptor[] arrayOfDescriptor;
        int j;
        bool2 = arrayOfDescriptor[i].implementor.contains("Dolby Laboratories");
        if (bool2) {
          bool1 = true;
        }
        i += 1;
      }
      catch (Exception localException2)
      {
        boolean bool1;
        boolean bool2;
        break label51;
      }
      localException1 = localException1;
      bool1 = false;
    }
    bool2 = bool1;
    if (i < j)
    {
      label51:
      TPNativeLog.printLog(4, localException1.getMessage());
      bool2 = bool1;
    }
    return bool2;
  }
  
  private static void writeStringToFile(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = new File(paramString1);
      if ((!paramString1.exists()) && (paramString1.createNewFile())) {
        return;
      }
      paramString1 = new FileWriter(paramString1, false);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1 = localObject;
      }
    }
    try
    {
      paramString1.write(paramString2);
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramString1 == null) {
        return;
      }
    }
    try
    {
      paramString1.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPSystemInfo
 * JD-Core Version:    0.7.0.1
 */