package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TbsDownloadConfig
{
  static final int APKTDOWNLOAD_DEFAULT = -300;
  static final int APKTDOWNLOAD_DELETEFILE_FAILED = -301;
  static final int APKTDOWNLOAD_DOWNLOADFLOW_EXCEED = -307;
  static final int APKTDOWNLOAD_DOWNLOAD_CANCELED = -309;
  static final int APKTDOWNLOAD_DOWNLOAD_DEBUGTBS = -321;
  static final int APKTDOWNLOAD_DOWNLOAD_FAILED = -318;
  static final int APKTDOWNLOAD_DOWNLOAD_FILESIZE_ERROR = -310;
  static final int APKTDOWNLOAD_DOWNLOAD_FINISHED = -311;
  static final int APKTDOWNLOAD_DOWNLOAD_FORBIDDEN = -314;
  static final int APKTDOWNLOAD_DOWNLOAD_LANGUAGE_NOT_CN = -320;
  static final int APKTDOWNLOAD_DOWNLOAD_LOCALINSTALLEDFLAG = -322;
  static final int APKTDOWNLOAD_DOWNLOAD_NO_FINISHED = -319;
  static final int APKTDOWNLOAD_DOWNLOAD_REDIRECT_EMPTY = -312;
  static final int APKTDOWNLOAD_DOWNLOAD_SUCCESS = -317;
  static final int APKTDOWNLOAD_DOWNLOAD_THROWABLE = -316;
  static final int APKTDOWNLOAD_DOWNLOAD_UNKNOWN = -315;
  static final int APKTDOWNLOAD_RANGE_NOT_SATISFIABLE = -313;
  static final int APKTDOWNLOAD_REQUESTING = -303;
  static final int APKTDOWNLOAD_RETRY302_EXCEED = -306;
  static final int APKTDOWNLOAD_RETRY_EXCEED = -305;
  static final int APKTDOWNLOAD_SDCARD_NOTENOUGH = -308;
  static final int APKTDOWNLOAD_URL_NULL = -302;
  static final int APKTDOWNLOAD_WIFI_UNABLE = -304;
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  private static final int DEFAULT_DOWNLOAD_FAILED_MAX_RETRYTIMES = 100;
  private static final int DEFAULT_DOWNLOAD_MAX_FLOW = 20;
  private static final int DEFAULT_DOWNLOAD_MIN_FREE_SPACE = 0;
  private static final long DEFAULT_DOWNLOAD_SINGLE_TIMEOUT = 1200000L;
  private static final int DEFAULT_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = 3;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  static final int INSTALL_FAILURE_APK_PATH_IS_NULL = -511;
  static final int INSTALL_FAILURE_APK_VERSION_IS_ZERO = -512;
  static final int INSTALL_FAILURE_BEGIN_COPY = -551;
  static final int INSTALL_FAILURE_BEGIN_INCRUPDATE = -550;
  static final int INSTALL_FAILURE_COPY_DST_DIR_NULL = -536;
  static final int INSTALL_FAILURE_COPY_EXCEPTION = -537;
  static final int INSTALL_FAILURE_COPY_EX_FILE_LOCK_NULL = -541;
  static final int INSTALL_FAILURE_COPY_EX_FILE_STREAM_FAILED = -542;
  static final int INSTALL_FAILURE_COPY_EX_NO_LOCK = -547;
  static final int INSTALL_FAILURE_COPY_EX_NO_NEED_PATCH = -545;
  static final int INSTALL_FAILURE_COPY_EX_PATCH_EXCEPTION = -543;
  static final int INSTALL_FAILURE_COPY_EX_PATCH_FAIL = -546;
  static final int INSTALL_FAILURE_COPY_EX_PATCH_SUCCESS = -544;
  static final int INSTALL_FAILURE_COPY_EX_ROM_NOT_ENOUGH = -540;
  static final int INSTALL_FAILURE_COPY_EX_START = -539;
  static final int INSTALL_FAILURE_COPY_FAILED = -534;
  static final int INSTALL_FAILURE_COPY_INSTALL_BEGIN = -524;
  static final int INSTALL_FAILURE_COPY_INSTALL_CANNOT_LOCK = -526;
  static final int INSTALL_FAILURE_COPY_INSTALL_EXEED_RETRY_NUM = -530;
  static final int INSTALL_FAILURE_COPY_INSTALL_FILE_STREAM_ERROR = -527;
  static final int INSTALL_FAILURE_COPY_INSTALL_PRECHECKX5_CHECK = -525;
  static final int INSTALL_FAILURE_COPY_INSTALL_ROM_NOT_ENOUGH = -529;
  static final int INSTALL_FAILURE_COPY_INSTALL_SAME_VERSION = -528;
  static final int INSTALL_FAILURE_COPY_INSTALL_SUCCESS = -533;
  static final int INSTALL_FAILURE_COPY_INSTALL_VERIFY_FAILED = -531;
  static final int INSTALL_FAILURE_COPY_INSTALL_VERIFY_MD5_FAILED = -532;
  static final int INSTALL_FAILURE_COPY_LOCK_FALSE = -538;
  static final int INSTALL_FAILURE_COPY_SRC_DIR_NULL = -535;
  static final int INSTALL_FAILURE_DEFAULT = -500;
  static final int INSTALL_FAILURE_DEX_OPT_EXCEED = -514;
  static final int INSTALL_FAILURE_DEX_OPT_FAILED = -515;
  static final int INSTALL_FAILURE_EXCEED_UNLZMA = -553;
  static final int INSTALL_FAILURE_FILE_LOCK_IS_DOWNLOADING = -505;
  static final int INSTALL_FAILURE_FILE_STREAM_FAILED = -506;
  static final int INSTALL_FAILURE_FINISH_RESET = -508;
  static final int INSTALL_FAILURE_GET_LOCK_FAILED = -519;
  static final int INSTALL_FAILURE_GET_THREAD_LOCK = -507;
  static final int INSTALL_FAILURE_INSTALL_DISABLED_BY_PRECHECK = -503;
  static final int INSTALL_FAILURE_INSTALL_NOT_CALL = -501;
  static final int INSTALL_FAILURE_INSTALL_SUCCESS = -516;
  static final int INSTALL_FAILURE_IN_DEXOPT = -549;
  static final int INSTALL_FAILURE_IN_UNZIP = -548;
  static final int INSTALL_FAILURE_LOCAL_INSTALLED = -502;
  static final int INSTALL_FAILURE_NEED_MD5_CHECK = -552;
  static final int INSTALL_FAILURE_RETRY_NUM_EXCEED = -510;
  static final int INSTALL_FAILURE_ROM_LIMITED = -504;
  static final int INSTALL_FAILURE_START_INSTALL = -509;
  static final int INSTALL_FAILURE_UNZIP_APK_INVALID = -520;
  static final int INSTALL_FAILURE_UNZIP_COPY_FILE_FAILED = -522;
  static final int INSTALL_FAILURE_UNZIP_OTHER_EXCEPTION = -523;
  static final int INSTALL_FAILURE_UNZIP_RETURN_FALSE = -513;
  static final int INSTALL_FAILURE_UNZIP_TMP_TMP_UNZIP_IS_NULL = -521;
  static final int INSTALL_FAILURE_WRITE_INFO_EXCEPTION = -518;
  static final int INSTALL_FAILURE_WRITE_INFO_SUCCESS = -517;
  static final int INTERRUPT_CODE_DEFALUT = -99;
  static final int INTERRUPT_TIME_OUT = -98;
  private static final long INTERRUPT_TIME_OUT_INTERVAL = 86400000L;
  static final int NEEDDOWNLOAD_API_LEVEL_BELOW_FROYO = -102;
  static final int NEEDDOWNLOAD_DEFAULT = -100;
  static final int NEEDDOWNLOAD_DEVICE_CUPABI_IN_BLACKLIST = -104;
  static final int NEEDDOWNLOAD_DISABLE_OVERSEA = -103;
  static final int NEEDDOWNLOAD_INIT_THREAD_EXCEPTION = -105;
  static final int NEEDDOWNLOAD_MAX_FLOW_CONTROL = -120;
  static final int NEEDDOWNLOAD_NO_FREE_SPACE = -117;
  static final int NEEDDOWNLOAD_OVERFLOW_MAX_DOWNLOAD_FAILED_RETRY_TIMES = -116;
  static final int NEEDDOWNLOAD_OVERFLOW_MAX_DOWNLOAD_SUCCESS_RETRY_TIMES = -115;
  static final int NEEDDOWNLOAD_QUERY_REQUEST = -114;
  static final int NEEDDOWNLOAD_READ_RESPONSE_ARGS_ERROR = -112;
  static final int NEEDDOWNLOAD_READ_RESPONSE_EMPTRY_URL = -124;
  static final int NEEDDOWNLOAD_READ_RESPONSE_EMPTY = -108;
  static final int NEEDDOWNLOAD_READ_RESPONSE_ERROR_VERSION = -125;
  static final int NEEDDOWNLOAD_READ_RESPONSE_HAS_LOCAL_VERSION = -113;
  static final int NEEDDOWNLOAD_READ_RESPONSE_NEEDSTARTDOWNLOAD = -122;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RESET_TBS = -110;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RESPONSE_CODE_ZERO = -111;
  static final int NEEDDOWNLOAD_READ_RESPONSE_RET_ERROR = -109;
  static final int NEEDDOWNLOAD_READ_RESPONSE_VERSION_BELOW_LASTVERSION = -128;
  static final int NEEDDOWNLOAD_READ_RESPONSE_VERSION_BELOW_LOCALVERSION = -127;
  static final int NEEDDOWNLOAD_READ_RESPONSE_VERSION_DISABLED = -126;
  static final int NEEDDOWNLOAD_SEND_REQUEST_LOCAL_EXCEPTION = -106;
  static final int NEEDDOWNLOAD_SEND_REQUEST_SERVER_EXCEPTION = -107;
  static final int NEEDDOWNLOAD_STARTDOWNLOAD_FALSE = -119;
  static final int NEEDDOWNLOAD_STARTDOWNLOAD_FALSE_AND_SEND_REQUEST = -121;
  static final int NEEDDOWNLOAD_STARTDOWNLOAD_FALSE_APKDOWNLOADED = -123;
  static final int NEEDDOWNLOAD_UNCALL = -101;
  static final int NEEDDOWNLOAD_UNCALL_EXCEPTION = -95;
  static final int NEEDDOWNLOAD_UNCALL_FILE_NOTEXISTS = -97;
  static final int NEEDDOWNLOAD_UNCALL_NO_KEY_NEEDDOWNLOAD = -96;
  static final int NEEDDOWNLOAD_WILL_STARTDOWNLOAD = -118;
  static final int STARTDOWNLOAD_API_LEVEL_BELOW_FROYO = -201;
  static final int STARTDOWNLOAD_DEFAULT = -200;
  static final int STARTDOWNLOAD_DEVICE_CUPABI_IN_BLACKLIST = -205;
  static final int STARTDOWNLOAD_FINISH = -215;
  static final int STARTDOWNLOAD_INIT_THREAD_EXCEPTION = -202;
  static final int STARTDOWNLOAD_NOSDCARD_WRITEABLE_PERMISSION = -204;
  static final int STARTDOWNLOAD_PROCESS_LOCKED = -203;
  static final int STARTDOWNLOAD_READ_RESPONSE_ARGS_ERROR = -212;
  static final int STARTDOWNLOAD_READ_RESPONSE_EMPTRY_URL = -217;
  static final int STARTDOWNLOAD_READ_RESPONSE_EMPTY = -208;
  static final int STARTDOWNLOAD_READ_RESPONSE_ERROR_VERSION = -218;
  static final int STARTDOWNLOAD_READ_RESPONSE_HAS_LOCAL_APK = -214;
  static final int STARTDOWNLOAD_READ_RESPONSE_HAS_LOCAL_VERSION = -213;
  static final int STARTDOWNLOAD_READ_RESPONSE_NEEDSTARTDOWNLOAD = -216;
  static final int STARTDOWNLOAD_READ_RESPONSE_RESET_TBS = -210;
  static final int STARTDOWNLOAD_READ_RESPONSE_RESPONSE_CODE_ZERO = -211;
  static final int STARTDOWNLOAD_READ_RESPONSE_RET_ERROR = -209;
  static final int STARTDOWNLOAD_READ_RESPONSE_VERSION_BELOW_LOCALVERSION = -219;
  static final int STARTDOWNLOAD_SEND_REQUEST_LOCAL_EXCEPTION = -206;
  static final int STARTDOWNLOAD_SEND_REQUEST_SERVER_EXCEPTION = -207;
  private static final String TBS_CFG_FILE = "tbs_download_config";
  static final int THIRDAPP_COREVERSION_IS_ZERO = -401;
  static final int THIRDAPP_DECREACE_ERROR = -404;
  static final int THIRDAPP_DEFAULT = -400;
  static final int THIRDAPP_GET_COREINFO_ERROR = -405;
  static final int THIRDAPP_NO_NEED_UPDATE_COREVERSION = -403;
  static final int THIRDAPP_READ_FROM_CONFIG_ERROR = -402;
  static final int THIRDAPP_WRITE_COREINFO_OK = -406;
  private static TbsDownloadConfig mInstance;
  private Context mAppContext;
  public SharedPreferences mPreferences;
  Map<String, Object> mSyncMap = new HashMap();
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.mAppContext = paramContext.getApplicationContext();
    if (this.mAppContext == null) {
      this.mAppContext = paramContext;
    }
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = mInstance;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsDownloadConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.mSyncMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        str = (String)localIterator.next();
        localObject2 = this.mSyncMap.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        localObject1.putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1.putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        localObject1.putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label203:
        localObject1.commit();
        this.mSyncMap.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: ldc_w 466
    //   9: invokeinterface 470 2 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +129 -> 145
    //   19: new 472	java/io/File
    //   22: dup
    //   23: new 472	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mAppContext	Landroid/content/Context;
    //   31: invokevirtual 476	android/content/Context:getFilesDir	()Ljava/io/File;
    //   34: ldc_w 478
    //   37: invokespecial 481	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: ldc_w 307
    //   43: invokespecial 481	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: invokevirtual 484	java/io/File:exists	()Z
    //   49: istore_3
    //   50: iload_3
    //   51: ifne +57 -> 108
    //   54: bipush 159
    //   56: istore_1
    //   57: aload_0
    //   58: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mAppContext	Landroid/content/Context;
    //   61: ifnull +163 -> 224
    //   64: ldc_w 486
    //   67: aload_0
    //   68: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mAppContext	Landroid/content/Context;
    //   71: invokevirtual 490	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   74: getfield 495	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   77: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +144 -> 224
    //   83: ldc_w 501
    //   86: invokestatic 507	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   89: invokevirtual 511	java/util/Locale:getCountry	()Ljava/lang/String;
    //   92: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: istore_3
    //   96: iload_3
    //   97: ifne +127 -> 224
    //   100: sipush -320
    //   103: istore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: aload_0
    //   109: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   112: ldc_w 513
    //   115: invokeinterface 470 2 0
    //   120: istore_3
    //   121: iload_3
    //   122: ifne +9 -> 131
    //   125: bipush 160
    //   127: istore_1
    //   128: goto -71 -> 57
    //   131: bipush 155
    //   133: istore_1
    //   134: goto -77 -> 57
    //   137: astore 4
    //   139: bipush 161
    //   141: istore_1
    //   142: goto -85 -> 57
    //   145: aload_0
    //   146: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   149: ldc_w 466
    //   152: bipush 157
    //   154: invokeinterface 461 3 0
    //   159: istore_1
    //   160: iload_1
    //   161: bipush 137
    //   163: if_icmpeq +11 -> 174
    //   166: iload_1
    //   167: istore_2
    //   168: iload_1
    //   169: bipush 135
    //   171: if_icmpne +18 -> 189
    //   174: aload_0
    //   175: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   178: ldc_w 515
    //   181: bipush 137
    //   183: invokeinterface 461 3 0
    //   188: istore_2
    //   189: iload_2
    //   190: istore_1
    //   191: invokestatic 520	java/lang/System:currentTimeMillis	()J
    //   194: aload_0
    //   195: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   198: ldc_w 522
    //   201: lconst_0
    //   202: invokeinterface 526 4 0
    //   207: lsub
    //   208: ldc2_w 198
    //   211: lcmp
    //   212: ifle -155 -> 57
    //   215: iload_2
    //   216: ldc_w 527
    //   219: isub
    //   220: istore_1
    //   221: goto -164 -> 57
    //   224: aload_0
    //   225: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   228: ldc_w 529
    //   231: iconst_m1
    //   232: invokeinterface 461 3 0
    //   237: istore_2
    //   238: iload_1
    //   239: sipush 1000
    //   242: imul
    //   243: iload_2
    //   244: iadd
    //   245: istore_1
    //   246: goto -142 -> 104
    //   249: astore 4
    //   251: aload_0
    //   252: monitorexit
    //   253: aload 4
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	TbsDownloadConfig
    //   56	190	1	i	int
    //   167	78	2	j	int
    //   14	108	3	bool	boolean
    //   137	1	4	localThrowable	java.lang.Throwable
    //   249	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	50	137	java/lang/Throwable
    //   108	121	137	java/lang/Throwable
    //   2	15	249	finally
    //   19	50	249	finally
    //   57	96	249	finally
    //   108	121	249	finally
    //   145	160	249	finally
    //   174	189	249	finally
    //   191	215	249	finally
    //   224	238	249	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getDownloadMinFreeSpace()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 537
    //   11: iconst_0
    //   12: invokeinterface 461 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +18 -> 37
    //   22: iload_1
    //   23: sipush 1024
    //   26: imul
    //   27: i2l
    //   28: lstore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: lload_3
    //   32: ldc2_w 533
    //   35: lmul
    //   36: lreturn
    //   37: iload_2
    //   38: istore_1
    //   39: goto -17 -> 22
    //   42: astore 5
    //   44: aload_0
    //   45: monitorexit
    //   46: aload 5
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	TbsDownloadConfig
    //   1	38	1	i	int
    //   17	21	2	j	int
    //   28	4	3	l	long
    //   42	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	42	finally
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getRetryInterval()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 549	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   5: lconst_0
    //   6: lcmp
    //   7: iflt +11 -> 18
    //   10: invokestatic 549	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   13: lstore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: lload_1
    //   17: lreturn
    //   18: aload_0
    //   19: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   22: ldc_w 551
    //   25: ldc2_w 71
    //   28: invokeinterface 526 4 0
    //   33: lstore_1
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   13	21	1	l	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   18	34	37	finally
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockEnable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 554
    //   11: iconst_1
    //   12: invokeinterface 558 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: astore_3
    //   30: goto -10 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadConfig
    //   1	22	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   24	4	3	localObject	Object
    //   29	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	24	finally
    //   4	18	29	java/lang/Exception
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 375 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 466
    //   16: iload_1
    //   17: invokeinterface 444 3 0
    //   22: pop
    //   23: aload_2
    //   24: ldc_w 522
    //   27: invokestatic 520	java/lang/System:currentTimeMillis	()J
    //   30: invokeinterface 434 4 0
    //   35: pop
    //   36: aload_2
    //   37: invokeinterface 383 1 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: goto -9 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TbsDownloadConfig
    //   0	55	1	paramInt	int
    //   11	26	2	localEditor	SharedPreferences.Editor
    //   46	4	2	localObject	Object
    //   51	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	43	46	finally
    //   2	43	51	java/lang/Exception
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 348	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 375 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 554
    //   16: iload_1
    //   17: invokeinterface 424 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 383 1 0
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: goto -9 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   0	42	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   38	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	38	java/lang/Exception
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
    public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
    public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
    public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
    public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
    public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_FULL_PACKAGE = "request_full_package";
    public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
    public static final String KEY_IS_OVERSEA = "is_oversea";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
    public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
    public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_REQUEST_FAIL = "request_fail";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_RETRY_INTERVAL = "retry_interval";
    public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
    public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
    public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
    public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
    public static final String KEY_USE_BUGLY = "tbs_use_bugly";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */