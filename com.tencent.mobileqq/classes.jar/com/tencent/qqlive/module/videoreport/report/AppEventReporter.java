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
import com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import com.tencent.qqlive.module.videoreport.utils.UssnUtils;
import java.util.HashSet;

public class AppEventReporter
  extends DefaultEventListener
{
  private static final int DELAY_CHECK_APP_OUT_INTERVAL = 2000;
  private static final String TAG = "AppEventReporter";
  private String mActiveInfo = "";
  private int mActivityCount = 0;
  private final HashSet<Integer> mActivityHashCode = new HashSet();
  private String mActivityName = "";
  private boolean mAppForegroundReported = false;
  private AppForegroundSession mAppForegroundSession;
  private Runnable mAppInReportRunnable = new AppEventReporter.1(this);
  private Runnable mAppOutDelayCheckRunnable = new AppEventReporter.2(this);
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
  private int mResumedCount = 0;
  private long mScheduleAppOutStamp = 0L;
  private final ListenerMgr<ISessionChangeListener> mSessionChangeListener = new ListenerMgr();
  private String mUsId = "";
  private long mUsStamp = System.currentTimeMillis();
  private long mUssn = 0L;
  
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
      this.mListenerMgr.startNotify(new AppEventReporter.4(this));
    }
  }
  
  private void appOutDataSender(boolean paramBoolean)
  {
    if (this.mAppForegroundReported)
    {
      this.mAppForegroundReported = false;
      this.mNoForegroundActivity = true;
      this.mLastGenerateTime = SystemClock.uptimeMillis();
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("AppEventReporter", "appOutDataSender: 后台上报");
      }
      long l;
      if (paramBoolean) {
        l = SystemClock.uptimeMillis() - this.mScheduleAppOutStamp;
      } else {
        l = 0L;
      }
      stopAppForegroundSession(l);
      this.mListenerMgr.startNotify(new AppEventReporter.5(this));
    }
  }
  
  private void appStartDataSender(Activity paramActivity)
  {
    if (this.mNoForegroundActivity) {
      if (isExceedVisitBackgroundTime())
      {
        SessionChangeReason localSessionChangeReason;
        if (this.mLastGenerateTime > 0L) {
          localSessionChangeReason = SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT;
        } else {
          localSessionChangeReason = SessionChangeReason.APP_START_UP;
        }
        updateAppEventParams(paramActivity);
        onAppVisit(localSessionChangeReason);
      }
      else if (isVstAdditionalReport())
      {
        updateAppEventParams(paramActivity);
        onAppVisit(SessionChangeReason.ADDITIONAL_SESSION_REENTER_FOREGROUND);
      }
    }
    this.mNoForegroundActivity = false;
    if ((!this.mHasVstReport) && (!interceptAppEvent(paramActivity, "report visit")))
    {
      updateAppEventParams(paramActivity);
      reportVst("vst");
      this.mHasVstReport = true;
    }
  }
  
  private void cancelDelayCheckAppOut()
  {
    ThreadUtils.removeOnUiThread(this.mAppOutDelayCheckRunnable);
  }
  
  private void doActReport(Activity paramActivity)
  {
    try
    {
      if (!this.mFirstActivityResumed)
      {
        this.mFirstActivityResumed = true;
        this.mIsActive = isDeviceActivated();
      }
      boolean bool = this.mIsActive;
      if (bool) {
        return;
      }
      bool = interceptAppEvent(paramActivity, "report active");
      if (bool) {
        return;
      }
      setDeviceActivated();
      appActivatedDataSender();
      this.mIsActive = true;
      return;
    }
    finally {}
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
    return AppEventReporter.InstanceHolder.access$300();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private boolean interceptAppEvent(Activity paramActivity, String paramString)
  {
    boolean bool = DetectionInterceptors.ignoreAppEvent(paramActivity);
    if ((bool) && (VideoReportInner.getInstance().isDebugMode()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("interceptAppEvent: activity intercepted, from = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", activity = ");
      localStringBuilder.append(paramActivity);
      Log.d("AppEventReporter", localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean isDeviceActivated()
  {
    Object localObject = ReportUtils.getContext();
    boolean bool1 = false;
    if (localObject != null)
    {
      boolean bool2 = ((Boolean)SPUtils.get(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(false))).booleanValue();
      bool1 = bool2;
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isDeviceActivated:");
        ((StringBuilder)localObject).append(this.mIsActive);
        Log.i("AppEventReporter", ((StringBuilder)localObject).toString());
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
    IAdditionalReportListener localIAdditionalReportListener = this.mEventAdditionalReport;
    return (localIAdditionalReportListener != null) && (localIAdditionalReportListener.shouldAdditionalReport("origin_vst"));
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
    ThreadUtils.runOnUiThread(new AppEventReporter.7(this));
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
  
  private void scheduleDelayCheckAppOut()
  {
    this.mScheduleAppOutStamp = SystemClock.uptimeMillis();
    ThreadUtils.runOnUiThreadDelay(this.mAppOutDelayCheckRunnable, 2000L);
  }
  
  private void setDeviceActivated()
  {
    if (ReportUtils.getContext() != null) {
      SPUtils.put(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(true));
    }
  }
  
  private void startAppForegroundSession()
  {
    AppForegroundSession localAppForegroundSession = this.mAppForegroundSession;
    if (localAppForegroundSession == null) {
      this.mAppForegroundSession = new AppForegroundSession(this.mInterceptorMonitor);
    } else {
      localAppForegroundSession.reset();
    }
    this.mAppForegroundSession.start();
  }
  
  private void stopAppForegroundSession(long paramLong)
  {
    ThreadUtils.removeOnUiThread(this.mAppInReportRunnable);
    AppForegroundSession localAppForegroundSession = this.mAppForegroundSession;
    if (localAppForegroundSession != null) {
      localAppForegroundSession.stopToReport(paramLong);
    }
  }
  
  private void updateAppEventParams(Activity paramActivity)
  {
    if (DTEventDynamicParams.getInstance().getDTParamProvider() != null) {
      this.mActiveInfo = DTEventDynamicParams.getInstance().getDTParamProvider().getActiveInfo();
    }
    this.mActivityName = getActivityName(paramActivity);
  }
  
  public void appOutDataSender()
  {
    appOutDataSender(false);
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
  
  long getUssn()
  {
    return this.mUssn;
  }
  
  public boolean isAppInForeground()
  {
    return this.mNoForegroundActivity ^ true;
  }
  
  boolean isColdStart()
  {
    return this.mIsColdStart;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    super.onActivityCreate(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityCreate: activity=");
      localStringBuilder.append(paramActivity);
      Log.d("AppEventReporter", localStringBuilder.toString());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: activity=");
      localStringBuilder.append(paramActivity);
      Log.d("AppEventReporter", localStringBuilder.toString());
    }
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    super.onActivityPause(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPause: activity=");
      localStringBuilder.append(paramActivity);
      Log.d("AppEventReporter", localStringBuilder.toString());
    }
    this.mResumedCount -= 1;
    scheduleDelayCheckAppOut();
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResume: activity=");
      localStringBuilder.append(paramActivity);
      Log.i("AppEventReporter", localStringBuilder.toString());
    }
    this.mResumedCount += 1;
    appStartDataSender(paramActivity);
    appInDataSender();
    CustomEventStagingManager.getInstance().supplementReportsEvent();
    if (!this.mLastHeartBeatReport)
    {
      this.mLastHeartBeatReport = true;
      reportAppLastHeartBeat();
    }
    ThreadUtils.execTask(new AppEventReporter.3(this, paramActivity));
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStarted: activity=");
      localStringBuilder.append(paramActivity);
      Log.i("AppEventReporter", localStringBuilder.toString());
    }
    this.mActivityCount += 1;
    this.mActivityHashCode.add(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Object localObject;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityStopped: activity=");
      ((StringBuilder)localObject).append(paramActivity);
      Log.i("AppEventReporter", ((StringBuilder)localObject).toString());
    }
    if (!this.mActivityHashCode.remove(Integer.valueOf(paramActivity.hashCode())))
    {
      localObject = paramActivity.getApplicationContext().getString(2131693626, new Object[] { paramActivity.toString() });
      if (VideoReportInner.getInstance().isDebugMode()) {
        Toast.makeText(paramActivity.getApplicationContext(), (CharSequence)localObject, 1).show();
      }
      Log.e("AppEventReporter", (String)localObject);
      return;
    }
    this.mActivityCount -= 1;
    if (this.mActivityCount <= 0) {
      appOutDataSender();
    }
    cancelDelayCheckAppOut();
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
    SessionChangeReason localSessionChangeReason = SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT;
    boolean bool = false;
    if ((paramSessionChangeReason == localSessionChangeReason) && (this.mIsNeedInterceptForegroundSession))
    {
      this.mIsNeedInterceptForegroundSession = false;
      return;
    }
    if ((paramSessionChangeReason == SessionChangeReason.CALL_UP_FROM_OUTER) && (this.mLastGenerateTime > 0L) && (isExceedVisitBackgroundTime())) {
      this.mIsNeedInterceptForegroundSession = true;
    }
    if ((paramSessionChangeReason == SessionChangeReason.APP_START_UP) && (!TextUtils.isEmpty(this.mUsId))) {
      return;
    }
    this.mUsId = ReportUtils.generateSessionId();
    this.mUsStamp = System.currentTimeMillis();
    this.mUssn = UssnUtils.generateUssn();
    if (paramSessionChangeReason == SessionChangeReason.APP_START_UP) {
      bool = true;
    }
    this.mIsColdStart = bool;
    this.mSessionChangeListener.startNotify(new AppEventReporter.6(this, paramSessionChangeReason));
  }
  
  public void unregister(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    this.mListenerMgr.unregister(paramIAppEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter
 * JD-Core Version:    0.7.0.1
 */