package com.tencent.mobileqq.nearby.now;

import android.view.View;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StoryViewRelayoutListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

class StoryPlayController$6
  implements StoryViewRelayoutListener
{
  StoryPlayController$6(StoryPlayController paramStoryPlayController, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().a.findViewById(2131370357).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.c();
  }
  
  public void a(String paramString, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().a.findViewById(2131370357).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new StoryPlayController.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.6
 * JD-Core Version:    0.7.0.1
 */