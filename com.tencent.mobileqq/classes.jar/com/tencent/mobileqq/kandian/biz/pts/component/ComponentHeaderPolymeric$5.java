package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentHeaderPolymeric$5
  implements Runnable
{
  ComponentHeaderPolymeric$5(ComponentHeaderPolymeric paramComponentHeaderPolymeric, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().c(this.a.mPolymericInfo.f, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.5
 * JD-Core Version:    0.7.0.1
 */