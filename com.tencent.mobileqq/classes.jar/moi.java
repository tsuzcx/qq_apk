import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;

public class moi
  implements Runnable
{
  public moi(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    if (FastWebVideoFeedsPlayManager.a(this.a) == null) {
      return;
    }
    if (FastWebVideoFeedsPlayManager.a(this.a) != null) {
      FastWebVideoFeedsPlayManager.a(this.a).cancel();
    }
    WeakReference localWeakReference1 = new WeakReference(FastWebVideoFeedsPlayManager.a(this.a));
    WeakReference localWeakReference2 = new WeakReference(FastWebVideoFeedsPlayManager.a(this.a));
    long l = FastWebVideoFeedsPlayManager.a(this.a).b();
    int i;
    if (l >= 30000L) {
      i = 100;
    }
    for (;;)
    {
      try
      {
        FastWebVideoFeedsPlayManager.a(this.a, new Timer());
        FastWebVideoFeedsPlayManager.a(this.a).schedule(new moj(this, localWeakReference1, localWeakReference2), 0L, i);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "innerStartShowProgress() mProgressTimer.schedule ERROR = " + localException.getMessage());
      return;
      if ((l >= 10000L) && (l <= 30000L)) {
        i = 40;
      } else {
        i = 20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moi
 * JD-Core Version:    0.7.0.1
 */