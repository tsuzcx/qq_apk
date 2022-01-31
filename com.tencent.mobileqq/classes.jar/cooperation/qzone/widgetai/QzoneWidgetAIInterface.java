package cooperation.qzone.widgetai;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import awqm;
import babp;
import bace;
import bbee;
import bbmy;
import bfpj;
import bfpk;
import bfpr;
import bfqv;
import bftg;
import bgax;
import bgbf;
import bgbz;
import bgly;
import bgma;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import mpl;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class QzoneWidgetAIInterface
{
  public static final int MSG_WNS_HTTP_GET_DATA = 203;
  public static final String TAG = "QzoneWidgetAIInterface";
  private static HashMap<String, String> friNickNameMap = new HashMap();
  private static String version = "0";
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("needTranslucentBrowser")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        bfpr.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      bfpr.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      bfpr.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    bfpr.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public static int getAppId()
  {
    return AppSetting.a();
  }
  
  public static Application getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public static String getBuildNumber()
  {
    return "4370";
  }
  
  public static String getBuilderNumber()
  {
    return "100084";
  }
  
  public static String getCacheDir(String paramString)
  {
    return bftg.a(paramString);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static long getCpuFrequency()
  {
    return bfqv.a();
  }
  
  public static String getDeviceInfor()
  {
    return bfpj.a().c();
  }
  
  public static String getHtmlData(String paramString)
  {
    return bbee.c(paramString);
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
    return mpl.a();
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
    return bgbf.b();
  }
  
  public static String getPluginId()
  {
    return bgbf.b();
  }
  
  public static String getPluginVersion()
  {
    String str = bgbf.b();
    if (!str.equals("qzone_widgetai.apk")) {
      bgax.a(getContext(), new bgly(str));
    }
    for (;;)
    {
      return version;
      version = "2013 8.2.6";
    }
  }
  
  public static String getQUA3()
  {
    return bfpk.a();
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
    return babp.d() / 1048576L;
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
    return AppSetting.f();
  }
  
  public static String getVersionForHabo()
  {
    return bfpk.c();
  }
  
  public static void handlePreDownloadSingleFile(String paramString, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    bgma.a(paramString, paramQzoneOfflineCacheHelperCallBack);
  }
  
  public static void handlePreDownloadZip(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    bgma.a(paramString1, paramString2, paramQzoneZipCacheHelperCallBack);
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    return bbee.a(paramUri);
  }
  
  public static void init(long paramLong)
  {
    bftg.a(paramLong);
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return bace.a(paramString);
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
    return mpl.a(paramString);
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
    return bbmy.a(BaseApplication.getContext(), paramInt1, paramCharSequence, paramInt2).a(paramInt3);
  }
  
  public static void publishMood(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, long paramLong, HashMap<String, String> paramHashMap, String paramString2)
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
    bgbz.a().a("cmd.publishMood", localBundle, false);
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
    awqm.a(BaseApplication.getContext()).reportKVEvent(paramString, paramProperties);
  }
  
  public static void reportMTATime(String paramString, Properties paramProperties, int paramInt)
  {
    awqm.a(BaseApplication.getContext()).reportTimeKVEvent(paramString, paramProperties, paramInt);
  }
  
  public static void updateLruFileInNewThread(String paramString1, String paramString2)
  {
    bgma.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.QzoneWidgetAIInterface
 * JD-Core Version:    0.7.0.1
 */