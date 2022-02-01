package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlay;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.RecommendDataAdapter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$FullPlayCallbackImpl
  implements IVideoPlay, VideoFullPlayController.OnFullPlayListener, VideoFullPlayController.RecommendDataAdapter
{
  private VideoFeedsRecommendFragment$FullPlayCallbackImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public VideoFeedsRecommendFragment.FullPlayParams a(VideoInfo paramVideoInfo)
  {
    VideoFeedsRecommendFragment.FullPlayParams localFullPlayParams = new VideoFeedsRecommendFragment.FullPlayParams(null);
    VideoFeedsRecommendFragment.FullPlayParams.a(localFullPlayParams, paramVideoInfo);
    localFullPlayParams.jdField_b_of_type_Long = 409409L;
    localFullPlayParams.jdField_a_of_type_Int = 0;
    localFullPlayParams.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localFullPlayParams.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localFullPlayParams.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localFullPlayParams.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localFullPlayParams;
  }
  
  public List<BaseVideoPlayParam> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.j(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a(6);
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    VideoItemHolder localVideoItemHolder = VideoFeedsRecommendFragment.a(this.a);
    if (((paramBaseVideoPlayParam instanceof VideoFeedsRecommendFragment.FullPlayParams)) && (localVideoItemHolder != null))
    {
      paramBaseVideoPlayParam = VideoFeedsRecommendFragment.FullPlayParams.a((VideoFeedsRecommendFragment.FullPlayParams)paramBaseVideoPlayParam);
      if (paramBaseVideoPlayParam == localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)
      {
        localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_Long = 0L;
        VideoFeedsRecommendFragment.a(this.a).a(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, false);
      }
      else
      {
        int i = localVideoItemHolder.c;
        VideoFeedsRecommendFragment.a(this.a).remove(i);
        VideoFeedsRecommendFragment.a(this.a).add(i, paramBaseVideoPlayParam);
        VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
      }
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = VideoFeedsRecommendFragment.FullPlayParams.a((VideoFeedsRecommendFragment.FullPlayParams)VideoFeedsRecommendFragment.a(this.a).a());
    Object localObject1 = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != localObject2)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject2);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      localObject2 = VideoFeedsRecommendFragment.a(this.a);
      ((VideoItemHolder)localObject2).b += 1;
      localObject2 = VideoFeedsRecommendFragment.a(this.a);
      ((VideoItemHolder)localObject2).c += 1;
      VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c);
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, false);
    }
    localObject1 = new VideoR5.Builder(null, null, ((VideoInfo)localObject1).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject1).g).a(409409).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", (String)localObject1, false);
  }
  
  public void ay_()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.FullPlayCallbackImpl
 * JD-Core Version:    0.7.0.1
 */