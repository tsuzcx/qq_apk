package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentHeaderPolymeric$4$1
  implements Runnable
{
  ComponentHeaderPolymeric$4$1(ComponentHeaderPolymeric.4 param4, int paramInt) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().h((int)this.b.a.mPolymericInfo.m, this.a - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.4.1
 * JD-Core Version:    0.7.0.1
 */