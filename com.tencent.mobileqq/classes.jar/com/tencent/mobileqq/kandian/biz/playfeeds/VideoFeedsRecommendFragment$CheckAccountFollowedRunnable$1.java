package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1
  implements Runnable
{
  VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable paramCheckAccountFollowedRunnable, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable, (VideoInfo)localObject, this.jdField_a_of_type_Boolean);
      i = bool;
      if (((VideoInfo)localObject).c != null)
      {
        localObject = ((VideoInfo)localObject).c.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
          bool |= VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable, localVideoInfo, this.jdField_a_of_type_Boolean);
        }
      }
    }
    if ((i != 0) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0) != null)) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0).b(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$CheckAccountFollowedRunnable).j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */