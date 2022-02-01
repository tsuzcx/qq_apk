package com.tencent.mobileqq.kandian.glue.video;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class VideoFullPlayController$VideoRecommendObserver
  extends VideoPlayRecommendObserver
{
  private VideoFullPlayController$VideoRecommendObserver(VideoFullPlayController paramVideoFullPlayController) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecommend:");
      localStringBuilder.append(paramBoolean);
      QLog.i("VideoFullPlayController", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      VideoFullPlayController.b(this.a).addAll(VideoFullPlayController.a(this.a).a(paramBundle));
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.VideoRecommendObserver
 * JD-Core Version:    0.7.0.1
 */