package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver paramVideoFeedsFirstRecommendObserver, VideoFeedsFirstVideoRecommendationManager paramVideoFeedsFirstVideoRecommendationManager, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsFirstVideoRecommendationManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager);
    if (localVideoPreDownloadMgr != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 1)
      {
        if (!localVideoPreDownloadMgr.a(null, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString)) {
          localVideoPreDownloadMgr.a(null, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int == 2) {
        ThirdVideoManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1(this, localVideoPreDownloadMgr));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1
 * JD-Core Version:    0.7.0.1
 */