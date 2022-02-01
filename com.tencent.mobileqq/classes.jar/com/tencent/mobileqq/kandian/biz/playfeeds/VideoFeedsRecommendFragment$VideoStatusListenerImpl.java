package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.ad.report.VideoAdTimeReportData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class VideoFeedsRecommendFragment$VideoStatusListenerImpl
  implements VideoFeedsPlayManager.VideoStatusListener
{
  private VideoFeedsRecommendFragment$VideoStatusListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.c(this.a).addOnLayoutChangeListener(new VideoFeedsRecommendFragment.VideoStatusListenerImpl.1(this));
      return;
    }
    VideoFeedsRecommendFragment.c(this.a).b();
  }
  
  public void a(VideoPlayParam paramVideoPlayParam) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (!paramVideoPlayParam.c.aq))
    {
      paramVideoPlayParam = paramVideoPlayParam.c.b;
      VideoFeedsRecommendFragment.T(this.a).a(paramVideoPlayParam);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.t(this.a) != null) {
      VideoFeedsRecommendFragment.t(this.a).b();
    }
  }
  
  public void b(VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void c(VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if ((VideoPreloadStrategyConoller.a().a((VideoPlayerWrapper)VideoFeedsRecommendFragment.g(this.a).az.h)) && (ReadInJoyHelper.ab(VideoFeedsRecommendFragment.y(this.a))) && (paramVideoPlayParam == VideoFeedsRecommendFragment.g(this.a).az))
    {
      int i = VideoFeedsRecommendFragment.g(this.a).Z;
      int j = VideoFeedsRecommendFragment.c(this.a).getHeaderViewsCount();
      localObject = VideoFeedsRecommendFragment.c(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof BaseVideoItemHolder))
      {
        localObject = (BaseVideoItemHolder)localObject;
        if (((BaseVideoItemHolder)localObject).az != null) {
          VideoFeedsRecommendFragment.O(this.a).b(((BaseVideoItemHolder)localObject).az);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.g(this.a).Z == 0) && (paramVideoPlayParam.c.a == 0)) {
      VideoFeedsRecommendFragment.g(this.a).aB.a(3);
    }
    if ((VideoFeedsRecommendFragment.t(this.a) != null) && (paramVideoPlayParam != null) && (VideoFeedsRecommendFragment.e(this.a).size() > 0) && (paramVideoPlayParam.c != null) && ((paramVideoPlayParam.c instanceof VideoInfo)))
    {
      localObject = paramVideoPlayParam.c;
      if (paramVideoPlayParam.c.aq)
      {
        if (((VideoInfo)localObject).at.c <= 0L) {
          ((VideoInfo)localObject).at.c = VideoFeedsRecommendFragment.t(this.a).i();
        }
        VideoFeedsRecommendFragment.t(this.a).f();
      }
      else
      {
        VideoFeedsRecommendFragment.t(this.a).a();
        localObject = paramVideoPlayParam.c.b;
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(0)).b))) {
          VideoFeedsRecommendFragment.t(this.a).b(0);
        } else {
          VideoFeedsRecommendFragment.t(this.a).b(VideoFeedsRecommendFragment.g(this.a).Z + 1);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.s(this.a) != null) && (paramVideoPlayParam.c != null)) {
      VideoFeedsRecommendFragment.s(this.a).a(paramVideoPlayParam.c.b);
    }
    if ((VideoFeedsRecommendFragment.T(this.a) != null) && (paramVideoPlayParam != null) && (paramVideoPlayParam.c != null)) {
      VideoFeedsRecommendFragment.T(this.a).a(paramVideoPlayParam);
    }
  }
  
  public void d(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.M(this.a) != null)
    {
      bool = VideoFeedsRecommendFragment.M(this.a).d();
      VideoFeedsPlayActivity.a("video play completion!, in weishi mode! interrupted weishi ad");
      if (bool) {
        return;
      }
    }
    VideoFeedsPlayActivity.a("video play completion!, move to next position");
    boolean bool = VideoFeedsRecommendFragment.J(this.a);
    if (VideoFeedsRecommendFragment.k(this.a))
    {
      if (bool)
      {
        VideoFeedsRecommendFragment.c(this.a).a();
        return;
      }
      VideoFeedsRecommendFragment.g(this.a).aB.a(5);
      return;
    }
    if (VideoFeedsRecommendFragment.J(this.a))
    {
      if ((VideoFeedsRecommendFragment.z(this.a) != null) && (VideoFeedsRecommendFragment.z(this.a).b() != null))
      {
        VideoFeedsRecommendFragment.z(this.a).a(VideoFeedsRecommendFragment.Q(this.a).a(VideoFeedsRecommendFragment.g(this.a).az.c));
        VideoFeedsRecommendFragment.Q(this.a).a();
        return;
      }
      VideoFeedsRecommendFragment.c(this.a).a();
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (paramVideoPlayParam.c.aq))
    {
      VideoInfo localVideoInfo = paramVideoPlayParam.c;
      if (!((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.as).mShowAdButton)
      {
        if ((VideoFeedsRecommendFragment.R(this.a) != null) && (VideoFeedsRecommendFragment.R(this.a).i() != null) && (VideoFeedsRecommendFragment.d(this.a) != null))
        {
          VideoFeedsRecommendFragment.R(this.a).f();
          VideoFeedsRecommendFragment.d(this.a).a(VideoFeedsRecommendFragment.R(this.a).i());
        }
        return;
      }
    }
    if (VideoFeedsRecommendFragment.R(this.a).a(paramVideoPlayParam)) {
      return;
    }
    if (VideoFeedsRecommendFragment.g(this.a).Z == VideoFeedsRecommendFragment.e(this.a).size() - 1) {
      return;
    }
    if ((!VideoFeedsRecommendFragment.S(this.a)) && (NetworkUtil.isMobileNetWork(VideoFeedsRecommendFragment.y(this.a).getApplication().getApplicationContext()))) {
      return;
    }
    if (VideoFeedsRecommendFragment.f(this.a).k())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    a(bool);
  }
  
  public void e(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.g(this.a) != null) {
      VideoFeedsAccessibilityHelper.a.a(VideoFeedsRecommendFragment.g(this.a).ad, true);
    }
    if (VideoFeedsRecommendFragment.t(this.a) != null) {
      VideoFeedsRecommendFragment.t(this.a).b();
    }
  }
  
  public void f(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.g(this.a) != null) {
      VideoFeedsAccessibilityHelper.a.a(VideoFeedsRecommendFragment.g(this.a).ad, false);
    }
    if (paramVideoPlayParam.c.aq)
    {
      VideoFeedsRecommendFragment.t(this.a).f();
      VideoFeedsRecommendFragment.T(this.a).h();
      return;
    }
    VideoFeedsRecommendFragment.t(this.a).a();
    VideoFeedsRecommendFragment.T(this.a).a();
  }
  
  public void g(VideoPlayParam paramVideoPlayParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.VideoStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */