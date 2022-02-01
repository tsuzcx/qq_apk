package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoPlayerPagerAdapter$1
  implements View.OnClickListener
{
  VideoPlayerPagerAdapter$1(VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, IShortVideoCommentsView paramIShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewIShortVideoCommentsView.showComment();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */