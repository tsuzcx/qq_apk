package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

class ReadInJoyTabAdapter$1
  implements View.OnClickListener
{
  ReadInJoyTabAdapter$1(ReadInJoyTabAdapter paramReadInJoyTabAdapter, TabChannelCoverInfo paramTabChannelCoverInfo1, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo2, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo);
    if (ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter) != null) {
      ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter).a(this.jdField_a_of_type_Int);
    }
    paramView = this.b;
    int j = ChannelCoverView.b;
    int i;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    ChannelCoverView.a("0X8009496", paramView, j, i, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */