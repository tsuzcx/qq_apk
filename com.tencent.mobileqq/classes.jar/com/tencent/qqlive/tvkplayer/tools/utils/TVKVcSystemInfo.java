package com.tencent.qqlive.tvkplayer.tools.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class TVKVcSystemInfo
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
  private static final String GUID_FILE = "/guid";
  private static final String GUID_PHONE_PATH;
  public static final int NETWORK_CLASS_2_G = 2;
  public static final int NETWORK_CLASS_3_G = 3;
  public static final int NETWORK_CLASS_4_G = 4;
  public static final int NETWORK_CLASS_UNKNOWN = 0;
  public static final int NETWORK_CLASS_WIFI = 1;
  private static final int NETWORK_TYPE_1xRTT = 7;
  private static final int NETWORK_TYPE_CDMA = 4;
  private static final int NETWORK_TYPE_EDGE = 2;
  private static final int NETWORK_TYPE_EHRPD = 14;
  private static final int NETWORK_TYPE_EVDO_0 = 5;
  private static final int NETWORK_TYPE_EVDO_A = 6;
  private static final int NETWORK_TYPE_EVDO_B = 12;
  private static final int NETWORK_TYPE_GPRS = 1;
  private static final int NETWORK_TYPE_HSDPA = 8;
  private static final int NETWORK_TYPE_HSPA = 10;
  private static final int NETWORK_TYPE_HSPAP = 15;
  private static final int NETWORK_TYPE_HSUPA = 9;
  private static final int NETWORK_TYPE_IDEN = 11;
  private static final int NETWORK_TYPE_LTE = 13;
  private static final int NETWORK_TYPE_UMTS = 3;
  public static final int OPERATOR_CHINA_MOBILE = 3;
  public static final int OPERATOR_CHINA_TELECOM = 1;
  public static final int OPERATOR_CHINA_UNICOM = 2;
  public static final int OPERATOR_UNKNOWN = 0;
  public static final int PLAYER_LEVEL_1 = 1;
  public static final int PLAYER_LEVEL_11 = 11;
  public static final int PLAYER_LEVEL_16 = 16;
  public static final int PLAYER_LEVEL_21 = 21;
  public static final int PLAYER_LEVEL_26 = 26;
  public static final int PLAYER_LEVEL_28 = 28;
  public static final int PLAYER_LEVEL_33 = 33;
  public static final int PLAYER_LEVEL_6 = 6;
  public static final int RECORD_LEVEL_1 = 1;
  public static final int RECORD_LEVEL_2 = 2;
  public static final int RECORD_LEVEL_3 = 3;
  public static final String TAG = "MediaPlayerMgr[TVKVcSystemInfo.java]";
  public static final int TYPE_CMNET = 2;
  public static final int TYPE_CMWAP = 3;
  public static final int TYPE_ETHERNET = 5;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_OTHER = 4;
  public static final int TYPE_WIFI = 1;
  private static String appVersionName;
  private static int cpuArch = 0;
  private static final String[][] cpuPerfList;
  private static long currentCpuFreq = 0L;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI;
  private static String deviceMacAddr;
  private static int externalStorageMounted = 0;
  private static Method getWlanMethod;
  private static int isNetworkAvailable = 0;
  private static boolean isNetworkChange = false;
  private static int mCpuArchitecture = 0;
  private static int mCpuHWProductIdx = -1;
  private static int mCpuHWProducter = -1;
  private static String mCpuHardware = "";
  private static String mCurrentIP = "";
  private static int mDeviceLevel = -1;
  private static String mFeature = "";
  private static int mMCC = 0;
  private static int mMNC = 0;
  private static int mMarketId = 0;
  private static int mNetWorkClass = -1;
  private static int mNetWorkType = 0;
  private static int mOpenGLVersion = 0;
  private static String mPackageName;
  private static String mProcessorName = "N/A";
  private static boolean mReadMarketId = false;
  private static int mRecordLevel = -1;
  public static int mScreenHeight = 0;
  public static int mScreenWidth = 0;
  private static long maxCpuFreq = 0L;
  private static int numOfCores = 0;
  private static String sBSSID = "";
  private static String sMacAddr = "";
  private static String sSSID = "";
  private static long sTotalMem;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getDataDirectory());
    ((StringBuilder)localObject).append("/data/");
    GUID_PHONE_PATH = ((StringBuilder)localObject).toString();
    localObject = new String[] { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" };
    cpuPerfList = new String[][] { { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro" }, { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" }, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960" }, localObject };
    mPackageName = "";
    maxCpuFreq = -1L;
    currentCpuFreq = -1L;
    numOfCores = -1;
    cpuArch = -1;
    deviceIMSI = "";
    externalStorageMounted = -1;
    isNetworkChange = false;
    isNetworkAvailable = -1;
    mNetWorkType = -1;
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    if (!hasMarshmallow()) {
      return true;
    }
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ("android.permission.WRITE_SETTINGS".equals(paramString)) {
        return Settings.System.canWrite(paramContext);
      }
      try
      {
        int i = ContextCompat.checkSelfPermission(paramContext, paramString);
        if (i == 0) {
          return true;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean detectDolbyDevice()
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
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", localException2);
    }
    catch (Exception localException2)
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    if (!TextUtils.isEmpty(appVersionName)) {
      return appVersionName;
    }
    if (paramContext == null) {
      return "";
    }
    try
    {
      appVersionName = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      String str = appVersionName;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private static int getArmCpuArch()
  {
    if (mCpuArchitecture == 0) {
      getCpuInfo();
    }
    boolean bool = TextUtils.isEmpty(mCpuHardware);
    int i = 7;
    if ((!bool) && (mCpuHardware.contains("MSM8994"))) {
      return 7;
    }
    if ((!getDeviceName().equals("XT882")) && (!getDeviceName().equals("ME860")) && (!getDeviceName().equals("MB860")) && (!getDeviceName().equals("Lenovo P70")) && (!getDeviceName().equals("Lenovo A60")))
    {
      if (getDeviceName().equals("Lenovo A366t")) {
        return 3;
      }
      if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("ARMv6"))) {
        return 4;
      }
      if ((!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon"))) {
        return 4;
      }
      int j = mCpuArchitecture;
      if (j != 64)
      {
        switch (j)
        {
        default: 
          return 0;
        case 8: 
        case 9: 
        case 10: 
          return 50;
        case 7: 
          return 6;
        case 6: 
          return 4;
        }
        i = 3;
      }
      return i;
    }
    return 3;
  }
  
  public static String getBSSID(Context paramContext)
  {
    if (!TextUtils.isEmpty(sBSSID)) {
      return sBSSID;
    }
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getApplicationContext().getSystemService("wifi"));
      if (paramContext != null)
      {
        sSSID = paramContext.getSSID();
        sBSSID = paramContext.getBSSID();
        paramContext = sBSSID;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return "";
  }
  
  public static int getCpuArchitecture()
  {
    int i = cpuArch;
    if (-1 != i) {
      return i;
    }
    if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI.contains("X86")))) {
      cpuArch = 1;
    } else if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("mips")) || (Build.CPU_ABI.contains("Mips")))) {
      cpuArch = 2;
    } else {
      cpuArch = getArmCpuArch();
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
        if ((!paramString.contains("MSM")) && (!paramString.contains("APQ")) && (!paramString.contains("QSD")))
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
    //   2: new 628	java/io/InputStreamReader
    //   5: dup
    //   6: new 630	java/io/FileInputStream
    //   9: dup
    //   10: ldc_w 632
    //   13: invokespecial 635	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: ldc_w 637
    //   19: invokespecial 640	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 642	java/io/BufferedReader
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 645	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 648	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +12 -> 50
    //   41: aload_3
    //   42: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   45: aload_2
    //   46: invokevirtual 652	java/io/BufferedReader:close	()V
    //   49: return
    //   50: aload_1
    //   51: ldc_w 654
    //   54: invokevirtual 482	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifne +13 -> 70
    //   60: aload_1
    //   61: ldc_w 656
    //   64: invokevirtual 482	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +8 -> 75
    //   70: bipush 64
    //   72: putstatic 518	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   75: aload_1
    //   76: ldc_w 658
    //   79: invokevirtual 662	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +41 -> 123
    //   85: aload_1
    //   86: bipush 58
    //   88: invokevirtual 666	java/lang/String:indexOf	(I)I
    //   91: istore_0
    //   92: iload_0
    //   93: iconst_1
    //   94: if_icmple -62 -> 32
    //   97: aload_1
    //   98: iload_0
    //   99: iconst_1
    //   100: iadd
    //   101: aload_1
    //   102: invokevirtual 622	java/lang/String:length	()I
    //   105: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: putstatic 540	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   111: getstatic 540	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   114: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   117: putstatic 540	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   120: goto -88 -> 32
    //   123: aload_1
    //   124: ldc_w 675
    //   127: invokevirtual 662	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   130: ifeq +86 -> 216
    //   133: getstatic 518	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   136: ifne -104 -> 32
    //   139: aload_1
    //   140: bipush 58
    //   142: invokevirtual 666	java/lang/String:indexOf	(I)I
    //   145: istore_0
    //   146: iload_0
    //   147: iconst_1
    //   148: if_icmple -116 -> 32
    //   151: aload_1
    //   152: iload_0
    //   153: iconst_1
    //   154: iadd
    //   155: aload_1
    //   156: invokevirtual 622	java/lang/String:length	()I
    //   159: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   162: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 622	java/lang/String:length	()I
    //   170: ifle +22 -> 192
    //   173: aload_1
    //   174: invokevirtual 622	java/lang/String:length	()I
    //   177: iconst_2
    //   178: if_icmpge +14 -> 192
    //   181: aload_1
    //   182: invokestatic 681	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   185: l2i
    //   186: putstatic 518	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   189: goto -157 -> 32
    //   192: aload_1
    //   193: invokevirtual 622	java/lang/String:length	()I
    //   196: iconst_1
    //   197: if_icmple -165 -> 32
    //   200: aload_1
    //   201: iconst_0
    //   202: iconst_1
    //   203: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   206: invokestatic 681	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   209: l2i
    //   210: putstatic 518	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   213: goto -181 -> 32
    //   216: aload_1
    //   217: ldc_w 683
    //   220: invokevirtual 662	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   223: ifeq +35 -> 258
    //   226: aload_1
    //   227: bipush 58
    //   229: invokevirtual 666	java/lang/String:indexOf	(I)I
    //   232: istore_0
    //   233: iload_0
    //   234: iconst_1
    //   235: if_icmple -203 -> 32
    //   238: aload_1
    //   239: iload_0
    //   240: iconst_1
    //   241: iadd
    //   242: aload_1
    //   243: invokevirtual 622	java/lang/String:length	()I
    //   246: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   249: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   252: putstatic 544	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mFeature	Ljava/lang/String;
    //   255: goto -223 -> 32
    //   258: aload_1
    //   259: ldc_w 685
    //   262: invokevirtual 662	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   265: ifeq -233 -> 32
    //   268: aload_1
    //   269: bipush 58
    //   271: invokevirtual 666	java/lang/String:indexOf	(I)I
    //   274: istore_0
    //   275: iload_0
    //   276: iconst_1
    //   277: if_icmple -245 -> 32
    //   280: aload_1
    //   281: iload_0
    //   282: iconst_1
    //   283: iadd
    //   284: aload_1
    //   285: invokevirtual 622	java/lang/String:length	()I
    //   288: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   291: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   294: ldc_w 687
    //   297: ldc 115
    //   299: invokevirtual 691	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   302: putstatic 523	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   305: new 142	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 693
    //   317: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: getstatic 523	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   325: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 85
    //   331: aload_1
    //   332: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 697	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: getstatic 523	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   341: invokestatic 699	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:getCpuHWProductIndex	(Ljava/lang/String;)I
    //   344: pop
    //   345: goto -313 -> 32
    //   348: astore_1
    //   349: goto +70 -> 419
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_2
    //   355: goto +64 -> 419
    //   358: aconst_null
    //   359: astore_2
    //   360: aload_3
    //   361: astore_1
    //   362: goto +13 -> 375
    //   365: astore_1
    //   366: aconst_null
    //   367: astore_3
    //   368: aload_3
    //   369: astore_2
    //   370: goto +49 -> 419
    //   373: aconst_null
    //   374: astore_2
    //   375: ldc_w 701
    //   378: putstatic 523	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   381: iconst_0
    //   382: putstatic 518	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   385: aload_1
    //   386: ifnull +10 -> 396
    //   389: aload_1
    //   390: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   393: goto +3 -> 396
    //   396: aload_2
    //   397: ifnull +14 -> 411
    //   400: aload_2
    //   401: invokevirtual 652	java/io/BufferedReader:close	()V
    //   404: return
    //   405: ldc 85
    //   407: aload_1
    //   408: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: return
    //   412: astore 4
    //   414: aload_1
    //   415: astore_3
    //   416: aload 4
    //   418: astore_1
    //   419: aload_3
    //   420: ifnull +10 -> 430
    //   423: aload_3
    //   424: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   427: goto +3 -> 430
    //   430: aload_2
    //   431: ifnull +16 -> 447
    //   434: aload_2
    //   435: invokevirtual 652	java/io/BufferedReader:close	()V
    //   438: goto +9 -> 447
    //   441: ldc 85
    //   443: aload_2
    //   444: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   447: goto +5 -> 452
    //   450: aload_1
    //   451: athrow
    //   452: goto -2 -> 450
    //   455: astore_2
    //   456: goto -83 -> 373
    //   459: astore_1
    //   460: goto -102 -> 358
    //   463: astore_1
    //   464: goto -104 -> 360
    //   467: astore_1
    //   468: goto -63 -> 405
    //   471: astore_2
    //   472: goto -31 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   91	193	0	i	int
    //   1	331	1	localObject1	Object
    //   348	1	1	localObject2	Object
    //   352	1	1	localObject3	Object
    //   361	1	1	localObject4	Object
    //   365	50	1	localThrowable1	Throwable
    //   418	33	1	localObject5	Object
    //   459	1	1	localThrowable2	Throwable
    //   463	1	1	localThrowable3	Throwable
    //   467	1	1	localIOException1	IOException
    //   31	413	2	localObject6	Object
    //   455	1	2	localThrowable4	Throwable
    //   471	1	2	localIOException2	IOException
    //   22	402	3	localObject7	Object
    //   412	5	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	348	finally
    //   50	70	348	finally
    //   70	75	348	finally
    //   75	92	348	finally
    //   97	120	348	finally
    //   123	146	348	finally
    //   151	189	348	finally
    //   192	213	348	finally
    //   216	233	348	finally
    //   238	255	348	finally
    //   258	275	348	finally
    //   280	345	348	finally
    //   23	32	352	finally
    //   2	23	365	finally
    //   375	385	412	finally
    //   2	23	455	java/lang/Throwable
    //   23	32	459	java/lang/Throwable
    //   32	37	463	java/lang/Throwable
    //   50	70	463	java/lang/Throwable
    //   70	75	463	java/lang/Throwable
    //   75	92	463	java/lang/Throwable
    //   97	120	463	java/lang/Throwable
    //   123	146	463	java/lang/Throwable
    //   151	189	463	java/lang/Throwable
    //   192	213	463	java/lang/Throwable
    //   216	233	463	java/lang/Throwable
    //   238	255	463	java/lang/Throwable
    //   258	275	463	java/lang/Throwable
    //   280	345	463	java/lang/Throwable
    //   41	49	467	java/io/IOException
    //   389	393	467	java/io/IOException
    //   400	404	467	java/io/IOException
    //   423	427	471	java/io/IOException
    //   434	438	471	java/io/IOException
  }
  
  public static long getCurrentAvailMem(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    try
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      if (paramContext == null) {
        return 0L;
      }
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem / 1048576L;
      return l;
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return 0L;
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: getstatic 410	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:currentCpuFreq	J
    //   3: lstore_0
    //   4: lload_0
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +5 -> 12
    //   10: lload_0
    //   11: lreturn
    //   12: ldc2_w 724
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
    //   31: new 628	java/io/InputStreamReader
    //   34: dup
    //   35: new 630	java/io/FileInputStream
    //   38: dup
    //   39: ldc_w 727
    //   42: invokespecial 635	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   45: ldc_w 637
    //   48: invokespecial 640	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: astore 12
    //   53: new 642	java/io/BufferedReader
    //   56: dup
    //   57: aload 12
    //   59: invokespecial 645	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
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
    //   78: invokevirtual 648	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 14
    //   83: aload 14
    //   85: ifnonnull +60 -> 145
    //   88: lload_2
    //   89: lstore 4
    //   91: lload_2
    //   92: lstore 6
    //   94: lload_2
    //   95: lstore 8
    //   97: lload_2
    //   98: lstore 10
    //   100: aload 12
    //   102: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   105: lload_2
    //   106: lstore 4
    //   108: lload_2
    //   109: lstore 6
    //   111: lload_2
    //   112: lstore 8
    //   114: lload_2
    //   115: lstore 10
    //   117: aload 13
    //   119: invokevirtual 652	java/io/BufferedReader:close	()V
    //   122: aload 12
    //   124: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   127: aload 13
    //   129: invokevirtual 652	java/io/BufferedReader:close	()V
    //   132: lconst_0
    //   133: lreturn
    //   134: astore 12
    //   136: ldc 85
    //   138: aload 12
    //   140: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: lconst_0
    //   144: lreturn
    //   145: lload_2
    //   146: lstore 4
    //   148: lload_2
    //   149: lstore 6
    //   151: lload_2
    //   152: lstore 8
    //   154: lload_2
    //   155: lstore 10
    //   157: aload 14
    //   159: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   162: astore 14
    //   164: lload_2
    //   165: lstore_0
    //   166: lload_2
    //   167: lstore 4
    //   169: lload_2
    //   170: lstore 6
    //   172: lload_2
    //   173: lstore 8
    //   175: lload_2
    //   176: lstore 10
    //   178: aload 14
    //   180: invokevirtual 622	java/lang/String:length	()I
    //   183: ifle +21 -> 204
    //   186: lload_2
    //   187: lstore 4
    //   189: lload_2
    //   190: lstore 6
    //   192: lload_2
    //   193: lstore 8
    //   195: lload_2
    //   196: lstore 10
    //   198: aload 14
    //   200: invokestatic 681	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   203: lstore_0
    //   204: lload_0
    //   205: lstore 4
    //   207: lload_0
    //   208: lstore 6
    //   210: lload_0
    //   211: lstore 8
    //   213: lload_0
    //   214: lstore 10
    //   216: lload_0
    //   217: putstatic 410	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:currentCpuFreq	J
    //   220: aload 12
    //   222: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   225: aload 13
    //   227: invokevirtual 652	java/io/BufferedReader:close	()V
    //   230: lload_0
    //   231: lreturn
    //   232: astore 12
    //   234: ldc 85
    //   236: aload 12
    //   238: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: lconst_0
    //   242: lreturn
    //   243: astore 14
    //   245: goto +72 -> 317
    //   248: astore 16
    //   250: lload 4
    //   252: lstore_2
    //   253: aload 13
    //   255: astore 14
    //   257: aload 12
    //   259: astore 15
    //   261: goto +156 -> 417
    //   264: astore 16
    //   266: lload 6
    //   268: lstore_2
    //   269: aload 13
    //   271: astore 14
    //   273: aload 12
    //   275: astore 15
    //   277: goto +204 -> 481
    //   280: astore 16
    //   282: lload 8
    //   284: lstore_2
    //   285: aload 13
    //   287: astore 14
    //   289: aload 12
    //   291: astore 15
    //   293: goto +256 -> 549
    //   296: astore 16
    //   298: lload 10
    //   300: lstore_2
    //   301: aload 13
    //   303: astore 14
    //   305: aload 12
    //   307: astore 15
    //   309: goto +304 -> 613
    //   312: astore 14
    //   314: aconst_null
    //   315: astore 13
    //   317: aload 12
    //   319: astore 15
    //   321: aload 14
    //   323: astore 12
    //   325: aload 15
    //   327: astore 14
    //   329: goto +347 -> 676
    //   332: astore 16
    //   334: aconst_null
    //   335: astore 14
    //   337: ldc2_w 724
    //   340: lstore_2
    //   341: aload 12
    //   343: astore 15
    //   345: goto +72 -> 417
    //   348: astore 16
    //   350: aconst_null
    //   351: astore 14
    //   353: ldc2_w 724
    //   356: lstore_2
    //   357: aload 12
    //   359: astore 15
    //   361: goto +120 -> 481
    //   364: astore 16
    //   366: aconst_null
    //   367: astore 14
    //   369: ldc2_w 724
    //   372: lstore_2
    //   373: aload 12
    //   375: astore 15
    //   377: goto +172 -> 549
    //   380: astore 16
    //   382: aconst_null
    //   383: astore 14
    //   385: ldc2_w 724
    //   388: lstore_2
    //   389: aload 12
    //   391: astore 15
    //   393: goto +220 -> 613
    //   396: astore 12
    //   398: aconst_null
    //   399: astore 13
    //   401: aload 16
    //   403: astore 14
    //   405: goto +271 -> 676
    //   408: astore 16
    //   410: ldc2_w 724
    //   413: lstore_2
    //   414: aconst_null
    //   415: astore 14
    //   417: aload 14
    //   419: astore 13
    //   421: aload 15
    //   423: astore 12
    //   425: ldc 85
    //   427: aload 16
    //   429: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: aload 15
    //   434: ifnull +11 -> 445
    //   437: aload 15
    //   439: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   442: goto +3 -> 445
    //   445: lload_2
    //   446: lstore_0
    //   447: aload 14
    //   449: ifnull +215 -> 664
    //   452: aload 14
    //   454: invokevirtual 652	java/io/BufferedReader:close	()V
    //   457: lload_2
    //   458: lreturn
    //   459: ldc 85
    //   461: aload 12
    //   463: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   466: lconst_0
    //   467: lreturn
    //   468: astore 16
    //   470: ldc2_w 724
    //   473: lstore_2
    //   474: aconst_null
    //   475: astore 14
    //   477: aload 13
    //   479: astore 15
    //   481: aload 14
    //   483: astore 13
    //   485: aload 15
    //   487: astore 12
    //   489: ldc 85
    //   491: aload 16
    //   493: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   496: aload 15
    //   498: ifnull +11 -> 509
    //   501: aload 15
    //   503: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   506: goto +3 -> 509
    //   509: lload_2
    //   510: lstore_0
    //   511: aload 14
    //   513: ifnull +151 -> 664
    //   516: aload 14
    //   518: invokevirtual 652	java/io/BufferedReader:close	()V
    //   521: lload_2
    //   522: lreturn
    //   523: ldc 85
    //   525: aload 12
    //   527: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   530: lconst_0
    //   531: lreturn
    //   532: astore 16
    //   534: ldc2_w 724
    //   537: lstore_2
    //   538: aconst_null
    //   539: astore 12
    //   541: aload 14
    //   543: astore 15
    //   545: aload 12
    //   547: astore 14
    //   549: aload 14
    //   551: astore 13
    //   553: aload 15
    //   555: astore 12
    //   557: ldc 85
    //   559: aload 16
    //   561: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload 15
    //   566: ifnull +11 -> 577
    //   569: aload 15
    //   571: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   574: goto +3 -> 577
    //   577: lload_2
    //   578: lstore_0
    //   579: aload 14
    //   581: ifnull +83 -> 664
    //   584: aload 14
    //   586: invokevirtual 652	java/io/BufferedReader:close	()V
    //   589: lload_2
    //   590: lreturn
    //   591: ldc 85
    //   593: aload 12
    //   595: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   598: lconst_0
    //   599: lreturn
    //   600: astore 16
    //   602: ldc2_w 724
    //   605: lstore_2
    //   606: aconst_null
    //   607: astore 14
    //   609: aload 17
    //   611: astore 15
    //   613: aload 14
    //   615: astore 13
    //   617: aload 15
    //   619: astore 12
    //   621: ldc 85
    //   623: aload 16
    //   625: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   628: aload 15
    //   630: ifnull +11 -> 641
    //   633: aload 15
    //   635: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   638: goto +3 -> 641
    //   641: lload_2
    //   642: lstore_0
    //   643: aload 14
    //   645: ifnull +19 -> 664
    //   648: aload 14
    //   650: invokevirtual 652	java/io/BufferedReader:close	()V
    //   653: lload_2
    //   654: lreturn
    //   655: ldc 85
    //   657: aload 12
    //   659: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   662: lconst_0
    //   663: lreturn
    //   664: lload_0
    //   665: lreturn
    //   666: astore 15
    //   668: aload 12
    //   670: astore 14
    //   672: aload 15
    //   674: astore 12
    //   676: aload 14
    //   678: ifnull +11 -> 689
    //   681: aload 14
    //   683: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   686: goto +3 -> 689
    //   689: aload 13
    //   691: ifnull +20 -> 711
    //   694: aload 13
    //   696: invokevirtual 652	java/io/BufferedReader:close	()V
    //   699: goto +12 -> 711
    //   702: ldc 85
    //   704: aload 12
    //   706: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   709: lconst_0
    //   710: lreturn
    //   711: aload 12
    //   713: athrow
    //   714: astore 12
    //   716: goto -257 -> 459
    //   719: astore 12
    //   721: goto -198 -> 523
    //   724: astore 12
    //   726: goto -135 -> 591
    //   729: astore 12
    //   731: goto -76 -> 655
    //   734: astore 12
    //   736: goto -34 -> 702
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	662	0	l1	long
    //   15	639	2	l2	long
    //   65	186	4	l3	long
    //   68	199	6	l4	long
    //   71	212	8	l5	long
    //   74	225	10	l6	long
    //   51	72	12	localInputStreamReader	java.io.InputStreamReader
    //   134	87	12	localThrowable1	Throwable
    //   232	86	12	localThrowable2	Throwable
    //   323	67	12	localObject1	Object
    //   396	1	12	localObject2	Object
    //   423	289	12	localObject3	Object
    //   714	1	12	localThrowable3	Throwable
    //   719	1	12	localThrowable4	Throwable
    //   724	1	12	localThrowable5	Throwable
    //   729	1	12	localThrowable6	Throwable
    //   734	1	12	localThrowable7	Throwable
    //   17	678	13	localObject4	Object
    //   20	179	14	str	String
    //   243	1	14	localObject5	Object
    //   255	49	14	localObject6	Object
    //   312	10	14	localObject7	Object
    //   327	355	14	localObject8	Object
    //   29	605	15	localObject9	Object
    //   666	7	15	localObject10	Object
    //   26	1	16	localObject11	Object
    //   248	1	16	localThrowable8	Throwable
    //   264	1	16	localException1	Exception
    //   280	1	16	localIOException1	IOException
    //   296	1	16	localFileNotFoundException1	java.io.FileNotFoundException
    //   332	1	16	localThrowable9	Throwable
    //   348	1	16	localException2	Exception
    //   364	1	16	localIOException2	IOException
    //   380	22	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   408	20	16	localThrowable10	Throwable
    //   468	24	16	localException3	Exception
    //   532	28	16	localIOException3	IOException
    //   600	24	16	localFileNotFoundException3	java.io.FileNotFoundException
    //   23	587	17	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   122	132	134	java/lang/Throwable
    //   220	230	232	java/lang/Throwable
    //   76	83	243	finally
    //   100	105	243	finally
    //   117	122	243	finally
    //   157	164	243	finally
    //   178	186	243	finally
    //   198	204	243	finally
    //   216	220	243	finally
    //   76	83	248	java/lang/Throwable
    //   100	105	248	java/lang/Throwable
    //   117	122	248	java/lang/Throwable
    //   157	164	248	java/lang/Throwable
    //   178	186	248	java/lang/Throwable
    //   198	204	248	java/lang/Throwable
    //   216	220	248	java/lang/Throwable
    //   76	83	264	java/lang/Exception
    //   100	105	264	java/lang/Exception
    //   117	122	264	java/lang/Exception
    //   157	164	264	java/lang/Exception
    //   178	186	264	java/lang/Exception
    //   198	204	264	java/lang/Exception
    //   216	220	264	java/lang/Exception
    //   76	83	280	java/io/IOException
    //   100	105	280	java/io/IOException
    //   117	122	280	java/io/IOException
    //   157	164	280	java/io/IOException
    //   178	186	280	java/io/IOException
    //   198	204	280	java/io/IOException
    //   216	220	280	java/io/IOException
    //   76	83	296	java/io/FileNotFoundException
    //   100	105	296	java/io/FileNotFoundException
    //   117	122	296	java/io/FileNotFoundException
    //   157	164	296	java/io/FileNotFoundException
    //   178	186	296	java/io/FileNotFoundException
    //   198	204	296	java/io/FileNotFoundException
    //   216	220	296	java/io/FileNotFoundException
    //   53	64	312	finally
    //   53	64	332	java/lang/Throwable
    //   53	64	348	java/lang/Exception
    //   53	64	364	java/io/IOException
    //   53	64	380	java/io/FileNotFoundException
    //   31	53	396	finally
    //   31	53	408	java/lang/Throwable
    //   31	53	468	java/lang/Exception
    //   31	53	532	java/io/IOException
    //   31	53	600	java/io/FileNotFoundException
    //   425	432	666	finally
    //   489	496	666	finally
    //   557	564	666	finally
    //   621	628	666	finally
    //   437	442	714	java/lang/Throwable
    //   452	457	714	java/lang/Throwable
    //   501	506	719	java/lang/Throwable
    //   516	521	719	java/lang/Throwable
    //   569	574	724	java/lang/Throwable
    //   584	589	724	java/lang/Throwable
    //   633	638	729	java/lang/Throwable
    //   648	653	729	java/lang/Throwable
    //   681	686	734	java/lang/Throwable
    //   694	699	734	java/lang/Throwable
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
      deviceIMEI = PhoneInfoMonitor.getDeviceId(paramContext);
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
        deviceIMSI = PhoneInfoMonitor.getSubscriberId(paramContext);
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
    deviceMacAddr = getDeviceMacAddrImpl(paramContext);
    if (TextUtils.isEmpty(deviceMacAddr)) {
      deviceMacAddr = "NONE";
    }
    return deviceMacAddr;
  }
  
  private static String getDeviceMacAddrImpl(Context paramContext)
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
          break label152;
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
            break label154;
          }
          localStringBuilder.append(":");
          break label154;
        }
        paramContext = localStringBuilder.toString().toUpperCase();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
        return "";
      }
      paramContext = getLowerMarshmallowDeviceMacAddr(paramContext);
      label152:
      return paramContext;
      label154:
      i += 1;
    }
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getGuidFromPhoneStorage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = paramContext.getPackageName();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(GUID_PHONE_PATH);
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("/");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(GUID_PHONE_PATH);
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("/guid");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      paramContext = localObject1;
      if (((File)localObject2).exists()) {
        paramContext = readStringFromFile((File)localObject2);
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      paramContext = localObject1;
    }
    if (paramContext == null) {
      return "";
    }
    return paramContext;
  }
  
  public static String getGuidFromStorage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = getGuidFromPhoneStorage(paramContext);
      if (paramContext != null) {
        try
        {
          boolean bool = paramContext.equals("guiderror");
          if (!bool) {
            return paramContext;
          }
        }
        catch (Exception localException1)
        {
          break label42;
        }
      }
      return "";
    }
    catch (Exception localException2)
    {
      paramContext = "";
      label42:
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", localException2);
    }
    return paramContext;
  }
  
  public static String getIP(Context paramContext)
  {
    if (TextUtils.isEmpty(mCurrentIP)) {
      updateNetworkIp(paramContext);
    }
    return mCurrentIP;
  }
  
  private static String getLowerMarshmallowDeviceMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return "";
  }
  
  public static int getMCC(Context paramContext)
  {
    int i = mMCC;
    if (i != 0) {
      return i;
    }
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMCC = paramContext.mcc;
      }
      i = mMCC;
      return i;
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return 0;
  }
  
  public static int getMNC(Context paramContext)
  {
    int i = mMNC;
    if (i != 0) {
      return i;
    }
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMNC = paramContext.mnc;
      }
      i = mMNC;
      return i;
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return 0;
  }
  
  /* Error */
  public static int getMarketId(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 861	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mReadMarketId	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 863	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mMarketId	I
    //   9: ireturn
    //   10: iconst_m1
    //   11: istore_2
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: aload_0
    //   19: invokevirtual 553	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   22: invokevirtual 867	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   25: ldc_w 869
    //   28: invokevirtual 875	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 4
    //   33: new 642	java/io/BufferedReader
    //   36: dup
    //   37: new 628	java/io/InputStreamReader
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 878	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 645	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_0
    //   50: aload_0
    //   51: astore 5
    //   53: aload 4
    //   55: astore 6
    //   57: aload_0
    //   58: invokevirtual 648	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 7
    //   63: iload_2
    //   64: istore_1
    //   65: aload_0
    //   66: astore 5
    //   68: aload 4
    //   70: astore 6
    //   72: aload 7
    //   74: invokestatic 444	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +80 -> 157
    //   80: iload_2
    //   81: istore_1
    //   82: aload_0
    //   83: astore 5
    //   85: aload 4
    //   87: astore 6
    //   89: aload 7
    //   91: ldc_w 880
    //   94: invokevirtual 482	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +60 -> 157
    //   100: aload_0
    //   101: astore 5
    //   103: aload 4
    //   105: astore 6
    //   107: aload 7
    //   109: aload 7
    //   111: ldc_w 882
    //   114: invokevirtual 884	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: iconst_1
    //   118: iadd
    //   119: invokevirtual 886	java/lang/String:substring	(I)Ljava/lang/String;
    //   122: astore 7
    //   124: iload_2
    //   125: istore_1
    //   126: aload_0
    //   127: astore 5
    //   129: aload 4
    //   131: astore 6
    //   133: aload 7
    //   135: invokestatic 444	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +19 -> 157
    //   141: aload_0
    //   142: astore 5
    //   144: aload 4
    //   146: astore 6
    //   148: aload 7
    //   150: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   153: invokestatic 889	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_1
    //   157: aload 4
    //   159: ifnull +13 -> 172
    //   162: iload_1
    //   163: istore_3
    //   164: aload 4
    //   166: invokevirtual 892	java/io/InputStream:close	()V
    //   169: goto +3 -> 172
    //   172: iload_1
    //   173: istore_3
    //   174: aload_0
    //   175: invokevirtual 652	java/io/BufferedReader:close	()V
    //   178: goto +89 -> 267
    //   181: aload_0
    //   182: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
    //   185: iload_3
    //   186: istore_1
    //   187: goto +80 -> 267
    //   190: astore 7
    //   192: goto +35 -> 227
    //   195: astore_0
    //   196: aconst_null
    //   197: astore 5
    //   199: goto +83 -> 282
    //   202: astore 7
    //   204: aconst_null
    //   205: astore_0
    //   206: goto +21 -> 227
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 4
    //   213: aload 4
    //   215: astore 5
    //   217: goto +65 -> 282
    //   220: astore 7
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: astore 4
    //   227: aload_0
    //   228: astore 5
    //   230: aload 4
    //   232: astore 6
    //   234: ldc 85
    //   236: aload 7
    //   238: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload 4
    //   243: ifnull +10 -> 253
    //   246: iload_2
    //   247: istore_3
    //   248: aload 4
    //   250: invokevirtual 892	java/io/InputStream:close	()V
    //   253: iload_2
    //   254: istore_1
    //   255: aload_0
    //   256: ifnull +11 -> 267
    //   259: iload_2
    //   260: istore_3
    //   261: aload_0
    //   262: invokevirtual 652	java/io/BufferedReader:close	()V
    //   265: iload_2
    //   266: istore_1
    //   267: iload_1
    //   268: putstatic 863	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mMarketId	I
    //   271: iconst_1
    //   272: putstatic 861	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mReadMarketId	Z
    //   275: iload_1
    //   276: ireturn
    //   277: astore_0
    //   278: aload 6
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +11 -> 295
    //   287: aload 4
    //   289: invokevirtual 892	java/io/InputStream:close	()V
    //   292: goto +3 -> 295
    //   295: aload 5
    //   297: ifnull +16 -> 313
    //   300: aload 5
    //   302: invokevirtual 652	java/io/BufferedReader:close	()V
    //   305: goto +8 -> 313
    //   308: aload 4
    //   310: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
    //   313: aload_0
    //   314: athrow
    //   315: astore_0
    //   316: goto -135 -> 181
    //   319: astore 4
    //   321: goto -13 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	Context
    //   64	212	1	i	int
    //   11	255	2	j	int
    //   163	98	3	k	int
    //   31	278	4	localObject1	Object
    //   319	1	4	localThrowable1	Throwable
    //   51	250	5	localObject2	Object
    //   55	224	6	localObject3	Object
    //   61	88	7	str	String
    //   190	1	7	localThrowable2	Throwable
    //   202	1	7	localThrowable3	Throwable
    //   220	17	7	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	63	190	java/lang/Throwable
    //   72	80	190	java/lang/Throwable
    //   89	100	190	java/lang/Throwable
    //   107	124	190	java/lang/Throwable
    //   133	141	190	java/lang/Throwable
    //   148	157	190	java/lang/Throwable
    //   33	50	195	finally
    //   33	50	202	java/lang/Throwable
    //   18	33	209	finally
    //   18	33	220	java/lang/Throwable
    //   57	63	277	finally
    //   72	80	277	finally
    //   89	100	277	finally
    //   107	124	277	finally
    //   133	141	277	finally
    //   148	157	277	finally
    //   234	241	277	finally
    //   164	169	315	java/lang/Throwable
    //   174	178	315	java/lang/Throwable
    //   248	253	315	java/lang/Throwable
    //   261	265	315	java/lang/Throwable
    //   287	292	319	java/lang/Throwable
    //   300	305	319	java/lang/Throwable
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: getstatic 408	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   3: lstore_0
    //   4: ldc2_w 405
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
    //   25: new 628	java/io/InputStreamReader
    //   28: dup
    //   29: new 630	java/io/FileInputStream
    //   32: dup
    //   33: ldc_w 896
    //   36: invokespecial 635	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: ldc_w 637
    //   42: invokespecial 640	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   45: astore 6
    //   47: new 642	java/io/BufferedReader
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 645	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 648	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 8
    //   65: aload 8
    //   67: ifnonnull +36 -> 103
    //   70: aload 6
    //   72: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   75: aload 7
    //   77: invokevirtual 652	java/io/BufferedReader:close	()V
    //   80: aload 6
    //   82: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   85: aload 7
    //   87: invokevirtual 652	java/io/BufferedReader:close	()V
    //   90: lconst_0
    //   91: lreturn
    //   92: astore 6
    //   94: ldc 85
    //   96: aload 6
    //   98: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: lconst_0
    //   102: lreturn
    //   103: aload 8
    //   105: invokevirtual 673	java/lang/String:trim	()Ljava/lang/String;
    //   108: astore 8
    //   110: lload_2
    //   111: lstore_0
    //   112: aload 8
    //   114: invokevirtual 622	java/lang/String:length	()I
    //   117: ifle +9 -> 126
    //   120: aload 8
    //   122: invokestatic 681	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   125: lstore_0
    //   126: lload_0
    //   127: lstore 4
    //   129: aload 6
    //   131: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   134: lload_0
    //   135: lstore 4
    //   137: aload 7
    //   139: invokevirtual 652	java/io/BufferedReader:close	()V
    //   142: goto +153 -> 295
    //   145: astore 6
    //   147: ldc 85
    //   149: aload 6
    //   151: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: lload 4
    //   156: lstore_0
    //   157: goto +138 -> 295
    //   160: astore 9
    //   162: aload 7
    //   164: astore 8
    //   166: aload 9
    //   168: astore 7
    //   170: goto +19 -> 189
    //   173: goto +59 -> 232
    //   176: goto +89 -> 265
    //   179: astore 7
    //   181: goto +8 -> 189
    //   184: astore 7
    //   186: aconst_null
    //   187: astore 6
    //   189: aload 6
    //   191: ifnull +11 -> 202
    //   194: aload 6
    //   196: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   199: goto +3 -> 202
    //   202: aload 8
    //   204: ifnull +18 -> 222
    //   207: aload 8
    //   209: invokevirtual 652	java/io/BufferedReader:close	()V
    //   212: goto +10 -> 222
    //   215: ldc 85
    //   217: aload 6
    //   219: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 7
    //   224: athrow
    //   225: aconst_null
    //   226: astore 6
    //   228: aload 9
    //   230: astore 7
    //   232: aload 6
    //   234: ifnull +11 -> 245
    //   237: lload_2
    //   238: lstore 4
    //   240: aload 6
    //   242: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   245: lload_2
    //   246: lstore_0
    //   247: aload 7
    //   249: ifnull +46 -> 295
    //   252: lload_2
    //   253: lstore 4
    //   255: aload 7
    //   257: invokevirtual 652	java/io/BufferedReader:close	()V
    //   260: lload_2
    //   261: lstore_0
    //   262: goto +33 -> 295
    //   265: aload 6
    //   267: ifnull +11 -> 278
    //   270: lload_2
    //   271: lstore 4
    //   273: aload 6
    //   275: invokevirtual 651	java/io/InputStreamReader:close	()V
    //   278: lload_2
    //   279: lstore_0
    //   280: aload 7
    //   282: ifnull +13 -> 295
    //   285: lload_2
    //   286: lstore 4
    //   288: aload 7
    //   290: invokevirtual 652	java/io/BufferedReader:close	()V
    //   293: lload_2
    //   294: lstore_0
    //   295: lload_0
    //   296: putstatic 408	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   299: new 142	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   306: astore 6
    //   308: aload 6
    //   310: ldc_w 898
    //   313: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 6
    //   319: getstatic 408	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   322: invokevirtual 901	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: ldc 85
    //   328: aload 6
    //   330: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 697	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: lload_0
    //   337: lreturn
    //   338: astore 6
    //   340: goto +41 -> 381
    //   343: astore 6
    //   345: goto -120 -> 225
    //   348: astore 7
    //   350: aload 10
    //   352: astore 7
    //   354: goto -89 -> 265
    //   357: astore 7
    //   359: aload 9
    //   361: astore 7
    //   363: goto -131 -> 232
    //   366: astore 8
    //   368: goto -192 -> 176
    //   371: astore 8
    //   373: goto -200 -> 173
    //   376: astore 6
    //   378: goto -163 -> 215
    //   381: aconst_null
    //   382: astore 6
    //   384: aload 10
    //   386: astore 7
    //   388: goto -123 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	334	0	l1	long
    //   24	270	2	l2	long
    //   127	160	4	l3	long
    //   45	36	6	localInputStreamReader	java.io.InputStreamReader
    //   92	38	6	localIOException1	IOException
    //   145	5	6	localIOException2	IOException
    //   187	142	6	localObject1	Object
    //   338	1	6	localIOException3	IOException
    //   343	1	6	localThrowable1	Throwable
    //   376	1	6	localIOException4	IOException
    //   382	1	6	localObject2	Object
    //   56	113	7	localObject3	Object
    //   179	1	7	localObject4	Object
    //   184	39	7	localObject5	Object
    //   230	59	7	localObject6	Object
    //   348	1	7	localIOException5	IOException
    //   352	1	7	localObject7	Object
    //   357	1	7	localThrowable2	Throwable
    //   361	26	7	localObject8	Object
    //   21	187	8	localObject9	Object
    //   366	1	8	localIOException6	IOException
    //   371	1	8	localThrowable3	Throwable
    //   15	1	9	localObject10	Object
    //   160	200	9	localObject11	Object
    //   18	367	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   80	90	92	java/io/IOException
    //   129	134	145	java/io/IOException
    //   137	142	145	java/io/IOException
    //   240	245	145	java/io/IOException
    //   255	260	145	java/io/IOException
    //   273	278	145	java/io/IOException
    //   288	293	145	java/io/IOException
    //   58	65	160	finally
    //   70	80	160	finally
    //   103	110	160	finally
    //   112	126	160	finally
    //   47	58	179	finally
    //   25	47	184	finally
    //   25	47	338	java/io/IOException
    //   25	47	343	java/lang/Throwable
    //   47	58	348	java/io/IOException
    //   47	58	357	java/lang/Throwable
    //   58	65	366	java/io/IOException
    //   70	80	366	java/io/IOException
    //   103	110	366	java/io/IOException
    //   112	126	366	java/io/IOException
    //   58	65	371	java/lang/Throwable
    //   70	80	371	java/lang/Throwable
    //   103	110	371	java/lang/Throwable
    //   112	126	371	java/lang/Throwable
    //   194	199	376	java/io/IOException
    //   207	212	376	java/io/IOException
  }
  
  public static int getMobileNetOperator(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return 0;
      }
      paramContext = paramContext.getNetworkOperator();
      if (!TextUtils.isEmpty(paramContext)) {
        if ((!paramContext.equals("46000")) && (!paramContext.equals("46002")) && (!paramContext.equals("46007")))
        {
          if (paramContext.equals("46001")) {
            return 2;
          }
          boolean bool = paramContext.equals("46003");
          if (bool) {
            return 1;
          }
        }
        else
        {
          return 3;
        }
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return 0;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    int i = mNetWorkType;
    if ((i != -1) && (!isNetworkChange)) {
      return i;
    }
    mNetWorkType = 0;
    if (paramContext != null) {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if (paramContext != null)
          {
            i = paramContext.getType();
            if (i != 0) {
              if (i != 1)
              {
                if ((i != 2) && (i != 3) && (i != 4) && (i != 5))
                {
                  if (i != 9)
                  {
                    mNetWorkType = 4;
                    break label148;
                  }
                  mNetWorkType = 5;
                  break label148;
                }
              }
              else
              {
                mNetWorkType = 1;
                break label148;
              }
            }
            mNetWorkType = 2;
            if ((paramContext.getExtraInfo() != null) && (!"cmnet".equalsIgnoreCase(paramContext.getExtraInfo()))) {
              mNetWorkType = 3;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      }
    }
    label148:
    return mNetWorkType;
  }
  
  public static int getNetWorkTypeInRealTime(Context paramContext)
  {
    if (paramContext == null) {
      mNetWorkType = 0;
    } else {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if (paramContext != null)
          {
            int i = paramContext.getType();
            if (i != 0) {
              if (i != 1)
              {
                if ((i != 2) && (i != 3) && (i != 4) && (i != 5))
                {
                  if (i != 9)
                  {
                    mNetWorkType = 4;
                    break label134;
                  }
                  mNetWorkType = 5;
                  break label134;
                }
              }
              else
              {
                mNetWorkType = 1;
                break label134;
              }
            }
            mNetWorkType = 2;
            if ((paramContext.getExtraInfo() != null) && (!"cmnet".equalsIgnoreCase(paramContext.getExtraInfo()))) {
              mNetWorkType = 3;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      }
    }
    label134:
    return mNetWorkType;
  }
  
  private static int getNetworkClass(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 13: 
      return 4;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 2;
  }
  
  public static int getNetworkClass(Context paramContext)
  {
    int i = mNetWorkClass;
    if ((i != -1) && (!isNetworkChange)) {
      return i;
    }
    if (paramContext == null) {
      return 0;
    }
    mNetWorkClass = 0;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          i = paramContext.getType();
          if (i != 0)
          {
            if (i != 1) {
              mNetWorkClass = 0;
            } else {
              mNetWorkClass = 1;
            }
          }
          else {
            mNetWorkClass = getNetworkClass(paramContext.getSubtype());
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      mNetWorkClass = 0;
    }
    return mNetWorkClass;
  }
  
  public static int getNumCores()
  {
    int i = numOfCores;
    if (-1 != i) {
      return i;
    }
    try
    {
      Object localObject = new File("/sys/devices/system/cpu/").listFiles(new TVKVcSystemInfo.1CpuFilter());
      if (localObject == null)
      {
        numOfCores = 1;
        return numOfCores;
      }
      numOfCores = localObject.length;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("core num ");
      ((StringBuilder)localObject).append(numOfCores);
      TVKLogUtil.i("MediaPlayerMgr[TVKVcSystemInfo.java]", ((StringBuilder)localObject).toString());
      i = numOfCores;
      return i;
    }
    catch (Exception localException)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", localException);
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
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      }
    }
    return mOpenGLVersion;
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getPackageName()
  {
    if (!TextUtils.isEmpty(mPackageName)) {
      return mPackageName;
    }
    Context localContext = TVideoMgr.getApplicationContext();
    if (localContext != null) {
      mPackageName = localContext.getPackageName();
    }
    return mPackageName;
  }
  
  public static int getPlayerLevel()
  {
    int i = mDeviceLevel;
    if (-1 != i) {
      return i;
    }
    mDeviceLevel = 11;
    if (getCpuArchitecture() < 6) {
      mDeviceLevel = 1;
    }
    if ((getNumCores() == 1) && (getMaxCpuFreq() / 1000L <= 1000L)) {
      mDeviceLevel = 6;
    }
    if (((getNumCores() == 1) && (getMaxCpuFreq() / 1000L > 1000L)) || ((getNumCores() == 2) && (getMaxCpuFreq() / 1000L < 1400L))) {
      mDeviceLevel = 11;
    }
    if ((getNumCores() == 2) && (getMaxCpuFreq() / 1000L >= 1400L)) {
      mDeviceLevel = 16;
    }
    if (getNumCores() >= 4) {
      mDeviceLevel = 21;
    }
    return mDeviceLevel;
  }
  
  public static int getRecordLevel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRecordLevel], numCores = ");
    localStringBuilder.append(getNumCores());
    localStringBuilder.append(", totalMem = ");
    localStringBuilder.append(getTotalMem(TVideoMgr.getApplicationContext()));
    TVKLogUtil.i("MediaPlayerMgr[TVKVcSystemInfo.java]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRecordLevel], mCpuHWProducter = ");
    localStringBuilder.append(mCpuHWProducter);
    localStringBuilder.append(", getMaxCpuFreq() = ");
    localStringBuilder.append(getMaxCpuFreq());
    localStringBuilder.append(" mCpuHWProductIdx=");
    localStringBuilder.append(mCpuHWProductIdx);
    TVKLogUtil.i("MediaPlayerMgr[TVKVcSystemInfo.java]", localStringBuilder.toString());
    int i = mRecordLevel;
    if (-1 != i) {
      return i;
    }
    i = mCpuHWProducter;
    if (-1 == i) {
      getRecordLevelByNumCores();
    } else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.sumsing_720p_index.getValue()).intValue()) {
              mRecordLevel = 3;
            } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.sumsing_480p_index.getValue()).intValue()) {
              mRecordLevel = 2;
            } else {
              getRecordLevelByNumCores();
            }
          }
        }
        else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hisi_720p_index.getValue()).intValue()) {
          mRecordLevel = 3;
        } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hisi_480p_index.getValue()).intValue()) {
          mRecordLevel = 2;
        } else {
          getRecordLevelByNumCores();
        }
      }
      else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.mtk_720p_index.getValue()).intValue()) {
        mRecordLevel = 3;
      } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.mtk_480p_index.getValue()).intValue()) {
        mRecordLevel = 2;
      } else {
        getRecordLevelByNumCores();
      }
    }
    else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.qualcomm_720p_index.getValue()).intValue()) {
      mRecordLevel = 3;
    } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.qualcomm_480p_index.getValue()).intValue()) {
      mRecordLevel = 2;
    } else {
      getRecordLevelByNumCores();
    }
    return mRecordLevel;
  }
  
  private static int getRecordLevelByNumCores()
  {
    if (getNumCores() >= 8)
    {
      if (getMaxCpuFreq() / 1000L >= 1900L) {
        mRecordLevel = 3;
      } else {
        mRecordLevel = 2;
      }
    }
    else if (getNumCores() >= 4)
    {
      if (getMaxCpuFreq() / 1000L >= 2500L) {
        mRecordLevel = 3;
      } else {
        mRecordLevel = 2;
      }
    }
    else {
      mRecordLevel = 1;
    }
    return mRecordLevel;
  }
  
  public static String getSSID(Context paramContext)
  {
    if (!TextUtils.isEmpty(sSSID)) {
      return sSSID;
    }
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getApplicationContext().getSystemService("wifi"));
      if (paramContext != null)
      {
        sSSID = paramContext.getSSID();
        sBSSID = paramContext.getBSSID();
        paramContext = sSSID;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return "";
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
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramString1);
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
  
  @TargetApi(16)
  public static long getTotalMem(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext == null) {
      return 0L;
    }
    long l2 = sTotalMem;
    if (l2 > 0L) {
      return l2;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
        sTotalMem = localMemoryInfo.totalMem / 1048576L;
        l1 = sTotalMem;
      }
      return l1;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public static int getWifiNetStrength(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getApplicationContext().getSystemService("wifi"));
      if (paramContext == null) {
        return 0;
      }
      i = paramContext.getRssi();
      if (Build.VERSION.SDK_INT < 14) {}
    }
    catch (Throwable paramContext)
    {
      int i;
      float f;
      return 0;
    }
    try
    {
      i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 101);
      return i;
    }
    catch (Throwable paramContext) {}
    if (i <= -100) {
      return 0;
    }
    if (i >= -55) {
      return 100;
    }
    f = 100;
    return (int)((i + 100) * f / 45.0F);
    return 0;
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
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", localThrowable);
    }
    return "wlan0";
  }
  
  private static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isExternalStorageMounted()
  {
    int i = externalStorageMounted;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != -1)
    {
      if (i == 1) {
        bool1 = true;
      }
      return bool1;
    }
    for (;;)
    {
      try
      {
        if (!Environment.getExternalStorageState().equals("mounted")) {
          break label66;
        }
        i = 1;
        externalStorageMounted = i;
      }
      catch (Exception localException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", localException);
      }
      bool1 = bool2;
      if (externalStorageMounted == 1) {
        bool1 = true;
      }
      return bool1;
      label66:
      i = 0;
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    int i = isNetworkAvailable;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((i != -1) && (!isNetworkChange))
    {
      if (i == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramContext != null) {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
        if (paramContext == null)
        {
          isNetworkAvailable = 0;
        }
        else
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext != null) && (paramContext.isAvailable()))
          {
            if (paramContext.getState() == NetworkInfo.State.CONNECTED) {
              isNetworkAvailable = 1;
            } else {
              isNetworkAvailable = 0;
            }
          }
          else {
            isNetworkAvailable = 0;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    bool1 = bool2;
    if (isNetworkAvailable == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isNetworkTypeMobile(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          int i = paramContext.getType();
          return (i == 0) || (i == 2) || (i == 3) || (i == 4) || (i == 5);
        }
      }
    }
    catch (Exception paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
    }
    return true;
  }
  
  public static void onNetworkChange(Context paramContext)
  {
    isNetworkChange = true;
    isNetworkAvailable(paramContext);
    getNetWorkType(paramContext);
    getNetworkClass(paramContext);
    isNetworkChange = false;
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
    //   10: new 642	java/io/BufferedReader
    //   13: dup
    //   14: new 1160	java/io/FileReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 1163	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   22: invokespecial 645	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: invokevirtual 1165	java/io/File:length	()J
    //   32: ldc2_w 1166
    //   35: lcmp
    //   36: ifle +6 -> 42
    //   39: goto +43 -> 82
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: invokevirtual 1165	java/io/File:length	()J
    //   48: l2i
    //   49: newarray char
    //   51: astore 5
    //   53: aload_1
    //   54: astore_2
    //   55: aload_1
    //   56: aload 5
    //   58: iconst_0
    //   59: aload_0
    //   60: invokevirtual 1165	java/io/File:length	()J
    //   63: l2i
    //   64: invokevirtual 1171	java/io/BufferedReader:read	([CII)I
    //   67: ifle +15 -> 82
    //   70: aload_1
    //   71: astore_2
    //   72: new 168	java/lang/String
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 1174	java/lang/String:<init>	([C)V
    //   81: astore_3
    //   82: aload_3
    //   83: astore_0
    //   84: aload_1
    //   85: invokevirtual 652	java/io/BufferedReader:close	()V
    //   88: aload_3
    //   89: areturn
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
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
    //   117: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
    //   120: aload_1
    //   121: ifnull +10 -> 131
    //   124: aload 4
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 652	java/io/BufferedReader:close	()V
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
    //   148: invokevirtual 652	java/io/BufferedReader:close	()V
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
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
    //   4: new 1177	java/io/RandomAccessFile
    //   7: dup
    //   8: ldc_w 1179
    //   11: ldc_w 1181
    //   14: invokespecial 1183	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual 1184	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 1185	java/io/RandomAccessFile:close	()V
    //   31: aload_2
    //   32: areturn
    //   33: astore_1
    //   34: ldc 85
    //   36: aload_1
    //   37: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: aload_0
    //   41: areturn
    //   42: astore_2
    //   43: goto +10 -> 53
    //   46: astore_0
    //   47: goto +29 -> 76
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: invokevirtual 893	java/lang/Throwable:printStackTrace	()V
    //   59: aload_1
    //   60: ifnull +9 -> 69
    //   63: aload_3
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 1185	java/io/RandomAccessFile:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_1
    //   72: aload_0
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: ifnull +17 -> 94
    //   80: aload_2
    //   81: invokevirtual 1185	java/io/RandomAccessFile:close	()V
    //   84: goto +10 -> 94
    //   87: astore_1
    //   88: ldc 85
    //   90: aload_1
    //   91: invokestatic 488	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	22	0	localObject1	Object
    //   46	1	0	localObject2	Object
    //   54	41	0	localObject3	Object
    //   17	11	1	localRandomAccessFile	java.io.RandomAccessFile
    //   33	4	1	localThrowable1	Throwable
    //   52	14	1	localObject4	Object
    //   71	4	1	localObject5	Object
    //   87	4	1	localThrowable2	Throwable
    //   1	31	2	str	String
    //   42	1	2	localThrowable3	Throwable
    //   50	6	2	localThrowable4	Throwable
    //   73	8	2	localObject6	Object
    //   3	61	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	33	java/lang/Throwable
    //   65	69	33	java/lang/Throwable
    //   20	25	42	java/lang/Throwable
    //   4	18	46	finally
    //   4	18	50	java/lang/Throwable
    //   20	25	71	finally
    //   55	59	71	finally
    //   80	84	87	java/lang/Throwable
  }
  
  public static void updateNetworkIp(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {
        return;
      }
      if ((paramContext.isWifiEnabled()) && (paramContext.getWifiState() == 3))
      {
        paramContext = NetworkMonitor.getConnectionInfo(paramContext);
        if (paramContext != null)
        {
          int i = paramContext.getIpAddress();
          if (i == 0)
          {
            mCurrentIP = "";
            return;
          }
          paramContext = new StringBuilder();
          paramContext.append(i & 0xFF);
          paramContext.append(".");
          paramContext.append(i >> 8 & 0xFF);
          paramContext.append(".");
          paramContext.append(i >> 16 & 0xFF);
          paramContext.append(".");
          paramContext.append(i >> 24 & 0xFF);
          mCurrentIP = paramContext.toString();
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKVcSystemInfo.java]", paramContext);
      try
      {
        paramContext = NetworkMonitor.getNetworkInterfaces();
        if (paramContext == null) {}
        InetAddress localInetAddress;
        do
        {
          return;
          Enumeration localEnumeration;
          while (!localEnumeration.hasMoreElements())
          {
            if (!paramContext.hasMoreElements()) {
              break;
            }
            localEnumeration = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
          }
          localInetAddress = (InetAddress)localEnumeration.nextElement();
        } while (localInetAddress.isLoopbackAddress());
        mCurrentIP = localInetAddress.getHostAddress();
        return;
      }
      catch (SocketException paramContext)
      {
        paramContext.printStackTrace();
        mCurrentIP = "";
      }
    }
  }
  
  private static void writeGuidToPhoneStorage(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GUID_PHONE_PATH);
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/guid");
    writeStringToFile(localStringBuilder.toString(), paramString2);
  }
  
  public static void writeGuidToStorage(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    writeGuidToPhoneStorage(paramContext.getPackageName(), paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo
 * JD-Core Version:    0.7.0.1
 */