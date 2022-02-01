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
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
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
    a();
  }
  
  private void a()
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
    CaughtExceptionReport.a(QQNearbyManager.c());
    CaughtExceptionReport.a(QQNearbyManager.d());
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
  
  public CrashHandleListener a()
  {
    return this;
  }
  
  public void a(String paramString, QQCrashReportManager paramQQCrashReportManager)
  {
    paramString = MobileQQ.getContext();
    CrashReport.putUserData(paramString, "PatchInstallStatus", String.valueOf(DexPatchInstaller.jdField_a_of_type_Int));
    if (!TextUtils.isEmpty(DexPatchInstaller.jdField_a_of_type_JavaLangString)) {
      CrashReport.putUserData(paramString, "PatchNameInstalled", DexPatchInstaller.jdField_a_of_type_JavaLangString);
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
    //   0: invokestatic 266	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 13
    //   5: new 194	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 294
    //   12: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: astore 10
    //   17: aload 10
    //   19: iload_1
    //   20: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: ldc_w 300
    //   29: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 10
    //   35: aload_2
    //   36: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 10
    //   42: ldc_w 302
    //   45: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: aload_3
    //   52: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 10
    //   58: ldc_w 304
    //   61: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 10
    //   67: aload 4
    //   69: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 10
    //   75: ldc_w 306
    //   78: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: iload 5
    //   86: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 10
    //   92: ldc_w 308
    //   95: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 10
    //   101: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   104: new 310	java/util/Date
    //   107: dup
    //   108: lload 6
    //   110: invokespecial 313	java/util/Date:<init>	(J)V
    //   113: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   116: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 122
    //   122: iconst_1
    //   123: aload 10
    //   125: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_2
    //   132: putstatic 321	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   135: aload 4
    //   137: putstatic 323	com/tencent/qqperf/monitor/crash/QQCrashReportManager:d	Ljava/lang/String;
    //   140: iconst_1
    //   141: getstatic 242	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   144: if_icmpne +50 -> 194
    //   147: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   150: getstatic 333	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_b_of_type_Long	J
    //   153: lsub
    //   154: ldc2_w 334
    //   157: lcmp
    //   158: ifgt +36 -> 194
    //   161: new 194	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   168: astore 10
    //   170: aload 10
    //   172: aload_2
    //   173: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 10
    //   179: aload_3
    //   180: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 13
    //   186: aload 10
    //   188: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 339	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   194: iconst_1
    //   195: getstatic 242	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   198: if_icmpne +47 -> 245
    //   201: aload 4
    //   203: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifne +39 -> 245
    //   209: iload_1
    //   210: ifeq +14 -> 224
    //   213: aload 4
    //   215: ldc_w 341
    //   218: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   221: ifne +18 -> 239
    //   224: iload_1
    //   225: ifne +20 -> 245
    //   228: aload 4
    //   230: ldc_w 343
    //   233: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifeq +9 -> 245
    //   239: invokestatic 348	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:a	()Lcom/tencent/qqperf/opt/suspendthread/SuspendThreadManager;
    //   242: invokevirtual 350	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:b	()V
    //   245: getstatic 353	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashCallback	Lcom/tencent/qqperf/monitor/crash/QQCrashCallback;
    //   248: ifnull +43 -> 291
    //   251: iload_1
    //   252: ifne +39 -> 291
    //   255: ldc_w 355
    //   258: aload_2
    //   259: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +29 -> 291
    //   265: aload_3
    //   266: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifne +22 -> 291
    //   272: aload_3
    //   273: ldc_w 357
    //   276: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   279: ifeq +12 -> 291
    //   282: getstatic 353	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashCallback	Lcom/tencent/qqperf/monitor/crash/QQCrashCallback;
    //   285: aload_2
    //   286: invokeinterface 360 2 0
    //   291: getstatic 363	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   294: ldc_w 365
    //   297: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   300: ifeq +51 -> 351
    //   303: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: astore 10
    //   308: new 194	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   315: astore 11
    //   317: aload 11
    //   319: ldc_w 375
    //   322: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 11
    //   328: aload_2
    //   329: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 11
    //   335: aload 4
    //   337: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 10
    //   343: aload 11
    //   345: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 378	com/tencent/mobileqq/qwallet/utils/QWalletCrashUtils:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   351: aload 4
    //   353: ifnull +126 -> 479
    //   356: aload 4
    //   358: ldc_w 380
    //   361: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   364: ifne +25 -> 389
    //   367: aload 4
    //   369: ldc_w 382
    //   372: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   375: ifne +14 -> 389
    //   378: aload 4
    //   380: ldc_w 384
    //   383: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +93 -> 479
    //   389: iconst_0
    //   390: iconst_0
    //   391: invokestatic 389	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   394: new 391	java/util/HashMap
    //   397: dup
    //   398: invokespecial 392	java/util/HashMap:<init>	()V
    //   401: astore 11
    //   403: iload_1
    //   404: ifeq +11 -> 415
    //   407: ldc_w 394
    //   410: astore 10
    //   412: goto +8 -> 420
    //   415: ldc_w 396
    //   418: astore 10
    //   420: aload 11
    //   422: ldc_w 398
    //   425: aload 10
    //   427: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: aload 11
    //   433: ldc_w 404
    //   436: aload_2
    //   437: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   440: pop
    //   441: aload 11
    //   443: ldc_w 406
    //   446: getstatic 363	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   449: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: aload 13
    //   455: invokestatic 412	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   458: getstatic 413	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 415
    //   464: iconst_1
    //   465: lconst_0
    //   466: lconst_0
    //   467: aload 11
    //   469: ldc_w 417
    //   472: iconst_0
    //   473: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   476: goto +3 -> 479
    //   479: ldc_w 423
    //   482: invokestatic 102	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   485: checkcast 423	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   488: astore 10
    //   490: aload 10
    //   492: ifnull +14 -> 506
    //   495: aload 10
    //   497: iload_1
    //   498: aload_2
    //   499: aload 4
    //   501: invokeinterface 427 4 0
    //   506: aload 4
    //   508: ifnull +107 -> 615
    //   511: aload 4
    //   513: ldc_w 429
    //   516: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   519: ifne +14 -> 533
    //   522: aload 4
    //   524: ldc_w 431
    //   527: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   530: ifeq +85 -> 615
    //   533: new 391	java/util/HashMap
    //   536: dup
    //   537: invokespecial 392	java/util/HashMap:<init>	()V
    //   540: astore 11
    //   542: iload_1
    //   543: ifeq +11 -> 554
    //   546: ldc_w 394
    //   549: astore 10
    //   551: goto +8 -> 559
    //   554: ldc_w 396
    //   557: astore 10
    //   559: aload 11
    //   561: ldc_w 398
    //   564: aload 10
    //   566: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: pop
    //   570: aload 11
    //   572: ldc_w 404
    //   575: aload_2
    //   576: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: aload 11
    //   582: ldc_w 406
    //   585: getstatic 363	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   588: invokevirtual 402	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   591: pop
    //   592: aload 13
    //   594: invokestatic 412	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   597: getstatic 413	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   600: ldc_w 433
    //   603: iconst_1
    //   604: lconst_0
    //   605: lconst_0
    //   606: aload 11
    //   608: ldc_w 417
    //   611: iconst_0
    //   612: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   615: getstatic 437	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   618: ldc_w 439
    //   621: invokevirtual 443	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   624: ifeq +55 -> 679
    //   627: new 183	android/content/Intent
    //   630: dup
    //   631: invokespecial 184	android/content/Intent:<init>	()V
    //   634: astore 10
    //   636: aload 10
    //   638: ldc_w 445
    //   641: invokevirtual 449	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   644: pop
    //   645: aload 10
    //   647: invokestatic 452	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   650: invokevirtual 455	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   653: invokevirtual 458	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   656: pop
    //   657: aload 13
    //   659: aload 10
    //   661: invokevirtual 462	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   664: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq +12 -> 679
    //   670: ldc 122
    //   672: iconst_2
    //   673: ldc_w 467
    //   676: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: ldc_w 469
    //   682: invokestatic 102	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   685: checkcast 469	com/tencent/mobileqq/soload/api/ISoLoaderCrashService
    //   688: astore 10
    //   690: aload 10
    //   692: ifnull +13 -> 705
    //   695: aload 10
    //   697: aload_2
    //   698: aload 4
    //   700: invokeinterface 473 3 0
    //   705: getstatic 363	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   708: ldc_w 475
    //   711: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   714: ifeq +44 -> 758
    //   717: new 194	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   724: astore 10
    //   726: aload 10
    //   728: ldc_w 375
    //   731: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 10
    //   737: aload_2
    //   738: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 10
    //   744: aload 4
    //   746: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 10
    //   752: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 479	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   758: aload 4
    //   760: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   763: istore 9
    //   765: aconst_null
    //   766: astore 11
    //   768: iload 9
    //   770: ifne +149 -> 919
    //   773: aload 4
    //   775: ldc_w 481
    //   778: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   781: ifeq +138 -> 919
    //   784: new 483	org/json/JSONObject
    //   787: dup
    //   788: invokespecial 484	org/json/JSONObject:<init>	()V
    //   791: astore 10
    //   793: aload 10
    //   795: ldc_w 486
    //   798: iload_1
    //   799: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   802: pop
    //   803: aload 10
    //   805: ldc_w 491
    //   808: aload_2
    //   809: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   812: pop
    //   813: aload 10
    //   815: ldc_w 496
    //   818: aload_3
    //   819: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   822: pop
    //   823: aload 10
    //   825: ldc_w 498
    //   828: aload 4
    //   830: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   833: pop
    //   834: aload 10
    //   836: ldc_w 500
    //   839: iload 5
    //   841: invokevirtual 503	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   844: pop
    //   845: aload 10
    //   847: ldc_w 505
    //   850: lload 6
    //   852: invokevirtual 508	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   855: pop
    //   856: getstatic 512	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   859: invokevirtual 516	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   862: astore 12
    //   864: aload 12
    //   866: ifnull +53 -> 919
    //   869: aload 12
    //   871: ldc_w 518
    //   874: invokevirtual 524	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   877: ldc_w 525
    //   880: iconst_1
    //   881: anewarray 46	java/lang/Class
    //   884: dup
    //   885: iconst_0
    //   886: ldc 177
    //   888: aastore
    //   889: invokevirtual 529	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   892: aconst_null
    //   893: iconst_1
    //   894: anewarray 4	java/lang/Object
    //   897: dup
    //   898: iconst_0
    //   899: aload 10
    //   901: invokevirtual 530	org/json/JSONObject:toString	()Ljava/lang/String;
    //   904: aastore
    //   905: invokevirtual 536	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   908: pop
    //   909: goto +10 -> 919
    //   912: astore 10
    //   914: aload 10
    //   916: invokevirtual 539	java/lang/Throwable:printStackTrace	()V
    //   919: new 194	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   926: astore 10
    //   928: aload 10
    //   930: getstatic 541	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   933: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 10
    //   939: ldc_w 543
    //   942: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload 10
    //   948: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: astore 10
    //   953: new 545	java/io/File
    //   956: dup
    //   957: aload 10
    //   959: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   962: astore 12
    //   964: aload 12
    //   966: invokevirtual 549	java/io/File:exists	()Z
    //   969: ifne +9 -> 978
    //   972: aload 12
    //   974: invokevirtual 552	java/io/File:mkdirs	()Z
    //   977: pop
    //   978: new 194	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   985: astore 12
    //   987: aload 12
    //   989: aload 10
    //   991: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 12
    //   997: lload 6
    //   999: invokevirtual 555	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 12
    //   1005: ldc_w 557
    //   1008: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: new 559	java/io/FileWriter
    //   1015: dup
    //   1016: aload 12
    //   1018: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokespecial 560	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   1024: astore 10
    //   1026: aload 10
    //   1028: astore 11
    //   1030: new 194	java/lang/StringBuilder
    //   1033: dup
    //   1034: sipush 128
    //   1037: invokespecial 563	java/lang/StringBuilder:<init>	(I)V
    //   1040: astore 12
    //   1042: aload 10
    //   1044: astore 11
    //   1046: aload 12
    //   1048: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   1051: new 310	java/util/Date
    //   1054: dup
    //   1055: lload 6
    //   1057: invokespecial 313	java/util/Date:<init>	(J)V
    //   1060: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1063: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 10
    //   1069: astore 11
    //   1071: aload 12
    //   1073: ldc_w 565
    //   1076: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload 10
    //   1082: astore 11
    //   1084: aload 12
    //   1086: aload_2
    //   1087: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload 10
    //   1093: astore 11
    //   1095: aload 12
    //   1097: ldc_w 565
    //   1100: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload 10
    //   1106: astore 11
    //   1108: aload 12
    //   1110: aload 4
    //   1112: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: aload 10
    //   1118: astore 11
    //   1120: aload 10
    //   1122: aload 12
    //   1124: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokevirtual 568	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   1130: aload 10
    //   1132: astore 11
    //   1134: aload 10
    //   1136: invokevirtual 571	java/io/FileWriter:flush	()V
    //   1139: aload 10
    //   1141: invokevirtual 574	java/io/FileWriter:close	()V
    //   1144: goto +40 -> 1184
    //   1147: goto +37 -> 1184
    //   1150: astore 12
    //   1152: goto +15 -> 1167
    //   1155: astore_2
    //   1156: aload 11
    //   1158: astore_3
    //   1159: goto +2642 -> 3801
    //   1162: astore 12
    //   1164: aconst_null
    //   1165: astore 10
    //   1167: aload 10
    //   1169: astore 11
    //   1171: aload 12
    //   1173: invokevirtual 575	java/lang/Exception:printStackTrace	()V
    //   1176: aload 10
    //   1178: ifnull +6 -> 1184
    //   1181: goto -42 -> 1139
    //   1184: aload_2
    //   1185: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1188: ifne +47 -> 1235
    //   1191: aload_2
    //   1192: ldc_w 577
    //   1195: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1198: ifeq +37 -> 1235
    //   1201: invokestatic 582	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1204: invokevirtual 583	com/tencent/qqperf/monitor/memory/MemoryManager:a	()V
    //   1207: aload 4
    //   1209: ldc_w 585
    //   1212: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1215: ifne +20 -> 1235
    //   1218: aload 4
    //   1220: ldc_w 587
    //   1223: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1226: ifne +9 -> 1235
    //   1229: invokestatic 592	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryClearManager;
    //   1232: invokevirtual 593	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:b	()V
    //   1235: getstatic 363	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   1238: astore 14
    //   1240: iload_1
    //   1241: ifeq +39 -> 1280
    //   1244: aload 14
    //   1246: ldc_w 595
    //   1249: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1252: ifne +14 -> 1266
    //   1255: aload 14
    //   1257: ldc_w 597
    //   1260: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1263: ifeq +17 -> 1280
    //   1266: ldc_w 599
    //   1269: iconst_1
    //   1270: aload 4
    //   1272: invokestatic 602	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: aload 4
    //   1277: invokestatic 607	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1280: aload 13
    //   1282: invokestatic 612	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1285: new 194	java/lang/StringBuilder
    //   1288: dup
    //   1289: sipush 128
    //   1292: invokespecial 563	java/lang/StringBuilder:<init>	(I)V
    //   1295: astore 12
    //   1297: aload 13
    //   1299: ldc_w 614
    //   1302: invokestatic 619	com/tencent/hotpatch/config/PatchConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/hotpatch/config/PatchConfig;
    //   1305: astore 10
    //   1307: aload 12
    //   1309: ldc_w 621
    //   1312: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload 12
    //   1318: ldc_w 623
    //   1321: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload 12
    //   1327: ldc_w 625
    //   1330: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 12
    //   1336: getstatic 628	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1339: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload 12
    //   1345: ldc_w 630
    //   1348: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 12
    //   1354: getstatic 633	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1357: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload 12
    //   1363: ldc_w 635
    //   1366: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: pop
    //   1370: aload 12
    //   1372: getstatic 638	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1375: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 12
    //   1381: ldc_w 640
    //   1384: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: aload 12
    //   1390: getstatic 643	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1393: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 12
    //   1399: ldc_w 645
    //   1402: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 12
    //   1408: getstatic 649	com/tencent/mobileqq/startup/director/StartupDirector:b	I
    //   1411: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 12
    //   1417: ldc_w 651
    //   1420: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: pop
    //   1424: aload 10
    //   1426: ifnull +2435 -> 3861
    //   1429: aload 10
    //   1431: invokevirtual 655	com/tencent/hotpatch/config/PatchConfig:a	()Z
    //   1434: ifeq +2427 -> 3861
    //   1437: iconst_1
    //   1438: istore 9
    //   1440: goto +3 -> 1443
    //   1443: aload 12
    //   1445: iload 9
    //   1447: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1450: pop
    //   1451: aload 12
    //   1453: ldc_w 657
    //   1456: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 12
    //   1462: getstatic 272	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_Int	I
    //   1465: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload 12
    //   1471: ldc_w 659
    //   1474: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: pop
    //   1478: aload 12
    //   1480: getstatic 662	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1483: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1486: pop
    //   1487: aload 12
    //   1489: ldc_w 664
    //   1492: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: pop
    //   1496: aload 12
    //   1498: getstatic 284	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1501: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 12
    //   1507: ldc_w 666
    //   1510: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: pop
    //   1514: aload 12
    //   1516: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1519: invokevirtual 675	java/lang/Runtime:maxMemory	()J
    //   1522: invokevirtual 555	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 12
    //   1528: ldc_w 677
    //   1531: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload 12
    //   1537: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1540: invokevirtual 680	java/lang/Runtime:totalMemory	()J
    //   1543: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1546: invokevirtual 683	java/lang/Runtime:freeMemory	()J
    //   1549: lsub
    //   1550: invokevirtual 555	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1553: pop
    //   1554: aload 12
    //   1556: ldc_w 685
    //   1559: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload 12
    //   1565: invokestatic 582	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1568: invokevirtual 687	com/tencent/qqperf/monitor/memory/MemoryManager:a	()I
    //   1571: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload 12
    //   1577: ldc_w 689
    //   1580: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: aload 12
    //   1586: invokestatic 582	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1589: invokevirtual 691	com/tencent/qqperf/monitor/memory/MemoryManager:b	()I
    //   1592: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: pop
    //   1596: aload 12
    //   1598: ldc_w 693
    //   1601: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload 12
    //   1607: invokestatic 582	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1610: invokevirtual 695	com/tencent/qqperf/monitor/memory/MemoryManager:c	()I
    //   1613: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: aload 12
    //   1619: ldc_w 697
    //   1622: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 12
    //   1628: invokestatic 702	com/tencent/qqperf/tools/SceneTracker:a	()Lcom/tencent/qqperf/tools/SceneTracker;
    //   1631: invokevirtual 704	com/tencent/qqperf/tools/SceneTracker:a	()Ljava/lang/String;
    //   1634: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: getstatic 709	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1641: ifnull +24 -> 1665
    //   1644: aload 12
    //   1646: ldc_w 711
    //   1649: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: pop
    //   1653: aload 12
    //   1655: getstatic 709	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1658: invokevirtual 714	android/support/v4/util/MQLruCache:size	()I
    //   1661: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1668: invokevirtual 675	java/lang/Runtime:maxMemory	()J
    //   1671: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1674: invokevirtual 680	java/lang/Runtime:totalMemory	()J
    //   1677: lsub
    //   1678: l2f
    //   1679: fconst_1
    //   1680: fmul
    //   1681: invokestatic 672	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1684: invokevirtual 675	java/lang/Runtime:maxMemory	()J
    //   1687: l2f
    //   1688: fdiv
    //   1689: f2d
    //   1690: ldc2_w 715
    //   1693: dcmpl
    //   1694: iflt +25 -> 1719
    //   1697: aload_2
    //   1698: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1701: ifne +18 -> 1719
    //   1704: aload_2
    //   1705: ldc_w 577
    //   1708: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1711: ifeq +8 -> 1719
    //   1714: aload 12
    //   1716: invokestatic 719	com/tencent/qqperf/monitor/crash/tools/ThreadInfoRecordHelper:a	(Ljava/lang/StringBuilder;)V
    //   1719: aload 12
    //   1721: ldc_w 721
    //   1724: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: pop
    //   1728: aload 12
    //   1730: getstatic 726	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1733: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: pop
    //   1737: getstatic 731	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1740: astore 10
    //   1742: aload 10
    //   1744: ifnull +56 -> 1800
    //   1747: aload 10
    //   1749: arraylength
    //   1750: iconst_3
    //   1751: if_icmplt +49 -> 1800
    //   1754: aload 12
    //   1756: ldc_w 733
    //   1759: iconst_3
    //   1760: anewarray 4	java/lang/Object
    //   1763: dup
    //   1764: iconst_0
    //   1765: aload 10
    //   1767: iconst_0
    //   1768: iaload
    //   1769: invokestatic 738	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1772: aastore
    //   1773: dup
    //   1774: iconst_1
    //   1775: aload 10
    //   1777: iconst_1
    //   1778: iaload
    //   1779: invokestatic 738	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1782: aastore
    //   1783: dup
    //   1784: iconst_2
    //   1785: aload 10
    //   1787: iconst_2
    //   1788: iaload
    //   1789: invokestatic 738	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1792: aastore
    //   1793: invokestatic 741	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1796: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: pop
    //   1800: aload 12
    //   1802: ldc_w 565
    //   1805: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: invokestatic 746	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   1812: invokevirtual 749	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/monitor/base/IAPMModuleCelling;
    //   1815: invokeinterface 752 1 0
    //   1820: astore 11
    //   1822: invokestatic 757	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()[J
    //   1825: astore 15
    //   1827: aload 12
    //   1829: invokestatic 760	com/tencent/mobileqq/utils/DeviceInfoUtil:l	()Ljava/lang/String;
    //   1832: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: pop
    //   1836: aload 12
    //   1838: ldc_w 565
    //   1841: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: pop
    //   1845: aload 11
    //   1847: astore 10
    //   1849: aload 11
    //   1851: ifnonnull +8 -> 1859
    //   1854: ldc_w 762
    //   1857: astore 10
    //   1859: aload 12
    //   1861: aload 10
    //   1863: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 12
    //   1869: ldc_w 565
    //   1872: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: pop
    //   1876: aload 12
    //   1878: ldc_w 764
    //   1881: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: pop
    //   1885: aload 12
    //   1887: aload 15
    //   1889: iconst_0
    //   1890: laload
    //   1891: invokevirtual 555	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1894: pop
    //   1895: aload 12
    //   1897: ldc_w 766
    //   1900: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: pop
    //   1904: aload 12
    //   1906: aload 15
    //   1908: iconst_1
    //   1909: laload
    //   1910: invokevirtual 555	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1913: pop
    //   1914: aload 12
    //   1916: ldc_w 768
    //   1919: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: pop
    //   1923: invokestatic 771	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   1926: pop
    //   1927: getstatic 773	com/tencent/qqperf/monitor/crash/QQCrashReportManager:e	Ljava/lang/String;
    //   1930: ifnonnull +11 -> 1941
    //   1933: ldc_w 762
    //   1936: astore 10
    //   1938: goto +12 -> 1950
    //   1941: invokestatic 771	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   1944: pop
    //   1945: getstatic 773	com/tencent/qqperf/monitor/crash/QQCrashReportManager:e	Ljava/lang/String;
    //   1948: astore 10
    //   1950: aload 12
    //   1952: aload 10
    //   1954: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 12
    //   1960: ldc_w 565
    //   1963: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: pop
    //   1967: new 194	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1974: astore 10
    //   1976: aload 10
    //   1978: ldc_w 775
    //   1981: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 10
    //   1987: invokestatic 780	mqq/app/Foreground:getResumeActivityCount	()I
    //   1990: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1993: pop
    //   1994: aload 10
    //   1996: ldc_w 565
    //   1999: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: pop
    //   2003: aload 12
    //   2005: aload 10
    //   2007: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2010: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: pop
    //   2014: aload 12
    //   2016: ldc_w 782
    //   2019: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 12
    //   2025: getstatic 787	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   2028: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2031: pop
    //   2032: aload 12
    //   2034: ldc_w 565
    //   2037: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: pop
    //   2041: getstatic 791	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2044: astore 10
    //   2046: aload 10
    //   2048: instanceof 784
    //   2051: ifeq +39 -> 2090
    //   2054: aload 10
    //   2056: checkcast 784	com/tencent/mobileqq/activity/SplashActivity
    //   2059: astore 10
    //   2061: aload 12
    //   2063: ldc_w 793
    //   2066: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: pop
    //   2070: aload 12
    //   2072: aload 10
    //   2074: invokevirtual 796	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   2077: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2080: pop
    //   2081: aload 12
    //   2083: ldc_w 565
    //   2086: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: pop
    //   2090: getstatic 799	com/tencent/mobileqq/activity/CrashReportConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2093: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2096: ifne +30 -> 2126
    //   2099: aload 12
    //   2101: ldc_w 801
    //   2104: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: pop
    //   2108: aload 12
    //   2110: getstatic 799	com/tencent/mobileqq/activity/CrashReportConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2113: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: pop
    //   2117: aload 12
    //   2119: ldc_w 565
    //   2122: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: pop
    //   2126: getstatic 804	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   2129: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2132: ifne +30 -> 2162
    //   2135: aload 12
    //   2137: ldc_w 806
    //   2140: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: aload 12
    //   2146: getstatic 804	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   2149: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: aload 12
    //   2155: ldc_w 565
    //   2158: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: pop
    //   2162: getstatic 809	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2165: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2168: ifne +30 -> 2198
    //   2171: aload 12
    //   2173: ldc_w 811
    //   2176: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: pop
    //   2180: aload 12
    //   2182: getstatic 809	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2185: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: pop
    //   2189: aload 12
    //   2191: ldc_w 565
    //   2194: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: pop
    //   2198: new 194	java/lang/StringBuilder
    //   2201: dup
    //   2202: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2205: astore 10
    //   2207: aload 10
    //   2209: ldc_w 813
    //   2212: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: pop
    //   2216: aload 10
    //   2218: invokestatic 818	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2221: ldc_w 820
    //   2224: ldc_w 822
    //   2227: iconst_1
    //   2228: invokevirtual 826	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   2231: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2234: pop
    //   2235: aload 12
    //   2237: aload 10
    //   2239: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: pop
    //   2246: new 194	java/lang/StringBuilder
    //   2249: dup
    //   2250: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2253: astore 10
    //   2255: aload 10
    //   2257: ldc_w 828
    //   2260: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: pop
    //   2264: aload 10
    //   2266: invokestatic 818	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2269: ldc_w 820
    //   2272: ldc_w 830
    //   2275: iconst_0
    //   2276: invokevirtual 833	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2279: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2282: pop
    //   2283: aload 12
    //   2285: aload 10
    //   2287: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2290: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: pop
    //   2294: new 194	java/lang/StringBuilder
    //   2297: dup
    //   2298: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2301: astore 10
    //   2303: aload 10
    //   2305: ldc_w 835
    //   2308: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: pop
    //   2312: aload 10
    //   2314: invokestatic 818	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2317: ldc_w 820
    //   2320: ldc_w 837
    //   2323: iconst_0
    //   2324: invokevirtual 833	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2327: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2330: pop
    //   2331: aload 12
    //   2333: aload 10
    //   2335: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2338: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: pop
    //   2342: aload 12
    //   2344: ldc_w 565
    //   2347: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: pop
    //   2351: invokestatic 838	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2354: invokestatic 843	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   2357: invokevirtual 846	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   2360: astore 10
    //   2362: aload 10
    //   2364: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2367: ifne +11 -> 2378
    //   2370: aload 12
    //   2372: aload 10
    //   2374: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: pop
    //   2378: invokestatic 771	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   2381: pop
    //   2382: aload 12
    //   2384: getstatic 849	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   2387: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2390: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: pop
    //   2394: invokestatic 771	com/tencent/qqperf/monitor/crash/QQCrashReportManager:a	()Lcom/tencent/qqperf/monitor/crash/QQCrashReportManager;
    //   2397: pop
    //   2398: aload 12
    //   2400: getstatic 851	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_b_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   2403: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2406: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: pop
    //   2410: getstatic 854	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2413: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2416: ifne +65 -> 2481
    //   2419: getstatic 859	android/os/Build$VERSION:SDK_INT	I
    //   2422: bipush 8
    //   2424: if_icmplt +57 -> 2481
    //   2427: new 194	java/lang/StringBuilder
    //   2430: dup
    //   2431: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2434: astore 10
    //   2436: aload 10
    //   2438: ldc_w 861
    //   2441: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2444: pop
    //   2445: aload 10
    //   2447: getstatic 854	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2450: invokevirtual 865	java/lang/String:getBytes	()[B
    //   2453: iconst_0
    //   2454: invokestatic 871	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2457: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: pop
    //   2461: aload 10
    //   2463: ldc_w 565
    //   2466: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: pop
    //   2470: aload 12
    //   2472: aload 10
    //   2474: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2477: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: pop
    //   2481: aload 12
    //   2483: invokestatic 876	cooperation/qzone/RDMEtraMsgCollector:getInstance	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   2486: invokevirtual 879	cooperation/qzone/RDMEtraMsgCollector:getEtraMsg	()Ljava/lang/String;
    //   2489: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: pop
    //   2493: aload 12
    //   2495: ldc_w 565
    //   2498: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2501: pop
    //   2502: aload 12
    //   2504: invokestatic 882	com/tencent/qqperf/monitor/crash/tools/WebViewInfoRecordHelper:a	()Ljava/lang/String;
    //   2507: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2510: pop
    //   2511: aload 13
    //   2513: invokestatic 888	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2516: istore 5
    //   2518: aload 13
    //   2520: invokestatic 893	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2523: istore 8
    //   2525: aload 12
    //   2527: bipush 10
    //   2529: invokevirtual 896	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2532: pop
    //   2533: aload 12
    //   2535: ldc_w 898
    //   2538: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2541: pop
    //   2542: iload 8
    //   2544: ifne +1323 -> 3867
    //   2547: ldc_w 900
    //   2550: astore 10
    //   2552: goto +3 -> 2555
    //   2555: aload 12
    //   2557: aload 10
    //   2559: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: pop
    //   2563: aload 12
    //   2565: ldc_w 902
    //   2568: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: pop
    //   2572: aload 12
    //   2574: iload 5
    //   2576: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2579: pop
    //   2580: aload 12
    //   2582: ldc_w 904
    //   2585: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: pop
    //   2589: aload 12
    //   2591: iload 8
    //   2593: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2596: pop
    //   2597: aload 12
    //   2599: ldc_w 906
    //   2602: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2605: pop
    //   2606: aload 12
    //   2608: aload 13
    //   2610: invokestatic 909	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2613: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: pop
    //   2617: aload 12
    //   2619: ldc_w 911
    //   2622: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: pop
    //   2626: aload 12
    //   2628: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   2631: new 310	java/util/Date
    //   2634: dup
    //   2635: getstatic 913	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:jdField_a_of_type_Long	J
    //   2638: invokespecial 313	java/util/Date:<init>	(J)V
    //   2641: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2644: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2647: pop
    //   2648: aload 12
    //   2650: ldc_w 915
    //   2653: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2656: pop
    //   2657: aload 12
    //   2659: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   2662: new 310	java/util/Date
    //   2665: dup
    //   2666: getstatic 916	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:jdField_b_of_type_Long	J
    //   2669: invokespecial 313	java/util/Date:<init>	(J)V
    //   2672: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2675: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: pop
    //   2679: aload 12
    //   2681: ldc_w 565
    //   2684: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2687: pop
    //   2688: iload_1
    //   2689: ifeq +115 -> 2804
    //   2692: aload 14
    //   2694: ldc_w 595
    //   2697: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2700: ifne +25 -> 2725
    //   2703: aload 14
    //   2705: ldc_w 597
    //   2708: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2711: ifne +14 -> 2725
    //   2714: aload 14
    //   2716: ldc_w 365
    //   2719: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2722: ifeq +82 -> 2804
    //   2725: aload 13
    //   2727: ldc 122
    //   2729: iconst_4
    //   2730: invokevirtual 920	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2733: ldc_w 922
    //   2736: aconst_null
    //   2737: invokeinterface 928 3 0
    //   2742: astore 10
    //   2744: aload 12
    //   2746: ldc_w 930
    //   2749: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: pop
    //   2753: aload 12
    //   2755: aload 10
    //   2757: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: pop
    //   2761: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2764: ifeq +40 -> 2804
    //   2767: new 194	java/lang/StringBuilder
    //   2770: dup
    //   2771: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2774: astore 11
    //   2776: aload 11
    //   2778: ldc_w 932
    //   2781: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: pop
    //   2785: aload 11
    //   2787: aload 10
    //   2789: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: pop
    //   2793: ldc 122
    //   2795: iconst_2
    //   2796: aload 11
    //   2798: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2801: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2804: aload 14
    //   2806: ldc_w 934
    //   2809: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2812: ifne +80 -> 2892
    //   2815: aload 14
    //   2817: ldc_w 936
    //   2820: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2823: ifne +69 -> 2892
    //   2826: aload 14
    //   2828: ldc_w 938
    //   2831: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2834: ifne +58 -> 2892
    //   2837: aload 14
    //   2839: ldc_w 940
    //   2842: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2845: ifne +47 -> 2892
    //   2848: aload 14
    //   2850: ldc_w 942
    //   2853: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2856: ifne +36 -> 2892
    //   2859: aload 14
    //   2861: ldc_w 944
    //   2864: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2867: ifne +25 -> 2892
    //   2870: aload 14
    //   2872: ldc_w 946
    //   2875: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2878: ifne +14 -> 2892
    //   2881: aload 14
    //   2883: ldc_w 948
    //   2886: invokevirtual 369	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2889: ifeq +106 -> 2995
    //   2892: ldc_w 950
    //   2895: invokestatic 102	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2898: checkcast 950	com/tencent/mobileqq/mini/api/report/IMiniReport
    //   2901: invokeinterface 953 1 0
    //   2906: astore 10
    //   2908: aload 10
    //   2910: ifnull +85 -> 2995
    //   2913: aload 12
    //   2915: ldc_w 955
    //   2918: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2921: pop
    //   2922: aload 12
    //   2924: aload 10
    //   2926: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: pop
    //   2930: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2933: ifeq +62 -> 2995
    //   2936: new 194	java/lang/StringBuilder
    //   2939: dup
    //   2940: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2943: astore 11
    //   2945: aload 11
    //   2947: ldc_w 957
    //   2950: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: pop
    //   2954: aload 11
    //   2956: aload 10
    //   2958: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: pop
    //   2962: ldc 122
    //   2964: iconst_2
    //   2965: aload 11
    //   2967: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2970: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2973: goto +22 -> 2995
    //   2976: astore 10
    //   2978: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2981: ifeq +14 -> 2995
    //   2984: ldc 122
    //   2986: iconst_2
    //   2987: ldc_w 959
    //   2990: aload 10
    //   2992: invokestatic 962	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2995: aload 12
    //   2997: ldc_w 964
    //   3000: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3003: pop
    //   3004: aload 12
    //   3006: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3009: getfield 967	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   3012: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: pop
    //   3016: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3019: getfield 971	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3022: ifnull +122 -> 3144
    //   3025: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3028: getfield 971	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3031: invokeinterface 975 1 0
    //   3036: ifne +108 -> 3144
    //   3039: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3042: getfield 971	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   3045: invokeinterface 976 1 0
    //   3050: astore 10
    //   3052: aload 10
    //   3054: invokeinterface 165 1 0
    //   3059: ifeq +85 -> 3144
    //   3062: aload 10
    //   3064: invokeinterface 169 1 0
    //   3069: checkcast 978	android/util/Pair
    //   3072: astore 11
    //   3074: aload 11
    //   3076: ifnull -24 -> 3052
    //   3079: aload 12
    //   3081: ldc_w 980
    //   3084: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3087: pop
    //   3088: aload 12
    //   3090: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   3093: new 310	java/util/Date
    //   3096: dup
    //   3097: aload 11
    //   3099: getfield 984	android/util/Pair:first	Ljava/lang/Object;
    //   3102: checkcast 986	java/lang/Long
    //   3105: invokevirtual 989	java/lang/Long:longValue	()J
    //   3108: invokespecial 313	java/util/Date:<init>	(J)V
    //   3111: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3114: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3117: pop
    //   3118: aload 12
    //   3120: ldc_w 991
    //   3123: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: pop
    //   3127: aload 12
    //   3129: aload 11
    //   3131: getfield 994	android/util/Pair:second	Ljava/lang/Object;
    //   3134: checkcast 177	java/lang/String
    //   3137: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: pop
    //   3141: goto -89 -> 3052
    //   3144: getstatic 997	com/tencent/qbar/QbarCrashCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3147: astore 10
    //   3149: aload 10
    //   3151: ifnull +28 -> 3179
    //   3154: aload 10
    //   3156: invokevirtual 1000	java/lang/String:length	()I
    //   3159: ifle +20 -> 3179
    //   3162: aload 12
    //   3164: ldc_w 1002
    //   3167: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: pop
    //   3171: aload 12
    //   3173: aload 10
    //   3175: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3178: pop
    //   3179: aload_2
    //   3180: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3183: ifne +49 -> 3232
    //   3186: aload_2
    //   3187: ldc_w 1004
    //   3190: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3193: ifeq +39 -> 3232
    //   3196: aload 4
    //   3198: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3201: ifne +31 -> 3232
    //   3204: aload 4
    //   3206: ldc_w 1006
    //   3209: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3212: ifeq +20 -> 3232
    //   3215: aload 12
    //   3217: ldc_w 1008
    //   3220: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3223: pop
    //   3224: invokestatic 373	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3227: aload 12
    //   3229: invokestatic 1013	com/tencent/qqperf/monitor/crash/tools/ReceiverInfoRecordHelper:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   3232: ldc_w 1015
    //   3235: aload_2
    //   3236: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3239: ifeq +22 -> 3261
    //   3242: aload 4
    //   3244: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3247: ifne +14 -> 3261
    //   3250: aload 4
    //   3252: ldc_w 1017
    //   3255: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3258: ifne +32 -> 3290
    //   3261: ldc_w 1019
    //   3264: aload_2
    //   3265: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3268: ifeq +43 -> 3311
    //   3271: aload 4
    //   3273: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3276: ifne +35 -> 3311
    //   3279: aload 4
    //   3281: ldc_w 1021
    //   3284: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3287: ifeq +24 -> 3311
    //   3290: aload 12
    //   3292: ldc_w 1023
    //   3295: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: pop
    //   3299: aload 12
    //   3301: ldc_w 1025
    //   3304: invokestatic 1030	com/tencent/mobileqq/util/SystemUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3307: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3310: pop
    //   3311: ldc_w 1032
    //   3314: aload_2
    //   3315: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3318: ifne +66 -> 3384
    //   3321: ldc_w 355
    //   3324: aload_2
    //   3325: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3328: ifeq +14 -> 3342
    //   3331: aload 4
    //   3333: ldc_w 1034
    //   3336: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3339: ifne +45 -> 3384
    //   3342: ldc_w 1036
    //   3345: aload_2
    //   3346: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3349: ifeq +14 -> 3363
    //   3352: aload 4
    //   3354: ldc_w 1038
    //   3357: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3360: ifne +24 -> 3384
    //   3363: ldc_w 355
    //   3366: aload_2
    //   3367: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3370: ifeq +103 -> 3473
    //   3373: aload 4
    //   3375: ldc_w 1040
    //   3378: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3381: ifeq +92 -> 3473
    //   3384: getstatic 22	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	Ljava/text/SimpleDateFormat;
    //   3387: new 310	java/util/Date
    //   3390: dup
    //   3391: getstatic 1041	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_Long	J
    //   3394: invokespecial 313	java/util/Date:<init>	(J)V
    //   3397: invokevirtual 317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3400: astore 10
    //   3402: aload 12
    //   3404: ldc_w 1043
    //   3407: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3410: pop
    //   3411: aload 12
    //   3413: getstatic 1044	com/tencent/qqperf/monitor/crash/QQCrashReportManager:jdField_a_of_type_Int	I
    //   3416: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3419: pop
    //   3420: aload 12
    //   3422: ldc_w 1046
    //   3425: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: pop
    //   3429: aload 12
    //   3431: aload 10
    //   3433: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: pop
    //   3437: aload 12
    //   3439: ldc_w 1048
    //   3442: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3445: pop
    //   3446: aload 12
    //   3448: invokestatic 1051	com/tencent/qqperf/monitor/crash/tools/FdinfoRecordHelper:a	()Ljava/lang/String;
    //   3451: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: pop
    //   3455: aload 12
    //   3457: ldc_w 1053
    //   3460: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: pop
    //   3464: aload 12
    //   3466: invokestatic 1058	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3469: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3472: pop
    //   3473: iconst_1
    //   3474: getstatic 242	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3477: if_icmpne +46 -> 3523
    //   3480: aload_3
    //   3481: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3484: ifne +39 -> 3523
    //   3487: aload_2
    //   3488: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3491: ifne +32 -> 3523
    //   3494: aload_2
    //   3495: ldc 244
    //   3497: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3500: ifeq +23 -> 3523
    //   3503: aload_3
    //   3504: ldc_w 1060
    //   3507: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3510: ifeq +13 -> 3523
    //   3513: aload 12
    //   3515: invokestatic 1064	com/tencent/qqperf/monitor/crash/tools/LooperMessagePrinterHelper:b	(Ljava/lang/StringBuilder;)V
    //   3518: aload 12
    //   3520: invokestatic 1065	com/tencent/qqperf/monitor/crash/tools/LooperMessagePrinterHelper:a	(Ljava/lang/StringBuilder;)V
    //   3523: iload_1
    //   3524: ifeq +39 -> 3563
    //   3527: aload 4
    //   3529: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3532: ifne +31 -> 3563
    //   3535: aload 4
    //   3537: ldc_w 1067
    //   3540: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3543: ifeq +20 -> 3563
    //   3546: aload_2
    //   3547: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3550: ifne +13 -> 3563
    //   3553: aload_2
    //   3554: ldc_w 1069
    //   3557: invokevirtual 1072	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3560: ifne +20 -> 3580
    //   3563: aload_2
    //   3564: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3567: ifne +83 -> 3650
    //   3570: aload_2
    //   3571: ldc_w 577
    //   3574: invokevirtual 247	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3577: ifeq +73 -> 3650
    //   3580: aload 12
    //   3582: ldc_w 1074
    //   3585: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: aload 12
    //   3591: ldc_w 1076
    //   3594: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: pop
    //   3598: aload 12
    //   3600: invokestatic 1079	com/tencent/qqperf/monitor/crash/tools/MemoryInfoRecordHelper:a	()Ljava/lang/String;
    //   3603: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3606: pop
    //   3607: aload 12
    //   3609: ldc_w 1074
    //   3612: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: pop
    //   3616: aload 12
    //   3618: ldc_w 1081
    //   3621: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3624: pop
    //   3625: aload 12
    //   3627: invokestatic 1084	com/tencent/qqperf/monitor/crash/tools/ActivityInfoRecordHelper:a	()Ljava/lang/String;
    //   3630: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: pop
    //   3634: goto +16 -> 3650
    //   3637: astore 4
    //   3639: ldc 122
    //   3641: iconst_1
    //   3642: ldc_w 1086
    //   3645: aload 4
    //   3647: invokestatic 962	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3650: new 194	java/lang/StringBuilder
    //   3653: dup
    //   3654: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3657: astore 4
    //   3659: aload 4
    //   3661: ldc_w 1088
    //   3664: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3667: pop
    //   3668: aload 4
    //   3670: invokestatic 838	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3673: ldc_w 1090
    //   3676: invokestatic 1095	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3679: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3682: pop
    //   3683: aload 12
    //   3685: aload 4
    //   3687: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3690: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: pop
    //   3694: new 194	java/lang/StringBuilder
    //   3697: dup
    //   3698: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3701: astore 4
    //   3703: aload 4
    //   3705: ldc_w 1097
    //   3708: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3711: pop
    //   3712: aload 4
    //   3714: invokestatic 1100	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	()I
    //   3717: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3720: pop
    //   3721: aload 12
    //   3723: aload 4
    //   3725: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3728: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3731: pop
    //   3732: goto +12 -> 3744
    //   3735: aload 12
    //   3737: ldc_w 1102
    //   3740: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: pop
    //   3744: aload_0
    //   3745: aload 12
    //   3747: aload_2
    //   3748: aload_3
    //   3749: invokespecial 1104	com/tencent/qqperf/monitor/crash/QQCrashHandleListener:a	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   3752: new 194	java/lang/StringBuilder
    //   3755: dup
    //   3756: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3759: astore_2
    //   3760: aload_2
    //   3761: ldc_w 1106
    //   3764: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3767: pop
    //   3768: aload_2
    //   3769: aload 12
    //   3771: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3774: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: pop
    //   3778: ldc 122
    //   3780: iconst_1
    //   3781: aload_2
    //   3782: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3785: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3788: invokestatic 1109	com/tencent/qphone/base/util/QLog:flushLog	()V
    //   3791: aload 12
    //   3793: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3796: areturn
    //   3797: astore_2
    //   3798: aload 11
    //   3800: astore_3
    //   3801: aload_3
    //   3802: ifnull +7 -> 3809
    //   3805: aload_3
    //   3806: invokevirtual 574	java/io/FileWriter:close	()V
    //   3809: goto +5 -> 3814
    //   3812: aload_2
    //   3813: athrow
    //   3814: goto -2 -> 3812
    //   3817: astore 10
    //   3819: goto -2672 -> 1147
    //   3822: astore 10
    //   3824: goto -1322 -> 2502
    //   3827: astore 10
    //   3829: goto -1318 -> 2511
    //   3832: astore 10
    //   3834: goto -1217 -> 2617
    //   3837: astore 10
    //   3839: goto -1151 -> 2688
    //   3842: astore 10
    //   3844: goto -665 -> 3179
    //   3847: astore 10
    //   3849: goto -538 -> 3311
    //   3852: astore 4
    //   3854: goto -119 -> 3735
    //   3857: astore_3
    //   3858: goto -49 -> 3809
    //   3861: iconst_0
    //   3862: istore 9
    //   3864: goto -2421 -> 1443
    //   3867: ldc_w 1111
    //   3870: astore 10
    //   3872: goto -1317 -> 2555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3875	0	this	QQCrashHandleListener
    //   0	3875	1	paramBoolean	boolean
    //   0	3875	2	paramString1	String
    //   0	3875	3	paramString2	String
    //   0	3875	4	paramString3	String
    //   0	3875	5	paramInt	int
    //   0	3875	6	paramLong	long
    //   2523	69	8	i	int
    //   763	3100	9	bool	boolean
    //   15	885	10	localObject1	Object
    //   912	3	10	localThrowable1	Throwable
    //   926	2031	10	localObject2	Object
    //   2976	15	10	localThrowable2	Throwable
    //   3050	382	10	localObject3	Object
    //   3817	1	10	localException1	java.lang.Exception
    //   3822	1	10	localThrowable3	Throwable
    //   3827	1	10	localThrowable4	Throwable
    //   3832	1	10	localThrowable5	Throwable
    //   3837	1	10	localThrowable6	Throwable
    //   3842	1	10	localThrowable7	Throwable
    //   3847	1	10	localThrowable8	Throwable
    //   3870	1	10	str1	String
    //   315	3484	11	localObject4	Object
    //   862	261	12	localObject5	Object
    //   1150	1	12	localException2	java.lang.Exception
    //   1162	10	12	localException3	java.lang.Exception
    //   1295	2497	12	localStringBuilder	StringBuilder
    //   3	2723	13	localBaseApplication	BaseApplication
    //   1238	1644	14	str2	String
    //   1825	82	15	arrayOfLong	long[]
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
    //   2804	2892	2976	java/lang/Throwable
    //   2892	2908	2976	java/lang/Throwable
    //   2913	2973	2976	java/lang/Throwable
    //   3527	3563	3637	java/lang/Throwable
    //   3563	3580	3637	java/lang/Throwable
    //   3580	3634	3637	java/lang/Throwable
    //   1030	1042	3797	finally
    //   1046	1067	3797	finally
    //   1071	1080	3797	finally
    //   1084	1091	3797	finally
    //   1095	1104	3797	finally
    //   1108	1116	3797	finally
    //   1120	1130	3797	finally
    //   1134	1139	3797	finally
    //   1171	1176	3797	finally
    //   1139	1144	3817	java/lang/Exception
    //   1297	1424	3822	java/lang/Throwable
    //   1429	1437	3822	java/lang/Throwable
    //   1443	1665	3822	java/lang/Throwable
    //   1665	1719	3822	java/lang/Throwable
    //   1719	1742	3822	java/lang/Throwable
    //   1747	1800	3822	java/lang/Throwable
    //   1800	1845	3822	java/lang/Throwable
    //   1859	1933	3822	java/lang/Throwable
    //   1941	1950	3822	java/lang/Throwable
    //   1950	2090	3822	java/lang/Throwable
    //   2090	2126	3822	java/lang/Throwable
    //   2126	2162	3822	java/lang/Throwable
    //   2162	2198	3822	java/lang/Throwable
    //   2198	2378	3822	java/lang/Throwable
    //   2378	2481	3822	java/lang/Throwable
    //   2481	2502	3822	java/lang/Throwable
    //   2502	2511	3827	java/lang/Throwable
    //   2511	2542	3832	java/lang/Throwable
    //   2555	2617	3832	java/lang/Throwable
    //   2617	2688	3837	java/lang/Throwable
    //   3144	3149	3842	java/lang/Throwable
    //   3154	3179	3842	java/lang/Throwable
    //   3179	3232	3847	java/lang/Throwable
    //   3232	3261	3847	java/lang/Throwable
    //   3261	3290	3847	java/lang/Throwable
    //   3290	3311	3847	java/lang/Throwable
    //   3650	3732	3852	java/lang/Throwable
    //   3805	3809	3857	java/lang/Exception
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("onCrashHandleEnd isNativeCrashed=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", sIsFinalizeTimeoutException=");
    localStringBuilder.append(QQCrashReportManager.jdField_b_of_type_Boolean);
    QLog.d("QQCrashReportManager", 1, localStringBuilder.toString());
    if (QQCrashReportManager.jdField_b_of_type_Boolean)
    {
      QQCrashReportManager.jdField_b_of_type_Boolean = false;
      return true;
    }
    Object localObject2 = MobileQQ.getContext();
    if (paramBoolean) {
      ((Context)localObject2).getSharedPreferences("QQCrashReportManager", 4).edit().putBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", true).commit();
    }
    if ((!paramBoolean) && (SafeModeUtil.a(QQCrashReportManager.jdField_c_of_type_JavaLangString, QQCrashReportManager.d)))
    {
      QQCrashReportManager.jdField_c_of_type_Boolean = true;
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
        QQCrashControlManager.a().b();
        QQCrashControlManager.a().c();
        QQCrashControlManager.a().a(QQCrashReportManager.jdField_c_of_type_JavaLangString, QQCrashReportManager.d);
      }
      boolean bool = ((String)localObject4).endsWith(":qzone");
      if ((bool) || (((String)localObject4).endsWith(":tool")) || (((String)localObject4).endsWith(":peak")))
      {
        QQCrashControlManager.a().b();
        QQCrashControlManager.a().b((String)localObject4);
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
      ((StringBuilder)localObject1).append(QQCrashReportManager.jdField_a_of_type_JavaLangString);
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
        if (QQCrashControlManager.a().a())
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
    localStringBuilder1.append(QQCrashReportManager.jdField_a_of_type_Boolean);
    localStringBuilder1.append(", sIsFinalizeTimeoutException=");
    localStringBuilder1.append(QQCrashReportManager.jdField_b_of_type_Boolean);
    QLog.d("QQCrashReportManager", 1, localStringBuilder1.toString());
    if ((QQCrashReportManager.jdField_a_of_type_Boolean) && (!QQCrashReportManager.jdField_b_of_type_Boolean) && (!SafeModeUtil.a(QQCrashReportManager.jdField_c_of_type_JavaLangString, QQCrashReportManager.d))) {
      Process.killProcess(Process.myPid());
    } else {
      QQCrashReportManager.jdField_a_of_type_Boolean = true;
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
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.a());
      localStringBuilder1.append(",top five were:↓\n--->");
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.a());
      localStringBuilder1.append("\n");
      localStringBuilder1.append("Current mapEvent content is:\n");
      localStringBuilder1.append(ActivityLifeCycleInfoRecordHelper.b());
      ActivityLifeCycleInfoRecordHelper.a();
      QQCrashReportManager.e = localStringBuilder1.toString();
      localStringBuilder1 = QQCrashReportManager.jdField_b_of_type_JavaLangStringBuilder;
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
    QQCrashReportManager.jdField_b_of_type_Boolean = paramBoolean;
    if (QQCrashReportManager.jdField_b_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashHandleListener
 * JD-Core Version:    0.7.0.1
 */