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
  
  public void a(VideoPlayParam paramVideoPlayParam) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (!paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r))
    {
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
      VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void c(VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if ((VideoPreloadStrategyConoller.a().a((VideoPlayerWrapper)VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper)) && (ReadInJoyHelper.y(VideoFeedsRecommendFragment.a(this.a))) && (paramVideoPlayParam == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).getHeaderViewsCount();
      localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof BaseVideoItemHolder))
      {
        localObject = (BaseVideoItemHolder)localObject;
        if (((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo instanceof VideoInfo)))
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r)
      {
        if (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportVideoAdTimeReportData.a <= 0L) {
          ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportVideoAdTimeReportData.a = VideoFeedsRecommendFragment.a(this.a).a();
        }
        VideoFeedsRecommendFragment.a(this.a).f();
      }
      else
      {
        VideoFeedsRecommendFragment.a(this.a).a();
        localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString))) {
          VideoFeedsRecommendFragment.a(this.a).b(0);
        } else {
          VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam);
    }
  }
  
  public void d(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      bool = VideoFeedsRecommendFragment.a(this.a).c();
      VideoFeedsPlayActivity.a("video play completion!, in weishi mode! interrupted weishi ad");
      if (bool) {
        return;
      }
    }
    VideoFeedsPlayActivity.a("video play completion!, move to next position");
    boolean bool = VideoFeedsRecommendFragment.d(this.a);
    if (VideoFeedsRecommendFragment.a(this.a))
    {
      if (bool)
      {
        VideoFeedsRecommendFragment.a(this.a).b();
        return;
      }
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a(5);
      return;
    }
    if (VideoFeedsRecommendFragment.d(this.a))
    {
      if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
      {
        VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo));
        VideoFeedsRecommendFragment.a(this.a).a();
        return;
      }
      VideoFeedsRecommendFragment.a(this.a).b();
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r))
    {
      VideoInfo localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (!((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).mShowAdButton)
      {
        if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null) && (VideoFeedsRecommendFragment.a(this.a) != null))
        {
          VideoFeedsRecommendFragment.a(this.a).e();
          VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
        }
        return;
      }
    }
    if (VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam)) {
      return;
    }
    if (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) {
      return;
    }
    if ((!VideoFeedsRecommendFragment.f(this.a)) && (NetworkUtil.isMobileNetWork(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))) {
      return;
    }
    if (VideoFeedsRecommendFragment.a(this.a).b())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new VideoFeedsRecommendFragment.VideoStatusListenerImpl.1(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void e(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a.a(VideoFeedsRecommendFragment.a(this.a).g, true);
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void f(VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a.a(VideoFeedsRecommendFragment.a(this.a).g, false);
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      VideoFeedsRecommendFragment.a(this.a).g();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void g(VideoPlayParam paramVideoPlayParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.VideoStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */