package com.tencent.qqlive.tvkplayer.tools.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
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
  private static final String GUID_PHONE_PATH = Environment.getDataDirectory() + "/data/";
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
  private static final String TAG = "MediaPlayerMgr";
  public static final int TYPE_CMNET = 2;
  public static final int TYPE_CMWAP = 3;
  public static final int TYPE_ETHERNET = 5;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_OTHER = 4;
  public static final int TYPE_WIFI = 1;
  private static String appVersionName;
  private static int cpuArch;
  private static final String[][] cpuPerfList;
  private static long currentCpuFreq;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI;
  private static String deviceMacAddr;
  private static int externalStorageMounted;
  private static Method getWlanMethod;
  private static int isNetworkAvailable;
  private static boolean isNetworkChange;
  private static long mAppInstallTime;
  private static int mCpuArchitecture;
  private static int mCpuHWProductIdx;
  private static int mCpuHWProducter;
  private static String mCpuHardware;
  private static String mCurrentIP;
  private static int mDeviceLevel;
  private static String mFeature;
  private static int mMCC;
  private static int mMNC;
  private static int mMarketId;
  private static int mNetWorkClass = -1;
  private static int mNetWorkType;
  private static int mOpenGLVersion = 0;
  private static String mPackageName = "";
  private static String mProcessorName = "N/A";
  private static boolean mReadMarketId;
  private static int mRecordLevel;
  public static int mScreenHeight;
  public static int mScreenWidth;
  private static long maxCpuFreq;
  private static int numOfCores;
  private static String sBSSID;
  private static String sMacAddr;
  private static String sSSID;
  private static long sTotalMem;
  
  static
  {
    mFeature = "";
    mCpuHardware = "";
    mCpuArchitecture = 0;
    mMCC = 0;
    mMNC = 0;
    mCpuHWProducter = -1;
    mCpuHWProductIdx = -1;
    mDeviceLevel = -1;
    mReadMarketId = false;
    mMarketId = 0;
    sSSID = "";
    mCurrentIP = "";
    sBSSID = "";
    sMacAddr = "";
    sTotalMem = 0L;
    mRecordLevel = -1;
    String[] arrayOfString = { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" };
    cpuPerfList = new String[][] { { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro" }, { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" }, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960" }, arrayOfString };
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
              break label146;
            }
            localStringBuilder.append(":");
            break label146;
          }
          paramContext = localStringBuilder.toString().toUpperCase();
        }
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr", paramContext);
        return "";
      }
      return getLowerMarshmallowDeviceMacAddr(paramContext);
      label146:
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
  
  public static boolean detectDolbyDevice()
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
      TVKLogUtil.e("MediaPlayerMgr", localException1);
      bool2 = bool1;
    }
    return bool2;
  }
  
  public static long getAppInstallTime(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    if (0L != mAppInstallTime) {
      return mAppInstallTime;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      long l = new File(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0).sourceDir).lastModified() / 1000L;
      mAppInstallTime = l;
      return l;
    }
    catch (Throwable paramContext)
    {
      return 0L;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 0L;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    Object localObject;
    if (!TextUtils.isEmpty(appVersionName)) {
      localObject = appVersionName;
    }
    for (;;)
    {
      return localObject;
      localObject = "";
      if (paramContext != null) {
        try
        {
          appVersionName = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
          paramContext = appVersionName;
          localObject = paramContext;
          if (paramContext == null) {
            return "";
          }
        }
        catch (Throwable paramContext) {}
      }
    }
    return "";
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
      paramContext = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
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
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return "";
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
        if ((!TextUtils.isEmpty(mCpuHardware)) && (mCpuHardware.contains("MSM8994")))
        {
          cpuArch = 7;
          return cpuArch;
        }
        if ((getDeviceName().equals("XT882")) || (getDeviceName().equals("ME860")) || (getDeviceName().equals("MB860")) || (getDeviceName().equals("Lenovo P70")) || (getDeviceName().equals("Lenovo A60")) || (getDeviceName().equals("Lenovo A366t")))
        {
          cpuArch = 3;
          return cpuArch;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("ARMv6")))
        {
          cpuArch = 4;
          return cpuArch;
        }
        if ((!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon")))
        {
          cpuArch = 4;
          return cpuArch;
        }
        switch (mCpuArchitecture)
        {
        default: 
          cpuArch = 0;
          break;
        case 5: 
          cpuArch = 3;
          break;
        case 6: 
          cpuArch = 4;
          break;
        case 7: 
          cpuArch = 6;
          break;
        case 8: 
        case 9: 
        case 10: 
          cpuArch = 50;
          break;
        case 64: 
          cpuArch = 7;
        }
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
      if ((paramString.contains("MSM")) || (paramString.contains("APQ")) || (paramString.contains("QSD"))) {
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 694	java/io/InputStreamReader
    //   8: dup
    //   9: new 696	java/io/FileInputStream
    //   12: dup
    //   13: ldc_w 698
    //   16: invokespecial 699	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: ldc_w 701
    //   22: invokespecial 704	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: astore_2
    //   26: new 706	java/io/BufferedReader
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 712	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +20 -> 61
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 716	java/io/BufferedReader:close	()V
    //   60: return
    //   61: aload_3
    //   62: ldc_w 718
    //   65: invokevirtual 556	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifne +13 -> 81
    //   71: aload_3
    //   72: ldc_w 720
    //   75: invokevirtual 556	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   78: ifeq +8 -> 86
    //   81: bipush 64
    //   83: putstatic 147	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   86: aload_3
    //   87: ldc_w 722
    //   90: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq +77 -> 170
    //   96: aload_3
    //   97: bipush 58
    //   99: invokevirtual 730	java/lang/String:indexOf	(I)I
    //   102: istore_0
    //   103: iload_0
    //   104: iconst_1
    //   105: if_icmple -70 -> 35
    //   108: aload_3
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: aload_3
    //   113: invokevirtual 494	java/lang/String:length	()I
    //   116: invokevirtual 734	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: putstatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   122: getstatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   125: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   128: putstatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mProcessorName	Ljava/lang/String;
    //   131: goto -96 -> 35
    //   134: astore_3
    //   135: ldc_w 739
    //   138: putstatic 145	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   141: iconst_0
    //   142: putstatic 147	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   153: aload_1
    //   154: ifnull -94 -> 60
    //   157: aload_1
    //   158: invokevirtual 716	java/io/BufferedReader:close	()V
    //   161: return
    //   162: astore_1
    //   163: ldc 85
    //   165: aload_1
    //   166: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: return
    //   170: aload_3
    //   171: ldc_w 741
    //   174: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   177: ifeq +111 -> 288
    //   180: getstatic 147	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   183: ifne -148 -> 35
    //   186: aload_3
    //   187: bipush 58
    //   189: invokevirtual 730	java/lang/String:indexOf	(I)I
    //   192: istore_0
    //   193: iload_0
    //   194: iconst_1
    //   195: if_icmple -160 -> 35
    //   198: aload_3
    //   199: iload_0
    //   200: iconst_1
    //   201: iadd
    //   202: aload_3
    //   203: invokevirtual 494	java/lang/String:length	()I
    //   206: invokevirtual 734	java/lang/String:substring	(II)Ljava/lang/String;
    //   209: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   212: astore_3
    //   213: aload_3
    //   214: invokevirtual 494	java/lang/String:length	()I
    //   217: ifle +47 -> 264
    //   220: aload_3
    //   221: invokevirtual 494	java/lang/String:length	()I
    //   224: iconst_2
    //   225: if_icmpge +39 -> 264
    //   228: aload_3
    //   229: invokestatic 747	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   232: l2i
    //   233: putstatic 147	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   236: goto -201 -> 35
    //   239: astore 4
    //   241: aload_1
    //   242: astore_3
    //   243: aload 4
    //   245: astore_1
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 716	java/io/BufferedReader:close	()V
    //   262: aload_1
    //   263: athrow
    //   264: aload_3
    //   265: invokevirtual 494	java/lang/String:length	()I
    //   268: iconst_1
    //   269: if_icmple -234 -> 35
    //   272: aload_3
    //   273: iconst_0
    //   274: iconst_1
    //   275: invokevirtual 734	java/lang/String:substring	(II)Ljava/lang/String;
    //   278: invokestatic 747	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   281: l2i
    //   282: putstatic 147	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuArchitecture	I
    //   285: goto -250 -> 35
    //   288: aload_3
    //   289: ldc_w 749
    //   292: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   295: ifeq +35 -> 330
    //   298: aload_3
    //   299: bipush 58
    //   301: invokevirtual 730	java/lang/String:indexOf	(I)I
    //   304: istore_0
    //   305: iload_0
    //   306: iconst_1
    //   307: if_icmple -272 -> 35
    //   310: aload_3
    //   311: iload_0
    //   312: iconst_1
    //   313: iadd
    //   314: aload_3
    //   315: invokevirtual 494	java/lang/String:length	()I
    //   318: invokevirtual 734	java/lang/String:substring	(II)Ljava/lang/String;
    //   321: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   324: putstatic 143	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mFeature	Ljava/lang/String;
    //   327: goto -292 -> 35
    //   330: aload_3
    //   331: ldc_w 751
    //   334: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   337: ifeq -302 -> 35
    //   340: aload_3
    //   341: bipush 58
    //   343: invokevirtual 730	java/lang/String:indexOf	(I)I
    //   346: istore_0
    //   347: iload_0
    //   348: iconst_1
    //   349: if_icmple -314 -> 35
    //   352: aload_3
    //   353: iload_0
    //   354: iconst_1
    //   355: iadd
    //   356: aload_3
    //   357: invokevirtual 494	java/lang/String:length	()I
    //   360: invokevirtual 734	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   366: ldc_w 753
    //   369: ldc 141
    //   371: invokevirtual 757	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   374: putstatic 145	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   377: ldc 85
    //   379: new 431	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 759
    //   389: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: getstatic 145	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   395: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 453	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 763	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: getstatic 145	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mCpuHardware	Ljava/lang/String;
    //   407: invokestatic 765	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:getCpuHWProductIndex	(Ljava/lang/String;)I
    //   410: pop
    //   411: goto -376 -> 35
    //   414: astore_1
    //   415: ldc 85
    //   417: aload_1
    //   418: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   421: return
    //   422: astore_2
    //   423: ldc 85
    //   425: aload_2
    //   426: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -167 -> 262
    //   432: astore_1
    //   433: aconst_null
    //   434: astore_2
    //   435: goto -189 -> 246
    //   438: astore_1
    //   439: goto -193 -> 246
    //   442: astore 4
    //   444: aload_1
    //   445: astore_3
    //   446: aload 4
    //   448: astore_1
    //   449: goto -203 -> 246
    //   452: astore_1
    //   453: aconst_null
    //   454: astore_1
    //   455: aload 4
    //   457: astore_2
    //   458: goto -323 -> 135
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_1
    //   464: goto -329 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   102	254	0	i	int
    //   34	124	1	localBufferedReader	java.io.BufferedReader
    //   162	80	1	localIOException1	IOException
    //   245	18	1	localObject1	Object
    //   414	4	1	localIOException2	IOException
    //   432	1	1	localObject2	Object
    //   438	7	1	localObject3	Object
    //   448	1	1	localObject4	Object
    //   452	1	1	localThrowable1	Throwable
    //   454	1	1	localObject5	Object
    //   461	1	1	localThrowable2	Throwable
    //   463	1	1	localObject6	Object
    //   25	226	2	localInputStreamReader	java.io.InputStreamReader
    //   422	4	2	localIOException3	IOException
    //   434	24	2	localObject7	Object
    //   1	112	3	str	String
    //   134	69	3	localThrowable3	Throwable
    //   212	234	3	localObject8	Object
    //   3	1	4	localObject9	Object
    //   239	5	4	localObject10	Object
    //   442	14	4	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	134	java/lang/Throwable
    //   61	81	134	java/lang/Throwable
    //   81	86	134	java/lang/Throwable
    //   86	103	134	java/lang/Throwable
    //   108	131	134	java/lang/Throwable
    //   170	193	134	java/lang/Throwable
    //   198	236	134	java/lang/Throwable
    //   264	285	134	java/lang/Throwable
    //   288	305	134	java/lang/Throwable
    //   310	327	134	java/lang/Throwable
    //   330	347	134	java/lang/Throwable
    //   352	411	134	java/lang/Throwable
    //   149	153	162	java/io/IOException
    //   157	161	162	java/io/IOException
    //   35	40	239	finally
    //   61	81	239	finally
    //   81	86	239	finally
    //   86	103	239	finally
    //   108	131	239	finally
    //   170	193	239	finally
    //   198	236	239	finally
    //   264	285	239	finally
    //   288	305	239	finally
    //   310	327	239	finally
    //   330	347	239	finally
    //   352	411	239	finally
    //   48	52	414	java/io/IOException
    //   56	60	414	java/io/IOException
    //   250	254	422	java/io/IOException
    //   258	262	422	java/io/IOException
    //   5	26	432	finally
    //   26	35	438	finally
    //   135	145	442	finally
    //   5	26	452	java/lang/Throwable
    //   26	35	461	java/lang/Throwable
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
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return 0L;
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: getstatic 415	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:currentCpuFreq	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +9 -> 14
    //   8: getstatic 415	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:currentCpuFreq	J
    //   11: lstore_2
    //   12: lload_2
    //   13: lreturn
    //   14: new 694	java/io/InputStreamReader
    //   17: dup
    //   18: new 696	java/io/FileInputStream
    //   21: dup
    //   22: ldc_w 787
    //   25: invokespecial 699	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   28: ldc_w 701
    //   31: invokespecial 704	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: astore 4
    //   36: new 706	java/io/BufferedReader
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore 7
    //   47: aload 7
    //   49: astore 6
    //   51: aload 4
    //   53: astore 5
    //   55: aload 7
    //   57: invokevirtual 712	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload 8
    //   64: ifnonnull +62 -> 126
    //   67: aload 7
    //   69: astore 6
    //   71: aload 4
    //   73: astore 5
    //   75: aload 4
    //   77: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   80: aload 7
    //   82: astore 6
    //   84: aload 4
    //   86: astore 5
    //   88: aload 7
    //   90: invokevirtual 716	java/io/BufferedReader:close	()V
    //   93: aload 4
    //   95: ifnull +8 -> 103
    //   98: aload 4
    //   100: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   103: aload 7
    //   105: ifnull +8 -> 113
    //   108: aload 7
    //   110: invokevirtual 716	java/io/BufferedReader:close	()V
    //   113: lconst_0
    //   114: lreturn
    //   115: astore 4
    //   117: ldc 85
    //   119: aload 4
    //   121: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: lconst_0
    //   125: lreturn
    //   126: aload 7
    //   128: astore 6
    //   130: aload 4
    //   132: astore 5
    //   134: aload 8
    //   136: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   139: astore 8
    //   141: aload 7
    //   143: astore 6
    //   145: aload 4
    //   147: astore 5
    //   149: aload 8
    //   151: invokevirtual 494	java/lang/String:length	()I
    //   154: ifle +475 -> 629
    //   157: aload 7
    //   159: astore 6
    //   161: aload 4
    //   163: astore 5
    //   165: aload 8
    //   167: invokestatic 747	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   170: lstore_0
    //   171: aload 7
    //   173: astore 6
    //   175: aload 4
    //   177: astore 5
    //   179: lload_0
    //   180: putstatic 415	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:currentCpuFreq	J
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   193: lload_0
    //   194: lstore_2
    //   195: aload 7
    //   197: ifnull -185 -> 12
    //   200: aload 7
    //   202: invokevirtual 716	java/io/BufferedReader:close	()V
    //   205: lload_0
    //   206: lreturn
    //   207: astore 4
    //   209: ldc 85
    //   211: aload 4
    //   213: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: lconst_0
    //   217: lreturn
    //   218: astore 8
    //   220: aconst_null
    //   221: astore 7
    //   223: aconst_null
    //   224: astore 4
    //   226: ldc2_w 788
    //   229: lstore_0
    //   230: aload 7
    //   232: astore 6
    //   234: aload 4
    //   236: astore 5
    //   238: ldc 85
    //   240: aload 8
    //   242: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   255: lload_0
    //   256: lstore_2
    //   257: aload 7
    //   259: ifnull -247 -> 12
    //   262: aload 7
    //   264: invokevirtual 716	java/io/BufferedReader:close	()V
    //   267: lload_0
    //   268: lreturn
    //   269: astore 4
    //   271: ldc 85
    //   273: aload 4
    //   275: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: lconst_0
    //   279: lreturn
    //   280: astore 8
    //   282: aconst_null
    //   283: astore 7
    //   285: aconst_null
    //   286: astore 4
    //   288: ldc2_w 788
    //   291: lstore_0
    //   292: aload 7
    //   294: astore 6
    //   296: aload 4
    //   298: astore 5
    //   300: ldc 85
    //   302: aload 8
    //   304: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   317: lload_0
    //   318: lstore_2
    //   319: aload 7
    //   321: ifnull -309 -> 12
    //   324: aload 7
    //   326: invokevirtual 716	java/io/BufferedReader:close	()V
    //   329: lload_0
    //   330: lreturn
    //   331: astore 4
    //   333: ldc 85
    //   335: aload 4
    //   337: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: lconst_0
    //   341: lreturn
    //   342: astore 8
    //   344: aconst_null
    //   345: astore 7
    //   347: aconst_null
    //   348: astore 4
    //   350: ldc2_w 788
    //   353: lstore_0
    //   354: aload 7
    //   356: astore 6
    //   358: aload 4
    //   360: astore 5
    //   362: ldc 85
    //   364: aload 8
    //   366: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   369: aload 4
    //   371: ifnull +8 -> 379
    //   374: aload 4
    //   376: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   379: lload_0
    //   380: lstore_2
    //   381: aload 7
    //   383: ifnull -371 -> 12
    //   386: aload 7
    //   388: invokevirtual 716	java/io/BufferedReader:close	()V
    //   391: lload_0
    //   392: lreturn
    //   393: astore 4
    //   395: ldc 85
    //   397: aload 4
    //   399: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: lconst_0
    //   403: lreturn
    //   404: astore 8
    //   406: aconst_null
    //   407: astore 7
    //   409: aconst_null
    //   410: astore 4
    //   412: ldc2_w 788
    //   415: lstore_0
    //   416: aload 7
    //   418: astore 6
    //   420: aload 4
    //   422: astore 5
    //   424: ldc 85
    //   426: aload 8
    //   428: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   431: aload 4
    //   433: ifnull +8 -> 441
    //   436: aload 4
    //   438: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   441: lload_0
    //   442: lstore_2
    //   443: aload 7
    //   445: ifnull -433 -> 12
    //   448: aload 7
    //   450: invokevirtual 716	java/io/BufferedReader:close	()V
    //   453: lload_0
    //   454: lreturn
    //   455: astore 4
    //   457: ldc 85
    //   459: aload 4
    //   461: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   464: lconst_0
    //   465: lreturn
    //   466: astore 7
    //   468: aconst_null
    //   469: astore 6
    //   471: aconst_null
    //   472: astore 4
    //   474: aload 4
    //   476: ifnull +8 -> 484
    //   479: aload 4
    //   481: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   484: aload 6
    //   486: ifnull +8 -> 494
    //   489: aload 6
    //   491: invokevirtual 716	java/io/BufferedReader:close	()V
    //   494: aload 7
    //   496: athrow
    //   497: astore 4
    //   499: ldc 85
    //   501: aload 4
    //   503: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   506: lconst_0
    //   507: lreturn
    //   508: astore 7
    //   510: aconst_null
    //   511: astore 6
    //   513: goto -39 -> 474
    //   516: astore 7
    //   518: aload 5
    //   520: astore 4
    //   522: goto -48 -> 474
    //   525: astore 8
    //   527: aconst_null
    //   528: astore 7
    //   530: ldc2_w 788
    //   533: lstore_0
    //   534: goto -118 -> 416
    //   537: astore 8
    //   539: ldc2_w 788
    //   542: lstore_0
    //   543: goto -127 -> 416
    //   546: astore 8
    //   548: goto -132 -> 416
    //   551: astore 8
    //   553: aconst_null
    //   554: astore 7
    //   556: ldc2_w 788
    //   559: lstore_0
    //   560: goto -206 -> 354
    //   563: astore 8
    //   565: ldc2_w 788
    //   568: lstore_0
    //   569: goto -215 -> 354
    //   572: astore 8
    //   574: goto -220 -> 354
    //   577: astore 8
    //   579: aconst_null
    //   580: astore 7
    //   582: ldc2_w 788
    //   585: lstore_0
    //   586: goto -294 -> 292
    //   589: astore 8
    //   591: ldc2_w 788
    //   594: lstore_0
    //   595: goto -303 -> 292
    //   598: astore 8
    //   600: goto -308 -> 292
    //   603: astore 8
    //   605: aconst_null
    //   606: astore 7
    //   608: ldc2_w 788
    //   611: lstore_0
    //   612: goto -382 -> 230
    //   615: astore 8
    //   617: ldc2_w 788
    //   620: lstore_0
    //   621: goto -391 -> 230
    //   624: astore 8
    //   626: goto -396 -> 230
    //   629: ldc2_w 788
    //   632: lstore_0
    //   633: goto -462 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   170	463	0	l1	long
    //   11	432	2	l2	long
    //   34	65	4	localInputStreamReader	java.io.InputStreamReader
    //   115	74	4	localThrowable1	Throwable
    //   207	5	4	localThrowable2	Throwable
    //   224	27	4	localObject1	Object
    //   269	5	4	localThrowable3	Throwable
    //   286	27	4	localObject2	Object
    //   331	5	4	localThrowable4	Throwable
    //   348	27	4	localObject3	Object
    //   393	5	4	localThrowable5	Throwable
    //   410	27	4	localObject4	Object
    //   455	5	4	localThrowable6	Throwable
    //   472	8	4	localObject5	Object
    //   497	5	4	localThrowable7	Throwable
    //   520	1	4	localObject6	Object
    //   53	466	5	localObject7	Object
    //   49	463	6	localBufferedReader1	java.io.BufferedReader
    //   45	404	7	localBufferedReader2	java.io.BufferedReader
    //   466	29	7	localObject8	Object
    //   508	1	7	localObject9	Object
    //   516	1	7	localObject10	Object
    //   528	79	7	localObject11	Object
    //   60	106	8	str	String
    //   218	23	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   280	23	8	localIOException1	IOException
    //   342	23	8	localException1	Exception
    //   404	23	8	localThrowable8	Throwable
    //   525	1	8	localThrowable9	Throwable
    //   537	1	8	localThrowable10	Throwable
    //   546	1	8	localThrowable11	Throwable
    //   551	1	8	localException2	Exception
    //   563	1	8	localException3	Exception
    //   572	1	8	localException4	Exception
    //   577	1	8	localIOException2	IOException
    //   589	1	8	localIOException3	IOException
    //   598	1	8	localIOException4	IOException
    //   603	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   615	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   624	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   98	103	115	java/lang/Throwable
    //   108	113	115	java/lang/Throwable
    //   188	193	207	java/lang/Throwable
    //   200	205	207	java/lang/Throwable
    //   14	36	218	java/io/FileNotFoundException
    //   250	255	269	java/lang/Throwable
    //   262	267	269	java/lang/Throwable
    //   14	36	280	java/io/IOException
    //   312	317	331	java/lang/Throwable
    //   324	329	331	java/lang/Throwable
    //   14	36	342	java/lang/Exception
    //   374	379	393	java/lang/Throwable
    //   386	391	393	java/lang/Throwable
    //   14	36	404	java/lang/Throwable
    //   436	441	455	java/lang/Throwable
    //   448	453	455	java/lang/Throwable
    //   14	36	466	finally
    //   479	484	497	java/lang/Throwable
    //   489	494	497	java/lang/Throwable
    //   36	47	508	finally
    //   55	62	516	finally
    //   75	80	516	finally
    //   88	93	516	finally
    //   134	141	516	finally
    //   149	157	516	finally
    //   165	171	516	finally
    //   179	183	516	finally
    //   238	245	516	finally
    //   300	307	516	finally
    //   362	369	516	finally
    //   424	431	516	finally
    //   36	47	525	java/lang/Throwable
    //   55	62	537	java/lang/Throwable
    //   75	80	537	java/lang/Throwable
    //   88	93	537	java/lang/Throwable
    //   134	141	537	java/lang/Throwable
    //   149	157	537	java/lang/Throwable
    //   165	171	537	java/lang/Throwable
    //   179	183	546	java/lang/Throwable
    //   36	47	551	java/lang/Exception
    //   55	62	563	java/lang/Exception
    //   75	80	563	java/lang/Exception
    //   88	93	563	java/lang/Exception
    //   134	141	563	java/lang/Exception
    //   149	157	563	java/lang/Exception
    //   165	171	563	java/lang/Exception
    //   179	183	572	java/lang/Exception
    //   36	47	577	java/io/IOException
    //   55	62	589	java/io/IOException
    //   75	80	589	java/io/IOException
    //   88	93	589	java/io/IOException
    //   134	141	589	java/io/IOException
    //   149	157	589	java/io/IOException
    //   165	171	589	java/io/IOException
    //   179	183	598	java/io/IOException
    //   36	47	603	java/io/FileNotFoundException
    //   55	62	615	java/io/FileNotFoundException
    //   75	80	615	java/io/FileNotFoundException
    //   88	93	615	java/io/FileNotFoundException
    //   134	141	615	java/io/FileNotFoundException
    //   149	157	615	java/io/FileNotFoundException
    //   165	171	615	java/io/FileNotFoundException
    //   179	183	624	java/io/FileNotFoundException
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
  
  public static String getGuidFromPhoneStorage(Context paramContext)
  {
    if (paramContext == null) {
      localObject = "";
    }
    do
    {
      return localObject;
      paramContext = paramContext.getPackageName();
      localObject = null;
      try
      {
        File localFile = new File(GUID_PHONE_PATH + paramContext + "/");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localFile = new File(GUID_PHONE_PATH + paramContext + "/guid");
        paramContext = (Context)localObject;
        if (localFile.exists()) {
          paramContext = readStringFromFile(localFile);
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TVKLogUtil.e("MediaPlayerMgr", paramContext);
          paramContext = (Context)localObject;
        }
      }
      localObject = paramContext;
    } while (paramContext != null);
    return "";
  }
  
  public static String getGuidFromStorage(Context paramContext)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        paramContext = getGuidFromPhoneStorage(paramContext);
        if (paramContext != null) {
          localObject = paramContext;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (!paramContext.equals("guiderror")) {
            continue;
          }
          return "";
        }
        catch (Exception localException2)
        {
          break;
        }
        localException1 = localException1;
        paramContext = "";
      }
    }
    TVKLogUtil.e("MediaPlayerMgr", localException1);
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
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return "";
  }
  
  public static int getMCC(Context paramContext)
  {
    int i = 0;
    if (mMCC != 0) {
      i = mMCC;
    }
    while (paramContext == null) {
      return i;
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
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return 0;
  }
  
  public static int getMNC(Context paramContext)
  {
    int i = 0;
    if (mMNC != 0) {
      i = mMNC;
    }
    while (paramContext == null) {
      return i;
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
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return 0;
  }
  
  /* Error */
  public static int getMarketId(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_m1
    //   4: istore_1
    //   5: getstatic 159	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mReadMarketId	Z
    //   8: ifeq +9 -> 17
    //   11: getstatic 161	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mMarketId	I
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: iload_1
    //   18: istore_2
    //   19: aload_0
    //   20: ifnull -5 -> 15
    //   23: aload_0
    //   24: invokevirtual 610	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: invokevirtual 882	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   30: ldc_w 884
    //   33: invokevirtual 890	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_0
    //   37: new 706	java/io/BufferedReader
    //   40: dup
    //   41: new 694	java/io/InputStreamReader
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 893	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore 6
    //   54: aload 6
    //   56: invokevirtual 712	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore 4
    //   61: iload_1
    //   62: istore_2
    //   63: aload 4
    //   65: invokestatic 521	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +52 -> 120
    //   71: iload_1
    //   72: istore_2
    //   73: aload 4
    //   75: ldc_w 895
    //   78: invokevirtual 556	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +39 -> 120
    //   84: aload 4
    //   86: aload 4
    //   88: ldc_w 897
    //   91: invokevirtual 899	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   94: iconst_1
    //   95: iadd
    //   96: invokevirtual 901	java/lang/String:substring	(I)Ljava/lang/String;
    //   99: astore 4
    //   101: iload_1
    //   102: istore_2
    //   103: aload 4
    //   105: invokestatic 521	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +12 -> 120
    //   111: aload 4
    //   113: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   116: invokestatic 904	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: istore_2
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 907	java/io/InputStream:close	()V
    //   128: iload_2
    //   129: istore_3
    //   130: aload 6
    //   132: ifnull +10 -> 142
    //   135: aload 6
    //   137: invokevirtual 716	java/io/BufferedReader:close	()V
    //   140: iload_2
    //   141: istore_3
    //   142: iload_3
    //   143: putstatic 161	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mMarketId	I
    //   146: iconst_1
    //   147: putstatic 159	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:mReadMarketId	Z
    //   150: iload_3
    //   151: ireturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   157: iload_2
    //   158: istore_3
    //   159: goto -17 -> 142
    //   162: astore 5
    //   164: aconst_null
    //   165: astore_0
    //   166: ldc 85
    //   168: aload 5
    //   170: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 907	java/io/InputStream:close	()V
    //   183: iload_1
    //   184: istore_3
    //   185: aload_0
    //   186: ifnull -44 -> 142
    //   189: aload_0
    //   190: invokevirtual 716	java/io/BufferedReader:close	()V
    //   193: iload_1
    //   194: istore_3
    //   195: goto -53 -> 142
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   203: iload_1
    //   204: istore_3
    //   205: goto -63 -> 142
    //   208: astore 4
    //   210: aconst_null
    //   211: astore 5
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 907	java/io/InputStream:close	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 716	java/io/BufferedReader:close	()V
    //   233: aload 4
    //   235: athrow
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   241: goto -8 -> 233
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 5
    //   249: goto -34 -> 215
    //   252: astore 4
    //   254: aload 6
    //   256: astore 5
    //   258: goto -43 -> 215
    //   261: astore 5
    //   263: aload 4
    //   265: astore 6
    //   267: aload 5
    //   269: astore 4
    //   271: aload_0
    //   272: astore 5
    //   274: aload 6
    //   276: astore_0
    //   277: goto -62 -> 215
    //   280: astore 5
    //   282: aconst_null
    //   283: astore 6
    //   285: aload_0
    //   286: astore 4
    //   288: aload 6
    //   290: astore_0
    //   291: goto -125 -> 166
    //   294: astore 5
    //   296: aload_0
    //   297: astore 4
    //   299: aload 6
    //   301: astore_0
    //   302: goto -136 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramContext	Context
    //   4	200	1	i	int
    //   14	144	2	j	int
    //   129	76	3	k	int
    //   1	178	4	str	String
    //   208	26	4	localObject1	Object
    //   244	1	4	localObject2	Object
    //   252	12	4	localObject3	Object
    //   269	29	4	localObject4	Object
    //   162	7	5	localThrowable1	Throwable
    //   211	46	5	localObject5	Object
    //   261	7	5	localObject6	Object
    //   272	1	5	localContext	Context
    //   280	1	5	localThrowable2	Throwable
    //   294	1	5	localThrowable3	Throwable
    //   52	248	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   124	128	152	java/lang/Throwable
    //   135	140	152	java/lang/Throwable
    //   23	37	162	java/lang/Throwable
    //   178	183	198	java/lang/Throwable
    //   189	193	198	java/lang/Throwable
    //   23	37	208	finally
    //   219	223	236	java/lang/Throwable
    //   228	233	236	java/lang/Throwable
    //   37	54	244	finally
    //   54	61	252	finally
    //   63	71	252	finally
    //   73	101	252	finally
    //   103	120	252	finally
    //   166	173	261	finally
    //   37	54	280	java/lang/Throwable
    //   54	61	294	java/lang/Throwable
    //   63	71	294	java/lang/Throwable
    //   73	101	294	java/lang/Throwable
    //   103	120	294	java/lang/Throwable
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
    //   11: ldc2_w 410
    //   14: getstatic 413	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   17: lcmp
    //   18: ifeq +9 -> 27
    //   21: getstatic 413	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   24: lstore_0
    //   25: lload_0
    //   26: lreturn
    //   27: new 694	java/io/InputStreamReader
    //   30: dup
    //   31: new 696	java/io/FileInputStream
    //   34: dup
    //   35: ldc_w 913
    //   38: invokespecial 699	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   41: ldc_w 701
    //   44: invokespecial 704	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: astore 6
    //   49: new 706	java/io/BufferedReader
    //   52: dup
    //   53: aload 6
    //   55: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 712	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 8
    //   67: aload 8
    //   69: ifnonnull +46 -> 115
    //   72: aload 6
    //   74: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   77: aload 7
    //   79: invokevirtual 716	java/io/BufferedReader:close	()V
    //   82: aload 6
    //   84: ifnull +8 -> 92
    //   87: aload 6
    //   89: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   92: aload 7
    //   94: ifnull -69 -> 25
    //   97: aload 7
    //   99: invokevirtual 716	java/io/BufferedReader:close	()V
    //   102: lconst_0
    //   103: lreturn
    //   104: astore 6
    //   106: ldc 85
    //   108: aload 6
    //   110: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: lconst_0
    //   114: lreturn
    //   115: aload 8
    //   117: invokevirtual 737	java/lang/String:trim	()Ljava/lang/String;
    //   120: astore 8
    //   122: lload_0
    //   123: lstore_2
    //   124: aload 8
    //   126: invokevirtual 494	java/lang/String:length	()I
    //   129: ifle +9 -> 138
    //   132: aload 8
    //   134: invokestatic 747	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore_2
    //   138: aload 6
    //   140: ifnull +8 -> 148
    //   143: aload 6
    //   145: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   148: lload_2
    //   149: lstore 4
    //   151: aload 7
    //   153: ifnull +11 -> 164
    //   156: aload 7
    //   158: invokevirtual 716	java/io/BufferedReader:close	()V
    //   161: lload_2
    //   162: lstore 4
    //   164: lload 4
    //   166: putstatic 413	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   169: ldc 85
    //   171: new 431	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 915
    //   181: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: getstatic 413	com/tencent/qqlive/tvkplayer/tools/utils/TVKVcSystemInfo:maxCpuFreq	J
    //   187: invokevirtual 918	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: invokevirtual 453	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 763	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: lload 4
    //   198: lreturn
    //   199: astore 6
    //   201: ldc 85
    //   203: aload 6
    //   205: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: lload_2
    //   209: lstore 4
    //   211: goto -47 -> 164
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 8
    //   219: aload 7
    //   221: astore 6
    //   223: aload 8
    //   225: astore 7
    //   227: aload 6
    //   229: ifnull +8 -> 237
    //   232: aload 6
    //   234: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   237: lload_0
    //   238: lstore 4
    //   240: aload 7
    //   242: ifnull -78 -> 164
    //   245: aload 7
    //   247: invokevirtual 716	java/io/BufferedReader:close	()V
    //   250: lload_0
    //   251: lstore 4
    //   253: goto -89 -> 164
    //   256: astore 6
    //   258: ldc 85
    //   260: aload 6
    //   262: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: lload_0
    //   266: lstore 4
    //   268: goto -104 -> 164
    //   271: astore 6
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 9
    //   278: astore 7
    //   280: aload 6
    //   282: ifnull +8 -> 290
    //   285: aload 6
    //   287: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   290: lload_0
    //   291: lstore 4
    //   293: aload 7
    //   295: ifnull -131 -> 164
    //   298: aload 7
    //   300: invokevirtual 716	java/io/BufferedReader:close	()V
    //   303: lload_0
    //   304: lstore 4
    //   306: goto -142 -> 164
    //   309: astore 6
    //   311: ldc 85
    //   313: aload 6
    //   315: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   318: lload_0
    //   319: lstore 4
    //   321: goto -157 -> 164
    //   324: astore 7
    //   326: aconst_null
    //   327: astore 6
    //   329: aload 6
    //   331: ifnull +8 -> 339
    //   334: aload 6
    //   336: invokevirtual 715	java/io/InputStreamReader:close	()V
    //   339: aload 8
    //   341: ifnull +8 -> 349
    //   344: aload 8
    //   346: invokevirtual 716	java/io/BufferedReader:close	()V
    //   349: aload 7
    //   351: athrow
    //   352: astore 6
    //   354: ldc 85
    //   356: aload 6
    //   358: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   361: goto -12 -> 349
    //   364: astore 7
    //   366: goto -37 -> 329
    //   369: astore 9
    //   371: aload 7
    //   373: astore 8
    //   375: aload 9
    //   377: astore 7
    //   379: goto -50 -> 329
    //   382: astore 7
    //   384: aload 9
    //   386: astore 7
    //   388: goto -108 -> 280
    //   391: astore 8
    //   393: goto -113 -> 280
    //   396: astore 7
    //   398: aconst_null
    //   399: astore 7
    //   401: goto -174 -> 227
    //   404: astore 8
    //   406: goto -179 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	309	0	l1	long
    //   123	86	2	l2	long
    //   149	171	4	l3	long
    //   47	41	6	localInputStreamReader	java.io.InputStreamReader
    //   104	40	6	localIOException1	IOException
    //   199	5	6	localIOException2	IOException
    //   214	1	6	localIOException3	IOException
    //   221	12	6	localObject1	Object
    //   256	5	6	localIOException4	IOException
    //   271	1	6	localThrowable1	Throwable
    //   274	12	6	localObject2	Object
    //   309	5	6	localIOException5	IOException
    //   327	8	6	localObject3	Object
    //   352	5	6	localIOException6	IOException
    //   7	292	7	localObject4	Object
    //   324	26	7	localObject5	Object
    //   364	8	7	localObject6	Object
    //   377	1	7	localObject7	Object
    //   382	1	7	localThrowable2	Throwable
    //   386	1	7	localObject8	Object
    //   396	1	7	localIOException7	IOException
    //   399	1	7	localObject9	Object
    //   4	370	8	localObject10	Object
    //   391	1	8	localThrowable3	Throwable
    //   404	1	8	localIOException8	IOException
    //   1	276	9	localObject11	Object
    //   369	16	9	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	104	java/io/IOException
    //   97	102	104	java/io/IOException
    //   143	148	199	java/io/IOException
    //   156	161	199	java/io/IOException
    //   27	49	214	java/io/IOException
    //   232	237	256	java/io/IOException
    //   245	250	256	java/io/IOException
    //   27	49	271	java/lang/Throwable
    //   285	290	309	java/io/IOException
    //   298	303	309	java/io/IOException
    //   27	49	324	finally
    //   334	339	352	java/io/IOException
    //   344	349	352	java/io/IOException
    //   49	60	364	finally
    //   60	67	369	finally
    //   72	82	369	finally
    //   115	122	369	finally
    //   124	138	369	finally
    //   49	60	382	java/lang/Throwable
    //   60	67	391	java/lang/Throwable
    //   72	82	391	java/lang/Throwable
    //   115	122	391	java/lang/Throwable
    //   124	138	391	java/lang/Throwable
    //   49	60	396	java/io/IOException
    //   60	67	404	java/io/IOException
    //   72	82	404	java/io/IOException
    //   115	122	404	java/io/IOException
    //   124	138	404	java/io/IOException
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
      if (!TextUtils.isEmpty(paramContext))
      {
        if ((paramContext.equals("46000")) || (paramContext.equals("46002")) || (paramContext.equals("46007"))) {
          break label99;
        }
        if (paramContext.equals("46001")) {
          return 2;
        }
        boolean bool = paramContext.equals("46003");
        if (bool) {
          return 1;
        }
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
      return 0;
    }
    label99:
    return 3;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    if ((mNetWorkType != -1) && (!isNetworkChange)) {
      return mNetWorkType;
    }
    mNetWorkType = 0;
    if (paramContext != null) {}
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          switch (paramContext.getType())
          {
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TVKLogUtil.e("MediaPlayerMgr", paramContext);
        continue;
        mNetWorkType = 2;
        if ((paramContext.getExtraInfo() != null) && (!"cmnet".equalsIgnoreCase(paramContext.getExtraInfo())))
        {
          mNetWorkType = 3;
          continue;
          mNetWorkType = 5;
        }
      }
    }
    for (mNetWorkType = 4;; mNetWorkType = 1) {
      return mNetWorkType;
    }
  }
  
  public static int getNetWorkTypeInRealTime(Context paramContext)
  {
    if (paramContext == null)
    {
      mNetWorkType = 0;
      return mNetWorkType;
    }
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          break;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null) {
          break;
        }
        switch (paramContext.getType())
        {
        case 6: 
        case 7: 
        case 8: 
          mNetWorkType = 4;
        }
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr", paramContext);
      }
      break;
      mNetWorkType = 1;
      break;
      mNetWorkType = 2;
      if ((paramContext.getExtraInfo() == null) || ("cmnet".equalsIgnoreCase(paramContext.getExtraInfo()))) {
        break;
      }
      mNetWorkType = 3;
      break;
      mNetWorkType = 5;
      break;
    }
  }
  
  private static int getNetworkClass(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
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
    return 4;
  }
  
  public static int getNetworkClass(Context paramContext)
  {
    if ((mNetWorkClass != -1) && (!isNetworkChange)) {
      return mNetWorkClass;
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
        if ((paramContext != null) && (paramContext.isConnected())) {
          switch (paramContext.getType())
          {
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TVKLogUtil.e("MediaPlayerMgr", paramContext);
        mNetWorkClass = 0;
        continue;
        mNetWorkClass = 1;
      }
    }
    for (mNetWorkClass = 0;; mNetWorkClass = getNetworkClass(paramContext.getSubtype())) {
      return mNetWorkClass;
    }
  }
  
  public static int getNumCores()
  {
    if (-1 != numOfCores) {
      return numOfCores;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new TVKVcSystemInfo.1CpuFilter());
      if (arrayOfFile == null)
      {
        numOfCores = 1;
        return numOfCores;
      }
      numOfCores = arrayOfFile.length;
      TVKLogUtil.i("MediaPlayerMgr", "core num " + numOfCores);
      int i = numOfCores;
      return i;
    }
    catch (Exception localException)
    {
      TVKLogUtil.e("MediaPlayerMgr", localException);
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
        TVKLogUtil.e("MediaPlayerMgr", paramContext);
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
    if (-1 != mDeviceLevel) {
      return mDeviceLevel;
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
    TVKLogUtil.i("MediaPlayerMgr", "[getRecordLevel], numCores = " + getNumCores() + ", totalMem = " + getTotalMem(TVideoMgr.getApplicationContext()));
    TVKLogUtil.i("MediaPlayerMgr", "[getRecordLevel], mCpuHWProducter = " + mCpuHWProducter + ", getMaxCpuFreq() = " + getMaxCpuFreq() + " mCpuHWProductIdx=" + mCpuHWProductIdx);
    if (-1 != mRecordLevel) {
      return mRecordLevel;
    }
    if (-1 == mCpuHWProducter) {
      getRecordLevelByNumCores();
    }
    for (;;)
    {
      return mRecordLevel;
      switch (mCpuHWProducter)
      {
      default: 
        break;
      case 0: 
        if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.qualcomm_720p_index.getValue()).intValue()) {
          mRecordLevel = 3;
        } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.qualcomm_480p_index.getValue()).intValue()) {
          mRecordLevel = 2;
        } else {
          getRecordLevelByNumCores();
        }
        break;
      case 3: 
        if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.sumsing_720p_index.getValue()).intValue()) {
          mRecordLevel = 3;
        } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.sumsing_480p_index.getValue()).intValue()) {
          mRecordLevel = 2;
        } else {
          getRecordLevelByNumCores();
        }
        break;
      case 2: 
        if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hisi_720p_index.getValue()).intValue()) {
          mRecordLevel = 3;
        } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hisi_480p_index.getValue()).intValue()) {
          mRecordLevel = 2;
        } else {
          getRecordLevelByNumCores();
        }
        break;
      case 1: 
        if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.mtk_720p_index.getValue()).intValue()) {
          mRecordLevel = 3;
        } else if (mCpuHWProductIdx >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.mtk_480p_index.getValue()).intValue()) {
          mRecordLevel = 2;
        } else {
          getRecordLevelByNumCores();
        }
        break;
      }
    }
  }
  
  private static int getRecordLevelByNumCores()
  {
    if (getNumCores() >= 8) {
      if (getMaxCpuFreq() / 1000L >= 1900L) {
        mRecordLevel = 3;
      }
    }
    for (;;)
    {
      return mRecordLevel;
      mRecordLevel = 2;
      continue;
      if (getNumCores() >= 4)
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
    }
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
      paramContext = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
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
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
    }
    return "";
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
        TVKLogUtil.e("MediaPlayerMgr", paramString1);
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
  
  @TargetApi(16)
  public static long getTotalMem(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    if (sTotalMem > 0L) {
      return sTotalMem;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
        sTotalMem = localMemoryInfo.totalMem / 1048576L;
        long l = sTotalMem;
        return l;
      }
      return 0L;
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
      paramContext = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        return 0;
      }
    }
    catch (Throwable paramContext)
    {
      return 0;
    }
    int i = paramContext.getRssi();
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 101);
        return i;
      }
      catch (Throwable paramContext)
      {
        return 0;
      }
    }
    if (i <= -100) {
      return 0;
    }
    if (i >= -55) {
      return 100;
    }
    float f = 45;
    return (int)(100 * (i + 100) / f);
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
      TVKLogUtil.e("MediaPlayerMgr", localThrowable);
    }
    return "wlan0";
  }
  
  private static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isExternalStorageMounted()
  {
    if (externalStorageMounted != -1) {
      return externalStorageMounted == 1;
    }
    for (;;)
    {
      try
      {
        if (!Environment.getExternalStorageState().equals("mounted")) {
          continue;
        }
        i = 1;
        externalStorageMounted = i;
      }
      catch (Exception localException)
      {
        int i;
        TVKLogUtil.e("MediaPlayerMgr", localException);
        continue;
      }
      if (externalStorageMounted == 1) {
        break;
      }
      return false;
      i = 0;
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool = true;
    if ((isNetworkAvailable != -1) && (!isNetworkChange)) {
      return isNetworkAvailable == 1;
    }
    if (paramContext != null) {}
    try
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext != null) {
        break label61;
      }
      isNetworkAvailable = 0;
    }
    catch (Exception paramContext)
    {
      label52:
      break label52;
    }
    if (isNetworkAvailable == 1) {}
    for (;;)
    {
      return bool;
      label61:
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable()))
      {
        isNetworkAvailable = 0;
        break;
      }
      if (paramContext.getState() == NetworkInfo.State.CONNECTED)
      {
        isNetworkAvailable = 1;
        break;
      }
      isNetworkAvailable = 0;
      break;
      bool = false;
    }
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
          switch (i)
          {
          case 1: 
          default: 
            return false;
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
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
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 706	java/io/BufferedReader
    //   9: dup
    //   10: new 1168	java/io/FileReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 1171	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   18: invokespecial 709	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_0
    //   26: invokevirtual 1173	java/io/File:length	()J
    //   29: lstore_1
    //   30: lload_1
    //   31: ldc2_w 1174
    //   34: lcmp
    //   35: ifle +22 -> 57
    //   38: aload 5
    //   40: astore 4
    //   42: aload_3
    //   43: ifnull +11 -> 54
    //   46: aload_3
    //   47: invokevirtual 716	java/io/BufferedReader:close	()V
    //   50: aload 5
    //   52: astore 4
    //   54: aload 4
    //   56: areturn
    //   57: aload_3
    //   58: astore 4
    //   60: aload_0
    //   61: invokevirtual 1173	java/io/File:length	()J
    //   64: l2i
    //   65: newarray char
    //   67: astore 7
    //   69: aload_3
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual 1173	java/io/File:length	()J
    //   80: l2i
    //   81: invokevirtual 1179	java/io/BufferedReader:read	([CII)I
    //   84: ifle -46 -> 38
    //   87: aload_3
    //   88: astore 4
    //   90: new 175	java/lang/String
    //   93: dup
    //   94: aload 7
    //   96: invokespecial 1182	java/lang/String:<init>	([C)V
    //   99: astore 5
    //   101: goto -63 -> 38
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
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
    //   128: invokevirtual 716	java/io/BufferedReader:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_3
    //   137: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   140: aload 6
    //   142: astore 4
    //   144: aload_0
    //   145: ifnull -91 -> 54
    //   148: aload_0
    //   149: invokevirtual 716	java/io/BufferedReader:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore_3
    //   162: aload_3
    //   163: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
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
    //   2: new 1185	java/io/RandomAccessFile
    //   5: dup
    //   6: ldc_w 1187
    //   9: ldc_w 1189
    //   12: invokespecial 1191	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 1192	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 1193	java/io/RandomAccessFile:close	()V
    //   35: aload_0
    //   36: astore_2
    //   37: aload_2
    //   38: areturn
    //   39: astore_1
    //   40: ldc 85
    //   42: aload_1
    //   43: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: aload_0
    //   47: areturn
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: invokevirtual 910	java/lang/Throwable:printStackTrace	()V
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: ifnull -23 -> 37
    //   63: aload_1
    //   64: invokevirtual 1193	java/io/RandomAccessFile:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: ldc 85
    //   72: aload_0
    //   73: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 1193	java/io/RandomAccessFile:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_0
    //   92: ldc 85
    //   94: aload_0
    //   95: invokestatic 508	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -9 -> 89
    //   101: astore_1
    //   102: goto -21 -> 81
    //   105: astore_2
    //   106: goto -55 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	36	0	localObject1	Object
    //   69	4	0	localThrowable1	Throwable
    //   80	6	0	localObject2	Object
    //   91	4	0	localThrowable2	Throwable
    //   15	17	1	localRandomAccessFile	java.io.RandomAccessFile
    //   39	4	1	localThrowable3	Throwable
    //   50	14	1	localObject3	Object
    //   78	12	1	localObject4	Object
    //   101	1	1	localObject5	Object
    //   22	16	2	localObject6	Object
    //   48	6	2	localThrowable4	Throwable
    //   58	1	2	localObject7	Object
    //   105	1	2	localThrowable5	Throwable
    //   1	57	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	39	java/lang/Throwable
    //   2	16	48	java/lang/Throwable
    //   63	67	69	java/lang/Throwable
    //   2	16	78	finally
    //   85	89	91	java/lang/Throwable
    //   18	23	101	finally
    //   53	57	101	finally
    //   18	23	105	java/lang/Throwable
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
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          i = paramContext.getIpAddress();
          if (i != 0) {
            break label140;
          }
          mCurrentIP = "";
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      TVKLogUtil.e("MediaPlayerMgr", paramContext);
      try
      {
        paramContext = NetworkInterface.getNetworkInterfaces();
        if (paramContext == null) {
          return;
        }
        InetAddress localInetAddress;
        do
        {
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
        return;
      }
      label140:
      mCurrentIP = (i & 0xFF) + "." + (i >> 8 & 0xFF) + "." + (i >> 16 & 0xFF) + "." + (i >> 24 & 0xFF);
    }
  }
  
  private static void writeGuidToPhoneStorage(String paramString1, String paramString2)
  {
    writeStringToFile(GUID_PHONE_PATH + paramString1 + "/guid", paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo
 * JD-Core Version:    0.7.0.1
 */