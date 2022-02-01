package cooperation.qzone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.CheckBox;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.util.QZoneExceptionReport;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QzonePluginProxyActivity
  extends PluginProxyFragmentActivity
  implements QzoneJumpQBrowserInterface
{
  private static final String KEY_CRASH_COUNT_IN_CNF_EXCEPTION = "Crash_Count_In_CNFException";
  private static final String[] PICTURE_VIEWER_ACTIVITY_LIST = { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QZonePanoramaActivity", "com.qzone.preview.QzonePictureSelectViewer" };
  public static final String QZONE_EXTRA_KEY_PLUGIN_ISLOADING = "QZoneExtra.Plugin.isloading";
  static final String QZONE_PLGUIN_APK = "qzone_plugin.apk";
  public static final String QZONE_PLUGIN_ACTIVITY_NAME = "qzone_plugin_activity_name";
  static final String QZONE_PLUGIN_NAME = "QZone";
  public static final String QZONE_PLUGIN_PACKAGE_NAME = "com.qzone";
  public static final String QZONE_START_UP_FAILED_COUNT_KEY = "qzone_app_start_fail_count";
  private static final String TAG = "QzonePluginProxyActivity";
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = { "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", "com.qzone.misc.web.QZoneTranslucentActivity", "com.qzone.misc.web.QZoneTranslucentActivity2", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.album.business.dlna.activity.DLNAActivity", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.common.activities.base.QzoneGiftPanelActivity", "com.qzone.common.activities.QzoneDualWarmActivity" };
  public static volatile ClassLoader qzoneClassLoader;
  private WatchActivityManager mWatchActivityManager = new WatchActivityManager();
  private TopGestureLayout topGestureLayout;
  
  private static void checkStartupSuceess()
  {
    if (!isQzoneExist())
    {
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.sApplication != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.sApplication.getRuntime() != null) {
          l1 = BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin();
        }
      }
      int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, l1);
      String str;
      if (i == 8)
      {
        str = LocalMultiProcConfig.getString4Uin("creditmessage", "", l1);
        QLog.w("QzonePluginProxyActivity", 1, "空间被封，creditLevel:" + i + ",msg:" + str);
        return;
      }
      QLog.w("QzonePluginProxyActivity", 1, "qzone进程可能启动失败");
      i = LocalMultiProcConfig.getInt("qzone_app_start_fail_count", 0) + 1;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_startup_failed_toast_show_limit", 1) < i)
      {
        str = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_startup_fail_msg", HardCodeUtil.a(2131712166));
        QQToast.a(BaseApplicationImpl.sApplication, 4, str, 1).a();
        LocalMultiProcConfig.putInt("qzone_app_start_fail_count", 0);
        QLog.w("QzonePluginProxyActivity", 1, "qzone进程可能启动失败弹出toast提示用户卸载重新安装");
      }
      for (boolean bool = true;; bool = false)
      {
        QZoneExceptionReport.doReport(new QZoneStartupFailException("qzone进程启动失败"), "qzone进程启动失败,failCount:" + i + ",showToast:" + bool);
        QLog.w("QzonePluginProxyActivity", 1, "qzone进程启动失败,failCount:" + i + ",showToast:" + bool);
        return;
        LocalMultiProcConfig.putInt("qzone_app_start_fail_count", i);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzonePluginProxyActivity", 1, "qzone进程启动成功");
    }
    LocalMultiProcConfig.putInt("qzone_app_start_fail_count", 0);
  }
  
  private void dismissPluginLoading()
  {
    Intent localIntent = new Intent("action_launch_completed");
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "FriendFeed", "好友动态");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    localIntent.putExtra("plugin_name", str);
    sendBroadcast(localIntent);
  }
  
  static String getActivityNameToIntent(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  public static ClassLoader getPhotoPlusClassLoader(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "Photoplus.apk");
  }
  
  private static ConcurrentHashMap<String, PackageInfo> getPluginStaticPackageInfoMap()
  {
    try
    {
      Object localObject = PluginStatic.class.getDeclaredField("sPackageInfoMap");
      ((Field)localObject).setAccessible(true);
      localObject = (ConcurrentHashMap)((Field)localObject).get(PluginStatic.class);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localNoSuchFieldException);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localIllegalAccessException);
      }
    }
  }
  
  public static ClassLoader getQZonePluginClassLoader(Context paramContext)
  {
    if (qzoneClassLoader == null) {
      QLog.e("QzonePluginProxyActivity", 1, new Exception("getQZonePluginClassLoader"), new Object[] { BaseApplicationImpl.processName + " isQzonePluginInstalledAndVersionRight " + QZoneApiProxy.sIsQzoneVersionRight + " " + QZoneApiProxy.sIsQzoneInstalled });
    }
    qzoneClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
    return qzoneClassLoader;
  }
  
  public static ClassLoader getQZonePluginClassLoaderInUI()
  {
    return qzoneClassLoader;
  }
  
  public static String getQZonePluginName()
  {
    return "qzone_plugin.apk";
  }
  
  public static ClassLoader getQzoneLiveClassLoader(Context paramContext)
  {
    ClassLoader localClassLoader = null;
    String str = QZonePluginUtils.getLoadQZoneLivePluginId();
    if (str.equals("qzone_live_video_plugin_hack.apk")) {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "getQzoneLiveClassLoader classsloader: " + localClassLoader);
      }
      return localClassLoader;
      if (str.equals("qzone_live_video_plugin.apk")) {
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public static ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_vertical_video_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneVerticalVideoClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public static ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_weishi_feeds_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneWeishiFeedsClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public static boolean isQzoneExist()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzonePluginProxyActivity", 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  private static boolean isStringInArray(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void launchPluingActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt, null, true, null, paramBoolean);
  }
  
  public static void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, null);
  }
  
  public static void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, null, false);
  }
  
  public static void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2)
  {
    openActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramPreloadProcHitPluginSession, paramBoolean2);
  }
  
  public static void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, null, true, paramPreloadProcHitPluginSession, false);
  }
  
  private static void openActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    openActivityForResult(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, paramPreloadProcHitPluginSession, false);
  }
  
  private static void openActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2)
  {
    if ((QZoneHelper.comboqzProtectEnable) && ((paramContext instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.getInt("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.getBool("qz_safe_mode_no_tip", false))
      {
        paramContext = DialogUtil.a(paramContext, 230, 2131562704, HardCodeUtil.a(2131712153), "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", HardCodeUtil.a(2131712165), HardCodeUtil.a(2131712149), new QzonePluginProxyActivity.1(paramContext, paramInt, paramString, paramIntent), new QzonePluginProxyActivity.2());
        ((CheckBox)paramContext.findViewById(2131365843)).setOnCheckedChangeListener(new QzonePluginProxyActivity.3());
        paramContext.show();
      }
      while (QZoneHelper.forwardQZoneApp(paramContext, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        return;
      }
      QZoneHelper.forwardH5QZone(paramIntent.getStringExtra("sid"), paramContext);
      return;
    }
    if ((paramContext instanceof FriendProfileCardActivity)) {
      StatisticHitRateCollector.a().c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：" + paramBoolean1);
    }
    QZoneHelper.openActivityAsync(paramBoolean1, new QzonePluginProxyActivity.4(paramIntent, paramString, paramPreloadProcHitPluginSession, paramInt, paramBoolean2, paramContext, paramOnDismissListener));
  }
  
  public static void setActivityNameToIntent(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public static void toExActivityWithResult(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 1;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzonePluginProxyActivity.PluginProxyActivityClassFactory.getPluginProxyActivityClass(paramString);
  }
  
  public IPluginActivity getRealPluginActivity()
  {
    return this.mPluginActivity;
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public WatchActivityManager getWatchActivityManager()
  {
    return this.mWatchActivityManager;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    ViewUtils.a();
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.topGestureLayout = new QZoneTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.topGestureLayout);
    }
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")))
    {
      if (paramBundle != null) {}
      for (;;)
      {
        paramBundle = paramBundle.getString("pluginsdk_launchActivity");
        localObject = new StringBuffer(HardCodeUtil.a(2131712167));
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
        QZoneExceptionReport.doReport(new QZoneStartupFailException(this.mCreateErrorInfo), HardCodeUtil.a(2131712154) + getPluginActivity());
        dismissPluginLoading();
        return;
        paramBundle = getIntent().getExtras();
      }
    }
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      paramBundle = ((Bundle)localObject).getString("from_plugin");
      localObject = ((Bundle)localObject).getString("uin");
      getIntent().putExtra("from_plugin", "");
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("QZoneVideoPlugin"))) {
        launchPluingActivityForResult(this, (String)localObject, getIntent(), 1000);
      }
    }
    this.mWatchActivityManager.onCreate(this);
  }
  
  public void onDestroy()
  {
    this.mWatchActivityManager.onDestroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.mWatchActivityManager.onKeyDown(paramInt, paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mWatchActivityManager.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.mWatchActivityManager.onStop();
  }
  
  public boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    label58:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int j;
        for (i = 1;; i = 0)
        {
          j = QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginErrorHandleCount", -1);
          if (j != 0) {
            break label58;
          }
          if (i == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("Qz_setting", 0);
        int k = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
        if (k == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((j >= 0) && (k >= j)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (i == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (i == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */