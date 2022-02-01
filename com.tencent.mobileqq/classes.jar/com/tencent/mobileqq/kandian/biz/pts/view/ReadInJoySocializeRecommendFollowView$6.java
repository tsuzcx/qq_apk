package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ReadInJoySocializeRecommendFollowView$6
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$6(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void run()
  {
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    long l = this.a.uin;
    int i;
    if (this.a.isFollowed) {
      i = 2;
    } else {
      i = 1;
    }
    localReadInJoyLogicEngine.c(l, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.6
 * JD-Core Version:    0.7.0.1
 */