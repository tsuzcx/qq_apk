package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;

class DetectInterceptorsMonitor$ActivityInterceptStateMachine
{
  private boolean mIsActivityIntercept;
  private boolean mIsLastActivityIntercept;
  @DetectInterceptorsMonitor.ActivityInterceptState
  private int mState = 0;
  
  @DetectInterceptorsMonitor.ActivityInterceptState
  public int getState()
  {
    return this.mState;
  }
  
  public boolean isIntercept()
  {
    return this.mState != 0;
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    this.mIsLastActivityIntercept = this.mIsActivityIntercept;
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.mIsActivityIntercept = DetectionInterceptors.ignoreAppEvent(paramActivity);
    if (!this.mIsActivityIntercept)
    {
      this.mState = 0;
      return;
    }
    if (!this.mIsLastActivityIntercept)
    {
      this.mState = 2;
      return;
    }
    this.mState = 1;
  }
  
  public void onAppOut()
  {
    this.mIsLastActivityIntercept = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor.ActivityInterceptStateMachine
 * JD-Core Version:    0.7.0.1
 */