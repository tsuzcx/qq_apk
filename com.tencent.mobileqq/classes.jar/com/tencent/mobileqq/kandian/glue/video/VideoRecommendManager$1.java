package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class VideoRecommendManager$1
  implements Runnable
{
  VideoRecommendManager$1(VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    VideoRecommendManager.a(this.this$0, ReadInJoyHelper.t((AppRuntime)localObject));
    VideoRecommendManager.b(this.this$0, ReadInJoyHelper.u((AppRuntime)localObject));
    VideoRecommendManager.a(this.this$0, ReadInJoyHelper.a((AppRuntime)localObject));
    VideoRecommendManager.c(this.this$0, ReadInJoyHelper.v((AppRuntime)localObject));
    if ((VideoRecommendManager.a(this.this$0) < 0.0F) || (VideoRecommendManager.a(this.this$0) > 1.0D)) {
      VideoRecommendManager.a(this.this$0, 0.8F);
    }
    if (VideoRecommendManager.a(this.this$0) < 1000) {
      VideoRecommendManager.b(this.this$0, 40000);
    }
    if (VideoRecommendManager.b(this.this$0) == 1) {
      VideoRecommendManager.a(this.this$0, true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init() 开关配置，mIsOpened = ");
      ((StringBuilder)localObject).append(VideoRecommendManager.a(this.this$0));
      ((StringBuilder)localObject).append(", mStrategyID = ");
      ((StringBuilder)localObject).append(VideoRecommendManager.b(this.this$0));
      ((StringBuilder)localObject).append(", mStrategyDurationLimit = ");
      ((StringBuilder)localObject).append(VideoRecommendManager.a(this.this$0));
      ((StringBuilder)localObject).append(", mStrategyDurationPercent = ");
      ((StringBuilder)localObject).append(VideoRecommendManager.a(this.this$0));
      ((StringBuilder)localObject).append(", mOperator = ");
      ((StringBuilder)localObject).append(VideoRecommendManager.c(this.this$0));
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */