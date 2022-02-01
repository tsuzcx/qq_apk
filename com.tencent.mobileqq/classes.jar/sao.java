import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class sao
  extends Handler
{
  public sao(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (VideoFeedsPlayManager.e(this.a)) {}
    do
    {
      return;
      if (!(paramMessage.obj instanceof sar)) {
        break;
      }
    } while (!VideoFeedsPlayManager.a(this.a, (sar)paramMessage.obj));
    super.dispatchMessage(paramMessage);
    return;
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case -3: 
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "prePlay timeout, try rePlay");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)) != null) && (VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)).d()) && (VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)).a() == VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
        VideoFeedsPlayManager.a(this.a).e(VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)));
        return;
      }
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean = false;
      this.a.c(VideoFeedsPlayManager.a(this.a));
      VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a), false);
      return;
    }
    paramMessage = VideoFeedsPlayManager.a(this.a);
    sar localsar = VideoFeedsPlayManager.a(this.a);
    long l1;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.f()) && ((localsar.jdField_a_of_type_Ruv == null) || (!localsar.jdField_a_of_type_Ruv.a(localsar))) && (!paramMessage.n()))
    {
      l1 = paramMessage.a();
      long l2 = paramMessage.b();
      if (localsar.jdField_a_of_type_Ruv != null) {
        localsar.jdField_a_of_type_Ruv.a(localsar, l1, l2);
      }
      if (l1 < l2 - 300L) {
        break label495;
      }
      VideoFeedsPlayManager.d(this.a, true);
      int i = (int)(l2 - l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoEndSoon: pos=" + l1 + ", duration=" + l2 + ", remainDuration=" + i + ", mHasCallEndingSoon=" + VideoFeedsPlayManager.f(this.a));
      }
      if ((!VideoFeedsPlayManager.f(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
      {
        VideoFeedsPlayManager.e(this.a, true);
        if ((localsar.jdField_a_of_type_Ruv != null) && (!VideoFeedsPlayManager.g(this.a)))
        {
          if ((!VideoFeedsPlayManager.h(this.a)) && (!VideoFeedsPlayManager.i(this.a))) {
            break label489;
          }
          bool = true;
          localsar.jdField_a_of_type_Ruv.a(VideoFeedsPlayManager.a(this.a), i, bool);
        }
      }
    }
    for (;;)
    {
      if (VideoFeedsPlayManager.a(this.a) != null) {
        VideoFeedsPlayManager.a(this.a).a(l1);
      }
      VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 100);
      return;
      label489:
      bool = false;
      break;
      label495:
      if ((l1 <= 500L) && (l1 >= 0L) && (VideoFeedsPlayManager.j(this.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoReplayOnLoop: pos=" + l1);
        }
        VideoFeedsPlayManager.f(this.a, false);
        VideoFeedsPlayManager.e(this.a, false);
        VideoFeedsPlayManager.d(this.a, false);
        VideoFeedsPlayManager.a(this.a);
        paramMessage.m();
        if ((VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (oqi.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))
        {
          VideoFeedsPlayManager.a(this.a).f();
          VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.1.1(this));
        }
        else if (VideoFeedsPlayManager.a(this.a) != null)
        {
          paramMessage = VideoFeedsPlayManager.a(this.a).iterator();
          while (paramMessage.hasNext()) {
            ((sat)paramMessage.next()).a(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.b(this.a));
          }
        }
      }
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (VideoFeedsPlayManager.e(this.a)) {
      return false;
    }
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
    {
      if (paramMessage.getCallback() != null) {
        paramMessage.getCallback().run();
      }
      for (;;)
      {
        return true;
        handleMessage(paramMessage);
      }
    }
    if (paramMessage.obj == null) {
      paramMessage.obj = VideoFeedsPlayManager.a(this.a);
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sao
 * JD-Core Version:    0.7.0.1
 */