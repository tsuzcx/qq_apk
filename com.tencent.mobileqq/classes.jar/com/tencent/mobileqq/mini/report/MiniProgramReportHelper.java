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
import bhpc;
import biaq;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
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
      QLog.e("MiniProgramReportHelper", 1, "[mini] assignAppLaunchId [appId= " + str1 + "] [launchId=" + str2);
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
  
  public static String currentUrlFromAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.pageContainer != null))
    {
      paramAppBrandRuntime = paramAppBrandRuntime.pageContainer.getCurrentPage();
      if (paramAppBrandRuntime != null) {
        return paramAppBrandRuntime.getUrl();
      }
    }
    return null;
  }
  
  public static void generateLaunchIdInMainProcess(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = getMiniAppIdSafely(paramMiniAppConfig);
    if (!TextUtils.isEmpty(paramMiniAppConfig))
    {
      String str = String.valueOf(System.currentTimeMillis());
      LAUNCH_ID_MAP_MAIN_PROCESS.put(paramMiniAppConfig, str);
      QLog.e("MiniProgramReportHelper", 1, "[mini] generateLaunchIdInMainProcess [appId= " + paramMiniAppConfig + "] [launchId=" + str);
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
  
  private static String getMiniAppIdSafely(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppConfig != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppConfig.config != null) {
        localObject1 = paramMiniAppConfig.config.appId;
      }
    }
    paramMiniAppConfig = (MiniAppConfig)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramMiniAppConfig = "0000000000";
    }
    return paramMiniAppConfig;
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
      PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
    }
    COMM.Entry localEntry1 = newEntry("uid", String.valueOf(bhpc.a().a()));
    COMM.Entry localEntry2 = newEntry("appid", getMiniAppIdSafely(paramMiniAppConfig));
    paramString10 = newEntry("launchid", paramString10);
    label75:
    COMM.Entry localEntry3;
    label87:
    COMM.Entry localEntry4;
    label122:
    COMM.Entry localEntry5;
    COMM.Entry localEntry6;
    label145:
    label200:
    COMM.Entry localEntry7;
    COMM.Entry localEntry8;
    if (paramString2 != null)
    {
      paramString2 = newEntry("event", paramString2);
      paramString9 = newEntry("timestamp", paramString9);
      if (paramString1 == null) {
        break label460;
      }
      localEntry3 = newEntry("page", paramString1);
      if (paramString3 == null) {
        break label466;
      }
      paramString3 = newEntry("attachinfo", paramString3);
      localEntry4 = newEntry("appversion", "8.4.8.4810");
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label472;
      }
      paramString1 = paramMiniAppConfig.config.version;
      localEntry5 = newEntry("miniapp_version", paramString1);
      localEntry6 = newEntry("qua", QUA.getQUA3());
      if (paramString4 == null) {
        break label478;
      }
      paramString4 = newEntry("cmd", paramString4);
      paramString5 = newEntry("retcode", paramString5);
      paramString7 = newEntry("time_cost", paramString7);
      paramString8 = newEntry("third_url", paramString8);
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.baseLibInfo == null)) {
        break label485;
      }
      paramString1 = paramMiniAppConfig.baseLibInfo.baseLibVersion;
      paramString1 = newEntry("baselib_version", paramString1);
      localEntry7 = newEntry("x5_version", String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication())));
      paramString6 = newEntry("app_type", paramString6);
      localEntry8 = newEntry("network_type", getNetworkType());
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.launchParam == null)) {
        break label491;
      }
    }
    label460:
    label466:
    label472:
    label478:
    label485:
    label491:
    for (paramMiniAppConfig = String.valueOf(paramMiniAppConfig.launchParam.scene);; paramMiniAppConfig = "")
    {
      return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, paramString10, paramString2, paramString9, localEntry3, paramString3, localEntry4, localEntry5, localEntry6, paramString4, paramString5, paramString7, paramString8, paramString1, localEntry7, paramString6, localEntry8, newEntry("scene", paramMiniAppConfig), newEntry("reverse1", paramString11), newEntry("reverse2", paramString12), newEntry("reverse3", paramString13), newEntry("reverse4", paramString14), newEntry("busiType", PERF_LEVEL) }));
      paramString2 = "";
      break;
      paramString1 = "";
      break label75;
      paramString3 = "";
      break label87;
      paramString1 = "";
      break label122;
      paramString4 = "";
      break label145;
      paramString1 = "";
      break label200;
    }
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
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      COMM.Entry localEntry1 = newEntry("launchid", paramString12);
      COMM.Entry localEntry2 = newEntry("appid", paramMiniAppConfig.config.appId);
      COMM.Entry localEntry3 = newEntry("app_version", String.valueOf(paramMiniAppConfig.config.version));
      COMM.Entry localEntry4 = newEntry("app_classification", null);
      COMM.Entry localEntry5 = newEntry("app_tag", "");
      if (!EnvUtils.isPkgDownloaded(paramMiniAppConfig)) {
        break label486;
      }
      paramString12 = "1";
      COMM.Entry localEntry6 = newEntry("isPkgDownloaed", paramString12);
      if (paramMiniAppConfig == null) {
        break label493;
      }
      paramString12 = paramMiniAppConfig.config;
      label112:
      if (!EnvUtils.isX5Enabled(paramString12)) {
        break label499;
      }
      paramString12 = "1";
      label125:
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, newEntry("isX5Enabled", paramString12), newEntry("app_status", String.valueOf(paramMiniAppConfig.config.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppConfig.config.via)) {
        localArrayList.add(newEntry("via", paramMiniAppConfig.config.via));
      }
    }
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.baseLibInfo != null)) {
      localArrayList.add(newEntry("app_js_version", paramMiniAppConfig.baseLibInfo.baseLibVersion));
    }
    paramString1 = newEntry("path", paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { paramString1, newEntry("refer", paramString2), newEntry("actiontype", String.valueOf(paramString3)), newEntry("sub_actiontype", String.valueOf(paramString4)), newEntry("reserves_action", String.valueOf(paramString5)), newEntry("reserves2", String.valueOf(paramString6)), newEntry("reserves3", String.valueOf(paramString7)), newEntry("reserves4", String.valueOf(paramString8)), newEntry("reserves5", String.valueOf(paramString9)), newEntry("reserves6", String.valueOf(paramString10)), newEntry("app_type", String.valueOf(paramString11)) }));
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.launchParam.reportData))) {
        localArrayList.addAll(newReportEntries(paramMiniAppConfig.launchParam.reportData));
      }
      return localArrayList;
      label486:
      paramString12 = "0";
      break;
      label493:
      paramString12 = null;
      break label112;
      label499:
      paramString12 = "0";
      break label125;
      paramString2 = "";
    }
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
    ArrayList localArrayList = new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("device_platform", "android"), newEntry("device_maker", Build.MANUFACTURER), newEntry("device_model", Build.MODEL), newEntry("device_version", Build.VERSION.RELEASE), newEntry("network_type", getNetworkType()), newEntry("network_gateway_ip", ""), newEntry("network_ssid", NetworkUtil.getCurrentWifiSSID(bhpc.a().a())) }));
    Object localObject = biaq.f();
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length == 2) {
        localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("gps_x", localObject[0]), newEntry("gps_y", localObject[1]) }));
      }
    }
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
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("uin", String.valueOf(bhpc.a().a())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis())), newEntry("qqversion", QUA.getQUA3()), newEntry("imei", biaq.c()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry("android_id", Settings.Secure.getString(bhpc.a().a().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> newVersionEntries(MiniAppConfig paramMiniAppConfig)
  {
    ArrayList localArrayList = new ArrayList();
    COMM.Entry localEntry1;
    COMM.Entry localEntry2;
    COMM.Entry localEntry3;
    COMM.Entry localEntry4;
    COMM.Entry localEntry5;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      localEntry1 = newEntry("appid", paramMiniAppConfig.config.appId);
      localEntry2 = newEntry("app_version", String.valueOf(paramMiniAppConfig.config.version));
      localEntry3 = newEntry("app_classification", null);
      localEntry4 = newEntry("app_tag", "");
      if (!EnvUtils.isPkgDownloaded(paramMiniAppConfig)) {
        break label244;
      }
      localObject = "1";
      localEntry5 = newEntry("isPkgDownloaed", (String)localObject);
      if (paramMiniAppConfig == null) {
        break label250;
      }
      localObject = paramMiniAppConfig.config;
      label98:
      if (!EnvUtils.isX5Enabled((MiniAppInfo)localObject)) {
        break label255;
      }
    }
    label244:
    label250:
    label255:
    for (Object localObject = "1";; localObject = "0")
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, newEntry("isX5Enabled", (String)localObject), newEntry("app_status", String.valueOf(paramMiniAppConfig.config.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppConfig.config.via)) {
        localArrayList.add(newEntry("via", paramMiniAppConfig.config.via));
      }
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.baseLibInfo != null)) {
        localArrayList.add(newEntry("app_js_version", paramMiniAppConfig.baseLibInfo.baseLibVersion));
      }
      return localArrayList;
      localObject = "0";
      break;
      localObject = null;
      break label98;
    }
  }
  
  private static Map<String, String> parseReportData(String paramString)
  {
    int i = 0;
    String str1 = null;
    localObject1 = null;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = str1;
      try
      {
        String[] arrayOfString = paramString.split("&");
        localObject1 = str1;
        int j = arrayOfString.length;
        for (paramString = (String)localObject2;; paramString = (String)localObject2)
        {
          localObject1 = paramString;
          if (i >= j) {
            break;
          }
          String str2 = arrayOfString[i];
          localObject1 = paramString;
          int k = str2.indexOf("=");
          localObject2 = paramString;
          if (k > 0)
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (k < str2.length() - 1)
            {
              localObject1 = paramString;
              str1 = URLDecoder.decode(str2.substring(0, k), "UTF-8");
              localObject1 = paramString;
              str2 = URLDecoder.decode(str2.substring(k + 1), "UTF-8");
              localObject2 = paramString;
              if (paramString == null)
              {
                localObject1 = paramString;
                localObject2 = new HashMap();
              }
              localObject1 = localObject2;
              ((Map)localObject2).put(str1, str2);
            }
          }
          i += 1;
        }
        return localObject1;
      }
      catch (Exception paramString)
      {
        QLog.e("MiniProgramReportHelper", 1, " parse reportData error.", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReportHelper
 * JD-Core Version:    0.7.0.1
 */