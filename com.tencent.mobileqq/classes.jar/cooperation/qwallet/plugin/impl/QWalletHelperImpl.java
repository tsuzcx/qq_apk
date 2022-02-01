package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.impl.QWalletPrivacyUtils;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.qwallet.report.IVACDReportService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.utils.QWalletPerTrace;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.QQDeviceInfo;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletLoadingDialog;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;
import cooperation.qwallet.plugin.QWalletPluginProxyService;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletHelperImpl
  implements IQWalletHelper
{
  private static final String APPINFO_MATCH_PARAM = "qqwallet_appinfo=";
  public static final String FILE_PRECONNECT_NAME = "pre_connect";
  public static final String KEY_PRECONNECT_LAST_TIME = "pre_connect_last_time";
  private static final String TAG = "QWalletHelperImpl";
  public static final String TYPE_PRECONNECT_M = "type_mqq_and_myun";
  private static byte[] iv = { 7, 2, 8, 9, 1, 6, 5, 3 };
  public static long lastTime = 0L;
  private static boolean mIsRefreshHome = true;
  public static String mQWalletExternalPath = "";
  public static String mQWalletInternalPath = "";
  private static long qLaunchTime;
  public static Set<String> sBuiltInActPayPkgs = new HashSet();
  private static HashMap<String, String> sPublicAccWhiteMap;
  
  static
  {
    sBuiltInActPayPkgs.add("com.tencent.mtt");
    sPublicAccWhiteMap = null;
    lastTime = -1L;
  }
  
  private static void addExtraForQvipPayWalletAct(Context paramContext, AppRuntime paramAppRuntime, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppRuntime != null)
    {
      if (paramIntent == null) {
        return;
      }
      String str = paramAppRuntime.getCurrentAccountUin();
      Object localObject = paramAppRuntime.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
      localStringBuilder.append(str);
      localObject = ((MobileQQ)localObject).getProperty(localStringBuilder.toString());
      paramIntent.putExtra("QWalletExtra.Account.Uin", paramAppRuntime.getCurrentAccountUin());
      paramIntent.putExtra("QWalletExtra.Account.NickName", (String)localObject);
      paramIntent.putExtra("QWalletExtra.MQQ.APPID", AppSetting.a());
      paramIntent.putExtra("QWalletExtra.MQQ.GUID", NetConnInfoCenter.GUID);
      paramIntent.putExtra("QWalletExtra.MQQ.Receiver", QWalletResultReceiver.getInstance());
      paramIntent.putExtra("QWalletExtra.Plugin.isloading", paramBoolean1);
      paramIntent.putExtra("QWalletExtra.Plugin.isRefreshHome", mIsRefreshHome);
      mIsRefreshHome = false;
      if (PatternLockUtils.isPatternLockOpened(paramContext, str))
      {
        paramIntent.putExtra("pluginsdk_is_Use_QWallet_PatternLock", true);
        paramIntent.putExtra("pluginsdk_is_QWallet_PLock_Bg_interval_time", PatternLockUtils.getForgroundIntervalTime(paramContext, str));
      }
      if (paramBoolean2)
      {
        if (!BaseGesturePWDUtil.getAppForground(paramContext)) {
          paramBoolean1 = PatternLockUtils.isPatternLockOpened(paramContext, str);
        } else {
          paramBoolean1 = PatternLockUtils.isNeedOpenPatternLock(paramContext, str);
        }
        paramIntent.putExtra("is_need_open_pattern_lock", paramBoolean1);
        if (paramBoolean1) {
          try
          {
            paramAppRuntime = new Intent();
            paramAppRuntime.setAction("com.tencent.mobileqq.gestureunlock");
            paramAppRuntime.putExtra("timeid", System.currentTimeMillis());
            paramContext.sendBroadcast(paramAppRuntime);
            return;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  private static void addWalletEntryConfig(Intent paramIntent, BaseQQAppInterface paramBaseQQAppInterface)
  {
    ArrayList localArrayList = parseTabsConfig(paramBaseQQAppInterface);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      paramIntent.putExtra("entry_tab_info", localArrayList);
    }
    paramBaseQQAppInterface = parseExtraConfig(paramBaseQQAppInterface);
    if (paramBaseQQAppInterface != null) {
      paramIntent.putExtra("entry_extra_config", paramBaseQQAppInterface);
    }
  }
  
  public static boolean compare(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = paramString1.toCharArray();
      paramString2 = paramString2.toCharArray();
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          return false;
        }
        int k = paramString1.length;
        if (k != paramString2.length) {
          return false;
        }
        int i = 0;
        while (i < k)
        {
          if (paramString2[i] != paramString1[i])
          {
            int j = 0;
            while (j < 6)
            {
              if (new char[] { 97, 98, 99, 100, 101, 102 }[j] == paramString2[i]) {
                if (new char[] { 65, 66, 67, 68, 69, 70 }[j] != paramString1[i]) {
                  return false;
                }
              }
              j += 1;
            }
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public static AppRuntime createVfcPluginAppInterface(Application paramApplication, String paramString)
  {
    if (paramApplication != null) {
      if (paramString == null) {
        return null;
      }
    }
    try
    {
      try
      {
        paramString = Class.forName("com.vfuchongcontrol.qq.VfuchongAppInterface");
        paramApplication = paramString;
      }
      catch (Exception paramApplication)
      {
        break label103;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      label26:
      break label26;
    }
    paramString = PluginStatic.getOrCreateClassLoader(paramApplication, "vfc_plugin.apk");
    paramApplication = paramString.loadClass("com.vfuchongcontrol.qq.VfuchongAppInterface");
    BasicClassTypeUtil.setClassLoader(true, paramString);
    if (paramApplication == null)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.qwallet.", 2, "*createVfctAppInterface load class fail");
        return null;
      }
    }
    else
    {
      paramApplication = paramApplication.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramApplication != null) && ((paramApplication instanceof AppRuntime)))
      {
        paramApplication = (AppRuntime)paramApplication;
        return paramApplication;
        label103:
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("*createVfcAppInterface exception:");
          paramString.append(paramApplication.toString());
          QLog.e("Q.qwallet.", 2, paramString.toString());
        }
      }
      return null;
    }
    return null;
  }
  
  public static long dateToStamp(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  private static String getAppInfoByUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.toLowerCase().indexOf("qqwallet_appinfo=");
      if (i != -1)
      {
        int k = i + 17;
        int j = paramString.indexOf('&', k);
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
        return paramString.substring(k, i);
      }
    }
    return "";
  }
  
  public static AppRuntime getAppRuntime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static long getLastUpdateToopMemberNumTime(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    return localBaseApplication.getSharedPreferences("qwallet_multi", i).getLong(paramString, 0L);
  }
  
  public static int getProcessPid(Context paramContext, String paramString)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (paramString.compareTo(localRunningAppProcessInfo.processName) == 0) {
            return localRunningAppProcessInfo.pid;
          }
        }
      }
    }
    return -1;
  }
  
  public static boolean getSyncPatternLockState(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("qwallet_patternlock", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_need_sync");
    localStringBuilder.append(paramString);
    boolean bool = paramContext.getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getSyncPatternLockState.uin=");
      paramContext.append(paramString);
      paramContext.append(",isNeedSync=");
      paramContext.append(bool);
      QLog.d("Q.qwallet.pay", 2, paramContext.toString());
    }
    return bool;
  }
  
  private static void gotoQWalletAct(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, long paramLong, boolean paramBoolean, QWalletLoadingDialog paramQWalletLoadingDialog)
  {
    if (paramQBaseActivity != null)
    {
      if (paramBaseQQAppInterface == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("userQqResources", 1);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("QWallet.load.beginTime", qLaunchTime);
      localIntent.putExtra("QWalletExtra.isFling", true);
      if (paramLong != 0L) {
        localIntent.putExtra("report_seq", paramLong);
      }
      addWalletEntryConfig(localIntent, paramBaseQQAppInterface);
      localIntent.putExtra("feeds_tab_redpoint", hasShowRedPoint(paramBaseQQAppInterface));
      localIntent.putExtra("is_from_qqsettingme", paramBoolean);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
      if (paramQWalletLoadingDialog != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      addExtraForQvipPayWalletAct(paramQBaseActivity, paramBaseQQAppInterface, localIntent, paramBoolean, true);
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).IPluginManager$openActivityForResult(paramQBaseActivity, localIntent, paramQWalletLoadingDialog);
      if (paramLong != 0L) {
        VACDReportUtil.a(paramLong, null, "plugin_begin", null, 0, null);
      }
    }
  }
  
  public static boolean hasShowRedPoint(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null) {
      return false;
    }
    return ((IQWalletRedService)paramBaseQQAppInterface.getRuntimeService(IQWalletRedService.class)).getShowInfo("4001").a;
  }
  
  private static boolean isCurrTaskNotValid(Activity paramActivity)
  {
    boolean bool;
    try
    {
      if ((MobileQQ.sMobileQQ.getAppRuntime(null) instanceof BaseQQAppInterface))
      {
        bool = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).isSplashNotExist();
        if (!QLog.isColorLevel()) {
          return bool;
        }
        paramActivity = new StringBuilder();
        paramActivity.append("isCurrTaskNotValid, isSplashNotExist=");
        paramActivity.append(bool);
        QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, paramActivity.toString());
        return bool;
      }
      paramActivity = ((ActivityManager)paramActivity.getSystemService("activity")).getRunningTasks(1);
      if ((paramActivity != null) && (paramActivity.size() > 0) && (paramActivity.get(0) != null))
      {
        int i = ((ActivityManager.RunningTaskInfo)paramActivity.get(0)).numActivities;
        if (i >= 2) {
          return false;
        }
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return true;
    return bool;
  }
  
  private static boolean isForePay(Bundle paramBundle)
  {
    return paramBundle.getInt("launch_type", 0) == 0;
  }
  
  private static boolean isFromDiffTaskAffinity(Activity paramActivity)
  {
    try
    {
      List localList = ((ActivityManager)paramActivity.getSystemService("activity")).getRunningTasks(1);
      if ((localList != null) && (localList.size() > 0) && (localList.get(0) != null) && (((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity != null))
      {
        if (((ActivityManager.RunningTaskInfo)localList.get(0)).id != paramActivity.getTaskId()) {
          return true;
        }
        Object localObject = ((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity;
        paramActivity = paramActivity.getPackageManager().getActivityInfo((ComponentName)localObject, 128).taskAffinity;
        localObject = MobileQQ.getContext().getApplicationInfo().taskAffinity;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isFromDiffTaskAffinity, baseTask=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("reqTask=");
          localStringBuilder.append(paramActivity);
          localStringBuilder.append(", numA:");
          localStringBuilder.append(((ActivityManager.RunningTaskInfo)localList.get(0)).numActivities);
          QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, localStringBuilder.toString());
        }
        boolean bool = ((String)localObject).equals(paramActivity);
        if (bool) {
          return false;
        }
      }
    }
    catch (Throwable paramActivity)
    {
      QLog.e("Q.qwallet.pay.QWalletPayBridge", 2, paramActivity.getMessage());
    }
    return true;
  }
  
  private static boolean isFromOnlyActScene(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("comeForm", 0);
      if (i == 9) {
        return true;
      }
      if (i == 4)
      {
        paramBundle = paramBundle.getString("packageName");
        if (!TextUtils.isEmpty(paramBundle))
        {
          Object localObject = QWalletTools.a();
          if (localObject != null)
          {
            localObject = (IQWalletConfigService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletConfigService.class, "");
            if (localObject != null)
            {
              localObject = ((IQWalletConfigService)localObject).getArray("common", new String[] { "act_pay_pkgs" });
              if (localObject != null)
              {
                i = 0;
                while (i < ((JSONArray)localObject).length())
                {
                  if (TextUtils.equals(paramBundle, ((JSONArray)localObject).optString(i))) {
                    return true;
                  }
                  i += 1;
                }
                i = 1;
                break label128;
              }
            }
          }
          i = 0;
          label128:
          if ((i == 0) && (sBuiltInActPayPkgs.contains(paramBundle))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean isFromSpecifyModel()
  {
    try
    {
      String str = Build.MANUFACTURER;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      boolean bool = str.equals("360");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNeedPreConnect(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre_connect");
    localStringBuilder.append(paramString1);
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
    paramString1 = new StringBuilder();
    paramString1.append("pre_connect_last_time");
    paramString1.append(paramString2);
    long l2 = paramContext.getLong(paramString1.toString(), 0L);
    if (TimeUnit.MILLISECONDS.toSeconds(l1 - l2) < 120000L) {
      return false;
    }
    paramContext = paramContext.edit();
    paramString1 = new StringBuilder();
    paramString1.append("pre_connect_last_time");
    paramString1.append(paramString2);
    paramContext.putLong(paramString1.toString(), l1);
    paramContext.commit();
    return true;
  }
  
  public static boolean isNeedUpdateTroopMemberNum(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - getLastUpdateToopMemberNumTime(paramString) >= 1800000L) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isPhoneRooted()
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "/system/bin/";
    arrayOfString[1] = "/system/xbin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append("su");
        boolean bool = new File(localStringBuilder.toString()).exists();
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isValidUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      int i = paramString.indexOf("?") + 1;
      bool1 = bool2;
      String str2 = paramString.substring(0, i - 1);
      bool1 = bool2;
      int j = paramString.indexOf("#") + 1;
      bool1 = bool2;
      String str1 = paramString.substring(i + 2, j - 1);
      bool1 = bool2;
      paramString = paramString.substring(j, paramString.length());
      bool1 = bool2;
      StringBuffer localStringBuffer = new StringBuffer();
      bool1 = bool2;
      localStringBuffer.append(str2);
      bool1 = bool2;
      localStringBuffer.append("#");
      bool1 = bool2;
      localStringBuffer.append(paramString);
      bool1 = bool2;
      localStringBuffer.append("akT!Y#9W");
      bool1 = bool2;
      paramString = QWalletHelperDelegate.hexdigest(localStringBuffer.toString()).substring(0, 4);
      bool1 = bool2;
      bool2 = paramString.equals(str1);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        bool2 = compare(paramString, str1);
        return bool2;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return bool1;
  }
  
  public static void launchPayBridgeService(Context paramContext, AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if ((paramContext != null) && (paramAppRuntime != null))
    {
      if (paramBundle == null) {
        return;
      }
      Intent localIntent = new Intent(MobileQQ.sMobileQQ, QWalletPluginProxyService.class);
      localIntent.putExtra("QWalletExtra.PayBridge.PayBundle", paramBundle);
      localIntent.putExtra("QWalletExtra.PayBridge.PayTimeStart", System.currentTimeMillis());
      boolean bool1 = true;
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("uin", paramAppRuntime.getCurrentAccountUin());
      localIntent.putExtra("pluginsdk_disable_PatternLock", true);
      Object localObject = (TicketManager)paramAppRuntime.getManager(2);
      String str = null;
      if (localObject != null) {
        localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getCurrentAccountUin());
      } else {
        localObject = null;
      }
      localIntent.putExtra("qqskey", (String)localObject);
      localObject = str;
      if (paramBundle.containsKey("tag")) {
        localObject = (String)paramBundle.get("tag");
      }
      if ((!"graphb".equals(localObject)) && (QWalletHelperDelegate.graphbSpeedEnable)) {
        localIntent.putExtra("useSkinEngine", true);
      }
      localIntent.putExtra("userQqResources", 1);
      boolean bool2 = paramBundle.containsKey("entry");
      str = "";
      if (bool2) {
        localObject = (String)paramBundle.get("entry");
      } else {
        localObject = "";
      }
      if (paramBundle.containsKey("viewParam")) {
        str = (String)paramBundle.get("viewParam");
      }
      if ((!"2".equals(localObject)) || (!"10".equals(str))) {
        bool1 = false;
      }
      addExtraForQvipPayWalletAct(paramContext, paramAppRuntime, localIntent, false, bool1);
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).IPluginManager$launchPluginService(paramContext, localIntent, paramBundle);
    }
  }
  
  public static void launchVfcPlugin(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).launchVfcPlugin(paramQBaseActivity, paramBaseQQAppInterface, paramString1, paramString2, paramString3);
  }
  
  public static JSONObject loadUnifiedConfig(Context paramContext)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (paramContext != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getFilesDir());
      ((StringBuilder)localObject2).append("/qb_tenpay_unified_config");
      localObject2 = FileUtils.readFile(((StringBuilder)localObject2).toString());
      int i;
      if (localObject2 != null)
      {
        localObject2 = new String((byte[])localObject2);
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        i = 1;
      }
      else
      {
        i = 0;
        localObject1 = localObject4;
      }
      localObject3 = localObject1;
      if (i == 0)
      {
        paramContext = paramContext.getSharedPreferences("qb_tenpay_prefer", 0).edit();
        paramContext.putInt("qpay_unified_config_ver", -1);
        paramContext.commit();
        localObject3 = localObject1;
      }
    }
    return localObject3;
  }
  
  static Bundle parseExtraConfig(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
    if (paramBaseQQAppInterface != null) {
      localBundle.putInt("accountShowType", paramBaseQQAppInterface.getInt("common", 0, new String[] { "accountShow", "type" }));
    }
    return localBundle;
  }
  
  static ArrayList<HashMap<String, String>> parseTabsConfig(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Object localObject2 = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
    Object localObject3 = ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "url" });
    Object localObject4 = ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "beginTime" });
    String str = ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "endTime" });
    if ((((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isValidDate((String)localObject4, str)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      paramBaseQQAppInterface = new ArrayList();
      HashMap localHashMap = new HashMap();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((IQWalletConfigService)localObject2).getInt("wallet_entry", 0, new String[] { "showTab" }));
      ((StringBuilder)localObject1).append("");
      localHashMap.put("showTab", ((StringBuilder)localObject1).toString());
      localHashMap.put("name", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab0", "name" }));
      localHashMap.put("iconNormal", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab0", "icon_normal" }));
      localHashMap.put("iconSelect", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab0", "icon_select" }));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("name", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "name" }));
      ((HashMap)localObject1).put("iconNormal", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "icon_normal" }));
      ((HashMap)localObject1).put("iconSelect", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "icon_select" }));
      ((HashMap)localObject1).put("colorTop", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "color_top" }));
      ((HashMap)localObject1).put("colorBottom", ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "color_bottom" }));
      ((HashMap)localObject1).put("url", localObject3);
      ((HashMap)localObject1).put("beginTime", localObject4);
      ((HashMap)localObject1).put("endTime", str);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((IQWalletConfigService)localObject2).getInt("wallet_entry", 0, new String[] { "tab1", "action" }));
      ((StringBuilder)localObject3).append("");
      ((HashMap)localObject1).put("action", ((StringBuilder)localObject3).toString());
      localObject2 = ((IQWalletConfigService)localObject2).getString("wallet_entry", "", new String[] { "tab1", "search" });
      try
      {
        localObject4 = new JSONObject((String)localObject2);
        localObject2 = ((JSONObject)localObject4).getString("url");
        localObject3 = ((JSONObject)localObject4).getString("beginTime");
        localObject4 = ((JSONObject)localObject4).getString("endTime");
        if ((((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isValidDate((String)localObject3, (String)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          ((HashMap)localObject1).put("search_url", localObject2);
          ((HashMap)localObject1).put("search_beginTime", localObject3);
          ((HashMap)localObject1).put("search_endTime", localObject4);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramBaseQQAppInterface.add(localHashMap);
      paramBaseQQAppInterface.add(localObject1);
      return paramBaseQQAppInterface;
    }
    return null;
  }
  
  public static String readQRTokenConfig(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("qrtoken_config", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qrtoken");
      localStringBuilder.append(paramString);
      paramContext = paramContext.getString(localStringBuilder.toString(), "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("tenpayguid");
      localStringBuilder.append(QWalletHelperDelegate.getQWDevId());
      paramString = QWalletHelperDelegate.hexdigest(localStringBuilder.toString());
      paramContext = QWalletHelperDelegate.desDecrypt(paramContext, paramString.substring(0, 16), paramString.substring(paramString.length() - 16, paramString.length()));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("readQRTokenConfig plain = ");
        paramString.append(paramContext);
        QLog.d("Q.qwallet.redpack", 2, paramString.toString());
      }
      if (paramContext != null)
      {
        if (!paramContext.endsWith("tenpay_qrtoken")) {
          return "";
        }
        paramContext = paramContext.substring(0, paramContext.length() - 14);
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static void saveLastUpdateToopMemberNumTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseApplication localBaseApplication = MobileQQ.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localBaseApplication.getSharedPreferences("qwallet_multi", i).edit().putLong(paramString, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static void saveQRTokenConfig(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
    }
    do
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("tenpayguid");
        String str = QQDeviceInfo.getIMEI("5076bf");
        QWalletHelperDelegate.mDeviceId = str;
        ((StringBuilder)localObject).append(str);
        str = QWalletHelperDelegate.hexdigest(((StringBuilder)localObject).toString());
        localObject = str.substring(0, 16);
        str = str.substring(str.length() - 16, str.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("tenpay_qrtoken");
        paramString1 = QWalletHelperDelegate.desEncrypt(localStringBuilder.toString(), (String)localObject, str);
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveQRTokenConfig ciper = ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.d("Q.qwallet.redpack", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramContext)
      {
        Object localObject;
        paramContext.printStackTrace();
      }
      paramContext = paramContext.getSharedPreferences("qrtoken_config", 0).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qrtoken");
      ((StringBuilder)localObject).append(paramString2);
      paramContext.putString(((StringBuilder)localObject).toString(), paramString1);
      paramContext.commit();
      return;
      return;
    } while (paramString1 != null);
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  public static void startActivityForResult(Context paramContext, Intent paramIntent, String paramString, int paramInt)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    paramContext.setRequestCode(paramInt);
    QRoute.startUri(paramContext, null);
  }
  
  public void clearInstance(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = (IVACDReportService)paramBaseQQAppInterface.getRuntimeService(IVACDReportService.class, "");
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.onDestroy();
      }
    }
    mIsRefreshHome = true;
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).GameShareConfProcessor$reset();
    QWalletResultReceiver.clear();
    ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).onDestory();
    ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).onDestory();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().b();
    PayLogicImpl.clearCache();
    lastTime = -1L;
  }
  
  public AppRuntime createQWalletAppInterface(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      if (paramString == null) {
        return null;
      }
    }
    try
    {
      try
      {
        paramString = Class.forName("com.qwallet.activity.QWalletAppInterface");
        paramContext = paramString;
      }
      catch (Exception paramContext)
      {
        break label103;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      label26:
      break label26;
    }
    paramString = PluginStatic.getOrCreateClassLoader(paramContext, "qwallet_plugin.apk");
    paramContext = paramString.loadClass("com.qwallet.activity.QWalletAppInterface");
    BasicClassTypeUtil.setClassLoader(true, paramString);
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.qwallet.", 2, "*createQWalletAppInterface load class fail");
        return null;
      }
    }
    else
    {
      paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof AppRuntime)))
      {
        paramContext = (AppRuntime)paramContext;
        return paramContext;
        label103:
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("*createQWalletAppInterface exception:");
          paramString.append(paramContext.toString());
          QLog.e("Q.qwallet.", 2, paramString.toString());
        }
      }
      return null;
    }
    return null;
  }
  
  public void doF2FRedpack(AppInterface paramAppInterface, Activity paramActivity, String paramString)
  {
    if ((paramAppInterface != null) && (paramActivity != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      long l = VACDReportUtil.a(null, "qqwallet", "graphb", "invoke", paramString, 0, null);
      if ((((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(paramAppInterface.getCurrentAccountUin(), "F2FRedpackQRCheck", true)) && (!isValidUrl(paramString)))
      {
        paramAppInterface = new Intent();
        paramAppInterface.putExtra("pay_requestcode", 200);
        RouteUtils.a(paramActivity, paramAppInterface, "/base/payBridge");
        VACDReportUtil.endReport(l, "invalidUrl", null, -900, null);
        return;
      }
      if (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(paramAppInterface.getCurrentAccountUin(), "F2FRedpackGIF", true))
      {
        VACDReportUtil.a(l, null, "checkAnim", null, 0, null);
        if (playF2FRedPackAnim(paramAppInterface, paramActivity, paramString, l)) {
          return;
        }
      }
      gotoF2FRedpack(paramAppInterface.getCurrentAccountUin(), paramAppInterface.getCurrentNickname(), paramActivity, paramString, false, l);
    }
  }
  
  public void doQRCodePay(AppInterface paramAppInterface, Activity paramActivity, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = VACDReportUtil.a(null, "qqwallet", "pay-qrcode", "payinvoke", null, 0, null);
      int i = paramString.indexOf("://qpay.qq.com/qr/");
      if (i == -1) {
        return;
      }
      String str2 = paramString.substring(i + 18);
      String str1 = null;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tokenId", str2);
        localJSONObject.put("comeForm", "3");
        str2 = localJSONObject.toString();
        str1 = str2;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (str1 == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("payparmas_callback_sn", "0");
      localBundle.putString("payparmas_json", str1);
      localBundle.putInt("payparmas_paytype", 8);
      localBundle.putString("payparmas_url_appinfo", "appid#3155944709|bargainor_id#|channel#offline");
      localBundle.putLong("vacreport_key_seq", l);
      localBundle.putString("payparmas_h5_url", paramString);
      paramString = new WeakReference(paramOnQRHandleResultCallback);
      paramString = new QWalletHelperImpl.2(this, ThreadManager.getUIHandlerV2(), paramString);
      paramAppInterface = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).PayBridgeActivity$newPay(paramAppInterface, paramActivity, paramString, 9, localBundle);
      if (paramAppInterface.getInt("retCode", -1) != 0) {
        VACDReportUtil.endReport(l, "parseurl", null, 668801, paramAppInterface.getString("retJson"));
      }
      return;
    }
  }
  
  public void doQWalletQRCode(AppInterface paramAppInterface, Activity paramActivity, String paramString)
  {
    Object localObject1;
    int i;
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Vip_pay_mywallet");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("wallet");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("watchqrcodescan");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append(0);
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append(1);
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append(0);
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append('|');
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append('|');
      StatisticCollector.getInstance(null).reportToPCliOper(paramAppInterface, ((StringBuilder)localObject1).toString());
      i = paramString.indexOf('?');
      if (i == -1) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject4 = paramString.substring(i + 1).split("&");
        Object localObject3 = new HashMap();
        int j = localObject4.length;
        i = 0;
        String str;
        Object localObject2;
        if (i < j)
        {
          if (TextUtils.isEmpty(localObject4[i])) {
            break label827;
          }
          int k = localObject4[i].indexOf('=');
          if (k == -1) {
            break label827;
          }
          str = localObject4[i].substring(0, k);
          try
          {
            localObject1 = URLDecoder.decode(localObject4[i].substring(k + 1), "UTF-8");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = "";
          }
          if (TextUtils.isEmpty(str)) {
            break label827;
          }
          ((Map)localObject3).put(str, localObject2);
          break label827;
        }
        if (((Map)localObject3).size() > 0)
        {
          localObject2 = (String)((Map)localObject3).get("m");
          localObject4 = (String)((Map)localObject3).get("a");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            if ((((String)localObject2).compareTo("tenpay") == 0) && (((String)localObject4).compareTo("1") == 0))
            {
              localObject4 = (String)((Map)localObject3).get("u");
              str = (String)((Map)localObject3).get("n");
              localObject2 = (String)((Map)localObject3).get("f");
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).compareTo("apw") != 0))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("appid#20000001|bargainor_id#1000026901|channel#");
                ((StringBuilder)localObject3).append((String)localObject2);
                localObject2 = ((StringBuilder)localObject3).toString();
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("appid#20000001|bargainor_id#1000026901|channel#");
                ((StringBuilder)localObject2).append("applewatchqrcode");
                localObject2 = ((StringBuilder)localObject2).toString();
              }
              localObject3 = new JSONObject();
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("url", paramString);
                localJSONObject.put("uin", localObject4);
                localJSONObject.put("name", str);
                ((JSONObject)localObject3).put("userId", paramAppInterface.getCurrentAccountUin());
                ((JSONObject)localObject3).put("viewTag", "parseqrcode");
                ((JSONObject)localObject3).put("appInfo", localObject2);
                ((JSONObject)localObject3).put("come_from", 5);
                ((JSONObject)localObject3).put("extra_data", localJSONObject);
              }
              catch (Exception paramAppInterface)
              {
                if (QLog.isDevelopLevel()) {
                  paramAppInterface.printStackTrace();
                }
              }
              paramAppInterface = new Bundle();
              paramAppInterface.putString("json", ((JSONObject)localObject3).toString());
              paramAppInterface.putString("callbackSn", "0");
              paramString = new Intent();
              paramString.putExtras(paramAppInterface);
              paramString.putExtra("pay_requestcode", 5);
              RouteUtils.a(paramActivity, paramString, "/base/payBridge", 1);
              return;
            }
            QQToast.a(paramActivity, HardCodeUtil.a(R.string.cR), 0).a();
            paramActivity.finish();
            return;
          }
          QQToast.a(paramActivity, HardCodeUtil.a(R.string.cR), 0).a();
          paramActivity.finish();
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
      return;
      label827:
      i += 1;
    }
  }
  
  public String getAppInfoFromHistory(WebView paramWebView)
  {
    if (paramWebView != null)
    {
      String str = getAppInfoByUrl(paramWebView.getUrl());
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      str = getAppInfoByUrl(paramWebView.getOriginalUrl());
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      WebBackForwardList localWebBackForwardList = paramWebView.copyBackForwardList();
      paramWebView = str;
      if (localWebBackForwardList != null)
      {
        int i = localWebBackForwardList.getSize() - 1;
        paramWebView = str;
        while (i >= 0)
        {
          paramWebView = getAppInfoByUrl(localWebBackForwardList.getItemAtIndex(i).getUrl());
          if (!TextUtils.isEmpty(paramWebView)) {
            return paramWebView;
          }
          paramWebView = getAppInfoByUrl(localWebBackForwardList.getItemAtIndex(i).getOriginalUrl());
          if (!TextUtils.isEmpty(paramWebView)) {
            return paramWebView;
          }
          i -= 1;
        }
      }
    }
    else
    {
      paramWebView = "";
    }
    return paramWebView;
  }
  
  public BaseQQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return (BaseQQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getCorrectAppInfo(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    if (paramString1.equals(paramString2)) {
      return paramString1;
    }
    int j = paramString1.lastIndexOf("|channel#");
    String str4 = "";
    Object localObject;
    int i;
    String str1;
    if (j != -1)
    {
      localObject = paramString1.substring(j + 9);
      i = paramString1.indexOf("|bargainor_id#");
      if (i != -1)
      {
        str1 = paramString1.substring(i + 14, j);
        j = paramString1.indexOf("appid#");
        if (j != -1) {
          paramString1 = paramString1.substring(j + 6, i);
        } else {
          paramString1 = "";
        }
      }
      else
      {
        paramString1 = "";
        str1 = paramString1;
      }
    }
    else
    {
      paramString1 = "";
      str1 = paramString1;
      localObject = str1;
    }
    j = paramString2.lastIndexOf("|channel#");
    String str2;
    String str3;
    if (j != -1)
    {
      String str5 = paramString2.substring(j + 9);
      i = paramString2.indexOf("|bargainor_id#");
      if (i != -1)
      {
        String str6 = paramString2.substring(i + 14, j);
        j = paramString2.indexOf("appid#");
        str2 = str6;
        str3 = str5;
        if (j != -1)
        {
          str4 = paramString2.substring(j + 6, i);
          str2 = str6;
          str3 = str5;
        }
      }
      else
      {
        str2 = "";
        str3 = str5;
      }
    }
    else
    {
      str2 = "";
      str3 = str2;
    }
    if (!TextUtils.isEmpty(str4))
    {
      paramString1 = new StringBuilder();
      paramString1.append("appid#");
      paramString1.append(str4);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("appid#");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|bargainor_id#");
    paramString1 = paramString2.toString();
    if (TextUtils.isEmpty(str1))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(str2);
      paramString1 = paramString2.toString();
    }
    else if (str1.compareTo("0") == 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(str2);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(str1);
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|channel#");
    paramString1 = paramString2.toString();
    if (!TextUtils.isEmpty(str3))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(str3);
      return paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append((String)localObject);
    return paramString2.toString();
  }
  
  /* Error */
  public void getPayCode(BaseQQAppInterface paramBaseQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: ldc_w 496
    //   12: invokestatic 502	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   15: checkcast 496	com/qwallet/temp/IQWalletTemp
    //   18: aload_1
    //   19: invokeinterface 1311 2 0
    //   24: istore_2
    //   25: new 96	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: ldc_w 1313
    //   39: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: iload_2
    //   46: invokevirtual 457	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc_w 459
    //   53: iconst_1
    //   54: aload 7
    //   56: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 462	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iload_2
    //   63: ifne +24 -> 87
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: goto +210 -> 280
    //   73: astore 7
    //   75: ldc_w 459
    //   78: iconst_1
    //   79: ldc_w 1313
    //   82: aload 7
    //   84: invokestatic 1316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: ldc_w 496
    //   90: invokestatic 502	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   93: checkcast 496	com/qwallet/temp/IQWalletTemp
    //   96: aload_1
    //   97: ldc_w 1318
    //   100: invokeinterface 1322 3 0
    //   105: astore 7
    //   107: aload 7
    //   109: ifnull +168 -> 277
    //   112: aload 7
    //   114: ldc_w 1113
    //   117: invokevirtual 621	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +6 -> 126
    //   123: goto +154 -> 277
    //   126: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   129: lstore_3
    //   130: getstatic 63	cooperation/qwallet/plugin/impl/QWalletHelperImpl:lastTime	J
    //   133: ldc2_w 60
    //   136: lcmp
    //   137: ifeq +22 -> 159
    //   140: getstatic 63	cooperation/qwallet/plugin/impl/QWalletHelperImpl:lastTime	J
    //   143: lstore 5
    //   145: lload_3
    //   146: lload 5
    //   148: lsub
    //   149: ldc2_w 1323
    //   152: lcmp
    //   153: ifge +6 -> 159
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: lload_3
    //   160: putstatic 63	cooperation/qwallet/plugin/impl/QWalletHelperImpl:lastTime	J
    //   163: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +12 -> 178
    //   169: ldc 19
    //   171: iconst_4
    //   172: ldc_w 1326
    //   175: invokestatic 548	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_1
    //   179: invokevirtual 1327	com/tencent/common/app/business/BaseQQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   182: astore 8
    //   184: new 572	android/os/Bundle
    //   187: dup
    //   188: invokespecial 836	android/os/Bundle:<init>	()V
    //   191: astore 9
    //   193: ldc 74
    //   195: astore 7
    //   197: aload_1
    //   198: iconst_2
    //   199: invokevirtual 1328	com/tencent/common/app/business/BaseQQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   202: checkcast 768	mqq/manager/TicketManager
    //   205: astore 10
    //   207: aload 7
    //   209: astore_1
    //   210: aload 10
    //   212: ifnull +13 -> 225
    //   215: aload 10
    //   217: aload 8
    //   219: invokeinterface 771 2 0
    //   224: astore_1
    //   225: aload 9
    //   227: ldc_w 760
    //   230: aload 8
    //   232: invokevirtual 1116	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 9
    //   237: ldc_w 1330
    //   240: aload_1
    //   241: invokevirtual 1116	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 9
    //   246: ldc_w 1332
    //   249: ldc_w 791
    //   252: invokevirtual 1116	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 9
    //   257: ldc_w 1334
    //   260: bipush 23
    //   262: invokevirtual 848	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   265: invokestatic 380	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   268: aload 9
    //   270: invokestatic 1340	cooperation/qwallet/plugin/QWalletPayBridge:launchBackground	(Landroid/content/Context;Landroid/os/Bundle;)Z
    //   273: pop
    //   274: aload_0
    //   275: monitorexit
    //   276: return
    //   277: aload_0
    //   278: monitorexit
    //   279: return
    //   280: aload_0
    //   281: monitorexit
    //   282: aload_1
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	QWalletHelperImpl
    //   0	284	1	paramBaseQQAppInterface	BaseQQAppInterface
    //   24	39	2	bool	boolean
    //   129	31	3	l1	long
    //   143	4	5	l2	long
    //   32	23	7	localStringBuilder	StringBuilder
    //   73	10	7	localThrowable	Throwable
    //   105	103	7	str1	String
    //   182	49	8	str2	String
    //   191	78	9	localBundle	Bundle
    //   205	11	10	localTicketManager	TicketManager
    // Exception table:
    //   from	to	target	type
    //   9	62	69	finally
    //   75	87	69	finally
    //   87	107	69	finally
    //   112	123	69	finally
    //   126	145	69	finally
    //   159	178	69	finally
    //   178	193	69	finally
    //   197	207	69	finally
    //   215	225	69	finally
    //   225	274	69	finally
    //   9	62	73	java/lang/Throwable
  }
  
  public HashMap<String, String> getPublicAccWhiteMap()
  {
    Object localObject = sPublicAccWhiteMap;
    if ((localObject == null) || (((HashMap)localObject).isEmpty()))
    {
      localObject = MobileQQ.getContext();
      int i;
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      } else {
        i = 0;
      }
      updatePublicAccWhiteMap(((BaseApplication)localObject).getSharedPreferences("qwallet_multi", i).getString("publicAcc_white_list", ""));
    }
    return sPublicAccWhiteMap;
  }
  
  public String getQWalletExternalPath()
  {
    if (!TextUtils.isEmpty(mQWalletExternalPath)) {
      return mQWalletExternalPath;
    }
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        StringBuilder localStringBuilder1 = new StringBuilder(MobileQQ.getContext().getExternalFilesDir("QWallet").getAbsolutePath());
        localStringBuilder1.append("/");
        mQWalletExternalPath = localStringBuilder1.toString();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("QWalletHelperImpl", 1, "getQWalletExternalPath is error,throwable:", localThrowable);
    }
    if (TextUtils.isEmpty(mQWalletExternalPath)) {
      mQWalletExternalPath = getQWalletInternalPath();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getQWalletExternalPath = ");
      localStringBuilder2.append(mQWalletExternalPath);
      QLog.d("QWalletHelperImpl", 1, localStringBuilder2.toString());
    }
    return mQWalletExternalPath;
  }
  
  public String getQWalletInternalPath()
  {
    if (!TextUtils.isEmpty(mQWalletInternalPath)) {
      return mQWalletInternalPath;
    }
    StringBuilder localStringBuilder = new StringBuilder(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/QWallet/");
    mQWalletInternalPath = localStringBuilder.toString();
    return mQWalletInternalPath;
  }
  
  public Class<? extends Activity> getQWalletProxyActivityClass()
  {
    return QWalletPluginProxyActivity.class;
  }
  
  public AppRuntime getRuntime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void gotoF2FRedpack(String paramString1, String paramString2, Activity paramActivity, String paramString3, boolean paramBoolean, long paramLong)
  {
    VACDReportUtil.a(paramLong, null, "startGrapHb", null, 0, null);
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      int i = paramString3.lastIndexOf('#');
      if (i == -1) {
        return;
      }
      String str = paramString3.substring(i + 1);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      Object localObject = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("channel", 2048);
        localJSONObject.put("qr_data", str);
        localJSONObject.put("name", paramString2);
        ((JSONObject)localObject).put("userId", paramString1);
        ((JSONObject)localObject).put("viewTag", "graphb");
        ((JSONObject)localObject).put("app_info", "");
        ((JSONObject)localObject).put("come_from", 2);
        ((JSONObject)localObject).put("extra_data", localJSONObject);
      }
      catch (Exception paramString1)
      {
        if (QLog.isDevelopLevel()) {
          paramString1.printStackTrace();
        }
      }
      paramString2 = new Bundle();
      paramString2.putInt("extra_ext_data_type", 1);
      paramString2.putBoolean("extra_ext_f2fredpack_is_anim", paramBoolean);
      paramString1 = new Bundle();
      localObject = ((JSONObject)localObject).toString();
      paramString1.putBundle("extra_ext_data", paramString2);
      paramString1.putString("json", (String)localObject);
      paramString1.putString("callbackSn", "0");
      paramString2 = new StringBuilder();
      paramString2.append("url=");
      paramString2.append(paramString3);
      paramString2.toString();
      paramString1.putLong("vacreport_key_seq", paramLong);
      paramString2 = new Intent();
      paramString2.putExtras(paramString1);
      paramString2.putExtra("pay_requestcode", 5);
      try
      {
        RouteUtils.a(paramActivity, paramString2, "/base/payBridge");
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isDevelopLevel()) {
          paramString1.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("QWalletHelperImpl failed to startActivity : ");
          paramString2.append(paramString3);
          QLog.d("Q.qwallet.redpack", 2, paramString2.toString(), paramString1);
        }
      }
    }
  }
  
  public void gotoQWalletHome(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1"));
    localIntent.setAction("android.intent.action.VIEW");
    paramActivity.startActivity(localIntent);
  }
  
  public boolean isLaunchPayPluginAct(Bundle paramBundle, Context paramContext)
  {
    if ((isForePay(paramBundle)) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      if ((isFromOnlyActScene(paramBundle)) || (isFromDiffTaskAffinity(paramContext)) || (isFromSpecifyModel()) || (isCurrTaskNotValid(paramContext))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isValidToLaunchQWallet(long paramLong)
  {
    long l = qLaunchTime;
    return (paramLong - l > 5000L) || (paramLong - l < 0L);
  }
  
  public void launchPayService(Context paramContext, AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    launchPayBridgeService(paramContext, paramAppRuntime, paramBundle);
  }
  
  public void launchQWalletAct(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQBaseActivity != null)
    {
      if (paramBaseQQAppInterface == null) {
        return;
      }
      if ((paramBoolean1) && (QWalletPrivacyUtils.a(paramQBaseActivity, paramBaseQQAppInterface))) {
        return;
      }
      QWalletPerTrace.a("homepage_onclick");
      paramBoolean1 = PatternLockUtils.isNeedOpenPatternLock(paramQBaseActivity, paramBaseQQAppInterface.getCurrentAccountUin());
      long l1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ProcessInfoUtil$getProcessRunningTime();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toolRunTime=");
      ((StringBuilder)localObject).append(l1);
      long l2 = VACDReportUtil.a(null, "qqwallet", "homepage", "click", ((StringBuilder)localObject).toString(), 0, null);
      qLaunchTime = System.currentTimeMillis();
      if (l1 > 5000L)
      {
        gotoQWalletAct(paramQBaseActivity, paramBaseQQAppInterface, l2, paramBoolean2, null);
        return;
      }
      localObject = new QWalletLoadingDialog(paramQBaseActivity, paramBoolean1);
      ((QWalletLoadingDialog)localObject).show();
      gotoQWalletAct(paramQBaseActivity, paramBaseQQAppInterface, l2, paramBoolean2, (QWalletLoadingDialog)localObject);
    }
  }
  
  protected boolean playF2FRedPackAnim(AppInterface paramAppInterface, Activity paramActivity, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && (paramActivity != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Object localObject1 = (IPreloadService)paramAppInterface.getRuntimeService(IPreloadService.class, "");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((IPreloadService)localObject1).getModuleByName("f2f_redpacket");
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((IPreloadModule)localObject2).getResApiList();
      if (localObject2 != null)
      {
        if (((List)localObject2).size() <= 0) {
          return false;
        }
        localObject2 = (IPreloadResource)((List)localObject2).get(0);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((IPreloadResource)localObject2).getUrl())) {
            return false;
          }
          localObject2 = PreloadStaticApi.a(((IPreloadResource)localObject2).getUrl());
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            ((IPreloadService)localObject1).downloadModule("f2f_redpacket", true);
            return false;
          }
          localObject1 = paramAppInterface.getCurrentAccountUin();
          paramAppInterface = paramAppInterface.getCurrentNickname();
          ThreadManager.post(new QWalletHelperImpl.3(this, (String)localObject2, new WeakReference(paramActivity), paramLong, (String)localObject1, paramAppInterface, paramString), 5, null, true);
          return true;
        }
      }
    }
    return false;
  }
  
  public void preloadQWallet(AppInterface paramAppInterface)
  {
    preloadQWallet(paramAppInterface, 5000, "qwallet_default");
  }
  
  public void preloadQWallet(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (paramAppRuntime == null) {
      return;
    }
    String str = paramAppRuntime.getCurrentAccountUin();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TicketManager)localObject).getSkey(str);
    }
    paramAppRuntime = new WeakReference(paramAppRuntime);
    ThreadManager.getSubThreadHandler().postDelayed(new QWalletHelperImpl.1(this, paramAppRuntime, str, (String)localObject, paramString), paramInt);
  }
  
  public void resetLaunchTime()
  {
    qLaunchTime = 0L;
  }
  
  public void updateHongBaoSpeedWitch(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i;
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (NumberFormatException paramBaseQQAppInterface)
    {
      paramBaseQQAppInterface.printStackTrace();
      i = 0;
    }
    if (i == 1) {
      bool = true;
    }
    QWalletHelperDelegate.graphbSpeedEnable = bool;
  }
  
  public void updatePublicAccWhiteMap(String paramString)
  {
    Object localObject1 = sPublicAccWhiteMap;
    if (localObject1 == null) {
      sPublicAccWhiteMap = new HashMap(16);
    } else {
      ((HashMap)localObject1).clear();
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString.split("\\|");
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          paramString = localObject1[i];
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = paramString.split("#");
            if ((paramString != null) && (!TextUtils.isEmpty(paramString[0])))
            {
              HashMap localHashMap = sPublicAccWhiteMap;
              Object localObject2 = paramString[0];
              if (paramString.length > 1) {
                paramString = paramString[1];
              } else {
                paramString = "0";
              }
              localHashMap.put(localObject2, paramString);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl
 * JD-Core Version:    0.7.0.1
 */