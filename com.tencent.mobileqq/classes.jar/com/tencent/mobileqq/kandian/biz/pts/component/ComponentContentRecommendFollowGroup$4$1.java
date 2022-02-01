package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ComponentContentRecommendFollowGroup$4$1
  implements Runnable
{
  ComponentContentRecommendFollowGroup$4$1(ComponentContentRecommendFollowGroup.4 param4, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("ComponentContentRecommendFollowGroup", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$4.a).mRecommendFollowInfos.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((Iterator)localObject).next();
      if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$4.a.b(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup$4.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.4.1
 * JD-Core Version:    0.7.0.1
 */