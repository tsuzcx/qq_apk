package com.tencent.mobileqq.nearby.now.view.logic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoInfoListenerImpl$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a(false);
    VideoInfoListenerImpl.a(this.a).a(VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int);
    if (VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */