package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.os.SystemClock;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import java.util.Timer;

public abstract class TimerWorker
{
  private static final String TAG = "CloudFaceCountDownTimer";
  private boolean mCancelled = false;
  private final long mCountdownInterval;
  private final long mMillisInFuture;
  private long mStopTimeInFuture;
  private Timer mTimer;
  
  protected TimerWorker(long paramLong1, long paramLong2)
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("CloudFaceCountDownTimer", "[TimerWorker.TimerWorker] mCountDownTimer");
    this.mMillisInFuture = paramLong1;
    this.mCountdownInterval = paramLong2;
  }
  
  private void continueTimerJudge()
  {
    if (this.mCancelled) {
      return;
    }
    long l1 = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
    if (l1 <= 0L)
    {
      this.mTimer.cancel();
      onFinish();
      return;
    }
    if (l1 < this.mCountdownInterval) {
      return;
    }
    long l2 = SystemClock.elapsedRealtime();
    onTick(l1);
    for (l1 = l2 + this.mCountdownInterval - SystemClock.elapsedRealtime(); l1 < 0L; l1 += this.mCountdownInterval) {}
  }
  
  public final void cancel()
  {
    try
    {
      this.mCancelled = true;
      if (this.mTimer != null) {
        this.mTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void onFinish();
  
  public abstract void onTick(long paramLong);
  
  public final TimerWorker start()
  {
    try
    {
      this.mCancelled = false;
      if (this.mMillisInFuture <= 0L)
      {
        onFinish();
        return this;
      }
      this.mStopTimeInFuture = (SystemClock.elapsedRealtime() + this.mMillisInFuture);
      this.mTimer = new Timer();
      this.mTimer.schedule(new TimerWorker.1(this), 0L, this.mCountdownInterval);
      return this;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker
 * JD-Core Version:    0.7.0.1
 */