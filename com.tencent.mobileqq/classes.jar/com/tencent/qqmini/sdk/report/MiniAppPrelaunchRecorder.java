package com.tencent.qqmini.sdk.report;

import android.os.SystemClock;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniAppPrelaunchRecorder
{
  private static final String TAG = "MiniAppPrelaunchRecorder";
  private static volatile MiniAppPrelaunchRecorder sInstance;
  private volatile boolean mIsCheckinColdStart = true;
  private volatile long mOnFlutterTaskDoneTime;
  private volatile long mOnMiniAppStartTime;
  private volatile boolean mOnPrelaunch;
  
  private MiniAppPrelaunchRecorder()
  {
    reset();
  }
  
  public static MiniAppPrelaunchRecorder get()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniAppPrelaunchRecorder();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static void release()
  {
    sInstance = null;
  }
  
  private void reset()
  {
    this.mOnPrelaunch = false;
    this.mOnFlutterTaskDoneTime = 0L;
    this.mOnMiniAppStartTime = 0L;
  }
  
  public boolean isCheckinColdStart()
  {
    boolean bool = this.mIsCheckinColdStart;
    if (bool) {
      this.mIsCheckinColdStart = false;
    }
    return bool;
  }
  
  public boolean isPrelaunchSuccess()
  {
    boolean bool;
    if ((this.mOnPrelaunch) && (this.mOnFlutterTaskDoneTime > 0L) && (this.mOnMiniAppStartTime > 0L) && (this.mOnMiniAppStartTime > this.mOnFlutterTaskDoneTime)) {
      bool = true;
    } else {
      bool = false;
    }
    reset();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPrelaunchSuccess ");
      localStringBuilder.append(bool);
      QMLog.i("MiniAppPrelaunchRecorder", localStringBuilder.toString());
    }
    return bool;
  }
  
  public void onFlutterTaskDone()
  {
    if (this.mOnPrelaunch)
    {
      this.mOnFlutterTaskDoneTime = SystemClock.elapsedRealtime();
      if (QMLog.isColorLevel()) {
        QMLog.i("MiniAppPrelaunchRecorder", "onFlutterTaskDone");
      }
    }
  }
  
  public void onMiniAppStart(String paramString)
  {
    if (!"1108164955".equals(paramString)) {
      return;
    }
    if (this.mOnPrelaunch)
    {
      this.mOnMiniAppStartTime = SystemClock.elapsedRealtime();
      if (QMLog.isColorLevel()) {
        QMLog.i("MiniAppPrelaunchRecorder", "onMiniAppStart");
      }
    }
  }
  
  public void onPrelaunch(String paramString)
  {
    if (!"1108164955".equals(paramString)) {
      return;
    }
    this.mOnPrelaunch = true;
    if (QMLog.isColorLevel()) {
      QMLog.i("MiniAppPrelaunchRecorder", "onPrelaunch");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder
 * JD-Core Version:    0.7.0.1
 */