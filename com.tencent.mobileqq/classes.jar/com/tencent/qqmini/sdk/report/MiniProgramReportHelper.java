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
  
  private static String adjustRefer(String paramString)
  {
    if ((!QUAUtil.isQQMainApp()) && (!QUAUtil.isTimApp()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName());
      localStringBuilder.append("_");
      if (paramString == null) {
        paramString = "1001";
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static void assignAppLaunchId(MiniAppInfo paramMiniAppInfo)
  {
    String str1 = getMiniAppIdSafely(paramMiniAppInfo);
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = String.valueOf(System.currentTimeMillis());
      APP_ID_LAUNCH_ID_MAP.put(str1, str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mini] assignAppLaunchId [appId= ");
      localStringBuilder.append(str1);
      localStringBuilder.append("] [launchId=");
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      QMLog.i("MiniProgramReportHelper", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mini] generateLaunchIdInMainProcess [appId= ");
      localStringBuilder.append(paramMiniAppInfo);
      localStringBuilder.append("] [launchId=");
      localStringBuilder.append(str);
      QMLog.e("MiniProgramReportHelper", localStringBuilder.toString());
    }
  }
  
  private static String getDeviceInfo()
  {
    if (!TextUtils.isEmpty(sDeviceInfo)) {
      return sDeviceInfo;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a=");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("&mem=");
    localStringBuilder.append(getDeviceRamSize());
    localStringBuilder.append("&mo=");
    localStringBuilder.append(getModelName());
    sDeviceInfo = localStringBuilder.toString();
    return sDeviceInfo;
  }
  
  private static long getDeviceRamSize()
  {
    if (Build.VERSION.SDK_INT >= 16) {
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
        QMLog.e("MiniProgramReportHelper", "getDeviceRamSize exception", localException);
      }
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
    String str2;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      str2 = paramMiniAppInfo.launchParam.miniAppId;
    } else {
      str2 = null;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramMiniAppInfo != null) {
        str1 = paramMiniAppInfo.appId;
      }
    }
    paramMiniAppInfo = str1;
    if (TextUtils.isEmpty(str1)) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(" ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
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
    COMM.Entry localEntry5 = newEntry("appversion", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion());
    if (paramMiniAppInfo != null) {
      paramString1 = paramMiniAppInfo.version;
    } else {
      paramString1 = "";
    }
    COMM.Entry localEntry6 = newEntry("miniapp_version", paramString1);
    COMM.Entry localEntry7 = newEntry("qua", QUAUtil.getPlatformQUA());
    COMM.Entry localEntry8 = newEntry("sdk_version", QUAUtil.getQUA());
    if (paramString4 == null) {
      paramString4 = "";
    }
    paramString4 = newEntry("cmd", paramString4);
    paramString5 = newEntry("retcode", paramString5);
    paramString7 = newEntry("time_cost", paramString7);
    paramString8 = newEntry("third_url", paramString8);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.baseLibInfo != null)) {
      paramString1 = paramMiniAppInfo.baseLibInfo.baseLibVersion;
    } else {
      paramString1 = "";
    }
    COMM.Entry localEntry9 = newEntry("baselib_version", paramString1);
    COMM.Entry localEntry10 = newEntry("x5_version", String.valueOf(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion()));
    COMM.Entry localEntry11 = newEntry("deviceinfo", getDeviceInfo());
    paramString6 = newEntry("app_type", paramString6);
    COMM.Entry localEntry12 = newEntry("network_type", getNetworkType());
    paramString1 = paramString10;
    if (paramMiniAppInfo != null)
    {
      paramString1 = paramString10;
      if (paramMiniAppInfo.launchParam != null) {
        paramString1 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      }
    }
    return new ArrayList(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, paramString2, paramString9, localEntry4, paramString3, localEntry5, localEntry6, localEntry7, localEntry8, paramString4, paramString5, paramString7, paramString8, localEntry9, localEntry10, localEntry11, paramString6, localEntry12, newEntry("scene", paramString1), newEntry("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), newEntry("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), newEntry("source_uin_platform", QUAUtil.getLoginType()), newEntry("connect_openid", LoginManager.getInstance().getPayOpenId()), newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType())), newEntry("reverse1", paramString11), newEntry("reverse2", paramString12), newEntry("reverse3", paramString13), newEntry("reverse4", paramString14), newEntry("render_mode", paramString15), newEntry("busiType", PERF_LEVEL) }));
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
      boolean bool = EnvUtils.isPkgDownloaded(paramMiniAppInfo);
      String str = "1";
      if (bool) {
        paramString12 = "1";
      } else {
        paramString12 = "0";
      }
      COMM.Entry localEntry6 = newEntry("isPkgDownloaed", paramString12);
      if (EnvUtils.isX5Enabled(paramMiniAppInfo)) {
        paramString12 = str;
      } else {
        paramString12 = "0";
      }
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, newEntry("isX5Enabled", paramString12), newEntry("app_status", String.valueOf(paramMiniAppInfo.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppInfo.via)) {
        localArrayList.add(newEntry("via", paramMiniAppInfo.via));
      }
      if (paramMiniAppInfo.baseLibInfo != null) {
        localArrayList.add(newEntry("app_js_version", paramMiniAppInfo.baseLibInfo.baseLibVersion));
      }
    }
    localArrayList.addAll(Arrays.asList(new COMM.Entry[] { newEntry("path", paramString1), newEntry("refer", adjustRefer(paramString2)), newEntry("actiontype", String.valueOf(paramString3)), newEntry("sub_actiontype", String.valueOf(paramString4)), newEntry("reserves_action", String.valueOf(paramString5)), newEntry("reserves2", String.valueOf(paramString6)), newEntry("reserves3", String.valueOf(paramString7)), newEntry("reserves4", String.valueOf(paramString8)), newEntry("reserves5", String.valueOf(paramString9)), newEntry("reserves6", String.valueOf(paramString10)), newEntry("app_type", String.valueOf(paramString11)), newEntry("sdk_version", QUAUtil.getQUA()) }));
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
  
  public static List<COMM.Entry> newThirdSourceEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("source_app", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId()), newEntry("source_version", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion()), newEntry("source_uin_platform", QUAUtil.getLoginType()), newEntry("connect_openid", LoginManager.getInstance().getPayOpenId()), newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType())) }));
  }
  
  public static List<COMM.Entry> newUserInfoEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { newEntry("uin", String.valueOf(LoginManager.getInstance().getAccount())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(System.currentTimeMillis())), newEntry("qqversion", QUAUtil.getPlatformQUA()), newEntry("imei", ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getImei()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry("android_id", Settings.Secure.getString(AppLoaderFactory.g().getContext().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> newVersionEntries(MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      COMM.Entry localEntry1 = newEntry("appid", paramMiniAppInfo.appId);
      COMM.Entry localEntry2 = newEntry("app_version", String.valueOf(paramMiniAppInfo.version));
      COMM.Entry localEntry3 = newEntry("app_classification", null);
      COMM.Entry localEntry4 = newEntry("app_tag", "");
      boolean bool = EnvUtils.isPkgDownloaded(paramMiniAppInfo);
      String str2 = "1";
      String str1;
      if (bool) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      COMM.Entry localEntry5 = newEntry("isPkgDownloaed", str1);
      if (EnvUtils.isX5Enabled(paramMiniAppInfo)) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localArrayList.addAll(Arrays.asList(new COMM.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, newEntry("isX5Enabled", str1), newEntry("app_status", String.valueOf(paramMiniAppInfo.verType)) }));
      if (!TextUtils.isEmpty(paramMiniAppInfo.via)) {
        localArrayList.add(newEntry("via", paramMiniAppInfo.via));
      }
      if (paramMiniAppInfo.baseLibInfo != null) {
        localArrayList.add(newEntry("app_js_version", paramMiniAppInfo.baseLibInfo.baseLibVersion));
      }
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
        QMLog.e("MiniProgramReportHelper", " parse reportData error.", localException2);
        str1 = paramString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReportHelper
 * JD-Core Version:    0.7.0.1
 */