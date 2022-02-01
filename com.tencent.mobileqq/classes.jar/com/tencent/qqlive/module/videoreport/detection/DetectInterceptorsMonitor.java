package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundInterceptActivities;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;

public class DetectInterceptorsMonitor
  extends DefaultEventListener
  implements AppEventReporter.IAppEventListener
{
  private static final String TAG = "DetectInterceptorsMonitor";
  private String mCurrentActivityStr;
  private AppForegroundInterceptActivities mInterceptActivities = new AppForegroundInterceptActivities();
  private long mInterceptDuration = 0L;
  private DetectInterceptorsMonitor.ActivityInterceptStateMachine mInterceptState = new DetectInterceptorsMonitor.ActivityInterceptStateMachine();
  private boolean mIsForeground;
  private long mStartTime = 0L;
  
  public DetectInterceptorsMonitor()
  {
    init();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private void resetMonitorTime()
  {
    this.mStartTime = SystemClock.uptimeMillis();
  }
  
  public void clearInterceptActivities()
  {
    this.mInterceptActivities.clear();
  }
  
  public String getInterceptActivities()
  {
    return this.mInterceptActivities.get();
  }
  
  public long getInterceptDuration()
  {
    triggerTiming("inquire");
    return this.mInterceptDuration;
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    triggerTiming("activity pause: " + this.mCurrentActivityStr);
    this.mInterceptState.onActivityPause(paramActivity);
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.mCurrentActivityStr = paramActivity.getClass().getCanonicalName();
    this.mInterceptState.onActivityResume(paramActivity);
    if (this.mInterceptState.isIntercept())
    {
      if (2 == this.mInterceptState.getState()) {
        resetMonitorTime();
      }
      this.mInterceptActivities.onIntercept(paramActivity);
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("DetectInterceptorsMonitor", "Intercept duration start timing: " + this.mCurrentActivityStr);
      }
    }
  }
  
  public void onAppIn()
  {
    this.mIsForeground = true;
    resetMonitorTime();
  }
  
  public void onAppOut(boolean paramBoolean)
  {
    triggerTiming("app out");
    this.mInterceptState.onAppOut();
    this.mIsForeground = false;
  }
  
  void triggerTiming(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!this.mIsForeground)
        {
          if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d("DetectInterceptorsMonitor", "Interrupt intercept duration updating for app is background now, from: " + paramString);
          }
          return;
        }
        if (!this.mInterceptState.isIntercept())
        {
          if (!VideoReportInner.getInstance().isDebugMode()) {
            continue;
          }
          Log.d("DetectInterceptorsMonitor", "Interrupt intercept duration updating for activity not intercept, Activity: " + this.mCurrentActivityStr + ", from: " + paramString);
          continue;
        }
        this.mInterceptDuration += SystemClock.uptimeMillis() - this.mStartTime;
      }
      finally {}
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("DetectInterceptorsMonitor", "Intercept duration update: " + this.mInterceptDuration + ", from: " + paramString);
      }
      resetMonitorTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor
 * JD-Core Version:    0.7.0.1
 */