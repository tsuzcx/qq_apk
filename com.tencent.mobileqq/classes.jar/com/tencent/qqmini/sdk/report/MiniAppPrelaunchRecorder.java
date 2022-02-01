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
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniAppPrelaunchRecorder();
      }
      return sInstance;
    }
    finally {}
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOnPrelaunch)
    {
      bool1 = bool2;
      if (this.mOnFlutterTaskDoneTime > 0L)
      {
        bool1 = bool2;
        if (this.mOnMiniAppStartTime > 0L)
        {
          bool1 = bool2;
          if (this.mOnMiniAppStartTime > this.mOnFlutterTaskDoneTime) {
            bool1 = true;
          }
        }
      }
    }
    reset();
    if (QMLog.isColorLevel()) {
      QMLog.i("MiniAppPrelaunchRecorder", "isPrelaunchSuccess " + bool1);
    }
    return bool1;
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
    if (!"1108164955".equals(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.mOnPrelaunch);
      this.mOnMiniAppStartTime = SystemClock.elapsedRealtime();
    } while (!QMLog.isColorLevel());
    QMLog.i("MiniAppPrelaunchRecorder", "onMiniAppStart");
  }
  
  public void onPrelaunch(String paramString)
  {
    if (!"1108164955".equals(paramString)) {}
    do
    {
      return;
      this.mOnPrelaunch = true;
    } while (!QMLog.isColorLevel());
    QMLog.i("MiniAppPrelaunchRecorder", "onPrelaunch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder
 * JD-Core Version:    0.7.0.1
 */