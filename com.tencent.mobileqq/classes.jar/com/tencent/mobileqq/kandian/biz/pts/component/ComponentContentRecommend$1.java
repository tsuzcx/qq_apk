package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentContentRecommend$1
  implements View.OnClickListener
{
  ComponentContentRecommend$1(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    paramView.a(ComponentContentRecommend.a(paramView));
    ReadInJoyLogicEngine.a().a(ComponentContentRecommend.a(this.a).mArticleID, ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a);
    ComponentContentRecommend.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.1
 * JD-Core Version:    0.7.0.1
 */