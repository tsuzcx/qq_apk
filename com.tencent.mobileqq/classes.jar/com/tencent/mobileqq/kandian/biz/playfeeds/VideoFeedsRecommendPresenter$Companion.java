package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter$Companion;", "", "()V", "SPEED_RATIO_1", "", "SPEED_RATIO_1_5", "SPEED_RATIO_2", "SPEED_RATIO_ARRAY", "", "getSPEED_RATIO_ARRAY", "()[F", "SPEED_RATIO_DRAWABLE_ID", "", "getSPEED_RATIO_DRAWABLE_ID", "()[I", "TAG", "", "isNeedReportAd", "", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$Companion
{
  private final boolean a(VideoPlayParam paramVideoPlayParam)
  {
    VideoInfo localVideoInfo;
    if (paramVideoPlayParam != null) {
      localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    } else {
      localVideoInfo = null;
    }
    return (localVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter.Companion
 * JD-Core Version:    0.7.0.1
 */