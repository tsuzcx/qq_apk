package com.tencent.mobileqq.nearby.profilecard.moment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentsAdapter$1
  implements View.OnClickListener
{
  CommentsAdapter$1(CommentsAdapter paramCommentsAdapter, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    if (CommentsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter) != null) {
      CommentsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentCommentsAdapter).a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.CommentsAdapter.1
 * JD-Core Version:    0.7.0.1
 */