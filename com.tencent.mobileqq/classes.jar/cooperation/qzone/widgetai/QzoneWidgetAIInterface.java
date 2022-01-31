package cooperation.qzone.widgetai;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import anmg;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class QzoneWidgetAIInterface
{
  public static final int MSG_WNS_HTTP_GET_DATA = 203;
  public static final String TAG = "QzoneWidgetAIInterface";
  private static HashMap friNickNameMap = new HashMap();
  private static String version = "0";
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("needTranslucentBrowser")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      QZoneHelper.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    QZoneHelper.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public static int getAppId()
  {
    return AppSetting.a;
  }
  
  public static Application getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public static String getBuildNumber()
  {
    return "3615";
  }
  
  public static String getBuilderNumber()
  {
    return "100084";
  }
  
  public static String getCacheDir(String paramString)
  {
    return CacheManager.a(paramString);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static long getCpuFrequency()
  {
    return QZoneVideoCommonUtils.a();
  }
  
  public static String getDeviceInfor()
  {
    return PlatformInfor.a().b();
  }
  
  public static String getHtmlData(String paramString)
  {
    return WebSoUtils.b(paramString);
  }
  
  public static int getIntConfig(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInt);
  }
  
  public static long getLongAccountUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  public static long getLongConfig(String paramString1, String paramString2, long paramLong)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong);
  }
  
  public static int getMultiProcInt(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(paramString, paramInt);
  }
  
  public static int getMultiProcInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin(paramString, paramInt, paramLong);
  }
  
  public static int getNetWorkType()
  {
    return HttpUtil.a();
  }
  
  public static int getNetworkType()
  {
    return NetworkState.getNetworkType();
  }
  
  public static String getNickname(String paramString)
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
  }
  
  public static String getPluginID()
  {
    return QZonePluginUtils.b();
  }
  
  public static String getPluginId()
  {
    return QZonePluginUtils.b();
  }
  
  public static String getPluginVersion()
  {
    String str = QZonePluginUtils.b();
    if (!str.equals("qzone_widgetai.apk")) {
      QZonePluginMangerHelper.a(getContext(), new anmg(str));
    }
    for (;;)
    {
      return version;
      version = "2013 7.6.8";
    }
  }
  
  public static String getQUA3()
  {
    return QUA.a();
  }
  
  public static AppRuntime getRuntime()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, paramInt);
  }
  
  public static String getStringConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public static long getSystemAvaialbeMemory()
  {
    return DeviceInfoUtil.e() / 1048576L;
  }
  
  public static String getUinString()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "0";
  }
  
  public static String getVersion()
  {
    return AppSetting.c();
  }
  
  public static String getVersionForHabo()
  {
    return QUA.c();
  }
  
  public static void handlePreDownloadSingleFile(String paramString, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    WidgetAIOfflineUtil.a(paramString, paramQzoneOfflineCacheHelperCallBack);
  }
  
  public static void handlePreDownloadZip(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    WidgetAIOfflineUtil.a(paramString1, paramString2, paramQzoneZipCacheHelperCallBack);
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    return WebSoUtils.a(paramUri);
  }
  
  public static void init(long paramLong)
  {
    CacheManager.a(paramLong);
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return FileUtils.a(paramString);
  }
  
  public static boolean isMobile()
  {
    return NetworkState.isMobile();
  }
  
  public static boolean isNetSupport()
  {
    return NetworkState.isNetSupport();
  }
  
  public static boolean isValidUrl(String paramString)
  {
    return HttpUtil.a(paramString);
  }
  
  public static boolean isWap()
  {
    return NetworkState.isWap();
  }
  
  public static boolean isWifiConn()
  {
    return NetworkState.isWifiConn();
  }
  
  public static Toast makeToast(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    return QQToast.a(BaseApplication.getContext(), paramInt1, paramCharSequence, paramInt2).a(paramInt3);
  }
  
  public static void publishMood(String paramString1, ArrayList paramArrayList1, int paramInt1, int paramInt2, ArrayList paramArrayList2, long paramLong, HashMap paramHashMap, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tagtitle", paramString2);
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.quality", paramInt1);
    localBundle.putInt("param.priv", paramInt2);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putLong("param.time", paramLong);
    localBundle.putSerializable("param.extMap", paramHashMap);
    RemoteHandleManager.a().a("cmd.publishMood", localBundle, false);
  }
  
  public static void report(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong3)
  {
    try
    {
      LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
      localLpReportInfo_pf00064.toUin = paramLong2;
      localLpReportInfo_pf00064.actionType = Integer.valueOf(paramString1).intValue();
      localLpReportInfo_pf00064.subactionType = Integer.valueOf(paramString2).intValue();
      localLpReportInfo_pf00064.reserves = Integer.valueOf(paramString3).intValue();
      localLpReportInfo_pf00064.networkType = paramInt;
      localLpReportInfo_pf00064.time = paramLong3;
      LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, true);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QzoneWidgetAIInterface", 1, QLog.getStackTraceString(paramString1));
    }
  }
  
  public static void reportMTA(String paramString, Properties paramProperties)
  {
    MTAReportController.a(BaseApplication.getContext()).reportKVEvent(paramString, paramProperties);
  }
  
  public static void reportMTATime(String paramString, Properties paramProperties, int paramInt)
  {
    MTAReportController.a(BaseApplication.getContext()).reportTimeKVEvent(paramString, paramProperties, paramInt);
  }
  
  public static void updateLruFileInNewThread(String paramString1, String paramString2)
  {
    WidgetAIOfflineUtil.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.QzoneWidgetAIInterface
 * JD-Core Version:    0.7.0.1
 */