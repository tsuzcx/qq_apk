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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity pause: ");
    localStringBuilder.append(this.mCurrentActivityStr);
    triggerTiming(localStringBuilder.toString());
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
      if (VideoReportInner.getInstance().isDebugMode())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("Intercept duration start timing: ");
        paramActivity.append(this.mCurrentActivityStr);
        Log.d("DetectInterceptorsMonitor", paramActivity.toString());
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
    try
    {
      StringBuilder localStringBuilder;
      if (!this.mIsForeground)
      {
        if (VideoReportInner.getInstance().isDebugMode())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Interrupt intercept duration updating for app is background now, from: ");
          localStringBuilder.append(paramString);
          Log.d("DetectInterceptorsMonitor", localStringBuilder.toString());
        }
        return;
      }
      if (!this.mInterceptState.isIntercept())
      {
        if (VideoReportInner.getInstance().isDebugMode())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Interrupt intercept duration updating for activity not intercept, Activity: ");
          localStringBuilder.append(this.mCurrentActivityStr);
          localStringBuilder.append(", from: ");
          localStringBuilder.append(paramString);
          Log.d("DetectInterceptorsMonitor", localStringBuilder.toString());
        }
        return;
      }
      this.mInterceptDuration += SystemClock.uptimeMillis() - this.mStartTime;
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Intercept duration update: ");
        localStringBuilder.append(this.mInterceptDuration);
        localStringBuilder.append(", from: ");
        localStringBuilder.append(paramString);
        Log.d("DetectInterceptorsMonitor", localStringBuilder.toString());
      }
      resetMonitorTime();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor
 * JD-Core Version:    0.7.0.1
 */