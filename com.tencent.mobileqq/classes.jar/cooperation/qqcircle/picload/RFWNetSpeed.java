package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;

public class RFWNetSpeed
{
  private static final long NET_WORK_SPEED_SPACE = 10000L;
  private static final String TAG = "QCircleNetSpeed";
  private static volatile RFWNetSpeed sInstance;
  private Handler mHandler;
  private volatile boolean mOnQQBackGround;
  private Runnable mRunnable;
  private volatile boolean mShouldInit = true;
  private long mTotalDownLoadData;
  
  private RFWNetSpeed()
  {
    registerBackGround();
  }
  
  private void checkInit()
  {
    if (this.mHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("QCircleNetSpeed");
      localHandlerThread.start();
      this.mHandler = new Handler(localHandlerThread.getLooper());
      this.mRunnable = new RFWNetSpeed.2(this);
    }
  }
  
  public static RFWNetSpeed g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new RFWNetSpeed();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void registerBackGround()
  {
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new RFWNetSpeed.1(this));
  }
  
  private void startRunnable()
  {
    this.mTotalDownLoadData = TrafficStats.getTotalRxBytes();
    if (this.mTotalDownLoadData == -1L) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.postDelayed(this.mRunnable, 10000L);
  }
  
  public void start()
  {
    if (this.mShouldInit)
    {
      this.mShouldInit = false;
      checkInit();
      startRunnable();
    }
  }
  
  public void stop()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.mShouldInit = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWNetSpeed
 * JD-Core Version:    0.7.0.1
 */