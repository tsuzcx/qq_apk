package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo;

public class VideoFeedsLikeAnimateManager$LikeAnimateObserver
  implements BusinessObserver
{
  public VideoFeedsLikeAnimateManager$LikeAnimateObserver(VideoFeedsLikeAnimateManager paramVideoFeedsLikeAnimateManager) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        return;
      }
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        VideoFeedsLikeAnimateManager.a(this.a, (LikeAnimationInfo)paramObject.getParcelable("key_like_animation_info"));
        ReadInJoyHelper.f();
        ReadInJoyHelper.a(VideoFeedsLikeAnimateManager.a(this.a));
        paramObject = this.a;
        VideoFeedsLikeAnimateManager.a(paramObject, VideoFeedsLikeAnimateManager.a(paramObject), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimateManager.LikeAnimateObserver
 * JD-Core Version:    0.7.0.1
 */