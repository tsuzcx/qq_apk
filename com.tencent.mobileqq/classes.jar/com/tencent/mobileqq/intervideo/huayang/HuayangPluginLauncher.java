package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.RunningPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HuayangPluginLauncher
  implements IHuayangPluginLauncher
{
  private static final int MSG_NOTIFY_LAUNCH_COMPLETED = 3;
  private static final int MSG_NOTIFY_LOAD_COMPLETED = 2;
  private static final int MSG_UPDATE_PROGRESS = 1;
  public static final String TAG = "HuayangPluginLauncher";
  private static Map<String, HuayangPluginLauncher> sLauncherMap = new HashMap();
  private final Context appContext;
  private final InstalledPlugin installedPlugin;
  private boolean isMainPlugin;
  private boolean isNeedStart;
  private String mAppName;
  private IVPluginDataReporter mDataReporter;
  private final List<IHuayangPluginLauncher.HuayangPluginLauncherListener> mLauncherListeners = new LinkedList();
  private IVPluginInfo mPluginInfo;
  private int mProgress;
  private boolean mRunning;
  private RunningPlugin mRunningPlugin;
  volatile boolean mStartActivityCalled = false;
  volatile boolean mStartPluginCalled = false;
  private long mStartTime;
  private String mTargetPageUri;
  private final Handler mUiHandler = new Handler(Looper.getMainLooper(), this.mUiHandlerCallback);
  private Handler.Callback mUiHandlerCallback = new HuayangPluginLauncher.1(this);
  private String mUin;
  private final PluginLoader pluginLoader = new DynamicPluginLoader();
  
  private HuayangPluginLauncher(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    this.installedPlugin = paramInstalledPlugin;
    this.appContext = paramContext.getApplicationContext();
    this.mDataReporter = new IVPluginDataReporter();
  }
  
  @NonNull
  private Intent getPluginIntentData()
  {
    Intent localIntent = new Intent();
    String str = this.mTargetPageUri;
    if (str != null) {
      localIntent.setData(Uri.parse(str));
    }
    localIntent.putExtras(this.mPluginInfo.h);
    int i;
    if (this.isMainPlugin) {
      i = 1;
    } else {
      i = 2;
    }
    localIntent.putExtra("PluginStartMode", i);
    localIntent.putExtra("isNeedTransparent", true);
    localIntent.putExtra("qqVersion", "8.8.17");
    return localIntent;
  }
  
  private void initPlugin(RunningPlugin paramRunningPlugin)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903613));
    ((StringBuilder)localObject).append(this.installedPlugin.pluginFile);
    log("HuayangPluginLauncher", ((StringBuilder)localObject).toString());
    localObject = getPluginIntentData();
    try
    {
      paramRunningPlugin.startInitActivity((Intent)localObject).get();
    }
    catch (Throwable paramRunningPlugin)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
      }
      ((IHuayangCrashReport)QRoute.api(IHuayangCrashReport.class)).report(paramRunningPlugin);
    }
    paramRunningPlugin = new StringBuilder();
    paramRunningPlugin.append(HardCodeUtil.a(2131903611));
    paramRunningPlugin.append(this.installedPlugin.pluginFile);
    paramRunningPlugin.append(HardCodeUtil.a(2131903608));
    paramRunningPlugin.append(System.currentTimeMillis() - l);
    log("HuayangPluginLauncher", paramRunningPlugin.toString());
  }
  
  private RunningPlugin loadPlugin()
  {
    long l = System.currentTimeMillis();
    log("HuayangPluginLauncher", HardCodeUtil.a(2131903609));
    try
    {
      Object localObject1 = this.pluginLoader.loadPlugin(this.appContext, this.installedPlugin);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131903619));
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        log("HuayangPluginLauncher", ((StringBuilder)localObject1).toString());
        notifyCompleted(false, new Exception("loadFuture == null"));
        return null;
      }
      HuayangPluginLauncher.3 local3 = new HuayangPluginLauncher.3(this);
      this.mUiHandler.post(local3);
      try
      {
        localObject1 = (RunningPlugin)((ProgressFuture)localObject1).get(100L, TimeUnit.SECONDS);
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangPluginLauncher", 2, localException2, new Object[0]);
        }
        localObject1 = null;
      }
      this.mUiHandler.removeCallbacks(local3);
      if (localException2 != null)
      {
        notifyCompleted(false, localException2);
        return null;
      }
      publishProgress(80);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131903623));
      localStringBuilder.append(this.installedPlugin.pluginFile);
      localStringBuilder.append(HardCodeUtil.a(2131903618));
      localStringBuilder.append(System.currentTimeMillis() - l);
      log("HuayangPluginLauncher", localStringBuilder.toString());
      return localObject1;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "在加载插件并调用其Application的OnCreate方法过程中出错", localException1);
      }
      notifyCompleted(false, localException1);
    }
    return null;
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void notifyCompleted(boolean paramBoolean, Throwable paramThrowable)
  {
    publishProgress(100);
    if ((!paramBoolean) && (!(paramThrowable instanceof TimeoutException)) && (!(paramThrowable instanceof InterruptedException)))
    {
      this.pluginLoader.setPluginDisabled(this.installedPlugin);
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, "设置插件启动失败标志失败");
      }
    }
    Message localMessage = Message.obtain(this.mUiHandler, 3, paramBoolean ^ true, 0, paramThrowable);
    this.mUiHandler.sendMessage(localMessage);
    if (paramBoolean)
    {
      reportLaunchResult(paramBoolean, null);
    }
    else
    {
      reportLaunchResult(paramBoolean, paramThrowable.toString());
      ((IHuayangCrashReport)QRoute.api(IHuayangCrashReport.class)).report(paramThrowable);
    }
    this.mRunning = false;
  }
  
  private void publishProgress(int paramInt)
  {
    if (paramInt < this.mProgress) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903617));
    ((StringBuilder)localObject).append(paramInt);
    log("HuayangPluginLauncher", ((StringBuilder)localObject).toString());
    this.mProgress = paramInt;
    localObject = Message.obtain(this.mUiHandler, 1, paramInt, 0);
    this.mUiHandler.sendMessage((Message)localObject);
  }
  
  private void report(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    this.mDataReporter.opDepartment(this.mAppName).opName(paramString1).opType(paramString1).opIn(paramInt1).opResult(paramInt2).d1(paramString2).d2(paramString3).d4(this.mPluginInfo.c).report();
  }
  
  private void reportLaunchResult(boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void startupPlugin(RunningPlugin paramRunningPlugin)
  {
    this.mStartPluginCalled = true;
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131903607));
    localStringBuilder.append(this.installedPlugin.pluginFile);
    log("HuayangPluginLauncher", localStringBuilder.toString());
    paramRunningPlugin = paramRunningPlugin.startLauncherActivity(getPluginIntentData());
    publishProgress(90);
    try
    {
      paramRunningPlugin.get();
      notifyCompleted(true, null);
      if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.mPluginInfo.c)) {
        Monitor.a("2691707");
      } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.mPluginInfo.c)) {
        Monitor.a("2597725");
      }
      paramRunningPlugin = this.appContext.getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("huayang_plugin_start_flag");
      localStringBuilder.append(this.mUin);
      localStringBuilder.append(this.mPluginInfo.c);
      paramRunningPlugin.putBoolean(localStringBuilder.toString(), true);
      paramRunningPlugin.putString("huayang_plugin_launch_appType_", this.mAppName);
      paramRunningPlugin.apply();
      Monitor.a("2585917");
    }
    catch (Throwable paramRunningPlugin)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginLauncher", 2, paramRunningPlugin, new Object[0]);
      }
      notifyCompleted(false, paramRunningPlugin);
    }
    paramRunningPlugin = new StringBuilder();
    paramRunningPlugin.append(HardCodeUtil.a(2131903622));
    paramRunningPlugin.append(this.installedPlugin.pluginFile);
    paramRunningPlugin.append(HardCodeUtil.a(2131903615));
    paramRunningPlugin.append(System.currentTimeMillis() - l);
    log("HuayangPluginLauncher", paramRunningPlugin.toString());
  }
  
  public void addLauncherListener(IHuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener)
  {
    if (paramHuayangPluginLauncherListener != null) {
      this.mLauncherListeners.add(paramHuayangPluginLauncherListener);
    }
  }
  
  public HuayangPluginLauncher getInstance(Context paramContext, Object paramObject)
  {
    try
    {
      HuayangPluginLauncher localHuayangPluginLauncher2 = (HuayangPluginLauncher)sLauncherMap.get(((InstalledPlugin)paramObject).pluginFile.getName());
      HuayangPluginLauncher localHuayangPluginLauncher1 = localHuayangPluginLauncher2;
      if (localHuayangPluginLauncher2 == null)
      {
        localHuayangPluginLauncher1 = new HuayangPluginLauncher(paramContext, (InstalledPlugin)paramObject);
        sLauncherMap.put(((InstalledPlugin)paramObject).pluginFile.getName(), localHuayangPluginLauncher1);
      }
      return localHuayangPluginLauncher1;
    }
    finally {}
  }
  
  public boolean isStartPluginCalled()
  {
    return this.mStartPluginCalled;
  }
  
  public void launchPlugin(String paramString1, boolean paramBoolean1, boolean paramBoolean2, IVPluginInfo paramIVPluginInfo, String paramString2, String paramString3)
  {
    if (this.mRunning)
    {
      log("HuayangPluginLauncher", "launchPlugin mRunning return");
      return;
    }
    this.mRunning = true;
    this.mAppName = paramString3;
    this.mStartActivityCalled = false;
    this.mStartPluginCalled = false;
    this.isNeedStart = paramBoolean1;
    this.isMainPlugin = paramBoolean2;
    this.mPluginInfo = paramIVPluginInfo;
    this.mUin = paramString2;
    this.mStartTime = System.currentTimeMillis();
    this.mTargetPageUri = paramString1;
    ThreadManager.executeOnSubThread(new HuayangPluginLauncher.2(this, paramBoolean2));
  }
  
  public void removeLauncherListener(IHuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener)
  {
    if (paramHuayangPluginLauncherListener != null) {
      this.mLauncherListeners.remove(paramHuayangPluginLauncherListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher
 * JD-Core Version:    0.7.0.1
 */