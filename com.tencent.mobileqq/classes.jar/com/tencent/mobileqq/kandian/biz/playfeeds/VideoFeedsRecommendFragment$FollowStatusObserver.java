package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VideoFeedsRecommendFragment$FollowStatusObserver
  implements IFollowStatusObserver
{
  private List<VideoInfo> a;
  
  public VideoFeedsRecommendFragment$FollowStatusObserver(List<VideoInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (!TextUtils.isEmpty(localVideoInfo.j))
      {
        FollowingMember localFollowingMember = (FollowingMember)paramMap.get(Long.valueOf(Long.parseLong(localVideoInfo.j)));
        if (localFollowingMember != null) {
          localVideoInfo.p = localFollowingMember.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.FollowStatusObserver
 * JD-Core Version:    0.7.0.1
 */