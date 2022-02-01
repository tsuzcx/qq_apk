package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ComponentContentRecommendFollowList$ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RecommendFollowInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private ComponentContentRecommendFollowList$ViewHolder(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368067: 
    case 2131369090: 
    case 2131371884: 
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo);
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo, this.jdField_a_of_type_Int);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList;
    RecommendFollowInfo localRecommendFollowInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
    paramView.a(localRecommendFollowInfo, localRecommendFollowInfo.isFollowed ^ true);
    ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.ViewHolder
 * JD-Core Version:    0.7.0.1
 */