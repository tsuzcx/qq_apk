package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IActivityDispatchCallback;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import mqq.app.ThirdAppReportHelper;

@SuppressLint({"NewApi"})
public abstract class PluginProxyActivity
  extends Activity
{
  public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  public static final String ACTION_PLUGIN_STARTUP_SPEED_INFO = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO";
  private static final String INNER_BUNDLE = "pluginsdk_inner_bundle";
  protected static final String INNER_INTENT_EXTRAS = "pluginsdk_inner_intent_extras";
  public static final int LAUNCH_TYPE_FIRST = 1;
  public static final int LAUNCH_TYPE_OTHER = -1;
  public static final String READER_ID = "qqreaderplugin.apk";
  private static final String TAG = "PluginProxyActivity";
  public static Locale locale;
  public static boolean mAppForground = true;
  public static boolean mGestureLockEnable;
  private static String mUin = "";
  public static IActivityDispatchCallback sActivityDispatchCallback;
  public static PluginProxyActivity.IPluginManifestChecker sChecker;
  private static Field sMMapField;
  private static Method sUnparcelMethod;
  public boolean mActNeedImmersive = true;
  private boolean mCanLock = true;
  private Class<?> mClassLaunchActivity;
  protected String mCreateErrorInfo;
  protected FlingHandler mFlingHandler;
  protected boolean mIsShowQQBackgroundIcon = true;
  protected String mLaunchActivity;
  protected boolean mNeedStatusTrans = true;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  protected IPluginActivity mPluginActivity;
  protected String mPluginApkFilePath;
  private boolean mPluginGestureLock;
  protected String mPluginID;
  protected String mPluginName;
  protected int mPluginResoucesType;
  private BroadcastReceiver mScreenOffReceiver = new PluginProxyActivity.2(this);
  protected int mStatusColor = 0;
  protected int mStopFlag;
  private String mUinString;
  protected boolean mUseSkinEngine;
  Object msystemBar;
  
  private boolean getAppForground(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getAppForground", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public static float getAvailableInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  private String getCurrentUinForPlugin(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getUinForPlugin", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof String))
      {
        paramContext = (String)paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private boolean getEnableGestureLock(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("enableGestureLock", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void handleIntentForQQBrowser(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.getComponent() != null)
      {
        String str = paramIntent.getComponent().getClassName();
        if ((str != null) && ((str.contains("QQBrowserActivity")) || (str.contains("QQBrowserDelegationActivity"))) && (!paramIntent.hasExtra("StartClickTime")))
        {
          paramIntent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
          paramIntent.putExtra("SourceActivityName", paramContext.getClass().getSimpleName());
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private boolean handleStartPluginFailed(Throwable paramThrowable)
  {
    boolean bool2 = false;
    if (((paramThrowable instanceof FileNotFoundException)) || ((paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("permission"))))
    {
      QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath);
      paramThrowable = getApplicationInfo();
      if (paramThrowable != null) {
        if ((paramThrowable.flags & 0x1) <= 0) {
          break label173;
        }
      }
      label173:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramThrowable.flags & 0x80) > 0) {
          bool2 = true;
        }
        QLog.d("plugin_tag", 1, "UID: " + paramThrowable.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        paramThrowable = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG");
        paramThrowable.setPackage(MobileQQ.getContext().getPackageName());
        sendBroadcast(paramThrowable);
        showNeedUninstanllAndInstallDialog();
        return true;
      }
    }
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    if (((paramThrowable instanceof ClassNotFoundException)) || ((paramThrowable instanceof PluginUtils.GetPackageInfoFailException)))
    {
      float f = getAvailableInnernalMemorySize();
      QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath + ", leftSpace(B) = " + f);
      PluginRecoverReceiver.broadcast(this, this.mPluginID);
      return false;
    }
    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
  }
  
  @SuppressLint({"NewApi"})
  private void initPlugin()
  {
    PackageInfo localPackageInfo = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
    if (localPackageInfo == null)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
      }
      try
      {
        localPackageInfo = ApkFileParser.getPackageInfoWithException(this, this.mPluginApkFilePath, 129);
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity.initPlugin end getPackageInfo, " + localPackageInfo);
        }
        if (localPackageInfo == null) {
          throw new PluginUtils.GetPackageInfoFailException("Get Package Info Failed!");
        }
      }
      catch (Throwable localThrowable)
      {
        throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", localThrowable);
      }
      PluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, localThrowable);
    }
    for (;;)
    {
      if (sChecker != null) {
        sChecker.doCheck(this.mPluginID, this.mLaunchActivity);
      }
      if ((this.mLaunchActivity == null) || (this.mLaunchActivity.length() == 0))
      {
        if ((localThrowable.activities == null) || (localThrowable.activities.length == 0)) {
          throw new PluginUtils.PluginActivityNotFoundException();
        }
        this.mLaunchActivity = localThrowable.activities[0].name;
      }
      Object localObject = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mPluginApkFilePath);
      getIntent().setExtrasClassLoader((ClassLoader)localObject);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mClassLaunchActivity = ((ClassLoader)localObject).loadClass(this.mLaunchActivity);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mPluginActivity = ((IPluginActivity)this.mClassLaunchActivity.newInstance());
      this.mPluginActivity.IInit(this.mPluginID, this.mPluginApkFilePath, this, (ClassLoader)localObject, localThrowable, this.mUseSkinEngine, this.mPluginResoucesType);
      Intent localIntent = new Intent(getIntent());
      localObject = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        localIntent.putExtras((Bundle)localObject);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.ISetIntent(localIntent);
      return;
    }
  }
  
  private boolean isActivityLocaleUpdated(Locale paramLocale)
  {
    if ((locale == null) || (paramLocale == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = locale.getLanguage().equals(paramLocale.getLanguage());
      bool2 = locale.getCountry().equals(paramLocale.getCountry());
    } while ((bool1) && (bool2));
    return true;
  }
  
  private boolean isAppOnForeground()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      localObject = ((Class)localObject).getMethod("isAppOnForegroundByTasks", new Class[] { Context.class }).invoke(localObject, new Object[] { this });
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  public static void openActivity(Context paramContext, Intent paramIntent, PluginProxyActivity.StartActivityParams paramStartActivityParams)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, paramStartActivityParams.loader.loadClass(paramStartActivityParams.proxyActivity));
      localIntent.putExtra("pluginsdk_pluginName", paramStartActivityParams.mPluginName);
      localIntent.putExtra("pluginsdk_pluginLocation", paramStartActivityParams.mPluginID);
      localIntent.putExtra("pluginsdk_pluginpath", paramStartActivityParams.mPluginApkFilePath);
      localIntent.putExtra("pluginsdk_launchActivity", paramStartActivityParams.launchActivity);
      localIntent.putExtra("useSkinEngine", paramStartActivityParams.mUseSkinEngine);
      if ((paramStartActivityParams.mPluginResoucesType == 1) || (paramStartActivityParams.mPluginResoucesType == -1) || (paramStartActivityParams.mPluginResoucesType == 2)) {
        localIntent.putExtra("userQqResources", paramStartActivityParams.mPluginResoucesType);
      }
      localIntent.putExtra("pluginsdk_selfuin", IPluginAdapterProxy.getProxy().currentUin);
      if (paramIntent != null)
      {
        localIntent.addFlags(paramIntent.getFlags());
        localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void openActivity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchActivity", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("plugin_tag", 1, "", paramContext);
    }
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchActivity", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.d("plugin_tag", 1, "", paramActivity);
    }
  }
  
  private void safeShowToast(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Toast.makeText(paramContext, paramString, paramInt).show();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void sendLaunchCompletedBroadcast()
  {
    Intent localIntent = new Intent("action_launch_completed");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    sendBroadcast(localIntent);
  }
  
  public static void setActivityDispatchCallback(IActivityDispatchCallback paramIActivityDispatchCallback)
  {
    sActivityDispatchCallback = paramIActivityDispatchCallback;
  }
  
  private void setAppForground(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setAppForground", new Class[] { Context.class, Boolean.TYPE }).invoke(paramContext, new Object[] { this, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void setClassLoaderToEveryBundle(Bundle paramBundle, ClassLoader paramClassLoader)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.setClassLoader(paramClassLoader);
    if ((sUnparcelMethod == null) || (sMMapField == null)) {
      if (Build.VERSION.SDK_INT >= 21) {
        break label146;
      }
    }
    label146:
    for (Object localObject = paramBundle.getClass();; localObject = paramBundle.getClass().getSuperclass())
    {
      sUnparcelMethod = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
      sUnparcelMethod.setAccessible(true);
      sMMapField = ((Class)localObject).getDeclaredField("mMap");
      sMMapField.setAccessible(true);
      sUnparcelMethod.invoke(paramBundle, new Object[0]);
      paramBundle = (Map)sMMapField.get(paramBundle);
      if (paramBundle == null) {
        break;
      }
      paramBundle = paramBundle.values().iterator();
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if ((localObject instanceof Bundle)) {
          setClassLoaderToEveryBundle((Bundle)localObject, paramClassLoader);
        }
      }
      break;
    }
  }
  
  private void setCurrentUinForPlugin(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setUinForPlugin", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, paramString });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void showLaunchPluginFail()
  {
    if (this.mCreateErrorInfo != null)
    {
      if ((this.mCreateErrorInfo.contains("空间")) || (this.mCreateErrorInfo.contains("Space"))) {
        safeShowToast(BaseApplication.getContext(), "系统可用内存不足，" + this.mPluginName + "启动失败!", 0);
      }
    }
    else {
      return;
    }
    safeShowToast(BaseApplication.getContext(), this.mPluginName + "启动失败!", 0);
  }
  
  public static void uploadLaunchInfoWhenCreateClassLoader(String paramString, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = paramIntent.getExtras();
        String str = localBundle.getString("pluginsdk_pluginLocation");
        Object localObject = (Long)PluginStatic.sClassLoaderStartTimeMap.get(str);
        if (localObject != null)
        {
          l1 = ((Long)localObject).longValue();
          if (l1 > 0L)
          {
            localObject = BaseApplication.getContext();
            long l2 = paramIntent.getLongExtra("launchTimeStart", 0L);
            long l3 = System.currentTimeMillis();
            PluginStatic.sClassLoaderStartTimeMap.put(str, Long.valueOf(0L));
            if (localBundle.getString("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector") != null)
            {
              paramIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO");
              paramIntent.putExtras(localBundle);
              paramIntent.putExtra("launchTotal", l3 - l2);
              paramIntent.putExtra("pluginLoaderCost", l1);
              paramIntent.putExtra("launchComponent", paramString);
              paramIntent.putExtra("launchProcName", MobileQQ.processName);
              paramIntent.setPackage(((Context)localObject).getPackageName());
              ((Context)localObject).sendBroadcast(paramIntent);
            }
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      long l1 = -1L;
    }
  }
  
  private void uploadStartupResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("clsUploader");
    localObject = ((Intent)localObject).getStringExtra("pluginsdk_selfuin");
    if (str != null)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
      localIntent.putExtra("pluginsdk_selfuin", (String)localObject);
      localIntent.putExtra("pluginsdk_pluginName", paramString1);
      localIntent.putExtra("pluginsdk_pluginLocation", paramString2);
      localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
      localIntent.putExtra("pluginsdk_launchActivity", paramString3);
      localIntent.putExtra("pluginsdk_extraInfo", paramString4);
      localIntent.putExtra("clsUploader", str);
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      sendBroadcast(localIntent);
    }
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (sActivityDispatchCallback != null) {
      sActivityDispatchCallback.disaptchTouchEventCallback(this, paramMotionEvent);
    }
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean enablePatternLock()
  {
    return mGestureLockEnable;
  }
  
  public boolean getGestureLock(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, mUin });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  public int getIsSupportImmersive()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.widget.immersive.ImmersiveUtils");
      localObject = ((Class)localObject).getMethod("isSupporImmersive", new Class[0]).invoke(localObject, new Object[0]);
      DebugHelper.log("getIsSupportImmersive ret=" + localObject);
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("pluginProxy", 2, "getIsSupportImmersive e=" + localException);
    }
    return 0;
  }
  
  public final String getPluginActivity()
  {
    String str2 = this.mLaunchActivity;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      Bundle localBundle = getIntent().getExtras();
      str1 = str2;
      if (localBundle != null) {
        str1 = localBundle.getString("pluginsdk_launchActivity");
      }
    }
    return str1;
  }
  
  @Deprecated
  public String getPluginID()
  {
    return null;
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  protected void handleCrash(Bundle paramBundle, Throwable paramThrowable) {}
  
  public void initImmersive()
  {
    if (this.msystemBar != null) {}
    try
    {
      Method localMethod = this.msystemBar.getClass().getMethod("init", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.msystemBar, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean isPatternLockOpened()
  {
    return getGestureLock(this, mUin);
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    DebugHelper.debug("PluginProxyActivity.isWrapContent: " + bool + ", from = " + this.mPluginActivity);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPluginActivity != null) {}
    try
    {
      ClassLoader localClassLoader = PluginStatic.getClassLoader(this.mPluginID);
      if ((localClassLoader != null) && (paramIntent != null)) {
        paramIntent.setExtrasClassLoader(localClassLoader);
      }
      this.mPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    this.mCanLock = false;
  }
  
  public void onBackPressed()
  {
    boolean bool = false;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IOnBackPressed();
    }
    if (!bool) {}
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnConfigurationChanged(paramConfiguration);
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate");
    }
    Object localObject1;
    Object localObject2;
    Object localObject4;
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale))
    {
      localObject1 = getResources();
      localObject2 = ((Resources)localObject1).getConfiguration();
      localObject4 = new DisplayMetrics();
      ((DisplayMetrics)localObject4).setTo(((Resources)localObject1).getDisplayMetrics());
      ((Configuration)localObject2).locale = locale;
      ((Resources)localObject1).updateConfiguration((Configuration)localObject2, ((Resources)localObject1).getDisplayMetrics());
      ((Resources)localObject1).getDisplayMetrics().setTo((DisplayMetrics)localObject4);
    }
    MobileQQ.sMobileQQ.addOtherTypeActivity(this);
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
    }
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getBundle("pluginsdk_inner_bundle");
      localObject2 = paramBundle;
    }
    while (!PluginStatic.isValidPluginIntent((Bundle)localObject2))
    {
      super.onCreate(paramBundle);
      finish();
      return;
      localObject2 = getIntent().getExtras();
      localObject1 = null;
    }
    this.mPluginName = ((Bundle)localObject2).getString("pluginsdk_pluginName");
    this.mPluginID = ((Bundle)localObject2).getString("pluginsdk_pluginLocation");
    this.mLaunchActivity = ((Bundle)localObject2).getString("pluginsdk_launchActivity");
    this.mUseSkinEngine = ((Bundle)localObject2).getBoolean("useSkinEngine", false);
    this.mPluginResoucesType = ((Bundle)localObject2).getInt("userQqResources", 0);
    this.mPluginApkFilePath = ((Bundle)localObject2).getString("pluginsdk_pluginpath");
    if ((MobileQQ.sIsToolProc) && (this.mPluginResoucesType != 1) && (this.mPluginResoucesType != 2)) {
      throw new IllegalArgumentException("工具进程（容器进程）必须实现多资源");
    }
    PluginRecoverReceiver.addCarePluginId(this.mPluginID);
    if (TextUtils.isEmpty(this.mPluginApkFilePath)) {}
    try
    {
      this.mPluginApkFilePath = PluginUtils.getInstalledPluginPath(this, this.mPluginID).getCanonicalPath();
      label295:
      this.mUinString = ((Bundle)localObject2).getString("pluginsdk_selfuin");
      if (!TextUtils.isEmpty(this.mUinString))
      {
        mUin = this.mUinString;
        setCurrentUinForPlugin(this, this.mUinString);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(mUin)) {
          IPluginAdapterProxy.getProxy().currentUin = mUin;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity onCreate.fetchParams mUin " + mUin);
        }
        this.mPluginGestureLock = ((Bundle)localObject2).getBoolean("param_plugin_gesturelock", false);
        if ((this.mPluginGestureLock) || (getEnableGestureLock(this))) {
          mGestureLockEnable = true;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity onCreate start registerReceiver");
        }
        localObject4 = new IntentFilter();
        ((IntentFilter)localObject4).addAction("android.intent.action.SCREEN_OFF");
        try
        {
          registerReceiver(this.mScreenOffReceiver, (IntentFilter)localObject4);
          if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyActivity.onCreate Params:" + this.mPluginID + ", " + this.mLaunchActivity);
          }
          if ((this.mPluginID == null) || (this.mPluginID.length() == 0))
          {
            localObject1 = new IllegalArgumentException("Param mPluingLocation missing!");
            i = 0;
            if (i == 0) {
              super.onCreate(paramBundle);
            }
            if (localObject1 == null) {
              break label829;
            }
            this.mCreateErrorInfo = PluginUtils.getExceptionInfo((Throwable)localObject1);
            if (DebugHelper.sDebug) {
              DebugHelper.log("PluginProxyActivity.onCreate startPlugin:" + this.mPluginName + ", " + this.mCreateErrorInfo);
            }
            if (!handleStartPluginFailed((Throwable)localObject1))
            {
              showLaunchPluginFail();
              finish();
            }
            uploadStartupResult(this.mPluginName, this.mPluginID, this.mLaunchActivity, this.mCreateErrorInfo);
            if (DebugHelper.sDebug) {
              DebugHelper.log("plugin_tag", "PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
            }
            sendLaunchCompletedBroadcast();
            setStatusTrans();
            return;
            mUin = getCurrentUinForPlugin(this);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (DebugHelper.sDebug)
            {
              DebugHelper.log("plugin_tag", "register exception.", localException1);
              continue;
              try
              {
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate start initPlugin");
                }
                initPlugin();
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate end initPlugin");
                }
                uploadLaunchInfoWhenCreateClassLoader(this.mLaunchActivity, getIntent());
                this.mPluginActivity.IOnSetTheme();
                super.onCreate(paramBundle);
              }
              catch (Throwable localThrowable1)
              {
                try
                {
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
                  }
                  if (localObject1 != null) {
                    ((Bundle)localObject1).setClassLoader(PluginStatic.getClassLoader(this.mPluginID));
                  }
                  this.mPluginActivity.IOnCreate((Bundle)localObject1);
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
                  }
                  i = 1;
                  localObject1 = localObject3;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    i = 1;
                  }
                }
                localThrowable1 = localThrowable1;
                i = 0;
              }
              this.mPluginActivity = null;
              localThrowable1.printStackTrace();
              PluginRuntime.handleCrash(localThrowable1, this.mPluginID, this);
              handleCrash((Bundle)localObject2, localThrowable1);
              continue;
              label829:
              this.mCreateErrorInfo = "success";
              if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate Success");
              }
              paramBundle = getIntent().getExtras();
              if (paramBundle != null)
              {
                i = paramBundle.getInt("fling_action_key");
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity.onCreate FLING_ACTION_KEY: " + i + ", from: " + paramBundle);
                }
                if ((i != 0) && (isWrapContent())) {
                  if (1 == i) {
                    this.mFlingHandler = new FlingTrackerHandler(this);
                  } else {
                    this.mFlingHandler = new FlingGestureHandler(this);
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      int i;
      break label295;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mPluginActivity != null) {}
    try
    {
      this.mPluginActivity.IOnDestroy();
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity onDestroy");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        unregisterReceiver(this.mScreenOffReceiver);
        MobileQQ.sMobileQQ.removeOtherTypeActivity(this);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    if (this.mPluginActivity != null) {
      bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = PluginStatic.getClassLoader(this.mPluginID);
    if (localObject != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
    }
    if (this.mPluginActivity != null)
    {
      Intent localIntent = new Intent(paramIntent);
      localIntent.setExtrasClassLoader((ClassLoader)localObject);
      localObject = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        localIntent.putExtras((Bundle)localObject);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.IOnNewIntent(localIntent);
    }
    if ((this.mPluginID != null) && (!this.mPluginID.equals("BuscardPlugin.apk")) && (paramIntent != null) && ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))) {
      if (QLog.isDevelopLevel()) {
        QLog.i("PluginProxyActivity", 4, "go buscard plugin");
      }
    }
    try
    {
      ActivityLifecycle.onNewIntent(this, paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.i("PluginProxyActivity", 4, "onNewIntent failed");
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onPause");
    }
    if ((this.mPluginID != null) && (!this.mPluginID.equals("BuscardPlugin.apk"))) {}
    try
    {
      ActivityLifecycle.onPause(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.i("PluginProxyActivity", 4, "disableNFCEvent failed");
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {}
    List localList;
    do
    {
      return;
      if (this.mPluginActivity != null)
      {
        this.mPluginActivity.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        return;
      }
      localList = (List)this.mPermissionCallerMap.get(paramInt);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (localObject != null) {
            if ((localObject instanceof QQPermissionCallback))
            {
              localObject = (QQPermissionCallback)localObject;
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              while (i < paramArrayOfInt.length)
              {
                if (paramArrayOfInt[i] != 0) {
                  localArrayList.add(paramArrayOfString[i]);
                }
                i += 1;
              }
              if (localArrayList.size() > 0) {
                ((QQPermissionCallback)localObject).deny(paramInt, paramArrayOfString, paramArrayOfInt);
              } else {
                ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
              }
            }
            else
            {
              QQPermissionHelper.requestResult(localObject, paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
        }
      }
    } while (localList == null);
    this.mPermissionCallerMap.remove(paramInt);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnRestart();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    ClassLoader localClassLoader = PluginStatic.getClassLoader(this.mPluginID);
    if (localClassLoader != null) {}
    try
    {
      setClassLoaderToEveryBundle(paramBundle, localClassLoader);
      super.onRestoreInstanceState(paramBundle);
      if (this.mPluginActivity != null)
      {
        Bundle localBundle = paramBundle.getBundle("pluginsdk_inner_bundle");
        paramBundle = localBundle;
        if (localBundle == null) {
          paramBundle = new Bundle();
        }
        paramBundle.setClassLoader(localClassLoader);
        this.mPluginActivity.IOnRestoreInstanceState(paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onResume()
  {
    try
    {
      super.onResume();
      label4:
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.onResume");
      }
      if ((DebugHelper.sDebug) && (this.mPluginActivity != null)) {
        QLog.d("pluginProxy", 2, "onresume mPluginActivity=" + this.mPluginActivity + "isNeedColor=" + this.mPluginActivity.IgetImmersiveConfig().isNeedColor + "need =" + this.mActNeedImmersive);
      }
      if ((this.mPluginActivity != null) && (this.mPluginActivity.IgetImmersiveConfig().isNeedColor) && (this.mActNeedImmersive) && (this.msystemBar == null))
      {
        setImmersiveBar(this, true, this.mPluginActivity.IgetImmersiveConfig().mStatusColor);
        Drawable localDrawable = this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable;
        if ((IPluginAdapterProxy.getProxy().isDefaultMode()) && (this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable != null)) {
          setStatusDrawable(this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable);
        }
        initImmersive();
      }
      if (this.mPluginActivity != null) {
        this.mPluginActivity.IOnResume();
      }
      mAppForground = getAppForground(this);
      if ((enablePatternLock()) && (!mAppForground) && (!TextUtils.isEmpty(mUin)) && (isPatternLockOpened()) && (this.mCanLock)) {
        startUnlockActivity(true);
      }
      if (!mAppForground)
      {
        mAppForground = true;
        setAppForground(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      if ((this.mPluginID != null) && (!this.mPluginID.equals("BuscardPlugin.apk"))) {}
      try
      {
        ActivityLifecycle.onResume(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isDevelopLevel()) {}
        QLog.i("PluginProxyActivity", 4, "registerNFCEvent failed");
        return;
      }
    }
    catch (Exception localException)
    {
      break label4;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mPluginActivity != null)
    {
      Bundle localBundle2 = paramBundle.getBundle("pluginsdk_inner_bundle");
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        localBundle1 = new Bundle();
        paramBundle.putBundle("pluginsdk_inner_bundle", localBundle1);
      }
      this.mPluginActivity.IOnSaveInstanceState(localBundle1);
    }
    paramBundle.putString("pluginsdk_pluginName", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginLocation", this.mPluginID);
    paramBundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
    paramBundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
    paramBundle.putBoolean("useSkinEngine", this.mUseSkinEngine);
    paramBundle.putInt("userQqResources", this.mPluginResoucesType);
    paramBundle.putString("pluginsdk_selfuin", this.mUinString);
    paramBundle.putBoolean("param_plugin_gesturelock", this.mPluginGestureLock);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
      recreate();
    }
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.foreground");
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      localIntent.putExtra("selfuin", "");
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    mAppForground = isAppOnForeground();
    if (!mAppForground) {
      setAppForground(this, mAppForground);
    }
    this.mStopFlag = 1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      return;
    }
    super.onUserInteraction();
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    Intent localIntent;
    if (this.mIsShowQQBackgroundIcon)
    {
      localIntent = new Intent("tencent.notify.background");
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      localIntent.putExtra("selfuin", "");
      localIntent.putExtra("classname", getClass().getName());
    }
    try
    {
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (sActivityDispatchCallback != null) {
      sActivityDispatchCallback.onWindowFocusChanged(this, paramBoolean);
    }
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  @TargetApi(24)
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = paramVarArgs[i];
      if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission((String)localObject) != 0)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      int m = paramVarArgs.size();
      i = 0;
      j = k;
      if (i < m)
      {
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0)
        {
          paramVarArgs.add(paramObject);
          this.mPermissionCallerMap.put(paramInt, paramVarArgs);
        }
        requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      }
    }
    do
    {
      return;
      i += 1;
      break;
      if (!(paramObject instanceof QQPermissionCallback)) {
        break label249;
      }
      paramObject = (QQPermissionCallback)paramObject;
    } while (getApplicationInfo().targetSdkVersion >= 23);
    paramObject.grant(paramInt, paramVarArgs, null);
    return;
    label249:
    QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
  }
  
  public void setImmersiveBar(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.widget.immersive.SystemBarCompact");
      localClass.getDeclaredConstructors();
      this.msystemBar = localClass.getConstructor(new Class[] { Activity.class, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { paramActivity, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void setStatusDrawable(Drawable paramDrawable)
  {
    if (this.msystemBar != null) {}
    try
    {
      Method localMethod = this.msystemBar.getClass().getMethod("setStatusDrawable", new Class[] { Drawable.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.msystemBar, new Object[] { paramDrawable });
      return;
    }
    catch (Exception paramDrawable)
    {
      QLog.d("pluginProxy", 2, "getMethod e=" + paramDrawable);
      paramDrawable.printStackTrace();
    }
  }
  
  public void setStatusTrans()
  {
    DebugHelper.log("setStatusTrans getIsSupportImmersive=" + getIsSupportImmersive());
    if ((this.mPluginActivity != null) && (this.mNeedStatusTrans) && (this.mPluginActivity.IgetImmersiveConfig().isTranslate) && (getIsSupportImmersive() == 1)) {
      getWindow().addFlags(67108864);
    }
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    return false;
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("启动" + this.mPluginName + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new PluginProxyActivity.1(this));
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      if (!isFinishing()) {
        ((Dialog)localObject).show();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    handleIntentForQQBrowser(this, paramIntent);
    if (paramIntent.getBooleanExtra("pluginsdk_IsPluginActivity", false))
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0)) {
        startPluginActivityForResult(this, str, paramIntent, paramInt);
      }
    }
    for (;;)
    {
      this.mStopFlag = 2;
      return;
      startActivityForResult(paramIntent, paramInt, 2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    startActivityForResultWithGesture(paramIntent, paramInt1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getPluginActivity());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    FileProvider7Helper.intentCompatForN(this, paramIntent);
    ThirdAppReportHelper.startActivityForResult(this, paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithGesture(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithSnap(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.startActivityForResultWithSnap:" + paramInt2);
    }
    String str = ScreenCapture.getSnapPath(this, paramInt2);
    if (str != null)
    {
      ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
      paramIntent.putExtra("fling_action_key", 1);
      paramIntent.putExtra("fling_code_key", paramInt2);
    }
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  protected void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.mPluginName);
    localIntent.putExtra("pluginsdk_pluginLocation", this.mPluginID);
    localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    localIntent.putExtra("useSkinEngine", this.mUseSkinEngine);
    if ((this.mPluginResoucesType == 1) || (this.mPluginResoucesType == -1) || (this.mPluginResoucesType == 2)) {
      localIntent.putExtra("userQqResources", this.mPluginResoucesType);
    }
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  protected void startUnlockActivity(boolean paramBoolean)
  {
    try
    {
      startActivity(new Intent(this, Class.forName("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */