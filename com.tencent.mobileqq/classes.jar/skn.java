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

public class skn
  extends Handler
{
  public skn(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    VideoFeedsPlayManager.a(this.a).f();
    VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.1.1(this));
  }
  
  public void a(spn paramspn, skq paramskq, long paramLong1, long paramLong2)
  {
    boolean bool = false;
    if (paramLong1 >= paramLong2 - 300L)
    {
      VideoFeedsPlayManager.d(this.a, true);
      int i = (int)(paramLong2 - paramLong1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoEndSoon: pos=" + paramLong1 + ", duration=" + paramLong2 + ", remainDuration=" + i + ", mHasCallEndingSoon=" + VideoFeedsPlayManager.f(this.a));
      }
      if ((!VideoFeedsPlayManager.f(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
      {
        VideoFeedsPlayManager.e(this.a, true);
        if ((paramskq.jdField_a_of_type_Sfg != null) && (!VideoFeedsPlayManager.g(this.a)))
        {
          if ((VideoFeedsPlayManager.h(this.a)) || (VideoFeedsPlayManager.i(this.a))) {
            bool = true;
          }
          paramskq.jdField_a_of_type_Sfg.a(VideoFeedsPlayManager.a(this.a), i, bool);
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramLong1 <= 500L) && (paramLong1 >= 0L) && (VideoFeedsPlayManager.j(this.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoReplayOnLoop: pos=" + paramLong1);
        }
        VideoFeedsPlayManager.f(this.a, false);
        VideoFeedsPlayManager.e(this.a, false);
        VideoFeedsPlayManager.d(this.a, false);
        VideoFeedsPlayManager.a(this.a);
        paramspn.m();
        if ((VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (ukr.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))
        {
          a();
          return;
        }
        if (VideoFeedsPlayManager.a(this.a) == null) {
          break;
        }
        paramspn = VideoFeedsPlayManager.a(this.a).iterator();
        while (paramspn.hasNext()) {
          ((sks)paramspn.next()).a(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.b(this.a));
        }
      }
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (VideoFeedsPlayManager.e(this.a)) {}
    do
    {
      return;
      if (!(paramMessage.obj instanceof skq)) {
        break;
      }
    } while (!VideoFeedsPlayManager.a(this.a, (skq)paramMessage.obj));
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
        VideoFeedsPlayManager.a(this.a).d(VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)));
        return;
      }
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean = false;
      this.a.c(VideoFeedsPlayManager.a(this.a));
      VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a), false);
      return;
    }
    paramMessage = VideoFeedsPlayManager.a(this.a);
    skq localskq = VideoFeedsPlayManager.a(this.a);
    if ((paramMessage != null) && (paramMessage.f()) && ((localskq.jdField_a_of_type_Sfg == null) || (!localskq.jdField_a_of_type_Sfg.a(localskq))) && (!paramMessage.n()))
    {
      long l1 = paramMessage.a();
      long l2 = paramMessage.b();
      if (localskq.jdField_a_of_type_Sfg != null) {
        localskq.jdField_a_of_type_Sfg.a(localskq, l1, l2);
      }
      a(paramMessage, localskq, l1, l2);
      if (VideoFeedsPlayManager.a(this.a) != null) {
        VideoFeedsPlayManager.a(this.a).a(l1);
      }
    }
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 100);
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
 * Qualified Name:     skn
 * JD-Core Version:    0.7.0.1
 */