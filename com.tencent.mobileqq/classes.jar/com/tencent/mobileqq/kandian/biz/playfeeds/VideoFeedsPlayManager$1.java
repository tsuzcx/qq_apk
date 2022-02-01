package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$1
  extends Handler
{
  VideoFeedsPlayManager$1(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    VideoFeedsPlayManager.i(this.a).w();
    VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.1.1(this));
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam, long paramLong1, long paramLong2)
  {
    if (paramLong1 >= paramLong2 - 300L)
    {
      paramVideoPlayerWrapper = this.a;
      boolean bool2 = true;
      VideoFeedsPlayManager.d(paramVideoPlayerWrapper, true);
      int i = (int)(paramLong2 - paramLong1);
      if (QLog.isColorLevel())
      {
        paramVideoPlayerWrapper = new StringBuilder();
        paramVideoPlayerWrapper.append("onVideoEndSoon: pos=");
        paramVideoPlayerWrapper.append(paramLong1);
        paramVideoPlayerWrapper.append(", duration=");
        paramVideoPlayerWrapper.append(paramLong2);
        paramVideoPlayerWrapper.append(", remainDuration=");
        paramVideoPlayerWrapper.append(i);
        paramVideoPlayerWrapper.append(", mHasCallEndingSoon=");
        paramVideoPlayerWrapper.append(VideoFeedsPlayManager.o(this.a));
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, paramVideoPlayerWrapper.toString());
      }
      if ((!VideoFeedsPlayManager.o(this.a)) && (VideoFeedsPlayManager.g(this.a) != null))
      {
        VideoFeedsPlayManager.e(this.a, true);
        if ((paramVideoPlayParam.o != null) && (!VideoFeedsPlayManager.p(this.a)))
        {
          boolean bool1 = bool2;
          if (!VideoFeedsPlayManager.q(this.a)) {
            if (VideoFeedsPlayManager.r(this.a)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          paramVideoPlayParam.o.a(VideoFeedsPlayManager.b(this.a), i, bool1);
        }
      }
    }
    else if ((paramLong1 <= 500L) && (paramLong1 >= 0L) && (VideoFeedsPlayManager.s(this.a)))
    {
      if (QLog.isColorLevel())
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append("onVideoReplayOnLoop: pos=");
        paramVideoPlayParam.append(paramLong1);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, paramVideoPlayParam.toString());
      }
      VideoFeedsPlayManager.f(this.a, false);
      VideoFeedsPlayManager.e(this.a, false);
      VideoFeedsPlayManager.d(this.a, false);
      VideoFeedsPlayManager.t(this.a);
      paramVideoPlayerWrapper.N();
      if ((VideoFeedsPlayManager.b(this.a).c.aq) && (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isShowAdGuide(VideoFeedsPlayManager.b(this.a).c.as)))
      {
        a();
        return;
      }
      if (VideoFeedsPlayManager.g(this.a) != null)
      {
        paramVideoPlayerWrapper = VideoFeedsPlayManager.g(this.a).iterator();
        while (paramVideoPlayerWrapper.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)paramVideoPlayerWrapper.next()).a(VideoFeedsPlayManager.b(this.a), VideoFeedsPlayManager.u(this.a));
        }
      }
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (VideoFeedsPlayManager.l(this.a)) {
      return;
    }
    if ((paramMessage.obj instanceof VideoPlayParam))
    {
      if (VideoFeedsPlayManager.b(this.a, (VideoPlayParam)paramMessage.obj)) {
        super.dispatchMessage(paramMessage);
      }
    }
    else {
      super.dispatchMessage(paramMessage);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != -3)
    {
      if (i != -2) {
        return;
      }
      paramMessage = VideoFeedsPlayManager.i(this.a);
      localObject = VideoFeedsPlayManager.b(this.a);
      if ((paramMessage != null) && (paramMessage.n()) && ((((VideoPlayParam)localObject).o == null) || (!((VideoPlayParam)localObject).o.b())) && (!paramMessage.S()))
      {
        long l1 = paramMessage.C();
        long l2 = paramMessage.I();
        if (((VideoPlayParam)localObject).o != null) {
          ((VideoPlayParam)localObject).o.a((VideoPlayParam)localObject, l1, l2);
        }
        a(paramMessage, (VideoPlayParam)localObject, l1, l2);
        if (VideoFeedsPlayManager.n(this.a) != null) {
          VideoFeedsPlayManager.n(this.a).a(l1);
        }
      }
      VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 100);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "prePlay timeout, try rePlay");
    }
    paramMessage = this.a;
    if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.b(paramMessage)) != null)
    {
      paramMessage = this.a;
      if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.b(paramMessage)).l())
      {
        paramMessage = this.a;
        if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.b(paramMessage)).E() == VideoFeedsPlayManager.b(this.a).c)
        {
          paramMessage = VideoFeedsPlayManager.m(this.a);
          localObject = this.a;
          paramMessage.a(VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject, VideoFeedsPlayManager.b((VideoFeedsPlayManager)localObject)));
          return;
        }
      }
    }
    VideoFeedsPlayManager.b(this.a).i = false;
    paramMessage = this.a;
    paramMessage.c(VideoFeedsPlayManager.b(paramMessage));
    paramMessage = this.a;
    VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.b(paramMessage), false);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (VideoFeedsPlayManager.l(this.a)) {
      return false;
    }
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
    {
      if (paramMessage.getCallback() != null) {
        paramMessage.getCallback().run();
      } else {
        handleMessage(paramMessage);
      }
      return true;
    }
    if (paramMessage.obj == null) {
      paramMessage.obj = VideoFeedsPlayManager.b(this.a);
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.1
 * JD-Core Version:    0.7.0.1
 */