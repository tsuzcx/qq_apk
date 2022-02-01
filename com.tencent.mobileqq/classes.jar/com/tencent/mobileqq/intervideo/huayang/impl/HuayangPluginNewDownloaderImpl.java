package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader;
import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HuayangPluginNewDownloaderImpl
  implements IHuayangPluginNewDownloader
{
  private static final int MSG_CHECK_VERSION = 0;
  private static final int MSG_NOTIFY_DOWNLOAD_COMPLETED = 2;
  private static final int MSG_NOTIFY_DOWNLOAD_FAILED = 3;
  private static final int MSG_NOTIFY_PRELOAD_COMPLETE = 5;
  private static final int MSG_NOTIFY_PRELOAD_FAILED = 6;
  private static final int MSG_NOTIFY_PRELOAD_PLUGIN_PROCESS = 7;
  private static final int MSG_NOTIFY_READ_PROGRESS = 4;
  private static final int MSG_UPDATE_PROGRESS = 1;
  private static final int PLUGIN_MANAGER_INIT_TIME_SECS = 10;
  public static final String TAG = "HuayangPluginNewDownloader";
  private static final int VALUE_MAIN_PLUGIN = 1;
  private String mAction;
  private Context mAppContext;
  private String mAppName;
  private IVPluginDataReporter mDataReporter;
  private IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener mDownloadListener;
  private volatile List<ProgressFuture<InstalledPlugin>> mGetPluginFuture;
  private volatile boolean mIsHaveCache;
  private Map<String, IVPluginInfo> mPluginInfoMap;
  private String mPluginPackageName;
  private String mPluginVersion;
  private int mProgress;
  private Runnable mRunnable = new HuayangPluginNewDownloaderImpl.3(this);
  private volatile boolean mRunning = false;
  private long mStartFlag;
  private long mStartTime;
  private boolean mTestEnv;
  private long mTotalSize;
  private Handler mUiHandler;
  private Handler.Callback mUiHandlerCallback = new HuayangPluginNewDownloaderImpl.1(this);
  public String mUin = "";
  private UpgradeablePluginManager upgradeablePluginManager;
  
  private void doForceUpdate(InstalledPlugin paramInstalledPlugin)
  {
    this.mIsHaveCache = false;
    Object localObject = this.mDownloadListener;
    if (localObject != null) {
      ((IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener)localObject).a(10, new Object[0]);
    }
    report("doForceUpdate", 0, 0, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForConfigPluginLoader);
    localObject = new Intent("action_iv_plugin_update");
    ((Intent)localObject).putExtra("plugin", paramInstalledPlugin);
    BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject);
    log("HuayangPluginNewDownloader", HardCodeUtil.a(2131705741));
  }
  
  private InstalledPlugin downloadPluginDownloadInfo(ProgressFuture<InstalledPlugin> paramProgressFuture)
  {
    Handler localHandler;
    if (!this.mIsHaveCache)
    {
      localHandler = this.mUiHandler;
      localHandler.sendMessage(Message.obtain(localHandler, 4, paramProgressFuture));
    }
    if ((!this.mIsHaveCache) && (Monitor.a()))
    {
      localHandler = this.mUiHandler;
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 1, 30, 0), 2000L);
      localHandler = this.mUiHandler;
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 1, 70, 0), 6000L);
    }
    try
    {
      paramProgressFuture = (InstalledPlugin)paramProgressFuture.get();
      if (!this.mIsHaveCache) {
        this.mUiHandler.removeMessages(4);
      }
      return paramProgressFuture;
    }
    catch (Exception paramProgressFuture)
    {
      if (!this.mIsHaveCache) {
        this.mUiHandler.removeMessages(4);
      }
      throw paramProgressFuture;
    }
  }
  
  /* Error */
  private InstalledPlugin getPluginFromServer(InstalledPlugin paramInstalledPlugin)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 29
    //   3: ldc 235
    //   5: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   11: lstore 6
    //   13: aload_0
    //   14: getfield 243	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:upgradeablePluginManager	Lcom/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager;
    //   17: ldc2_w 244
    //   20: getstatic 251	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   23: invokevirtual 257	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:upgradeIfNeededThenInit	(JLjava/util/concurrent/TimeUnit;)I
    //   26: istore_2
    //   27: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   30: lload 6
    //   32: lsub
    //   33: lstore 6
    //   35: new 259	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   42: astore 9
    //   44: aload 9
    //   46: ldc_w 262
    //   49: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 9
    //   55: iload_2
    //   56: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 9
    //   62: ldc_w 271
    //   65: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 9
    //   71: lload 6
    //   73: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: ldc 29
    //   80: aload 9
    //   82: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_2
    //   89: iconst_m1
    //   90: if_icmpeq +38 -> 128
    //   93: aload_0
    //   94: ldc_w 280
    //   97: iload_2
    //   98: lload 6
    //   100: l2i
    //   101: ldc 70
    //   103: ldc 70
    //   105: invokespecial 156	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:report	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: iconst_1
    //   110: if_icmpne +12 -> 122
    //   113: ldc_w 282
    //   116: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   119: goto +9 -> 128
    //   122: ldc_w 286
    //   125: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 243	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:upgradeablePluginManager	Lcom/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager;
    //   132: invokevirtual 290	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:getVersionChecker	()Lcom/tencent/hydevteam/pluginframework/pluginmanager/VersionChecker;
    //   135: astore 15
    //   137: iconst_2
    //   138: anewarray 292	java/lang/String
    //   141: astore 16
    //   143: aload 16
    //   145: iconst_0
    //   146: ldc_w 294
    //   149: aastore
    //   150: ldc_w 296
    //   153: astore 13
    //   155: aload 16
    //   157: iconst_1
    //   158: ldc_w 296
    //   161: aastore
    //   162: new 259	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   169: astore 12
    //   171: aload 16
    //   173: arraylength
    //   174: istore_2
    //   175: aconst_null
    //   176: astore 9
    //   178: aconst_null
    //   179: astore 11
    //   181: iconst_0
    //   182: istore_3
    //   183: iload_3
    //   184: iload_2
    //   185: if_icmpge +892 -> 1077
    //   188: aload 16
    //   190: iload_3
    //   191: aaload
    //   192: astore 17
    //   194: aload_0
    //   195: getfield 72	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mUin	Ljava/lang/String;
    //   198: astore 10
    //   200: aload_0
    //   201: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   204: astore 18
    //   206: aload_0
    //   207: getfield 298	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mTestEnv	Z
    //   210: istore 8
    //   212: aload 13
    //   214: astore 14
    //   216: aload 15
    //   218: aload 17
    //   220: aload 10
    //   222: aload 18
    //   224: iload 8
    //   226: aload_1
    //   227: invokeinterface 304 6 0
    //   232: astore 9
    //   234: aload 17
    //   236: ldc_w 294
    //   239: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   242: ifeq +12 -> 254
    //   245: ldc_w 310
    //   248: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   251: goto +19 -> 270
    //   254: aload 17
    //   256: aload 14
    //   258: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifeq +9 -> 270
    //   264: ldc_w 312
    //   267: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   270: new 259	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   277: astore 10
    //   279: aload 10
    //   281: ldc_w 313
    //   284: invokestatic 185	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   287: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 10
    //   293: aload 9
    //   295: getfield 318	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:url	Ljava/lang/String;
    //   298: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_0
    //   303: ldc 29
    //   305: aload 10
    //   307: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_0
    //   314: aload 9
    //   316: getfield 321	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:size	J
    //   319: putfield 107	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mTotalSize	J
    //   322: aload 9
    //   324: getfield 324	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:forceUpdate	Z
    //   327: ifeq +12 -> 339
    //   330: aload_1
    //   331: ifnull +8 -> 339
    //   334: aload_0
    //   335: aload_1
    //   336: invokespecial 326	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:doForceUpdate	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;)V
    //   339: aload 9
    //   341: instanceof 328
    //   344: ifeq +94 -> 438
    //   347: aload 9
    //   349: checkcast 328	com/tencent/hydevteam/pluginframework/pluginmanager/MultiTargetDownloadInfo
    //   352: getfield 331	com/tencent/hydevteam/pluginframework/pluginmanager/MultiTargetDownloadInfo:allSubTargets	Ljava/util/Map;
    //   355: astore 10
    //   357: aload 10
    //   359: ifnull +79 -> 438
    //   362: aload 10
    //   364: invokeinterface 337 1 0
    //   369: invokeinterface 343 1 0
    //   374: astore 10
    //   376: aload 10
    //   378: invokeinterface 348 1 0
    //   383: ifeq +55 -> 438
    //   386: aload 10
    //   388: invokeinterface 351 1 0
    //   393: checkcast 353	java/util/Map$Entry
    //   396: astore 18
    //   398: aload 18
    //   400: invokeinterface 356 1 0
    //   405: checkcast 358	java/lang/CharSequence
    //   408: aload_0
    //   409: getfield 360	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginPackageName	Ljava/lang/String;
    //   412: invokestatic 365	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   415: ifeq -39 -> 376
    //   418: aload_0
    //   419: aload 18
    //   421: invokeinterface 368 1 0
    //   426: checkcast 315	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo
    //   429: getfield 321	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:size	J
    //   432: putfield 107	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mTotalSize	J
    //   435: goto -59 -> 376
    //   438: aload_0
    //   439: getfield 129	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mUiHandler	Landroid/os/Handler;
    //   442: iconst_0
    //   443: aload_0
    //   444: getfield 107	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mTotalSize	J
    //   447: invokestatic 374	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   450: invokestatic 195	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   453: astore 10
    //   455: aload_0
    //   456: getfield 129	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mUiHandler	Landroid/os/Handler;
    //   459: aload 10
    //   461: invokevirtual 201	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   464: pop
    //   465: ldc_w 376
    //   468: aload_0
    //   469: getfield 378	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAction	Ljava/lang/String;
    //   472: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: istore 8
    //   477: iload 8
    //   479: ifeq +5 -> 484
    //   482: aconst_null
    //   483: areturn
    //   484: aload_0
    //   485: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   488: ifne +9 -> 497
    //   491: aload_0
    //   492: bipush 10
    //   494: invokespecial 381	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:publishProgress	(I)V
    //   497: aload_0
    //   498: ldc 29
    //   500: ldc_w 383
    //   503: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   509: lstore 6
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 243	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:upgradeablePluginManager	Lcom/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager;
    //   516: aload_0
    //   517: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   520: aload 9
    //   522: aload_0
    //   523: getfield 360	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginPackageName	Ljava/lang/String;
    //   526: invokevirtual 387	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:updatePlugin	(Ljava/lang/String;Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;Ljava/lang/String;)Ljava/util/List;
    //   529: putfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   537: iconst_0
    //   538: invokeinterface 394 2 0
    //   543: checkcast 219	com/tencent/hydevteam/common/progress/ProgressFuture
    //   546: invokespecial 396	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:downloadPluginDownloadInfo	(Lcom/tencent/hydevteam/common/progress/ProgressFuture;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   549: astore 10
    //   551: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   554: lload 6
    //   556: lsub
    //   557: l2i
    //   558: istore 5
    //   560: aload 10
    //   562: ifnonnull +9 -> 571
    //   565: iconst_m1
    //   566: istore 4
    //   568: goto +10 -> 578
    //   571: aload 10
    //   573: getfield 399	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginFileType	I
    //   576: istore 4
    //   578: aload 10
    //   580: astore 9
    //   582: aload_0
    //   583: ldc_w 400
    //   586: iload 4
    //   588: iload 5
    //   590: ldc 70
    //   592: ldc 70
    //   594: invokespecial 156	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:report	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   597: new 259	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   604: astore 11
    //   606: aload 11
    //   608: ldc_w 401
    //   611: invokestatic 185	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   614: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 11
    //   620: iload 5
    //   622: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_0
    //   627: ldc 29
    //   629: aload 11
    //   631: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 17
    //   639: ldc_w 294
    //   642: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   645: ifeq +12 -> 657
    //   648: ldc_w 403
    //   651: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   654: goto +19 -> 673
    //   657: aload 17
    //   659: aload 14
    //   661: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +9 -> 673
    //   667: ldc_w 405
    //   670: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   673: new 259	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   680: astore 11
    //   682: aload 9
    //   684: astore 10
    //   686: aload 11
    //   688: ldc_w 407
    //   691: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 9
    //   697: ifnonnull +492 -> 1189
    //   700: iconst_1
    //   701: istore 8
    //   703: goto +3 -> 706
    //   706: aload 9
    //   708: astore 10
    //   710: aload 11
    //   712: iload 8
    //   714: invokevirtual 410	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 9
    //   720: astore 10
    //   722: aload_0
    //   723: ldc 29
    //   725: aload 11
    //   727: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload 9
    //   735: areturn
    //   736: aload 9
    //   738: astore 10
    //   740: aload 17
    //   742: ldc_w 294
    //   745: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   748: ifne +30 -> 778
    //   751: aload 9
    //   753: astore 10
    //   755: aload 17
    //   757: aload 14
    //   759: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   762: ifeq +26 -> 788
    //   765: aload 9
    //   767: astore 10
    //   769: ldc_w 412
    //   772: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   775: goto +13 -> 788
    //   778: aload 9
    //   780: astore 10
    //   782: ldc_w 414
    //   785: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   788: aload 9
    //   790: astore 10
    //   792: aload 11
    //   794: athrow
    //   795: astore 11
    //   797: aload 10
    //   799: astore 9
    //   801: aload 11
    //   803: astore 10
    //   805: aconst_null
    //   806: astore 14
    //   808: aload 9
    //   810: astore 11
    //   812: aload 14
    //   814: astore 9
    //   816: goto +75 -> 891
    //   819: astore 10
    //   821: aconst_null
    //   822: astore 9
    //   824: goto +67 -> 891
    //   827: astore 10
    //   829: aconst_null
    //   830: astore 9
    //   832: goto +59 -> 891
    //   835: astore 10
    //   837: aconst_null
    //   838: astore 9
    //   840: goto +10 -> 850
    //   843: astore 10
    //   845: goto +46 -> 891
    //   848: astore 10
    //   850: aload 17
    //   852: ldc_w 294
    //   855: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   858: ifne +22 -> 880
    //   861: aload 17
    //   863: aload 13
    //   865: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   868: ifeq +18 -> 886
    //   871: ldc_w 416
    //   874: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   877: goto +9 -> 886
    //   880: ldc_w 418
    //   883: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   886: aload 10
    //   888: athrow
    //   889: astore 10
    //   891: aload 12
    //   893: astore 14
    //   895: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   898: ifeq +54 -> 952
    //   901: new 259	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   908: astore 18
    //   910: aload 18
    //   912: ldc_w 425
    //   915: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload 18
    //   921: aload 17
    //   923: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: aload 18
    //   929: ldc_w 427
    //   932: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: ldc 29
    //   938: iconst_2
    //   939: aload 18
    //   941: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: aload 10
    //   946: invokestatic 431	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   949: goto +3 -> 952
    //   952: ldc_w 433
    //   955: invokestatic 439	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   958: checkcast 433	com/tencent/mobileqq/intervideo/huayang/IHuayangCrashReport
    //   961: aload 10
    //   963: invokeinterface 442 2 0
    //   968: aload 14
    //   970: aload 10
    //   972: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   975: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 14
    //   981: ldc_w 445
    //   984: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 17
    //   990: ldc_w 294
    //   993: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   996: ifeq +13 -> 1009
    //   999: aload_0
    //   1000: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   1003: ifeq +6 -> 1009
    //   1006: goto +71 -> 1077
    //   1009: aload_0
    //   1010: getfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   1013: ifnull +53 -> 1066
    //   1016: aload_0
    //   1017: getfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   1020: invokeinterface 446 1 0
    //   1025: astore 10
    //   1027: aload 10
    //   1029: invokeinterface 348 1 0
    //   1034: ifeq +23 -> 1057
    //   1037: aload 10
    //   1039: invokeinterface 351 1 0
    //   1044: checkcast 219	com/tencent/hydevteam/common/progress/ProgressFuture
    //   1047: iconst_1
    //   1048: invokeinterface 450 2 0
    //   1053: pop
    //   1054: goto -27 -> 1027
    //   1057: aload_0
    //   1058: aload 9
    //   1060: putfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   1063: goto +3 -> 1066
    //   1066: iload_3
    //   1067: iconst_1
    //   1068: iadd
    //   1069: istore_3
    //   1070: aload 14
    //   1072: astore 12
    //   1074: goto -891 -> 183
    //   1077: iconst_1
    //   1078: istore 8
    //   1080: new 259	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   1087: astore_1
    //   1088: aload_1
    //   1089: ldc_w 407
    //   1092: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 11
    //   1098: ifnonnull +6 -> 1104
    //   1101: goto +6 -> 1107
    //   1104: iconst_0
    //   1105: istore 8
    //   1107: aload_1
    //   1108: iload 8
    //   1110: invokevirtual 410	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: aload_0
    //   1115: ldc 29
    //   1117: aload_1
    //   1118: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   1124: ldc_w 452
    //   1127: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   1130: aload_0
    //   1131: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   1134: ifeq +9 -> 1143
    //   1137: ldc_w 454
    //   1140: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   1143: new 259	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   1150: astore_1
    //   1151: aload_1
    //   1152: ldc_w 456
    //   1155: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload_1
    //   1160: aload 12
    //   1162: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: new 233	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   1172: dup
    //   1173: aload_1
    //   1174: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokespecial 457	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   1180: astore_1
    //   1181: goto +5 -> 1186
    //   1184: aload_1
    //   1185: athrow
    //   1186: goto -2 -> 1184
    //   1189: iconst_0
    //   1190: istore 8
    //   1192: goto -486 -> 706
    //   1195: astore 10
    //   1197: goto -392 -> 805
    //   1200: astore 9
    //   1202: goto +5 -> 1207
    //   1205: astore 9
    //   1207: aload 9
    //   1209: astore 11
    //   1211: aload 10
    //   1213: astore 9
    //   1215: goto -479 -> 736
    //   1218: astore 10
    //   1220: aload 11
    //   1222: astore 9
    //   1224: aload 10
    //   1226: astore 11
    //   1228: goto -492 -> 736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1231	0	this	HuayangPluginNewDownloaderImpl
    //   0	1231	1	paramInstalledPlugin	InstalledPlugin
    //   26	160	2	i	int
    //   182	888	3	j	int
    //   566	21	4	k	int
    //   558	63	5	m	int
    //   11	544	6	l	long
    //   210	981	8	bool	boolean
    //   42	1017	9	localObject1	Object
    //   1200	1	9	localException1	Exception
    //   1205	3	9	localException2	Exception
    //   1213	10	9	localObject2	Object
    //   198	606	10	localObject3	Object
    //   819	1	10	localException3	Exception
    //   827	1	10	localException4	Exception
    //   835	1	10	localVersionCheckException1	com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException
    //   843	1	10	localException5	Exception
    //   848	39	10	localVersionCheckException2	com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException
    //   889	82	10	localException6	Exception
    //   1025	13	10	localIterator	Iterator
    //   1195	17	10	localException7	Exception
    //   1218	7	10	localException8	Exception
    //   179	614	11	localStringBuilder	StringBuilder
    //   795	7	11	localException9	Exception
    //   810	417	11	localObject4	Object
    //   169	992	12	localObject5	Object
    //   153	711	13	str1	String
    //   214	857	14	localObject6	Object
    //   135	82	15	localVersionChecker	com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker
    //   141	48	16	arrayOfString	String[]
    //   192	797	17	str2	String
    //   204	736	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   686	695	795	java/lang/Exception
    //   710	718	795	java/lang/Exception
    //   722	733	795	java/lang/Exception
    //   740	751	795	java/lang/Exception
    //   755	765	795	java/lang/Exception
    //   769	775	795	java/lang/Exception
    //   782	788	795	java/lang/Exception
    //   792	795	795	java/lang/Exception
    //   484	497	819	java/lang/Exception
    //   497	532	819	java/lang/Exception
    //   216	251	827	java/lang/Exception
    //   254	270	827	java/lang/Exception
    //   270	330	827	java/lang/Exception
    //   334	339	827	java/lang/Exception
    //   339	357	827	java/lang/Exception
    //   362	376	827	java/lang/Exception
    //   376	435	827	java/lang/Exception
    //   438	477	827	java/lang/Exception
    //   216	251	835	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   254	270	835	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   194	212	843	java/lang/Exception
    //   194	212	848	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   850	877	889	java/lang/Exception
    //   880	886	889	java/lang/Exception
    //   886	889	889	java/lang/Exception
    //   673	682	1195	java/lang/Exception
    //   582	654	1200	java/lang/Exception
    //   657	673	1200	java/lang/Exception
    //   551	560	1205	java/lang/Exception
    //   571	578	1205	java/lang/Exception
    //   532	551	1218	java/lang/Exception
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void notifyDownloadCompleted(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131705727));
    boolean bool;
    if (paramInstalledPlugin == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    log("HuayangPluginNewDownloader", ((StringBuilder)localObject).toString());
    reportIsCache(this.mIsHaveCache);
    notifyUIStateChange(2, paramInstalledPlugin);
    if (paramBoolean) {
      localObject = "fromCache";
    } else {
      localObject = "fromServer";
    }
    reportDownloadResult(true, paramInstalledPlugin, (String)localObject, null);
    this.mUiHandler.removeMessages(4);
  }
  
  private void notifyPreloadCompete(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131705729));
    localStringBuilder.append(paramInstalledPlugin);
    log("HuayangPluginNewDownloader", localStringBuilder.toString());
    paramInstalledPlugin = Message.obtain(this.mUiHandler, 5, paramInstalledPlugin);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = -1;
    }
    paramInstalledPlugin.arg1 = i;
    this.mUiHandler.sendMessage(paramInstalledPlugin);
  }
  
  private void notifyUIStateChange(int paramInt, Object paramObject)
  {
    paramObject = Message.obtain(this.mUiHandler, paramInt, paramObject);
    this.mUiHandler.sendMessage(paramObject);
  }
  
  private void preloadPlugin(InstalledPlugin paramInstalledPlugin)
  {
    long l = System.currentTimeMillis();
    boolean bool = TextUtils.equals(this.mAppName, "group_video");
    try
    {
      this.upgradeablePluginManager.preloadApk(this.mAppContext, paramInstalledPlugin, bool).get();
      log("HuayangPluginNewDownloader", HardCodeUtil.a(2131705721));
      if (!this.mIsHaveCache) {
        notifyPreloadCompete(paramInstalledPlugin, true);
      }
      Object localObject = null;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuayangPluginNewDownloader", 2, "预加载过程中出错：", localException);
      }
      if (!this.mIsHaveCache) {
        notifyUIStateChange(6, localException.toString());
      }
      ((IHuayangCrashReport)QRoute.api(IHuayangCrashReport.class)).report(localException);
    }
    int i = (int)(System.currentTimeMillis() - l);
    String str = paramInstalledPlugin.toString();
    if (localException != null) {
      paramInstalledPlugin = localException.getMessage();
    } else {
      paramInstalledPlugin = "";
    }
    report("preLoadFinish", 0, i, str, paramInstalledPlugin);
  }
  
  private void publishProgress(int paramInt)
  {
    Message localMessage = Message.obtain(this.mUiHandler, 1, paramInt, 0);
    this.mUiHandler.sendMessage(localMessage);
  }
  
  private void report(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    IVPluginDataReporter localIVPluginDataReporter = this.mDataReporter.opType(paramString1);
    if (TextUtils.isEmpty(this.mAction)) {
      paramString1 = "null";
    } else {
      paramString1 = this.mAction;
    }
    paramString2 = localIVPluginDataReporter.opName(paramString1).opIn(paramInt1).opResult(paramInt2).d1(paramString2).d2(paramString3);
    if (this.mIsHaveCache) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    paramString2.d3(paramString1).d4(this.mPluginPackageName).report();
  }
  
  private void reportDownloadResult(boolean paramBoolean, InstalledPlugin paramInstalledPlugin, String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportIsCache(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportPreDownload(InstalledPlugin paramInstalledPlugin, Exception paramException, int paramInt)
  {
    if (paramInstalledPlugin != null)
    {
      report("preDownloadFinish", 1, paramInt, paramInstalledPlugin.toString(), null);
      return;
    }
    if (paramException != null) {
      paramInstalledPlugin = paramException.getMessage();
    } else {
      paramInstalledPlugin = "";
    }
    report("preDownloadFinish", 0, paramInt, paramInstalledPlugin, null);
  }
  
  /* Error */
  private void runDownloadTask()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 243	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:upgradeablePluginManager	Lcom/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager;
    //   4: aload_0
    //   5: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   8: invokevirtual 565	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:getCachedLatestPlugin	(Ljava/lang/String;)Ljava/util/List;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +225 -> 240
    //   18: aload 5
    //   20: invokeinterface 568 1 0
    //   25: ifle +215 -> 240
    //   28: new 570	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 571	java/util/ArrayList:<init>	()V
    //   35: astore 6
    //   37: aload 5
    //   39: invokeinterface 446 1 0
    //   44: astore 7
    //   46: aload 7
    //   48: invokeinterface 348 1 0
    //   53: ifeq +27 -> 80
    //   56: aload 6
    //   58: aload 7
    //   60: invokeinterface 351 1 0
    //   65: checkcast 146	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin
    //   68: getfield 574	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginVersionForPluginLoaderManage	Ljava/lang/String;
    //   71: invokeinterface 577 2 0
    //   76: pop
    //   77: goto -31 -> 46
    //   80: aload 6
    //   82: invokestatic 583	java/util/Collections:sort	(Ljava/util/List;)V
    //   85: aload 6
    //   87: invokevirtual 584	java/lang/Object:toString	()Ljava/lang/String;
    //   90: astore 6
    //   92: aload_0
    //   93: getfield 586	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginVersion	Ljava/lang/String;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +134 -> 234
    //   103: aload 6
    //   105: aload 7
    //   107: invokestatic 365	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   110: ifne +124 -> 234
    //   113: new 259	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   120: astore 7
    //   122: aload 7
    //   124: ldc_w 587
    //   127: invokestatic 185	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   130: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 7
    //   136: aload 6
    //   138: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 7
    //   144: ldc_w 589
    //   147: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 7
    //   153: aload_0
    //   154: getfield 586	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginVersion	Ljava/lang/String;
    //   157: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: ldc 29
    //   164: aload 7
    //   166: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc_w 591
    //   175: invokestatic 439	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   178: checkcast 591	com/tencent/mobileqq/intervideo/huayang/IHuayangOpenHelper
    //   181: astore 7
    //   183: aload_0
    //   184: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   187: astore 8
    //   189: new 259	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   196: astore 9
    //   198: aload 9
    //   200: aload_0
    //   201: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   204: invokevirtual 596	android/content/Context:getPackageName	()Ljava/lang/String;
    //   207: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 9
    //   213: ldc_w 598
    //   216: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: aload 8
    //   224: aload 9
    //   226: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokeinterface 602 3 0
    //   234: aload_0
    //   235: aload 6
    //   237: putfield 586	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginVersion	Ljava/lang/String;
    //   240: iconst_1
    //   241: istore_1
    //   242: aload 5
    //   244: ifnull +66 -> 310
    //   247: aload 5
    //   249: invokeinterface 568 1 0
    //   254: iconst_1
    //   255: if_icmpne +55 -> 310
    //   258: aload 5
    //   260: iconst_0
    //   261: invokeinterface 394 2 0
    //   266: checkcast 146	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin
    //   269: getfield 399	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginFileType	I
    //   272: ifne +38 -> 310
    //   275: aload 5
    //   277: iconst_0
    //   278: invokeinterface 394 2 0
    //   283: checkcast 146	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin
    //   286: astore 5
    //   288: aload_0
    //   289: iconst_1
    //   290: putfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   293: aload_0
    //   294: aload 5
    //   296: iconst_1
    //   297: invokespecial 604	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyDownloadCompleted	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   300: aload_0
    //   301: aload 5
    //   303: iconst_1
    //   304: invokespecial 498	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyPreloadCompete	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   307: goto +148 -> 455
    //   310: aload 5
    //   312: ifnull +101 -> 413
    //   315: aload 5
    //   317: invokeinterface 606 1 0
    //   322: ifne +91 -> 413
    //   325: aload 5
    //   327: invokeinterface 446 1 0
    //   332: astore 7
    //   334: aconst_null
    //   335: astore 5
    //   337: aload 7
    //   339: invokeinterface 348 1 0
    //   344: ifeq +66 -> 410
    //   347: aload 7
    //   349: invokeinterface 351 1 0
    //   354: checkcast 146	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin
    //   357: astore 6
    //   359: aload 6
    //   361: getfield 149	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginPackageName	Ljava/lang/String;
    //   364: aload_0
    //   365: getfield 360	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginPackageName	Ljava/lang/String;
    //   368: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq +29 -> 400
    //   374: aload_0
    //   375: iconst_1
    //   376: putfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   379: aload_0
    //   380: aload 6
    //   382: iconst_1
    //   383: invokespecial 604	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyDownloadCompleted	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   386: aload_0
    //   387: aload 6
    //   389: iconst_1
    //   390: invokespecial 498	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyPreloadCompete	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   393: aload 6
    //   395: astore 5
    //   397: goto -60 -> 337
    //   400: aload_0
    //   401: aload 6
    //   403: iconst_0
    //   404: invokespecial 498	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyPreloadCompete	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   407: goto -70 -> 337
    //   410: goto +45 -> 455
    //   413: getstatic 610	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   416: aload_0
    //   417: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   420: invokeinterface 613 2 0
    //   425: ifnull +27 -> 452
    //   428: getstatic 610	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:a	Ljava/util/Map;
    //   431: aload_0
    //   432: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   435: invokeinterface 613 2 0
    //   440: checkcast 608	com/tencent/mobileqq/intervideo/huayang/MonitorConfig
    //   443: getfield 616	com/tencent/mobileqq/intervideo/huayang/MonitorConfig:g	I
    //   446: invokestatic 618	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   449: invokestatic 621	com/tencent/mobileqq/intervideo/huayang/Monitor:b	(Ljava/lang/String;)V
    //   452: aconst_null
    //   453: astore 5
    //   455: lconst_0
    //   456: lstore_2
    //   457: aload_0
    //   458: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   461: ifeq +7 -> 468
    //   464: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   467: lstore_2
    //   468: aload_0
    //   469: getfield 378	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAction	Ljava/lang/String;
    //   472: ldc_w 623
    //   475: invokestatic 365	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   478: ifne +10 -> 488
    //   481: aload_0
    //   482: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   485: ifne +13 -> 498
    //   488: aload_0
    //   489: getfield 129	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mUiHandler	Landroid/os/Handler;
    //   492: bipush 7
    //   494: invokevirtual 627	android/os/Handler:sendEmptyMessage	(I)Z
    //   497: pop
    //   498: aload_0
    //   499: getfield 629	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginInfoMap	Ljava/util/Map;
    //   502: aload_0
    //   503: getfield 360	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginPackageName	Ljava/lang/String;
    //   506: invokeinterface 613 2 0
    //   511: checkcast 631	com/tencent/mobileqq/intervideo/IVPluginInfo
    //   514: astore 6
    //   516: aload 6
    //   518: ifnull +57 -> 575
    //   521: aload 6
    //   523: getfield 634	com/tencent/mobileqq/intervideo/IVPluginInfo:j	Ljava/lang/String;
    //   526: astore 6
    //   528: aload 6
    //   530: ifnull +45 -> 575
    //   533: new 636	org/json/JSONObject
    //   536: dup
    //   537: aload 6
    //   539: invokespecial 637	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   542: astore 6
    //   544: aload 6
    //   546: ldc_w 639
    //   549: invokevirtual 643	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   552: ifeq +23 -> 575
    //   555: aload 6
    //   557: ldc_w 639
    //   560: invokevirtual 646	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   563: istore 4
    //   565: goto +13 -> 578
    //   568: astore 6
    //   570: aload 6
    //   572: invokevirtual 649	org/json/JSONException:printStackTrace	()V
    //   575: iconst_0
    //   576: istore 4
    //   578: ldc_w 651
    //   581: aload_0
    //   582: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   585: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   588: ifeq +19 -> 607
    //   591: aload_0
    //   592: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   595: invokestatic 657	com/tencent/mobileqq/utils/NetworkUtil:isWifiEnabled	(Landroid/content/Context;)Z
    //   598: ifne +9 -> 607
    //   601: iload 4
    //   603: ifeq +4 -> 607
    //   606: return
    //   607: aload_0
    //   608: aload 5
    //   610: invokespecial 659	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:getPluginFromServer	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   613: astore 5
    //   615: aconst_null
    //   616: astore 6
    //   618: goto +42 -> 660
    //   621: astore 6
    //   623: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +15 -> 641
    //   629: ldc 29
    //   631: iconst_2
    //   632: aload 6
    //   634: iconst_0
    //   635: anewarray 4	java/lang/Object
    //   638: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   641: ldc_w 433
    //   644: invokestatic 439	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   647: checkcast 433	com/tencent/mobileqq/intervideo/huayang/IHuayangCrashReport
    //   650: aload 6
    //   652: invokeinterface 442 2 0
    //   657: aconst_null
    //   658: astore 5
    //   660: ldc_w 376
    //   663: aload_0
    //   664: getfield 378	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAction	Ljava/lang/String;
    //   667: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   670: ifeq +9 -> 679
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 74	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mRunning	Z
    //   678: return
    //   679: aload_0
    //   680: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   683: ifne +49 -> 732
    //   686: aload 6
    //   688: ifnonnull +19 -> 707
    //   691: aload_0
    //   692: bipush 100
    //   694: invokespecial 381	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:publishProgress	(I)V
    //   697: aload_0
    //   698: aload 5
    //   700: iconst_0
    //   701: invokespecial 604	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyDownloadCompleted	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   704: goto +42 -> 746
    //   707: aload_0
    //   708: iconst_3
    //   709: aload 6
    //   711: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   714: invokespecial 472	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyUIStateChange	(ILjava/lang/Object;)V
    //   717: aload_0
    //   718: iconst_0
    //   719: aconst_null
    //   720: aconst_null
    //   721: aload 6
    //   723: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   726: invokespecial 480	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:reportDownloadResult	(ZLcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   729: goto +17 -> 746
    //   732: aload_0
    //   733: aload 5
    //   735: aload 6
    //   737: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   740: lload_2
    //   741: lsub
    //   742: l2i
    //   743: invokespecial 664	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:reportPreDownload	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Ljava/lang/Exception;I)V
    //   746: aload 5
    //   748: ifnull +52 -> 800
    //   751: aload_0
    //   752: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   755: aload 5
    //   757: getfield 149	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginPackageName	Ljava/lang/String;
    //   760: aload 5
    //   762: getfield 574	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginVersionForPluginLoaderManage	Ljava/lang/String;
    //   765: aload 5
    //   767: getfield 668	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginFile	Ljava/io/File;
    //   770: invokevirtual 673	java/io/File:getName	()Ljava/lang/String;
    //   773: invokestatic 679	com/tencent/hydevteam/pluginframework/installedplugin/PluginRunningPath:isPreOdexFileExists	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   776: ifne +24 -> 800
    //   779: aload_0
    //   780: ldc 29
    //   782: ldc_w 680
    //   785: invokestatic 185	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   788: invokespecial 123	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload_0
    //   792: aload 5
    //   794: invokespecial 682	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:preloadPlugin	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;)V
    //   797: goto +22 -> 819
    //   800: aload 5
    //   802: ifnull +17 -> 819
    //   805: aload_0
    //   806: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   809: ifne +10 -> 819
    //   812: aload_0
    //   813: aload 5
    //   815: iconst_1
    //   816: invokespecial 498	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyPreloadCompete	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   819: aload_0
    //   820: getfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   823: astore 7
    //   825: aload_0
    //   826: aconst_null
    //   827: putfield 389	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mGetPluginFuture	Ljava/util/List;
    //   830: aload_0
    //   831: iconst_0
    //   832: putfield 74	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mRunning	Z
    //   835: aload 7
    //   837: ifnull +204 -> 1041
    //   840: iload_1
    //   841: aload 7
    //   843: invokeinterface 568 1 0
    //   848: if_icmpge +193 -> 1041
    //   851: aload 7
    //   853: iload_1
    //   854: invokeinterface 394 2 0
    //   859: checkcast 219	com/tencent/hydevteam/common/progress/ProgressFuture
    //   862: invokeinterface 223 1 0
    //   867: checkcast 146	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin
    //   870: astore 6
    //   872: aload 6
    //   874: ifnull +67 -> 941
    //   877: aload_0
    //   878: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   881: aload 6
    //   883: getfield 149	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginPackageName	Ljava/lang/String;
    //   886: aload 6
    //   888: getfield 574	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginVersionForPluginLoaderManage	Ljava/lang/String;
    //   891: aload 6
    //   893: getfield 668	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginFile	Ljava/io/File;
    //   896: invokevirtual 673	java/io/File:getName	()Ljava/lang/String;
    //   899: invokestatic 679	com/tencent/hydevteam/pluginframework/installedplugin/PluginRunningPath:isPreOdexFileExists	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   902: ifne +39 -> 941
    //   905: aload_0
    //   906: getfield 111	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppName	Ljava/lang/String;
    //   909: ldc_w 491
    //   912: invokestatic 365	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   915: istore 4
    //   917: aload_0
    //   918: getfield 243	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:upgradeablePluginManager	Lcom/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager;
    //   921: aload_0
    //   922: getfield 133	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mAppContext	Landroid/content/Context;
    //   925: aload 6
    //   927: iload 4
    //   929: invokevirtual 495	com/tencent/hydevteam/pluginframework/pluginmanager/UpgradeablePluginManager:preloadApk	(Landroid/content/Context;Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)Lcom/tencent/hydevteam/common/progress/ProgressFuture;
    //   932: invokeinterface 223 1 0
    //   937: pop
    //   938: goto +3 -> 941
    //   941: aload 6
    //   943: ifnull +91 -> 1034
    //   946: aload_0
    //   947: getfield 137	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mIsHaveCache	Z
    //   950: ifne +84 -> 1034
    //   953: aload_0
    //   954: getfield 629	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:mPluginInfoMap	Ljava/util/Map;
    //   957: aload 6
    //   959: getfield 149	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:pluginPackageName	Ljava/lang/String;
    //   962: invokeinterface 613 2 0
    //   967: checkcast 631	com/tencent/mobileqq/intervideo/IVPluginInfo
    //   970: ifnull +64 -> 1034
    //   973: ldc_w 684
    //   976: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   979: aload_0
    //   980: aload 6
    //   982: iconst_0
    //   983: invokespecial 498	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:notifyPreloadCompete	(Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;Z)V
    //   986: goto +48 -> 1034
    //   989: astore 5
    //   991: aconst_null
    //   992: astore 6
    //   994: ldc_w 686
    //   997: invokestatic 284	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   1000: aload 6
    //   1002: ifnonnull +9 -> 1011
    //   1005: aconst_null
    //   1006: astore 6
    //   1008: goto +10 -> 1018
    //   1011: aload 6
    //   1013: invokevirtual 501	com/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin:toString	()Ljava/lang/String;
    //   1016: astore 6
    //   1018: aload_0
    //   1019: ldc_w 688
    //   1022: iconst_0
    //   1023: iconst_0
    //   1024: aload 6
    //   1026: aload 5
    //   1028: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   1031: invokespecial 156	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:report	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   1034: iload_1
    //   1035: iconst_1
    //   1036: iadd
    //   1037: istore_1
    //   1038: goto -198 -> 840
    //   1041: return
    //   1042: astore 5
    //   1044: goto -50 -> 994
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1047	0	this	HuayangPluginNewDownloaderImpl
    //   241	797	1	i	int
    //   456	285	2	l	long
    //   563	365	4	bool	boolean
    //   11	803	5	localObject1	Object
    //   989	38	5	localException1	Exception
    //   1042	1	5	localException2	Exception
    //   35	521	6	localObject2	Object
    //   568	3	6	localJSONException	org.json.JSONException
    //   616	1	6	localObject3	Object
    //   621	115	6	localException3	Exception
    //   870	155	6	localObject4	Object
    //   44	808	7	localObject5	Object
    //   187	36	8	localContext	Context
    //   196	29	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   533	565	568	org/json/JSONException
    //   607	615	621	java/lang/Exception
    //   851	872	989	java/lang/Exception
    //   877	938	1042	java/lang/Exception
    //   946	986	1042	java/lang/Exception
  }
  
  public void cancelDownload()
  {
    if ((this.mGetPluginFuture != null) && (!this.mGetPluginFuture.isEmpty()))
    {
      Monitor.a("2597859");
      Iterator localIterator = this.mGetPluginFuture.iterator();
      while (localIterator.hasNext()) {
        ((ProgressFuture)localIterator.next()).cancel(true);
      }
    }
  }
  
  public void cancelLauncher()
  {
    report("cancelLauncher", 0, (int)(System.currentTimeMillis() - this.mStartTime), "", "");
  }
  
  public void download(String paramString1, String paramString2, String paramString3, Map<String, IVPluginInfo> paramMap)
  {
    if (this.mRunning) {
      return;
    }
    this.mRunning = true;
    this.mIsHaveCache = false;
    this.mGetPluginFuture = null;
    this.mAction = paramString2;
    this.mPluginPackageName = paramString3;
    this.mPluginInfoMap = paramMap;
    this.mStartTime = System.currentTimeMillis();
    this.mAppName = paramString1;
    this.mProgress = 0;
    this.mUiHandler.removeCallbacks(this.mRunnable);
    this.mStartFlag = System.currentTimeMillis();
    this.mUiHandler.postDelayed(this.mRunnable, 40000L);
    report("startDownload", 0, 0, "", "");
    ThreadManager.postDownLoadTask(new HuayangPluginNewDownloaderImpl.2(this), 8, null, false);
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public HuayangPluginNewDownloaderImpl init(Context paramContext, File paramFile, String paramString)
  {
    this.mAppContext = paramContext;
    this.mUiHandler = new Handler(Looper.getMainLooper(), this.mUiHandlerCallback);
    this.mTestEnv = IVPluginLoader.a();
    this.upgradeablePluginManager = new UpgradeablePluginManager(paramFile, paramString, this.mTestEnv);
    this.mDataReporter = new IVPluginDataReporter();
    this.mDataReporter.opDepartment(paramString);
    return this;
  }
  
  public void setDonwanlodPreloadListener(IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener paramHuayangPluginLoadStatusListener)
  {
    this.mDownloadListener = paramHuayangPluginLoadStatusListener;
  }
  
  public void setRunning(boolean paramBoolean)
  {
    this.mRunning = paramBoolean;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */