package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginProxyActivity
  extends Activity
{
  public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  public static final String ACTION_PLUGIN_STARTUP_SPEED_INFO = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO";
  protected static final String INNER_INTENT_EXTRAS = "pluginsdk_inner_intent_extras";
  public static final String LAUNCH_TOTAL = "launchTotal";
  public static final String LAUNCH_TYPE = "launchType";
  public static final int LAUNCH_TYPE_FIRST = 1;
  public static final int LAUNCH_TYPE_OTHER = -1;
  public static final String READER_ID = "qqreaderplugin.apk";
  private static final String b = "PluginProxyActivity";
  private static final String c = "pluginsdk_inner_bundle";
  private static String g = "";
  private static Method j;
  private static Field k;
  public static boolean mAppForground = true;
  public static boolean mGestureLockEnable;
  public static IPluginManifestChecker sChecker;
  Object a;
  private Class d;
  private String e;
  private boolean f;
  private boolean h = true;
  private BroadcastReceiver i = new l(this);
  public boolean mActNeedImmersive = true;
  protected String mCreateErrorInfo;
  protected FlingHandler mFlingHandler;
  protected boolean mIsShowQQBackgroundIcon = true;
  protected String mLaunchActivity;
  protected boolean mNeedStatusTrans = true;
  protected IPluginActivity mPluginActivity;
  protected String mPluginApkFilePath;
  protected String mPluginID;
  protected String mPluginName;
  protected int mPluginResoucesType;
  protected int mStatusColor = 0;
  protected int mStopFlag;
  protected boolean mUseSkinEngine;
  
  private void a()
  {
    if (this.mCreateErrorInfo != null)
    {
      if ((this.mCreateErrorInfo.contains("空间")) || (this.mCreateErrorInfo.contains("Space"))) {
        a(BaseApplication.getContext(), "系统可用内存不足，" + this.mPluginName + "启动失败!", 0);
      }
    }
    else {
      return;
    }
    a(BaseApplication.getContext(), this.mPluginName + "启动失败!", 0);
  }
  
  private void a(Context paramContext, String paramString)
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
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Toast.makeText(paramContext, paramString, paramInt).show();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void a(Context paramContext, boolean paramBoolean)
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
  
  private static void a(Bundle paramBundle, ClassLoader paramClassLoader)
    throws Exception
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.setClassLoader(paramClassLoader);
    if ((j == null) || (k == null)) {
      if (Build.VERSION.SDK_INT >= 21) {
        break label144;
      }
    }
    label144:
    for (Object localObject = paramBundle.getClass();; localObject = paramBundle.getClass().getSuperclass())
    {
      j = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
      j.setAccessible(true);
      k = ((Class)localObject).getDeclaredField("mMap");
      k.setAccessible(true);
      j.invoke(paramBundle, new Object[0]);
      paramBundle = (Map)k.get(paramBundle);
      if (paramBundle == null) {
        break;
      }
      paramBundle = paramBundle.values().iterator();
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if ((localObject instanceof Bundle)) {
          a((Bundle)localObject, paramClassLoader);
        }
      }
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("clsUploader");
    localObject = ((Intent)localObject).getStringExtra("pluginsdk_selfuin");
    if (str != null)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO");
      localIntent.putExtra("pluginsdk_selfuin", (String)localObject);
      localIntent.putExtra("pluginsdk_pluginName", paramString1);
      localIntent.putExtra("pluginsdk_pluginLocation", paramString2);
      localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
      localIntent.putExtra("pluginsdk_launchActivity", paramString3);
      localIntent.putExtra("clsUploader", str);
      localIntent.putExtra("launchTotal", paramLong1);
      localIntent.putExtra("launchType", paramLong2);
      sendBroadcast(localIntent);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
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
      sendBroadcast(localIntent);
    }
  }
  
  private boolean a(Context paramContext)
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
  
  private boolean a(Intent paramIntent)
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
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool2 = false;
    if (((paramThrowable instanceof FileNotFoundException)) || ((paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("permission"))))
    {
      QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath);
      paramThrowable = getApplicationInfo();
      if (paramThrowable != null) {
        if ((paramThrowable.flags & 0x1) <= 0) {
          break label163;
        }
      }
      label163:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramThrowable.flags & 0x80) > 0) {
          bool2 = true;
        }
        QLog.d("plugin_tag", 1, "UID: " + paramThrowable.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        sendBroadcast(new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG"));
        showNeedUninstanllAndInstallDialog();
        return true;
      }
    }
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    if (((paramThrowable instanceof ClassNotFoundException)) || ((paramThrowable instanceof PluginUtils.a)))
    {
      float f1 = getAvailableInnernalMemorySize();
      QLog.d("plugin_tag", 1, "" + this.mPluginApkFilePath + ", leftSpace(B) = " + f1);
      PluginRecoverReceiver.a(this, this.mPluginID);
      return false;
    }
    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
  }
  
  private void b()
    throws Exception
  {
    PackageInfo localPackageInfo = (PackageInfo)PluginStatic.d.get(this.mPluginApkFilePath);
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
          throw new PluginUtils.a("Get Package Info Failed!");
        }
      }
      catch (Throwable localThrowable)
      {
        throw new PluginUtils.a("getPackageInfoWithException", localThrowable);
      }
      PluginStatic.d.put(this.mPluginApkFilePath, localThrowable);
    }
    for (;;)
    {
      if (sChecker != null) {
        sChecker.doCheck(this.mPluginID, this.mLaunchActivity);
      }
      if ((this.mLaunchActivity == null) || (this.mLaunchActivity.length() == 0))
      {
        if ((localThrowable.activities == null) || (localThrowable.activities.length == 0)) {
          throw new PluginUtils.b();
        }
        this.mLaunchActivity = localThrowable.activities[0].name;
      }
      Object localObject = PluginStatic.a(this, this.mPluginID, this.mPluginApkFilePath);
      getIntent().setExtrasClassLoader((ClassLoader)localObject);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.d = ((ClassLoader)localObject).loadClass(this.mLaunchActivity);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.mPluginActivity = ((IPluginActivity)this.d.newInstance());
      this.mPluginActivity.IInit(this.mPluginID, this.mPluginApkFilePath, this, (ClassLoader)localObject, localThrowable, this.mUseSkinEngine, this.mPluginResoucesType);
      Intent localIntent = new Intent(getIntent());
      localObject = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        localIntent.putExtras((Bundle)localObject);
        localIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.ISetIntent(localIntent);
      long l1 = getIntent().getLongExtra("plugin_launch_time", System.currentTimeMillis());
      long l2 = System.currentTimeMillis();
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPluginCost " + (l2 - l1));
      }
      return;
    }
  }
  
  private boolean b(Context paramContext)
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
  
  private String c(Context paramContext)
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
  
  private void c()
  {
    Intent localIntent = new Intent("action_launch_completed");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    sendBroadcast(localIntent);
  }
  
  private boolean d()
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
  
  public static float getAvailableInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f1 = ((StatFs)localObject).getAvailableBlocks();
      int m = ((StatFs)localObject).getBlockSize();
      return m * f1;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public static void openActivity(Context paramContext, Intent paramIntent, StartActivityParams paramStartActivityParams)
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
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
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, g });
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
        int m = ((Integer)localObject).intValue();
        return m;
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
  
  public String getPluginID()
  {
    return null;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  protected void handleCrash(Bundle paramBundle, Throwable paramThrowable) {}
  
  public void initImmersive()
  {
    if (this.a != null) {}
    try
    {
      Method localMethod = this.a.getClass().getMethod("init", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.a, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean isPatternLockOpened()
  {
    return getGestureLock(this, g);
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
    this.h = false;
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
  
  /* Error */
  protected void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_2
    //   8: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   11: ifeq +9 -> 20
    //   14: ldc_w 745
    //   17: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   20: getstatic 751	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   23: aload_0
    //   24: invokevirtual 755	mqq/app/MobileQQ:addOtherTypeActivity	(Landroid/app/Activity;)V
    //   27: invokestatic 759	com/tencent/mobileqq/pluginsdk/a:a	()V
    //   30: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   33: ifeq +9 -> 42
    //   36: ldc_w 761
    //   39: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +32 -> 75
    //   46: aload_1
    //   47: ldc 43
    //   49: invokevirtual 764	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   52: astore 11
    //   54: aload_1
    //   55: astore 12
    //   57: aload 12
    //   59: invokestatic 767	com/tencent/mobileqq/pluginsdk/PluginStatic:a	(Landroid/os/Bundle;)Z
    //   62: ifne +28 -> 90
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 769	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   70: aload_0
    //   71: invokevirtual 728	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:finish	()V
    //   74: return
    //   75: aload_0
    //   76: invokevirtual 278	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   79: invokevirtual 630	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   82: astore 12
    //   84: aconst_null
    //   85: astore 11
    //   87: goto -30 -> 57
    //   90: aload_0
    //   91: aload 12
    //   93: ldc_w 297
    //   96: invokevirtual 683	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 136	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginName	Ljava/lang/String;
    //   102: aload_0
    //   103: aload 12
    //   105: ldc_w 299
    //   108: invokevirtual 683	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   114: aload_0
    //   115: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   118: invokestatic 714	com/tencent/mobileqq/pluginsdk/PluginStatic:getClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   121: ifnonnull +88 -> 209
    //   124: iconst_1
    //   125: istore_3
    //   126: aload_0
    //   127: aload 12
    //   129: ldc_w 305
    //   132: invokevirtual 683	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: putfield 462	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   138: aload_0
    //   139: aload 12
    //   141: ldc_w 600
    //   144: iconst_0
    //   145: invokevirtual 773	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   148: putfield 506	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mUseSkinEngine	Z
    //   151: aload_0
    //   152: aload 12
    //   154: ldc_w 607
    //   157: iconst_0
    //   158: invokevirtual 777	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   161: putfield 508	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginResoucesType	I
    //   164: aload_0
    //   165: aload 12
    //   167: ldc_w 301
    //   170: invokevirtual 683	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: putfield 303	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   176: getstatic 780	mqq/app/MobileQQ:sIsToolProc	Z
    //   179: ifeq +35 -> 214
    //   182: aload_0
    //   183: getfield 508	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginResoucesType	I
    //   186: iconst_1
    //   187: if_icmpeq +27 -> 214
    //   190: aload_0
    //   191: getfield 508	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginResoucesType	I
    //   194: iconst_2
    //   195: if_icmpeq +19 -> 214
    //   198: new 782	java/lang/IllegalArgumentException
    //   201: dup
    //   202: ldc_w 784
    //   205: invokespecial 785	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: iconst_0
    //   210: istore_3
    //   211: goto -85 -> 126
    //   214: aload_0
    //   215: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   218: invokestatic 787	com/tencent/mobileqq/pluginsdk/PluginRecoverReceiver:a	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield 303	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   225: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifeq +18 -> 246
    //   231: aload_0
    //   232: aload_0
    //   233: aload_0
    //   234: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   237: invokestatic 793	com/tencent/mobileqq/pluginsdk/PluginUtils:getInstalledPluginPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   240: invokevirtual 796	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   243: putfield 303	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   246: aload_0
    //   247: aload 12
    //   249: ldc_w 288
    //   252: invokevirtual 683	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 798	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:e	Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 798	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:e	Ljava/lang/String;
    //   262: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifne +394 -> 659
    //   268: aload_0
    //   269: getfield 798	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:e	Ljava/lang/String;
    //   272: putstatic 86	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:g	Ljava/lang/String;
    //   275: aload_0
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 798	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:e	Ljava/lang/String;
    //   281: invokespecial 799	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   284: getstatic 86	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:g	Ljava/lang/String;
    //   287: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifne +12 -> 302
    //   293: invokestatic 616	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   296: getstatic 86	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:g	Ljava/lang/String;
    //   299: putfield 619	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:currentUin	Ljava/lang/String;
    //   302: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   305: ifeq +28 -> 333
    //   308: new 127	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 801
    //   318: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: getstatic 86	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:g	Ljava/lang/String;
    //   324: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   333: aload_0
    //   334: aload 12
    //   336: ldc_w 803
    //   339: iconst_0
    //   340: invokevirtual 773	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   343: putfield 805	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:f	Z
    //   346: aload_0
    //   347: getfield 805	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:f	Z
    //   350: ifne +11 -> 361
    //   353: aload_0
    //   354: aload_0
    //   355: invokespecial 807	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:b	(Landroid/content/Context;)Z
    //   358: ifeq +7 -> 365
    //   361: iconst_1
    //   362: putstatic 659	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mGestureLockEnable	Z
    //   365: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   368: ifeq +9 -> 377
    //   371: ldc_w 809
    //   374: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   377: new 811	android/content/IntentFilter
    //   380: dup
    //   381: invokespecial 812	android/content/IntentFilter:<init>	()V
    //   384: astore 14
    //   386: aload 14
    //   388: ldc_w 814
    //   391: invokevirtual 817	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 107	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:i	Landroid/content/BroadcastReceiver;
    //   399: aload 14
    //   401: invokevirtual 821	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   404: pop
    //   405: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   408: ifeq +45 -> 453
    //   411: ldc_w 359
    //   414: new 127	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 823
    //   424: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   431: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 825
    //   437: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_0
    //   441: getfield 462	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   444: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 827	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   457: ifnull +13 -> 470
    //   460: aload_0
    //   461: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   464: invokevirtual 470	java/lang/String:length	()I
    //   467: ifne +225 -> 692
    //   470: new 782	java/lang/IllegalArgumentException
    //   473: dup
    //   474: ldc_w 829
    //   477: invokespecial 785	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   480: astore 11
    //   482: iload_2
    //   483: ifne +8 -> 491
    //   486: aload_0
    //   487: aload_1
    //   488: invokespecial 769	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   491: aload 11
    //   493: ifnull +338 -> 831
    //   496: aload_0
    //   497: aload 11
    //   499: invokestatic 833	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   502: putfield 109	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   505: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   508: ifeq +42 -> 550
    //   511: new 127	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 835
    //   521: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload_0
    //   525: getfield 136	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginName	Ljava/lang/String;
    //   528: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: ldc_w 825
    //   534: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_0
    //   538: getfield 109	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   541: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   550: aload_0
    //   551: aload 11
    //   553: invokespecial 837	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:a	(Ljava/lang/Throwable;)Z
    //   556: ifne +11 -> 567
    //   559: aload_0
    //   560: invokespecial 838	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:a	()V
    //   563: aload_0
    //   564: invokevirtual 728	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:finish	()V
    //   567: aload_0
    //   568: aload_0
    //   569: getfield 136	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginName	Ljava/lang/String;
    //   572: aload_0
    //   573: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   576: aload_0
    //   577: getfield 462	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   580: aload_0
    //   581: getfield 109	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   584: invokespecial 840	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   587: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   590: ifeq +12 -> 602
    //   593: ldc_w 359
    //   596: ldc_w 842
    //   599: invokestatic 827	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_0
    //   603: invokespecial 844	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:c	()V
    //   606: aload_0
    //   607: invokevirtual 847	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:setStatusTrans	()V
    //   610: aload_0
    //   611: invokevirtual 278	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   614: ldc_w 530
    //   617: lconst_0
    //   618: invokevirtual 540	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   621: lstore 7
    //   623: invokestatic 536	java/lang/System:currentTimeMillis	()J
    //   626: lstore 9
    //   628: iload_3
    //   629: ifeq +326 -> 955
    //   632: lconst_1
    //   633: lstore 5
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 136	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginName	Ljava/lang/String;
    //   640: aload_0
    //   641: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   644: aload_0
    //   645: getfield 462	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   648: lload 9
    //   650: lload 7
    //   652: lsub
    //   653: lload 5
    //   655: invokespecial 849	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V
    //   658: return
    //   659: aload_0
    //   660: aload_0
    //   661: invokespecial 851	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:c	(Landroid/content/Context;)Ljava/lang/String;
    //   664: putstatic 86	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:g	Ljava/lang/String;
    //   667: goto -383 -> 284
    //   670: astore 14
    //   672: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   675: ifeq -270 -> 405
    //   678: ldc_w 359
    //   681: ldc_w 853
    //   684: aload 14
    //   686: invokestatic 856	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   689: goto -284 -> 405
    //   692: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   695: ifeq +9 -> 704
    //   698: ldc_w 858
    //   701: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   704: aload_0
    //   705: invokespecial 860	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:b	()V
    //   708: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   711: ifeq +9 -> 720
    //   714: ldc_w 862
    //   717: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   720: aload_0
    //   721: getfield 504	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginActivity	Lcom/tencent/mobileqq/pluginsdk/IPluginActivity;
    //   724: invokeinterface 865 1 0
    //   729: aload_0
    //   730: aload_1
    //   731: invokespecial 769	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   734: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   737: ifeq +9 -> 746
    //   740: ldc_w 867
    //   743: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   746: aload 11
    //   748: ifnull +15 -> 763
    //   751: aload 11
    //   753: aload_0
    //   754: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   757: invokestatic 714	com/tencent/mobileqq/pluginsdk/PluginStatic:getClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   760: invokevirtual 210	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   763: aload_0
    //   764: getfield 504	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginActivity	Lcom/tencent/mobileqq/pluginsdk/IPluginActivity;
    //   767: aload 11
    //   769: invokeinterface 870 2 0
    //   774: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   777: ifeq +9 -> 786
    //   780: ldc_w 872
    //   783: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   786: iconst_1
    //   787: istore_2
    //   788: aload 13
    //   790: astore 11
    //   792: goto -310 -> 482
    //   795: astore 11
    //   797: iload 4
    //   799: istore_2
    //   800: aload_0
    //   801: aconst_null
    //   802: putfield 504	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginActivity	Lcom/tencent/mobileqq/pluginsdk/IPluginActivity;
    //   805: aload 11
    //   807: invokevirtual 873	java/lang/Throwable:printStackTrace	()V
    //   810: aload 11
    //   812: aload_0
    //   813: getfield 408	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mPluginID	Ljava/lang/String;
    //   816: aload_0
    //   817: invokestatic 878	com/tencent/mobileqq/pluginsdk/PluginRuntime:handleCrash	(Ljava/lang/Throwable;Ljava/lang/String;Landroid/content/Context;)V
    //   820: aload_0
    //   821: aload 12
    //   823: aload 11
    //   825: invokevirtual 880	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:handleCrash	(Landroid/os/Bundle;Ljava/lang/Throwable;)V
    //   828: goto -346 -> 482
    //   831: aload_0
    //   832: ldc_w 882
    //   835: putfield 109	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   838: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   841: ifeq +9 -> 850
    //   844: ldc_w 884
    //   847: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   850: aload_0
    //   851: invokevirtual 278	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   854: invokevirtual 630	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   857: astore_1
    //   858: aload_1
    //   859: ifnull -292 -> 567
    //   862: aload_1
    //   863: ldc_w 886
    //   866: invokevirtual 889	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   869: istore_2
    //   870: getstatic 431	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   873: ifeq +36 -> 909
    //   876: new 127	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   883: ldc_w 891
    //   886: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: iload_2
    //   890: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: ldc_w 893
    //   896: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_1
    //   900: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   903: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 436	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   909: iload_2
    //   910: ifeq -343 -> 567
    //   913: aload_0
    //   914: invokevirtual 737	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:isWrapContent	()Z
    //   917: ifeq -350 -> 567
    //   920: iconst_1
    //   921: iload_2
    //   922: if_icmpne +18 -> 940
    //   925: aload_0
    //   926: new 895	com/tencent/mobileqq/activity/fling/FlingTrackerHandler
    //   929: dup
    //   930: aload_0
    //   931: invokespecial 897	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:<init>	(Landroid/app/Activity;)V
    //   934: putfield 739	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mFlingHandler	Lcom/tencent/mobileqq/activity/fling/FlingHandler;
    //   937: goto -370 -> 567
    //   940: aload_0
    //   941: new 899	com/tencent/mobileqq/activity/fling/FlingGestureHandler
    //   944: dup
    //   945: aload_0
    //   946: invokespecial 900	com/tencent/mobileqq/activity/fling/FlingGestureHandler:<init>	(Landroid/app/Activity;)V
    //   949: putfield 739	com/tencent/mobileqq/pluginsdk/PluginProxyActivity:mFlingHandler	Lcom/tencent/mobileqq/activity/fling/FlingHandler;
    //   952: goto -385 -> 567
    //   955: ldc2_w 901
    //   958: lstore 5
    //   960: goto -325 -> 635
    //   963: astore 11
    //   965: iconst_1
    //   966: istore_2
    //   967: goto -167 -> 800
    //   970: astore 14
    //   972: goto -726 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	this	PluginProxyActivity
    //   0	975	1	paramBundle	Bundle
    //   7	960	2	m	int
    //   125	504	3	n	int
    //   4	794	4	i1	int
    //   633	326	5	l1	long
    //   621	30	7	l2	long
    //   626	23	9	l3	long
    //   52	739	11	localObject1	Object
    //   795	29	11	localThrowable1	Throwable
    //   963	1	11	localThrowable2	Throwable
    //   55	767	12	localBundle	Bundle
    //   1	788	13	localObject2	Object
    //   384	16	14	localIntentFilter	android.content.IntentFilter
    //   670	15	14	localException1	Exception
    //   970	1	14	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   394	405	670	java/lang/Exception
    //   692	704	795	java/lang/Throwable
    //   704	720	795	java/lang/Throwable
    //   720	734	795	java/lang/Throwable
    //   734	746	963	java/lang/Throwable
    //   751	763	963	java/lang/Throwable
    //   763	786	963	java/lang/Throwable
    //   231	246	970	java/lang/Exception
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
        unregisterReceiver(this.i);
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
      a(paramBundle, localClassLoader);
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
      if ((this.mPluginActivity != null) && (this.mPluginActivity.IgetImmersiveConfig().isNeedColor) && (this.mActNeedImmersive) && (this.a == null))
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
      mAppForground = a(this);
      if ((enablePatternLock()) && (!mAppForground) && (!TextUtils.isEmpty(g)) && (isPatternLockOpened()) && (this.h)) {
        startUnlockActivity(true);
      }
      if (!mAppForground)
      {
        mAppForground = true;
        a(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.h = true;
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
    paramBundle.putString("pluginsdk_selfuin", this.e);
    paramBundle.putBoolean("param_plugin_gesturelock", this.f);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.foreground");
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
    mAppForground = d();
    if (!mAppForground) {
      a(this, mAppForground);
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
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setImmersiveBar(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.widget.immersive.SystemBarCompact");
      localClass.getDeclaredConstructors();
      this.a = localClass.getConstructor(new Class[] { Activity.class, Boolean.TYPE, Integer.TYPE }).newInstance(new Object[] { paramActivity, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void setStatusDrawable(Drawable paramDrawable)
  {
    if (this.a != null) {}
    try
    {
      Method localMethod = this.a.getClass().getMethod("setStatusDrawable", new Class[] { Drawable.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.a, new Object[] { paramDrawable });
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
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new k(this));
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
    if (a(paramIntent)) {
      this.h = false;
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
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
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
  
  public static abstract interface IPluginManifestChecker
  {
    public abstract void doCheck(String paramString1, String paramString2);
  }
  
  public static class StartActivityParams
  {
    public String launchActivity;
    public ClassLoader loader;
    public String mPluginApkFilePath;
    public String mPluginID;
    public String mPluginName;
    public int mPluginResoucesType;
    public boolean mUseSkinEngine;
    public String proxyActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */