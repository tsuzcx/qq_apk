package com.tencent.proxyinner.plugin.excecutor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.Downloader.PluginChecker;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater.Event;
import com.tencent.proxyinner.plugin.Installer;
import com.tencent.proxyinner.plugin.Installer.InstallEvent;
import com.tencent.proxyinner.plugin.LocalPlugin;
import com.tencent.proxyinner.plugin.loader.PluginLauncher;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.Event;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.LauncherParam;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.utility.UtilFile;
import com.tencent.proxyinner.utility.UtilMisc;
import com.tencent.proxyinner.utility.UtilPerf;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.InitParam;
import java.io.File;

public class XPluginStateMachine
  extends XStateMachine
  implements PluginUpdater.Event, PluginLauncher.Event
{
  static final String TAG = "XProxy | XPluginStateMachine";
  int downloadTrigger = 2;
  PluginLauncher.LauncherParam launcherParam = new PluginLauncher.LauncherParam();
  int mBootType = 0;
  Context mContext;
  int mDownloadType = 2;
  Event mEvent;
  InitParam mInitParam;
  Installer mInstaller;
  Intent mIntent;
  LocalPlugin mLocalPlugin;
  PluginChecker mPluginChecker;
  String mPluginID;
  PluginLauncher mPluginLauncher = new PluginLauncher();
  PluginUpdater mPluginUpdater;
  boolean mSilentUpdateCompleted = false;
  String mSourceId;
  int mTargetState = 0;
  int mUpdateProgress = 0;
  long timeInstallBegin = 0L;
  
  private void buildLoadParam(Bundle paramBundle)
  {
    boolean bool = false;
    try
    {
      if (!TextUtils.isEmpty(this.mInitParam.mSourceId)) {
        paramBundle.putLong("uin", Long.parseLong(this.mInitParam.mSourceId));
      }
      int i = this.mLocalPlugin.getMaxSdkVersion();
      this.launcherParam.mApkPath = this.mLocalPlugin.getPath();
      this.launcherParam.params = paramBundle;
      this.launcherParam.mPakageName = this.mPluginChecker.getPackName();
      this.launcherParam.mIsMoveSoFile = false;
      paramBundle = this.launcherParam;
      if (!this.mLocalPlugin.getHasDex2Oat(i)) {
        bool = true;
      }
      paramBundle.mUseSpeedyClassloader = bool;
      this.launcherParam.isLoad = true;
      this.launcherParam.mMapComponent = this.mInitParam.mComponentMap;
      this.launcherParam.mDefaultContainerActivity = this.mInitParam.mDefaultContainerActivity;
      this.launcherParam.mDefaultContainerService = this.mInitParam.mDefaultContainerService;
      this.launcherParam.mDefaultLoadApkActivity = this.mInitParam.mDefaultLoadApkActivity;
      this.launcherParam.mVersionName = String.valueOf(i);
      if (this.mPluginID.equals("Live")) {
        this.launcherParam.mProcessName = "com.tencent.mobileqq:tool";
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        XLog.i("XProxy | XPluginStateMachine", "mOpenroomParam.mSourceId NumberFormatException");
      }
    }
  }
  
  private boolean download()
  {
    XLog.i("XProxy | XPluginStateMachine", "插件开始下载");
    if (this.mCurrentStatus != 0) {
      return false;
    }
    gotoStatus(1, 0, 0);
    if ((this.mPluginChecker.getStatus() == 0) || (this.mPluginChecker.getStatus() == 1))
    {
      XLog.i("XProxy | XPluginStateMachine", "版本检查还没有完成，或者在进行中,直接返回");
      return false;
    }
    runDownloadTask();
    return true;
  }
  
  private void install()
  {
    if (getStatus() == 3)
    {
      XLog.i("XProxy | XPluginStateMachine", "installPlugin 插件正在安装中，直接返回");
      return;
    }
    gotoStatus(3, 0, 0);
    if (getTargetState() < 8) {}
    for (int i = 2;; i = 1)
    {
      installPluginInner(i);
      return;
    }
  }
  
  private boolean installPluginInner(final int paramInt)
  {
    try
    {
      this.timeInstallBegin = System.currentTimeMillis();
      String str1 = this.mLocalPlugin.getPluginPathWihoutConfirm();
      String str2 = this.mLocalPlugin.getPluginOptDexDir() + this.mPluginChecker.getPackName() + File.separator + "optDex" + "_" + this.mLocalPlugin.getMaxSdkVersion() + File.separator;
      String str3 = this.mLocalPlugin.getPluginOptDexDir() + this.mPluginChecker.getPackName() + File.separator + "lib" + "_" + this.mLocalPlugin.getMaxSdkVersion() + File.separator;
      String str4 = str1 + File.pathSeparator + UtilFile.getPluginSecondaryDexesPath(this.mContext, this.mPluginChecker.getPackName(), this.mLocalPlugin.getMaxSdkVersion());
      this.mInstaller = null;
      this.mInstaller = new Installer(this.mContext, this.mLocalPlugin, str1, str2, str4, str3, this.mPluginChecker.getPackName(), this.mPluginID);
      this.mInstaller.setMoveSoFileInHost(this.mInitParam.mMoveSoFileInHost);
      this.mInstaller.installPlugin(paramInt, new Installer.InstallEvent()
      {
        public void onInstallResult(int paramAnonymousInt, String paramAnonymousString)
        {
          DataReport.getInstance(XPluginStateMachine.this.mPluginID).reportInstallComplete(XPluginStateMachine.this.mLocalPlugin.getMaxSdkVersion(), paramInt, paramAnonymousInt, paramAnonymousString);
          if ((paramAnonymousInt != 0) && (paramAnonymousInt != 5000))
          {
            XPluginStateMachine.this.gotoStatus(2, 0, 0);
            if ((XPluginStateMachine.this.mEvent != null) && (paramInt == 1)) {
              XPluginStateMachine.this.onLoadError(XPluginStateMachine.this.mPluginChecker.getPackName(), 5, paramAnonymousInt, paramAnonymousString);
            }
            return;
          }
          if ((paramAnonymousInt == 0) && (paramInt == 1)) {
            XPluginStateMachine.this.gotoStatus(3, 0, 97);
          }
          if (paramInt != 3)
          {
            XPluginStateMachine.this.gotoStatus(4, 0, 97);
            XPluginStateMachine.this.excecute(XPluginStateMachine.this.mIntent);
            return;
          }
          XPluginStateMachine.this.mSilentUpdateCompleted = true;
        }
        
        public boolean onUnZipSoFile(String paramAnonymousString1, String paramAnonymousString2)
        {
          return XPluginStateMachine.this.mEvent.onUnZipSOFile(paramAnonymousString1, paramAnonymousString2);
        }
      });
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private boolean load(Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 308	com/tencent/proxyinner/utility/UtilPerf:startLoad	()V
    //   3: aload_0
    //   4: invokevirtual 223	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:getStatus	()I
    //   7: iconst_4
    //   8: if_icmpeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 180	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginID	Ljava/lang/String;
    //   17: invokestatic 314	com/tencent/proxyinner/report/DataReport:getInstance	(Ljava/lang/String;)Lcom/tencent/proxyinner/report/DataReport;
    //   20: aload_0
    //   21: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   24: invokevirtual 116	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   27: iconst_1
    //   28: invokevirtual 318	com/tencent/proxyinner/report/DataReport:reportLoadStart	(II)V
    //   31: aload_0
    //   32: iconst_5
    //   33: iconst_0
    //   34: iconst_0
    //   35: invokevirtual 213	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:gotoStatus	(III)Z
    //   38: pop
    //   39: aload_0
    //   40: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   43: getfield 88	com/tencent/txproxy/InitParam:mSourceId	Ljava/lang/String;
    //   46: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +19 -> 68
    //   52: aload_1
    //   53: ldc 96
    //   55: aload_0
    //   56: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   59: getfield 88	com/tencent/txproxy/InitParam:mSourceId	Ljava/lang/String;
    //   62: invokestatic 102	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   65: invokevirtual 108	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   68: ldc 17
    //   70: new 242	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 320
    //   80: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   87: invokevirtual 120	com/tencent/proxyinner/plugin/LocalPlugin:getPath	()Ljava/lang/String;
    //   90: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 202	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: aload_0
    //   101: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   104: aload_0
    //   105: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   108: invokevirtual 120	com/tencent/proxyinner/plugin/LocalPlugin:getPath	()Ljava/lang/String;
    //   111: putfield 123	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mApkPath	Ljava/lang/String;
    //   114: aload_0
    //   115: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   118: aload_1
    //   119: putfield 127	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:params	Landroid/os/Bundle;
    //   122: aload_0
    //   123: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   126: aload_0
    //   127: getfield 129	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginChecker	Lcom/tencent/proxyinner/plugin/Downloader/PluginChecker;
    //   130: invokevirtual 134	com/tencent/proxyinner/plugin/Downloader/PluginChecker:getPackName	()Ljava/lang/String;
    //   133: putfield 137	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mPakageName	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   140: iconst_0
    //   141: putfield 140	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mIsMoveSoFile	Z
    //   144: aload_0
    //   145: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   148: astore 5
    //   150: aload_0
    //   151: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   154: aload_0
    //   155: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   158: invokevirtual 116	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   161: invokevirtual 144	com/tencent/proxyinner/plugin/LocalPlugin:getHasDex2Oat	(I)Z
    //   164: ifne +417 -> 581
    //   167: iconst_1
    //   168: istore 4
    //   170: aload 5
    //   172: iload 4
    //   174: putfield 147	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mUseSpeedyClassloader	Z
    //   177: aload_0
    //   178: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   181: iconst_1
    //   182: putfield 150	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:isLoad	Z
    //   185: aload_0
    //   186: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   189: aload_0
    //   190: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   193: getfield 154	com/tencent/txproxy/InitParam:mComponentMap	Ljava/util/Map;
    //   196: putfield 157	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mMapComponent	Ljava/util/Map;
    //   199: aload_0
    //   200: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   203: aload_0
    //   204: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   207: getfield 160	com/tencent/txproxy/InitParam:mDefaultContainerActivity	Ljava/lang/String;
    //   210: putfield 161	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mDefaultContainerActivity	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   217: aload_0
    //   218: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   221: getfield 164	com/tencent/txproxy/InitParam:mDefaultContainerService	Ljava/lang/String;
    //   224: putfield 165	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mDefaultContainerService	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   231: aload_0
    //   232: getfield 84	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mInitParam	Lcom/tencent/txproxy/InitParam;
    //   235: getfield 168	com/tencent/txproxy/InitParam:mDefaultLoadApkActivity	Ljava/lang/String;
    //   238: putfield 169	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mDefaultLoadApkActivity	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   245: aload_0
    //   246: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   249: invokevirtual 116	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   252: invokestatic 175	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   255: putfield 178	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mVersionName	Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 180	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginID	Ljava/lang/String;
    //   262: ldc 182
    //   264: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq +12 -> 279
    //   270: aload_0
    //   271: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   274: ldc 188
    //   276: putfield 191	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mProcessName	Ljava/lang/String;
    //   279: aload_1
    //   280: ldc_w 322
    //   283: invokevirtual 326	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   286: istore_2
    //   287: iload_2
    //   288: iconst_2
    //   289: if_icmpne +298 -> 587
    //   292: aload_0
    //   293: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   296: ldc_w 328
    //   299: putfield 191	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mProcessName	Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 180	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginID	Ljava/lang/String;
    //   306: ldc 182
    //   308: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifne +16 -> 327
    //   314: aload_0
    //   315: getfield 180	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginID	Ljava/lang/String;
    //   318: ldc_w 330
    //   321: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +341 -> 665
    //   327: new 242	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   334: aload_0
    //   335: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   338: invokevirtual 246	com/tencent/proxyinner/plugin/LocalPlugin:getPluginOptDexDir	()Ljava/lang/String;
    //   341: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: getfield 129	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginChecker	Lcom/tencent/proxyinner/plugin/Downloader/PluginChecker;
    //   348: invokevirtual 134	com/tencent/proxyinner/plugin/Downloader/PluginChecker:getPackName	()Ljava/lang/String;
    //   351: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: getstatic 255	java/io/File:separator	Ljava/lang/String;
    //   357: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 267
    //   363: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 259
    //   369: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 110	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   376: invokevirtual 116	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   379: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: getstatic 255	java/io/File:separator	Ljava/lang/String;
    //   385: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: astore_1
    //   392: new 252	java/io/File
    //   395: dup
    //   396: new 242	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   403: aload_1
    //   404: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 332
    //   410: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   419: astore 5
    //   421: new 252	java/io/File
    //   424: dup
    //   425: new 242	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   432: aload_1
    //   433: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 337
    //   439: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   448: astore 6
    //   450: aload 5
    //   452: ifnull +153 -> 605
    //   455: aload 5
    //   457: invokevirtual 340	java/io/File:exists	()Z
    //   460: ifeq +145 -> 605
    //   463: aload 6
    //   465: ifnull +140 -> 605
    //   468: aload 6
    //   470: invokevirtual 340	java/io/File:exists	()Z
    //   473: ifeq +132 -> 605
    //   476: iconst_1
    //   477: istore_2
    //   478: iload_2
    //   479: ifne +186 -> 665
    //   482: new 252	java/io/File
    //   485: dup
    //   486: aload_1
    //   487: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   490: astore_1
    //   491: iconst_0
    //   492: istore_3
    //   493: iload_3
    //   494: istore_2
    //   495: aload_1
    //   496: ifnull +18 -> 514
    //   499: iload_3
    //   500: istore_2
    //   501: aload_1
    //   502: invokevirtual 344	java/io/File:list	()[Ljava/lang/String;
    //   505: ifnull +9 -> 514
    //   508: aload_1
    //   509: invokevirtual 344	java/io/File:list	()[Ljava/lang/String;
    //   512: arraylength
    //   513: istore_2
    //   514: aload_1
    //   515: invokevirtual 348	java/io/File:listFiles	()[Ljava/io/File;
    //   518: astore 5
    //   520: new 350	java/lang/StringBuffer
    //   523: dup
    //   524: invokespecial 351	java/lang/StringBuffer:<init>	()V
    //   527: astore 6
    //   529: aload 5
    //   531: ifnull +79 -> 610
    //   534: iconst_0
    //   535: istore_3
    //   536: iload_3
    //   537: aload 5
    //   539: arraylength
    //   540: if_icmpge +70 -> 610
    //   543: aload 6
    //   545: aload 5
    //   547: iload_3
    //   548: aaload
    //   549: invokevirtual 354	java/io/File:getName	()Ljava/lang/String;
    //   552: invokevirtual 357	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   555: pop
    //   556: iload_3
    //   557: iconst_1
    //   558: iadd
    //   559: istore_3
    //   560: goto -24 -> 536
    //   563: astore 5
    //   565: aload 5
    //   567: invokevirtual 194	java/lang/NumberFormatException:printStackTrace	()V
    //   570: ldc 17
    //   572: ldc 196
    //   574: invokestatic 202	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   577: pop
    //   578: goto -510 -> 68
    //   581: iconst_0
    //   582: istore 4
    //   584: goto -414 -> 170
    //   587: iload_2
    //   588: iconst_3
    //   589: if_icmpne -287 -> 302
    //   592: aload_0
    //   593: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   596: ldc_w 359
    //   599: putfield 191	com/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam:mProcessName	Ljava/lang/String;
    //   602: goto -300 -> 302
    //   605: iconst_0
    //   606: istore_2
    //   607: goto -129 -> 478
    //   610: aload_0
    //   611: aload_0
    //   612: getfield 129	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginChecker	Lcom/tencent/proxyinner/plugin/Downloader/PluginChecker;
    //   615: invokevirtual 134	com/tencent/proxyinner/plugin/Downloader/PluginChecker:getPackName	()Ljava/lang/String;
    //   618: iconst_1
    //   619: sipush 20000
    //   622: new 242	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 361
    //   632: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload_2
    //   636: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: ldc_w 363
    //   642: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 6
    //   647: invokevirtual 364	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   650: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokevirtual 368	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:onLoadError	(Ljava/lang/String;IILjava/lang/String;)V
    //   659: aload_1
    //   660: invokestatic 372	com/tencent/proxyinner/utility/UtilFile:deleteDir	(Ljava/io/File;)V
    //   663: iconst_0
    //   664: ireturn
    //   665: aload_0
    //   666: getfield 67	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:mPluginLauncher	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher;
    //   669: aload_0
    //   670: getfield 62	com/tencent/proxyinner/plugin/excecutor/XPluginStateMachine:launcherParam	Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;
    //   673: invokevirtual 375	com/tencent/proxyinner/plugin/loader/PluginLauncher:load	(Lcom/tencent/proxyinner/plugin/loader/PluginLauncher$LauncherParam;)V
    //   676: iconst_1
    //   677: ireturn
    //   678: astore 7
    //   680: goto -124 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	XPluginStateMachine
    //   0	683	1	paramBundle	Bundle
    //   286	350	2	i	int
    //   492	68	3	j	int
    //   168	415	4	bool	boolean
    //   148	398	5	localObject1	Object
    //   563	3	5	localNumberFormatException	NumberFormatException
    //   448	198	6	localObject2	Object
    //   678	1	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   39	68	563	java/lang/NumberFormatException
    //   543	556	678	java/lang/Exception
  }
  
  private void runDownloadTask()
  {
    boolean bool = this.mInitParam.isDownloadInHost;
    int i = this.mInitParam.mDownloadEngine;
    bool = this.mPluginUpdater.run(this, Boolean.valueOf(bool).booleanValue(), i, this.mPluginChecker.getJsonString());
    if (getTargetState() < 8) {}
    for (i = 1;; i = 2)
    {
      this.downloadTrigger = i;
      if (bool) {
        DataReport.getInstance(this.mPluginID).reportDownloadStart(this.mLocalPlugin.getMaxSdkVersion(), this.mDownloadType, this.downloadTrigger, this.mPluginChecker.getCheckUrl());
      }
      return;
    }
  }
  
  private boolean start(Bundle paramBundle)
  {
    
    if (!this.mLocalPlugin.haslocalInstalledPlugin()) {
      this.mEvent.onExecuteError(this.mTargetState, 30001, "not_exit_install_plugin");
    }
    while ((this.mCurrentStatus != 6) && (this.mCurrentStatus != 8) && (this.mCurrentStatus != 4)) {
      return false;
    }
    paramBundle.putString("versioncgitext", this.mPluginChecker.getJsonString());
    paramBundle.putString("rootpath", this.mLocalPlugin.getSdkPath());
    return startImpl(paramBundle);
  }
  
  private boolean startImpl(Bundle paramBundle)
  {
    gotoStatus(7, 0, 0);
    this.launcherParam.mIsMoveSoFile = false;
    this.launcherParam.isLoad = false;
    this.launcherParam.params = paramBundle;
    this.launcherParam.activityName = paramBundle.getString("launchername");
    paramBundle = paramBundle.getString("vasschema");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.launcherParam.data = Uri.parse(paramBundle);
    }
    XLog.i("XProxy | XPluginStateMachine", "启动插件,apkPath = " + this.launcherParam.mApkPath);
    DataReport.getInstance(this.mPluginID).reportLoadStart(this.mLocalPlugin.getMaxSdkVersion(), 2);
    this.mPluginLauncher.start(this.launcherParam);
    return true;
  }
  
  public void cancelRun()
  {
    this.mTargetState = 4;
  }
  
  public void downloadSecretly()
  {
    if ((UtilMisc.isTestEnv(this.mPluginID)) && (this.mLocalPlugin.isExistDebugPlugin())) {
      return;
    }
    runDownloadTask();
  }
  
  public boolean excecute(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    XLog.i("XProxy | XPluginStateMachine", "开始执行插件加载自动机，当前状态 = " + toString(this.mCurrentStatus) + " targetState =" + this.mTargetState);
    if (this.mCurrentStatus == 0) {
      if (TextUtils.isEmpty(this.mLocalPlugin.getPath())) {
        download();
      }
    }
    do
    {
      return true;
      gotoStatus(2, 0, 0);
      install();
      return true;
      if ((this.mCurrentStatus == 1) && (getmCurrentFlag() == 1))
      {
        download();
        return true;
      }
      if (this.mCurrentStatus == 2)
      {
        install();
        return true;
      }
      if ((this.mCurrentStatus == 4) && (this.mTargetState == 6))
      {
        load(this.mIntent.getExtras());
        return true;
      }
      if ((this.mCurrentStatus == 4) && (this.mTargetState > 6))
      {
        buildLoadParam(this.mIntent.getExtras());
        start(this.mIntent.getExtras());
        return true;
      }
      if ((this.mCurrentStatus == 6) && (this.mTargetState > 6))
      {
        start(this.mIntent.getExtras());
        return true;
      }
    } while ((this.mCurrentStatus != 8) || (this.mTargetState <= 6));
    start(this.mIntent.getExtras());
    return true;
  }
  
  public int getProgress()
  {
    return this.mUpdateProgress;
  }
  
  public int getTargetState()
  {
    return this.mTargetState;
  }
  
  public boolean gotoStatus(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.mCurrentStatus;
    super.gotoStatus(paramInt1, paramInt2);
    if (this.mEvent != null) {
      this.mEvent.onStateChange(i, paramInt1, paramInt2, paramInt3);
    }
    return true;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, LocalPlugin paramLocalPlugin, InitParam paramInitParam, PluginChecker paramPluginChecker, Event paramEvent)
  {
    this.mContext = paramContext;
    this.mPluginID = paramString1;
    this.mSourceId = paramString2;
    this.mLocalPlugin = paramLocalPlugin;
    this.mPluginChecker = paramPluginChecker;
    this.mInitParam = paramInitParam;
    this.mEvent = paramEvent;
    gotoStatus(0, 0, 0);
    this.mPluginLauncher.init(this.mContext, this.mPluginID);
    this.mPluginLauncher.setListener(this);
  }
  
  public boolean isPluginLoaded()
  {
    return this.mPluginLauncher.isPluginLoaded();
  }
  
  public boolean isSilentUpdateCompleted()
  {
    return this.mSilentUpdateCompleted;
  }
  
  public void onDownloadCancel()
  {
    if (this.mCurrentStatus == 1)
    {
      gotoStatus(0, 0, 0);
      setTargetState(0);
      this.mUpdateProgress = 0;
    }
  }
  
  public void onHasPlugin(boolean paramBoolean) {}
  
  public void onLoadError(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    XLog.e("XProxy | XPluginStateMachine", "插件加载/启动失败,code = " + paramInt1 + " res = " + paramInt2 + "descMsg = " + paramString2);
    if (this.mEvent.onRetry(paramString2))
    {
      XLog.i("XProxy | XPluginStateMachine", "retry...");
      this.mLocalPlugin.addRetryTimes();
      return;
    }
    if (this.mTargetState == 8) {
      DataReport.getInstance(this.mPluginID).reportBootFail(this.mLocalPlugin.getMaxSdkVersion(), this.mBootType, paramInt1, String.valueOf(paramInt2), paramString2, this.mLocalPlugin.getRetryTimes());
    }
    paramString1 = DataReport.getInstance(this.mPluginID);
    int j = this.mLocalPlugin.getMaxSdkVersion();
    int i;
    if (getTargetState() < 8)
    {
      i = 1;
      paramString1.reportLoadComplete(j, i, paramInt1, paramInt2, paramString2);
      this.mEvent.onExecuteError(this.mTargetState, paramInt1, paramString2);
      if (!this.mLocalPlugin.isExistInstallPlugin()) {
        break label213;
      }
      gotoStatus(2, 1000, 0);
    }
    for (;;)
    {
      this.mLocalPlugin.resetRetryTimes();
      return;
      i = 2;
      break;
      label213:
      this.mPluginUpdater.resetStatus();
      gotoStatus(0, 1, 0);
    }
  }
  
  public void onLoaded(PluginLauncher.LauncherParam paramLauncherParam)
  {
    paramLauncherParam = DataReport.getInstance(this.mPluginID);
    int j = this.mLocalPlugin.getMaxSdkVersion();
    if (getTargetState() < 8) {}
    for (int i = 1;; i = 2)
    {
      paramLauncherParam.reportLoadComplete(j, i, 0, 0, "");
      if (getStatus() < 6)
      {
        gotoStatus(6, 0, 0);
        UtilPerf.finishLoad();
        excecute(this.mIntent);
      }
      return;
    }
  }
  
  public void onNoNeedUpdate()
  {
    if (this.mCurrentStatus == 1)
    {
      XLog.i("XProxy | XPluginStateMachine", "下载结果：无更新");
      gotoStatus(2, 0, 0);
      return;
    }
    XLog.i("XProxy | XPluginStateMachine", "后台偷偷更新, 结果：无更新");
  }
  
  public void onNoUpdate()
  {
    int i = 1;
    if (this.mCurrentStatus == 1)
    {
      if (UtilMisc.isTestEnv(this.mPluginID)) {
        XLog.i("XProxy | XPluginStateMachine", "下载结果：无更新");
      }
      gotoStatus(2, 0, 0);
      if (this.mTargetState >= 8) {
        break label100;
      }
    }
    for (;;)
    {
      DataReport.getInstance(this.mPluginID).reportDownloadComplete(5, this.mLocalPlugin.getMaxSdkVersion(), 0, "", this.mInitParam.mDownloadEngine, this.mDownloadType, i, this.mPluginChecker.getCheckUrl());
      return;
      XLog.i("XProxy | XPluginStateMachine", "后台偷偷更新, 结果：无更新");
      break;
      label100:
      i = 2;
    }
  }
  
  public void onStartDownloadFile(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    if (this.mEvent != null) {
      this.mEvent.onDownloadStart(paramInt, paramString1, paramString2, paramHostEventListener);
    }
  }
  
  public void onStartIncUpdate(Bundle paramBundle) {}
  
  public void onStarted(String paramString)
  {
    UtilPerf.finishStartActivity();
    gotoStatus(8, 0, 0);
    DataReport.getInstance(this.mPluginID).reportBootComplete(this.mLocalPlugin.getMaxSdkVersion(), this.mBootType, 0, "0", "", this.mLocalPlugin.getRetryTimes());
    this.mLocalPlugin.resetRetryTimes();
    this.mInstaller.dex2OatInSubThread();
  }
  
  public void onUpdateError(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (this.mCurrentStatus == 1)
    {
      XLog.i("XProxy | XPluginStateMachine", "下载出错，code" + paramInt1 + " errInfo = " + this.mPluginUpdater.getLastError() + "headInfo = " + this.mPluginUpdater.getLastHeadInfo());
      this.mEvent.onExecuteError(this.mTargetState, paramInt1, "");
      gotoStatus(0, 0, 0);
      this.mUpdateProgress = 0;
      this.mPluginChecker.resetStatus();
      if (this.mTargetState >= 8) {
        break label189;
      }
    }
    for (;;)
    {
      DataReport.getInstance(this.mPluginID).reportDownloadFail(paramInt1, this.mLocalPlugin.getMaxSdkVersion(), paramInt2, this.mPluginUpdater.getLastError(), this.mInitParam.mDownloadEngine, this.mDownloadType, i, this.mPluginChecker.getCheckUrl());
      return;
      XLog.i("XProxy | XPluginStateMachine", "后台偷偷更新失败了，code = " + paramInt1);
      break;
      label189:
      i = 2;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (paramInt > this.mUpdateProgress)
    {
      this.mUpdateProgress = paramInt;
      if (getStatus() == 1) {
        this.mEvent.onStateChange(this.mCurrentStatus, this.mCurrentStatus, 0, paramInt);
      }
    }
  }
  
  public void onUpdated()
  {
    int i = 1;
    if (this.mCurrentStatus == 1)
    {
      XLog.perfLog("下载完成");
      gotoStatus(2, 0, 0);
      this.mUpdateProgress = 0;
      excecute(this.mIntent);
      if (this.mTargetState >= 8) {
        break label104;
      }
    }
    for (;;)
    {
      DataReport.getInstance(this.mPluginID).reportDownloadComplete(0, this.mLocalPlugin.getMaxSdkVersion(), 0, "", this.mInitParam.mDownloadEngine, this.mDownloadType, i, this.mPluginChecker.getCheckUrl());
      return;
      XLog.perfLog("静默更新完成");
      installPluginInner(3);
      break;
      label104:
      i = 2;
    }
  }
  
  public void resetStateToIdel()
  {
    this.mCurrentStatus = 0;
  }
  
  public void setBootType()
  {
    if (getStatus() < 4) {
      this.mBootType = 1;
    }
    do
    {
      return;
      if ((getStatus() >= 4) && (getStatus() < 6))
      {
        this.mBootType = 2;
        return;
      }
    } while (getStatus() < 6);
    this.mBootType = 3;
  }
  
  public void setDownloadInHost(boolean paramBoolean)
  {
    if (this.mInitParam != null) {
      this.mInitParam.isDownloadInHost = paramBoolean;
    }
  }
  
  public void setTargetState(int paramInt)
  {
    this.mTargetState = paramInt;
  }
  
  public void setUpdater(PluginUpdater paramPluginUpdater, int paramInt)
  {
    this.mPluginUpdater = paramPluginUpdater;
    this.mDownloadType = paramInt;
  }
  
  public void unInit(boolean paramBoolean)
  {
    XLog.i("XProxy | XPluginStateMachine", "uninit,isExitProcess = " + paramBoolean);
    this.mPluginLauncher.unInit(paramBoolean);
    gotoStatus(0, 0, 0);
  }
  
  public static abstract interface Event
  {
    public abstract void onDownloadStart(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener);
    
    public abstract void onExecuteError(int paramInt1, int paramInt2, String paramString);
    
    public abstract boolean onRetry(String paramString);
    
    public abstract void onStateChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract boolean onUnZipSOFile(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.excecutor.XPluginStateMachine
 * JD-Core Version:    0.7.0.1
 */