package com.tencent.mobileqq.nearby.now;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryPlayController$2$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a();
    this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.2.2
 * JD-Core Version:    0.7.0.1
 */