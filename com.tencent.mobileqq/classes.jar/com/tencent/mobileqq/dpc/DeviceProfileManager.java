package com.tencent.mobileqq.dpc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.CPU;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Memory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Storage;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.dpc.api.IDPCAccountService;
import com.tencent.mobileqq.dpc.api.impl.DPCAccountServiceImpl;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.xml.sax.InputSource;

public class DeviceProfileManager
{
  private static final String BRAOD_CAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
  private static final String[] DPCCONFIGINFO_FILEDS = { "featureValue" };
  private static final String DPC_CHANGE_BROAD_CAST = "com.tentcent.mobileqq.dpc.broadcast";
  private static final int DPC_RSP_LOG_TYPE_ACCOUNT_MANAGER = 1;
  private static final int DPC_RSP_LOG_TYPE_TMP_FEATURE_MAP_NEW = 3;
  private static final int DPC_RSP_LOG_TYPE_TMP_FEATURE_MAP_OLD = 4;
  private static final int DPC_RSP_LOG_TYPE_TMP_MAP = 2;
  public static final String KEY_AB_TEST_RAND = "ab_rand";
  public static final String KEY_ACCOUNT_LAST_UPDATE_TIME = "account_last_update_time";
  public static final String KEY_KEYTYPE = "key_type";
  public static final String KEY_LAST_UPDATE_TIME = "last_update_time";
  public static final String KEY_SERVER_VISION = "server_version";
  public static final String KEY_VERSIONCODE = "key_versioncode";
  public static final int MAX_AB_RANDOM_VALUE = 10000;
  private static final Object OBSERVER_LOCK = new Object();
  public static final String TAG = "DeviceProfileManager";
  private static List<DPCObserver> dpcObservers;
  private static Field[] fields;
  public static boolean isInited = false;
  private static volatile DeviceProfileManager mInstance;
  public static DPCAccountServiceImpl sAccountDpcService;
  boolean isRegisteredBroadCast = false;
  public int mAbRamdom;
  private HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureDefaultMap = new HashMap();
  private HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureMapLV2 = new HashMap();
  private BroadcastReceiver mReceiver = new DeviceProfileManager.1(this);
  private AtomicInteger mServerDataCurrentState = new AtomicInteger(1);
  
  private DeviceProfileManager()
  {
    if (MobileQQ.sProcessId != 9) {}
    for (;;)
    {
      init(bool);
      return;
      bool = false;
    }
  }
  
  public static void addObserver(DPCObserver paramDPCObserver)
  {
    synchronized (OBSERVER_LOCK)
    {
      if (dpcObservers == null) {
        dpcObservers = new ArrayList();
      }
      if ((paramDPCObserver != null) && (!dpcObservers.contains(paramDPCObserver))) {
        dpcObservers.add(paramDPCObserver);
      }
      return;
    }
  }
  
