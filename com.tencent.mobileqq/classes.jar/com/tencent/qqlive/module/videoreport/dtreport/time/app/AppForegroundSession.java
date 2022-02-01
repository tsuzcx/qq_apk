package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.PageReporter;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Map;

public class AppForegroundSession
  implements ITimeProcessor
{
  private static final long DEFAULT_HEART_BEAT_INTERVAL = 60000L;
  private static final long DEFAULT_TIME_PIN_INTERVAL = 5000L;
  private static final long MIN_TIME_PIN_INTERVAL = 5000L;
  private String mAppSessionId;
  private long mAppStartTime;
  private HeartBeatProcessor mCurrentHeartBeatProcessor;
  private long mForegroundDuration;
  private long mHeartBeatInterval = VideoReportInner.getInstance().getConfiguration().getAppTimeReportHeartBeatInterval() * 1000;
  private String mHeartBeatTaskKey;
  private long mInterceptDuration = 0L;
  private DetectInterceptorsMonitor mInterceptorMonitor;
  private int mProcessorState = -1;
  private long mTimePinInterval = VideoReportInner.getInstance().getConfiguration().getAppTimeReportTimePinInterval() * 1000;
  
  public AppForegroundSession(DetectInterceptorsMonitor paramDetectInterceptorsMonitor)
  {
    this.mInterceptorMonitor = paramDetectInterceptorsMonitor;
    initHeartBeatProcessor();
    reset();
  }
  
  private long getHeartBeatInterval()
  {
    return this.mHeartBeatInterval;
  }
  
  private long getTimePinInterval()
  {
    return this.mTimePinInterval;
  }
  
  private void initHeartBeatProcessor()
  {
    if (this.mHeartBeatInterval <= 0L) {
      this.mHeartBeatInterval = 60000L;
    }
    if (this.mTimePinInterval <= 0L) {
      this.mTimePinInterval = 5000L;
    }
    if (this.mTimePinInterval < 5000L) {
      this.mTimePinInterval = 5000L;
    }
    long l = this.mTimePinInterval;
    if (l > this.mHeartBeatInterval) {
      this.mHeartBeatInterval = l;
    }
    this.mCurrentHeartBeatProcessor = new HeartBeatProcessor(true, this.mTimePinInterval);
    this.mCurrentHeartBeatProcessor.setHeartBeatCallback(new AppForegroundSession.2(this));
  }
  
  private void reportAppIn()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("appin");
    localFinalData.put("dt_app_starttime", Long.valueOf(System.currentTimeMillis()));
    localFinalData.put("dt_sys_elapsed_realtime", Long.valueOf(SystemClock.elapsedRealtime()));
    localFinalData.put("dt_app_heartbeat_interval", Long.valueOf(getHeartBeatInterval() / 1000L));
    localFinalData.put("dt_app_file_interval", Long.valueOf(getTimePinInterval() / 1000L));
    localFinalData.put("dt_app_sessionid", getAppSessionId());
    localFinalData.put("dt_activity_name", AppEventReporter.getInstance().getActivityName());
    localFinalData.put("dt_active_info", AppEventReporter.getInstance().getActiveInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("appin", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  private void reportAppOut(long paramLong)
  {
    long l1 = SystemClock.uptimeMillis() - this.mAppStartTime - paramLong;
    long l2 = this.mInterceptorMonitor.getInterceptDuration();
    long l3 = this.mInterceptDuration;
    this.mInterceptorMonitor.onAppOut(false);
    Object localObject = this.mInterceptorMonitor.getInterceptActivities();
    this.mInterceptorMonitor.clearInterceptActivities();
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("appout");
    localFinalData.put("lvtm", Long.valueOf(l1));
    localFinalData.put("dt_white_lvtm", Long.valueOf(l1 - l2 + l3));
    localFinalData.put("dt_activity_blacklist", localObject);
    localFinalData.put("dt_lvtm_delta", Long.valueOf(paramLong));
    localFinalData.put("dt_app_stoptime", Long.valueOf(System.currentTimeMillis() - paramLong));
    localFinalData.put("dt_sys_elapsed_realtime", Long.valueOf(SystemClock.elapsedRealtime() - paramLong));
    localFinalData.put("dt_app_sessionid", getAppSessionId());
    localFinalData.put("dt_app_foreground_duration", Long.valueOf(getForegroundDuration() - paramLong));
    localFinalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo("appout"));
    localFinalData.put("dt_activity_name", AppEventReporter.getInstance().getActivityName());
    localFinalData.put("dt_active_info", AppEventReporter.getInstance().getActiveInfo());
    localObject = VideoReportInner.getInstance().getEventDynamicParams();
    if (localObject != null) {
      ((IEventDynamicParams)localObject).setEventDynamicParams("appout", localFinalData.getEventParams());
    }
    FinalDataTarget.handleInMainThread(null, localFinalData);
  }
  
  private static void reportHeartBeat(Map<String, Object> paramMap)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_app_heartbeat");
    localFinalData.putAll(paramMap);
    paramMap = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramMap != null) {
      paramMap.setEventDynamicParams("dt_app_heartbeat", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  public static void reportLastHeartBeat(String paramString)
  {
    ThreadUtils.execTask(new AppForegroundSession.3(paramString));
  }
  
  private void stopToReport()
  {
    stopToReport(0L);
  }
  
  private void triggerTiming()
  {
    try
    {
      this.mCurrentHeartBeatProcessor.stop();
      this.mForegroundDuration += this.mCurrentHeartBeatProcessor.getForegroundDuration();
      this.mCurrentHeartBeatProcessor.reset();
      if (this.mProcessorState == 0) {
        this.mCurrentHeartBeatProcessor.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getAppSessionId()
  {
    return this.mAppSessionId;
  }
  
  public long getBackgroundDuration()
  {
    return 0L;
  }
  
  public long getForegroundDuration()
  {
    try
    {
      long l = this.mForegroundDuration;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mProcessorState == 0) {
        stopToReport();
      }
      this.mProcessorState = -1;
      this.mAppSessionId = ReportUtils.generateSessionId();
      this.mForegroundDuration = 0L;
      this.mHeartBeatTaskKey = null;
      this.mCurrentHeartBeatProcessor.reset();
      this.mCurrentHeartBeatProcessor.setSessionId(this.mAppSessionId);
      return;
    }
    finally {}
  }
  
  public void setInForeground(boolean paramBoolean) {}
  
  public void start()
  {
    try
    {
      if (this.mProcessorState == 0) {
        stopToReport();
      }
      this.mProcessorState = 0;
      this.mAppStartTime = SystemClock.uptimeMillis();
      this.mInterceptorMonitor.onAppIn();
      this.mInterceptDuration = this.mInterceptorMonitor.getInterceptDuration();
      this.mHeartBeatTaskKey = TimerTaskManager.getInstance().addUIThreadTimerTask(new AppForegroundSession.1(this), this.mHeartBeatInterval, this.mHeartBeatInterval);
      this.mCurrentHeartBeatProcessor.start();
      reportAppIn();
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      if (this.mProcessorState == 0)
      {
        this.mProcessorState = 1;
        TimerTaskManager.getInstance().cancelTimerTask(this.mHeartBeatTaskKey);
        this.mHeartBeatTaskKey = null;
        triggerTiming();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stopToReport(long paramLong)
  {
    try
    {
      if (this.mProcessorState == 0)
      {
        stop();
        reportAppOut(paramLong);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession
 * JD-Core Version:    0.7.0.1
 */