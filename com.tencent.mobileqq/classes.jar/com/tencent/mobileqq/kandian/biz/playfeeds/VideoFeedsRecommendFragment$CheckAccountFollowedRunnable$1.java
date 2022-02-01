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
    Iterator localIterator = VideoFeedsRecommendFragment.e(this.b.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.b, (VideoInfo)localObject, this.a);
      i = bool;
      if (((VideoInfo)localObject).aH != null)
      {
        localObject = ((VideoInfo)localObject).aH.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
          bool |= VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.b, localVideoInfo, this.a);
        }
      }
    }
    if ((i != 0) && (VideoFeedsRecommendFragment.d(this.b.this$0) != null)) {
      VideoFeedsRecommendFragment.d(this.b.this$0).d(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.b).q);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */