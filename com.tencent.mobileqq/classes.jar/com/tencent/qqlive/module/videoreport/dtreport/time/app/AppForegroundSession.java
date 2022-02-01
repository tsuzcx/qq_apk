package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
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
  private int mProcessorState = -1;
  private long mTimePinInterval = VideoReportInner.getInstance().getConfiguration().getAppTimeReportTimePinInterval() * 1000;
  
  public AppForegroundSession()
  {
    initHeartBeatProcessor();
    reset();
  }
  
  private String getAppSessionId()
  {
    return this.mAppSessionId;
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
    if (this.mTimePinInterval > this.mHeartBeatInterval) {
      this.mHeartBeatInterval = this.mTimePinInterval;
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
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("appin", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  private void reportAppOut(boolean paramBoolean)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("appout");
    localFinalData.put("lvtm", Long.valueOf(SystemClock.uptimeMillis() - this.mAppStartTime));
    localFinalData.put("dt_app_stoptime", Long.valueOf(System.currentTimeMillis()));
    localFinalData.put("dt_sys_elapsed_realtime", Long.valueOf(SystemClock.elapsedRealtime()));
    localFinalData.put("dt_app_sessionid", getAppSessionId());
    localFinalData.put("dt_app_foreground_duration", Long.valueOf(getForegroundDuration()));
    localFinalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("appout", localFinalData.getEventParams());
    }
    if (paramBoolean)
    {
      FinalDataTarget.handleInMainThread(null, localFinalData);
      return;
    }
    FinalDataTarget.handle(null, localFinalData);
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
    ThreadUtils.execTask(new AppForegroundSession.3());
  }
  
  public static void reportLastHeartBeat()
  {
    Map localMap = AppHeartBeatSpUtils.getLastHeartBeat();
    if (localMap == null) {
      return;
    }
    reportHeartBeat(localMap);
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
        stop(true);
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
        stop(true);
      }
      this.mProcessorState = 0;
      this.mAppStartTime = SystemClock.uptimeMillis();
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
  
  public void stop(boolean paramBoolean)
  {
    try
    {
      stop();
      reportAppOut(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession
 * JD-Core Version:    0.7.0.1
 */