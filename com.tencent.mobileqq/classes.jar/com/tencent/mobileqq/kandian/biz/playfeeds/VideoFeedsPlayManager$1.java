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
    VideoFeedsPlayManager.a(this.a).f();
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
        paramVideoPlayerWrapper.append(VideoFeedsPlayManager.f(this.a));
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, paramVideoPlayerWrapper.toString());
      }
      if ((!VideoFeedsPlayManager.f(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
      {
        VideoFeedsPlayManager.e(this.a, true);
        if ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) && (!VideoFeedsPlayManager.g(this.a)))
        {
          boolean bool1 = bool2;
          if (!VideoFeedsPlayManager.h(this.a)) {
            if (VideoFeedsPlayManager.i(this.a)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(VideoFeedsPlayManager.a(this.a), i, bool1);
        }
      }
    }
    else if ((paramLong1 <= 500L) && (paramLong1 >= 0L) && (VideoFeedsPlayManager.j(this.a)))
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
      VideoFeedsPlayManager.a(this.a);
      paramVideoPlayerWrapper.m();
      if ((VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) && (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isShowAdGuide(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a)))
      {
        a();
        return;
      }
      if (VideoFeedsPlayManager.a(this.a) != null)
      {
        paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a).iterator();
        while (paramVideoPlayerWrapper.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)paramVideoPlayerWrapper.next()).a(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.b(this.a));
        }
      }
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (VideoFeedsPlayManager.e(this.a)) {
      return;
    }
    if ((paramMessage.obj instanceof VideoPlayParam))
    {
      if (VideoFeedsPlayManager.a(this.a, (VideoPlayParam)paramMessage.obj)) {
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
      paramMessage = VideoFeedsPlayManager.a(this.a);
      localObject = VideoFeedsPlayManager.a(this.a);
      if ((paramMessage != null) && (paramMessage.f()) && ((((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate == null) || (!((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a())) && (!paramMessage.n()))
      {
        long l1 = paramMessage.a();
        long l2 = paramMessage.b();
        if (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
          ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a((VideoPlayParam)localObject, l1, l2);
        }
        a(paramMessage, (VideoPlayParam)localObject, l1, l2);
        if (VideoFeedsPlayManager.a(this.a) != null) {
          VideoFeedsPlayManager.a(this.a).a(l1);
        }
      }
      VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 100);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "prePlay timeout, try rePlay");
    }
    paramMessage = this.a;
    if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.a(paramMessage)) != null)
    {
      paramMessage = this.a;
      if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.a(paramMessage)).d())
      {
        paramMessage = this.a;
        if (VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.a(paramMessage)).a() == VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)
        {
          paramMessage = VideoFeedsPlayManager.a(this.a);
          localObject = this.a;
          paramMessage.a(VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject, VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject)));
          return;
        }
      }
    }
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean = false;
    paramMessage = this.a;
    paramMessage.c(VideoFeedsPlayManager.a(paramMessage));
    paramMessage = this.a;
    VideoFeedsPlayManager.a(paramMessage, VideoFeedsPlayManager.a(paramMessage), false);
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
      } else {
        handleMessage(paramMessage);
      }
      return true;
    }
    if (paramMessage.obj == null) {
      paramMessage.obj = VideoFeedsPlayManager.a(this.a);
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.1
 * JD-Core Version:    0.7.0.1
 */