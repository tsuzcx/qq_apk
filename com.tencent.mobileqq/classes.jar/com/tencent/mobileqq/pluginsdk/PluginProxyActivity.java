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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import mqq.app.AndroidOreoUtils;
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
  public static boolean mGestureLockEnable = false;
  private static String mUin = "";
  public static IActivityDispatchCallback sActivityDispatchCallback;
  public static PluginProxyActivity.IPluginManifestChecker sChecker;
  private static Field sMMapField;
  private static Method sUnparcelMethod;
  public boolean mActNeedImmersive = true;
  AndroidOreoUtils mAndroidOreoUtils;
  private boolean mCanLock = true;
  private Class<?> mClassLaunchActivity = null;
  protected String mCreateErrorInfo = null;
  protected FlingHandler mFlingHandler;
  protected boolean mIsShowQQBackgroundIcon = true;
  protected String mLaunchActivity = null;
  protected boolean mNeedStatusTrans = true;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  protected IPluginActivity mPluginActivity = null;
  protected String mPluginApkFilePath = null;
  private boolean mPluginGestureLock = false;
  protected String mPluginID = null;
  protected String mPluginName = null;
  protected int mPluginResoucesType;
  private BroadcastReceiver mScreenOffReceiver = new PluginProxyActivity.2(this);
  protected int mStatusColor = 0;
  protected int mStopFlag = 0;
  private String mUinString = null;
  protected boolean mUseSkinEngine = false;
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
      return f * i;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
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
    boolean bool1 = paramThrowable instanceof FileNotFoundException;
    boolean bool2 = false;
    if ((!bool1) && ((paramThrowable.getMessage() == null) || (!paramThrowable.getMessage().contains("permission"))))
    {
      if ((paramThrowable instanceof Resources.NotFoundException))
      {
        showNeedUninstanllAndInstallDialog();
      }
      else
      {
        if ((!(paramThrowable instanceof ClassNotFoundException)) && (!(paramThrowable instanceof PluginUtils.GetPackageInfoFailException))) {
          return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
        }
        float f = getAvailableInnernalMemorySize();
        paramThrowable = new StringBuilder();
        paramThrowable.append("");
        paramThrowable.append(this.mPluginApkFilePath);
        paramThrowable.append(", leftSpace(B) = ");
        paramThrowable.append(f);
        QLog.d("plugin_tag", 1, paramThrowable.toString());
        PluginRecoverReceiver.broadcast(this, this.mPluginID);
        return false;
      }
    }
    else
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("");
      paramThrowable.append(this.mPluginApkFilePath);
      QLog.d("plugin_tag", 1, paramThrowable.toString());
      paramThrowable = getApplicationInfo();
      if (paramThrowable != null)
      {
        if ((paramThrowable.flags & 0x1) > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((paramThrowable.flags & 0x80) > 0) {
          bool2 = true;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UID: ");
        localStringBuilder.append(paramThrowable.uid);
        localStringBuilder.append(", IsSystemApp: ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", IsUpdateSystemApp: ");
        localStringBuilder.append(bool2);
        QLog.d("plugin_tag", 1, localStringBuilder.toString());
        paramThrowable = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG");
        paramThrowable.setPackage(MobileQQ.getContext().getPackageName());
        sendBroadcast(paramThrowable);
      }
      showNeedUninstanllAndInstallDialog();
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private void initPlugin()
  {
    Object localObject2 = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
      }
      try
      {
        localObject1 = ApkFileParser.getPackageInfoWithException(this, this.mPluginApkFilePath, 129);
        if (DebugHelper.sDebug)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PluginProxyActivity.initPlugin end getPackageInfo, ");
          ((StringBuilder)localObject2).append(localObject1);
          DebugHelper.log(((StringBuilder)localObject2).toString());
        }
        if (localObject1 != null) {
          PluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, localObject1);
        } else {
          throw new PluginUtils.GetPackageInfoFailException("Get Package Info Failed!");
        }
      }
      catch (Throwable localThrowable)
      {
        throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", localThrowable);
      }
    }
    localObject2 = sChecker;
    if (localObject2 != null) {
      ((PluginProxyActivity.IPluginManifestChecker)localObject2).doCheck(this.mPluginID, this.mLaunchActivity);
    }
    localObject2 = this.mLaunchActivity;
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      if ((localThrowable.activities != null) && (localThrowable.activities.length != 0)) {
        this.mLaunchActivity = localThrowable.activities[0].name;
      }
    }
    else
    {
      localObject2 = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mPluginApkFilePath, true);
      getIntent().setExtrasClassLoader((ClassLoader)localObject2);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mClassLaunchActivity = ((ClassLoader)localObject2).loadClass(this.mLaunchActivity);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mPluginActivity = ((IPluginActivity)this.mClassLaunchActivity.newInstance());
      this.mPluginActivity.IInit(this.mPluginID, this.mPluginApkFilePath, this, (ClassLoader)localObject2, localThrowable, this.mUseSkinEngine, this.mPluginResoucesType);
      Intent localIntent = new Intent(getIntent());
      localObject2 = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject2 != null)
      {
        localIntent.putExtras((Bundle)localObject2);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.ISetIntent(localIntent);
      return;
    }
    throw new PluginUtils.PluginActivityNotFoundException();
  }
  
  private boolean isActivityLocaleUpdated(Locale paramLocale)
  {
    Locale localLocale = locale;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localLocale != null)
    {
      if (paramLocale == null) {
        return false;
      }
      bool1 = localLocale.getLanguage().equals(paramLocale.getLanguage());
      boolean bool3 = locale.getCountry().equals(paramLocale.getCountry());
      if (bool1)
      {
        bool1 = bool2;
        if (bool3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isAppOnForeground()
  {
    boolean bool = false;
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      localObject = ((Class)localObject).getMethod("isAppOnForegroundByTasks", new Class[] { Context.class }).invoke(localObject, new Object[] { this });
      if ((localObject instanceof Boolean)) {
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {
      return true;
    }
    return !paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName());
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) {
      return true;
    }
    paramIntent = paramIntent.getComponent();
    if (paramIntent != null)
    {
      str = paramIntent.getPackageName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone"))) {
        return true;
      }
      paramIntent = paramIntent.getClassName();
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity"))) {
        return true;
      }
    }
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
    Object localObject;
    if ((sUnparcelMethod == null) || (sMMapField == null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        localObject = paramBundle.getClass();
      } else {
        localObject = paramBundle.getClass().getSuperclass();
      }
      sUnparcelMethod = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
      sUnparcelMethod.setAccessible(true);
      sMMapField = ((Class)localObject).getDeclaredField("mMap");
      sMMapField.setAccessible(true);
    }
    sUnparcelMethod.invoke(paramBundle, new Object[0]);
    paramBundle = (Map)sMMapField.get(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.values().iterator();
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if ((localObject instanceof Bundle)) {
          setClassLoaderToEveryBundle((Bundle)localObject, paramClassLoader);
        }
      }
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
    Object localObject = this.mCreateErrorInfo;
    if (localObject != null)
    {
      if ((!((String)localObject).contains("空间")) && (!this.mCreateErrorInfo.contains("Space")))
      {
        localObject = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mPluginName);
        localStringBuilder.append("启动失败!");
        safeShowToast((Context)localObject, localStringBuilder.toString(), 0);
        return;
      }
      localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统可用内存不足，");
      localStringBuilder.append(this.mPluginName);
      localStringBuilder.append("启动失败!");
      safeShowToast((Context)localObject, localStringBuilder.toString(), 0);
    }
  }
  
  public static void uploadLaunchInfoWhenCreateClassLoader(String paramString, Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getExtras();
      String str = localBundle.getString("pluginsdk_pluginLocation");
      Object localObject = (Long)PluginStatic.sClassLoaderStartTimeMap.get(str);
      long l1 = -1L;
      if (localObject != null) {
        l1 = ((Long)localObject).longValue();
      }
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
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
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
  
  protected boolean compatibleAndroidOreo()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    Object localObject = sActivityDispatchCallback;
    if (localObject != null) {
      ((IActivityDispatchCallback)localObject).disaptchTouchEventCallback(this, paramMotionEvent);
    }
    localObject = this.mPluginActivity;
    boolean bool;
    if (localObject != null) {
      bool = ((IPluginActivity)localObject).IDispatchTouchEvent(paramMotionEvent);
    } else {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean enablePatternLock()
  {
    return mGestureLockEnable;
  }
  
  public boolean getGestureLock(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, mUin });
      if ((paramContext instanceof Boolean)) {
        bool = ((Boolean)paramContext).booleanValue();
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public int getIsSupportImmersive()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.widget.immersive.ImmersiveUtils");
      localObject = ((Class)localObject).getMethod("isSupporImmersive", new Class[0]).invoke(localObject, new Object[0]);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIsSupportImmersive ret=");
      localStringBuilder.append(localObject);
      DebugHelper.log(localStringBuilder.toString());
      if ((localObject instanceof Integer))
      {
        int i = ((Integer)localObject).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIsSupportImmersive e=");
      localStringBuilder.append(localException);
      QLog.d("pluginProxy", 2, localStringBuilder.toString());
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
    Object localObject = this.msystemBar;
    if (localObject != null) {
      try
      {
        localObject = localObject.getClass().getMethod("init", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(this.msystemBar, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected boolean isPatternLockOpened()
  {
    return getGestureLock(this, mUin);
  }
  
  protected boolean isWrapContent()
  {
    Object localObject = this.mPluginActivity;
    boolean bool;
    if (localObject != null) {
      bool = ((IPluginActivity)localObject).IIsWrapContent();
    } else {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PluginProxyActivity.isWrapContent: ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(", from = ");
    ((StringBuilder)localObject).append(this.mPluginActivity);
    DebugHelper.debug(((StringBuilder)localObject).toString());
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPluginActivity != null) {
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
        paramIntent.printStackTrace();
      }
    }
    this.mCanLock = false;
  }
  
  public void onBackPressed()
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    boolean bool;
    if (localIPluginActivity != null) {
      bool = localIPluginActivity.IOnBackPressed();
    } else {
      bool = false;
    }
    if (!bool) {}
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label30:
      break label30;
    }
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = this.mPluginActivity;
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnConfigurationChanged(paramConfiguration);
    }
    if (isWrapContent())
    {
      localObject = this.mFlingHandler;
      if (localObject != null) {
        ((FlingHandler)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate");
    }
    this.mAndroidOreoUtils = new AndroidOreoUtils(this);
    Object localObject1;
    Object localObject3;
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale))
    {
      localObject1 = getResources();
      localObject3 = ((Resources)localObject1).getConfiguration();
      localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(((Resources)localObject1).getDisplayMetrics());
      ((Configuration)localObject3).locale = locale;
      ((Resources)localObject1).updateConfiguration((Configuration)localObject3, ((Resources)localObject1).getDisplayMetrics());
      ((Resources)localObject1).getDisplayMetrics().setTo(localDisplayMetrics);
    }
    MobileQQ.sMobileQQ.addOtherTypeActivity(this);
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
    }
    DisplayMetrics localDisplayMetrics = null;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getBundle("pluginsdk_inner_bundle");
      localObject3 = paramBundle;
    }
    else
    {
      localObject3 = getIntent().getExtras();
      localObject1 = null;
    }
    boolean bool;
    if (!PluginStatic.isValidPluginIntent((Bundle)localObject3))
    {
      if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()))
      {
        bool = this.mAndroidOreoUtils.fixOrientation();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCreate fixOrientation when Oreo, result1 = ");
        ((StringBuilder)localObject1).append(bool);
        QLog.i("PluginProxyActivity", 1, ((StringBuilder)localObject1).toString());
      }
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.mPluginName = ((Bundle)localObject3).getString("pluginsdk_pluginName");
    this.mPluginID = ((Bundle)localObject3).getString("pluginsdk_pluginLocation");
    this.mLaunchActivity = ((Bundle)localObject3).getString("pluginsdk_launchActivity");
    int j = 0;
    int i = 0;
    this.mUseSkinEngine = ((Bundle)localObject3).getBoolean("useSkinEngine", false);
    this.mPluginResoucesType = ((Bundle)localObject3).getInt("userQqResources", 0);
    this.mPluginApkFilePath = ((Bundle)localObject3).getString("pluginsdk_pluginpath");
    if (MobileQQ.sIsToolProc)
    {
      int k = this.mPluginResoucesType;
      if ((k != 1) && (k != 2)) {
        throw new IllegalArgumentException("工具进程（容器进程）必须实现多资源");
      }
    }
    PluginRecoverReceiver.addCarePluginId(this.mPluginID);
    if (TextUtils.isEmpty(this.mPluginApkFilePath)) {}
    try
    {
      this.mPluginApkFilePath = PluginUtils.getInstalledPluginPath(this, this.mPluginID).getCanonicalPath();
    }
    catch (Exception localException2)
    {
      label410:
      Object localObject4;
      Object localObject5;
      Object localObject2;
      break label410;
    }
    this.mUinString = ((Bundle)localObject3).getString("pluginsdk_selfuin");
    if (!TextUtils.isEmpty(this.mUinString))
    {
      localObject4 = this.mUinString;
      mUin = (String)localObject4;
      setCurrentUinForPlugin(this, (String)localObject4);
    }
    else
    {
      mUin = getCurrentUinForPlugin(this);
    }
    if (!TextUtils.isEmpty(mUin)) {
      IPluginAdapterProxy.getProxy().currentUin = mUin;
    }
    if (DebugHelper.sDebug)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("PluginProxyActivity onCreate.fetchParams mUin ");
      ((StringBuilder)localObject4).append(mUin);
      DebugHelper.log(((StringBuilder)localObject4).toString());
    }
    this.mPluginGestureLock = ((Bundle)localObject3).getBoolean("param_plugin_gesturelock", false);
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
    }
    catch (Exception localException1)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "register exception.", localException1);
      }
    }
    if (DebugHelper.sDebug)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("PluginProxyActivity.onCreate Params:");
      ((StringBuilder)localObject5).append(this.mPluginID);
      ((StringBuilder)localObject5).append(", ");
      ((StringBuilder)localObject5).append(this.mLaunchActivity);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject5).toString());
    }
    localObject5 = this.mPluginID;
    if ((localObject5 != null) && (((String)localObject5).length() != 0))
    {
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
        if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()))
        {
          bool = this.mAndroidOreoUtils.fixOrientation();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("onCreate fixOrientation when Oreo, result2 = ");
          ((StringBuilder)localObject5).append(bool);
          QLog.i("PluginProxyActivity", 1, ((StringBuilder)localObject5).toString());
        }
        if (localObject1 != null) {
          ((Bundle)localObject1).setClassLoader(PluginStatic.getClassLoader(this.mPluginID));
        }
        super.onCreate(paramBundle);
        try
        {
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
          }
          this.mPluginActivity.IOnCreate((Bundle)localObject1);
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
          }
          i = 1;
          localObject1 = localDisplayMetrics;
        }
        catch (Throwable localThrowable1)
        {
          i = 1;
        }
        this.mPluginActivity = null;
      }
      catch (Throwable localThrowable2) {}
      localThrowable2.printStackTrace();
      PluginRuntime.handleCrash(localThrowable2, this.mPluginID, this);
      handleCrash((Bundle)localObject3, localThrowable2);
    }
    else
    {
      localObject2 = new IllegalArgumentException("Param mPluingLocation missing!");
      i = j;
    }
    if (i == 0)
    {
      if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()))
      {
        bool = this.mAndroidOreoUtils.fixOrientation();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onCreate fixOrientation when Oreo, result3 = ");
        ((StringBuilder)localObject3).append(bool);
        QLog.i("PluginProxyActivity", 1, ((StringBuilder)localObject3).toString());
      }
      super.onCreate(paramBundle);
    }
    if (localObject2 != null)
    {
      this.mCreateErrorInfo = PluginUtils.getExceptionInfo((Throwable)localObject2);
      if (DebugHelper.sDebug)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("PluginProxyActivity.onCreate startPlugin:");
        paramBundle.append(this.mPluginName);
        paramBundle.append(", ");
        paramBundle.append(this.mCreateErrorInfo);
        DebugHelper.log(paramBundle.toString());
      }
      if (!handleStartPluginFailed((Throwable)localObject2))
      {
        showLaunchPluginFail();
        finish();
      }
    }
    else
    {
      this.mCreateErrorInfo = "success";
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.onCreate Success");
      }
      paramBundle = getIntent().getExtras();
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fling_action_key");
        if (DebugHelper.sDebug)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PluginProxyActivity.onCreate FLING_ACTION_KEY: ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", from: ");
          ((StringBuilder)localObject2).append(paramBundle);
          DebugHelper.log(((StringBuilder)localObject2).toString());
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
    uploadStartupResult(this.mPluginName, this.mPluginID, this.mLaunchActivity, this.mCreateErrorInfo);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
    }
    sendLaunchCompletedBroadcast();
    setStatusTrans();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      return localIPluginActivity.IOnCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      try
      {
        localIPluginActivity.IOnDestroy();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onDestroy");
    }
    try
    {
      unregisterReceiver(this.mScreenOffReceiver);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    MobileQQ.sMobileQQ.removeOtherTypeActivity(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    boolean bool1;
    if (localIPluginActivity != null) {
      bool1 = localIPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      return localIPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject2 = PluginStatic.getClassLoader(this.mPluginID);
    if (localObject2 != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject2);
    }
    if (this.mPluginActivity != null)
    {
      localObject1 = new Intent(paramIntent);
      ((Intent)localObject1).setExtrasClassLoader((ClassLoader)localObject2);
      localObject2 = ((Intent)localObject1).getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ((Intent)localObject1).removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.IOnNewIntent((Intent)localObject1);
    }
    Object localObject1 = this.mPluginID;
    if ((localObject1 != null) && (!((String)localObject1).equals("BuscardPlugin.apk")) && (paramIntent != null) && ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))) {
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
      label133:
      break label133;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PluginProxyActivity", 4, "onNewIntent failed");
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      return localIPluginActivity.IOnOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    Object localObject = this.mPluginActivity;
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnPause();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onPause");
    }
    localObject = this.mPluginID;
    if ((localObject != null) && (!((String)localObject).equals("BuscardPlugin.apk"))) {}
    try
    {
      ActivityLifecycle.onPause(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      label55:
      break label55;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PluginProxyActivity", 4, "disableNFCEvent failed");
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      return localIPluginActivity.IOnPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {
      return;
    }
    Object localObject1 = this.mPluginActivity;
    if (localObject1 != null)
    {
      ((IPluginActivity)localObject1).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    localObject1 = (List)this.mPermissionCallerMap.get(paramInt);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (localObject2 != null) {
          if ((localObject2 instanceof QQPermissionCallback))
          {
            localObject2 = (QQPermissionCallback)localObject2;
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
              ((QQPermissionCallback)localObject2).deny(paramInt, paramArrayOfString, paramArrayOfInt);
            } else {
              ((QQPermissionCallback)localObject2).grant(paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
          else
          {
            QQPermissionHelper.requestResult(localObject2, paramInt, paramArrayOfString, paramArrayOfInt);
          }
        }
      }
    }
    if (localObject1 != null) {
      this.mPermissionCallerMap.remove(paramInt);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnRestart();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    ClassLoader localClassLoader = PluginStatic.getClassLoader(this.mPluginID);
    if (localClassLoader != null) {
      try
      {
        setClassLoaderToEveryBundle(paramBundle, localClassLoader);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
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
      if ((DebugHelper.sDebug) && (this.mPluginActivity != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onresume mPluginActivity=");
        ((StringBuilder)localObject).append(this.mPluginActivity);
        ((StringBuilder)localObject).append("isNeedColor=");
        ((StringBuilder)localObject).append(this.mPluginActivity.IgetImmersiveConfig().isNeedColor);
        ((StringBuilder)localObject).append("need =");
        ((StringBuilder)localObject).append(this.mActNeedImmersive);
        QLog.d("pluginProxy", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.mPluginActivity;
      if ((localObject != null) && (((IPluginActivity)localObject).IgetImmersiveConfig().isNeedColor) && (this.mActNeedImmersive) && (this.msystemBar == null))
      {
        setImmersiveBar(this, true, this.mPluginActivity.IgetImmersiveConfig().mStatusColor);
        localObject = this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable;
        if ((IPluginAdapterProxy.getProxy().isDefaultMode()) && (this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable != null)) {
          setStatusDrawable(this.mPluginActivity.IgetImmersiveConfig().mStatusDrawable);
        }
        initImmersive();
      }
      localObject = this.mPluginActivity;
      if (localObject != null) {
        ((IPluginActivity)localObject).IOnResume();
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
      localObject = this.mPluginID;
      if ((localObject != null) && (!((String)localObject).equals("BuscardPlugin.apk"))) {}
      try
      {
        ActivityLifecycle.onResume(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        label333:
        break label333;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PluginProxyActivity", 4, "registerNFCEvent failed");
      }
      return;
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
    Object localObject = this.mPluginActivity;
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      localObject = new Intent("tencent.notify.foreground");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("selfuin", "");
      sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
    if (isWrapContent())
    {
      localObject = this.mFlingHandler;
      if (localObject != null) {
        ((FlingHandler)localObject).onStart();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStop();
    }
    mAppForground = isAppOnForeground();
    boolean bool = mAppForground;
    if (!bool) {
      setAppForground(this, bool);
    }
    this.mStopFlag = 1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null) {
      return localIPluginActivity.IOnTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    if (localIPluginActivity != null)
    {
      localIPluginActivity.IOnUserInteraction();
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
    Object localObject = sActivityDispatchCallback;
    if (localObject != null) {
      ((IActivityDispatchCallback)localObject).onWindowFocusChanged(this, paramBoolean);
    }
    localObject = this.mPluginActivity;
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  @TargetApi(24)
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int k = 0;
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
    if (localArrayList.size() > 0)
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      int m = paramVarArgs.size();
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j == 0)
      {
        paramVarArgs.add(paramObject);
        this.mPermissionCallerMap.put(paramInt, paramVarArgs);
      }
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
    }
    if ((paramObject instanceof QQPermissionCallback))
    {
      paramObject = (QQPermissionCallback)paramObject;
      if (getApplicationInfo().targetSdkVersion < 23) {
        paramObject.grant(paramInt, paramVarArgs, null);
      }
    }
    else
    {
      QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
    }
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
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (compatibleAndroidOreo()) && (getApplicationInfo().targetSdkVersion >= 27) && (this.mAndroidOreoUtils.isTranslucentOrFloating()))
    {
      AndroidOreoUtils localAndroidOreoUtils = this.mAndroidOreoUtils;
      if (localAndroidOreoUtils.isFixedOrientation(localAndroidOreoUtils.getCurrentActivityInfo(), paramInt))
      {
        QLog.i("PluginProxyActivity", 1, "avoid calling setRequestedOrientation when Oreo.");
        return;
      }
    }
    super.setRequestedOrientation(paramInt);
  }
  
  public void setStatusDrawable(Drawable paramDrawable)
  {
    Object localObject = this.msystemBar;
    if (localObject != null) {
      try
      {
        localObject = localObject.getClass().getMethod("setStatusDrawable", new Class[] { Drawable.class });
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(this.msystemBar, new Object[] { paramDrawable });
        return;
      }
      catch (Exception paramDrawable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMethod e=");
        ((StringBuilder)localObject).append(paramDrawable);
        QLog.d("pluginProxy", 2, ((StringBuilder)localObject).toString());
        paramDrawable.printStackTrace();
      }
    }
  }
  
  public void setStatusTrans()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStatusTrans getIsSupportImmersive=");
    ((StringBuilder)localObject).append(getIsSupportImmersive());
    DebugHelper.log(((StringBuilder)localObject).toString());
    localObject = this.mPluginActivity;
    if ((localObject != null) && (this.mNeedStatusTrans) && (((IPluginActivity)localObject).IgetImmersiveConfig().isTranslate) && (getIsSupportImmersive() == 1)) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("启动");
    localStringBuilder.append(this.mPluginName);
    localStringBuilder.append("失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setMessage(localStringBuilder.toString());
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
    else
    {
      startActivityForResult(paramIntent, paramInt, 2);
    }
    this.mStopFlag = 2;
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
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          super.startActivityForResult(paramIntent, paramInt1);
          return;
        }
        startActivityForResultWithGesture(paramIntent, paramInt1);
        return;
      }
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt1);
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
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyActivity.startActivityForResultWithSnap:");
      ((StringBuilder)localObject).append(paramInt2);
      DebugHelper.log(((StringBuilder)localObject).toString());
    }
    Object localObject = ScreenCapture.getSnapPath(this, paramInt2);
    if (localObject != null)
    {
      ScreenCapture.captureViewToFile((String)localObject, getWindow().getDecorView());
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
    int i = this.mPluginResoucesType;
    if ((i == 1) || (i == -1) || (i == 2)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */