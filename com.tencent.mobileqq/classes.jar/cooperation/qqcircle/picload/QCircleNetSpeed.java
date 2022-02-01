package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;

public class QCircleNetSpeed
{
  private static final long NET_WORK_SPEED_SPACE = 10000L;
  private static final String TAG = "QCircleNetSpeed";
  private static volatile QCircleNetSpeed sInstance;
  private Handler mHandler;
  private Runnable mRunnable;
  private volatile boolean mShouldInit = true;
  private long mTotalDownLoadData;
  
  public static QCircleNetSpeed g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleNetSpeed();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void start()
  {
    if (this.mShouldInit)
    {
      this.mShouldInit = false;
      if (this.mHandler == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("QCircleNetSpeed");
        localHandlerThread.start();
        this.mHandler = new Handler(localHandlerThread.getLooper());
        this.mRunnable = new QCircleNetSpeed.1(this);
      }
      this.mTotalDownLoadData = TrafficStats.getTotalRxBytes();
      if (this.mTotalDownLoadData != -1L) {}
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.postDelayed(this.mRunnable, 10000L);
  }
  
  public void stop()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mShouldInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleNetSpeed
 * JD-Core Version:    0.7.0.1
 */