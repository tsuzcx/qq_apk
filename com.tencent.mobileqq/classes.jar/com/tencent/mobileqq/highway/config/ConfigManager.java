package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class ConfigManager
  implements IHwManager
{
  private static final String BDH_FILE_DIR;
  private static final String CUSTOM_ENV_FILE_NAME = "custom_env";
  static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  private static final String STORE_KEY_ID = "STORE_KEY_ID";
  private static final String STORE_KEY_IP = "STORE_KEY_IP";
  private static final String STORE_KEY_PORT = "STORE_KEY_PORT";
  public static final String TAG = "HWConfigManager";
  private static int mCustomID = 0;
  private static volatile ConfigManager mUniqueInstance;
  public static int mUseHardCodeIp = -1;
  private Context mContext4MSFGet;
  private EndPoint mCustomEnvAddr;
  private boolean mCustomeEnvInit;
  private IpContainer mGetIpContainer;
  private ArrayList<HwNetSegConf> mHCNetSegConfList;
  private HardCodeIpList mHardCodeIpList;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private HwEngine mHwEngine;
  private Map<Integer, ServiceIpProvider> mIPProviders = new HashMap();
  private boolean mIsGettingConfg = false;
  private IpContainer mPushIpContainer;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile;
    if (BaseApplication.getContext().getExternalFilesDir(null) == null) {
      localFile = BaseApplication.getContext().getFilesDir();
    } else {
      localFile = BaseApplication.getContext().getExternalFilesDir(null);
    }
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append("/tencent/MobileQQ/bdh/");
    BDH_FILE_DIR = localStringBuilder.toString();
  }
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwEngine paramHwEngine)
  {
    this.mHwEngine = paramHwEngine;
    this.mHCNetSegConfList = new ArrayList();
    this.mHCNetSegConfList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
    initIpConfig(paramContext, paramAppRuntime);
  }
  
  public static int getCustomEnvId()
  {
    return mCustomID;
  }
  
  public static ConfigManager getInstance(Context paramContext, HwEngine paramHwEngine)
  {
    if (mUniqueInstance == null) {
      if ((paramContext != null) && (paramHwEngine != null) && (paramHwEngine.app != null) && (paramHwEngine.currentUin != null)) {
        try
        {
          if (mUniqueInstance == null) {
            mUniqueInstance = new ConfigManager(paramContext, paramHwEngine.app, paramHwEngine.currentUin, paramHwEngine);
          }
        }
        finally {}
      } else {
        return null;
      }
    }
    return mUniqueInstance;
  }
  
  private HwNetSegConf getNetSegConfByType(ArrayList<HwNetSegConf> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramArrayList.next();
      if (localHwNetSegConf.netType == paramInt) {
        return localHwNetSegConf;
      }
    }
    return null;
  }
  
  private void handleIpv6Cfg(Context paramContext, HwConfig paramHwConfig)
  {
    PBUInt32Field localPBUInt32Field = paramHwConfig.fmtIpv6Policy;
    int m = 0;
    int j;
    int i;
    if (localPBUInt32Field != null)
    {
      j = paramHwConfig.fmtIpv6Policy.get();
      i = 1;
    }
    else
    {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.fmtIpv6Policy is null ");
      i = 0;
      j = 0;
    }
    int k;
    if (paramHwConfig.bdhIpv6Policy != null)
    {
      k = paramHwConfig.bdhIpv6Policy.get();
      i = 1;
    }
    else
    {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.bdhIpv6Policy is null ");
      k = 0;
    }
    if (paramHwConfig.connAttemptDelay != null)
    {
      m = paramHwConfig.connAttemptDelay.get();
      i = 1;
    }
    else
    {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.connAttemptDelay is null ");
    }
    if (i != 0) {
      Ipv6Config.updateCfgFromSrv(paramContext, j, k, m);
    }
  }
  
  /* Error */
  private void initCustomEnv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 225	com/tencent/mobileqq/highway/config/ConfigManager:mCustomeEnvInit	Z
    //   6: ifne +128 -> 134
    //   9: new 79	java/io/File
    //   12: dup
    //   13: getstatic 94	com/tencent/mobileqq/highway/config/ConfigManager:BDH_FILE_DIR	Ljava/lang/String;
    //   16: ldc 11
    //   18: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 230	java/io/File:exists	()Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +101 -> 129
    //   31: new 232	java/io/FileInputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_3
    //   40: new 237	java/util/Properties
    //   43: dup
    //   44: invokespecial 238	java/util/Properties:<init>	()V
    //   47: astore_2
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual 242	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: aload_2
    //   54: ldc 19
    //   56: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +10 -> 71
    //   64: aload_3
    //   65: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: putstatic 144	com/tencent/mobileqq/highway/config/ConfigManager:mCustomID	I
    //   71: aload_2
    //   72: ldc 21
    //   74: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_3
    //   78: aload_2
    //   79: ldc 23
    //   81: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_2
    //   85: aload_3
    //   86: ifnull +43 -> 129
    //   89: aload_2
    //   90: ifnull +39 -> 129
    //   93: aload_0
    //   94: new 254	com/tencent/mobileqq/highway/utils/EndPoint
    //   97: dup
    //   98: aload_3
    //   99: aload_2
    //   100: invokestatic 258	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 261	java/lang/Integer:intValue	()I
    //   106: invokespecial 264	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;I)V
    //   109: putfield 266	com/tencent/mobileqq/highway/config/ConfigManager:mCustomEnvAddr	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   112: goto +17 -> 129
    //   115: astore_2
    //   116: goto +11 -> 127
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   124: goto +5 -> 129
    //   127: aload_2
    //   128: athrow
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 225	com/tencent/mobileqq/highway/config/ConfigManager:mCustomeEnvInit	Z
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ConfigManager
    //   26	2	1	bool	boolean
    //   21	79	2	localObject1	Object
    //   115	1	2	localObject2	Object
    //   119	9	2	localException	java.lang.Exception
    //   137	4	2	localObject3	Object
    //   39	60	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   31	60	115	finally
    //   64	71	115	finally
    //   71	85	115	finally
    //   93	112	115	finally
    //   120	124	115	finally
    //   31	60	119	java/lang/Exception
    //   64	71	119	java/lang/Exception
    //   71	85	119	java/lang/Exception
    //   93	112	119	java/lang/Exception
    //   2	27	137	finally
    //   127	129	137	finally
    //   129	134	137	finally
  }
  
  private void initIpConfig(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("v6.htdata.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    this.mPushIpContainer = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mGetIpContainer = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
    this.mIPProviders.put(Integer.valueOf(21), new ServiceIpProvider(paramContext, paramAppRuntime, 21));
  }
  
  private void onSvrConnFailed(EndPoint paramEndPoint)
  {
    this.mPushIpContainer.onConnFailed(paramEndPoint);
    this.mGetIpContainer.onConnFailed(paramEndPoint);
  }
  
  private void onSvrConnSuccess(EndPoint paramEndPoint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSvrConnSuccess() IP = ");
    localStringBuilder.append(paramEndPoint.host);
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    this.mPushIpContainer.onConnSuccess(paramEndPoint);
    this.mGetIpContainer.onConnSuccess(paramEndPoint);
  }
  
  private void processHwConfigPush(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime)
  {
    if (paramHwConfig == null) {
      return;
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_refresh_cached_ip.get() == 1)) {
      IpContainer.refreshIpLearning();
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_enable_ip_learn.get() == 1)) {
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 1;
    } else {
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 0;
    }
    if (paramHwConfig.dtConf != null) {
      BdhSegTimeoutUtil.updateFromSrv(paramHwConfig.dtConf);
    }
    if (paramHwConfig.openUpConf != null) {
      OpenUpConfig.updateFromSrv(paramHwConfig.openUpConf);
    }
    if (paramHwConfig.videoConf != null) {
      VideoUpConfigInfo.updateFromSrc(paramHwConfig.videoConf);
    } else {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.videoConf is null ");
    }
    if (paramHwConfig.ptvCof != null) {
      PTVUpConfigInfo.updateFromSrc(paramHwConfig.ptvCof);
    } else {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.ptvCof is null ");
    }
    handleIpv6Cfg(paramContext, paramHwConfig);
    this.mPushIpContainer.addNew(paramContext, paramHwConfig, paramAppRuntime, this);
  }
  
  private void processOtherTypeConfigPush(Map<Integer, HwConfig> paramMap, AppRuntime paramAppRuntime)
  {
    Integer[] arrayOfInteger = new Integer[1];
    int i = 0;
    arrayOfInteger[0] = Integer.valueOf(21);
    int j = arrayOfInteger.length;
    while (i < j)
    {
      Object localObject = arrayOfInteger[i];
      HwConfig localHwConfig = (HwConfig)paramMap.get(arrayOfInteger);
      if (localHwConfig != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processOtherTypeConfigPush() ");
        localStringBuilder.append(localObject);
        BdhLogUtil.LogEvent("C", localStringBuilder.toString());
        localObject = (ServiceIpProvider)this.mIPProviders.get(localObject);
        if (localObject != null) {
          ((ServiceIpProvider)localObject).addPushIp(localHwConfig, paramAppRuntime);
        }
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void saveCustomEnv(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 79	java/io/File
    //   3: dup
    //   4: getstatic 94	com/tencent/mobileqq/highway/config/ConfigManager:BDH_FILE_DIR	Ljava/lang/String;
    //   7: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload_0
    //   13: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +24 -> 40
    //   19: aload_1
    //   20: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +17 -> 40
    //   26: aload_2
    //   27: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +10 -> 40
    //   33: aload 4
    //   35: invokevirtual 422	java/io/File:delete	()Z
    //   38: pop
    //   39: return
    //   40: aload 4
    //   42: invokevirtual 230	java/io/File:exists	()Z
    //   45: ifne +48 -> 93
    //   48: aload 4
    //   50: invokevirtual 425	java/io/File:mkdirs	()Z
    //   53: ifne +40 -> 93
    //   56: new 60	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   63: astore_0
    //   64: aload_0
    //   65: ldc_w 427
    //   68: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: aload 4
    //   75: invokevirtual 430	java/io/File:getPath	()Ljava/lang/String;
    //   78: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 26
    //   84: iconst_2
    //   85: aload_0
    //   86: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 436	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: new 79	java/io/File
    //   96: dup
    //   97: aload 4
    //   99: ldc 11
    //   101: invokespecial 439	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   104: astore 8
    //   106: aconst_null
    //   107: astore 7
    //   109: aconst_null
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 5
    //   115: aload 7
    //   117: astore 4
    //   119: aload 8
    //   121: invokevirtual 422	java/io/File:delete	()Z
    //   124: pop
    //   125: aload 7
    //   127: astore 4
    //   129: aload 8
    //   131: invokevirtual 442	java/io/File:createNewFile	()Z
    //   134: ifeq +116 -> 250
    //   137: aload 7
    //   139: astore 4
    //   141: new 444	java/io/FileOutputStream
    //   144: dup
    //   145: aload 8
    //   147: invokespecial 445	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: astore 5
    //   152: new 237	java/util/Properties
    //   155: dup
    //   156: invokespecial 238	java/util/Properties:<init>	()V
    //   159: astore 4
    //   161: aload_0
    //   162: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +12 -> 177
    //   168: aload 4
    //   170: ldc 21
    //   172: aload_0
    //   173: invokevirtual 449	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_1
    //   178: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +12 -> 193
    //   184: aload 4
    //   186: ldc 23
    //   188: aload_1
    //   189: invokevirtual 449	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   192: pop
    //   193: aload_2
    //   194: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: istore_3
    //   198: iload_3
    //   199: ifne +27 -> 226
    //   202: aload_2
    //   203: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: ifle +20 -> 226
    //   209: aload 4
    //   211: ldc 19
    //   213: aload_2
    //   214: invokevirtual 449	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   217: pop
    //   218: goto +8 -> 226
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 450	java/lang/NumberFormatException:printStackTrace	()V
    //   226: aload 4
    //   228: aload 5
    //   230: ldc_w 452
    //   233: invokevirtual 456	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   236: goto +14 -> 250
    //   239: astore_0
    //   240: goto +59 -> 299
    //   243: astore_1
    //   244: aload 5
    //   246: astore_0
    //   247: goto +28 -> 275
    //   250: aload 5
    //   252: ifnull +46 -> 298
    //   255: aload 5
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   262: return
    //   263: astore_0
    //   264: aload 4
    //   266: astore 5
    //   268: goto +31 -> 299
    //   271: astore_1
    //   272: aload 6
    //   274: astore_0
    //   275: aload_0
    //   276: astore 4
    //   278: aload_1
    //   279: invokevirtual 460	java/io/IOException:printStackTrace	()V
    //   282: aload_0
    //   283: astore 4
    //   285: aload 8
    //   287: invokevirtual 422	java/io/File:delete	()Z
    //   290: pop
    //   291: aload_0
    //   292: ifnull +6 -> 298
    //   295: goto -37 -> 258
    //   298: return
    //   299: aload 5
    //   301: ifnull +8 -> 309
    //   304: aload 5
    //   306: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   309: goto +5 -> 314
    //   312: aload_0
    //   313: athrow
    //   314: goto -2 -> 312
    //   317: astore_0
    //   318: return
    //   319: astore_1
    //   320: goto -11 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramString1	String
    //   0	323	1	paramString2	String
    //   0	323	2	paramString3	String
    //   197	2	3	bool	boolean
    //   10	274	4	localObject1	Object
    //   113	192	5	localObject2	Object
    //   110	163	6	localObject3	Object
    //   107	31	7	localObject4	Object
    //   104	182	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   202	218	221	java/lang/NumberFormatException
    //   152	177	239	finally
    //   177	193	239	finally
    //   193	198	239	finally
    //   202	218	239	finally
    //   222	226	239	finally
    //   226	236	239	finally
    //   152	177	243	java/io/IOException
    //   177	193	243	java/io/IOException
    //   193	198	243	java/io/IOException
    //   202	218	243	java/io/IOException
    //   222	226	243	java/io/IOException
    //   226	236	243	java/io/IOException
    //   119	125	263	finally
    //   129	137	263	finally
    //   141	152	263	finally
    //   278	282	263	finally
    //   285	291	263	finally
    //   119	125	271	java/io/IOException
    //   129	137	271	java/io/IOException
    //   141	152	271	java/io/IOException
    //   258	262	317	java/lang/Exception
    //   304	309	319	java/lang/Exception
  }
  
  public void clearIpv6Cfg(Context paramContext)
  {
    this.mPushIpContainer.cleanIpv6Cfg(paramContext);
    this.mGetIpContainer.cleanIpv6Cfg(paramContext);
  }
  
  public SparseArray<HwNetSegConf> getAllBuzSegConfs(Context paramContext)
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1, getNetSegConf(paramContext, 1));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    return localSparseArray;
  }
  
  public EndPoint getCustomEnvAddr()
  {
    initCustomEnv();
    return this.mCustomEnvAddr;
  }
  
  public HwEngine getHwEngine()
  {
    return this.mHwEngine;
  }
  
  public List<EndPoint> getIpList(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.mPushIpContainer;
    if (localObject1 != null) {
      localObject1 = ((IpContainer)localObject1).findIpCurNetList(paramContext, paramBoolean);
    } else {
      localObject1 = null;
    }
    IpContainer localIpContainer = this.mGetIpContainer;
    Object localObject2 = localObject1;
    if (localIpContainer != null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIpContainer.findIpCurNetList(paramContext, paramBoolean);
      }
    }
    if (localObject2 != null) {
      localArrayList.addAll((Collection)localObject2);
    }
    return localArrayList;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    return getNetSegConf(paramContext, 0);
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext, int paramInt)
  {
    Object localObject = this.mHCNetSegConfList;
    ArrayList localArrayList = this.mPushIpContainer.getNetSegConf(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject = localArrayList;
    }
    else
    {
      localArrayList = this.mGetIpContainer.getNetSegConf(paramInt);
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        localObject = localArrayList;
      }
    }
    int j = HwNetworkUtil.getSystemNetwork(paramContext);
    int i = 0;
    paramInt = i;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5)
              {
                paramInt = i;
                break label133;
              }
            }
            else
            {
              paramInt = 4;
              break label133;
            }
          }
          else
          {
            paramInt = 3;
            break label133;
          }
        }
        else
        {
          paramInt = 2;
          break label133;
        }
      }
      paramInt = 1;
    }
    label133:
    paramContext = getNetSegConfByType((ArrayList)localObject, paramInt);
    if (paramContext != null) {
      return paramContext;
    }
    BdhLogUtil.LogEvent("C", "getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, paramInt);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject1 = getCustomEnvAddr();
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = this.mPushIpContainer;
    if (localObject1 != null)
    {
      localObject2 = ((IpContainer)localObject1).findIpCurNet(paramContext, paramBoolean);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNextSrvAddr, mPushIpContainer.findIpCurNet, epFromPush = ");
        ((StringBuilder)localObject1).append(((EndPoint)localObject2).toString());
        ((StringBuilder)localObject1).append(" with key= ");
        ((StringBuilder)localObject1).append(((EndPoint)localObject2).keyOfAPN);
        ((StringBuilder)localObject1).append(", timestamp = ");
        ((StringBuilder)localObject1).append(((EndPoint)localObject2).timestamp);
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = this.mGetIpContainer;
    if (localObject2 != null)
    {
      EndPoint localEndPoint = ((IpContainer)localObject2).findIpCurNet(paramContext, paramBoolean);
      localObject2 = localEndPoint;
      if (localEndPoint != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getNextSrvAddr, mGetIpContainer.findIpCurNet, epFromGet =  ");
        ((StringBuilder)localObject2).append(localEndPoint.toString());
        ((StringBuilder)localObject2).append(" with key= ");
        ((StringBuilder)localObject2).append(localEndPoint.keyOfAPN);
        ((StringBuilder)localObject2).append(", timestamp = ");
        ((StringBuilder)localObject2).append(localEndPoint.timestamp);
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
        localObject2 = localEndPoint;
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((localObject1 != null) && (localObject2 != null))
    {
      if (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp) {
        return localObject1;
      }
      return localObject2;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    if (!this.mIsGettingConfg)
    {
      this.mContext4MSFGet = paramContext;
      HwServlet.getConfig(paramAppRuntime, paramString);
    }
    paramString = this.mPushIpContainer;
    if (paramString != null)
    {
      paramString = paramString.findIpRecent(paramContext, paramBoolean);
      localObject1 = paramString;
      if (paramString != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNextSrvAddr, mPushIpContainer.findIpRecent, epFromPush = ");
        ((StringBuilder)localObject1).append(paramString.toString());
        ((StringBuilder)localObject1).append(" with key= ");
        ((StringBuilder)localObject1).append(paramString.keyOfAPN);
        ((StringBuilder)localObject1).append(", timestamp = ");
        ((StringBuilder)localObject1).append(paramString.timestamp);
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject1).toString());
        localObject1 = paramString;
      }
    }
    paramString = this.mGetIpContainer;
    if (paramString != null)
    {
      paramString = paramString.findIpRecent(paramContext, paramBoolean);
      localObject2 = paramString;
      if (paramString != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getNextSrvAddr, mGetIpContainer.findIpRecent, epFromGet =  ");
        ((StringBuilder)localObject2).append(paramString.toString());
        ((StringBuilder)localObject2).append(" with key= ");
        ((StringBuilder)localObject2).append(paramString.keyOfAPN);
        ((StringBuilder)localObject2).append(", timestamp = ");
        ((StringBuilder)localObject2).append(paramString.timestamp);
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
        localObject2 = paramString;
      }
    }
    if ((localObject1 != null) && (localObject2 != null))
    {
      if (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp) {
        return localObject1;
      }
      return localObject2;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    if (mUseHardCodeIp == -1) {
      mUseHardCodeIp = 1;
    }
    paramString = this.mHardCodeIpList.getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
    if (paramString != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("getNextSrvAddr(), mHardCodeIpList.getRandomFromCandicate4HardCode, epDomain =  ");
      paramContext.append(paramString.host);
      paramContext.append(" port=");
      paramContext.append(paramString.port);
      BdhLogUtil.LogEvent("C", paramContext.toString());
      return paramString;
    }
    if (!paramBoolean)
    {
      paramString = this.mHardCodeIpList.getNextIp(paramContext);
      if (paramString != null)
      {
        paramContext = new StringBuilder();
        paramContext.append("getNextSrvAddr(), mHardCodeIpList.getNextIp, epHardCode =  ");
        paramContext.append(paramString.host);
        paramContext.append(" port=");
        paramContext.append(paramString.port);
        BdhLogUtil.LogEvent("C", paramContext.toString());
        return paramString;
      }
    }
    initIpConfig(paramContext, paramAppRuntime);
    return null;
  }
  
  public List<EndPoint> getOtherTypeIp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    ServiceIpProvider localServiceIpProvider = (ServiceIpProvider)this.mIPProviders.get(Integer.valueOf(paramInt));
    if (localServiceIpProvider != null) {
      return localServiceIpProvider.getIpList(paramContext, paramBoolean);
    }
    return null;
  }
  
  public boolean hasIpv6List(Context paramContext)
  {
    IpContainer localIpContainer = this.mPushIpContainer;
    if ((localIpContainer != null) && (localIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mPushIpContainer has ipv6 list ");
      return true;
    }
    localIpContainer = this.mGetIpContainer;
    if ((localIpContainer != null) && (localIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mGetIpContainer has ipv6 list ");
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      mUniqueInstance = null;
      return;
    }
    finally {}
  }
  
  public void onInit() {}
  
  public void onNetWorkChange(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean) {}
  
  public void onOtherTypeSrvAddrGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramHwConfig != null)
    {
      if (paramHwConfig.ipList.isEmpty()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTypeSrvAddrGet() ");
      ((StringBuilder)localObject).append(paramInt);
      BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
      localObject = (ServiceIpProvider)this.mIPProviders.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        ((ServiceIpProvider)localObject).addSSOGetIp(paramHwConfig, paramAppRuntime);
      }
    }
  }
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, Map<Integer, HwConfig> paramMap)
  {
    if (paramMap != null)
    {
      BdhLogUtil.LogEvent("C", "onSrvAddrPush() ");
      processHwConfigPush(paramContext, (HwConfig)paramMap.get(Integer.valueOf(10)), paramAppRuntime);
      processOtherTypeConfigPush(paramMap, paramAppRuntime);
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig != null) && (!paramHwConfig.ipList.isEmpty()))
    {
      if (this.mContext4MSFGet == null) {
        return;
      }
      BdhLogUtil.LogEvent("C", "onSrvAddrHttpGet() ");
      this.mGetIpContainer.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime, this);
      this.mIsGettingConfg = false;
      this.mContext4MSFGet = null;
    }
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 3)
    {
      BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable() connError_unreachable");
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("onSrvAddrUnavailable() IP = ");
    paramContext.append(paramString2);
    BdhLogUtil.LogEvent("C", paramContext.toString());
    boolean bool2 = this.mPushIpContainer.fail(paramString2, paramBoolean);
    boolean bool3 = this.mGetIpContainer.fail(paramString2, paramBoolean);
    boolean bool1 = false;
    paramBoolean = bool1;
    if (!bool2)
    {
      paramBoolean = bool1;
      if (!bool3)
      {
        paramContext = this.mHcDomainCandicateList;
        paramBoolean = bool1;
        if (paramContext != null)
        {
          paramBoolean = HardCodeIpList.foundNRemoveIP(paramContext, paramString2);
          BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHcDomainCandicateList ");
        }
      }
    }
    if (!paramBoolean)
    {
      paramContext = this.mHardCodeIpList;
      if (paramContext != null)
      {
        paramContext.foundNRemove(paramString2);
        BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHardCodeIpList ");
      }
    }
  }
  
  public void onSvrConnFinish(EndPoint paramEndPoint, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onSvrConnFinish IP = ");
    localStringBuilder.append(paramEndPoint.host);
    localStringBuilder.append(" err:");
    localStringBuilder.append(paramInt);
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    if (paramInt == 0)
    {
      onSvrConnSuccess(paramEndPoint);
      return;
    }
    if (paramInt != 3) {
      onSvrConnFailed(paramEndPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */