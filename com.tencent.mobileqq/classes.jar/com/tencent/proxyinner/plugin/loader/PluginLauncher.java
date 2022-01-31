package com.tencent.proxyinner.plugin.loader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginCallback;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.lifecycle.PluginLifeCycle;
import com.tencent.proxyinner.utility.ApkUtility;
import java.util.HashMap;
import java.util.Map;

public class PluginLauncher
  implements PluginLoaderMonitor.IMonitorListener, PluginCallback
{
  private static final int MSG_CRASHED = 6;
  private static final int MSG_LOAD_FAIL = 2;
  private static final int MSG_LOAD_SUCC = 1;
  private static final int MSG_MOVE_SO_FILE = 9;
  private static final int MSG_MOVE_SO_FILE_FAIL = 8;
  private static final int MSG_MOVE_SO_FILE_SUCC = 7;
  private static final int MSG_START_FAIL = 5;
  private static final int MSG_START_SUCC = 4;
  private static final int RES_INSTALL_FAIL = 5;
  private static final int RES_LOAD_CRASHED = 10003;
  private static final int RES_LOAD_FAIL = 1;
  private static final int RES_LOAD_SUCC = 0;
  private static final int RES_LOAD_TIMEOUT = 10001;
  private static final int RES_START_APK_NOT_EXIST = 10005;
  private static final int RES_START_CRASHED = 10004;
  private static final int RES_START_FAIL = 2;
  private static final int RES_START_PARAM_INVALID = 10006;
  private static final int RES_START_TIMEOUT = 10002;
  private static final String TAG = "TXProxy|PluginLoader";
  private static int mTimeoutDelay = 30000;
  private Context mContext;
  Event mEventListener;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Bundle localBundle = paramAnonymousMessage.getData();
      int i = 0;
      String str1 = "";
      String str2 = "";
      if (localBundle != null)
      {
        i = localBundle.getInt("res");
        str1 = localBundle.getString("descmsg");
        str2 = localBundle.getString("packagename");
      }
      if (PluginLauncher.this.mEventListener != null)
      {
        if (paramAnonymousMessage.what != 1) {
          break label114;
        }
        XLog.i("TXProxy|PluginLoader", "加载插件成功");
        if (PluginLauncher.this.mParams.isLoad) {
          PluginLauncher.this.monitor.stopTimeoutMonitor();
        }
        PluginLauncher.this.mEventListener.onLoaded(PluginLauncher.this.mParams);
      }
      label114:
      do
      {
        do
        {
          return;
          if (paramAnonymousMessage.what == 4)
          {
            XLog.i("TXProxy|PluginLoader", "启动插件成功");
            PluginLauncher.this.monitor.stopTimeoutMonitor();
            PluginLauncher.this.mEventListener.onStarted(str2);
            return;
          }
          if (paramAnonymousMessage.what == 2)
          {
            XLog.e("TXProxy|PluginLoader", "加载插件失败");
            PluginLauncher.this.monitor.stopTimeoutMonitor();
            PluginLauncher.this.mEventListener.onLoadError(str2, 1, i, str1);
            return;
          }
          if (paramAnonymousMessage.what == 5)
          {
            XLog.e("TXProxy|PluginLoader", "启动插件失败");
            PluginLauncher.this.monitor.stopTimeoutMonitor();
            PluginLauncher.this.mEventListener.onLoadError(str2, 2, i, str1);
            return;
          }
          if (paramAnonymousMessage.what != 7) {
            break;
          }
          XLog.i("TXProxy|PluginLoader", "拷贝ｓｏ文件成功");
          if (PluginLauncher.this.mThread != null)
          {
            PluginLauncher.this.mThread.interrupt();
            PluginLauncher.this.mThread = null;
          }
        } while (SixGodHelper.isPluginLoaded(PluginLauncher.this.mParams.mPakageName));
        PluginLauncher.this.mParams.mIsMoveSoFile = false;
        PluginLauncher.this.launchPlugin(PluginLauncher.this.mContext, PluginLauncher.this.mParams);
        return;
      } while (paramAnonymousMessage.what != 8);
      XLog.i("TXProxy|PluginLoader", "拷贝ｓｏ文件失败");
      PluginLauncher.this.mEventListener.onLoadError(str2, 1, i, str1);
    }
  };
  LauncherParam mParams;
  PluginLifeCycle mPluginLifeCycle;
  String mPluginid;
  HandlerThread mThread;
  private PluginLoaderMonitor monitor = new PluginLoaderMonitor();
  
  private PluginLoadParams buildSixgodLoadPluginParams(LauncherParam paramLauncherParam)
  {
    PluginLoadParams localPluginLoadParams = new PluginLoadParams(paramLauncherParam.mApkPath, paramLauncherParam.mPakageName, ApkUtility.getApkName(paramLauncherParam.mApkPath));
    localPluginLoadParams.preOnCreateExtras = paramLauncherParam.params;
    localPluginLoadParams.supportMultidex = true;
    localPluginLoadParams.supportSpeedyClassloader = paramLauncherParam.mUseSpeedyClassloader;
    localPluginLoadParams.pluginLoadCallBack = this;
    if (paramLauncherParam.mPakageName.equals("com.tencent.mobileqq"))
    {
      localPluginLoadParams.defaultActivityContainer = "com.tencent.proxyinner.plugin.loader.ODContainnerActivity";
      localPluginLoadParams.componentMap.put("com.tencent.od.app.newloginprocess.EnteringRoomActivity", "com.tencent.pluginloader.proxy.ODLoadActivity");
      localPluginLoadParams.componentMap.put("com.tencent.od.app.newloginprocess.LoginActivity", "com.tencent.pluginloader.proxy.ODLoadActivity");
      localPluginLoadParams.componentMap.put("com.tencent.od.app.ODRoomActivity", "com.tencent.proxyinner.plugin.loader.ODSingleTopProxyActivity");
    }
    for (;;)
    {
      localPluginLoadParams.pluginLoadCallBack = this;
      if (!TextUtils.isEmpty(paramLauncherParam.mDefaultContainerActivity)) {
        localPluginLoadParams.defaultActivityContainer = paramLauncherParam.mDefaultContainerActivity;
      }
      localPluginLoadParams.useBootClassLoader = true;
      if (paramLauncherParam.mMapComponent.size() > 0) {
        localPluginLoadParams.componentMap.putAll(paramLauncherParam.mMapComponent);
      }
      localPluginLoadParams.versionName = paramLauncherParam.mVersionName;
      return localPluginLoadParams;
      if (paramLauncherParam.mPakageName.equals("com.tencent.now"))
      {
        localPluginLoadParams.defaultUseActionBar = true;
        if (paramLauncherParam.mMapComponent.size() == 0)
        {
          localPluginLoadParams.componentMap.put("com.tencent.wns.export.EmptyService", "com.tencent.proxyinner.plugin.loader.WnsEmptyProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.room.QtService", "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy");
          localPluginLoadParams.componentMap.put("com.tencent.wns.service.WnsMain", "com.tencent.proxyinner.plugin.loader.WNSProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.startup.LauncherActivity", "com.tencent.mobileqq.intervideo.now.NowGestureProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.tmdownloader.TMAssistantDownloadService", "com.tencent.pluginloader.proxy.DownloadProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.videoroom.widget.LiteVideoWindowService", "com.tencent.pluginloader.proxy.NowVideoServiceProxy");
          localPluginLoadParams.componentMap.put("com.wns.daemon.foreservice.FakeForeGroundService", "com.tencent.proxyinner.plugin.loader.FakaForgroundProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.web.WebActivity", "com.tencent.proxyinner.plugin.loader.WebProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.videoroom.RoomActivity", "com.tencent.mobileqq.intervideo.now.NowGestureProxyActivity");
          localPluginLoadParams.defaultUseActionBar = true;
          localPluginLoadParams.defaultActivityContainer = "com.tencent.pluginloader.proxy.NowDefaultProxy";
          localPluginLoadParams.defaultServiceContainer = "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy";
        }
      }
    }
  }
  
  private boolean launchPlugin(Context paramContext, LauncherParam paramLauncherParam)
  {
    if ((paramContext == null) || (paramLauncherParam == null)) {
      postCallback(5, paramLauncherParam.mPakageName, 10006, "params is invalid");
    }
    this.mContext = paramContext;
    this.mParams = paramLauncherParam;
    if (TextUtils.isEmpty(paramLauncherParam.mApkPath))
    {
      postCallback(5, paramLauncherParam.mPakageName, 10005, "pluginPath is empty");
      return false;
    }
    if (this.mParams.isLoad)
    {
      XLog.i("TXProxy|PluginLoader", "loadPlugin");
      loadPlugin(buildSixgodLoadPluginParams(paramLauncherParam));
    }
    for (;;)
    {
      return true;
      if (TextUtils.isEmpty(this.mParams.activityName))
      {
        SixGodHelper.startPluginLauncherActivity(this.mContext, buildSixgodLoadPluginParams(paramLauncherParam), paramLauncherParam.params, paramLauncherParam.data);
      }
      else
      {
        XLog.i("TXProxy|PluginLoader", "startPluginActivity data = " + paramLauncherParam.data);
        SixGodHelper.startPluginActivity(this.mContext, paramLauncherParam.activityName, buildSixgodLoadPluginParams(paramLauncherParam), paramLauncherParam.params, paramLauncherParam.data);
      }
    }
  }
  
  private void loadPlugin(final PluginLoadParams paramPluginLoadParams)
  {
    HandlerThread localHandlerThread = new HandlerThread("load_plugin", 1);
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SixGodHelper.preloadPlugin(PluginLauncher.this.mContext, paramPluginLoadParams, Class.forName(PluginLauncher.this.mParams.mDefaultLoadApkActivity));
          return;
        }
        catch (Exception localException)
        {
          PluginLauncher.this.postCallback(2, paramPluginLoadParams.pkgName, 10003, "loadPlugin crashed!");
          localException.printStackTrace();
        }
      }
    });
  }
  
  private void postCallback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("res", paramInt2);
    localBundle.putString("descmsg", paramString2);
    localBundle.putString("packagename", paramString1);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void callAppCreateFailed(String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void callAppCreateSucc(String paramString1, String paramString2) {}
  
  public void init(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mPluginid = paramString;
    this.mPluginLifeCycle = new PluginLifeCycle(paramContext);
  }
  
  public boolean isPluginLoaded()
  {
    return this.mPluginLifeCycle.isPluginLoaded();
  }
  
  public void load(LauncherParam paramLauncherParam)
  {
    XLog.i("TXProxy|PluginLoader", "开始加载插件,启动超时逻辑, path = " + paramLauncherParam.mApkPath);
    if (paramLauncherParam == null) {
      throw new IllegalArgumentException("load,LauncherParam = null!");
    }
    this.monitor.startTimeoutMonitor(1, this, mTimeoutDelay);
    launchPlugin(this.mContext, paramLauncherParam);
  }
  
  public void loadPluginFailed(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    XLog.e("TXProxy|PluginLoader", "loadPluginFailed packageName = " + paramString1);
    postCallback(2, paramString1, paramInt, paramString3);
  }
  
  public void loadPluginSucc(String paramString1, String paramString2, String paramString3)
  {
    XLog.i("TXProxy|PluginLoader", "loadPluginSucc packageName = " + paramString1 + " processName = " + paramString3);
    this.mPluginLifeCycle.onPluginLoaded(paramString3);
    postCallback(1, paramString1, 0, "");
  }
  
  public void onLoadTimeout()
  {
    XLog.e("TXProxy|PluginLoader", "加载插件超时！");
    postCallback(2, this.mParams.mPakageName, 10001, "load_time_out");
  }
  
  public void onStartTimeout()
  {
    XLog.e("TXProxy|PluginLoader", "启动插件超时！");
    postCallback(5, this.mParams.mPakageName, 10002, "start_time_out");
  }
  
  public void setListener(Event paramEvent)
  {
    this.mEventListener = paramEvent;
  }
  
  public void start(LauncherParam paramLauncherParam)
  {
    XLog.i("TXProxy|PluginLoader", "开始启动插件,启动超时逻辑");
    this.monitor.startTimeoutMonitor(2, this, mTimeoutDelay);
    launchPlugin(this.mContext, paramLauncherParam);
  }
  
  public void startMainActivityFailed(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    XLog.e("TXProxy|PluginLoader", "startMainActivityFailed packageName = " + paramString1);
    postCallback(5, paramString1, 2, paramString4);
  }
  
  public void startMainActivitySucc(String paramString1, String paramString2, String paramString3)
  {
    XLog.i("TXProxy|PluginLoader", "startMainActivitySucc packageName = " + paramString1);
    postCallback(4, paramString1, 0, "startMainActivitySucc!");
  }
  
  public void unInit(boolean paramBoolean)
  {
    unload(paramBoolean);
  }
  
  public void unload(boolean paramBoolean)
  {
    XLog.i("TXProxy|PluginLoader", "卸载插件");
    if (this.mParams != null)
    {
      SixGodHelper.unLoadPlugin(this.mContext, this.mParams.mPakageName, paramBoolean);
      this.mPluginLifeCycle.onPluginUnLoaded();
    }
  }
  
  public static abstract interface Event
  {
    public abstract void onLoadError(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract void onLoaded(PluginLauncher.LauncherParam paramLauncherParam);
    
    public abstract void onStarted(String paramString);
  }
  
  public static class LauncherParam
  {
    public String activityName;
    public Uri data;
    public boolean isLoad;
    public String mApkPath;
    public String mDefaultContainerActivity;
    public String mDefaultContainerService;
    public String mDefaultLoadApkActivity;
    public boolean mIsMoveSoFile;
    public Map<String, String> mMapComponent = new HashMap();
    public String mPakageName;
    public String mProcessName = ":plugin";
    public boolean mUseSpeedyClassloader = false;
    public String mVersionName = "version";
    public Bundle params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.PluginLauncher
 * JD-Core Version:    0.7.0.1
 */