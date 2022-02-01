package com.tencent.qqperf.monitor.crash;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.StoryDebugUtils.StoryExceptionCallback;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.PatchDownloadManager;
import com.tencent.imcore.message.core.LockManager;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.message.MsgHelper;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.ConversationInfoErrorReporter;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qmethodmonitor.monitor.InvokeMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtQZonePluginException;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.qqperf.monitor.crash.tools.SQLiteInfoHelper;
import com.tencent.qqperf.monitor.file.ExternalDirFileOperationMonitor;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.SingleLineTextView;
import cooperation.plugin.PluginCrashException;
import cooperation.qzone.LocalMultiProcConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class QQCrashHandleListener
  implements CrashHandleListener, ICrashReportCallback
{
  static SimpleDateFormat a = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  
  public QQCrashHandleListener()
  {
    b();
  }
  
  private void a(Context paramContext, String paramString)
  {
    QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash");
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null))
    {
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if (paramString.equals(localRunningServiceInfo.process))
          {
            Intent localIntent = new Intent();
            localIntent.setComponent(localRunningServiceInfo.service);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Stop service: ");
            localStringBuilder.append(localRunningServiceInfo.service);
            localStringBuilder.append(", clientCount: ");
            localStringBuilder.append(localRunningServiceInfo.clientCount);
            localStringBuilder.append(", clientPackage: ");
            localStringBuilder.append(localRunningServiceInfo.clientPackage);
            localStringBuilder.append(", crashCount: ");
            localStringBuilder.append(localRunningServiceInfo.crashCount);
            QLog.d("QQCrashReportManager", 1, localStringBuilder.toString());
            paramContext.stopService(localIntent);
          }
        }
        return;
      }
      QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash,list == null");
      return;
    }
    QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash,context == null");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    try
    {
      if ((1 == BaseApplicationImpl.sProcessId) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.contains("ANR_EXCEPTION")))
      {
        LockManager.a().a(paramStringBuilder);
        SQLiteInfoHelper.a(paramStringBuilder);
      }
      return;
    }
    catch (Throwable paramStringBuilder) {}
  }
  
  private void b()
  {
    CaughtExceptionReport.a(CaughtQZonePluginException.class);
    CaughtExceptionReport.a(PluginCrashException.class);
    CaughtExceptionReport.a(BackgroundException.class);
    CaughtExceptionReport.a(QConfigureException.class);
    CaughtExceptionReport.a(QQHippyException.class);
    CaughtExceptionReport.a(BaseActivity.class.getName());
    CaughtExceptionReport.a(FDStats.class.getName());
    CaughtExceptionReport.a(SwiftWebAccelerator.TbsAccelerator.class.getName());
    CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.class.getName());
    CaughtExceptionReport.a(ShortVideoExceptionReporter.class.getName());
    CaughtExceptionReport.a(PatchDownloadManager.class.getName());
    CaughtExceptionReport.a(SingleLineTextView.class.getName());
    CaughtExceptionReport.a(BaseBubbleBuilder.class.getName());
    CaughtExceptionReport.a(ChatItemAnimLayout.class.getName());
    CaughtExceptionReport.a(SecurityUtile.class.getName());
    CaughtExceptionReport.a(MsgHelper.class.getName());
    CaughtExceptionReport.a(ConversationInfo.class.getName());
    CaughtExceptionReport.a(QQNearbyManager.s());
    CaughtExceptionReport.a(QQNearbyManager.t());
    CaughtExceptionReport.a(ReportLog.class.getName());
    CaughtExceptionReport.a(FightReporter.class.getName());
    CaughtExceptionReport.a(ThreadManagerInitialler.class.getName());
    CaughtExceptionReport.a(RichMediaBugReport.class.getName());
    CaughtExceptionReport.a(MD5Utils.class.getName());
    CaughtExceptionReport.a(RecentUserProxy.class.getName());
    CaughtExceptionReport.a(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getBGLocateMonitorClassName());
    CaughtExceptionReport.a(MutualMarkBusinessLogicHelper.class.getName());
    CaughtExceptionReport.a(ConversationInfoErrorReporter.class.getName());
    CaughtExceptionReport.a(MsgProxyUtilsCallback.class.getName());
    CaughtExceptionReport.a(ExternalDirFileOperationMonitor.class.getName());
    CaughtExceptionReport.a(InvokeMonitor.class.getName());
    CaughtExceptionReport.a(FitSystemWindowsRelativeLayout.class.getName());
    CaughtExceptionReport.a(ConversationContainer.class.getName());
    CaughtExceptionReport.a(NativeMemoryMonitor.class.getName());
    CaughtExceptionReport.a(NativeMonitorConfigHelper.class.getName());
  }
  
  public CrashHandleListener a()
  {
    return this;
  }
  
  public void a(String paramString, QQCrashReportManager paramQQCrashReportManager)
  {
    paramString = MobileQQ.getContext();
    CrashReport.putUserData(paramString, "PatchInstallStatus", String.valueOf(DexPatchInstaller.a));
    if (!TextUtils.isEmpty(DexPatchInstaller.b)) {
      CrashReport.putUserData(paramString, "PatchNameInstalled", DexPatchInstaller.b);
    }
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 272	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 13
    //   5: new 104	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 300
    //   12: invokespecial 301	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: astore 10
    //   17: aload 10
    //   19: iload_1
    //   20: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: ldc_w 306
    //   29: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 10
    //   35: aload_2
    //   36: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 10
    //   42: ldc_w 308
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: aload_3
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 10
    //   58: ldc_w 310
    //   61: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 10
    //   67: aload 4
    //   69: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 10
    //   75: ldc_w 312
    //   78: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: iload 5
    //   86: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 10
    //   92: ldc_w 314
    //   95: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 10
    //   101: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   104: new 316	java/util/Date
    //   107: dup
    //   108: lload 6
    //   110: invokespecial 319	java/util/Date:<init>	(J)V
    //   113: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   116: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 31
    //   122: iconst_1
    //   123: aload 10
    //   125: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_2
    //   132: putstatic 328	com/tencent/qqperf/monitor/crash/QQCrashReportManager:j	Ljava/lang/String;
    //   135: aload 4
    //   137: putstatic 331	com/tencent/qqperf/monitor/crash/QQCrashReportManager:k	Ljava/lang/String;
    //   140: iconst_1
    //   141: getstatic 153	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   144: if_icmpne +50 -> 194
    //   147: invokestatic 337	java/lang/System:currentTimeMillis	()J
    //   150: getstatic 341	com/tencent/qqperf/monitor/crash/QQCrashReportManager:h	J
    //   153: lsub
    //   154: ldc2_w 342
    //   157: lcmp
    //   158: ifgt +36 -> 194
    //   161: new 104	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   168: astore 10
    //   170: aload 10
    //   172: aload_2
    //   173: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 10
    //   179: aload_3
    //   180: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 13
    //   186: aload 10
    //   188: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 347	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   194: iconst_1
    //   195: getstatic 153	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   198: if_icmpne +47 -> 245
    //   201: aload 4
    //   203: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifne +39 -> 245
    //   209: iload_1
    //   210: ifeq +14 -> 224
    //   213: aload 4
    //   215: ldc_w 349
    //   218: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   221: ifne +18 -> 239
    //   224: iload_1
    //   225: ifne +20 -> 245
    //   228: aload 4
    //   230: ldc_w 351
    //   233: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifeq +9 -> 245
    //   239: invokestatic 356	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:a	()Lcom/tencent/qqperf/opt/suspendthread/SuspendThreadManager;
    //   242: invokevirtual 359	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:c	()V
    //   245: getstatic 363	com/tencent/qqperf/monitor/crash/QQCrashReportManager:e	Lcom/tencent/qqperf/monitor/crash/QQCrashCallback;
    //   248: ifnull +43 -> 291
    //   251: iload_1
    //   252: ifne +39 -> 291
    //   255: ldc_w 365
    //   258: aload_2
    //   259: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +29 -> 291
    //   265: aload_3
    //   266: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifne +22 -> 291
    //   272: aload_3
    //   273: ldc_w 367
    //   276: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   279: ifeq +12 -> 291
    //   282: getstatic 363	com/tencent/qqperf/monitor/crash/QQCrashReportManager:e	Lcom/tencent/qqperf/monitor/crash/QQCrashCallback;
    //   285: aload_2
    //   286: invokeinterface 370 2 0
    //   291: getstatic 373	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   294: ldc_w 375
    //   297: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   300: ifeq +51 -> 351
    //   303: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: astore 10
    //   308: new 104	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   315: astore 11
    //   317: aload 11
    //   319: ldc_w 385
    //   322: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 11
    //   328: aload_2
    //   329: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 11
    //   335: aload 4
    //   337: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 10
    //   343: aload 11
    //   345: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 388	com/tencent/mobileqq/qwallet/utils/QWalletCrashUtils:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   351: aload 4
    //   353: ifnull +126 -> 479
    //   356: aload 4
    //   358: ldc_w 390
    //   361: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   364: ifne +25 -> 389
    //   367: aload 4
    //   369: ldc_w 392
    //   372: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   375: ifne +14 -> 389
    //   378: aload 4
    //   380: ldc_w 394
    //   383: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +93 -> 479
    //   389: iconst_0
    //   390: iconst_0
    //   391: invokestatic 399	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   394: new 401	java/util/HashMap
    //   397: dup
    //   398: invokespecial 402	java/util/HashMap:<init>	()V
    //   401: astore 11
    //   403: iload_1
    //   404: ifeq +11 -> 415
    //   407: ldc_w 404
    //   410: astore 10
    //   412: goto +8 -> 420
    //   415: ldc_w 406
    //   418: astore 10
    //   420: aload 11
    //   422: ldc_w 408
    //   425: aload 10
    //   427: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: aload 11
    //   433: ldc_w 414
    //   436: aload_2
    //   437: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   440: pop
    //   441: aload 11
    //   443: ldc_w 416
    //   446: getstatic 373	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   449: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: aload 13
    //   455: invokestatic 422	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   458: getstatic 424	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	Ljava/lang/String;
    //   461: ldc_w 426
    //   464: iconst_1
    //   465: lconst_0
    //   466: lconst_0
    //   467: aload 11
    //   469: ldc_w 428
    //   472: iconst_0
    //   473: invokevirtual 432	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   476: goto +3 -> 479
    //   479: ldc_w 434
    //   482: invokestatic 243	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   485: checkcast 434	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   488: astore 10
    //   490: aload 10
    //   492: ifnull +14 -> 506
    //   495: aload 10
    //   497: iload_1
    //   498: aload_2
    //   499: aload 4
    //   501: invokeinterface 438 4 0
    //   506: aload 4
    //   508: ifnull +107 -> 615
    //   511: aload 4
    //   513: ldc_w 440
    //   516: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   519: ifne +14 -> 533
    //   522: aload 4
    //   524: ldc_w 442
    //   527: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   530: ifeq +85 -> 615
    //   533: new 401	java/util/HashMap
    //   536: dup
    //   537: invokespecial 402	java/util/HashMap:<init>	()V
    //   540: astore 11
    //   542: iload_1
    //   543: ifeq +11 -> 554
    //   546: ldc_w 404
    //   549: astore 10
    //   551: goto +8 -> 559
    //   554: ldc_w 406
    //   557: astore 10
    //   559: aload 11
    //   561: ldc_w 408
    //   564: aload 10
    //   566: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: pop
    //   570: aload 11
    //   572: ldc_w 414
    //   575: aload_2
    //   576: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: aload 11
    //   582: ldc_w 416
    //   585: getstatic 373	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   588: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   591: pop
    //   592: aload 13
    //   594: invokestatic 422	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   597: getstatic 424	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	Ljava/lang/String;
    //   600: ldc_w 444
    //   603: iconst_1
    //   604: lconst_0
    //   605: lconst_0
    //   606: aload 11
    //   608: ldc_w 428
    //   611: iconst_0
    //   612: invokevirtual 432	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   615: getstatic 448	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   618: ldc_w 450
    //   621: invokevirtual 454	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   624: ifeq +55 -> 679
    //   627: new 93	android/content/Intent
    //   630: dup
    //   631: invokespecial 94	android/content/Intent:<init>	()V
    //   634: astore 10
    //   636: aload 10
    //   638: ldc_w 456
    //   641: invokevirtual 460	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   644: pop
    //   645: aload 10
    //   647: invokestatic 463	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   650: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   653: invokevirtual 469	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   656: pop
    //   657: aload 13
    //   659: aload 10
    //   661: invokevirtual 473	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   664: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq +12 -> 679
    //   670: ldc 31
    //   672: iconst_2
    //   673: ldc_w 478
    //   676: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: ldc_w 480
    //   682: invokestatic 243	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   685: checkcast 480	com/tencent/mobileqq/soload/api/ISoLoaderCrashService
    //   688: astore 10
    //   690: aload 10
    //   692: ifnull +13 -> 705
    //   695: aload 10
    //   697: aload_2
    //   698: aload 4
    //   700: invokeinterface 484 3 0
    //   705: getstatic 373	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   708: ldc_w 486
    //   711: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   714: ifeq +44 -> 758
    //   717: new 104	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   724: astore 10
    //   726: aload 10
    //   728: ldc_w 385
    //   731: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 10
    //   737: aload_2
    //   738: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 10
    //   744: aload 4
    //   746: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 10
    //   752: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 490	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   758: aload 4
    //   760: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   763: istore 9
    //   765: aconst_null
    //   766: astore 11
    //   768: iload 9
    //   770: ifne +149 -> 919
    //   773: aload 4
    //   775: ldc_w 492
    //   778: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   781: ifeq +138 -> 919
    //   784: new 494	org/json/JSONObject
    //   787: dup
    //   788: invokespecial 495	org/json/JSONObject:<init>	()V
    //   791: astore 10
    //   793: aload 10
    //   795: ldc_w 497
    //   798: iload_1
    //   799: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   802: pop
    //   803: aload 10
    //   805: ldc_w 502
    //   808: aload_2
    //   809: invokevirtual 505	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   812: pop
    //   813: aload 10
    //   815: ldc_w 507
    //   818: aload_3
    //   819: invokevirtual 505	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   822: pop
    //   823: aload 10
    //   825: ldc_w 509
    //   828: aload 4
    //   830: invokevirtual 505	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   833: pop
    //   834: aload 10
    //   836: ldc_w 511
    //   839: iload 5
    //   841: invokevirtual 514	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   844: pop
    //   845: aload 10
    //   847: ldc_w 516
    //   850: lload 6
    //   852: invokevirtual 519	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   855: pop
    //   856: getstatic 523	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   859: invokevirtual 527	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   862: astore 12
    //   864: aload 12
    //   866: ifnull +53 -> 919
    //   869: aload 12
    //   871: ldc_w 529
    //   874: invokevirtual 535	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   877: ldc_w 536
    //   880: iconst_1
    //   881: anewarray 188	java/lang/Class
    //   884: dup
    //   885: iconst_0
    //   886: ldc 87
    //   888: aastore
    //   889: invokevirtual 540	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   892: aconst_null
    //   893: iconst_1
    //   894: anewarray 4	java/lang/Object
    //   897: dup
    //   898: iconst_0
    //   899: aload 10
    //   901: invokevirtual 541	org/json/JSONObject:toString	()Ljava/lang/String;
    //   904: aastore
    //   905: invokevirtual 547	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   908: pop
    //   909: goto +10 -> 919
    //   912: astore 10
    //   914: aload 10
    //   916: invokevirtual 550	java/lang/Throwable:printStackTrace	()V
    //   919: new 104	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   926: astore 10
    //   928: aload 10
    //   930: getstatic 552	com/tencent/qqperf/monitor/crash/QQCrashReportManager:d	Ljava/lang/String;
    //   933: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 10
    //   939: ldc_w 554
    //   942: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload 10
    //   948: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: astore 10
    //   953: new 556	java/io/File
    //   956: dup
    //   957: aload 10
    //   959: invokespecial 557	java/io/File:<init>	(Ljava/lang/String;)V
    //   962: astore 12
    //   964: aload 12
    //   966: invokevirtual 560	java/io/File:exists	()Z
    //   969: ifne +9 -> 978
    //   972: aload 12
    //   974: invokevirtual 563	java/io/File:mkdirs	()Z
    //   977: pop
    //   978: new 104	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   985: astore 12
    //   987: aload 12
    //   989: aload 10
    //   991: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 12
    //   997: lload 6
    //   999: invokevirtual 566	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 12
    //   1005: ldc_w 568
    //   1008: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: new 570	java/io/FileWriter
    //   1015: dup
    //   1016: aload 12
    //   1018: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokespecial 571	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   1024: astore 10
    //   1026: aload 10
    //   1028: astore 11
    //   1030: new 104	java/lang/StringBuilder
    //   1033: dup
    //   1034: sipush 128
    //   1037: invokespecial 574	java/lang/StringBuilder:<init>	(I)V
    //   1040: astore 12
    //   1042: aload 10
    //   1044: astore 11
    //   1046: aload 12
    //   1048: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   1051: new 316	java/util/Date
    //   1054: dup
    //   1055: lload 6
    //   1057: invokespecial 319	java/util/Date:<init>	(J)V
    //   1060: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1063: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 10
    //   1069: astore 11
    //   1071: aload 12
    //   1073: ldc_w 576
    //   1076: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload 10
    //   1082: astore 11
    //   1084: aload 12
    //   1086: aload_2
    //   1087: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload 10
    //   1093: astore 11
    //   1095: aload 12
    //   1097: ldc_w 576
    //   1100: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload 10
    //   1106: astore 11
    //   1108: aload 12
    //   1110: aload 4
    //   1112: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: aload 10
    //   1118: astore 11
    //   1120: aload 10
    //   1122: aload 12
    //   1124: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokevirtual 579	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   1130: aload 10
    //   1132: astore 11
    //   1134: aload 10
    //   1136: invokevirtual 582	java/io/FileWriter:flush	()V
    //   1139: aload 10
    //   1141: invokevirtual 585	java/io/FileWriter:close	()V
    //   1144: goto +40 -> 1184
    //   1147: goto +37 -> 1184
    //   1150: astore 12
    //   1152: goto +15 -> 1167
    //   1155: astore_2
    //   1156: aload 11
    //   1158: astore_3
    //   1159: goto +2624 -> 3783
    //   1162: astore 12
    //   1164: aconst_null
    //   1165: astore 10
    //   1167: aload 10
    //   1169: astore 11
    //   1171: aload 12
    //   1173: invokevirtual 586	java/lang/Exception:printStackTrace	()V
    //   1176: aload 10
    //   1178: ifnull +6 -> 1184
    //   1181: goto -42 -> 1139
    //   1184: aload_2
    //   1185: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1188: ifne +47 -> 1235
    //   1191: aload_2
    //   1192: ldc_w 588
    //   1195: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1198: ifeq +37 -> 1235
    //   1201: invokestatic 593	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1204: invokevirtual 594	com/tencent/qqperf/monitor/memory/MemoryManager:b	()V
    //   1207: aload 4
    //   1209: ldc_w 596
    //   1212: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1215: ifne +20 -> 1235
    //   1218: aload 4
    //   1220: ldc_w 598
    //   1223: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1226: ifne +9 -> 1235
    //   1229: invokestatic 603	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:b	()Lcom/tencent/qqperf/opt/clearmemory/MemoryClearManager;
    //   1232: invokevirtual 605	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:d	()V
    //   1235: getstatic 373	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   1238: astore 14
    //   1240: iload_1
    //   1241: ifeq +39 -> 1280
    //   1244: aload 14
    //   1246: ldc_w 607
    //   1249: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1252: ifne +14 -> 1266
    //   1255: aload 14
    //   1257: ldc_w 609
    //   1260: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1263: ifeq +17 -> 1280
    //   1266: ldc_w 611
    //   1269: iconst_1
    //   1270: aload 4
    //   1272: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: aload 4
    //   1277: invokestatic 618	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1280: aload 13
    //   1282: invokestatic 624	com/tencent/common/app/QFixApplicationImpl:updateNCrashCount	(Landroid/content/Context;)V
    //   1285: new 104	java/lang/StringBuilder
    //   1288: dup
    //   1289: sipush 128
    //   1292: invokespecial 574	java/lang/StringBuilder:<init>	(I)V
    //   1295: astore 12
    //   1297: aload 13
    //   1299: ldc_w 626
    //   1302: invokestatic 631	com/tencent/hotpatch/config/PatchConfigManager:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/hotpatch/config/PatchConfig;
    //   1305: astore 10
    //   1307: aload 12
    //   1309: ldc_w 633
    //   1312: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload 12
    //   1318: ldc_w 635
    //   1321: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload 12
    //   1327: ldc_w 637
    //   1330: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 12
    //   1336: getstatic 640	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1339: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload 12
    //   1345: ldc_w 642
    //   1348: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 12
    //   1354: getstatic 645	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1357: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload 12
    //   1363: ldc_w 647
    //   1366: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: pop
    //   1370: aload 12
    //   1372: getstatic 650	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1375: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 12
    //   1381: ldc_w 652
    //   1384: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: aload 12
    //   1390: getstatic 655	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1393: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 12
    //   1399: ldc_w 657
    //   1402: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 12
    //   1408: getstatic 661	com/tencent/mobileqq/startup/director/StartupDirector:h	I
    //   1411: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 12
    //   1417: ldc_w 663
    //   1420: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: pop
    //   1424: aload 10
    //   1426: ifnull +2417 -> 3843
    //   1429: aload 10
    //   1431: invokevirtual 667	com/tencent/hotpatch/config/PatchConfig:a	()Z
    //   1434: ifeq +2409 -> 3843
    //   1437: iconst_1
    //   1438: istore 9
    //   1440: goto +3 -> 1443
    //   1443: aload 12
    //   1445: iload 9
    //   1447: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload 12
    //   1453: ldc_w 669
    //   1456: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 12
    //   1462: getstatic 278	com/tencent/hotpatch/DexPatchInstaller:a	I
    //   1465: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload 12
    //   1471: ldc_w 671
    //   1474: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: pop
    //   1478: aload 12
    //   1480: getstatic 290	com/tencent/hotpatch/DexPatchInstaller:b	Ljava/lang/String;
    //   1483: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: pop
    //   1487: aload 12
    //   1489: ldc_w 673
    //   1492: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: pop
    //   1496: aload 12
    //   1498: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1501: invokevirtual 682	java/lang/Runtime:maxMemory	()J
    //   1504: invokevirtual 566	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: aload 12
    //   1510: ldc_w 684
    //   1513: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 12
    //   1519: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1522: invokevirtual 687	java/lang/Runtime:totalMemory	()J
    //   1525: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1528: invokevirtual 690	java/lang/Runtime:freeMemory	()J
    //   1531: lsub
    //   1532: invokevirtual 566	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 12
    //   1538: ldc_w 692
    //   1541: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: aload 12
    //   1547: invokestatic 593	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1550: invokevirtual 695	com/tencent/qqperf/monitor/memory/MemoryManager:f	()I
    //   1553: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload 12
    //   1559: ldc_w 697
    //   1562: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1565: pop
    //   1566: aload 12
    //   1568: invokestatic 593	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1571: invokevirtual 700	com/tencent/qqperf/monitor/memory/MemoryManager:g	()I
    //   1574: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload 12
    //   1580: ldc_w 702
    //   1583: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: pop
    //   1587: aload 12
    //   1589: invokestatic 593	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1592: invokevirtual 704	com/tencent/qqperf/monitor/memory/MemoryManager:h	()I
    //   1595: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1598: pop
    //   1599: aload 12
    //   1601: ldc_w 706
    //   1604: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: pop
    //   1608: aload 12
    //   1610: invokestatic 711	com/tencent/qqperf/tools/SceneTracker:a	()Lcom/tencent/qqperf/tools/SceneTracker;
    //   1613: invokevirtual 713	com/tencent/qqperf/tools/SceneTracker:b	()Ljava/lang/String;
    //   1616: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: pop
    //   1620: getstatic 718	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1623: ifnull +24 -> 1647
    //   1626: aload 12
    //   1628: ldc_w 720
    //   1631: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: pop
    //   1635: aload 12
    //   1637: getstatic 718	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1640: invokevirtual 723	android/support/v4/util/MQLruCache:size	()I
    //   1643: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1646: pop
    //   1647: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1650: invokevirtual 682	java/lang/Runtime:maxMemory	()J
    //   1653: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1656: invokevirtual 687	java/lang/Runtime:totalMemory	()J
    //   1659: lsub
    //   1660: l2f
    //   1661: fconst_1
    //   1662: fmul
    //   1663: invokestatic 679	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1666: invokevirtual 682	java/lang/Runtime:maxMemory	()J
    //   1669: l2f
    //   1670: fdiv
    //   1671: f2d
    //   1672: ldc2_w 724
    //   1675: dcmpl
    //   1676: iflt +25 -> 1701
    //   1679: aload_2
    //   1680: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1683: ifne +18 -> 1701
    //   1686: aload_2
    //   1687: ldc_w 588
    //   1690: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1693: ifeq +8 -> 1701
    //   1696: aload 12
    //   1698: invokestatic 728	com/tencent/qqperf/monitor/crash/tools/ThreadInfoRecordHelper:a	(Ljava/lang/StringBuilder;)V
    //   1701: aload 12
    //   1703: ldc_w 730
    //   1706: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: pop
    //   1710: aload 12
    //   1712: getstatic 735	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1715: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: pop
    //   1719: getstatic 740	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1722: astore 10
    //   1724: aload 10
    //   1726: ifnull +56 -> 1782
    //   1729: aload 10
    //   1731: arraylength
    //   1732: iconst_3
    //   1733: if_icmplt +49 -> 1782
    //   1736: aload 12
    //   1738: ldc_w 742
    //   1741: iconst_3
    //   1742: anewarray 4	java/lang/Object
    //   1745: dup
    //   1746: iconst_0
    //   1747: aload 10
    //   1749: iconst_0
    //   1750: iaload
    //   1751: invokestatic 747	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1754: aastore
    //   1755: dup
    //   1756: iconst_1
    //   1757: aload 10
    //   1759: iconst_1
    //   1760: iaload
    //   1761: invokestatic 747	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1764: aastore
    //   1765: dup
    //   1766: iconst_2
    //   1767: aload 10
    //   1769: iconst_2
    //   1770: iaload
    //   1771: invokestatic 747	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1774: aastore
    //   1775: invokestatic 750	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1778: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: pop
    //   1782: aload 12
    //   1784: ldc_w 576
    //   1787: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: invokestatic 755	com/tencent/qqperf/MagnifierSDK:b	()Lcom/tencent/qqperf/MagnifierSDK;
    //   1794: invokevirtual 758	com/tencent/qqperf/MagnifierSDK:d	()Lcom/tencent/qqperf/monitor/base/IAPMModuleCelling;
    //   1797: invokeinterface 762 1 0
    //   1802: astore 11
    //   1804: invokestatic 768	com/tencent/mobileqq/utils/DeviceInfoUtil:p	()[J
    //   1807: astore 15
    //   1809: aload 12
    //   1811: invokestatic 771	com/tencent/mobileqq/utils/DeviceInfoUtil:x	()Ljava/lang/String;
    //   1814: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: pop
    //   1818: aload 12
    //   1820: ldc_w 576
    //   1823: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: pop
    //   1827: aload 11
    //   1829: astore 10
    //   1831: aload 11
    //   1833: ifnonnull +8 -> 1841
    //   1836: ldc_w 773
    //   1839: astore 10
    //   1841: aload 12
    //   1843: aload 10
    //   1845: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload 12
    //   1851: ldc_w 576
    //   1854: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 12
    //   1860: ldc_w 775
    //   1863: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 12
    //   1869: aload 15
    //   1871: iconst_0
    //   1872: laload
    //   1873: invokevirtual 566	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1876: pop
    //   1877: aload 12
    //   1879: ldc_w 777
    //   1882: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: pop
    //   1886: aload 12
    //   1888: aload 15
    //   1890: iconst_1
    //   1891: laload
    //   1892: invokevirtual 566	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1895: pop
    //   1896: aload 12
    //   1898: ldc_w 779
    //   1901: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: pop
    //   1905: invokestatic 782	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   1908: pop
    //   1909: getstatic 785	com/tencent/qqperf/monitor/crash/QQCrashReportManager:l	Ljava/lang/String;
    //   1912: ifnonnull +11 -> 1923
    //   1915: ldc_w 773
    //   1918: astore 10
    //   1920: goto +12 -> 1932
    //   1923: invokestatic 782	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   1926: pop
    //   1927: getstatic 785	com/tencent/qqperf/monitor/crash/QQCrashReportManager:l	Ljava/lang/String;
    //   1930: astore 10
    //   1932: aload 12
    //   1934: aload 10
    //   1936: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: pop
    //   1940: aload 12
    //   1942: ldc_w 576
    //   1945: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: pop
    //   1949: new 104	java/lang/StringBuilder
    //   1952: dup
    //   1953: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1956: astore 10
    //   1958: aload 10
    //   1960: ldc_w 787
    //   1963: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: pop
    //   1967: aload 10
    //   1969: invokestatic 792	mqq/app/Foreground:getResumeActivityCount	()I
    //   1972: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: aload 10
    //   1978: ldc_w 576
    //   1981: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 12
    //   1987: aload 10
    //   1989: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: pop
    //   1996: aload 12
    //   1998: ldc_w 794
    //   2001: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: pop
    //   2005: aload 12
    //   2007: getstatic 799	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   2010: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2013: pop
    //   2014: aload 12
    //   2016: ldc_w 576
    //   2019: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: getstatic 803	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2026: astore 10
    //   2028: aload 10
    //   2030: instanceof 796
    //   2033: ifeq +39 -> 2072
    //   2036: aload 10
    //   2038: checkcast 796	com/tencent/mobileqq/activity/SplashActivity
    //   2041: astore 10
    //   2043: aload 12
    //   2045: ldc_w 805
    //   2048: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: pop
    //   2052: aload 12
    //   2054: aload 10
    //   2056: invokevirtual 808	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   2059: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2062: pop
    //   2063: aload 12
    //   2065: ldc_w 576
    //   2068: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: pop
    //   2072: getstatic 811	com/tencent/mobileqq/activity/CrashReportConstant:a	Ljava/lang/String;
    //   2075: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2078: ifne +30 -> 2108
    //   2081: aload 12
    //   2083: ldc_w 813
    //   2086: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: pop
    //   2090: aload 12
    //   2092: getstatic 811	com/tencent/mobileqq/activity/CrashReportConstant:a	Ljava/lang/String;
    //   2095: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: pop
    //   2099: aload 12
    //   2101: ldc_w 576
    //   2104: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: pop
    //   2108: getstatic 816	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   2111: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2114: ifne +30 -> 2144
    //   2117: aload 12
    //   2119: ldc_w 818
    //   2122: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: pop
    //   2126: aload 12
    //   2128: getstatic 816	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   2131: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: pop
    //   2135: aload 12
    //   2137: ldc_w 576
    //   2140: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: getstatic 821	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2147: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2150: ifne +30 -> 2180
    //   2153: aload 12
    //   2155: ldc_w 823
    //   2158: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: pop
    //   2162: aload 12
    //   2164: getstatic 821	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2167: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: pop
    //   2171: aload 12
    //   2173: ldc_w 576
    //   2176: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: pop
    //   2180: new 104	java/lang/StringBuilder
    //   2183: dup
    //   2184: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2187: astore 10
    //   2189: aload 10
    //   2191: ldc_w 825
    //   2194: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: pop
    //   2198: aload 10
    //   2200: invokestatic 830	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2203: ldc_w 832
    //   2206: ldc_w 834
    //   2209: iconst_1
    //   2210: invokevirtual 838	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   2213: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2216: pop
    //   2217: aload 12
    //   2219: aload 10
    //   2221: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2224: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: pop
    //   2228: new 104	java/lang/StringBuilder
    //   2231: dup
    //   2232: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2235: astore 10
    //   2237: aload 10
    //   2239: ldc_w 840
    //   2242: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: pop
    //   2246: aload 10
    //   2248: invokestatic 830	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2251: ldc_w 832
    //   2254: ldc_w 842
    //   2257: iconst_0
    //   2258: invokevirtual 845	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2261: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2264: pop
    //   2265: aload 12
    //   2267: aload 10
    //   2269: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2272: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: pop
    //   2276: new 104	java/lang/StringBuilder
    //   2279: dup
    //   2280: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2283: astore 10
    //   2285: aload 10
    //   2287: ldc_w 847
    //   2290: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: pop
    //   2294: aload 10
    //   2296: invokestatic 830	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2299: ldc_w 832
    //   2302: ldc_w 849
    //   2305: iconst_0
    //   2306: invokevirtual 845	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2309: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2312: pop
    //   2313: aload 12
    //   2315: aload 10
    //   2317: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2320: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: pop
    //   2324: aload 12
    //   2326: ldc_w 576
    //   2329: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2332: pop
    //   2333: invokestatic 850	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2336: invokestatic 853	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   2339: invokevirtual 856	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   2342: astore 10
    //   2344: aload 10
    //   2346: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2349: ifne +11 -> 2360
    //   2352: aload 12
    //   2354: aload 10
    //   2356: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: pop
    //   2360: invokestatic 782	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   2363: pop
    //   2364: aload 12
    //   2366: getstatic 860	com/tencent/qqperf/monitor/crash/QQCrashReportManager:m	Ljava/lang/StringBuilder;
    //   2369: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2372: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: pop
    //   2376: invokestatic 782	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   2379: pop
    //   2380: aload 12
    //   2382: getstatic 863	com/tencent/qqperf/monitor/crash/QQCrashReportManager:n	Ljava/lang/StringBuilder;
    //   2385: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2388: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2391: pop
    //   2392: getstatic 866	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2395: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2398: ifne +65 -> 2463
    //   2401: getstatic 871	android/os/Build$VERSION:SDK_INT	I
    //   2404: bipush 8
    //   2406: if_icmplt +57 -> 2463
    //   2409: new 104	java/lang/StringBuilder
    //   2412: dup
    //   2413: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2416: astore 10
    //   2418: aload 10
    //   2420: ldc_w 873
    //   2423: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: pop
    //   2427: aload 10
    //   2429: getstatic 866	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2432: invokevirtual 877	java/lang/String:getBytes	()[B
    //   2435: iconst_0
    //   2436: invokestatic 883	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2439: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: pop
    //   2443: aload 10
    //   2445: ldc_w 576
    //   2448: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: pop
    //   2452: aload 12
    //   2454: aload 10
    //   2456: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2459: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: pop
    //   2463: aload 12
    //   2465: invokestatic 888	cooperation/qzone/RDMEtraMsgCollector:getInstance	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   2468: invokevirtual 891	cooperation/qzone/RDMEtraMsgCollector:getEtraMsg	()Ljava/lang/String;
    //   2471: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: pop
    //   2475: aload 12
    //   2477: ldc_w 576
    //   2480: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: pop
    //   2484: aload 12
    //   2486: invokestatic 895	com/tencent/qqperf/monitor/crash/tools/WebViewInfoRecordHelper:a	()Ljava/lang/String;
    //   2489: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: pop
    //   2493: aload 13
    //   2495: invokestatic 901	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2498: istore 5
    //   2500: aload 13
    //   2502: invokestatic 906	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2505: istore 8
    //   2507: aload 12
    //   2509: bipush 10
    //   2511: invokevirtual 909	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2514: pop
    //   2515: aload 12
    //   2517: ldc_w 911
    //   2520: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: pop
    //   2524: iload 8
    //   2526: ifne +1323 -> 3849
    //   2529: ldc_w 913
    //   2532: astore 10
    //   2534: goto +3 -> 2537
    //   2537: aload 12
    //   2539: aload 10
    //   2541: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: pop
    //   2545: aload 12
    //   2547: ldc_w 915
    //   2550: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2553: pop
    //   2554: aload 12
    //   2556: iload 5
    //   2558: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2561: pop
    //   2562: aload 12
    //   2564: ldc_w 917
    //   2567: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: pop
    //   2571: aload 12
    //   2573: iload 8
    //   2575: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2578: pop
    //   2579: aload 12
    //   2581: ldc_w 919
    //   2584: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: pop
    //   2588: aload 12
    //   2590: aload 13
    //   2592: invokestatic 922	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2595: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2598: pop
    //   2599: aload 12
    //   2601: ldc_w 924
    //   2604: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2607: pop
    //   2608: aload 12
    //   2610: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   2613: new 316	java/util/Date
    //   2616: dup
    //   2617: getstatic 926	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:a	J
    //   2620: invokespecial 319	java/util/Date:<init>	(J)V
    //   2623: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2626: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: pop
    //   2630: aload 12
    //   2632: ldc_w 928
    //   2635: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: aload 12
    //   2641: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   2644: new 316	java/util/Date
    //   2647: dup
    //   2648: getstatic 930	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:b	J
    //   2651: invokespecial 319	java/util/Date:<init>	(J)V
    //   2654: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2657: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: pop
    //   2661: aload 12
    //   2663: ldc_w 576
    //   2666: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: pop
    //   2670: iload_1
    //   2671: ifeq +115 -> 2786
    //   2674: aload 14
    //   2676: ldc_w 607
    //   2679: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2682: ifne +25 -> 2707
    //   2685: aload 14
    //   2687: ldc_w 609
    //   2690: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2693: ifne +14 -> 2707
    //   2696: aload 14
    //   2698: ldc_w 375
    //   2701: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2704: ifeq +82 -> 2786
    //   2707: aload 13
    //   2709: ldc 31
    //   2711: iconst_4
    //   2712: invokevirtual 934	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2715: ldc_w 936
    //   2718: aconst_null
    //   2719: invokeinterface 942 3 0
    //   2724: astore 10
    //   2726: aload 12
    //   2728: ldc_w 944
    //   2731: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2734: pop
    //   2735: aload 12
    //   2737: aload 10
    //   2739: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2742: pop
    //   2743: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2746: ifeq +40 -> 2786
    //   2749: new 104	java/lang/StringBuilder
    //   2752: dup
    //   2753: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2756: astore 11
    //   2758: aload 11
    //   2760: ldc_w 946
    //   2763: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: pop
    //   2767: aload 11
    //   2769: aload 10
    //   2771: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2774: pop
    //   2775: ldc 31
    //   2777: iconst_2
    //   2778: aload 11
    //   2780: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2783: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2786: aload 14
    //   2788: ldc_w 948
    //   2791: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2794: ifne +80 -> 2874
    //   2797: aload 14
    //   2799: ldc_w 950
    //   2802: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2805: ifne +69 -> 2874
    //   2808: aload 14
    //   2810: ldc_w 952
    //   2813: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2816: ifne +58 -> 2874
    //   2819: aload 14
    //   2821: ldc_w 954
    //   2824: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2827: ifne +47 -> 2874
    //   2830: aload 14
    //   2832: ldc_w 956
    //   2835: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2838: ifne +36 -> 2874
    //   2841: aload 14
    //   2843: ldc_w 958
    //   2846: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2849: ifne +25 -> 2874
    //   2852: aload 14
    //   2854: ldc_w 960
    //   2857: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2860: ifne +14 -> 2874
    //   2863: aload 14
    //   2865: ldc_w 962
    //   2868: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2871: ifeq +106 -> 2977
    //   2874: ldc_w 964
    //   2877: invokestatic 243	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2880: checkcast 964	com/tencent/mobileqq/mini/api/report/IMiniReport
    //   2883: invokeinterface 967 1 0
    //   2888: astore 10
    //   2890: aload 10
    //   2892: ifnull +85 -> 2977
    //   2895: aload 12
    //   2897: ldc_w 969
    //   2900: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: pop
    //   2904: aload 12
    //   2906: aload 10
    //   2908: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2911: pop
    //   2912: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2915: ifeq +62 -> 2977
    //   2918: new 104	java/lang/StringBuilder
    //   2921: dup
    //   2922: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2925: astore 11
    //   2927: aload 11
    //   2929: ldc_w 971
    //   2932: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: pop
    //   2936: aload 11
    //   2938: aload 10
    //   2940: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: pop
    //   2944: ldc 31
    //   2946: iconst_2
    //   2947: aload 11
    //   2949: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2952: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2955: goto +22 -> 2977
    //   2958: astore 10
    //   2960: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2963: ifeq +14 -> 2977
    //   2966: ldc 31
    //   2968: iconst_2
    //   2969: ldc_w 973
    //   2972: aload 10
    //   2974: invokestatic 976	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2977: aload 12
    //   2979: ldc_w 978
    //   2982: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2985: pop
    //   2986: aload 12
    //   2988: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2991: getfield 981	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2994: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: pop
    //   2998: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3001: getfield 985	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3004: ifnull +122 -> 3126
    //   3007: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3010: getfield 985	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3013: invokeinterface 989 1 0
    //   3018: ifne +108 -> 3126
    //   3021: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3024: getfield 985	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3027: invokeinterface 990 1 0
    //   3032: astore 10
    //   3034: aload 10
    //   3036: invokeinterface 75 1 0
    //   3041: ifeq +85 -> 3126
    //   3044: aload 10
    //   3046: invokeinterface 79 1 0
    //   3051: checkcast 992	android/util/Pair
    //   3054: astore 11
    //   3056: aload 11
    //   3058: ifnull -24 -> 3034
    //   3061: aload 12
    //   3063: ldc_w 994
    //   3066: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: pop
    //   3070: aload 12
    //   3072: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   3075: new 316	java/util/Date
    //   3078: dup
    //   3079: aload 11
    //   3081: getfield 998	android/util/Pair:first	Ljava/lang/Object;
    //   3084: checkcast 1000	java/lang/Long
    //   3087: invokevirtual 1003	java/lang/Long:longValue	()J
    //   3090: invokespecial 319	java/util/Date:<init>	(J)V
    //   3093: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3096: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3099: pop
    //   3100: aload 12
    //   3102: ldc_w 1005
    //   3105: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3108: pop
    //   3109: aload 12
    //   3111: aload 11
    //   3113: getfield 1008	android/util/Pair:second	Ljava/lang/Object;
    //   3116: checkcast 87	java/lang/String
    //   3119: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3122: pop
    //   3123: goto -89 -> 3034
    //   3126: getstatic 1013	com/tencent/qbar/QbarCrashCollector:sCurrentUrl	Ljava/lang/String;
    //   3129: astore 10
    //   3131: aload 10
    //   3133: ifnull +28 -> 3161
    //   3136: aload 10
    //   3138: invokevirtual 1016	java/lang/String:length	()I
    //   3141: ifle +20 -> 3161
    //   3144: aload 12
    //   3146: ldc_w 1018
    //   3149: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3152: pop
    //   3153: aload 12
    //   3155: aload 10
    //   3157: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: pop
    //   3161: aload_2
    //   3162: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3165: ifne +49 -> 3214
    //   3168: aload_2
    //   3169: ldc_w 1020
    //   3172: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3175: ifeq +39 -> 3214
    //   3178: aload 4
    //   3180: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3183: ifne +31 -> 3214
    //   3186: aload 4
    //   3188: ldc_w 1022
    //   3191: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3194: ifeq +20 -> 3214
    //   3197: aload 12
    //   3199: ldc_w 1024
    //   3202: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: pop
    //   3206: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3209: aload 12
    //   3211: invokestatic 1029	com/tencent/qqperf/monitor/crash/tools/ReceiverInfoRecordHelper:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   3214: ldc_w 1031
    //   3217: aload_2
    //   3218: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3221: ifeq +22 -> 3243
    //   3224: aload 4
    //   3226: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3229: ifne +14 -> 3243
    //   3232: aload 4
    //   3234: ldc_w 1033
    //   3237: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3240: ifne +32 -> 3272
    //   3243: ldc_w 1035
    //   3246: aload_2
    //   3247: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3250: ifeq +43 -> 3293
    //   3253: aload 4
    //   3255: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3258: ifne +35 -> 3293
    //   3261: aload 4
    //   3263: ldc_w 1037
    //   3266: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3269: ifeq +24 -> 3293
    //   3272: aload 12
    //   3274: ldc_w 1039
    //   3277: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3280: pop
    //   3281: aload 12
    //   3283: ldc_w 1041
    //   3286: invokestatic 1046	com/tencent/mobileqq/util/SystemUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3289: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: pop
    //   3293: ldc_w 1048
    //   3296: aload_2
    //   3297: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3300: ifne +66 -> 3366
    //   3303: ldc_w 365
    //   3306: aload_2
    //   3307: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3310: ifeq +14 -> 3324
    //   3313: aload 4
    //   3315: ldc_w 1050
    //   3318: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3321: ifne +45 -> 3366
    //   3324: ldc_w 1052
    //   3327: aload_2
    //   3328: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3331: ifeq +14 -> 3345
    //   3334: aload 4
    //   3336: ldc_w 1054
    //   3339: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3342: ifne +24 -> 3366
    //   3345: ldc_w 365
    //   3348: aload_2
    //   3349: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3352: ifeq +103 -> 3455
    //   3355: aload 4
    //   3357: ldc_w 1056
    //   3360: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3363: ifeq +92 -> 3455
    //   3366: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   3369: new 316	java/util/Date
    //   3372: dup
    //   3373: getstatic 1058	com/tencent/qqperf/monitor/crash/QQCrashReportManager:c	J
    //   3376: invokespecial 319	java/util/Date:<init>	(J)V
    //   3379: invokevirtual 323	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3382: astore 10
    //   3384: aload 12
    //   3386: ldc_w 1060
    //   3389: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3392: pop
    //   3393: aload 12
    //   3395: getstatic 1062	com/tencent/qqperf/monitor/crash/QQCrashReportManager:b	I
    //   3398: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3401: pop
    //   3402: aload 12
    //   3404: ldc_w 1064
    //   3407: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3410: pop
    //   3411: aload 12
    //   3413: aload 10
    //   3415: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3418: pop
    //   3419: aload 12
    //   3421: ldc_w 1066
    //   3424: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3427: pop
    //   3428: aload 12
    //   3430: invokestatic 1069	com/tencent/qqperf/monitor/crash/tools/FdinfoRecordHelper:a	()Ljava/lang/String;
    //   3433: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: pop
    //   3437: aload 12
    //   3439: ldc_w 1071
    //   3442: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: pop
    //   3446: aload 12
    //   3448: invokestatic 1076	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3451: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: pop
    //   3455: iconst_1
    //   3456: getstatic 153	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3459: if_icmpne +46 -> 3505
    //   3462: aload_3
    //   3463: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3466: ifne +39 -> 3505
    //   3469: aload_2
    //   3470: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3473: ifne +32 -> 3505
    //   3476: aload_2
    //   3477: ldc 155
    //   3479: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3482: ifeq +23 -> 3505
    //   3485: aload_3
    //   3486: ldc_w 1078
    //   3489: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3492: ifeq +13 -> 3505
    //   3495: aload 12
    //   3497: invokestatic 1082	com/tencent/qqperf/monitor/crash/tools/LooperMessagePrinterHelper:b	(Ljava/lang/StringBuilder;)V
    //   3500: aload 12
    //   3502: invokestatic 1083	com/tencent/qqperf/monitor/crash/tools/LooperMessagePrinterHelper:a	(Ljava/lang/StringBuilder;)V
    //   3505: iload_1
    //   3506: ifeq +39 -> 3545
    //   3509: aload 4
    //   3511: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3514: ifne +31 -> 3545
    //   3517: aload 4
    //   3519: ldc_w 1085
    //   3522: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3525: ifeq +20 -> 3545
    //   3528: aload_2
    //   3529: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3532: ifne +13 -> 3545
    //   3535: aload_2
    //   3536: ldc_w 1087
    //   3539: invokevirtual 1090	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3542: ifne +20 -> 3562
    //   3545: aload_2
    //   3546: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3549: ifne +83 -> 3632
    //   3552: aload_2
    //   3553: ldc_w 588
    //   3556: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3559: ifeq +73 -> 3632
    //   3562: aload 12
    //   3564: ldc_w 1092
    //   3567: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3570: pop
    //   3571: aload 12
    //   3573: ldc_w 1094
    //   3576: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: pop
    //   3580: aload 12
    //   3582: invokestatic 1097	com/tencent/qqperf/monitor/crash/tools/MemoryInfoRecordHelper:a	()Ljava/lang/String;
    //   3585: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: aload 12
    //   3591: ldc_w 1092
    //   3594: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: pop
    //   3598: aload 12
    //   3600: ldc_w 1099
    //   3603: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3606: pop
    //   3607: aload 12
    //   3609: invokestatic 1102	com/tencent/qqperf/monitor/crash/tools/ActivityInfoRecordHelper:a	()Ljava/lang/String;
    //   3612: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: pop
    //   3616: goto +16 -> 3632
    //   3619: astore 4
    //   3621: ldc 31
    //   3623: iconst_1
    //   3624: ldc_w 1104
    //   3627: aload 4
    //   3629: invokestatic 976	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3632: new 104	java/lang/StringBuilder
    //   3635: dup
    //   3636: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3639: astore 4
    //   3641: aload 4
    //   3643: ldc_w 1106
    //   3646: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3649: pop
    //   3650: aload 4
    //   3652: invokestatic 850	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3655: ldc_w 1108
    //   3658: invokestatic 1113	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3661: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3664: pop
    //   3665: aload 12
    //   3667: aload 4
    //   3669: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3672: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3675: pop
    //   3676: new 104	java/lang/StringBuilder
    //   3679: dup
    //   3680: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3683: astore 4
    //   3685: aload 4
    //   3687: ldc_w 1115
    //   3690: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: pop
    //   3694: aload 4
    //   3696: invokestatic 1119	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	()I
    //   3699: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3702: pop
    //   3703: aload 12
    //   3705: aload 4
    //   3707: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3710: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3713: pop
    //   3714: goto +12 -> 3726
    //   3717: aload 12
    //   3719: ldc_w 1121
    //   3722: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: pop
    //   3726: aload_0
    //   3727: aload 12
    //   3729: aload_2
    //   3730: aload_3
    //   3731: invokespecial 1123	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   3734: new 104	java/lang/StringBuilder
    //   3737: dup
    //   3738: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3741: astore_2
    //   3742: aload_2
    //   3743: ldc_w 1125
    //   3746: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3749: pop
    //   3750: aload_2
    //   3751: aload 12
    //   3753: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3756: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3759: pop
    //   3760: ldc 31
    //   3762: iconst_1
    //   3763: aload_2
    //   3764: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3767: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3770: invokestatic 1128	com/tencent/qphone/base/util/QLog:flushLog	()V
    //   3773: aload 12
    //   3775: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3778: areturn
    //   3779: astore_2
    //   3780: aload 11
    //   3782: astore_3
    //   3783: aload_3
    //   3784: ifnull +7 -> 3791
    //   3787: aload_3
    //   3788: invokevirtual 585	java/io/FileWriter:close	()V
    //   3791: goto +5 -> 3796
    //   3794: aload_2
    //   3795: athrow
    //   3796: goto -2 -> 3794
    //   3799: astore 10
    //   3801: goto -2654 -> 1147
    //   3804: astore 10
    //   3806: goto -1322 -> 2484
    //   3809: astore 10
    //   3811: goto -1318 -> 2493
    //   3814: astore 10
    //   3816: goto -1217 -> 2599
    //   3819: astore 10
    //   3821: goto -1151 -> 2670
    //   3824: astore 10
    //   3826: goto -665 -> 3161
    //   3829: astore 10
    //   3831: goto -538 -> 3293
    //   3834: astore 4
    //   3836: goto -119 -> 3717
    //   3839: astore_3
    //   3840: goto -49 -> 3791
    //   3843: iconst_0
    //   3844: istore 9
    //   3846: goto -2403 -> 1443
    //   3849: ldc_w 1130
    //   3852: astore 10
    //   3854: goto -1317 -> 2537
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3857	0	this	QQCrashHandleListener
    //   0	3857	1	paramBoolean	boolean
    //   0	3857	2	paramString1	String
    //   0	3857	3	paramString2	String
    //   0	3857	4	paramString3	String
    //   0	3857	5	paramInt	int
    //   0	3857	6	paramLong	long
    //   2505	69	8	i	int
    //   763	3082	9	bool	boolean
    //   15	885	10	localObject1	Object
    //   912	3	10	localThrowable1	Throwable
    //   926	2013	10	localObject2	Object
    //   2958	15	10	localThrowable2	Throwable
    //   3032	382	10	localObject3	Object
    //   3799	1	10	localException1	java.lang.Exception
    //   3804	1	10	localThrowable3	Throwable
    //   3809	1	10	localThrowable4	Throwable
    //   3814	1	10	localThrowable5	Throwable
    //   3819	1	10	localThrowable6	Throwable
    //   3824	1	10	localThrowable7	Throwable
    //   3829	1	10	localThrowable8	Throwable
    //   3852	1	10	str1	String
    //   315	3466	11	localObject4	Object
    //   862	261	12	localObject5	Object
    //   1150	1	12	localException2	java.lang.Exception
    //   1162	10	12	localException3	java.lang.Exception
    //   1295	2479	12	localStringBuilder	StringBuilder
    //   3	2705	13	localBaseApplication	BaseApplication
    //   1238	1626	14	str2	String
    //   1807	82	15	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   784	864	912	java/lang/Throwable
    //   869	909	912	java/lang/Throwable
    //   1030	1042	1150	java/lang/Exception
    //   1046	1067	1150	java/lang/Exception
    //   1071	1080	1150	java/lang/Exception
    //   1084	1091	1150	java/lang/Exception
    //   1095	1104	1150	java/lang/Exception
    //   1108	1116	1150	java/lang/Exception
    //   1120	1130	1150	java/lang/Exception
    //   1134	1139	1150	java/lang/Exception
    //   919	978	1155	finally
    //   978	1026	1155	finally
    //   919	978	1162	java/lang/Exception
    //   978	1026	1162	java/lang/Exception
    //   2786	2874	2958	java/lang/Throwable
    //   2874	2890	2958	java/lang/Throwable
    //   2895	2955	2958	java/lang/Throwable
    //   3509	3545	3619	java/lang/Throwable
    //   3545	3562	3619	java/lang/Throwable
    //   3562	3616	3619	java/lang/Throwable
    //   1030	1042	3779	finally
    //   1046	1067	3779	finally
    //   1071	1080	3779	finally
    //   1084	1091	3779	finally
    //   1095	1104	3779	finally
    //   1108	1116	3779	finally
    //   1120	1130	3779	finally
    //   1134	1139	3779	finally
    //   1171	1176	3779	finally
    //   1139	1144	3799	java/lang/Exception
    //   1297	1424	3804	java/lang/Throwable
    //   1429	1437	3804	java/lang/Throwable
    //   1443	1647	3804	java/lang/Throwable
    //   1647	1701	3804	java/lang/Throwable
    //   1701	1724	3804	java/lang/Throwable
    //   1729	1782	3804	java/lang/Throwable
    //   1782	1827	3804	java/lang/Throwable
    //   1841	1915	3804	java/lang/Throwable
    //   1923	1932	3804	java/lang/Throwable
    //   1932	2072	3804	java/lang/Throwable
    //   2072	2108	3804	java/lang/Throwable
    //   2108	2144	3804	java/lang/Throwable
    //   2144	2180	3804	java/lang/Throwable
    //   2180	2360	3804	java/lang/Throwable
    //   2360	2463	3804	java/lang/Throwable
    //   2463	2484	3804	java/lang/Throwable
    //   2484	2493	3809	java/lang/Throwable
    //   2493	2524	3814	java/lang/Throwable
    //   2537	2599	3814	java/lang/Throwable
    //   2599	2670	3819	java/lang/Throwable
    //   3126	3131	3824	java/lang/Throwable
    //   3136	3161	3824	java/lang/Throwable
    //   3161	3214	3829	java/lang/Throwable
    //   3214	3243	3829	java/lang/Throwable
    //   3243	3272	3829	java/lang/Throwable
    //   3272	3293	3829	java/lang/Throwable
    //   3632	3714	3834	java/lang/Throwable
    //   3787	3791	3839	java/lang/Exception
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("onCrashHandleEnd isNativeCrashed=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", sIsFinalizeTimeoutException=");
    localStringBuilder.append(QQCrashReportManager.g);
    QLog.d("QQCrashReportManager", 1, localStringBuilder.toString());
    if (QQCrashReportManager.g)
    {
      QQCrashReportManager.g = false;
      return true;
    }
    Object localObject2 = MobileQQ.getContext();
    if (paramBoolean) {
      ((Context)localObject2).getSharedPreferences("QQCrashReportManager", 4).edit().putBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", true).commit();
    }
    if ((!paramBoolean) && (SafeModeUtil.a(QQCrashReportManager.j, QQCrashReportManager.k)))
    {
      QQCrashReportManager.i = true;
      return true;
    }
    Object localObject4 = BaseApplicationImpl.processName;
    try
    {
      CacheHelper.fileCache().clear();
      BaseApplicationImpl.getApplication().closeAllActivitys();
      try
      {
        a((Context)localObject2, (String)localObject4);
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2) {}
    try
    {
      if (((String)localObject4).equals("com.tencent.mobileqq"))
      {
        QQCrashControlManager.b().d();
        QQCrashControlManager.b().e();
        QQCrashControlManager.b().a(QQCrashReportManager.j, QQCrashReportManager.k);
      }
      boolean bool = ((String)localObject4).endsWith(":qzone");
      if ((bool) || (((String)localObject4).endsWith(":tool")) || (((String)localObject4).endsWith(":peak")))
      {
        QQCrashControlManager.b().d();
        QQCrashControlManager.b().b((String)localObject4);
      }
      if (((((String)localObject4).endsWith(":qzone")) || (((String)localObject4).endsWith(":tool")) || (((String)localObject4).endsWith(":peak")) || (((String)localObject4).endsWith(":qzonevideo")) || (((String)localObject4).endsWith(":picture"))) && (LocalMultiProcConfig.getBool("key_sp_qzone_isforeground", false)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("qzone crash | crash time:");
        l = System.currentTimeMillis();
      }
    }
    catch (Throwable localThrowable4)
    {
      Object localObject1;
      long l;
      Object localObject5;
      break label409;
    }
    try
    {
      ((StringBuilder)localObject1).append(l / 1000L);
      QLog.d("QQCrashReportManager", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("key_sp_qzone_crash_time_");
      ((StringBuilder)localObject1).append(QQCrashReportManager.a);
      LocalMultiProcConfig.putLong(((StringBuilder)localObject1).toString(), System.currentTimeMillis() / 1000L);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", false);
    }
    catch (Throwable localThrowable5)
    {
      break label409;
      if (!paramBoolean) {
        break label993;
      }
      break label976;
    }
    break label418;
    label409:
    QLog.d("QQCrashReportManager", 1, "init and update crashcontrol exception happen.");
    label418:
    localObject1 = localObject2;
    try
    {
      BaseApplicationImpl.getApplication().crashed();
      if (((String)localObject4).equals("com.tencent.mobileqq"))
      {
        localObject5 = new Intent("com.tencent.process.exit");
        localObject2 = localObject1;
      }
      try
      {
        Object localObject6 = ((ActivityManager)((Context)localObject2).getSystemService("activity")).getRunningAppProcesses();
        ArrayList localArrayList = new ArrayList();
        if ((localObject6 != null) && (((List)localObject6).size() > 0))
        {
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            String str = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject6).next()).processName;
            if ((str != null) && (str.startsWith("com.tencent.mobileqq:")) && (!str.endsWith(":MSF"))) {
              localArrayList.add(str);
            }
          }
        }
        ((Intent)localObject5).putStringArrayListExtra("procNameList", localArrayList);
        ((Intent)localObject5).putExtra("verify", BaseApplicationImpl.getLocalVerify(localArrayList, false));
        ((Context)localObject2).sendBroadcast((Intent)localObject5);
      }
      catch (Throwable localThrowable6)
      {
        break label713;
      }
      localObject2 = localObject1;
      if (((String)localObject4).endsWith(":qzone"))
      {
        localObject2 = ((ActivityManager)((Context)localObject2).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          if (((ActivityManager.RunningAppProcessInfo)localObject5).processName.equals("com.tencent.mobileqq:qzonevideo"))
          {
            QLog.flushLog();
            Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject5).pid);
          }
        }
      }
      if (!((String)localObject4).endsWith(":TMAssistantDownloadSDKService")) {
        break label718;
      }
      TMAssistantDownloadManager.closeAllService((Context)localObject2);
    }
    catch (Throwable localThrowable7) {}
    label713:
    localThrowable7.printStackTrace();
    try
    {
      label718:
      if (((String)localObject4).equals("com.tencent.mobileqq"))
      {
        if (QQCrashControlManager.b().a())
        {
          QLog.d("QQCrashReportManager", 1, "onCrashHandleEnd shouldStopMsf= true, kill package processes.");
          Object localObject3 = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningAppProcesses();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
              localObject5 = ((ActivityManager.RunningAppProcessInfo)localObject4).processName;
              if ((localObject5 != null) && (((String)localObject5).startsWith("com.tencent.mobileqq:")) && (!((String)localObject5).endsWith(":MSF")))
              {
                QLog.flushLog();
                Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject4).pid);
              }
            }
          }
          localObject1 = ((Context)localObject1).getSharedPreferences("crashcontrol", 0);
          int i = ((SharedPreferences)localObject1).getInt("countTryKillMsf", 0);
          ((SharedPreferences)localObject1).edit().putInt("countTryKillMsf", i + 1).commit();
          BaseApplicationImpl.getApplication().stopMsfOnCrash(true);
          QLog.flushLog();
          Process.killProcess(Process.myPid());
        }
        BaseApplicationImpl.getApplication().qqProcessExit(true);
      }
      else
      {
        if ((((String)localObject4).endsWith(":qzone")) || (((String)localObject4).endsWith(":buscard")) || (((String)localObject4).endsWith(":video")) || (((String)localObject4).contains(":mini"))) {
          break label1005;
        }
        label976:
        BaseApplicationImpl.getApplication().otherProcessExit(false);
      }
    }
    catch (Throwable localThrowable3)
    {
      localThrowable3.printStackTrace();
    }
    label993:
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("onCrashHandleStart isNativeCrashed=");
    localStringBuilder1.append(paramBoolean);
    localStringBuilder1.append(", sHasCrashed=");
    localStringBuilder1.append(QQCrashReportManager.f);
    localStringBuilder1.append(", sIsFinalizeTimeoutException=");
    localStringBuilder1.append(QQCrashReportManager.g);
    QLog.d("QQCrashReportManager", 1, localStringBuilder1.toString());
    if ((QQCrashReportManager.f) && (!QQCrashReportManager.g) && (!SafeModeUtil.a(QQCrashReportManager.j, QQCrashReportManager.k))) {
      Process.killProcess(Process.myPid());
    } else {
      QQCrashReportManager.f = true;
    }
    SharedPreferencesProxyManager.getInstance().onCrashStart();
    try
    {
      localStringBuilder1 = new StringBuilder(128);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("topActivity:");
      localStringBuilder2.append(ProcessUtil.a());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("\n");
      localStringBuilder1.append("ActivityInfoStack:size=");
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.b());
      localStringBuilder1.append(",top five were:↓\n--->");
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.a());
      localStringBuilder1.append("\n");
      localStringBuilder1.append("Current mapEvent content is:\n");
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.d());
      ActivityLifeCycleInfoRecordHelper.c();
      QQCrashReportManager.l = localStringBuilder1.toString();
      localStringBuilder1 = QQCrashReportManager.n;
      localStringBuilder1.append("Current thread Id=");
      localStringBuilder1.append(Process.myTid());
      localStringBuilder1.append(", Name=");
      localStringBuilder1.append(Thread.currentThread().getName());
      localStringBuilder1.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString4 = new StringBuilder("onCrashSaving isNativeCrashed=");
    paramString4.append(paramBoolean);
    paramString4.append(", crashType=");
    paramString4.append(paramString1);
    paramString4.append(", crashAddress=");
    paramString4.append(paramString2);
    paramString4.append(", crashTime=");
    paramString4.append(a.format(new Date(paramLong)));
    paramString4.append(", curTime=");
    paramString4.append(a.format(new Date(System.currentTimeMillis())));
    QLog.d("QQCrashReportManager", 1, paramString4.toString());
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    QQCrashReportManager.g = paramBoolean;
    if (QQCrashReportManager.g) {
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    try
    {
      if (!SafeModeUtil.a(paramString1, paramString3)) {
        break label303;
      }
      paramString1 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4).getString("key_not_exit_crash_stack", null);
      paramString2 = new StringBuilder();
      paramString2.append("CrashReport.setCrashFilter: ");
      paramString2.append(paramString1);
      QLog.e("QQCrashReportManager", 1, paramString2.toString());
      CrashReport.setCrashFilter(paramString1);
    }
    catch (Throwable paramString1)
    {
      label294:
      label303:
      break label294;
    }
    QLog.e("QQCrashReportManager", 1, "CrashReport.setCrashFilter Failed");
    WebpSoLoader.a(paramString3);
    GifSoLoader.a(paramString3);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).checkExceptionWhetherCauseByQCircle(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashHandleListener
 * JD-Core Version:    0.7.0.1
 */