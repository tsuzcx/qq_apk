package com.tencent.mobileqq.soso.location;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
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
  private static final Object LOCK = new Object();
  public static final int MAX_LONG_TIME = 30000;
  public static final int MSG_RESET_TIMEOUT = 1002;
  public static final int MSG_STOP_LOCATION = 1001;
  public static final String PRE = "qq_";
  public static final int REQ_LOCATION = 2;
  public static final int REQ_RAW = 1;
  private static final SosoInterfaceOnLocationListener REQ_RAW_LOCATION_LISTENER = new SosoInterface.5(0, false, false, 0L, false, false, "reqRawData");
  private static final AtomicInteger REQ_STATUS;
  public static final int REQ_STOP = 0;
  public static final String SP_NAME = "soso_lbs";
  public static final String TAG = "SOSO.LBS";
  private static int consecutiveFailCount = 0;
  private static int consumeOffset = 0;
  public static volatile boolean hasGetOaid = false;
  private static long lastUpdateTime = 0L;
  private static TencentLocationListener locListener;
  private static SosoLbsInfo logSoso;
  private static TencentLocationManager mLocationManager;
  public static volatile String mOaid = "";
  private static long reqLocationTime = 0L;
  public static long reqRawTime = 0L;
  public static int sContinuousLocationInterval = 2000;
  private static boolean sInLaunchTime = true;
  private static int sLastErrorCode;
  private static int sLevel3NoCityCodeCount;
  private static HashSet<String> sRegisteredCallers;
  public static long sResumeFlagFromConversation = -1L;
  private static boolean sScreenOn;
  private static long sTime;
  private static Handler subHandler;
  private static TencentLog tencentLog;
  private static long[] timeUpdate;
  
  static
  {
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
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        localException.printStackTrace();
      }
    }
    consecutiveFailCount = 0;
    consumeOffset = 0;
    locListener = new SosoInterface.3();
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
        if (QLog.isColorLevel())
        {
          paramTencentLocation = new StringBuilder();
          paramTencentLocation.append("onLocationChanged level is 3, adcode is null, count : ");
          paramTencentLocation.append(sLevel3NoCityCodeCount);
          QLog.i("SOSO.LBS", 2, paramTencentLocation.toString());
        }
      }
    }
    sLevel3NoCityCodeCount = 0;
    return false;
  }
  
  public static SosoLbsInfo getCanUsedLbsInfoCache(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SosoLbsInfo localSosoLbsInfo = null;
    Object localObject1;
    if ((paramLong > 5000L) && (paramInt != 4))
    {
      boolean bool2 = isMainProcess();
      boolean bool1 = true;
      Object localObject2;
      if (bool2)
      {
        long l1 = SystemClock.elapsedRealtime();
        localObject1 = localSosoLbsInfo;
        if (paramLong > 0L)
        {
          localObject1 = localSosoLbsInfo;
          if (!paramBoolean1) {
            if (paramBoolean2)
            {
              localObject2 = timeUpdate;
              localObject1 = localSosoLbsInfo;
              if (localObject2[paramInt] > 0L)
              {
                localObject1 = localSosoLbsInfo;
                if (l1 >= localObject2[paramInt] + paramLong) {}
              }
            }
            else
            {
              for (localObject1 = getSosoInfo(paramInt, true);; localObject1 = getRawSosoInfo(true))
              {
                return localObject1;
                long l2 = reqRawTime;
                localObject1 = localSosoLbsInfo;
                if (l2 <= 0L) {
                  break;
                }
                localObject1 = localSosoLbsInfo;
                if (l1 >= l2 + paramLong) {
                  break;
                }
                localObject1 = localSosoLbsInfo;
                if (logSoso == null) {
                  break;
                }
              }
            }
          }
        }
      }
      else
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("max_cache_interval", paramLong);
        ((Bundle)localObject1).putBoolean("goon", paramBoolean1);
        ((Bundle)localObject1).putInt("level", paramInt);
        ((Bundle)localObject1).putBoolean("req_location", paramBoolean2);
        localObject2 = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "get_lbs_info", (Bundle)localObject1);
        if ((localObject2 != null) && (((EIPCResult)localObject2).isSuccess()))
        {
          ((EIPCResult)localObject2).data.setClassLoader(SosoInterface.class.getClassLoader());
          localSosoLbsInfo = (SosoLbsInfo)((EIPCResult)localObject2).data.getParcelable("soso_lbs_info");
          localObject1 = localSosoLbsInfo;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getCanUsedLbsInfoCache result is ok ,info is null: ");
            if (localSosoLbsInfo == null) {
              paramBoolean1 = bool1;
            } else {
              paramBoolean1 = false;
            }
            ((StringBuilder)localObject1).append(paramBoolean1);
            QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
            return localSosoLbsInfo;
          }
        }
        else
        {
          localObject1 = localSosoLbsInfo;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getCanUsedLbsInfoCache result is not ok. code: ");
            if (localObject2 == null) {
              paramInt = -1;
            } else {
              paramInt = ((EIPCResult)localObject2).code;
            }
            ((StringBuilder)localObject1).append(paramInt);
            QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localSosoLbsInfo;
          }
        }
      }
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getCanUsedLbsInfoCache maxCacheInterval is: ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" directly return.");
      QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
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
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((Context)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return localObject;
    }
    return "10000";
  }
  
  private static long getNormalEnterConversationTime()
  {
    return getConfigSp().getLong("normal_enter_conversation_time", 0L);
  }
  
  private static String getOaid()
  {
    try
    {
      if (hasGetOaid)
      {
        str = mOaid;
        return str;
      }
      hasGetOaid = true;
      ThreadManager.getSubThreadHandler().post(new SosoInterface.8());
      String str = mOaid;
      return str;
    }
    finally {}
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
    int i = ARR_LOC_LISTENER.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (i > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        localObject2 = localObject1;
        if (!localSosoInterfaceOnLocationListener.isRemoved)
        {
          localObject2 = localObject1;
          if (!localSosoInterfaceOnLocationListener.goonListener)
          {
            localObject2 = localObject1;
            if (!localSosoInterfaceOnLocationListener.reqLocation) {
              localObject2 = localSosoInterfaceOnLocationListener;
            }
          }
        }
        i -= 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
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
    int i = ARR_LOC_LISTENER.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (i > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        localObject2 = localObject1;
        if (!localSosoInterfaceOnLocationListener.isRemoved)
        {
          localObject2 = localObject1;
          if (localSosoInterfaceOnLocationListener.goonListener)
          {
            localObject2 = localObject1;
            if (localSosoInterfaceOnLocationListener.requesting) {
              localObject2 = localSosoInterfaceOnLocationListener;
            }
          }
        }
        i -= 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  @Deprecated
  public static SosoLbsInfo getSosoInfo()
  {
    SosoLbsInfo localSosoLbsInfo = logSoso;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      localSosoLbsInfo = new SosoLbsInfo();
      localSosoLbsInfo.mLocation = logSoso.mLocation.clone(4, true);
      return localSosoLbsInfo;
    }
    return null;
  }
  
  public static SosoLbsInfo getSosoInfo(int paramInt, boolean paramBoolean)
  {
    SosoLbsInfo localSosoLbsInfo = logSoso;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      localSosoLbsInfo = new SosoLbsInfo();
      localSosoLbsInfo.mLocation = logSoso.mLocation.clone(paramInt, paramBoolean);
      return localSosoLbsInfo;
    }
    return null;
  }
  
  private static SosoInterfaceOnLocationListener getTopCommonListener()
  {
    int i = ARR_LOC_LISTENER.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (i > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        localObject2 = localObject1;
        if (!localSosoInterfaceOnLocationListener.isRemoved)
        {
          localObject2 = localObject1;
          if (!localSosoInterfaceOnLocationListener.goonListener)
          {
            localObject2 = localObject1;
            if (localSosoInterfaceOnLocationListener.reqLocation) {
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (localObject1.level >= localSosoInterfaceOnLocationListener.level) {}
              }
              else
              {
                localObject2 = localSosoInterfaceOnLocationListener;
              }
            }
          }
        }
        i -= 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  private static SosoInterfaceOnLocationListener getTopGoonListener()
  {
    int i = ARR_LOC_LISTENER.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (i > 0)
    {
      i = ARR_LOC_LISTENER.size() - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        localObject2 = localObject1;
        if (!localSosoInterfaceOnLocationListener.isRemoved)
        {
          localObject2 = localObject1;
          if (localSosoInterfaceOnLocationListener.goonListener) {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (localObject1.level >= localSosoInterfaceOnLocationListener.level) {}
            }
            else
            {
              localObject2 = localSosoInterfaceOnLocationListener;
            }
          }
        }
        i -= 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
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
    if (!TextUtils.isEmpty(paramString))
    {
      HashSet localHashSet = sRegisteredCallers;
      if (localHashSet != null) {
        return localHashSet.contains(paramString);
      }
    }
    return false;
  }
  
  public static boolean isInLaunchTime()
  {
    if (!sInLaunchTime) {
      return false;
    }
    long l;
    if (isMainProcess()) {
      l = sResumeFlagFromConversation;
    } else {
      l = getNormalEnterConversationTime();
    }
    if ((l > 0L) && (SystemClock.elapsedRealtime() - l < 60000L)) {
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
    int i;
    synchronized (LOCK)
    {
      if (ARR_LOC_LISTENER.isEmpty()) {
        return;
      }
      i = ARR_LOC_LISTENER.size() - 1;
      if (i >= 0)
      {
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        if (localSosoInterfaceOnLocationListener != null)
        {
          SosoLbsInfo localSosoLbsInfo;
          if (localSosoInterfaceOnLocationListener.reqLocation) {
            localSosoLbsInfo = getSosoInfo(localSosoInterfaceOnLocationListener.level, true);
          } else {
            localSosoLbsInfo = getRawSosoInfo(true);
          }
          if (localSosoInterfaceOnLocationListener.uiThread) {
            runOnUI(localSosoInterfaceOnLocationListener, -10000, localSosoLbsInfo);
          } else {
            localSosoInterfaceOnLocationListener.onLocationFinish(-10000, localSosoLbsInfo);
          }
        }
      }
      else
      {
        ARR_LOC_LISTENER.clear();
        return;
      }
    }
  }
  
  private static void notifyLocationFinish(TencentLocation paramTencentLocation, int paramInt, String paramString, long paramLong)
  {
    int j = paramInt;
    int k = paramTencentLocation.getExtra().getInt("qq_level");
    String str = paramTencentLocation.getExtra().getString("qq_caller");
    boolean bool2 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
    boolean bool3 = paramTencentLocation.getExtra().getBoolean("qq_allowGps");
    boolean bool1;
    if (j == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (ARR_LOC_LISTENER.size() > 0)
    {
      if (bool2) {
        paramTencentLocation = getSosoInfo(k, true);
      } else {
        paramTencentLocation = getRawSosoInfo(true);
      }
      int i = ARR_LOC_LISTENER.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (SosoInterfaceOnLocationListener)ARR_LOC_LISTENER.get(i);
        Object localObject1;
        if ((((SosoInterfaceOnLocationListener)localObject2).reqLocation == bool2) && ((!((SosoInterfaceOnLocationListener)localObject2).reqLocation) || (((SosoInterfaceOnLocationListener)localObject2).level <= k)))
        {
          if (((SosoInterfaceOnLocationListener)localObject2).uiThread) {
            runOnUI((SosoInterfaceOnLocationListener)localObject2, j, paramTencentLocation);
          } else {
            ((SosoInterfaceOnLocationListener)localObject2).onLocationFinish(j, paramTencentLocation);
          }
          if (TextUtils.isEmpty(str)) {}
          while (str.equals(((SosoInterfaceOnLocationListener)localObject2).tag))
          {
            j = 0;
            break;
          }
          j = 1;
          if (j != 0) {
            uploadSummaryData(bool1, bool2, paramLong, paramInt, str, paramString, bool3, k, true);
          } else {
            uploadSummaryData(bool1, bool2, paramLong, paramInt, str, paramString, bool3, k, false);
          }
          if (((SosoInterfaceOnLocationListener)localObject2).goonListener)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onLocationChanged() lis=");
              ((StringBuilder)localObject1).append(((SosoInterfaceOnLocationListener)localObject2).tag);
              ((StringBuilder)localObject1).append(" goon...");
              QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
            }
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = ARR_LOC_LISTENER;
            j = i;
            ((ArrayList)localObject1).remove(j);
            ((SosoInterfaceOnLocationListener)localObject2).isRemoved = true;
            localObject1 = localObject2;
            i = j;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onLocationChanged() lis=");
              ((StringBuilder)localObject1).append(((SosoInterfaceOnLocationListener)localObject2).tag);
              ((StringBuilder)localObject1).append(" removed normally.");
              QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
              i = j;
            }
          }
        }
        else
        {
          localObject1 = localObject2;
        }
        if (!((SosoInterfaceOnLocationListener)localObject1).isRemoved) {
          if (((SosoInterfaceOnLocationListener)localObject1).goonListener)
          {
            j = consecutiveFailCount;
            if (j > 0) {
              ((SosoInterfaceOnLocationListener)localObject1).onConsecutiveFailure(paramInt, j);
            }
          }
          else if (SystemClock.elapsedRealtime() - ((SosoInterfaceOnLocationListener)localObject1).sTime > 30000L)
          {
            ARR_LOC_LISTENER.remove(i);
            ((SosoInterfaceOnLocationListener)localObject1).isRemoved = true;
            if (((SosoInterfaceOnLocationListener)localObject1).reqLocation) {
              localObject2 = getSosoInfo(((SosoInterfaceOnLocationListener)localObject1).level, true);
            } else {
              localObject2 = getRawSosoInfo(true);
            }
            if (localObject2 == null) {
              j = -10000;
            } else {
              j = 0;
            }
            ((SosoInterfaceOnLocationListener)localObject1).onLocationFinish(j, (SosoLbsInfo)localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("lis=");
              ((StringBuilder)localObject2).append(((SosoInterfaceOnLocationListener)localObject1).tag);
              ((StringBuilder)localObject2).append(" err_timeout.reqRaw=");
              ((StringBuilder)localObject2).append(((SosoInterfaceOnLocationListener)localObject1).reqLocation);
              ((StringBuilder)localObject2).append(". Force 2 remove it.");
              QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        i -= 1;
        j = paramInt;
      }
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
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeOnLocationListener() lis=");
        ((StringBuilder)???).append(paramSosoInterfaceOnLocationListener.tag);
        ((StringBuilder)???).append(" removed.");
        QLog.d("SOSO.LBS", 2, ((StringBuilder)???).toString());
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
  
  @Deprecated
  public static void reqRawLbsData(long paramLong, String paramString)
  {
    boolean bool3;
    boolean bool4;
    if ((ThreadManager.getSubThread() != Thread.currentThread()) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      localObject1 = Thread.currentThread().getStackTrace();
      Object localObject2;
      if ((localObject1 != null) && (localObject1.length >= 4))
      {
        localObject1 = localObject1[3];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getClassName());
        ((StringBuilder)localObject2).append(".");
        ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getMethodName());
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reqRawData caller route: ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = "";
      }
      if ((paramLong > 0L) && (SystemClock.elapsedRealtime() < reqRawTime + paramLong))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reqRawLbsData() use cache and callback now.caller=");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new HashMap();
        if ((paramString != null) && (paramString.length() > 0)) {
          ((HashMap)localObject2).put("param_caller", paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((HashMap)localObject2).put("param_caller_route", localObject1);
        }
        ((HashMap)localObject2).put("param_useCache", Boolean.toString(Boolean.TRUE.booleanValue()));
        paramString = getCurrentUin();
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(paramString, "actSosoRawDataCache", true, 0L, 0L, (HashMap)localObject2, "");
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reqRawLbsData() caller=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" interval=");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = REQ_RAW_LOCATION_LISTENER;
      ((SosoInterfaceOnLocationListener)localObject1).tag = paramString;
      startLocation((SosoInterfaceOnLocationListener)localObject1);
      paramLong = SystemClock.elapsedRealtime();
      bool3 = false;
      bool4 = false;
      bool1 = false;
      bool2 = bool4;
    }
    try
    {
      localObject1 = LOCK;
      bool2 = bool4;
      bool2 = bool3;
      try
      {
        if (SystemClock.elapsedRealtime() < reqRawTime + 2000L)
        {
          bool1 = true;
        }
        else
        {
          bool2 = bool3;
          LOCK.wait(20000L);
        }
        bool2 = bool1;
      }
      finally {}
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reqSosoLbsRawData() caller=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" less2s=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" cost=");
      ((StringBuilder)localObject1).append(SystemClock.elapsedRealtime() - paramLong);
      QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject1).toString());
    }
    return;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reqRawLbsData() can't be invoked by SubThread or UIThread.caller=");
    ((StringBuilder)localObject1).append(paramString);
    throw new AndroidRuntimeException(((StringBuilder)localObject1).toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSosoInterfaceConfig: ");
      localStringBuilder.append(paramString);
      QLog.i("SOSO.LBS", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    getConfigSp().edit().putString("config", paramString).commit();
    return true;
  }
  
  public static void startLocation(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    if (paramSosoInterfaceOnLocationListener == null) {
      return;
    }
    boolean bool;
    int j;
    Object localObject;
    try
    {
      bool = paramSosoInterfaceOnLocationListener.isRemoved;
      i = 0;
      if (bool) {
        paramSosoInterfaceOnLocationListener.isRemoved = false;
      }
      bool = NetworkUtil.isNetSupport(MobileQQ.sMobileQQ.getApplicationContext());
      if ((!isInLaunchTime()) || ("official_location".equals(paramSosoInterfaceOnLocationListener.tag))) {
        break label269;
      }
      j = 1;
    }
    finally {}
    if (!sScreenOn)
    {
      i = -10001;
    }
    else if (j != 0)
    {
      j = -10003;
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("发现启动时定位业务：");
        ((StringBuilder)localObject).append(paramSosoInterfaceOnLocationListener.tag);
        QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject).toString());
      }
    }
    for (int i = j;; i = 1)
    {
      if (TextUtils.isEmpty(mOaid)) {
        mOaid = getOaid();
      }
      BGLocateMonitor.checkTencentLocateReport(i);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startLocation() return. perCheckCode=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" hasNet=");
          ((StringBuilder)localObject).append(bool);
          QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject).toString());
        }
        localObject = getSosoInfo(paramSosoInterfaceOnLocationListener.level, true);
        if (paramSosoInterfaceOnLocationListener.uiThread) {
          runOnUI(paramSosoInterfaceOnLocationListener, i, (SosoLbsInfo)localObject);
        } else {
          paramSosoInterfaceOnLocationListener.onLocationFinish(i, (SosoLbsInfo)localObject);
        }
        return;
      }
      localObject = tencentLog;
      locateInSubThread(paramSosoInterfaceOnLocationListener);
      return;
      label269:
      j = 0;
      if (bool) {
        break;
      }
    }
  }
  
  private static void startNextLocation(boolean paramBoolean, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener1, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener2, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener3, SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener4)
  {
    Object localObject = "";
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramSosoInterfaceOnLocationListener2 = new StringBuilder();
        paramSosoInterfaceOnLocationListener2.append("onLocationChanged()");
        if (paramSosoInterfaceOnLocationListener3 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" goonLis been truncated:");
          ((StringBuilder)localObject).append(paramSosoInterfaceOnLocationListener3.tag);
          localObject = ((StringBuilder)localObject).toString();
        }
        paramSosoInterfaceOnLocationListener2.append((String)localObject);
        paramSosoInterfaceOnLocationListener2.append(" start:reqRawData");
        QLog.d("SOSO.LBS", 2, paramSosoInterfaceOnLocationListener2.toString());
      }
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
      return;
    }
    if (paramSosoInterfaceOnLocationListener2 != null)
    {
      if (QLog.isColorLevel())
      {
        paramSosoInterfaceOnLocationListener1 = new StringBuilder();
        paramSosoInterfaceOnLocationListener1.append("onLocationChanged()");
        if (paramSosoInterfaceOnLocationListener3 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" goonLis been truncated:");
          ((StringBuilder)localObject).append(paramSosoInterfaceOnLocationListener3.tag);
          localObject = ((StringBuilder)localObject).toString();
        }
        paramSosoInterfaceOnLocationListener1.append((String)localObject);
        paramSosoInterfaceOnLocationListener1.append(" start:");
        paramSosoInterfaceOnLocationListener1.append(paramSosoInterfaceOnLocationListener2.tag);
        QLog.d("SOSO.LBS", 2, paramSosoInterfaceOnLocationListener1.toString());
      }
      if (paramSosoInterfaceOnLocationListener4 != null) {
        paramSosoInterfaceOnLocationListener4.requesting = false;
      }
      stopLocation();
      paramSosoInterfaceOnLocationListener2.maxCacheInterval = 0L;
      startLocation(paramSosoInterfaceOnLocationListener2);
      return;
    }
    if (paramSosoInterfaceOnLocationListener3 != null)
    {
      if (QLog.isColorLevel())
      {
        paramSosoInterfaceOnLocationListener1 = new StringBuilder();
        paramSosoInterfaceOnLocationListener1.append("onLocationChanged() goonLis goon after 1000ms:");
        paramSosoInterfaceOnLocationListener1.append(paramSosoInterfaceOnLocationListener3.tag);
        QLog.d("SOSO.LBS", 2, paramSosoInterfaceOnLocationListener1.toString());
      }
      if ((paramSosoInterfaceOnLocationListener4 != null) && (paramSosoInterfaceOnLocationListener4 != paramSosoInterfaceOnLocationListener3)) {
        paramSosoInterfaceOnLocationListener4.requesting = false;
      }
      if ((!paramSosoInterfaceOnLocationListener3.requesting) && (!paramSosoInterfaceOnLocationListener3.isRemoved))
      {
        stopLocation();
        ThreadManager.getSubThreadHandler().postDelayed(new SosoInterface.4(paramSosoInterfaceOnLocationListener3), 2000L);
      }
    }
  }
  
  public static void startOfficialLocation()
  {
    SharedPreferences localSharedPreferences = getConfigSp();
    Object localObject = localSharedPreferences.getString("config", "");
    long l = localSharedPreferences.getLong("lastLocationTime", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOfficialLocation. config is: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" lastLocationTime: ");
      localStringBuilder.append(l);
      QLog.i("SOSO.LBS", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).getInt("isLoginLBSOpen");
      int j = ((JSONObject)localObject).getInt("loginLBSInterval");
      if (i != 1) {
        return;
      }
      if (NetConnInfoCenter.getServerTime() - l < j) {
        return;
      }
      if (TextUtils.isEmpty(mOaid)) {
        mOaid = getOaid();
      }
      LbsManagerService.startLocation(new SosoInterface.12("official_location", false));
      localSharedPreferences.edit().putLong("lastLocationTime", NetConnInfoCenter.getServerTime()).commit();
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isDevelopLevel()) {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private static void stopLocation()
  {
    REQ_STATUS.set(0);
    TencentLocationListener localTencentLocationListener = locListener;
    if (localTencentLocationListener != null)
    {
      TencentLocationManager localTencentLocationManager = mLocationManager;
      if (localTencentLocationManager != null)
      {
        localTencentLocationManager.removeUpdates(localTencentLocationListener);
        mLocationManager = null;
      }
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            logSoso.mLocation.poi = paramTencentLocation.getPoiList();
            timeUpdate[4] = SystemClock.elapsedRealtime();
          }
        }
        else
        {
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
        }
      }
      else
      {
        logSoso.mLocation.name = paramTencentLocation.getName();
        logSoso.mLocation.address = paramTencentLocation.getAddress();
        timeUpdate[1] = SystemClock.elapsedRealtime();
      }
    }
    else
    {
      logSoso.mLocation.altitude = paramTencentLocation.getAltitude();
      logSoso.mLocation.accuracy = paramTencentLocation.getAccuracy();
      timeUpdate[0] = SystemClock.elapsedRealtime();
    }
    reqLocationTime = SystemClock.elapsedRealtime();
    if (reqLocationTime - lastUpdateTime > 3000L)
    {
      saveGeogInfo(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
      lastUpdateTime = reqLocationTime;
      if (QLog.isColorLevel())
      {
        paramTencentLocation = new StringBuilder();
        paramTencentLocation.append("saveGeogInfo cost: ");
        paramTencentLocation.append(SystemClock.elapsedRealtime() - lastUpdateTime);
        QLog.d("SOSO.LBS", 2, paramTencentLocation.toString());
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update location ipc result code: ");
        if (paramTencentLocation == null) {
          paramInt = -1;
        } else {
          paramInt = paramTencentLocation.code;
        }
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("SOSO.LBS", 2, ((StringBuilder)localObject).toString());
      }
    }
    LbsInfoReportManagerUtils.reportLbsInfo2DC(logSoso.mLocation, paramString);
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3) {
          return;
        }
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
      }
      logSoso.mLocation.name = paramSosoLbsInfo.mLocation.name;
      logSoso.mLocation.address = paramSosoLbsInfo.mLocation.address;
      timeUpdate[1] = SystemClock.elapsedRealtime();
    }
    logSoso.mLocation.altitude = paramSosoLbsInfo.mLocation.altitude;
    logSoso.mLocation.accuracy = paramSosoLbsInfo.mLocation.accuracy;
    timeUpdate[0] = SystemClock.elapsedRealtime();
  }
  
  public static void updateRawData(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (logSoso == null)
    {
      logSoso = new SosoLbsInfo();
      logSoso.mLocation = new SosoLocation();
    }
    try
    {
      logSoso.rawData = paramArrayOfByte;
      localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      Object localObject1;
      double d1;
      double d2;
      label93:
      label95:
      break label527;
    }
    try
    {
      localObject1 = localJSONObject.getJSONObject("location");
      d1 = ((JSONObject)localObject1).getDouble("latitude");
    }
    catch (JSONException localJSONException1)
    {
      break label93;
    }
    try
    {
      d2 = ((JSONObject)localObject1).getDouble("longitude");
    }
    catch (JSONException localJSONException2)
    {
      break label95;
    }
    d1 = 0.0D;
    d2 = 0.0D;
    try
    {
      localObject1 = localJSONObject.getJSONObject("attribute");
      localSosoAttribute = new SosoAttribute(((JSONObject)localObject1).getString("imei"), ((JSONObject)localObject1).getString("imsi"), ((JSONObject)localObject1).getString("phonenum"), ((JSONObject)localObject1).getString("qq"), ((JSONObject)localObject1).getBoolean("roaming"));
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        SosoAttribute localSosoAttribute;
        ArrayList localArrayList1;
        int j;
        int i;
        Object localObject2;
        ArrayList localArrayList2;
        long l1;
        continue;
        boolean bool = false;
      }
    }
    localSosoAttribute = new SosoAttribute("", "", "", "", false);
    localArrayList1 = new ArrayList();
    localObject1 = localJSONObject.getJSONArray("cells");
    j = ((JSONArray)localObject1).length();
    i = 0;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      int k = ((JSONObject)localObject2).getInt("mcc");
      int m = ((JSONObject)localObject2).getInt("mnc");
      int n = ((JSONObject)localObject2).getInt("lac");
      int i1 = ((JSONObject)localObject2).getInt("cellid");
      int i2 = ((JSONObject)localObject2).getInt("rss");
      if (i != 0) {
        break label668;
      }
      bool = true;
      localArrayList1.add(new SosoCell(k, m, n, i1, i2, bool));
      i += 1;
    }
    localArrayList2 = new ArrayList();
    localObject1 = localJSONObject.getJSONArray("wifis");
    j = ((JSONArray)localObject1).length();
    i = 0;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      localArrayList2.add(new SosoWifi(((JSONObject)localObject2).getString("mac"), ((JSONObject)localObject2).getInt("rssi")));
      i += 1;
    }
    localObject1 = "";
    l1 = 0L;
    try
    {
      localObject2 = localJSONObject.getString("version");
      localObject1 = localObject2;
      long l2 = localJSONObject.getLong("source");
      l1 = l2;
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException4)
    {
      label440:
      break label440;
    }
    if (d1 != 0.0D) {
      logSoso.mLocation.mLat84 = d1;
    }
    if (d2 != 0.0D) {
      logSoso.mLocation.mLon84 = d2;
    }
    logSoso.mAttr = localSosoAttribute;
    logSoso.mCells = localArrayList1;
    logSoso.mWifis = localArrayList2;
    logSoso.mSource = l1;
    logSoso.mVersion = ((String)localObject1);
    logSoso.provider = paramString;
    reqRawTime = SystemClock.elapsedRealtime();
    label527:
    if (!isMainProcess())
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("provider", paramString);
      ((Bundle)localObject1).putByteArray("raw_data", paramArrayOfByte);
      ((Bundle)localObject1).putBoolean("req_location", false);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", (Bundle)localObject1);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("update raw data, ipc result code: ");
        if (paramString == null) {
          i = -1;
        } else {
          i = paramString.code;
        }
        paramArrayOfByte.append(i);
        QLog.i("SOSO.LBS", 2, paramArrayOfByte.toString());
      }
    }
  }
  
  private static void uploadSummaryData(boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt1 == -4) || (paramInt1 == -17))) {
      return;
    }
    if (((!paramBoolean1) && (HwNetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ.getApplicationContext()))) || (paramBoolean1))
    {
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
      if (paramBoolean4)
      {
        if (paramBoolean2) {
          paramString2 = "actSosoLocationCache";
        } else {
          paramString2 = "actSosoRawDataCache";
        }
      }
      else if (paramBoolean2) {
        paramString2 = "actSosoLocation";
      } else {
        paramString2 = "actSosoRawData";
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, paramString2, paramBoolean1, paramLong, 0L, localHashMap, "");
      MagnifierSDK.a().a().a("requestSoso", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean3), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (isInLaunchTime())
      {
        paramString2 = new HashMap();
        if ((paramString1 != null) && (paramString1.length() > 0))
        {
          paramString2.put("param_caller", paramString1);
          StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(str, "actLocationEarly", paramBoolean1, paramLong, 0L, paramString2, "");
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("location too early: ");
            paramString2.append(paramString1);
            QLog.e("SOSO.LBS", 2, paramString2.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface
 * JD-Core Version:    0.7.0.1
 */