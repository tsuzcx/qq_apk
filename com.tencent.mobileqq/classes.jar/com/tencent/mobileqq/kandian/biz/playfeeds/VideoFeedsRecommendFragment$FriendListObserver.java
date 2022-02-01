package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class VideoFeedsRecommendFragment$FriendListObserver
  extends FriendListObserver
{
  private VideoFeedsRecommendFragment$FriendListObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    Object localObject1 = VideoFeedsRecommendFragment.y(this.a);
    String str = null;
    int i = 0;
    if (localObject1 != null) {
      str = ContactUtils.a((AppRuntime)localObject1, paramString, false);
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    localObject1 = VideoFeedsRecommendFragment.e(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (VideoInfo)((Iterator)localObject1).next();
      int j = i;
      if (paramString.equals(((VideoInfo)localObject2).q))
      {
        j = i;
        if (!str.equals(((VideoInfo)localObject2).r))
        {
          ((VideoInfo)localObject2).r = str;
          j = 1;
        }
      }
      i = j;
      if (((VideoInfo)localObject2).aH != null)
      {
        localObject2 = ((VideoInfo)localObject2).aH.iterator();
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
          if ((paramString.equals(localVideoInfo.q)) && (!str.equals(localVideoInfo.r)))
          {
            localVideoInfo.r = str;
            j = 1;
          }
        }
      }
    }
    if (i != 0) {
      VideoFeedsRecommendFragment.d(this.a).d(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.FriendListObserver
 * JD-Core Version:    0.7.0.1
 */