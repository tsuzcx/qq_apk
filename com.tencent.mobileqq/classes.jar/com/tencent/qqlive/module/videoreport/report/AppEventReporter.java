package com.tencent.qqlive.module.videoreport.report;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor;
import com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.HashSet;

public class AppEventReporter
  extends DefaultEventListener
{
  private static final String TAG = "AppEventReporter";
  private String mActiveInfo = "";
  private int mActivityCount = 0;
  private final HashSet<Integer> mActivityHashCode = new HashSet();
  private String mActivityName = "";
  private boolean mAppForegroundReported = false;
  private AppForegroundSession mAppForegroundSession;
  private Runnable mAppInReportRunnable = new AppEventReporter.1(this);
  private IAdditionalReportListener mEventAdditionalReport;
  private boolean mFirstActivityResumed = false;
  private boolean mHasVstReport;
  private DetectInterceptorsMonitor mInterceptorMonitor = new DetectInterceptorsMonitor();
  private boolean mIsActive;
  private boolean mIsColdStart = true;
  private boolean mIsNeedInterceptForegroundSession = false;
  private long mLastGenerateTime = -1L;
  private boolean mLastHeartBeatReport = false;
  private final ListenerMgr<AppEventReporter.IAppEventListener> mListenerMgr = new ListenerMgr();
  private boolean mNoForegroundActivity = true;
  private final ListenerMgr<ISessionChangeListener> mSessionChangeListener = new ListenerMgr();
  private String mUsId = "";
  private long mUsStamp = System.currentTimeMillis();
  
  private void appActivatedDataSender()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "appActivatedDataSender: 激活上报");
    }
    FinalData localFinalData = getFinalData("act");
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("act", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  private void appInDataSender()
  {
    if (!this.mAppForegroundReported)
    {
      this.mAppForegroundReported = true;
      ThreadUtils.execTask(this.mAppInReportRunnable, true);
      this.mListenerMgr.startNotify(new AppEventReporter.3(this));
    }
  }
  
  private void appStartDataSender(Activity paramActivity)
  {
    SessionChangeReason localSessionChangeReason;
    if (this.mNoForegroundActivity)
    {
      if (!isExceedVisitBackgroundTime()) {
        break label83;
      }
      if (this.mLastGenerateTime <= 0L) {
        break label76;
      }
      localSessionChangeReason = SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT;
      updateAppEventParams(paramActivity);
      onAppVisit(localSessionChangeReason);
    }
    for (;;)
    {
      this.mNoForegroundActivity = false;
      if ((!this.mHasVstReport) && (!interceptAppEvent(paramActivity, "report visit")))
      {
        updateAppEventParams(paramActivity);
        reportVst("vst");
        this.mHasVstReport = true;
      }
      return;
      label76:
      localSessionChangeReason = SessionChangeReason.APP_START_UP;
      break;
      label83:
      if (isVstAdditionalReport())
      {
        updateAppEventParams(paramActivity);
        onAppVisit(SessionChangeReason.ADDITIONAL_SESSION_REENTER_FOREGROUND);
      }
    }
  }
  
  /* Error */
  private void doActReport(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/qqlive/module/videoreport/report/AppEventReporter:mFirstActivityResumed	Z
    //   6: ifne +16 -> 22
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 57	com/tencent/qqlive/module/videoreport/report/AppEventReporter:mFirstActivityResumed	Z
    //   14: aload_0
    //   15: aload_0
    //   16: invokespecial 228	com/tencent/qqlive/module/videoreport/report/AppEventReporter:isDeviceActivated	()Z
    //   19: putfield 230	com/tencent/qqlive/module/videoreport/report/AppEventReporter:mIsActive	Z
    //   22: aload_0
    //   23: getfield 230	com/tencent/qqlive/module/videoreport/report/AppEventReporter:mIsActive	Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: aload_1
    //   36: ldc 232
    //   38: invokespecial 210	com/tencent/qqlive/module/videoreport/report/AppEventReporter:interceptAppEvent	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   41: ifne -10 -> 31
    //   44: aload_0
    //   45: invokespecial 235	com/tencent/qqlive/module/videoreport/report/AppEventReporter:setDeviceActivated	()V
    //   48: aload_0
    //   49: invokespecial 237	com/tencent/qqlive/module/videoreport/report/AppEventReporter:appActivatedDataSender	()V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 230	com/tencent/qqlive/module/videoreport/report/AppEventReporter:mIsActive	Z
    //   57: goto -26 -> 31
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	AppEventReporter
    //   0	65	1	paramActivity	Activity
    //   26	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	60	finally
    //   22	27	60	finally
    //   34	57	60	finally
  }
  
  private String getActivityName(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "";
    }
    return paramActivity.getClass().getCanonicalName();
  }
  
  private FinalData getFinalData(String paramString)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.put("dt_activity_name", getActivityName());
    localFinalData.put("dt_active_info", getActiveInfo());
    localFinalData.setEventKey(paramString);
    return localFinalData;
  }
  
  public static AppEventReporter getInstance()
  {
    return AppEventReporter.InstanceHolder.access$100();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private boolean interceptAppEvent(Activity paramActivity, String paramString)
  {
    boolean bool = DetectionInterceptors.ignoreAppEvent(paramActivity);
    if ((bool) && (VideoReportInner.getInstance().isDebugMode())) {
      Log.d("AppEventReporter", "interceptAppEvent: activity intercepted, from = " + paramString + ", activity = " + paramActivity);
    }
    return bool;
  }
  
  private boolean isDeviceActivated()
  {
    boolean bool1 = false;
    if (ReportUtils.getContext() != null)
    {
      boolean bool2 = ((Boolean)SPUtils.get(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(false))).booleanValue();
      bool1 = bool2;
      if (VideoReportInner.getInstance().isDebugMode())
      {
        Log.i("AppEventReporter", "isDeviceActivated:" + this.mIsActive);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private boolean isExceedVisitBackgroundTime()
  {
    return SystemClock.uptimeMillis() > this.mLastGenerateTime + VideoReportInner.getInstance().getConfiguration().getVisitBackgroundTime();
  }
  
  private boolean isVstAdditionalReport()
  {
    return (this.mEventAdditionalReport != null) && (this.mEventAdditionalReport.shouldAdditionalReport("origin_vst"));
  }
  
  private void onAppVisit(SessionChangeReason paramSessionChangeReason)
  {
    startNewSession(paramSessionChangeReason);
    this.mHasVstReport = false;
    PageManager.getInstance().resetPagePath();
    reportVst("origin_vst");
  }
  
  private void reportAppLastHeartBeat()
  {
    ThreadUtils.runOnUiThread(new AppEventReporter.6(this));
  }
  
  private void reportVst(String paramString)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "appStartDataSender: 启动上报");
    }
    FinalData localFinalData = getFinalData(paramString);
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams(paramString, localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  private void setDeviceActivated()
  {
    if (ReportUtils.getContext() != null) {
      SPUtils.put(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(true));
    }
  }
  
  private void startAppForegroundSession()
  {
    if (this.mAppForegroundSession == null) {
      this.mAppForegroundSession = new AppForegroundSession(this.mInterceptorMonitor);
    }
    for (;;)
    {
      this.mAppForegroundSession.start();
      return;
      this.mAppForegroundSession.reset();
    }
  }
  
  private void stopAppForegroundSession(boolean paramBoolean)
  {
    ThreadUtils.removeOnUiThread(this.mAppInReportRunnable);
    if (this.mAppForegroundSession != null) {
      this.mAppForegroundSession.stop(paramBoolean);
    }
  }
  
  private void updateAppEventParams(Activity paramActivity)
  {
    if (DTEventDynamicParams.getInstance().getDTParamProvider() != null) {
      this.mActiveInfo = DTEventDynamicParams.getInstance().getDTParamProvider().getActiveInfo();
    }
    this.mActivityName = getActivityName(paramActivity);
  }
  
  public void appOutDataSender(boolean paramBoolean)
  {
    if (this.mAppForegroundReported)
    {
      this.mAppForegroundReported = false;
      this.mNoForegroundActivity = true;
      this.mLastGenerateTime = SystemClock.uptimeMillis();
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("AppEventReporter", "appOutDataSender: 后台上报");
      }
      stopAppForegroundSession(paramBoolean);
      this.mListenerMgr.startNotify(new AppEventReporter.4(this, paramBoolean));
    }
  }
  
  public String getActiveInfo()
  {
    return this.mActiveInfo;
  }
  
  public String getActivityName()
  {
    return this.mActivityName;
  }
  
  String getUsId()
  {
    return this.mUsId;
  }
  
  long getUsStamp()
  {
    return this.mUsStamp;
  }
  
  public boolean isAppInForeground()
  {
    return !this.mNoForegroundActivity;
  }
  
  boolean isColdStart()
  {
    return this.mIsColdStart;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    super.onActivityCreate(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityCreate: activity=" + paramActivity);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityDestroyed: activity=" + paramActivity);
    }
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    super.onActivityPause(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityPause: activity=" + paramActivity);
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityResume: activity=" + paramActivity);
    }
    appStartDataSender(paramActivity);
    appInDataSender();
    if (!this.mLastHeartBeatReport)
    {
      this.mLastHeartBeatReport = true;
      reportAppLastHeartBeat();
    }
    ThreadUtils.execTask(new AppEventReporter.2(this, paramActivity));
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityStarted: activity=" + paramActivity);
    }
    this.mActivityCount += 1;
    this.mActivityHashCode.add(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityStopped: activity=" + paramActivity);
    }
    if (!this.mActivityHashCode.remove(Integer.valueOf(paramActivity.hashCode())))
    {
      String str = paramActivity.getApplicationContext().getString(2131693517, new Object[] { paramActivity.toString() });
      if (VideoReportInner.getInstance().isDebugMode()) {
        Toast.makeText(paramActivity.getApplicationContext(), str, 1).show();
      }
      Log.e("AppEventReporter", str);
    }
    do
    {
      return;
      this.mActivityCount -= 1;
    } while (this.mActivityCount > 0);
    appOutDataSender(false);
  }
  
  public void register(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    this.mListenerMgr.register(paramIAppEventListener);
  }
  
  public void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    this.mSessionChangeListener.register(paramISessionChangeListener);
  }
  
  public void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    this.mEventAdditionalReport = paramIAdditionalReportListener;
  }
  
  public void startNewSession(SessionChangeReason paramSessionChangeReason)
  {
    boolean bool = true;
    if ((paramSessionChangeReason == SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT) && (this.mIsNeedInterceptForegroundSession)) {
      this.mIsNeedInterceptForegroundSession = false;
    }
    do
    {
      return;
      if ((paramSessionChangeReason == SessionChangeReason.CALL_UP_FROM_OUTER) && (this.mLastGenerateTime > 0L) && (isExceedVisitBackgroundTime())) {
        this.mIsNeedInterceptForegroundSession = true;
      }
    } while ((paramSessionChangeReason == SessionChangeReason.APP_START_UP) && (!TextUtils.isEmpty(this.mUsId)));
    this.mUsId = ReportUtils.generateSessionId();
    this.mUsStamp = System.currentTimeMillis();
    if (paramSessionChangeReason == SessionChangeReason.APP_START_UP) {}
    for (;;)
    {
      this.mIsColdStart = bool;
      this.mSessionChangeListener.startNotify(new AppEventReporter.5(this, paramSessionChangeReason));
      return;
      bool = false;
    }
  }
  
  public void unregister(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    this.mListenerMgr.unregister(paramIAppEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter
 * JD-Core Version:    0.7.0.1
 */