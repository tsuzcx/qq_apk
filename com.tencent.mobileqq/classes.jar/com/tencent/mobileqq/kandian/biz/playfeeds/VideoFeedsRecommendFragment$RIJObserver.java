package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupCommand;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsRecommendFragment$RIJObserver
  extends ReadInJoyObserver
{
  private VideoFeedsRecommendFragment$RIJObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    try
    {
      RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
      localRecommendFollowInfo.uin = paramLong;
      localRecommendFollowInfo.isFollowed = paramBoolean;
      SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(2, localRecommendFollowInfo));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "run: CheckAccountFollowedRunnable", localException);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onQueryContentCoinNumResult: success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", retMsg=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", rowkey=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", coinNum=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramString1 = VideoFeedsRecommendFragment.a(this.a).iterator();
      while (paramString1.hasNext())
      {
        localObject = (VideoInfo)paramString1.next();
        if ((!TextUtils.isEmpty(((VideoInfo)localObject).g)) && (((VideoInfo)localObject).g.equals(paramString2)))
        {
          ((VideoInfo)localObject).jdField_o_of_type_Int = paramInt2;
          VideoFeedsRecommendFragment.a(this.a).a((VideoInfo)localObject);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckContentHasCoinResult: success=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", retMsg=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", rowkey=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", hasCoin=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      paramString1 = VideoFeedsRecommendFragment.a(this.a).iterator();
      while (paramString1.hasNext())
      {
        localObject = (VideoInfo)paramString1.next();
        if ((!TextUtils.isEmpty(((VideoInfo)localObject).g)) && (((VideoInfo)localObject).g.equals(paramString2)))
        {
          ((VideoInfo)localObject).n = paramBoolean2;
          ((VideoInfo)localObject).jdField_o_of_type_Boolean = true;
          if (localObject == this.a.b()) {
            VideoFeedsRecommendFragment.a(this.a).a((VideoInfo)localObject, "0X800B2EA");
          }
          VideoFeedsRecommendFragment.a(this.a).a((VideoInfo)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.RIJObserver
 * JD-Core Version:    0.7.0.1
 */