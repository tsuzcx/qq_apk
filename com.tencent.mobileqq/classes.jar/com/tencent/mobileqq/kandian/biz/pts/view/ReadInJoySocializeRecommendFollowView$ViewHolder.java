package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySocializeRecommendFollowView$ViewHolder
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RecommendFollowInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private ReadInJoySocializeRecommendFollowView$ViewHolder(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368067: 
    case 2131369090: 
    case 2131371884: 
      ReadInJoySocializeRecommendFollowView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo);
      paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo.uin);
      localStringBuilder.append("");
      paramView.publicAccountReportClickEvent(null, (String)localObject, "0X8009849", "0X8009849", 0, 0, "1", localStringBuilder.toString(), "", "", false);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
    paramView.a((RecommendFollowInfo)localObject, ((RecommendFollowInfo)localObject).isFollowed ^ true);
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo.uin);
    localStringBuilder.append("");
    paramView.publicAccountReportClickEvent(null, (String)localObject, "0X800984A", "0X800984A", 0, 0, "1", localStringBuilder.toString(), "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */