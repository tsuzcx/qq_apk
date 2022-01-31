package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class ConfigManager
  implements IHwManager
{
  private static final String BDH_FILE_DIR;
  private static final String CUSTOM_ENV_FILE_NAME = "custom_env";
  private static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  private static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  private static final String STORE_KEY_ID = "STORE_KEY_ID";
  private static final String STORE_KEY_IP = "STORE_KEY_IP";
  private static final String STORE_KEY_PORT = "STORE_KEY_PORT";
  public static final String TAG = "HWConfigManager";
  private static int mCustomID;
  private static volatile ConfigManager mUniqueInstance;
  public static int mUseHardCodeIp = -1;
  private Context mContext4MSFGet;
  public int mCurnetIptype;
  private EndPoint mCustomEnvAddr;
  private boolean mCustomeEnvInit;
  private IpContainer mGetIpContainer;
  private ArrayList<HwNetSegConf> mHCNetSegConfList;
  private HardCodeIpList mHardCodeIpList;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private HwEngine mHwEngine;
  public Ipv6Available mIpv6Available;
  private boolean mIsGettingConfg;
  private IpContainer mPushIpContainer;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (BaseApplication.getContext().getExternalFilesDir(null) == null) {}
    for (String str = BaseApplication.getContext().getFilesDir().getAbsolutePath();; str = BaseApplication.getContext().getExternalFilesDir(null).getAbsolutePath())
    {
      BDH_FILE_DIR = str + "/tencent/MobileQQ/bdh/";
      return;
    }
  }
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwEngine paramHwEngine)
  {
    this.mHwEngine = paramHwEngine;
    this.mIpv6Available = new Ipv6Available();
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
      if ((paramContext == null) || (paramHwEngine == null) || (paramHwEngine.app == null) || (paramHwEngine.currentUin == null)) {
        return null;
      }
    }
    try
    {
      if (mUniqueInstance == null) {
        mUniqueInstance = new ConfigManager(paramContext, paramHwEngine.app, paramHwEngine.currentUin, paramHwEngine);
      }
      return mUniqueInstance;
    }
    finally {}
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
  
  private void initCustomEnv()
  {
    try
    {
      Object localObject1;
      if (!this.mCustomeEnvInit)
      {
        localObject1 = new File(BDH_FILE_DIR, "custom_env");
        boolean bool = ((File)localObject1).exists();
        if (!bool) {}
      }
      try
      {
        Object localObject4 = new FileInputStream((File)localObject1);
        localObject1 = new Properties();
        ((Properties)localObject1).load((InputStream)localObject4);
        localObject4 = ((Properties)localObject1).getProperty("STORE_KEY_ID");
        if (localObject4 != null) {
          mCustomID = Integer.parseInt((String)localObject4);
        }
        localObject4 = ((Properties)localObject1).getProperty("STORE_KEY_IP");
        localObject1 = ((Properties)localObject1).getProperty("STORE_KEY_PORT");
        if ((localObject4 != null) && (localObject1 != null)) {
          this.mCustomEnvAddr = new EndPoint((String)localObject4, Integer.valueOf((String)localObject1).intValue());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException = localException;
          localException.printStackTrace();
        }
      }
      finally {}
      this.mCustomeEnvInit = true;
      return;
    }
    finally {}
  }
  
  private void initIpConfig(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("htdata3.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    this.mPushIpContainer = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mGetIpContainer = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
  }
  
  private void onSvrConnFailed(EndPoint paramEndPoint)
  {
    this.mPushIpContainer.onConnFailed(paramEndPoint);
    this.mGetIpContainer.onConnFailed(paramEndPoint);
  }
  
  private void onSvrConnSuccess(EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onSvrConnSuccess() IP = " + paramEndPoint.host);
    this.mPushIpContainer.onConnSuccess(paramEndPoint);
    this.mGetIpContainer.onConnSuccess(paramEndPoint);
  }
  
  /* Error */
  public static void saveCustomEnv(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 79	java/io/File
    //   3: dup
    //   4: getstatic 94	com/tencent/mobileqq/highway/config/ConfigManager:BDH_FILE_DIR	Ljava/lang/String;
    //   7: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload_0
    //   13: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +24 -> 40
    //   19: aload_1
    //   20: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +17 -> 40
    //   26: aload_2
    //   27: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +10 -> 40
    //   33: aload 4
    //   35: invokevirtual 290	java/io/File:delete	()Z
    //   38: pop
    //   39: return
    //   40: aload 4
    //   42: invokevirtual 190	java/io/File:exists	()Z
    //   45: ifne +42 -> 87
    //   48: aload 4
    //   50: invokevirtual 293	java/io/File:mkdirs	()Z
    //   53: ifne +34 -> 87
    //   56: ldc 26
    //   58: iconst_2
    //   59: new 60	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 295
    //   69: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 298	java/io/File:getPath	()Ljava/lang/String;
    //   77: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: return
    //   87: new 79	java/io/File
    //   90: dup
    //   91: aload 4
    //   93: ldc 11
    //   95: invokespecial 307	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 290	java/io/File:delete	()Z
    //   105: pop
    //   106: aload 6
    //   108: invokevirtual 310	java/io/File:createNewFile	()Z
    //   111: ifeq +214 -> 325
    //   114: new 312	java/io/FileOutputStream
    //   117: dup
    //   118: aload 6
    //   120: invokespecial 313	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   123: astore 5
    //   125: aload 5
    //   127: astore 4
    //   129: new 197	java/util/Properties
    //   132: dup
    //   133: invokespecial 198	java/util/Properties:<init>	()V
    //   136: astore 7
    //   138: aload 5
    //   140: astore 4
    //   142: aload_0
    //   143: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +16 -> 162
    //   149: aload 5
    //   151: astore 4
    //   153: aload 7
    //   155: ldc 21
    //   157: aload_0
    //   158: invokevirtual 317	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   161: pop
    //   162: aload 5
    //   164: astore 4
    //   166: aload_1
    //   167: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +16 -> 186
    //   173: aload 5
    //   175: astore 4
    //   177: aload 7
    //   179: ldc 23
    //   181: aload_1
    //   182: invokevirtual 317	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 5
    //   188: astore 4
    //   190: aload_2
    //   191: invokestatic 287	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: istore_3
    //   195: iload_3
    //   196: ifne +27 -> 223
    //   199: aload 5
    //   201: astore 4
    //   203: aload_2
    //   204: invokestatic 212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   207: ifle +16 -> 223
    //   210: aload 5
    //   212: astore 4
    //   214: aload 7
    //   216: ldc 19
    //   218: aload_2
    //   219: invokevirtual 317	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   222: pop
    //   223: aload 5
    //   225: astore 4
    //   227: aload 7
    //   229: aload 5
    //   231: ldc_w 319
    //   234: invokevirtual 323	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   237: aload 5
    //   239: ifnull -200 -> 39
    //   242: aload 5
    //   244: invokevirtual 326	java/io/FileOutputStream:close	()V
    //   247: return
    //   248: astore_0
    //   249: return
    //   250: astore_0
    //   251: aload 5
    //   253: astore 4
    //   255: aload_0
    //   256: invokevirtual 327	java/lang/NumberFormatException:printStackTrace	()V
    //   259: goto -36 -> 223
    //   262: astore_0
    //   263: aload 5
    //   265: astore 4
    //   267: aload_0
    //   268: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   271: aload 5
    //   273: astore 4
    //   275: aload 6
    //   277: invokevirtual 290	java/io/File:delete	()Z
    //   280: pop
    //   281: aload 5
    //   283: ifnull -244 -> 39
    //   286: aload 5
    //   288: invokevirtual 326	java/io/FileOutputStream:close	()V
    //   291: return
    //   292: astore_0
    //   293: return
    //   294: astore_0
    //   295: aconst_null
    //   296: astore 4
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 326	java/io/FileOutputStream:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: astore_1
    //   311: goto -3 -> 308
    //   314: astore_0
    //   315: goto -17 -> 298
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 5
    //   322: goto -59 -> 263
    //   325: aconst_null
    //   326: astore 5
    //   328: goto -91 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString1	String
    //   0	331	1	paramString2	String
    //   0	331	2	paramString3	String
    //   194	2	3	bool	boolean
    //   10	294	4	localObject	Object
    //   123	204	5	localFileOutputStream	java.io.FileOutputStream
    //   98	178	6	localFile	File
    //   136	92	7	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   242	247	248	java/lang/Exception
    //   203	210	250	java/lang/NumberFormatException
    //   214	223	250	java/lang/NumberFormatException
    //   129	138	262	java/io/IOException
    //   142	149	262	java/io/IOException
    //   153	162	262	java/io/IOException
    //   166	173	262	java/io/IOException
    //   177	186	262	java/io/IOException
    //   190	195	262	java/io/IOException
    //   203	210	262	java/io/IOException
    //   214	223	262	java/io/IOException
    //   227	237	262	java/io/IOException
    //   255	259	262	java/io/IOException
    //   286	291	292	java/lang/Exception
    //   100	125	294	finally
    //   303	308	310	java/lang/Exception
    //   129	138	314	finally
    //   142	149	314	finally
    //   153	162	314	finally
    //   166	173	314	finally
    //   177	186	314	finally
    //   190	195	314	finally
    //   203	210	314	finally
    //   214	223	314	finally
    //   227	237	314	finally
    //   255	259	314	finally
    //   267	271	314	finally
    //   275	281	314	finally
    //   100	125	318	java/io/IOException
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
    ArrayList localArrayList1 = null;
    ArrayList localArrayList3 = new ArrayList();
    if (this.mPushIpContainer != null) {
      localArrayList1 = this.mPushIpContainer.findIpCurNetList(paramContext, paramBoolean);
    }
    ArrayList localArrayList2 = localArrayList1;
    if (this.mGetIpContainer != null)
    {
      localArrayList2 = localArrayList1;
      if (localArrayList1 == null) {
        localArrayList2 = this.mGetIpContainer.findIpCurNetList(paramContext, paramBoolean);
      }
    }
    if (localArrayList2 != null) {
      localArrayList3.addAll(localArrayList2);
    }
    return localArrayList3;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    return getNetSegConf(paramContext, 0);
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext, int paramInt)
  {
    ArrayList localArrayList1 = this.mHCNetSegConfList;
    Object localObject = this.mPushIpContainer.getNetSegConf(paramInt);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramContext = getNetSegConfByType((ArrayList)localObject, paramInt);
      if (paramContext == null) {
        break label145;
      }
      return paramContext;
      ArrayList localArrayList2 = this.mGetIpContainer.getNetSegConf(paramInt);
      if (localArrayList2 != null)
      {
        localObject = localArrayList2;
        if (!localArrayList2.isEmpty()) {
          break;
        }
      }
      localObject = localArrayList1;
      break;
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
    label145:
    BdhLogUtil.LogEvent("C", "getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, paramInt);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject3 = getCustomEnvAddr();
    if (localObject3 != null) {
      return localObject3;
    }
    Object localObject2;
    if (this.mPushIpContainer != null)
    {
      localObject2 = this.mPushIpContainer.findIpCurNet(paramContext, paramBoolean);
      localObject1 = localObject2;
      if (localObject2 != null) {
        BdhLogUtil.LogEvent("C", "getNextSrvAddr, mPushIpContainer.findIpCurNet, epFromPush = " + ((EndPoint)localObject2).toString() + " with key= " + ((EndPoint)localObject2).keyOfAPN + ", timestamp = " + ((EndPoint)localObject2).timestamp);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (this.mGetIpContainer != null)
      {
        localObject3 = this.mGetIpContainer.findIpCurNet(paramContext, paramBoolean);
        localObject2 = localObject3;
        if (localObject3 != null) {
          BdhLogUtil.LogEvent("C", "getNextSrvAddr, mGetIpContainer.findIpCurNet, epFromGet =  " + ((EndPoint)localObject3).toString() + " with key= " + ((EndPoint)localObject3).keyOfAPN + ", timestamp = " + ((EndPoint)localObject3).timestamp);
        }
      }
      for (localObject2 = localObject3;; localObject2 = null)
      {
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject3 = localObject1;
          if (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp) {
            break;
          }
          return localObject2;
        }
        localObject3 = localObject1;
        if (localObject1 != null) {
          break;
        }
        if (localObject2 != null) {
          return localObject2;
        }
        if (!this.mIsGettingConfg)
        {
          this.mContext4MSFGet = paramContext;
          HwServlet.getConfig(paramAppRuntime, paramString);
        }
        if (this.mPushIpContainer != null)
        {
          paramString = this.mPushIpContainer.findIpRecent(paramContext, paramBoolean);
          localObject1 = paramString;
          if (paramString != null)
          {
            BdhLogUtil.LogEvent("C", "getNextSrvAddr, mPushIpContainer.findIpRecent, epFromPush = " + paramString.toString() + " with key= " + paramString.keyOfAPN + ", timestamp = " + paramString.timestamp);
            localObject1 = paramString;
          }
        }
        if (this.mGetIpContainer != null)
        {
          paramString = this.mGetIpContainer.findIpRecent(paramContext, paramBoolean);
          localObject2 = paramString;
          if (paramString != null)
          {
            BdhLogUtil.LogEvent("C", "getNextSrvAddr, mGetIpContainer.findIpRecent, epFromGet =  " + paramString.toString() + " with key= " + paramString.keyOfAPN + ", timestamp = " + paramString.timestamp);
            localObject2 = paramString;
          }
        }
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject3 = localObject1;
          if (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp) {
            break;
          }
          return localObject2;
        }
        localObject3 = localObject1;
        if (localObject1 != null) {
          break;
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
          BdhLogUtil.LogEvent("C", "getNextSrvAddr(), mHardCodeIpList.getRandomFromCandicate4HardCode, epDomain =  " + paramString.host + " port=" + paramString.port);
          return paramString;
        }
        if (!paramBoolean)
        {
          paramString = this.mHardCodeIpList.getNextIp(paramContext);
          if (paramString != null)
          {
            BdhLogUtil.LogEvent("C", "getNextSrvAddr(), mHardCodeIpList.getNextIp, epHardCode =  " + paramString.host + " port=" + paramString.port);
            return paramString;
          }
        }
        initIpConfig(paramContext, paramAppRuntime);
        return null;
      }
    }
  }
  
  public boolean hasIpv6List(Context paramContext)
  {
    if ((this.mPushIpContainer != null) && (this.mPushIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mPushIpContainer has ipv6 list ");
      return true;
    }
    if ((this.mGetIpContainer != null) && (this.mGetIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mGetIpContainer has ipv6 list ");
      return true;
    }
    return false;
  }
  
  public boolean isIpv6On()
  {
    if (this.mHwEngine == null)
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, mHwEngine is null ");
      return false;
    }
    BdhLogUtil.LogEvent("C", "isIpv6On, ipv6Switch = " + this.mHwEngine.ipv6Switch + ", ipv6SwitchDual = " + this.mHwEngine.ipv6SwitchDual);
    if (!this.mHwEngine.ipv6Switch) {
      return false;
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.mCurnetIptype = i;
    BdhLogUtil.LogEvent("C", "isIpv6On,getActiveNetIpFamily = " + i);
    if ((i == 3) && (!this.mHwEngine.ipv6SwitchDual))
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, ipv6SwitchDual is false ");
      return false;
    }
    if ((i != 2) && (i != 3)) {
      return false;
    }
    Context localContext = this.mHwEngine.getAppContext();
    if (localContext == null)
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, context is null ");
      return false;
    }
    i = -1;
    if (this.mIpv6Available != null)
    {
      i = this.mIpv6Available.getAvailable(localContext);
      BdhLogUtil.LogEvent("C", "isIpv6On, ipv6Available = " + i);
    }
    if ((hasIpv6List(localContext)) && (i != 0))
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, return true");
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
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwConfig paramHwConfig)
  {
    BdhLogUtil.LogEvent("C", "onSrvAddrPush() ");
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_refresh_cached_ip.get() == 1)) {
      IpContainer.refreshIpLearning();
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_enable_ip_learn.get() == 1))
    {
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 1;
      if (paramHwConfig.dtConf != null) {
        BdhSegTimeoutUtil.updateFromSrv(paramHwConfig.dtConf);
      }
      if (paramHwConfig.openUpConf != null) {
        OpenUpConfig.updateFromSrv(paramHwConfig.openUpConf);
      }
      if (paramHwConfig.videoConf == null) {
        break label147;
      }
      VideoUpConfigInfo.updateFromSrc(paramHwConfig.videoConf);
      label110:
      if (paramHwConfig.ptvCof == null) {
        break label159;
      }
      PTVUpConfigInfo.updateFromSrc(paramHwConfig.ptvCof);
    }
    for (;;)
    {
      this.mPushIpContainer.addNew(paramContext, paramHwConfig, paramAppRuntime, this);
      return;
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 0;
      break;
      label147:
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.videoConf is null ");
      break label110;
      label159:
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.ptvCof is null ");
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig == null) || (paramHwConfig.ipList.isEmpty()) || (this.mContext4MSFGet == null)) {
      return;
    }
    BdhLogUtil.LogEvent("C", "onSrvAddrHttpGet() ");
    this.mGetIpContainer.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime, this);
    this.mIsGettingConfg = false;
    this.mContext4MSFGet = null;
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 3) {
      BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable() connError_unreachable");
    }
    do
    {
      return;
      BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable() IP = " + paramString2);
      boolean bool2 = this.mPushIpContainer.fail(paramString2, paramBoolean);
      boolean bool3 = this.mGetIpContainer.fail(paramString2, paramBoolean);
      boolean bool1 = false;
      paramBoolean = bool1;
      if (!bool2)
      {
        paramBoolean = bool1;
        if (!bool3)
        {
          paramBoolean = bool1;
          if (this.mHcDomainCandicateList != null)
          {
            paramBoolean = HardCodeIpList.foundNRemoveIP(this.mHcDomainCandicateList, paramString2);
            BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHcDomainCandicateList ");
          }
        }
      }
    } while ((paramBoolean) || (this.mHardCodeIpList == null));
    this.mHardCodeIpList.foundNRemove(paramString2);
    BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHardCodeIpList ");
  }
  
  public void onSvrConnFinish(EndPoint paramEndPoint, int paramInt)
  {
    BdhLogUtil.LogEvent("C", " onSvrConnFinish IP = " + paramEndPoint.host + " err:" + paramInt);
    if (paramInt == 0) {
      onSvrConnSuccess(paramEndPoint);
    }
    while (paramInt == 3) {
      return;
    }
    onSvrConnFailed(paramEndPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */