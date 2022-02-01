package cooperation.qzone;

import android.app.Activity;
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
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QzonePluginProxyActivity
  extends PluginProxyFragmentActivity
  implements QzoneJumpQBrowserInterface
{
  private static final String KEY_CRASH_COUNT_IN_CNF_EXCEPTION = "Crash_Count_In_CNFException";
  public static final String QZONE_EXTRA_KEY_PLUGIN_ISLOADING = "QZoneExtra.Plugin.isloading";
  public static final String QZONE_PLUGIN_ACTIVITY_NAME = "qzone_plugin_activity_name";
  static final String QZONE_PLUGIN_NAME = "QZone";
  public static final String QZONE_PLUGIN_PACKAGE_NAME = "com.qzone";
  public static final String QZONE_START_UP_FAILED_COUNT_KEY = "qzone_app_start_fail_count";
  private static final String TAG = "QzonePluginProxyActivity";
  public static volatile ClassLoader qzoneClassLoader;
  private WatchActivityManager mWatchActivityManager = new WatchActivityManager();
  private TopGestureLayout topGestureLayout;
  
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
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getPhotoPlusClassLoader(paramContext);
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
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localIllegalAccessException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.w("QzonePluginProxyActivity", 1, "Get PluginStatic sPackageInfoMap Failed!", localNoSuchFieldException);
    }
    return null;
  }
  
  public static ClassLoader getQZonePluginClassLoader(Context paramContext)
  {
    if (qzoneClassLoader == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MobileQQ.processName);
      localStringBuilder.append(" isQzonePluginInstalledAndVersionRight ");
      localStringBuilder.append(((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).isQzoneVersionRight());
      localStringBuilder.append(" ");
      localStringBuilder.append(((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).isIsQzoneInstalled());
      QLog.w("QzonePluginProxyActivity", 1, localStringBuilder.toString(), new Exception("getQZonePluginClassLoader"));
    }
    qzoneClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID());
    return qzoneClassLoader;
  }
  
  public static ClassLoader getQZonePluginClassLoaderInUI()
  {
    return qzoneClassLoader;
  }
  
  public static String getQZonePluginName()
  {
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID();
  }
  
  public static ClassLoader getQzoneLiveClassLoader(Context paramContext)
  {
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneLiveClassLoader(paramContext);
  }
  
  public static ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext)
  {
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneVerticalVideoClassLoader(paramContext);
  }
  
  public static ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext)
  {
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getQzoneWeishiFeedsClassLoader(paramContext);
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
    ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramPreloadProcHitPluginSession, paramBoolean2);
  }
  
  public static void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, null, true, paramPreloadProcHitPluginSession, false);
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
    paramBundle.putString("PhotoConst.PLUGIN_APK", ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID());
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
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getPluginID();
  }
  
  protected int getPluginResType()
  {
    return 1;
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return ((IQzonePluginProxyActivityProxy)QRoute.api(IQzonePluginProxyActivityProxy.class)).getProxyActivity(paramString);
  }
  
  public IPluginActivity getRealPluginActivity()
  {
    return this.mPluginActivity;
  }
  
  protected int getThemeResId()
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.topGestureLayout = new QZoneTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.topGestureLayout);
    }
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")))
    {
      if (paramBundle == null) {
        paramBundle = getIntent().getExtras();
      }
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      localObject = new StringBuffer(HardCodeUtil.a(2131712142));
      ((StringBuffer)localObject).append(paramBundle);
      ((StringBuffer)localObject).append(" ");
      ((StringBuffer)localObject).append(this.mCreateErrorInfo);
      QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
      paramBundle = (IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class);
      localObject = new QZoneStartupFailException(this.mCreateErrorInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131712129));
      localStringBuilder.append(getPluginActivity());
      paramBundle.doReport((Throwable)localObject, localStringBuilder.toString());
      dismissPluginLoading();
      return;
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
    VideoReport.addToDetectionWhitelist(this);
  }
  
  protected void onDestroy()
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
  
  protected void onResume()
  {
    super.onResume();
    this.mWatchActivityManager.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mWatchActivityManager.onStop();
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    boolean bool4 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4) {
      return false;
    }
    int i;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginErrorHandleCount", -1);
    if (j == 0)
    {
      if (i != 0) {
        bool1 = super.shouldHandleStartPluginFailed(paramString);
      }
      return bool1;
    }
    paramString = paramString.toLowerCase();
    if (paramString.contains("classnotfoundexception"))
    {
      Object localObject = getSharedPreferences("Qz_setting", 0);
      int k = ((SharedPreferences)localObject).getInt("Crash_Count_In_CNFException", 0);
      ((SharedPreferences)localObject).edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
      if (k == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("kill process with first Exception:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("Plugin", 1, ((StringBuilder)localObject).toString());
        finish();
        Process.killProcess(Process.myPid());
        return true;
      }
      if ((j >= 0) && (k >= j))
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = super.shouldHandleStartPluginFailed(paramString);
        }
        return bool1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show dialog with non-first Exception:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("Plugin", 1, ((StringBuilder)localObject).toString());
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    bool1 = bool3;
    if (i != 0) {
      bool1 = super.shouldHandleStartPluginFailed(paramString);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */