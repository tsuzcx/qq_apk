package com.tencent.mobileqq.soso.location;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.soso.location.inject.LbsInfoReportManagerUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SosoInterface
{
  private static final ArrayList<SosoInterfaceOnLocationListener> ARR_LOC_LISTENER;
  public static final int ERR_SCREEN_OF = -10001;
  public static final int ERR_TIMEOUT = -10000;
  public static final int ERR_TOO_EARLY = -10003;
  private static final Object LOCK;
  public static final int MAX_LONG_TIME = 30000;
  public static final int MSG_RESET_TIMEOUT = 1002;
  public static final int MSG_STOP_LOCATION = 1001;
  public static final String PRE = "qq_";
  public static final int REQ_LOCATION = 2;
  public static final int REQ_RAW = 1;
  private static final SosoInterfaceOnLocationListener REQ_RAW_LOCATION_LISTENER;
  private static final AtomicInteger REQ_STATUS;
  public static final int REQ_STOP = 0;
  public static final String SP_NAME = "soso_lbs";
  public static final String TAG = "SOSO.LBS";
  private static int consecutiveFailCount;
  private static int consumeOffset;
  public static volatile boolean hasGetOaid;
  private static long lastUpdateTime;
  private static TencentLocationListener locListener;
  private static SosoLbsInfo logSoso;
  private static TencentLocationManager mLocationManager;
  public static volatile String mOaid;
  private static long reqLocationTime;
  public static long reqRawTime;
  public static int sContinuousLocationInterval = 2000;
  private static boolean sInLaunchTime;
  private static int sLastErrorCode;
  private static int sLevel3NoCityCodeCount;
  private static HashSet<String> sRegisteredCallers;
  public static long sResumeFlagFromConversation;
  private static boolean sScreenOn;
  private static long sTime;
  private static Handler subHandler;
  private static TencentLog tencentLog;
  private static long[] timeUpdate;
  
  static
  {
    LOCK = new Object();
    mOaid = "";
    sResumeFlagFromConversation = -1L;
    ARR_LOC_LISTENER = new ArrayList();
    sLevel3NoCityCodeCount = 0;
    subHandler = new Handler(ThreadManager.getSubThreadLooper(), new SosoInterface.1());
    REQ_STATUS = new AtomicInteger(0);
    timeUpdate = new long[] { 0L, 0L, 0L, 0L, 0L };
    sScreenOn = true;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    SosoInterface.2 local2 = new SosoInterface.2();
    try
    {
      MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(local2, localIntentFilter);
      consecutiveFailCount = 0;
      consumeOffset = 0;
      locListener = new SosoInterface.3();
      REQ_RAW_LOCATION_LISTENER = new SosoInterface.5(0, false, false, 0L, false, false, "reqRawData");
      sInLaunchTime = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private static void addOnLocationListener(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    if (paramSosoInterfaceOnLocationListener == null) {
      return;
    }
    synchronized (LOCK)
    {
      if (!ARR_LOC_LISTENER.contains(paramSosoInterfaceOnLocationListener)) {
        ARR_LOC_LISTENER.add(paramSosoInterfaceOnLocationListener);
      }
      return;
    }
  }
  
  private static boolean checkLevel3NoCityCodeCount(TencentLocation paramTencentLocation, int paramInt1, int paramInt2)
  {
    if ((3 == paramInt2) && (paramInt1 == 0))
    {
      String str;
      if (TextUtils.isEmpty(paramTencentLocation.getCityCode()))
      {
        sLevel3NoCityCodeCount += 1;
        if (sLevel3NoCityCodeCount >= 12)
        {
          paramTencentLocation = new HashMap();
          paramTencentLocation.put("level_3_no_citycode", String.valueOf(sLevel3NoCityCodeCount));
          str = getCurrentUin();
          StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, "actSoSoNoCityCodeTimeout", true, 0L, 0L, paramTencentLocation, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null");
        }
        return true;
      }
      if (sLevel3NoCityCodeCount > 0)
      {
        paramTencentLocation = new HashMap();
        paramTencentLocation.put("level_3_no_citycode", String.valueOf(sLevel3NoCityCodeCount));
        str = getCurrentUin();
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, "actSoSoNoCityCode", true, 0L, 0L, paramTencentLocation, "");
        if (QLog.isColorLevel()) {
          QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null, count : " + sLevel3NoCityCodeCount);
        }
      }
    }
    sLevel3NoCityCodeCount = 0;
    return false;
  }
  
  public static SosoLbsInfo getCanUsedLbsInfoCache(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SosoLbsInfo localSosoLbsInfo = null;
    boolean bool = true;
    if ((paramLong <= 5000L) || (paramInt == 4))
    {
      localObject = localSosoLbsInfo;
      if (QLog.isColorLevel())
      {
        QLog.i("SOSO.LBS", 2, "getCanUsedLbsInfoCache maxCacheInterval is: " + paramLong + " directly return.");
        localObject = localSosoLbsInfo;
      }
    }
    EIPCResult localEIPCResult;
    do
    {
      do
      {
        do
        {
          long l;
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
                      return localObject;
                      if (!isMainProcess()) {
                        break;
                      }
                      l = SystemClock.elapsedRealtime();
                      localObject = localSosoLbsInfo;
                    } while (paramLong <= 0L);
                    localObject = localSosoLbsInfo;
                  } while (paramBoolean1);
                  if (!paramBoolean2) {
                    break;
                  }
                  localObject = localSosoLbsInfo;
                } while (timeUpdate[paramInt] <= 0L);
                localObject = localSosoLbsInfo;
              } while (l >= timeUpdate[paramInt] + paramLong);
              return getSosoInfo(paramInt, true);
              localObject = localSosoLbsInfo;
            } while (reqRawTime <= 0L);
            localObject = localSosoLbsInfo;
          } while (l >= reqRawTime + paramLong);
          localObject = localSosoLbsInfo;
        } while (logSoso == null);
        return getRawSosoInfo(true);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("max_cache_interval", paramLong);
        ((Bundle)localObject).putBoolean("goon", paramBoolean1);
        ((Bundle)localObject).putInt("level", paramInt);
        ((Bundle)localObject).putBoolean("req_location", paramBoolean2);
        localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "get_lbs_info", (Bundle)localObject);
        if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
          break;
        }
        localEIPCResult.data.setClassLoader(SosoInterface.class.getClassLoader());
        localSosoLbsInfo = (SosoLbsInfo)localEIPCResult.data.getParcelable("soso_lbs_info");
        localObject = localSosoLbsInfo;
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is ok ,info is null: ");
      if (localSosoLbsInfo == null) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        QLog.i("SOSO.LBS", 2, paramBoolean1);
        return localSosoLbsInfo;
      }
      localObject = localSosoLbsInfo;
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is not ok. code: ");
    if (localEIPCResult == null) {}
    for (paramInt = -1;; paramInt = localEIPCResult.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      return null;
    }
  }
  
  static String getCity()
  {
    SosoLbsInfo localSosoLbsInfo = getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.mLocation.city))) {
      return localSosoLbsInfo.mLocation.city;
    }
    return getConfigSp().getString("city", "");
  }
  
  public static String getCityCode()
  {
    SosoLbsInfo localSosoLbsInfo = getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.mLocation.cityCode))) {
      return localSosoLbsInfo.mLocation.cityCode;
    }
    return getConfigSp().getString("adcode", "");
  }
  
  private static SharedPreferences getConfigSp()
  {
    return MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("sosoConfig", 4);
  }
  
  public static String getCurrentUin()
  {
    Object localObject = MobileQQ.sMobileQQ.getApplicationContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break;
      }
      return localObject;
    }
    return "10000";
  }
  
  private static long getNormalEnterConversationTime()
  {
    return getConfigSp().getLong("normal_enter_conversation_time", 0L);
  }
  
  /* Error */
  private static String getOaid()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 530	com/tencent/mobileqq/soso/location/SosoInterface:hasGetOaid	Z
    //   6: ifeq +12 -> 18
    //   9: getstatic 88	com/tencent/mobileqq/soso/location/SosoInterface:mOaid	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: iconst_1
    //   19: putstatic 530	com/tencent/mobileqq/soso/location/SosoInterface:hasGetOaid	Z
    //   22: invokestatic 534	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   25: new 536	com/tencent/mobileqq/soso/location/SosoInterface$8
    //   28: dup
    //   29: invokespecial 537	com/tencent/mobileqq/soso/location/SosoInterface$8:<init>	()V
    //   32: invokevirtual 543	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: getstatic 88	com/tencent/mobileqq/soso/location/SosoInterface:mOaid	Ljava/lang/String;
    //   39: astore_0
    //   40: goto -27 -> 13
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	28	0	str	String
    //   43	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	43	finally
    //   18	40	43	finally
  }
  
  public static String getProvince()
  {
    SosoLbsInfo localSosoLbsInfo = getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.mLocation.province))) {
      return localSosoLbsInfo.mLocation.province;
    }
    return getConfigSp().getString("province", "");
  }
  
  private static SosoInterfaceOnLocationListener getRawLocationListener()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (ARR_LOC_LISTENER.size() > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      localObject2 = localObject1;
      if (i >= 0)
      {
        localObject2 = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if ((((SosoInterfaceOnLocationListener)localObject2).isRemoved) || (((SosoInterfaceOnLocationListener)localObject2).goonListener) || (((SosoInterfaceOnLocationListener)localObject2).reqLocation)) {
          break label71;
        }
        localObject1 = localObject2;
      }
    }
    label71:
    for (;;)
    {
      i -= 1;
      break;
      return localObject2;
    }
  }
  
  @Deprecated
  public static SosoLbsInfo getRawSosoInfo()
  {
    return getRawSosoInfo(true);
  }
  
  public static SosoLbsInfo getRawSosoInfo(boolean paramBoolean)
  {
    if (logSoso == null) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.rawData = logSoso.rawData;
    if (logSoso.mLocation != null) {
      localSosoLbsInfo.mLocation = logSoso.mLocation.clone(0, paramBoolean);
    }
    if (logSoso.mAttr != null) {
      localSosoLbsInfo.mAttr = logSoso.mAttr.clone();
    }
    ArrayList localArrayList = new ArrayList();
    if (logSoso.mCells != null) {
      localArrayList.addAll(logSoso.mCells);
    }
    localSosoLbsInfo.mCells = localArrayList;
    localArrayList = new ArrayList();
    if (logSoso.mWifis != null) {
      localArrayList.addAll(logSoso.mWifis);
    }
    localSosoLbsInfo.mWifis = localArrayList;
    localSosoLbsInfo.mSource = logSoso.mSource;
    localSosoLbsInfo.mVersion = logSoso.mVersion;
    localSosoLbsInfo.provider = logSoso.provider;
    return localSosoLbsInfo;
  }
  
  private static SosoInterfaceOnLocationListener getRequestingGoonListener()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (ARR_LOC_LISTENER.size() > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      localObject2 = localObject1;
      if (i >= 0)
      {
        localObject2 = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if ((((SosoInterfaceOnLocationListener)localObject2).isRemoved) || (!((SosoInterfaceOnLocationListener)localObject2).goonListener) || (!((SosoInterfaceOnLocationListener)localObject2).requesting)) {
          break label71;
        }
        localObject1 = localObject2;
      }
    }
    label71:
    for (;;)
    {
      i -= 1;
      break;
      return localObject2;
    }
  }
  
  @Deprecated
  public static SosoLbsInfo getSosoInfo()
  {
    if ((logSoso == null) || (logSoso.mLocation == null)) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.mLocation = logSoso.mLocation.clone(4, true);
    return localSosoLbsInfo;
  }
  
  public static SosoLbsInfo getSosoInfo(int paramInt, boolean paramBoolean)
  {
    if ((logSoso == null) || (logSoso.mLocation == null)) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.mLocation = logSoso.mLocation.clone(paramInt, paramBoolean);
    return localSosoLbsInfo;
  }
  
  private static SosoInterfaceOnLocationListener getTopCommonListener()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener;
    if (ARR_LOC_LISTENER.size() > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      localObject2 = localObject1;
      if (i >= 0)
      {
        localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if ((localSosoInterfaceOnLocationListener.isRemoved) || (localSosoInterfaceOnLocationListener.goonListener) || (!localSosoInterfaceOnLocationListener.reqLocation)) {
          break label90;
        }
        localObject2 = localSosoInterfaceOnLocationListener;
        if (localObject1 != null) {
          if (localObject1.level >= localSosoInterfaceOnLocationListener.level) {
            break label90;
          }
        }
      }
    }
    label90:
    for (localObject2 = localSosoInterfaceOnLocationListener;; localObject2 = localObject1)
    {
      i -= 1;
      localObject1 = localObject2;
      break;
      return localObject2;
    }
  }
  
  private static SosoInterfaceOnLocationListener getTopGoonListener()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener;
    if (ARR_LOC_LISTENER.size() > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      localObject2 = localObject1;
      if (i >= 0)
      {
        localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if ((localSosoInterfaceOnLocationListener.isRemoved) || (!localSosoInterfaceOnLocationListener.goonListener)) {
          break label83;
        }
        localObject2 = localSosoInterfaceOnLocationListener;
        if (localObject1 != null) {
          if (localObject1.level >= localSosoInterfaceOnLocationListener.level) {
            break label83;
          }
        }
      }
    }
    label83:
    for (localObject2 = localSosoInterfaceOnLocationListener;; localObject2 = localObject1)
    {
      i -= 1;
      localObject1 = localObject2;
      break;
      return localObject2;
    }
  }
  
  private static void initRegisteredCallers()
  {
    sRegisteredCallers = new HashSet(128, 1.0F);
    sRegisteredCallers.add("pathtrace");
    sRegisteredCallers.add("ecshop");
    sRegisteredCallers.add("AbsPublish");
    sRegisteredCallers.add("QQYPHomePageActivity");
    sRegisteredCallers.add("vas_red_point");
    sRegisteredCallers.add("HotSpotNodeUtil");
    sRegisteredCallers.add("smartdevice:lightapp");
    sRegisteredCallers.add("HYNearbyHelper");
    sRegisteredCallers.add("AbsPublishIphoneTitleBarActivity");
    sRegisteredCallers.add("GetNearbyRecommender");
    sRegisteredCallers.add("HotChatHandler");
    sRegisteredCallers.add("LBSService");
    sRegisteredCallers.add("LBSService.Encounter");
    sRegisteredCallers.add("LBSService.Point");
    sRegisteredCallers.add("NearbyHandler");
    sRegisteredCallers.add("AccountConfigReq");
    sRegisteredCallers.add("recommend_troop");
    sRegisteredCallers.add("AddFriendVerifyActivity");
    sRegisteredCallers.add("AutoLocationMapView");
    sRegisteredCallers.add("BaseProtocolCoder.Point");
    sRegisteredCallers.add("BusinessCmrTmpChatPie");
    sRegisteredCallers.add("BusinessHandler");
    sRegisteredCallers.add("c2blbs");
    sRegisteredCallers.add("CardHandler");
    sRegisteredCallers.add("CreateFaceToFaceDiscussionActivity");
    sRegisteredCallers.add("CrmIvr");
    sRegisteredCallers.add("EnterpriseQQManager");
    sRegisteredCallers.add("FlowCameraActivity2");
    sRegisteredCallers.add("IphoneTitleBarActivity");
    sRegisteredCallers.add("LBSHandler");
    sRegisteredCallers.add("LBSService.Groups");
    sRegisteredCallers.add("Leba");
    sRegisteredCallers.add("NearbyCmdHelper.Point");
    sRegisteredCallers.add("NearbyTroopsView");
    sRegisteredCallers.add("PersonalInfoReq");
    sRegisteredCallers.add("PublicAccountChatPie");
    sRegisteredCallers.add("PublicAccountManager");
    sRegisteredCallers.add("PublicView");
    sRegisteredCallers.add("QLifeCommentActivity");
    sRegisteredCallers.add("QQCardService");
    sRegisteredCallers.add("QQMapActivity");
    sRegisteredCallers.add("QQSettingRedesign");
    sRegisteredCallers.add("QQYPCityActivity");
    sRegisteredCallers.add("Qwallet");
    sRegisteredCallers.add("RealEventReq");
    sRegisteredCallers.add("TroopNotifyAndRecommendView");
    sRegisteredCallers.add("reqRawData");
    sRegisteredCallers.add("SearchContacts");
    sRegisteredCallers.add("SearchProtocol");
    sRegisteredCallers.add("smartdevice:deviceinterface");
    sRegisteredCallers.add("StatusServlet");
    sRegisteredCallers.add("TroopFileHandler");
    sRegisteredCallers.add("TroopNearByBigMapView");
    sRegisteredCallers.add("VipMapRoamActivity");
    sRegisteredCallers.add("webview");
    sRegisteredCallers.add("qq_weather");
    sRegisteredCallers.add("NearbyProtocolCoder.Encounter");
    sRegisteredCallers.add("BizTroopHandler");
    sRegisteredCallers.add("troop_handler");
    sRegisteredCallers.add("NearbyCardHandler");
    sRegisteredCallers.add("LbsMngLocationListener");
    sRegisteredCallers.add("QWalletBaseProtocol");
    sRegisteredCallers.add("buscardLocation");
    sRegisteredCallers.add("NewFlowCameraActivity");
    sRegisteredCallers.add("NewStoryTakeVideoActivity");
    sRegisteredCallers.add("NearbyNowliveTab");
    sRegisteredCallers.add("ArkAppLocationManager");
    sRegisteredCallers.add("ArkAppEventObserverManager");
    sRegisteredCallers.add("vfuchong_bus_card");
    sRegisteredCallers.add("ARMapDataPreload");
    sRegisteredCallers.add("armap_web_plugin");
    sRegisteredCallers.add("LebaPlugin");
    sRegisteredCallers.add("GdtLocationUtil");
    sRegisteredCallers.add("FlashCarGame");
    sRegisteredCallers.add("QQARScan");
    sRegisteredCallers.add("BKEngineLocationManager");
    sRegisteredCallers.add("Doraemon");
    sRegisteredCallers.add("GalleryReportedUtils");
    sRegisteredCallers.add("official_location");
    sRegisteredCallers.add("readinjoy_anti_cheating");
    sRegisteredCallers.add("qzone_address_select");
    sRegisteredCallers.add("qzone_for_report");
    sRegisteredCallers.add("qzone_weather");
    sRegisteredCallers.add("qzone_live");
    sRegisteredCallers.add("qzone_say");
    sRegisteredCallers.add("qzone_upload_pic_video");
    sRegisteredCallers.add("qzone_photo_recommend");
    sRegisteredCallers.add("qzone_little_video_enter");
    sRegisteredCallers.add("qzone_request_server");
    sRegisteredCallers.add("qzone_h5");
    sRegisteredCallers.add("qzone_other");
    sRegisteredCallers.add("readinjoy_feed_ad_distance");
    sRegisteredCallers.add("gdt_tangram");
    sRegisteredCallers.add("nearby_readinjoy");
    sRegisteredCallers.add("troop_member_distance");
    sRegisteredCallers.add("qq_story_water_mark");
    sRegisteredCallers.add("miniApp");
    sRegisteredCallers.add("readinjoy_weather");
    sRegisteredCallers.add("PublicAccountHandler");
    sRegisteredCallers.add("readinjoy_position");
    sRegisteredCallers.add("Face2FaceAddContactPresenter");
    sRegisteredCallers.add("qqcircle");
    sRegisteredCallers.add("extend_friend");
  }
  
  private static boolean isCallerRegistered(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (sRegisteredCallers == null)) {
      return false;
    }
    return sRegisteredCallers.contains(paramString);
  }
  
  public static boolean isInLaunchTime()
  {
    if (!sInLaunchTime) {
      return false;
    }
    if (isMainProcess()) {}
    for (long l = sResumeFlagFromConversation; (l > 0L) && (SystemClock.elapsedRealtime() - l < 60000L); l = getNormalEnterConversationTime()) {
      return true;
    }
    sInLaunchTime = false;
    return false;
  }
  
  public static boolean isLastLocationSuccess()
  {
    return getConfigSp().getInt("last_location_err_code", -1) == 0;
  }
  
  private static boolean isMainProcess()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  private static void locateInSubThread(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    ThreadManager.getSubThreadHandler().post(new SosoInterface.7(paramSosoInterfaceOnLocationListener));
  }
  
  private static void notifyLocationError()
  {
    for (;;)
    {
      int i;
      SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener;
      synchronized (LOCK)
      {
        if (ARR_LOC_LISTENER.isEmpty()) {
          return;
        }
        i = ARR_LOC_LISTENER.size() - 1;
        if (i < 0) {
          break label107;
        }
        localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if (localSosoInterfaceOnLocationListener == null) {
          break label116;
        }
        if (localSosoInterfaceOnLocationListener.reqLocation)
        {
          SosoLbsInfo localSosoLbsInfo1 = getSosoInfo(localSosoInterfaceOnLocationListener.level, true);
          if (!localSosoInterfaceOnLocationListener.uiThread) {
            break label96;
          }
          runOnUI(localSosoInterfaceOnLocationListener, -10000, localSosoLbsInfo1);
        }
      }
      SosoLbsInfo localSosoLbsInfo2 = getRawSosoInfo(true);
      continue;
      label96:
      localSosoInterfaceOnLocationListener.onLocationFinish(-10000, localSosoLbsInfo2);
      break label116;
      label107:
      ARR_LOC_LISTENER.clear();
      return;
      label116:
      i -= 1;
    }
  }
  
  private static void notifyLocationFinish(TencentLocation paramTencentLocation, int paramInt, String paramString, long paramLong)
  {
    int k = paramTencentLocation.getExtra().getInt("qq_level");
    String str = paramTencentLocation.getExtra().getString("qq_caller");
    boolean bool2 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
    boolean bool3 = paramTencentLocation.getExtra().getBoolean("qq_allowGps");
    boolean bool1;
    label84:
    int j;
    label94:
    SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener;
    if (paramInt == 0)
    {
      bool1 = true;
      if (ARR_LOC_LISTENER.size() <= 0) {
        return;
      }
      if (!bool2) {
        break label284;
      }
      paramTencentLocation = getSosoInfo(k, true);
      j = ARR_LOC_LISTENER.size() - 1;
      if (j < 0) {
        return;
      }
      localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(j);
      if ((localSosoInterfaceOnLocationListener.reqLocation == bool2) && ((!localSosoInterfaceOnLocationListener.reqLocation) || (localSosoInterfaceOnLocationListener.level <= k)))
      {
        if (!localSosoInterfaceOnLocationListener.uiThread) {
          break label292;
        }
        runOnUI(localSosoInterfaceOnLocationListener, paramInt, paramTencentLocation);
        label155:
        if (!TextUtils.isEmpty(str)) {
          break label302;
        }
        i = 0;
        label166:
        if (i == 0) {
          break label327;
        }
        uploadSummaryData(bool1, bool2, paramLong, paramInt, str, paramString, bool3, k, true);
        label188:
        if (!localSosoInterfaceOnLocationListener.goonListener) {
          break label347;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + localSosoInterfaceOnLocationListener.tag + " goon...");
        }
      }
      label238:
      if (!localSosoInterfaceOnLocationListener.isRemoved)
      {
        if (!localSosoInterfaceOnLocationListener.goonListener) {
          break label407;
        }
        if (consecutiveFailCount > 0) {
          localSosoInterfaceOnLocationListener.onConsecutiveFailure(paramInt, consecutiveFailCount);
        }
      }
    }
    label284:
    label292:
    label302:
    label327:
    label347:
    while (SystemClock.elapsedRealtime() - localSosoInterfaceOnLocationListener.sTime <= 30000L)
    {
      j -= 1;
      break label94;
      bool1 = false;
      break;
      paramTencentLocation = getRawSosoInfo(true);
      break label84;
      localSosoInterfaceOnLocationListener.onLocationFinish(paramInt, paramTencentLocation);
      break label155;
      if (!str.equals(localSosoInterfaceOnLocationListener.tag))
      {
        i = 1;
        break label166;
      }
      i = 0;
      break label166;
      uploadSummaryData(bool1, bool2, paramLong, paramInt, str, paramString, bool3, k, false);
      break label188;
      ARR_LOC_LISTENER.remove(j);
      localSosoInterfaceOnLocationListener.isRemoved = true;
      if (!QLog.isColorLevel()) {
        break label238;
      }
      QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + localSosoInterfaceOnLocationListener.tag + " removed normally.");
      break label238;
    }
    label407:
    ARR_LOC_LISTENER.remove(j);
    localSosoInterfaceOnLocationListener.isRemoved = true;
    SosoLbsInfo localSosoLbsInfo;
    if (localSosoInterfaceOnLocationListener.reqLocation)
    {
      localSosoLbsInfo = getSosoInfo(localSosoInterfaceOnLocationListener.level, true);
      label457:
      if (localSosoLbsInfo != null) {
        break label544;
      }
    }
    label544:
    for (int i = -10000;; i = 0)
    {
      localSosoInterfaceOnLocationListener.onLocationFinish(i, localSosoLbsInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SOSO.LBS", 2, "lis=" + localSosoInterfaceOnLocationListener.tag + " err_timeout.reqRaw=" + localSosoInterfaceOnLocationListener.reqLocation + ". Force 2 remove it.");
      break;
      localSosoLbsInfo = getRawSosoInfo(true);
      break label457;
    }
  }
  
  public static void onDestroy()
  {
    ThreadManager.getSubThreadHandler().post(new SosoInterface.10());
    synchronized (LOCK)
    {
      ARR_LOC_LISTENER.clear();
      return;
    }
  }
  
  public static void removeOnLocationListener(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    synchronized (LOCK)
    {
      ARR_LOC_LISTENER.remove(paramSosoInterfaceOnLocationListener);
      paramSosoInterfaceOnLocationListener.isRemoved = true;
      paramSosoInterfaceOnLocationListener.requesting = false;
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramSosoInterfaceOnLocationListener.tag + " removed.");
      }
      if (ARR_LOC_LISTENER.size() == 0)
      {
        ThreadManager.getSubThreadHandler().post(new SosoInterface.9());
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  /* Error */
  @Deprecated
  public static void reqRawLbsData(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 934	com/tencent/mobileqq/app/ThreadManager:getSubThread	()Ljava/lang/Thread;
    //   3: invokestatic 939	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 939	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 944	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 947	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 949	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 348	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 951
    //   35: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 953	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 939	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 957	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 12
    //   57: ldc 86
    //   59: astore 11
    //   61: aload 11
    //   63: astore 10
    //   65: aload 12
    //   67: ifnull +95 -> 162
    //   70: aload 11
    //   72: astore 10
    //   74: aload 12
    //   76: arraylength
    //   77: iconst_4
    //   78: if_icmplt +84 -> 162
    //   81: aload 12
    //   83: iconst_3
    //   84: aaload
    //   85: astore 10
    //   87: new 348	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   94: aload 10
    //   96: invokevirtual 962	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   99: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 964
    //   105: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 10
    //   110: invokevirtual 967	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   113: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 11
    //   121: aload 11
    //   123: astore 10
    //   125: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +34 -> 162
    //   131: ldc 42
    //   133: iconst_2
    //   134: new 348	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 969
    //   144: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 11
    //   149: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 344	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 11
    //   160: astore 10
    //   162: lload_0
    //   163: lconst_0
    //   164: lcmp
    //   165: ifle +142 -> 307
    //   168: invokestatic 380	android/os/SystemClock:elapsedRealtime	()J
    //   171: getstatic 386	com/tencent/mobileqq/soso/location/SosoInterface:reqRawTime	J
    //   174: lload_0
    //   175: ladd
    //   176: lcmp
    //   177: ifge +130 -> 307
    //   180: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +29 -> 212
    //   186: ldc 42
    //   188: iconst_2
    //   189: new 348	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 971
    //   199: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 889	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: new 307	java/util/HashMap
    //   215: dup
    //   216: invokespecial 308	java/util/HashMap:<init>	()V
    //   219: astore 11
    //   221: aload_2
    //   222: ifnull +20 -> 242
    //   225: aload_2
    //   226: invokevirtual 518	java/lang/String:length	()I
    //   229: ifle +13 -> 242
    //   232: aload 11
    //   234: ldc_w 973
    //   237: aload_2
    //   238: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: aload 10
    //   244: invokestatic 305	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +14 -> 261
    //   250: aload 11
    //   252: ldc_w 975
    //   255: aload 10
    //   257: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload 11
    //   263: ldc_w 977
    //   266: getstatic 983	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   269: invokevirtual 986	java/lang/Boolean:booleanValue	()Z
    //   272: invokestatic 989	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   275: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: invokestatic 323	com/tencent/mobileqq/soso/location/SosoInterface:getCurrentUin	()Ljava/lang/String;
    //   282: astore_2
    //   283: getstatic 146	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   286: invokevirtual 150	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   289: invokestatic 329	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   292: aload_2
    //   293: ldc_w 991
    //   296: iconst_1
    //   297: lconst_0
    //   298: lconst_0
    //   299: aload 11
    //   301: ldc 86
    //   303: invokevirtual 335	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   306: return
    //   307: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +39 -> 349
    //   313: ldc 42
    //   315: iconst_2
    //   316: new 348	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 993
    //   326: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 995
    //   336: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: lload_0
    //   340: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 889	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: getstatic 174	com/tencent/mobileqq/soso/location/SosoInterface:REQ_RAW_LOCATION_LISTENER	Lcom/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener;
    //   352: aload_2
    //   353: putfield 884	com/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener:tag	Ljava/lang/String;
    //   356: getstatic 174	com/tencent/mobileqq/soso/location/SosoInterface:REQ_RAW_LOCATION_LISTENER	Lcom/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener;
    //   359: invokestatic 998	com/tencent/mobileqq/soso/location/SosoInterface:startLocation	(Lcom/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener;)V
    //   362: invokestatic 380	android/os/SystemClock:elapsedRealtime	()J
    //   365: lstore_0
    //   366: iconst_0
    //   367: istore 9
    //   369: iconst_0
    //   370: istore 8
    //   372: iload 8
    //   374: istore 7
    //   376: getstatic 84	com/tencent/mobileqq/soso/location/SosoInterface:LOCK	Ljava/lang/Object;
    //   379: astore 11
    //   381: iload 8
    //   383: istore 7
    //   385: aload 11
    //   387: monitorenter
    //   388: iload 9
    //   390: istore 8
    //   392: invokestatic 380	android/os/SystemClock:elapsedRealtime	()J
    //   395: lstore_3
    //   396: iload 9
    //   398: istore 8
    //   400: getstatic 386	com/tencent/mobileqq/soso/location/SosoInterface:reqRawTime	J
    //   403: lstore 5
    //   405: lload_3
    //   406: lload 5
    //   408: ldc2_w 999
    //   411: ladd
    //   412: lcmp
    //   413: ifge +67 -> 480
    //   416: iconst_1
    //   417: istore 7
    //   419: aload 11
    //   421: monitorexit
    //   422: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -119 -> 306
    //   428: ldc 42
    //   430: iconst_2
    //   431: new 348	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1002
    //   441: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_2
    //   445: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 1004
    //   451: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload 7
    //   456: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   459: ldc_w 1006
    //   462: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokestatic 380	android/os/SystemClock:elapsedRealtime	()J
    //   468: lload_0
    //   469: lsub
    //   470: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 889	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: return
    //   480: iload 9
    //   482: istore 8
    //   484: getstatic 84	com/tencent/mobileqq/soso/location/SosoInterface:LOCK	Ljava/lang/Object;
    //   487: ldc2_w 1007
    //   490: invokevirtual 1012	java/lang/Object:wait	(J)V
    //   493: iconst_0
    //   494: istore 7
    //   496: goto -77 -> 419
    //   499: iload 7
    //   501: istore 8
    //   503: aload 11
    //   505: monitorexit
    //   506: aload 10
    //   508: athrow
    //   509: astore 10
    //   511: goto -89 -> 422
    //   514: astore 10
    //   516: goto -17 -> 499
    //   519: astore 10
    //   521: iload 8
    //   523: istore 7
    //   525: goto -26 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramLong	long
    //   0	528	2	paramString	String
    //   395	11	3	l1	long
    //   403	4	5	l2	long
    //   374	150	7	bool1	boolean
    //   370	152	8	bool2	boolean
    //   367	114	9	bool3	boolean
    //   63	444	10	localObject1	Object
    //   509	1	10	localInterruptedException	java.lang.InterruptedException
    //   514	1	10	localObject2	Object
    //   519	1	10	localObject3	Object
    //   59	445	11	localObject4	Object
    //   55	27	12	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   376	381	509	java/lang/InterruptedException
    //   385	388	509	java/lang/InterruptedException
    //   506	509	509	java/lang/InterruptedException
    //   419	422	514	finally
    //   392	396	519	finally
    //   400	405	519	finally
    //   484	493	519	finally
    //   503	506	519	finally
  }
  
  private static void runOnUI(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener, int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoInterfaceOnLocationListener == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new SosoInterface.6(paramSosoInterfaceOnLocationListener, paramInt, paramSosoLbsInfo));
  }
  
  public static void saveGeogInfo(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2204);
    localNewIntent.putExtra("longitude", paramString1);
    localNewIntent.putExtra("latitude", paramString2);
    if (MobileQQ.sMobileQQ.peekAppRuntime() != null)
    {
      MobileQQ.sMobileQQ.peekAppRuntime().startServlet(localNewIntent);
      return;
    }
    QLog.e("SOSO.LBS", 1, "MobileQQ.sMobileQQ.peekAppRuntime() == null");
  }
  
  private static void saveLastLocationErrCode(int paramInt)
  {
    getConfigSp().edit().putInt("last_location_err_code", paramInt).commit();
  }
  
  public static void saveNormalEnterConversationTime(long paramLong)
  {
    getConfigSp().edit().putLong("normal_enter_conversation_time", paramLong).commit();
  }
  
  public static boolean saveSosoInterfaceConfig(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS", 2, "saveSosoInterfaceConfig: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    getConfigSp().edit().putString("config", paramString).commit();
    return true;
  }
  
  public static void startLocation(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    int j = 1;
    if (paramSosoInterfaceOnLocationListener == null) {
      return;
    }
    for (;;)
    {
      boolean bool;
      label59:
      try
      {
        if (paramSosoInterfaceOnLocationListener.isRemoved) {
          paramSosoInterfaceOnLocationListener.isRemoved = false;
        }
        bool = NetworkUtil.d(MobileQQ.sMobileQQ.getApplicationContext());
        if ((!isInLaunchTime()) || ("official_location".equals(paramSosoInterfaceOnLocationListener.tag))) {
          break label157;
        }
        i = 1;
      }
      finally {}
      if (TextUtils.isEmpty(mOaid)) {
        mOaid = getOaid();
      }
      BGLocateMonitor.checkTencentLocateReport(i);
      SosoLbsInfo localSosoLbsInfo;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool);
        }
        localSosoLbsInfo = getSosoInfo(paramSosoInterfaceOnLocationListener.level, true);
        if (paramSosoInterfaceOnLocationListener.uiThread)
        {
          runOnUI(paramSosoInterfaceOnLocationListener, i, localSosoLbsInfo);
          break;
          label157:
          i = 0;
        }
      }
      while (bool)
      {
        if (!sScreenOn)
        {
          i = -10001;
          break label59;
        }
        if (i != 0)
        {
          j = -10003;
          i = j;
          if (!QLog.isColorLevel()) {
            break label59;
          }
          QLog.i("SOSO.LBS", 2, "发现启动时定位业务：" + paramSosoInterfaceOnLocationListener.tag);
          i = j;
          break label59;
          paramSosoInterfaceOnLocationListener.onLocationFinish(i, localSosoLbsInfo);
          break;
          if (tencentLog == null) {}
          locateInSubThread(paramSosoInterfaceOnLocationListener);
          break;
        }
        i = 0;
        break label59;
      }
      int i = j;
    }
  }
  
  private static void startNextLocation(boolean paramBoolean, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener1, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener2, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener3, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener4)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onLocationChanged()");
        if (paramSosoInterfaceOnLocationListener3 == null)
        {
          paramSosoInterfaceOnLocationListener2 = "";
          QLog.d("SOSO.LBS", 2, paramSosoInterfaceOnLocationListener2 + " start:reqRawData");
        }
      }
      else
      {
        if (paramSosoInterfaceOnLocationListener4 != null) {
          paramSosoInterfaceOnLocationListener4.requesting = false;
        }
        if (paramSosoInterfaceOnLocationListener1 != null)
        {
          REQ_RAW_LOCATION_LISTENER.tag = paramSosoInterfaceOnLocationListener1.tag;
          REQ_RAW_LOCATION_LISTENER.askGPS = paramSosoInterfaceOnLocationListener1.askGPS;
        }
        stopLocation();
        startLocation(REQ_RAW_LOCATION_LISTENER);
      }
    }
    label209:
    do
    {
      do
      {
        return;
        paramSosoInterfaceOnLocationListener2 = " goonLis been truncated:" + paramSosoInterfaceOnLocationListener3.tag;
        break;
        if (paramSosoInterfaceOnLocationListener2 != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("onLocationChanged()");
            if (paramSosoInterfaceOnLocationListener3 != null) {
              break label209;
            }
          }
          for (paramSosoInterfaceOnLocationListener1 = "";; paramSosoInterfaceOnLocationListener1 = " goonLis been truncated:" + paramSosoInterfaceOnLocationListener3.tag)
          {
            QLog.d("SOSO.LBS", 2, paramSosoInterfaceOnLocationListener1 + " start:" + paramSosoInterfaceOnLocationListener2.tag);
            if (paramSosoInterfaceOnLocationListener4 != null) {
              paramSosoInterfaceOnLocationListener4.requesting = false;
            }
            stopLocation();
            paramSosoInterfaceOnLocationListener2.maxCacheInterval = 0L;
            startLocation(paramSosoInterfaceOnLocationListener2);
            return;
          }
        }
      } while (paramSosoInterfaceOnLocationListener3 == null);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() goonLis goon after 1000ms:" + paramSosoInterfaceOnLocationListener3.tag);
      }
      if ((paramSosoInterfaceOnLocationListener4 != null) && (paramSosoInterfaceOnLocationListener4 != paramSosoInterfaceOnLocationListener3)) {
        paramSosoInterfaceOnLocationListener4.requesting = false;
      }
    } while ((paramSosoInterfaceOnLocationListener3.requesting) || (paramSosoInterfaceOnLocationListener3.isRemoved));
    stopLocation();
    ThreadManager.getSubThreadHandler().postDelayed(new SosoInterface.4(paramSosoInterfaceOnLocationListener3), 2000L);
  }
  
  public static void startOfficialLocation()
  {
    SharedPreferences localSharedPreferences = getConfigSp();
    Object localObject = localSharedPreferences.getString("config", "");
    long l = localSharedPreferences.getLong("lastLocationTime", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS", 2, "startOfficialLocation. config is: " + (String)localObject + " lastLocationTime: " + l);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject((String)localObject);
          int i = ((JSONObject)localObject).getInt("isLoginLBSOpen");
          int j = ((JSONObject)localObject).getInt("loginLBSInterval");
          if ((i == 1) && (NetConnInfoCenter.getServerTime() - l >= j))
          {
            if (TextUtils.isEmpty(mOaid)) {
              mOaid = getOaid();
            }
            LbsManagerService.startLocation(new SosoInterface.12("official_location", false));
            localSharedPreferences.edit().putLong("lastLocationTime", NetConnInfoCenter.getServerTime()).commit();
            return;
          }
        }
        catch (JSONException localJSONException) {}
      }
    } while (!QLog.isDevelopLevel());
    localJSONException.printStackTrace();
  }
  
  private static void stopLocation()
  {
    REQ_STATUS.set(0);
    if ((locListener != null) && (mLocationManager != null))
    {
      mLocationManager.removeUpdates(locListener);
      mLocationManager = null;
    }
    sLevel3NoCityCodeCount = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "stopLocation() stop LBS");
    }
  }
  
  private static void toastSomethingWrong(String paramString)
  {
    ThreadManager.getUIHandler().post(new SosoInterface.11(paramString));
  }
  
  private static void updateLocation(int paramInt, TencentLocation paramTencentLocation, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    if (logSoso == null)
    {
      logSoso = new SosoLbsInfo();
      logSoso.mLocation = new SosoLocation();
    }
    logSoso.mLocation.mLon02 = paramTencentLocation.getLongitude();
    logSoso.mLocation.mLat02 = paramTencentLocation.getLatitude();
    logSoso.mLocation.mVerifyKey = paramTencentLocation.getVerifyKey();
    logSoso.mLocation.fakeReason = paramTencentLocation.getFakeReason();
    logSoso.mLocation.locationTime = paramTencentLocation.getTime();
    logSoso.mLocation.speed = paramTencentLocation.getSpeed();
    logSoso.mLocation.mProviderSource = paramTencentLocation.getSourceProvider();
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      reqLocationTime = SystemClock.elapsedRealtime();
      if (reqLocationTime - lastUpdateTime > 3000L)
      {
        saveGeogInfo(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
        lastUpdateTime = reqLocationTime;
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - lastUpdateTime));
        }
      }
      if (!isMainProcess())
      {
        paramTencentLocation = new Bundle();
        paramTencentLocation.putInt("level", paramInt);
        paramTencentLocation.putBoolean("req_location", true);
        paramTencentLocation.putParcelable("soso_lbs_info", logSoso);
        paramTencentLocation = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", paramTencentLocation);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("update location ipc result code: ");
          if (paramTencentLocation != null) {
            break label723;
          }
        }
      }
      break;
    }
    label723:
    for (paramInt = -1;; paramInt = paramTencentLocation.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      LbsInfoReportManagerUtils.reportLbsInfo2DC(logSoso.mLocation, paramString);
      return;
      logSoso.mLocation.poi = paramTencentLocation.getPoiList();
      timeUpdate[4] = SystemClock.elapsedRealtime();
      logSoso.mLocation.nation = paramTencentLocation.getNation();
      logSoso.mLocation.province = paramTencentLocation.getProvince();
      logSoso.mLocation.city = paramTencentLocation.getCity();
      localObject = paramTencentLocation.getCityCode();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase("unknown"))) {
        logSoso.mLocation.cityCode = ((String)localObject);
      }
      logSoso.mLocation.district = paramTencentLocation.getDistrict();
      logSoso.mLocation.town = paramTencentLocation.getTown();
      logSoso.mLocation.village = paramTencentLocation.getVillage();
      logSoso.mLocation.street = paramTencentLocation.getStreet();
      logSoso.mLocation.streetNo = paramTencentLocation.getStreetNo();
      timeUpdate[3] = SystemClock.elapsedRealtime();
      getConfigSp().edit().putString("province", logSoso.mLocation.province).apply();
      getConfigSp().edit().putString("adcode", logSoso.mLocation.cityCode).apply();
      getConfigSp().edit().putString("city", logSoso.mLocation.city).apply();
      logSoso.mLocation.name = paramTencentLocation.getName();
      logSoso.mLocation.address = paramTencentLocation.getAddress();
      timeUpdate[1] = SystemClock.elapsedRealtime();
      logSoso.mLocation.altitude = paramTencentLocation.getAltitude();
      logSoso.mLocation.accuracy = paramTencentLocation.getAccuracy();
      timeUpdate[0] = SystemClock.elapsedRealtime();
      break;
    }
  }
  
  public static void updateMainProcessCachedLocation(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return;
    }
    if (logSoso == null)
    {
      logSoso = new SosoLbsInfo();
      logSoso.mLocation = new SosoLocation();
    }
    logSoso.mLocation.speed = paramSosoLbsInfo.mLocation.speed;
    logSoso.mLocation.mLon02 = paramSosoLbsInfo.mLocation.mLon02;
    logSoso.mLocation.mLat02 = paramSosoLbsInfo.mLocation.mLat02;
    logSoso.mLocation.mVerifyKey = paramSosoLbsInfo.mLocation.mVerifyKey;
    logSoso.mLocation.fakeReason = paramSosoLbsInfo.mLocation.fakeReason;
    logSoso.mLocation.locationTime = paramSosoLbsInfo.mLocation.locationTime;
    logSoso.mLocation.mProviderSource = paramSosoLbsInfo.mLocation.mProviderSource;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    for (;;)
    {
      logSoso.mLocation.altitude = paramSosoLbsInfo.mLocation.altitude;
      logSoso.mLocation.accuracy = paramSosoLbsInfo.mLocation.accuracy;
      timeUpdate[0] = SystemClock.elapsedRealtime();
      return;
      logSoso.mLocation.nation = paramSosoLbsInfo.mLocation.nation;
      logSoso.mLocation.province = paramSosoLbsInfo.mLocation.province;
      logSoso.mLocation.city = paramSosoLbsInfo.mLocation.city;
      String str = paramSosoLbsInfo.mLocation.cityCode;
      if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
        logSoso.mLocation.cityCode = str;
      }
      logSoso.mLocation.district = paramSosoLbsInfo.mLocation.district;
      logSoso.mLocation.town = paramSosoLbsInfo.mLocation.town;
      logSoso.mLocation.village = paramSosoLbsInfo.mLocation.village;
      logSoso.mLocation.street = paramSosoLbsInfo.mLocation.street;
      logSoso.mLocation.streetNo = paramSosoLbsInfo.mLocation.streetNo;
      timeUpdate[3] = SystemClock.elapsedRealtime();
      logSoso.mLocation.name = paramSosoLbsInfo.mLocation.name;
      logSoso.mLocation.address = paramSosoLbsInfo.mLocation.address;
      timeUpdate[1] = SystemClock.elapsedRealtime();
    }
  }
  
  public static void updateRawData(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      if (logSoso == null)
      {
        logSoso = new SosoLbsInfo();
        logSoso.mLocation = new SosoLocation();
      }
      for (;;)
      {
        try
        {
          logSoso.rawData = paramArrayOfByte;
          localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
          d2 = 0.0D;
          d1 = d2;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          Object localObject1;
          SosoAttribute localSosoAttribute;
          ArrayList localArrayList1;
          int j;
          int i;
          Object localObject3;
          ArrayList localArrayList2;
          Object localObject2;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("location");
          d1 = d2;
          d2 = ((JSONObject)localObject1).getDouble("latitude");
          d1 = d2;
          d3 = ((JSONObject)localObject1).getDouble("longitude");
          d1 = d3;
        }
        catch (JSONException localJSONException2)
        {
          d3 = 0.0D;
          d2 = d1;
          d1 = d3;
          continue;
          bool = false;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("attribute");
          localSosoAttribute = new SosoAttribute(((JSONObject)localObject1).getString("imei"), ((JSONObject)localObject1).getString("imsi"), ((JSONObject)localObject1).getString("phonenum"), ((JSONObject)localObject1).getString("qq"), ((JSONObject)localObject1).getBoolean("roaming"));
          localArrayList1 = new ArrayList();
          localObject1 = localJSONObject.getJSONArray("cells");
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            int k = ((JSONObject)localObject3).getInt("mcc");
            int m = ((JSONObject)localObject3).getInt("mnc");
            int n = ((JSONObject)localObject3).getInt("lac");
            int i1 = ((JSONObject)localObject3).getInt("cellid");
            int i2 = ((JSONObject)localObject3).getInt("rss");
            if (i != 0) {
              break label666;
            }
            bool = true;
            localArrayList1.add(new SosoCell(k, m, n, i1, i2, bool));
            i += 1;
            continue;
          }
        }
        catch (JSONException localJSONException1)
        {
          localSosoAttribute = new SosoAttribute("", "", "", "", false);
          continue;
          localArrayList2 = new ArrayList();
          localObject2 = localJSONObject.getJSONArray("wifis");
          i = 0;
          j = ((JSONArray)localObject2).length();
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localArrayList2.add(new SosoWifi(((JSONObject)localObject3).getString("mac"), ((JSONObject)localObject3).getInt("rssi")));
            i += 1;
            continue;
          }
          localObject2 = "";
          try
          {
            localObject3 = localJSONObject.getString("version");
            localObject2 = localObject3;
            l = localJSONObject.getLong("source");
          }
          catch (JSONException localJSONException3)
          {
            long l = 0L;
            Object localObject4 = localObject2;
            continue;
            i = paramString.code;
            continue;
          }
          if (d2 != 0.0D) {
            logSoso.mLocation.mLat84 = d2;
          }
          if (d1 != 0.0D) {
            logSoso.mLocation.mLon84 = d1;
          }
          logSoso.mAttr = localSosoAttribute;
          logSoso.mCells = localArrayList1;
          logSoso.mWifis = localArrayList2;
          logSoso.mSource = l;
          logSoso.mVersion = ((String)localObject3);
          logSoso.provider = paramString;
          reqRawTime = SystemClock.elapsedRealtime();
          if (isMainProcess()) {
            break;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("provider", paramString);
          ((Bundle)localObject2).putByteArray("raw_data", paramArrayOfByte);
          ((Bundle)localObject2).putBoolean("req_location", false);
          paramString = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", (Bundle)localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          paramArrayOfByte = new StringBuilder().append("update raw data, ipc result code: ");
          if (paramString == null)
          {
            i = -1;
            QLog.i("SOSO.LBS", 2, i);
            return;
          }
        }
      }
    }
  }
  
  private static void uploadSummaryData(boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt1 == -4) || (paramInt1 == -17)))
    {
      break label28;
      break label28;
    }
    label28:
    while (((paramBoolean1) || (!HwNetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ.getApplicationContext()))) && (!paramBoolean1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt1));
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localHashMap.put("param_caller", paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("param_reason", paramString2);
    }
    localHashMap.put("param_useCache", Boolean.toString(paramBoolean4));
    localHashMap.put("param_askGps", Boolean.toString(paramBoolean3));
    localHashMap.put("param_costTime", Long.toString(paramLong));
    localHashMap.put("param_level", String.valueOf(paramInt2));
    String str = getCurrentUin();
    if (paramBoolean4) {
      if (paramBoolean2) {
        paramString2 = "actSosoLocationCache";
      }
    }
    for (;;)
    {
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, paramString2, paramBoolean1, paramLong, 0L, localHashMap, "");
      MagnifierSDK.a().a().a("requestSoso", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean3), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (!isInLaunchTime()) {
        break;
      }
      paramString2 = new HashMap();
      if ((paramString1 == null) || (paramString1.length() <= 0)) {
        break;
      }
      paramString2.put("param_caller", paramString1);
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, "actLocationEarly", paramBoolean1, paramLong, 0L, paramString2, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SOSO.LBS", 2, "location too early: " + paramString1);
      return;
      paramString2 = "actSosoRawDataCache";
      continue;
      if (paramBoolean2) {
        paramString2 = "actSosoLocation";
      } else {
        paramString2 = "actSosoRawData";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface
 * JD-Core Version:    0.7.0.1
 */