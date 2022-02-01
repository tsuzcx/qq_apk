package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyVideoSubChannelActivity$7
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyVideoSubChannelActivity$7(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyVideoSubChannelActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, false);
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyVideoSubChannelActivity).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.7
 * JD-Core Version:    0.7.0.1
 */