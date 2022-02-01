package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.ErrorCode;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  private VideoFeedsPlayManager$MediaPlayListenerAdapterImpl(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.c(this.a);
    if ((VideoFeedsPlayManager.d(this.a) != null) && (localVideoPlayParam != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("预播放任务 onDownloadFinish title = ");
        localStringBuilder.append(localVideoPlayParam.c.g);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      int i = localVideoPlayParam.k;
      VideoFeedsPlayManager.d(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).e != null)) {
      CodecReuseHelper.a.a(paramObject, VideoFeedsPlayManager.b(this.a).e);
    }
  }
  
  private int b(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == null) {
      return 0;
    }
    if (paramVideoPlayParam.f == null) {
      return 0;
    }
    return paramVideoPlayParam.f.j;
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.c(this.a);
      StringBuilder localStringBuilder = null;
      Object localObject = localStringBuilder;
      if (localVideoPlayParam != null)
      {
        localObject = localStringBuilder;
        if (localVideoPlayParam.c != null) {
          localObject = localVideoPlayParam.c.b;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrePlayFinished() vid=");
      localStringBuilder.append((String)localObject);
      QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
    }
    if (PlayerHelper.a.a()) {
      a();
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).e != null)) {
      VideoFeedsPlayManager.b(this.a).e.ay = ((Long)paramObject).intValue();
    }
  }
  
  private void c(VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.o != null)) {
      paramVideoPlayParam.o.g(paramVideoPlayParam);
    }
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.g(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.g(this.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).g(VideoFeedsPlayManager.b(this.a));
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.e != null)) {
      paramVideoPlayParam.e.p = SystemClock.uptimeMillis();
    }
  }
  
  private void d(VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.o != null)) {
      paramVideoPlayParam.o.h(paramVideoPlayParam);
    }
    Object localObject;
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.g(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.g(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(VideoFeedsPlayManager.b(this.a), this.a.p());
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.e != null))
    {
      localObject = paramVideoPlayParam.e;
      ((AbsReadInJoyVideoReportData)localObject).q += SystemClock.uptimeMillis() - paramVideoPlayParam.e.p;
      paramVideoPlayParam = paramVideoPlayParam.e;
      paramVideoPlayParam.s += 1;
    }
    if ((VideoFeedsPlayManager.c(this.a) != null) && (VideoFeedsPlayManager.c(this.a).i))
    {
      paramVideoPlayParam = this.a;
      paramVideoPlayParam = VideoFeedsPlayManager.a(paramVideoPlayParam, VideoFeedsPlayManager.c(paramVideoPlayParam));
      if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.l())) {
        VideoFeedsPlayManager.c(this.a).h.B();
      }
    }
  }
  
  private void e(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.e != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      IVideoUIDelegate localIVideoUIDelegate = paramVideoPlayParam.o;
      int i = 1;
      if (localIVideoUIDelegate != null)
      {
        localIVideoUIDelegate = paramVideoPlayParam.o;
        boolean bool;
        if (paramVideoPlayParam == VideoFeedsPlayManager.c(this.a)) {
          bool = true;
        } else {
          bool = false;
        }
        localIVideoUIDelegate.a(paramVideoPlayParam, bool, VideoFeedsPlayManager.k(this.a));
      }
      if (paramVideoPlayParam.e.m <= 0L) {
        i = 0;
      }
      if (i != 0) {
        paramVideoPlayParam.e.au = (SystemClock.uptimeMillis() - paramVideoPlayParam.e.m);
      } else {
        paramVideoPlayParam.e.au = 0L;
      }
      paramVideoPlayParam.e.av = (SystemClock.uptimeMillis() - paramVideoPlayParam.e.n);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      paramVideoPlayerWrapper = new StringBuilder();
      paramVideoPlayerWrapper.append("startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=");
      paramVideoPlayerWrapper.append(VideoFeedsPlayManager.f(this.a));
      QLog.d("VideoFeedsPlayManager.preplay", 2, paramVideoPlayerWrapper.toString());
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-3);
    if (VideoFeedsPlayManager.f(this.a))
    {
      this.a.f();
      return;
    }
    VideoFeedsPlayManager.b(this.a, true);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.b(this.a) != null) {
        paramIVideoPlayerWrapper = VideoFeedsPlayManager.b(this.a).c.b;
      } else {
        paramIVideoPlayerWrapper = "param null";
      }
      localStringBuilder.append(paramIVideoPlayerWrapper);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this));
    paramIVideoPlayerWrapper = VideoFeedsPlayManager.b(this.a);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.e != null))
    {
      paramIVideoPlayerWrapper.e.j = true;
      paramIVideoPlayerWrapper.e.D = true;
    }
    VideoFeedsPlayManager.c(this.a, true);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      paramObject = VideoFeedsPlayManager.c(this.a);
      if ((VideoFeedsPlayManager.a(this.a, paramObject) == paramIVideoPlayerWrapper) && (paramObject.i)) {
        b();
      }
      return;
    }
    paramObject = VideoFeedsPlayManager.b(this.a);
    if ((paramObject != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onVideoPrepared() vid=");
      localStringBuilder.append(paramObject.c.b);
      localStringBuilder.append(", mIsOpenedVideo = ");
      localStringBuilder.append(VideoFeedsPlayManager.e(this.a));
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (!VideoFeedsPlayManager.e(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoFeedsPlayManager.a(this.a, false);
    a(paramObject);
    a(paramIVideoPlayerWrapper);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnectQualityCallback json= ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper))
    {
      VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
      boolean bool = VideoFeedsPlayManager.a(this.a, localVideoPlayerWrapper);
      localObject = null;
      paramIVideoPlayerWrapper = null;
      if (!bool)
      {
        localObject = this.a;
        if (localVideoPlayerWrapper == VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject, VideoFeedsPlayManager.c((VideoFeedsPlayManager)localObject)))
        {
          VideoFeedsPlayManager.a(this.a, paramString);
          if (VideoFeedsPlayManager.c(this.a) != null) {
            paramIVideoPlayerWrapper = VideoFeedsPlayManager.c(this.a).c;
          }
          if (paramIVideoPlayerWrapper != null) {
            VideoBufferRangeController.a().a(localVideoPlayerWrapper, paramIVideoPlayerWrapper.e, localVideoPlayerWrapper.M());
          }
        }
        return;
      }
      paramIVideoPlayerWrapper = (IVideoPlayerWrapper)localObject;
      if (VideoFeedsPlayManager.b(this.a) != null) {
        paramIVideoPlayerWrapper = VideoFeedsPlayManager.b(this.a).c;
      }
      if (paramIVideoPlayerWrapper != null) {
        VideoBufferRangeController.a().a(localVideoPlayerWrapper, paramIVideoPlayerWrapper.e, localVideoPlayerWrapper.M());
      }
    }
    if (VideoFeedsPlayManager.b(this.a) != null)
    {
      if (VideoFeedsPlayManager.b(this.a).e == null) {
        return;
      }
      VideoFeedsPlayManager.b(this.a).e.ac = paramString;
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.e != null))
    {
      if (paramVideoPlayParam.e.o != 0L) {
        return;
      }
      paramVideoPlayParam.e.o = (SystemClock.uptimeMillis() - paramVideoPlayParam.e.m);
      Object localObject = paramVideoPlayParam.e;
      ((AbsReadInJoyVideoReportData)localObject).q += paramVideoPlayParam.e.o;
      localObject = paramVideoPlayParam.e;
      ((AbsReadInJoyVideoReportData)localObject).s += 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.c.b);
        ((StringBuilder)localObject).append(", 预加载状态：");
        ((StringBuilder)localObject).append(paramVideoPlayParam.e.V);
        ((StringBuilder)localObject).append(", 预下载命中：");
        ((StringBuilder)localObject).append(VideoFeedsPlayManager.a(this.a, paramVideoPlayParam).g);
        ((StringBuilder)localObject).append(", 首帧耗时：");
        ((StringBuilder)localObject).append(paramVideoPlayParam.e.o);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("model : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" what : ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" extra : ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("detailInfo : ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" obj : ");
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = "";
    }
    ((StringBuilder)localObject).append(paramObject);
    paramObject = ((StringBuilder)localObject).toString();
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper))
    {
      paramString = this.a;
      if ((VideoFeedsPlayManager.a(paramString, VideoFeedsPlayManager.c(paramString)) == paramIVideoPlayerWrapper) && (paramIVideoPlayerWrapper != null)) {
        VideoFeedsPlayManager.c(this.a).i = false;
      }
      return false;
    }
    paramIVideoPlayerWrapper = VideoFeedsPlayManager.b(this.a);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.c != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("播放状态回调 onError() ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", vid=");
      ((StringBuilder)localObject).append(paramIVideoPlayerWrapper.c.b);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    paramObject = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.o != null)) {
      paramIVideoPlayerWrapper.o.a(paramIVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.g(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.g(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramIVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.c != null)) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramIVideoPlayerWrapper.c.l, paramIVideoPlayerWrapper.c.b, 1, paramInt2);
    }
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.e != null))
    {
      paramIVideoPlayerWrapper.e.j = false;
      paramObject = paramIVideoPlayerWrapper.e;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt2);
      paramObject.k = ((StringBuilder)localObject).toString();
      paramIVideoPlayerWrapper.e.l = paramString;
    }
    if ((VideoFeedsPlayManager.h(this.a)) && (VideoFeedsPlayManager.i(this.a) != null))
    {
      paramString = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(VideoFeedsPlayManager.b(this.a).c.as);
      paramObject = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickStateInVideoMode(VideoFeedsPlayManager.b(this.a))) {
        paramInt1 = 20;
      } else {
        paramInt1 = 0;
      }
      paramObject = paramObject.getVideoInfoObject(0, 0, 0, 0, paramInt1, 0, 0, 2, 2, 0, ReportConstants.VideoEndType.OTHER, true);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsPlayManager.j(this.a)).a(6).b(b(paramIVideoPlayerWrapper)).a(paramString).a(VideoFeedsPlayManager.b(this.a).c.as).a(paramObject));
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).resetClickStateInVideoMode(VideoFeedsPlayManager.b(this.a));
    }
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.b(this.a, paramInt)) && ((paramIVideoPlayerWrapper instanceof VideoPlayManager)) && (!VideoFeedsPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper))) {
      return false;
    }
    VideoPlayParam localVideoPlayParam1 = VideoFeedsPlayManager.b(this.a);
    VideoPlayParam localVideoPlayParam2 = VideoFeedsPlayManager.c(this.a);
    if ((localVideoPlayParam1 != null) && (paramIVideoPlayerWrapper == localVideoPlayParam1.h)) {
      paramIVideoPlayerWrapper = localVideoPlayParam1;
    } else if ((localVideoPlayParam2 != null) && (paramIVideoPlayerWrapper == localVideoPlayParam2.h)) {
      paramIVideoPlayerWrapper = localVideoPlayParam2;
    } else {
      paramIVideoPlayerWrapper = null;
    }
    if (paramInt != 105)
    {
      if (paramInt != 112)
      {
        if (paramInt != 113)
        {
          if (paramInt != 208)
          {
            if (paramInt != 209) {
              return false;
            }
            b(paramObject);
            return false;
          }
          a(paramObject);
          return false;
        }
        d(localVideoPlayParam1);
        return false;
      }
      c(localVideoPlayParam1);
      return false;
    }
    e(paramIVideoPlayerWrapper);
    return false;
  }
  
  public void b(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    super.b(paramIVideoPlayerWrapper);
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper))
    {
      VideoFeedsPlayManager.a(this.a).removeMessages(-2);
      VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
      if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).h == paramIVideoPlayerWrapper))
      {
        VideoFeedsPlayManager.b(this.a).b = ((VideoPlayerWrapper)paramIVideoPlayerWrapper).b();
        VideoFeedsPlayManager.b(this.a).o.b(VideoFeedsPlayManager.b(this.a), true);
      }
    }
  }
  
  public void c(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */