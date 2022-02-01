package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class FPSCalculator
{
  private static final int CALL_INTERVAL = 500;
  private static final String TAG = "FPSCalculator";
  private static volatile FPSCalculator sInstance;
  private Choreographer mChoreographer;
  private boolean mEnable = false;
  private Choreographer.FrameCallback mFPSMeasuringCallback;
  private Runnable mFakeFPSRunnable = new FPSCalculator.2(this);
  private long mFrameStartTime = 0L;
  private int mFramesRendered = 0;
  private Handler mHandler;
  private Runnable mInitFPSRunnable = new FPSCalculator.1(this);
  private Vector<FPSCalculator.GetFPSListener> mListener = new Vector();
  private Object mLock = new Object();
  
  private void disable()
  {
    if (this.mEnable)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Choreographer localChoreographer = this.mChoreographer;
        if (localChoreographer != null)
        {
          localChoreographer.removeFrameCallback(this.mFPSMeasuringCallback);
          if (QMLog.isColorLevel()) {
            QMLog.d("FPSCalculator", "removeFrameCallback ");
          }
        }
        this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      else
      {
        this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      this.mFrameStartTime = 0L;
      this.mFramesRendered = 0;
      this.mEnable = false;
      QMLog.d("FPSCalculator", "FPSCalculator set enable = false");
    }
  }
  
  private void doOnFrame(long paramLong)
  {
    paramLong = nsToMs(paramLong);
    long l = this.mFrameStartTime;
    if (l <= 0L)
    {
      this.mFrameStartTime = paramLong;
    }
    else
    {
      l = paramLong - l;
      this.mFramesRendered += 1;
      if (l > 500L)
      {
        double d1 = this.mFramesRendered * 1000;
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        this.mFrameStartTime = paramLong;
        int i = 0;
        this.mFramesRendered = 0;
        synchronized (this.mLock)
        {
          while (i < this.mListener.size())
          {
            ((FPSCalculator.GetFPSListener)this.mListener.get(i)).onInfo(this.mFrameStartTime, d1);
            i += 1;
          }
        }
      }
    }
    this.mChoreographer.postFrameCallback(this.mFPSMeasuringCallback);
  }
  
  private void enable()
  {
    if (this.mEnable)
    {
      QMLog.d("FPSCalculator", "FPSCalculator is enable");
      return;
    }
    this.mEnable = true;
    QMLog.d("FPSCalculator", "FPSCalculator set enable = true");
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.mFPSMeasuringCallback == null) {
        this.mFPSMeasuringCallback = new FPSCalculator.3(this);
      }
      this.mHandler.post(this.mInitFPSRunnable);
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("FPSCalculator", "build version is not support ");
    }
    this.mHandler.postDelayed(this.mFakeFPSRunnable, 500L);
  }
  
  public static FPSCalculator getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new FPSCalculator();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private static long nsToMs(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public void addListener(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.mLock)
    {
      if (!this.mListener.contains(paramGetFPSListener)) {
        this.mListener.add(paramGetFPSListener);
      }
      if (this.mListener.size() > 0) {
        enable();
      }
      return;
    }
  }
  
  public boolean isObserved(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    return this.mListener.contains(paramGetFPSListener);
  }
  
  public void removeListener(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.mLock)
    {
      if (this.mListener.contains(paramGetFPSListener)) {
        this.mListener.remove(paramGetFPSListener);
      }
      if (this.mListener.size() <= 0) {
        disable();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator
 * JD-Core Version:    0.7.0.1
 */