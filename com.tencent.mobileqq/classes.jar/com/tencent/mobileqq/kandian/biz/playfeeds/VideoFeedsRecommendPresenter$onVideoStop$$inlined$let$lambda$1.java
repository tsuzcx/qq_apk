package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter$onVideoStop$1$1"}, k=3, mv={1, 1, 16})
final class VideoFeedsRecommendPresenter$onVideoStop$$inlined$let$lambda$1
  implements Runnable
{
  VideoFeedsRecommendPresenter$onVideoStop$$inlined$let$lambda$1(VideoInfo paramVideoInfo, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, VideoPlayParam paramVideoPlayParam, List paramList, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a instanceof ReadInJoyVideoReportData))
    {
      VideoFeedsReporter localVideoFeedsReporter = this.this$0.a();
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      List localList = this.jdField_a_of_type_JavaUtilList;
      AbsReadInJoyVideoReportData localAbsReadInJoyVideoReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a;
      if (localAbsReadInJoyVideoReportData != null)
      {
        localVideoFeedsReporter.a(localVideoInfo, localList, (ReadInJoyVideoReportData)localAbsReadInJoyVideoReportData, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */