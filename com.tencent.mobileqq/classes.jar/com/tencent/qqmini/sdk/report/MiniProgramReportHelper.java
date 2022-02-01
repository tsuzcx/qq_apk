package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StGameDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.EnvUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
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
  private static MiniAppInfo MINI_APP_CONFIG_FOR_PRELOAD;
  public static String PERF_LEVEL;
  public static final String PRELOAD_MINI_APP_ID = "0000000000";
  private static final String TAG = "MiniProgramReportHelper";
  private static String sDeviceInfo = null;
  
  static
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = "0000000000";
    MINI_APP_CONFIG_FOR_PRELOAD = localMiniAppInfo;
    MINI_APP_CONFIG_FOR_PRELOAD.launchParam.miniAppId = "0000000000";
  }
  
  public static void assignAppLaunchId(MiniAppInfo paramMiniAppInfo)
  {
    String str1 = getMiniAppIdSafely(paramMiniAppInfo);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = String.valueOf(System.currentTimeMillis());
      APP_ID_LAUNCH_ID_MAP.put(str1, str2);
      QMLog.i("MiniProgramReportHelper", "[mini] assignAppLaunchId [appId= " + str1 + "] [launchId=" + str2 + "]");
    }
    MINI_APP_CONFIG_FOR_PRELOAD = paramMiniAppInfo;
  }
  
  public static void checkShouldAssignPreloadLaunchId(int paramInt)
  {
    if ((paramInt == 605) || (paramInt == 1)) {
      APP_ID_LAUNCH_ID_MAP.put("0000000000", "0");
    }
  }
  
  public static void generateLaunchIdInMainProcess(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = getMiniAppIdSafely(paramMiniAppInfo);
    if (!TextUtils.isEmpty(paramMiniAppInfo))
    {
      String str = String.valueOf(System.currentTimeMillis());
      LAUNCH_ID_MAP_MAIN_PROCESS.put(paramMiniAppInfo, str);
      QMLog.e("MiniProgramReportHelper", "[mini] generateLaunchIdInMainProcess [appId= " + paramMiniAppInfo + "] [launchId=" + str);
    }
  }
  
  private static String getDeviceInfo()
  {
    if (!TextUtils.isEmpty(sDeviceInfo)) {
      return sDeviceInfo;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a=").append(Build.VERSION.SDK_INT).append("&mem=").append(getDeviceRamSize()).append("&mo=").append(getModelName());
    sDeviceInfo = localStringBuilder.toString();
    return sDeviceInfo;
  }
  
  private static long getDeviceRamSize()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)AppLoaderFactory.g().getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.totalMem / 1024L / 1024L;
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public static String getLaunchIdFromMainProcess(MiniAppInfo paramMiniAppInfo)
  {
    return (String)LAUNCH_ID_MAP_MAIN_PROCESS.get(getMiniAppIdSafely(paramMiniAppInfo));
  }
  
  public static String getLaunchIdFromMainProcess(String paramString)
  {
    return (String)LAUNCH_ID_MAP_MAIN_PROCESS.get(paramString);
  }
  
  private static String getMiniAppIdSafely(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam != null) {
        localObject1 = paramMiniAppInfo.launchParam.miniAppId;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramMiniAppInfo != null) {
        localObject2 = paramMiniAppInfo.appId;
      }
    }
    paramMiniAppInfo = (MiniAppInfo)localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      paramMiniAppInfo = "0000000000";
    }
    return paramMiniAppInfo;
  }
  
  private static String getModelName()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if ((str2 != null) && (str1 != null) && (str2.toLowerCase().startsWith(str1.toLowerCase()))) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  public static String getNetworkType()
  {
    String str = NetworkUtil.getNetWorkTypeByStr(AppLoaderFactory.g().getContext());
    if (str == null) {
      return "unknown";
    }
    return str.toLowerCase();
  }
  
  public static String launchIdForMiniAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    return (String)APP_ID_LAUNCH_ID_MAP.get(getMiniAppIdSafely(paramMiniAppInfo));
  }
  
  public static MiniAppInfo miniAppConfigForPreload()
  {
    return MINI_APP_CONFIG_FOR_PRELOAD;
  }
  
  public static List<COMM.Entry> newAppQualityEntries(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramMiniAppInfo = newAppQualityEntries(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, "", "", "", "", "");
    if (!QUAUtil.isQQApp()) {
      paramMiniAppInfo.addAll(newThirdSourceEntries());
    }
    return paramMiniAppInfo;
  }
  
  public static List<COMM.Entry> newAppQualityEntries(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    if (PERF_LEVEL == null) {
      PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
    }
    COMM.Entry localEntry1 = newEntry("uid", LoginManager.getInstance().getAccount());
    COMM.Entry localEntry2 = newEntry("appid", getMiniAppIdSafely(paramMiniAppInfo));
    paramString10 = newEntry("launchid", paramString10);
    label76:
    COMM.Entry localEntry3;
    label89:
    COMM.Entry localEntry4;
    label126:
    COMM.Entry localEntry5;
    COMM.Entry localEntry6;
    COMM.Entry localEntry7;
    label162:
    label221:
    COMM.Entry localEntry8;
    COMM.Entry localEntry9;
    COMM.Entry localEntry10;
    if (paramString2 != null)
    {
      paramString2 = newEntry("event", paramString2);
      paramString9 = newEntry("timestamp", paramString9);
      if (paramString1 == null) {
        break label615;
      }
      localEntry3 = newEntry("page", paramString1);
      if (paramString3 == null) {
        break label621;
      }
      paramString3 = newEntry("attachinfo", paramString3);
      localEntry4 = newEntry("appversion", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion());
      if (paramMiniAppInfo == null) {
        break label627;
      }
      paramString1 = paramMiniAppInfo.version;
      localEntry5 = newEntry("miniapp_version", paramString1);
      localEntry6 = newEntry("qua", QUAUtil.getPlatformQUA());
      localEntry7 = newEntry("sdk_version", QUAUtil.getQUA());
      if (paramString4 == null) {
        break label633;
      }
      paramString4 = newEntry("cmd", paramString4);
      paramString5 = newEntry("retcode", paramString5);
      paramString7 = newEntry("time_cost", paramString7);
      paramString8 = newEntry("third_url", paramString8);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.baseLibInfo == null)) {
        break label640;
      }
      paramString1 = paramMiniAppInfo.baseLibInfo.baseLibVersion;
      paramString1 = newEntry("baselib_version", paramString1);
      localEntry8 = newEntry("x5_version", String.valueOf(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion()));
      localEntry9 = newEntry("deviceinfo", getDeviceInfo());
      paramString6 = newEntry("app_type", paramString6);
      localEntry10 = newEntry("network_type", getNetworkType());
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label646;
      }
    }
    label640:
    label646:
    for (paramMiniAppInfo = String.valueOf(paramMiniAppInfo.launchParam.scene);; paramMiniAppInfo = "")
    {
      return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, paramString10, paramString2, paramString9, localEntry3, paramString3, localEntry4, localEntry5, localEntry6, localEntry7, paramString4, paramString5, paramString7, paramString8, paramString1, localEntry8, localEntry9, paramString6, localEntry10, newEntry("scene", paramMiniAppInfo), newEntry("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), newEntry("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), newEntry("source_uin_platform", QUAUtil.getLoginType()), newEntry("connect_openid", LoginManager.getInstance().getPayOpenId()), newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType())), newEntry("reverse1", paramString11), newEntry("reverse2", paramString12), newEntry("reverse3", paramString13), newEntry("reverse4", paramString14), newEntry("render_mode", paramString15), newEntry("busiType", PERF_LEVEL) }));
      paramString2 = "";
      break;
      label615:
      paramString1 = "";
      break label76;
      label621:
      paramString3 = "";
      break label89;
      label627:
      paramString1 = "";
      break label126;
      label633:
      paramString4 = "";
      break label162;
      paramString1 = "";
      break label221;
    }
  }
  
  public static List<COMM.Entry> newBaseBusinessEntries(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("actiontype", String.valueOf(paramString1)), newEntry("sub_actiontype", String.valueOf(paramString2)), newEntry("reserves_action", String.valueOf(paramString3)), newEntry("reserves2", String.valueOf(paramString4)), newEntry("reserves3", String.valueOf(paramString5)), newEntry("reserves4", String.valueOf(paramString6)), newEntry("reserves5", String.valueOf(paramString7)) }));
    return localArrayList;
  }
  
  public static List<COMM.Entry> newBusinessEntries(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      COMM.Entry localEntry1 = newEntry("launchid", paramString12);
      COMM.Entry localEntry2 = newEntry("appid", paramMiniAppInfo.appId);
      COMM.Entry localEntry3 = newEntry("app_version", String.valueOf(paramMiniAppInfo.version));
      COMM.Entry localEntry4 = newEntry("app_classification", null);
      COMM.Entry localEntry5 = newEntry("app_tag", "");
      if (!EnvUtils.isPkgDownloaded(paramMiniAppInfo)) {
        break label502;
      }
      paramString12 = "1";
      COMM.Entry localEntry6 = newEntry("isPkgDownloaed", paramString12);
      if (!EnvUtils.isX5Enabled(paramMiniAppInfo)) {
        break label509;
      }
      paramString12 = "1";
      label103:
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, newEntry("isX5Enabled", paramString12), newEntry("app_status", String.valueOf(paramMiniAppInfo.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppInfo.via)) {
        localArrayList.add(newEntry("via", paramMiniAppInfo.via));
      }
      if (paramMiniAppInfo.baseLibInfo != null) {
        localArrayList.add(newEntry("app_js_version", paramMiniAppInfo.baseLibInfo.baseLibVersion));
      }
    }
    paramString1 = newEntry("path", paramString1);
    if (QUAUtil.isQQMainApp()) {
      if (paramString2 == null) {}
    }
    for (;;)
    {
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { paramString1, newEntry("refer", paramString2), newEntry("actiontype", String.valueOf(paramString3)), newEntry("sub_actiontype", String.valueOf(paramString4)), newEntry("reserves_action", String.valueOf(paramString5)), newEntry("reserves2", String.valueOf(paramString6)), newEntry("reserves3", String.valueOf(paramString7)), newEntry("reserves4", String.valueOf(paramString8)), newEntry("reserves5", String.valueOf(paramString9)), newEntry("reserves6", String.valueOf(paramString10)), newEntry("app_type", String.valueOf(paramString11)), newEntry("sdk_version", QUAUtil.getQUA()) }));
      if (paramMiniAppInfo != null)
      {
        if ((paramMiniAppInfo.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.reportData))) {
          localArrayList.addAll(newReportEntries(paramMiniAppInfo.launchParam.reportData));
        }
        if ((paramMiniAppInfo.reportData != null) && (!TextUtils.isEmpty(paramMiniAppInfo.reportData))) {
          localArrayList.addAll(newReportEntries(paramMiniAppInfo.reportData));
        }
      }
      return localArrayList;
      label502:
      paramString12 = "0";
      break;
      label509:
      paramString12 = "0";
      break label103;
      paramString2 = "";
      continue;
      if (paramString2 != null) {
        paramString2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_" + paramString2;
      } else {
        paramString2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_1001";
      }
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
    ArrayList localArrayList = new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("device_platform", "android"), newEntry("device_maker", Build.MANUFACTURER), newEntry("device_model", Build.MODEL), newEntry("device_version", Build.VERSION.RELEASE), newEntry("network_type", getNetworkType()), newEntry("network_gateway_ip", ""), newEntry("network_ssid", NetworkUtil.getCurrentWifiSSID(AppLoaderFactory.g().getContext())) }));
    Object localObject = DeviceUtil.getLocation();
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length == 2) {
        localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("gps_x", localObject[0]), newEntry("gps_y", localObject[1]) }));
      }
    }
    return localArrayList;
  }
  
  public static List<COMM.Entry> newQQqunInfoBusinessEntries(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("actiontype", String.valueOf(paramString1)), newEntry("sub_actiontype", String.valueOf(paramString2)), newEntry("reserves_action", String.valueOf(paramString3)), newEntry("groupid", String.valueOf(paramString4)) }));
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
  
  public static List<COMM.Entry> newThirdSourceEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), newEntry("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), newEntry("source_uin_platform", QUAUtil.getLoginType()), newEntry("connect_openid", LoginManager.getInstance().getPayOpenId()), newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType())) }));
  }
  
  public static List<COMM.Entry> newUserInfoEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("uin", String.valueOf(LoginManager.getInstance().getAccount())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(System.currentTimeMillis())), newEntry("qqversion", QUAUtil.getPlatformQUA()), newEntry("imei", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getImei()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry("android_id", Settings.Secure.getString(AppLoaderFactory.g().getContext().getContentResolver(), "android_id")) }));
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
        QMLog.e("MiniProgramReportHelper", " parse reportData error.", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReportHelper
 * JD-Core Version:    0.7.0.1
 */