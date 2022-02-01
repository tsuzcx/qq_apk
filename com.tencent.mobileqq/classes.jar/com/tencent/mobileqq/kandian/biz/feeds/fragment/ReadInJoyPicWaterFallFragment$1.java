package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;

class ReadInJoyPicWaterFallFragment$1
  extends ReadInjoyXRecyclerView
{
  ReadInJoyPicWaterFallFragment$1(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView.setData(this.a.b(), this.a.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.1
 * JD-Core Version:    0.7.0.1
 */