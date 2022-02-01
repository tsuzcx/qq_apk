package com.tencent.thumbplayer.core.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
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
  private static final String[][] cpuPerfList = { { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro", "MSM8998", "SDM845", "SM8150", "SM8250", "SM8350" }, { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" }, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960", "Kirin970", "Kirin980", "Kirin990" }, { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" } };
  private static long currentCpuFreq = 0L;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI = "";
  private static String deviceMacAddr;
  private static Method getWlanMethod;
  private static long mAppInstallTime = 0L;
  private static int mAudioBestFramesPerBust = 0;
  private static int mAudioBestSampleRate = 0;
  private static int mCpuArchitecture = 0;
  private static int mCpuHWProductIdx = -1;
  private static int mCpuHWProducter = -1;
  private static String mCpuHardware = "";
  private static String mFeature = "";
  private static int mOpenGLVersion = 0;
  private static String mProcessorName = "N/A";
  public static int mScreenHeight;
  public static int mScreenWidth;
  private static long maxCpuFreq = -1L;
  private static int numOfCores;
  
  static
  {
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
        if (localObject == null) {
          break label154;
        }
        localObject = ((NetworkInterface)localObject).getHardwareAddress();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          str = Integer.toHexString(localObject[i] & 0xFF);
          paramContext = str;
          if (str.length() == 1)
          {
            paramContext = new StringBuilder();
            paramContext.append(0);
            paramContext.append(str);
            paramContext = paramContext.toString();
          }
          localStringBuilder.append(paramContext);
          if (i == j - 1) {
            break label156;
          }
          localStringBuilder.append(":");
          break label156;
        }
        paramContext = localStringBuilder.toString().toUpperCase();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TPNativeLog.printLog(4, paramContext.getMessage());
        return "";
      }
      paramContext = getLowerMarshmallowDeviceMacAddr(paramContext);
      label154:
      return paramContext;
      label156:
      i += 1;
    }
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    if (!hasMarshmallow()) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ("android.permission.WRITE_SETTINGS".equals(paramString)) {
        return Settings.System.canWrite(paramContext);
      }
    }
    try
    {
      int i = ContextCompat.checkSelfPermission(paramContext, paramString);
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
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
    if (paramInt != 64) {
      switch (paramInt)
      {
      default: 
        return 0;
      case 7: 
        return 6;
      case 6: 
        return 4;
      case 5: 
        return 3;
      }
    }
    return 7;
  }
  
  public static int getCpuArchitecture()
  {
    int i = cpuArch;
    if (-1 != i) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCpuArchitecture Build.CPU_ABI: ");
    localStringBuilder.append(Build.CPU_ABI);
    TPNativeLog.printLog(2, localStringBuilder.toString());
    if (Build.CPU_ABI.contains("arm64-v8a"))
    {
      cpuArch = 7;
      return cpuArch;
    }
    if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI.contains("X86"))))
    {
      cpuArch = 1;
    }
    else if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("mips")) || (Build.CPU_ABI.contains("Mips"))))
    {
      cpuArch = 2;
    }
    else
    {
      if (mCpuArchitecture == 0) {
        getCpuInfo();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCpuArchitecture mCpuArchitecture:");
      localStringBuilder.append(mCpuArchitecture);
      TPNativeLog.printLog(2, localStringBuilder.toString());
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
      if ((mCpuArchitecture == 7) && (!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon")) && (!mFeature.contains("asimd")))
      {
        cpuArch = 4;
        return cpuArch;
      }
      cpuArch = getCpuArchFromId(mCpuArchitecture);
    }
    return cpuArch;
  }
  
  private static int getCpuHWProducer(String paramString)
  {
    if (paramString.isEmpty()) {
      return -1;
    }
    if ((!paramString.contains("Exynos")) && (!paramString.contains("SMDK")) && (!paramString.contains("S5L8900")) && (!paramString.contains("S5PC100")))
    {
      if ((!paramString.contains("Kirin")) && (!paramString.contains("K3V")))
      {
        if ((!paramString.contains("MSM")) && (!paramString.contains("APQ")) && (!paramString.contains("QSD")) && (!paramString.contains("SDM")) && (!paramString.contains("SM")))
        {
          if (paramString.contains("MT6")) {
            return 1;
          }
          return -1;
        }
        return 0;
      }
      return 2;
    }
    return 3;
  }
  
  public static int getCpuHWProductIndex(String paramString)
  {
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    int i = mCpuHWProducter;
    if ((i >= 0) && (mCpuHWProductIdx < 0))
    {
      String[] arrayOfString = cpuPerfList[i];
      i = 0;
      int k;
      for (int j = -1; i < arrayOfString.length; j = k)
      {
        k = j;
        if (paramString.contains(arrayOfString[i])) {
          if (-1 != j)
          {
            k = j;
            if (arrayOfString[i].length() <= arrayOfString[j].length()) {}
          }
          else
          {
            k = i;
          }
        }
        i += 1;
      }
      mCpuHWProductIdx = j;
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
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 521	java/io/InputStreamReader
    //   7: dup
    //   8: new 523	java/io/FileInputStream
    //   11: dup
    //   12: ldc_w 525
    //   15: invokespecial 528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: ldc_w 530
    //   21: invokespecial 533	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 535	java/io/BufferedReader
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +12 -> 52
    //   43: aload_0
    //   44: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   47: aload_2
    //   48: invokevirtual 545	java/io/BufferedReader:close	()V
    //   51: return
    //   52: aload_1
    //   53: invokestatic 548	com/tencent/thumbplayer/core/common/TPSystemInfo:parseCpuInfoLine	(Ljava/lang/String;)V
    //   56: goto -22 -> 34
    //   59: astore_1
    //   60: goto +72 -> 132
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: goto +66 -> 132
    //   69: aconst_null
    //   70: astore_1
    //   71: goto +17 -> 88
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_1
    //   78: astore_0
    //   79: aload_3
    //   80: astore_1
    //   81: goto +51 -> 132
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_2
    //   87: astore_0
    //   88: ldc_w 550
    //   91: putstatic 467	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuHardware	Ljava/lang/String;
    //   94: iconst_0
    //   95: putstatic 460	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuArchitecture	I
    //   98: aload_0
    //   99: ifnull +10 -> 109
    //   102: aload_0
    //   103: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   106: goto +3 -> 109
    //   109: aload_1
    //   110: ifnull +16 -> 126
    //   113: aload_1
    //   114: invokevirtual 545	java/io/BufferedReader:close	()V
    //   117: return
    //   118: iconst_4
    //   119: aload_0
    //   120: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   123: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   126: return
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: aload_3
    //   131: astore_1
    //   132: aload_0
    //   133: ifnull +10 -> 143
    //   136: aload_0
    //   137: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   140: goto +3 -> 143
    //   143: aload_2
    //   144: ifnull +18 -> 162
    //   147: aload_2
    //   148: invokevirtual 545	java/io/BufferedReader:close	()V
    //   151: goto +11 -> 162
    //   154: iconst_4
    //   155: aload_0
    //   156: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   159: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   162: goto +5 -> 167
    //   165: aload_1
    //   166: athrow
    //   167: goto -2 -> 165
    //   170: astore_0
    //   171: goto -87 -> 84
    //   174: astore_1
    //   175: goto -106 -> 69
    //   178: astore_1
    //   179: aload_2
    //   180: astore_1
    //   181: goto -110 -> 71
    //   184: astore_0
    //   185: goto -67 -> 118
    //   188: astore_0
    //   189: goto -35 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	132	0	localObject1	Object
    //   170	1	0	localThrowable1	Throwable
    //   184	1	0	localIOException1	IOException
    //   188	1	0	localIOException2	IOException
    //   1	52	1	str	String
    //   59	1	1	localObject2	Object
    //   63	1	1	localObject3	Object
    //   70	96	1	localObject4	Object
    //   174	1	1	localThrowable2	Throwable
    //   178	1	1	localThrowable3	Throwable
    //   180	1	1	localObject5	Object
    //   3	177	2	localObject6	Object
    //   74	6	3	localObject7	Object
    //   127	4	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	59	finally
    //   52	56	59	finally
    //   25	34	63	finally
    //   4	25	74	finally
    //   88	98	127	finally
    //   4	25	170	java/lang/Throwable
    //   25	34	174	java/lang/Throwable
    //   34	39	178	java/lang/Throwable
    //   52	56	178	java/lang/Throwable
    //   43	51	184	java/io/IOException
    //   102	106	184	java/io/IOException
    //   113	117	184	java/io/IOException
    //   136	140	188	java/io/IOException
    //   147	151	188	java/io/IOException
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: getstatic 321	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   3: lstore_0
    //   4: lload_0
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +5 -> 12
    //   10: lload_0
    //   11: lreturn
    //   12: ldc2_w 556
    //   15: lstore_2
    //   16: aconst_null
    //   17: astore 13
    //   19: aconst_null
    //   20: astore 14
    //   22: aconst_null
    //   23: astore 17
    //   25: aconst_null
    //   26: astore 16
    //   28: aconst_null
    //   29: astore 15
    //   31: new 521	java/io/InputStreamReader
    //   34: dup
    //   35: new 523	java/io/FileInputStream
    //   38: dup
    //   39: ldc_w 559
    //   42: invokespecial 528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   45: ldc_w 530
    //   48: invokespecial 533	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: astore 12
    //   53: new 535	java/io/BufferedReader
    //   56: dup
    //   57: aload 12
    //   59: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore 13
    //   64: lload_2
    //   65: lstore 4
    //   67: lload_2
    //   68: lstore 6
    //   70: lload_2
    //   71: lstore 8
    //   73: lload_2
    //   74: lstore 10
    //   76: aload 13
    //   78: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 14
    //   83: aload 14
    //   85: ifnonnull +62 -> 147
    //   88: lload_2
    //   89: lstore 4
    //   91: lload_2
    //   92: lstore 6
    //   94: lload_2
    //   95: lstore 8
    //   97: lload_2
    //   98: lstore 10
    //   100: aload 12
    //   102: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   105: lload_2
    //   106: lstore 4
    //   108: lload_2
    //   109: lstore 6
    //   111: lload_2
    //   112: lstore 8
    //   114: lload_2
    //   115: lstore 10
    //   117: aload 13
    //   119: invokevirtual 545	java/io/BufferedReader:close	()V
    //   122: aload 12
    //   124: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   127: aload 13
    //   129: invokevirtual 545	java/io/BufferedReader:close	()V
    //   132: lconst_0
    //   133: lreturn
    //   134: astore 12
    //   136: iconst_4
    //   137: aload 12
    //   139: invokevirtual 386	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   142: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   145: lconst_0
    //   146: lreturn
    //   147: lload_2
    //   148: lstore 4
    //   150: lload_2
    //   151: lstore 6
    //   153: lload_2
    //   154: lstore 8
    //   156: lload_2
    //   157: lstore 10
    //   159: aload 14
    //   161: invokevirtual 562	java/lang/String:trim	()Ljava/lang/String;
    //   164: astore 14
    //   166: lload_2
    //   167: lstore_0
    //   168: lload_2
    //   169: lstore 4
    //   171: lload_2
    //   172: lstore 6
    //   174: lload_2
    //   175: lstore 8
    //   177: lload_2
    //   178: lstore 10
    //   180: aload 14
    //   182: invokevirtual 368	java/lang/String:length	()I
    //   185: ifle +21 -> 206
    //   188: lload_2
    //   189: lstore 4
    //   191: lload_2
    //   192: lstore 6
    //   194: lload_2
    //   195: lstore 8
    //   197: lload_2
    //   198: lstore 10
    //   200: aload 14
    //   202: invokestatic 568	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   205: lstore_0
    //   206: lload_0
    //   207: lstore 4
    //   209: lload_0
    //   210: lstore 6
    //   212: lload_0
    //   213: lstore 8
    //   215: lload_0
    //   216: lstore 10
    //   218: lload_0
    //   219: putstatic 321	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   222: aload 12
    //   224: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   227: aload 13
    //   229: invokevirtual 545	java/io/BufferedReader:close	()V
    //   232: lload_0
    //   233: lreturn
    //   234: astore 15
    //   236: aload 13
    //   238: astore 14
    //   240: goto +72 -> 312
    //   243: astore 16
    //   245: lload 4
    //   247: lstore_2
    //   248: aload 13
    //   250: astore 14
    //   252: aload 12
    //   254: astore 15
    //   256: goto +148 -> 404
    //   259: astore 16
    //   261: lload 6
    //   263: lstore_2
    //   264: aload 13
    //   266: astore 14
    //   268: aload 12
    //   270: astore 15
    //   272: goto +186 -> 458
    //   275: astore 16
    //   277: lload 8
    //   279: lstore_2
    //   280: aload 13
    //   282: astore 14
    //   284: aload 12
    //   286: astore 15
    //   288: goto +228 -> 516
    //   291: astore 16
    //   293: lload 10
    //   295: lstore_2
    //   296: aload 13
    //   298: astore 14
    //   300: aload 12
    //   302: astore 15
    //   304: goto +266 -> 570
    //   307: astore 15
    //   309: aconst_null
    //   310: astore 14
    //   312: aload 15
    //   314: astore 13
    //   316: goto +295 -> 611
    //   319: astore 16
    //   321: aconst_null
    //   322: astore 14
    //   324: ldc2_w 556
    //   327: lstore_2
    //   328: aload 12
    //   330: astore 15
    //   332: goto +72 -> 404
    //   335: astore 16
    //   337: aconst_null
    //   338: astore 14
    //   340: ldc2_w 556
    //   343: lstore_2
    //   344: aload 12
    //   346: astore 15
    //   348: goto +110 -> 458
    //   351: astore 16
    //   353: aconst_null
    //   354: astore 14
    //   356: ldc2_w 556
    //   359: lstore_2
    //   360: aload 12
    //   362: astore 15
    //   364: goto +152 -> 516
    //   367: astore 16
    //   369: aconst_null
    //   370: astore 14
    //   372: ldc2_w 556
    //   375: lstore_2
    //   376: aload 12
    //   378: astore 15
    //   380: goto +190 -> 570
    //   383: astore 13
    //   385: aconst_null
    //   386: astore 14
    //   388: aload 16
    //   390: astore 12
    //   392: goto +219 -> 611
    //   395: astore 16
    //   397: ldc2_w 556
    //   400: lstore_2
    //   401: aconst_null
    //   402: astore 14
    //   404: aload 14
    //   406: astore 13
    //   408: aload 15
    //   410: astore 12
    //   412: iconst_4
    //   413: aload 16
    //   415: invokevirtual 386	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   418: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   421: aload 15
    //   423: ifnull +8 -> 431
    //   426: aload 15
    //   428: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   431: lload_2
    //   432: lstore_0
    //   433: aload 14
    //   435: ifnull +199 -> 634
    //   438: aload 14
    //   440: invokevirtual 545	java/io/BufferedReader:close	()V
    //   443: lload_2
    //   444: lreturn
    //   445: astore 16
    //   447: ldc2_w 556
    //   450: lstore_2
    //   451: aconst_null
    //   452: astore 14
    //   454: aload 13
    //   456: astore 15
    //   458: aload 14
    //   460: astore 13
    //   462: aload 15
    //   464: astore 12
    //   466: iconst_4
    //   467: aload 16
    //   469: invokevirtual 569	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   472: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   475: aload 15
    //   477: ifnull +8 -> 485
    //   480: aload 15
    //   482: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   485: lload_2
    //   486: lstore_0
    //   487: aload 14
    //   489: ifnull +145 -> 634
    //   492: aload 14
    //   494: invokevirtual 545	java/io/BufferedReader:close	()V
    //   497: lload_2
    //   498: lreturn
    //   499: astore 16
    //   501: ldc2_w 556
    //   504: lstore_2
    //   505: aconst_null
    //   506: astore 12
    //   508: aload 14
    //   510: astore 15
    //   512: aload 12
    //   514: astore 14
    //   516: aload 14
    //   518: astore 13
    //   520: aload 15
    //   522: astore 12
    //   524: iconst_4
    //   525: aload 16
    //   527: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   530: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   533: aload 15
    //   535: ifnull +8 -> 543
    //   538: aload 15
    //   540: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   543: lload_2
    //   544: lstore_0
    //   545: aload 14
    //   547: ifnull +87 -> 634
    //   550: aload 14
    //   552: invokevirtual 545	java/io/BufferedReader:close	()V
    //   555: lload_2
    //   556: lreturn
    //   557: astore 16
    //   559: ldc2_w 556
    //   562: lstore_2
    //   563: aconst_null
    //   564: astore 14
    //   566: aload 17
    //   568: astore 15
    //   570: aload 14
    //   572: astore 13
    //   574: aload 15
    //   576: astore 12
    //   578: iconst_4
    //   579: aload 16
    //   581: invokevirtual 570	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   584: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   587: aload 15
    //   589: ifnull +8 -> 597
    //   592: aload 15
    //   594: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   597: lload_2
    //   598: lstore_0
    //   599: aload 14
    //   601: ifnull +33 -> 634
    //   604: aload 14
    //   606: invokevirtual 545	java/io/BufferedReader:close	()V
    //   609: lload_2
    //   610: lreturn
    //   611: aload 12
    //   613: ifnull +8 -> 621
    //   616: aload 12
    //   618: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   621: aload 14
    //   623: ifnull +8 -> 631
    //   626: aload 14
    //   628: invokevirtual 545	java/io/BufferedReader:close	()V
    //   631: aload 13
    //   633: athrow
    //   634: lload_0
    //   635: lreturn
    //   636: astore 15
    //   638: aload 13
    //   640: astore 14
    //   642: aload 15
    //   644: astore 13
    //   646: goto -35 -> 611
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	632	0	l1	long
    //   15	595	2	l2	long
    //   65	181	4	l3	long
    //   68	194	6	l4	long
    //   71	207	8	l5	long
    //   74	220	10	l6	long
    //   51	72	12	localInputStreamReader	java.io.InputStreamReader
    //   134	243	12	localThrowable1	Throwable
    //   390	227	12	localObject1	Object
    //   17	298	13	localObject2	Object
    //   383	1	13	localObject3	Object
    //   406	239	13	localObject4	Object
    //   20	621	14	localObject5	Object
    //   29	1	15	localObject6	Object
    //   234	1	15	localObject7	Object
    //   254	49	15	localObject8	Object
    //   307	6	15	localObject9	Object
    //   330	263	15	localObject10	Object
    //   636	7	15	localObject11	Object
    //   26	1	16	localObject12	Object
    //   243	1	16	localThrowable2	Throwable
    //   259	1	16	localException1	Exception
    //   275	1	16	localIOException1	IOException
    //   291	1	16	localFileNotFoundException1	java.io.FileNotFoundException
    //   319	1	16	localThrowable3	Throwable
    //   335	1	16	localException2	Exception
    //   351	1	16	localIOException2	IOException
    //   367	22	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   395	19	16	localThrowable4	Throwable
    //   445	23	16	localException3	Exception
    //   499	27	16	localIOException3	IOException
    //   557	23	16	localFileNotFoundException3	java.io.FileNotFoundException
    //   23	544	17	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   122	132	134	java/lang/Throwable
    //   222	232	134	java/lang/Throwable
    //   426	431	134	java/lang/Throwable
    //   438	443	134	java/lang/Throwable
    //   480	485	134	java/lang/Throwable
    //   492	497	134	java/lang/Throwable
    //   538	543	134	java/lang/Throwable
    //   550	555	134	java/lang/Throwable
    //   592	597	134	java/lang/Throwable
    //   604	609	134	java/lang/Throwable
    //   616	621	134	java/lang/Throwable
    //   626	631	134	java/lang/Throwable
    //   76	83	234	finally
    //   100	105	234	finally
    //   117	122	234	finally
    //   159	166	234	finally
    //   180	188	234	finally
    //   200	206	234	finally
    //   218	222	234	finally
    //   76	83	243	java/lang/Throwable
    //   100	105	243	java/lang/Throwable
    //   117	122	243	java/lang/Throwable
    //   159	166	243	java/lang/Throwable
    //   180	188	243	java/lang/Throwable
    //   200	206	243	java/lang/Throwable
    //   218	222	243	java/lang/Throwable
    //   76	83	259	java/lang/Exception
    //   100	105	259	java/lang/Exception
    //   117	122	259	java/lang/Exception
    //   159	166	259	java/lang/Exception
    //   180	188	259	java/lang/Exception
    //   200	206	259	java/lang/Exception
    //   218	222	259	java/lang/Exception
    //   76	83	275	java/io/IOException
    //   100	105	275	java/io/IOException
    //   117	122	275	java/io/IOException
    //   159	166	275	java/io/IOException
    //   180	188	275	java/io/IOException
    //   200	206	275	java/io/IOException
    //   218	222	275	java/io/IOException
    //   76	83	291	java/io/FileNotFoundException
    //   100	105	291	java/io/FileNotFoundException
    //   117	122	291	java/io/FileNotFoundException
    //   159	166	291	java/io/FileNotFoundException
    //   180	188	291	java/io/FileNotFoundException
    //   200	206	291	java/io/FileNotFoundException
    //   218	222	291	java/io/FileNotFoundException
    //   53	64	307	finally
    //   53	64	319	java/lang/Throwable
    //   53	64	335	java/lang/Exception
    //   53	64	351	java/io/IOException
    //   53	64	367	java/io/FileNotFoundException
    //   31	53	383	finally
    //   31	53	395	java/lang/Throwable
    //   31	53	445	java/lang/Exception
    //   31	53	499	java/io/IOException
    //   31	53	557	java/io/FileNotFoundException
    //   412	421	636	finally
    //   466	475	636	finally
    //   524	533	636	finally
    //   578	587	636	finally
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
      if (!TextUtils.isEmpty(deviceID)) {
        break label57;
      }
      deviceID = "NONE";
    }
    catch (Throwable paramContext)
    {
      label51:
      label57:
      break label51;
    }
    deviceID = "NONE";
    return deviceID;
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
      if (paramContext == null) {
        break label89;
      }
      deviceIMEI = paramContext.getDeviceId();
      if (TextUtils.isEmpty(deviceIMEI)) {
        deviceIMEI = "NONE";
      }
      paramContext = deviceIMEI;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label83:
      break label83;
    }
    deviceIMEI = "NONE";
    label89:
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
      return "";
    }
    catch (Throwable paramContext) {}
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
    //   0: getstatic 319	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   3: lstore_0
    //   4: ldc2_w 316
    //   7: lload_0
    //   8: lcmp
    //   9: ifeq +5 -> 14
    //   12: lload_0
    //   13: lreturn
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 10
    //   20: aconst_null
    //   21: astore 8
    //   23: lconst_0
    //   24: lstore_2
    //   25: new 521	java/io/InputStreamReader
    //   28: dup
    //   29: new 523	java/io/FileInputStream
    //   32: dup
    //   33: ldc_w 638
    //   36: invokespecial 528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: ldc_w 530
    //   42: invokespecial 533	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   45: astore 6
    //   47: new 535	java/io/BufferedReader
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 541	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 8
    //   65: aload 8
    //   67: ifnonnull +38 -> 105
    //   70: aload 6
    //   72: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   75: aload 7
    //   77: invokevirtual 545	java/io/BufferedReader:close	()V
    //   80: aload 6
    //   82: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   85: aload 7
    //   87: invokevirtual 545	java/io/BufferedReader:close	()V
    //   90: lconst_0
    //   91: lreturn
    //   92: astore 6
    //   94: iconst_4
    //   95: aload 6
    //   97: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   103: lconst_0
    //   104: lreturn
    //   105: aload 8
    //   107: invokevirtual 562	java/lang/String:trim	()Ljava/lang/String;
    //   110: astore 8
    //   112: lload_2
    //   113: lstore_0
    //   114: aload 8
    //   116: invokevirtual 368	java/lang/String:length	()I
    //   119: ifle +9 -> 128
    //   122: aload 8
    //   124: invokestatic 568	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   127: lstore_0
    //   128: lload_0
    //   129: lstore 4
    //   131: aload 6
    //   133: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   136: lload_0
    //   137: lstore 4
    //   139: aload 7
    //   141: invokevirtual 545	java/io/BufferedReader:close	()V
    //   144: goto +157 -> 301
    //   147: astore 6
    //   149: iconst_4
    //   150: aload 6
    //   152: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   155: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   158: lload 4
    //   160: lstore_0
    //   161: goto +140 -> 301
    //   164: astore 9
    //   166: aload 7
    //   168: astore 8
    //   170: aload 9
    //   172: astore 7
    //   174: goto +19 -> 193
    //   177: goto +61 -> 238
    //   180: goto +91 -> 271
    //   183: astore 7
    //   185: goto +8 -> 193
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 6
    //   193: aload 6
    //   195: ifnull +11 -> 206
    //   198: aload 6
    //   200: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   203: goto +3 -> 206
    //   206: aload 8
    //   208: ifnull +20 -> 228
    //   211: aload 8
    //   213: invokevirtual 545	java/io/BufferedReader:close	()V
    //   216: goto +12 -> 228
    //   219: iconst_4
    //   220: aload 6
    //   222: invokevirtual 551	java/io/IOException:getMessage	()Ljava/lang/String;
    //   225: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   228: aload 7
    //   230: athrow
    //   231: aconst_null
    //   232: astore 6
    //   234: aload 9
    //   236: astore 7
    //   238: aload 6
    //   240: ifnull +11 -> 251
    //   243: lload_2
    //   244: lstore 4
    //   246: aload 6
    //   248: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   251: lload_2
    //   252: lstore_0
    //   253: aload 7
    //   255: ifnull +46 -> 301
    //   258: lload_2
    //   259: lstore 4
    //   261: aload 7
    //   263: invokevirtual 545	java/io/BufferedReader:close	()V
    //   266: lload_2
    //   267: lstore_0
    //   268: goto +33 -> 301
    //   271: aload 6
    //   273: ifnull +11 -> 284
    //   276: lload_2
    //   277: lstore 4
    //   279: aload 6
    //   281: invokevirtual 544	java/io/InputStreamReader:close	()V
    //   284: lload_2
    //   285: lstore_0
    //   286: aload 7
    //   288: ifnull +13 -> 301
    //   291: lload_2
    //   292: lstore 4
    //   294: aload 7
    //   296: invokevirtual 545	java/io/BufferedReader:close	()V
    //   299: lload_2
    //   300: lstore_0
    //   301: lload_0
    //   302: putstatic 319	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   305: new 357	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   312: astore 6
    //   314: aload 6
    //   316: ldc_w 640
    //   319: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 6
    //   325: getstatic 319	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   328: invokevirtual 643	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: iconst_2
    //   333: aload 6
    //   335: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   341: lload_0
    //   342: lreturn
    //   343: astore 6
    //   345: goto +41 -> 386
    //   348: astore 6
    //   350: goto -119 -> 231
    //   353: astore 7
    //   355: aload 10
    //   357: astore 7
    //   359: goto -88 -> 271
    //   362: astore 7
    //   364: aload 9
    //   366: astore 7
    //   368: goto -130 -> 238
    //   371: astore 8
    //   373: goto -193 -> 180
    //   376: astore 8
    //   378: goto -201 -> 177
    //   381: astore 6
    //   383: goto -164 -> 219
    //   386: aconst_null
    //   387: astore 6
    //   389: aload 10
    //   391: astore 7
    //   393: goto -122 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	339	0	l1	long
    //   24	276	2	l2	long
    //   129	164	4	l3	long
    //   45	36	6	localInputStreamReader	java.io.InputStreamReader
    //   92	40	6	localIOException1	IOException
    //   147	4	6	localIOException2	IOException
    //   191	143	6	localStringBuilder	StringBuilder
    //   343	1	6	localIOException3	IOException
    //   348	1	6	localThrowable1	Throwable
    //   381	1	6	localIOException4	IOException
    //   387	1	6	localObject1	Object
    //   56	117	7	localObject2	Object
    //   183	1	7	localObject3	Object
    //   188	41	7	localObject4	Object
    //   236	59	7	localObject5	Object
    //   353	1	7	localIOException5	IOException
    //   357	1	7	localObject6	Object
    //   362	1	7	localThrowable2	Throwable
    //   366	26	7	localObject7	Object
    //   21	191	8	localObject8	Object
    //   371	1	8	localIOException6	IOException
    //   376	1	8	localThrowable3	Throwable
    //   15	1	9	localObject9	Object
    //   164	201	9	localObject10	Object
    //   18	372	10	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   80	90	92	java/io/IOException
    //   131	136	147	java/io/IOException
    //   139	144	147	java/io/IOException
    //   246	251	147	java/io/IOException
    //   261	266	147	java/io/IOException
    //   279	284	147	java/io/IOException
    //   294	299	147	java/io/IOException
    //   58	65	164	finally
    //   70	80	164	finally
    //   105	112	164	finally
    //   114	128	164	finally
    //   47	58	183	finally
    //   25	47	188	finally
    //   25	47	343	java/io/IOException
    //   25	47	348	java/lang/Throwable
    //   47	58	353	java/io/IOException
    //   47	58	362	java/lang/Throwable
    //   58	65	371	java/io/IOException
    //   70	80	371	java/io/IOException
    //   105	112	371	java/io/IOException
    //   114	128	371	java/io/IOException
    //   58	65	376	java/lang/Throwable
    //   70	80	376	java/lang/Throwable
    //   105	112	376	java/lang/Throwable
    //   114	128	376	java/lang/Throwable
    //   198	203	381	java/io/IOException
    //   211	216	381	java/io/IOException
  }
  
  public static int getNumCores()
  {
    int i = numOfCores;
    if (-1 != i) {
      return i;
    }
    try
    {
      Object localObject = new File("/sys/devices/system/cpu/").listFiles(new TPSystemInfo.1CpuFilter());
      if (localObject == null)
      {
        numOfCores = 1;
        return numOfCores;
      }
      numOfCores = localObject.length;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("core num ");
      ((StringBuilder)localObject).append(numOfCores);
      TPNativeLog.printLog(2, ((StringBuilder)localObject).toString());
      i = numOfCores;
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
    if (mOpenGLVersion == 0) {
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
    int i = mScreenHeight;
    if (i != 0) {
      return i;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    catch (Throwable paramContext)
    {
      label32:
      break label32;
    }
    mScreenHeight = 0;
    return mScreenHeight;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    int i = mScreenWidth;
    if (i != 0) {
      return i;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    }
    catch (Throwable paramContext)
    {
      label32:
      break label32;
    }
    mScreenWidth = 0;
    return mScreenWidth;
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      float f2 = -1.0F;
      float f1;
      try
      {
        paramString1 = paramString1.trim().split("\\s+");
        long l3 = getSystemIdleTime(paramString1);
        long l1 = getSystemUptime(paramString1);
        paramString1 = paramString2.trim().split("\\s+");
        long l4 = getSystemIdleTime(paramString1);
        long l2 = getSystemUptime(paramString1);
        f1 = f2;
        if (l3 >= 0L)
        {
          f1 = f2;
          if (l1 >= 0L)
          {
            f1 = f2;
            if (l4 >= 0L)
            {
              f1 = f2;
              if (l2 >= 0L)
              {
                l4 += l2;
                l3 += l1;
                f1 = f2;
                if (l4 > l3)
                {
                  f1 = f2;
                  if (l2 >= l1) {
                    f1 = (float)(l2 - l1) / (float)(l4 - l3) * 100.0F;
                  }
                }
              }
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        TPNativeLog.printLog(4, paramString1.getMessage());
        f1 = f2;
      }
      return (int)f1;
    }
    return -1;
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
    int i = 1;
    long l2;
    for (long l1 = 0L; i < paramArrayOfString.length; l1 = l2)
    {
      l2 = l1;
      if (4 != i) {}
      try
      {
        l2 = Long.parseLong(paramArrayOfString[i]);
        l2 = l1 + l2;
      }
      catch (Throwable paramArrayOfString)
      {
        label35:
        break label35;
      }
      return -1L;
      i += 1;
    }
    return l1;
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
  
  public static void initAudioBestSettings(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        if (mAudioBestSampleRate <= 0)
        {
          if (Build.VERSION.SDK_INT >= 17)
          {
            Object localObject = (AudioManager)paramContext.getSystemService("audio");
            paramContext = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            localObject = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            try
            {
              mAudioBestSampleRate = Integer.parseInt(paramContext);
              mAudioBestFramesPerBust = Integer.parseInt((String)localObject);
            }
            catch (NumberFormatException paramContext)
            {
              TPNativeLog.printLog(4, paramContext.getMessage());
            }
          }
          return;
        }
      }
      finally {}
    }
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
    else if (paramString.startsWith("CPU architecture"))
    {
      if (mCpuArchitecture == 0)
      {
        i = paramString.indexOf(':');
        if (i > 1)
        {
          paramString = paramString.substring(i + 1, paramString.length()).trim();
          if ((paramString.length() > 0) && (paramString.length() < 2))
          {
            mCpuArchitecture = (int)Long.parseLong(paramString);
            return;
          }
          if (paramString.length() > 1) {
            mCpuArchitecture = (int)Long.parseLong(paramString.substring(0, 1));
          }
        }
      }
    }
    else if (paramString.startsWith("Features"))
    {
      i = paramString.indexOf(':');
      if (i > 1) {
        mFeature = paramString.substring(i + 1, paramString.length()).trim();
      }
    }
    else if (paramString.startsWith("Hardware"))
    {
      i = paramString.indexOf(':');
      if (i > 1)
      {
        mCpuHardware = paramString.substring(i + 1, paramString.length()).trim().replace(" ", "");
        paramString = new StringBuilder();
        paramString.append("hardware ");
        paramString.append(mCpuHardware);
        TPNativeLog.printLog(2, paramString.toString());
        getCpuHWProductIndex(mCpuHardware);
      }
    }
  }
  
  /* Error */
  private static String readStringFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: new 535	java/io/BufferedReader
    //   13: dup
    //   14: new 816	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 819	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: invokespecial 538	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: invokevirtual 821	java/io/File:length	()J
    //   32: ldc2_w 822
    //   35: lcmp
    //   36: ifle +6 -> 42
    //   39: goto +43 -> 82
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: invokevirtual 821	java/io/File:length	()J
    //   48: l2i
    //   49: newarray char
    //   51: astore 5
    //   53: aload_1
    //   54: astore_2
    //   55: aload_1
    //   56: aload 5
    //   58: iconst_0
    //   59: aload_0
    //   60: invokevirtual 821	java/io/File:length	()J
    //   63: l2i
    //   64: invokevirtual 827	java/io/BufferedReader:read	([CII)I
    //   67: ifle +15 -> 82
    //   70: aload_1
    //   71: astore_2
    //   72: new 67	java/lang/String
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 830	java/lang/String:<init>	([C)V
    //   81: astore_3
    //   82: aload_3
    //   83: astore_0
    //   84: aload_1
    //   85: invokevirtual 545	java/io/BufferedReader:close	()V
    //   88: aload_3
    //   89: areturn
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 721	java/lang/Throwable:printStackTrace	()V
    //   95: aload_0
    //   96: areturn
    //   97: astore_0
    //   98: goto +16 -> 114
    //   101: astore_0
    //   102: aload_1
    //   103: astore_2
    //   104: goto +37 -> 141
    //   107: astore_0
    //   108: goto +35 -> 143
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_2
    //   116: aload_0
    //   117: invokevirtual 721	java/lang/Throwable:printStackTrace	()V
    //   120: aload_1
    //   121: ifnull +10 -> 131
    //   124: aload 4
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 545	java/io/BufferedReader:close	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: goto +9 -> 143
    //   137: astore_0
    //   138: aload 5
    //   140: astore_2
    //   141: aload_0
    //   142: athrow
    //   143: aload_2
    //   144: ifnull +15 -> 159
    //   147: aload_2
    //   148: invokevirtual 545	java/io/BufferedReader:close	()V
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 721	java/lang/Throwable:printStackTrace	()V
    //   159: aload_0
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramFile	File
    //   25	60	1	localBufferedReader	java.io.BufferedReader
    //   90	13	1	localThrowable1	Throwable
    //   113	15	1	localObject1	Object
    //   154	2	1	localThrowable2	Throwable
    //   4	144	2	localObject2	Object
    //   9	80	3	str	String
    //   1	124	4	localObject3	Object
    //   6	133	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   84	88	90	java/lang/Throwable
    //   127	131	90	java/lang/Throwable
    //   28	39	97	java/lang/Throwable
    //   44	53	97	java/lang/Throwable
    //   55	70	97	java/lang/Throwable
    //   72	82	97	java/lang/Throwable
    //   28	39	101	java/io/FileNotFoundException
    //   44	53	101	java/io/FileNotFoundException
    //   55	70	101	java/io/FileNotFoundException
    //   72	82	101	java/io/FileNotFoundException
    //   10	26	107	finally
    //   141	143	107	finally
    //   10	26	111	java/lang/Throwable
    //   28	39	133	finally
    //   44	53	133	finally
    //   55	70	133	finally
    //   72	82	133	finally
    //   116	120	133	finally
    //   10	26	137	java/io/FileNotFoundException
    //   147	151	154	java/lang/Throwable
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 833	java/io/RandomAccessFile
    //   7: dup
    //   8: ldc_w 835
    //   11: ldc_w 837
    //   14: invokespecial 840	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual 841	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 842	java/io/RandomAccessFile:close	()V
    //   31: aload_2
    //   32: areturn
    //   33: astore_1
    //   34: iconst_4
    //   35: aload_1
    //   36: invokevirtual 386	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   39: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   42: aload_0
    //   43: areturn
    //   44: astore_2
    //   45: goto +10 -> 55
    //   48: astore_0
    //   49: goto +29 -> 78
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 721	java/lang/Throwable:printStackTrace	()V
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_3
    //   66: astore_0
    //   67: aload_1
    //   68: invokevirtual 842	java/io/RandomAccessFile:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: aload_0
    //   75: astore_2
    //   76: aload_1
    //   77: astore_0
    //   78: aload_2
    //   79: ifnull +19 -> 98
    //   82: aload_2
    //   83: invokevirtual 842	java/io/RandomAccessFile:close	()V
    //   86: goto +12 -> 98
    //   89: astore_1
    //   90: iconst_4
    //   91: aload_1
    //   92: invokevirtual 386	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   95: invokestatic 392	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	24	0	localObject1	Object
    //   48	1	0	localObject2	Object
    //   56	43	0	localObject3	Object
    //   17	11	1	localRandomAccessFile	java.io.RandomAccessFile
    //   33	3	1	localThrowable1	Throwable
    //   54	14	1	localObject4	Object
    //   73	4	1	localObject5	Object
    //   89	3	1	localThrowable2	Throwable
    //   1	31	2	str	String
    //   44	1	2	localThrowable3	Throwable
    //   52	6	2	localThrowable4	Throwable
    //   75	8	2	localObject6	Object
    //   3	63	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	33	java/lang/Throwable
    //   67	71	33	java/lang/Throwable
    //   20	25	44	java/lang/Throwable
    //   4	18	48	finally
    //   4	18	52	java/lang/Throwable
    //   20	25	73	finally
    //   57	61	73	finally
    //   82	86	89	java/lang/Throwable
  }
  
  public static boolean supportInDeviceDolbyAudioEffect()
  {
    int i = 0;
    boolean bool1;
    try
    {
      AudioEffect.Descriptor[] arrayOfDescriptor = AudioEffect.queryEffects();
      int j = arrayOfDescriptor.length;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          return bool2;
        }
        try
        {
          bool2 = arrayOfDescriptor[i].implementor.contains("Dolby Laboratories");
          if (bool2) {
            bool1 = true;
          }
          i += 1;
        }
        catch (Exception localException1) {}
      }
      TPNativeLog.printLog(4, localException2.getMessage());
    }
    catch (Exception localException2)
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  private static void writeStringToFile(String paramString1, String paramString2)
  {
    localObject = null;
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
        label50:
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
      break label50;
    }
    if (paramString1 != null) {
      try
      {
        paramString1.close();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPSystemInfo
 * JD-Core Version:    0.7.0.1
 */