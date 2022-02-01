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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCachedLbsInfo business id: ");
      localStringBuilder.append(paramString);
      QLog.i("SOSO.LBS.LbsManagerService", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = getBusinessInfo(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SOSO.LBS.LbsManagerService", 2, "getCachedLbsInfo business info is null.");
      }
      return null;
    }
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = getBusinessInfo(paramString);
    if (localObject == null) {
      return null;
    }
    if (paramSosoLbsInfo == null) {
      return null;
    }
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
    Object localObject = getBusinessInfo(paramLbsManagerServiceOnLocationChangeListener.businessId);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("makeSososOnLocationListener business info is null, business id: ");
        ((StringBuilder)localObject).append(paramLbsManagerServiceOnLocationChangeListener.businessId);
        QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    int i = ((LbsManagerService.BusinessInfo)localObject).canUseMaxCacheInterval();
    int j = ((LbsManagerService.BusinessInfo)localObject).requestDataLevel;
    boolean bool1 = ((LbsManagerService.BusinessInfo)localObject).reqGoon;
    boolean bool2 = ((LbsManagerService.BusinessInfo)localObject).canUseGps;
    return new LbsManagerService.1(j, ((LbsManagerService.BusinessInfo)localObject).reqRawData ^ true, bool2, i, paramLbsManagerServiceOnLocationChangeListener.observerOnUiThread, bool1, paramLbsManagerServiceOnLocationChangeListener.businessId, paramLbsManagerServiceOnLocationChangeListener);
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
    localBusinessInfo = new LbsManagerService.BusinessInfo("QQLive", true, 2, 3, false, true, false);
    S_BUSINESS.put(localBusinessInfo.businessId, localBusinessInfo);
  }
  
  public static void removeListener(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    if (paramLbsManagerServiceOnLocationChangeListener == null) {
      return;
    }
    SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = null;
    synchronized (sListenerMap)
    {
      if (sListenerMap.containsKey(paramLbsManagerServiceOnLocationChangeListener))
      {
        localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)sListenerMap.remove(paramLbsManagerServiceOnLocationChangeListener);
        sReverseListenerMap.remove(localSosoInterfaceOnLocationListener);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeListener business id is: ");
        ((StringBuilder)???).append(paramLbsManagerServiceOnLocationChangeListener.businessId);
        ((StringBuilder)???).append(" sosoLocationListener is null: ");
        boolean bool;
        if (localSosoInterfaceOnLocationListener == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)???).append(bool);
        QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)???).toString());
      }
      if (localSosoInterfaceOnLocationListener != null) {
        SosoInterface.removeOnLocationListener(localSosoInterfaceOnLocationListener);
      }
      return;
    }
  }
  
  public static void startLocation(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    if (paramLbsManagerServiceOnLocationChangeListener == null) {
      return;
    }
    Object localObject1 = null;
    synchronized (sListenerMap)
    {
      Object localObject2;
      if (!sListenerMap.containsKey(paramLbsManagerServiceOnLocationChangeListener))
      {
        localObject2 = makeSosoOnLocationListener(paramLbsManagerServiceOnLocationChangeListener);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          sListenerMap.put(paramLbsManagerServiceOnLocationChangeListener, localObject2);
          sReverseListenerMap.put(localObject2, paramLbsManagerServiceOnLocationChangeListener);
          localObject1 = localObject2;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startLocation sosoLocationListener is null : ");
        boolean bool;
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(" business id: ");
        ((StringBuilder)localObject2).append(paramLbsManagerServiceOnLocationChangeListener.businessId);
        QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null) {
        SosoInterface.startLocation(localObject1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerService
 * JD-Core Version:    0.7.0.1
 */