package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.GroupRecommendAccount;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import java.util.List;

class ComponentContentRecommendFollowGroup$ViewHolder
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GroupRecommendAccount jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView;
  ImageView[] c;
  
  private ComponentContentRecommendFollowGroup$ViewHolder(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131367072)
    {
      if ((i != 2131368067) && (i != 2131371884)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup.a((RecommendFollowInfo)paramView.getTag());
      return;
    }
    int j = 0;
    i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.a.size())
    {
      if (!((RecommendFollowInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.a.get(i)).isFollowed)
      {
        i = j;
        break label95;
      }
      i += 1;
    }
    i = 1;
    label95:
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.a, i ^ 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.ViewHolder
 * JD-Core Version:    0.7.0.1
 */