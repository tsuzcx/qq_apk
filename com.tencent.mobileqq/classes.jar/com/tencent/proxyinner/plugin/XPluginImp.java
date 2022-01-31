package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import com.tencent.proxyinner.channel.PluginChannel;
import com.tencent.proxyinner.channel.PluginChannel.Event;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.log.XLog.Event;
import com.tencent.proxyinner.plugin.Downloader.PluginChecker;
import com.tencent.proxyinner.plugin.Downloader.PluginChecker.Event;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam.ApkParam;
import com.tencent.proxyinner.plugin.data.XPluginInfoBuilder;
import com.tencent.proxyinner.plugin.excecutor.XPluginStateMachine;
import com.tencent.proxyinner.plugin.excecutor.XPluginStateMachine.Event;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.report.DataReport.Event;
import com.tencent.proxyinner.utility.ThreadManager;
import com.tencent.proxyinner.utility.UtilFile;
import com.tencent.proxyinner.utility.UtilMisc;
import com.tencent.proxyinner.utility.UtilPerf;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.HostInterface;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;
import com.tencent.txproxy.XEventListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XPluginImp
  implements XPluginStateMachine.Event, PluginChecker.Event, DataReport.Event, XLog.Event, PluginChannel.Event
{
  static final String TAG = "TXProxy|XPluginImp";
  static int loadRetryTimes = 0;
  DataReport dataReport;
  boolean hasVersionFirst = false;
  boolean isPreDownload = false;
  LocalPlugin localPlugin = new LocalPlugin();
  XLog log;
  Context mContext;
  int mDownloadType = 2;
  protected HostInterface mHostInterface;
  InitParam mInitParam;
  Intent mIntent = new Intent();
  int mLastErrorCode = 0;
  String mLastErrorMsg;
  ArrayList<String> mMutexPluginList;
  boolean mNeedConfirm = false;
  String mPluginId;
  RunPluginParams mRunParams;
  XPluginStateMachine mStateMachine;
  UpdateParam mUpdateParam;
  public PluginChannel pluginChannel = new PluginChannel();
  public PluginChecker pluginChecker;
  XPluginNotifyer pluginNotifyer = new XPluginNotifyer();
  PluginUpdater pluginUpdater;
  long timeRunPlugin = 0L;
  
  private void checkVersion()
  {
    this.dataReport.reportCheckVersionStart(this.pluginChecker.getCheckUrl());
    UtilPerf.startCheckVersion();
    if ((this.pluginChecker.getStatus() == 0) || (this.pluginChecker.isVersionInfoExpired())) {
      this.pluginChecker.run(this.mInitParam.mSourceId, this.mContext, this.mPluginId, this);
    }
  }
  
  private void deleteFoler(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteFoler(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private boolean doCheckVersionIfNeeded()
  {
    boolean bool = false;
    if ((this.pluginChecker.isVersionInfoExpired()) || (!isCheckedVersion()))
    {
      XLog.i("TXProxy|XPluginImp", "版本检查信息已过期，状态重置为IDEL，并重新版本检查");
      this.mStateMachine.gotoStatus(0, 0, 0);
      checkVersion();
      bool = true;
    }
    return bool;
  }
  
  private void downloadSecretly()
  {
    if (this.mStateMachine.getStatus() == 1) {
      return;
    }
    this.mStateMachine.downloadSecretly();
  }
  
  private void forceDoCheckVersion()
  {
    XLog.i("TXProxy|XPluginImp", "强制进行版本检查");
    this.mStateMachine.gotoStatus(0, 0, 0);
    checkVersion();
  }
  
  private void initPluginChecker(String paramString)
  {
    if (this.pluginChecker == null)
    {
      this.pluginChecker = new PluginChecker(this.localPlugin, paramString);
      if (this.mHostInterface != null) {
        this.pluginChecker.setHostInterface(this.mHostInterface);
      }
    }
    this.pluginChecker.resetStatus();
  }
  
  private void initPluginStateMachine()
  {
    if (this.mStateMachine == null)
    {
      this.mStateMachine = new XPluginStateMachine();
      this.mStateMachine.init(this.mContext, this.mPluginId, this.mInitParam.mSourceId, this.localPlugin, this.mInitParam, this.pluginChecker, this);
    }
    this.mStateMachine.resetStateToIdel();
  }
  
  public void addListener(XEventListener paramXEventListener)
  {
    this.pluginNotifyer.addListener(paramXEventListener);
  }
  
  public void cancelRun(String paramString)
  {
    XLog.i("TXProxy|XPluginImp", "cancelRun reason = " + paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "cancelrun");
    localHashMap.put("timeconsume", Long.valueOf(System.currentTimeMillis() - this.timeRunPlugin));
    localHashMap.put("int1", Integer.valueOf(this.mStateMachine.getStatus()));
    localHashMap.put("int2", Integer.valueOf(getPluginDownloadType()));
    localHashMap.put("str2", paramString);
    if (this.pluginUpdater != null)
    {
      localHashMap.put("int3", Integer.valueOf(this.pluginUpdater.getLastResponseCode()));
      localHashMap.put("str1", this.pluginUpdater.getLastError());
    }
    localHashMap.put("int4", Integer.valueOf(this.mLastErrorCode));
    localHashMap.put("str3", this.mLastErrorMsg);
    if (this.mStateMachine.getTargetState() >= 8) {}
    for (int i = 1;; i = 0)
    {
      int j = this.mStateMachine.getProgress();
      this.dataReport.reportCancelRun(this.localPlugin.getMaxSdkVersion(), i, j, getStatus(), this.mLastErrorCode);
      this.mStateMachine.cancelRun();
      return;
    }
  }
  
  public boolean clearAllLocalData()
  {
    this.hasVersionFirst = false;
    if (this.localPlugin != null) {
      this.localPlugin.clearAllPluginData();
    }
    return true;
  }
  
  public UpdateParam getCheckVersionInfo()
  {
    return this.mUpdateParam;
  }
  
  public int getPluginDownloadType()
  {
    return this.mDownloadType;
  }
  
  public int getPluginSize()
  {
    return this.mUpdateParam.getFirstTagParam().size;
  }
  
  public int getStatus()
  {
    return this.mStateMachine.getStatus();
  }
  
  public boolean haslocalOdexedPlugin()
  {
    return this.localPlugin.haslocalInstalledPlugin();
  }
  
  public void initParam(String paramString, Context paramContext, InitParam paramInitParam)
  {
    int i = 1;
    UtilPerf.init();
    this.mContext = paramContext;
    this.mPluginId = paramString;
    this.mInitParam = paramInitParam;
    if ((paramContext == null) || (this.mInitParam == null))
    {
      this.pluginNotifyer.onError(this.mPluginId, 1, "init param error!");
      return;
    }
    this.mIntent = XPluginInfoBuilder.setInitParam(this.mPluginId, this.mIntent, paramInitParam);
    this.localPlugin.init(this.mContext, this.mPluginId, this.mInitParam.mPluginName);
    com.tencent.txproxy.PluginInfo.pluginVersionCode = this.localPlugin.getMaxSdkVersion();
    this.log = XLog.getInstance();
    this.log.setEventList(this);
    this.dataReport = DataReport.getInstance(this.mPluginId);
    this.dataReport.addListener(this);
    paramString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "Tencent/" + "xproxy/" + this.mContext.getPackageName();
    this.log.init(this.mContext, paramString, this.mInitParam.isLogInHost);
    initPluginChecker(this.mPluginId);
    this.pluginChannel.create(this.mContext, this.mPluginId, String.valueOf(this.mInitParam.mChannelId));
    this.pluginChannel.addEventListener(this);
    this.hasVersionFirst = this.localPlugin.haslocalInstalledPlugin();
    if (this.hasVersionFirst) {
      i = 2;
    }
    this.mDownloadType = i;
    initPluginStateMachine();
    UtilPerf.finishInit();
  }
  
  public boolean isCheckedVersion()
  {
    return (this.pluginChecker.getStatus() == 2) && (!this.pluginChecker.isVersionInfoExpired());
  }
  
  public boolean isPluginLoaded()
  {
    return this.mStateMachine.isPluginLoaded();
  }
  
  public boolean isSilentUpdateComplete()
  {
    return this.mStateMachine.isSilentUpdateCompleted();
  }
  
  public boolean isTestEnv()
  {
    return UtilMisc.isTestEnv(this.mPluginId);
  }
  
  public void loadplugin(Bundle paramBundle)
  {
    if (this.mStateMachine.getTargetState() >= 6) {
      return;
    }
    setSourceInfo(paramBundle);
    this.mStateMachine.setTargetState(6);
    if ((this.pluginChecker.isVersionInfoExpired()) || (!isCheckedVersion()))
    {
      XLog.i("TXProxy|XPluginImp", "版本检查信息已过期，状态重置为IDEL，并重新版本检查");
      checkVersion();
      return;
    }
    XLog.i("TXProxy|XPluginImp", "loadlugin");
    this.mStateMachine.excecute(this.mIntent);
  }
  
  public void onCheckCompleted(boolean paramBoolean, final UpdateParam paramUpdateParam)
  {
    XLog.perfLog("版本检查完成，succ =  " + paramBoolean + "请求url = " + this.pluginChecker.getCheckUrl());
    this.localPlugin.setPackageName(this.pluginChecker.getPackName());
    if (!paramUpdateParam.curVersionExit)
    {
      localObject = new File(this.localPlugin.getSdkPath());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        this.localPlugin.setPreinstalledPlugin(this.localPlugin.getMaxSdkVersion(), "", false);
        UtilFile.deleteDir((File)localObject);
      }
    }
    Object localObject = this.dataReport;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      String str = this.pluginChecker.getLastError();
      boolean bool;
      if (!paramUpdateParam.curVersionExit)
      {
        bool = true;
        label146:
        ((DataReport)localObject).reportCheckVersionComplete(i, str, bool);
        if (this.mStateMachine.getStatus() != 1) {
          break label378;
        }
        i = 1;
        label169:
        if (!paramBoolean) {
          break label471;
        }
        com.tencent.txproxy.PluginInfo.pluginVersionCode = paramUpdateParam.newSdkVersion;
        if ((!this.localPlugin.isExistInstallPlugin()) && (!this.localPlugin.isExistDebugPlugin())) {
          break label388;
        }
        this.mStateMachine.gotoStatus(2, 0);
        if (this.mStateMachine.getTargetState() < 8) {
          break label383;
        }
        i = 1;
        label224:
        this.dataReport.reportLoadDirect(this.localPlugin.getMaxSdkVersion(), i);
        label239:
        if (this.hasVersionFirst) {
          break label437;
        }
        if (!this.localPlugin.isRetrying()) {
          break label429;
        }
        this.mDownloadType = 4;
        label261:
        if (this.mStateMachine.getTargetState() < 8) {
          this.isPreDownload = true;
        }
      }
      try
      {
        l = Long.parseLong(this.mInitParam.mSourceId);
        this.pluginUpdater = PluginUpdater.create(this.mPluginId, this.localPlugin, l);
        this.mStateMachine.setUpdater(this.pluginUpdater, this.mDownloadType);
        this.mStateMachine.excecute(this.mIntent);
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if ((paramUpdateParam.newVersionExit) && (XPluginImp.this.mInitParam.mNeedSilentUpdate) && (XPluginImp.this.mDownloadType != 1))
            {
              XLog.i("TXProxy|XPluginImp", "服务器上有新版本，开始静默更新");
              XPluginImp.this.downloadSecretly();
            }
          }
        }, 15000L);
        UtilPerf.finishCheckVersion();
        return;
        i = this.pluginChecker.getLastHttpResponseCode();
        continue;
        bool = false;
        break label146;
        label378:
        i = 0;
        break label169;
        label383:
        i = 0;
        break label224;
        label388:
        if (this.mStateMachine.isPluginLoaded())
        {
          XLog.i("TXProxy|XPluginImp", "插件已经过期，且插件正在运行中，先清除老版本插件信息并杀掉插件进程");
          this.mStateMachine.unInit(true);
        }
        this.mStateMachine.gotoStatus(0, 1, 0);
        break label239;
        label429:
        this.mDownloadType = 1;
        break label261;
        label437:
        if (this.pluginChecker.isForceDownload())
        {
          this.mDownloadType = 3;
          break label261;
        }
        this.mDownloadType = 2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
    label471:
    this.mLastErrorCode = 1;
    XLog.e("TXProxy|XPluginImp", "check faild! errInfo = " + this.pluginChecker.getLastError());
    int j;
    int k;
    int m;
    if (i != 0)
    {
      paramUpdateParam = this.dataReport;
      j = this.localPlugin.getMaxSdkVersion();
      k = this.mDownloadType;
      if (!this.isPreDownload) {
        break label644;
      }
      i = 1;
      paramUpdateParam.reportDownloadStart(j, k, i, this.pluginChecker.getCheckUrl());
      paramUpdateParam = this.dataReport;
      j = this.localPlugin.getMaxSdkVersion();
      k = this.mInitParam.mDownloadEngine;
      m = this.mDownloadType;
      if (!this.isPreDownload) {
        break label649;
      }
    }
    label644:
    label649:
    for (int i = 1;; i = 2)
    {
      paramUpdateParam.reportDownloadComplete(1, j, 0, "", k, m, i, this.pluginChecker.getCheckUrl());
      this.pluginNotifyer.onError(this.mPluginId, -1, "check version fail!");
      this.mStateMachine.gotoStatus(0, 2);
      return;
      i = 2;
      break;
    }
  }
  
  public void onDataReport(Bundle paramBundle)
  {
    this.pluginNotifyer.onDataReport("", paramBundle);
  }
  
  public void onDownloadStart(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    this.pluginNotifyer.onDownloadFile(paramInt, paramString1, paramString2, paramHostEventListener);
  }
  
  public void onExecuteError(int paramInt1, int paramInt2, String paramString)
  {
    this.mLastErrorCode = paramInt2;
    this.mLastErrorMsg = paramString;
    this.mStateMachine.setTargetState(0);
    this.pluginNotifyer.onError(this.mPluginId, paramInt2, paramString);
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    this.pluginNotifyer.onLog(paramString1, paramString2, paramInt);
  }
  
  public void onRemoteRequest(String paramString, Bundle paramBundle)
  {
    XLog.i("TXProxy|XPluginImp", "收到远程广播，通知宿主 cmd = " + paramString);
    this.pluginNotifyer.onRecvMessage(this.mPluginId, paramString, paramBundle);
  }
  
  public boolean onRetry(String paramString)
  {
    if (this.mRunParams != null)
    {
      int i = loadRetryTimes;
      loadRetryTimes = i + 1;
      if (i < this.pluginChecker.getMaxLoadRetryTimes())
      {
        XLog.i("TXProxy|XPluginImp", "删除本地文件，重新下载 retry " + loadRetryTimes);
        paramString = new File(this.localPlugin.getSdkPath());
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          this.hasVersionFirst = false;
          this.localPlugin.clearAllPluginData();
        }
        this.pluginChecker.resetStatus();
        this.mStateMachine.unInit(true);
        this.mStateMachine.gotoStatus(0, 0, 0);
        runPlugin(this.mRunParams);
        return true;
      }
    }
    return false;
  }
  
  public void onStateChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1)) {
      if (paramInt4 != 0) {
        this.pluginNotifyer.onProgress(this.mPluginId, paramInt4 * 95 / 100);
      }
    }
    do
    {
      return;
      if ((paramInt1 == 3) && (paramInt2 == 3) && (paramInt4 > 0))
      {
        this.pluginNotifyer.onProgress(this.mPluginId, paramInt4);
        return;
      }
      if ((paramInt1 == 3) && (paramInt2 == 4))
      {
        this.pluginNotifyer.onPluginInstalled(this.mPluginId);
        return;
      }
      if ((paramInt1 == 2) && (paramInt2 == 4))
      {
        this.pluginNotifyer.onPluginInstalled(this.mPluginId);
        return;
      }
      if ((paramInt1 == 5) && (paramInt2 == 6))
      {
        this.pluginNotifyer.onProgress(this.mPluginId, 99);
        this.pluginNotifyer.onPluginLoaded(this.mPluginId);
        return;
      }
    } while ((paramInt1 != 7) || (paramInt2 != 8));
    this.pluginNotifyer.onPluginRun(this.pluginChecker.getPackName());
  }
  
  public boolean onUnZipSOFile(String paramString1, String paramString2)
  {
    try
    {
      this.pluginNotifyer.onUnZipSo(paramString1, paramString2);
      return true;
    }
    catch (MoveSoException paramString1) {}
    return false;
  }
  
  public void registerPluginMsg(String paramString)
  {
    this.pluginChannel.register(paramString);
  }
  
  public void removeListener(XEventListener paramXEventListener)
  {
    this.pluginNotifyer.removeListener(paramXEventListener);
  }
  
  public void runPlugin(RunPluginParams paramRunPluginParams)
  {
    this.mRunParams = paramRunPluginParams;
    this.timeRunPlugin = System.currentTimeMillis();
    UtilPerf.startRun();
    boolean bool = haslocalOdexedPlugin();
    Intent localIntent = new Intent();
    XPluginInfoBuilder.setLauncherParam(localIntent, paramRunPluginParams);
    this.mStateMachine.setTargetState(8);
    this.mStateMachine.setBootType();
    setSourceInfo(localIntent.getExtras());
    if (doCheckVersionIfNeeded())
    {
      this.dataReport.reportBootStart(bool, true);
      return;
    }
    this.dataReport.reportBootStart(bool, false);
    this.mStateMachine.excecute(this.mIntent);
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    this.pluginChannel.sendMessage(paramString, paramBundle);
  }
  
  public void setDownloadInHost(boolean paramBoolean)
  {
    this.mStateMachine.setDownloadInHost(paramBoolean);
  }
  
  public void setHostInterface(HostInterface paramHostInterface)
  {
    this.mHostInterface = paramHostInterface;
    if (this.pluginChecker != null) {
      this.pluginChecker.setHostInterface(paramHostInterface);
    }
  }
  
  public void setLogInHost(boolean paramBoolean)
  {
    this.log.setLoginInHost(paramBoolean);
  }
  
  public void setMutexPluginList(ArrayList<String> paramArrayList)
  {
    this.mMutexPluginList = paramArrayList;
  }
  
  public void setSourceInfo(Bundle paramBundle)
  {
    try
    {
      this.mIntent.putExtra("pkgname", this.mContext.getPackageName());
      this.mIntent.putExtra("channelid", Integer.parseInt(this.mInitParam.mChannelId));
      this.mIntent.putExtra("pluginflag", true);
      this.mIntent.putExtra("sdk_download_version", this.localPlugin.getMaxSdkVersion());
      this.mIntent.putExtras(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public boolean unload(Boolean paramBoolean)
  {
    if (this.mStateMachine == null) {}
    do
    {
      return false;
      XLog.i("TXProxy|XPluginImp", "插件尝试卸载 mCurrentStatus = " + this.mStateMachine.getStatus());
    } while ((this.mStateMachine.getStatus() != 6) && (this.mStateMachine.getStatus() != 8));
    this.pluginChannel.unRegisterAllCmd();
    this.pluginChannel.removeEventListener(this);
    this.pluginChannel.stop();
    this.mStateMachine.unInit(paramBoolean.booleanValue());
    this.log.unInit();
    this.dataReport.removeListener(this);
    this.mRunParams = null;
    ThreadManager.unInit();
    return true;
  }
  
  public void updatePluginAndPreInstall(boolean paramBoolean)
  {
    XLog.i("TXProxy|XPluginImp", "updatePluginAndPreInstall");
    if ((!paramBoolean) && (haslocalOdexedPlugin()))
    {
      XLog.i("TXProxy|XPluginImp", "不需要强制安装最新版本，本地已经有安装过的版本了，不处理");
      return;
    }
    if (this.mStateMachine.getStatus() >= 6)
    {
      XLog.i("TXProxy|XPluginImp", "当前插件已经加载了，不再处理请求，不然");
      return;
    }
    if (this.mStateMachine.getTargetState() >= 6)
    {
      XLog.i("TXProxy|XPluginImp", "自动机已经在执行加载了，不再处理请求");
      return;
    }
    this.mStateMachine.setTargetState(4);
    forceDoCheckVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.XPluginImp
 * JD-Core Version:    0.7.0.1
 */