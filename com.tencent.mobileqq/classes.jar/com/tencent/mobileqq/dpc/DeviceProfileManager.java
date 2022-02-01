package com.tencent.mobileqq.dpc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
  boolean isRegisteredBroadCast;
  public int mAbRamdom;
  private HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureDefaultMap = new HashMap();
  private HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureMapLV2 = new HashMap();
  private BroadcastReceiver mReceiver = new DeviceProfileManager.1(this);
  private AtomicInteger mServerDataCurrentState = new AtomicInteger(1);
  
  private DeviceProfileManager()
  {
    boolean bool = false;
    this.isRegisteredBroadCast = false;
    if (MobileQQ.sProcessId != 9) {
      bool = true;
    }
    init(bool);
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
    ((ConfigurationService.OS)localObject1).kernel.set(DeviceInfoUtil.I());
    ((ConfigurationService.OS)localObject1).sdk.set(String.valueOf(DeviceInfoUtil.d()));
    ((ConfigurationService.OS)localObject1).version.set(DeviceInfoUtil.g());
    ((ConfigurationService.OS)localObject1).rom.set(DeviceInfoUtil.v());
    ConfigurationService.CPU localCPU = new ConfigurationService.CPU();
    localCPU.setHasFlag(true);
    localCPU.model.set(DeviceInfoUtil.m());
    localCPU.cores.set(DeviceInfoUtil.h());
    localCPU.frequency.set((int)DeviceInfoUtil.k());
    ConfigurationService.Memory localMemory = new ConfigurationService.Memory();
    localMemory.setHasFlag(true);
    localMemory.total.set(DeviceInfoUtil.a());
    localMemory.process.set(DeviceInfoUtil.s());
    ConfigurationService.Storage localStorage = new ConfigurationService.Storage();
    localStorage.setHasFlag(true);
    localStorage.builtin.set(DeviceInfoUtil.o());
    Object localObject2 = DeviceInfoUtil.q();
    localStorage.external.set(localObject2[0] * 1048576L + localObject2[1] * 1024L * 1024L);
    localObject2 = new ConfigurationService.Screen();
    ((ConfigurationService.Screen)localObject2).setHasFlag(true);
    ((ConfigurationService.Screen)localObject2).model.set("");
    ((ConfigurationService.Screen)localObject2).width.set((int)DeviceInfoUtil.B());
    ((ConfigurationService.Screen)localObject2).height.set((int)DeviceInfoUtil.C());
    ((ConfigurationService.Screen)localObject2).dpi.set(DeviceInfoUtil.J());
    ((ConfigurationService.Screen)localObject2).multi_touch.set(DeviceInfoUtil.K());
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
    int i = ApkUtils.a(paramAppRuntime.getApplicationContext());
    int j = localSharedPreferences.getInt("key_versioncode", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceProfileManager.KEY_LAST_UPDATE_TIME=");
      localStringBuilder.append(l2);
      localStringBuilder.append(",nowSystemTime=");
      localStringBuilder.append(l1);
      localStringBuilder.append("versionCode=");
      localStringBuilder.append(i);
      localStringBuilder.append(",key_versioncode=");
      localStringBuilder.append(j);
      QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
    }
    if ((172800L > Math.abs(l1 - l2) / 1000L) && (j >= i)) {
      i = localSharedPreferences.getInt(DPCAccountServiceImpl.buildAccountDpcSPName(paramAppRuntime, "server_version"), 0);
    } else {
      i = 0;
    }
    ((ConfigurationService.ConfigSeq)localObject3).version.set(i);
    paramAppRuntime = new ArrayList();
    paramAppRuntime.add(localObject3);
    localObject3 = new ConfigurationService.DeviceInfo();
    ((ConfigurationService.DeviceInfo)localObject3).setHasFlag(true);
    ((ConfigurationService.DeviceInfo)localObject3).brand.set(DeviceInfoUtil.t());
    ((ConfigurationService.DeviceInfo)localObject3).model.set(DeviceInfoUtil.f());
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
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramDPCConfigInfo == null) {
        return false;
      }
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString.toString().trim();
      if (arrayOfString.length == 0) {
        return false;
      }
      if (fields == null)
      {
        fields = new Field[DPCCONFIGINFO_FILEDS.length];
        i = 0;
        for (;;)
        {
          paramString = fields;
          if (i >= paramString.length) {
            break;
          }
          try
          {
            paramString[i] = paramDPCConfigInfo.getClass().getField(DPCCONFIGINFO_FILEDS[i]);
            fields[i].setAccessible(true);
          }
          catch (NoSuchFieldException paramString)
          {
            paramString.printStackTrace();
            fields[i] = null;
          }
          i += 1;
        }
      }
      int j = Math.min(fields.length, arrayOfString.length);
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2)
      {
        String str = arrayOfString[i];
        bool2 = bool1;
        if (str != null) {
          if (str.length() == 0)
          {
            bool2 = bool1;
          }
          else
          {
            paramString = str;
            if (str.indexOf('{', 0) == 0)
            {
              paramString = str;
              if (str.lastIndexOf('}') == str.length() - 1) {
                paramString = str.substring(1, str.length() - 1);
              }
            }
            bool2 = bool1;
            try
            {
              if (fields[i] != null)
              {
                bool2 = bool1;
                if (!paramString.equals((String)fields[i].get(paramDPCConfigInfo)))
                {
                  fields[i].set(paramDPCConfigInfo, paramString);
                  bool2 = true;
                }
              }
            }
            catch (IllegalAccessException paramString)
            {
              paramString.printStackTrace();
              bool2 = bool1;
            }
            catch (IllegalArgumentException paramString)
            {
              paramString.printStackTrace();
              bool2 = bool1;
            }
          }
        }
        i += 1;
      }
      return bool1;
    }
    return false;
  }
  
  private DeviceProfileManager.DPCConfigInfo getFeatureInfo(String paramString)
  {
    if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
    {
      if (sAccountDpcService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "getFeatureValue() accountDpcManager is null");
        }
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFeatureValue() accountDpcNames=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("DeviceProfileManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = sAccountDpcService.mFeatureAccountMapLV2;
      paramString = sAccountDpcService.buildAccountDpcName(paramString);
    }
    else
    {
      localObject = this.mFeatureMapLV2;
    }
    DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
    Object localObject = localDPCConfigInfo;
    if (localDPCConfigInfo == null)
    {
      localObject = localDPCConfigInfo;
      if (MobileQQ.sProcessId == 9) {
        localObject = getFeatureInfoSync(paramString);
      }
    }
    return localObject;
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
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DeviceProfileManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static DeviceProfileManager getInstanceWithoutAccountManager()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DeviceProfileManager();
        }
      }
      finally {}
    }
    return mInstance;
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
    Object localObject1;
    if (this.mAbRamdom == -1)
    {
      this.mAbRamdom = new Random().nextInt(10000);
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putInt("ab_rand", this.mAbRamdom);
      ((SharedPreferences.Editor)localObject1).apply();
    }
    if (!paramBoolean) {
      return;
    }
    DPCNames[] arrayOfDPCNames = DPCNames.values();
    int j = arrayOfDPCNames.length;
    int i = 0;
    while (i < j)
    {
      DPCNames localDPCNames = arrayOfDPCNames[i];
      Object localObject2 = localSharedPreferences.getString(localDPCNames.name(), "");
      if ("".equals(localObject2))
      {
        localObject1 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultMap.get(localDPCNames.name())).clone();
      }
      else
      {
        localObject1 = new DeviceProfileManager.DPCConfigInfo();
        buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject1, (String)localObject2);
      }
      this.mFeatureMapLV2.put(localDPCNames.name(), localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init loop mFeatureMapLV2 MAP: ");
        ((StringBuilder)localObject2).append(localDPCNames.name());
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(((DeviceProfileManager.DPCConfigInfo)localObject1).toString());
        QLog.i("DeviceProfileManager", 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
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
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = HardCodeUtil.a(2131896714);
    this.mFeatureDefaultMap.put(DPCNames.OneyWayDateMsgNotifyCfg.name(), localObject);
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = HardCodeUtil.a(2131896713);
    this.mFeatureDefaultMap.put(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name(), localObject);
  }
  
  private void notifyHasDpcChanged(boolean paramBoolean)
  {
    nextServerDataState(4);
    Intent localIntent = new Intent("com.tentcent.mobileqq.dpc.broadcast");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("featureMapLV2", this.mFeatureMapLV2);
    DPCAccountServiceImpl localDPCAccountServiceImpl = sAccountDpcService;
    if (localDPCAccountServiceImpl != null) {
      localBundle.putSerializable("featureAccountMapLV2", localDPCAccountServiceImpl.mFeatureAccountMapLV2);
    }
    localIntent.putExtras(localBundle);
    MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    notifyObservers(paramBoolean);
  }
  
  private static void notifyObservers(boolean paramBoolean)
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
        if (localDPCObserver != null) {
          localDPCObserver.onDpcPullFinished(paramBoolean);
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void onDPCResponseClrLog(boolean paramBoolean, int paramInt, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          paramObject = (Object[])paramObject;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDPCResponse tempFeatureMap old value: key=");
          localStringBuilder.append(paramObject[0]);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramObject[1]);
          localStringBuilder.append(", isAddConfig=");
          localStringBuilder.append(paramObject[2]);
          localStringBuilder.append(", hasUpdate=");
          localStringBuilder.append(paramObject[3]);
          QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
          return;
        }
        paramObject = (Object[])paramObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDPCResponse tempFeatureMap new value: key=");
        localStringBuilder.append(paramObject[0]);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramObject[1]);
        localStringBuilder.append(", isAddConfig=");
        localStringBuilder.append(paramObject[2]);
        QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
        return;
      }
      paramObject = (Object[])paramObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDPCResponse DPCXmlHandler.tempMap: key=");
      localStringBuilder.append(paramObject[0]);
      localStringBuilder.append(", value=");
      localStringBuilder.append(paramObject[1]);
      localStringBuilder.append(", isAccountName=");
      localStringBuilder.append(paramObject[2]);
      QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
      return;
    }
    QLog.e("DeviceProfileManager", 2, "onDPCResponse() accountDpcManager or responseUin is null");
  }
  
  public static <T> int parseComplexParams(String paramString, T[] paramArrayOfT, DeviceProfileManager.StringParser<T> paramStringParser)
  {
    int k = 0;
    int m = 0;
    int i = 0;
    int j = m;
    if (paramArrayOfT != null)
    {
      j = m;
      if (paramStringParser != null)
      {
        j = m;
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramString = paramString.split("\\|");
            j = Math.min(paramString.length, paramArrayOfT.length);
            for (;;)
            {
              if (i < j) {
                try
                {
                  paramArrayOfT[i] = paramStringParser.parse(paramString[i]);
                  i += 1;
                }
                catch (Exception paramString)
                {
                  i = j;
                  break label91;
                }
              }
            }
            return j;
          }
          catch (Exception paramString)
          {
            i = k;
            label91:
            j = i;
            if (QLog.isColorLevel())
            {
              paramArrayOfT = new StringBuilder();
              paramArrayOfT.append("Parse ComplexParams failed:");
              paramArrayOfT.append(paramString);
              QLog.d("DeviceProfileManager", 2, paramArrayOfT.toString());
              j = i;
            }
          }
        }
      }
    }
    return j;
  }
  
  private static void printReqInfo(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    ConfigurationService.DeviceInfo localDeviceInfo = paramReqGetConfig.device_info;
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("config.version = ");
    localStringBuilder2.append(((ConfigurationService.ConfigSeq)paramReqGetConfig.seq_list.get(0)).version.get());
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("buidldReqConfig{");
    localStringBuilder1.append(" brand= ");
    localStringBuilder1.append(localDeviceInfo.brand.get());
    localStringBuilder1.append(" ,model= ");
    localStringBuilder1.append(localDeviceInfo.model.get());
    localStringBuilder1.append(" ,os.type= ");
    localStringBuilder1.append(localDeviceInfo.os.type.get());
    localStringBuilder1.append(" ,os.kernel= ");
    localStringBuilder1.append(localDeviceInfo.os.kernel.get());
    localStringBuilder1.append(" ,os.sdk= ");
    localStringBuilder1.append(localDeviceInfo.os.sdk.get());
    localStringBuilder1.append(" ,os.version= ");
    localStringBuilder1.append(localDeviceInfo.os.version.get());
    localStringBuilder1.append(" ,os.rom= ");
    localStringBuilder1.append(localDeviceInfo.os.rom.get());
    localStringBuilder1.append(" ,cpu.model= ");
    localStringBuilder1.append(localDeviceInfo.cpu.model.get());
    localStringBuilder1.append(" ,cpu.cores= ");
    localStringBuilder1.append(localDeviceInfo.cpu.cores.get());
    localStringBuilder1.append(" ,cpu.frequency= ");
    localStringBuilder1.append(localDeviceInfo.cpu.frequency.get());
    localStringBuilder1.append(" ,memory.total= ");
    localStringBuilder1.append(localDeviceInfo.memory.total.get());
    localStringBuilder1.append(" ,memory.process= ");
    localStringBuilder1.append(localDeviceInfo.memory.process.get());
    localStringBuilder1.append(" ,storage.builtin= ");
    localStringBuilder1.append(localDeviceInfo.storage.builtin.get());
    localStringBuilder1.append(" ,storage.external= ");
    localStringBuilder1.append(localDeviceInfo.storage.external.get());
    localStringBuilder1.append(" ,screen.model= ");
    localStringBuilder1.append(localDeviceInfo.screen.model.get());
    localStringBuilder1.append(" ,screen.width= ");
    localStringBuilder1.append(localDeviceInfo.screen.width.get());
    localStringBuilder1.append(" ,screen.height= ");
    localStringBuilder1.append(localDeviceInfo.screen.height.get());
    localStringBuilder1.append(" ,screen.dpi= ");
    localStringBuilder1.append(localDeviceInfo.screen.dpi.get());
    localStringBuilder1.append(" ,screen.multi_touch= ");
    localStringBuilder1.append(localDeviceInfo.screen.multi_touch.get());
    localStringBuilder1.append(" ,camera.primary= ");
    localStringBuilder1.append(localDeviceInfo.camera.primary.get());
    localStringBuilder1.append(" ,camera.secondary= ");
    localStringBuilder1.append(localDeviceInfo.camera.secondary.get());
    localStringBuilder1.append(" ,camera.flash= ");
    localStringBuilder1.append(localDeviceInfo.camera.flash.get());
    localStringBuilder1.append(" }");
    QLog.i("DeviceProfileManager", 1, localStringBuilder1.toString());
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
    DPCAccountServiceImpl localDPCAccountServiceImpl = sAccountDpcService;
    if (localDPCAccountServiceImpl != null)
    {
      paramEditor2.putLong(DPCAccountServiceImpl.buildAccountDpcSPName(localDPCAccountServiceImpl.mApp, "last_update_time"), System.currentTimeMillis());
      paramEditor2.putInt(DPCAccountServiceImpl.buildAccountDpcSPName(sAccountDpcService.mApp, "server_version"), paramConfig.version.get());
    }
    int i = paramSharedPreferences.getInt("key_versioncode", 0);
    int j = ApkUtils.a(MobileQQ.sMobileQQ.getApplicationContext());
    if (i < j) {
      paramEditor2.putInt("key_versioncode", j);
    }
    paramEditor1.commit();
    paramEditor2.commit();
    paramConfig = new StringBuilder();
    paramConfig.append("onDPCResponse KEY_LAST_UPDATE_TIME=");
    paramConfig.append(System.currentTimeMillis());
    paramConfig.append(", versioncode=");
    paramConfig.append(j);
    paramConfig.append(", keyVersionCode =");
    paramConfig.append(i);
    QLog.i("DeviceProfileManager", 1, paramConfig.toString());
    return true;
  }
  
  private void waitDPCServerData(long paramLong)
  {
    if (getServerDataCurrentState() != 4) {
      synchronized (this.mServerDataCurrentState)
      {
        int i = getServerDataCurrentState();
        if (i != 4) {
          try
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("waitDPCServerData() is waiting threadID=");
              localStringBuilder.append(Thread.currentThread().getId());
              QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
            }
            this.mServerDataCurrentState.wait(paramLong);
          }
          catch (InterruptedException localInterruptedException)
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
    Object localObject;
    String str1;
    if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
    {
      if (sAccountDpcService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "getFeatureValue() accountDpcManager is null");
        }
        return null;
      }
      localObject = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig_account");
      str1 = sAccountDpcService.buildAccountDpcName(paramString);
      String str2 = ((SharedPreferences)localObject).getString(str1, "");
      if ("".equals(str2))
      {
        localObject = (DeviceProfileManager.DPCConfigInfo)sAccountDpcService.mFeatureDefaultAccountMap.get(paramString);
        if (localObject != null) {
          localObject = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject).clone();
        } else {
          localObject = new DeviceProfileManager.DPCConfigInfo();
        }
      }
      else
      {
        localObject = new DeviceProfileManager.DPCConfigInfo();
        buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject, str2);
      }
      sAccountDpcService.mFeatureAccountMapLV2.put(str1, localObject);
    }
    else
    {
      str1 = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig").getString(paramString, "");
      if ("".equals(str1))
      {
        localObject = (DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultMap.get(paramString);
        if (localObject != null) {
          localObject = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject).clone();
        } else {
          localObject = new DeviceProfileManager.DPCConfigInfo();
        }
      }
      else
      {
        localObject = new DeviceProfileManager.DPCConfigInfo();
        buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject, str1);
      }
      this.mFeatureMapLV2.put(paramString, localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceProfileManager", 2, new Object[] { "getFeatureInfoSync ", paramString, " = ", ((DeviceProfileManager.DPCConfigInfo)localObject).toString() });
    }
    return localObject;
  }
  
  public String getFeatureValue(String paramString)
  {
    for (;;)
    {
      try
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = getFeatureInfo(paramString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFeatureValue: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append("=");
          if (localDPCConfigInfo != null)
          {
            paramString = localDPCConfigInfo.toString();
            localStringBuilder.append(paramString);
            QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if ((localDPCConfigInfo != null) && (localDPCConfigInfo.featureValue != null) && (localDPCConfigInfo.featureValue.length() != 0))
          {
            paramString = localDPCConfigInfo.featureValue;
            return paramString;
          }
          return "";
        }
      }
      finally {}
      paramString = "null";
    }
  }
  
  public String getFeatureValue(String paramString, long paramLong)
  {
    waitDPCServerData(paramLong);
    return getFeatureValue(paramString);
  }
  
  public String getFeatureValue(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = getFeatureValue(paramString1);
      if (paramString1 != null)
      {
        boolean bool = "".equals(paramString1);
        if (!bool) {
          return paramString1;
        }
      }
      return paramString2;
    }
    finally {}
  }
  
  public int getServerDataCurrentState()
  {
    return this.mServerDataCurrentState.get();
  }
  
  public boolean isFeatureSupported(String paramString)
  {
    try
    {
      if (DPCAccountServiceImpl.accountDpcNames.contains(paramString))
      {
        if (sAccountDpcService == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("DeviceProfileManager", 2, "isFeatureSupported() accountDpcManager is null");
          }
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isFeatureSupported() accountDpcNames=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("DeviceProfileManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = sAccountDpcService.mFeatureAccountMapLV2;
        paramString = sAccountDpcService.buildAccountDpcName(paramString);
      }
      else
      {
        localObject = this.mFeatureMapLV2;
      }
      Object localObject = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
      if ((QLog.isColorLevel()) && (localObject != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isFeatureSupported: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("=");
        localStringBuilder.append(((DeviceProfileManager.DPCConfigInfo)localObject).toString());
        QLog.d("DeviceProfileManager", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue != null) && (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.length() != 0))
      {
        if ((!((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("0")) && (!((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("2")))
        {
          boolean bool = ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("1");
          return bool;
        }
        return false;
      }
      return false;
    }
    finally {}
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
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
    }
    return false;
  }
  
  public void printDPCConfigValue()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder(1024);
      localStringBuilder1.append("mFeatureMapLV2 start loop: \n");
      Iterator localIterator = this.mFeatureMapLV2.entrySet().iterator();
      Map.Entry localEntry;
      StringBuilder localStringBuilder2;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("key=");
        localStringBuilder2.append(localEntry.getKey());
        localStringBuilder2.append(", value=");
        localStringBuilder2.append(localEntry.getValue().toString());
        localStringBuilder2.append("\n");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append("mFeatureMapLV2 end loop: \n");
      localStringBuilder1.append("mFeatureAccountMapLV2 start loop: \n");
      localIterator = sAccountDpcService.mFeatureAccountMapLV2.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("key=");
        localStringBuilder2.append(localEntry.getKey());
        localStringBuilder2.append(", value=");
        localStringBuilder2.append(localEntry.getValue().toString());
        localStringBuilder2.append("\n");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append("mFeatureAccountMapLV2 end loop: \n");
      QLog.i("DeviceProfileManager", 2, localStringBuilder1.toString());
    }
  }
  
  public void registerBroadCast(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if (this.isRegisteredBroadCast) {
        return;
      }
      paramAppRuntime = paramAppRuntime.getApplicationContext();
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tentcent.mobileqq.dpc.broadcast");
      try
      {
        paramAppRuntime.registerReceiver(this.mReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", new Handler(ThreadManager.getSubThreadLooper()));
        this.isRegisteredBroadCast = true;
        return;
      }
      catch (Exception paramAppRuntime)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerBroadCast failed! e = ");
          ((StringBuilder)localObject).append(paramAppRuntime);
          ((StringBuilder)localObject).append(" msg = ");
          ((StringBuilder)localObject).append(paramAppRuntime.getMessage());
          QLog.d("DeviceProfileManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
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