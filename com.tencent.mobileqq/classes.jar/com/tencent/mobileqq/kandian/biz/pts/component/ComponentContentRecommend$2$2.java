package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ComponentContentRecommend$2$2
  implements View.OnClickListener
{
  ComponentContentRecommend$2$2(ComponentContentRecommend.2 param2, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommend$2.a;
    RecommendFollowInfo localRecommendFollowInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
    paramView.a(localRecommendFollowInfo, localRecommendFollowInfo.isFollowed ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.2.2
 * JD-Core Version:    0.7.0.1
 */