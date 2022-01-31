import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.ProgressUIHandler.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;

public class own
  extends Handler
{
  WeakReference<ReadInjoyIMAXAdFragment> a;
  
  public own(Looper paramLooper, ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    super(paramLooper);
    this.a = new WeakReference(paramReadInjoyIMAXAdFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInjoyIMAXAdFragment localReadInjoyIMAXAdFragment = (ReadInjoyIMAXAdFragment)this.a.get();
    if (localReadInjoyIMAXAdFragment == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    long l1;
    if (ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment) != null)
    {
      l1 = ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).getCurrentPostion();
      long l2 = ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).getDuration();
      if (l1 >= l2 - 300L)
      {
        ReadInjoyIMAXAdFragment.b(localReadInjoyIMAXAdFragment, true);
        int i = (int)(l2 - l1);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyIMAXAdFragment", 2, "onVideoEndSoon: pos=" + l1 + ", duration=" + l2 + ", remainDuration=" + i + ", mHasCallEndingSoon=" + ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment));
        }
        if (!ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment))
        {
          ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment, true);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyIMAXAdFragment", 2, "onVideoEndSoon: !!!");
          }
          ReadInjoyIMAXAdFragment.d(localReadInjoyIMAXAdFragment);
        }
        ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment, l1);
      }
    }
    for (;;)
    {
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).sendEmptyMessageDelayed(-2, 100);
      return;
      if ((l1 > 500L) || (l1 < 0L) || (!ReadInjoyIMAXAdFragment.d(localReadInjoyIMAXAdFragment))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyIMAXAdFragment", 2, "onVideoReplayOnLoop: pos=" + l1);
      }
      ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment, false);
      ReadInjoyIMAXAdFragment.b(localReadInjoyIMAXAdFragment, false);
      if (ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment) == null) {
        break;
      }
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).pause();
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).post(new ReadInjoyIMAXAdFragment.ProgressUIHandler.1(this));
      break;
      ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment, ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment) + 100);
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment, ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     own
 * JD-Core Version:    0.7.0.1
 */