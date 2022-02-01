package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ComponentContentRecommendFollowList$6$1
  implements Runnable
{
  ComponentContentRecommendFollowList$6$1(ComponentContentRecommendFollowList.6 param6, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ComponentContentRecommendFollowList", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ComponentContentRecommendFollowList.b(this.c.a).mRecommendFollowInfos.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((Iterator)localObject).next();
      if (this.a == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.b;
        this.c.a.a(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowList.a(this.c.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.6.1
 * JD-Core Version:    0.7.0.1
 */