package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;

public class QCircleNetSpeed
{
  private static final long NET_WORK_SPEED_SPACE = 10000L;
  private static final String TAG = "QCircleNetSpeed";
  private static volatile QCircleNetSpeed sInstance;
  private Handler mHandler;
  private volatile boolean mOnQQBackGround;
  private Runnable mRunnable;
  private volatile boolean mShouldInit = true;
  private long mTotalDownLoadData;
  
  private QCircleNetSpeed()
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
      this.mRunnable = new QCircleNetSpeed.2(this);
    }
  }
  
  public static QCircleNetSpeed g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleNetSpeed();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void registerBackGround()
  {
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new QCircleNetSpeed.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleNetSpeed
 * JD-Core Version:    0.7.0.1
 */