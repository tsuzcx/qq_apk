package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StGameDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qzone.QUA;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MiniProgramReportHelper
{
  private static final Map<String, String> APP_ID_LAUNCH_ID_MAP = new HashMap();
  private static final Map<String, String> LAUNCH_ID_MAP_MAIN_PROCESS = new HashMap();
  private static MiniAppConfig MINI_APP_CONFIG_FOR_PRELOAD;
  public static String PERF_LEVEL;
  public static final String PRELOAD_MINI_APP_ID = "0000000000";
  private static final String TAG = "MiniProgramReportHelper";
  
  static
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = "0000000000";
    MINI_APP_CONFIG_FOR_PRELOAD = new MiniAppConfig(localMiniAppInfo);
    MINI_APP_CONFIG_FOR_PRELOAD.launchParam = new LaunchParam();
    MINI_APP_CONFIG_FOR_PRELOAD.launchParam.miniAppId = "0000000000";
  }
  
  public static void assignAppLaunchId(MiniAppConfig paramMiniAppConfig)
  {
    String str1 = getMiniAppIdSafely(paramMiniAppConfig);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = String.valueOf(System.currentTimeMillis());
      APP_ID_LAUNCH_ID_MAP.put(str1, str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mini] assignAppLaunchId [appId= ");
      localStringBuilder.append(str1);
      localStringBuilder.append("] [launchId=");
      localStringBuilder.append(str2);
      QLog.e("MiniProgramReportHelper", 1, localStringBuilder.toString());
    }
    MINI_APP_CONFIG_FOR_PRELOAD = paramMiniAppConfig;
  }
  
  public static void checkShouldAssignPreloadLaunchId(int paramInt)
  {
    if ((paramInt == 605) || (paramInt == 1)) {
      APP_ID_LAUNCH_ID_MAP.put("0000000000", "0");
    }
  }
  
  public static String currentUrlFromApkInfo(ApkgInfo paramApkgInfo)
  {
    Object localObject = null;
    String str = null;
    if (paramApkgInfo != null)
    {
      if (paramApkgInfo.mAppConfigInfo != null) {
        str = paramApkgInfo.mAppConfigInfo.entryPagePath;
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (paramApkgInfo.appConfig != null)
        {
          localObject = str;
          if (paramApkgInfo.appConfig.launchParam != null) {
            localObject = paramApkgInfo.appConfig.launchParam.entryPath;
          }
        }
      }
    }
    return localObject;
  }
  
  public static void generateLaunchIdInMainProcess(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = getMiniAppIdSafely(paramMiniAppConfig);
    if (!TextUtils.isEmpty(paramMiniAppConfig))
    {
      String str = String.valueOf(System.currentTimeMillis());
      LAUNCH_ID_MAP_MAIN_PROCESS.put(paramMiniAppConfig, str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mini] generateLaunchIdInMainProcess [appId= ");
      localStringBuilder.append(paramMiniAppConfig);
      localStringBuilder.append("] [launchId=");
      localStringBuilder.append(str);
      QLog.e("MiniProgramReportHelper", 1, localStringBuilder.toString());
    }
  }
  
  public static String getLaunchIdFromMainProcess(MiniAppConfig paramMiniAppConfig)
  {
    return (String)LAUNCH_ID_MAP_MAIN_PROCESS.get(getMiniAppIdSafely(paramMiniAppConfig));
  }
  
  public static String getLaunchIdFromMainProcess(String paramString)
  {
    return (String)LAUNCH_ID_MAP_MAIN_PROCESS.get(paramString);
  }
  
  private static String getLocation(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = new StringBuilder();
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("miniapp");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      paramContext.append(localSosoLbsInfo.mLocation.mLat02);
      paramContext.append('*');
      paramContext.append(localSosoLbsInfo.mLocation.mLon02);
    }
    return paramContext.toString();
  }
  
  private static String getMiniAppIdSafely(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
      paramMiniAppConfig = paramMiniAppConfig.config.appId;
    } else {
      paramMiniAppConfig = null;
    }
    Object localObject = paramMiniAppConfig;
    if (TextUtils.isEmpty(paramMiniAppConfig)) {
      localObject = "0000000000";
    }
    return localObject;
  }
  
  public static String getNetworkType()
  {
    String str = HttpUtil.getNetWorkTypeByStr();
    if (str == null) {
      return "unknown";
    }
    return str.toLowerCase();
  }
  
  public static String launchIdForMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    return (String)APP_ID_LAUNCH_ID_MAP.get(getMiniAppIdSafely(paramMiniAppConfig));
  }
  
  public static MiniAppConfig miniAppConfigForPreload()
  {
    return MINI_APP_CONFIG_FOR_PRELOAD;
  }
  
  public static List<COMM.Entry> newAppQualityEntries(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    return newAppQualityEntries(paramMiniAppConfig, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, "", "", "", "");
  }
  
  public static List<COMM.Entry> newAppQualityEntries(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    if (PERF_LEVEL == null) {
      PERF_LEVEL = String.valueOf(DeviceInfoUtils.a());
    }
    COMM.Entry localEntry1 = newEntry("uid", String.valueOf(CommonDataAdapter.a().a()));
    COMM.Entry localEntry2 = newEntry("appid", getMiniAppIdSafely(paramMiniAppConfig));
    COMM.Entry localEntry3 = newEntry("launchid", paramString10);
    paramString10 = "";
    if (paramString2 == null) {
      paramString2 = "";
    }
    paramString2 = newEntry("event", paramString2);
    paramString9 = newEntry("timestamp", paramString9);
    if (paramString1 == null) {
      paramString1 = "";
    }
    COMM.Entry localEntry4 = newEntry("page", paramString1);
    if (paramString3 == null) {
      paramString3 = "";
    }
    paramString3 = newEntry("attachinfo", paramString3);
    COMM.Entry localEntry5 = newEntry("appversion", "8.7.0.5295");
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
      paramString1 = paramMiniAppConfig.config.version;
    } else {
      paramString1 = "";
    }
    COMM.Entry localEntry6 = newEntry("miniapp_version", paramString1);
    COMM.Entry localEntry7 = newEntry("qua", QUA.getQUA3());
    if (paramString4 == null) {
      paramString4 = "";
    }
    paramString4 = newEntry("cmd", paramString4);
    paramString5 = newEntry("retcode", paramString5);
    paramString7 = newEntry("time_cost", paramString7);
    paramString8 = newEntry("third_url", paramString8);
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.baseLibInfo != null)) {
      paramString1 = paramMiniAppConfig.baseLibInfo.baseLibVersion;
    } else {
      paramString1 = "";
    }
    COMM.Entry localEntry8 = newEntry("baselib_version", paramString1);
    COMM.Entry localEntry9 = newEntry("x5_version", String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication())));
    paramString6 = newEntry("app_type", paramString6);
    COMM.Entry localEntry10 = newEntry("network_type", getNetworkType());
    paramString1 = paramString10;
    if (paramMiniAppConfig != null)
    {
      paramString1 = paramString10;
      if (paramMiniAppConfig.launchParam != null) {
        paramString1 = String.valueOf(paramMiniAppConfig.launchParam.scene);
      }
    }
    return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, paramString2, paramString9, localEntry4, paramString3, localEntry5, localEntry6, localEntry7, paramString4, paramString5, paramString7, paramString8, localEntry8, localEntry9, paramString6, localEntry10, newEntry("scene", paramString1), newEntry("reverse1", paramString11), newEntry("reverse2", paramString12), newEntry("reverse3", paramString13), newEntry("reverse4", paramString14), newEntry("busiType", PERF_LEVEL) }));
  }
  
  public static List<COMM.Entry> newBaseBusinessEntries(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("actiontype", String.valueOf(paramString1)), newEntry("sub_actiontype", String.valueOf(paramString2)), newEntry("reserves_action", String.valueOf(paramString3)), newEntry("reserves2", String.valueOf(paramString4)), newEntry("reserves3", String.valueOf(paramString5)), newEntry("reserves4", String.valueOf(paramString6)), newEntry("reserves5", String.valueOf(paramString7)) }));
    return localArrayList;
  }
  
  public static List<COMM.Entry> newBusinessEntries(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = "";
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      COMM.Entry localEntry1 = newEntry("launchid", paramString12);
      COMM.Entry localEntry2 = newEntry("appid", paramMiniAppConfig.config.appId);
      COMM.Entry localEntry3 = newEntry("app_version", String.valueOf(paramMiniAppConfig.config.version));
      COMM.Entry localEntry4 = newEntry("app_classification", null);
      COMM.Entry localEntry5 = newEntry("app_tag", "");
      boolean bool = EnvUtils.isPkgDownloaded(paramMiniAppConfig);
      String str2 = "1";
      if (bool) {
        paramString12 = "1";
      } else {
        paramString12 = "0";
      }
      COMM.Entry localEntry6 = newEntry("isPkgDownloaed", paramString12);
      if (paramMiniAppConfig != null) {
        paramString12 = paramMiniAppConfig.config;
      } else {
        paramString12 = null;
      }
      if (EnvUtils.isX5Enabled(paramString12)) {
        paramString12 = str2;
      } else {
        paramString12 = "0";
      }
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, newEntry("isX5Enabled", paramString12), newEntry("app_status", String.valueOf(paramMiniAppConfig.config.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppConfig.config.via)) {
        localArrayList.add(newEntry("via", paramMiniAppConfig.config.via));
      }
    }
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.baseLibInfo != null)) {
      localArrayList.add(newEntry("app_js_version", paramMiniAppConfig.baseLibInfo.baseLibVersion));
    }
    paramString12 = newEntry("path", paramString1);
    paramString1 = str1;
    if (paramString2 != null) {
      paramString1 = paramString2;
    }
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { paramString12, newEntry("refer", paramString1), newEntry("actiontype", String.valueOf(paramString3)), newEntry("sub_actiontype", String.valueOf(paramString4)), newEntry("reserves_action", String.valueOf(paramString5)), newEntry("reserves2", String.valueOf(paramString6)), newEntry("reserves3", String.valueOf(paramString7)), newEntry("reserves4", String.valueOf(paramString8)), newEntry("reserves5", String.valueOf(paramString9)), newEntry("reserves6", String.valueOf(paramString10)), newEntry("app_type", String.valueOf(paramString11)) }));
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.launchParam.reportData))) {
      localArrayList.addAll(newReportEntries(paramMiniAppConfig.launchParam.reportData));
    }
    return localArrayList;
  }
  
  public static APP_REPORT_TRANSFER.StDataReportReq newDataReportReq(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = new APP_REPORT_TRANSFER.StDataReportReq();
    localStDataReportReq.dcdata.addAll(paramList);
    return localStDataReportReq;
  }
  
  public static REPORT.StDcReportReq newDcReportReq(List<REPORT.SingleDcData> paramList)
  {
    REPORT.StDcReportReq localStDcReportReq = new REPORT.StDcReportReq();
    localStDcReportReq.dcdata.addAll(paramList);
    return localStDcReportReq;
  }
  
  public static COMM.Entry newEntry(String paramString1, String paramString2)
  {
    COMM.Entry localEntry = new COMM.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static COMM.Entry newEntry(Map.Entry<String, String> paramEntry)
  {
    COMM.Entry localEntry = new COMM.Entry();
    if (paramEntry.getKey() != null) {
      localEntry.key.set((String)paramEntry.getKey());
    }
    if (paramEntry.getValue() != null) {
      localEntry.value.set((String)paramEntry.getValue());
    }
    return localEntry;
  }
  
  public static REPORT.StGameDcReportReq newGameCPReportReq(List<REPORT.SingleDcData> paramList)
  {
    REPORT.StGameDcReportReq localStGameDcReportReq = new REPORT.StGameDcReportReq();
    if (paramList != null) {
      localStGameDcReportReq.dcdata.addAll(paramList);
    }
    return localStGameDcReportReq;
  }
  
  public static List<COMM.Entry> newGenericEntries()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("device_platform", "android"), newEntry("device_maker", Build.MANUFACTURER), newEntry("device_model", Build.MODEL), newEntry("device_version", Build.VERSION.RELEASE), newEntry("network_type", getNetworkType()), newEntry("network_gateway_ip", ""), newEntry("network_ssid", NetworkUtil.getCurrentWifiSSID(CommonDataAdapter.a().a())) }));
    Object localObject = getLocation(CommonDataAdapter.a().a());
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length == 2) {
        localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("gps_x", localObject[0]), newEntry("gps_y", localObject[1]) }));
      }
    }
    return localArrayList;
  }
  
  public static List<COMM.Entry> newModeAndLocation(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("mode", String.valueOf(paramString1)), newEntry("location", String.valueOf(paramString2)) }));
    return localArrayList;
  }
  
  public static List<COMM.Entry> newQQqunInfoBusinessEntries(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("actiontype", String.valueOf(paramString1)), newEntry("sub_actiontype", String.valueOf(paramString2)), newEntry("reserves_action", String.valueOf(paramString3)), newEntry("reserves2", String.valueOf(paramString4)), newEntry("groupid", String.valueOf(paramString5)) }));
    return localArrayList;
  }
  
  public static List<COMM.Entry> newReportEntries(String paramString)
  {
    Object localObject = parseReportData(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramString.add(newEntry((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    return paramString;
  }
  
  public static REPORT.SingleDcData newSingleDcData(int paramInt, String paramString, List<COMM.Entry> paramList1, List<COMM.Entry> paramList2)
  {
    REPORT.SingleDcData localSingleDcData = new REPORT.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    localSingleDcData.type.set(paramString);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    return localSingleDcData;
  }
  
  public static REPORT.SingleDcData newSingleDcData(int paramInt, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    REPORT.SingleDcData localSingleDcData = new REPORT.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    localSingleDcData.type.set(paramString);
    if (paramMap1 != null)
    {
      paramString = paramMap1.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap1 = (Map.Entry)paramString.next();
        localSingleDcData.report_data.add(newEntry(paramMap1));
      }
    }
    if (paramMap2 != null)
    {
      paramString = paramMap2.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap1 = (Map.Entry)paramString.next();
        localSingleDcData.extinfo.add(newEntry(paramMap1));
      }
    }
    return localSingleDcData;
  }
  
  public static APP_REPORT_TRANSFER.SingleDcData newSingleReportData(int paramInt, List<COMM.Entry> paramList1, List<COMM.Entry> paramList2)
  {
    APP_REPORT_TRANSFER.SingleDcData localSingleDcData = new APP_REPORT_TRANSFER.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    return localSingleDcData;
  }
  
  public static REPORT.StThirdDcReportReq newThirdDcReportReq(List<REPORT.SingleDcData> paramList)
  {
    REPORT.StThirdDcReportReq localStThirdDcReportReq = new REPORT.StThirdDcReportReq();
    if (paramList != null) {
      localStThirdDcReportReq.dcdata.addAll(paramList);
    }
    return localStThirdDcReportReq;
  }
  
  public static List<COMM.Entry> newUserInfoEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("uin", String.valueOf(CommonDataAdapter.a().a())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis())), newEntry("qqversion", QUA.getQUA3()), newEntry("imei", MobileInfoUtil.getImei()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> newVersionEntries(MiniAppConfig paramMiniAppConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      COMM.Entry localEntry1 = newEntry("appid", paramMiniAppConfig.config.appId);
      COMM.Entry localEntry2 = newEntry("app_version", String.valueOf(paramMiniAppConfig.config.version));
      Object localObject2 = null;
      COMM.Entry localEntry3 = newEntry("app_classification", null);
      COMM.Entry localEntry4 = newEntry("app_tag", "");
      boolean bool = EnvUtils.isPkgDownloaded(paramMiniAppConfig);
      String str = "1";
      if (bool) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      COMM.Entry localEntry5 = newEntry("isPkgDownloaed", (String)localObject1);
      Object localObject1 = localObject2;
      if (paramMiniAppConfig != null) {
        localObject1 = paramMiniAppConfig.config;
      }
      if (EnvUtils.isX5Enabled((MiniAppInfo)localObject1)) {
        localObject1 = str;
      } else {
        localObject1 = "0";
      }
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, newEntry("isX5Enabled", (String)localObject1), newEntry("app_status", String.valueOf(paramMiniAppConfig.config.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppConfig.config.via)) {
        localArrayList.add(newEntry("via", paramMiniAppConfig.config.via));
      }
    }
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.baseLibInfo != null)) {
      localArrayList.add(newEntry("app_js_version", paramMiniAppConfig.baseLibInfo.baseLibVersion));
    }
    return localArrayList;
  }
  
  private static Map<String, String> parseReportData(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject2 = null;
    label178:
    String str1;
    if (!bool) {
      try
      {
        String[] arrayOfString = paramString.split("&");
        int j = arrayOfString.length;
        paramString = null;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str3 = arrayOfString[i];
            localObject2 = paramString;
            try
            {
              int k = str3.indexOf("=");
              localObject1 = paramString;
              if (k > 0)
              {
                localObject1 = paramString;
                localObject2 = paramString;
                if (k < str3.length() - 1)
                {
                  localObject2 = paramString;
                  String str2 = URLDecoder.decode(str3.substring(0, k), "UTF-8");
                  localObject2 = paramString;
                  str3 = URLDecoder.decode(str3.substring(k + 1), "UTF-8");
                  localObject1 = paramString;
                  if (paramString == null)
                  {
                    localObject2 = paramString;
                    localObject1 = new HashMap();
                  }
                  localObject2 = localObject1;
                  ((Map)localObject1).put(str2, str3);
                }
              }
              i += 1;
              paramString = (String)localObject1;
            }
            catch (Exception localException1)
            {
              paramString = (String)localObject2;
              break label178;
            }
          }
        }
        return paramString;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        QLog.e("MiniProgramReportHelper", 1, " parse reportData error.", localException2);
        str1 = paramString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReportHelper
 * JD-Core Version:    0.7.0.1
 */