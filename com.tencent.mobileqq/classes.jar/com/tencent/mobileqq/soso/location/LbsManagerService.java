package com.tencent.mobileqq.soso.location;

import android.text.TextUtils;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LbsManagerService
{
  private static final int MAX_CONTINUE_FAIL_COUNT = 5;
  private static final int REAL_TIME_REQUIREMENT_ALMOST_IMMEDIATELY = 4;
  private static final int REAL_TIME_REQUIREMENT_HIGH = 3;
  private static final int REAL_TIME_REQUIREMENT_IMMEDIATELY = 5;
  private static final int REAL_TIME_REQUIREMENT_LOW = 1;
  private static final int REAL_TIME_REQUIREMENT_MIDDLE = 2;
  private static final HashMap<String, LbsManagerService.BusinessInfo> S_BUSINESS = new HashMap();
  private static final String TAG = "SOSO.LBS.LbsManagerService";
  private static Map<LbsManagerServiceOnLocationChangeListener, SosoInterfaceOnLocationListener> sListenerMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<SosoInterfaceOnLocationListener, LbsManagerServiceOnLocationChangeListener> sReverseListenerMap = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    registerBusinessInfo();
  }
  
  private static LbsManagerService.BusinessInfo getBusinessInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (LbsManagerService.BusinessInfo)S_BUSINESS.get(paramString);
  }
  
  public static SosoLbsInfo getCachedLbsInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.LbsManagerService", 2, "getCachedLbsInfo business id: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = getBusinessInfo(paramString);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("SOSO.LBS.LbsManagerService", 2, "getCachedLbsInfo business info is null.");
    return null;
    if (paramString.reqRawData) {
      return SosoInterface.getRawSosoInfo(paramString.reqLonAndLat);
    }
    return SosoInterface.getSosoInfo(paramString.requestDataLevel, paramString.reqLonAndLat);
  }
  
  public static SosoLbsInfo getCachedLbsInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      return SosoInterface.getRawSosoInfo(false);
    }
    return SosoInterface.getSosoInfo(3, false);
  }
  
  public static String getCity()
  {
    return SosoInterface.getCity();
  }
  
  public static String getCityCode()
  {
    return SosoInterface.getCityCode();
  }
  
  public static String getProvince()
  {
    return SosoInterface.getProvince();
  }
  
  private static SosoLbsInfo handleLbsInfo(SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      localObject = getBusinessInfo(paramString);
    } while ((localObject == null) || (paramSosoLbsInfo == null));
    if (((LbsManagerService.BusinessInfo)localObject).reqRawData)
    {
      paramString = new SosoLbsInfo();
      paramString.rawData = paramSosoLbsInfo.rawData;
      if (paramSosoLbsInfo.mLocation != null) {
        paramString.mLocation = paramSosoLbsInfo.mLocation.clone(0, ((LbsManagerService.BusinessInfo)localObject).reqLonAndLat);
      }
      if (paramSosoLbsInfo.mAttr != null) {
        paramString.mAttr = paramSosoLbsInfo.mAttr.clone();
      }
      localObject = new ArrayList();
      if (paramSosoLbsInfo.mCells != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.mCells);
      }
      paramString.mCells = ((ArrayList)localObject);
      localObject = new ArrayList();
      if (paramSosoLbsInfo.mWifis != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.mWifis);
      }
      paramString.mWifis = ((ArrayList)localObject);
      paramString.mSource = paramSosoLbsInfo.mSource;
      paramString.mVersion = paramSosoLbsInfo.mVersion;
      paramString.provider = paramSosoLbsInfo.provider;
      return paramString;
    }
    paramString = new SosoLbsInfo();
    paramString.mLocation = paramSosoLbsInfo.mLocation.clone(((LbsManagerService.BusinessInfo)localObject).requestDataLevel, ((LbsManagerService.BusinessInfo)localObject).reqLonAndLat);
    return paramString;
  }
  
  public static boolean isLastLocationSuccess()
  {
    return SosoInterface.isLastLocationSuccess();
  }
  
  private static SosoInterfaceOnLocationListener makeSosoOnLocationListener(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    LbsManagerService.BusinessInfo localBusinessInfo = getBusinessInfo(paramLbsManagerServiceOnLocationChangeListener.businessId);
    if (localBusinessInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 2, "makeSososOnLocationListener business info is null, business id: " + paramLbsManagerServiceOnLocationChangeListener.businessId);
      }
      return null;
    }
    int i = localBusinessInfo.canUseMaxCacheInterval();
    int j = localBusinessInfo.requestDataLevel;
    boolean bool2 = localBusinessInfo.reqGoon;
    boolean bool3 = localBusinessInfo.canUseGps;
    if (!localBusinessInfo.reqRawData) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new LbsManagerService.1(j, bool1, bool3, i, paramLbsManagerServiceOnLocationChangeListener.observerOnUiThread, bool2, paramLbsManagerServiceOnLocationChangeListener.businessId, paramLbsManagerServiceOnLocationChangeListener);
    }
  }
  
  public static void onDestroy()
  {
    synchronized (sListenerMap)
    {
      sListenerMap.clear();
      sReverseListenerMap.clear();
      return;
    }
  }
  
  private static void registerBusinessInfo()
  {
    LbsManagerService.BusinessInfo localBusinessInfo = new LbsManagerService.BusinessInfo("official_location", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("QQMapActivity", true, 5, 1, true, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("vas_red_point", false, 2, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_address_select", true, 5, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_for_report", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_weather", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_live", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_say", true, 5, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_upload_pic_video", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_photo_recommend", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_little_video_enter", true, 3, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_request_server", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_h5", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qzone_other", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("gdt_tangram", true, 1, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("nearby_readinjoy", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("troop_handler", true, 2, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("troop_member_distance", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("webview", true, 3, 4, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qq_weather", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qq_story_water_mark", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_weather", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("LBSService.Point", true, 5, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("Login.Guide", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("recommend_troop", true, 2, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("vfuchong_bus_card", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("readinjoy_position", false, 3, 3, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("qqcircle", true, 4, 0, false, false, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("extend_friend", true, 1, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("miniapp", true, 1, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
    localBusinessInfo = new LbsManagerService.BusinessInfo("NearbyProtocolCoder.Encounter", true, 1, 0, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
  }
  
  public static void removeListener(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    if (paramLbsManagerServiceOnLocationChangeListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (sListenerMap)
      {
        if (!sListenerMap.containsKey(paramLbsManagerServiceOnLocationChangeListener)) {
          break label120;
        }
        localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)sListenerMap.remove(paramLbsManagerServiceOnLocationChangeListener);
        sReverseListenerMap.remove(localSosoInterfaceOnLocationListener);
        if (QLog.isColorLevel())
        {
          paramLbsManagerServiceOnLocationChangeListener = new StringBuilder().append("removeListener business id is: ").append(paramLbsManagerServiceOnLocationChangeListener.businessId).append(" sosoLocationListener is null: ");
          if (localSosoInterfaceOnLocationListener == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 2, bool);
          }
        }
        else
        {
          if (localSosoInterfaceOnLocationListener == null) {
            break;
          }
          SosoInterface.removeOnLocationListener(localSosoInterfaceOnLocationListener);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = null;
    }
  }
  
  public static void startLocation(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    if (paramLbsManagerServiceOnLocationChangeListener == null) {
      return;
    }
    label131:
    label136:
    for (;;)
    {
      synchronized (sListenerMap)
      {
        if (sListenerMap.containsKey(paramLbsManagerServiceOnLocationChangeListener)) {
          break label131;
        }
        localSosoInterfaceOnLocationListener = makeSosoOnLocationListener(paramLbsManagerServiceOnLocationChangeListener);
        if (localSosoInterfaceOnLocationListener == null) {
          break label136;
        }
        sListenerMap.put(paramLbsManagerServiceOnLocationChangeListener, localSosoInterfaceOnLocationListener);
        sReverseListenerMap.put(localSosoInterfaceOnLocationListener, paramLbsManagerServiceOnLocationChangeListener);
        break label136;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localSosoInterfaceOnLocationListener == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 2, bool + " business id: " + paramLbsManagerServiceOnLocationChangeListener.businessId);
          }
        }
        else
        {
          if (localSosoInterfaceOnLocationListener == null) {
            break;
          }
          SosoInterface.startLocation(localSosoInterfaceOnLocationListener);
          return;
        }
      }
      boolean bool = false;
      continue;
      SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerService
 * JD-Core Version:    0.7.0.1
 */