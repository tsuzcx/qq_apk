package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.UserInfoItem;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$LiveStatusCallback
  implements RIJLiveStatusModule.LiveStatusCallback
{
  private VideoFeedsRecommendFragment$LiveStatusCallback(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(int paramInt, List<RIJLiveStatusModule.UserInfoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RIJLiveStatusModule.UserInfoItem localUserInfoItem = (RIJLiveStatusModule.UserInfoItem)paramList.next();
      paramInt = 0;
      Iterator localIterator = VideoFeedsRecommendFragment.e(this.a).iterator();
      while (localIterator.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localVideoInfo.q)) && (localVideoInfo.aO == null) && (Long.parseLong(localVideoInfo.q) == localUserInfoItem.a))
        {
          localVideoInfo.aO = localUserInfoItem.b;
          if (localUserInfoItem.b.a == 1) {
            paramInt = 1;
          }
        }
      }
      if (paramInt != 0) {
        VideoFeedsHelper.a(new VideoFeedsRecommendFragment.LiveStatusCallback.1(this, localUserInfoItem));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.LiveStatusCallback
 * JD-Core Version:    0.7.0.1
 */