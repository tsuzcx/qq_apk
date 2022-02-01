package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ComponentContentRecommend$6
  implements Runnable
{
  ComponentContentRecommend$6(ComponentContentRecommend paramComponentContentRecommend, RecommendFollowInfo paramRecommendFollowInfo) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.6
 * JD-Core Version:    0.7.0.1
 */