  public static ConfigurationService.ReqGetConfig buidldReqConfig(AppRuntime paramAppRuntime)
  {
    Object localObject1 = new ConfigurationService.OS();
    ((ConfigurationService.OS)localObject1).setHasFlag(true);
    ((ConfigurationService.OS)localObject1).type.set(2);
    ((ConfigurationService.OS)localObject1).kernel.set(DeviceInfoUtil.m());
    ((ConfigurationService.OS)localObject1).sdk.set(String.valueOf(DeviceInfoUtil.a()));
    ((ConfigurationService.OS)localObject1).version.set(DeviceInfoUtil.e());
    ((ConfigurationService.OS)localObject1).rom.set(DeviceInfoUtil.j());
    ConfigurationService.CPU localCPU = new ConfigurationService.CPU();
    localCPU.setHasFlag(true);
    localCPU.model.set(DeviceInfoUtil.g());
    localCPU.cores.set(DeviceInfoUtil.b());
    localCPU.frequency.set((int)DeviceInfoUtil.b());
    ConfigurationService.Memory localMemory = new ConfigurationService.Memory();
    localMemory.setHasFlag(true);
    localMemory.total.set(DeviceInfoUtil.a());
    localMemory.process.set(DeviceInfoUtil.f());
    ConfigurationService.Storage localStorage = new ConfigurationService.Storage();
    localStorage.setHasFlag(true);
    localStorage.builtin.set(DeviceInfoUtil.d());
    Object localObject2 = DeviceInfoUtil.b();
    localStorage.external.set(localObject2[0] * 1048576L + localObject2[1] * 1024L * 1024L);
    localObject2 = new ConfigurationService.Screen();
    ((ConfigurationService.Screen)localObject2).setHasFlag(true);
    ((ConfigurationService.Screen)localObject2).model.set("");
    ((ConfigurationService.Screen)localObject2).width.set((int)DeviceInfoUtil.g());
    ((ConfigurationService.Screen)localObject2).height.set((int)DeviceInfoUtil.h());
    ((ConfigurationService.Screen)localObject2).dpi.set(DeviceInfoUtil.e());
    ((ConfigurationService.Screen)localObject2).multi_touch.set(DeviceInfoUtil.c());
    ConfigurationService.Camera localCamera = new ConfigurationService.Camera();
    localCamera.setHasFlag(true);
    localCamera.primary.set(0L);
    localCamera.secondary.set(0L);
    localCamera.flash.set(false);
    Object localObject3 = new ConfigurationService.ConfigSeq();
    ((ConfigurationService.ConfigSeq)localObject3).setHasFlag(true);
    ((ConfigurationService.ConfigSeq)localObject3).type.set(4);
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(paramAppRuntime.getApplicationContext(), "dpcConfig_account");
    long l2 = localSharedPreferences.getLong(DPCAccountServiceImpl.buildAccountDpcSPName(paramAppRuntime, "last_update_time"), 0L);
    int k = ApkUtils.a(paramAppRuntime.getApplicationContext());
    int m = localSharedPreferences.getInt("key_versioncode", 0);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceProfileManager", 2, "DeviceProfileManager.KEY_LAST_UPDATE_TIME=" + l2 + ",nowSystemTime=" + l1 + "versionCode=" + k + ",key_versioncode=" + m);
    }
    int j = 0;
    int i = j;
    if (172800L > Math.abs(l1 - l2) / 1000L)
    {
      i = j;
      if (m >= k) {
        i = localSharedPreferences.getInt(DPCAccountServiceImpl.buildAccountDpcSPName(paramAppRuntime, "server_version"), 0);
      }
    }
    ((ConfigurationService.ConfigSeq)localObject3).version.set(i);
    paramAppRuntime = new ArrayList();
    paramAppRuntime.add(localObject3);
    localObject3 = new ConfigurationService.DeviceInfo();
    ((ConfigurationService.DeviceInfo)localObject3).setHasFlag(true);
    ((ConfigurationService.DeviceInfo)localObject3).brand.set(DeviceInfoUtil.h());
    ((ConfigurationService.DeviceInfo)localObject3).model.set(DeviceInfoUtil.d());
    ((ConfigurationService.DeviceInfo)localObject3).os = ((ConfigurationService.OS)localObject1);
    ((ConfigurationService.DeviceInfo)localObject3).cpu = localCPU;
    ((ConfigurationService.DeviceInfo)localObject3).memory = localMemory;
    ((ConfigurationService.DeviceInfo)localObject3).storage = localStorage;
    ((ConfigurationService.DeviceInfo)localObject3).screen = ((ConfigurationService.Screen)localObject2);
    ((ConfigurationService.DeviceInfo)localObject3).camera = localCamera;
    localObject1 = new ConfigurationService.ReqGetConfig();
    ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject3);
    ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll(paramAppRuntime);
    printReqInfo((ConfigurationService.ReqGetConfig)localObject1);
    return localObject1;
  }
  
  public static boolean buildDPCConfigValue(DeviceProfileManager.DPCConfigInfo paramDPCConfigInfo, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramDPCConfigInfo == null)) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[1];
      arrayOfString[0] = paramString.toString().trim();
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    if (fields == null)
    {
      fields = new Field[DPCCONFIGINFO_FILEDS.length];
      i = 0;
      for (;;)
      {
        if (i < fields.length) {
          try
          {
            fields[i] = paramDPCConfigInfo.getClass().getField(DPCCONFIGINFO_FILEDS[i]);
            fields[i].setAccessible(true);
            i += 1;
          }
          catch (NoSuchFieldException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              fields[i] = null;
            }
          }
        }
      }
    }
    int j = Math.min(fields.length, arrayOfString.length);
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    while (i < j)
    {
      paramString = arrayOfString[i];
      bool2 = bool1;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          bool2 = bool1;
        }
      }
      else
      {
        i += 1;
        bool1 = bool2;
        continue;
      }
      if ((paramString.indexOf('{', 0) != 0) || (paramString.lastIndexOf('}') != paramString.length() - 1)) {
        break label288;
      }
      paramString = paramString.substring(1, paramString.length() - 1);
    }
    label285:
    label288:
    for (;;)
    {
      try
      {
        if ((fields[i] == null) || (paramString.equals((String)fields[i].get(paramDPCConfigInfo)))) {
          break label285;
        }
        fields[i].set(paramDPCConfigInfo, paramString);
        bool1 = true;
        bool2 = bool1;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      break;
      return bool1;
    }
  }
  
  private DeviceProfileManager.DPCConfigInfo getFeatureInfo(String paramString)
  {
    Object localObject;
    if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
    {
      if (sAccountDpcService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "getFeatureValue() accountDpcManager is null");
        }
        localObject = null;
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceProfileManager", 2, "getFeatureValue() accountDpcNames=" + paramString);
      }
      localObject = sAccountDpcService.mFeatureAccountMapLV2;
      paramString = sAccountDpcService.buildAccountDpcName(paramString);
    }
    for (;;)
    {
      DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
      localObject = localDPCConfigInfo;
      if (localDPCConfigInfo != null) {
        break;
      }
      localObject = localDPCConfigInfo;
      if (MobileQQ.sProcessId != 9) {
        break;
      }
      return getFeatureInfoSync(paramString);
      localObject = this.mFeatureMapLV2;
    }
  }
  
  public static DeviceProfileManager getInstance()
  {
    return getInstance(MobileQQ.sMobileQQ.peekAppRuntime());
  }
  
  public static DeviceProfileManager getInstance(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      sAccountDpcService = (DPCAccountServiceImpl)paramAppRuntime.getRuntimeService(IDPCAccountService.class, "all");
    }
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new DeviceProfileManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static DeviceProfileManager getInstanceWithoutAccountManager()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new DeviceProfileManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void init(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceProfileManager", 2, "DeviceProfileManager init DPC content");
    }
    isInited = true;
    initDefaultValue();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig");
    this.mAbRamdom = localSharedPreferences.getInt("ab_rand", -1);
    Object localObject;
    if (this.mAbRamdom == -1)
    {
      this.mAbRamdom = new Random().nextInt(10000);
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("ab_rand", this.mAbRamdom);
      ((SharedPreferences.Editor)localObject).apply();
    }
    if (!paramBoolean) {
      return;
    }
    DPCNames[] arrayOfDPCNames = DPCNames.values();
    int j = arrayOfDPCNames.length;
    int i = 0;
    label122:
    DPCNames localDPCNames;
    String str;
    if (i < j)
    {
      localDPCNames = arrayOfDPCNames[i];
      str = localSharedPreferences.getString(localDPCNames.name(), "");
      if (!"".equals(str)) {
        break label256;
      }
      localObject = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultMap.get(localDPCNames.name())).clone();
    }
    for (;;)
    {
      this.mFeatureMapLV2.put(localDPCNames.name(), localObject);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceProfileManager", 2, "init loop mFeatureMapLV2 MAP: " + localDPCNames.name() + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
      }
      i += 1;
      break label122;
      break;
      label256:
      localObject = new DeviceProfileManager.DPCConfigInfo();
      buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject, str);
    }
  }
  
  private void initDefaultValue()
  {
    Object localObject = DPCNames.values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localDPCConfigInfo = localObject[i];
      this.mFeatureDefaultMap.put(localDPCConfigInfo.name(), new DeviceProfileManager.DPCConfigInfo());
      i += 1;
    }
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = "1";
    this.mFeatureDefaultMap.put(DPCNames.magicface_support.name(), localObject);
    DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
    localDPCConfigInfo.featureValue = "1";
    this.mFeatureDefaultMap.put(DPCNames.h5magic_support.name(), localDPCConfigInfo);
    new DeviceProfileManager.DPCConfigInfo().featureValue = "1";
    this.mFeatureDefaultMap.put(DPCNames.aio_eggs.name(), localObject);
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = HardCodeUtil.a(2131698687);
    this.mFeatureDefaultMap.put(DPCNames.OneyWayDateMsgNotifyCfg.name(), localObject);
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = HardCodeUtil.a(2131698686);
    this.mFeatureDefaultMap.put(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name(), localObject);
  }
  
  private void notifyHasDpcChanged(boolean paramBoolean)
  {
    nextServerDataState(4);
    Intent localIntent = new Intent("com.tentcent.mobileqq.dpc.broadcast");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("featureMapLV2", this.mFeatureMapLV2);
    if (sAccountDpcService != null) {
      localBundle.putSerializable("featureAccountMapLV2", sAccountDpcService.mFeatureAccountMapLV2);
    }
    localIntent.putExtras(localBundle);
    MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    notifyObservers(paramBoolean);
  }
  
  private static void notifyObservers(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (OBSERVER_LOCK)
      {
        if (dpcObservers == null) {
          return;
        }
        i = dpcObservers.size() - 1;
        if (i >= 0)
        {
          DPCObserver localDPCObserver = (DPCObserver)dpcObservers.get(i);
          if (localDPCObserver == null) {
            break label68;
          }
          localDPCObserver.onDpcPullFinished(paramBoolean);
        }
      }
      return;
      label68:
      i -= 1;
    }
  }
  
  private void onDPCResponseClrLog(boolean paramBoolean, int paramInt, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QLog.e("DeviceProfileManager", 2, "onDPCResponse() accountDpcManager or responseUin is null");
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      QLog.d("DeviceProfileManager", 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + paramObject[0] + ", value=" + paramObject[1] + ", isAccountName=" + paramObject[2]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      QLog.d("DeviceProfileManager", 2, "onDPCResponse tempFeatureMap new value: key=" + paramObject[0] + " " + paramObject[1] + ", isAddConfig=" + paramObject[2]);
      return;
    }
    paramObject = (Object[])paramObject;
    QLog.d("DeviceProfileManager", 2, "onDPCResponse tempFeatureMap old value: key=" + paramObject[0] + " " + paramObject[1] + ", isAddConfig=" + paramObject[2] + ", hasUpdate=" + paramObject[3]);
  }
  
  /* Error */
  public static <T> int parseComplexParams(String paramString, T[] paramArrayOfT, DeviceProfileManager.StringParser<T> paramStringParser)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +110 -> 114
    //   7: aload_2
    //   8: ifnull +106 -> 114
    //   11: aload_0
    //   12: invokestatic 754	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +99 -> 114
    //   18: aload_0
    //   19: ldc_w 756
    //   22: invokevirtual 760	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: arraylength
    //   28: aload_1
    //   29: arraylength
    //   30: invokestatic 514	java/lang/Math:min	(II)I
    //   33: istore_3
    //   34: iload_3
    //   35: istore 4
    //   37: iload 5
    //   39: iload_3
    //   40: if_icmpge +67 -> 107
    //   43: aload_1
    //   44: iload 5
    //   46: aload_2
    //   47: aload_0
    //   48: iload 5
    //   50: aaload
    //   51: invokeinterface 766 2 0
    //   56: aastore
    //   57: iload 5
    //   59: iconst_1
    //   60: iadd
    //   61: istore 5
    //   63: goto -29 -> 34
    //   66: astore_0
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: istore 4
    //   72: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 47
    //   80: iconst_2
    //   81: new 380	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 768
    //   91: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: invokevirtual 730	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload_3
    //   105: istore 4
    //   107: iload 4
    //   109: ireturn
    //   110: astore_0
    //   111: goto -42 -> 69
    //   114: iconst_0
    //   115: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   0	116	1	paramArrayOfT	T[]
    //   0	116	2	paramStringParser	DeviceProfileManager.StringParser<T>
    //   33	72	3	i	int
    //   35	73	4	j	int
    //   1	61	5	k	int
    // Exception table:
    //   from	to	target	type
    //   18	34	66	java/lang/Exception
    //   43	57	110	java/lang/Exception
  }
  
  private static void printReqInfo(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    ConfigurationService.DeviceInfo localDeviceInfo = paramReqGetConfig.device_info;
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("config.version = " + ((ConfigurationService.ConfigSeq)paramReqGetConfig.seq_list.get(0)).version.get() + "\n");
    localStringBuilder.append("buidldReqConfig{");
    localStringBuilder.append(" brand= ");
    localStringBuilder.append(localDeviceInfo.brand.get());
    localStringBuilder.append(" ,model= ");
    localStringBuilder.append(localDeviceInfo.model.get());
    localStringBuilder.append(" ,os.type= ");
    localStringBuilder.append(localDeviceInfo.os.type.get());
    localStringBuilder.append(" ,os.kernel= ");
    localStringBuilder.append(localDeviceInfo.os.kernel.get());
    localStringBuilder.append(" ,os.sdk= ");
    localStringBuilder.append(localDeviceInfo.os.sdk.get());
    localStringBuilder.append(" ,os.version= ");
    localStringBuilder.append(localDeviceInfo.os.version.get());
    localStringBuilder.append(" ,os.rom= ");
    localStringBuilder.append(localDeviceInfo.os.rom.get());
    localStringBuilder.append(" ,cpu.model= ");
    localStringBuilder.append(localDeviceInfo.cpu.model.get());
    localStringBuilder.append(" ,cpu.cores= ");
    localStringBuilder.append(localDeviceInfo.cpu.cores.get());
    localStringBuilder.append(" ,cpu.frequency= ");
    localStringBuilder.append(localDeviceInfo.cpu.frequency.get());
    localStringBuilder.append(" ,memory.total= ");
    localStringBuilder.append(localDeviceInfo.memory.total.get());
    localStringBuilder.append(" ,memory.process= ");
    localStringBuilder.append(localDeviceInfo.memory.process.get());
    localStringBuilder.append(" ,storage.builtin= ");
    localStringBuilder.append(localDeviceInfo.storage.builtin.get());
    localStringBuilder.append(" ,storage.external= ");
    localStringBuilder.append(localDeviceInfo.storage.external.get());
    localStringBuilder.append(" ,screen.model= ");
    localStringBuilder.append(localDeviceInfo.screen.model.get());
    localStringBuilder.append(" ,screen.width= ");
    localStringBuilder.append(localDeviceInfo.screen.width.get());
    localStringBuilder.append(" ,screen.height= ");
    localStringBuilder.append(localDeviceInfo.screen.height.get());
    localStringBuilder.append(" ,screen.dpi= ");
    localStringBuilder.append(localDeviceInfo.screen.dpi.get());
    localStringBuilder.append(" ,screen.multi_touch= ");
    localStringBuilder.append(localDeviceInfo.screen.multi_touch.get());
    localStringBuilder.append(" ,camera.primary= ");
    localStringBuilder.append(localDeviceInfo.camera.primary.get());
    localStringBuilder.append(" ,camera.secondary= ");
    localStringBuilder.append(localDeviceInfo.camera.secondary.get());
    localStringBuilder.append(" ,camera.flash= ");
    localStringBuilder.append(localDeviceInfo.camera.flash.get());
    localStringBuilder.append(" }");
    QLog.i("DeviceProfileManager", 1, localStringBuilder.toString());
  }
  
  public static void removeObserver(DPCObserver paramDPCObserver)
  {
    synchronized (OBSERVER_LOCK)
    {
      if ((dpcObservers != null) && (paramDPCObserver != null)) {
        dpcObservers.remove(paramDPCObserver);
      }
      return;
    }
  }
  
  private boolean updateDpcSp(ConfigurationService.Config paramConfig, SharedPreferences.Editor paramEditor1, SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor2)
  {
    if (sAccountDpcService != null)
    {
      paramEditor2.putLong(DPCAccountServiceImpl.buildAccountDpcSPName(sAccountDpcService.mApp, "last_update_time"), System.currentTimeMillis());
      paramEditor2.putInt(DPCAccountServiceImpl.buildAccountDpcSPName(sAccountDpcService.mApp, "server_version"), paramConfig.version.get());
    }
    int i = paramSharedPreferences.getInt("key_versioncode", 0);
    int j = ApkUtils.a(MobileQQ.sMobileQQ.getApplicationContext());
    if (i < j) {
      paramEditor2.putInt("key_versioncode", j);
    }
    paramEditor1.commit();
    paramEditor2.commit();
    QLog.i("DeviceProfileManager", 1, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis() + ", versioncode=" + j + ", keyVersionCode =" + i);
    return true;
  }
  
  private void waitDPCServerData(long paramLong)
  {
    if (getServerDataCurrentState() != 4) {
      synchronized (this.mServerDataCurrentState)
      {
        int i = getServerDataCurrentState();
        if (i != 4) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("DeviceProfileManager", 2, "waitDPCServerData() is waiting threadID=" + Thread.currentThread().getId());
          }
          this.mServerDataCurrentState.wait(paramLong);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("DeviceProfileManager", 1, "waitDpcServerData failed", localInterruptedException);
            }
          }
        }
        return;
      }
    }
  }
  
  public DeviceProfileManager.DPCConfigInfo getFeatureInfoSync(String paramString)
  {
    Object localObject1;
    if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
    {
      if (sAccountDpcService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "getFeatureValue() accountDpcManager is null");
        }
        localObject2 = null;
        return localObject2;
      }
      localObject1 = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig_account");
      localObject2 = sAccountDpcService.buildAccountDpcName(paramString);
      String str = ((SharedPreferences)localObject1).getString((String)localObject2, "");
      if ("".equals(str))
      {
        localObject1 = (DeviceProfileManager.DPCConfigInfo)sAccountDpcService.mFeatureDefaultAccountMap.get(paramString);
        if (localObject1 != null) {
          localObject1 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject1).clone();
        }
      }
      for (;;)
      {
        sAccountDpcService.mFeatureAccountMapLV2.put(localObject2, localObject1);
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DeviceProfileManager", 2, new Object[] { "getFeatureInfoSync ", paramString, " = ", ((DeviceProfileManager.DPCConfigInfo)localObject1).toString() });
        return localObject1;
        localObject1 = new DeviceProfileManager.DPCConfigInfo();
        continue;
        localObject1 = new DeviceProfileManager.DPCConfigInfo();
        buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject1, str);
      }
    }
    Object localObject2 = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig").getString(paramString, "");
    if ("".equals(localObject2))
    {
      localObject1 = (DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultMap.get(paramString);
      if (localObject1 != null) {
        localObject1 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject1).clone();
      }
    }
    for (;;)
    {
      this.mFeatureMapLV2.put(paramString, localObject1);
      break;
      localObject1 = new DeviceProfileManager.DPCConfigInfo();
      continue;
      localObject1 = new DeviceProfileManager.DPCConfigInfo();
      buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject1, (String)localObject2);
    }
  }
  
  /* Error */
  public String getFeatureValue(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 902	com/tencent/mobileqq/dpc/DeviceProfileManager:getFeatureInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/dpc/DeviceProfileManager$DPCConfigInfo;
    //   7: astore_2
    //   8: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +50 -> 61
    //   14: new 380	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 904
    //   24: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 646
    //   34: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: astore_3
    //   38: aload_2
    //   39: ifnull +51 -> 90
    //   42: aload_2
    //   43: invokevirtual 647	com/tencent/mobileqq/dpc/DeviceProfileManager$DPCConfigInfo:toString	()Ljava/lang/String;
    //   46: astore_1
    //   47: ldc 47
    //   49: iconst_2
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_2
    //   62: ifnull +20 -> 82
    //   65: aload_2
    //   66: getfield 657	com/tencent/mobileqq/dpc/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   69: ifnull +13 -> 82
    //   72: aload_2
    //   73: getfield 657	com/tencent/mobileqq/dpc/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   76: invokevirtual 486	java/lang/String:length	()I
    //   79: ifne +18 -> 97
    //   82: ldc_w 283
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: areturn
    //   90: ldc_w 906
    //   93: astore_1
    //   94: goto -47 -> 47
    //   97: aload_2
    //   98: getfield 657	com/tencent/mobileqq/dpc/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   101: astore_1
    //   102: goto -16 -> 86
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	DeviceProfileManager
    //   0	110	1	paramString	String
    //   7	91	2	localDPCConfigInfo	DeviceProfileManager.DPCConfigInfo
    //   37	14	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	38	105	finally
    //   42	47	105	finally
    //   47	61	105	finally
    //   65	82	105	finally
    //   97	102	105	finally
  }
  
  public String getFeatureValue(String paramString, long paramLong)
  {
    waitDPCServerData(paramLong);
    return getFeatureValue(paramString);
  }
  
  /* Error */
  public String getFeatureValue(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 911	com/tencent/mobileqq/dpc/DeviceProfileManager:getFeatureValue	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_2
    //   10: astore_1
    //   11: aload 4
    //   13: ifnull +18 -> 31
    //   16: ldc_w 283
    //   19: aload 4
    //   21: invokevirtual 532	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifeq +9 -> 35
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload 4
    //   37: astore_1
    //   38: goto -7 -> 31
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	DeviceProfileManager
    //   0	46	1	paramString1	String
    //   0	46	2	paramString2	String
    //   24	2	3	bool	boolean
    //   7	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	41	finally
    //   16	25	41	finally
  }
  
  public int getServerDataCurrentState()
  {
    return this.mServerDataCurrentState.get();
  }
  
  public boolean isFeatureSupported(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
        {
          if (sAccountDpcService == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("DeviceProfileManager", 2, "isFeatureSupported() accountDpcManager is null");
            }
            bool = false;
            return bool;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DeviceProfileManager", 2, "isFeatureSupported() accountDpcNames=" + paramString);
          }
          localObject = sAccountDpcService.mFeatureAccountMapLV2;
          paramString = sAccountDpcService.buildAccountDpcName(paramString);
          localObject = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.d("DeviceProfileManager", 2, "isFeatureSupported: " + paramString + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
          }
          if ((localObject == null) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue == null)) {
            break label235;
          }
          if (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.length() == 0) {
            break label235;
          }
        }
        else
        {
          localObject = this.mFeatureMapLV2;
          continue;
        }
        if ((((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("0")) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("2"))) {
          break label240;
        }
        bool = ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("1");
        if (bool)
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
        bool = false;
      }
      finally {}
      label235:
      continue;
      label240:
      boolean bool = false;
    }
  }
  
  public boolean isFeatureSupported(String paramString, long paramLong)
  {
    waitDPCServerData(paramLong);
    return isFeatureSupported(paramString);
  }
  
  public void nextServerDataState(int paramInt)
  {
    this.mServerDataCurrentState.set(paramInt);
    if (paramInt == 4) {
      synchronized (this.mServerDataCurrentState)
      {
        this.mServerDataCurrentState.notifyAll();
        return;
      }
    }
  }
  
  public boolean onDPCResponse(ConfigurationService.RespGetConfig paramRespGetConfig, String paramString)
  {
    try
    {
      ThreadManager.getSubThreadHandler().post(new DeviceProfileManager.2(this, paramRespGetConfig, paramString));
      return true;
    }
    finally
    {
      paramRespGetConfig = finally;
      throw paramRespGetConfig;
    }
  }
  
  public boolean parseDPCXML(String paramString, HashMap<String, DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo> paramHashMap)
  {
    QLog.i("DeviceProfileManager", 1, "dpcStart{" + SecUtil.xor(paramString, "8.5.5") + "}dpcEnd");
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    paramHashMap = new DeviceProfileManager.DPCXmlHandler(paramHashMap);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes("utf-8"))), paramHashMap);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceProfileManager", 2, "pareseDCPXML", paramString);
      }
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void printDPCConfigValue()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("mFeatureMapLV2 start loop: \n");
      Iterator localIterator = this.mFeatureMapLV2.entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append("key=" + localEntry.getKey() + ", value=" + localEntry.getValue().toString() + "\n");
      }
      localStringBuilder.append("mFeatureMapLV2 end loop: \n");
      localStringBuilder.append("mFeatureAccountMapLV2 start loop: \n");
      localIterator = sAccountDpcService.mFeatureAccountMapLV2.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append("key=" + localEntry.getKey() + ", value=" + localEntry.getValue().toString() + "\n");
      }
      localStringBuilder.append("mFeatureAccountMapLV2 end loop: \n");
      QLog.i("DeviceProfileManager", 2, localStringBuilder.toString());
    }
  }
  
  public void registerBroadCast(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) || (this.isRegisteredBroadCast)) {}
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.getApplicationContext();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tentcent.mobileqq.dpc.broadcast");
      try
      {
        paramAppRuntime.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", new Handler(ThreadManager.getSubThreadLooper()));
        this.isRegisteredBroadCast = true;
        return;
      }
      catch (Exception paramAppRuntime) {}
    } while (!QLog.isColorLevel());
    QLog.d("DeviceProfileManager", 2, "registerBroadCast failed! e = " + paramAppRuntime + " msg = " + paramAppRuntime.getMessage());
  }
  
  public void unRegisterBroadCast(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    try
    {
      paramAppRuntime.getApplicationContext().unregisterReceiver(this.mReceiver);
      return;
    }
    catch (Exception paramAppRuntime) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager
 * JD-Core Version:    0.7.0.1
 */