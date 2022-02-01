package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentHeaderTopicRecommend$5
  implements Ox978RespCallBack
{
  ComponentHeaderTopicRecommend$5(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 1)) {
      ReadInJoyLogicEngine.a().a((int)ComponentHeaderTopicRecommend.a(this.a).businessId, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.5
 * JD-Core Version:    0.7.0.1
 */